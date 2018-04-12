package android.support.design.widget;

import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
/* loaded from: classes2.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    private boolean mInterceptingEvents;
    OnDismissListener mListener;
    private boolean mSensitivitySet;
    ViewDragHelper mViewDragHelper;
    private float mSensitivity = 0.0f;
    int mSwipeDirection = 2;
    float mDragDismissThreshold = 0.5f;
    float mAlphaStartSwipeDistance = 0.0f;
    float mAlphaEndSwipeDistance = 0.5f;
    private final ViewDragHelper.Callback mDragCallback = new ViewDragHelper.Callback() { // from class: android.support.design.widget.SwipeDismissBehavior.1
        private static final int INVALID_POINTER_ID = -1;
        private int mActivePointerId = -1;
        private int mOriginalCapturedViewLeft;

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view2, int i) {
            return this.mActivePointerId == -1 && SwipeDismissBehavior.this.canSwipeDismissView(view2);
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view2, int i) {
            this.mActivePointerId = i;
            this.mOriginalCapturedViewLeft = view2.getLeft();
            ViewParent parent = view2.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            if (SwipeDismissBehavior.this.mListener != null) {
                SwipeDismissBehavior.this.mListener.onDragStateChanged(i);
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewReleased(View view2, float f, float f2) {
            int i;
            this.mActivePointerId = -1;
            int width = view2.getWidth();
            boolean z = false;
            if (shouldDismiss(view2, f)) {
                i = view2.getLeft() < this.mOriginalCapturedViewLeft ? this.mOriginalCapturedViewLeft - width : this.mOriginalCapturedViewLeft + width;
                z = true;
            } else {
                i = this.mOriginalCapturedViewLeft;
            }
            if (SwipeDismissBehavior.this.mViewDragHelper.settleCapturedViewAt(i, view2.getTop())) {
                ViewCompat.postOnAnimation(view2, new SettleRunnable(view2, z));
            } else if (z && SwipeDismissBehavior.this.mListener != null) {
                SwipeDismissBehavior.this.mListener.onDismiss(view2);
            }
        }

        private boolean shouldDismiss(View view2, float f) {
            if (f == 0.0f) {
                return Math.abs(view2.getLeft() - this.mOriginalCapturedViewLeft) >= Math.round(((float) view2.getWidth()) * SwipeDismissBehavior.this.mDragDismissThreshold);
            }
            boolean z = ViewCompat.getLayoutDirection(view2) == 1;
            if (SwipeDismissBehavior.this.mSwipeDirection == 2) {
                return true;
            }
            if (SwipeDismissBehavior.this.mSwipeDirection == 0) {
                return z ? f < 0.0f : f > 0.0f;
            } else if (SwipeDismissBehavior.this.mSwipeDirection == 1) {
                return z ? f > 0.0f : f < 0.0f;
            } else {
                return false;
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view2) {
            return view2.getWidth();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view2, int i, int i2) {
            int width;
            int width2;
            boolean z = ViewCompat.getLayoutDirection(view2) == 1;
            if (SwipeDismissBehavior.this.mSwipeDirection == 0) {
                if (z) {
                    width = this.mOriginalCapturedViewLeft - view2.getWidth();
                    width2 = this.mOriginalCapturedViewLeft;
                } else {
                    width = this.mOriginalCapturedViewLeft;
                    width2 = this.mOriginalCapturedViewLeft + view2.getWidth();
                }
            } else if (SwipeDismissBehavior.this.mSwipeDirection == 1) {
                if (z) {
                    width = this.mOriginalCapturedViewLeft;
                    width2 = this.mOriginalCapturedViewLeft + view2.getWidth();
                } else {
                    width = this.mOriginalCapturedViewLeft - view2.getWidth();
                    width2 = this.mOriginalCapturedViewLeft;
                }
            } else {
                width = this.mOriginalCapturedViewLeft - view2.getWidth();
                width2 = this.mOriginalCapturedViewLeft + view2.getWidth();
            }
            return SwipeDismissBehavior.clamp(width, i, width2);
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view2, int i, int i2) {
            return view2.getTop();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view2, int i, int i2, int i3, int i4) {
            float width = this.mOriginalCapturedViewLeft + (view2.getWidth() * SwipeDismissBehavior.this.mAlphaStartSwipeDistance);
            float width2 = this.mOriginalCapturedViewLeft + (view2.getWidth() * SwipeDismissBehavior.this.mAlphaEndSwipeDistance);
            if (i <= width) {
                ViewCompat.setAlpha(view2, 1.0f);
            } else if (i >= width2) {
                ViewCompat.setAlpha(view2, 0.0f);
            } else {
                ViewCompat.setAlpha(view2, SwipeDismissBehavior.clamp(0.0f, 1.0f - SwipeDismissBehavior.fraction(width, width2, i), 1.0f));
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface OnDismissListener {
        void onDismiss(View view2);

        void onDragStateChanged(int i);
    }

    public void setListener(OnDismissListener onDismissListener) {
        this.mListener = onDismissListener;
    }

    public void setSwipeDirection(int i) {
        this.mSwipeDirection = i;
    }

    public void setDragDismissDistance(float f) {
        this.mDragDismissThreshold = clamp(0.0f, f, 1.0f);
    }

    public void setStartAlphaSwipeDistance(float f) {
        this.mAlphaStartSwipeDistance = clamp(0.0f, f, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float f) {
        this.mAlphaEndSwipeDistance = clamp(0.0f, f, 1.0f);
    }

    public void setSensitivity(float f) {
        this.mSensitivity = f;
        this.mSensitivitySet = true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.mInterceptingEvents;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.mInterceptingEvents = coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), (int) motionEvent.getY());
                z = this.mInterceptingEvents;
                break;
            case 1:
            case 3:
                this.mInterceptingEvents = false;
                break;
        }
        if (z) {
            ensureViewDragHelper(coordinatorLayout);
            return this.mViewDragHelper.shouldInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.mViewDragHelper != null) {
            this.mViewDragHelper.processTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean canSwipeDismissView(@NonNull View view2) {
        return true;
    }

    private void ensureViewDragHelper(ViewGroup viewGroup) {
        ViewDragHelper create;
        if (this.mViewDragHelper == null) {
            if (this.mSensitivitySet) {
                create = ViewDragHelper.create(viewGroup, this.mSensitivity, this.mDragCallback);
            } else {
                create = ViewDragHelper.create(viewGroup, this.mDragCallback);
            }
            this.mViewDragHelper = create;
        }
    }

    /* loaded from: classes2.dex */
    private class SettleRunnable implements Runnable {
        private final boolean mDismiss;
        private final View mView;

        SettleRunnable(View view2, boolean z) {
            this.mView = view2;
            this.mDismiss = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwipeDismissBehavior.this.mViewDragHelper != null && SwipeDismissBehavior.this.mViewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.mView, this);
            } else if (this.mDismiss && SwipeDismissBehavior.this.mListener != null) {
                SwipeDismissBehavior.this.mListener.onDismiss(this.mView);
            }
        }
    }

    static float clamp(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    static int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    public int getDragState() {
        if (this.mViewDragHelper != null) {
            return this.mViewDragHelper.getViewDragState();
        }
        return 0;
    }

    static float fraction(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }
}
