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
    private static /* synthetic */ int[] IX;
    private static /* synthetic */ int[] IY;
    private State IB;
    private Mode IC;
    private Mode IE;
    private int IF;
    private int IG;
    protected View IH;
    private float II;
    private FrameLayout IJ;
    private FrameLayout IK;
    private float IL;
    private float IM;
    private com.baidu.adp.widget.ScrollView.a IN;
    private com.baidu.adp.widget.ScrollView.a IO;
    private int IP;
    private c IQ;
    private b IR;
    private a IS;
    private boolean IT;
    private boolean IU;
    private boolean IW;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void nW();
    }

    /* loaded from: classes.dex */
    public interface b {
        void nX();
    }

    /* loaded from: classes.dex */
    public interface c {
        void X(boolean z);
    }

    static /* synthetic */ int[] nU() {
        int[] iArr = IX;
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
            IX = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] nV() {
        int[] iArr = IY;
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
            IY = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.nF() != null) {
            if (this.IN != null) {
                this.IJ.removeView(this.IN.nF());
            }
            this.IN = aVar;
            this.IJ.addView(this.IN.nF());
            this.IN.nE();
        }
    }

    public void setCustomFooterView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.nF() != null) {
            if (this.IO != null) {
                this.IK.removeView(this.IO.nF());
            }
            this.IO = aVar;
            this.IK.addView(this.IO.nF());
            this.IO.nE();
        }
    }

    public com.baidu.adp.widget.ScrollView.a getHeadLoadingView() {
        return this.IN;
    }

    public com.baidu.adp.widget.ScrollView.a getmFootLoadingView() {
        return this.IO;
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
        this.IR = bVar;
    }

    public void setOnPullDownListener(a aVar) {
        this.IS = aVar;
    }

    public void setOnScrollUpDownListener(c cVar) {
        this.IQ = cVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.IH = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.IE) {
            this.IE = mode;
            nG();
        }
    }

    protected void nG() {
        if (this.IE.showHeaderLoadingLayout()) {
            this.IJ.setVisibility(0);
        } else {
            this.IJ.setVisibility(8);
        }
        if (this.IE.showFooterLoadingLayout()) {
            this.IK.setVisibility(0);
        } else {
            this.IK.setVisibility(8);
        }
        this.IC = this.IE != Mode.BOTH ? this.IE : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.IB != State.REFRESHING) {
            if (this.IE.showHeaderLoadingLayout() && i == 1) {
                this.IT = true;
                fullScroll(33);
                aB(this.IP);
                this.IC = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.IN);
                nH();
            } else if (this.IE.showFooterLoadingLayout() && i == 0) {
                this.IT = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.IC = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.IO);
                nH();
            }
        }
    }

    private void nH() {
        if (this.IC == Mode.PULL_FROM_START) {
            if (this.IS != null) {
                this.IS.nW();
            }
        } else if (this.IC == Mode.PULL_FROM_END && this.IR != null) {
            this.IR.nX();
        }
    }

    private boolean nI() {
        switch (nU()[this.IE.ordinal()]) {
            case 2:
                return nJ();
            case 3:
                return nK();
            case 4:
                return nK() || nJ();
            default:
                return false;
        }
    }

    private boolean nJ() {
        switch (nU()[this.IE.ordinal()]) {
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

    private boolean nK() {
        switch (nU()[this.IE.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.IH.getHeight() + this.IK.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.IH.getHeight() + this.IK.getHeight() && getHeadViewTopMargin() == this.IP;
        }
    }

    private void nL() {
        if (getHeadViewTopMargin() >= this.IL) {
            a(State.RELEASE_TO_REFRESH, this.IN);
        } else {
            a(State.PULL_TO_REFRESH, this.IN);
        }
    }

    private void nM() {
        if (getHeadViewTopMargin() > this.IP && getHeadViewTopMargin() - getScrollY() < this.IL) {
            a(State.PULL_TO_REFRESH, this.IN);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.IP) {
            a(State.RESET, this.IN);
        }
    }

    private void nN() {
        if (getFootViewBottomMargin() >= this.IM) {
            a(State.RELEASE_TO_REFRESH, this.IO);
        } else {
            a(State.PULL_TO_REFRESH, this.IO);
        }
    }

    private void nO() {
        a(State.PULL_TO_REFRESH, this.IO);
    }

    private void nP() {
        this.IU = true;
        this.IW = false;
    }

    private void nQ() {
        this.IU = false;
        this.IW = true;
    }

    private void nR() {
        this.IU = false;
        this.IW = false;
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
        if (!this.IE.permitsPullToRefresh() || this.IT) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.II = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.IQ != null) {
                    if (motionEvent.getY() - this.II >= 20.0f) {
                        this.IQ.X(true);
                    } else if (motionEvent.getY() - this.II <= -30.0f) {
                        this.IQ.X(false);
                    }
                }
                release();
                nR();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.IB == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.II = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (nI()) {
                    if (nJ() && i < 0 && this.IE.showHeaderLoadingLayout() && !this.IW) {
                        nP();
                        if (this.IE == Mode.BOTH) {
                            this.IC = Mode.PULL_FROM_START;
                        }
                        aB(i / 2);
                        nL();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (nJ() && i > 0 && this.IE.showHeaderLoadingLayout() && !this.IW) {
                        nM();
                        aB(i / 2);
                    }
                    if (nK() && i > 0 && this.IE.showFooterLoadingLayout() && !this.IU) {
                        nQ();
                        if (this.IE == Mode.BOTH) {
                            this.IC = Mode.PULL_FROM_END;
                        }
                        aC(i / 2);
                        nN();
                        return super.onTouchEvent(motionEvent);
                    } else if (nK() && i < 0 && this.IE.showFooterLoadingLayout() && !this.IU) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        nO();
                        break;
                    }
                } else if (this.IC == Mode.PULL_FROM_START && i > 0) {
                    nM();
                    aB(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.IC == Mode.PULL_FROM_END && i < 0) {
                    nO();
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.IJ.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.IP) {
            layoutParams.topMargin = this.IP;
        }
        this.IJ.setLayoutParams(layoutParams);
    }

    private void aC(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.IK.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.IK.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, com.baidu.adp.widget.ScrollView.a aVar) {
        if (this.IB != state) {
            this.IB = state;
            switch (nV()[state.ordinal()]) {
                case 1:
                    aVar.nE();
                    return;
                case 2:
                    aVar.nD();
                    return;
                case 3:
                    aVar.nq();
                    return;
                case 4:
                    aVar.nr();
                    return;
                case 5:
                    aVar.nr();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.IJ.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.IK.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.IC.showHeaderLoadingLayout()) {
            nS();
        } else if (this.IC.showFooterLoadingLayout()) {
            nT();
        }
    }

    private void nS() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.IB) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.IB) {
                k(getHeadViewTopMargin(), this.IP);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.IB) {
                scrollTo(0, 0);
                k(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.IB) {
                aB(getHeadViewTopMargin() - this.IP);
                scrollTo(0, 0);
                a(State.RESET, this.IN);
            }
        } else if (getScrollY() < 0 && State.RESET != this.IB) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.IB) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.IB) {
                k(getHeadViewTopMargin(), this.IP);
            }
        }
    }

    private void k(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.IF);
            eVar.h(this.IJ);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.nB();
        }
    }

    private void nT() {
        if (State.RELEASE_TO_REFRESH == this.IB) {
            l(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.IB) {
            aC(0 - getFootViewBottomMargin());
        }
    }

    private void l(int i, int i2) {
        com.baidu.adp.widget.ScrollView.b bVar = new com.baidu.adp.widget.ScrollView.b(i, i2, this.IG);
        bVar.h(this.IK);
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

        /* JADX DEBUG: Replace access to removed values field (Jb) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Ja) with 'values()' method */
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
