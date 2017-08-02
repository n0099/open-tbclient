package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View nv;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.nv = null;
        this.nv = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.nv.setTag(this);
    }

    public View cf() {
        return this.nv;
    }

    public View findViewById(int i) {
        return this.nv.findViewById(i);
    }
}
