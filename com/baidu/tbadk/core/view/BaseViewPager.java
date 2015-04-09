package com.baidu.tbadk.core.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class BaseViewPager extends ViewPager implements GestureDetector.OnGestureListener {
    private a Xc;
    private a Xd;
    private GestureDetector mGestureDetector;

    public BaseViewPager(Context context) {
        super(context);
        this.mGestureDetector = null;
        this.Xc = null;
        this.Xd = null;
        init();
    }

    public BaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGestureDetector = null;
        this.Xc = null;
        this.Xd = null;
        init();
    }

    public void setOnFlipOutListener(a aVar) {
        this.Xc = aVar;
    }

    public void setOnScrollOutListener(a aVar) {
        this.Xd = aVar;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector == null || getAdapter() == null || getAdapter().getCount() == 0 || (getCurrentItem() != 0 && getAdapter().getCount() != getCurrentItem() + 1)) {
            return super.onTouchEvent(motionEvent);
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    private void init() {
        this.mGestureDetector = new GestureDetector(this);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.Xc != null) {
            if (f < 0.0f && getAdapter().getCount() == getCurrentItem() + 1) {
                this.Xc.cj(0);
                return true;
            } else if (f > 0.0f && getCurrentItem() == 0) {
                this.Xc.cj(1);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.Xd != null) {
            if (f > 0.0f && getAdapter().getCount() == getCurrentItem() + 1) {
                this.Xd.cj(0);
                return true;
            } else if (f < 0.0f && getCurrentItem() == 0) {
                this.Xd.cj(1);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }
}
