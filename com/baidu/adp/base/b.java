package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View vo;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.vo = null;
        this.vo = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.vo.setTag(this);
    }

    public View gb() {
        return this.vo;
    }

    public View findViewById(int i) {
        return this.vo.findViewById(i);
    }
}
