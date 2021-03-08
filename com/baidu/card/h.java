package com.baidu.card;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class h extends a<com.baidu.tbadk.core.data.a> {
    private int bottomMargin;
    private int topMargin;

    public h(Context context) {
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

    public int sV() {
        return this.bottomMargin;
    }

    public void bu(int i) {
        this.bottomMargin = i;
    }
}
