package com.baidu.searchbox.ng.ai.apps.media.chooser.ioc;
/* loaded from: classes2.dex */
public abstract class AiAppsTransCoder {

    /* loaded from: classes2.dex */
    public interface Callback {
        void onCompletion();

        void onError(int i, int i2);
    }

    public void setTranscoderMode(int i) {
    }

    public void setDataSource(String str) {
    }

    public void setOutputFile(String str) {
    }

    public void setOutputMaxEdgeLen(int i) {
    }

    private void setAudioCodec(String str) {
    }

    private void setVideoCodec(String str) {
    }

    public void setVideoSize(int i, int i2) {
    }

    public void setVideoFrameRate(int i) {
    }

    public void setVideoBitRate(int i) {
    }

    public void setAudioBitRate(int i) {
    }

    public void start() {
    }

    public void setCallback(Callback callback) {
    }
}
