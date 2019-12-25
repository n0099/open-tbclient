package com.baidu.ala.recorder.video;
/* loaded from: classes2.dex */
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
