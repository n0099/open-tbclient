package com.baidu.live.tbadk.img;

import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.LocalViewSize;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.img.ImageUploader;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class AsyncImageUploadModel<T> {
    private final ImageUploader imageUploader;
    private String mPath;
    public T progessObject;
    private WeakReference<ImageUploadUIProgressCallback<T>> mUploadProgressCallback = null;
    private UploadPicCallback mUploadPicCallback = null;
    private AsyncImageUploadModel<T>.SendPicAyncTask mSendPicAyncTask = null;

    /* loaded from: classes4.dex */
    public interface ImageUploadUIProgressCallback<T> {
        void onImageProgessInUI(int i, T t);
    }

    /* loaded from: classes4.dex */
    public interface UploadPicCallback {
        void callBack(String str, ImageUploadResult imageUploadResult);
    }

    public AsyncImageUploadModel(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.imageUploader = new ImageUploader(str2);
    }

    public void setServersideResize(int i, int i2, int i3, int i4) {
        this.imageUploader.setServersideResize(i, i2, i3, i4);
    }

    public void loadPic(boolean z) {
        if (this.mSendPicAyncTask == null) {
            this.mSendPicAyncTask = new SendPicAyncTask();
            this.mSendPicAyncTask.setIsNeedAddWater(z);
            this.mSendPicAyncTask.execute(new String[0]);
        }
    }

    /* loaded from: classes4.dex */
    private class SendPicAyncTask extends BdAsyncTask<String, Integer, ImageUploadResult> implements ImageUploader.ImageUploadProgressCallback {
        private boolean isNeedAddWater;

        private SendPicAyncTask() {
            this.isNeedAddWater = false;
        }

        protected void setIsNeedAddWater(boolean z) {
            this.isNeedAddWater = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public ImageUploadResult doInBackground(String... strArr) {
            return uploadChunkFile();
        }

        private ImageUploadResult uploadChunkFile() {
            AsyncImageUploadModel.this.imageUploader.setImageUploadProgressCallback(this, null);
            ImageUploadResult uploadInBackground = AsyncImageUploadModel.this.imageUploader.uploadInBackground(AsyncImageUploadModel.this.mPath, this.isNeedAddWater);
            publishProgress(100);
            return uploadInBackground;
        }

        @Override // com.baidu.live.tbadk.img.ImageUploader.ImageUploadProgressCallback
        public void onImageDataSentInBackground(String str, Object obj, long j, long j2) {
            int i;
            if (j2 == 0) {
                i = 0;
            } else {
                i = (int) ((((float) j) * 100.0f) / ((float) j2));
                if (i > 100) {
                    i = 90;
                }
            }
            publishProgress(Integer.valueOf(i));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && AsyncImageUploadModel.this.mUploadProgressCallback != null && AsyncImageUploadModel.this.mUploadProgressCallback.get() != null) {
                ((ImageUploadUIProgressCallback) AsyncImageUploadModel.this.mUploadProgressCallback.get()).onImageProgessInUI(numArr[0].intValue(), AsyncImageUploadModel.this.progessObject);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (AsyncImageUploadModel.this.mUploadPicCallback != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_send_error);
                AsyncImageUploadModel.this.mUploadPicCallback.callBack(AsyncImageUploadModel.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void cancel() {
            super.cancel();
            AsyncImageUploadModel.this.mSendPicAyncTask = null;
            AsyncImageUploadModel.this.imageUploader.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute((SendPicAyncTask) imageUploadResult);
            AsyncImageUploadModel.this.mSendPicAyncTask = null;
            if (AsyncImageUploadModel.this.mUploadPicCallback != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_send_error);
                    TiebaInitialize.imgError(-1002, imageUploadResult.error_msg, "");
                }
                AsyncImageUploadModel.this.mUploadPicCallback.callBack(AsyncImageUploadModel.this.mPath, imageUploadResult);
            }
        }
    }

    public void cancel() {
        if (this.mSendPicAyncTask != null) {
            this.mSendPicAyncTask.cancel();
            this.mSendPicAyncTask = null;
        }
    }

    public void setUploadProgressCallback(ImageUploadUIProgressCallback<T> imageUploadUIProgressCallback) {
        this.mUploadProgressCallback = new WeakReference<>(imageUploadUIProgressCallback);
    }

    public UploadPicCallback getUploadPicCallback() {
        return this.mUploadPicCallback;
    }

    public void setUploadPicCallback(UploadPicCallback uploadPicCallback) {
        this.mUploadPicCallback = uploadPicCallback;
    }

    public void setGroupId(String str) {
        this.imageUploader.setGroupId(str);
    }

    public T getProgessObject() {
        return this.progessObject;
    }

    public void setProgessObject(T t) {
        this.progessObject = t;
    }

    public void setServerResizeForIMImage() {
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.getInstance().getMsgSPicMaxSize();
        LocalViewSize.ImageSize msgBPicMaxSize = LocalViewSize.getInstance().getMsgBPicMaxSize();
        setServersideResize(msgBPicMaxSize.width, msgBPicMaxSize.height, msgSPicMaxSize.width, msgSPicMaxSize.height);
    }
}
