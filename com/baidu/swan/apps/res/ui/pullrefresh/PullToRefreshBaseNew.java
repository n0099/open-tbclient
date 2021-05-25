package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public abstract class PullToRefreshBaseNew<T extends View> extends FrameLayout {
    public static final boolean B = k.f43199a;
    public d.a.l0.a.z1.a.d.a<T> A;

    /* renamed from: e  reason: collision with root package name */
    public HEADERTYPE f11193e;

    /* renamed from: f  reason: collision with root package name */
    public float f11194f;

    /* renamed from: g  reason: collision with root package name */
    public float f11195g;

    /* renamed from: h  reason: collision with root package name */
    public e<T> f11196h;

    /* renamed from: i  reason: collision with root package name */
    public LoadingLayout f11197i;
    public LoadingLayout j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public ILoadingLayout$State r;
    public ILoadingLayout$State s;
    public T t;
    public PullToRefreshBaseNew<T>.f u;
    public FrameLayout v;
    public int w;
    public boolean x;
    public float y;
    public boolean z;

    /* loaded from: classes3.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PullToRefreshBaseNew.this.f11196h.a(PullToRefreshBaseNew.this);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PullToRefreshBaseNew.this.f11196h.b(PullToRefreshBaseNew.this);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PullToRefreshBaseNew.this.f11196h.c(PullToRefreshBaseNew.this);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11201a;

        static {
            int[] iArr = new int[HEADERTYPE.values().length];
            f11201a = iArr;
            try {
                iArr[HEADERTYPE.STANDARD_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11201a[HEADERTYPE.BIG_BG_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11201a[HEADERTYPE.ROTATE_HEADER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e<V extends View> {
        void a(PullToRefreshBaseNew<V> pullToRefreshBaseNew);

        void b(PullToRefreshBaseNew<V> pullToRefreshBaseNew);

        void c(PullToRefreshBaseNew<V> pullToRefreshBaseNew);
    }

    /* loaded from: classes3.dex */
    public final class f implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        public final int f11203f;

        /* renamed from: g  reason: collision with root package name */
        public final int f11204g;

        /* renamed from: h  reason: collision with root package name */
        public final long f11205h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f11206i = true;
        public long j = -1;
        public int k = -1;

        /* renamed from: e  reason: collision with root package name */
        public final Interpolator f11202e = new DecelerateInterpolator();

        public f(int i2, int i3, long j) {
            this.f11204g = i2;
            this.f11203f = i3;
            this.f11205h = j;
        }

        public void a() {
            this.f11206i = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f11205h <= 0) {
                PullToRefreshBaseNew.this.y(0, this.f11203f);
                return;
            }
            if (this.j == -1) {
                this.j = System.currentTimeMillis();
            } else {
                int round = this.f11204g - Math.round((this.f11204g - this.f11203f) * this.f11202e.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.j) * 1000) / this.f11205h, 1000L), 0L)) / 1000.0f));
                this.k = round;
                PullToRefreshBaseNew.this.y(0, round);
            }
            if (!this.f11206i || this.f11203f == this.k) {
                return;
            }
            PullToRefreshBaseNew.this.postDelayed(this, 16L);
        }
    }

    public PullToRefreshBaseNew(Context context) {
        super(context);
        this.f11193e = HEADERTYPE.STANDARD_HEADER;
        this.f11194f = 2.5f;
        this.f11195g = -1.0f;
        this.m = true;
        this.n = false;
        this.o = true;
        this.p = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.r = iLoadingLayout$State;
        this.s = iLoadingLayout$State;
        this.w = -1;
        this.x = false;
        this.y = 1.0f;
        h(context, null);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void setInterceptTouchEventEnabled(boolean z) {
        this.o = z;
    }

    public final void A(int i2, long j, long j2) {
        PullToRefreshBaseNew<T>.f fVar = this.u;
        if (fVar != null) {
            fVar.a();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i2;
        if (z) {
            this.u = new f(scrollYValue, i2, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.u, j2);
            } else {
                post(this.u);
            }
        }
    }

    public void B() {
        if (m()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.REFRESHING;
        this.s = iLoadingLayout$State;
        r(iLoadingLayout$State, false);
        LoadingLayout loadingLayout = this.j;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
        if (this.f11196h != null) {
            postDelayed(new c(), getSmoothScrollDuration());
        }
    }

    public void C() {
        D(true);
    }

    public final void D(boolean z) {
        if (o() || j()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.LONG_REFRESHING;
        this.r = iLoadingLayout$State;
        r(iLoadingLayout$State, true);
        LoadingLayout loadingLayout = this.f11197i;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.LONG_REFRESHING);
        }
        if (this.f11196h != null) {
            postDelayed(new b(), getSmoothScrollDuration());
        }
    }

    public void E() {
        F(true);
    }

    public final void F(boolean z) {
        if (o() || j()) {
            return;
        }
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.REFRESHING;
        this.r = iLoadingLayout$State;
        r(iLoadingLayout$State, true);
        LoadingLayout loadingLayout = this.f11197i;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
        if (!z || this.f11196h == null) {
            return;
        }
        postDelayed(new a(), getSmoothScrollDuration());
    }

    public void c(Context context) {
        LoadingLayout loadingLayout = this.f11197i;
        LoadingLayout loadingLayout2 = this.j;
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

    public void d(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    public LoadingLayout e(Context context, AttributeSet attributeSet) {
        return new FooterLoadingLayout(context);
    }

    public LoadingLayout f(Context context, AttributeSet attributeSet) {
        LoadingLayout headerLoadingLayout;
        w();
        int i2 = d.f11201a[this.f11193e.ordinal()];
        if (i2 == 1) {
            headerLoadingLayout = new HeaderLoadingLayout(context);
        } else if (i2 != 2) {
            headerLoadingLayout = i2 != 3 ? null : new RotateLoadingLayout(context);
        } else {
            headerLoadingLayout = new BigBgHeaderLoadingLayout(context);
        }
        return headerLoadingLayout == null ? new HeaderLoadingLayout(context) : headerLoadingLayout;
    }

    public abstract T g(Context context, AttributeSet attributeSet);

    public LoadingLayout getFooterLoadingLayout() {
        return this.j;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.f11197i;
    }

    public d.a.l0.a.z1.a.d.a<T> getRefreshableFactory() {
        return this.A;
    }

    public T getRefreshableView() {
        return this.t;
    }

    public long getSmoothScrollDuration() {
        return 150L;
    }

    public final void h(Context context, AttributeSet attributeSet) {
        this.q = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f11197i = f(context, attributeSet);
        this.j = e(context, attributeSet);
        T g2 = g(context, attributeSet);
        this.t = g2;
        if (B && g2 == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        T t = this.t;
        if (t != null) {
            d(context, t);
        }
        c(context);
    }

    public final boolean i() {
        return this.o;
    }

    public boolean j() {
        return this.r == ILoadingLayout$State.LONG_REFRESHING;
    }

    public boolean k() {
        return true;
    }

    public boolean l() {
        return this.n && this.j != null;
    }

    public boolean m() {
        return this.s == ILoadingLayout$State.REFRESHING;
    }

    public boolean n() {
        return this.m && this.f11197i != null;
    }

    public boolean o() {
        return this.r == ILoadingLayout$State.REFRESHING;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        T t;
        boolean z = false;
        if (i()) {
            if (l() || n()) {
                int action = motionEvent.getAction();
                if (action != 3 && action != 1) {
                    if (action == 0 || !this.p) {
                        if (action == 0) {
                            this.f11195g = motionEvent.getY();
                            this.p = false;
                        } else if (action == 2) {
                            float y = motionEvent.getY() - this.f11195g;
                            if (Math.abs(y) > this.q || o() || m() || j()) {
                                this.f11195g = motionEvent.getY();
                                if (n() && p()) {
                                    z = (Math.abs(getScrollYValue()) > 0 || y > 0.5f) ? true : true;
                                    this.p = z;
                                    if (z && k() && (t = this.t) != null) {
                                        t.onTouchEvent(motionEvent);
                                    }
                                } else if (l() && q()) {
                                    this.p = (Math.abs(getScrollYValue()) > 0 || y < -0.5f) ? true : true;
                                }
                            }
                        }
                        return this.p;
                    }
                    return true;
                }
                this.p = false;
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        LoadingLayout loadingLayout = this.f11197i;
        if (loadingLayout != null) {
            loadingLayout.layout(loadingLayout.getLeft(), this.f11197i.getTop() - this.f11197i.getHeight(), this.f11197i.getRight(), this.f11197i.getBottom() - this.f11197i.getHeight());
            this.k = this.f11197i.getContentSize();
        }
        LoadingLayout loadingLayout2 = this.j;
        if (loadingLayout2 == null || this.t == null) {
            return;
        }
        loadingLayout2.layout(loadingLayout2.getLeft(), this.t.getBottom(), this.j.getRight(), this.t.getBottom() + this.j.getHeight());
        this.l = this.j.getContentSize();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = false;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float y = motionEvent.getY() - this.f11195g;
                    this.f11195g = motionEvent.getY();
                    if (n() && p()) {
                        t(y / this.f11194f);
                    } else if (l() && q()) {
                        s(y / this.f11194f);
                    } else {
                        this.p = false;
                        return false;
                    }
                    return true;
                } else if (action != 3) {
                    return false;
                }
            }
            if (this.p) {
                this.p = false;
                if (p()) {
                    if (this.m) {
                        ILoadingLayout$State iLoadingLayout$State = this.r;
                        if (iLoadingLayout$State == ILoadingLayout$State.RELEASE_TO_REFRESH) {
                            E();
                            z = true;
                        } else if (this.x && iLoadingLayout$State == ILoadingLayout$State.RELEASE_TO_LONG_REFRESH) {
                            C();
                            z = true;
                            if (this.z) {
                                return true;
                            }
                        }
                    } else {
                        ILoadingLayout$State iLoadingLayout$State2 = ILoadingLayout$State.RESET;
                        this.r = iLoadingLayout$State2;
                        r(iLoadingLayout$State2, true);
                    }
                    v();
                    return z;
                } else if (q()) {
                    if (l() && this.s == ILoadingLayout$State.RELEASE_TO_REFRESH) {
                        B();
                        z = true;
                    }
                    u();
                    return z;
                } else {
                    return false;
                }
            }
            return false;
        }
        this.f11195g = motionEvent.getY();
        this.p = false;
        return false;
    }

    public abstract boolean p();

    public abstract boolean q();

    public void r(ILoadingLayout$State iLoadingLayout$State, boolean z) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void s(float f2) {
        int scrollYValue = getScrollYValue();
        if (f2 > 0.0f && scrollYValue - f2 <= 0.0f) {
            y(0, 0);
            return;
        }
        x(0, -((int) f2));
        if (this.j != null && this.l != 0) {
            this.j.d(Math.abs(getScrollYValue()) / this.l);
        }
        int abs = Math.abs(getScrollYValue());
        if (!l() || m()) {
            return;
        }
        if (abs > this.l) {
            this.s = ILoadingLayout$State.RELEASE_TO_REFRESH;
        } else {
            this.s = ILoadingLayout$State.PULL_TO_REFRESH;
        }
        LoadingLayout loadingLayout = this.j;
        if (loadingLayout != null) {
            loadingLayout.setState(this.s);
        }
        r(this.s, false);
    }

    public void setEmptyView(View view) {
        FrameLayout frameLayout = this.v;
        if (frameLayout != null) {
            frameLayout.addView(view, -1, -1);
        }
    }

    public void setHeaderBackgroundColor(int i2) {
        LoadingLayout loadingLayout = this.f11197i;
        if (loadingLayout != null) {
            loadingLayout.setHeaderBackgroundColor(getResources().getColor(i2));
        }
    }

    public void setHeaderBackgroundResource(int i2) {
        LoadingLayout loadingLayout = this.f11197i;
        if (loadingLayout != null) {
            loadingLayout.setHeaderBackgroundResource(i2);
        }
    }

    public void setHeaderBigBackground(int i2) {
        LoadingLayout loadingLayout = this.f11197i;
        if (loadingLayout == null) {
            return;
        }
        loadingLayout.setHeaderBigBackground(i2);
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        LoadingLayout loadingLayout = this.f11197i;
        if (loadingLayout != null) {
            loadingLayout.setLastUpdatedLabel(charSequence);
        }
        LoadingLayout loadingLayout2 = this.j;
        if (loadingLayout2 != null) {
            loadingLayout2.setLastUpdatedLabel(charSequence);
        }
    }

    public void setListenParentScroll(boolean z) {
        this.z = z;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.x = z;
    }

    public void setMaxPullOffset(int i2) {
        this.w = i2;
    }

    public void setOffsetRadio(float f2) {
        this.f11194f = f2;
    }

    public void setOnRefreshListener(e<T> eVar) {
        this.f11196h = eVar;
    }

    public void setPullLoadEnabled(boolean z) {
        this.n = z;
    }

    public void setPullRatio(float f2) {
        this.y = Math.max(f2, 1.0f);
    }

    public void setPullRefreshEnabled(boolean z) {
        this.m = z;
    }

    public void setScrollLoadEnabled(boolean z) {
    }

    public void t(float f2) {
        int scrollYValue = getScrollYValue();
        if (f2 < 0.0f && scrollYValue - f2 >= 0.0f) {
            y(0, 0);
        } else if (this.w <= 0 || f2 <= 0.0f || Math.abs(scrollYValue) < this.w) {
            x(0, -((int) f2));
            if (this.f11197i != null && this.k != 0) {
                this.f11197i.d(Math.abs(getScrollYValue()) / this.k);
            }
            int abs = Math.abs(getScrollYValue());
            if (!n() || o() || j()) {
                return;
            }
            if (this.x && abs > this.k * this.y * 2.0f) {
                this.r = ILoadingLayout$State.RELEASE_TO_LONG_REFRESH;
            } else if (abs > this.k * this.y) {
                this.r = ILoadingLayout$State.RELEASE_TO_REFRESH;
            } else {
                this.r = ILoadingLayout$State.PULL_TO_REFRESH;
            }
            LoadingLayout loadingLayout = this.f11197i;
            if (loadingLayout != null) {
                loadingLayout.setState(this.r);
            }
            r(this.r, true);
        }
    }

    public void u() {
        int abs = Math.abs(getScrollYValue());
        boolean m = m();
        if (m && abs <= this.l) {
            z(0);
        } else if (m) {
            z(this.l);
        } else {
            z(0);
        }
    }

    public void v() {
        int abs = Math.abs(getScrollYValue());
        boolean o = o();
        boolean j = j();
        if ((o || j) && abs <= this.k) {
            z(0);
        } else if (!o && !j) {
            z(0);
        } else {
            z(-this.k);
        }
    }

    public void w() {
    }

    public final void x(int i2, int i3) {
        scrollBy(i2, i3);
    }

    public final void y(int i2, int i3) {
        scrollTo(i2, i3);
    }

    public final void z(int i2) {
        A(i2, getSmoothScrollDuration(), 0L);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11193e = HEADERTYPE.STANDARD_HEADER;
        this.f11194f = 2.5f;
        this.f11195g = -1.0f;
        this.m = true;
        this.n = false;
        this.o = true;
        this.p = false;
        ILoadingLayout$State iLoadingLayout$State = ILoadingLayout$State.NONE;
        this.r = iLoadingLayout$State;
        this.s = iLoadingLayout$State;
        this.w = -1;
        this.x = false;
        this.y = 1.0f;
        h(context, attributeSet);
    }
}
