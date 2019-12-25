package com.baidu.card;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class h extends b<com.baidu.tbadk.core.data.a> {
    private int JM;

    public h(Context context) {
        super(context);
        this.JM = 0;
    }

    public int getTopMargin() {
        return this.JM;
    }

    public void setTopMargin(int i) {
        this.JM = i;
    }
}
