package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View sf;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.sf = null;
        this.sf = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.sf.setTag(this);
    }

    public View eC() {
        return this.sf;
    }

    public View findViewById(int i) {
        return this.sf.findViewById(i);
    }
}
