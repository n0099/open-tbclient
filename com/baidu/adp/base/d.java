package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class d<T> extends f<T> {
    protected View dT;

    public d(h<T> hVar, int i) {
        super(hVar);
        this.dT = null;
        this.dT = LayoutInflater.from(hVar.getContext()).inflate(i, (ViewGroup) null);
        this.dT.setTag(this);
    }

    public View ac() {
        return this.dT;
    }

    public View findViewById(int i) {
        return this.dT.findViewById(i);
    }
}
