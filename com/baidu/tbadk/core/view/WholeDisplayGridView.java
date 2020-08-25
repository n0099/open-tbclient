package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes2.dex */
public class WholeDisplayGridView extends BdGridView {
    private boolean ewg;

    public WholeDisplayGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ewg = false;
    }

    public WholeDisplayGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ewg = false;
    }

    public WholeDisplayGridView(Context context) {
        super(context);
        this.ewg = false;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2 && this.ewg) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setForbidMove(boolean z) {
        this.ewg = z;
    }
}
