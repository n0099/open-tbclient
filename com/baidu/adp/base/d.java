package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class d<T> extends f<T> {
    protected View mConvertView;

    public d(h<T> hVar, int i) {
        super(hVar);
        this.mConvertView = null;
        this.mConvertView = LayoutInflater.from(hVar.getContext()).inflate(i, (ViewGroup) null);
        this.mConvertView.setTag(this);
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public View findViewById(int i) {
        return this.mConvertView.findViewById(i);
    }
}
