package com.baidu.card;

import android.content.Context;
/* loaded from: classes3.dex */
public abstract class f extends b<com.baidu.tbadk.core.data.a> {
    private int VM;

    public f(Context context) {
        super(context);
        this.VM = 0;
    }

    public int getTopMargin() {
        return this.VM;
    }

    public void setTopMargin(int i) {
        this.VM = i;
    }
}
