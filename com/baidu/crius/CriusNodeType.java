package com.baidu.crius;

import com.baidu.crius.proguard.annotations.DoNotStrip;
@DoNotStrip
/* loaded from: classes11.dex */
public enum CriusNodeType {
    DEFAULT(0),
    TEXT(1);
    
    private int mIntValue;

    CriusNodeType(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static CriusNodeType fromInt(int i) {
        switch (i) {
            case 0:
                return DEFAULT;
            case 1:
                return TEXT;
            default:
                throw new IllegalArgumentException("Unknown enum value: " + i);
        }
    }
}
