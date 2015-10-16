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
    private static /* synthetic */ int[] IW;
    private static /* synthetic */ int[] IX;
    private State IA;
    private Mode IB;
    private Mode IC;
    private int IE;
    private int IF;
    protected View IG;
    private float IH;
    private FrameLayout II;
    private FrameLayout IJ;
    private float IK;
    private float IL;
    private com.baidu.adp.widget.ScrollView.a IM;
    private com.baidu.adp.widget.ScrollView.a IN;
    private int IO;
    private c IP;
    private b IQ;
    private a IR;
    private boolean IS;
    private boolean IT;
    private boolean IU;
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
        int[] iArr = IW;
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
            IW = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] nU() {
        int[] iArr = IX;
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
            IX = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.nE() != null) {
            if (this.IM != null) {
                this.II.removeView(this.IM.nE());
            }
            this.IM = aVar;
            this.II.addView(this.IM.nE());
            this.IM.nD();
        }
    }

    public void setCustomFooterView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.nE() != null) {
            if (this.IN != null) {
                this.IJ.removeView(this.IN.nE());
            }
            this.IN = aVar;
            this.IJ.addView(this.IN.nE());
            this.IN.nD();
        }
    }

    public com.baidu.adp.widget.ScrollView.a getHeadLoadingView() {
        return this.IM;
    }

    public com.baidu.adp.widget.ScrollView.a getmFootLoadingView() {
        return this.IN;
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
        this.IQ = bVar;
    }

    public void setOnPullDownListener(a aVar) {
        this.IR = aVar;
    }

    public void setOnScrollUpDownListener(c cVar) {
        this.IP = cVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.IG = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.IC) {
            this.IC = mode;
            nF();
        }
    }

    protected void nF() {
        if (this.IC.showHeaderLoadingLayout()) {
            this.II.setVisibility(0);
        } else {
            this.II.setVisibility(8);
        }
        if (this.IC.showFooterLoadingLayout()) {
            this.IJ.setVisibility(0);
        } else {
            this.IJ.setVisibility(8);
        }
        this.IB = this.IC != Mode.BOTH ? this.IC : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.IA != State.REFRESHING) {
            if (this.IC.showHeaderLoadingLayout() && i == 1) {
                this.IS = true;
                fullScroll(33);
                aB(this.IO);
                this.IB = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.IM);
                nG();
            } else if (this.IC.showFooterLoadingLayout() && i == 0) {
                this.IS = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.IB = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.IN);
                nG();
            }
        }
    }

    private void nG() {
        if (this.IB == Mode.PULL_FROM_START) {
            if (this.IR != null) {
                this.IR.nV();
            }
        } else if (this.IB == Mode.PULL_FROM_END && this.IQ != null) {
            this.IQ.nW();
        }
    }

    private boolean nH() {
        switch (nT()[this.IC.ordinal()]) {
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
        switch (nT()[this.IC.ordinal()]) {
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
        switch (nT()[this.IC.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.IG.getHeight() + this.IJ.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.IG.getHeight() + this.IJ.getHeight() && getHeadViewTopMargin() == this.IO;
        }
    }

    private void nK() {
        if (getHeadViewTopMargin() >= this.IK) {
            a(State.RELEASE_TO_REFRESH, this.IM);
        } else {
            a(State.PULL_TO_REFRESH, this.IM);
        }
    }

    private void nL() {
        if (getHeadViewTopMargin() > this.IO && getHeadViewTopMargin() - getScrollY() < this.IK) {
            a(State.PULL_TO_REFRESH, this.IM);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.IO) {
            a(State.RESET, this.IM);
        }
    }

    private void nM() {
        if (getFootViewBottomMargin() >= this.IL) {
            a(State.RELEASE_TO_REFRESH, this.IN);
        } else {
            a(State.PULL_TO_REFRESH, this.IN);
        }
    }

    private void nN() {
        a(State.PULL_TO_REFRESH, this.IN);
    }

    private void nO() {
        this.IT = true;
        this.IU = false;
    }

    private void nP() {
        this.IT = false;
        this.IU = true;
    }

    private void nQ() {
        this.IT = false;
        this.IU = false;
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
        if (!this.IC.permitsPullToRefresh() || this.IS) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.IH = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.IP != null) {
                    if (motionEvent.getY() - this.IH >= 20.0f) {
                        this.IP.X(true);
                    } else if (motionEvent.getY() - this.IH <= -30.0f) {
                        this.IP.X(false);
                    }
                }
                release();
                nQ();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.IA == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.IH = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (nH()) {
                    if (nI() && i < 0 && this.IC.showHeaderLoadingLayout() && !this.IU) {
                        nO();
                        if (this.IC == Mode.BOTH) {
                            this.IB = Mode.PULL_FROM_START;
                        }
                        aB(i / 2);
                        nK();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (nI() && i > 0 && this.IC.showHeaderLoadingLayout() && !this.IU) {
                        nL();
                        aB(i / 2);
                    }
                    if (nJ() && i > 0 && this.IC.showFooterLoadingLayout() && !this.IT) {
                        nP();
                        if (this.IC == Mode.BOTH) {
                            this.IB = Mode.PULL_FROM_END;
                        }
                        aC(i / 2);
                        nM();
                        return super.onTouchEvent(motionEvent);
                    } else if (nJ() && i < 0 && this.IC.showFooterLoadingLayout() && !this.IT) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        nN();
                        break;
                    }
                } else if (this.IB == Mode.PULL_FROM_START && i > 0) {
                    nL();
                    aB(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.IB == Mode.PULL_FROM_END && i < 0) {
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.II.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.IO) {
            layoutParams.topMargin = this.IO;
        }
        this.II.setLayoutParams(layoutParams);
    }

    private void aC(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.IJ.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.IJ.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, com.baidu.adp.widget.ScrollView.a aVar) {
        if (this.IA != state) {
            this.IA = state;
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
        return ((LinearLayout.LayoutParams) this.II.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.IJ.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.IB.showHeaderLoadingLayout()) {
            nR();
        } else if (this.IB.showFooterLoadingLayout()) {
            nS();
        }
    }

    private void nR() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.IA) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.IA) {
                k(getHeadViewTopMargin(), this.IO);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.IA) {
                scrollTo(0, 0);
                k(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.IA) {
                aB(getHeadViewTopMargin() - this.IO);
                scrollTo(0, 0);
                a(State.RESET, this.IM);
            }
        } else if (getScrollY() < 0 && State.RESET != this.IA) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.IA) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.IA) {
                k(getHeadViewTopMargin(), this.IO);
            }
        }
    }

    private void k(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.IE);
            eVar.h(this.II);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.nA();
        }
    }

    private void nS() {
        if (State.RELEASE_TO_REFRESH == this.IA) {
            l(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.IA) {
            aC(0 - getFootViewBottomMargin());
        }
    }

    private void l(int i, int i2) {
        com.baidu.adp.widget.ScrollView.b bVar = new com.baidu.adp.widget.ScrollView.b(i, i2, this.IF);
        bVar.h(this.IJ);
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

        /* JADX DEBUG: Replace access to removed values field (Ja) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (IZ) with 'values()' method */
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
