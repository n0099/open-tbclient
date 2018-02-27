package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View abw;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.abw = null;
        this.abw = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.abw.setTag(this);
    }

    public View jK() {
        return this.abw;
    }

    public View findViewById(int i) {
        return this.abw.findViewById(i);
    }
}
