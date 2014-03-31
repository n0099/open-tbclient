package com.baidu.adp.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class d<T> extends f {
    protected View a;

    public d(Context context, int i) {
        super(context);
        this.a = null;
        this.a = LayoutInflater.from(context).inflate(i, (ViewGroup) null);
        this.a.setTag(this);
    }

    public final View a() {
        return this.a;
    }

    public final View a(int i) {
        return this.a.findViewById(i);
    }
}
