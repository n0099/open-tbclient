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
    private static /* synthetic */ int[] JT;
    private static /* synthetic */ int[] JU;
    private Mode JA;
    private Mode JB;
    private int JC;
    private int JD;
    protected View JE;
    private float JF;
    private FrameLayout JG;
    private FrameLayout JH;
    private float JI;
    private float JJ;
    private com.baidu.adp.widget.ScrollView.a JK;
    private com.baidu.adp.widget.ScrollView.a JL;
    private int JM;
    private c JN;
    private b JO;
    private a JP;
    private boolean JQ;
    private boolean JR;
    private boolean JS;
    private State Jz;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void nU();
    }

    /* loaded from: classes.dex */
    public interface b {
        void nV();
    }

    /* loaded from: classes.dex */
    public interface c {
        void U(boolean z);
    }

    static /* synthetic */ int[] nS() {
        int[] iArr = JT;
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
            JT = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] nT() {
        int[] iArr = JU;
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
            JU = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.nD() != null) {
            if (this.JK != null) {
                this.JG.removeView(this.JK.nD());
            }
            this.JK = aVar;
            this.JG.addView(this.JK.nD());
            this.JK.nC();
        }
    }

    public void setCustomFooterView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.nD() != null) {
            if (this.JL != null) {
                this.JH.removeView(this.JL.nD());
            }
            this.JL = aVar;
            this.JH.addView(this.JL.nD());
            this.JL.nC();
        }
    }

    public com.baidu.adp.widget.ScrollView.a getHeadLoadingView() {
        return this.JK;
    }

    public com.baidu.adp.widget.ScrollView.a getmFootLoadingView() {
        return this.JL;
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
        this.JO = bVar;
    }

    public void setOnPullDownListener(a aVar) {
        this.JP = aVar;
    }

    public void setOnScrollUpDownListener(c cVar) {
        this.JN = cVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.JE = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.JB) {
            this.JB = mode;
            nE();
        }
    }

    protected void nE() {
        if (this.JB.showHeaderLoadingLayout()) {
            this.JG.setVisibility(0);
        } else {
            this.JG.setVisibility(8);
        }
        if (this.JB.showFooterLoadingLayout()) {
            this.JH.setVisibility(0);
        } else {
            this.JH.setVisibility(8);
        }
        this.JA = this.JB != Mode.BOTH ? this.JB : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.Jz != State.REFRESHING) {
            if (this.JB.showHeaderLoadingLayout() && i == 1) {
                this.JQ = true;
                fullScroll(33);
                aI(this.JM);
                this.JA = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.JK);
                nF();
            } else if (this.JB.showFooterLoadingLayout() && i == 0) {
                this.JQ = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.JA = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.JL);
                nF();
            }
        }
    }

    private void nF() {
        if (this.JA == Mode.PULL_FROM_START) {
            if (this.JP != null) {
                this.JP.nU();
            }
        } else if (this.JA == Mode.PULL_FROM_END && this.JO != null) {
            this.JO.nV();
        }
    }

    private boolean nG() {
        switch (nS()[this.JB.ordinal()]) {
            case 2:
                return nH();
            case 3:
                return nI();
            case 4:
                return nI() || nH();
            default:
                return false;
        }
    }

    private boolean nH() {
        switch (nS()[this.JB.ordinal()]) {
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

    private boolean nI() {
        switch (nS()[this.JB.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.JE.getHeight() + this.JH.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.JE.getHeight() + this.JH.getHeight() && getHeadViewTopMargin() == this.JM;
        }
    }

    private void nJ() {
        if (getHeadViewTopMargin() >= this.JI) {
            a(State.RELEASE_TO_REFRESH, this.JK);
        } else {
            a(State.PULL_TO_REFRESH, this.JK);
        }
    }

    private void nK() {
        if (getHeadViewTopMargin() > this.JM && getHeadViewTopMargin() - getScrollY() < this.JI) {
            a(State.PULL_TO_REFRESH, this.JK);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.JM) {
            a(State.RESET, this.JK);
        }
    }

    private void nL() {
        if (getFootViewBottomMargin() >= this.JJ) {
            a(State.RELEASE_TO_REFRESH, this.JL);
        } else {
            a(State.PULL_TO_REFRESH, this.JL);
        }
    }

    private void nM() {
        a(State.PULL_TO_REFRESH, this.JL);
    }

    private void nN() {
        this.JR = true;
        this.JS = false;
    }

    private void nO() {
        this.JR = false;
        this.JS = true;
    }

    private void nP() {
        this.JR = false;
        this.JS = false;
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
        if (!this.JB.permitsPullToRefresh() || this.JQ) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.JF = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.JN != null) {
                    if (motionEvent.getY() - this.JF >= 20.0f) {
                        this.JN.U(true);
                    } else if (motionEvent.getY() - this.JF <= -30.0f) {
                        this.JN.U(false);
                    }
                }
                release();
                nP();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.Jz == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.JF = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (nG()) {
                    if (nH() && i < 0 && this.JB.showHeaderLoadingLayout() && !this.JS) {
                        nN();
                        if (this.JB == Mode.BOTH) {
                            this.JA = Mode.PULL_FROM_START;
                        }
                        aI(i / 2);
                        nJ();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (nH() && i > 0 && this.JB.showHeaderLoadingLayout() && !this.JS) {
                        nK();
                        aI(i / 2);
                    }
                    if (nI() && i > 0 && this.JB.showFooterLoadingLayout() && !this.JR) {
                        nO();
                        if (this.JB == Mode.BOTH) {
                            this.JA = Mode.PULL_FROM_END;
                        }
                        aJ(i / 2);
                        nL();
                        return super.onTouchEvent(motionEvent);
                    } else if (nI() && i < 0 && this.JB.showFooterLoadingLayout() && !this.JR) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        nM();
                        break;
                    }
                } else if (this.JA == Mode.PULL_FROM_START && i > 0) {
                    nK();
                    aI(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.JA == Mode.PULL_FROM_END && i < 0) {
                    nM();
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

    private void aI(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.JG.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.JM) {
            layoutParams.topMargin = this.JM;
        }
        this.JG.setLayoutParams(layoutParams);
    }

    private void aJ(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.JH.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.JH.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, com.baidu.adp.widget.ScrollView.a aVar) {
        if (this.Jz != state) {
            this.Jz = state;
            switch (nT()[state.ordinal()]) {
                case 1:
                    aVar.nC();
                    return;
                case 2:
                    aVar.nB();
                    return;
                case 3:
                    aVar.nj();
                    return;
                case 4:
                    aVar.nk();
                    return;
                case 5:
                    aVar.nk();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.JG.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.JH.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.JA.showHeaderLoadingLayout()) {
            nQ();
        } else if (this.JA.showFooterLoadingLayout()) {
            nR();
        }
    }

    private void nQ() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.Jz) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.Jz) {
                k(getHeadViewTopMargin(), this.JM);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.Jz) {
                scrollTo(0, 0);
                k(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.Jz) {
                aI(getHeadViewTopMargin() - this.JM);
                scrollTo(0, 0);
                a(State.RESET, this.JK);
            }
        } else if (getScrollY() < 0 && State.RESET != this.Jz) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.Jz) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.Jz) {
                k(getHeadViewTopMargin(), this.JM);
            }
        }
    }

    private void k(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.JC);
            eVar.t(this.JG);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.nz();
        }
    }

    private void nR() {
        if (State.RELEASE_TO_REFRESH == this.Jz) {
            l(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.Jz) {
            aJ(0 - getFootViewBottomMargin());
        }
    }

    private void l(int i, int i2) {
        com.baidu.adp.widget.ScrollView.b bVar = new com.baidu.adp.widget.ScrollView.b(i, i2, this.JD);
        bVar.t(this.JH);
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

        /* JADX DEBUG: Replace access to removed values field (JX) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (JW) with 'values()' method */
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
