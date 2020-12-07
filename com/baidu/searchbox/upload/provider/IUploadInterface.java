package com.baidu.searchbox.upload.provider;

import android.support.annotation.NonNull;
import com.baidu.searchbox.publisher.controller.listener.PublishRequestListener;
import com.baidu.searchbox.ugc.upload.HttpRequestTokenModule;
import com.baidu.searchbox.upload.provider.listener.UploadImageListener;
import com.baidu.searchbox.upload.provider.listener.UploadVideoListener;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public interface IUploadInterface {
    public static final IUploadInterface EMPTY = new IUploadInterface() { // from class: com.baidu.searchbox.upload.provider.IUploadInterface.1
        @Override // com.baidu.searchbox.upload.provider.IUploadInterface
        public void upLoadImage(String str, UploadImageListener uploadImageListener) {
        }

        @Override // com.baidu.searchbox.upload.provider.IUploadInterface
        public void upLoadImage(List<String> list, UploadImageListener uploadImageListener) {
        }

        @Override // com.baidu.searchbox.upload.provider.IUploadInterface
        public void uploadVideo(String str, UploadVideoListener uploadVideoListener) {
        }

        @Override // com.baidu.searchbox.upload.provider.IUploadInterface
        public void stopUpload() {
        }

        @Override // com.baidu.searchbox.upload.provider.IUploadInterface
        public void publish(String str, JSONObject jSONObject, PublishRequestListener publishRequestListener) {
        }

        @Override // com.baidu.searchbox.upload.provider.IUploadInterface
        public void imagesTextPublish(String str, JSONObject jSONObject, List<String> list, PublishRequestListener publishRequestListener) {
        }

        @Override // com.baidu.searchbox.upload.provider.IUploadInterface
        public void releaseUploadManager() {
        }

        @Override // com.baidu.searchbox.upload.provider.IUploadInterface
        public HttpRequestTokenModule.STSInfo requestPublisherToken(List<String> list, boolean z, int i, String str) {
            return null;
        }

        @Override // com.baidu.searchbox.upload.provider.IUploadInterface
        public void setSTSFrom(String str) {
        }
    };
    public static final String FROM_COMMENT = "comment";
    public static final String FROM_UGC = "ugc";

    void imagesTextPublish(String str, JSONObject jSONObject, List<String> list, PublishRequestListener publishRequestListener);

    void publish(String str, JSONObject jSONObject, PublishRequestListener publishRequestListener);

    void releaseUploadManager();

    HttpRequestTokenModule.STSInfo requestPublisherToken(List<String> list, boolean z, int i, String str);

    void setSTSFrom(String str);

    void stopUpload();

    void upLoadImage(String str, UploadImageListener uploadImageListener);

    void upLoadImage(List<String> list, UploadImageListener uploadImageListener);

    void uploadVideo(String str, UploadVideoListener uploadVideoListener);

    /* loaded from: classes20.dex */
    public static final class Impl {
        private static IUploadInterface sUgcProvider = UploadProviderManager.getUploadProvider();

        private Impl() {
        }

        @NonNull
        public static IUploadInterface get() {
            if (sUgcProvider == null) {
                sUgcProvider = IUploadInterface.EMPTY;
            }
            return sUgcProvider;
        }
    }
}
