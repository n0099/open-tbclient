package com.baidu.tbadk.c.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int anN;
    private int anO;
    public int anP;
    private int iconId;
    private Context mContext;

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.anN = i;
        this.iconId = i2;
        this.anP = i3;
        this.anO = i4;
    }

    public int Ae() {
        return this.iconId;
    }

    public int Af() {
        return this.anN;
    }
}
