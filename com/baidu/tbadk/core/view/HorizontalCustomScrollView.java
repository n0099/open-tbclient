package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
public class HorizontalCustomScrollView extends HorizontalScrollView {
    private a esg;

    /* loaded from: classes.dex */
    public interface a {
        void aT(int i, int i2);
    }

    public void setOnSizeChangeListener(a aVar) {
        this.esg = aVar;
    }

    public HorizontalCustomScrollView(Context context) {
        super(context);
    }

    public HorizontalCustomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HorizontalCustomScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.esg != null) {
            this.esg.aT(getMeasuredWidth(), getMeasuredHeight());
        }
    }
}
