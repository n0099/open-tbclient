package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class WholeDisplayGridView extends BdGridView {
    private boolean azw;

    public WholeDisplayGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.azw = false;
    }

    public WholeDisplayGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azw = false;
    }

    public WholeDisplayGridView(Context context) {
        super(context);
        this.azw = false;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2 && this.azw) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setForbidMove(boolean z) {
        this.azw = z;
    }
}
