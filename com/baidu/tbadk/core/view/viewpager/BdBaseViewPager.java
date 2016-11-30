package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class BdBaseViewPager extends ViewPager {
    private boolean aix;
    private float x;
    private float y;

    public BdBaseViewPager(Context context) {
        super(context);
        this.aix = false;
    }

    public BdBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aix = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        this.aix = z;
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (h(motionEvent)) {
            return true;
        }
        if (motionEvent.getPointerCount() > 1 && this.aix) {
            requestDisallowInterceptTouchEvent(false);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            requestDisallowInterceptTouchEvent(true);
            return dispatchTouchEvent;
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (h(motionEvent)) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.x = getX();
                this.y = getY();
                if (Math.abs(this.x - getX()) <= Math.abs(this.y - getY())) {
                    aP(true);
                    break;
                } else {
                    aP(false);
                    break;
                }
            case 1:
            default:
                aP(true);
                break;
            case 2:
                if (Math.abs(this.x - getX()) <= Math.abs(this.y - getY())) {
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
            case 2:
            case 5:
            case 6:
                aP(true);
                break;
            case 1:
            case 3:
                aP(false);
                break;
        }
        if (h(motionEvent)) {
            return true;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    private boolean h(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    private void aP(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
