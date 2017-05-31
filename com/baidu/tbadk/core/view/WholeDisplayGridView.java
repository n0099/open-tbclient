package com.baidu.tbadk.core.view;

import android.content.Context;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class WholeDisplayGridView extends BdGridView {
    private boolean amI;

    public WholeDisplayGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amI = false;
    }

    public WholeDisplayGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amI = false;
    }

    public WholeDisplayGridView(Context context) {
        super(context);
        this.amI = false;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, ExploreByTouchHelper.INVALID_ID));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2 && this.amI) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setForbidMove(boolean z) {
        this.amI = z;
    }
}
