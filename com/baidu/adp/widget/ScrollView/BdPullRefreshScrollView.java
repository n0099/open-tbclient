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
    private static /* synthetic */ int[] Ap;
    private static /* synthetic */ int[] Aq;
    private float Aa;
    private FrameLayout Ab;
    private FrameLayout Ac;
    private float Ae;
    private float Af;
    private com.baidu.adp.widget.ScrollView.a Ag;
    private com.baidu.adp.widget.ScrollView.a Ah;
    private int Ai;
    private c Aj;
    private b Ak;
    private a Al;
    private boolean Am;
    private boolean An;
    private boolean Ao;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;
    private State zU;
    private Mode zV;
    private Mode zW;
    private int zX;
    private int zY;
    protected View zZ;

    /* loaded from: classes.dex */
    public interface a {
        void kd();
    }

    /* loaded from: classes.dex */
    public interface b {
        void ke();
    }

    /* loaded from: classes.dex */
    public interface c {
        void T(boolean z);
    }

    static /* synthetic */ int[] kb() {
        int[] iArr = Ap;
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
            Ap = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] kc() {
        int[] iArr = Aq;
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
            Aq = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.jM() != null) {
            if (this.Ag != null) {
                this.Ab.removeView(this.Ag.jM());
            }
            this.Ag = aVar;
            this.Ab.addView(this.Ag.jM());
            this.Ag.jL();
        }
    }

    public void setCustomFooterView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.jM() != null) {
            if (this.Ah != null) {
                this.Ac.removeView(this.Ah.jM());
            }
            this.Ah = aVar;
            this.Ac.addView(this.Ah.jM());
            this.Ah.jL();
        }
    }

    public com.baidu.adp.widget.ScrollView.a getHeadLoadingView() {
        return this.Ag;
    }

    public com.baidu.adp.widget.ScrollView.a getmFootLoadingView() {
        return this.Ah;
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
        this.Ak = bVar;
    }

    public void setOnPullDownListener(a aVar) {
        this.Al = aVar;
    }

    public void setOnScrollUpDownListener(c cVar) {
        this.Aj = cVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.zZ = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.zW) {
            this.zW = mode;
            jN();
        }
    }

    protected void jN() {
        if (this.zW.showHeaderLoadingLayout()) {
            this.Ab.setVisibility(0);
        } else {
            this.Ab.setVisibility(8);
        }
        if (this.zW.showFooterLoadingLayout()) {
            this.Ac.setVisibility(0);
        } else {
            this.Ac.setVisibility(8);
        }
        this.zV = this.zW != Mode.BOTH ? this.zW : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.zU != State.REFRESHING) {
            if (this.zW.showHeaderLoadingLayout() && i == 1) {
                this.Am = true;
                fullScroll(33);
                av(this.Ai);
                this.zV = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.Ag);
                jO();
            } else if (this.zW.showFooterLoadingLayout() && i == 0) {
                this.Am = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.zV = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.Ah);
                jO();
            }
        }
    }

    private void jO() {
        if (this.zV == Mode.PULL_FROM_START) {
            if (this.Al != null) {
                this.Al.kd();
            }
        } else if (this.zV == Mode.PULL_FROM_END && this.Ak != null) {
            this.Ak.ke();
        }
    }

    private boolean jP() {
        switch (kb()[this.zW.ordinal()]) {
            case 2:
                return jQ();
            case 3:
                return jR();
            case 4:
                return jR() || jQ();
            default:
                return false;
        }
    }

    private boolean jQ() {
        switch (kb()[this.zW.ordinal()]) {
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

    private boolean jR() {
        switch (kb()[this.zW.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.zZ.getHeight() + this.Ac.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.zZ.getHeight() + this.Ac.getHeight() && getHeadViewTopMargin() == this.Ai;
        }
    }

    private void jS() {
        if (getHeadViewTopMargin() >= this.Ae) {
            a(State.RELEASE_TO_REFRESH, this.Ag);
        } else {
            a(State.PULL_TO_REFRESH, this.Ag);
        }
    }

    private void jT() {
        if (getHeadViewTopMargin() > this.Ai && getHeadViewTopMargin() - getScrollY() < this.Ae) {
            a(State.PULL_TO_REFRESH, this.Ag);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.Ai) {
            a(State.RESET, this.Ag);
        }
    }

    private void jU() {
        if (getFootViewBottomMargin() >= this.Af) {
            a(State.RELEASE_TO_REFRESH, this.Ah);
        } else {
            a(State.PULL_TO_REFRESH, this.Ah);
        }
    }

    private void jV() {
        a(State.PULL_TO_REFRESH, this.Ah);
    }

    private void jW() {
        this.An = true;
        this.Ao = false;
    }

    private void jX() {
        this.An = false;
        this.Ao = true;
    }

    private void jY() {
        this.An = false;
        this.Ao = false;
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
        if (!this.zW.permitsPullToRefresh() || this.Am) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.Aa = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.Aj != null) {
                    if (motionEvent.getY() - this.Aa >= 20.0f) {
                        this.Aj.T(true);
                    } else if (motionEvent.getY() - this.Aa <= -30.0f) {
                        this.Aj.T(false);
                    }
                }
                release();
                jY();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.zU == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.Aa = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (jP()) {
                    if (jQ() && i < 0 && this.zW.showHeaderLoadingLayout() && !this.Ao) {
                        jW();
                        if (this.zW == Mode.BOTH) {
                            this.zV = Mode.PULL_FROM_START;
                        }
                        av(i / 2);
                        jS();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (jQ() && i > 0 && this.zW.showHeaderLoadingLayout() && !this.Ao) {
                        jT();
                        av(i / 2);
                    }
                    if (jR() && i > 0 && this.zW.showFooterLoadingLayout() && !this.An) {
                        jX();
                        if (this.zW == Mode.BOTH) {
                            this.zV = Mode.PULL_FROM_END;
                        }
                        aw(i / 2);
                        jU();
                        return super.onTouchEvent(motionEvent);
                    } else if (jR() && i < 0 && this.zW.showFooterLoadingLayout() && !this.An) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        jV();
                        break;
                    }
                } else if (this.zV == Mode.PULL_FROM_START && i > 0) {
                    jT();
                    av(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.zV == Mode.PULL_FROM_END && i < 0) {
                    jV();
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

    private void av(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ab.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.Ai) {
            layoutParams.topMargin = this.Ai;
        }
        this.Ab.setLayoutParams(layoutParams);
    }

    private void aw(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ac.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.Ac.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, com.baidu.adp.widget.ScrollView.a aVar) {
        if (this.zU != state) {
            this.zU = state;
            switch (kc()[state.ordinal()]) {
                case 1:
                    aVar.jL();
                    return;
                case 2:
                    aVar.jK();
                    return;
                case 3:
                    aVar.jr();
                    return;
                case 4:
                    aVar.js();
                    return;
                case 5:
                    aVar.js();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.Ab.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.Ac.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.zV.showHeaderLoadingLayout()) {
            jZ();
        } else if (this.zV.showFooterLoadingLayout()) {
            ka();
        }
    }

    private void jZ() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.zU) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.zU) {
                k(getHeadViewTopMargin(), this.Ai);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.zU) {
                scrollTo(0, 0);
                k(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.zU) {
                av(getHeadViewTopMargin() - this.Ai);
                scrollTo(0, 0);
                a(State.RESET, this.Ag);
            }
        } else if (getScrollY() < 0 && State.RESET != this.zU) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.zU) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.zU) {
                k(getHeadViewTopMargin(), this.Ai);
            }
        }
    }

    private void k(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.zX);
            eVar.t(this.Ab);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.jH();
        }
    }

    private void ka() {
        if (State.RELEASE_TO_REFRESH == this.zU) {
            l(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.zU) {
            aw(0 - getFootViewBottomMargin());
        }
    }

    private void l(int i, int i2) {
        com.baidu.adp.widget.ScrollView.b bVar = new com.baidu.adp.widget.ScrollView.b(i, i2, this.zY);
        bVar.t(this.Ac);
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

        /* JADX DEBUG: Replace access to removed values field (At) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (As) with 'values()' method */
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
