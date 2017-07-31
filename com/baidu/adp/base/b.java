package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View pd;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.pd = null;
        this.pd = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.pd.setTag(this);
    }

    public View cq() {
        return this.pd;
    }

    public View findViewById(int i) {
        return this.pd.findViewById(i);
    }
}
