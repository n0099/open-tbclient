package com.baidu.tbadk.b.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int aiv;
    private int aiw;
    public int aix;
    private int iconId;
    private Context mContext;

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.aiv = i;
        this.iconId = i2;
        this.aix = i3;
        this.aiw = i4;
    }

    public int yV() {
        return this.iconId;
    }

    public int yW() {
        return this.aiv;
    }
}
