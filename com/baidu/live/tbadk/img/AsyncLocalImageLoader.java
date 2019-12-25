package com.baidu.live.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.tbadk.core.util.BitmapHelper;
import com.baidu.live.tbadk.imagemanager.TbImageCallback;
import com.baidu.live.tbadk.imagemanager.TbImageMemoryCache;
import com.baidu.live.tbadk.img.effect.ImageActionManager;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes2.dex */
public class AsyncLocalImageLoader {
    private Queue<HoldData> imagesWaitingForLoad = new ConcurrentLinkedQueue();
    private volatile LocalImageLoaderTask runningTask;

    public BdImage getImage(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return TbImageMemoryCache.getInstance().getPic(imageFileInfo.toCachedKey(z));
    }

    public BdImage loadImage(ImageFileInfo imageFileInfo, TbImageCallback tbImageCallback, boolean z, boolean z2) {
        BdImage image = getImage(imageFileInfo, z);
        if (image == null) {
            if (z2) {
                return null;
            }
            HoldData holdData = new HoldData();
            holdData.callback = tbImageCallback;
            holdData.imageInfo = imageFileInfo;
            holdData.includePersistActions = z;
            this.imagesWaitingForLoad.add(holdData);
            notifyNewTaskAdded();
            return null;
        }
        return image;
    }

    public BdImage loadImage(ImageFileInfo imageFileInfo, TbImageCallback tbImageCallback, boolean z) {
        return loadImage(imageFileInfo, tbImageCallback, z, false);
    }

    protected void notifyNewTaskAdded() {
        if (this.runningTask == null && !this.imagesWaitingForLoad.isEmpty()) {
            this.runningTask = new LocalImageLoaderTask(this.imagesWaitingForLoad);
            this.runningTask.execute(new Void[0]);
        }
    }

    public void cancelAllAsyncTask() {
        this.imagesWaitingForLoad = new ConcurrentLinkedQueue();
        if (this.runningTask != null) {
            this.runningTask.cancel(true);
            this.runningTask = null;
        }
    }

    public int getAsyncTaskNum() {
        return this.imagesWaitingForLoad.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class LocalImageLoaderTask extends BdAsyncTask<Void, HoldData, HoldData> {
        final Queue<HoldData> imagesWaitingForLoadRef;

        public LocalImageLoaderTask(Queue<HoldData> queue) {
            this.imagesWaitingForLoadRef = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public HoldData doInBackground(Void... voidArr) {
            Bitmap bitmap;
            int i;
            while (true) {
                HoldData poll = this.imagesWaitingForLoadRef.poll();
                if (poll == null) {
                    break;
                } else if (isCancelled()) {
                    this.imagesWaitingForLoadRef.add(poll);
                    break;
                } else {
                    BdImage pic = TbImageMemoryCache.getInstance().getPic(poll.imageInfo.toCachedKey(poll.includePersistActions));
                    if (pic != null) {
                        poll.loadedImg = pic;
                        poll.isFromCache = true;
                    } else {
                        Bitmap loadImageAndApplyEffects = AsyncLocalImageLoader.this.loadImageAndApplyEffects(poll.imageInfo, poll.includePersistActions);
                        if (loadImageAndApplyEffects != null) {
                            try {
                                i = BitmapHelper.readPictureDegree(poll.imageInfo.getFilePath());
                                if (i != 0) {
                                    try {
                                        bitmap = BitmapHelper.rotateBitmapBydegree(loadImageAndApplyEffects, i);
                                        if (loadImageAndApplyEffects != bitmap) {
                                            try {
                                                loadImageAndApplyEffects.recycle();
                                                loadImageAndApplyEffects = null;
                                            } catch (Exception e) {
                                            }
                                        }
                                    } catch (Exception e2) {
                                        bitmap = null;
                                    }
                                } else {
                                    bitmap = null;
                                }
                            } catch (Exception e3) {
                                bitmap = null;
                                i = 0;
                            }
                            if (i != 0 && bitmap != null) {
                                poll.loadedImg = new BdImage(bitmap, poll.imageInfo.isGif(), poll.imageInfo.getFilePath());
                            } else {
                                poll.loadedImg = new BdImage(loadImageAndApplyEffects, poll.imageInfo.isGif(), poll.imageInfo.getFilePath());
                            }
                        }
                    }
                    publishProgress(poll);
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(HoldData holdData) {
            super.onPostExecute((LocalImageLoaderTask) holdData);
            AsyncLocalImageLoader.this.runningTask = null;
            AsyncLocalImageLoader.this.notifyNewTaskAdded();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onProgressUpdate(HoldData... holdDataArr) {
            if (holdDataArr != null) {
                for (HoldData holdData : holdDataArr) {
                    BdImage bdImage = holdData.loadedImg;
                    if (bdImage != null && !holdData.isFromCache) {
                        TbImageMemoryCache.getInstance().addPic(holdData.imageInfo.toCachedKey(holdData.includePersistActions), bdImage);
                    }
                    if (holdData.callback != null) {
                        holdData.callback.imageLoaded(bdImage, holdData.imageInfo.toCachedKey(holdData.includePersistActions), holdData.isFromCache);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            AsyncLocalImageLoader.this.runningTask = null;
            while (true) {
                HoldData poll = this.imagesWaitingForLoadRef.poll();
                if (poll != null) {
                    if (poll.callback != null) {
                        poll.callback.imageLoaded(null, poll.imageInfo.toCachedKey(poll.includePersistActions), false);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public Bitmap loadImageAndApplyEffects(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        if (z && imageFileInfo.getPersistActionsList() != null) {
            linkedList.addAll(imageFileInfo.getPersistActionsList());
        }
        if (imageFileInfo.getPageActionsList() != null) {
            linkedList.addAll(imageFileInfo.getPageActionsList());
        }
        if (imageFileInfo.getOrginalBitmap() != null) {
            try {
                return ImageActionManager.getInstance().applyImageActions(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return ImageActionManager.getInstance().applyImageActions(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            return BitmapHelper.loadBitmap(imageFileInfo.getFilePath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class HoldData {
        TbImageCallback callback;
        ImageFileInfo imageInfo;
        boolean includePersistActions;
        boolean isFromCache;
        BdImage loadedImg;

        private HoldData() {
        }
    }
}
