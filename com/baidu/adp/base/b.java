package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View lJ;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.lJ = null;
        this.lJ = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.lJ.setTag(this);
    }

    public View bO() {
        return this.lJ;
    }

    public View findViewById(int i) {
        return this.lJ.findViewById(i);
    }
}
