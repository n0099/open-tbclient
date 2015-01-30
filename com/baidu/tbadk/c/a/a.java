package com.baidu.tbadk.c.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int Xj;
    private int Xk;
    public int Xl;
    private int iconId;
    private Context mContext;

    public abstract void onClick();

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.Xj = i;
        this.iconId = i2;
        this.Xl = i3;
        this.Xk = i4;
    }

    public int uS() {
        return this.iconId;
    }

    public int uT() {
        return this.Xj;
    }
}
