package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View rV;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.rV = null;
        this.rV = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.rV.setTag(this);
    }

    public View eB() {
        return this.rV;
    }

    public View findViewById(int i) {
        return this.rV.findViewById(i);
    }
}
