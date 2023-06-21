package com.baidu.nadcore.webpanel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.uiwidget.ExpandIconView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tieba.R;
import com.baidu.tieba.a91;
import com.baidu.tieba.d61;
import com.baidu.tieba.n81;
import com.baidu.tieba.o81;
import com.baidu.tieba.p81;
import com.baidu.tieba.qn0;
import com.baidu.tieba.r81;
import com.baidu.tieba.t81;
import com.baidu.tieba.tc1;
import com.baidu.tieba.z81;
/* loaded from: classes3.dex */
public class PanelScrollView extends FrameLayout implements View.OnTouchListener, View.OnLayoutChangeListener {
    public static final int A = d61.c.a(tc1.a(), 18.0f);
    public int a;
    public int b;
    public int c;
    public t81 d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public ObjectAnimator j;
    public int k;
    public int l;
    public n81 m;
    public p81 n;
    public r81 o;
    public GestureDetector p;
    public d q;
    public c r;
    public ExpandIconView s;
    public int t;
    public int u;
    public int v;
    public int w;
    public long x;
    public boolean y;
    public VelocityTracker z;

    /* loaded from: classes3.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            PanelScrollView panelScrollView = PanelScrollView.this;
            panelScrollView.e = panelScrollView.getMeasuredHeight();
            PanelScrollView.this.t();
            ViewTreeObserver viewTreeObserver = PanelScrollView.this.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            PanelScrollView.this.l = 0;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            PanelScrollView.this.l = 0;
            FrameLayout.LayoutParams webViewLayoutParams = PanelScrollView.this.getWebViewLayoutParams();
            if (webViewLayoutParams != null) {
                webViewLayoutParams.height = (PanelScrollView.this.e - webViewLayoutParams.topMargin) + PanelScrollView.A;
                PanelScrollView.this.n.i(webViewLayoutParams);
                int i = webViewLayoutParams.topMargin;
                if (i != 0) {
                    if (i != PanelScrollView.this.g || webViewLayoutParams.height != (PanelScrollView.this.e - PanelScrollView.this.g) + PanelScrollView.A) {
                        return;
                    }
                    PanelScrollView.this.m(1, false);
                    return;
                }
                PanelScrollView.this.m(2, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends GestureDetector.SimpleOnGestureListener {
        public final PanelScrollView a;
        public float b = 0.0f;
        public float c = 0.0f;

        public e(PanelScrollView panelScrollView) {
            this.a = panelScrollView;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            PanelScrollView panelScrollView = this.a;
            if (panelScrollView != null && panelScrollView.r != null) {
                this.a.q.a();
            }
            return super.onSingleTapUp(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (this.b != motionEvent.getX() || this.c != motionEvent.getY()) {
                this.b = motionEvent.getX();
                this.c = motionEvent.getY();
                PanelScrollView panelScrollView = this.a;
                if (panelScrollView != null && panelScrollView.r != null) {
                    this.a.r.a();
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams getWebViewLayoutParams() {
        if (this.n.b() == null) {
            return null;
        }
        ViewGroup.LayoutParams b2 = this.n.b();
        if (!(b2 instanceof FrameLayout.LayoutParams)) {
            return null;
        }
        return (FrameLayout.LayoutParams) b2;
    }

    @Keep
    public int getAnimateValue() {
        return this.k;
    }

    public final void n() {
        FrameLayout.LayoutParams webViewLayoutParams = getWebViewLayoutParams();
        if (webViewLayoutParams != null) {
            if (webViewLayoutParams.topMargin == 0) {
                this.n.e();
            } else {
                this.n.v();
            }
        }
    }

    public final int q() {
        FrameLayout.LayoutParams webViewLayoutParams = getWebViewLayoutParams();
        if (webViewLayoutParams == null) {
            return -1;
        }
        int i = webViewLayoutParams.topMargin;
        if (i == 0) {
            return 2;
        }
        if (i != this.g) {
            return -1;
        }
        return 1;
    }

    public PanelScrollView(Context context) {
        super(context);
        this.a = 0;
        this.b = -1;
        this.c = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.i = false;
        this.k = 0;
        this.l = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0L;
        this.y = false;
        this.z = null;
        l();
    }

    private void setExpandIconView(int i) {
        ExpandIconView expandIconView = this.s;
        if (expandIconView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) expandIconView.getLayoutParams();
        layoutParams.topMargin = i;
        this.s.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.p.onTouchEvent(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final int p(int i) {
        int i2;
        FrameLayout.LayoutParams webViewLayoutParams = getWebViewLayoutParams();
        if (webViewLayoutParams == null || i < (i2 = webViewLayoutParams.topMargin)) {
            return 0;
        }
        if (i < i2 + this.f) {
            return 1;
        }
        return 2;
    }

    @Keep
    public void setAnimateValue(int i) {
        this.k = i;
        w(i - this.l);
        this.l = i;
    }

    public void setOnGestureScrollListener(@NonNull c cVar) {
        this.r = cVar;
    }

    public void setOnGestureSingleTapUpListener(@NonNull d dVar) {
        this.q = dVar;
    }

    public void setPanelData(t81 t81Var) {
        this.d = t81Var;
        String g = t81Var.g();
        if (!TextUtils.isEmpty(g)) {
            this.m.g(g);
        }
        this.m.k(t81Var.u());
    }

    public final void w(int i) {
        FrameLayout.LayoutParams webViewLayoutParams = getWebViewLayoutParams();
        if (webViewLayoutParams == null) {
            return;
        }
        if (this.i) {
            int i2 = webViewLayoutParams.topMargin - i;
            webViewLayoutParams.topMargin = i2;
            if (i2 < 0) {
                webViewLayoutParams.topMargin = 0;
            }
        } else {
            int i3 = webViewLayoutParams.topMargin + i;
            webViewLayoutParams.topMargin = i3;
            int i4 = this.g;
            if (i3 > i4) {
                webViewLayoutParams.topMargin = i4;
            }
        }
        this.n.i(webViewLayoutParams);
        o();
        n();
    }

    public PanelScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.b = -1;
        this.c = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.i = false;
        this.k = 0;
        this.l = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0L;
        this.y = false;
        this.z = null;
        l();
    }

    public void k(@NonNull p81 p81Var, r81 r81Var) {
        this.n = p81Var;
        this.o = r81Var;
        p81Var.o(this);
        this.n.p(this.m);
        this.n.u(r81Var);
    }

    public final void u(int i, int i2) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "animateValue", 0, i2);
        this.j = ofInt;
        ofInt.setDuration(i);
        this.j.start();
        this.j.addListener(new b());
    }

    public PanelScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = -1;
        this.c = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.i = false;
        this.k = 0;
        this.l = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0L;
        this.y = false;
        this.z = null;
        l();
    }

    public final void l() {
        this.m = new n81();
        setClipChildren(false);
        setLayerType(2, null);
        setOnTouchListener(this);
        getViewTreeObserver().addOnPreDrawListener(new a());
        if (Build.VERSION.SDK_INT >= 21) {
            this.h = ((Activity) getContext()).getWindow().getStatusBarColor();
        } else {
            this.h = ((Activity) getContext()).getResources().getColor(R.color.nad_transparent);
        }
        this.p = new GestureDetector(getContext(), new e(this));
    }

    public final void m(int i, boolean z) {
        this.n.t(i, z);
        if (!z) {
            if (i == 1) {
                qn0.a().a(new o81(4, this.d.a()));
                t81 t81Var = this.d;
                if (t81Var != null) {
                    z81.a(ClogBuilder.LogType.DAZZLE_TRANS_SLIDING_COUNT, "", "down", t81Var.c());
                }
            } else if (i == 2) {
                qn0.a().a(new o81(3, this.d.a()));
                t81 t81Var2 = this.d;
                if (t81Var2 != null) {
                    z81.a(ClogBuilder.LogType.DAZZLE_TRANS_SLIDING_COUNT, "", MapBundleKey.OfflineMapKey.OFFLINE_UPDATE, t81Var2.c());
                }
            }
        }
    }

    public final void o() {
        if (!this.d.j() || !(getContext() instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) getContext();
        FrameLayout.LayoutParams webViewLayoutParams = getWebViewLayoutParams();
        if (webViewLayoutParams != null) {
            if (webViewLayoutParams.topMargin == 0) {
                a91.d(activity.getWindow(), 17170443);
                if (Build.VERSION.SDK_INT >= 23) {
                    activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() | 8192);
                    return;
                }
                return;
            }
            a91.d(activity.getWindow(), this.h);
            if (Build.VERSION.SDK_INT >= 23) {
                activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() & (-8193));
            }
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        o();
        n();
        if (this.n.n()) {
            FrameLayout.LayoutParams webViewLayoutParams = getWebViewLayoutParams();
            if (webViewLayoutParams != null) {
                int i9 = webViewLayoutParams.topMargin;
                if (i9 == 0) {
                    m(2, false);
                } else if (i9 == this.g) {
                    m(1, false);
                }
            }
            this.n.m(false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        if (this.z == null) {
            this.z = VelocityTracker.obtain();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.y = false;
                        this.i = false;
                    }
                } else {
                    this.z.addMovement(motionEvent);
                    this.z.computeCurrentVelocity(1000);
                    this.v = ((int) motionEvent.getRawX()) - this.t;
                    this.w = ((int) motionEvent.getRawY()) - this.u;
                    this.t = (int) motionEvent.getRawX();
                    this.u = (int) motionEvent.getRawY();
                    if (Math.abs(this.v) >= Math.abs(this.w)) {
                        return false;
                    }
                    int i = this.a;
                    if (i == 2) {
                        boolean v = v(true, this.w);
                        if (v && !this.y) {
                            int i2 = this.b;
                            if (i2 != -1) {
                                m(i2, true);
                            }
                            this.y = true;
                        }
                        return v;
                    } else if (i != 1) {
                        return true;
                    } else {
                        boolean v2 = v(false, this.w);
                        if (v2 && !this.y) {
                            int i3 = this.b;
                            if (i3 != -1) {
                                m(i3, true);
                            }
                            this.y = true;
                        }
                        return v2;
                    }
                }
            } else {
                int i4 = this.a;
                if (i4 == 0) {
                    if (this.w >= 20) {
                        return false;
                    }
                    if (System.currentTimeMillis() - this.x < ViewConfiguration.getLongPressTimeout()) {
                        if (this.m.d()) {
                            this.n.a();
                            z81.a(ClogBuilder.LogType.FREE_CLICK, "", "top_area", this.d.c());
                            return true;
                        }
                        r81 r81Var = this.o;
                        if (r81Var != null) {
                            r81Var.a(0);
                        }
                    }
                    return true;
                }
                if (i4 == 1 || i4 == 2) {
                    if (!this.m.a() && this.b == 1) {
                        if (this.y && this.z.getYVelocity() > 800.0f) {
                            if (!this.m.b()) {
                                this.y = false;
                                this.o.a(2);
                                return false;
                            }
                        } else if (this.y && this.z.getYVelocity() < -800.0f && !this.m.c()) {
                            t81 t81Var = this.d;
                            if (t81Var != null && t81Var.n()) {
                                this.y = false;
                                return false;
                            }
                            FrameLayout.LayoutParams webViewLayoutParams = getWebViewLayoutParams();
                            if (webViewLayoutParams == null) {
                                this.y = false;
                                return false;
                            }
                            this.i = true;
                            u(160, webViewLayoutParams.topMargin + A);
                            this.y = false;
                            return false;
                        }
                    }
                    if (this.y) {
                        FrameLayout.LayoutParams webViewLayoutParams2 = getWebViewLayoutParams();
                        if (webViewLayoutParams2 == null) {
                            this.y = false;
                            return false;
                        }
                        int i5 = webViewLayoutParams2.topMargin;
                        if (i5 <= this.g / 2 && i5 >= 0) {
                            this.i = true;
                            u(160, i5);
                        }
                        int i6 = this.g;
                        if (i5 > i6 / 2 && i5 < i6) {
                            this.i = false;
                            u(160, i6 - i5);
                            setExpandIconView(this.g - d61.c.a(getContext(), 17.0f));
                        }
                        int i7 = this.g;
                        if (i5 > i7 + ((this.e - i7) / 4)) {
                            this.o.a(2);
                        }
                        int i8 = this.g;
                        if (i5 > i8 && i5 < ((this.e - i8) / 4) + i8) {
                            this.i = true;
                            u(160, i5 - i8);
                            setExpandIconView(this.g - d61.c.a(getContext(), 17.0f));
                        }
                    }
                }
                this.y = false;
            }
            return false;
        }
        this.v = 0;
        this.w = 0;
        this.x = System.currentTimeMillis();
        this.a = p((int) motionEvent.getY());
        this.b = q();
        this.u = (int) motionEvent.getRawY();
        this.y = false;
        this.z.clear();
        this.z.addMovement(motionEvent);
        return false;
    }

    public void r() {
        this.n.c(this);
        if (!(getContext() instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) getContext();
        a91.d(activity.getWindow(), this.h);
        if (Build.VERSION.SDK_INT >= 23) {
            activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() & (-8193));
        }
    }

    public final void t() {
        this.f = d61.c.a(tc1.a(), 100.0f);
        if (this.d.d() == 0) {
            if (this.d.e() < 0.0d || this.d.e() > 1.0d) {
                this.d.z(0.7d);
            }
            this.g = (int) (this.e * (1.0d - this.d.e()));
        } else {
            if (this.d.e() <= 0.0d) {
                this.d.z(1.95d);
            }
            this.g = (int) (d61.c.e(tc1.a()) / this.d.e());
        }
        this.n.k((this.e - this.g) + A);
        this.n.g(this.g);
        this.m.m(this.e);
        this.m.l(this.g);
        this.n.s(this);
        if (this.d.r()) {
            ExpandIconView expandIconView = new ExpandIconView(getContext());
            this.s = expandIconView;
            expandIconView.setFraction(0.0f, false);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.height = d61.c.a(getContext(), 24.0f);
            layoutParams.width = d61.c.a(getContext(), 24.0f);
            layoutParams.gravity = 1;
            layoutParams.topMargin = this.g - d61.c.a(getContext(), 17.0f);
            addView(this.s, layoutParams);
        }
    }

    public final boolean v(boolean z, int i) {
        t81 t81Var;
        if (this.m.a()) {
            return false;
        }
        FrameLayout.LayoutParams webViewLayoutParams = getWebViewLayoutParams();
        FrameLayout.LayoutParams layoutParams = null;
        ExpandIconView expandIconView = this.s;
        if (expandIconView != null) {
            layoutParams = (FrameLayout.LayoutParams) expandIconView.getLayoutParams();
        }
        if (webViewLayoutParams == null) {
            return false;
        }
        if (i < 0 && webViewLayoutParams.topMargin + i < this.g && (t81Var = this.d) != null && t81Var.n()) {
            return false;
        }
        if (this.c == 0 && this.b == 2 && this.a == 2) {
            return false;
        }
        int i2 = webViewLayoutParams.topMargin;
        if (i2 + i >= this.g && i2 + i < this.e) {
            if (this.m.b()) {
                return false;
            }
            if (this.c == 0 && this.a == 2 && webViewLayoutParams.topMargin == this.g) {
                return false;
            }
            if (z) {
                if (!this.n.j()) {
                    return false;
                }
                this.n.g(webViewLayoutParams.topMargin + i);
                if (layoutParams != null) {
                    setExpandIconView(layoutParams.topMargin + i);
                }
            } else {
                this.n.g(webViewLayoutParams.topMargin + i);
                if (layoutParams != null) {
                    setExpandIconView(layoutParams.topMargin + i);
                }
            }
            return true;
        } else if (i < 0 && webViewLayoutParams.topMargin <= 0) {
            return false;
        } else {
            if (i > 0) {
                if (this.m.b()) {
                    return false;
                }
                if (z) {
                    if (!this.n.j()) {
                        return false;
                    }
                    webViewLayoutParams.topMargin += i;
                    if (layoutParams != null) {
                        layoutParams.topMargin += i;
                    }
                } else {
                    webViewLayoutParams.topMargin += i;
                    if (layoutParams != null) {
                        layoutParams.topMargin += i;
                    }
                }
            } else if (i >= 0 || this.m.c()) {
                return false;
            } else {
                webViewLayoutParams.topMargin += i;
                if (layoutParams != null) {
                    layoutParams.topMargin += i;
                }
            }
            int i3 = webViewLayoutParams.topMargin;
            int i4 = this.g;
            if (i3 > i4) {
                webViewLayoutParams.topMargin = i4;
            }
            if (webViewLayoutParams.topMargin < 0) {
                webViewLayoutParams.topMargin = 0;
            }
            int i5 = webViewLayoutParams.height;
            int i6 = this.e;
            int i7 = A;
            if (i5 != i6 + i7) {
                webViewLayoutParams.height = i6 + i7;
            }
            this.n.i(webViewLayoutParams);
            if (layoutParams != null) {
                setExpandIconView(layoutParams.topMargin);
            }
            return true;
        }
    }
}
