package com.baidu.tbadk.c.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int anT;
    private int anU;
    public int anV;
    private int iconId;
    private Context mContext;

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.anT = i;
        this.iconId = i2;
        this.anV = i3;
        this.anU = i4;
    }

    public int Ag() {
        return this.iconId;
    }

    public int Ah() {
        return this.anT;
    }
}
