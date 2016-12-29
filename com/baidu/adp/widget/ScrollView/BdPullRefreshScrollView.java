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
    private static /* synthetic */ int[] Df;
    private static /* synthetic */ int[] Dg;
    private State CL;
    private Mode CM;
    private Mode CN;
    private int CO;
    private int CP;
    protected View CQ;
    private float CR;
    private FrameLayout CS;
    private FrameLayout CT;
    private float CU;
    private float CV;
    private com.baidu.adp.widget.ScrollView.a CW;
    private com.baidu.adp.widget.ScrollView.a CX;
    private int CY;
    private c CZ;
    private b Da;
    private a Db;
    private boolean Dc;
    private boolean Dd;
    private boolean De;
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
        int[] iArr = Df;
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
            Df = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] kT() {
        int[] iArr = Dg;
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
            Dg = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.kG() != null) {
            if (this.CW != null) {
                this.CS.removeView(this.CW.kG());
            }
            this.CW = aVar;
            this.CS.addView(this.CW.kG());
            this.CW.kF();
        }
    }

    public void setCustomFooterView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.kG() != null) {
            if (this.CX != null) {
                this.CT.removeView(this.CX.kG());
            }
            this.CX = aVar;
            this.CT.addView(this.CX.kG());
            this.CX.kF();
        }
    }

    public com.baidu.adp.widget.ScrollView.a getHeadLoadingView() {
        return this.CW;
    }

    public com.baidu.adp.widget.ScrollView.a getmFootLoadingView() {
        return this.CX;
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
        this.Da = bVar;
    }

    public void setOnPullDownListener(a aVar) {
        this.Db = aVar;
    }

    public void setOnScrollUpDownListener(c cVar) {
        this.CZ = cVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.CQ = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.CN) {
            this.CN = mode;
            updateUIForMode();
        }
    }

    protected void updateUIForMode() {
        if (this.CN.showHeaderLoadingLayout()) {
            this.CS.setVisibility(0);
        } else {
            this.CS.setVisibility(8);
        }
        if (this.CN.showFooterLoadingLayout()) {
            this.CT.setVisibility(0);
        } else {
            this.CT.setVisibility(8);
        }
        this.CM = this.CN != Mode.BOTH ? this.CN : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.CL != State.REFRESHING) {
            if (this.CN.showHeaderLoadingLayout() && i == 1) {
                this.Dc = true;
                fullScroll(33);
                aM(this.CY);
                this.CM = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.CW);
                kH();
            } else if (this.CN.showFooterLoadingLayout() && i == 0) {
                this.Dc = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.CM = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.CX);
                kH();
            }
        }
    }

    private void kH() {
        if (this.CM == Mode.PULL_FROM_START) {
            if (this.Db != null) {
                this.Db.kU();
            }
        } else if (this.CM == Mode.PULL_FROM_END && this.Da != null) {
            this.Da.kV();
        }
    }

    private boolean kI() {
        switch (kS()[this.CN.ordinal()]) {
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
        switch (kS()[this.CN.ordinal()]) {
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
        switch (kS()[this.CN.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.CQ.getHeight() + this.CT.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.CQ.getHeight() + this.CT.getHeight() && getHeadViewTopMargin() == this.CY;
        }
    }

    private void kJ() {
        if (getHeadViewTopMargin() >= this.CU) {
            a(State.RELEASE_TO_REFRESH, this.CW);
        } else {
            a(State.PULL_TO_REFRESH, this.CW);
        }
    }

    private void kK() {
        if (getHeadViewTopMargin() > this.CY && getHeadViewTopMargin() - getScrollY() < this.CU) {
            a(State.PULL_TO_REFRESH, this.CW);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.CY) {
            a(State.RESET, this.CW);
        }
    }

    private void kL() {
        if (getFootViewBottomMargin() >= this.CV) {
            a(State.RELEASE_TO_REFRESH, this.CX);
        } else {
            a(State.PULL_TO_REFRESH, this.CX);
        }
    }

    private void kM() {
        a(State.PULL_TO_REFRESH, this.CX);
    }

    private void kN() {
        this.Dd = true;
        this.De = false;
    }

    private void kO() {
        this.Dd = false;
        this.De = true;
    }

    private void kP() {
        this.Dd = false;
        this.De = false;
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
        if (!this.CN.permitsPullToRefresh() || this.Dc) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.CR = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.CZ != null) {
                    if (motionEvent.getY() - this.CR >= 20.0f) {
                        this.CZ.X(true);
                    } else if (motionEvent.getY() - this.CR <= -30.0f) {
                        this.CZ.X(false);
                    }
                }
                release();
                kP();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.CL == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.CR = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (kI()) {
                    if (isReadyForPullStart() && i < 0 && this.CN.showHeaderLoadingLayout() && !this.De) {
                        kN();
                        if (this.CN == Mode.BOTH) {
                            this.CM = Mode.PULL_FROM_START;
                        }
                        aM(i / 2);
                        kJ();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (isReadyForPullStart() && i > 0 && this.CN.showHeaderLoadingLayout() && !this.De) {
                        kK();
                        aM(i / 2);
                    }
                    if (isReadyForPullEnd() && i > 0 && this.CN.showFooterLoadingLayout() && !this.Dd) {
                        kO();
                        if (this.CN == Mode.BOTH) {
                            this.CM = Mode.PULL_FROM_END;
                        }
                        aN(i / 2);
                        kL();
                        return super.onTouchEvent(motionEvent);
                    } else if (isReadyForPullEnd() && i < 0 && this.CN.showFooterLoadingLayout() && !this.Dd) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        kM();
                        break;
                    }
                } else if (this.CM == Mode.PULL_FROM_START && i > 0) {
                    kK();
                    aM(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.CM == Mode.PULL_FROM_END && i < 0) {
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

    private void aM(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.CS.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.CY) {
            layoutParams.topMargin = this.CY;
        }
        this.CS.setLayoutParams(layoutParams);
    }

    private void aN(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.CT.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.CT.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, com.baidu.adp.widget.ScrollView.a aVar) {
        if (this.CL != state) {
            this.CL = state;
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
        return ((LinearLayout.LayoutParams) this.CS.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.CT.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.CM.showHeaderLoadingLayout()) {
            kQ();
        } else if (this.CM.showFooterLoadingLayout()) {
            kR();
        }
    }

    private void kQ() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.CL) {
                m(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.CL) {
                m(getHeadViewTopMargin(), this.CY);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.CL) {
                scrollTo(0, 0);
                m(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.CL) {
                aM(getHeadViewTopMargin() - this.CY);
                scrollTo(0, 0);
                a(State.RESET, this.CW);
            }
        } else if (getScrollY() < 0 && State.RESET != this.CL) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.CL) {
                m(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.CL) {
                m(getHeadViewTopMargin(), this.CY);
            }
        }
    }

    private void m(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.CO);
            eVar.t(this.CS);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.kB();
        }
    }

    private void kR() {
        if (State.RELEASE_TO_REFRESH == this.CL) {
            n(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.CL) {
            aN(0 - getFootViewBottomMargin());
        }
    }

    private void n(int i, int i2) {
        com.baidu.adp.widget.ScrollView.b bVar = new com.baidu.adp.widget.ScrollView.b(i, i2, this.CP);
        bVar.t(this.CT);
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

        /* JADX DEBUG: Replace access to removed values field (Dj) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Di) with 'values()' method */
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
