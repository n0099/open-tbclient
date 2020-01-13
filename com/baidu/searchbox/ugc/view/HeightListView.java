package com.baidu.searchbox.ugc.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
@Deprecated
/* loaded from: classes12.dex */
public class HeightListView extends ListView {
    private int mListViewHeight;

    public int getListViewHeight() {
        return this.mListViewHeight;
    }

    public void setListViewHeight(int i) {
        this.mListViewHeight = i;
    }

    public HeightListView(Context context) {
        super(context);
        this.mListViewHeight = -1;
    }

    public HeightListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mListViewHeight = -1;
    }

    public HeightListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mListViewHeight = -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mListViewHeight > -1) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.mListViewHeight, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }
}
