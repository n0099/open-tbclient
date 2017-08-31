package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View mN;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.mN = null;
        this.mN = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.mN.setTag(this);
    }

    public View cf() {
        return this.mN;
    }

    public View findViewById(int i) {
        return this.mN.findViewById(i);
    }
}
