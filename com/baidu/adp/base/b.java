package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View sM;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.sM = null;
        this.sM = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.sM.setTag(this);
    }

    public View eR() {
        return this.sM;
    }

    public View findViewById(int i) {
        return this.sM.findViewById(i);
    }
}
