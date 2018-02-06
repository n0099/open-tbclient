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
    OnDismissListener qo;
    private boolean qp;
    private boolean qr;
    private float qq = 0.0f;
    int qs = 2;
    float qt = 0.5f;
    float qu = 0.0f;
    float qv = 0.5f;
    private final ViewDragHelper.Callback lE = new ViewDragHelper.Callback() { // from class: android.support.design.widget.SwipeDismissBehavior.1
        private int mActivePointerId = -1;
        private int qw;

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            return this.mActivePointerId == -1 && SwipeDismissBehavior.this.canSwipeDismissView(view);
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i) {
            this.mActivePointerId = i;
            this.qw = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            if (SwipeDismissBehavior.this.qo != null) {
                SwipeDismissBehavior.this.qo.onDragStateChanged(i);
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            int i;
            this.mActivePointerId = -1;
            int width = view.getWidth();
            boolean z = false;
            if (n(view, f)) {
                i = view.getLeft() < this.qw ? this.qw - width : this.qw + width;
                z = true;
            } else {
                i = this.qw;
            }
            if (SwipeDismissBehavior.this.lt.settleCapturedViewAt(i, view.getTop())) {
                ViewCompat.postOnAnimation(view, new a(view, z));
            } else if (z && SwipeDismissBehavior.this.qo != null) {
                SwipeDismissBehavior.this.qo.onDismiss(view);
            }
        }

        private boolean n(View view, float f) {
            if (f == 0.0f) {
                return Math.abs(view.getLeft() - this.qw) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.qt);
            }
            boolean z = ViewCompat.getLayoutDirection(view) == 1;
            if (SwipeDismissBehavior.this.qs == 2) {
                return true;
            }
            if (SwipeDismissBehavior.this.qs == 0) {
                return z ? f < 0.0f : f > 0.0f;
            } else if (SwipeDismissBehavior.this.qs == 1) {
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
            if (SwipeDismissBehavior.this.qs == 0) {
                if (z) {
                    width = this.qw - view.getWidth();
                    width2 = this.qw;
                } else {
                    width = this.qw;
                    width2 = this.qw + view.getWidth();
                }
            } else if (SwipeDismissBehavior.this.qs == 1) {
                if (z) {
                    width = this.qw;
                    width2 = this.qw + view.getWidth();
                } else {
                    width = this.qw - view.getWidth();
                    width2 = this.qw;
                }
            } else {
                width = this.qw - view.getWidth();
                width2 = this.qw + view.getWidth();
            }
            return SwipeDismissBehavior.clamp(width, i, width2);
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            float width = this.qw + (view.getWidth() * SwipeDismissBehavior.this.qu);
            float width2 = this.qw + (view.getWidth() * SwipeDismissBehavior.this.qv);
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
        this.qo = onDismissListener;
    }

    public void setSwipeDirection(int i) {
        this.qs = i;
    }

    public void setDragDismissDistance(float f) {
        this.qt = c(0.0f, f, 1.0f);
    }

    public void setStartAlphaSwipeDistance(float f) {
        this.qu = c(0.0f, f, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float f) {
        this.qv = c(0.0f, f, 1.0f);
    }

    public void setSensitivity(float f) {
        this.qq = f;
        this.qr = true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.qp;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.qp = coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), (int) motionEvent.getY());
                z = this.qp;
                break;
            case 1:
            case 3:
                this.qp = false;
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
            if (this.qr) {
                create = ViewDragHelper.create(viewGroup, this.qq, this.lE);
            } else {
                create = ViewDragHelper.create(viewGroup, this.lE);
            }
            this.lt = create;
        }
    }

    /* loaded from: classes2.dex */
    private class a implements Runnable {
        private final View mView;
        private final boolean qy;

        a(View view, boolean z) {
            this.mView = view;
            this.qy = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwipeDismissBehavior.this.lt != null && SwipeDismissBehavior.this.lt.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.mView, this);
            } else if (this.qy && SwipeDismissBehavior.this.qo != null) {
                SwipeDismissBehavior.this.qo.onDismiss(this.mView);
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
