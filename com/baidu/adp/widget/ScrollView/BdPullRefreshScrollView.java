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
    private static /* synthetic */ int[] De;
    private static /* synthetic */ int[] Df;
    private State CK;
    private Mode CL;
    private Mode CM;
    private int CN;
    private int CO;
    protected View CP;
    private float CQ;
    private FrameLayout CR;
    private FrameLayout CS;
    private float CT;
    private float CU;
    private com.baidu.adp.widget.ScrollView.a CV;
    private com.baidu.adp.widget.ScrollView.a CW;
    private int CX;
    private c CY;
    private b CZ;
    private a Da;
    private boolean Db;
    private boolean Dc;
    private boolean Dd;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void kU();
    }

    /* loaded from: classes.dex */
    public interface b {
        void kV();
    }

    /* loaded from: classes.dex */
    public interface c {
        void X(boolean z);
    }

    static /* synthetic */ int[] kS() {
        int[] iArr = De;
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
            De = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] kT() {
        int[] iArr = Df;
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
            Df = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.kG() != null) {
            if (this.CV != null) {
                this.CR.removeView(this.CV.kG());
            }
            this.CV = aVar;
            this.CR.addView(this.CV.kG());
            this.CV.kF();
        }
    }

    public void setCustomFooterView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.kG() != null) {
            if (this.CW != null) {
                this.CS.removeView(this.CW.kG());
            }
            this.CW = aVar;
            this.CS.addView(this.CW.kG());
            this.CW.kF();
        }
    }

    public com.baidu.adp.widget.ScrollView.a getHeadLoadingView() {
        return this.CV;
    }

    public com.baidu.adp.widget.ScrollView.a getmFootLoadingView() {
        return this.CW;
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
        this.CZ = bVar;
    }

    public void setOnPullDownListener(a aVar) {
        this.Da = aVar;
    }

    public void setOnScrollUpDownListener(c cVar) {
        this.CY = cVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.CP = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.CM) {
            this.CM = mode;
            updateUIForMode();
        }
    }

    protected void updateUIForMode() {
        if (this.CM.showHeaderLoadingLayout()) {
            this.CR.setVisibility(0);
        } else {
            this.CR.setVisibility(8);
        }
        if (this.CM.showFooterLoadingLayout()) {
            this.CS.setVisibility(0);
        } else {
            this.CS.setVisibility(8);
        }
        this.CL = this.CM != Mode.BOTH ? this.CM : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.CK != State.REFRESHING) {
            if (this.CM.showHeaderLoadingLayout() && i == 1) {
                this.Db = true;
                fullScroll(33);
                aL(this.CX);
                this.CL = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.CV);
                kH();
            } else if (this.CM.showFooterLoadingLayout() && i == 0) {
                this.Db = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.CL = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.CW);
                kH();
            }
        }
    }

    private void kH() {
        if (this.CL == Mode.PULL_FROM_START) {
            if (this.Da != null) {
                this.Da.kU();
            }
        } else if (this.CL == Mode.PULL_FROM_END && this.CZ != null) {
            this.CZ.kV();
        }
    }

    private boolean kI() {
        switch (kS()[this.CM.ordinal()]) {
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
        switch (kS()[this.CM.ordinal()]) {
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
        switch (kS()[this.CM.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.CP.getHeight() + this.CS.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.CP.getHeight() + this.CS.getHeight() && getHeadViewTopMargin() == this.CX;
        }
    }

    private void kJ() {
        if (getHeadViewTopMargin() >= this.CT) {
            a(State.RELEASE_TO_REFRESH, this.CV);
        } else {
            a(State.PULL_TO_REFRESH, this.CV);
        }
    }

    private void kK() {
        if (getHeadViewTopMargin() > this.CX && getHeadViewTopMargin() - getScrollY() < this.CT) {
            a(State.PULL_TO_REFRESH, this.CV);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.CX) {
            a(State.RESET, this.CV);
        }
    }

    private void kL() {
        if (getFootViewBottomMargin() >= this.CU) {
            a(State.RELEASE_TO_REFRESH, this.CW);
        } else {
            a(State.PULL_TO_REFRESH, this.CW);
        }
    }

    private void kM() {
        a(State.PULL_TO_REFRESH, this.CW);
    }

    private void kN() {
        this.Dc = true;
        this.Dd = false;
    }

    private void kO() {
        this.Dc = false;
        this.Dd = true;
    }

    private void kP() {
        this.Dc = false;
        this.Dd = false;
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
        if (!this.CM.permitsPullToRefresh() || this.Db) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.CQ = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.CY != null) {
                    if (motionEvent.getY() - this.CQ >= 20.0f) {
                        this.CY.X(true);
                    } else if (motionEvent.getY() - this.CQ <= -30.0f) {
                        this.CY.X(false);
                    }
                }
                release();
                kP();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.CK == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.CQ = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (kI()) {
                    if (isReadyForPullStart() && i < 0 && this.CM.showHeaderLoadingLayout() && !this.Dd) {
                        kN();
                        if (this.CM == Mode.BOTH) {
                            this.CL = Mode.PULL_FROM_START;
                        }
                        aL(i / 2);
                        kJ();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (isReadyForPullStart() && i > 0 && this.CM.showHeaderLoadingLayout() && !this.Dd) {
                        kK();
                        aL(i / 2);
                    }
                    if (isReadyForPullEnd() && i > 0 && this.CM.showFooterLoadingLayout() && !this.Dc) {
                        kO();
                        if (this.CM == Mode.BOTH) {
                            this.CL = Mode.PULL_FROM_END;
                        }
                        aM(i / 2);
                        kL();
                        return super.onTouchEvent(motionEvent);
                    } else if (isReadyForPullEnd() && i < 0 && this.CM.showFooterLoadingLayout() && !this.Dc) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        kM();
                        break;
                    }
                } else if (this.CL == Mode.PULL_FROM_START && i > 0) {
                    kK();
                    aL(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.CL == Mode.PULL_FROM_END && i < 0) {
                    kM();
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.CR.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.CX) {
            layoutParams.topMargin = this.CX;
        }
        this.CR.setLayoutParams(layoutParams);
    }

    private void aM(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.CS.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.CS.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, com.baidu.adp.widget.ScrollView.a aVar) {
        if (this.CK != state) {
            this.CK = state;
            switch (kT()[state.ordinal()]) {
                case 1:
                    aVar.kF();
                    return;
                case 2:
                    aVar.kE();
                    return;
                case 3:
                    aVar.kl();
                    return;
                case 4:
                    aVar.km();
                    return;
                case 5:
                    aVar.km();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.CR.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.CS.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.CL.showHeaderLoadingLayout()) {
            kQ();
        } else if (this.CL.showFooterLoadingLayout()) {
            kR();
        }
    }

    private void kQ() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.CK) {
                m(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.CK) {
                m(getHeadViewTopMargin(), this.CX);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.CK) {
                scrollTo(0, 0);
                m(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.CK) {
                aL(getHeadViewTopMargin() - this.CX);
                scrollTo(0, 0);
                a(State.RESET, this.CV);
            }
        } else if (getScrollY() < 0 && State.RESET != this.CK) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.CK) {
                m(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.CK) {
                m(getHeadViewTopMargin(), this.CX);
            }
        }
    }

    private void m(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.CN);
            eVar.t(this.CR);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.kB();
        }
    }

    private void kR() {
        if (State.RELEASE_TO_REFRESH == this.CK) {
            n(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.CK) {
            aM(0 - getFootViewBottomMargin());
        }
    }

    private void n(int i, int i2) {
        com.baidu.adp.widget.ScrollView.b bVar = new com.baidu.adp.widget.ScrollView.b(i, i2, this.CO);
        bVar.t(this.CS);
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

        /* JADX DEBUG: Replace access to removed values field (Di) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Dh) with 'values()' method */
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
