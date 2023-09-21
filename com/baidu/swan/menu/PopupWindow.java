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
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.mh4;
import java.lang.ref.WeakReference;
@SuppressLint({"ClickableViewAccessibility", "BDThrowableCheck", "SyntheticAccessor"})
/* loaded from: classes4.dex */
public class PopupWindow {
    public static final int[] P = {16842922};
    public int A;
    public int[] B;
    public int[] C;
    public Drawable D;
    public Drawable E;
    public Drawable F;
    public boolean G;
    public int H;
    public b I;
    public boolean J;
    public int K;
    public WeakReference<View> L;
    public ViewTreeObserver.OnScrollChangedListener M;
    public int N;
    public int O;
    public Context a;
    public WindowManager b;
    public boolean c;
    public boolean d;
    public View e;
    public View f;
    public boolean g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public View.OnTouchListener s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes4.dex */
    public interface b {
        void onDismiss();
    }

    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view2;
            if (PopupWindow.this.L != null) {
                view2 = (View) PopupWindow.this.L.get();
            } else {
                view2 = null;
            }
            if (view2 != null && PopupWindow.this.f != null) {
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) PopupWindow.this.f.getLayoutParams();
                PopupWindow popupWindow = PopupWindow.this;
                popupWindow.Q(popupWindow.t(view2, layoutParams, popupWindow.N, PopupWindow.this.O));
                PopupWindow.this.update(layoutParams.x, layoutParams.y, -1, -1, true);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    PopupWindow.this.q();
                    return true;
                } else {
                    return super.dispatchKeyEvent(keyEvent);
                }
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (PopupWindow.this.s != null && PopupWindow.this.s.onTouch(this, motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public int[] onCreateDrawableState(int i) {
            if (PopupWindow.this.G) {
                int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(onCreateDrawableState, PopupWindow.P);
                return onCreateDrawableState;
            }
            return super.onCreateDrawableState(i);
        }

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int i) {
            if (PopupWindow.this.e != null) {
                PopupWindow.this.e.sendAccessibilityEvent(i);
            } else {
                super.sendAccessibilityEvent(i);
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x < 0 || x >= super.getWidth() || y < 0 || y >= super.getHeight())) {
                PopupWindow.this.q();
                return true;
            } else if (motionEvent.getAction() == 4) {
                PopupWindow.this.q();
                return true;
            } else {
                return super.onTouchEvent(motionEvent);
            }
        }
    }

    public PopupWindow() {
        this((View) null, 0, 0);
    }

    public final void P() {
        View view2;
        WeakReference<View> weakReference = this.L;
        if (weakReference != null) {
            view2 = weakReference.get();
        } else {
            view2 = null;
        }
        if (view2 != null) {
            view2.getViewTreeObserver().removeOnScrollChangedListener(this.M);
        }
        this.L = null;
    }

    public final int n() {
        int i = this.K;
        if (i == -1) {
            if (this.d) {
                if (this.G) {
                    return R.style.obfuscated_res_0x7f10017e;
                }
                return R.style.obfuscated_res_0x7f10017d;
            }
            return 0;
        }
        return i;
    }

    public View u() {
        return this.e;
    }

    public boolean y() {
        return this.c;
    }

    public boolean z() {
        Context context;
        if (this.m < 0 && (context = this.a) != null) {
            if (context.getApplicationInfo().targetSdkVersion < 11) {
                return false;
            }
            return true;
        } else if (this.m != 1) {
            return false;
        } else {
            return true;
        }
    }

    public PopupWindow(Context context) {
        this(context, null);
    }

    public void C(int i) {
        this.K = i;
    }

    public void D(Drawable drawable) {
        this.D = drawable;
    }

    public void E(boolean z) {
        this.l = z;
    }

    public void F(View view2) {
        Context context;
        if (y()) {
            return;
        }
        this.e = view2;
        if (this.a == null && view2 != null) {
            this.a = view2.getContext();
        }
        if (this.b == null && (context = this.a) != null) {
            this.b = (WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
        }
    }

    public void G(boolean z) {
        this.g = z;
    }

    public void H(int i) {
        this.x = i;
    }

    public void I(boolean z) {
        this.n = z;
    }

    public void J(b bVar) {
        this.I = bVar;
    }

    public void K(boolean z) {
        this.k = z;
    }

    public void L(int i) {
        this.i = i;
    }

    public void M(int i) {
        this.u = i;
    }

    public final void Q(boolean z) {
        if (z != this.G) {
            this.G = z;
            if (this.D != null) {
                Drawable drawable = this.E;
                if (drawable != null) {
                    if (z) {
                        this.f.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.f.setBackgroundDrawable(this.F);
                        return;
                    }
                }
                this.f.refreshDrawableState();
            }
        }
    }

    public final void x(WindowManager.LayoutParams layoutParams) {
        Context context = this.a;
        if (context != null) {
            layoutParams.packageName = context.getPackageName();
        }
        this.b.addView(this.f, layoutParams);
    }

    public PopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842870);
    }

    public void update(int i, int i2) {
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f.getLayoutParams();
        update(layoutParams.x, layoutParams.y, i, i2, false);
    }

    public PopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public final void B(View view2, int i, int i2) {
        P();
        this.L = new WeakReference<>(view2);
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.M);
        }
        this.N = i;
        this.O = i2;
    }

    public void N(View view2, int i, int i2) {
        r(view2, i, i2);
    }

    public void update(View view2, int i, int i2) {
        update(view2, false, 0, 0, true, i, i2);
    }

    public PopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.h = 0;
        this.i = 1;
        this.j = true;
        this.k = false;
        this.l = true;
        this.m = -1;
        this.p = true;
        this.q = false;
        this.B = new int[2];
        this.C = new int[2];
        new Rect();
        this.H = 1000;
        this.J = false;
        this.K = -1;
        this.M = new a();
        this.a = context;
        this.b = (WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, mh4.PopupWindow, i, i2);
        this.D = obtainStyledAttributes.getDrawable(4);
        int resourceId = obtainStyledAttributes.getResourceId(3, -1);
        this.K = resourceId != 16973824 ? resourceId : -1;
        obtainStyledAttributes.recycle();
    }

    public PopupWindow(View view2, int i, int i2) {
        this(view2, i, i2, false);
    }

    public PopupWindow(View view2, int i, int i2, boolean z) {
        this.h = 0;
        this.i = 1;
        this.j = true;
        this.k = false;
        this.l = true;
        this.m = -1;
        this.p = true;
        this.q = false;
        this.B = new int[2];
        this.C = new int[2];
        new Rect();
        this.H = 1000;
        this.J = false;
        this.K = -1;
        this.M = new a();
        if (view2 != null) {
            Context context = view2.getContext();
            this.a = context;
            this.b = (WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
        }
        F(view2);
        M(i);
        H(i2);
        G(z);
    }

    public void update(View view2, int i, int i2, int i3, int i4) {
        update(view2, true, i, i2, true, i3, i4);
    }

    private void update(View view2, boolean z, int i, int i2, boolean z2, int i3, int i4) {
        boolean z3;
        int i5 = i3;
        int i6 = i4;
        if (y() && this.e != null) {
            WeakReference<View> weakReference = this.L;
            boolean z4 = false;
            if (z && (this.N != i || this.O != i2)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (weakReference != null && weakReference.get() == view2 && (!z3 || this.d)) {
                if (z3) {
                    this.N = i;
                    this.O = i2;
                }
            } else {
                B(view2, i, i2);
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f.getLayoutParams();
            if (z2) {
                if (i5 == -1) {
                    i5 = this.z;
                } else {
                    this.z = i5;
                }
                if (i6 == -1) {
                    i6 = this.A;
                } else {
                    this.A = i6;
                }
            }
            int i7 = layoutParams.x;
            int i8 = layoutParams.y;
            if (z) {
                Q(t(view2, layoutParams, i, i2));
            } else {
                Q(t(view2, layoutParams, this.N, this.O));
            }
            int i9 = layoutParams.x;
            int i10 = layoutParams.y;
            update(i9, i10, i5, i6, (i7 == i9 && i8 == i10) ? true : true);
        }
    }

    public final void A(WindowManager.LayoutParams layoutParams) {
        View view2 = this.e;
        if (view2 != null && this.a != null && this.b != null) {
            if (this.D != null) {
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                int i = -2;
                i = (layoutParams2 == null || layoutParams2.height != -2) ? -1 : -1;
                c cVar = new c(this.a);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                cVar.setBackgroundDrawable(this.D);
                cVar.addView(this.e, layoutParams3);
                this.f = cVar;
            } else {
                this.f = view2;
            }
            this.z = layoutParams.width;
            this.A = layoutParams.height;
            return;
        }
        throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r3.h == 2) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        r4 = r4 | 131072;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
        if (r3.h == 1) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int o(int i) {
        int i2 = i & (-8815129);
        if (this.J) {
            i2 |= 32768;
        }
        if (!this.g) {
            i2 |= 8;
        }
        if (!this.j) {
            i2 |= 16;
        }
        if (this.k) {
            i2 |= 262144;
        }
        if (!this.l) {
            i2 |= 512;
        }
        if (z()) {
            i2 |= 8388608;
        }
        if (this.n) {
            i2 |= 256;
        }
        if (this.q) {
            i2 |= 65536;
        }
        if (this.r) {
            return i2 | 32;
        }
        return i2;
    }

    public final WindowManager.LayoutParams p(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        int i = this.u;
        this.v = i;
        layoutParams.width = i;
        int i2 = this.x;
        this.y = i2;
        layoutParams.height = i2;
        Drawable drawable = this.D;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = o(layoutParams.flags);
        layoutParams.type = this.H;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.i;
        layoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }

    public void O(View view2, int i, int i2, int i3) {
        s(view2.getWindowToken(), i, i2, i3);
    }

    public void update(int i, int i2, int i3, int i4) {
        update(i, i2, i3, i4, false);
    }

    public void q() {
        b bVar;
        if (y() && this.f != null) {
            this.c = false;
            P();
            try {
                this.b.removeView(this.f);
                View view2 = this.f;
                View view3 = this.e;
                if (view2 != view3 && (view2 instanceof ViewGroup)) {
                    ((ViewGroup) view2).removeView(view3);
                }
                this.f = null;
                bVar = this.I;
                if (bVar == null) {
                    return;
                }
            } catch (IllegalArgumentException unused) {
                View view4 = this.f;
                View view5 = this.e;
                if (view4 != view5 && (view4 instanceof ViewGroup)) {
                    ((ViewGroup) view4).removeView(view5);
                }
                this.f = null;
                bVar = this.I;
                if (bVar == null) {
                    return;
                }
            } catch (Throwable th) {
                View view6 = this.f;
                View view7 = this.e;
                if (view6 != view7 && (view6 instanceof ViewGroup)) {
                    ((ViewGroup) view6).removeView(view7);
                }
                this.f = null;
                b bVar2 = this.I;
                if (bVar2 != null) {
                    bVar2.onDismiss();
                }
                throw th;
            }
            bVar.onDismiss();
        }
    }

    public void r(View view2, int i, int i2) {
        if (!y() && this.e != null) {
            B(view2, i, i2);
            this.c = true;
            this.d = true;
            WindowManager.LayoutParams p = p(view2.getWindowToken());
            A(p);
            Q(t(view2, p, i, i2));
            int i3 = this.w;
            if (i3 < 0) {
                this.y = i3;
                p.height = i3;
            }
            int i4 = this.t;
            if (i4 < 0) {
                this.v = i4;
                p.width = i4;
            }
            p.windowAnimations = n();
            x(p);
        }
    }

    public void s(IBinder iBinder, int i, int i2, int i3) {
        if (iBinder != null && !y() && this.e != null) {
            P();
            this.c = true;
            this.d = false;
            WindowManager.LayoutParams p = p(iBinder);
            p.windowAnimations = n();
            A(p);
            if (i == 0) {
                i = 51;
            }
            p.gravity = i;
            p.x = i2;
            p.y = i3;
            int i4 = this.w;
            if (i4 < 0) {
                this.y = i4;
                p.height = i4;
            }
            int i5 = this.t;
            if (i5 < 0) {
                this.v = i5;
                p.width = i5;
            }
            x(p);
        }
    }

    public final boolean t(View view2, WindowManager.LayoutParams layoutParams, int i, int i2) {
        int height = view2.getHeight();
        view2.getLocationInWindow(this.B);
        int[] iArr = this.B;
        boolean z = false;
        layoutParams.x = iArr[0] + i;
        layoutParams.y = iArr[1] + height + i2;
        layoutParams.gravity = 51;
        view2.getLocationOnScreen(this.C);
        Rect rect = new Rect();
        view2.getWindowVisibleDisplayFrame(rect);
        View rootView = view2.getRootView();
        if (this.C[1] + height + i2 + this.A > rect.bottom || (layoutParams.x + this.z) - rootView.getWidth() > 0) {
            if (this.p) {
                int scrollX = view2.getScrollX();
                int scrollY = view2.getScrollY();
                view2.requestRectangleOnScreen(new Rect(scrollX, scrollY, this.z + scrollX + i, this.A + scrollY + view2.getHeight() + i2), true);
            }
            view2.getLocationInWindow(this.B);
            int[] iArr2 = this.B;
            layoutParams.x = iArr2[0] + i;
            layoutParams.y = iArr2[1] + view2.getHeight() + i2;
            view2.getLocationOnScreen(this.C);
            if (((rect.bottom - this.C[1]) - view2.getHeight()) - i2 < (this.C[1] - i2) - rect.top) {
                z = true;
            }
            if (z) {
                layoutParams.gravity = 83;
                layoutParams.y = (rootView.getHeight() - this.B[1]) + i2;
            } else {
                layoutParams.y = this.B[1] + view2.getHeight() + i2;
            }
        }
        if (this.o) {
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
            if (z) {
                int i8 = (this.C[1] + i2) - this.A;
                if (i8 < 0) {
                    layoutParams.y += i8;
                }
            } else {
                layoutParams.y = Math.max(layoutParams.y, rect.top);
            }
        }
        layoutParams.gravity |= LaunchTaskConstants.OTHER_PROCESS;
        return z;
    }

    public void update() {
        if (y() && this.e != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f.getLayoutParams();
            boolean z = false;
            int n = n();
            boolean z2 = true;
            if (n != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = n;
                z = true;
            }
            int o = o(layoutParams.flags);
            if (o != layoutParams.flags) {
                layoutParams.flags = o;
            } else {
                z2 = z;
            }
            if (z2) {
                this.b.updateViewLayout(this.f, layoutParams);
            }
        }
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        if (i3 != -1) {
            this.v = i3;
            M(i3);
        }
        if (i4 != -1) {
            this.y = i4;
            H(i4);
        }
        if (y() && this.e != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f.getLayoutParams();
            int i5 = this.t;
            if (i5 >= 0) {
                i5 = this.v;
            }
            boolean z2 = true;
            if (i3 != -1 && layoutParams.width != i5) {
                this.v = i5;
                layoutParams.width = i5;
                z = true;
            }
            int i6 = this.w;
            if (i6 >= 0) {
                i6 = this.y;
            }
            if (i4 != -1 && layoutParams.height != i6) {
                this.y = i6;
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
            int n = n();
            if (n != layoutParams.windowAnimations) {
                layoutParams.windowAnimations = n;
                z = true;
            }
            int o = o(layoutParams.flags);
            if (o != layoutParams.flags) {
                layoutParams.flags = o;
            } else {
                z2 = z;
            }
            if (z2) {
                this.b.updateViewLayout(this.f, layoutParams);
            }
        }
    }
}
