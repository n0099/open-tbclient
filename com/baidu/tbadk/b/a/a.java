package com.baidu.tbadk.b.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int QF;
    private int QG;
    public int QH;
    private int iconId;
    private Context mContext;

    public abstract void onClick();

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.QF = i;
        this.iconId = i2;
        this.QH = i3;
        this.QG = i4;
    }

    public int qY() {
        return this.iconId;
    }

    public int qZ() {
        return this.QF;
    }

    public String getDescription() {
        return this.mContext.getString(this.QH);
    }
}
