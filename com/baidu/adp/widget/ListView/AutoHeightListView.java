package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
/* loaded from: classes.dex */
public class AutoHeightListView extends ListView {
    public AutoHeightListView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public AutoHeightListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoHeightListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
