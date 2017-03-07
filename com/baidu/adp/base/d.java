package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class d<T> extends e<T> {
    protected View nW;

    public d(g<T> gVar, int i) {
        super(gVar);
        this.nW = null;
        this.nW = LayoutInflater.from(gVar.getContext()).inflate(i, (ViewGroup) null);
        this.nW.setTag(this);
    }

    public View cg() {
        return this.nW;
    }

    public View findViewById(int i) {
        return this.nW.findViewById(i);
    }
}
