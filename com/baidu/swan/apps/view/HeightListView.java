package com.baidu.swan.apps.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
/* loaded from: classes3.dex */
public class HeightListView extends ListView {

    /* renamed from: e  reason: collision with root package name */
    public int f12350e;

    public HeightListView(Context context) {
        super(context);
        this.f12350e = -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.f12350e;
        if (i3 > -1) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    public void setListViewHeight(int i) {
        this.f12350e = i;
    }

    public HeightListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12350e = -1;
    }

    public HeightListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12350e = -1;
    }
}
