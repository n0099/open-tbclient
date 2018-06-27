package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View sd;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.sd = null;
        this.sd = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.sd.setTag(this);
    }

    public View eC() {
        return this.sd;
    }

    public View findViewById(int i) {
        return this.sd.findViewById(i);
    }
}
