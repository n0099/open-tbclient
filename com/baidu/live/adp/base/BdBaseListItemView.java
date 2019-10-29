package com.baidu.live.adp.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes6.dex */
public class BdBaseListItemView<T> extends BdBaseView<T> {
    protected View mConvertView;

    public BdBaseListItemView(BdPageContext<T> bdPageContext, int i) {
        super(bdPageContext);
        this.mConvertView = null;
        this.mConvertView = LayoutInflater.from(bdPageContext.getContext()).inflate(i, (ViewGroup) null);
        this.mConvertView.setTag(this);
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public View findViewById(int i) {
        return this.mConvertView.findViewById(i);
    }
}
