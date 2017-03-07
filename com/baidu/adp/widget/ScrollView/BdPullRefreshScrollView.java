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
    private static /* synthetic */ int[] JF;
    private static /* synthetic */ int[] JG;
    private b JA;
    private a JB;
    private boolean JC;
    private boolean JD;
    private boolean JE;
    private State Jl;
    private Mode Jm;
    private Mode Jn;
    private int Jo;
    private int Jp;
    protected View Jq;
    private float Jr;
    private FrameLayout Js;
    private FrameLayout Jt;
    private float Ju;
    private float Jv;
    private com.baidu.adp.widget.ScrollView.a Jw;
    private com.baidu.adp.widget.ScrollView.a Jx;
    private int Jy;
    private c Jz;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void lG();
    }

    /* loaded from: classes.dex */
    public interface b {
        void lH();
    }

    /* loaded from: classes.dex */
    public interface c {
        void Y(boolean z);
    }

    static /* synthetic */ int[] lE() {
        int[] iArr = JF;
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
            JF = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] lF() {
        int[] iArr = JG;
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
            JG = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.ls() != null) {
            if (this.Jw != null) {
                this.Js.removeView(this.Jw.ls());
            }
            this.Jw = aVar;
            this.Js.addView(this.Jw.ls());
            this.Jw.lr();
        }
    }

    public void setCustomFooterView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.ls() != null) {
            if (this.Jx != null) {
                this.Jt.removeView(this.Jx.ls());
            }
            this.Jx = aVar;
            this.Jt.addView(this.Jx.ls());
            this.Jx.lr();
        }
    }

    public com.baidu.adp.widget.ScrollView.a getHeadLoadingView() {
        return this.Jw;
    }

    public com.baidu.adp.widget.ScrollView.a getmFootLoadingView() {
        return this.Jx;
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
        this.JA = bVar;
    }

    public void setOnPullDownListener(a aVar) {
        this.JB = aVar;
    }

    public void setOnScrollUpDownListener(c cVar) {
        this.Jz = cVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.Jq = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.Jn) {
            this.Jn = mode;
            updateUIForMode();
        }
    }

    protected void updateUIForMode() {
        if (this.Jn.showHeaderLoadingLayout()) {
            this.Js.setVisibility(0);
        } else {
            this.Js.setVisibility(8);
        }
        if (this.Jn.showFooterLoadingLayout()) {
            this.Jt.setVisibility(0);
        } else {
            this.Jt.setVisibility(8);
        }
        this.Jm = this.Jn != Mode.BOTH ? this.Jn : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.Jl != State.REFRESHING) {
            if (this.Jn.showHeaderLoadingLayout() && i == 1) {
                this.JC = true;
                fullScroll(33);
                aL(this.Jy);
                this.Jm = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.Jw);
                lt();
            } else if (this.Jn.showFooterLoadingLayout() && i == 0) {
                this.JC = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.Jm = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.Jx);
                lt();
            }
        }
    }

    private void lt() {
        if (this.Jm == Mode.PULL_FROM_START) {
            if (this.JB != null) {
                this.JB.lG();
            }
        } else if (this.Jm == Mode.PULL_FROM_END && this.JA != null) {
            this.JA.lH();
        }
    }

    private boolean lu() {
        switch (lE()[this.Jn.ordinal()]) {
            case 2:
                return isReadyForPullStart();
            case 3:
                return isReadyForPullEnd();
            case 4:
                return isReadyForPullEnd() || isReadyForPullStart();
            default:
                return false;
        }
    }

    private boolean isReadyForPullStart() {
        switch (lE()[this.Jn.ordinal()]) {
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

    private boolean isReadyForPullEnd() {
        switch (lE()[this.Jn.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.Jq.getHeight() + this.Jt.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.Jq.getHeight() + this.Jt.getHeight() && getHeadViewTopMargin() == this.Jy;
        }
    }

    private void lv() {
        if (getHeadViewTopMargin() >= this.Ju) {
            a(State.RELEASE_TO_REFRESH, this.Jw);
        } else {
            a(State.PULL_TO_REFRESH, this.Jw);
        }
    }

    private void lw() {
        if (getHeadViewTopMargin() > this.Jy && getHeadViewTopMargin() - getScrollY() < this.Ju) {
            a(State.PULL_TO_REFRESH, this.Jw);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.Jy) {
            a(State.RESET, this.Jw);
        }
    }

    private void lx() {
        if (getFootViewBottomMargin() >= this.Jv) {
            a(State.RELEASE_TO_REFRESH, this.Jx);
        } else {
            a(State.PULL_TO_REFRESH, this.Jx);
        }
    }

    private void ly() {
        a(State.PULL_TO_REFRESH, this.Jx);
    }

    private void lz() {
        this.JD = true;
        this.JE = false;
    }

    private void lA() {
        this.JD = false;
        this.JE = true;
    }

    private void lB() {
        this.JD = false;
        this.JE = false;
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
        if (!this.Jn.permitsPullToRefresh() || this.JC) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.Jr = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.Jz != null) {
                    if (motionEvent.getY() - this.Jr >= 20.0f) {
                        this.Jz.Y(true);
                    } else if (motionEvent.getY() - this.Jr <= -30.0f) {
                        this.Jz.Y(false);
                    }
                }
                release();
                lB();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.Jl == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.Jr = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (lu()) {
                    if (isReadyForPullStart() && i < 0 && this.Jn.showHeaderLoadingLayout() && !this.JE) {
                        lz();
                        if (this.Jn == Mode.BOTH) {
                            this.Jm = Mode.PULL_FROM_START;
                        }
                        aL(i / 2);
                        lv();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (isReadyForPullStart() && i > 0 && this.Jn.showHeaderLoadingLayout() && !this.JE) {
                        lw();
                        aL(i / 2);
                    }
                    if (isReadyForPullEnd() && i > 0 && this.Jn.showFooterLoadingLayout() && !this.JD) {
                        lA();
                        if (this.Jn == Mode.BOTH) {
                            this.Jm = Mode.PULL_FROM_END;
                        }
                        aM(i / 2);
                        lx();
                        return super.onTouchEvent(motionEvent);
                    } else if (isReadyForPullEnd() && i < 0 && this.Jn.showFooterLoadingLayout() && !this.JD) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        ly();
                        break;
                    }
                } else if (this.Jm == Mode.PULL_FROM_START && i > 0) {
                    lw();
                    aL(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.Jm == Mode.PULL_FROM_END && i < 0) {
                    ly();
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

    private void aL(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Js.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.Jy) {
            layoutParams.topMargin = this.Jy;
        }
        this.Js.setLayoutParams(layoutParams);
    }

    private void aM(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Jt.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.Jt.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, com.baidu.adp.widget.ScrollView.a aVar) {
        if (this.Jl != state) {
            this.Jl = state;
            switch (lF()[state.ordinal()]) {
                case 1:
                    aVar.lr();
                    return;
                case 2:
                    aVar.lq();
                    return;
                case 3:
                    aVar.lb();
                    return;
                case 4:
                    aVar.lc();
                    return;
                case 5:
                    aVar.lc();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.Js.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.Jt.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.Jm.showHeaderLoadingLayout()) {
            lC();
        } else if (this.Jm.showFooterLoadingLayout()) {
            lD();
        }
    }

    private void lC() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.Jl) {
                u(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.Jl) {
                u(getHeadViewTopMargin(), this.Jy);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.Jl) {
                scrollTo(0, 0);
                u(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.Jl) {
                aL(getHeadViewTopMargin() - this.Jy);
                scrollTo(0, 0);
                a(State.RESET, this.Jw);
            }
        } else if (getScrollY() < 0 && State.RESET != this.Jl) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.Jl) {
                u(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.Jl) {
                u(getHeadViewTopMargin(), this.Jy);
            }
        }
    }

    private void u(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.Jo);
            eVar.r(this.Js);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.ln();
        }
    }

    private void lD() {
        if (State.RELEASE_TO_REFRESH == this.Jl) {
            v(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.Jl) {
            aM(0 - getFootViewBottomMargin());
        }
    }

    private void v(int i, int i2) {
        com.baidu.adp.widget.ScrollView.b bVar = new com.baidu.adp.widget.ScrollView.b(i, i2, this.Jp);
        bVar.r(this.Jt);
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

        /* JADX DEBUG: Replace access to removed values field (JJ) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (JI) with 'values()' method */
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
