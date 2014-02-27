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
    private static /* synthetic */ int[] y;
    private static /* synthetic */ int[] z;
    protected View a;
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
    private o q;
    private p r;
    private n s;
    private m t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;

    private static /* synthetic */ int[] h() {
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

    private static /* synthetic */ int[] i() {
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
        a(context, null, new q(context), new a(context));
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
        a(context, attributeSet, new q(context), new a(context));
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
        a(context, null, new q(context), new a(context));
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
        b();
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

    public void setOnPullUpListener(n nVar) {
        this.s = nVar;
    }

    public void setOnPullDownListener(m mVar) {
        this.t = mVar;
    }

    public void setOnStopListener(p pVar) {
        this.r = pVar;
    }

    public void setOnScrollUpDownListener(o oVar) {
        this.q = oVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.a = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.e) {
            this.e = mode;
            b();
        }
    }

    private void b() {
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

    public final void a() {
        if (this.c == State.REFRESHING || this.c == State.MANUAL_REFRESHING) {
            if (this.d == Mode.PULL_FROM_START) {
                f fVar = new f(0, this.p, 300);
                fVar.a(this.j);
                fVar.a(new j(this));
            } else if (this.d == Mode.PULL_FROM_END) {
                this.u = false;
                a(State.RESET, this.o);
            }
        }
    }

    public void setRefreshing(int i) {
        if (this.c != State.REFRESHING) {
            if (this.e.showHeaderLoadingLayout() && i == 1) {
                this.u = true;
                fullScroll(33);
                a(this.p);
                this.d = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.n);
                c();
            } else if (this.e.showFooterLoadingLayout() && i == 0) {
                this.u = true;
                fullScroll(130);
                this.d = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.o);
                c();
            }
        }
    }

    private void c() {
        if (this.d == Mode.PULL_FROM_START) {
            if (this.t != null) {
                this.t.a();
            }
        } else if (this.d == Mode.PULL_FROM_END && this.s != null) {
            n nVar = this.s;
        }
    }

    private boolean d() {
        switch (h()[this.e.ordinal()]) {
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
        switch (h()[this.e.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.a.getHeight() + this.k.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.a.getHeight() + this.k.getHeight() && getHeadViewTopMargin() == this.p;
        }
    }

    private void f() {
        if (getHeadViewTopMargin() > this.p && getHeadViewTopMargin() - getScrollY() < this.l) {
            a(State.PULL_TO_REFRESH, this.n);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.p) {
            a(State.RESET, this.n);
        }
    }

    private void g() {
        a(State.PULL_TO_REFRESH, this.o);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
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
                        o oVar = this.q;
                    } else if (motionEvent.getY() - this.i <= -30.0f) {
                        o oVar2 = this.q;
                    }
                }
                if (this.d.showHeaderLoadingLayout()) {
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
                } else if (this.d.showFooterLoadingLayout()) {
                    if (State.RELEASE_TO_REFRESH == this.c) {
                        c cVar = new c(getFootViewBottomMargin(), 0, this.g);
                        cVar.a(this.k);
                        cVar.a(new l(this));
                    } else if (State.PULL_TO_REFRESH == this.c) {
                        b(0 - getFootViewBottomMargin());
                    }
                }
                this.w = false;
                this.x = false;
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
                switch (h()[this.e.ordinal()]) {
                    case 2:
                        z2 = d();
                        break;
                    case 3:
                        z2 = e();
                        break;
                    case 4:
                        if (e() || d()) {
                            z2 = true;
                            break;
                        }
                        break;
                    default:
                        z2 = false;
                        break;
                }
                if (z2) {
                    if (d() && i < 0 && this.e.showHeaderLoadingLayout() && !this.x) {
                        this.w = true;
                        this.x = false;
                        if (this.e == Mode.BOTH) {
                            this.d = Mode.PULL_FROM_START;
                        }
                        a(i / 2);
                        if (getHeadViewTopMargin() >= this.l) {
                            a(State.RELEASE_TO_REFRESH, this.n);
                        } else {
                            a(State.PULL_TO_REFRESH, this.n);
                        }
                        return super.onTouchEvent(motionEvent);
                    }
                    if (d() && i > 0 && this.e.showHeaderLoadingLayout() && !this.x) {
                        f();
                        a(i / 2);
                    }
                    if (e() && i > 0 && this.e.showFooterLoadingLayout() && !this.w) {
                        this.w = false;
                        this.x = true;
                        if (this.e == Mode.BOTH) {
                            this.d = Mode.PULL_FROM_END;
                        }
                        b(i / 2);
                        if (getFootViewBottomMargin() >= this.m) {
                            a(State.RELEASE_TO_REFRESH, this.o);
                        } else {
                            a(State.PULL_TO_REFRESH, this.o);
                        }
                        return super.onTouchEvent(motionEvent);
                    } else if (e() && i < 0 && this.e.showFooterLoadingLayout() && !this.w) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        g();
                        break;
                    }
                } else if (this.d == Mode.PULL_FROM_START && i > 0) {
                    f();
                    a(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.d == Mode.PULL_FROM_END && i < 0) {
                    g();
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
        return ((LinearLayout.LayoutParams) this.j.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.k.getLayoutParams()).bottomMargin;
    }

    private void a(int i, int i2) {
        f fVar = new f(i, i2, this.f);
        fVar.a(this.j);
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
