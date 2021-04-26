package com.baidu.swan.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.alibaba.fastjson.asm.Label;
import d.a.h0.i.l;
import d.a.h0.i.m;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class PopupWindow {
    public static final int[] T = {16842922};
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int[] F;
    public int[] G;
    public Drawable H;
    public Drawable I;
    public Drawable J;
    public boolean K;
    public int L;
    public b M;
    public boolean N;
    public int O;
    public WeakReference<View> P;
    public ViewTreeObserver.OnScrollChangedListener Q;
    public int R;
    public int S;

    /* renamed from: e  reason: collision with root package name */
    public Context f12562e;

    /* renamed from: f  reason: collision with root package name */
    public WindowManager f12563f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12564g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12565h;

    /* renamed from: i  reason: collision with root package name */
    public View f12566i;
    public View j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public View.OnTouchListener w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = PopupWindow.this.P != null ? (View) PopupWindow.this.P.get() : null;
            if (view == null || PopupWindow.this.j == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.j.getLayoutParams();
            PopupWindow popupWindow = PopupWindow.this;
            popupWindow.P(popupWindow.q(view, layoutParams, popupWindow.R, PopupWindow.this.S));
            PopupWindow.this.O(layoutParams.x, layoutParams.y, -1, -1, true);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onDismiss();
    }

    /* loaded from: classes3.dex */
    public class c extends FrameLayout {
        public c(Context context) {
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
                    }
                    return true;
                } else if (keyEvent.getAction() == 1 && (keyDispatcherState = getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                    PopupWindow.this.n();
                    return true;
                } else {
                    return super.dispatchKeyEvent(keyEvent);
                }
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (PopupWindow.this.w == null || !PopupWindow.this.w.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        public int[] onCreateDrawableState(int i2) {
            if (PopupWindow.this.K) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
                View.mergeDrawableStates(onCreateDrawableState, PopupWindow.T);
                return onCreateDrawableState;
            }
            return super.onCreateDrawableState(i2);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x < 0 || x >= super.getWidth() || y < 0 || y >= super.getHeight())) {
                PopupWindow.this.n();
                return true;
            } else if (motionEvent.getAction() == 4) {
                PopupWindow.this.n();
                return true;
            } else {
                return super.onTouchEvent(motionEvent);
            }
        }

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int i2) {
            if (PopupWindow.this.f12566i != null) {
                PopupWindow.this.f12566i.sendAccessibilityEvent(i2);
            } else {
                super.sendAccessibilityEvent(i2);
            }
        }
    }

    public PopupWindow(Context context) {
        this(context, null);
    }

    public void A(View view) {
        Context context;
        if (t()) {
            return;
        }
        this.f12566i = view;
        if (this.f12562e == null && view != null) {
            this.f12562e = view.getContext();
        }
        if (this.f12563f != null || (context = this.f12562e) == null) {
            return;
        }
        this.f12563f = (WindowManager) context.getSystemService("window");
    }

    public void B(boolean z) {
        this.k = z;
    }

    public void F(int i2) {
        this.B = i2;
    }

    public void G(b bVar) {
        this.M = bVar;
    }

    public void H(boolean z) {
        this.o = z;
    }

    public void I(int i2) {
        this.m = i2;
    }

    public void J(int i2) {
        this.y = i2;
    }

    public void K(View view, int i2, int i3) {
        o(view, i2, i3);
    }

    public void L(View view, int i2, int i3, int i4) {
        p(view.getWindowToken(), i2, i3, i4);
    }

    public final void M() {
        WeakReference<View> weakReference = this.P;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.Q);
        }
        this.P = null;
    }

    public void N() {
        if (!t() || this.f12566i == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.j.getLayoutParams();
        boolean z = false;
        int k = k();
        boolean z2 = true;
        if (k != layoutParams.windowAnimations) {
            layoutParams.windowAnimations = k;
            z = true;
        }
        int l = l(layoutParams.flags);
        if (l != layoutParams.flags) {
            layoutParams.flags = l;
        } else {
            z2 = z;
        }
        if (z2) {
            this.f12563f.updateViewLayout(this.j, layoutParams);
        }
    }

    public void O(int i2, int i3, int i4, int i5, boolean z) {
        if (i4 != -1) {
            this.z = i4;
            J(i4);
        }
        if (i5 != -1) {
            this.C = i5;
            F(i5);
        }
        if (!t() || this.f12566i == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.j.getLayoutParams();
        int i6 = this.x;
        if (i6 >= 0) {
            i6 = this.z;
        }
        boolean z2 = true;
        if (i4 != -1 && layoutParams.width != i6) {
            this.z = i6;
            layoutParams.width = i6;
            z = true;
        }
        int i7 = this.A;
        if (i7 >= 0) {
            i7 = this.C;
        }
        if (i5 != -1 && layoutParams.height != i7) {
            this.C = i7;
            layoutParams.height = i7;
            z = true;
        }
        if (layoutParams.x != i2) {
            layoutParams.x = i2;
            z = true;
        }
        if (layoutParams.y != i3) {
            layoutParams.y = i3;
            z = true;
        }
        int k = k();
        if (k != layoutParams.windowAnimations) {
            layoutParams.windowAnimations = k;
            z = true;
        }
        int l = l(layoutParams.flags);
        if (l != layoutParams.flags) {
            layoutParams.flags = l;
        } else {
            z2 = z;
        }
        if (z2) {
            this.f12563f.updateViewLayout(this.j, layoutParams);
        }
    }

    public final void P(boolean z) {
        if (z != this.K) {
            this.K = z;
            if (this.H != null) {
                Drawable drawable = this.I;
                if (drawable == null) {
                    this.j.refreshDrawableState();
                } else if (z) {
                    this.j.setBackgroundDrawable(drawable);
                } else {
                    this.j.setBackgroundDrawable(this.J);
                }
            }
        }
    }

    public final int k() {
        int i2 = this.O;
        if (i2 == -1) {
            if (this.f12565h) {
                return this.K ? l.PopupWindow_DropDownUp : l.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r3.l == 2) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        r4 = r4 | 131072;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
        if (r3.l == 1) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int l(int i2) {
        int i3 = i2 & (-8815129);
        if (this.N) {
            i3 |= 32768;
        }
        if (!this.k) {
            i3 |= 8;
        }
        if (!this.n) {
            i3 |= 16;
        }
        if (this.o) {
            i3 |= 262144;
        }
        if (!this.p) {
            i3 |= 512;
        }
        if (u()) {
            i3 |= 8388608;
        }
        if (this.r) {
            i3 |= 256;
        }
        if (this.u) {
            i3 |= 65536;
        }
        return this.v ? i3 | 32 : i3;
    }

    public final WindowManager.LayoutParams m(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i2 = this.y;
        this.z = i2;
        layoutParams.width = i2;
        int i3 = this.B;
        this.C = i3;
        layoutParams.height = i3;
        Drawable drawable = this.H;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = l(layoutParams.flags);
        layoutParams.type = this.L;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.m;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    public void n() {
        b bVar;
        if (!t() || this.j == null) {
            return;
        }
        this.f12564g = false;
        M();
        try {
            this.f12563f.removeView(this.j);
            View view = this.j;
            View view2 = this.f12566i;
            if (view != view2 && (view instanceof ViewGroup)) {
                ((ViewGroup) view).removeView(view2);
            }
            this.j = null;
            bVar = this.M;
            if (bVar == null) {
                return;
            }
        } catch (IllegalArgumentException unused) {
            View view3 = this.j;
            View view4 = this.f12566i;
            if (view3 != view4 && (view3 instanceof ViewGroup)) {
                ((ViewGroup) view3).removeView(view4);
            }
            this.j = null;
            bVar = this.M;
            if (bVar == null) {
                return;
            }
        } catch (Throwable th) {
            View view5 = this.j;
            View view6 = this.f12566i;
            if (view5 != view6 && (view5 instanceof ViewGroup)) {
                ((ViewGroup) view5).removeView(view6);
            }
            this.j = null;
            b bVar2 = this.M;
            if (bVar2 != null) {
                bVar2.onDismiss();
            }
            throw th;
        }
        bVar.onDismiss();
    }

    public void o(View view, int i2, int i3) {
        if (t() || this.f12566i == null) {
            return;
        }
        w(view, i2, i3);
        this.f12564g = true;
        this.f12565h = true;
        WindowManager.LayoutParams m = m(view.getWindowToken());
        v(m);
        P(q(view, m, i2, i3));
        int i4 = this.A;
        if (i4 < 0) {
            this.C = i4;
            m.height = i4;
        }
        int i5 = this.x;
        if (i5 < 0) {
            this.z = i5;
            m.width = i5;
        }
        m.windowAnimations = k();
        s(m);
    }

    public void p(IBinder iBinder, int i2, int i3, int i4) {
        if (iBinder == null || t() || this.f12566i == null) {
            return;
        }
        M();
        this.f12564g = true;
        this.f12565h = false;
        WindowManager.LayoutParams m = m(iBinder);
        m.windowAnimations = k();
        v(m);
        if (i2 == 0) {
            i2 = 51;
        }
        m.gravity = i2;
        m.x = i3;
        m.y = i4;
        int i5 = this.A;
        if (i5 < 0) {
            this.C = i5;
            m.height = i5;
        }
        int i6 = this.x;
        if (i6 < 0) {
            this.z = i6;
            m.width = i6;
        }
        s(m);
    }

    public final boolean q(View view, WindowManager.LayoutParams layoutParams, int i2, int i3) {
        int height = view.getHeight();
        view.getLocationInWindow(this.F);
        int[] iArr = this.F;
        layoutParams.x = iArr[0] + i2;
        layoutParams.y = iArr[1] + height + i3;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.G);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (this.G[1] + height + i3 + this.E > rect.bottom || (layoutParams.x + this.D) - rootView.getWidth() > 0) {
            if (this.t) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.D + scrollX + i2, this.E + scrollY + view.getHeight() + i3), true);
            }
            view.getLocationInWindow(this.F);
            int[] iArr2 = this.F;
            layoutParams.x = iArr2[0] + i2;
            layoutParams.y = iArr2[1] + view.getHeight() + i3;
            view.getLocationOnScreen(this.G);
            r2 = ((rect.bottom - this.G[1]) - view.getHeight()) - i3 < (this.G[1] - i3) - rect.top;
            if (r2) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.F[1]) + i3;
            } else {
                layoutParams.y = this.F[1] + view.getHeight() + i3;
            }
        }
        if (this.s) {
            int i4 = rect.right - rect.left;
            int i5 = layoutParams.x;
            int i6 = layoutParams.width + i5;
            if (i6 > i4) {
                layoutParams.x = i5 - (i6 - i4);
            }
            int i7 = layoutParams.x;
            int i8 = rect.left;
            if (i7 < i8) {
                layoutParams.x = i8;
                layoutParams.width = Math.min(layoutParams.width, i4);
            }
            if (r2) {
                int i9 = (this.G[1] + i3) - this.E;
                if (i9 < 0) {
                    layoutParams.y += i9;
                }
            } else {
                layoutParams.y = Math.max(layoutParams.y, rect.top);
            }
        }
        layoutParams.gravity |= Label.FORWARD_REFERENCE_TYPE_SHORT;
        return r2;
    }

    public View r() {
        return this.f12566i;
    }

    public final void s(WindowManager.LayoutParams layoutParams) {
        Context context = this.f12562e;
        if (context != null) {
            layoutParams.packageName = context.getPackageName();
        }
        this.f12563f.addView(this.j, layoutParams);
    }

    public boolean t() {
        return this.f12564g;
    }

    public boolean u() {
        Context context;
        return (this.q >= 0 || (context = this.f12562e) == null) ? this.q == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public final void v(WindowManager.LayoutParams layoutParams) {
        View view = this.f12566i;
        if (view != null && this.f12562e != null && this.f12563f != null) {
            if (this.H != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                int i2 = -2;
                i2 = (layoutParams2 == null || layoutParams2.height != -2) ? -1 : -1;
                c cVar = new c(this.f12562e);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i2);
                cVar.setBackgroundDrawable(this.H);
                cVar.addView(this.f12566i, layoutParams3);
                this.j = cVar;
            } else {
                this.j = view;
            }
            this.D = layoutParams.width;
            this.E = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    public final void w(View view, int i2, int i3) {
        M();
        this.P = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.Q);
        }
        this.R = i2;
        this.S = i3;
    }

    public void x(int i2) {
        this.O = i2;
    }

    public void y(Drawable drawable) {
        this.H = drawable;
    }

    public void z(boolean z) {
        this.p = z;
    }

    public PopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842870);
    }

    public PopupWindow(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public PopupWindow(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.l = 0;
        this.m = 1;
        this.n = true;
        this.o = false;
        this.p = true;
        this.q = -1;
        this.t = true;
        this.u = false;
        this.F = new int[2];
        this.G = new int[2];
        new Rect();
        this.L = 1000;
        this.N = false;
        this.O = -1;
        this.Q = new a();
        this.f12562e = context;
        this.f12563f = (WindowManager) context.getSystemService("window");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.PopupWindow, i2, i3);
        this.H = obtainStyledAttributes.getDrawable(m.PopupWindow_popupBackground);
        int resourceId = obtainStyledAttributes.getResourceId(m.PopupWindow_popupAnimationStyle, -1);
        this.O = resourceId != 16973824 ? resourceId : -1;
        obtainStyledAttributes.recycle();
    }

    public PopupWindow() {
        this((View) null, 0, 0);
    }

    public PopupWindow(View view, int i2, int i3) {
        this(view, i2, i3, false);
    }

    public PopupWindow(View view, int i2, int i3, boolean z) {
        this.l = 0;
        this.m = 1;
        this.n = true;
        this.o = false;
        this.p = true;
        this.q = -1;
        this.t = true;
        this.u = false;
        this.F = new int[2];
        this.G = new int[2];
        new Rect();
        this.L = 1000;
        this.N = false;
        this.O = -1;
        this.Q = new a();
        if (view != null) {
            Context context = view.getContext();
            this.f12562e = context;
            this.f12563f = (WindowManager) context.getSystemService("window");
        }
        A(view);
        J(i2);
        F(i3);
        B(z);
    }
}
