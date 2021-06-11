package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes3.dex */
public class WholeDisplayGridView extends BdGridView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f12527e;

    public WholeDisplayGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12527e = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2 && this.f12527e) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public void setForbidMove(boolean z) {
        this.f12527e = z;
    }

    public WholeDisplayGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12527e = false;
    }

    public WholeDisplayGridView(Context context) {
        super(context);
        this.f12527e = false;
    }
}
