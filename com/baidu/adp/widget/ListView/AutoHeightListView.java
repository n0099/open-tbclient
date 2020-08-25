package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
/* loaded from: classes2.dex */
public class AutoHeightListView extends ListView {
    public AutoHeightListView(Context context) {
        this(context, null);
    }

    public AutoHeightListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoHeightListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
