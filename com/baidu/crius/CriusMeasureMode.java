package com.baidu.crius;

import com.baidu.crius.proguard.annotations.DoNotStrip;
@DoNotStrip
/* loaded from: classes3.dex */
public enum CriusMeasureMode {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);
    
    private int mIntValue;

    CriusMeasureMode(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static CriusMeasureMode fromInt(int i) {
        switch (i) {
            case 0:
                return UNDEFINED;
            case 1:
                return EXACTLY;
            case 2:
                return AT_MOST;
            default:
                throw new IllegalArgumentException("Unknown enum value: " + i);
        }
    }
}
