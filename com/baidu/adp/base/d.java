package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class d<T> extends e<T> {
    protected View ge;

    public d(g<T> gVar, int i) {
        super(gVar);
        this.ge = null;
        this.ge = LayoutInflater.from(gVar.getContext()).inflate(i, (ViewGroup) null);
        this.ge.setTag(this);
    }

    public View aX() {
        return this.ge;
    }

    public View findViewById(int i) {
        return this.ge.findViewById(i);
    }
}
