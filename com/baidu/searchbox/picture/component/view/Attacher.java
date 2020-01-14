package com.baidu.searchbox.picture.component.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ScrollerCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.baidu.searchbox.picture.component.ScaleDragDetector;
import com.baidu.searchbox.picture.component.listener.DefaultOnDoubleTapListener;
import com.baidu.searchbox.picture.component.listener.OnPhotoTapListener;
import com.baidu.searchbox.picture.component.listener.OnScaleChangeListener;
import com.baidu.searchbox.picture.component.listener.OnScaleDragGestureListener;
import com.baidu.searchbox.picture.component.listener.OnViewTapListener;
import com.facebook.drawee.drawable.p;
import com.facebook.drawee.generic.a;
import com.facebook.drawee.view.DraweeView;
import java.lang.ref.WeakReference;
/* loaded from: classes12.dex */
public class Attacher implements View.OnTouchListener, OnScaleDragGestureListener, IAttacher {
    private static final int EDGE_BOTH = 2;
    private static final int EDGE_LEFT = 0;
    private static final int EDGE_NONE = -1;
    private static final int EDGE_RIGHT = 1;
    private FlingRunnable mCurrentFlingRunnable;
    private WeakReference<DraweeView<a>> mDraweeView;
    private GestureDetectorCompat mGestureDetector;
    private View.OnLongClickListener mLongClickListener;
    private OnScaleDragGestureListener mOnScaleDragGestureListener;
    private OnPhotoTapListener mPhotoTapListener;
    private OnScaleChangeListener mScaleChangeListener;
    private ScaleDragDetector mScaleDragDetector;
    private OnViewTapListener mViewTapListener;
    private final float[] mMatrixValues = new float[9];
    private final RectF mDisplayRect = new RectF();
    private final Interpolator mZoomInterpolator = new AccelerateDecelerateInterpolator();
    private float mMinScale = 1.0f;
    private float mMidScale = 1.75f;
    private float mMaxScale = 3.0f;
    private long mZoomDuration = 200;
    private boolean mBlockParentIntercept = false;
    private boolean mAllowParentInterceptOnEdge = true;
    private int mScrollEdge = 2;
    private final Matrix mMatrix = new Matrix();
    private int mImageInfoHeight = -1;
    private int mImageInfoWidth = -1;

    public Attacher(DraweeView<a> draweeView) {
        this.mDraweeView = new WeakReference<>(draweeView);
        draweeView.getHierarchy().b(p.b.lMg);
        draweeView.setOnTouchListener(this);
        this.mScaleDragDetector = new ScaleDragDetector(draweeView.getContext(), this);
        this.mGestureDetector = new GestureDetectorCompat(draweeView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.searchbox.picture.component.view.Attacher.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                super.onLongPress(motionEvent);
                if (Attacher.this.mLongClickListener != null) {
                    Attacher.this.mLongClickListener.onLongClick(Attacher.this.getDraweeView());
                }
            }
        });
        this.mGestureDetector.setOnDoubleTapListener(new DefaultOnDoubleTapListener(this));
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        if (onDoubleTapListener != null) {
            this.mGestureDetector.setOnDoubleTapListener(onDoubleTapListener);
        } else {
            this.mGestureDetector.setOnDoubleTapListener(new DefaultOnDoubleTapListener(this));
        }
    }

    public DraweeView<a> getDraweeView() {
        return this.mDraweeView.get();
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public float getMinimumScale() {
        return this.mMinScale;
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public float getMediumScale() {
        return this.mMidScale;
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public float getMaximumScale() {
        return this.mMaxScale;
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setMaximumScale(float f) {
        checkZoomLevels(this.mMinScale, this.mMidScale, f);
        this.mMaxScale = f;
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setMediumScale(float f) {
        checkZoomLevels(this.mMinScale, f, this.mMaxScale);
        this.mMidScale = f;
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setMinimumScale(float f) {
        checkZoomLevels(f, this.mMidScale, this.mMaxScale);
        this.mMinScale = f;
    }

    public void setScaleParams(float f, float f2, float f3) {
        checkZoomLevels(f, f2, f3);
        this.mMinScale = f;
        this.mMidScale = f2;
        this.mMaxScale = f3;
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(getMatrixValue(this.mMatrix, 0), 2.0d)) + ((float) Math.pow(getMatrixValue(this.mMatrix, 3), 2.0d)));
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setScale(float f) {
        setScale(f, false);
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setScale(float f, boolean z) {
        DraweeView<a> draweeView = getDraweeView();
        if (draweeView != null) {
            setScale(f, draweeView.getRight() / 2, draweeView.getBottom() / 2, false);
        }
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setScale(float f, float f2, float f3, boolean z) {
        DraweeView<a> draweeView = getDraweeView();
        if (draweeView != null && f >= this.mMinScale && f <= this.mMaxScale) {
            if (z) {
                draweeView.post(new AnimatedZoomRunnable(getScale(), f, f2, f3));
                return;
            }
            this.mMatrix.setScale(f, f, f2, f3);
            checkMatrixAndInvalidate();
        }
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setZoomTransitionDuration(long j) {
        if (j < 0) {
            j = 200;
        }
        this.mZoomDuration = j;
    }

    public void setOnScaleDragGestureListener(OnScaleDragGestureListener onScaleDragGestureListener) {
        this.mOnScaleDragGestureListener = onScaleDragGestureListener;
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setAllowParentInterceptOnEdge(boolean z) {
        this.mAllowParentInterceptOnEdge = z;
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setOnScaleChangeListener(OnScaleChangeListener onScaleChangeListener) {
        this.mScaleChangeListener = onScaleChangeListener;
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.mPhotoTapListener = onPhotoTapListener;
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.mViewTapListener = onViewTapListener;
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public OnPhotoTapListener getOnPhotoTapListener() {
        return this.mPhotoTapListener;
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public OnViewTapListener getOnViewTapListener() {
        return this.mViewTapListener;
    }

    @Override // com.baidu.searchbox.picture.component.view.IAttacher
    public void update(int i, int i2) {
        this.mImageInfoWidth = i;
        this.mImageInfoHeight = i2;
        updateBaseMatrix();
    }

    private static void checkZoomLevels(float f, float f2, float f3) {
        if (f > f2) {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        }
        if (f2 > f3) {
            throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
        }
    }

    private int getViewWidth() {
        DraweeView<a> draweeView = getDraweeView();
        if (draweeView != null) {
            return (draweeView.getWidth() - draweeView.getPaddingLeft()) - draweeView.getPaddingRight();
        }
        return 0;
    }

    private int getViewHeight() {
        DraweeView<a> draweeView = getDraweeView();
        if (draweeView != null) {
            return (draweeView.getHeight() - draweeView.getPaddingTop()) - draweeView.getPaddingBottom();
        }
        return 0;
    }

    private float getMatrixValue(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i];
    }

    public Matrix getDrawMatrix() {
        return this.mMatrix;
    }

    public RectF getDisplayRect() {
        checkMatrixBounds();
        return getDisplayRect(getDrawMatrix());
    }

    private RectF getDisplayRect(Matrix matrix) {
        DraweeView<a> draweeView = getDraweeView();
        if (draweeView == null || (this.mImageInfoWidth == -1 && this.mImageInfoHeight == -1)) {
            return null;
        }
        this.mDisplayRect.set(0.0f, 0.0f, this.mImageInfoWidth, this.mImageInfoHeight);
        draweeView.getHierarchy().a(this.mDisplayRect);
        matrix.mapRect(this.mDisplayRect);
        return this.mDisplayRect;
    }

    public void checkMatrixAndInvalidate() {
        DraweeView<a> draweeView = getDraweeView();
        if (draweeView != null && checkMatrixBounds()) {
            draweeView.invalidate();
        }
    }

    public RectF getRectF() {
        return getDisplayRect(getDrawMatrix());
    }

    public boolean checkMatrixBounds() {
        float f;
        float f2 = 0.0f;
        RectF displayRect = getDisplayRect(getDrawMatrix());
        if (displayRect == null) {
            return false;
        }
        float height = displayRect.height();
        float width = displayRect.width();
        int viewHeight = getViewHeight();
        if (height <= viewHeight) {
            f = ((viewHeight - height) / 2.0f) - displayRect.top;
        } else if (displayRect.top > 0.0f) {
            f = -displayRect.top;
        } else {
            f = displayRect.bottom < ((float) viewHeight) ? viewHeight - displayRect.bottom : 0.0f;
        }
        int viewWidth = getViewWidth();
        if (width <= viewWidth) {
            f2 = ((viewWidth - width) / 2.0f) - displayRect.left;
            this.mScrollEdge = 2;
        } else if (displayRect.left > 0.0f) {
            f2 = -displayRect.left;
            this.mScrollEdge = 0;
        } else if (displayRect.right < viewWidth) {
            f2 = viewWidth - displayRect.right;
            this.mScrollEdge = 1;
        } else {
            this.mScrollEdge = -1;
        }
        this.mMatrix.postTranslate(f2, f);
        return true;
    }

    private void updateBaseMatrix() {
        if (this.mImageInfoWidth != -1 || this.mImageInfoHeight != -1) {
            resetMatrix();
        }
    }

    private void resetMatrix() {
        this.mMatrix.reset();
        checkMatrixBounds();
        DraweeView<a> draweeView = getDraweeView();
        if (draweeView != null) {
            draweeView.invalidate();
        }
    }

    private void checkMinScale() {
        RectF displayRect;
        DraweeView<a> draweeView = getDraweeView();
        if (draweeView != null && getScale() < this.mMinScale && (displayRect = getDisplayRect()) != null) {
            draweeView.post(new AnimatedZoomRunnable(getScale(), this.mMinScale, displayRect.centerX(), displayRect.centerY()));
        }
    }

    @Override // com.baidu.searchbox.picture.component.listener.OnScaleDragGestureListener
    public void onScale(float f, float f2, float f3) {
        if (getScale() < this.mMaxScale || f < 1.0f) {
            if (this.mScaleChangeListener != null) {
                this.mScaleChangeListener.onScaleChange(f, f2, f3);
            }
            this.mMatrix.postScale(f, f, f2, f3);
            checkMatrixAndInvalidate();
            if (this.mOnScaleDragGestureListener != null) {
                this.mOnScaleDragGestureListener.onScale(f, f2, f3);
            }
        }
    }

    @Override // com.baidu.searchbox.picture.component.listener.OnScaleDragGestureListener
    public void onScaleEnd() {
        checkMinScale();
        if (this.mOnScaleDragGestureListener != null) {
            this.mOnScaleDragGestureListener.onScaleEnd();
        }
    }

    @Override // com.baidu.searchbox.picture.component.listener.OnScaleDragGestureListener
    public void onDrag(float f, float f2) {
        DraweeView<a> draweeView = getDraweeView();
        if (draweeView != null && !this.mScaleDragDetector.isScaling()) {
            this.mMatrix.postTranslate(f, f2);
            checkMatrixAndInvalidate();
            if (this.mOnScaleDragGestureListener != null) {
                this.mOnScaleDragGestureListener.onDrag(f, f2);
            }
            ViewParent parent = draweeView.getParent();
            if (parent != null) {
                if (this.mAllowParentInterceptOnEdge && !this.mScaleDragDetector.isScaling() && !this.mBlockParentIntercept) {
                    if (this.mScrollEdge == 2 || ((this.mScrollEdge == 0 && f >= 1.0f) || (this.mScrollEdge == 1 && f <= -1.0f))) {
                        parent.requestDisallowInterceptTouchEvent(false);
                        return;
                    }
                    return;
                }
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    @Override // com.baidu.searchbox.picture.component.listener.OnScaleDragGestureListener
    public void onFling(float f, float f2, float f3, float f4) {
        DraweeView<a> draweeView = getDraweeView();
        if (draweeView != null) {
            this.mCurrentFlingRunnable = new FlingRunnable(draweeView.getContext());
            this.mCurrentFlingRunnable.fling(getViewWidth(), getViewHeight(), (int) f3, (int) f4);
            draweeView.post(this.mCurrentFlingRunnable);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = false;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                ViewParent parent = view.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                cancelFling();
                break;
            case 1:
            case 3:
                ViewParent parent2 = view.getParent();
                if (parent2 != null) {
                    parent2.requestDisallowInterceptTouchEvent(false);
                    break;
                }
                break;
        }
        boolean isScaling = this.mScaleDragDetector.isScaling();
        boolean isDragging = this.mScaleDragDetector.isDragging();
        boolean onTouchEvent = this.mScaleDragDetector.onTouchEvent(motionEvent);
        boolean z2 = (isScaling || this.mScaleDragDetector.isScaling()) ? false : true;
        boolean z3 = (isDragging || this.mScaleDragDetector.isDragging()) ? false : true;
        if (z2 && z3) {
            z = true;
        }
        this.mBlockParentIntercept = z;
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        return onTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class AnimatedZoomRunnable implements Runnable {
        private final float mFocalX;
        private final float mFocalY;
        private final long mStartTime = System.currentTimeMillis();
        private final float mZoomEnd;
        private final float mZoomStart;

        public AnimatedZoomRunnable(float f, float f2, float f3, float f4) {
            this.mFocalX = f3;
            this.mFocalY = f4;
            this.mZoomStart = f;
            this.mZoomEnd = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            DraweeView<a> draweeView = Attacher.this.getDraweeView();
            if (draweeView != null) {
                float interpolate = interpolate();
                Attacher.this.onScale((this.mZoomStart + ((this.mZoomEnd - this.mZoomStart) * interpolate)) / Attacher.this.getScale(), this.mFocalX, this.mFocalY);
                if (interpolate < 1.0f) {
                    Attacher.this.postOnAnimation(draweeView, this);
                }
            }
        }

        private float interpolate() {
            return Attacher.this.mZoomInterpolator.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / ((float) Attacher.this.mZoomDuration)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class FlingRunnable implements Runnable {
        private int mCurrentX;
        private int mCurrentY;
        private final ScrollerCompat mScroller;

        public FlingRunnable(Context context) {
            this.mScroller = ScrollerCompat.create(context);
        }

        public void cancelFling() {
            this.mScroller.abortAnimation();
        }

        public void fling(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            RectF displayRect = Attacher.this.getDisplayRect();
            if (displayRect != null) {
                int round = Math.round(-displayRect.left);
                if (i < displayRect.width()) {
                    i5 = Math.round(displayRect.width() - i);
                    i6 = 0;
                } else {
                    i5 = round;
                    i6 = round;
                }
                int round2 = Math.round(-displayRect.top);
                if (i2 < displayRect.height()) {
                    i7 = Math.round(displayRect.height() - i2);
                    i8 = 0;
                } else {
                    i7 = round2;
                    i8 = round2;
                }
                this.mCurrentX = round;
                this.mCurrentY = round2;
                if (round != i5 || round2 != i7) {
                    this.mScroller.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            DraweeView<a> draweeView;
            if (!this.mScroller.isFinished() && (draweeView = Attacher.this.getDraweeView()) != null && this.mScroller.computeScrollOffset()) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                Attacher.this.mMatrix.postTranslate(this.mCurrentX - currX, this.mCurrentY - currY);
                draweeView.invalidate();
                this.mCurrentX = currX;
                this.mCurrentY = currY;
                Attacher.this.postOnAnimation(draweeView, this);
                if (Attacher.this.mOnScaleDragGestureListener != null) {
                    Attacher.this.mOnScaleDragGestureListener.onFling(currX, currY, currX, currY);
                }
            }
        }
    }

    private void cancelFling() {
        if (this.mCurrentFlingRunnable != null) {
            this.mCurrentFlingRunnable.cancelFling();
            this.mCurrentFlingRunnable = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnAnimation(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        cancelFling();
    }
}
