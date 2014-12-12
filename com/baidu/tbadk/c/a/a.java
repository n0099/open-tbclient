package com.baidu.tbadk.c.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int WE;
    private int WF;
    public int WG;
    private int iconId;
    private Context mContext;

    public abstract void onClick();

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.WE = i;
        this.iconId = i2;
        this.WG = i3;
        this.WF = i4;
    }

    public int uB() {
        return this.iconId;
    }

    public int uC() {
        return this.WE;
    }
}
