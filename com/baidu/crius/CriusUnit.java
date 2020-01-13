package com.baidu.crius;

import com.baidu.crius.proguard.annotations.DoNotStrip;
@DoNotStrip
/* loaded from: classes11.dex */
public enum CriusUnit {
    UNDEFINED(0),
    POINT(1),
    PERCENT(2),
    AUTO(3);
    
    private int mIntValue;

    CriusUnit(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static CriusUnit fromInt(int i) {
        switch (i) {
            case 0:
                return UNDEFINED;
            case 1:
                return POINT;
            case 2:
                return PERCENT;
            case 3:
                return AUTO;
            default:
                throw new IllegalArgumentException("Unknown enum value: " + i);
        }
    }
}
