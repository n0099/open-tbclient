package com.baidu.searchbox.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ScrollerCompat;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class ViewDragHelper {
    public static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    public static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    public static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final String TAG = "ViewDragHelper";
    public static final Interpolator sInterpolator = new Interpolator() { // from class: com.baidu.searchbox.widget.ViewDragHelper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    public final Callback mCallback;
    public View mCapturedView;
    public int mDragState;
    public int[] mEdgeDragsInProgress;
    public int[] mEdgeDragsLocked;
    public int mEdgeSize;
    public int[] mInitialEdgesTouched;
    public float[] mInitialMotionX;
    public float[] mInitialMotionY;
    public float[] mLastMotionX;
    public float[] mLastMotionY;
    public float mMaxVelocity;
    public float mMinVelocity;
    public final ViewGroup mParentView;
    public int mPointersDown;
    public boolean mReleaseInProgress;
    public ScrollerCompat mScroller;
    public int mTouchSlop;
    public int mTrackingEdges;
    public VelocityTracker mVelocityTracker;
    public int mActivePointerId = -1;
    public final Runnable mSetIdleRunnable = new Runnable() { // from class: com.baidu.searchbox.widget.ViewDragHelper.2
        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.setDragState(0);
        }
    };

    /* loaded from: classes2.dex */
    public static abstract class Callback {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public abstract boolean isPageTranslucent();

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float f2, float f3) {
        }

        public abstract boolean tryCaptureView(View view, int i);
    }

    public ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (callback != null) {
            this.mParentView = viewGroup;
            this.mCallback = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.mEdgeSize = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.mMaxVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
            this.mMinVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
            this.mScroller = ScrollerCompat.create(context, sInterpolator);
            return;
        }
        throw new IllegalArgumentException("Callback may not be null");
    }

    private boolean checkNewEdgeDrag(float f2, float f3, int i, int i2) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.mInitialEdgesTouched[i] & i2) != i2 || (this.mTrackingEdges & i2) == 0 || (this.mEdgeDragsLocked[i] & i2) == i2 || (this.mEdgeDragsInProgress[i] & i2) == i2) {
            return false;
        }
        int i3 = this.mTouchSlop;
        if (abs > i3 || abs2 > i3) {
            if (abs >= abs2 * 0.5f || !this.mCallback.onEdgeLock(i2)) {
                return (this.mEdgeDragsInProgress[i] & i2) == 0 && abs > ((float) this.mTouchSlop);
            }
            int[] iArr = this.mEdgeDragsLocked;
            iArr[i] = iArr[i] | i2;
            return false;
        }
        return false;
    }

    private boolean checkTouchSlop(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z = this.mCallback.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.mCallback.getViewVerticalDragRange(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f2) > ((float) this.mTouchSlop) : z2 && Math.abs(f3) > ((float) this.mTouchSlop);
        }
        int i = this.mTouchSlop;
        return (f2 * f2) + (f3 * f3) > ((float) (i * i));
    }

    private int clampMag(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        return abs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    private void clearMotionHistory() {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.mInitialMotionY, 0.0f);
        Arrays.fill(this.mLastMotionX, 0.0f);
        Arrays.fill(this.mLastMotionY, 0.0f);
        Arrays.fill(this.mInitialEdgesTouched, 0);
        Arrays.fill(this.mEdgeDragsInProgress, 0);
        Arrays.fill(this.mEdgeDragsLocked, 0);
        this.mPointersDown = 0;
    }

    private int computeAxisDuration(int i, int i2, int i3) {
        int abs;
        if (i == 0) {
            return 0;
        }
        int width = this.mParentView.getWidth();
        float f2 = width / 2;
        float distanceInfluenceForSnapDuration = f2 + (distanceInfluenceForSnapDuration(Math.min(1.0f, Math.abs(i) / width)) * f2);
        int abs2 = Math.abs(i2);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(distanceInfluenceForSnapDuration / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    private int computeSettleDuration(View view, int i, int i2, int i3, int i4) {
        float f2;
        float f3;
        float f4;
        float f5;
        int clampMag = clampMag(i3, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int clampMag2 = clampMag(i4, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(clampMag);
        int abs4 = Math.abs(clampMag2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        if (clampMag != 0) {
            f2 = abs3;
            f3 = i5;
        } else {
            f2 = abs;
            f3 = i6;
        }
        float f6 = f2 / f3;
        if (clampMag2 != 0) {
            f4 = abs4;
            f5 = i5;
        } else {
            f4 = abs2;
            f5 = i6;
        }
        return (int) ((computeAxisDuration(i, clampMag, this.mCallback.getViewHorizontalDragRange(view)) * f6) + (computeAxisDuration(i2, clampMag2, this.mCallback.getViewVerticalDragRange(view)) * (f4 / f5)));
    }

    public static ViewDragHelper create(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private void dispatchViewReleased(float f2, float f3) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, f2, f3);
        this.mReleaseInProgress = false;
        if (this.mDragState == 1) {
            setDragState(0);
        }
    }

    private float distanceInfluenceForSnapDuration(float f2) {
        return (float) Math.sin((float) ((f2 - 0.5f) * 0.4712389167638204d));
    }

    private void dragTo(int i, int i2, int i3, int i4) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        if (i3 != 0) {
            i = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, i, i3);
            if (this.mCallback.isPageTranslucent()) {
                this.mCapturedView.offsetLeftAndRight(i - left);
            }
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.mCallback.clampViewPositionVertical(this.mCapturedView, i2, i4);
            this.mCapturedView.offsetTopAndBottom(i2 - top);
        }
        int i6 = i2;
        if (i3 == 0 && i4 == 0) {
            return;
        }
        int i7 = i5 - left;
        int i8 = i6 - top;
        if (this.mCallback.isPageTranslucent()) {
            this.mCallback.onViewPositionChanged(this.mCapturedView, i5, i6, i7, i8);
        }
    }

    private void ensureMotionHistorySizeForId(int i) {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            float[] fArr6 = this.mInitialMotionX;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.mInitialMotionY;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.mLastMotionX;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.mLastMotionY;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.mInitialEdgesTouched;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.mEdgeDragsInProgress;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.mEdgeDragsLocked;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.mInitialMotionX = fArr2;
            this.mInitialMotionY = fArr3;
            this.mLastMotionX = fArr4;
            this.mLastMotionY = fArr5;
            this.mInitialEdgesTouched = iArr;
            this.mEdgeDragsInProgress = iArr2;
            this.mEdgeDragsLocked = iArr3;
        }
    }

    private boolean forceSettleCapturedViewAt(int i, int i2, int i3, int i4) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.mScroller.abortAnimation();
            setDragState(0);
            return false;
        }
        this.mScroller.startScroll(left, top, i5, i6, computeSettleDuration(this.mCapturedView, i5, i6, i3, i4));
        setDragState(2);
        return true;
    }

    private int getEdgesTouched(int i, int i2) {
        int i3 = i < this.mParentView.getLeft() + this.mEdgeSize ? 1 : 0;
        if (i2 < this.mParentView.getTop() + this.mEdgeSize) {
            i3 |= 4;
        }
        if (i > this.mParentView.getRight() - this.mEdgeSize) {
            i3 |= 2;
        }
        return i2 > this.mParentView.getBottom() - this.mEdgeSize ? i3 | 8 : i3;
    }

    private float getMotionEventX(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getX(motionEvent, findPointerIndex);
    }

    private float getMotionEventY(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, findPointerIndex);
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        dispatchViewReleased(clampMag(VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    private void reportNewEdgeDrags(float f2, float f3, int i) {
        int i2 = checkNewEdgeDrag(f2, f3, i, 1) ? 1 : 0;
        if (checkNewEdgeDrag(f3, f2, i, 4)) {
            i2 |= 4;
        }
        if (checkNewEdgeDrag(f2, f3, i, 2)) {
            i2 |= 2;
        }
        if (checkNewEdgeDrag(f3, f2, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.mEdgeDragsInProgress;
            iArr[i] = iArr[i] | i2;
            this.mCallback.onEdgeDragStarted(i2, i);
        }
    }

    private void saveInitialMotion(float f2, float f3, int i) {
        ensureMotionHistorySizeForId(i);
        float[] fArr = this.mInitialMotionX;
        this.mLastMotionX[i] = f2;
        fArr[i] = f2;
        float[] fArr2 = this.mInitialMotionY;
        this.mLastMotionY[i] = f3;
        fArr2[i] = f3;
        this.mInitialEdgesTouched[i] = getEdgesTouched((int) f2, (int) f3);
        this.mPointersDown |= 1 << i;
    }

    private void saveLastMotion(MotionEvent motionEvent) {
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, i);
            float motionEventX = getMotionEventX(motionEvent, i);
            float motionEventY = getMotionEventY(motionEvent, i);
            if (motionEventX == -1.0f || motionEventY == -1.0f) {
                return;
            }
            this.mLastMotionX[pointerId] = motionEventX;
            this.mLastMotionY[pointerId] = motionEventY;
        }
    }

    public void abort() {
        cancel();
        if (this.mDragState == 2) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int currX2 = this.mScroller.getCurrX();
            int currY2 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        setDragState(0);
    }

    public boolean canScroll(View view, boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && canScroll(childAt, true, i, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && (ViewCompat.canScrollHorizontally(view, -i) || ViewCompat.canScrollVertically(view, -i2));
    }

    public void cancel() {
        this.mActivePointerId = -1;
        clearMotionHistory();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void captureChildView(View view, int i) {
        if (view.getParent() == this.mParentView) {
            this.mCapturedView = view;
            this.mActivePointerId = i;
            this.mCallback.onViewCaptured(view, i);
            setDragState(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + SmallTailInfo.EMOTION_SUFFIX);
    }

    public boolean continueSettling(boolean z) {
        if (this.mDragState == 2) {
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            int left = currX - this.mCapturedView.getLeft();
            int top = currY - this.mCapturedView.getTop();
            if (left != 0) {
                this.mCapturedView.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.mCapturedView.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.mScroller.getFinalX() && currY == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.mParentView.post(this.mSetIdleRunnable);
                } else {
                    setDragState(0);
                }
            }
        }
        return this.mDragState == 2;
    }

    public View findTopChildUnder(int i, int i2) {
        for (int childCount = this.mParentView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i, int i2, int i3, int i4) {
        if (this.mReleaseInProgress) {
            this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int) VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), i, i3, i2, i4);
            setDragState(2);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    public View getCapturedView() {
        return this.mCapturedView;
    }

    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int i, int i2) {
        return isViewUnder(this.mCapturedView, i, i2);
    }

    public boolean isEdgeTouched(int i) {
        int length = this.mInitialEdgesTouched.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (isEdgeTouched(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointerDown(int i) {
        return ((1 << i) & this.mPointersDown) != 0;
    }

    public boolean isViewUnder(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0077, code lost:
        if (r11 != (-1)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0079, code lost:
        releaseViewForPointerUp();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void processTouchEvent(MotionEvent motionEvent) {
        int i;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            View findTopChildUnder = findTopChildUnder((int) x, (int) y);
            saveInitialMotion(x, y, pointerId);
            tryCaptureViewForDrag(findTopChildUnder, pointerId);
            int i3 = this.mInitialEdgesTouched[pointerId];
            int i4 = this.mTrackingEdges;
            if ((i3 & i4) != 0) {
                this.mCallback.onEdgeTouched(i3 & i4, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.mDragState == 1) {
                releaseViewForPointerUp();
            }
            cancel();
        } else if (actionMasked == 2) {
            if (this.mDragState == 1) {
                int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
                float motionEventX = getMotionEventX(motionEvent, findPointerIndex);
                float motionEventY = getMotionEventY(motionEvent, findPointerIndex);
                if (motionEventX == -1.0f || motionEventY == -1.0f) {
                    return;
                }
                float[] fArr = this.mLastMotionX;
                int i5 = this.mActivePointerId;
                int i6 = (int) (motionEventX - fArr[i5]);
                int i7 = (int) (motionEventY - this.mLastMotionY[i5]);
                dragTo(this.mCapturedView.getLeft() + i6, this.mCapturedView.getTop() + i7, i6, i7);
                saveLastMotion(motionEvent);
                return;
            }
            int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
            while (i2 < pointerCount) {
                int pointerId2 = MotionEventCompat.getPointerId(motionEvent, i2);
                float motionEventX2 = getMotionEventX(motionEvent, i2);
                float motionEventY2 = getMotionEventY(motionEvent, i2);
                if (motionEventX2 != -1.0f && motionEventY2 != -1.0f) {
                    float f2 = motionEventX2 - this.mInitialMotionX[pointerId2];
                    float f3 = motionEventY2 - this.mInitialMotionY[pointerId2];
                    reportNewEdgeDrags(f2, f3, pointerId2);
                    if (this.mDragState != 1) {
                        View findTopChildUnder2 = findTopChildUnder((int) motionEventX2, (int) motionEventY2);
                        if (checkTouchSlop(findTopChildUnder2, f2, f3) && tryCaptureViewForDrag(findTopChildUnder2, pointerId2)) {
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                } else {
                    return;
                }
            }
            saveLastMotion(motionEvent);
        } else if (actionMasked == 3) {
            if (this.mDragState == 1) {
                dispatchViewReleased(0.0f, 0.0f);
            }
            cancel();
        } else if (actionMasked == 5) {
            int pointerId3 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            float motionEventX3 = getMotionEventX(motionEvent, actionIndex);
            float motionEventY3 = getMotionEventY(motionEvent, actionIndex);
            if (motionEventX3 == -1.0f || motionEventY3 == -1.0f) {
                return;
            }
            saveInitialMotion(motionEventX3, motionEventY3, pointerId3);
            if (this.mDragState == 0) {
                tryCaptureViewForDrag(findTopChildUnder((int) motionEventX3, (int) motionEventY3), pointerId3);
                int i8 = this.mInitialEdgesTouched[pointerId3];
                int i9 = this.mTrackingEdges;
                if ((i8 & i9) != 0) {
                    this.mCallback.onEdgeTouched(i8 & i9, pointerId3);
                }
            } else if (isCapturedViewUnder((int) motionEventX3, (int) motionEventY3)) {
                tryCaptureViewForDrag(this.mCapturedView, pointerId3);
            }
        } else if (actionMasked != 6) {
        } else {
            int pointerId4 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            if (this.mDragState == 1 && pointerId4 == this.mActivePointerId) {
                int pointerCount2 = MotionEventCompat.getPointerCount(motionEvent);
                while (true) {
                    if (i2 >= pointerCount2) {
                        i = -1;
                        break;
                    }
                    int pointerId5 = MotionEventCompat.getPointerId(motionEvent, i2);
                    if (pointerId5 != this.mActivePointerId) {
                        float motionEventX4 = getMotionEventX(motionEvent, i2);
                        float motionEventY4 = getMotionEventY(motionEvent, i2);
                        if (motionEventX4 != -1.0f && motionEventY4 != -1.0f) {
                            View findTopChildUnder3 = findTopChildUnder((int) motionEventX4, (int) motionEventY4);
                            View view = this.mCapturedView;
                            if (findTopChildUnder3 == view && tryCaptureViewForDrag(view, pointerId5)) {
                                i = this.mActivePointerId;
                                break;
                            }
                        } else {
                            return;
                        }
                    }
                    i2++;
                }
            }
            clearMotionHistory(pointerId4);
        }
    }

    public void setDragState(int i) {
        if (this.mDragState != i) {
            this.mDragState = i;
            this.mCallback.onViewDragStateChanged(i);
            if (this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public void setEdgeTrackingEnabled(int i) {
        this.mTrackingEdges = i;
    }

    public void setMinVelocity(float f2) {
        this.mMinVelocity = f2;
    }

    public boolean settleCapturedViewAt(int i, int i2) {
        if (this.mReleaseInProgress) {
            return forceSettleCapturedViewAt(i, i2, (int) VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int) VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e5, code lost:
        if (r13 != r12) goto L62;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldInterceptTouchEvent(MotionEvent motionEvent) {
        View findTopChildUnder;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        boolean z = false;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                float f2 = -1.0f;
                if (actionMasked == 2) {
                    int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
                    int i = 0;
                    while (i < pointerCount) {
                        int pointerId = MotionEventCompat.getPointerId(motionEvent, i);
                        float motionEventX = getMotionEventX(motionEvent, i);
                        float motionEventY = getMotionEventY(motionEvent, i);
                        if (motionEventX != f2 && motionEventY != f2) {
                            float f3 = motionEventX - this.mInitialMotionX[pointerId];
                            float f4 = motionEventY - this.mInitialMotionY[pointerId];
                            View findTopChildUnder2 = findTopChildUnder((int) motionEventX, (int) motionEventY);
                            boolean z2 = findTopChildUnder2 != null && checkTouchSlop(findTopChildUnder2, f3, f4);
                            if (z2) {
                                int left = findTopChildUnder2.getLeft();
                                int i2 = (int) f3;
                                int clampViewPositionHorizontal = this.mCallback.clampViewPositionHorizontal(findTopChildUnder2, left + i2, i2);
                                int top = findTopChildUnder2.getTop();
                                int i3 = (int) f4;
                                int clampViewPositionVertical = this.mCallback.clampViewPositionVertical(findTopChildUnder2, top + i3, i3);
                                int viewHorizontalDragRange = this.mCallback.getViewHorizontalDragRange(findTopChildUnder2);
                                int viewVerticalDragRange = this.mCallback.getViewVerticalDragRange(findTopChildUnder2);
                                if (viewHorizontalDragRange != 0) {
                                    if (viewHorizontalDragRange > 0) {
                                    }
                                }
                                if (viewVerticalDragRange != 0) {
                                    if (viewVerticalDragRange > 0 && clampViewPositionVertical == top) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            reportNewEdgeDrags(f3, f4, pointerId);
                            if (this.mDragState == 1 || (z2 && tryCaptureViewForDrag(findTopChildUnder2, pointerId))) {
                                break;
                            }
                            i++;
                            z = false;
                            f2 = -1.0f;
                        } else {
                            return z;
                        }
                    }
                    saveLastMotion(motionEvent);
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        int pointerId2 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                        float motionEventX2 = getMotionEventX(motionEvent, actionIndex);
                        float motionEventY2 = getMotionEventY(motionEvent, actionIndex);
                        if (motionEventX2 == -1.0f || motionEventY2 == -1.0f) {
                            return false;
                        }
                        saveInitialMotion(motionEventX2, motionEventY2, pointerId2);
                        int i4 = this.mDragState;
                        if (i4 == 0) {
                            int i5 = this.mInitialEdgesTouched[pointerId2];
                            int i6 = this.mTrackingEdges;
                            if ((i5 & i6) != 0) {
                                this.mCallback.onEdgeTouched(i5 & i6, pointerId2);
                            }
                        } else if (i4 == 2 && (findTopChildUnder = findTopChildUnder((int) motionEventX2, (int) motionEventY2)) == this.mCapturedView) {
                            tryCaptureViewForDrag(findTopChildUnder, pointerId2);
                        }
                    } else if (actionMasked == 6) {
                        clearMotionHistory(MotionEventCompat.getPointerId(motionEvent, actionIndex));
                    }
                }
            }
            cancel();
        } else {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId3 = MotionEventCompat.getPointerId(motionEvent, 0);
            saveInitialMotion(x, y, pointerId3);
            View findTopChildUnder3 = findTopChildUnder((int) x, (int) y);
            if (findTopChildUnder3 == this.mCapturedView && this.mDragState == 2) {
                tryCaptureViewForDrag(findTopChildUnder3, pointerId3);
            }
            int i7 = this.mInitialEdgesTouched[pointerId3];
            int i8 = this.mTrackingEdges;
            if ((i7 & i8) != 0) {
                this.mCallback.onEdgeTouched(i7 & i8, pointerId3);
            }
        }
        return this.mDragState == 1;
    }

    public boolean smoothSlideViewTo(View view, int i, int i2) {
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        boolean forceSettleCapturedViewAt = forceSettleCapturedViewAt(i, i2, 0, 0);
        if (!forceSettleCapturedViewAt && this.mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }
        return forceSettleCapturedViewAt;
    }

    public boolean tryCaptureViewForDrag(View view, int i) {
        if (view == this.mCapturedView && this.mActivePointerId == i) {
            return true;
        }
        if (view == null || !this.mCallback.tryCaptureView(view, i)) {
            return false;
        }
        this.mActivePointerId = i;
        captureChildView(view, i);
        return true;
    }

    private float clampMag(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        return abs > f4 ? f2 > 0.0f ? f4 : -f4 : f2;
    }

    public static ViewDragHelper create(ViewGroup viewGroup, float f2, Callback callback) {
        ViewDragHelper create = create(viewGroup, callback);
        create.mTouchSlop = (int) (create.mTouchSlop * (1.0f / f2));
        return create;
    }

    public boolean isEdgeTouched(int i, int i2) {
        return isPointerDown(i2) && (i & this.mInitialEdgesTouched[i2]) != 0;
    }

    public boolean checkTouchSlop(int i) {
        int length = this.mInitialMotionX.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (checkTouchSlop(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int i, int i2) {
        if (isPointerDown(i2)) {
            boolean z = (i & 1) == 1;
            boolean z2 = (i & 2) == 2;
            float f2 = this.mLastMotionX[i2] - this.mInitialMotionX[i2];
            float f3 = this.mLastMotionY[i2] - this.mInitialMotionY[i2];
            if (!z || !z2) {
                return z ? Math.abs(f2) > ((float) this.mTouchSlop) : z2 && Math.abs(f3) > ((float) this.mTouchSlop);
            }
            int i3 = this.mTouchSlop;
            return (f2 * f2) + (f3 * f3) > ((float) (i3 * i3));
        }
        return false;
    }

    private void clearMotionHistory(int i) {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null) {
            return;
        }
        fArr[i] = 0.0f;
        this.mInitialMotionY[i] = 0.0f;
        this.mLastMotionX[i] = 0.0f;
        this.mLastMotionY[i] = 0.0f;
        this.mInitialEdgesTouched[i] = 0;
        this.mEdgeDragsInProgress[i] = 0;
        this.mEdgeDragsLocked[i] = 0;
        this.mPointersDown = (~(1 << i)) & this.mPointersDown;
    }
}
