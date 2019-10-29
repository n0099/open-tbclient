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
/* loaded from: classes2.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private static final boolean DEBUG = b.DEBUG;
    protected HEADERTYPE bff;
    private a<T> bfg;
    private LoadingLayout bfh;
    private LoadingLayout bfi;
    private int bfj;
    private int bfk;
    private boolean bfl;
    private boolean bfm;
    private boolean bfn;
    private boolean bfo;
    private boolean bfp;
    private ILoadingLayout.State bfq;
    private ILoadingLayout.State bfr;
    protected T bfs;
    private FrameLayout bft;
    private int bfu;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> bfv;
    private int mActivePointerId;
    private float mLastMotionY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes2.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER,
        Common_STYLE_HEADER,
        SWAN_APP_HEADER
    }

    /* loaded from: classes2.dex */
    public interface a<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);

        void b(PullToRefreshBase<V> pullToRefreshBase);
    }

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    protected abstract boolean isReadyForPullDown();

    protected abstract boolean isReadyForPullUp();

    public PullToRefreshBase(Context context, com.baidu.swan.apps.res.ui.pullrefresh.a<T> aVar, HEADERTYPE headertype) {
        super(context);
        this.bff = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.bfl = true;
        this.bfm = false;
        this.bfn = false;
        this.bfo = true;
        this.bfp = false;
        this.bfq = ILoadingLayout.State.NONE;
        this.bfr = ILoadingLayout.State.NONE;
        this.bfu = -1;
        this.mActivePointerId = -1;
        this.bfv = aVar;
        this.bff = headertype;
        init(context, null);
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.bff = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.bfl = true;
        this.bfm = false;
        this.bfn = false;
        this.bfo = true;
        this.bfp = false;
        this.bfq = ILoadingLayout.State.NONE;
        this.bfr = ILoadingLayout.State.NONE;
        this.bfu = -1;
        this.mActivePointerId = -1;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bff = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.bfl = true;
        this.bfm = false;
        this.bfn = false;
        this.bfo = true;
        this.bfp = false;
        this.bfq = ILoadingLayout.State.NONE;
        this.bfr = ILoadingLayout.State.NONE;
        this.bfu = -1;
        this.mActivePointerId = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mScroller = new Scroller(context);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.bfh = f(context, attributeSet);
        this.bfi = g(context, attributeSet);
        this.bfs = createRefreshableView(context, attributeSet);
        if (this.bfs == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.bfs);
        addHeaderAndFooter(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PullToRefreshBase.this.Ps();
                PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ps() {
        int contentSize = this.bfh != null ? this.bfh.getContentSize() : 0;
        int contentSize2 = this.bfi != null ? this.bfi.getContentSize() : 0;
        int i = contentSize < 0 ? 0 : contentSize;
        int i2 = contentSize2 < 0 ? 0 : contentSize2;
        this.bfj = i;
        this.bfk = i2;
        int measuredHeight = this.bfh != null ? this.bfh.getMeasuredHeight() : 0;
        int measuredHeight2 = this.bfi != null ? this.bfi.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.bfk;
        }
        setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Ps();
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
        if (Pu()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.bfp = false;
                    return false;
                } else if (action == 0 || !this.bfp) {
                    int actionIndex = motionEvent.getActionIndex();
                    switch (action) {
                        case 0:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY();
                            this.bfp = false;
                            break;
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                this.bfp = false;
                                return this.bfp;
                            }
                            float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading()) {
                                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.bfp = z;
                                    if (this.bfp && Pt()) {
                                        this.bfs.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.bfp = z;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY(actionIndex);
                            this.bfp = false;
                            break;
                        case 6:
                            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                            if (motionEvent.getPointerId(action2) == this.mActivePointerId) {
                                this.mActivePointerId = motionEvent.getPointerId(action2 != 0 ? 0 : 1);
                                this.mLastMotionY = (int) motionEvent.getY(i);
                                this.bfp = false;
                                break;
                            }
                            break;
                    }
                    return this.bfp;
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
                if (this.bfp) {
                    this.bfp = false;
                    if (isReadyForPullDown()) {
                        if (this.bfl && this.bfq == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startRefreshing();
                            z = true;
                        } else if (!isPullRefreshing()) {
                            this.bfq = ILoadingLayout.State.RESET;
                            a(ILoadingLayout.State.RESET, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.bfr == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    this.bfp = false;
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
                    this.bfp = false;
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
        this.bfl = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.bfm = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.bfn = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.bfl && this.bfh != null;
    }

    public boolean isPullLoadEnabled() {
        return this.bfm && this.bfi != null;
    }

    public boolean isScrollLoadEnabled() {
        return this.bfn;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.bfg = aVar;
    }

    public void ce(boolean z) {
        f(z, (String) null);
    }

    public void f(boolean z, String str) {
        if (isPullRefreshing()) {
            this.bfq = ILoadingLayout.State.RESET;
            a(ILoadingLayout.State.RESET, true);
            setInterceptTouchEventEnabled(false);
            this.bfh.a(z, str, new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                            PullToRefreshBase.this.bfh.setState(ILoadingLayout.State.RESET);
                        }
                    }, PullToRefreshBase.this.getSmoothScrollDuration());
                    PullToRefreshBase.this.resetHeaderLayout();
                }
            });
        }
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.bfv;
    }

    public T getRefreshableView() {
        return this.bfs;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.bfh;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.bfi;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.bfh != null) {
            this.bfh.setLastUpdatedLabel(charSequence);
        }
        if (this.bfi != null) {
            this.bfi.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.bfu = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.bfh != null) {
            this.bfh.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.bfh != null) {
            this.bfh.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.bfh != null) {
            this.bfh.setHeaderBigBackground(i);
        }
    }

    public void a(final boolean z, long j, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.4
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.bfh.getRefreshingHeight();
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

    protected boolean Pt() {
        return true;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        Pv();
        LoadingLayout loadingLayout = null;
        switch (this.bff) {
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

    protected LoadingLayout g(Context context, AttributeSet attributeSet) {
        return new FooterLoadingLayout(context);
    }

    protected int getSmoothScrollDuration() {
        return 300;
    }

    protected void refreshRefreshableViewSize(int i, int i2) {
        if (this.bft != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bft.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.bft.requestLayout();
            }
        }
    }

    public void setEmptyView(View view) {
        if (this.bft != null) {
            this.bft.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        this.bft = new FrameLayout(context);
        this.bft.addView(t, -1, -1);
        addView(this.bft, new LinearLayout.LayoutParams(-1, 10));
    }

    protected void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.bfh;
        LoadingLayout loadingLayout2 = this.bfi;
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
            L(0, 0);
            if (this.bfh != null) {
                this.bfh.dU(0);
            }
        } else if (this.bfu <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.bfu) {
            M(0, -((int) f));
            if (this.bfh != null) {
                this.bfh.dU(-getScrollY());
                if (this.bfj != 0) {
                    this.bfh.onPull(Math.abs(getScrollYValue()) / this.bfj);
                }
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing()) {
                if (abs > this.bfh.getCanRefreshPullLength()) {
                    this.bfq = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.bfq = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.bfh != null) {
                    this.bfh.setState(this.bfq);
                }
                a(this.bfq, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            L(0, 0);
            return;
        }
        M(0, -((int) f));
        if (this.bfi != null && this.bfk != 0) {
            this.bfi.onPull(Math.abs(getScrollYValue()) / this.bfk);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.bfk) {
                this.bfr = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.bfr = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.bfi != null) {
                this.bfi.setState(this.bfr);
            }
            a(this.bfr, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.bfh.getRefreshingHeight()) {
            ea(0);
        } else if (isPullRefreshing) {
            ea(-this.bfh.getRefreshingHeight());
        } else {
            ea(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.bfk) {
            ea(0);
        } else if (isPullLoading) {
            ea(this.bfk);
        } else {
            ea(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.bfq == ILoadingLayout.State.REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.bfr == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        cf(true);
    }

    private void cf(boolean z) {
        if (!isPullRefreshing()) {
            this.bfq = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.bfh != null) {
                this.bfh.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.bfg != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.bfg.a(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoading() {
        if (!isPullLoading()) {
            this.bfr = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.bfi != null) {
                this.bfi.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.bfg != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.bfg.b(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    private void L(int i, int i2) {
        scrollTo(i, i2);
    }

    private void M(int i, int i2) {
        scrollBy(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getScrollYValue() {
        return getScrollY();
    }

    private void ea(int i) {
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
            this.bfh.dU(-currY);
            this.bfi.onPull(Math.abs(getScrollYValue()) / this.bfk);
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.bfo = z;
    }

    private boolean Pu() {
        return this.bfo;
    }

    protected void Pv() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
