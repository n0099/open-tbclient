package com.baidu.tbadk.b.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int QB;
    private int QC;
    public int QD;
    private int iconId;
    private Context mContext;

    public abstract void onClick();

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.QB = i;
        this.iconId = i2;
        this.QD = i3;
        this.QC = i4;
    }

    public int qW() {
        return this.iconId;
    }

    public int qX() {
        return this.QB;
    }

    public String getDescription() {
        return this.mContext.getString(this.QD);
    }
}
