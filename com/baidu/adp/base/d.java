package com.baidu.adp.base;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public class d<T> extends f {
    protected View ay;

    public d(Context context, int i) {
        super(context);
        this.ay = null;
        this.ay = com.baidu.adp.lib.g.b.ek().inflate(context, i, null);
        this.ay.setTag(this);
    }

    public View O() {
        return this.ay;
    }

    public View findViewById(int i) {
        return this.ay.findViewById(i);
    }
}
