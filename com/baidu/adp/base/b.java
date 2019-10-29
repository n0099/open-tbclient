package com.baidu.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class b<T> extends c<T> {
    protected View mConvertView;

    public b(e<T> eVar, int i) {
        super(eVar);
        this.mConvertView = null;
        this.mConvertView = LayoutInflater.from(eVar.getContext()).inflate(i, (ViewGroup) null);
        this.mConvertView.setTag(this);
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public View findViewById(int i) {
        return this.mConvertView.findViewById(i);
    }
}
