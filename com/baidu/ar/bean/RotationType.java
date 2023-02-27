package com.baidu.ar.bean;
/* loaded from: classes.dex */
public enum RotationType {
    ROTATE_0(0),
    ROTATE_90(90),
    ROTATE_180(180),
    ROTATE_270(270);
    
    public final int mDegree;

    RotationType(int i) {
        this.mDegree = i;
    }

    public int getDegree() {
        return this.mDegree;
    }
}
