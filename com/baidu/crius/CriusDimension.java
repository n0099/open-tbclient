package com.baidu.crius;

import com.baidu.crius.proguard.annotations.DoNotStrip;
@DoNotStrip
/* loaded from: classes10.dex */
public enum CriusDimension {
    WIDTH(0),
    HEIGHT(1);
    
    private int mIntValue;

    CriusDimension(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static CriusDimension fromInt(int i) {
        switch (i) {
            case 0:
                return WIDTH;
            case 1:
                return HEIGHT;
            default:
                throw new IllegalArgumentException("Unknown enum value: " + i);
        }
    }
}
