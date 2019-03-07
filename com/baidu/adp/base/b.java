package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View vk;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.vk = null;
        this.vk = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.vk.setTag(this);
    }

    public View fY() {
        return this.vk;
    }

    public View findViewById(int i) {
        return this.vk.findViewById(i);
    }
}
