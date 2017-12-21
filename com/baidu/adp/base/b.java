package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View mP;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.mP = null;
        this.mP = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.mP.setTag(this);
    }

    public View cf() {
        return this.mP;
    }

    public View findViewById(int i) {
        return this.mP.findViewById(i);
    }
}
