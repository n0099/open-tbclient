package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View abC;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.abC = null;
        this.abC = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.abC.setTag(this);
    }

    public View jK() {
        return this.abC;
    }

    public View findViewById(int i) {
        return this.abC.findViewById(i);
    }
}
