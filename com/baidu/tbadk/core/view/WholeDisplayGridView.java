package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class WholeDisplayGridView extends BdGridView {
    private boolean azi;

    public WholeDisplayGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.azi = false;
    }

    public WholeDisplayGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azi = false;
    }

    public WholeDisplayGridView(Context context) {
        super(context);
        this.azi = false;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2 && this.azi) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setForbidMove(boolean z) {
        this.azi = z;
    }
}
