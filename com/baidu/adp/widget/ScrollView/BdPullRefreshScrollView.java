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
    private static /* synthetic */ int[] Jg;
    private static /* synthetic */ int[] Jh;
    private State IL;
    private Mode IM;
    private Mode IN;
    private int IO;
    private int IP;
    protected View IQ;
    private float IR;
    private FrameLayout IS;
    private FrameLayout IT;
    private float IU;
    private float IW;
    private com.baidu.adp.widget.ScrollView.a IX;
    private com.baidu.adp.widget.ScrollView.a IY;
    private int IZ;
    private c Ja;
    private b Jb;
    private a Jc;
    private boolean Jd;
    private boolean Je;
    private boolean Jf;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void lK();
    }

    /* loaded from: classes.dex */
    public interface b {
        void lL();
    }

    /* loaded from: classes.dex */
    public interface c {
        void Y(boolean z);
    }

    static /* synthetic */ int[] lI() {
        int[] iArr = Jg;
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
            Jg = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] lJ() {
        int[] iArr = Jh;
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
            Jh = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.lw() != null) {
            if (this.IX != null) {
                this.IS.removeView(this.IX.lw());
            }
            this.IX = aVar;
            this.IS.addView(this.IX.lw());
            this.IX.lv();
        }
    }

    public void setCustomFooterView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.lw() != null) {
            if (this.IY != null) {
                this.IT.removeView(this.IY.lw());
            }
            this.IY = aVar;
            this.IT.addView(this.IY.lw());
            this.IY.lv();
        }
    }

    public com.baidu.adp.widget.ScrollView.a getHeadLoadingView() {
        return this.IX;
    }

    public com.baidu.adp.widget.ScrollView.a getmFootLoadingView() {
        return this.IY;
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
        this.Jb = bVar;
    }

    public void setOnPullDownListener(a aVar) {
        this.Jc = aVar;
    }

    public void setOnScrollUpDownListener(c cVar) {
        this.Ja = cVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.IQ = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.IN) {
            this.IN = mode;
            updateUIForMode();
        }
    }

    protected void updateUIForMode() {
        if (this.IN.showHeaderLoadingLayout()) {
            this.IS.setVisibility(0);
        } else {
            this.IS.setVisibility(8);
        }
        if (this.IN.showFooterLoadingLayout()) {
            this.IT.setVisibility(0);
        } else {
            this.IT.setVisibility(8);
        }
        this.IM = this.IN != Mode.BOTH ? this.IN : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.IL != State.REFRESHING) {
            if (this.IN.showHeaderLoadingLayout() && i == 1) {
                this.Jd = true;
                fullScroll(33);
                aK(this.IZ);
                this.IM = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.IX);
                lx();
            } else if (this.IN.showFooterLoadingLayout() && i == 0) {
                this.Jd = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.IM = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.IY);
                lx();
            }
        }
    }

    private void lx() {
        if (this.IM == Mode.PULL_FROM_START) {
            if (this.Jc != null) {
                this.Jc.lK();
            }
        } else if (this.IM == Mode.PULL_FROM_END && this.Jb != null) {
            this.Jb.lL();
        }
    }

    private boolean ly() {
        switch (lI()[this.IN.ordinal()]) {
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
        switch (lI()[this.IN.ordinal()]) {
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
        switch (lI()[this.IN.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.IQ.getHeight() + this.IT.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.IQ.getHeight() + this.IT.getHeight() && getHeadViewTopMargin() == this.IZ;
        }
    }

    private void lz() {
        if (getHeadViewTopMargin() >= this.IU) {
            a(State.RELEASE_TO_REFRESH, this.IX);
        } else {
            a(State.PULL_TO_REFRESH, this.IX);
        }
    }

    private void lA() {
        if (getHeadViewTopMargin() > this.IZ && getHeadViewTopMargin() - getScrollY() < this.IU) {
            a(State.PULL_TO_REFRESH, this.IX);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.IZ) {
            a(State.RESET, this.IX);
        }
    }

    private void lB() {
        if (getFootViewBottomMargin() >= this.IW) {
            a(State.RELEASE_TO_REFRESH, this.IY);
        } else {
            a(State.PULL_TO_REFRESH, this.IY);
        }
    }

    private void lC() {
        a(State.PULL_TO_REFRESH, this.IY);
    }

    private void lD() {
        this.Je = true;
        this.Jf = false;
    }

    private void lE() {
        this.Je = false;
        this.Jf = true;
    }

    private void lF() {
        this.Je = false;
        this.Jf = false;
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
        if (!this.IN.permitsPullToRefresh() || this.Jd) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.IR = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.Ja != null) {
                    if (motionEvent.getY() - this.IR >= 20.0f) {
                        this.Ja.Y(true);
                    } else if (motionEvent.getY() - this.IR <= -30.0f) {
                        this.Ja.Y(false);
                    }
                }
                release();
                lF();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.IL == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.IR = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (ly()) {
                    if (isReadyForPullStart() && i < 0 && this.IN.showHeaderLoadingLayout() && !this.Jf) {
                        lD();
                        if (this.IN == Mode.BOTH) {
                            this.IM = Mode.PULL_FROM_START;
                        }
                        aK(i / 2);
                        lz();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (isReadyForPullStart() && i > 0 && this.IN.showHeaderLoadingLayout() && !this.Jf) {
                        lA();
                        aK(i / 2);
                    }
                    if (isReadyForPullEnd() && i > 0 && this.IN.showFooterLoadingLayout() && !this.Je) {
                        lE();
                        if (this.IN == Mode.BOTH) {
                            this.IM = Mode.PULL_FROM_END;
                        }
                        aL(i / 2);
                        lB();
                        return super.onTouchEvent(motionEvent);
                    } else if (isReadyForPullEnd() && i < 0 && this.IN.showFooterLoadingLayout() && !this.Je) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        lC();
                        break;
                    }
                } else if (this.IM == Mode.PULL_FROM_START && i > 0) {
                    lA();
                    aK(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.IM == Mode.PULL_FROM_END && i < 0) {
                    lC();
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

    private void aK(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.IS.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.IZ) {
            layoutParams.topMargin = this.IZ;
        }
        this.IS.setLayoutParams(layoutParams);
    }

    private void aL(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.IT.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.IT.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, com.baidu.adp.widget.ScrollView.a aVar) {
        if (this.IL != state) {
            this.IL = state;
            switch (lJ()[state.ordinal()]) {
                case 1:
                    aVar.lv();
                    return;
                case 2:
                    aVar.lu();
                    return;
                case 3:
                    aVar.lf();
                    return;
                case 4:
                    aVar.lg();
                    return;
                case 5:
                    aVar.lg();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.IS.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.IT.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.IM.showHeaderLoadingLayout()) {
            lG();
        } else if (this.IM.showFooterLoadingLayout()) {
            lH();
        }
    }

    private void lG() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.IL) {
                u(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.IL) {
                u(getHeadViewTopMargin(), this.IZ);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.IL) {
                scrollTo(0, 0);
                u(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.IL) {
                aK(getHeadViewTopMargin() - this.IZ);
                scrollTo(0, 0);
                a(State.RESET, this.IX);
            }
        } else if (getScrollY() < 0 && State.RESET != this.IL) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.IL) {
                u(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.IL) {
                u(getHeadViewTopMargin(), this.IZ);
            }
        }
    }

    private void u(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.IO);
            eVar.r(this.IS);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.lr();
        }
    }

    private void lH() {
        if (State.RELEASE_TO_REFRESH == this.IL) {
            v(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.IL) {
            aL(0 - getFootViewBottomMargin());
        }
    }

    private void v(int i, int i2) {
        com.baidu.adp.widget.ScrollView.b bVar = new com.baidu.adp.widget.ScrollView.b(i, i2, this.IP);
        bVar.r(this.IT);
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

        /* JADX DEBUG: Replace access to removed values field (Jk) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Jj) with 'values()' method */
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
