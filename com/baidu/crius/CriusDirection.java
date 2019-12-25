package com.baidu.crius;

import com.baidu.crius.proguard.annotations.DoNotStrip;
@DoNotStrip
/* loaded from: classes10.dex */
public enum CriusDirection {
    INHERIT(0),
    LTR(1),
    RTL(2);
    
    private int mIntValue;

    CriusDirection(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static CriusDirection fromInt(int i) {
        switch (i) {
            case 0:
                return INHERIT;
            case 1:
                return LTR;
            case 2:
                return RTL;
            default:
                throw new IllegalArgumentException("Unknown enum value: " + i);
        }
    }
}
