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
import androidx.annotation.Nullable;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.uiwidget.ExpandIconView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tieba.R;
import com.baidu.tieba.ac1;
import com.baidu.tieba.e91;
import com.baidu.tieba.fn0;
import com.baidu.tieba.g91;
import com.baidu.tieba.h91;
import com.baidu.tieba.j91;
import com.baidu.tieba.l91;
import com.baidu.tieba.pi0;
import com.baidu.tieba.q61;
import com.baidu.tieba.qi0;
import com.baidu.tieba.s91;
import com.baidu.tieba.y61;
/* loaded from: classes3.dex */
public class PanelScrollView extends FrameLayout implements View.OnTouchListener, View.OnLayoutChangeListener, pi0 {
    public static final int B = q61.c.a(ac1.a(), 18.0f);
    public VelocityTracker A;
    public int a;
    public int b;
    public int c;
    public l91 d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public ObjectAnimator j;
    public int k;
    public int l;
    public e91 m;
    public h91 n;
    public j91 o;
    public GestureDetector p;
    public d q;
    public c r;
    public qi0 s;
    public ExpandIconView t;
    public int u;
    public int v;
    public int w;
    public int x;
    public long y;
    public boolean z;

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
            PanelScrollView.this.s();
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
                webViewLayoutParams.height = (PanelScrollView.this.e - webViewLayoutParams.topMargin) + PanelScrollView.B;
                PanelScrollView.this.n.g(webViewLayoutParams);
                int i = webViewLayoutParams.topMargin;
                if (i != 0) {
                    if (i != PanelScrollView.this.g || webViewLayoutParams.height != (PanelScrollView.this.e - PanelScrollView.this.g) + PanelScrollView.B) {
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

    public int getPanelHeight() {
        return this.e - this.g;
    }

    public final void n() {
        FrameLayout.LayoutParams webViewLayoutParams = getWebViewLayoutParams();
        if (webViewLayoutParams != null) {
            if (webViewLayoutParams.topMargin == 0) {
                this.n.d();
            } else {
                this.n.u();
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
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0L;
        this.z = false;
        this.A = null;
        l();
    }

    private void setExpandIconView(int i) {
        ExpandIconView expandIconView = this.t;
        if (expandIconView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) expandIconView.getLayoutParams();
        layoutParams.topMargin = i;
        this.t.setLayoutParams(layoutParams);
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

    public void setPanelData(l91 l91Var) {
        this.d = l91Var;
        String k = l91Var.k();
        if (!TextUtils.isEmpty(k)) {
            this.m.g(k);
        }
        this.m.k(l91Var.A());
    }

    public void setScrollListener(@Nullable qi0 qi0Var) {
        this.s = qi0Var;
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
        this.n.g(webViewLayoutParams);
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
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0L;
        this.z = false;
        this.A = null;
        l();
    }

    public void k(@NonNull h91 h91Var, j91 j91Var) {
        this.n = h91Var;
        this.o = j91Var;
        h91Var.n(this);
        this.n.o(this.m);
        this.n.t(j91Var);
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
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0L;
        this.z = false;
        this.A = null;
        l();
    }

    public final void l() {
        this.m = new e91();
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
        this.n.s(i, z);
        if (!z) {
            if (i == 1) {
                fn0.a().a(new g91(4, this.d.a()));
                l91 l91Var = this.d;
                if (l91Var != null) {
                    s91.a(ClogBuilder.LogType.DAZZLE_TRANS_SLIDING_COUNT, "", "down", l91Var.f());
                }
            } else if (i == 2) {
                fn0.a().a(new g91(3, this.d.a()));
                l91 l91Var2 = this.d;
                if (l91Var2 != null) {
                    s91.a(ClogBuilder.LogType.DAZZLE_TRANS_SLIDING_COUNT, "", MapBundleKey.OfflineMapKey.OFFLINE_UPDATE, l91Var2.f());
                }
            }
        }
    }

    public final void o() {
        if (!this.d.o() || !(getContext() instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) getContext();
        FrameLayout.LayoutParams webViewLayoutParams = getWebViewLayoutParams();
        if (webViewLayoutParams != null) {
            if (webViewLayoutParams.topMargin == 0) {
                y61.d(activity.getWindow(), 17170443);
                if (Build.VERSION.SDK_INT >= 23) {
                    activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() | 8192);
                    return;
                }
                return;
            }
            y61.d(activity.getWindow(), this.h);
            if (Build.VERSION.SDK_INT >= 23) {
                activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() & (-8193));
            }
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        o();
        n();
        if (this.n.m()) {
            FrameLayout.LayoutParams webViewLayoutParams = getWebViewLayoutParams();
            if (webViewLayoutParams != null) {
                int i9 = webViewLayoutParams.topMargin;
                if (i9 == 0) {
                    m(2, false);
                } else if (i9 == this.g) {
                    m(1, false);
                }
            }
            this.n.k(false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        if (this.A == null) {
            this.A = VelocityTracker.obtain();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.z = false;
                        this.i = false;
                    }
                } else {
                    this.A.addMovement(motionEvent);
                    this.A.computeCurrentVelocity(1000);
                    this.w = ((int) motionEvent.getRawX()) - this.u;
                    this.x = ((int) motionEvent.getRawY()) - this.v;
                    this.u = (int) motionEvent.getRawX();
                    this.v = (int) motionEvent.getRawY();
                    if (Math.abs(this.w) >= Math.abs(this.x)) {
                        return false;
                    }
                    int i = this.a;
                    if (i == 2) {
                        boolean v = v(true, this.x);
                        if (v && !this.z) {
                            int i2 = this.b;
                            if (i2 != -1) {
                                m(i2, true);
                            }
                            this.z = true;
                        }
                        return v;
                    } else if (i != 1) {
                        return true;
                    } else {
                        boolean v2 = v(false, this.x);
                        if (v2 && !this.z) {
                            int i3 = this.b;
                            if (i3 != -1) {
                                m(i3, true);
                            }
                            this.z = true;
                        }
                        return v2;
                    }
                }
            } else {
                int i4 = this.a;
                if (i4 == 0) {
                    if (this.x >= 20) {
                        return false;
                    }
                    if (System.currentTimeMillis() - this.y < ViewConfiguration.getLongPressTimeout()) {
                        if (this.m.d()) {
                            this.n.a();
                            s91.a(ClogBuilder.LogType.FREE_CLICK, "", "top_area", this.d.f());
                            return true;
                        }
                        j91 j91Var = this.o;
                        if (j91Var != null) {
                            j91Var.a(0);
                        }
                    }
                    return true;
                }
                if (i4 == 1 || i4 == 2) {
                    if (!this.m.a() && this.b == 1) {
                        if (this.z && this.A.getYVelocity() > 800.0f) {
                            if (!this.m.b()) {
                                this.z = false;
                                this.o.a(2);
                                return false;
                            }
                        } else if (this.z && this.A.getYVelocity() < -800.0f && !this.m.c()) {
                            l91 l91Var = this.d;
                            if (l91Var != null && l91Var.s()) {
                                this.z = false;
                                return false;
                            }
                            FrameLayout.LayoutParams webViewLayoutParams = getWebViewLayoutParams();
                            if (webViewLayoutParams == null) {
                                this.z = false;
                                return false;
                            }
                            this.i = true;
                            u(160, webViewLayoutParams.topMargin + B);
                            this.z = false;
                            return false;
                        }
                    }
                    if (this.z) {
                        FrameLayout.LayoutParams webViewLayoutParams2 = getWebViewLayoutParams();
                        if (webViewLayoutParams2 == null) {
                            this.z = false;
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
                            setExpandIconView(this.g - q61.c.a(getContext(), 17.0f));
                        }
                        int i7 = this.g;
                        if (i5 > i7 + ((this.e - i7) / 4)) {
                            this.o.a(2);
                        }
                        int i8 = this.g;
                        if (i5 > i8 && i5 < ((this.e - i8) / 4) + i8) {
                            this.i = true;
                            u(160, i5 - i8);
                            setExpandIconView(this.g - q61.c.a(getContext(), 17.0f));
                        }
                    }
                }
                this.z = false;
            }
            return false;
        }
        this.w = 0;
        this.x = 0;
        this.y = System.currentTimeMillis();
        this.a = p((int) motionEvent.getY());
        this.b = q();
        this.v = (int) motionEvent.getRawY();
        this.z = false;
        this.A.clear();
        this.A.addMovement(motionEvent);
        return false;
    }

    public void r() {
        this.n.c(this);
        if (!(getContext() instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) getContext();
        y61.d(activity.getWindow(), this.h);
        if (Build.VERSION.SDK_INT >= 23) {
            activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() & (-8193));
        }
    }

    public final void s() {
        this.f = q61.c.a(ac1.a(), 100.0f);
        if (this.d.g() == 0) {
            if (this.d.h() < 0.0d || this.d.h() > 1.0d) {
                this.d.I(0.7d);
            }
            this.g = (int) (this.e * (1.0d - this.d.h()));
        } else {
            if (this.d.h() <= 0.0d) {
                this.d.I(1.95d);
            }
            this.g = (int) (q61.c.e(ac1.a()) / this.d.h());
        }
        this.n.i((this.e - this.g) + B);
        this.n.e(this.g);
        this.m.m(this.e);
        this.m.l(this.g);
        this.n.r(this);
        if (this.d.x()) {
            ExpandIconView expandIconView = new ExpandIconView(getContext());
            this.t = expandIconView;
            expandIconView.setFraction(0.0f, false);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.height = q61.c.a(getContext(), 24.0f);
            layoutParams.width = q61.c.a(getContext(), 24.0f);
            layoutParams.gravity = 1;
            layoutParams.topMargin = this.g - q61.c.a(getContext(), 17.0f);
            addView(this.t, layoutParams);
        }
    }

    public final boolean v(boolean z, int i) {
        int i2;
        l91 l91Var;
        if (this.m.a()) {
            return false;
        }
        FrameLayout.LayoutParams webViewLayoutParams = getWebViewLayoutParams();
        FrameLayout.LayoutParams layoutParams = null;
        ExpandIconView expandIconView = this.t;
        if (expandIconView != null) {
            layoutParams = (FrameLayout.LayoutParams) expandIconView.getLayoutParams();
        }
        if (webViewLayoutParams == null) {
            return false;
        }
        if (i < 0 && webViewLayoutParams.topMargin + i < this.g && (l91Var = this.d) != null && l91Var.s()) {
            return false;
        }
        if (this.c == 0 && this.b == 2 && this.a == 2) {
            return false;
        }
        int i3 = webViewLayoutParams.topMargin;
        if (i3 + i >= this.g && i3 + i < this.e) {
            if (this.m.b()) {
                return false;
            }
            if (this.c == 0 && this.a == 2 && webViewLayoutParams.topMargin == this.g) {
                return false;
            }
            if (z) {
                if (!this.n.h()) {
                    return false;
                }
                this.n.e(webViewLayoutParams.topMargin + i);
                if (layoutParams != null) {
                    setExpandIconView(layoutParams.topMargin + i);
                }
            } else {
                this.n.e(webViewLayoutParams.topMargin + i);
                if (layoutParams != null) {
                    setExpandIconView(layoutParams.topMargin + i);
                }
            }
            if (this.e > 0) {
                float panelHeight = (getPanelHeight() - (i2 - webViewLayoutParams.topMargin)) / (getPanelHeight() * 1.0f);
                qi0 qi0Var = this.s;
                if (qi0Var != null) {
                    qi0Var.a(panelHeight);
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
                    if (!this.n.h()) {
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
            int i4 = webViewLayoutParams.topMargin;
            int i5 = this.g;
            if (i4 > i5) {
                webViewLayoutParams.topMargin = i5;
            }
            if (webViewLayoutParams.topMargin < 0) {
                webViewLayoutParams.topMargin = 0;
            }
            int i6 = webViewLayoutParams.height;
            int i7 = this.e;
            int i8 = B;
            if (i6 != i7 + i8) {
                webViewLayoutParams.height = i7 + i8;
            }
            this.n.g(webViewLayoutParams);
            if (layoutParams != null) {
                setExpandIconView(layoutParams.topMargin);
            }
            return true;
        }
    }
}
