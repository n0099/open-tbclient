package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class d<T> extends f<T> {
    protected View nv;

    public d(h<T> hVar, int i) {
        super(hVar);
        this.nv = null;
        this.nv = LayoutInflater.from(hVar.getContext()).inflate(i, (ViewGroup) null);
        this.nv.setTag(this);
    }

    public View dM() {
        return this.nv;
    }

    public View findViewById(int i) {
        return this.nv.findViewById(i);
    }
}
