package com.baidu.searchbox.ui.imagezoom;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;
/* loaded from: classes4.dex */
public class ImageViewTouch extends ImageViewTouchBase {
    public static final float SCROLL_DELTA_THRESHOLD = 1.0f;
    public int mDoubleTapDirection;
    public boolean mDoubleTapEnabled;
    public OnImageViewTouchDoubleTapListener mDoubleTapListener;
    public OnImageViewTouchFlingListener mFlingListener;
    public GestureDetector mGestureDetector;
    public GestureDetector.OnGestureListener mGestureListener;
    public OnLongPressListener mLongPressListener;
    public ScaleGestureDetector mScaleDetector;
    public boolean mScaleEnabled;
    public float mScaleFactor;
    public ScaleGestureDetector.OnScaleGestureListener mScaleListener;
    public boolean mScrollEnabled;
    public OnImageViewTouchScrollListener mScrollListener;
    public OnImageViewTouchSingleTapListener mSingleTapListener;
    public int mTouchSlop;
    public OnImageViewTouchScaleListener mViewScaleListener;

    /* loaded from: classes4.dex */
    public interface OnImageViewTouchDoubleTapListener {
        void onDoubleTap();
    }

    /* loaded from: classes4.dex */
    public interface OnImageViewTouchFlingListener {
        void onFling();
    }

    /* loaded from: classes4.dex */
    public interface OnImageViewTouchScaleListener {
        void onScale();
    }

    /* loaded from: classes4.dex */
    public interface OnImageViewTouchScrollListener {
        void onScroll();
    }

    /* loaded from: classes4.dex */
    public interface OnImageViewTouchSingleTapListener {
        void onSingleTapConfirmed();
    }

    /* loaded from: classes4.dex */
    public interface OnLongPressListener {
        void onLongPress();
    }

    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return true;
    }

    /* loaded from: classes4.dex */
    public class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return ImageViewTouch.this.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (ImageViewTouch.this.isLongClickable() && !ImageViewTouch.this.mScaleDetector.isInProgress()) {
                ImageViewTouch.this.setPressed(true);
                if (ImageViewTouch.this.mLongPressListener != null) {
                    ImageViewTouch.this.mLongPressListener.onLongPress();
                }
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (ImageViewTouch.this.mSingleTapListener != null) {
                ImageViewTouch.this.mSingleTapListener.onSingleTapConfirmed();
            }
            return ImageViewTouch.this.onSingleTapConfirmed(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return ImageViewTouch.this.onSingleTapUp(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            ImageViewTouch imageViewTouch = ImageViewTouch.this;
            if (imageViewTouch.mDoubleTapEnabled) {
                imageViewTouch.mUserScaled = true;
                float scale = imageViewTouch.getScale();
                ImageViewTouch imageViewTouch2 = ImageViewTouch.this;
                ImageViewTouch.this.zoomTo(Math.min(ImageViewTouch.this.getMaxScale(), Math.max(imageViewTouch2.onDoubleTapPost(scale, imageViewTouch2.getMaxScale()), ImageViewTouch.this.getMinScale())), motionEvent.getX(), motionEvent.getY(), 200.0f);
                ImageViewTouch.this.invalidate();
            }
            if (ImageViewTouch.this.mDoubleTapListener != null) {
                ImageViewTouch.this.mDoubleTapListener.onDoubleTap();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!ImageViewTouch.this.mScrollEnabled || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1 || ImageViewTouch.this.mScaleDetector.isInProgress() || ImageViewTouch.this.getScale() == 1.0f) {
                return false;
            }
            if (ImageViewTouch.this.mFlingListener != null) {
                ImageViewTouch.this.mFlingListener.onFling();
            }
            return ImageViewTouch.this.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!ImageViewTouch.this.mScrollEnabled || motionEvent == null || motionEvent2 == null || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1 || ImageViewTouch.this.mScaleDetector.isInProgress()) {
                return false;
            }
            if (ImageViewTouch.this.mScrollListener != null) {
                ImageViewTouch.this.mScrollListener.onScroll();
            }
            return ImageViewTouch.this.onScroll(motionEvent, motionEvent2, f, f2);
        }
    }

    /* loaded from: classes4.dex */
    public class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public boolean mScaled = false;

        public ScaleListener() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float currentSpan = scaleGestureDetector.getCurrentSpan() - scaleGestureDetector.getPreviousSpan();
            float scale = ImageViewTouch.this.getScale() * scaleGestureDetector.getScaleFactor();
            ImageViewTouch imageViewTouch = ImageViewTouch.this;
            if (imageViewTouch.mScaleEnabled) {
                if (this.mScaled && currentSpan != 0.0f) {
                    imageViewTouch.mUserScaled = true;
                    ImageViewTouch.this.zoomTo(Math.min(imageViewTouch.getMaxScale(), Math.max(scale, ImageViewTouch.this.getMinScale() - 0.1f)), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    ImageViewTouch imageViewTouch2 = ImageViewTouch.this;
                    imageViewTouch2.mDoubleTapDirection = 1;
                    imageViewTouch2.invalidate();
                    if (ImageViewTouch.this.mViewScaleListener != null) {
                        ImageViewTouch.this.mViewScaleListener.onScale();
                    }
                    return true;
                } else if (!this.mScaled) {
                    this.mScaled = true;
                }
            }
            return true;
        }
    }

    public ImageViewTouch(Context context) {
        super(context);
        this.mDoubleTapEnabled = true;
        this.mScaleEnabled = true;
        this.mScrollEnabled = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mScaleDetector.onTouchEvent(motionEvent);
        if (!this.mScaleDetector.isInProgress()) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        if ((motionEvent.getAction() & 255) != 1) {
            return true;
        }
        return onUp(motionEvent);
    }

    public boolean onUp(MotionEvent motionEvent) {
        if (getScale() < getMinScale()) {
            zoomTo(getMinScale(), 50.0f);
            return true;
        }
        return true;
    }

    @Override // com.baidu.searchbox.ui.imagezoom.ImageViewTouchBase
    public void onZoomAnimationCompleted(float f) {
        if (f < getMinScale()) {
            zoomTo(getMinScale(), 50.0f);
        }
    }

    public void setDoubleTapEnabled(boolean z) {
        this.mDoubleTapEnabled = z;
    }

    public void setDoubleTapListener(OnImageViewTouchDoubleTapListener onImageViewTouchDoubleTapListener) {
        this.mDoubleTapListener = onImageViewTouchDoubleTapListener;
    }

    public void setFlingListener(OnImageViewTouchFlingListener onImageViewTouchFlingListener) {
        this.mFlingListener = onImageViewTouchFlingListener;
    }

    public void setLongPressListener(OnLongPressListener onLongPressListener) {
        this.mLongPressListener = onLongPressListener;
    }

    public void setScaleEnabled(boolean z) {
        this.mScaleEnabled = z;
    }

    public void setScrollEnabled(boolean z) {
        this.mScrollEnabled = z;
    }

    public void setScrollListener(OnImageViewTouchScrollListener onImageViewTouchScrollListener) {
        this.mScrollListener = onImageViewTouchScrollListener;
    }

    public void setSingleTapListener(OnImageViewTouchSingleTapListener onImageViewTouchSingleTapListener) {
        this.mSingleTapListener = onImageViewTouchSingleTapListener;
    }

    public void setViewScaleListener(OnImageViewTouchScaleListener onImageViewTouchScaleListener) {
        this.mViewScaleListener = onImageViewTouchScaleListener;
    }

    public ImageViewTouch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public float onDoubleTapPost(float f, float f2) {
        if (this.mDoubleTapDirection == 1) {
            float f3 = this.mScaleFactor;
            if ((2.0f * f3) + f <= f2) {
                return f + f3;
            }
            this.mDoubleTapDirection = -1;
            return f2;
        }
        this.mDoubleTapDirection = 1;
        return 1.0f;
    }

    public ImageViewTouch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDoubleTapEnabled = true;
        this.mScaleEnabled = true;
        this.mScrollEnabled = true;
    }

    public boolean canScroll(int i) {
        RectF bitmapRect = getBitmapRect();
        updateRect(bitmapRect, this.mScrollRect);
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (bitmapRect == null) {
            return false;
        }
        float f = bitmapRect.right;
        int i2 = rect.right;
        if (f >= i2 && i < 0) {
            if (Math.abs(f - i2) <= 1.0f) {
                return false;
            }
            return true;
        } else if (Math.abs(bitmapRect.left - this.mScrollRect.left) <= 1.0d) {
            return false;
        } else {
            return true;
        }
    }

    public boolean getDoubleTapEnabled() {
        return this.mDoubleTapEnabled;
    }

    public OnImageViewTouchFlingListener getFlingListener() {
        return this.mFlingListener;
    }

    public GestureDetector.OnGestureListener getGestureListener() {
        return new GestureListener();
    }

    public ScaleGestureDetector.OnScaleGestureListener getScaleListener() {
        return new ScaleListener();
    }

    public OnImageViewTouchScrollListener getScrollListener() {
        return this.mScrollListener;
    }

    public OnImageViewTouchScaleListener getViewScaleListener() {
        return this.mViewScaleListener;
    }

    @Override // com.baidu.searchbox.ui.imagezoom.ImageViewTouchBase
    public void init(Context context, AttributeSet attributeSet, int i) {
        super.init(context, attributeSet, i);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mGestureListener = getGestureListener();
        this.mScaleListener = getScaleListener();
        this.mScaleDetector = new ScaleGestureDetector(getContext(), this.mScaleListener);
        this.mGestureDetector = new GestureDetector(getContext(), this.mGestureListener, null, true);
        this.mDoubleTapDirection = 1;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float x = motionEvent2.getX() - motionEvent.getX();
        float y = motionEvent2.getY() - motionEvent.getY();
        if (Math.abs(f) <= 800.0f && Math.abs(f2) <= 800.0f) {
            return false;
        }
        this.mUserScaled = true;
        scrollBy(x * 2.0f, y * 2.0f, 300.0d);
        invalidate();
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (getScale() == 1.0f) {
            return false;
        }
        this.mUserScaled = true;
        scrollBy(-f, -f2);
        invalidate();
        return true;
    }

    @Override // com.baidu.searchbox.ui.imagezoom.ImageViewTouchBase
    public void setImageDrawableSpecial(Drawable drawable, Matrix matrix, float f, float f2) {
        super.setImageDrawableSpecial(drawable, matrix, f, f2);
        this.mScaleFactor = getMaxScale() / 3.0f;
    }
}
