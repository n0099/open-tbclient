package com.baidu.swan.apps.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
/* loaded from: classes3.dex */
public class HeightListView extends ListView {

    /* renamed from: e  reason: collision with root package name */
    public int f11394e;

    public HeightListView(Context context) {
        super(context);
        this.f11394e = -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = this.f11394e;
        if (i4 > -1) {
            i3 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
    }

    public void setListViewHeight(int i2) {
        this.f11394e = i2;
    }

    public HeightListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11394e = -1;
    }

    public HeightListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11394e = -1;
    }
}
