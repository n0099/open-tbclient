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
import d.b.g0.i.l;
import d.b.g0.i.m;
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
    public Context f12991e;

    /* renamed from: f  reason: collision with root package name */
    public WindowManager f12992f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12993g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12994h;
    public View i;
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
            popupWindow.R(popupWindow.q(view, layoutParams, popupWindow.R, PopupWindow.this.S));
            PopupWindow.this.Q(layoutParams.x, layoutParams.y, -1, -1, true);
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
        public int[] onCreateDrawableState(int i) {
            if (PopupWindow.this.K) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, PopupWindow.T);
                return onCreateDrawableState;
            }
            return super.onCreateDrawableState(i);
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
        public void sendAccessibilityEvent(int i) {
            if (PopupWindow.this.i != null) {
                PopupWindow.this.i.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }
    }

    public PopupWindow(Context context) {
        this(context, null);
    }

    public void A(boolean z) {
        this.p = z;
    }

    public void B(View view) {
        Context context;
        if (u()) {
            return;
        }
        this.i = view;
        if (this.f12991e == null && view != null) {
            this.f12991e = view.getContext();
        }
        if (this.f12992f != null || (context = this.f12991e) == null) {
            return;
        }
        this.f12992f = (WindowManager) context.getSystemService("window");
    }

    public void E(boolean z) {
        this.k = z;
    }

    public void F(int i) {
        this.B = i;
    }

    public void G(b bVar) {
        this.M = bVar;
    }

    public void I(boolean z) {
        this.o = z;
    }

    public void J(int i) {
        this.m = i;
    }

    public void K(int i) {
        this.y = i;
    }

    public void L(View view, int i, int i2) {
        o(view, i, i2);
    }

    public void M(View view, int i, int i2, int i3) {
        p(view.getWindowToken(), i, i2, i3);
    }

    public final void O() {
        WeakReference<View> weakReference = this.P;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.Q);
        }
        this.P = null;
    }

    public void P() {
        if (!u() || this.i == null) {
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
            this.f12992f.updateViewLayout(this.j, layoutParams);
        }
    }

    public void Q(int i, int i2, int i3, int i4, boolean z) {
        if (i3 != -1) {
            this.z = i3;
            K(i3);
        }
        if (i4 != -1) {
            this.C = i4;
            F(i4);
        }
        if (!u() || this.i == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.j.getLayoutParams();
        int i5 = this.x;
        if (i5 >= 0) {
            i5 = this.z;
        }
        boolean z2 = true;
        if (i3 != -1 && layoutParams.width != i5) {
            this.z = i5;
            layoutParams.width = i5;
            z = true;
        }
        int i6 = this.A;
        if (i6 >= 0) {
            i6 = this.C;
        }
        if (i4 != -1 && layoutParams.height != i6) {
            this.C = i6;
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
            this.f12992f.updateViewLayout(this.j, layoutParams);
        }
    }

    public final void R(boolean z) {
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
        int i = this.O;
        if (i == -1) {
            if (this.f12994h) {
                return this.K ? l.PopupWindow_DropDownUp : l.PopupWindow_DropDownDown;
            }
            return 0;
        }
        return i;
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
    public final int l(int i) {
        int i2 = i & (-8815129);
        if (this.N) {
            i2 |= 32768;
        }
        if (!this.k) {
            i2 |= 8;
        }
        if (!this.n) {
            i2 |= 16;
        }
        if (this.o) {
            i2 |= 262144;
        }
        if (!this.p) {
            i2 |= 512;
        }
        if (v()) {
            i2 |= 8388608;
        }
        if (this.r) {
            i2 |= 256;
        }
        if (this.u) {
            i2 |= 65536;
        }
        return this.v ? i2 | 32 : i2;
    }

    public final WindowManager.LayoutParams m(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.y;
        this.z = i;
        layoutParams.width = i;
        int i2 = this.B;
        this.C = i2;
        layoutParams.height = i2;
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
        if (!u() || this.j == null) {
            return;
        }
        this.f12993g = false;
        O();
        try {
            this.f12992f.removeView(this.j);
            View view = this.j;
            View view2 = this.i;
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
            View view4 = this.i;
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
            View view6 = this.i;
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

    public void o(View view, int i, int i2) {
        if (u() || this.i == null) {
            return;
        }
        x(view, i, i2);
        this.f12993g = true;
        this.f12994h = true;
        WindowManager.LayoutParams m = m(view.getWindowToken());
        w(m);
        R(q(view, m, i, i2));
        int i3 = this.A;
        if (i3 < 0) {
            this.C = i3;
            m.height = i3;
        }
        int i4 = this.x;
        if (i4 < 0) {
            this.z = i4;
            m.width = i4;
        }
        m.windowAnimations = k();
        s(m);
    }

    public void p(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder == null || u() || this.i == null) {
            return;
        }
        O();
        this.f12993g = true;
        this.f12994h = false;
        WindowManager.LayoutParams m = m(iBinder);
        m.windowAnimations = k();
        w(m);
        if (i == 0) {
            i = 51;
        }
        m.gravity = i;
        m.x = i2;
        m.y = i3;
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
        s(m);
    }

    public final boolean q(View view, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view.getHeight();
        view.getLocationInWindow(this.F);
        int[] iArr = this.F;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.G);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        View rootView = view.getRootView();
        if (this.G[1] + height + i2 + this.E > rect.bottom || (layoutParams.x + this.D) - rootView.getWidth() > 0) {
            if (this.t) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.D + scrollX + i, this.E + scrollY + view.getHeight() + i2), true);
            }
            view.getLocationInWindow(this.F);
            int[] iArr2 = this.F;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view.getHeight() + i2;
            view.getLocationOnScreen(this.G);
            r2 = ((rect.bottom - this.G[1]) - view.getHeight()) - i2 < (this.G[1] - i2) - rect.top;
            if (r2) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.F[1]) + i2;
            } else {
                layoutParams.y = this.F[1] + view.getHeight() + i2;
            }
        }
        if (this.s) {
            int i3 = rect.right - rect.left;
            int i4 = layoutParams.x;
            int i5 = layoutParams.width + i4;
            if (i5 > i3) {
                layoutParams.x = i4 - (i5 - i3);
            }
            int i6 = layoutParams.x;
            int i7 = rect.left;
            if (i6 < i7) {
                layoutParams.x = i7;
                layoutParams.width = Math.min(layoutParams.width, i3);
            }
            if (r2) {
                int i8 = (this.G[1] + i2) - this.E;
                if (i8 < 0) {
                    layoutParams.y += i8;
                }
            } else {
                layoutParams.y = Math.max(layoutParams.y, rect.top);
            }
        }
        layoutParams.gravity |= 268435456;
        return r2;
    }

    public View r() {
        return this.i;
    }

    public final void s(WindowManager.LayoutParams layoutParams) {
        Context context = this.f12991e;
        if (context != null) {
            layoutParams.packageName = context.getPackageName();
        }
        this.f12992f.addView(this.j, layoutParams);
    }

    public boolean u() {
        return this.f12993g;
    }

    public boolean v() {
        Context context;
        return (this.q >= 0 || (context = this.f12991e) == null) ? this.q == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public final void w(WindowManager.LayoutParams layoutParams) {
        View view = this.i;
        if (view != null && this.f12991e != null && this.f12992f != null) {
            if (this.H != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                int i = -2;
                i = (layoutParams2 == null || layoutParams2.height != -2) ? -1 : -1;
                c cVar = new c(this.f12991e);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                cVar.setBackgroundDrawable(this.H);
                cVar.addView(this.i, layoutParams3);
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

    public final void x(View view, int i, int i2) {
        O();
        this.P = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.Q);
        }
        this.R = i;
        this.S = i2;
    }

    public void y(int i) {
        this.O = i;
    }

    public void z(Drawable drawable) {
        this.H = drawable;
    }

    public PopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842870);
    }

    public PopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
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
        this.f12991e = context;
        this.f12992f = (WindowManager) context.getSystemService("window");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.PopupWindow, i, i2);
        this.H = obtainStyledAttributes.getDrawable(m.PopupWindow_popupBackground);
        int resourceId = obtainStyledAttributes.getResourceId(m.PopupWindow_popupAnimationStyle, -1);
        this.O = resourceId != 16973824 ? resourceId : -1;
        obtainStyledAttributes.recycle();
    }

    public PopupWindow() {
        this((View) null, 0, 0);
    }

    public PopupWindow(View view, int i, int i2) {
        this(view, i, i2, false);
    }

    public PopupWindow(View view, int i, int i2, boolean z) {
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
            this.f12991e = context;
            this.f12992f = (WindowManager) context.getSystemService("window");
        }
        B(view);
        K(i);
        F(i2);
        E(z);
    }
}
