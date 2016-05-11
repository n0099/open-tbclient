package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class d<T> extends f<T> {
    protected View dq;

    public d(h<T> hVar, int i) {
        super(hVar);
        this.dq = null;
        this.dq = LayoutInflater.from(hVar.getContext()).inflate(i, (ViewGroup) null);
        this.dq.setTag(this);
    }

    public View ac() {
        return this.dq;
    }

    public View findViewById(int i) {
        return this.dq.findViewById(i);
    }
}
