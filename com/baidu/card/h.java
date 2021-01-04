package com.baidu.card;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class h extends a<com.baidu.tbadk.core.data.a> {
    private int aht;
    private int ahv;

    public h(Context context) {
        super(context);
        this.aht = 0;
        this.ahv = 0;
    }

    public int getTopMargin() {
        return this.aht;
    }

    public void setTopMargin(int i) {
        this.aht = i;
    }

    public int tj() {
        return this.ahv;
    }

    public void bv(int i) {
        this.ahv = i;
    }
}
