package com.baidu.ala.recorder.video;
/* loaded from: classes7.dex */
public enum VideoFormat {
    RGBA(1),
    NV21(2),
    I420(3);
    
    private int value;

    VideoFormat(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
