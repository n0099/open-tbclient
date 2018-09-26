package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View uz;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.uz = null;
        this.uz = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.uz.setTag(this);
    }

    public View fJ() {
        return this.uz;
    }

    public View findViewById(int i) {
        return this.uz.findViewById(i);
    }
}
