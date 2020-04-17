package com.baidu.swan.apps.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
/* loaded from: classes11.dex */
public class HeightListView extends ListView {
    private int cyG;

    public void setListViewHeight(int i) {
        this.cyG = i;
    }

    public HeightListView(Context context) {
        super(context);
        this.cyG = -1;
    }

    public HeightListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cyG = -1;
    }

    public HeightListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cyG = -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.cyG > -1) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.cyG, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }
}
