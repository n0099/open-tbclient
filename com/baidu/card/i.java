package com.baidu.card;

import android.content.Context;
/* loaded from: classes20.dex */
public abstract class i extends b<com.baidu.tbadk.core.data.a> {
    private int bottomMargin;
    private int topMargin;

    public i(Context context) {
        super(context);
        this.topMargin = 0;
        this.bottomMargin = 0;
    }

    public int getTopMargin() {
        return this.topMargin;
    }

    public void setTopMargin(int i) {
        this.topMargin = i;
    }

    public int tI() {
        return this.bottomMargin;
    }

    public void br(int i) {
        this.bottomMargin = i;
    }
}
