package com.baidu.card;

import android.content.Context;
/* loaded from: classes21.dex */
public abstract class i extends b<com.baidu.tbadk.core.data.a> {
    private int agU;
    private int agW;

    public i(Context context) {
        super(context);
        this.agU = 0;
        this.agW = 0;
    }

    public int getTopMargin() {
        return this.agU;
    }

    public void setTopMargin(int i) {
        this.agU = i;
    }

    public int tL() {
        return this.agW;
    }

    public void bv(int i) {
        this.agW = i;
    }
}
