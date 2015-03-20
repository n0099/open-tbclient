package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
public class HorizontalCustomScrollView extends HorizontalScrollView {
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
}
