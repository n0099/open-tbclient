package com.baidu.ala.liveRecorder.video;
/* loaded from: classes6.dex */
public enum VideoFormat {
    RGBA(1),
    NV21(2);
    
    private int value;

    VideoFormat(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
