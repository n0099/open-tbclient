package com.baidu.ar.arplay.core.engine.rotate;
/* loaded from: classes3.dex */
public enum Orientation {
    UNKNOWN(-1),
    PORTRAIT(0),
    PORTRAIT_REVERSE(180),
    LANDSCAPE(90),
    LANDSCAPE_REVERSE(-90);
    
    private int mDegree;

    Orientation(int i) {
        this.mDegree = i;
    }

    public static Orientation valueOf(int i) {
        return i == PORTRAIT.getDegree() ? PORTRAIT : i == PORTRAIT_REVERSE.getDegree() ? PORTRAIT_REVERSE : i == LANDSCAPE.getDegree() ? LANDSCAPE : i == LANDSCAPE_REVERSE.getDegree() ? LANDSCAPE_REVERSE : UNKNOWN;
    }

    public int getDegree() {
        return this.mDegree;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.mDegree);
    }
}
