package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View pf;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.pf = null;
        this.pf = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.pf.setTag(this);
    }

    public View cq() {
        return this.pf;
    }

    public View findViewById(int i) {
        return this.pf.findViewById(i);
    }
}
