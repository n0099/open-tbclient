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
/* loaded from: classes11.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private static final boolean DEBUG = b.DEBUG;
    protected HEADERTYPE cwU;
    private a<T> cwV;
    private LoadingLayout cwW;
    private LoadingLayout cwX;
    private int cwY;
    private int cwZ;
    private boolean cxa;
    private boolean cxb;
    private boolean cxc;
    private boolean cxd;
    private boolean cxe;
    private ILoadingLayout.State cxf;
    private ILoadingLayout.State cxg;
    protected T cxh;
    private FrameLayout cxi;
    private int cxj;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> cxk;
    private int mActivePointerId;
    private float mLastMotionY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes11.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER,
        Common_STYLE_HEADER,
        SWAN_APP_HEADER
    }

    /* loaded from: classes11.dex */
    public interface a<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);

        void b(PullToRefreshBase<V> pullToRefreshBase);
    }

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    protected abstract boolean isReadyForPullDown();

    protected abstract boolean isReadyForPullUp();

    public PullToRefreshBase(Context context, com.baidu.swan.apps.res.ui.pullrefresh.a<T> aVar, HEADERTYPE headertype) {
        super(context);
        this.cwU = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.cxa = true;
        this.cxb = false;
        this.cxc = false;
        this.cxd = true;
        this.cxe = false;
        this.cxf = ILoadingLayout.State.NONE;
        this.cxg = ILoadingLayout.State.NONE;
        this.cxj = -1;
        this.mActivePointerId = -1;
        this.cxk = aVar;
        this.cwU = headertype;
        init(context, null);
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.cwU = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.cxa = true;
        this.cxb = false;
        this.cxc = false;
        this.cxd = true;
        this.cxe = false;
        this.cxf = ILoadingLayout.State.NONE;
        this.cxg = ILoadingLayout.State.NONE;
        this.cxj = -1;
        this.mActivePointerId = -1;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cwU = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.cxa = true;
        this.cxb = false;
        this.cxc = false;
        this.cxd = true;
        this.cxe = false;
        this.cxf = ILoadingLayout.State.NONE;
        this.cxg = ILoadingLayout.State.NONE;
        this.cxj = -1;
        this.mActivePointerId = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mScroller = new Scroller(context);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.cwW = e(context, attributeSet);
        this.cwX = f(context, attributeSet);
        this.cxh = createRefreshableView(context, attributeSet);
        if (this.cxh == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.cxh);
        addHeaderAndFooter(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PullToRefreshBase.this.anP();
                PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anP() {
        int contentSize = this.cwW != null ? this.cwW.getContentSize() : 0;
        int contentSize2 = this.cwX != null ? this.cwX.getContentSize() : 0;
        int i = contentSize < 0 ? 0 : contentSize;
        int i2 = contentSize2 < 0 ? 0 : contentSize2;
        this.cwY = i;
        this.cwZ = i2;
        int measuredHeight = this.cwW != null ? this.cwW.getMeasuredHeight() : 0;
        int measuredHeight2 = this.cwX != null ? this.cwX.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.cwZ;
        }
        setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        anP();
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
        if (anR()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.cxe = false;
                    return false;
                } else if (action == 0 || !this.cxe) {
                    int actionIndex = motionEvent.getActionIndex();
                    switch (action) {
                        case 0:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY();
                            this.cxe = false;
                            break;
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                this.cxe = false;
                                return this.cxe;
                            }
                            float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading()) {
                                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.cxe = z;
                                    if (this.cxe && anQ()) {
                                        this.cxh.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.cxe = z;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY(actionIndex);
                            this.cxe = false;
                            break;
                        case 6:
                            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                            if (motionEvent.getPointerId(action2) == this.mActivePointerId) {
                                this.mActivePointerId = motionEvent.getPointerId(action2 != 0 ? 0 : 1);
                                this.mLastMotionY = (int) motionEvent.getY(i);
                                this.cxe = false;
                                break;
                            }
                            break;
                    }
                    return this.cxe;
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
                if (this.cxe) {
                    this.cxe = false;
                    if (isReadyForPullDown()) {
                        if (this.cxa && this.cxf == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startRefreshing();
                            z = true;
                        } else if (!isPullRefreshing()) {
                            this.cxf = ILoadingLayout.State.RESET;
                            a(ILoadingLayout.State.RESET, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.cxg == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    this.cxe = false;
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
                    this.cxe = false;
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
        this.cxa = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.cxb = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.cxc = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.cxa && this.cwW != null;
    }

    public boolean isPullLoadEnabled() {
        return this.cxb && this.cwX != null;
    }

    public boolean isScrollLoadEnabled() {
        return this.cxc;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.cwV = aVar;
    }

    public void eK(boolean z) {
        h(z, null);
    }

    public void h(boolean z, String str) {
        if (isPullRefreshing()) {
            this.cxf = ILoadingLayout.State.RESET;
            a(ILoadingLayout.State.RESET, true);
            setInterceptTouchEventEnabled(false);
            this.cwW.a(z, str, new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                            PullToRefreshBase.this.cwW.setState(ILoadingLayout.State.RESET);
                        }
                    }, PullToRefreshBase.this.getSmoothScrollDuration());
                    PullToRefreshBase.this.resetHeaderLayout();
                }
            });
        }
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.cxk;
    }

    public T getRefreshableView() {
        return this.cxh;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.cwW;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.cwX;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.cwW != null) {
            this.cwW.setLastUpdatedLabel(charSequence);
        }
        if (this.cwX != null) {
            this.cwX.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.cxj = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.cwW != null) {
            this.cwW.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.cwW != null) {
            this.cwW.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.cwW != null) {
            this.cwW.setHeaderBigBackground(i);
        }
    }

    public void a(final boolean z, long j, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.4
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.cwW.getRefreshingHeight();
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

    protected boolean anQ() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        anS();
        LoadingLayout loadingLayout = null;
        switch (this.cwU) {
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
        if (this.cxi != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cxi.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.cxi.requestLayout();
            }
        }
    }

    public void setEmptyView(View view) {
        if (this.cxi != null) {
            this.cxi.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        this.cxi = new FrameLayout(context);
        this.cxi.addView(t, -1, -1);
        addView(this.cxi, new LinearLayout.LayoutParams(-1, com.baidu.swan.apps.u.a.aeU().getSwitch("swan_app_refresh_ngwebview_height_switch", false) ? 10 : -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.cwW;
        LoadingLayout loadingLayout2 = this.cwX;
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
            aj(0, 0);
            if (this.cwW != null) {
                this.cwW.gh(0);
            }
        } else if (this.cxj <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.cxj) {
            ak(0, -((int) f));
            if (this.cwW != null) {
                this.cwW.gh(-getScrollY());
                if (this.cwY != 0) {
                    this.cwW.onPull(Math.abs(getScrollYValue()) / this.cwY);
                }
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing()) {
                if (this.cwW != null && abs > this.cwW.getCanRefreshPullLength()) {
                    this.cxf = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.cxf = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.cwW != null) {
                    this.cwW.setState(this.cxf);
                }
                a(this.cxf, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            aj(0, 0);
            return;
        }
        ak(0, -((int) f));
        if (this.cwX != null && this.cwZ != 0) {
            this.cwX.onPull(Math.abs(getScrollYValue()) / this.cwZ);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.cwZ) {
                this.cxg = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.cxg = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.cwX != null) {
                this.cwX.setState(this.cxg);
            }
            a(this.cxg, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.cwW.getRefreshingHeight()) {
            gm(0);
        } else if (isPullRefreshing) {
            gm(-this.cwW.getRefreshingHeight());
        } else {
            gm(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.cwZ) {
            gm(0);
        } else if (isPullLoading) {
            gm(this.cwZ);
        } else {
            gm(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.cxf == ILoadingLayout.State.REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.cxg == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        eL(true);
    }

    private void eL(boolean z) {
        if (!isPullRefreshing()) {
            this.cxf = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.cwW != null) {
                this.cwW.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.cwV != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.cwV.a(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoading() {
        if (!isPullLoading()) {
            this.cxg = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.cwX != null) {
                this.cwX.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.cwV != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.cwV.b(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    private void aj(int i, int i2) {
        scrollTo(i, i2);
    }

    private void ak(int i, int i2) {
        scrollBy(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getScrollYValue() {
        return getScrollY();
    }

    private void gm(int i) {
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
            this.cwW.gh(-currY);
            this.cwX.onPull(Math.abs(getScrollYValue()) / this.cwZ);
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.cxd = z;
    }

    private boolean anR() {
        return this.cxd;
    }

    protected void anS() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
