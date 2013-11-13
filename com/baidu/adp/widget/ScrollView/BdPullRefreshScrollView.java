package com.baidu.adp.widget.ScrollView;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
/* loaded from: classes.dex */
public class BdPullRefreshScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    protected View f582a;
    private int b;
    private State c;
    private Mode d;
    private Mode e;
    private int f;
    private int g;
    private float h;
    private float i;
    private FrameLayout j;
    private FrameLayout k;
    private float l;
    private float m;
    private b n;
    private b o;
    private int p;
    private p q;
    private q r;
    private o s;
    private n t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;

    public BdPullRefreshScrollView(Context context) {
        super(context);
        this.c = State.RESET;
        this.e = Mode.getDefault();
        this.f = 200;
        this.g = 200;
        this.h = -1000.0f;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        a(context, null, new r(context), new a(context));
    }

    public BdPullRefreshScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = State.RESET;
        this.e = Mode.getDefault();
        this.f = 200;
        this.g = 200;
        this.h = -1000.0f;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        a(context, attributeSet, new r(context), new a(context));
    }

    public BdPullRefreshScrollView(Context context, Mode mode) {
        super(context);
        this.c = State.RESET;
        this.e = Mode.getDefault();
        this.f = 200;
        this.g = 200;
        this.h = -1000.0f;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.e = mode;
        a(context, null, new r(context), new a(context));
    }

    public BdPullRefreshScrollView(Context context, Mode mode, b bVar, b bVar2) {
        super(context);
        this.c = State.RESET;
        this.e = Mode.getDefault();
        this.f = 200;
        this.g = 200;
        this.h = -1000.0f;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.e = mode;
        a(context, null, bVar, bVar2);
    }

    private void a(Context context, AttributeSet attributeSet, b bVar, b bVar2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.adp.g.AdpPullToRefreshScrollView);
        if (obtainStyledAttributes.hasValue(0)) {
            this.e = Mode.mapIntToValue(obtainStyledAttributes.getInteger(0, 0));
        }
        this.b = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f = obtainStyledAttributes.getInteger(4, 200);
        this.g = obtainStyledAttributes.getInteger(5, 200);
        LayoutInflater.from(context).inflate(com.baidu.adp.e.adp_pull_refresh_scroll_view, (ViewGroup) this, true);
        this.j = (FrameLayout) findViewById(com.baidu.adp.d.head_ly);
        this.k = (FrameLayout) findViewById(com.baidu.adp.d.foot_ly);
        setCustomHeaderView(bVar);
        setCustomFooterView(bVar2);
        if (obtainStyledAttributes.hasValue(1)) {
            this.l = obtainStyledAttributes.getDimension(1, 0.0f);
        } else {
            this.l = getResources().getDimension(com.baidu.adp.b.adp_head_need_refresh_delta);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.m = obtainStyledAttributes.getDimension(2, 0.0f);
        } else {
            this.m = getResources().getDimension(com.baidu.adp.b.adp_foot_need_refresh_delta);
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.p = -obtainStyledAttributes.getDimensionPixelSize(3, 0);
        } else {
            this.p = -getResources().getDimensionPixelSize(com.baidu.adp.b.adp_head_view_height);
        }
        setFadingEdgeLength(0);
        a();
    }

    public void setCustomHeaderView(b bVar) {
        if (bVar != null && bVar.getRealView() != null) {
            if (this.n != null) {
                this.j.removeView(this.n.getRealView());
            }
            this.n = bVar;
            this.j.addView(this.n.getRealView());
            this.n.b_();
        }
    }

    public void setCustomFooterView(b bVar) {
        if (bVar != null && bVar.getRealView() != null) {
            if (this.o != null) {
                this.k.removeView(this.o.getRealView());
            }
            this.o = bVar;
            this.k.addView(this.o.getRealView());
            this.o.b_();
        }
    }

    public b getHeadLoadingView() {
        return this.n;
    }

    public b getmFootLoadingView() {
        return this.o;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            if (getChildCount() == 1) {
                setContentView(view);
                return;
            }
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            if (getChildCount() == 1) {
                setContentView(view);
                return;
            }
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            if (getChildCount() == 1) {
                setContentView(view);
                return;
            }
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            if (getChildCount() == 1) {
                setContentView(view);
                return;
            }
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void setOnPullUpListener(o oVar) {
        this.s = oVar;
    }

    public void setOnPullDownListener(n nVar) {
        this.t = nVar;
    }

    public void setOnStopListener(q qVar) {
        this.r = qVar;
    }

    public void setOnScrollUpDownListener(p pVar) {
        this.q = pVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.f582a = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.e) {
            this.e = mode;
            a();
        }
    }

    protected void a() {
        if (this.e.showHeaderLoadingLayout()) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
        if (this.e.showFooterLoadingLayout()) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
        this.d = this.e != Mode.BOTH ? this.e : Mode.PULL_FROM_START;
    }

    public final boolean b() {
        return this.c == State.REFRESHING || this.c == State.MANUAL_REFRESHING;
    }

    public final void c() {
        if (b()) {
            if (this.d == Mode.PULL_FROM_START) {
                d();
            } else if (this.d == Mode.PULL_FROM_END) {
                e();
            }
        }
    }

    protected void d() {
        f fVar = new f(0, this.p, 300);
        fVar.a(this.j);
        fVar.a(new j(this));
    }

    protected void e() {
        this.u = false;
        a(State.RESET, this.o);
    }

    public void setRefreshing(int i) {
        if (this.c != State.REFRESHING) {
            if (this.e.showHeaderLoadingLayout() && i == 1) {
                this.u = true;
                fullScroll(33);
                a(this.p);
                this.d = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.n);
                f();
            } else if (this.e.showFooterLoadingLayout() && i == 0) {
                this.u = true;
                fullScroll(130);
                this.d = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.o);
                f();
            }
        }
    }

    private void f() {
        if (this.d == Mode.PULL_FROM_START) {
            if (this.t != null) {
                this.t.a();
            }
        } else if (this.d == Mode.PULL_FROM_END && this.s != null) {
            this.s.a();
        }
    }

    private boolean g() {
        switch (m.f595a[this.e.ordinal()]) {
            case 1:
                return h();
            case 2:
                return i();
            case 3:
                return i() || h();
            default:
                return false;
        }
    }

    private boolean h() {
        switch (m.f595a[this.e.ordinal()]) {
            case 1:
                return getScrollY() <= 0;
            case 2:
                return false;
            case 3:
                return getScrollY() <= 0 && getPaddingBottom() == 0;
            default:
                return false;
        }
    }

    private boolean i() {
        switch (m.f595a[this.e.ordinal()]) {
            case 1:
            default:
                return false;
            case 2:
                return getScrollY() + getHeight() >= this.f582a.getHeight() + this.k.getHeight();
            case 3:
                if (getScrollY() + getHeight() < this.f582a.getHeight() + this.k.getHeight() || getHeadViewTopMargin() != this.p) {
                    r0 = false;
                }
                return r0;
        }
    }

    private void j() {
        if (getHeadViewTopMargin() >= this.l) {
            a(State.RELEASE_TO_REFRESH, this.n);
        } else {
            a(State.PULL_TO_REFRESH, this.n);
        }
    }

    private void k() {
        if (getHeadViewTopMargin() > this.p && getHeadViewTopMargin() - getScrollY() < this.l) {
            a(State.PULL_TO_REFRESH, this.n);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.p) {
            a(State.RESET, this.n);
        }
    }

    private void l() {
        if (getFootViewBottomMargin() >= this.m) {
            a(State.RELEASE_TO_REFRESH, this.o);
        } else {
            a(State.PULL_TO_REFRESH, this.o);
        }
    }

    private void m() {
        a(State.PULL_TO_REFRESH, this.o);
    }

    private void n() {
        this.w = true;
        this.x = false;
    }

    private void o() {
        this.w = false;
        this.x = true;
    }

    private void p() {
        this.w = false;
        this.x = false;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.e.permitsPullToRefresh() || this.u) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.h = motionEvent.getY();
                this.i = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.q != null) {
                    if (motionEvent.getY() - this.i >= 20.0f) {
                        this.q.a(true);
                    } else if (motionEvent.getY() - this.i <= -30.0f) {
                        this.q.a(false);
                    }
                }
                q();
                p();
                this.h = -1000.0f;
                break;
            case 2:
                if (this.c == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.h) {
                    this.h = motionEvent.getY();
                    this.i = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.h;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.h = y;
                if (g()) {
                    if (h() && i < 0 && this.e.showHeaderLoadingLayout() && !this.x) {
                        n();
                        if (this.e == Mode.BOTH) {
                            this.d = Mode.PULL_FROM_START;
                        }
                        a(i / 2);
                        j();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (h() && i > 0 && this.e.showHeaderLoadingLayout() && !this.x) {
                        k();
                        a(i / 2);
                    }
                    if (i() && i > 0 && this.e.showFooterLoadingLayout() && !this.w) {
                        o();
                        if (this.e == Mode.BOTH) {
                            this.d = Mode.PULL_FROM_END;
                        }
                        b(i / 2);
                        l();
                        return super.onTouchEvent(motionEvent);
                    } else if (i() && i < 0 && this.e.showFooterLoadingLayout() && !this.w) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        m();
                        break;
                    }
                } else if (this.d == Mode.PULL_FROM_START && i > 0) {
                    k();
                    a(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.d == Mode.PULL_FROM_END && i < 0) {
                    m();
                    return super.onTouchEvent(motionEvent);
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void a(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.p) {
            layoutParams.topMargin = this.p;
        }
        this.j.setLayoutParams(layoutParams);
    }

    private void b(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.k.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, b bVar) {
        if (this.c != state) {
            this.c = state;
            switch (m.b[state.ordinal()]) {
                case 1:
                    bVar.a_();
                    return;
                case 2:
                    bVar.e();
                    return;
                case 3:
                    bVar.f();
                    return;
                case 4:
                    bVar.b_();
                    return;
                case 5:
                    bVar.f();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.j.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.k.getLayoutParams()).bottomMargin;
    }

    private void q() {
        if (this.d.showHeaderLoadingLayout()) {
            r();
        } else if (this.d.showFooterLoadingLayout()) {
            s();
        }
    }

    private void r() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.c) {
                a(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.c) {
                a(getHeadViewTopMargin(), this.p);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.c) {
                scrollTo(0, 0);
                a(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.c) {
                a(getHeadViewTopMargin() - this.p);
                scrollTo(0, 0);
                a(State.RESET, this.n);
            }
        } else if (getScrollY() < 0 && State.RESET != this.c) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.c) {
                a(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.c) {
                a(getHeadViewTopMargin(), this.p);
            }
        }
    }

    private void a(int i, int i2) {
        f fVar = new f(i, i2, this.f);
        fVar.a(this.j);
        fVar.a(new k(this));
    }

    private void s() {
        if (State.RELEASE_TO_REFRESH == this.c) {
            b(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.c) {
            b(0 - getFootViewBottomMargin());
        }
    }

    private void b(int i, int i2) {
        c cVar = new c(i, i2, this.g);
        cVar.a(this.k);
        cVar.a(new l(this));
    }

    /* loaded from: classes.dex */
    public enum State {
        RESET(0),
        PULL_TO_REFRESH(1),
        RELEASE_TO_REFRESH(2),
        REFRESHING(8),
        MANUAL_REFRESHING(9),
        OVERSCROLLING(16);
        
        private int mIntValue;

        static State mapIntToValue(int i) {
            State[] values;
            for (State state : values()) {
                if (i == state.getIntValue()) {
                    return state;
                }
            }
            return RESET;
        }

        State(int i) {
            this.mIntValue = i;
        }

        int getIntValue() {
            return this.mIntValue;
        }
    }

    /* loaded from: classes.dex */
    public enum Mode {
        DISABLED(0),
        PULL_FROM_START(1),
        PULL_FROM_END(2),
        BOTH(3),
        MANUAL_REFRESH_ONLY(4);
        
        private int mIntValue;

        static Mode mapIntToValue(int i) {
            Mode[] values;
            for (Mode mode : values()) {
                if (i == mode.getIntValue()) {
                    return mode;
                }
            }
            return getDefault();
        }

        static Mode getDefault() {
            return PULL_FROM_START;
        }

        Mode(int i) {
            this.mIntValue = i;
        }

        boolean permitsPullToRefresh() {
            return (this == DISABLED || this == MANUAL_REFRESH_ONLY) ? false : true;
        }

        public boolean showHeaderLoadingLayout() {
            return this == PULL_FROM_START || this == BOTH || this == MANUAL_REFRESH_ONLY;
        }

        public boolean showFooterLoadingLayout() {
            return this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY;
        }

        int getIntValue() {
            return this.mIntValue;
        }
    }
}
