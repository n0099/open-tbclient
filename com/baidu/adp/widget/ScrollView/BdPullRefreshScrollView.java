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
    private static /* synthetic */ int[] yx;
    private static /* synthetic */ int[] yy;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;
    private State yc;
    private Mode yd;
    private Mode yf;
    private int yg;
    private int yh;
    protected View yi;
    private float yj;
    private FrameLayout yk;
    private FrameLayout yl;
    private float ym;
    private float yn;
    private a yo;
    private a yp;
    private int yq;
    private l yr;
    private k ys;
    private j yt;
    private boolean yu;
    private boolean yv;
    private boolean yw;

    static /* synthetic */ int[] ke() {
        int[] iArr = yx;
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
            yx = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] kf() {
        int[] iArr = yy;
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
            yy = iArr;
        }
        return iArr;
    }

    public void setCustomHeaderView(a aVar) {
        if (aVar != null && aVar.jP() != null) {
            if (this.yo != null) {
                this.yk.removeView(this.yo.jP());
            }
            this.yo = aVar;
            this.yk.addView(this.yo.jP());
            this.yo.jO();
        }
    }

    public void setCustomFooterView(a aVar) {
        if (aVar != null && aVar.jP() != null) {
            if (this.yp != null) {
                this.yl.removeView(this.yp.jP());
            }
            this.yp = aVar;
            this.yl.addView(this.yp.jP());
            this.yp.jO();
        }
    }

    public a getHeadLoadingView() {
        return this.yo;
    }

    public a getmFootLoadingView() {
        return this.yp;
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
        this.ys = kVar;
    }

    public void setOnPullDownListener(j jVar) {
        this.yt = jVar;
    }

    public void setOnScrollUpDownListener(l lVar) {
        this.yr = lVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.yi = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.yf) {
            this.yf = mode;
            jQ();
        }
    }

    protected void jQ() {
        if (this.yf.showHeaderLoadingLayout()) {
            this.yk.setVisibility(0);
        } else {
            this.yk.setVisibility(8);
        }
        if (this.yf.showFooterLoadingLayout()) {
            this.yl.setVisibility(0);
        } else {
            this.yl.setVisibility(8);
        }
        this.yd = this.yf != Mode.BOTH ? this.yf : Mode.PULL_FROM_START;
    }

    public void setRefreshing(int i) {
        if (this.yc != State.REFRESHING) {
            if (this.yf.showHeaderLoadingLayout() && i == 1) {
                this.yu = true;
                fullScroll(33);
                aF(this.yq);
                this.yd = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.yo);
                jR();
            } else if (this.yf.showFooterLoadingLayout() && i == 0) {
                this.yu = true;
                fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.yd = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.yp);
                jR();
            }
        }
    }

    private void jR() {
        if (this.yd == Mode.PULL_FROM_START) {
            if (this.yt != null) {
                this.yt.kg();
            }
        } else if (this.yd == Mode.PULL_FROM_END && this.ys != null) {
            this.ys.kh();
        }
    }

    private boolean jS() {
        switch (ke()[this.yf.ordinal()]) {
            case 2:
                return jT();
            case 3:
                return jU();
            case 4:
                return jU() || jT();
            default:
                return false;
        }
    }

    private boolean jT() {
        switch (ke()[this.yf.ordinal()]) {
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

    private boolean jU() {
        switch (ke()[this.yf.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.yi.getHeight() + this.yl.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.yi.getHeight() + this.yl.getHeight() && getHeadViewTopMargin() == this.yq;
        }
    }

    private void jV() {
        if (getHeadViewTopMargin() >= this.ym) {
            a(State.RELEASE_TO_REFRESH, this.yo);
        } else {
            a(State.PULL_TO_REFRESH, this.yo);
        }
    }

    private void jW() {
        if (getHeadViewTopMargin() > this.yq && getHeadViewTopMargin() - getScrollY() < this.ym) {
            a(State.PULL_TO_REFRESH, this.yo);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.yq) {
            a(State.RESET, this.yo);
        }
    }

    private void jX() {
        if (getFootViewBottomMargin() >= this.yn) {
            a(State.RELEASE_TO_REFRESH, this.yp);
        } else {
            a(State.PULL_TO_REFRESH, this.yp);
        }
    }

    private void jY() {
        a(State.PULL_TO_REFRESH, this.yp);
    }

    private void jZ() {
        this.yv = true;
        this.yw = false;
    }

    private void ka() {
        this.yv = false;
        this.yw = true;
    }

    private void kb() {
        this.yv = false;
        this.yw = false;
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
        if (!this.yf.permitsPullToRefresh() || this.yu) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.yj = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.yr != null) {
                    if (motionEvent.getY() - this.yj >= 20.0f) {
                        this.yr.V(true);
                    } else if (motionEvent.getY() - this.yj <= -30.0f) {
                        this.yr.V(false);
                    }
                }
                release();
                kb();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.yc == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.yj = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (jS()) {
                    if (jT() && i < 0 && this.yf.showHeaderLoadingLayout() && !this.yw) {
                        jZ();
                        if (this.yf == Mode.BOTH) {
                            this.yd = Mode.PULL_FROM_START;
                        }
                        aF(i / 2);
                        jV();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (jT() && i > 0 && this.yf.showHeaderLoadingLayout() && !this.yw) {
                        jW();
                        aF(i / 2);
                    }
                    if (jU() && i > 0 && this.yf.showFooterLoadingLayout() && !this.yv) {
                        ka();
                        if (this.yf == Mode.BOTH) {
                            this.yd = Mode.PULL_FROM_END;
                        }
                        aG(i / 2);
                        jX();
                        return super.onTouchEvent(motionEvent);
                    } else if (jU() && i < 0 && this.yf.showFooterLoadingLayout() && !this.yv) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        jY();
                        break;
                    }
                } else if (this.yd == Mode.PULL_FROM_START && i > 0) {
                    jW();
                    aF(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.yd == Mode.PULL_FROM_END && i < 0) {
                    jY();
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

    private void aF(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.yk.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.yq) {
            layoutParams.topMargin = this.yq;
        }
        this.yk.setLayoutParams(layoutParams);
    }

    private void aG(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.yl.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.yl.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, a aVar) {
        if (this.yc != state) {
            this.yc = state;
            switch (kf()[state.ordinal()]) {
                case 1:
                    aVar.jO();
                    return;
                case 2:
                    aVar.jN();
                    return;
                case 3:
                    aVar.js();
                    return;
                case 4:
                    aVar.jt();
                    return;
                case 5:
                    aVar.jt();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.yk.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.yl.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.yd.showHeaderLoadingLayout()) {
            kc();
        } else if (this.yd.showFooterLoadingLayout()) {
            kd();
        }
    }

    private void kc() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.yc) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.yc) {
                k(getHeadViewTopMargin(), this.yq);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.yc) {
                scrollTo(0, 0);
                k(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.yc) {
                aF(getHeadViewTopMargin() - this.yq);
                scrollTo(0, 0);
                a(State.RESET, this.yo);
            }
        } else if (getScrollY() < 0 && State.RESET != this.yc) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.yc) {
                k(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.yc) {
                k(getHeadViewTopMargin(), this.yq);
            }
        }
    }

    private void k(int i, int i2) {
        h hVar = new h(this);
        try {
            e eVar = new e(i, i2, this.yg);
            eVar.g(this.yk);
            eVar.a(hVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            hVar.jG();
        }
    }

    private void kd() {
        if (State.RELEASE_TO_REFRESH == this.yc) {
            l(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.yc) {
            aG(0 - getFootViewBottomMargin());
        }
    }

    private void l(int i, int i2) {
        b bVar = new b(i, i2, this.yh);
        bVar.g(this.yl);
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

        /* JADX DEBUG: Replace access to removed values field (yB) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (yA) with 'values()' method */
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
