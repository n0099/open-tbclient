package com.baidu.card;

import android.content.Context;
/* loaded from: classes3.dex */
public abstract class f extends b<com.baidu.tbadk.core.data.a> {
    private int VN;

    public f(Context context) {
        super(context);
        this.VN = 0;
    }

    public int getTopMargin() {
        return this.VN;
    }

    public void setTopMargin(int i) {
        this.VN = i;
    }
}
