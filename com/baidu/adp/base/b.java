package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View rW;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.rW = null;
        this.rW = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.rW.setTag(this);
    }

    public View eB() {
        return this.rW;
    }

    public View findViewById(int i) {
        return this.rW.findViewById(i);
    }
}
