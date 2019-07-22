package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View sP;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.sP = null;
        this.sP = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.sP.setTag(this);
    }

    public View eY() {
        return this.sP;
    }

    public View findViewById(int i) {
        return this.sP.findViewById(i);
    }
}
