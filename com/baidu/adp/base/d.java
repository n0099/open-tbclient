package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class d<T> extends f<T> {
    protected View gg;

    public d(h<T> hVar, int i) {
        super(hVar);
        this.gg = null;
        this.gg = LayoutInflater.from(hVar.getContext()).inflate(i, (ViewGroup) null);
        this.gg.setTag(this);
    }

    public View aX() {
        return this.gg;
    }

    public View findViewById(int i) {
        return this.gg.findViewById(i);
    }
}
