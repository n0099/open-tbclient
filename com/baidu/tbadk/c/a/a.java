package com.baidu.tbadk.c.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int Xg;
    private int Xh;
    public int Xi;
    private int iconId;
    private Context mContext;

    public abstract void onClick();

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.Xg = i;
        this.iconId = i2;
        this.Xi = i3;
        this.Xh = i4;
    }

    public int uM() {
        return this.iconId;
    }

    public int uN() {
        return this.Xg;
    }
}
