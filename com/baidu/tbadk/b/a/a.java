package com.baidu.tbadk.b.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int ahm;
    private int ahn;
    public int aho;
    private int iconId;
    private Context mContext;

    public abstract void onClick();

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.ahm = i;
        this.iconId = i2;
        this.aho = i3;
        this.ahn = i4;
    }

    public int yc() {
        return this.iconId;
    }

    public int yd() {
        return this.ahm;
    }
}
