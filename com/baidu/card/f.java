package com.baidu.card;

import android.content.Context;
/* loaded from: classes3.dex */
public abstract class f extends b<com.baidu.tbadk.core.data.a> {
    private int Fb;

    public f(Context context) {
        super(context);
        this.Fb = 0;
    }

    public int getTopMargin() {
        return this.Fb;
    }

    public void setTopMargin(int i) {
        this.Fb = i;
    }
}
