package com.baidu.swan.apps.res.ui.pullrefresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.baidu.tieba.js1;
import com.baidu.tieba.la3;
/* loaded from: classes4.dex */
public abstract class PullToRefreshBaseNew<T extends View> extends FrameLayout {
    public static final boolean x = js1.a;
    public HEADERTYPE a;
    public float b;
    public float c;
    public e<T> d;
    public LoadingLayout e;
    public LoadingLayout f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public ILoadingLayout$State n;
    public ILoadingLayout$State o;
    public T p;
    public PullToRefreshBaseNew<T>.f q;
    public FrameLayout r;
    public int s;
    public boolean t;
    public float u;
    public boolean v;
    public la3<T> w;

    /* loaded from: classes4.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER
    }

    /* loaded from: classes4.dex */
    public interface e<V extends View> {
        void a(PullToRefreshBaseNew<V> pullToRefreshBaseNew);

        void b(PullToRefreshBaseNew<V> pullToRefreshBaseNew);

        void c(PullToRefreshBaseNew<V> pullToRefreshBaseNew);
    }

    public abstract T g(Context context, AttributeSet attributeSet);

    public long getSmoothScrollDuration() {
        return 150L;
    }

    public boolean k() {
        return true;
    }

    public abstract boolean p();

    public abstract boolean q();

    public void r(ILoadingLayout$State iLoadingLayout$State, boolean z) {
    }

    public void setScrollLoadEnabled(boolean z) {
    }

    public void w() {
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PullToRefreshBaseNew.this.d.a(PullToRefreshBaseNew.this);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PullToRefreshBaseNew.this.d.b(PullToRefreshBaseNew.this);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PullToRefreshBaseNew.this.d.c(PullToRefreshBaseNew.this);
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class d {
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
        }
    }

    /* loaded from: classes4.dex */
    public final class f implements Runnable {
        public final int b;
        public final int c;
        public final long d;
        public boolean e = true;
        public long f = -1;
        public int g = -1;
        public final Interpolator a = new DecelerateInterpolator();

        public f(int i, int i2, long j) {
            this.c = i;
            this.b = i2;
            this.d = j;
        }

        public void a() {
            this.e = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.d > 0) {
                if (this.f == -1) {
                    this.f = System.currentTimeMillis();
                } else {
                    int round = this.c - Math.round((this.c - this.b) * this.a.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.f) * 1000) / this.d, 1000L), 0L)) / 1000.0f));
                    this.g = round;
                    PullToRefreshBaseNew.this.y(0, round);
                }
                if (this.e && this.b != this.g) {
                    PullToRefreshBaseNew.this.postDelayed(this, 16L);
                    return;
                }
                return;
            }
            PullToRefreshBaseNew.this.y(0, this.b);
        }
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    public void B() {
        if (m()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.REFRESHING;
        this.o = iLoadingLayout$State;
        r(iLoadingLayout$State, false);
        LoadingLayout loadingLayout = this.f;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
        if (this.d != null) {
            postDelayed(new c(), getSmoothScrollDuration());
        }
    }

    public void C() {
        D(true);
    }

    public void E() {
        F(true);
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.f;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.e;
    }

    public la3<T> getRefreshableFactory() {
        return this.w;
    }

    public T getRefreshableView() {
        return this.p;
    }

    public final boolean i() {
        return this.k;
    }

    public boolean j() {
        if (this.n == ILoadingLayout$State.LONG_REFRESHING) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if (this.j && this.f != null) {
            return true;
        }
        return false;
    }

    public boolean m() {
        if (this.o == ILoadingLayout$State.REFRESHING) {
            return true;
        }
        return false;
    }

    public boolean n() {
        if (this.i && this.e != null) {
            return true;
        }
        return false;
    }

    public boolean o() {
        if (this.n == ILoadingLayout$State.REFRESHING) {
            return true;
        }
        return false;
    }

    public void u() {
        int abs = Math.abs(getScrollYValue());
        boolean m = m();
        if (m && abs <= this.h) {
            z(0);
        } else if (m) {
            z(this.h);
        } else {
            z(0);
        }
    }

    public void v() {
        int abs = Math.abs(getScrollYValue());
        boolean o = o();
        boolean j = j();
        if ((o || j) && abs <= this.g) {
            z(0);
        } else if (!o && !j) {
            z(0);
        } else {
            z(-this.g);
        }
    }

    public PullToRefreshBaseNew(Context context) {
        super(context);
        this.a = HEADERTYPE.STANDARD_HEADER;
        this.b = 2.5f;
        this.c = -1.0f;
        this.i = true;
        this.j = false;
        this.k = true;
        this.l = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.n = iLoadingLayout$State;
        this.o = iLoadingLayout$State;
        this.s = -1;
        this.t = false;
        this.u = 1.0f;
        h(context, null);
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.k = z;
    }

    public final void D(boolean z) {
        if (!o() && !j()) {
            ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.LONG_REFRESHING;
            this.n = iLoadingLayout$State;
            r(iLoadingLayout$State, true);
            LoadingLayout loadingLayout = this.e;
            if (loadingLayout != null) {
                loadingLayout.setState(ILoadingLayout$State.LONG_REFRESHING);
            }
            if (this.d != null) {
                postDelayed(new b(), getSmoothScrollDuration());
            }
        }
    }

    public final void F(boolean z) {
        if (!o() && !j()) {
            ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.REFRESHING;
            this.n = iLoadingLayout$State;
            r(iLoadingLayout$State, true);
            LoadingLayout loadingLayout = this.e;
            if (loadingLayout != null) {
                loadingLayout.setState(ILoadingLayout$State.REFRESHING);
            }
            if (z && this.d != null) {
                postDelayed(new a(), getSmoothScrollDuration());
            }
        }
    }

    public void c(Context context) {
        LoadingLayout loadingLayout = this.e;
        LoadingLayout loadingLayout2 = this.f;
        if (loadingLayout != null) {
            if (this == loadingLayout.getParent()) {
                removeView(loadingLayout);
            }
            addView(loadingLayout, 0, new FrameLayout.LayoutParams(-1, -2));
        }
        if (loadingLayout2 != null) {
            if (this == loadingLayout2.getParent()) {
                removeView(loadingLayout2);
            }
            addView(loadingLayout2, -1, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setEmptyView(View view2) {
        FrameLayout frameLayout = this.r;
        if (frameLayout != null) {
            frameLayout.addView(view2, -1, -1);
        }
    }

    public void setHeaderBackgroundColor(int i) {
        LoadingLayout loadingLayout = this.e;
        if (loadingLayout != null) {
            loadingLayout.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        LoadingLayout loadingLayout = this.e;
        if (loadingLayout != null) {
            loadingLayout.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        LoadingLayout loadingLayout = this.e;
        if (loadingLayout == null) {
            return;
        }
        loadingLayout.setHeaderBigBackground(i);
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        LoadingLayout loadingLayout = this.e;
        if (loadingLayout != null) {
            loadingLayout.setLastUpdatedLabel(charSequence);
        }
        LoadingLayout loadingLayout2 = this.f;
        if (loadingLayout2 != null) {
            loadingLayout2.setLastUpdatedLabel(charSequence);
        }
    }

    public void setListenParentScroll(boolean z) {
        this.v = z;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.t = z;
    }

    public void setMaxPullOffset(int i) {
        this.s = i;
    }

    public void setOffsetRadio(float f2) {
        this.b = f2;
    }

    public void setOnRefreshListener(e<T> eVar) {
        this.d = eVar;
    }

    public void setPullLoadEnabled(boolean z) {
        this.j = z;
    }

    public void setPullRatio(float f2) {
        this.u = Math.max(f2, 1.0f);
    }

    public void setPullRefreshEnabled(boolean z) {
        this.i = z;
    }

    public final void z(int i) {
        A(i, getSmoothScrollDuration(), 0L);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = HEADERTYPE.STANDARD_HEADER;
        this.b = 2.5f;
        this.c = -1.0f;
        this.i = true;
        this.j = false;
        this.k = true;
        this.l = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.n = iLoadingLayout$State;
        this.o = iLoadingLayout$State;
        this.s = -1;
        this.t = false;
        this.u = 1.0f;
        h(context, attributeSet);
    }

    public void d(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    public LoadingLayout e(Context context, AttributeSet attributeSet) {
        return new FooterLoadingLayout(context);
    }

    public LoadingLayout f(Context context, AttributeSet attributeSet) {
        LoadingLayout headerLoadingLayout;
        w();
        int i = d.a[this.a.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    headerLoadingLayout = null;
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

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public final void x(int i, int i2) {
        scrollBy(i, i2);
    }

    public final void y(int i, int i2) {
        scrollTo(i, i2);
    }

    public final void A(int i, long j, long j2) {
        boolean z;
        PullToRefreshBaseNew<T>.f fVar = this.q;
        if (fVar != null) {
            fVar.a();
        }
        int scrollYValue = getScrollYValue();
        if (scrollYValue != i) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.q = new f(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.q, j2);
            } else {
                post(this.q);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void h(Context context, AttributeSet attributeSet) {
        this.m = ViewConfiguration.get(context).getScaledTouchSlop();
        this.e = f(context, attributeSet);
        this.f = e(context, attributeSet);
        T g = g(context, attributeSet);
        this.p = g;
        if (x && g == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        T t = this.p;
        if (t != null) {
            d(context, t);
        }
        c(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        T t;
        boolean z = false;
        if (!i()) {
            return false;
        }
        if (!l() && !n()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 3 && action != 1) {
            if (action != 0 && this.l) {
                return true;
            }
            if (action != 0) {
                if (action == 2) {
                    float y = motionEvent.getY() - this.c;
                    if (Math.abs(y) > this.m || o() || m() || j()) {
                        this.c = motionEvent.getY();
                        if (n() && p()) {
                            z = (Math.abs(getScrollYValue()) > 0 || y > 0.5f) ? true : true;
                            this.l = z;
                            if (z && k() && (t = this.p) != null) {
                                t.onTouchEvent(motionEvent);
                            }
                        } else if (l() && q()) {
                            this.l = (Math.abs(getScrollYValue()) > 0 || y < -0.5f) ? true : true;
                        }
                    }
                }
            } else {
                this.c = motionEvent.getY();
                this.l = false;
            }
            return this.l;
        }
        this.l = false;
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = false;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else {
                    float y = motionEvent.getY() - this.c;
                    this.c = motionEvent.getY();
                    if (n() && p()) {
                        t(y / this.b);
                    } else if (l() && q()) {
                        s(y / this.b);
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
            if (p()) {
                if (this.i) {
                    ILoadingLayout$State iLoadingLayout$State = this.n;
                    if (iLoadingLayout$State == ILoadingLayout$State.RELEASE_TO_REFRESH) {
                        E();
                        z = true;
                    } else if (this.t && iLoadingLayout$State == ILoadingLayout$State.RELEASE_TO_LONG_REFRESH) {
                        C();
                        z = true;
                        if (this.v) {
                            return true;
                        }
                    }
                } else {
                    ILoadingLayout$State iLoadingLayout$State2 = ILoadingLayout$State.RESET;
                    this.n = iLoadingLayout$State2;
                    r(iLoadingLayout$State2, true);
                }
                v();
                return z;
            } else if (!q()) {
                return false;
            } else {
                if (l() && this.o == ILoadingLayout$State.RELEASE_TO_REFRESH) {
                    B();
                    z = true;
                }
                u();
                return z;
            }
        }
        this.c = motionEvent.getY();
        this.l = false;
        return false;
    }

    public void t(float f2) {
        int scrollYValue = getScrollYValue();
        if (f2 < 0.0f && scrollYValue - f2 >= 0.0f) {
            y(0, 0);
        } else if (this.s > 0 && f2 > 0.0f && Math.abs(scrollYValue) >= this.s) {
        } else {
            x(0, -((int) f2));
            if (this.e != null && this.g != 0) {
                this.e.d(Math.abs(getScrollYValue()) / this.g);
            }
            int abs = Math.abs(getScrollYValue());
            if (n() && !o() && !j()) {
                if (this.t && abs > this.g * this.u * 2.0f) {
                    this.n = ILoadingLayout$State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.g * this.u) {
                    this.n = ILoadingLayout$State.RELEASE_TO_REFRESH;
                } else {
                    this.n = ILoadingLayout$State.PULL_TO_REFRESH;
                }
                LoadingLayout loadingLayout = this.e;
                if (loadingLayout != null) {
                    loadingLayout.setState(this.n);
                }
                r(this.n, true);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        LoadingLayout loadingLayout = this.e;
        if (loadingLayout != null) {
            loadingLayout.layout(loadingLayout.getLeft(), this.e.getTop() - this.e.getHeight(), this.e.getRight(), this.e.getBottom() - this.e.getHeight());
            this.g = this.e.getContentSize();
        }
        LoadingLayout loadingLayout2 = this.f;
        if (loadingLayout2 != null && this.p != null) {
            loadingLayout2.layout(loadingLayout2.getLeft(), this.p.getBottom(), this.f.getRight(), this.p.getBottom() + this.f.getHeight());
            this.h = this.f.getContentSize();
        }
    }

    public void s(float f2) {
        int scrollYValue = getScrollYValue();
        if (f2 > 0.0f && scrollYValue - f2 <= 0.0f) {
            y(0, 0);
            return;
        }
        x(0, -((int) f2));
        if (this.f != null && this.h != 0) {
            this.f.d(Math.abs(getScrollYValue()) / this.h);
        }
        int abs = Math.abs(getScrollYValue());
        if (l() && !m()) {
            if (abs > this.h) {
                this.o = ILoadingLayout$State.RELEASE_TO_REFRESH;
            } else {
                this.o = ILoadingLayout$State.PULL_TO_REFRESH;
            }
            LoadingLayout loadingLayout = this.f;
            if (loadingLayout != null) {
                loadingLayout.setState(this.o);
            }
            r(this.o, false);
        }
    }
}
