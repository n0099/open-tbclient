package com.baidu.searchbox.picture.component;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.baidu.searchbox.picture.component.listener.OnScaleDragGestureListener;
/* loaded from: classes13.dex */
public class ScaleDragDetector implements ScaleGestureDetector.OnScaleGestureListener {
    private static final int INVALID_POINTER_ID = -1;
    private int mActivePointerId = -1;
    private int mActivePointerIndex = 0;
    private boolean mIsDragging;
    float mLastTouchX;
    float mLastTouchY;
    private final float mMinimumVelocity;
    private final ScaleGestureDetector mScaleDetector;
    private final OnScaleDragGestureListener mScaleDragGestureListener;
    private final float mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public ScaleDragDetector(Context context, OnScaleDragGestureListener onScaleDragGestureListener) {
        this.mScaleDetector = new ScaleGestureDetector(context, this);
        this.mScaleDragGestureListener = onScaleDragGestureListener;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
            return false;
        }
        this.mScaleDragGestureListener.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.mScaleDragGestureListener.onScaleEnd();
    }

    public boolean isScaling() {
        return this.mScaleDetector.isInProgress();
    }

    public boolean isDragging() {
        return this.mIsDragging;
    }

    private float getActiveX(MotionEvent motionEvent) {
        try {
            return MotionEventCompat.getX(motionEvent, this.mActivePointerIndex);
        } catch (Exception e) {
            return motionEvent.getX();
        }
    }

    private float getActiveY(MotionEvent motionEvent) {
        try {
            return MotionEventCompat.getY(motionEvent, this.mActivePointerIndex);
        } catch (Exception e) {
            return motionEvent.getY();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mScaleDetector.onTouchEvent(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        onTouchActivePointer(actionMasked, motionEvent);
        onTouchDragEvent(actionMasked, motionEvent);
        return true;
    }

    private void onTouchActivePointer(int i, MotionEvent motionEvent) {
        switch (i) {
            case 0:
                this.mActivePointerId = motionEvent.getPointerId(0);
                break;
            case 1:
            case 3:
                this.mActivePointerId = -1;
                break;
            case 6:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
                    int i2 = actionIndex == 0 ? 1 : 0;
                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, i2);
                    this.mLastTouchX = MotionEventCompat.getX(motionEvent, i2);
                    this.mLastTouchY = MotionEventCompat.getY(motionEvent, i2);
                    break;
                }
                break;
        }
        this.mActivePointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId != -1 ? this.mActivePointerId : 0);
    }

    private void onTouchDragEvent(int i, MotionEvent motionEvent) {
        switch (i) {
            case 0:
                this.mVelocityTracker = VelocityTracker.obtain();
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.addMovement(motionEvent);
                }
                this.mLastTouchX = getActiveX(motionEvent);
                this.mLastTouchY = getActiveY(motionEvent);
                this.mIsDragging = false;
                return;
            case 1:
                if (this.mIsDragging && this.mVelocityTracker != null) {
                    this.mLastTouchX = getActiveX(motionEvent);
                    this.mLastTouchY = getActiveY(motionEvent);
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float xVelocity = this.mVelocityTracker.getXVelocity();
                    float yVelocity = this.mVelocityTracker.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.mMinimumVelocity) {
                        this.mScaleDragGestureListener.onFling(this.mLastTouchX, this.mLastTouchY, -xVelocity, -yVelocity);
                    }
                }
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    return;
                }
                return;
            case 2:
                float activeX = getActiveX(motionEvent);
                float activeY = getActiveY(motionEvent);
                float f = activeX - this.mLastTouchX;
                float f2 = activeY - this.mLastTouchY;
                if (!this.mIsDragging) {
                    this.mIsDragging = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.mTouchSlop);
                }
                if (this.mIsDragging) {
                    this.mScaleDragGestureListener.onDrag(f, f2);
                    this.mLastTouchX = activeX;
                    this.mLastTouchY = activeY;
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.addMovement(motionEvent);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
