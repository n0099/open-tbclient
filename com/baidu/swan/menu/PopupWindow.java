package com.baidu.swan.menu;

import android.annotation.SuppressLint;
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
import d.a.i0.k.l;
import d.a.i0.k.m;
import java.lang.ref.WeakReference;
@SuppressLint({"ClickableViewAccessibility", "BDThrowableCheck", "SyntheticAccessor"})
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
    public Context f11904e;

    /* renamed from: f  reason: collision with root package name */
    public WindowManager f11905f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11906g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11907h;

    /* renamed from: i  reason: collision with root package name */
    public View f11908i;
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
            popupWindow.V(popupWindow.u(view, layoutParams, popupWindow.R, PopupWindow.this.S));
            PopupWindow.this.T(layoutParams.x, layoutParams.y, -1, -1, true);
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
                    PopupWindow.this.r();
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
                PopupWindow.this.r();
                return true;
            } else if (motionEvent.getAction() == 4) {
                PopupWindow.this.r();
                return true;
            } else {
                return super.onTouchEvent(motionEvent);
            }
        }

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int i2) {
            if (PopupWindow.this.f11908i != null) {
                PopupWindow.this.f11908i.sendAccessibilityEvent(i2);
            } else {
                super.sendAccessibilityEvent(i2);
            }
        }
    }

    public PopupWindow(Context context) {
        this(context, null);
    }

    public final void A(View view, int i2, int i3) {
        R();
        this.P = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.Q);
        }
        this.R = i2;
        this.S = i3;
    }

    public void B(int i2) {
        this.O = i2;
    }

    public void F(Drawable drawable) {
        this.H = drawable;
    }

    public void G(boolean z) {
        this.p = z;
    }

    public void H(View view) {
        Context context;
        if (x()) {
            return;
        }
        this.f11908i = view;
        if (this.f11904e == null && view != null) {
            this.f11904e = view.getContext();
        }
        if (this.f11905f != null || (context = this.f11904e) == null) {
            return;
        }
        this.f11905f = (WindowManager) context.getSystemService("window");
    }

    public void I(boolean z) {
        this.k = z;
    }

    public void J(int i2) {
        this.B = i2;
    }

    public void K(boolean z) {
        this.r = z;
    }

    public void L(b bVar) {
        this.M = bVar;
    }

    public void M(boolean z) {
        this.o = z;
    }

    public void N(int i2) {
        this.m = i2;
    }

    public void O(int i2) {
        this.y = i2;
    }

    public void P(View view, int i2, int i3) {
        s(view, i2, i3);
    }

    public void Q(View view, int i2, int i3, int i4) {
        t(view.getWindowToken(), i2, i3, i4);
    }

    public final void R() {
        WeakReference<View> weakReference = this.P;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.Q);
        }
        this.P = null;
    }

    public void S() {
        if (!x() || this.f11908i == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.j.getLayoutParams();
        boolean z = false;
        int o = o();
        boolean z2 = true;
        if (o != layoutParams.windowAnimations) {
            layoutParams.windowAnimations = o;
            z = true;
        }
        int p = p(layoutParams.flags);
        if (p != layoutParams.flags) {
            layoutParams.flags = p;
        } else {
            z2 = z;
        }
        if (z2) {
            this.f11905f.updateViewLayout(this.j, layoutParams);
        }
    }

    public void T(int i2, int i3, int i4, int i5, boolean z) {
        if (i4 != -1) {
            this.z = i4;
            O(i4);
        }
        if (i5 != -1) {
            this.C = i5;
            J(i5);
        }
        if (!x() || this.f11908i == null) {
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
        int o = o();
        if (o != layoutParams.windowAnimations) {
            layoutParams.windowAnimations = o;
            z = true;
        }
        int p = p(layoutParams.flags);
        if (p != layoutParams.flags) {
            layoutParams.flags = p;
        } else {
            z2 = z;
        }
        if (z2) {
            this.f11905f.updateViewLayout(this.j, layoutParams);
        }
    }

    public final void V(boolean z) {
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

    public final int o() {
        int i2 = this.O;
        if (i2 == -1) {
            if (this.f11907h) {
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
    public final int p(int i2) {
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
        if (y()) {
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

    public final WindowManager.LayoutParams q(IBinder iBinder) {
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
        layoutParams.flags = p(layoutParams.flags);
        layoutParams.type = this.L;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.m;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    public void r() {
        b bVar;
        if (!x() || this.j == null) {
            return;
        }
        this.f11906g = false;
        R();
        try {
            this.f11905f.removeView(this.j);
            View view = this.j;
            View view2 = this.f11908i;
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
            View view4 = this.f11908i;
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
            View view6 = this.f11908i;
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

    public void s(View view, int i2, int i3) {
        if (x() || this.f11908i == null) {
            return;
        }
        A(view, i2, i3);
        this.f11906g = true;
        this.f11907h = true;
        WindowManager.LayoutParams q = q(view.getWindowToken());
        z(q);
        V(u(view, q, i2, i3));
        int i4 = this.A;
        if (i4 < 0) {
            this.C = i4;
            q.height = i4;
        }
        int i5 = this.x;
        if (i5 < 0) {
            this.z = i5;
            q.width = i5;
        }
        q.windowAnimations = o();
        w(q);
    }

    public void t(IBinder iBinder, int i2, int i3, int i4) {
        if (iBinder == null || x() || this.f11908i == null) {
            return;
        }
        R();
        this.f11906g = true;
        this.f11907h = false;
        WindowManager.LayoutParams q = q(iBinder);
        q.windowAnimations = o();
        z(q);
        if (i2 == 0) {
            i2 = 51;
        }
        q.gravity = i2;
        q.x = i3;
        q.y = i4;
        int i5 = this.A;
        if (i5 < 0) {
            this.C = i5;
            q.height = i5;
        }
        int i6 = this.x;
        if (i6 < 0) {
            this.z = i6;
            q.width = i6;
        }
        w(q);
    }

    public final boolean u(View view, WindowManager.LayoutParams layoutParams, int i2, int i3) {
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

    public View v() {
        return this.f11908i;
    }

    public final void w(WindowManager.LayoutParams layoutParams) {
        Context context = this.f11904e;
        if (context != null) {
            layoutParams.packageName = context.getPackageName();
        }
        this.f11905f.addView(this.j, layoutParams);
    }

    public boolean x() {
        return this.f11906g;
    }

    public boolean y() {
        Context context;
        return (this.q >= 0 || (context = this.f11904e) == null) ? this.q == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    public final void z(WindowManager.LayoutParams layoutParams) {
        View view = this.f11908i;
        if (view != null && this.f11904e != null && this.f11905f != null) {
            if (this.H != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                int i2 = -2;
                i2 = (layoutParams2 == null || layoutParams2.height != -2) ? -1 : -1;
                c cVar = new c(this.f11904e);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i2);
                cVar.setBackgroundDrawable(this.H);
                cVar.addView(this.f11908i, layoutParams3);
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
        this.f11904e = context;
        this.f11905f = (WindowManager) context.getSystemService("window");
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
            this.f11904e = context;
            this.f11905f = (WindowManager) context.getSystemService("window");
        }
        H(view);
        O(i2);
        J(i3);
        I(z);
    }
}
