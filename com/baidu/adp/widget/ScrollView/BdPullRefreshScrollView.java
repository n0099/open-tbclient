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
    private static /* synthetic */ int[] Jo;
    private static /* synthetic */ int[] Jp;
    private State IT;
    private Mode IU;
    private Mode IW;
    private int IX;
    private int IY;
    protected View IZ;
    private float Ja;
    private FrameLayout Jb;
    private FrameLayout Jc;
    private float Jd;
    private float Je;
    private com.baidu.adp.widget.ScrollView.a Jf;
    private com.baidu.adp.widget.ScrollView.a Jg;
    private int Jh;
    private c Ji;
    private b Jj;
    private a Jk;
    private boolean Jl;
    private boolean Jm;
    private boolean Jn;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void oc();
    }

    /* loaded from: classes.dex */
    public interface b {
        void od();
    }

    /* loaded from: classes.dex */
    public interface c {
        void X(boolean z);
    }

    static /* synthetic */ int[] oa() {
        int[] iArr = Jo;
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
            Jo = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] ob() {
        int[] iArr = Jp;
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
            Jp = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.nL() != null) {
            if (this.Jf != null) {
                this.Jb.removeView(this.Jf.nL());
            }
            this.Jf = aVar;
            this.Jb.addView(this.Jf.nL());
            this.Jf.nK();
        }
    }

    public void setCustomFooterView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.nL() != null) {
            if (this.Jg != null) {
                this.Jc.removeView(this.Jg.nL());
            }
            this.Jg = aVar;
            this.Jc.addView(this.Jg.nL());
            this.Jg.nK();
        }
    }

    public com.baidu.adp.widget.ScrollView.a getHeadLoadingView() {
        return this.Jf;
    }

    public com.baidu.adp.widget.ScrollView.a getmFootLoadingView() {
        return this.Jg;
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
        this.Jj = bVar;
    }

    public void setOnPullDownListener(a aVar) {
        this.Jk = aVar;
    }

    public void setOnScrollUpDownListener(c cVar) {
        this.Ji = cVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.IZ = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.IW) {
            this.IW = mode;
            nM();
        }
    }

    protected void nM() {
        if (this.IW.showHeaderLoadingLayout()) {
            this.Jb.setVisibility(0);
        } else {
            this.Jb.setVisibility(8);
        }
        if (this.IW.showFooterLoadingLayout()) {
            this.Jc.setVisibility(0);
        } else {
            this.Jc.setVisibility(8);
        }
        this.IU = this.IW != Mode.BOTH ? this.IW : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.IT != State.REFRESHING) {
            if (this.IW.showHeaderLoadingLayout() && i == 1) {
                this.Jl = true;
                fullScroll(33);
                aC(this.Jh);
                this.IU = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.Jf);
                nN();
            } else if (this.IW.showFooterLoadingLayout() && i == 0) {
                this.Jl = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.IU = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.Jg);
                nN();
            }
        }
    }

    private void nN() {
        if (this.IU == Mode.PULL_FROM_START) {
            if (this.Jk != null) {
                this.Jk.oc();
            }
        } else if (this.IU == Mode.PULL_FROM_END && this.Jj != null) {
            this.Jj.od();
        }
    }

    private boolean nO() {
        switch (oa()[this.IW.ordinal()]) {
            case 2:
                return nP();
            case 3:
                return nQ();
            case 4:
                return nQ() || nP();
            default:
                return false;
        }
    }

    private boolean nP() {
        switch (oa()[this.IW.ordinal()]) {
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

    private boolean nQ() {
        switch (oa()[this.IW.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.IZ.getHeight() + this.Jc.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.IZ.getHeight() + this.Jc.getHeight() && getHeadViewTopMargin() == this.Jh;
        }
    }

    private void nR() {
        if (getHeadViewTopMargin() >= this.Jd) {
            a(State.RELEASE_TO_REFRESH, this.Jf);
        } else {
            a(State.PULL_TO_REFRESH, this.Jf);
        }
    }

    private void nS() {
        if (getHeadViewTopMargin() > this.Jh && getHeadViewTopMargin() - getScrollY() < this.Jd) {
            a(State.PULL_TO_REFRESH, this.Jf);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.Jh) {
            a(State.RESET, this.Jf);
        }
    }

    private void nT() {
        if (getFootViewBottomMargin() >= this.Je) {
            a(State.RELEASE_TO_REFRESH, this.Jg);
        } else {
            a(State.PULL_TO_REFRESH, this.Jg);
        }
    }

    private void nU() {
        a(State.PULL_TO_REFRESH, this.Jg);
    }

    private void nV() {
        this.Jm = true;
        this.Jn = false;
    }

    private void nW() {
        this.Jm = false;
        this.Jn = true;
    }

    private void nX() {
        this.Jm = false;
        this.Jn = false;
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
        if (!this.IW.permitsPullToRefresh() || this.Jl) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.Ja = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.Ji != null) {
                    if (motionEvent.getY() - this.Ja >= 20.0f) {
                        this.Ji.X(true);
                    } else if (motionEvent.getY() - this.Ja <= -30.0f) {
                        this.Ji.X(false);
                    }
                }
                release();
                nX();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.IT == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.Ja = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (nO()) {
                    if (nP() && i < 0 && this.IW.showHeaderLoadingLayout() && !this.Jn) {
                        nV();
                        if (this.IW == Mode.BOTH) {
                            this.IU = Mode.PULL_FROM_START;
                        }
                        aC(i / 2);
                        nR();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (nP() && i > 0 && this.IW.showHeaderLoadingLayout() && !this.Jn) {
                        nS();
                        aC(i / 2);
                    }
                    if (nQ() && i > 0 && this.IW.showFooterLoadingLayout() && !this.Jm) {
                        nW();
                        if (this.IW == Mode.BOTH) {
                            this.IU = Mode.PULL_FROM_END;
                        }
                        aD(i / 2);
                        nT();
                        return super.onTouchEvent(motionEvent);
                    } else if (nQ() && i < 0 && this.IW.showFooterLoadingLayout() && !this.Jm) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        nU();
                        break;
                    }
                } else if (this.IU == Mode.PULL_FROM_START && i > 0) {
                    nS();
                    aC(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.IU == Mode.PULL_FROM_END && i < 0) {
                    nU();
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

    private void aC(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Jb.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.Jh) {
            layoutParams.topMargin = this.Jh;
        }
        this.Jb.setLayoutParams(layoutParams);
    }

    private void aD(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Jc.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.Jc.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, com.baidu.adp.widget.ScrollView.a aVar) {
        if (this.IT != state) {
            this.IT = state;
            switch (ob()[state.ordinal()]) {
                case 1:
                    aVar.nK();
                    return;
                case 2:
                    aVar.nJ();
                    return;
                case 3:
                    aVar.nw();
                    return;
                case 4:
                    aVar.nx();
                    return;
                case 5:
                    aVar.nx();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.Jb.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.Jc.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.IU.showHeaderLoadingLayout()) {
            nY();
        } else if (this.IU.showFooterLoadingLayout()) {
            nZ();
        }
    }

    private void nY() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.IT) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.IT) {
                k(getHeadViewTopMargin(), this.Jh);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.IT) {
                scrollTo(0, 0);
                k(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.IT) {
                aC(getHeadViewTopMargin() - this.Jh);
                scrollTo(0, 0);
                a(State.RESET, this.Jf);
            }
        } else if (getScrollY() < 0 && State.RESET != this.IT) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.IT) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.IT) {
                k(getHeadViewTopMargin(), this.Jh);
            }
        }
    }

    private void k(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.IX);
            eVar.h(this.Jb);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.nH();
        }
    }

    private void nZ() {
        if (State.RELEASE_TO_REFRESH == this.IT) {
            l(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.IT) {
            aD(0 - getFootViewBottomMargin());
        }
    }

    private void l(int i, int i2) {
        com.baidu.adp.widget.ScrollView.b bVar = new com.baidu.adp.widget.ScrollView.b(i, i2, this.IY);
        bVar.h(this.Jc);
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

        /* JADX DEBUG: Replace access to removed values field (Js) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Jr) with 'values()' method */
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
