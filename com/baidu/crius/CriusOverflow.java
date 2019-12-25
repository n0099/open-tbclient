package com.baidu.crius;

import com.baidu.crius.proguard.annotations.DoNotStrip;
@DoNotStrip
/* loaded from: classes10.dex */
public enum CriusOverflow {
    HIDDEN(0),
    SCROLL(1);
    
    private int mIntValue;

    CriusOverflow(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static CriusOverflow fromInt(int i) {
        switch (i) {
            case 0:
                return HIDDEN;
            case 1:
                return SCROLL;
            default:
                throw new IllegalArgumentException("Unknown enum value: " + i);
        }
    }
}
