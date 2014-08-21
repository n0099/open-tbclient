package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class c extends LinearLayout {
    public c(Context context, String str) {
        super(context);
        LayoutInflater.from(getContext()).inflate(com.baidu.tieba.v.floatview_item_layout, this);
        setGravity(17);
        ((TextView) findViewById(com.baidu.tieba.u.floatview_item_tv)).setText(str);
        setTag(str);
    }

    public static LinearLayout.LayoutParams a() {
        return new LinearLayout.LayoutParams(-2, -1);
    }
}
