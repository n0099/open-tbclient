package com.baidu.searchbox.upload.provider;

import android.support.annotation.NonNull;
import com.baidu.searchbox.ugc.upload.HttpRequestTokenModule;
import com.baidu.searchbox.upload.provider.listener.UploadImageListener;
import java.util.List;
/* loaded from: classes13.dex */
public interface IUploadInterface {
    public static final IUploadInterface EMPTY = new IUploadInterface() { // from class: com.baidu.searchbox.upload.provider.IUploadInterface.1
        @Override // com.baidu.searchbox.upload.provider.IUploadInterface
        public void upLoadImage(String str, UploadImageListener uploadImageListener) {
        }

        @Override // com.baidu.searchbox.upload.provider.IUploadInterface
        public void upLoadImage(List<String> list, UploadImageListener uploadImageListener) {
        }

        @Override // com.baidu.searchbox.upload.provider.IUploadInterface
        public void stopUpload() {
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

    void releaseUploadManager();

    HttpRequestTokenModule.STSInfo requestPublisherToken(List<String> list, boolean z, int i, String str);

    void setSTSFrom(String str);

    void stopUpload();

    void upLoadImage(String str, UploadImageListener uploadImageListener);

    void upLoadImage(List<String> list, UploadImageListener uploadImageListener);

    /* loaded from: classes13.dex */
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
