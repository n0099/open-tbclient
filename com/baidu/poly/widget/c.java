package com.baidu.poly.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.baidu.poly.b;
import com.baidu.poly.util.d;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class c {
    private static final boolean DEBUG = d.cdF;
    private static final int[] cgm = {16842922};
    private boolean cgB;
    private View.OnTouchListener cgC;
    private int cgD;
    private int cgE;
    private int cgF;
    private int cgG;
    private int cgH;
    private int cgI;
    private int cgJ;
    private int cgK;
    private Drawable cgO;
    private Drawable cgP;
    private Drawable cgQ;
    private boolean cgR;
    private b cgT;
    private WeakReference<View> cgW;
    private int cgY;
    private int cgZ;
    private WindowManager cgn;
    private boolean cgo;
    private View cgp;
    private View cgq;
    private boolean cgr;
    private boolean cgx;
    private boolean cgy;
    private boolean le;
    private Context mContext;
    private int cgs = 0;
    private int cgt = 1;
    private boolean se = true;
    private boolean cgu = false;
    private boolean cgv = true;
    private int cgw = -1;
    private boolean cgz = true;
    private boolean cgA = false;
    private int[] cgL = new int[2];
    private int[] cgM = new int[2];
    private Rect cgN = new Rect();
    private int cgS = 1000;
    private boolean cgU = false;
    private int cgV = -1;
    private ViewTreeObserver.OnScrollChangedListener cgX = new a();

    /* loaded from: classes6.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = c.this.cgW != null ? (View) c.this.cgW.get() : null;
            if (view == null || c.this.cgq == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c.this.cgq.getLayoutParams();
            c cVar = c.this;
            cVar.d(cVar.a(view, layoutParams, cVar.cgY, c.this.cgZ));
            c.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.poly.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0315c extends FrameLayout {
        public C0315c(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            KeyEvent.DispatcherState keyDispatcherState;
            if (keyEvent.getKeyCode() == 4) {
                if (getKeyDispatcherState() == null) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.startTracking(keyEvent, this);
                        return true;
                    }
                    return true;
                } else if (keyEvent.getAction() == 1 && (keyDispatcherState = getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                    c.this.dismiss();
                    return true;
                } else {
                    return super.dispatchKeyEvent(keyEvent);
                }
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (c.this.cgC == null || !c.this.cgC.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i) {
            if (c.this.cgR) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, c.cgm);
                return onCreateDrawableState;
            }
            return super.onCreateDrawableState(i);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x < 0 || x >= super.getWidth() || y < 0 || y >= super.getHeight())) {
                c.this.dismiss();
                return true;
            } else if (motionEvent.getAction() == 4) {
                c.this.dismiss();
                return true;
            } else {
                return super.onTouchEvent(motionEvent);
            }
        }

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int i) {
            if (c.this.cgp != null) {
                c.this.cgp.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public c(View view, int i, int i2, boolean z) {
        if (view != null) {
            this.mContext = view.getContext();
            this.cgn = (WindowManager) this.mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    private int abE() {
        int i = this.cgV;
        if (i == -1) {
            if (this.cgo) {
                return this.cgR ? b.h.PopupWindow_DropDownUp : b.h.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
    }

    private void abF() {
        WeakReference<View> weakReference = this.cgW;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.cgX);
        }
        this.cgW = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
        if (r3.cgs == 2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r3.cgs == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r0 | 131072;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int gV(int i) {
        int i2 = (-8815129) & i;
        if (this.cgU) {
            i2 |= 32768;
        }
        if (!this.cgr) {
            i2 |= 8;
        }
        if (!this.se) {
            i2 |= 16;
        }
        if (this.cgu) {
            i2 |= 262144;
        }
        if (!this.cgv) {
            i2 |= 512;
        }
        if (isSplitTouchEnabled()) {
            i2 |= 8388608;
        }
        if (this.cgx) {
            i2 |= 256;
        }
        if (this.cgA) {
            i2 |= 65536;
        }
        return this.cgB ? i2 | 32 : i2;
    }

    public void dismiss() {
        b bVar;
        if (isShowing() && this.cgq != null) {
            this.le = false;
            abF();
            try {
                try {
                    this.cgn.removeView(this.cgq);
                    View view = this.cgq;
                    View view2 = this.cgp;
                    if (view != view2 && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeView(view2);
                    }
                    this.cgq = null;
                    bVar = this.cgT;
                    if (bVar == null) {
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    if (!DEBUG) {
                        View view3 = this.cgq;
                        View view4 = this.cgp;
                        if (view3 != view4 && (view3 instanceof ViewGroup)) {
                            ((ViewGroup) view3).removeView(view4);
                        }
                        this.cgq = null;
                        bVar = this.cgT;
                        if (bVar == null) {
                            return;
                        }
                    } else {
                        throw e;
                    }
                }
                bVar.onDismiss();
            } catch (Throwable th) {
                View view5 = this.cgq;
                View view6 = this.cgp;
                if (view5 != view6 && (view5 instanceof ViewGroup)) {
                    ((ViewGroup) view5).removeView(view6);
                }
                this.cgq = null;
                b bVar2 = this.cgT;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
        }
    }

    public boolean isShowing() {
        return this.le;
    }

    public boolean isSplitTouchEnabled() {
        Context context;
        return (this.cgw >= 0 || (context = this.mContext) == null) ? this.cgw == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.cgO = drawable;
    }

    public void setClippingEnabled(boolean z) {
        this.cgv = z;
    }

    public void setContentView(View view) {
        Context context;
        View view2;
        if (!isShowing()) {
            this.cgp = view;
            if (this.mContext == null && (view2 = this.cgp) != null) {
                this.mContext = view2.getContext();
            }
            if (this.cgn != null || this.cgp == null || (context = this.mContext) == null) {
                return;
            }
            this.cgn = (WindowManager) context.getSystemService("window");
        }
    }

    public void setFocusable(boolean z) {
        this.cgr = z;
    }

    public void setHeight(int i) {
        this.cgH = i;
    }

    public void setOutsideTouchable(boolean z) {
        this.cgu = z;
    }

    public void setWidth(int i) {
        this.cgE = i;
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        a(view.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = true;
        if (i3 != -1) {
            this.cgF = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.cgI = i4;
            setHeight(i4);
        }
        if (isShowing() && this.cgp != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.cgq.getLayoutParams();
            int i5 = this.cgD;
            if (i5 >= 0) {
                i5 = this.cgF;
            }
            if (i3 != -1 && layoutParams.width != i5) {
                this.cgF = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.cgG;
            if (i6 >= 0) {
                i6 = this.cgI;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.cgI = i6;
                layoutParams.height = i6;
                z = true;
            }
            if (layoutParams.x != i) {
                layoutParams.x = i;
                z = true;
            }
            if (layoutParams.y != i2) {
                layoutParams.y = i2;
                z = true;
            }
            int abE = abE();
            if (abE != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = abE;
                z = true;
            }
            int gV = gV(layoutParams.flags);
            if (gV != layoutParams.flags) {
                layoutParams.flags = gV;
            } else {
                z2 = z;
            }
            if (z2) {
                this.cgn.updateViewLayout(this.cgq, layoutParams);
            }
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        int i = -2;
        View view = this.cgp;
        if (view != null && this.mContext != null && this.cgn != null) {
            if (this.cgO != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null || layoutParams2.height != -2) {
                    i = -1;
                }
                C0315c c0315c = new C0315c(this.mContext);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                c0315c.setBackgroundDrawable(this.cgO);
                c0315c.addView(this.cgp, layoutParams3);
                this.cgq = c0315c;
            } else {
                this.cgq = view;
            }
            this.cgJ = layoutParams.width;
            this.cgK = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z != this.cgR) {
            this.cgR = z;
            if (this.cgO != null) {
                Drawable drawable = this.cgP;
                if (drawable != null) {
                    if (this.cgR) {
                        this.cgq.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.cgq.setBackgroundDrawable(this.cgQ);
                        return;
                    }
                }
                this.cgq.refreshDrawableState();
            }
        }
    }

    public void a(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !isShowing() && this.cgp != null) {
            abF();
            this.le = true;
            this.cgo = false;
            WindowManager.LayoutParams c = c(iBinder);
            c.windowAnimations = abE();
            a(c);
            if (i == 0) {
                i = 51;
            }
            c.gravity = i;
            c.x = i2;
            c.y = i3;
            int i4 = this.cgG;
            if (i4 < 0) {
                this.cgI = i4;
                c.height = i4;
            }
            int i5 = this.cgD;
            if (i5 < 0) {
                this.cgF = i5;
                c.width = i5;
            }
            b(c);
        }
    }

    private void b(WindowManager.LayoutParams layoutParams) {
        Context context = this.mContext;
        if (context != null) {
            layoutParams.packageName = context.getPackageName();
        }
        this.cgn.addView(this.cgq, layoutParams);
    }

    private WindowManager.LayoutParams c(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.cgE;
        this.cgF = i;
        layoutParams.width = i;
        int i2 = this.cgH;
        this.cgI = i2;
        layoutParams.height = i2;
        Drawable drawable = this.cgO;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = gV(layoutParams.flags);
        layoutParams.type = this.cgS;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.cgt;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.cgL);
        int[] iArr = this.cgL;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.cgM);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (height + this.cgM[1] + i2 + this.cgK > rect.bottom || (layoutParams.x + this.cgJ) - rootView.getWidth() > 0) {
            if (this.cgz) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.cgJ + scrollX + i, this.cgK + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.cgL);
            int[] iArr2 = this.cgL;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.cgM);
            r0 = ((rect.bottom - this.cgM[1]) - view.getHeight()) - i2 < (this.cgM[1] - i2) - rect.top;
            if (r0) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.cgL[1]) + i2;
            } else {
                layoutParams.y = this.cgL[1] + view.getHeight() + i2;
            }
        }
        if (this.cgy) {
            int i3 = rect.right - rect.left;
            int i4 = layoutParams.x + layoutParams.width;
            if (i4 > i3) {
                layoutParams.x -= i4 - i3;
            }
            int i5 = layoutParams.x;
            int i6 = rect.left;
            if (i5 < i6) {
                layoutParams.x = i6;
                layoutParams.width = Math.min(layoutParams.width, i3);
            }
            if (r0) {
                int i7 = (this.cgM[1] + i2) - this.cgK;
                if (i7 < 0) {
                    layoutParams.y = i7 + layoutParams.y;
                }
            } else {
                layoutParams.y = Math.max(layoutParams.y, rect.top);
            }
        }
        layoutParams.gravity |= 268435456;
        return r0;
    }

    public void a(b bVar) {
        this.cgT = bVar;
    }
}
