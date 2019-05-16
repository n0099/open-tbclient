package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View sN;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.sN = null;
        this.sN = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.sN.setTag(this);
    }

    public View eR() {
        return this.sN;
    }

    public View findViewById(int i) {
        return this.sN.findViewById(i);
    }
}
