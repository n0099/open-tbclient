package com.baidu.adp.widget.ScrollView;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class BdPullRefreshScrollView extends ScrollView {
    private static /* synthetic */ int[] wx;
    private static /* synthetic */ int[] wy;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private float mLastY;
    private Scroller mScroller;
    private int mTouchSlop;
    private State wd;
    private Mode we;
    private Mode wf;
    private int wg;
    private int wh;
    protected View wi;
    private float wj;
    private FrameLayout wk;
    private FrameLayout wl;
    private float wm;
    private float wn;
    private b wo;
    private b wp;
    private int wq;
    private n wr;
    private m ws;
    private l wt;
    private boolean wu;
    private boolean wv;
    private boolean ww;

    static /* synthetic */ int[] iw() {
        int[] iArr = wx;
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
            wx = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] ix() {
        int[] iArr = wy;
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
            wy = iArr;
        }
        return iArr;
    }

    public BdPullRefreshScrollView(Context context) {
        super(context);
        this.wd = State.RESET;
        this.wf = Mode.getDefault();
        this.wg = Constants.MEDIA_INFO;
        this.wh = Constants.MEDIA_INFO;
        this.mLastY = -1000.0f;
        this.wu = false;
        this.wv = false;
        this.ww = false;
        this.mIsBeingDragged = false;
        a(context, null, new o(context), new a(context));
    }

    public BdPullRefreshScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.wd = State.RESET;
        this.wf = Mode.getDefault();
        this.wg = Constants.MEDIA_INFO;
        this.wh = Constants.MEDIA_INFO;
        this.mLastY = -1000.0f;
        this.wu = false;
        this.wv = false;
        this.ww = false;
        this.mIsBeingDragged = false;
        a(context, attributeSet, new o(context), new a(context));
    }

    public BdPullRefreshScrollView(Context context, Mode mode) {
        super(context);
        this.wd = State.RESET;
        this.wf = Mode.getDefault();
        this.wg = Constants.MEDIA_INFO;
        this.wh = Constants.MEDIA_INFO;
        this.mLastY = -1000.0f;
        this.wu = false;
        this.wv = false;
        this.ww = false;
        this.mIsBeingDragged = false;
        this.wf = mode;
        a(context, null, new o(context), new a(context));
    }

    public BdPullRefreshScrollView(Context context, Mode mode, b bVar, b bVar2) {
        super(context);
        this.wd = State.RESET;
        this.wf = Mode.getDefault();
        this.wg = Constants.MEDIA_INFO;
        this.wh = Constants.MEDIA_INFO;
        this.mLastY = -1000.0f;
        this.wu = false;
        this.wv = false;
        this.ww = false;
        this.mIsBeingDragged = false;
        this.wf = mode;
        a(context, null, bVar, bVar2);
    }

    private void a(Context context, AttributeSet attributeSet, b bVar, b bVar2) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mScroller = new Scroller(getContext());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AdpPullToRefreshScrollView);
        if (obtainStyledAttributes.hasValue(0)) {
            this.wf = Mode.mapIntToValue(obtainStyledAttributes.getInteger(0, 0));
        }
        this.wg = obtainStyledAttributes.getInteger(4, Constants.MEDIA_INFO);
        this.wh = obtainStyledAttributes.getInteger(5, Constants.MEDIA_INFO);
        com.baidu.adp.lib.g.b.ek().a(context, R.layout.adp_pull_refresh_scroll_view, this, true);
        this.wk = (FrameLayout) findViewById(R.id.head_ly);
        this.wl = (FrameLayout) findViewById(R.id.foot_ly);
        setCustomHeaderView(bVar);
        setCustomFooterView(bVar2);
        if (obtainStyledAttributes.hasValue(1)) {
            this.wm = obtainStyledAttributes.getDimension(1, 0.0f);
        } else {
            this.wm = getResources().getDimension(R.dimen.adp_head_need_refresh_delta);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.wn = obtainStyledAttributes.getDimension(2, 0.0f);
        } else {
            this.wn = getResources().getDimension(R.dimen.adp_foot_need_refresh_delta);
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.wq = -obtainStyledAttributes.getDimensionPixelSize(3, 0);
        } else {
            this.wq = -getResources().getDimensionPixelSize(R.dimen.adp_head_view_height);
        }
        obtainStyledAttributes.recycle();
        setFadingEdgeLength(0);
        id();
    }

    public void setCustomHeaderView(b bVar) {
        if (bVar != null && bVar.getRealView() != null) {
            if (this.wo != null) {
                this.wk.removeView(this.wo.getRealView());
            }
            this.wo = bVar;
            this.wk.addView(this.wo.getRealView());
            this.wo.ic();
        }
    }

    public void setCustomFooterView(b bVar) {
        if (bVar != null && bVar.getRealView() != null) {
            if (this.wp != null) {
                this.wl.removeView(this.wp.getRealView());
            }
            this.wp = bVar;
            this.wl.addView(this.wp.getRealView());
            this.wp.ic();
        }
    }

    public b getHeadLoadingView() {
        return this.wo;
    }

    public b getmFootLoadingView() {
        return this.wp;
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

    public void setOnPullUpListener(m mVar) {
        this.ws = mVar;
    }

    public void setOnPullDownListener(l lVar) {
        this.wt = lVar;
    }

    public void setOnScrollUpDownListener(n nVar) {
        this.wr = nVar;
    }

    public void setContentView(View view) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.wi = view;
            ((LinearLayout) childAt).addView(view, 1);
        }
    }

    public final void setMode(Mode mode) {
        if (mode != this.wf) {
            this.wf = mode;
            id();
        }
    }

    protected void id() {
        if (this.wf.showHeaderLoadingLayout()) {
            this.wk.setVisibility(0);
        } else {
            this.wk.setVisibility(8);
        }
        if (this.wf.showFooterLoadingLayout()) {
            this.wl.setVisibility(0);
        } else {
            this.wl.setVisibility(8);
        }
        this.we = this.wf != Mode.BOTH ? this.wf : Mode.PULL_FROM_START;
    }

    public final boolean ie() {
        return this.wd == State.REFRESHING || this.wd == State.MANUAL_REFRESHING;
    }

    public final void ig() {
        if (ie()) {
            if (this.we == Mode.PULL_FROM_START) {
                ih();
            } else if (this.we == Mode.PULL_FROM_END) {
                ii();
            }
        }
    }

    protected void ih() {
        i iVar = new i(this);
        try {
            f fVar = new f(0, this.wq, TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
            fVar.g(this.wk);
            fVar.a(iVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            iVar.hU();
        }
    }

    protected void ii() {
        this.wu = false;
        a(State.RESET, this.wp);
    }

    public void setRefreshing(int i) {
        if (this.wd != State.REFRESHING) {
            if (this.wf.showHeaderLoadingLayout() && i == 1) {
                this.wu = true;
                fullScroll(33);
                al(this.wq);
                this.we = Mode.PULL_FROM_START;
                a(State.REFRESHING, this.wo);
                ij();
            } else if (this.wf.showFooterLoadingLayout() && i == 0) {
                this.wu = true;
                fullScroll(130);
                this.we = Mode.PULL_FROM_END;
                a(State.REFRESHING, this.wp);
                ij();
            }
        }
    }

    private void ij() {
        if (this.we == Mode.PULL_FROM_START) {
            if (this.wt != null) {
                this.wt.iy();
            }
        } else if (this.we == Mode.PULL_FROM_END && this.ws != null) {
            this.ws.iz();
        }
    }

    private boolean ik() {
        switch (iw()[this.wf.ordinal()]) {
            case 2:
                return il();
            case 3:
                return im();
            case 4:
                return im() || il();
            default:
                return false;
        }
    }

    private boolean il() {
        switch (iw()[this.wf.ordinal()]) {
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

    private boolean im() {
        switch (iw()[this.wf.ordinal()]) {
            case 2:
            default:
                return false;
            case 3:
                return getScrollY() + getHeight() >= this.wi.getHeight() + this.wl.getHeight();
            case 4:
                return getScrollY() + getHeight() >= this.wi.getHeight() + this.wl.getHeight() && getHeadViewTopMargin() == this.wq;
        }
    }

    private void in() {
        if (getHeadViewTopMargin() >= this.wm) {
            a(State.RELEASE_TO_REFRESH, this.wo);
        } else {
            a(State.PULL_TO_REFRESH, this.wo);
        }
    }

    private void io() {
        if (getHeadViewTopMargin() > this.wq && getHeadViewTopMargin() - getScrollY() < this.wm) {
            a(State.PULL_TO_REFRESH, this.wo);
        } else if (getHeadViewTopMargin() - getScrollY() <= this.wq) {
            a(State.RESET, this.wo);
        }
    }

    private void ip() {
        if (getFootViewBottomMargin() >= this.wn) {
            a(State.RELEASE_TO_REFRESH, this.wp);
        } else {
            a(State.PULL_TO_REFRESH, this.wp);
        }
    }

    private void iq() {
        a(State.PULL_TO_REFRESH, this.wp);
    }

    private void ir() {
        this.wv = true;
        this.ww = false;
    }

    private void is() {
        this.wv = false;
        this.ww = true;
    }

    private void it() {
        this.wv = false;
        this.ww = false;
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
        if (!this.wf.permitsPullToRefresh() || this.wu) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getY();
                this.wj = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.wr != null) {
                    if (motionEvent.getY() - this.wj >= 20.0f) {
                        this.wr.K(true);
                    } else if (motionEvent.getY() - this.wj <= -30.0f) {
                        this.wr.K(false);
                    }
                }
                release();
                it();
                this.mLastY = -1000.0f;
                this.mIsBeingDragged = false;
                break;
            case 2:
                if (this.wd == State.REFRESHING) {
                    return super.onTouchEvent(motionEvent);
                }
                if (-1000.0f == this.mLastY) {
                    this.mLastY = motionEvent.getY();
                    this.wj = motionEvent.getY();
                    return super.onTouchEvent(motionEvent);
                }
                float f = this.mLastY;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                this.mLastY = y;
                if (ik()) {
                    if (il() && i < 0 && this.wf.showHeaderLoadingLayout() && !this.ww) {
                        ir();
                        if (this.wf == Mode.BOTH) {
                            this.we = Mode.PULL_FROM_START;
                        }
                        al(i / 2);
                        in();
                        return super.onTouchEvent(motionEvent);
                    }
                    if (il() && i > 0 && this.wf.showHeaderLoadingLayout() && !this.ww) {
                        io();
                        al(i / 2);
                    }
                    if (im() && i > 0 && this.wf.showFooterLoadingLayout() && !this.wv) {
                        is();
                        if (this.wf == Mode.BOTH) {
                            this.we = Mode.PULL_FROM_END;
                        }
                        am(i / 2);
                        ip();
                        return super.onTouchEvent(motionEvent);
                    } else if (im() && i < 0 && this.wf.showFooterLoadingLayout() && !this.wv) {
                        if (computeVerticalScrollRange() >= getHeight()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        iq();
                        break;
                    }
                } else if (this.we == Mode.PULL_FROM_START && i > 0) {
                    io();
                    al(i / 2);
                    return super.onTouchEvent(motionEvent);
                } else if (this.we == Mode.PULL_FROM_END && i < 0) {
                    iq();
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

    private void al(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.wk.getLayoutParams();
        layoutParams.topMargin -= i;
        if (layoutParams.topMargin <= this.wq) {
            layoutParams.topMargin = this.wq;
        }
        this.wk.setLayoutParams(layoutParams);
    }

    private void am(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.wl.getLayoutParams();
        layoutParams.bottomMargin += i;
        if (layoutParams.bottomMargin <= 0) {
            layoutParams.bottomMargin = 0;
        }
        this.wl.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(State state, b bVar) {
        if (this.wd != state) {
            this.wd = state;
            switch (ix()[state.ordinal()]) {
                case 1:
                    bVar.ic();
                    return;
                case 2:
                    bVar.ib();
                    return;
                case 3:
                    bVar.hE();
                    return;
                case 4:
                    bVar.hF();
                    return;
                case 5:
                    bVar.hF();
                    return;
                default:
                    return;
            }
        }
    }

    private int getHeadViewTopMargin() {
        return ((LinearLayout.LayoutParams) this.wk.getLayoutParams()).topMargin;
    }

    private int getFootViewBottomMargin() {
        return ((LinearLayout.LayoutParams) this.wl.getLayoutParams()).bottomMargin;
    }

    private void release() {
        if (this.we.showHeaderLoadingLayout()) {
            iu();
        } else if (this.we.showFooterLoadingLayout()) {
            iv();
        }
    }

    private void iu() {
        if (getScrollY() == 0) {
            if (State.RELEASE_TO_REFRESH == this.wd) {
                i(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.wd) {
                i(getHeadViewTopMargin(), this.wq);
            }
        } else if (getScrollY() > 0) {
            if (State.RELEASE_TO_REFRESH == this.wd) {
                scrollTo(0, 0);
                i(getHeadViewTopMargin() - getScrollY(), 0);
            } else if (State.PULL_TO_REFRESH == this.wd) {
                al(getHeadViewTopMargin() - this.wq);
                scrollTo(0, 0);
                a(State.RESET, this.wo);
            }
        } else if (getScrollY() < 0 && State.RESET != this.wd) {
            scrollTo(0, 0);
            if (State.RELEASE_TO_REFRESH == this.wd) {
                i(getHeadViewTopMargin(), 0);
            } else if (State.PULL_TO_REFRESH == this.wd) {
                i(getHeadViewTopMargin(), this.wq);
            }
        }
    }

    private void i(int i, int i2) {
        j jVar = new j(this);
        try {
            f fVar = new f(i, i2, this.wg);
            fVar.g(this.wk);
            fVar.a(jVar);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            jVar.hU();
        }
    }

    private void iv() {
        if (State.RELEASE_TO_REFRESH == this.wd) {
            j(getFootViewBottomMargin(), 0);
        } else if (State.PULL_TO_REFRESH == this.wd) {
            am(0 - getFootViewBottomMargin());
        }
    }

    private void j(int i, int i2) {
        c cVar = new c(i, i2, this.wh);
        cVar.g(this.wl);
        cVar.a(new k(this));
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

        /* JADX DEBUG: Replace access to removed values field (wB) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (wA) with 'values()' method */
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
