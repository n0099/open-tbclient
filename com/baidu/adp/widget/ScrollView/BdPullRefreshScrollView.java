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
    private static /* synthetic */ int[] IZ;
    private static /* synthetic */ int[] Ja;
    private State IF;
    private Mode IG;
    private Mode IH;
    private int II;
    private int IJ;
    protected View IK;
    private float IL;
    private FrameLayout IM;
    private FrameLayout IN;
    private float IO;
    private float IP;
    private a IQ;
    private a IR;
    private int IS;
    private l IT;
    private k IU;
    private j IV;
    private boolean IW;
    private boolean IX;
    private boolean IY;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;

    static /* synthetic */ int[] nv() {
        int[] iArr = IZ;
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
            IZ = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] nw() {
        int[] iArr = Ja;
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
            Ja = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(a aVar) {
        if (aVar != null && aVar.ng() != null) {
            if (this.IQ != null) {
                this.IM.removeView(this.IQ.ng());
            }
            this.IQ = aVar;
            this.IM.addView(this.IQ.ng());
            this.IQ.nf();
        }
    }

    public void setCustomFooterView(a aVar) {
        if (aVar != null && aVar.ng() != null) {
            if (this.IR != null) {
                this.IN.removeView(this.IR.ng());
            }
            this.IR = aVar;
            this.IN.addView(this.IR.ng());
            this.IR.nf();
        }
    }

    public a getHeadLoadingView() {
        return this.IQ;
    }

    public a getmFootLoadingView() {
        return this.IR;
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
        this.IU = kVar;
    }

    public void setOnPullDownListener(j jVar) {
        this.IV = jVar;
    }

    public void setOnScrollUpDownListener(l lVar) {
        this.IT = lVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.IK = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.IH) {
            this.IH = mode;
            nh();
        }
    }

    protected void nh() {
        if (this.IH.showHeaderLoadingLayout()) {
            this.IM.setVisibility(0);
        } else {
            this.IM.setVisibility(8);
        }
        if (this.IH.showFooterLoadingLayout()) {
            this.IN.setVisibility(0);
        } else {
            this.IN.setVisibility(8);
        }
        this.IG = this.IH != Mode.BOTH ? this.IH : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.IF != State.REFRESHING) {
            if (this.IH.showHeaderLoadingLayout() && i == 1) {
                this.IW = true;
                fullScroll(33);
                aB(this.IS);
                this.IG = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.IQ);
                ni();
            } else if (this.IH.showFooterLoadingLayout() && i == 0) {
                this.IW = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.IG = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.IR);
                ni();
            }
        }
    }

    private void ni() {
        if (this.IG == Mode.PULL_FROM_START) {
            if (this.IV != null) {
                this.IV.nx();
            }
        } else if (this.IG == Mode.PULL_FROM_END && this.IU != null) {
            this.IU.ny();
        }
    }

    private boolean nj() {
        switch (nv()[this.IH.ordinal()]) {
            case 2:
                return nk();
            case 3:
                return nl();
            case 4:
                return nl() || nk();
            default:
                return false;
        }
    }

    private boolean nk() {
        switch (nv()[this.IH.ordinal()]) {
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

    private boolean nl() {
        switch (nv()[this.IH.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.IK.getHeight() + this.IN.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.IK.getHeight() + this.IN.getHeight() && getHeadViewTopMargin() == this.IS;
        }
    }

    private void nm() {
        if (getHeadViewTopMargin() >= this.IO) {
            a(State.RELEASE_TO_REFRESH, this.IQ);
        } else {
            a(State.PULL_TO_REFRESH, this.IQ);
        }
    }

    private void nn() {
        if (getHeadViewTopMargin() > this.IS && getHeadViewTopMargin() - getScrollY() < this.IO) {
            a(State.PULL_TO_REFRESH, this.IQ);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.IS) {
            a(State.RESET, this.IQ);
        }
    }

    private void no() {
        if (getFootViewBottomMargin() >= this.IP) {
            a(State.RELEASE_TO_REFRESH, this.IR);
        } else {
            a(State.PULL_TO_REFRESH, this.IR);
        }
    }

    private void np() {
        a(State.PULL_TO_REFRESH, this.IR);
    }

    private void nq() {
        this.IX = true;
        this.IY = false;
    }

    private void nr() {
        this.IX = false;
        this.IY = true;
    }

    private void ns() {
        this.IX = false;
        this.IY = false;
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
        if (!this.IH.permitsPullToRefresh() || this.IW) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.IL = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.IT != null) {
                    if (motionEvent.getY() - this.IL >= 20.0f) {
                        this.IT.T(true);
                    } else if (motionEvent.getY() - this.IL <= -30.0f) {
                        this.IT.T(false);
                    }
                }
                release();
                ns();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.IF == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.IL = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (nj()) {
                    if (nk() && i < 0 && this.IH.showHeaderLoadingLayout() && !this.IY) {
                        nq();
                        if (this.IH == Mode.BOTH) {
                            this.IG = Mode.PULL_FROM_START;
                        }
                        aB(i / 2);
                        nm();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (nk() && i > 0 && this.IH.showHeaderLoadingLayout() && !this.IY) {
                        nn();
                        aB(i / 2);
                    }
                    if (nl() && i > 0 && this.IH.showFooterLoadingLayout() && !this.IX) {
                        nr();
                        if (this.IH == Mode.BOTH) {
                            this.IG = Mode.PULL_FROM_END;
                        }
                        aC(i / 2);
                        no();
                        return super.onTouchEvent(motionEvent);
                    } else if (nl() && i < 0 && this.IH.showFooterLoadingLayout() && !this.IX) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        np();
                        break;
                    }
                } else if (this.IG == Mode.PULL_FROM_START && i > 0) {
                    nn();
                    aB(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.IG == Mode.PULL_FROM_END && i < 0) {
                    np();
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.IM.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.IS) {
            layoutParams.topMargin = this.IS;
        }
        this.IM.setLayoutParams(layoutParams);
    }

    private void aC(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.IN.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.IN.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, a aVar) {
        if (this.IF != state) {
            this.IF = state;
            switch (nw()[state.ordinal()]) {
                case 1:
                    aVar.nf();
                    return;
                case 2:
                    aVar.ne();
                    return;
                case 3:
                    aVar.mO();
                    return;
                case 4:
                    aVar.mP();
                    return;
                case 5:
                    aVar.mP();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.IM.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.IN.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.IG.showHeaderLoadingLayout()) {
            nt();
        } else if (this.IG.showFooterLoadingLayout()) {
            nu();
        }
    }

    private void nt() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.IF) {
                i(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.IF) {
                i(getHeadViewTopMargin(), this.IS);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.IF) {
                scrollTo(0, 0);
                i(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.IF) {
                aB(getHeadViewTopMargin() - this.IS);
                scrollTo(0, 0);
                a(State.RESET, this.IQ);
            }
        } else if (getScrollY() < 0 && State.RESET != this.IF) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.IF) {
                i(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.IF) {
                i(getHeadViewTopMargin(), this.IS);
            }
        }
    }

    private void i(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.II);
            eVar.g(this.IM);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.nb();
        }
    }

    private void nu() {
        if (State.RELEASE_TO_REFRESH == this.IF) {
            j(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.IF) {
            aC(0 - getFootViewBottomMargin());
        }
    }

    private void j(int i, int i2) {
        b bVar = new b(i, i2, this.IJ);
        bVar.g(this.IN);
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

        /* JADX DEBUG: Replace access to removed values field (Jd) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Jc) with 'values()' method */
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
