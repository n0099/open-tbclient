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
    private static /* synthetic */ int[] IU;
    private static /* synthetic */ int[] IW;
    private Mode IA;
    private Mode IB;
    private int IC;
    private int IE;
    protected View IF;
    private float IG;
    private FrameLayout IH;
    private FrameLayout II;
    private float IJ;
    private float IK;
    private com.baidu.adp.widget.ScrollView.a IL;
    private com.baidu.adp.widget.ScrollView.a IM;
    private int IN;
    private c IO;
    private b IP;
    private a IQ;
    private boolean IR;
    private boolean IS;
    private boolean IT;
    private State Iz;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void nV();
    }

    /* loaded from: classes.dex */
    public interface b {
        void nW();
    }

    /* loaded from: classes.dex */
    public interface c {
        void X(boolean z);
    }

    static /* synthetic */ int[] nT() {
        int[] iArr = IU;
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
            IU = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] nU() {
        int[] iArr = IW;
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
            IW = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.nE() != null) {
            if (this.IL != null) {
                this.IH.removeView(this.IL.nE());
            }
            this.IL = aVar;
            this.IH.addView(this.IL.nE());
            this.IL.nD();
        }
    }

    public void setCustomFooterView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.nE() != null) {
            if (this.IM != null) {
                this.II.removeView(this.IM.nE());
            }
            this.IM = aVar;
            this.II.addView(this.IM.nE());
            this.IM.nD();
        }
    }

    public com.baidu.adp.widget.ScrollView.a getHeadLoadingView() {
        return this.IL;
    }

    public com.baidu.adp.widget.ScrollView.a getmFootLoadingView() {
        return this.IM;
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
        this.IP = bVar;
    }

    public void setOnPullDownListener(a aVar) {
        this.IQ = aVar;
    }

    public void setOnScrollUpDownListener(c cVar) {
        this.IO = cVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.IF = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.IB) {
            this.IB = mode;
            nF();
        }
    }

    protected void nF() {
        if (this.IB.showHeaderLoadingLayout()) {
            this.IH.setVisibility(0);
        } else {
            this.IH.setVisibility(8);
        }
        if (this.IB.showFooterLoadingLayout()) {
            this.II.setVisibility(0);
        } else {
            this.II.setVisibility(8);
        }
        this.IA = this.IB != Mode.BOTH ? this.IB : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.Iz != State.REFRESHING) {
            if (this.IB.showHeaderLoadingLayout() && i == 1) {
                this.IR = true;
                fullScroll(33);
                aB(this.IN);
                this.IA = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.IL);
                nG();
            } else if (this.IB.showFooterLoadingLayout() && i == 0) {
                this.IR = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.IA = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.IM);
                nG();
            }
        }
    }

    private void nG() {
        if (this.IA == Mode.PULL_FROM_START) {
            if (this.IQ != null) {
                this.IQ.nV();
            }
        } else if (this.IA == Mode.PULL_FROM_END && this.IP != null) {
            this.IP.nW();
        }
    }

    private boolean nH() {
        switch (nT()[this.IB.ordinal()]) {
            case 2:
                return nI();
            case 3:
                return nJ();
            case 4:
                return nJ() || nI();
            default:
                return false;
        }
    }

    private boolean nI() {
        switch (nT()[this.IB.ordinal()]) {
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

    private boolean nJ() {
        switch (nT()[this.IB.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.IF.getHeight() + this.II.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.IF.getHeight() + this.II.getHeight() && getHeadViewTopMargin() == this.IN;
        }
    }

    private void nK() {
        if (getHeadViewTopMargin() >= this.IJ) {
            a(State.RELEASE_TO_REFRESH, this.IL);
        } else {
            a(State.PULL_TO_REFRESH, this.IL);
        }
    }

    private void nL() {
        if (getHeadViewTopMargin() > this.IN && getHeadViewTopMargin() - getScrollY() < this.IJ) {
            a(State.PULL_TO_REFRESH, this.IL);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.IN) {
            a(State.RESET, this.IL);
        }
    }

    private void nM() {
        if (getFootViewBottomMargin() >= this.IK) {
            a(State.RELEASE_TO_REFRESH, this.IM);
        } else {
            a(State.PULL_TO_REFRESH, this.IM);
        }
    }

    private void nN() {
        a(State.PULL_TO_REFRESH, this.IM);
    }

    private void nO() {
        this.IS = true;
        this.IT = false;
    }

    private void nP() {
        this.IS = false;
        this.IT = true;
    }

    private void nQ() {
        this.IS = false;
        this.IT = false;
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
        if (!this.IB.permitsPullToRefresh() || this.IR) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.IG = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.IO != null) {
                    if (motionEvent.getY() - this.IG >= 20.0f) {
                        this.IO.X(true);
                    } else if (motionEvent.getY() - this.IG <= -30.0f) {
                        this.IO.X(false);
                    }
                }
                release();
                nQ();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.Iz == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.IG = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (nH()) {
                    if (nI() && i < 0 && this.IB.showHeaderLoadingLayout() && !this.IT) {
                        nO();
                        if (this.IB == Mode.BOTH) {
                            this.IA = Mode.PULL_FROM_START;
                        }
                        aB(i / 2);
                        nK();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (nI() && i > 0 && this.IB.showHeaderLoadingLayout() && !this.IT) {
                        nL();
                        aB(i / 2);
                    }
                    if (nJ() && i > 0 && this.IB.showFooterLoadingLayout() && !this.IS) {
                        nP();
                        if (this.IB == Mode.BOTH) {
                            this.IA = Mode.PULL_FROM_END;
                        }
                        aC(i / 2);
                        nM();
                        return super.onTouchEvent(motionEvent);
                    } else if (nJ() && i < 0 && this.IB.showFooterLoadingLayout() && !this.IS) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        nN();
                        break;
                    }
                } else if (this.IA == Mode.PULL_FROM_START && i > 0) {
                    nL();
                    aB(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.IA == Mode.PULL_FROM_END && i < 0) {
                    nN();
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

    private void aB(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.IH.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.IN) {
            layoutParams.topMargin = this.IN;
        }
        this.IH.setLayoutParams(layoutParams);
    }

    private void aC(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.II.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.II.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, com.baidu.adp.widget.ScrollView.a aVar) {
        if (this.Iz != state) {
            this.Iz = state;
            switch (nU()[state.ordinal()]) {
                case 1:
                    aVar.nD();
                    return;
                case 2:
                    aVar.nC();
                    return;
                case 3:
                    aVar.np();
                    return;
                case 4:
                    aVar.nq();
                    return;
                case 5:
                    aVar.nq();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.IH.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.II.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.IA.showHeaderLoadingLayout()) {
            nR();
        } else if (this.IA.showFooterLoadingLayout()) {
            nS();
        }
    }

    private void nR() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.Iz) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.Iz) {
                k(getHeadViewTopMargin(), this.IN);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.Iz) {
                scrollTo(0, 0);
                k(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.Iz) {
                aB(getHeadViewTopMargin() - this.IN);
                scrollTo(0, 0);
                a(State.RESET, this.IL);
            }
        } else if (getScrollY() < 0 && State.RESET != this.Iz) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.Iz) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.Iz) {
                k(getHeadViewTopMargin(), this.IN);
            }
        }
    }

    private void k(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.IC);
            eVar.h(this.IH);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.nA();
        }
    }

    private void nS() {
        if (State.RELEASE_TO_REFRESH == this.Iz) {
            l(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.Iz) {
            aC(0 - getFootViewBottomMargin());
        }
    }

    private void l(int i, int i2) {
        com.baidu.adp.widget.ScrollView.b bVar = new com.baidu.adp.widget.ScrollView.b(i, i2, this.IE);
        bVar.h(this.II);
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

        /* JADX DEBUG: Replace access to removed values field (IZ) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (IY) with 'values()' method */
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
