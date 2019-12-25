package com.baidu.searchbox.ugc.bridge;

import com.baidu.searchbox.ugc.upload.HttpRequestTokenModule;
import com.baidu.searchbox.ugc.upload.UploadFileTask;
import com.baidu.searchbox.ugc.upload.UploadImageTask;
import com.baidu.searchbox.ugc.upload.UploadManager;
import com.baidu.searchbox.upload.provider.IUploadInterface;
import com.baidu.searchbox.upload.provider.listener.UploadImageListener;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class UploadProviderImpl implements IUploadInterface {
    public static String STS_FROM = "ugc";
    private int mFinishedTask = 0;
    private int mTaskCount = 0;

    @Override // com.baidu.searchbox.upload.provider.IUploadInterface
    public void setSTSFrom(String str) {
        STS_FROM = str;
    }

    @Override // com.baidu.searchbox.upload.provider.IUploadInterface
    public void upLoadImage(String str, UploadImageListener uploadImageListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        upLoadImage(arrayList, uploadImageListener);
    }

    @Override // com.baidu.searchbox.upload.provider.IUploadInterface
    public void upLoadImage(List<String> list, final UploadImageListener uploadImageListener) {
        if (list != null && !list.isEmpty()) {
            UploadManager.getInstance().setUploadCallback(new UploadManager.UploadCallback() { // from class: com.baidu.searchbox.ugc.bridge.UploadProviderImpl.1
                @Override // com.baidu.searchbox.ugc.upload.UploadManager.UploadCallback
                public void onError(String str) {
                    if (uploadImageListener != null) {
                        uploadImageListener.uploadFail();
                    }
                }

                @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
                public void onProgress(UploadFileTask uploadFileTask, long j, long j2) {
                    if (uploadImageListener != null) {
                        uploadImageListener.uploadProgress((UploadProviderImpl.this.mFinishedTask / UploadProviderImpl.this.mTaskCount) + ((1.0f / UploadProviderImpl.this.mTaskCount) * (((float) j) / ((float) j2))));
                    }
                }

                @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
                public void onStart(UploadFileTask uploadFileTask) {
                }

                @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
                public void onSuccess(UploadFileTask uploadFileTask) {
                    UploadProviderImpl.this.mFinishedTask++;
                    if (uploadImageListener != null) {
                        uploadImageListener.uploadSuccess(uploadFileTask.getUrl(), uploadFileTask.width, uploadFileTask.height, uploadFileTask.size);
                    }
                }

                @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
                public void onFailed(UploadFileTask uploadFileTask) {
                    if (uploadImageListener != null) {
                        uploadImageListener.uploadFail();
                    }
                }
            });
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                arrayList.add(new UploadImageTask(str));
            }
            this.mFinishedTask = 0;
            this.mTaskCount = arrayList.size();
            UploadManager.getInstance().startAll(arrayList, 0, STS_FROM);
        }
    }

    @Override // com.baidu.searchbox.upload.provider.IUploadInterface
    public void stopUpload() {
        UploadManager.getInstance().stopAll();
    }

    @Override // com.baidu.searchbox.upload.provider.IUploadInterface
    public void releaseUploadManager() {
        UploadManager.getInstance().release();
    }

    @Override // com.baidu.searchbox.upload.provider.IUploadInterface
    public HttpRequestTokenModule.STSInfo requestPublisherToken(List<String> list, boolean z, int i, String str) {
        return new HttpRequestTokenModule().requestToken(list, z, i, str);
    }
}
