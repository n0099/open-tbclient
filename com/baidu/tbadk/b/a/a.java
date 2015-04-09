package com.baidu.tbadk.b.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int ahu;
    private int ahv;
    public int ahw;
    private int iconId;
    private Context mContext;

    public abstract void onClick();

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.ahu = i;
        this.iconId = i2;
        this.ahw = i3;
        this.ahv = i4;
    }

    public int yi() {
        return this.iconId;
    }

    public int yj() {
        return this.ahu;
    }
}
