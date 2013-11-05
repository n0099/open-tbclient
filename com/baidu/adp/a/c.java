package com.baidu.adp.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class c<T> extends e {

    /* renamed from: a  reason: collision with root package name */
    protected View f399a;

    public c(Context context, int i) {
        super(context);
        this.f399a = null;
        this.f399a = LayoutInflater.from(context).inflate(i, (ViewGroup) null);
        this.f399a.setTag(this);
    }

    public View a() {
        return this.f399a;
    }

    public View a(int i) {
        return this.f399a.findViewById(i);
    }
}
