package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes3.dex */
public class WholeDisplayGridView extends BdGridView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f13593e;

    public WholeDisplayGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13593e = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2 && this.f13593e) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public void setForbidMove(boolean z) {
        this.f13593e = z;
    }

    public WholeDisplayGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13593e = false;
    }

    public WholeDisplayGridView(Context context) {
        super(context);
        this.f13593e = false;
    }
}
