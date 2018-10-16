package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View vm;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.vm = null;
        this.vm = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.vm.setTag(this);
    }

    public View gb() {
        return this.vm;
    }

    public View findViewById(int i) {
        return this.vm.findViewById(i);
    }
}
