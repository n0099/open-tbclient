package com.baidu.ar.arplay.core.filter;
/* loaded from: classes12.dex */
public enum OutputFillMode {
    StretchToFill(0),
    KeepRatioFill(1),
    KeepRatioCrop(2);
    
    private final int value;

    OutputFillMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
