package com.baidu.ar.arplay.core.renderer;
/* loaded from: classes.dex */
public enum OutputFillMode {
    StretchToFill(0),
    KeepRatioFill(1),
    KeepRatioCrop(2);
    
    public final int value;

    OutputFillMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
