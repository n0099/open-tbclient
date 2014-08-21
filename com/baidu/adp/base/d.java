package com.baidu.adp.base;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public class d<T> extends f {
    protected View a;

    public d(Context context, int i) {
        super(context);
        this.a = null;
        this.a = com.baidu.adp.lib.e.b.a().a(context, i, null);
        this.a.setTag(this);
    }

    public View a() {
        return this.a;
    }

    public View a(int i) {
        return this.a.findViewById(i);
    }
}
