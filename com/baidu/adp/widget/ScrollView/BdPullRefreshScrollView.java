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
    private static /* synthetic */ int[] Aq;
    private static /* synthetic */ int[] Ar;
    protected View Aa;
    private float Ab;
    private FrameLayout Ac;
    private FrameLayout Ae;
    private float Af;
    private float Ag;
    private com.baidu.adp.widget.ScrollView.a Ah;
    private com.baidu.adp.widget.ScrollView.a Ai;
    private int Aj;
    private c Ak;
    private b Al;
    private a Am;
    private boolean An;
    private boolean Ao;
    private boolean Ap;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;
    private State zV;
    private Mode zW;
    private Mode zX;
    private int zY;
    private int zZ;

    /* loaded from: classes.dex */
    public interface a {
        void ka();
    }

    /* loaded from: classes.dex */
    public interface b {
        void kb();
    }

    /* loaded from: classes.dex */
    public interface c {
        void T(boolean z);
    }

    static /* synthetic */ int[] jY() {
        int[] iArr = Aq;
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
            Aq = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] jZ() {
        int[] iArr = Ar;
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
            Ar = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.jJ() != null) {
            if (this.Ah != null) {
                this.Ac.removeView(this.Ah.jJ());
            }
            this.Ah = aVar;
            this.Ac.addView(this.Ah.jJ());
            this.Ah.jI();
        }
    }

    public void setCustomFooterView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.jJ() != null) {
            if (this.Ai != null) {
                this.Ae.removeView(this.Ai.jJ());
            }
            this.Ai = aVar;
            this.Ae.addView(this.Ai.jJ());
            this.Ai.jI();
        }
    }

    public com.baidu.adp.widget.ScrollView.a getHeadLoadingView() {
        return this.Ah;
    }

    public com.baidu.adp.widget.ScrollView.a getmFootLoadingView() {
        return this.Ai;
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
        this.Al = bVar;
    }

    public void setOnPullDownListener(a aVar) {
        this.Am = aVar;
    }

    public void setOnScrollUpDownListener(c cVar) {
        this.Ak = cVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.Aa = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.zX) {
            this.zX = mode;
            jK();
        }
    }

    protected void jK() {
        if (this.zX.showHeaderLoadingLayout()) {
            this.Ac.setVisibility(0);
        } else {
            this.Ac.setVisibility(8);
        }
        if (this.zX.showFooterLoadingLayout()) {
            this.Ae.setVisibility(0);
        } else {
            this.Ae.setVisibility(8);
        }
        this.zW = this.zX != Mode.BOTH ? this.zX : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.zV != State.REFRESHING) {
            if (this.zX.showHeaderLoadingLayout() && i == 1) {
                this.An = true;
                fullScroll(33);
                au(this.Aj);
                this.zW = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.Ah);
                jL();
            } else if (this.zX.showFooterLoadingLayout() && i == 0) {
                this.An = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.zW = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.Ai);
                jL();
            }
        }
    }

    private void jL() {
        if (this.zW == Mode.PULL_FROM_START) {
            if (this.Am != null) {
                this.Am.ka();
            }
        } else if (this.zW == Mode.PULL_FROM_END && this.Al != null) {
            this.Al.kb();
        }
    }

    private boolean jM() {
        switch (jY()[this.zX.ordinal()]) {
            case 2:
                return jN();
            case 3:
                return jO();
            case 4:
                return jO() || jN();
            default:
                return false;
        }
    }

    private boolean jN() {
        switch (jY()[this.zX.ordinal()]) {
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

    private boolean jO() {
        switch (jY()[this.zX.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.Aa.getHeight() + this.Ae.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.Aa.getHeight() + this.Ae.getHeight() && getHeadViewTopMargin() == this.Aj;
        }
    }

    private void jP() {
        if (getHeadViewTopMargin() >= this.Af) {
            a(State.RELEASE_TO_REFRESH, this.Ah);
        } else {
            a(State.PULL_TO_REFRESH, this.Ah);
        }
    }

    private void jQ() {
        if (getHeadViewTopMargin() > this.Aj && getHeadViewTopMargin() - getScrollY() < this.Af) {
            a(State.PULL_TO_REFRESH, this.Ah);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.Aj) {
            a(State.RESET, this.Ah);
        }
    }

    private void jR() {
        if (getFootViewBottomMargin() >= this.Ag) {
            a(State.RELEASE_TO_REFRESH, this.Ai);
        } else {
            a(State.PULL_TO_REFRESH, this.Ai);
        }
    }

    private void jS() {
        a(State.PULL_TO_REFRESH, this.Ai);
    }

    private void jT() {
        this.Ao = true;
        this.Ap = false;
    }

    private void jU() {
        this.Ao = false;
        this.Ap = true;
    }

    private void jV() {
        this.Ao = false;
        this.Ap = false;
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
        if (!this.zX.permitsPullToRefresh() || this.An) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.Ab = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.Ak != null) {
                    if (motionEvent.getY() - this.Ab >= 20.0f) {
                        this.Ak.T(true);
                    } else if (motionEvent.getY() - this.Ab <= -30.0f) {
                        this.Ak.T(false);
                    }
                }
                release();
                jV();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.zV == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.Ab = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (jM()) {
                    if (jN() && i < 0 && this.zX.showHeaderLoadingLayout() && !this.Ap) {
                        jT();
                        if (this.zX == Mode.BOTH) {
                            this.zW = Mode.PULL_FROM_START;
                        }
                        au(i / 2);
                        jP();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (jN() && i > 0 && this.zX.showHeaderLoadingLayout() && !this.Ap) {
                        jQ();
                        au(i / 2);
                    }
                    if (jO() && i > 0 && this.zX.showFooterLoadingLayout() && !this.Ao) {
                        jU();
                        if (this.zX == Mode.BOTH) {
                            this.zW = Mode.PULL_FROM_END;
                        }
                        av(i / 2);
                        jR();
                        return super.onTouchEvent(motionEvent);
                    } else if (jO() && i < 0 && this.zX.showFooterLoadingLayout() && !this.Ao) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        jS();
                        break;
                    }
                } else if (this.zW == Mode.PULL_FROM_START && i > 0) {
                    jQ();
                    au(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.zW == Mode.PULL_FROM_END && i < 0) {
                    jS();
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

    private void au(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ac.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.Aj) {
            layoutParams.topMargin = this.Aj;
        }
        this.Ac.setLayoutParams(layoutParams);
    }

    private void av(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ae.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.Ae.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, com.baidu.adp.widget.ScrollView.a aVar) {
        if (this.zV != state) {
            this.zV = state;
            switch (jZ()[state.ordinal()]) {
                case 1:
                    aVar.jI();
                    return;
                case 2:
                    aVar.jH();
                    return;
                case 3:
                    aVar.jo();
                    return;
                case 4:
                    aVar.jp();
                    return;
                case 5:
                    aVar.jp();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.Ac.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.Ae.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.zW.showHeaderLoadingLayout()) {
            jW();
        } else if (this.zW.showFooterLoadingLayout()) {
            jX();
        }
    }

    private void jW() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.zV) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.zV) {
                k(getHeadViewTopMargin(), this.Aj);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.zV) {
                scrollTo(0, 0);
                k(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.zV) {
                au(getHeadViewTopMargin() - this.Aj);
                scrollTo(0, 0);
                a(State.RESET, this.Ah);
            }
        } else if (getScrollY() < 0 && State.RESET != this.zV) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.zV) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.zV) {
                k(getHeadViewTopMargin(), this.Aj);
            }
        }
    }

    private void k(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.zY);
            eVar.t(this.Ac);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.jE();
        }
    }

    private void jX() {
        if (State.RELEASE_TO_REFRESH == this.zV) {
            l(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.zV) {
            av(0 - getFootViewBottomMargin());
        }
    }

    private void l(int i, int i2) {
        com.baidu.adp.widget.ScrollView.b bVar = new com.baidu.adp.widget.ScrollView.b(i, i2, this.zZ);
        bVar.t(this.Ae);
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

        /* JADX DEBUG: Replace access to removed values field (Au) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (At) with 'values()' method */
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
