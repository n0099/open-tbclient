package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class h extends LinearLayout {
    public h(Context context, String str) {
        super(context);
        LayoutInflater.from(getContext()).inflate(com.baidu.tieba.r.floatview_item_layout, this);
        setGravity(17);
        ((TextView) findViewById(com.baidu.tieba.q.floatview_item_tv)).setText(str);
        setTag(str);
    }

    public static LinearLayout.LayoutParams uo() {
        return new LinearLayout.LayoutParams(-2, -1);
    }
}
