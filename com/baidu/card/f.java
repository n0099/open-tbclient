package com.baidu.card;

import android.content.Context;
/* loaded from: classes3.dex */
public abstract class f extends b<com.baidu.tbadk.core.data.a> {
    private int FB;

    public f(Context context) {
        super(context);
        this.FB = 0;
    }

    public int getTopMargin() {
        return this.FB;
    }

    public void setTopMargin(int i) {
        this.FB = i;
    }
}
