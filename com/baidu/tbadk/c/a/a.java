package com.baidu.tbadk.c.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int apn;
    private int apo;
    public int apq;
    private int iconId;
    private Context mContext;

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.apn = i;
        this.iconId = i2;
        this.apq = i3;
        this.apo = i4;
    }

    public int At() {
        return this.iconId;
    }

    public int Au() {
        return this.apn;
    }
}
