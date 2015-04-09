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
    private static /* synthetic */ int[] Jb;
    private static /* synthetic */ int[] Jc;
    private State IH;
    private Mode II;
    private Mode IJ;
    private int IK;
    private int IL;
    protected View IM;
    private float IN;
    private FrameLayout IO;
    private FrameLayout IP;
    private float IQ;
    private float IR;
    private a IS;
    private a IT;
    private int IU;
    private l IV;
    private k IW;
    private j IX;
    private boolean IY;
    private boolean IZ;
    private boolean Ja;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;

    static /* synthetic */ int[] nv() {
        int[] iArr = Jb;
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
            Jb = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] nw() {
        int[] iArr = Jc;
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
            Jc = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(a aVar) {
        if (aVar != null && aVar.ng() != null) {
            if (this.IS != null) {
                this.IO.removeView(this.IS.ng());
            }
            this.IS = aVar;
            this.IO.addView(this.IS.ng());
            this.IS.nf();
        }
    }

    public void setCustomFooterView(a aVar) {
        if (aVar != null && aVar.ng() != null) {
            if (this.IT != null) {
                this.IP.removeView(this.IT.ng());
            }
            this.IT = aVar;
            this.IP.addView(this.IT.ng());
            this.IT.nf();
        }
    }

    public a getHeadLoadingView() {
        return this.IS;
    }

    public a getmFootLoadingView() {
        return this.IT;
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
        this.IW = kVar;
    }

    public void setOnPullDownListener(j jVar) {
        this.IX = jVar;
    }

    public void setOnScrollUpDownListener(l lVar) {
        this.IV = lVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.IM = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.IJ) {
            this.IJ = mode;
            nh();
        }
    }

    protected void nh() {
        if (this.IJ.showHeaderLoadingLayout()) {
            this.IO.setVisibility(0);
        } else {
            this.IO.setVisibility(8);
        }
        if (this.IJ.showFooterLoadingLayout()) {
            this.IP.setVisibility(0);
        } else {
            this.IP.setVisibility(8);
        }
        this.II = this.IJ != Mode.BOTH ? this.IJ : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.IH != State.REFRESHING) {
            if (this.IJ.showHeaderLoadingLayout() && i == 1) {
                this.IY = true;
                fullScroll(33);
                aB(this.IU);
                this.II = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.IS);
                ni();
            } else if (this.IJ.showFooterLoadingLayout() && i == 0) {
                this.IY = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.II = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.IT);
                ni();
            }
        }
    }

    private void ni() {
        if (this.II == Mode.PULL_FROM_START) {
            if (this.IX != null) {
                this.IX.nx();
            }
        } else if (this.II == Mode.PULL_FROM_END && this.IW != null) {
            this.IW.ny();
        }
    }

    private boolean nj() {
        switch (nv()[this.IJ.ordinal()]) {
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
        switch (nv()[this.IJ.ordinal()]) {
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
        switch (nv()[this.IJ.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.IM.getHeight() + this.IP.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.IM.getHeight() + this.IP.getHeight() && getHeadViewTopMargin() == this.IU;
        }
    }

    private void nm() {
        if (getHeadViewTopMargin() >= this.IQ) {
            a(State.RELEASE_TO_REFRESH, this.IS);
        } else {
            a(State.PULL_TO_REFRESH, this.IS);
        }
    }

    private void nn() {
        if (getHeadViewTopMargin() > this.IU && getHeadViewTopMargin() - getScrollY() < this.IQ) {
            a(State.PULL_TO_REFRESH, this.IS);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.IU) {
            a(State.RESET, this.IS);
        }
    }

    private void no() {
        if (getFootViewBottomMargin() >= this.IR) {
            a(State.RELEASE_TO_REFRESH, this.IT);
        } else {
            a(State.PULL_TO_REFRESH, this.IT);
        }
    }

    private void np() {
        a(State.PULL_TO_REFRESH, this.IT);
    }

    private void nq() {
        this.IZ = true;
        this.Ja = false;
    }

    private void nr() {
        this.IZ = false;
        this.Ja = true;
    }

    private void ns() {
        this.IZ = false;
        this.Ja = false;
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
        if (!this.IJ.permitsPullToRefresh() || this.IY) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.IN = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.IV != null) {
                    if (motionEvent.getY() - this.IN >= 20.0f) {
                        this.IV.T(true);
                    } else if (motionEvent.getY() - this.IN <= -30.0f) {
                        this.IV.T(false);
                    }
                }
                release();
                ns();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.IH == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.IN = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (nj()) {
                    if (nk() && i < 0 && this.IJ.showHeaderLoadingLayout() && !this.Ja) {
                        nq();
                        if (this.IJ == Mode.BOTH) {
                            this.II = Mode.PULL_FROM_START;
                        }
                        aB(i / 2);
                        nm();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (nk() && i > 0 && this.IJ.showHeaderLoadingLayout() && !this.Ja) {
                        nn();
                        aB(i / 2);
                    }
                    if (nl() && i > 0 && this.IJ.showFooterLoadingLayout() && !this.IZ) {
                        nr();
                        if (this.IJ == Mode.BOTH) {
                            this.II = Mode.PULL_FROM_END;
                        }
                        aC(i / 2);
                        no();
                        return super.onTouchEvent(motionEvent);
                    } else if (nl() && i < 0 && this.IJ.showFooterLoadingLayout() && !this.IZ) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        np();
                        break;
                    }
                } else if (this.II == Mode.PULL_FROM_START && i > 0) {
                    nn();
                    aB(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.II == Mode.PULL_FROM_END && i < 0) {
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.IO.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.IU) {
            layoutParams.topMargin = this.IU;
        }
        this.IO.setLayoutParams(layoutParams);
    }

    private void aC(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.IP.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.IP.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, a aVar) {
        if (this.IH != state) {
            this.IH = state;
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
        return ((LinearLayout.LayoutParams) this.IO.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.IP.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.II.showHeaderLoadingLayout()) {
            nt();
        } else if (this.II.showFooterLoadingLayout()) {
            nu();
        }
    }

    private void nt() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.IH) {
                i(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.IH) {
                i(getHeadViewTopMargin(), this.IU);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.IH) {
                scrollTo(0, 0);
                i(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.IH) {
                aB(getHeadViewTopMargin() - this.IU);
                scrollTo(0, 0);
                a(State.RESET, this.IS);
            }
        } else if (getScrollY() < 0 && State.RESET != this.IH) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.IH) {
                i(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.IH) {
                i(getHeadViewTopMargin(), this.IU);
            }
        }
    }

    private void i(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.IK);
            eVar.g(this.IO);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.nb();
        }
    }

    private void nu() {
        if (State.RELEASE_TO_REFRESH == this.IH) {
            j(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.IH) {
            aC(0 - getFootViewBottomMargin());
        }
    }

    private void j(int i, int i2) {
        b bVar = new b(i, i2, this.IL);
        bVar.g(this.IP);
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

        /* JADX DEBUG: Replace access to removed values field (Jf) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Je) with 'values()' method */
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
