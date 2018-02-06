package android.support.v7.widget;

import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RestrictTo;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.view.menu.ShowableListMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
@RestrictTo
/* loaded from: classes2.dex */
public abstract class ForwardingListener implements View.OnTouchListener {
    private final float OQ;
    private final int OR;
    private final int OT;
    final View OU;
    private Runnable OV;
    private Runnable OW;
    private boolean OX;
    private final int[] OY = new int[2];
    private int mActivePointerId;

    public abstract ShowableListMenu getPopup();

    public ForwardingListener(View view) {
        this.OU = view;
        view.setLongClickable(true);
        if (Build.VERSION.SDK_INT >= 12) {
            af(view);
        } else {
            ag(view);
        }
        this.OQ = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.OR = ViewConfiguration.getTapTimeout();
        this.OT = (this.OR + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void af(View view) {
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: android.support.v7.widget.ForwardingListener.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                ForwardingListener.this.onDetachedFromWindow();
            }
        });
    }

    private void ag(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.ForwardingListener.2
            boolean mIsAttached;

            {
                this.mIsAttached = ForwardingListener.this.OU.isAttachedToWindow();
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                boolean z = this.mIsAttached;
                this.mIsAttached = ForwardingListener.this.OU.isAttachedToWindow();
                if (z && !this.mIsAttached) {
                    ForwardingListener.this.onDetachedFromWindow();
                }
            }
        });
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.OX;
        if (z2) {
            z = j(motionEvent) || !onForwardingStopped();
        } else {
            boolean z3 = i(motionEvent) && onForwardingStarted();
            if (z3) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.OU.onTouchEvent(obtain);
                obtain.recycle();
            }
            z = z3;
        }
        this.OX = z;
        return z || z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDetachedFromWindow() {
        this.OX = false;
        this.mActivePointerId = -1;
        if (this.OV != null) {
            this.OU.removeCallbacks(this.OV);
        }
    }

    protected boolean onForwardingStarted() {
        ShowableListMenu popup = getPopup();
        if (popup != null && !popup.isShowing()) {
            popup.show();
            return true;
        }
        return true;
    }

    protected boolean onForwardingStopped() {
        ShowableListMenu popup = getPopup();
        if (popup != null && popup.isShowing()) {
            popup.dismiss();
            return true;
        }
        return true;
    }

    private boolean i(MotionEvent motionEvent) {
        View view = this.OU;
        if (view.isEnabled()) {
            switch (MotionEventCompat.getActionMasked(motionEvent)) {
                case 0:
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    if (this.OV == null) {
                        this.OV = new a();
                    }
                    view.postDelayed(this.OV, this.OR);
                    if (this.OW == null) {
                        this.OW = new b();
                    }
                    view.postDelayed(this.OW, this.OT);
                    return false;
                case 1:
                case 3:
                    fX();
                    return false;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex < 0 || a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.OQ)) {
                        return false;
                    }
                    fX();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    private void fX() {
        if (this.OW != null) {
            this.OU.removeCallbacks(this.OW);
        }
        if (this.OV != null) {
            this.OU.removeCallbacks(this.OV);
        }
    }

    void fY() {
        fX();
        View view = this.OU;
        if (view.isEnabled() && !view.isLongClickable() && onForwardingStarted()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.OX = true;
        }
    }

    private boolean j(MotionEvent motionEvent) {
        l lVar;
        View view = this.OU;
        ShowableListMenu popup = getPopup();
        if (popup == null || !popup.isShowing() || (lVar = (l) popup.getListView()) == null || !lVar.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        b(view, obtainNoHistory);
        a(lVar, obtainNoHistory);
        boolean onForwardedEvent = lVar.onForwardedEvent(obtainNoHistory, this.mActivePointerId);
        obtainNoHistory.recycle();
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        return onForwardedEvent && (actionMasked != 1 && actionMasked != 3);
    }

    private static boolean a(View view, float f, float f2, float f3) {
        return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = this.OY;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(-iArr[0], -iArr[1]);
        return true;
    }

    private boolean b(View view, MotionEvent motionEvent) {
        int[] iArr = this.OY;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(iArr[0], iArr[1]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = ForwardingListener.this.OU.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ForwardingListener.this.fY();
        }
    }
}
