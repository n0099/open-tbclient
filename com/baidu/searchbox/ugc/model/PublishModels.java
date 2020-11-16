package com.baidu.searchbox.ugc.model;
/* loaded from: classes9.dex */
public class PublishModels {

    /* loaded from: classes9.dex */
    public static class ImageData {
        public int height;
        public long size;
        public String url;
        public int width;
    }

    /* loaded from: classes9.dex */
    public interface PublishCallback {
        void onFailed(String str);

        void onSuccess(PublishResultInfo publishResultInfo);
    }

    /* loaded from: classes9.dex */
    public static class PublishData {
        public String errmsg;
        public PublishSubData subData;
    }

    /* loaded from: classes9.dex */
    public static class PublishResultInfo {
        public PublishData data;
        public String requestId;
    }

    /* loaded from: classes9.dex */
    public static class PublishSubData {
        public String coverImg;
        public String isTransfer;
        public String mediaType;
        public String metaId;
        public String vid;
        public String videoUrl;
    }
}
