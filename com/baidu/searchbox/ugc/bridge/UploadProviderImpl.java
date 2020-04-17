package com.baidu.searchbox.ugc.bridge;

import android.widget.Toast;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.publisher.controller.listener.PublishRequestListener;
import com.baidu.searchbox.publisher.video.interfaces.IPublisherSboxVideoInterface;
import com.baidu.searchbox.ugc.model.HttpRequestPublishModule;
import com.baidu.searchbox.ugc.model.PublishModels;
import com.baidu.searchbox.ugc.upload.HttpRequestTokenModule;
import com.baidu.searchbox.ugc.upload.UploadFileTask;
import com.baidu.searchbox.ugc.upload.UploadImageTask;
import com.baidu.searchbox.ugc.upload.UploadManager;
import com.baidu.searchbox.ugc.upload.UploadVideoTask;
import com.baidu.searchbox.upload.provider.IUploadInterface;
import com.baidu.searchbox.upload.provider.UploadProviderManager;
import com.baidu.searchbox.upload.provider.listener.UploadImageListener;
import com.baidu.searchbox.upload.provider.listener.UploadVideoListener;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class UploadProviderImpl implements IUploadInterface {
    public static String STS_FROM = "ugc";
    private static final String TAG = "UploadProviderImpl";
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
    public void uploadVideo(String str, final UploadVideoListener uploadVideoListener) {
        Runnable uploadVideoTask;
        UploadManager.getInstance().setUploadCallback(new UploadManager.UploadCallback() { // from class: com.baidu.searchbox.ugc.bridge.UploadProviderImpl.2
            @Override // com.baidu.searchbox.ugc.upload.UploadManager.UploadCallback
            public void onError(String str2) {
                if (uploadVideoListener != null) {
                    uploadVideoListener.uploadFail(str2);
                }
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onProgress(UploadFileTask uploadFileTask, long j, long j2) {
                if (uploadVideoListener != null && j2 != 0) {
                    uploadVideoListener.uploadProgress((int) ((((float) j) / ((float) j2)) * 100.0f));
                }
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onStart(UploadFileTask uploadFileTask) {
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onSuccess(UploadFileTask uploadFileTask) {
                if (uploadVideoListener != null) {
                    uploadVideoListener.uploadSuccess(uploadFileTask.getUrl(), uploadFileTask.getBosKey(), uploadFileTask.isJumpCompress() ? uploadFileTask.getFileName() : uploadFileTask.getCompressFileName());
                }
            }

            @Override // com.baidu.searchbox.ugc.upload.UploadFileTask.TaskCallback
            public void onFailed(UploadFileTask uploadFileTask) {
                if (uploadVideoListener != null) {
                    uploadVideoListener.uploadFail(String.valueOf(uploadFileTask.mErrorCode));
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        IPublisherSboxVideoInterface iPublisherSboxVideoInterface = (IPublisherSboxVideoInterface) c.a(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
        if (iPublisherSboxVideoInterface != null && (uploadVideoTask = iPublisherSboxVideoInterface.getUploadVideoTask(str)) != null && (uploadVideoTask instanceof UploadFileTask)) {
            arrayList.add((UploadFileTask) uploadVideoTask);
        }
        UploadVideoTask uploadVideoTask2 = new UploadVideoTask(str);
        if (uploadVideoTask2 != null) {
            arrayList.add(uploadVideoTask2);
        }
        UploadManager.getInstance().startAll(arrayList, 0, "ugc");
    }

    @Override // com.baidu.searchbox.upload.provider.IUploadInterface
    public void stopUpload() {
        UploadManager.getInstance().stopAll();
    }

    @Override // com.baidu.searchbox.upload.provider.IUploadInterface
    public void publish(String str, JSONObject jSONObject, PublishRequestListener publishRequestListener) {
        new HttpRequestPublishModule().requestPublish(str, HttpRequestPublishModule.generateRequestPublishParams(jSONObject), publishRequestListener);
    }

    @Override // com.baidu.searchbox.upload.provider.IUploadInterface
    public void imagesTextPublish(final String str, final JSONObject jSONObject, final List<String> list, final PublishRequestListener publishRequestListener) {
        if (list != null && list.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            UploadProviderManager.getUploadProvider().upLoadImage(list, new UploadImageListener() { // from class: com.baidu.searchbox.ugc.bridge.UploadProviderImpl.3
                @Override // com.baidu.searchbox.upload.provider.listener.UploadImageListener
                public void uploadSuccess(String str2, int i, int i2, long j) {
                    PublishModels.ImageData imageData = new PublishModels.ImageData();
                    imageData.url = str2;
                    imageData.width = i;
                    imageData.height = i2;
                    imageData.size = j;
                    arrayList.add(imageData);
                    if (arrayList.size() == list.size()) {
                        UploadProviderImpl.this.requestPublishTextImages(str, jSONObject, arrayList, publishRequestListener);
                    }
                }

                @Override // com.baidu.searchbox.upload.provider.listener.UploadImageListener
                public void uploadFail() {
                    Toast.makeText(AppRuntime.getAppContext(), "上传失败", 0).show();
                }

                @Override // com.baidu.searchbox.upload.provider.listener.UploadImageListener
                public void uploadProgress(float f) {
                }
            });
            return;
        }
        requestPublishTextImages(str, jSONObject, null, publishRequestListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPublishTextImages(String str, JSONObject jSONObject, List<PublishModels.ImageData> list, PublishRequestListener publishRequestListener) {
        try {
            JSONArray jSONArray = new JSONArray();
            if (list != null && list.size() > 0) {
                for (PublishModels.ImageData imageData : list) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("url", imageData.url);
                    jSONObject2.put("width", imageData.width + "");
                    jSONObject2.put("height", imageData.height + "");
                    jSONObject2.put(TiebaInitialize.LogFields.SIZE, imageData.size + "");
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put(TbConfig.IMAGE_CACHE_DIR_NAME, jSONArray);
            }
            UploadProviderManager.getUploadProvider().publish(str, jSONObject, publishRequestListener);
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
