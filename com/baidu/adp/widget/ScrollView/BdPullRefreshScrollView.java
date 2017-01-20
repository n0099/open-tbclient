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
    private static /* synthetic */ int[] Cq;
    private static /* synthetic */ int[] Cr;
    private State BW;
    private Mode BX;
    private Mode BY;
    private int BZ;
    private int Ca;
    protected View Cb;
    private float Cc;
    private FrameLayout Cd;
    private FrameLayout Ce;
    private float Cf;
    private float Cg;
    private com.baidu.adp.widget.ScrollView.a Ch;
    private com.baidu.adp.widget.ScrollView.a Ci;
    private int Cj;
    private c Ck;
    private b Cl;
    private a Cm;
    private boolean Cn;
    private boolean Co;
    private boolean Cp;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void kM();
    }

    /* loaded from: classes.dex */
    public interface b {
        void kN();
    }

    /* loaded from: classes.dex */
    public interface c {
        void X(boolean z);
    }

    static /* synthetic */ int[] kK() {
        int[] iArr = Cq;
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
            Cq = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] kL() {
        int[] iArr = Cr;
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
            Cr = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.ky() != null) {
            if (this.Ch != null) {
                this.Cd.removeView(this.Ch.ky());
            }
            this.Ch = aVar;
            this.Cd.addView(this.Ch.ky());
            this.Ch.kx();
        }
    }

    public void setCustomFooterView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.ky() != null) {
            if (this.Ci != null) {
                this.Ce.removeView(this.Ci.ky());
            }
            this.Ci = aVar;
            this.Ce.addView(this.Ci.ky());
            this.Ci.kx();
        }
    }

    public com.baidu.adp.widget.ScrollView.a getHeadLoadingView() {
        return this.Ch;
    }

    public com.baidu.adp.widget.ScrollView.a getmFootLoadingView() {
        return this.Ci;
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
        this.Cl = bVar;
    }

    public void setOnPullDownListener(a aVar) {
        this.Cm = aVar;
    }

    public void setOnScrollUpDownListener(c cVar) {
        this.Ck = cVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.Cb = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.BY) {
            this.BY = mode;
            updateUIForMode();
        }
    }

    protected void updateUIForMode() {
        if (this.BY.showHeaderLoadingLayout()) {
            this.Cd.setVisibility(0);
        } else {
            this.Cd.setVisibility(8);
        }
        if (this.BY.showFooterLoadingLayout()) {
            this.Ce.setVisibility(0);
        } else {
            this.Ce.setVisibility(8);
        }
        this.BX = this.BY != Mode.BOTH ? this.BY : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.BW != State.REFRESHING) {
            if (this.BY.showHeaderLoadingLayout() && i == 1) {
                this.Cn = true;
                fullScroll(33);
                aL(this.Cj);
                this.BX = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.Ch);
                kz();
            } else if (this.BY.showFooterLoadingLayout() && i == 0) {
                this.Cn = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.BX = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.Ci);
                kz();
            }
        }
    }

    private void kz() {
        if (this.BX == Mode.PULL_FROM_START) {
            if (this.Cm != null) {
                this.Cm.kM();
            }
        } else if (this.BX == Mode.PULL_FROM_END && this.Cl != null) {
            this.Cl.kN();
        }
    }

    private boolean kA() {
        switch (kK()[this.BY.ordinal()]) {
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
        switch (kK()[this.BY.ordinal()]) {
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
        switch (kK()[this.BY.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.Cb.getHeight() + this.Ce.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.Cb.getHeight() + this.Ce.getHeight() && getHeadViewTopMargin() == this.Cj;
        }
    }

    private void kB() {
        if (getHeadViewTopMargin() >= this.Cf) {
            a(State.RELEASE_TO_REFRESH, this.Ch);
        } else {
            a(State.PULL_TO_REFRESH, this.Ch);
        }
    }

    private void kC() {
        if (getHeadViewTopMargin() > this.Cj && getHeadViewTopMargin() - getScrollY() < this.Cf) {
            a(State.PULL_TO_REFRESH, this.Ch);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.Cj) {
            a(State.RESET, this.Ch);
        }
    }

    private void kD() {
        if (getFootViewBottomMargin() >= this.Cg) {
            a(State.RELEASE_TO_REFRESH, this.Ci);
        } else {
            a(State.PULL_TO_REFRESH, this.Ci);
        }
    }

    private void kE() {
        a(State.PULL_TO_REFRESH, this.Ci);
    }

    private void kF() {
        this.Co = true;
        this.Cp = false;
    }

    private void kG() {
        this.Co = false;
        this.Cp = true;
    }

    private void kH() {
        this.Co = false;
        this.Cp = false;
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
        if (!this.BY.permitsPullToRefresh() || this.Cn) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.Cc = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.Ck != null) {
                    if (motionEvent.getY() - this.Cc >= 20.0f) {
                        this.Ck.X(true);
                    } else if (motionEvent.getY() - this.Cc <= -30.0f) {
                        this.Ck.X(false);
                    }
                }
                release();
                kH();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.BW == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.Cc = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (kA()) {
                    if (isReadyForPullStart() && i < 0 && this.BY.showHeaderLoadingLayout() && !this.Cp) {
                        kF();
                        if (this.BY == Mode.BOTH) {
                            this.BX = Mode.PULL_FROM_START;
                        }
                        aL(i / 2);
                        kB();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (isReadyForPullStart() && i > 0 && this.BY.showHeaderLoadingLayout() && !this.Cp) {
                        kC();
                        aL(i / 2);
                    }
                    if (isReadyForPullEnd() && i > 0 && this.BY.showFooterLoadingLayout() && !this.Co) {
                        kG();
                        if (this.BY == Mode.BOTH) {
                            this.BX = Mode.PULL_FROM_END;
                        }
                        aM(i / 2);
                        kD();
                        return super.onTouchEvent(motionEvent);
                    } else if (isReadyForPullEnd() && i < 0 && this.BY.showFooterLoadingLayout() && !this.Co) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        kE();
                        break;
                    }
                } else if (this.BX == Mode.PULL_FROM_START && i > 0) {
                    kC();
                    aL(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.BX == Mode.PULL_FROM_END && i < 0) {
                    kE();
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Cd.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.Cj) {
            layoutParams.topMargin = this.Cj;
        }
        this.Cd.setLayoutParams(layoutParams);
    }

    private void aM(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ce.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.Ce.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, com.baidu.adp.widget.ScrollView.a aVar) {
        if (this.BW != state) {
            this.BW = state;
            switch (kL()[state.ordinal()]) {
                case 1:
                    aVar.kx();
                    return;
                case 2:
                    aVar.kw();
                    return;
                case 3:
                    aVar.kh();
                    return;
                case 4:
                    aVar.ki();
                    return;
                case 5:
                    aVar.ki();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.Cd.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.Ce.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.BX.showHeaderLoadingLayout()) {
            kI();
        } else if (this.BX.showFooterLoadingLayout()) {
            kJ();
        }
    }

    private void kI() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.BW) {
                n(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.BW) {
                n(getHeadViewTopMargin(), this.Cj);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.BW) {
                scrollTo(0, 0);
                n(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.BW) {
                aL(getHeadViewTopMargin() - this.Cj);
                scrollTo(0, 0);
                a(State.RESET, this.Ch);
            }
        } else if (getScrollY() < 0 && State.RESET != this.BW) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.BW) {
                n(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.BW) {
                n(getHeadViewTopMargin(), this.Cj);
            }
        }
    }

    private void n(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.BZ);
            eVar.r(this.Cd);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.kt();
        }
    }

    private void kJ() {
        if (State.RELEASE_TO_REFRESH == this.BW) {
            o(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.BW) {
            aM(0 - getFootViewBottomMargin());
        }
    }

    private void o(int i, int i2) {
        com.baidu.adp.widget.ScrollView.b bVar = new com.baidu.adp.widget.ScrollView.b(i, i2, this.Ca);
        bVar.r(this.Ce);
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

        /* JADX DEBUG: Replace access to removed values field (Cu) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Ct) with 'values()' method */
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
