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
    private static /* synthetic */ int[] Ji;
    private static /* synthetic */ int[] Jj;
    private State IN;
    private Mode IO;
    private Mode IP;
    private int IQ;
    private int IR;
    protected View IS;
    private float IT;
    private FrameLayout IU;
    private FrameLayout IW;
    private float IX;
    private float IY;
    private com.baidu.adp.widget.ScrollView.a IZ;
    private com.baidu.adp.widget.ScrollView.a Ja;
    private int Jb;
    private c Jc;
    private b Jd;
    private a Je;
    private boolean Jf;
    private boolean Jg;
    private boolean Jh;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void lL();
    }

    /* loaded from: classes.dex */
    public interface b {
        void lM();
    }

    /* loaded from: classes.dex */
    public interface c {
        void Y(boolean z);
    }

    static /* synthetic */ int[] lJ() {
        int[] iArr = Ji;
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
            Ji = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] lK() {
        int[] iArr = Jj;
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
            Jj = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.lx() != null) {
            if (this.IZ != null) {
                this.IU.removeView(this.IZ.lx());
            }
            this.IZ = aVar;
            this.IU.addView(this.IZ.lx());
            this.IZ.lw();
        }
    }

    public void setCustomFooterView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.lx() != null) {
            if (this.Ja != null) {
                this.IW.removeView(this.Ja.lx());
            }
            this.Ja = aVar;
            this.IW.addView(this.Ja.lx());
            this.Ja.lw();
        }
    }

    public com.baidu.adp.widget.ScrollView.a getHeadLoadingView() {
        return this.IZ;
    }

    public com.baidu.adp.widget.ScrollView.a getmFootLoadingView() {
        return this.Ja;
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
        this.Jd = bVar;
    }

    public void setOnPullDownListener(a aVar) {
        this.Je = aVar;
    }

    public void setOnScrollUpDownListener(c cVar) {
        this.Jc = cVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.IS = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.IP) {
            this.IP = mode;
            updateUIForMode();
        }
    }

    protected void updateUIForMode() {
        if (this.IP.showHeaderLoadingLayout()) {
            this.IU.setVisibility(0);
        } else {
            this.IU.setVisibility(8);
        }
        if (this.IP.showFooterLoadingLayout()) {
            this.IW.setVisibility(0);
        } else {
            this.IW.setVisibility(8);
        }
        this.IO = this.IP != Mode.BOTH ? this.IP : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.IN != State.REFRESHING) {
            if (this.IP.showHeaderLoadingLayout() && i == 1) {
                this.Jf = true;
                fullScroll(33);
                aK(this.Jb);
                this.IO = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.IZ);
                ly();
            } else if (this.IP.showFooterLoadingLayout() && i == 0) {
                this.Jf = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.IO = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.Ja);
                ly();
            }
        }
    }

    private void ly() {
        if (this.IO == Mode.PULL_FROM_START) {
            if (this.Je != null) {
                this.Je.lL();
            }
        } else if (this.IO == Mode.PULL_FROM_END && this.Jd != null) {
            this.Jd.lM();
        }
    }

    private boolean lz() {
        switch (lJ()[this.IP.ordinal()]) {
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
        switch (lJ()[this.IP.ordinal()]) {
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
        switch (lJ()[this.IP.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.IS.getHeight() + this.IW.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.IS.getHeight() + this.IW.getHeight() && getHeadViewTopMargin() == this.Jb;
        }
    }

    private void lA() {
        if (getHeadViewTopMargin() >= this.IX) {
            a(State.RELEASE_TO_REFRESH, this.IZ);
        } else {
            a(State.PULL_TO_REFRESH, this.IZ);
        }
    }

    private void lB() {
        if (getHeadViewTopMargin() > this.Jb && getHeadViewTopMargin() - getScrollY() < this.IX) {
            a(State.PULL_TO_REFRESH, this.IZ);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.Jb) {
            a(State.RESET, this.IZ);
        }
    }

    private void lC() {
        if (getFootViewBottomMargin() >= this.IY) {
            a(State.RELEASE_TO_REFRESH, this.Ja);
        } else {
            a(State.PULL_TO_REFRESH, this.Ja);
        }
    }

    private void lD() {
        a(State.PULL_TO_REFRESH, this.Ja);
    }

    private void lE() {
        this.Jg = true;
        this.Jh = false;
    }

    private void lF() {
        this.Jg = false;
        this.Jh = true;
    }

    private void lG() {
        this.Jg = false;
        this.Jh = false;
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
        if (!this.IP.permitsPullToRefresh() || this.Jf) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.IT = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.Jc != null) {
                    if (motionEvent.getY() - this.IT >= 20.0f) {
                        this.Jc.Y(true);
                    } else if (motionEvent.getY() - this.IT <= -30.0f) {
                        this.Jc.Y(false);
                    }
                }
                release();
                lG();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.IN == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.IT = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (lz()) {
                    if (isReadyForPullStart() && i < 0 && this.IP.showHeaderLoadingLayout() && !this.Jh) {
                        lE();
                        if (this.IP == Mode.BOTH) {
                            this.IO = Mode.PULL_FROM_START;
                        }
                        aK(i / 2);
                        lA();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (isReadyForPullStart() && i > 0 && this.IP.showHeaderLoadingLayout() && !this.Jh) {
                        lB();
                        aK(i / 2);
                    }
                    if (isReadyForPullEnd() && i > 0 && this.IP.showFooterLoadingLayout() && !this.Jg) {
                        lF();
                        if (this.IP == Mode.BOTH) {
                            this.IO = Mode.PULL_FROM_END;
                        }
                        aL(i / 2);
                        lC();
                        return super.onTouchEvent(motionEvent);
                    } else if (isReadyForPullEnd() && i < 0 && this.IP.showFooterLoadingLayout() && !this.Jg) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        lD();
                        break;
                    }
                } else if (this.IO == Mode.PULL_FROM_START && i > 0) {
                    lB();
                    aK(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.IO == Mode.PULL_FROM_END && i < 0) {
                    lD();
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.IU.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.Jb) {
            layoutParams.topMargin = this.Jb;
        }
        this.IU.setLayoutParams(layoutParams);
    }

    private void aL(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.IW.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.IW.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, com.baidu.adp.widget.ScrollView.a aVar) {
        if (this.IN != state) {
            this.IN = state;
            switch (lK()[state.ordinal()]) {
                case 1:
                    aVar.lw();
                    return;
                case 2:
                    aVar.lv();
                    return;
                case 3:
                    aVar.lg();
                    return;
                case 4:
                    aVar.lh();
                    return;
                case 5:
                    aVar.lh();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.IU.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.IW.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.IO.showHeaderLoadingLayout()) {
            lH();
        } else if (this.IO.showFooterLoadingLayout()) {
            lI();
        }
    }

    private void lH() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.IN) {
                u(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.IN) {
                u(getHeadViewTopMargin(), this.Jb);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.IN) {
                scrollTo(0, 0);
                u(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.IN) {
                aK(getHeadViewTopMargin() - this.Jb);
                scrollTo(0, 0);
                a(State.RESET, this.IZ);
            }
        } else if (getScrollY() < 0 && State.RESET != this.IN) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.IN) {
                u(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.IN) {
                u(getHeadViewTopMargin(), this.Jb);
            }
        }
    }

    private void u(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.IQ);
            eVar.r(this.IU);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.ls();
        }
    }

    private void lI() {
        if (State.RELEASE_TO_REFRESH == this.IN) {
            v(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.IN) {
            aL(0 - getFootViewBottomMargin());
        }
    }

    private void v(int i, int i2) {
        com.baidu.adp.widget.ScrollView.b bVar = new com.baidu.adp.widget.ScrollView.b(i, i2, this.IR);
        bVar.r(this.IW);
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

        /* JADX DEBUG: Replace access to removed values field (Jm) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Jl) with 'values()' method */
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
