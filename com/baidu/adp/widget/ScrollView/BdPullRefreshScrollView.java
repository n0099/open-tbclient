package com.baidu.adp.widget.ScrollView;

import android.support.v4.media.TransportMediator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class BdPullRefreshScrollView extends ScrollView {
    private static /* synthetic */ int[] JE;
    private static /* synthetic */ int[] JF;
    private a JA;
    private boolean JB;
    private boolean JC;
    private boolean JD;
    private State Jk;
    private Mode Jl;
    private Mode Jm;
    private int Jn;
    private int Jo;
    protected View Jp;
    private float Jq;
    private FrameLayout Jr;
    private FrameLayout Js;
    private float Jt;
    private float Ju;
    private com.baidu.adp.widget.ScrollView.a Jv;
    private com.baidu.adp.widget.ScrollView.a Jw;
    private int Jx;
    private c Jy;
    private b Jz;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void nA();
    }

    /* loaded from: classes.dex */
    public interface b {
        void nB();
    }

    /* loaded from: classes.dex */
    public interface c {
        void U(boolean z);
    }

    static /* synthetic */ int[] ny() {
        int[] iArr = JE;
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
            JE = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] nz() {
        int[] iArr = JF;
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
            JF = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.nj() != null) {
            if (this.Jv != null) {
                this.Jr.removeView(this.Jv.nj());
            }
            this.Jv = aVar;
            this.Jr.addView(this.Jv.nj());
            this.Jv.ni();
        }
    }

    public void setCustomFooterView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.nj() != null) {
            if (this.Jw != null) {
                this.Js.removeView(this.Jw.nj());
            }
            this.Jw = aVar;
            this.Js.addView(this.Jw.nj());
            this.Jw.ni();
        }
    }

    public com.baidu.adp.widget.ScrollView.a getHeadLoadingView() {
        return this.Jv;
    }

    public com.baidu.adp.widget.ScrollView.a getmFootLoadingView() {
        return this.Jw;
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

    public void setOnPullUpListener(b bVar) {
        this.Jz = bVar;
    }

    public void setOnPullDownListener(a aVar) {
        this.JA = aVar;
    }

    public void setOnScrollUpDownListener(c cVar) {
        this.Jy = cVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.Jp = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.Jm) {
            this.Jm = mode;
            nk();
        }
    }

    protected void nk() {
        if (this.Jm.showHeaderLoadingLayout()) {
            this.Jr.setVisibility(0);
        } else {
            this.Jr.setVisibility(8);
        }
        if (this.Jm.showFooterLoadingLayout()) {
            this.Js.setVisibility(0);
        } else {
            this.Js.setVisibility(8);
        }
        this.Jl = this.Jm != Mode.BOTH ? this.Jm : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.Jk != State.REFRESHING) {
            if (this.Jm.showHeaderLoadingLayout() && i == 1) {
                this.JB = true;
                fullScroll(33);
                av(this.Jx);
                this.Jl = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.Jv);
                nl();
            } else if (this.Jm.showFooterLoadingLayout() && i == 0) {
                this.JB = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.Jl = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.Jw);
                nl();
            }
        }
    }

    private void nl() {
        if (this.Jl == Mode.PULL_FROM_START) {
            if (this.JA != null) {
                this.JA.nA();
            }
        } else if (this.Jl == Mode.PULL_FROM_END && this.Jz != null) {
            this.Jz.nB();
        }
    }

    private boolean nm() {
        switch (ny()[this.Jm.ordinal()]) {
            case 2:
                return nn();
            case 3:
                return no();
            case 4:
                return no() || nn();
            default:
                return false;
        }
    }

    private boolean nn() {
        switch (ny()[this.Jm.ordinal()]) {
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

    private boolean no() {
        switch (ny()[this.Jm.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.Jp.getHeight() + this.Js.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.Jp.getHeight() + this.Js.getHeight() && getHeadViewTopMargin() == this.Jx;
        }
    }

    private void np() {
        if (getHeadViewTopMargin() >= this.Jt) {
            a(State.RELEASE_TO_REFRESH, this.Jv);
        } else {
            a(State.PULL_TO_REFRESH, this.Jv);
        }
    }

    private void nq() {
        if (getHeadViewTopMargin() > this.Jx && getHeadViewTopMargin() - getScrollY() < this.Jt) {
            a(State.PULL_TO_REFRESH, this.Jv);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.Jx) {
            a(State.RESET, this.Jv);
        }
    }

    private void nr() {
        if (getFootViewBottomMargin() >= this.Ju) {
            a(State.RELEASE_TO_REFRESH, this.Jw);
        } else {
            a(State.PULL_TO_REFRESH, this.Jw);
        }
    }

    private void ns() {
        a(State.PULL_TO_REFRESH, this.Jw);
    }

    private void nt() {
        this.JC = true;
        this.JD = false;
    }

    private void nu() {
        this.JC = false;
        this.JD = true;
    }

    private void nv() {
        this.JC = false;
        this.JD = false;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        super.onInterceptTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.mLastMotionY = y;
                this.mIsBeingDragged = this.mScroller.isFinished() ? false : true;
                break;
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (((int) Math.abs(y - this.mLastMotionY)) > this.mTouchSlop) {
                    this.mIsBeingDragged = true;
                    break;
                }
                break;
        }
        return this.mIsBeingDragged;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.Jm.permitsPullToRefresh() || this.JB) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.Jq = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.Jy != null) {
                    if (motionEvent.getY() - this.Jq >= 20.0f) {
                        this.Jy.U(true);
                    } else if (motionEvent.getY() - this.Jq <= -30.0f) {
                        this.Jy.U(false);
                    }
                }
                release();
                nv();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.Jk == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.Jq = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (nm()) {
                    if (nn() && i < 0 && this.Jm.showHeaderLoadingLayout() && !this.JD) {
                        nt();
                        if (this.Jm == Mode.BOTH) {
                            this.Jl = Mode.PULL_FROM_START;
                        }
                        av(i / 2);
                        np();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (nn() && i > 0 && this.Jm.showHeaderLoadingLayout() && !this.JD) {
                        nq();
                        av(i / 2);
                    }
                    if (no() && i > 0 && this.Jm.showFooterLoadingLayout() && !this.JC) {
                        nu();
                        if (this.Jm == Mode.BOTH) {
                            this.Jl = Mode.PULL_FROM_END;
                        }
                        aw(i / 2);
                        nr();
                        return super.onTouchEvent(motionEvent);
                    } else if (no() && i < 0 && this.Jm.showFooterLoadingLayout() && !this.JC) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        ns();
                        break;
                    }
                } else if (this.Jl == Mode.PULL_FROM_START && i > 0) {
                    nq();
                    av(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.Jl == Mode.PULL_FROM_END && i < 0) {
                    ns();
                    return super.onTouchEvent(motionEvent);
                }
                break;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            BdLog.detailException(e);
            return true;
        }
    }

    private void av(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Jr.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.Jx) {
            layoutParams.topMargin = this.Jx;
        }
        this.Jr.setLayoutParams(layoutParams);
    }

    private void aw(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Js.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.Js.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, com.baidu.adp.widget.ScrollView.a aVar) {
        if (this.Jk != state) {
            this.Jk = state;
            switch (nz()[state.ordinal()]) {
                case 1:
                    aVar.ni();
                    return;
                case 2:
                    aVar.nh();
                    return;
                case 3:
                    aVar.mU();
                    return;
                case 4:
                    aVar.mV();
                    return;
                case 5:
                    aVar.mV();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.Jr.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.Js.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.Jl.showHeaderLoadingLayout()) {
            nw();
        } else if (this.Jl.showFooterLoadingLayout()) {
            nx();
        }
    }

    private void nw() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.Jk) {
                j(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.Jk) {
                j(getHeadViewTopMargin(), this.Jx);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.Jk) {
                scrollTo(0, 0);
                j(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.Jk) {
                av(getHeadViewTopMargin() - this.Jx);
                scrollTo(0, 0);
                a(State.RESET, this.Jv);
            }
        } else if (getScrollY() < 0 && State.RESET != this.Jk) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.Jk) {
                j(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.Jk) {
                j(getHeadViewTopMargin(), this.Jx);
            }
        }
    }

    private void j(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.Jn);
            eVar.h(this.Jr);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.nf();
        }
    }

    private void nx() {
        if (State.RELEASE_TO_REFRESH == this.Jk) {
            k(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.Jk) {
            aw(0 - getFootViewBottomMargin());
        }
    }

    private void k(int i, int i2) {
        com.baidu.adp.widget.ScrollView.b bVar = new com.baidu.adp.widget.ScrollView.b(i, i2, this.Jo);
        bVar.h(this.Js);
        bVar.a(new i(this));
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

        /* JADX DEBUG: Replace access to removed values field (JI) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (JH) with 'values()' method */
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
