package com.baidu.card;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class h extends a<com.baidu.tbadk.core.data.a> {
    private int agC;
    private int agE;

    public h(Context context) {
        super(context);
        this.agC = 0;
        this.agE = 0;
    }

    public int getTopMargin() {
        return this.agC;
    }

    public void setTopMargin(int i) {
        this.agC = i;
    }

    public int sY() {
        return this.agE;
    }

    public void bt(int i) {
        this.agE = i;
    }
}
