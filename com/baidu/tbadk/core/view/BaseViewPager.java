package com.baidu.tbadk.core.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class BaseViewPager extends ViewPager implements GestureDetector.OnGestureListener {
    private GestureDetector GX;
    private a GY;
    private a GZ;

    public BaseViewPager(Context context) {
        super(context);
        this.GX = null;
        this.GY = null;
        this.GZ = null;
        init();
    }

    public BaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GX = null;
        this.GY = null;
        this.GZ = null;
        init();
    }

    public void setOnFlipOutListener(a aVar) {
        this.GY = aVar;
    }

    public void setOnScrollOutListener(a aVar) {
        this.GZ = aVar;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.GX == null || getAdapter() == null || getAdapter().getCount() == 0 || (getCurrentItem() != 0 && getAdapter().getCount() != getCurrentItem() + 1)) {
            return super.onTouchEvent(motionEvent);
        }
        this.GX.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    private void init() {
        this.GX = new GestureDetector(this);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.GY != null) {
            if (f < 0.0f && getAdapter().getCount() == getCurrentItem() + 1) {
                this.GY.bE(0);
                return true;
            } else if (f > 0.0f && getCurrentItem() == 0) {
                this.GY.bE(1);
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
        if (this.GZ != null) {
            if (f > 0.0f && getAdapter().getCount() == getCurrentItem() + 1) {
                this.GZ.bE(0);
                return true;
            } else if (f < 0.0f && getCurrentItem() == 0) {
                this.GZ.bE(1);
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
