package com.baidu.pass.ecommerce.common.adapter;

import android.view.View;
/* loaded from: classes2.dex */
public class ViewHolder<D> {
    public View convertView;

    public ViewHolder(View view) {
        this.convertView = view;
    }

    public void bindView(D d2) {
    }

    public <T extends View> T findViewById(int i) {
        return (T) this.convertView.findViewById(i);
    }
}
