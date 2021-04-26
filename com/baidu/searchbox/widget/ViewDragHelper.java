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
        public int clampViewPositionHorizontal(View view, int i2, int i3) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i2, int i3) {
            return 0;
        }

        public int getOrderedChildIndex(int i2) {
            return i2;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public abstract boolean isPageTranslucent();

        public void onEdgeDragStarted(int i2, int i3) {
        }

        public boolean onEdgeLock(int i2) {
            return false;
        }

        public void onEdgeTouched(int i2, int i3) {
        }

        public void onViewCaptured(View view, int i2) {
        }

        public void onViewDragStateChanged(int i2) {
        }

        public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
        }

        public void onViewReleased(View view, float f2, float f3) {
        }

        public abstract boolean tryCaptureView(View view, int i2);
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

    private boolean checkNewEdgeDrag(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.mInitialEdgesTouched[i2] & i3) != i3 || (this.mTrackingEdges & i3) == 0 || (this.mEdgeDragsLocked[i2] & i3) == i3 || (this.mEdgeDragsInProgress[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.mTouchSlop;
        if (abs > i4 || abs2 > i4) {
            if (abs >= abs2 * 0.5f || !this.mCallback.onEdgeLock(i3)) {
                return (this.mEdgeDragsInProgress[i2] & i3) == 0 && abs > ((float) this.mTouchSlop);
            }
            int[] iArr = this.mEdgeDragsLocked;
            iArr[i2] = iArr[i2] | i3;
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
        int i2 = this.mTouchSlop;
        return (f2 * f2) + (f3 * f3) > ((float) (i2 * i2));
    }

    private int clampMag(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        return abs > i4 ? i2 > 0 ? i4 : -i4 : i2;
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

    private int computeAxisDuration(int i2, int i3, int i4) {
        int abs;
        if (i2 == 0) {
            return 0;
        }
        int width = this.mParentView.getWidth();
        float f2 = width / 2;
        float distanceInfluenceForSnapDuration = f2 + (distanceInfluenceForSnapDuration(Math.min(1.0f, Math.abs(i2) / width)) * f2);
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(distanceInfluenceForSnapDuration / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i2) / i4) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    private int computeSettleDuration(View view, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int clampMag = clampMag(i4, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int clampMag2 = clampMag(i5, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int abs = Math.abs(i2);
        int abs2 = Math.abs(i3);
        int abs3 = Math.abs(clampMag);
        int abs4 = Math.abs(clampMag2);
        int i6 = abs3 + abs4;
        int i7 = abs + abs2;
        if (clampMag != 0) {
            f2 = abs3;
            f3 = i6;
        } else {
            f2 = abs;
            f3 = i7;
        }
        float f6 = f2 / f3;
        if (clampMag2 != 0) {
            f4 = abs4;
            f5 = i6;
        } else {
            f4 = abs2;
            f5 = i7;
        }
        return (int) ((computeAxisDuration(i2, clampMag, this.mCallback.getViewHorizontalDragRange(view)) * f6) + (computeAxisDuration(i3, clampMag2, this.mCallback.getViewVerticalDragRange(view)) * (f4 / f5)));
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

    private void dragTo(int i2, int i3, int i4, int i5) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        if (i4 != 0) {
            i2 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, i2, i4);
            if (this.mCallback.isPageTranslucent()) {
                this.mCapturedView.offsetLeftAndRight(i2 - left);
            }
        }
        int i6 = i2;
        if (i5 != 0) {
            i3 = this.mCallback.clampViewPositionVertical(this.mCapturedView, i3, i5);
            this.mCapturedView.offsetTopAndBottom(i3 - top);
        }
        int i7 = i3;
        if (i4 == 0 && i5 == 0) {
            return;
        }
        int i8 = i6 - left;
        int i9 = i7 - top;
        if (this.mCallback.isPageTranslucent()) {
            this.mCallback.onViewPositionChanged(this.mCapturedView, i6, i7, i8, i9);
        }
    }

    private void ensureMotionHistorySizeForId(int i2) {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null || fArr.length <= i2) {
            int i3 = i2 + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
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

    private boolean forceSettleCapturedViewAt(int i2, int i3, int i4, int i5) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.mScroller.abortAnimation();
            setDragState(0);
            return false;
        }
        this.mScroller.startScroll(left, top, i6, i7, computeSettleDuration(this.mCapturedView, i6, i7, i4, i5));
        setDragState(2);
        return true;
    }

    private int getEdgesTouched(int i2, int i3) {
        int i4 = i2 < this.mParentView.getLeft() + this.mEdgeSize ? 1 : 0;
        if (i3 < this.mParentView.getTop() + this.mEdgeSize) {
            i4 |= 4;
        }
        if (i2 > this.mParentView.getRight() - this.mEdgeSize) {
            i4 |= 2;
        }
        return i3 > this.mParentView.getBottom() - this.mEdgeSize ? i4 | 8 : i4;
    }

    private float getMotionEventX(MotionEvent motionEvent, int i2) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getX(motionEvent, findPointerIndex);
    }

    private float getMotionEventY(MotionEvent motionEvent, int i2) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, findPointerIndex);
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        dispatchViewReleased(clampMag(VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    private void reportNewEdgeDrags(float f2, float f3, int i2) {
        int i3 = checkNewEdgeDrag(f2, f3, i2, 1) ? 1 : 0;
        if (checkNewEdgeDrag(f3, f2, i2, 4)) {
            i3 |= 4;
        }
        if (checkNewEdgeDrag(f2, f3, i2, 2)) {
            i3 |= 2;
        }
        if (checkNewEdgeDrag(f3, f2, i2, 8)) {
            i3 |= 8;
        }
        if (i3 != 0) {
            int[] iArr = this.mEdgeDragsInProgress;
            iArr[i2] = iArr[i2] | i3;
            this.mCallback.onEdgeDragStarted(i3, i2);
        }
    }

    private void saveInitialMotion(float f2, float f3, int i2) {
        ensureMotionHistorySizeForId(i2);
        float[] fArr = this.mInitialMotionX;
        this.mLastMotionX[i2] = f2;
        fArr[i2] = f2;
        float[] fArr2 = this.mInitialMotionY;
        this.mLastMotionY[i2] = f3;
        fArr2[i2] = f3;
        this.mInitialEdgesTouched[i2] = getEdgesTouched((int) f2, (int) f3);
        this.mPointersDown |= 1 << i2;
    }

    private void saveLastMotion(MotionEvent motionEvent) {
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, i2);
            float motionEventX = getMotionEventX(motionEvent, i2);
            float motionEventY = getMotionEventY(motionEvent, i2);
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

    public boolean canScroll(View view, boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i7 = i4 + scrollX;
                if (i7 >= childAt.getLeft() && i7 < childAt.getRight() && (i6 = i5 + scrollY) >= childAt.getTop() && i6 < childAt.getBottom() && canScroll(childAt, true, i2, i3, i7 - childAt.getLeft(), i6 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && (ViewCompat.canScrollHorizontally(view, -i2) || ViewCompat.canScrollVertically(view, -i3));
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

    public void captureChildView(View view, int i2) {
        if (view.getParent() == this.mParentView) {
            this.mCapturedView = view;
            this.mActivePointerId = i2;
            this.mCallback.onViewCaptured(view, i2);
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

    public View findTopChildUnder(int i2, int i3) {
        for (int childCount = this.mParentView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(childCount));
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i2, int i3, int i4, int i5) {
        if (this.mReleaseInProgress) {
            this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int) VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), i2, i4, i3, i5);
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

    public boolean isCapturedViewUnder(int i2, int i3) {
        return isViewUnder(this.mCapturedView, i2, i3);
    }

    public boolean isEdgeTouched(int i2) {
        int length = this.mInitialEdgesTouched.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (isEdgeTouched(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointerDown(int i2) {
        return ((1 << i2) & this.mPointersDown) != 0;
    }

    public boolean isViewUnder(View view, int i2, int i3) {
        return view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom();
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
        int i2;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            View findTopChildUnder = findTopChildUnder((int) x, (int) y);
            saveInitialMotion(x, y, pointerId);
            tryCaptureViewForDrag(findTopChildUnder, pointerId);
            int i4 = this.mInitialEdgesTouched[pointerId];
            int i5 = this.mTrackingEdges;
            if ((i4 & i5) != 0) {
                this.mCallback.onEdgeTouched(i4 & i5, pointerId);
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
                int i6 = this.mActivePointerId;
                int i7 = (int) (motionEventX - fArr[i6]);
                int i8 = (int) (motionEventY - this.mLastMotionY[i6]);
                dragTo(this.mCapturedView.getLeft() + i7, this.mCapturedView.getTop() + i8, i7, i8);
                saveLastMotion(motionEvent);
                return;
            }
            int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
            while (i3 < pointerCount) {
                int pointerId2 = MotionEventCompat.getPointerId(motionEvent, i3);
                float motionEventX2 = getMotionEventX(motionEvent, i3);
                float motionEventY2 = getMotionEventY(motionEvent, i3);
                if (motionEventX2 != -1.0f && motionEventY2 != -1.0f) {
                    float f2 = motionEventX2 - this.mInitialMotionX[pointerId2];
                    float f3 = motionEventY2 - this.mInitialMotionY[pointerId2];
                    reportNewEdgeDrags(f2, f3, pointerId2);
                    if (this.mDragState != 1) {
                        View findTopChildUnder2 = findTopChildUnder((int) motionEventX2, (int) motionEventY2);
                        if (checkTouchSlop(findTopChildUnder2, f2, f3) && tryCaptureViewForDrag(findTopChildUnder2, pointerId2)) {
                            break;
                        }
                        i3++;
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
                int i9 = this.mInitialEdgesTouched[pointerId3];
                int i10 = this.mTrackingEdges;
                if ((i9 & i10) != 0) {
                    this.mCallback.onEdgeTouched(i9 & i10, pointerId3);
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
                    if (i3 >= pointerCount2) {
                        i2 = -1;
                        break;
                    }
                    int pointerId5 = MotionEventCompat.getPointerId(motionEvent, i3);
                    if (pointerId5 != this.mActivePointerId) {
                        float motionEventX4 = getMotionEventX(motionEvent, i3);
                        float motionEventY4 = getMotionEventY(motionEvent, i3);
                        if (motionEventX4 != -1.0f && motionEventY4 != -1.0f) {
                            View findTopChildUnder3 = findTopChildUnder((int) motionEventX4, (int) motionEventY4);
                            View view = this.mCapturedView;
                            if (findTopChildUnder3 == view && tryCaptureViewForDrag(view, pointerId5)) {
                                i2 = this.mActivePointerId;
                                break;
                            }
                        } else {
                            return;
                        }
                    }
                    i3++;
                }
            }
            clearMotionHistory(pointerId4);
        }
    }

    public void setDragState(int i2) {
        if (this.mDragState != i2) {
            this.mDragState = i2;
            this.mCallback.onViewDragStateChanged(i2);
            if (this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public void setEdgeTrackingEnabled(int i2) {
        this.mTrackingEdges = i2;
    }

    public void setMinVelocity(float f2) {
        this.mMinVelocity = f2;
    }

    public boolean settleCapturedViewAt(int i2, int i3) {
        if (this.mReleaseInProgress) {
            return forceSettleCapturedViewAt(i2, i3, (int) VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int) VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId));
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
                    int i2 = 0;
                    while (i2 < pointerCount) {
                        int pointerId = MotionEventCompat.getPointerId(motionEvent, i2);
                        float motionEventX = getMotionEventX(motionEvent, i2);
                        float motionEventY = getMotionEventY(motionEvent, i2);
                        if (motionEventX != f2 && motionEventY != f2) {
                            float f3 = motionEventX - this.mInitialMotionX[pointerId];
                            float f4 = motionEventY - this.mInitialMotionY[pointerId];
                            View findTopChildUnder2 = findTopChildUnder((int) motionEventX, (int) motionEventY);
                            boolean z2 = findTopChildUnder2 != null && checkTouchSlop(findTopChildUnder2, f3, f4);
                            if (z2) {
                                int left = findTopChildUnder2.getLeft();
                                int i3 = (int) f3;
                                int clampViewPositionHorizontal = this.mCallback.clampViewPositionHorizontal(findTopChildUnder2, left + i3, i3);
                                int top = findTopChildUnder2.getTop();
                                int i4 = (int) f4;
                                int clampViewPositionVertical = this.mCallback.clampViewPositionVertical(findTopChildUnder2, top + i4, i4);
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
                            i2++;
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
                        int i5 = this.mDragState;
                        if (i5 == 0) {
                            int i6 = this.mInitialEdgesTouched[pointerId2];
                            int i7 = this.mTrackingEdges;
                            if ((i6 & i7) != 0) {
                                this.mCallback.onEdgeTouched(i6 & i7, pointerId2);
                            }
                        } else if (i5 == 2 && (findTopChildUnder = findTopChildUnder((int) motionEventX2, (int) motionEventY2)) == this.mCapturedView) {
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
            int i8 = this.mInitialEdgesTouched[pointerId3];
            int i9 = this.mTrackingEdges;
            if ((i8 & i9) != 0) {
                this.mCallback.onEdgeTouched(i8 & i9, pointerId3);
            }
        }
        return this.mDragState == 1;
    }

    public boolean smoothSlideViewTo(View view, int i2, int i3) {
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        boolean forceSettleCapturedViewAt = forceSettleCapturedViewAt(i2, i3, 0, 0);
        if (!forceSettleCapturedViewAt && this.mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }
        return forceSettleCapturedViewAt;
    }

    public boolean tryCaptureViewForDrag(View view, int i2) {
        if (view == this.mCapturedView && this.mActivePointerId == i2) {
            return true;
        }
        if (view == null || !this.mCallback.tryCaptureView(view, i2)) {
            return false;
        }
        this.mActivePointerId = i2;
        captureChildView(view, i2);
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

    public boolean isEdgeTouched(int i2, int i3) {
        return isPointerDown(i3) && (i2 & this.mInitialEdgesTouched[i3]) != 0;
    }

    public boolean checkTouchSlop(int i2) {
        int length = this.mInitialMotionX.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (checkTouchSlop(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int i2, int i3) {
        if (isPointerDown(i3)) {
            boolean z = (i2 & 1) == 1;
            boolean z2 = (i2 & 2) == 2;
            float f2 = this.mLastMotionX[i3] - this.mInitialMotionX[i3];
            float f3 = this.mLastMotionY[i3] - this.mInitialMotionY[i3];
            if (!z || !z2) {
                return z ? Math.abs(f2) > ((float) this.mTouchSlop) : z2 && Math.abs(f3) > ((float) this.mTouchSlop);
            }
            int i4 = this.mTouchSlop;
            return (f2 * f2) + (f3 * f3) > ((float) (i4 * i4));
        }
        return false;
    }

    private void clearMotionHistory(int i2) {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null) {
            return;
        }
        fArr[i2] = 0.0f;
        this.mInitialMotionY[i2] = 0.0f;
        this.mLastMotionX[i2] = 0.0f;
        this.mLastMotionY[i2] = 0.0f;
        this.mInitialEdgesTouched[i2] = 0;
        this.mEdgeDragsInProgress[i2] = 0;
        this.mEdgeDragsLocked[i2] = 0;
        this.mPointersDown = (~(1 << i2)) & this.mPointersDown;
    }
}
