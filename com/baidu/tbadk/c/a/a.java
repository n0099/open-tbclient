package com.baidu.tbadk.c.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int anO;
    private int anP;
    public int anQ;
    private int iconId;
    private Context mContext;

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.anO = i;
        this.iconId = i2;
        this.anQ = i3;
        this.anP = i4;
    }

    public int Ae() {
        return this.iconId;
    }

    public int Af() {
        return this.anO;
    }
}
