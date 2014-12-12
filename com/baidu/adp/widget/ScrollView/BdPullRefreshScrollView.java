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
    private static /* synthetic */ int[] yA;
    private static /* synthetic */ int[] yB;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;
    private State yg;
    private Mode yh;
    private Mode yi;
    private int yj;
    private int yk;
    protected View yl;
    private float ym;
    private FrameLayout yn;
    private FrameLayout yo;
    private float yp;
    private float yq;
    private a yr;
    private a ys;
    private int yt;
    private l yu;
    private k yv;
    private j yw;
    private boolean yx;
    private boolean yy;
    private boolean yz;

    static /* synthetic */ int[] kl() {
        int[] iArr = yA;
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
            yA = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] km() {
        int[] iArr = yB;
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
            yB = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(a aVar) {
        if (aVar != null && aVar.jW() != null) {
            if (this.yr != null) {
                this.yn.removeView(this.yr.jW());
            }
            this.yr = aVar;
            this.yn.addView(this.yr.jW());
            this.yr.jV();
        }
    }

    public void setCustomFooterView(a aVar) {
        if (aVar != null && aVar.jW() != null) {
            if (this.ys != null) {
                this.yo.removeView(this.ys.jW());
            }
            this.ys = aVar;
            this.yo.addView(this.ys.jW());
            this.ys.jV();
        }
    }

    public a getHeadLoadingView() {
        return this.yr;
    }

    public a getmFootLoadingView() {
        return this.ys;
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
        this.yv = kVar;
    }

    public void setOnPullDownListener(j jVar) {
        this.yw = jVar;
    }

    public void setOnScrollUpDownListener(l lVar) {
        this.yu = lVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.yl = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.yi) {
            this.yi = mode;
            jX();
        }
    }

    protected void jX() {
        if (this.yi.showHeaderLoadingLayout()) {
            this.yn.setVisibility(0);
        } else {
            this.yn.setVisibility(8);
        }
        if (this.yi.showFooterLoadingLayout()) {
            this.yo.setVisibility(0);
        } else {
            this.yo.setVisibility(8);
        }
        this.yh = this.yi != Mode.BOTH ? this.yi : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.yg != State.REFRESHING) {
            if (this.yi.showHeaderLoadingLayout() && i == 1) {
                this.yx = true;
                fullScroll(33);
                aA(this.yt);
                this.yh = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.yr);
                jY();
            } else if (this.yi.showFooterLoadingLayout() && i == 0) {
                this.yx = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.yh = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.ys);
                jY();
            }
        }
    }

    private void jY() {
        if (this.yh == Mode.PULL_FROM_START) {
            if (this.yw != null) {
                this.yw.kn();
            }
        } else if (this.yh == Mode.PULL_FROM_END && this.yv != null) {
            this.yv.ko();
        }
    }

    private boolean jZ() {
        switch (kl()[this.yi.ordinal()]) {
            case 2:
                return ka();
            case 3:
                return kb();
            case 4:
                return kb() || ka();
            default:
                return false;
        }
    }

    private boolean ka() {
        switch (kl()[this.yi.ordinal()]) {
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

    private boolean kb() {
        switch (kl()[this.yi.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.yl.getHeight() + this.yo.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.yl.getHeight() + this.yo.getHeight() && getHeadViewTopMargin() == this.yt;
        }
    }

    private void kc() {
        if (getHeadViewTopMargin() >= this.yp) {
            a(State.RELEASE_TO_REFRESH, this.yr);
        } else {
            a(State.PULL_TO_REFRESH, this.yr);
        }
    }

    private void kd() {
        if (getHeadViewTopMargin() > this.yt && getHeadViewTopMargin() - getScrollY() < this.yp) {
            a(State.PULL_TO_REFRESH, this.yr);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.yt) {
            a(State.RESET, this.yr);
        }
    }

    private void ke() {
        if (getFootViewBottomMargin() >= this.yq) {
            a(State.RELEASE_TO_REFRESH, this.ys);
        } else {
            a(State.PULL_TO_REFRESH, this.ys);
        }
    }

    private void kf() {
        a(State.PULL_TO_REFRESH, this.ys);
    }

    private void kg() {
        this.yy = true;
        this.yz = false;
    }

    private void kh() {
        this.yy = false;
        this.yz = true;
    }

    private void ki() {
        this.yy = false;
        this.yz = false;
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
        if (!this.yi.permitsPullToRefresh() || this.yx) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.ym = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.yu != null) {
                    if (motionEvent.getY() - this.ym >= 20.0f) {
                        this.yu.V(true);
                    } else if (motionEvent.getY() - this.ym <= -30.0f) {
                        this.yu.V(false);
                    }
                }
                release();
                ki();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.yg == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.ym = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (jZ()) {
                    if (ka() && i < 0 && this.yi.showHeaderLoadingLayout() && !this.yz) {
                        kg();
                        if (this.yi == Mode.BOTH) {
                            this.yh = Mode.PULL_FROM_START;
                        }
                        aA(i / 2);
                        kc();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (ka() && i > 0 && this.yi.showHeaderLoadingLayout() && !this.yz) {
                        kd();
                        aA(i / 2);
                    }
                    if (kb() && i > 0 && this.yi.showFooterLoadingLayout() && !this.yy) {
                        kh();
                        if (this.yi == Mode.BOTH) {
                            this.yh = Mode.PULL_FROM_END;
                        }
                        aB(i / 2);
                        ke();
                        return super.onTouchEvent(motionEvent);
                    } else if (kb() && i < 0 && this.yi.showFooterLoadingLayout() && !this.yy) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        kf();
                        break;
                    }
                } else if (this.yh == Mode.PULL_FROM_START && i > 0) {
                    kd();
                    aA(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.yh == Mode.PULL_FROM_END && i < 0) {
                    kf();
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

    private void aA(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.yn.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.yt) {
            layoutParams.topMargin = this.yt;
        }
        this.yn.setLayoutParams(layoutParams);
    }

    private void aB(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.yo.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.yo.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, a aVar) {
        if (this.yg != state) {
            this.yg = state;
            switch (km()[state.ordinal()]) {
                case 1:
                    aVar.jV();
                    return;
                case 2:
                    aVar.jU();
                    return;
                case 3:
                    aVar.jA();
                    return;
                case 4:
                    aVar.jB();
                    return;
                case 5:
                    aVar.jB();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.yn.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.yo.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.yh.showHeaderLoadingLayout()) {
            kj();
        } else if (this.yh.showFooterLoadingLayout()) {
            kk();
        }
    }

    private void kj() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.yg) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.yg) {
                k(getHeadViewTopMargin(), this.yt);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.yg) {
                scrollTo(0, 0);
                k(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.yg) {
                aA(getHeadViewTopMargin() - this.yt);
                scrollTo(0, 0);
                a(State.RESET, this.yr);
            }
        } else if (getScrollY() < 0 && State.RESET != this.yg) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.yg) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.yg) {
                k(getHeadViewTopMargin(), this.yt);
            }
        }
    }

    private void k(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.yj);
            eVar.g(this.yn);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.jO();
        }
    }

    private void kk() {
        if (State.RELEASE_TO_REFRESH == this.yg) {
            l(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.yg) {
            aB(0 - getFootViewBottomMargin());
        }
    }

    private void l(int i, int i2) {
        b bVar = new b(i, i2, this.yk);
        bVar.g(this.yo);
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

        /* JADX DEBUG: Replace access to removed values field (yE) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (yD) with 'values()' method */
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
