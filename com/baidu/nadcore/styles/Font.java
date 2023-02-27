package com.baidu.nadcore.styles;
/* loaded from: classes2.dex */
public enum Font {
    F_NORMAL(400),
    F_F_X01(700),
    F_F_X02(700),
    F_F_X03(700);
    
    public int mFontWeight;

    Font(int i) {
        this.mFontWeight = i;
    }

    public int getFontWeight() {
        return this.mFontWeight;
    }
}
