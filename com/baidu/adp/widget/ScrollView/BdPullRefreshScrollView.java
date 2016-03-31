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
    private static /* synthetic */ int[] JZ;
    private static /* synthetic */ int[] Ka;
    private State JF;
    private Mode JG;
    private Mode JH;
    private int JI;
    private int JJ;
    protected View JK;
    private float JL;
    private FrameLayout JM;
    private FrameLayout JN;
    private float JO;
    private float JP;
    private com.baidu.adp.widget.ScrollView.a JQ;
    private com.baidu.adp.widget.ScrollView.a JR;
    private int JS;
    private c JT;
    private b JU;
    private a JV;
    private boolean JW;
    private boolean JX;
    private boolean JY;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void nN();
    }

    /* loaded from: classes.dex */
    public interface b {
        void nO();
    }

    /* loaded from: classes.dex */
    public interface c {
        void T(boolean z);
    }

    static /* synthetic */ int[] nL() {
        int[] iArr = JZ;
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
            JZ = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] nM() {
        int[] iArr = Ka;
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
            Ka = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.nw() != null) {
            if (this.JQ != null) {
                this.JM.removeView(this.JQ.nw());
            }
            this.JQ = aVar;
            this.JM.addView(this.JQ.nw());
            this.JQ.nv();
        }
    }

    public void setCustomFooterView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.nw() != null) {
            if (this.JR != null) {
                this.JN.removeView(this.JR.nw());
            }
            this.JR = aVar;
            this.JN.addView(this.JR.nw());
            this.JR.nv();
        }
    }

    public com.baidu.adp.widget.ScrollView.a getHeadLoadingView() {
        return this.JQ;
    }

    public com.baidu.adp.widget.ScrollView.a getmFootLoadingView() {
        return this.JR;
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
        this.JU = bVar;
    }

    public void setOnPullDownListener(a aVar) {
        this.JV = aVar;
    }

    public void setOnScrollUpDownListener(c cVar) {
        this.JT = cVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.JK = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.JH) {
            this.JH = mode;
            nx();
        }
    }

    protected void nx() {
        if (this.JH.showHeaderLoadingLayout()) {
            this.JM.setVisibility(0);
        } else {
            this.JM.setVisibility(8);
        }
        if (this.JH.showFooterLoadingLayout()) {
            this.JN.setVisibility(0);
        } else {
            this.JN.setVisibility(8);
        }
        this.JG = this.JH != Mode.BOTH ? this.JH : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.JF != State.REFRESHING) {
            if (this.JH.showHeaderLoadingLayout() && i == 1) {
                this.JW = true;
                fullScroll(33);
                aH(this.JS);
                this.JG = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.JQ);
                ny();
            } else if (this.JH.showFooterLoadingLayout() && i == 0) {
                this.JW = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.JG = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.JR);
                ny();
            }
        }
    }

    private void ny() {
        if (this.JG == Mode.PULL_FROM_START) {
            if (this.JV != null) {
                this.JV.nN();
            }
        } else if (this.JG == Mode.PULL_FROM_END && this.JU != null) {
            this.JU.nO();
        }
    }

    private boolean nz() {
        switch (nL()[this.JH.ordinal()]) {
            case 2:
                return nA();
            case 3:
                return nB();
            case 4:
                return nB() || nA();
            default:
                return false;
        }
    }

    private boolean nA() {
        switch (nL()[this.JH.ordinal()]) {
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

    private boolean nB() {
        switch (nL()[this.JH.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.JK.getHeight() + this.JN.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.JK.getHeight() + this.JN.getHeight() && getHeadViewTopMargin() == this.JS;
        }
    }

    private void nC() {
        if (getHeadViewTopMargin() >= this.JO) {
            a(State.RELEASE_TO_REFRESH, this.JQ);
        } else {
            a(State.PULL_TO_REFRESH, this.JQ);
        }
    }

    private void nD() {
        if (getHeadViewTopMargin() > this.JS && getHeadViewTopMargin() - getScrollY() < this.JO) {
            a(State.PULL_TO_REFRESH, this.JQ);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.JS) {
            a(State.RESET, this.JQ);
        }
    }

    private void nE() {
        if (getFootViewBottomMargin() >= this.JP) {
            a(State.RELEASE_TO_REFRESH, this.JR);
        } else {
            a(State.PULL_TO_REFRESH, this.JR);
        }
    }

    private void nF() {
        a(State.PULL_TO_REFRESH, this.JR);
    }

    private void nG() {
        this.JX = true;
        this.JY = false;
    }

    private void nH() {
        this.JX = false;
        this.JY = true;
    }

    private void nI() {
        this.JX = false;
        this.JY = false;
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
        if (!this.JH.permitsPullToRefresh() || this.JW) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.JL = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.JT != null) {
                    if (motionEvent.getY() - this.JL >= 20.0f) {
                        this.JT.T(true);
                    } else if (motionEvent.getY() - this.JL <= -30.0f) {
                        this.JT.T(false);
                    }
                }
                release();
                nI();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.JF == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.JL = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (nz()) {
                    if (nA() && i < 0 && this.JH.showHeaderLoadingLayout() && !this.JY) {
                        nG();
                        if (this.JH == Mode.BOTH) {
                            this.JG = Mode.PULL_FROM_START;
                        }
                        aH(i / 2);
                        nC();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (nA() && i > 0 && this.JH.showHeaderLoadingLayout() && !this.JY) {
                        nD();
                        aH(i / 2);
                    }
                    if (nB() && i > 0 && this.JH.showFooterLoadingLayout() && !this.JX) {
                        nH();
                        if (this.JH == Mode.BOTH) {
                            this.JG = Mode.PULL_FROM_END;
                        }
                        aI(i / 2);
                        nE();
                        return super.onTouchEvent(motionEvent);
                    } else if (nB() && i < 0 && this.JH.showFooterLoadingLayout() && !this.JX) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        nF();
                        break;
                    }
                } else if (this.JG == Mode.PULL_FROM_START && i > 0) {
                    nD();
                    aH(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.JG == Mode.PULL_FROM_END && i < 0) {
                    nF();
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

    private void aH(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.JM.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.JS) {
            layoutParams.topMargin = this.JS;
        }
        this.JM.setLayoutParams(layoutParams);
    }

    private void aI(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.JN.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.JN.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, com.baidu.adp.widget.ScrollView.a aVar) {
        if (this.JF != state) {
            this.JF = state;
            switch (nM()[state.ordinal()]) {
                case 1:
                    aVar.nv();
                    return;
                case 2:
                    aVar.nt();
                    return;
                case 3:
                    aVar.na();
                    return;
                case 4:
                    aVar.nb();
                    return;
                case 5:
                    aVar.nb();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.JM.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.JN.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.JG.showHeaderLoadingLayout()) {
            nJ();
        } else if (this.JG.showFooterLoadingLayout()) {
            nK();
        }
    }

    private void nJ() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.JF) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.JF) {
                k(getHeadViewTopMargin(), this.JS);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.JF) {
                scrollTo(0, 0);
                k(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.JF) {
                aH(getHeadViewTopMargin() - this.JS);
                scrollTo(0, 0);
                a(State.RESET, this.JQ);
            }
        } else if (getScrollY() < 0 && State.RESET != this.JF) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.JF) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.JF) {
                k(getHeadViewTopMargin(), this.JS);
            }
        }
    }

    private void k(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.JI);
            eVar.t(this.JM);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.nq();
        }
    }

    private void nK() {
        if (State.RELEASE_TO_REFRESH == this.JF) {
            l(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.JF) {
            aI(0 - getFootViewBottomMargin());
        }
    }

    private void l(int i, int i2) {
        com.baidu.adp.widget.ScrollView.b bVar = new com.baidu.adp.widget.ScrollView.b(i, i2, this.JJ);
        bVar.t(this.JN);
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

        /* JADX DEBUG: Replace access to removed values field (Kd) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Kc) with 'values()' method */
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
