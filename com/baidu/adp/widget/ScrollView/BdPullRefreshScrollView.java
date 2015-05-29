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
    private static /* synthetic */ int[] IR;
    private static /* synthetic */ int[] IS;
    private int IA;
    protected View IB;
    private float IC;
    private FrameLayout IE;
    private FrameLayout IF;
    private float IG;
    private float IH;
    private a II;
    private a IJ;
    private int IK;
    private l IL;
    private k IM;
    private j IN;
    private boolean IO;
    private boolean IP;
    private boolean IQ;
    private State Iw;
    private Mode Ix;
    private Mode Iy;
    private int Iz;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;

    static /* synthetic */ int[] nM() {
        int[] iArr = IR;
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
            IR = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] nN() {
        int[] iArr = IS;
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
            IS = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(a aVar) {
        if (aVar != null && aVar.nx() != null) {
            if (this.II != null) {
                this.IE.removeView(this.II.nx());
            }
            this.II = aVar;
            this.IE.addView(this.II.nx());
            this.II.nw();
        }
    }

    public void setCustomFooterView(a aVar) {
        if (aVar != null && aVar.nx() != null) {
            if (this.IJ != null) {
                this.IF.removeView(this.IJ.nx());
            }
            this.IJ = aVar;
            this.IF.addView(this.IJ.nx());
            this.IJ.nw();
        }
    }

    public a getHeadLoadingView() {
        return this.II;
    }

    public a getmFootLoadingView() {
        return this.IJ;
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

    public void setOnPullUpListener(k kVar) {
        this.IM = kVar;
    }

    public void setOnPullDownListener(j jVar) {
        this.IN = jVar;
    }

    public void setOnScrollUpDownListener(l lVar) {
        this.IL = lVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.IB = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.Iy) {
            this.Iy = mode;
            ny();
        }
    }

    protected void ny() {
        if (this.Iy.showHeaderLoadingLayout()) {
            this.IE.setVisibility(0);
        } else {
            this.IE.setVisibility(8);
        }
        if (this.Iy.showFooterLoadingLayout()) {
            this.IF.setVisibility(0);
        } else {
            this.IF.setVisibility(8);
        }
        this.Ix = this.Iy != Mode.BOTH ? this.Iy : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.Iw != State.REFRESHING) {
            if (this.Iy.showHeaderLoadingLayout() && i == 1) {
                this.IO = true;
                fullScroll(33);
                az(this.IK);
                this.Ix = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.II);
                nz();
            } else if (this.Iy.showFooterLoadingLayout() && i == 0) {
                this.IO = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.Ix = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.IJ);
                nz();
            }
        }
    }

    private void nz() {
        if (this.Ix == Mode.PULL_FROM_START) {
            if (this.IN != null) {
                this.IN.nO();
            }
        } else if (this.Ix == Mode.PULL_FROM_END && this.IM != null) {
            this.IM.nP();
        }
    }

    private boolean nA() {
        switch (nM()[this.Iy.ordinal()]) {
            case 2:
                return nB();
            case 3:
                return nC();
            case 4:
                return nC() || nB();
            default:
                return false;
        }
    }

    private boolean nB() {
        switch (nM()[this.Iy.ordinal()]) {
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

    private boolean nC() {
        switch (nM()[this.Iy.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.IB.getHeight() + this.IF.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.IB.getHeight() + this.IF.getHeight() && getHeadViewTopMargin() == this.IK;
        }
    }

    private void nD() {
        if (getHeadViewTopMargin() >= this.IG) {
            a(State.RELEASE_TO_REFRESH, this.II);
        } else {
            a(State.PULL_TO_REFRESH, this.II);
        }
    }

    private void nE() {
        if (getHeadViewTopMargin() > this.IK && getHeadViewTopMargin() - getScrollY() < this.IG) {
            a(State.PULL_TO_REFRESH, this.II);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.IK) {
            a(State.RESET, this.II);
        }
    }

    private void nF() {
        if (getFootViewBottomMargin() >= this.IH) {
            a(State.RELEASE_TO_REFRESH, this.IJ);
        } else {
            a(State.PULL_TO_REFRESH, this.IJ);
        }
    }

    private void nG() {
        a(State.PULL_TO_REFRESH, this.IJ);
    }

    private void nH() {
        this.IP = true;
        this.IQ = false;
    }

    private void nI() {
        this.IP = false;
        this.IQ = true;
    }

    private void nJ() {
        this.IP = false;
        this.IQ = false;
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
        if (!this.Iy.permitsPullToRefresh() || this.IO) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.IC = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.IL != null) {
                    if (motionEvent.getY() - this.IC >= 20.0f) {
                        this.IL.V(true);
                    } else if (motionEvent.getY() - this.IC <= -30.0f) {
                        this.IL.V(false);
                    }
                }
                release();
                nJ();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.Iw == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.IC = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (nA()) {
                    if (nB() && i < 0 && this.Iy.showHeaderLoadingLayout() && !this.IQ) {
                        nH();
                        if (this.Iy == Mode.BOTH) {
                            this.Ix = Mode.PULL_FROM_START;
                        }
                        az(i / 2);
                        nD();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (nB() && i > 0 && this.Iy.showHeaderLoadingLayout() && !this.IQ) {
                        nE();
                        az(i / 2);
                    }
                    if (nC() && i > 0 && this.Iy.showFooterLoadingLayout() && !this.IP) {
                        nI();
                        if (this.Iy == Mode.BOTH) {
                            this.Ix = Mode.PULL_FROM_END;
                        }
                        aA(i / 2);
                        nF();
                        return super.onTouchEvent(motionEvent);
                    } else if (nC() && i < 0 && this.Iy.showFooterLoadingLayout() && !this.IP) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        nG();
                        break;
                    }
                } else if (this.Ix == Mode.PULL_FROM_START && i > 0) {
                    nE();
                    az(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.Ix == Mode.PULL_FROM_END && i < 0) {
                    nG();
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

    private void az(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.IE.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.IK) {
            layoutParams.topMargin = this.IK;
        }
        this.IE.setLayoutParams(layoutParams);
    }

    private void aA(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.IF.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.IF.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, a aVar) {
        if (this.Iw != state) {
            this.Iw = state;
            switch (nN()[state.ordinal()]) {
                case 1:
                    aVar.nw();
                    return;
                case 2:
                    aVar.nv();
                    return;
                case 3:
                    aVar.nh();
                    return;
                case 4:
                    aVar.ni();
                    return;
                case 5:
                    aVar.ni();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.IE.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.IF.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.Ix.showHeaderLoadingLayout()) {
            nK();
        } else if (this.Ix.showFooterLoadingLayout()) {
            nL();
        }
    }

    private void nK() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.Iw) {
                i(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.Iw) {
                i(getHeadViewTopMargin(), this.IK);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.Iw) {
                scrollTo(0, 0);
                i(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.Iw) {
                az(getHeadViewTopMargin() - this.IK);
                scrollTo(0, 0);
                a(State.RESET, this.II);
            }
        } else if (getScrollY() < 0 && State.RESET != this.Iw) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.Iw) {
                i(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.Iw) {
                i(getHeadViewTopMargin(), this.IK);
            }
        }
    }

    private void i(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.Iz);
            eVar.g(this.IE);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.ns();
        }
    }

    private void nL() {
        if (State.RELEASE_TO_REFRESH == this.Iw) {
            j(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.Iw) {
            aA(0 - getFootViewBottomMargin());
        }
    }

    private void j(int i, int i2) {
        b bVar = new b(i, i2, this.IA);
        bVar.g(this.IF);
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

        /* JADX DEBUG: Replace access to removed values field (IW) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (IU) with 'values()' method */
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
