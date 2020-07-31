package com.baidu.crius;

import com.baidu.crius.proguard.annotations.DoNotStrip;
@DoNotStrip
/* loaded from: classes6.dex */
public enum CriusPositionType {
    RELATIVE(0),
    ABSOLUTE(1);
    
    private int mIntValue;

    CriusPositionType(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static CriusPositionType fromInt(int i) {
        switch (i) {
            case 0:
                return RELATIVE;
            case 1:
                return ABSOLUTE;
            default:
                throw new IllegalArgumentException("Unknown enum value: " + i);
        }
    }
}
