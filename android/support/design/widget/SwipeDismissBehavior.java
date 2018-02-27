package android.support.design.widget;

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
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    ViewDragHelper lt;
    OnDismissListener qn;
    private boolean qo;
    private boolean qq;
    private float qp = 0.0f;
    int qr = 2;
    float qs = 0.5f;
    float qt = 0.0f;
    float qu = 0.5f;
    private final ViewDragHelper.Callback lE = new ViewDragHelper.Callback() { // from class: android.support.design.widget.SwipeDismissBehavior.1
        private int mActivePointerId = -1;
        private int qv;

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            return this.mActivePointerId == -1 && SwipeDismissBehavior.this.canSwipeDismissView(view);
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i) {
            this.mActivePointerId = i;
            this.qv = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            if (SwipeDismissBehavior.this.qn != null) {
                SwipeDismissBehavior.this.qn.onDragStateChanged(i);
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            int i;
            this.mActivePointerId = -1;
            int width = view.getWidth();
            boolean z = false;
            if (n(view, f)) {
                i = view.getLeft() < this.qv ? this.qv - width : this.qv + width;
                z = true;
            } else {
                i = this.qv;
            }
            if (SwipeDismissBehavior.this.lt.settleCapturedViewAt(i, view.getTop())) {
                ViewCompat.postOnAnimation(view, new a(view, z));
            } else if (z && SwipeDismissBehavior.this.qn != null) {
                SwipeDismissBehavior.this.qn.onDismiss(view);
            }
        }

        private boolean n(View view, float f) {
            if (f == 0.0f) {
                return Math.abs(view.getLeft() - this.qv) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.qs);
            }
            boolean z = ViewCompat.getLayoutDirection(view) == 1;
            if (SwipeDismissBehavior.this.qr == 2) {
                return true;
            }
            if (SwipeDismissBehavior.this.qr == 0) {
                return z ? f < 0.0f : f > 0.0f;
            } else if (SwipeDismissBehavior.this.qr == 1) {
                return z ? f > 0.0f : f < 0.0f;
            } else {
                return false;
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            int width;
            int width2;
            boolean z = ViewCompat.getLayoutDirection(view) == 1;
            if (SwipeDismissBehavior.this.qr == 0) {
                if (z) {
                    width = this.qv - view.getWidth();
                    width2 = this.qv;
                } else {
                    width = this.qv;
                    width2 = this.qv + view.getWidth();
                }
            } else if (SwipeDismissBehavior.this.qr == 1) {
                if (z) {
                    width = this.qv;
                    width2 = this.qv + view.getWidth();
                } else {
                    width = this.qv - view.getWidth();
                    width2 = this.qv;
                }
            } else {
                width = this.qv - view.getWidth();
                width2 = this.qv + view.getWidth();
            }
            return SwipeDismissBehavior.clamp(width, i, width2);
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            float width = this.qv + (view.getWidth() * SwipeDismissBehavior.this.qt);
            float width2 = this.qv + (view.getWidth() * SwipeDismissBehavior.this.qu);
            if (i <= width) {
                ViewCompat.setAlpha(view, 1.0f);
            } else if (i >= width2) {
                ViewCompat.setAlpha(view, 0.0f);
            } else {
                ViewCompat.setAlpha(view, SwipeDismissBehavior.c(0.0f, 1.0f - SwipeDismissBehavior.d(width, width2, i), 1.0f));
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface OnDismissListener {
        void onDismiss(View view);

        void onDragStateChanged(int i);
    }

    public void setListener(OnDismissListener onDismissListener) {
        this.qn = onDismissListener;
    }

    public void setSwipeDirection(int i) {
        this.qr = i;
    }

    public void setDragDismissDistance(float f) {
        this.qs = c(0.0f, f, 1.0f);
    }

    public void setStartAlphaSwipeDistance(float f) {
        this.qt = c(0.0f, f, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float f) {
        this.qu = c(0.0f, f, 1.0f);
    }

    public void setSensitivity(float f) {
        this.qp = f;
        this.qq = true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.qo;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.qo = coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), (int) motionEvent.getY());
                z = this.qo;
                break;
            case 1:
            case 3:
                this.qo = false;
                break;
        }
        if (z) {
            a(coordinatorLayout);
            return this.lt.shouldInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.lt != null) {
            this.lt.processTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public boolean canSwipeDismissView(View view) {
        return true;
    }

    private void a(ViewGroup viewGroup) {
        ViewDragHelper create;
        if (this.lt == null) {
            if (this.qq) {
                create = ViewDragHelper.create(viewGroup, this.qp, this.lE);
            } else {
                create = ViewDragHelper.create(viewGroup, this.lE);
            }
            this.lt = create;
        }
    }

    /* loaded from: classes2.dex */
    private class a implements Runnable {
        private final View mView;
        private final boolean qx;

        a(View view, boolean z) {
            this.mView = view;
            this.qx = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwipeDismissBehavior.this.lt != null && SwipeDismissBehavior.this.lt.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.mView, this);
            } else if (this.qx && SwipeDismissBehavior.this.qn != null) {
                SwipeDismissBehavior.this.qn.onDismiss(this.mView);
            }
        }
    }

    static float c(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    static int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    public int getDragState() {
        if (this.lt != null) {
            return this.lt.getViewDragState();
        }
        return 0;
    }

    static float d(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }
}
