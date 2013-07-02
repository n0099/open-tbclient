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
import com.baidu.mapapi.MKEvent;
/* loaded from: classes.dex */
public class BdPullRefreshScrollView extends ScrollView {
    private static /* synthetic */ int[] y;
    private static /* synthetic */ int[] z;
    protected FrameLayout a;
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
    private c n;
    private c o;
    private float p;
    private p q;
    private q r;
    private o s;
    private n t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;

    static /* synthetic */ int[] f() {
        int[] iArr = y;
        if (iArr == null) {
            iArr = new int[Mode.valuesCustom().length];
            try {
                iArr[Mode.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Mode.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Mode.MANUAL_REFRESH_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Mode.PULL_FROM_END.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            y = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] g() {
        int[] iArr = z;
        if (iArr == null) {
            iArr = new int[State.valuesCustom().length];
            try {
                iArr[State.MANUAL_REFRESHING.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[State.OVERSCROLLING.ordinal()] = 6;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[State.PULL_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[State.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[State.RELEASE_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[State.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            z = iArr;
        }
        return iArr;
    }

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
        a(context, null, new b(context), new a(context));
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
        a(context, attributeSet, new b(context), new a(context));
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
        a(context, null, new b(context), new a(context));
    }

    public BdPullRefreshScrollView(Context context, Mode mode, c cVar, c cVar2) {
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
        a(context, null, cVar, cVar2);
    }

    private void a(Context context, AttributeSet attributeSet, c cVar, c cVar2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.adp.h.AdpPullToRefreshScrollView);
        if (obtainStyledAttributes.hasValue(0)) {
            this.e = Mode.mapIntToValue(obtainStyledAttributes.getInteger(0, 0));
        }
        this.b = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f = obtainStyledAttributes.getInteger(4, 200);
        this.g = obtainStyledAttributes.getInteger(5, 200);
        LayoutInflater.from(context).inflate(com.baidu.adp.f.adp_pull_refresh_scroll_view, (ViewGroup) this, true);
        this.a = (FrameLayout) findViewById(com.baidu.adp.e.content_ly);
        this.j = (FrameLayout) findViewById(com.baidu.adp.e.head_ly);
        this.k = (FrameLayout) findViewById(com.baidu.adp.e.foot_ly);
        setCustomHeaderView(cVar);
        setCustomFooterView(cVar2);
        if (obtainStyledAttributes.hasValue(1)) {
            this.l = obtainStyledAttributes.getDimension(1, 0.0f);
        } else {
            this.l = getResources().getDimension(com.baidu.adp.c.adp_head_need_refresh_delta);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.m = obtainStyledAttributes.getDimension(2, 0.0f);
        } else {
            this.m = getResources().getDimension(com.baidu.adp.c.adp_foot_need_refresh_delta);
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.p = -obtainStyledAttributes.getDimension(3, 0.0f);
        } else {
            this.p = -getResources().getDimension(com.baidu.adp.c.adp_head_view_height);
        }
        setFadingEdgeLength(0);
        a();
    }

    public void setCustomHeaderView(c cVar) {
        if (this.n != null) {
            this.j.removeView((View) this.n);
        }
        this.n = cVar;
        this.j.addView((View) this.n);
        this.n.d();
    }

    public void setCustomFooterView(c cVar) {
        if (this.o != null) {
            this.k.removeView((View) this.o);
        }
        this.o = cVar;
        this.k.addView((View) this.o);
        this.o.d();
    }

    public c getHeadLoadingView() {
        return this.n;
    }

    public c getmFootLoadingView() {
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
        this.a.addView(view);
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
        g gVar = new g(0, (int) this.p, MKEvent.ERROR_PERMISSION_DENIED);
        gVar.a(this.j);
        gVar.a(new k(this));
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
                a((int) this.p);
                this.d = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.n);
                h();
            } else if (this.e.showFooterLoadingLayout() && i == 0) {
                this.u = true;
                fullScroll(130);
                this.d = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.o);
                h();
            }
        }
    }

    private void h() {
        if (this.d == Mode.PULL_FROM_START) {
            if (this.t != null) {
                this.t.a();
            }
        } else if (this.d == Mode.PULL_FROM_END && this.s != null) {
            this.s.a();
        }
    }

    private boolean i() {
        switch (f()[this.e.ordinal()]) {
            case 2:
                return j();
            case 3:
                return k();
            case 4:
                return k() || j();
            default:
                return false;
        }
    }

    private boolean j() {
        switch (f()[this.e.ordinal()]) {
            case 2:
                return getScrollY() <= 0;
            case 3:
                return false;
            case 4:
                return getScrollY() <= 0 && getPaddingBottom() == 0;
            default:
                return false;
        }
    }

    private boolean k() {
        switch (f()[this.e.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.a.getHeight() + this.k.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.a.getHeight() + this.k.getHeight() && ((float) getHeadViewTopMargin()) == this.p;
        }
    }

    private void l() {
        if (getHeadViewTopMargin() >= this.l) {
            a(State.RELEASE_TO_REFRESH, this.n);
        } else {
            a(State.PULL_TO_REFRESH, this.n);
        }
    }

    private void m() {
        if (getHeadViewTopMargin() > this.p && getHeadViewTopMargin() - getScrollY() < this.l) {
            a(State.PULL_TO_REFRESH, this.n);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.p) {
            a(State.RESET, this.n);
        }
    }

    private void n() {
        if (getFootViewBottomMargin() >= this.m) {
            a(State.RELEASE_TO_REFRESH, this.o);
        } else {
            a(State.PULL_TO_REFRESH, this.o);
        }
    }

    private void o() {
        a(State.PULL_TO_REFRESH, this.o);
    }

    private void p() {
        this.w = true;
        this.x = false;
    }

    private void q() {
        this.w = false;
        this.x = true;
    }

    private void r() {
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
                s();
                r();
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
                float y2 = motionEvent.getY();
                int i = (int) (f - y2);
                this.h = y2;
                if (i()) {
                    if (j() && i < 0 && this.e.showHeaderLoadingLayout() && !this.x) {
                        p();
                        if (this.e == Mode.BOTH) {
                            this.d = Mode.PULL_FROM_START;
                        }
                        a(i / 2);
                        l();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (j() && i > 0 && this.e.showHeaderLoadingLayout() && !this.x) {
                        m();
                        a(i / 2);
                    }
                    if (k() && i > 0 && this.e.showFooterLoadingLayout() && !this.w) {
                        q();
                        if (this.e == Mode.BOTH) {
                            this.d = Mode.PULL_FROM_END;
                        }
                        b(i / 2);
                        n();
                        return super.onTouchEvent(motionEvent);
                    } else if (k() && i < 0 && this.e.showFooterLoadingLayout() && !this.w) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        o();
                        break;
                    }
                } else if (this.d == Mode.PULL_FROM_START && i > 0) {
                    m();
                    a(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.d == Mode.PULL_FROM_END && i < 0) {
                    o();
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
            layoutParams.topMargin = (int) this.p;
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
    public void a(State state, c cVar) {
        if (this.c != state) {
            this.c = state;
            switch (g()[state.ordinal()]) {
                case 1:
                    cVar.d();
                    return;
                case 2:
                    cVar.a();
                    return;
                case 3:
                    cVar.b();
                    return;
                case 4:
                    cVar.c();
                    return;
                case 5:
                    cVar.c();
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

    private void s() {
        if (this.d.showHeaderLoadingLayout()) {
            t();
        } else if (this.d.showFooterLoadingLayout()) {
            u();
        }
    }

    private void t() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.c) {
                a(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.c) {
                a(getHeadViewTopMargin(), (int) this.p);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.c) {
                scrollTo(0, 0);
                a(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.c) {
                a(getHeadViewTopMargin() - ((int) this.p));
                scrollTo(0, 0);
                a(State.RESET, this.n);
            }
        } else if (getScrollY() < 0 && State.RESET != this.c) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.c) {
                a(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.c) {
                a(getHeadViewTopMargin(), (int) this.p);
            }
        }
    }

    private void a(int i, int i2) {
        g gVar = new g(i, i2, this.f);
        gVar.a(this.j);
        gVar.a(new l(this));
    }

    private void u() {
        if (State.RELEASE_TO_REFRESH == this.c) {
            b(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.c) {
            b(0 - getFootViewBottomMargin());
        }
    }

    private void b(int i, int i2) {
        d dVar = new d(i, i2, this.g);
        dVar.a(this.k);
        dVar.a(new m(this));
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

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] valuesCustom = values();
            int length = valuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(valuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }

        static State mapIntToValue(int i) {
            State[] valuesCustom;
            for (State state : valuesCustom()) {
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

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Mode[] valuesCustom() {
            Mode[] valuesCustom = values();
            int length = valuesCustom.length;
            Mode[] modeArr = new Mode[length];
            System.arraycopy(valuesCustom, 0, modeArr, 0, length);
            return modeArr;
        }

        static Mode mapIntToValue(int i) {
            Mode[] valuesCustom;
            for (Mode mode : valuesCustom()) {
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
