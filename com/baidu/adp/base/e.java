package com.baidu.adp.base;

import android.view.View;
/* loaded from: classes.dex */
public class e<T> extends g<T> {
    protected View mConvertView;

    public e(j<T> jVar, int i) {
        super(jVar);
        this.mConvertView = null;
        this.mConvertView = com.baidu.adp.lib.g.b.hr().inflate(jVar.getContext(), i, null);
        this.mConvertView.setTag(this);
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public View findViewById(int i) {
        return this.mConvertView.findViewById(i);
    }
}
