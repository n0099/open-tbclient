package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes25.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private static final boolean DEBUG = b.DEBUG;
    private ILoadingLayout.State dvA;
    private ILoadingLayout.State dvB;
    protected T dvC;
    private FrameLayout dvD;
    private int dvE;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> dvF;
    protected HEADERTYPE dvp;
    private a<T> dvq;
    private LoadingLayout dvr;
    private LoadingLayout dvs;
    private int dvt;
    private int dvu;
    private boolean dvv;
    private boolean dvw;
    private boolean dvx;
    private boolean dvy;
    private boolean dvz;
    private int mActivePointerId;
    private float mLastMotionY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes25.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER,
        Common_STYLE_HEADER,
        SWAN_APP_HEADER
    }

    /* loaded from: classes25.dex */
    public interface a<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);

        void b(PullToRefreshBase<V> pullToRefreshBase);
    }

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    protected abstract boolean isReadyForPullDown();

    protected abstract boolean isReadyForPullUp();

    public PullToRefreshBase(Context context, com.baidu.swan.apps.res.ui.pullrefresh.a<T> aVar, HEADERTYPE headertype) {
        super(context);
        this.dvp = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.dvv = true;
        this.dvw = false;
        this.dvx = false;
        this.dvy = true;
        this.dvz = false;
        this.dvA = ILoadingLayout.State.NONE;
        this.dvB = ILoadingLayout.State.NONE;
        this.dvE = -1;
        this.mActivePointerId = -1;
        this.dvF = aVar;
        this.dvp = headertype;
        init(context, null);
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.dvp = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.dvv = true;
        this.dvw = false;
        this.dvx = false;
        this.dvy = true;
        this.dvz = false;
        this.dvA = ILoadingLayout.State.NONE;
        this.dvB = ILoadingLayout.State.NONE;
        this.dvE = -1;
        this.mActivePointerId = -1;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dvp = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.dvv = true;
        this.dvw = false;
        this.dvx = false;
        this.dvy = true;
        this.dvz = false;
        this.dvA = ILoadingLayout.State.NONE;
        this.dvB = ILoadingLayout.State.NONE;
        this.dvE = -1;
        this.mActivePointerId = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mScroller = new Scroller(context);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.dvr = e(context, attributeSet);
        this.dvs = f(context, attributeSet);
        this.dvC = createRefreshableView(context, attributeSet);
        if (this.dvC == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.dvC);
        addHeaderAndFooter(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PullToRefreshBase.this.aJd();
                PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJd() {
        int contentSize = this.dvr != null ? this.dvr.getContentSize() : 0;
        int contentSize2 = this.dvs != null ? this.dvs.getContentSize() : 0;
        int i = contentSize < 0 ? 0 : contentSize;
        int i2 = contentSize2 < 0 ? 0 : contentSize2;
        this.dvt = i;
        this.dvu = i2;
        int measuredHeight = this.dvr != null ? this.dvr.getMeasuredHeight() : 0;
        int measuredHeight2 = this.dvs != null ? this.dvs.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.dvu;
        }
        setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        aJd();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.2
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (1 != i) {
            throw new IllegalArgumentException("This class only supports VERTICAL orientation.");
        }
        super.setOrientation(i);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i;
        boolean z = false;
        if (aJf()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.dvz = false;
                    return false;
                } else if (action == 0 || !this.dvz) {
                    int actionIndex = motionEvent.getActionIndex();
                    switch (action) {
                        case 0:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY();
                            this.dvz = false;
                            break;
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                this.dvz = false;
                                return this.dvz;
                            }
                            float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading()) {
                                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.dvz = z;
                                    if (this.dvz && aJe()) {
                                        this.dvC.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.dvz = z;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY(actionIndex);
                            this.dvz = false;
                            break;
                        case 6:
                            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                            if (motionEvent.getPointerId(action2) == this.mActivePointerId) {
                                this.mActivePointerId = motionEvent.getPointerId(action2 != 0 ? 0 : 1);
                                this.mLastMotionY = (int) motionEvent.getY(i);
                                this.dvz = false;
                                break;
                            }
                            break;
                    }
                    return this.dvz;
                } else {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        boolean z = false;
        int actionIndex = motionEvent.getActionIndex();
        switch (motionEvent.getAction()) {
            case 0:
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                this.mLastMotionY = motionEvent.getY();
                return false;
            case 1:
            case 3:
                if (this.dvz) {
                    this.dvz = false;
                    if (isReadyForPullDown()) {
                        if (this.dvv && this.dvA == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startRefreshing();
                            z = true;
                        } else if (!isPullRefreshing()) {
                            this.dvA = ILoadingLayout.State.RESET;
                            a(ILoadingLayout.State.RESET, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.dvB == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startLoading();
                            z = true;
                        }
                        resetFooterLayout();
                        return z;
                    } else {
                        return false;
                    }
                }
                return false;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex < 0) {
                    this.dvz = false;
                    return false;
                }
                float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                    pullHeaderLayout(y / 1.5f);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / 1.5f);
                    return true;
                } else {
                    this.dvz = false;
                    return false;
                }
            case 4:
            default:
                return false;
            case 5:
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                this.mLastMotionY = motionEvent.getY(actionIndex);
                return false;
            case 6:
                int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                if (motionEvent.getPointerId(action) == this.mActivePointerId) {
                    this.mActivePointerId = motionEvent.getPointerId(action != 0 ? 0 : 1);
                    this.mLastMotionY = (int) motionEvent.getY(i);
                    return false;
                }
                return false;
        }
    }

    public void setPullRefreshEnabled(boolean z) {
        this.dvv = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.dvw = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.dvx = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.dvv && this.dvr != null;
    }

    public boolean isPullLoadEnabled() {
        return this.dvw && this.dvs != null;
    }

    public boolean isScrollLoadEnabled() {
        return this.dvx;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.dvq = aVar;
    }

    public void gA(boolean z) {
        k(z, null);
    }

    public void k(boolean z, String str) {
        if (isPullRefreshing()) {
            this.dvA = ILoadingLayout.State.RESET;
            a(ILoadingLayout.State.RESET, true);
            setInterceptTouchEventEnabled(false);
            this.dvr.a(z, str, new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                            PullToRefreshBase.this.dvr.setState(ILoadingLayout.State.RESET);
                        }
                    }, PullToRefreshBase.this.getSmoothScrollDuration());
                    PullToRefreshBase.this.resetHeaderLayout();
                }
            });
        }
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.dvF;
    }

    public T getRefreshableView() {
        return this.dvC;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.dvr;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.dvs;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.dvr != null) {
            this.dvr.setLastUpdatedLabel(charSequence);
        }
        if (this.dvs != null) {
            this.dvs.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.dvE = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.dvr != null) {
            this.dvr.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.dvr != null) {
            this.dvr.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.dvr != null) {
            this.dvr.setHeaderBigBackground(i);
        }
    }

    public void a(final boolean z, long j, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.4
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.dvr.getRefreshingHeight();
                int i2 = z ? 300 : 0;
                PullToRefreshBase.this.startRefreshing();
                PullToRefreshBase.this.smoothScrollTo(i, i2);
                if (runnable != null) {
                    PullToRefreshBase.this.post(runnable);
                }
            }
        }, j);
    }

    public void doPullRefreshing(boolean z, long j) {
        a(z, j, (Runnable) null);
    }

    protected boolean aJe() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        aJg();
        LoadingLayout loadingLayout = null;
        switch (this.dvp) {
            case STANDARD_HEADER:
                loadingLayout = new HeaderLoadingLayout(context);
                break;
            case BIG_BG_HEADER:
                loadingLayout = new BigBgHeaderLoadingLayout(context);
                break;
            case ROTATE_HEADER:
                loadingLayout = new RotateLoadingLayout(context);
                break;
            case Common_STYLE_HEADER:
                loadingLayout = new CommonHeaderLoadingLayout(context);
                break;
            case SWAN_APP_HEADER:
                loadingLayout = new NeutralHeaderLoadingLayout(context);
                break;
        }
        if (loadingLayout == null) {
            return new HeaderLoadingLayout(context);
        }
        return loadingLayout;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        return new FooterLoadingLayout(context);
    }

    protected int getSmoothScrollDuration() {
        return 300;
    }

    protected void refreshRefreshableViewSize(int i, int i2) {
        if (this.dvD != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dvD.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.dvD.requestLayout();
            }
        }
    }

    public void setEmptyView(View view) {
        if (this.dvD != null) {
            this.dvD.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        this.dvD = new FrameLayout(context);
        this.dvD.addView(t, -1, -1);
        addView(this.dvD, new LinearLayout.LayoutParams(-1, getNgWebViewHeightSwitch() ? 10 : -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.dvr;
        LoadingLayout loadingLayout2 = this.dvs;
        if (loadingLayout != null) {
            if (this == loadingLayout.getParent()) {
                removeView(loadingLayout);
            }
            addView(loadingLayout, 0, layoutParams);
        }
        if (loadingLayout2 != null) {
            if (this == loadingLayout2.getParent()) {
                removeView(loadingLayout2);
            }
            addView(loadingLayout2, -1, layoutParams);
        }
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            as(0, 0);
            if (this.dvr != null) {
                this.dvr.kh(0);
            }
        } else if (this.dvE <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.dvE) {
            at(0, -((int) f));
            if (this.dvr != null) {
                this.dvr.kh(-getScrollY());
                if (this.dvt != 0) {
                    this.dvr.onPull(Math.abs(getScrollYValue()) / this.dvt);
                }
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing()) {
                if (this.dvr != null && abs > this.dvr.getCanRefreshPullLength()) {
                    this.dvA = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.dvA = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.dvr != null) {
                    this.dvr.setState(this.dvA);
                }
                a(this.dvA, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            as(0, 0);
            return;
        }
        at(0, -((int) f));
        if (this.dvs != null && this.dvu != 0) {
            this.dvs.onPull(Math.abs(getScrollYValue()) / this.dvu);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.dvu) {
                this.dvB = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.dvB = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.dvs != null) {
                this.dvs.setState(this.dvB);
            }
            a(this.dvB, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.dvr.getRefreshingHeight()) {
            kn(0);
        } else if (isPullRefreshing) {
            kn(-this.dvr.getRefreshingHeight());
        } else {
            kn(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.dvu) {
            kn(0);
        } else if (isPullLoading) {
            kn(this.dvu);
        } else {
            kn(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.dvA == ILoadingLayout.State.REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.dvB == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        gB(true);
    }

    private void gB(boolean z) {
        if (!isPullRefreshing()) {
            this.dvA = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.dvr != null) {
                this.dvr.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.dvq != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.dvq.a(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoading() {
        if (!isPullLoading()) {
            this.dvB = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.dvs != null) {
                this.dvs.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.dvq != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.dvq.b(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    private void as(int i, int i2) {
        scrollTo(i, i2);
    }

    private void at(int i, int i2) {
        scrollBy(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getScrollYValue() {
        return getScrollY();
    }

    private void kn(int i) {
        smoothScrollTo(i, getSmoothScrollDuration());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void smoothScrollTo(int i, int i2) {
        this.mScroller.forceFinished(true);
        int scrollY = getScrollY();
        int i3 = i - scrollY;
        if (i3 != 0) {
            this.mScroller.startScroll(0, scrollY, 0, i3, i2);
            postInvalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            scrollTo(0, currY);
            this.dvr.kh(-currY);
            this.dvs.onPull(Math.abs(getScrollYValue()) / this.dvu);
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.dvy = z;
    }

    private boolean aJf() {
        return this.dvy;
    }

    protected void aJg() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public static boolean getNgWebViewHeightSwitch() {
        return com.baidu.swan.apps.performance.b.b.aGw() ? com.baidu.swan.apps.performance.b.b.getNgWebViewHeightSwitch() : com.baidu.swan.apps.t.a.azd().getSwitch("swan_app_refresh_ngwebview_height_switch", false);
    }
}
