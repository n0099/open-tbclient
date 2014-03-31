package com.baidu.adp.widget.ScrollView;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
/* loaded from: classes.dex */
public class BdPullRefreshScrollView extends ScrollView {
    private static /* synthetic */ int[] v;
    private static /* synthetic */ int[] w;
    protected View a;
    private State b;
    private Mode c;
    private Mode d;
    private int e;
    private int f;
    private float g;
    private float h;
    private FrameLayout i;
    private FrameLayout j;
    private float k;
    private float l;
    private b m;
    private b n;
    private int o;
    private o p;
    private n q;
    private m r;
    private boolean s;
    private boolean t;
    private boolean u;

    private static /* synthetic */ int[] h() {
        int[] iArr = v;
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
            v = iArr;
        }
        return iArr;
    }

    private static /* synthetic */ int[] i() {
        int[] iArr = w;
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
            w = iArr;
        }
        return iArr;
    }

    public BdPullRefreshScrollView(Context context) {
        super(context);
        this.b = State.RESET;
        this.d = Mode.getDefault();
        this.e = 200;
        this.f = 200;
        this.g = -1000.0f;
        this.s = false;
        this.t = false;
        this.u = false;
        a(context, null, new p(context), new a(context));
    }

    public BdPullRefreshScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = State.RESET;
        this.d = Mode.getDefault();
        this.e = 200;
        this.f = 200;
        this.g = -1000.0f;
        this.s = false;
        this.t = false;
        this.u = false;
        a(context, attributeSet, new p(context), new a(context));
    }

    public BdPullRefreshScrollView(Context context, Mode mode) {
        super(context);
        this.b = State.RESET;
        this.d = Mode.getDefault();
        this.e = 200;
        this.f = 200;
        this.g = -1000.0f;
        this.s = false;
        this.t = false;
        this.u = false;
        this.d = mode;
        a(context, null, new p(context), new a(context));
    }

    public BdPullRefreshScrollView(Context context, Mode mode, b bVar, b bVar2) {
        super(context);
        this.b = State.RESET;
        this.d = Mode.getDefault();
        this.e = 200;
        this.f = 200;
        this.g = -1000.0f;
        this.s = false;
        this.t = false;
        this.u = false;
        this.d = mode;
        a(context, null, bVar, bVar2);
    }

    private void a(Context context, AttributeSet attributeSet, b bVar, b bVar2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.adp.g.AdpPullToRefreshScrollView);
        if (obtainStyledAttributes.hasValue(0)) {
            this.d = Mode.mapIntToValue(obtainStyledAttributes.getInteger(0, 0));
        }
        this.e = obtainStyledAttributes.getInteger(4, 200);
        this.f = obtainStyledAttributes.getInteger(5, 200);
        LayoutInflater.from(context).inflate(com.baidu.adp.e.adp_pull_refresh_scroll_view, (ViewGroup) this, true);
        this.i = (FrameLayout) findViewById(com.baidu.adp.d.head_ly);
        this.j = (FrameLayout) findViewById(com.baidu.adp.d.foot_ly);
        setCustomHeaderView(bVar);
        setCustomFooterView(bVar2);
        if (obtainStyledAttributes.hasValue(1)) {
            this.k = obtainStyledAttributes.getDimension(1, 0.0f);
        } else {
            this.k = getResources().getDimension(com.baidu.adp.b.adp_head_need_refresh_delta);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.l = obtainStyledAttributes.getDimension(2, 0.0f);
        } else {
            this.l = getResources().getDimension(com.baidu.adp.b.adp_foot_need_refresh_delta);
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.o = -obtainStyledAttributes.getDimensionPixelSize(3, 0);
        } else {
            this.o = -getResources().getDimensionPixelSize(com.baidu.adp.b.adp_head_view_height);
        }
        setFadingEdgeLength(0);
        b();
    }

    public void setCustomHeaderView(b bVar) {
        if (bVar != null && bVar.getRealView() != null) {
            if (this.m != null) {
                this.i.removeView(this.m.getRealView());
            }
            this.m = bVar;
            this.i.addView(this.m.getRealView());
            this.m.b_();
        }
    }

    public void setCustomFooterView(b bVar) {
        if (bVar != null && bVar.getRealView() != null) {
            if (this.n != null) {
                this.j.removeView(this.n.getRealView());
            }
            this.n = bVar;
            this.j.addView(this.n.getRealView());
            this.n.b_();
        }
    }

    public b getHeadLoadingView() {
        return this.m;
    }

    public b getmFootLoadingView() {
        return this.n;
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

    public void setOnPullUpListener(n nVar) {
        this.q = nVar;
    }

    public void setOnPullDownListener(m mVar) {
        this.r = mVar;
    }

    public void setOnScrollUpDownListener(o oVar) {
        this.p = oVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.a = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.d) {
            this.d = mode;
            b();
        }
    }

    private void b() {
        if (this.d.showHeaderLoadingLayout()) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        if (this.d.showFooterLoadingLayout()) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
        this.c = this.d != Mode.BOTH ? this.d : Mode.PULL_FROM_START;
    }

    public final void a() {
        if (this.b == State.REFRESHING || this.b == State.MANUAL_REFRESHING) {
            if (this.c == Mode.PULL_FROM_START) {
                f fVar = new f(0, this.o, 300);
                fVar.a(this.i);
                fVar.a(new j(this));
            } else if (this.c == Mode.PULL_FROM_END) {
                this.s = false;
                a(State.RESET, this.n);
            }
        }
    }

    public void setRefreshing(int i) {
        if (this.b != State.REFRESHING) {
            if (this.d.showHeaderLoadingLayout() && i == 1) {
                this.s = true;
                fullScroll(33);
                a(this.o);
                this.c = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.m);
                c();
            } else if (this.d.showFooterLoadingLayout() && i == 0) {
                this.s = true;
                fullScroll(130);
                this.c = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.n);
                c();
            }
        }
    }

    private void c() {
        if (this.c == Mode.PULL_FROM_START) {
            if (this.r != null) {
                this.r.a();
            }
        } else if (this.c == Mode.PULL_FROM_END && this.q != null) {
            n nVar = this.q;
        }
    }

    private boolean d() {
        switch (h()[this.d.ordinal()]) {
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

    private boolean e() {
        switch (h()[this.d.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.a.getHeight() + this.j.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.a.getHeight() + this.j.getHeight() && getHeadViewTopMargin() == this.o;
        }
    }

    private void f() {
        if (getHeadViewTopMargin() > this.o && getHeadViewTopMargin() - getScrollY() < this.k) {
            a(State.PULL_TO_REFRESH, this.m);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.o) {
            a(State.RESET, this.m);
        }
    }

    private void g() {
        a(State.PULL_TO_REFRESH, this.n);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.d.permitsPullToRefresh() || this.s) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.g = motionEvent.getY();
                this.h = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.p != null) {
                    if (motionEvent.getY() - this.h >= 20.0f) {
                        o oVar = this.p;
                    } else if (motionEvent.getY() - this.h <= -30.0f) {
                        o oVar2 = this.p;
                    }
                }
                if (this.c.showHeaderLoadingLayout()) {
                    if (getScrollY() == 0) {
                        if (State.RELEASE_TO_REFRESH == this.b) {
                            a(getHeadViewTopMargin(), 0);
                        } else if (State.PULL_TO_REFRESH == this.b) {
                            a(getHeadViewTopMargin(), this.o);
                        }
                    } else if (getScrollY() > 0) {
                        if (State.RELEASE_TO_REFRESH == this.b) {
                            scrollTo(0, 0);
                            a(getHeadViewTopMargin() - getScrollY(), 0);
                        } else if (State.PULL_TO_REFRESH == this.b) {
                            a(getHeadViewTopMargin() - this.o);
                            scrollTo(0, 0);
                            a(State.RESET, this.m);
                        }
                    } else if (getScrollY() < 0 && State.RESET != this.b) {
                        scrollTo(0, 0);
                        if (State.RELEASE_TO_REFRESH == this.b) {
                            a(getHeadViewTopMargin(), 0);
                        } else if (State.PULL_TO_REFRESH == this.b) {
                            a(getHeadViewTopMargin(), this.o);
                        }
                    }
                } else if (this.c.showFooterLoadingLayout()) {
                    if (State.RELEASE_TO_REFRESH == this.b) {
                        c cVar = new c(getFootViewBottomMargin(), 0, this.f);
                        cVar.a(this.j);
                        cVar.a(new l(this));
                    } else if (State.PULL_TO_REFRESH == this.b) {
                        b(0 - getFootViewBottomMargin());
                    }
                }
                this.t = false;
                this.u = false;
                this.g = -1000.0f;
                break;
            case 2:
                if (this.b == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.g) {
                    this.g = motionEvent.getY();
                    this.h = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.g;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.g = y;
                switch (h()[this.d.ordinal()]) {
                    case 2:
                        z = d();
                        break;
                    case 3:
                        z = e();
                        break;
                    case 4:
                        if (e() || d()) {
                            z = true;
                            break;
                        }
                        break;
                    default:
                        z = false;
                        break;
                }
                if (z) {
                    if (d() && i < 0 && this.d.showHeaderLoadingLayout() && !this.u) {
                        this.t = true;
                        this.u = false;
                        if (this.d == Mode.BOTH) {
                            this.c = Mode.PULL_FROM_START;
                        }
                        a(i / 2);
                        if (getHeadViewTopMargin() >= this.k) {
                            a(State.RELEASE_TO_REFRESH, this.m);
                        } else {
                            a(State.PULL_TO_REFRESH, this.m);
                        }
                        return super.onTouchEvent(motionEvent);
                    }
                    if (d() && i > 0 && this.d.showHeaderLoadingLayout() && !this.u) {
                        f();
                        a(i / 2);
                    }
                    if (e() && i > 0 && this.d.showFooterLoadingLayout() && !this.t) {
                        this.t = false;
                        this.u = true;
                        if (this.d == Mode.BOTH) {
                            this.c = Mode.PULL_FROM_END;
                        }
                        b(i / 2);
                        if (getFootViewBottomMargin() >= this.l) {
                            a(State.RELEASE_TO_REFRESH, this.n);
                        } else {
                            a(State.PULL_TO_REFRESH, this.n);
                        }
                        return super.onTouchEvent(motionEvent);
                    } else if (e() && i < 0 && this.d.showFooterLoadingLayout() && !this.t) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        g();
                        break;
                    }
                } else if (this.c == Mode.PULL_FROM_START && i > 0) {
                    f();
                    a(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.c == Mode.PULL_FROM_END && i < 0) {
                    g();
                    return super.onTouchEvent(motionEvent);
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void a(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.o) {
            layoutParams.topMargin = this.o;
        }
        this.i.setLayoutParams(layoutParams);
    }

    private void b(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.j.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, b bVar) {
        if (this.b != state) {
            this.b = state;
            switch (i()[state.ordinal()]) {
                case 1:
                    bVar.b_();
                    return;
                case 2:
                    bVar.a_();
                    return;
                case 3:
                    bVar.e();
                    return;
                case 4:
                    bVar.f();
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
        return ((LinearLayout.LayoutParams) this.i.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.j.getLayoutParams()).bottomMargin;
    }

    private void a(int i, int i2) {
        f fVar = new f(i, i2, this.e);
        fVar.a(this.i);
        fVar.a(new k(this));
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

        final int getIntValue() {
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

        final boolean permitsPullToRefresh() {
            return (this == DISABLED || this == MANUAL_REFRESH_ONLY) ? false : true;
        }

        public final boolean showHeaderLoadingLayout() {
            return this == PULL_FROM_START || this == BOTH || this == MANUAL_REFRESH_ONLY;
        }

        public final boolean showFooterLoadingLayout() {
            return this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY;
        }

        final int getIntValue() {
            return this.mIntValue;
        }
    }
}
