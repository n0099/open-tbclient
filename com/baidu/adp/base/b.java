package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View mO;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.mO = null;
        this.mO = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.mO.setTag(this);
    }

    public View cf() {
        return this.mO;
    }

    public View findViewById(int i) {
        return this.mO.findViewById(i);
    }
}
