package com.baidu.spswitch.emotion.resource;
/* loaded from: classes2.dex */
public interface IEmotionDownload {
    public static final IEmotionDownload EMPTY = new IEmotionDownload() { // from class: com.baidu.spswitch.emotion.resource.IEmotionDownload.1
        @Override // com.baidu.spswitch.emotion.resource.IEmotionDownload
        public void downloadRetryIfNeeded(String str) {
        }

        @Override // com.baidu.spswitch.emotion.resource.IEmotionDownload
        public void downloadRetryImmediately() {
        }
    };

    void downloadRetryIfNeeded(String str);

    void downloadRetryImmediately();
}
