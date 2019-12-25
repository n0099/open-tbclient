package com.baidu.live.tbadk.widget.horizonalscrolllistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
/* loaded from: classes2.dex */
public class MyHorizontalScrollView extends HorizontalScrollView {
    private GestureDetector mGestureDetector;

    public MyHorizontalScrollView(Context context) {
        super(context);
        this.mGestureDetector = new GestureDetector(new XScrollDetector());
    }

    public MyHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGestureDetector = new GestureDetector(new XScrollDetector());
    }

    public MyHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGestureDetector = new GestureDetector(new XScrollDetector());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
                return onInterceptTouchEvent;
            }
            return onInterceptTouchEvent;
        }
        return false;
    }

    /* loaded from: classes2.dex */
    private class XScrollDetector extends GestureDetector.SimpleOnGestureListener {
        private XScrollDetector() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return Math.abs(f) > Math.abs(f2);
        }
    }
}
