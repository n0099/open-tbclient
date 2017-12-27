package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View abE;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.abE = null;
        this.abE = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.abE.setTag(this);
    }

    public View jK() {
        return this.abE;
    }

    public View findViewById(int i) {
        return this.abE.findViewById(i);
    }
}
