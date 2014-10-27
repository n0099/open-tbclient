package com.baidu.tbadk.core.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class BaseViewPager extends ViewPager implements GestureDetector.OnGestureListener {
    private GestureDetector GW;
    private a GX;
    private a GY;

    public BaseViewPager(Context context) {
        super(context);
        this.GW = null;
        this.GX = null;
        this.GY = null;
        init();
    }

    public BaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GW = null;
        this.GX = null;
        this.GY = null;
        init();
    }

    public void setOnFlipOutListener(a aVar) {
        this.GX = aVar;
    }

    public void setOnScrollOutListener(a aVar) {
        this.GY = aVar;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.GW == null || getAdapter() == null || getAdapter().getCount() == 0 || (getCurrentItem() != 0 && getAdapter().getCount() != getCurrentItem() + 1)) {
            return super.onTouchEvent(motionEvent);
        }
        this.GW.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    private void init() {
        this.GW = new GestureDetector(this);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.GX != null) {
            if (f < 0.0f && getAdapter().getCount() == getCurrentItem() + 1) {
                this.GX.bE(0);
                return true;
            } else if (f > 0.0f && getCurrentItem() == 0) {
                this.GX.bE(1);
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
        if (this.GY != null) {
            if (f > 0.0f && getAdapter().getCount() == getCurrentItem() + 1) {
                this.GY.bE(0);
                return true;
            } else if (f < 0.0f && getCurrentItem() == 0) {
                this.GY.bE(1);
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
