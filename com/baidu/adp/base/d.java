package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class d<T> extends f<T> {
    protected View gh;

    public d(h<T> hVar, int i) {
        super(hVar);
        this.gh = null;
        this.gh = LayoutInflater.from(hVar.getContext()).inflate(i, (ViewGroup) null);
        this.gh.setTag(this);
    }

    public View aX() {
        return this.gh;
    }

    public View findViewById(int i) {
        return this.gh.findViewById(i);
    }
}
