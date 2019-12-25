package com.baidu.live.tbadk.widget.largeimage.tools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.pool.BdCache;
import com.baidu.live.adp.lib.pool.BdObjectPool;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.BitmapHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.imagemanager.TbImageMemoryCache;
import com.baidu.live.tbadk.widget.largeimage.atomskeleton.BlockBitmap;
import com.baidu.live.tbadk.widget.largeimage.atomskeleton.Viewpoint;
import com.baidu.live.tbadk.widget.largeimage.logic.ILoadBlockBitmapCallback;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class LoadBlockBitmapTaskManager {
    private static final String TAG = LoadBlockBitmapTaskManager.class.getSimpleName();
    private BdCache<BlockBitmap.Position, BlockBitmap> mBlockBitmapLruCache;
    private BdObjectPool<BlockBitmap> mBlockBitmapSimplePool;
    private final BitmapRegionDecoder mDecoder;
    private final Viewpoint mViewPoint;
    private final List<BdAsyncTask> taskList = new LinkedList();

    public void clearAllTask() {
        for (BdAsyncTask bdAsyncTask : this.taskList) {
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
        this.taskList.clear();
    }

    public void onDestory() {
        clearAllTask();
        if (this.mBlockBitmapLruCache != null) {
            this.mBlockBitmapLruCache.setMaxSize(0);
            this.mBlockBitmapLruCache.clear();
            this.mBlockBitmapLruCache = null;
        }
        this.mBlockBitmapSimplePool = null;
    }

    public LoadBlockBitmapTaskManager(Viewpoint viewpoint, BitmapRegionDecoder bitmapRegionDecoder) {
        this.mViewPoint = viewpoint;
        this.mDecoder = bitmapRegionDecoder;
        TbImageMemoryCache.getInstance().setPicMaxSize((int) (getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.mBlockBitmapLruCache = new BdCache<BlockBitmap.Position, BlockBitmap>((int) (getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f)) { // from class: com.baidu.live.tbadk.widget.largeimage.tools.LoadBlockBitmapTaskManager.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.pool.BdCache
            public int sizeOf(BlockBitmap.Position position, BlockBitmap blockBitmap) {
                if (blockBitmap == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(blockBitmap.getBitmap());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.pool.BdCache
            public void entryRemoved(boolean z, BlockBitmap.Position position, BlockBitmap blockBitmap, BlockBitmap blockBitmap2) {
                if (z && LoadBlockBitmapTaskManager.this.mBlockBitmapSimplePool != null && blockBitmap != null) {
                    blockBitmap.clearBitmap();
                    LoadBlockBitmapTaskManager.this.mBlockBitmapSimplePool.returnObject(blockBitmap);
                }
            }
        };
        this.mBlockBitmapSimplePool = TbImageMemoryCache.getInstance().initBlockBitmapPool(this.mViewPoint.getBlockSize());
        this.mBlockBitmapSimplePool.setMaxIdle(6);
    }

    public void summitTask(LoadBitmapAsyncTask loadBitmapAsyncTask) {
        if (loadBitmapAsyncTask == null) {
            return;
        }
        loadBitmapAsyncTask.initData(this, this.mViewPoint, this.mDecoder, getBlockBitmapLruCache());
        loadBitmapAsyncTask.execute(new Object[0]);
        this.taskList.add(loadBitmapAsyncTask);
    }

    public BdCache<BlockBitmap.Position, BlockBitmap> getBlockBitmapLruCache() {
        return this.mBlockBitmapLruCache;
    }

    public BdObjectPool<BlockBitmap> getBlockBitmapSimplePool() {
        return this.mBlockBitmapSimplePool;
    }

    /* loaded from: classes2.dex */
    public static class LoadBitmapAsyncTask extends BdAsyncTask {
        private int column;
        private BdCache<BlockBitmap.Position, BlockBitmap> mBlockBitmapLruCache;
        private BitmapRegionDecoder mDecoder;
        private ILoadBlockBitmapCallback mLoadBlockBitmapCallback;
        private LoadBlockBitmapTaskManager mTaskManager;
        private Viewpoint mViewpoint;
        private int row;
        private int sampleScale;

        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        protected Object doInBackground(Object[] objArr) {
            BlockBitmap createBlockBitmap;
            if (this.mBlockBitmapLruCache != null && this.mViewpoint.checkIsVisiable(this.row, this.column, this.sampleScale)) {
                Rect rect = this.mViewpoint.getRect(this.row, this.column, this.sampleScale);
                this.mViewpoint.checkAndResizeBitmapRegion(rect);
                if (!isRectRegionIllegal(rect)) {
                    try {
                        createBlockBitmap = this.mTaskManager.getBlockBitmapSimplePool().borrowObject();
                        if (createBlockBitmap != null) {
                            if (!createBlockBitmap.isSizeEqual(rect)) {
                                System.currentTimeMillis();
                                createBlockBitmap.clearBitmap();
                            }
                        } else {
                            createBlockBitmap = this.mViewpoint.createBlockBitmap();
                        }
                    } catch (Throwable th) {
                        TbadkCoreApplication.getInst().onAppMemoryLow();
                        this.mBlockBitmapLruCache.setMaxSize((int) (this.mBlockBitmapLruCache.getMaxSize() * 0.8d));
                        System.gc();
                        try {
                            createBlockBitmap = this.mViewpoint.createBlockBitmap();
                        } catch (Throwable th2) {
                        }
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleScale;
                    options.inBitmap = createBlockBitmap.getBitmap();
                    options.inMutable = true;
                    System.currentTimeMillis();
                    Bitmap decodeRegion = this.mDecoder.decodeRegion(rect, options);
                    decodeRegion.prepareToDraw();
                    createBlockBitmap.setBitmap(decodeRegion);
                    createBlockBitmap.setPosition(this.row, this.column, this.sampleScale);
                    this.mBlockBitmapLruCache.put(createBlockBitmap.getPosition(), createBlockBitmap);
                    if (this.mLoadBlockBitmapCallback != null) {
                        this.mLoadBlockBitmapCallback.onLoadFinished();
                    }
                }
            }
            return null;
        }

        public LoadBitmapAsyncTask(int i, int i2, int i3) {
            this.row = i;
            this.column = i2;
            this.sampleScale = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void initData(LoadBlockBitmapTaskManager loadBlockBitmapTaskManager, Viewpoint viewpoint, BitmapRegionDecoder bitmapRegionDecoder, BdCache<BlockBitmap.Position, BlockBitmap> bdCache) {
            this.mViewpoint = viewpoint;
            this.mDecoder = bitmapRegionDecoder;
            this.mBlockBitmapLruCache = bdCache;
            this.mTaskManager = loadBlockBitmapTaskManager;
        }

        public void setLoadFinshedListener(ILoadBlockBitmapCallback iLoadBlockBitmapCallback) {
            this.mLoadBlockBitmapCallback = iLoadBlockBitmapCallback;
        }

        private boolean isRectRegionIllegal(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }
    }

    public static int getBigImageMaxUsedMemoryForRemoteProcess() {
        return (int) (UtilHelper.getBitmapMaxMemory(TbadkCoreApplication.getInst().getContext()) * 0.28d);
    }
}
