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
    private static /* synthetic */ int[] AR;
    private static /* synthetic */ int[] AT;
    private int AA;
    protected View AB;
    private float AC;
    private FrameLayout AD;
    private FrameLayout AE;
    private float AF;
    private float AG;
    private com.baidu.adp.widget.ScrollView.a AH;
    private com.baidu.adp.widget.ScrollView.a AI;
    private int AJ;
    private c AK;
    private b AM;
    private a AN;
    private boolean AO;
    private boolean AP;
    private boolean AQ;
    private State Aw;
    private Mode Ax;
    private Mode Ay;
    private int Az;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void jZ();
    }

    /* loaded from: classes.dex */
    public interface b {
        void ka();
    }

    /* loaded from: classes.dex */
    public interface c {
        void V(boolean z);
    }

    static /* synthetic */ int[] jX() {
        int[] iArr = AR;
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
            AR = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] jY() {
        int[] iArr = AT;
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
            AT = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.jL() != null) {
            if (this.AH != null) {
                this.AD.removeView(this.AH.jL());
            }
            this.AH = aVar;
            this.AD.addView(this.AH.jL());
            this.AH.jK();
        }
    }

    public void setCustomFooterView(com.baidu.adp.widget.ScrollView.a aVar) {
        if (aVar != null && aVar.jL() != null) {
            if (this.AI != null) {
                this.AE.removeView(this.AI.jL());
            }
            this.AI = aVar;
            this.AE.addView(this.AI.jL());
            this.AI.jK();
        }
    }

    public com.baidu.adp.widget.ScrollView.a getHeadLoadingView() {
        return this.AH;
    }

    public com.baidu.adp.widget.ScrollView.a getmFootLoadingView() {
        return this.AI;
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
        this.AM = bVar;
    }

    public void setOnPullDownListener(a aVar) {
        this.AN = aVar;
    }

    public void setOnScrollUpDownListener(c cVar) {
        this.AK = cVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.AB = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.Ay) {
            this.Ay = mode;
            updateUIForMode();
        }
    }

    protected void updateUIForMode() {
        if (this.Ay.showHeaderLoadingLayout()) {
            this.AD.setVisibility(0);
        } else {
            this.AD.setVisibility(8);
        }
        if (this.Ay.showFooterLoadingLayout()) {
            this.AE.setVisibility(0);
        } else {
            this.AE.setVisibility(8);
        }
        this.Ax = this.Ay != Mode.BOTH ? this.Ay : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.Aw != State.REFRESHING) {
            if (this.Ay.showHeaderLoadingLayout() && i == 1) {
                this.AO = true;
                fullScroll(33);
                ay(this.AJ);
                this.Ax = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.AH);
                jM();
            } else if (this.Ay.showFooterLoadingLayout() && i == 0) {
                this.AO = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.Ax = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.AI);
                jM();
            }
        }
    }

    private void jM() {
        if (this.Ax == Mode.PULL_FROM_START) {
            if (this.AN != null) {
                this.AN.jZ();
            }
        } else if (this.Ax == Mode.PULL_FROM_END && this.AM != null) {
            this.AM.ka();
        }
    }

    private boolean jN() {
        switch (jX()[this.Ay.ordinal()]) {
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
        switch (jX()[this.Ay.ordinal()]) {
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
        switch (jX()[this.Ay.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.AB.getHeight() + this.AE.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.AB.getHeight() + this.AE.getHeight() && getHeadViewTopMargin() == this.AJ;
        }
    }

    private void jO() {
        if (getHeadViewTopMargin() >= this.AF) {
            a(State.RELEASE_TO_REFRESH, this.AH);
        } else {
            a(State.PULL_TO_REFRESH, this.AH);
        }
    }

    private void jP() {
        if (getHeadViewTopMargin() > this.AJ && getHeadViewTopMargin() - getScrollY() < this.AF) {
            a(State.PULL_TO_REFRESH, this.AH);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.AJ) {
            a(State.RESET, this.AH);
        }
    }

    private void jQ() {
        if (getFootViewBottomMargin() >= this.AG) {
            a(State.RELEASE_TO_REFRESH, this.AI);
        } else {
            a(State.PULL_TO_REFRESH, this.AI);
        }
    }

    private void jR() {
        a(State.PULL_TO_REFRESH, this.AI);
    }

    private void jS() {
        this.AP = true;
        this.AQ = false;
    }

    private void jT() {
        this.AP = false;
        this.AQ = true;
    }

    private void jU() {
        this.AP = false;
        this.AQ = false;
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
        if (!this.Ay.permitsPullToRefresh() || this.AO) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.AC = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.AK != null) {
                    if (motionEvent.getY() - this.AC >= 20.0f) {
                        this.AK.V(true);
                    } else if (motionEvent.getY() - this.AC <= -30.0f) {
                        this.AK.V(false);
                    }
                }
                release();
                jU();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.Aw == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.AC = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (jN()) {
                    if (isReadyForPullStart() && i < 0 && this.Ay.showHeaderLoadingLayout() && !this.AQ) {
                        jS();
                        if (this.Ay == Mode.BOTH) {
                            this.Ax = Mode.PULL_FROM_START;
                        }
                        ay(i / 2);
                        jO();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (isReadyForPullStart() && i > 0 && this.Ay.showHeaderLoadingLayout() && !this.AQ) {
                        jP();
                        ay(i / 2);
                    }
                    if (isReadyForPullEnd() && i > 0 && this.Ay.showFooterLoadingLayout() && !this.AP) {
                        jT();
                        if (this.Ay == Mode.BOTH) {
                            this.Ax = Mode.PULL_FROM_END;
                        }
                        az(i / 2);
                        jQ();
                        return super.onTouchEvent(motionEvent);
                    } else if (isReadyForPullEnd() && i < 0 && this.Ay.showFooterLoadingLayout() && !this.AP) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        jR();
                        break;
                    }
                } else if (this.Ax == Mode.PULL_FROM_START && i > 0) {
                    jP();
                    ay(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.Ax == Mode.PULL_FROM_END && i < 0) {
                    jR();
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

    private void ay(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.AD.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.AJ) {
            layoutParams.topMargin = this.AJ;
        }
        this.AD.setLayoutParams(layoutParams);
    }

    private void az(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.AE.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.AE.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, com.baidu.adp.widget.ScrollView.a aVar) {
        if (this.Aw != state) {
            this.Aw = state;
            switch (jY()[state.ordinal()]) {
                case 1:
                    aVar.jK();
                    return;
                case 2:
                    aVar.jJ();
                    return;
                case 3:
                    aVar.jq();
                    return;
                case 4:
                    aVar.jr();
                    return;
                case 5:
                    aVar.jr();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.AD.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.AE.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.Ax.showHeaderLoadingLayout()) {
            jV();
        } else if (this.Ax.showFooterLoadingLayout()) {
            jW();
        }
    }

    private void jV() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.Aw) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.Aw) {
                k(getHeadViewTopMargin(), this.AJ);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.Aw) {
                scrollTo(0, 0);
                k(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.Aw) {
                ay(getHeadViewTopMargin() - this.AJ);
                scrollTo(0, 0);
                a(State.RESET, this.AH);
            }
        } else if (getScrollY() < 0 && State.RESET != this.Aw) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.Aw) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.Aw) {
                k(getHeadViewTopMargin(), this.AJ);
            }
        }
    }

    private void k(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.Az);
            eVar.t(this.AD);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.jG();
        }
    }

    private void jW() {
        if (State.RELEASE_TO_REFRESH == this.Aw) {
            l(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.Aw) {
            az(0 - getFootViewBottomMargin());
        }
    }

    private void l(int i, int i2) {
        com.baidu.adp.widget.ScrollView.b bVar = new com.baidu.adp.widget.ScrollView.b(i, i2, this.AA);
        bVar.t(this.AE);
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

        /* JADX DEBUG: Replace access to removed values field (AW) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (AV) with 'values()' method */
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
