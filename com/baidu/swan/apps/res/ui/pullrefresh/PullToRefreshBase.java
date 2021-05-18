package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Scroller;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    public static final boolean z = k.f43025a;

    /* renamed from: e  reason: collision with root package name */
    public HEADERTYPE f11277e;

    /* renamed from: f  reason: collision with root package name */
    public float f11278f;

    /* renamed from: g  reason: collision with root package name */
    public h<T> f11279g;

    /* renamed from: h  reason: collision with root package name */
    public LoadingLayout f11280h;

    /* renamed from: i  reason: collision with root package name */
    public LoadingLayout f11281i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public ILoadingLayout$State r;
    public ILoadingLayout$State s;
    public T t;
    public FrameLayout u;
    public int v;
    public Scroller w;
    public int x;
    public d.a.i0.a.z1.a.d.a<T> y;

    /* loaded from: classes3.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER,
        Common_STYLE_HEADER,
        SWAN_APP_HEADER
    }

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            PullToRefreshBase.this.B();
            PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PullToRefreshBase.this.requestLayout();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                PullToRefreshBase.this.f11280h.setState(ILoadingLayout$State.RESET);
            }
        }

        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PullToRefreshBase.this.postDelayed(new a(), PullToRefreshBase.this.getSmoothScrollDuration());
            PullToRefreshBase.this.E();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11286e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Runnable f11287f;

        public d(boolean z, Runnable runnable) {
            this.f11286e = z;
            this.f11287f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = -PullToRefreshBase.this.f11280h.getRefreshingHeight();
            int i3 = this.f11286e ? 300 : 0;
            PullToRefreshBase.this.L();
            PullToRefreshBase.this.J(i2, i3);
            Runnable runnable = this.f11287f;
            if (runnable != null) {
                PullToRefreshBase.this.post(runnable);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PullToRefreshBase.this.f11279g.b(PullToRefreshBase.this);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PullToRefreshBase.this.f11279g.a(PullToRefreshBase.this);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11291a;

        static {
            int[] iArr = new int[HEADERTYPE.values().length];
            f11291a = iArr;
            try {
                iArr[HEADERTYPE.STANDARD_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11291a[HEADERTYPE.BIG_BG_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11291a[HEADERTYPE.ROTATE_HEADER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11291a[HEADERTYPE.Common_STYLE_HEADER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11291a[HEADERTYPE.SWAN_APP_HEADER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface h<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);

        void b(PullToRefreshBase<V> pullToRefreshBase);
    }

    public PullToRefreshBase(Context context, d.a.i0.a.z1.a.d.a<T> aVar, HEADERTYPE headertype) {
        super(context);
        this.f11277e = HEADERTYPE.Common_STYLE_HEADER;
        this.f11278f = -1.0f;
        this.l = true;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.r = iLoadingLayout$State;
        this.s = iLoadingLayout$State;
        this.v = -1;
        this.x = -1;
        this.y = aVar;
        this.f11277e = headertype;
        m(context, null);
    }

    private boolean getNgWebViewHeightSwitch() {
        d.a.i0.a.c1.a.Z().getSwitch("swan_app_refresh_ngwebview_height_switch", false);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z2) {
        this.o = z2;
    }

    public void A(float f2) {
        int scrollYValue = getScrollYValue();
        if (f2 < 0.0f && scrollYValue - f2 >= 0.0f) {
            H(0, 0);
            LoadingLayout loadingLayout = this.f11280h;
            if (loadingLayout != null) {
                loadingLayout.e(0);
            }
        } else if (this.v <= 0 || f2 <= 0.0f || Math.abs(scrollYValue) < this.v) {
            G(0, -((int) f2));
            LoadingLayout loadingLayout2 = this.f11280h;
            if (loadingLayout2 != null) {
                loadingLayout2.e(-getScrollY());
                if (this.j != 0) {
                    this.f11280h.d(Math.abs(getScrollYValue()) / this.j);
                }
            }
            int abs = Math.abs(getScrollYValue());
            if (!r() || s()) {
                return;
            }
            LoadingLayout loadingLayout3 = this.f11280h;
            if (loadingLayout3 != null && abs > loadingLayout3.getCanRefreshPullLength()) {
                this.r = ILoadingLayout$State.RELEASE_TO_REFRESH;
            } else {
                this.r = ILoadingLayout$State.PULL_TO_REFRESH;
            }
            LoadingLayout loadingLayout4 = this.f11280h;
            if (loadingLayout4 != null) {
                loadingLayout4.setState(this.r);
            }
            y(this.r, true);
        }
    }

    public final void B() {
        LoadingLayout loadingLayout = this.f11280h;
        int contentSize = loadingLayout != null ? loadingLayout.getContentSize() : 0;
        LoadingLayout loadingLayout2 = this.f11281i;
        int contentSize2 = loadingLayout2 != null ? loadingLayout2.getContentSize() : 0;
        if (contentSize < 0) {
            contentSize = 0;
        }
        if (contentSize2 < 0) {
            contentSize2 = 0;
        }
        this.j = contentSize;
        this.k = contentSize2;
        LoadingLayout loadingLayout3 = this.f11280h;
        int measuredHeight = loadingLayout3 != null ? loadingLayout3.getMeasuredHeight() : 0;
        LoadingLayout loadingLayout4 = this.f11281i;
        int measuredHeight2 = loadingLayout4 != null ? loadingLayout4.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.k;
        }
        setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
    }

    public void C(int i2, int i3) {
        FrameLayout frameLayout = this.u;
        if (frameLayout != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            if (layoutParams.height != i3) {
                layoutParams.height = i3;
                this.u.requestLayout();
            }
        }
    }

    public void D() {
        int abs = Math.abs(getScrollYValue());
        boolean q = q();
        if (q && abs <= this.k) {
            I(0);
        } else if (q) {
            I(this.k);
        } else {
            I(0);
        }
    }

    public void E() {
        int abs = Math.abs(getScrollYValue());
        boolean s = s();
        if (s && abs <= this.f11280h.getRefreshingHeight()) {
            I(0);
        } else if (s) {
            I(-this.f11280h.getRefreshingHeight());
        } else {
            I(0);
        }
    }

    public void F() {
    }

    public final void G(int i2, int i3) {
        scrollBy(i2, i3);
    }

    public final void H(int i2, int i3) {
        scrollTo(i2, i3);
    }

    public final void I(int i2) {
        J(i2, getSmoothScrollDuration());
    }

    public final void J(int i2, int i3) {
        this.w.forceFinished(true);
        int scrollY = getScrollY();
        int i4 = i2 - scrollY;
        if (i4 != 0) {
            this.w.startScroll(0, scrollY, 0, i4, i3);
            postInvalidate();
        }
    }

    public void K() {
        if (q()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.REFRESHING;
        this.s = iLoadingLayout$State;
        y(iLoadingLayout$State, false);
        LoadingLayout loadingLayout = this.f11281i;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
        if (this.f11279g != null) {
            postDelayed(new f(), getSmoothScrollDuration());
        }
    }

    public void L() {
        M(true);
    }

    public final void M(boolean z2) {
        if (s()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.REFRESHING;
        this.r = iLoadingLayout$State;
        y(iLoadingLayout$State, true);
        LoadingLayout loadingLayout = this.f11280h;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
        if (!z2 || this.f11279g == null) {
            return;
        }
        postDelayed(new e(), getSmoothScrollDuration());
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.w.computeScrollOffset()) {
            int currY = this.w.getCurrY();
            scrollTo(0, currY);
            this.f11280h.e(-currY);
            this.f11281i.d(Math.abs(getScrollYValue()) / this.k);
            postInvalidate();
        }
    }

    public void f(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.f11280h;
        LoadingLayout loadingLayout2 = this.f11281i;
        if (loadingLayout != null) {
            if (this == loadingLayout.getParent()) {
                removeView(loadingLayout);
            }
            addView(loadingLayout, 0, layoutParams);
        }
        if (loadingLayout2 != null) {
            if (this == loadingLayout2.getParent()) {
                removeView(loadingLayout2);
            }
            addView(loadingLayout2, -1, layoutParams);
        }
    }

    public void g(Context context, T t) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.u = frameLayout;
        frameLayout.addView(t, -1, -1);
        addView(this.u, new LinearLayout.LayoutParams(-1, getNgWebViewHeightSwitch() ? 10 : -1));
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.f11281i;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.f11280h;
    }

    public d.a.i0.a.z1.a.d.a<T> getRefreshableFactory() {
        return this.y;
    }

    public T getRefreshableView() {
        return this.t;
    }

    public int getScrollYValue() {
        return getScrollY();
    }

    public int getSmoothScrollDuration() {
        return 300;
    }

    public LoadingLayout h(Context context, AttributeSet attributeSet) {
        return new FooterLoadingLayout(context);
    }

    public LoadingLayout i(Context context, AttributeSet attributeSet) {
        LoadingLayout headerLoadingLayout;
        F();
        int i2 = g.f11291a[this.f11277e.ordinal()];
        if (i2 == 1) {
            headerLoadingLayout = new HeaderLoadingLayout(context);
        } else if (i2 == 2) {
            headerLoadingLayout = new BigBgHeaderLoadingLayout(context);
        } else if (i2 == 3) {
            headerLoadingLayout = new RotateLoadingLayout(context);
        } else if (i2 != 4) {
            headerLoadingLayout = i2 != 5 ? null : new NeutralHeaderLoadingLayout(context);
        } else {
            headerLoadingLayout = new CommonHeaderLoadingLayout(context);
        }
        return headerLoadingLayout == null ? new HeaderLoadingLayout(context) : headerLoadingLayout;
    }

    public abstract T j(Context context, AttributeSet attributeSet);

    public void k(boolean z2, long j) {
        l(z2, j, null);
    }

    public void l(boolean z2, long j, Runnable runnable) {
        postDelayed(new d(z2, runnable), j);
    }

    public final void m(Context context, AttributeSet attributeSet) {
        this.w = new Scroller(context);
        super.setOrientation(1);
        this.q = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f11280h = i(context, attributeSet);
        this.f11281i = h(context, attributeSet);
        T j = j(context, attributeSet);
        this.t = j;
        if (z && j == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        T t = this.t;
        if (t != null) {
            g(context, t);
        }
        f(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public final boolean n() {
        return this.o;
    }

    public boolean o() {
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        T t;
        boolean z2 = false;
        if (n()) {
            if (p() || r()) {
                int action = motionEvent.getAction();
                if (action != 3) {
                    if (action != 1) {
                        if (action == 0 || !this.p) {
                            int actionIndex = motionEvent.getActionIndex();
                            if (action == 0) {
                                this.x = motionEvent.getPointerId(actionIndex);
                                this.f11278f = motionEvent.getY();
                                this.p = false;
                            } else if (action == 2) {
                                int findPointerIndex = motionEvent.findPointerIndex(this.x);
                                if (findPointerIndex < 0) {
                                    this.p = false;
                                    return false;
                                }
                                float y = motionEvent.getY(findPointerIndex) - this.f11278f;
                                if (Math.abs(y) > this.q || s() || q()) {
                                    this.f11278f = motionEvent.getY(findPointerIndex);
                                    if (r() && t()) {
                                        z2 = (Math.abs(getScrollYValue()) > 0 || y > 0.5f) ? true : true;
                                        this.p = z2;
                                        if (z2 && o() && (t = this.t) != null) {
                                            t.onTouchEvent(motionEvent);
                                        }
                                    } else if (p() && u()) {
                                        this.p = (Math.abs(getScrollYValue()) > 0 || y < -0.5f) ? true : true;
                                    }
                                }
                            } else if (action == 5) {
                                this.x = motionEvent.getPointerId(actionIndex);
                                this.f11278f = motionEvent.getY(actionIndex);
                                this.p = false;
                            } else if (action == 6) {
                                int action2 = (motionEvent.getAction() & 65280) >> 8;
                                if (motionEvent.getPointerId(action2) == this.x) {
                                    int i2 = action2 != 0 ? 0 : 1;
                                    this.x = motionEvent.getPointerId(i2);
                                    this.f11278f = (int) motionEvent.getY(i2);
                                    this.p = false;
                                }
                            }
                            return this.p;
                        }
                        return true;
                    }
                }
                this.p = false;
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        B();
        C(i2, i3);
        post(new b());
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        int action = motionEvent.getAction();
        boolean z2 = false;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.x);
                    if (findPointerIndex < 0) {
                        this.p = false;
                        return false;
                    }
                    float y = motionEvent.getY(findPointerIndex) - this.f11278f;
                    this.f11278f = motionEvent.getY(findPointerIndex);
                    if (r() && t()) {
                        A(y / 1.5f);
                    } else if (p() && u()) {
                        z(y / 1.5f);
                    } else {
                        this.p = false;
                        return false;
                    }
                    return true;
                } else if (action != 3) {
                    if (action == 5) {
                        this.x = motionEvent.getPointerId(actionIndex);
                        this.f11278f = motionEvent.getY(actionIndex);
                        return false;
                    } else if (action != 6) {
                        return false;
                    } else {
                        int action2 = (motionEvent.getAction() & 65280) >> 8;
                        if (motionEvent.getPointerId(action2) == this.x) {
                            int i2 = action2 != 0 ? 0 : 1;
                            this.x = motionEvent.getPointerId(i2);
                            this.f11278f = (int) motionEvent.getY(i2);
                            return false;
                        }
                        return false;
                    }
                }
            }
            if (this.p) {
                this.p = false;
                if (t()) {
                    if (this.l && this.r == ILoadingLayout$State.RELEASE_TO_REFRESH) {
                        L();
                        z2 = true;
                    } else if (!s()) {
                        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.RESET;
                        this.r = iLoadingLayout$State;
                        y(iLoadingLayout$State, true);
                    }
                    E();
                    return z2;
                } else if (u()) {
                    if (p() && this.s == ILoadingLayout$State.RELEASE_TO_REFRESH) {
                        K();
                        z2 = true;
                    }
                    D();
                    return z2;
                } else {
                    return false;
                }
            }
            return false;
        }
        this.x = motionEvent.getPointerId(actionIndex);
        this.f11278f = motionEvent.getY();
        return false;
    }

    public boolean p() {
        return this.m && this.f11281i != null;
    }

    public boolean q() {
        return this.s == ILoadingLayout$State.REFRESHING;
    }

    public boolean r() {
        return this.l && this.f11280h != null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z2);
        }
    }

    public boolean s() {
        return this.r == ILoadingLayout$State.REFRESHING;
    }

    public void setEmptyView(View view) {
        FrameLayout frameLayout = this.u;
        if (frameLayout != null) {
            frameLayout.addView(view, -1, -1);
        }
    }

    public void setHeaderBackgroundColor(int i2) {
        LoadingLayout loadingLayout = this.f11280h;
        if (loadingLayout != null) {
            loadingLayout.setHeaderBackgroundColor(getResources().getColor(i2));
        }
    }

    public void setHeaderBackgroundResource(int i2) {
        LoadingLayout loadingLayout = this.f11280h;
        if (loadingLayout != null) {
            loadingLayout.setHeaderBackgroundResource(i2);
        }
    }

    public void setHeaderBigBackground(int i2) {
        LoadingLayout loadingLayout = this.f11280h;
        if (loadingLayout == null) {
            return;
        }
        loadingLayout.setHeaderBigBackground(i2);
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        LoadingLayout loadingLayout = this.f11280h;
        if (loadingLayout != null) {
            loadingLayout.setLastUpdatedLabel(charSequence);
        }
        LoadingLayout loadingLayout2 = this.f11281i;
        if (loadingLayout2 != null) {
            loadingLayout2.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i2) {
        this.v = i2;
    }

    public void setOnRefreshListener(h<T> hVar) {
        this.f11279g = hVar;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
    }

    public void setPullLoadEnabled(boolean z2) {
        this.m = z2;
    }

    public void setPullRefreshEnabled(boolean z2) {
        this.l = z2;
    }

    public void setScrollLoadEnabled(boolean z2) {
        this.n = z2;
    }

    public abstract boolean t();

    public abstract boolean u();

    public boolean v() {
        return this.n;
    }

    public void w(boolean z2) {
        x(z2, null);
    }

    public void x(boolean z2, String str) {
        if (s()) {
            ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.RESET;
            this.r = iLoadingLayout$State;
            y(iLoadingLayout$State, true);
            setInterceptTouchEventEnabled(false);
            this.f11280h.f(z2, str, new c());
        }
    }

    public void y(ILoadingLayout$State iLoadingLayout$State, boolean z2) {
    }

    public void z(float f2) {
        int scrollYValue = getScrollYValue();
        if (f2 > 0.0f && scrollYValue - f2 <= 0.0f) {
            H(0, 0);
            return;
        }
        G(0, -((int) f2));
        if (this.f11281i != null && this.k != 0) {
            this.f11281i.d(Math.abs(getScrollYValue()) / this.k);
        }
        int abs = Math.abs(getScrollYValue());
        if (!p() || q()) {
            return;
        }
        if (abs > this.k) {
            this.s = ILoadingLayout$State.RELEASE_TO_REFRESH;
        } else {
            this.s = ILoadingLayout$State.PULL_TO_REFRESH;
        }
        LoadingLayout loadingLayout = this.f11281i;
        if (loadingLayout != null) {
            loadingLayout.setState(this.s);
        }
        y(this.s, false);
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.f11277e = HEADERTYPE.Common_STYLE_HEADER;
        this.f11278f = -1.0f;
        this.l = true;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.r = iLoadingLayout$State;
        this.s = iLoadingLayout$State;
        this.v = -1;
        this.x = -1;
        m(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11277e = HEADERTYPE.Common_STYLE_HEADER;
        this.f11278f = -1.0f;
        this.l = true;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.r = iLoadingLayout$State;
        this.s = iLoadingLayout$State;
        this.v = -1;
        this.x = -1;
        m(context, attributeSet);
    }
}
