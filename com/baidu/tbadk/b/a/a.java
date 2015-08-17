package com.baidu.tbadk.b.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int anC;
    private int anD;
    public int anE;
    private int iconId;
    private Context mContext;

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.anC = i;
        this.iconId = i2;
        this.anE = i3;
        this.anD = i4;
    }

    public int Ag() {
        return this.iconId;
    }

    public int Ah() {
        return this.anC;
    }
}
