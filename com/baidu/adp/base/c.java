package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class c<T> extends d<T> {
    protected View mConvertView;

    public c(f<T> fVar, int i) {
        super(fVar);
        this.mConvertView = null;
        this.mConvertView = LayoutInflater.from(fVar.getContext()).inflate(i, (ViewGroup) null);
        this.mConvertView.setTag(this);
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public View findViewById(int i) {
        return this.mConvertView.findViewById(i);
    }
}
