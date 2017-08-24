package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View pg;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.pg = null;
        this.pg = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.pg.setTag(this);
    }

    public View cq() {
        return this.pg;
    }

    public View findViewById(int i) {
        return this.pg.findViewById(i);
    }
}
