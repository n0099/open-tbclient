package com.baidu.minivideo.plugin.capture.bean;
/* loaded from: classes5.dex */
public enum MusicStyle {
    MENU(0),
    COMMON(1),
    MORE(2),
    END(3),
    PACK(4),
    LINE(5),
    DESCRIBE(6);
    
    int value;

    MusicStyle(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }
}
