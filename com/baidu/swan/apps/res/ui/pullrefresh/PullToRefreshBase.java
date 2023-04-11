package com.baidu.swan.apps.res.ui.pullrefresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.baidu.tieba.br2;
import com.baidu.tieba.eo1;
import com.baidu.tieba.g63;
/* loaded from: classes3.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    public static final boolean v = eo1.a;
    public HEADERTYPE a;
    public float b;
    public h<T> c;
    public LoadingLayout d;
    public LoadingLayout e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public ILoadingLayout$State n;
    public ILoadingLayout$State o;
    public T p;
    public FrameLayout q;
    public int r;
    public Scroller s;
    public int t;
    public g63<T> u;

    /* loaded from: classes3.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER,
        Common_STYLE_HEADER,
        SWAN_APP_HEADER
    }

    /* loaded from: classes3.dex */
    public interface h<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);

        void b(PullToRefreshBase<V> pullToRefreshBase);
    }

    public void F() {
    }

    public int getSmoothScrollDuration() {
        return 300;
    }

    public abstract T j(Context context, AttributeSet attributeSet);

    public boolean o() {
        return true;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
    }

    public abstract boolean t();

    public abstract boolean u();

    public void y(ILoadingLayout$State iLoadingLayout$State, boolean z) {
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
                PullToRefreshBase.this.d.setState(ILoadingLayout$State.RESET);
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
    public class d implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Runnable b;

        public d(boolean z, Runnable runnable) {
            this.a = z;
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2 = -PullToRefreshBase.this.d.getRefreshingHeight();
            if (this.a) {
                i = 300;
            } else {
                i = 0;
            }
            PullToRefreshBase.this.L();
            PullToRefreshBase.this.J(i2, i);
            Runnable runnable = this.b;
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
            PullToRefreshBase.this.c.b(PullToRefreshBase.this);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PullToRefreshBase.this.c.a(PullToRefreshBase.this);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class g {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[HEADERTYPE.values().length];
            a = iArr;
            try {
                iArr[HEADERTYPE.STANDARD_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[HEADERTYPE.BIG_BG_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[HEADERTYPE.ROTATE_HEADER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[HEADERTYPE.Common_STYLE_HEADER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[HEADERTYPE.SWAN_APP_HEADER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private boolean getNgWebViewHeightSwitch() {
        br2.g0().getSwitch("swan_app_refresh_ngwebview_height_switch", false);
        return false;
    }

    public void D() {
        int abs = Math.abs(getScrollYValue());
        boolean q = q();
        if (q && abs <= this.g) {
            I(0);
        } else if (q) {
            I(this.g);
        } else {
            I(0);
        }
    }

    public void E() {
        int abs = Math.abs(getScrollYValue());
        boolean s = s();
        if (s && abs <= this.d.getRefreshingHeight()) {
            I(0);
        } else if (s) {
            I(-this.d.getRefreshingHeight());
        } else {
            I(0);
        }
    }

    public void K() {
        if (q()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.REFRESHING;
        this.o = iLoadingLayout$State;
        y(iLoadingLayout$State, false);
        LoadingLayout loadingLayout = this.e;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
        if (this.c != null) {
            postDelayed(new f(), getSmoothScrollDuration());
        }
    }

    public void L() {
        M(true);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.s.computeScrollOffset()) {
            int currY = this.s.getCurrY();
            scrollTo(0, currY);
            this.d.e(-currY);
            this.e.d(Math.abs(getScrollYValue()) / this.g);
            postInvalidate();
        }
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.e;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.d;
    }

    public g63<T> getRefreshableFactory() {
        return this.u;
    }

    public T getRefreshableView() {
        return this.p;
    }

    public int getScrollYValue() {
        return getScrollY();
    }

    public final boolean n() {
        return this.k;
    }

    public boolean p() {
        if (this.i && this.e != null) {
            return true;
        }
        return false;
    }

    public boolean q() {
        if (this.o == ILoadingLayout$State.REFRESHING) {
            return true;
        }
        return false;
    }

    public boolean r() {
        if (this.h && this.d != null) {
            return true;
        }
        return false;
    }

    public boolean s() {
        if (this.n == ILoadingLayout$State.REFRESHING) {
            return true;
        }
        return false;
    }

    public boolean v() {
        return this.j;
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.a = HEADERTYPE.Common_STYLE_HEADER;
        this.b = -1.0f;
        this.h = true;
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.n = iLoadingLayout$State;
        this.o = iLoadingLayout$State;
        this.r = -1;
        this.t = -1;
        m(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.k = z;
    }

    public final void I(int i) {
        J(i, getSmoothScrollDuration());
    }

    public final void M(boolean z) {
        if (s()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.REFRESHING;
        this.n = iLoadingLayout$State;
        y(iLoadingLayout$State, true);
        LoadingLayout loadingLayout = this.d;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
        if (z && this.c != null) {
            postDelayed(new e(), getSmoothScrollDuration());
        }
    }

    public void f(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.d;
        LoadingLayout loadingLayout2 = this.e;
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

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setEmptyView(View view2) {
        FrameLayout frameLayout = this.q;
        if (frameLayout != null) {
            frameLayout.addView(view2, -1, -1);
        }
    }

    public void setHeaderBackgroundColor(int i) {
        LoadingLayout loadingLayout = this.d;
        if (loadingLayout != null) {
            loadingLayout.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        LoadingLayout loadingLayout = this.d;
        if (loadingLayout != null) {
            loadingLayout.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        LoadingLayout loadingLayout = this.d;
        if (loadingLayout == null) {
            return;
        }
        loadingLayout.setHeaderBigBackground(i);
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        LoadingLayout loadingLayout = this.d;
        if (loadingLayout != null) {
            loadingLayout.setLastUpdatedLabel(charSequence);
        }
        LoadingLayout loadingLayout2 = this.e;
        if (loadingLayout2 != null) {
            loadingLayout2.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.r = i;
    }

    public void setOnRefreshListener(h<T> hVar) {
        this.c = hVar;
    }

    public void setPullLoadEnabled(boolean z) {
        this.i = z;
    }

    public void setPullRefreshEnabled(boolean z) {
        this.h = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.j = z;
    }

    public void w(boolean z) {
        x(z, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = HEADERTYPE.Common_STYLE_HEADER;
        this.b = -1.0f;
        this.h = true;
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.n = iLoadingLayout$State;
        this.o = iLoadingLayout$State;
        this.r = -1;
        this.t = -1;
        m(context, attributeSet);
    }

    public void C(int i, int i2) {
        FrameLayout frameLayout = this.q;
        if (frameLayout != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.q.requestLayout();
            }
        }
    }

    public final void G(int i, int i2) {
        scrollBy(i, i2);
    }

    public final void H(int i, int i2) {
        scrollTo(i, i2);
    }

    public final void J(int i, int i2) {
        this.s.forceFinished(true);
        int scrollY = getScrollY();
        int i3 = i - scrollY;
        if (i3 != 0) {
            this.s.startScroll(0, scrollY, 0, i3, i2);
            postInvalidate();
        }
    }

    public void g(Context context, T t) {
        int i;
        FrameLayout frameLayout = new FrameLayout(context);
        this.q = frameLayout;
        frameLayout.addView(t, -1, -1);
        if (getNgWebViewHeightSwitch()) {
            i = 10;
        } else {
            i = -1;
        }
        addView(this.q, new LinearLayout.LayoutParams(-1, i));
    }

    public LoadingLayout h(Context context, AttributeSet attributeSet) {
        return new FooterLoadingLayout(context);
    }

    public void k(boolean z, long j) {
        l(z, j, null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void x(boolean z, String str) {
        if (s()) {
            ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.RESET;
            this.n = iLoadingLayout$State;
            y(iLoadingLayout$State, true);
            setInterceptTouchEventEnabled(false);
            this.d.f(z, str, new c());
        }
    }

    public PullToRefreshBase(Context context, g63<T> g63Var, HEADERTYPE headertype) {
        super(context);
        this.a = HEADERTYPE.Common_STYLE_HEADER;
        this.b = -1.0f;
        this.h = true;
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.n = iLoadingLayout$State;
        this.o = iLoadingLayout$State;
        this.r = -1;
        this.t = -1;
        this.u = g63Var;
        this.a = headertype;
        m(context, null);
    }

    public void l(boolean z, long j, Runnable runnable) {
        postDelayed(new d(z, runnable), j);
    }

    public void A(float f2) {
        int scrollYValue = getScrollYValue();
        if (f2 < 0.0f && scrollYValue - f2 >= 0.0f) {
            H(0, 0);
            LoadingLayout loadingLayout = this.d;
            if (loadingLayout != null) {
                loadingLayout.e(0);
            }
        } else if (this.r > 0 && f2 > 0.0f && Math.abs(scrollYValue) >= this.r) {
        } else {
            G(0, -((int) f2));
            LoadingLayout loadingLayout2 = this.d;
            if (loadingLayout2 != null) {
                loadingLayout2.e(-getScrollY());
                if (this.f != 0) {
                    this.d.d(Math.abs(getScrollYValue()) / this.f);
                }
            }
            int abs = Math.abs(getScrollYValue());
            if (r() && !s()) {
                LoadingLayout loadingLayout3 = this.d;
                if (loadingLayout3 != null && abs > loadingLayout3.getCanRefreshPullLength()) {
                    this.n = ILoadingLayout$State.RELEASE_TO_REFRESH;
                } else {
                    this.n = ILoadingLayout$State.PULL_TO_REFRESH;
                }
                LoadingLayout loadingLayout4 = this.d;
                if (loadingLayout4 != null) {
                    loadingLayout4.setState(this.n);
                }
                y(this.n, true);
            }
        }
    }

    public final void B() {
        int i;
        int i2;
        int i3;
        LoadingLayout loadingLayout = this.d;
        int i4 = 0;
        if (loadingLayout != null) {
            i = loadingLayout.getContentSize();
        } else {
            i = 0;
        }
        LoadingLayout loadingLayout2 = this.e;
        if (loadingLayout2 != null) {
            i2 = loadingLayout2.getContentSize();
        } else {
            i2 = 0;
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        this.f = i;
        this.g = i2;
        LoadingLayout loadingLayout3 = this.d;
        if (loadingLayout3 != null) {
            i3 = loadingLayout3.getMeasuredHeight();
        } else {
            i3 = 0;
        }
        LoadingLayout loadingLayout4 = this.e;
        if (loadingLayout4 != null) {
            i4 = loadingLayout4.getMeasuredHeight();
        }
        if (i4 == 0) {
            i4 = this.g;
        }
        setPadding(getPaddingLeft(), -i3, getPaddingRight(), -i4);
    }

    public LoadingLayout i(Context context, AttributeSet attributeSet) {
        LoadingLayout headerLoadingLayout;
        F();
        int i = g.a[this.a.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            headerLoadingLayout = null;
                        } else {
                            headerLoadingLayout = new NeutralHeaderLoadingLayout(context);
                        }
                    } else {
                        headerLoadingLayout = new CommonHeaderLoadingLayout(context);
                    }
                } else {
                    headerLoadingLayout = new RotateLoadingLayout(context);
                }
            } else {
                headerLoadingLayout = new BigBgHeaderLoadingLayout(context);
            }
        } else {
            headerLoadingLayout = new HeaderLoadingLayout(context);
        }
        if (headerLoadingLayout == null) {
            return new HeaderLoadingLayout(context);
        }
        return headerLoadingLayout;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void m(Context context, AttributeSet attributeSet) {
        this.s = new Scroller(context);
        super.setOrientation(1);
        this.m = ViewConfiguration.get(context).getScaledTouchSlop();
        this.d = i(context, attributeSet);
        this.e = h(context, attributeSet);
        T j = j(context, attributeSet);
        this.p = j;
        if (v && j == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        T t = this.p;
        if (t != null) {
            g(context, t);
        }
        f(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        T t;
        boolean z = false;
        if (!n()) {
            return false;
        }
        if (!p() && !r()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 3) {
            int i = 1;
            if (action != 1) {
                if (action != 0 && this.l) {
                    return true;
                }
                int actionIndex = motionEvent.getActionIndex();
                if (action != 0) {
                    if (action != 2) {
                        if (action != 5) {
                            if (action == 6) {
                                int action2 = (motionEvent.getAction() & 65280) >> 8;
                                if (motionEvent.getPointerId(action2) == this.t) {
                                    if (action2 != 0) {
                                        i = 0;
                                    }
                                    this.t = motionEvent.getPointerId(i);
                                    this.b = (int) motionEvent.getY(i);
                                    this.l = false;
                                }
                            }
                        } else {
                            this.t = motionEvent.getPointerId(actionIndex);
                            this.b = motionEvent.getY(actionIndex);
                            this.l = false;
                        }
                    } else {
                        int findPointerIndex = motionEvent.findPointerIndex(this.t);
                        if (findPointerIndex < 0) {
                            this.l = false;
                            return false;
                        }
                        float y = motionEvent.getY(findPointerIndex) - this.b;
                        if (Math.abs(y) > this.m || s() || q()) {
                            this.b = motionEvent.getY(findPointerIndex);
                            if (r() && t()) {
                                z = (Math.abs(getScrollYValue()) > 0 || y > 0.5f) ? true : true;
                                this.l = z;
                                if (z && o() && (t = this.p) != null) {
                                    t.onTouchEvent(motionEvent);
                                }
                            } else if (p() && u()) {
                                this.l = (Math.abs(getScrollYValue()) > 0 || y < -0.5f) ? true : true;
                            }
                        }
                    }
                } else {
                    this.t = motionEvent.getPointerId(actionIndex);
                    this.b = motionEvent.getY();
                    this.l = false;
                }
                return this.l;
            }
        }
        this.l = false;
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        int action = motionEvent.getAction();
        boolean z = false;
        int i = 1;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action != 6) {
                                return false;
                            }
                            int action2 = (motionEvent.getAction() & 65280) >> 8;
                            if (motionEvent.getPointerId(action2) != this.t) {
                                return false;
                            }
                            if (action2 != 0) {
                                i = 0;
                            }
                            this.t = motionEvent.getPointerId(i);
                            this.b = (int) motionEvent.getY(i);
                            return false;
                        }
                        this.t = motionEvent.getPointerId(actionIndex);
                        this.b = motionEvent.getY(actionIndex);
                        return false;
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.t);
                    if (findPointerIndex < 0) {
                        this.l = false;
                        return false;
                    }
                    float y = motionEvent.getY(findPointerIndex) - this.b;
                    this.b = motionEvent.getY(findPointerIndex);
                    if (r() && t()) {
                        A(y / 1.5f);
                    } else if (p() && u()) {
                        z(y / 1.5f);
                    } else {
                        this.l = false;
                        return false;
                    }
                    return true;
                }
            }
            if (!this.l) {
                return false;
            }
            this.l = false;
            if (t()) {
                if (this.h && this.n == ILoadingLayout$State.RELEASE_TO_REFRESH) {
                    L();
                    z = true;
                } else if (!s()) {
                    ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.RESET;
                    this.n = iLoadingLayout$State;
                    y(iLoadingLayout$State, true);
                }
                E();
                return z;
            } else if (!u()) {
                return false;
            } else {
                if (p() && this.o == ILoadingLayout$State.RELEASE_TO_REFRESH) {
                    K();
                    z = true;
                }
                D();
                return z;
            }
        }
        this.t = motionEvent.getPointerId(actionIndex);
        this.b = motionEvent.getY();
        return false;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        B();
        C(i, i2);
        post(new b());
    }

    public void z(float f2) {
        int scrollYValue = getScrollYValue();
        if (f2 > 0.0f && scrollYValue - f2 <= 0.0f) {
            H(0, 0);
            return;
        }
        G(0, -((int) f2));
        if (this.e != null && this.g != 0) {
            this.e.d(Math.abs(getScrollYValue()) / this.g);
        }
        int abs = Math.abs(getScrollYValue());
        if (p() && !q()) {
            if (abs > this.g) {
                this.o = ILoadingLayout$State.RELEASE_TO_REFRESH;
            } else {
                this.o = ILoadingLayout$State.PULL_TO_REFRESH;
            }
            LoadingLayout loadingLayout = this.e;
            if (loadingLayout != null) {
                loadingLayout.setState(this.o);
            }
            y(this.o, false);
        }
    }
}
