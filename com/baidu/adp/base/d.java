package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class d<T> extends e<T> {
    protected View nv;

    public d(g<T> gVar, int i) {
        super(gVar);
        this.nv = null;
        this.nv = LayoutInflater.from(gVar.getContext()).inflate(i, (ViewGroup) null);
        this.nv.setTag(this);
    }

    public View cf() {
        return this.nv;
    }

    public View findViewById(int i) {
        return this.nv.findViewById(i);
    }
}
