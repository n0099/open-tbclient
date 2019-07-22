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
    private boolean aLA;
    private boolean aLB;
    private boolean aLC;
    private boolean aLD;
    private ILoadingLayout.State aLE;
    private ILoadingLayout.State aLF;
    protected T aLG;
    private FrameLayout aLH;
    private int aLI;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> aLJ;
    protected HEADERTYPE aLt;
    private a<T> aLu;
    private LoadingLayout aLv;
    private LoadingLayout aLw;
    private int aLx;
    private int aLy;
    private boolean aLz;
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
        this.aLt = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.aLz = true;
        this.aLA = false;
        this.aLB = false;
        this.aLC = true;
        this.aLD = false;
        this.aLE = ILoadingLayout.State.NONE;
        this.aLF = ILoadingLayout.State.NONE;
        this.aLI = -1;
        this.mActivePointerId = -1;
        this.aLJ = aVar;
        this.aLt = headertype;
        init(context, null);
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.aLt = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.aLz = true;
        this.aLA = false;
        this.aLB = false;
        this.aLC = true;
        this.aLD = false;
        this.aLE = ILoadingLayout.State.NONE;
        this.aLF = ILoadingLayout.State.NONE;
        this.aLI = -1;
        this.mActivePointerId = -1;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLt = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.aLz = true;
        this.aLA = false;
        this.aLB = false;
        this.aLC = true;
        this.aLD = false;
        this.aLE = ILoadingLayout.State.NONE;
        this.aLF = ILoadingLayout.State.NONE;
        this.aLI = -1;
        this.mActivePointerId = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mScroller = new Scroller(context);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.aLv = f(context, attributeSet);
        this.aLw = g(context, attributeSet);
        this.aLG = createRefreshableView(context, attributeSet);
        if (this.aLG == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.aLG);
        addHeaderAndFooter(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PullToRefreshBase.this.Kv();
                PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kv() {
        int contentSize = this.aLv != null ? this.aLv.getContentSize() : 0;
        int contentSize2 = this.aLw != null ? this.aLw.getContentSize() : 0;
        int i = contentSize < 0 ? 0 : contentSize;
        int i2 = contentSize2 < 0 ? 0 : contentSize2;
        this.aLx = i;
        this.aLy = i2;
        int measuredHeight = this.aLv != null ? this.aLv.getMeasuredHeight() : 0;
        int measuredHeight2 = this.aLw != null ? this.aLw.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.aLy;
        }
        setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Kv();
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
        if (Kx()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.aLD = false;
                    return false;
                } else if (action == 0 || !this.aLD) {
                    int actionIndex = motionEvent.getActionIndex();
                    switch (action) {
                        case 0:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY();
                            this.aLD = false;
                            break;
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                this.aLD = false;
                                return this.aLD;
                            }
                            float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading()) {
                                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.aLD = z;
                                    if (this.aLD && Kw()) {
                                        this.aLG.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.aLD = z;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY(actionIndex);
                            this.aLD = false;
                            break;
                        case 6:
                            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                            if (motionEvent.getPointerId(action2) == this.mActivePointerId) {
                                this.mActivePointerId = motionEvent.getPointerId(action2 != 0 ? 0 : 1);
                                this.mLastMotionY = (int) motionEvent.getY(i);
                                this.aLD = false;
                                break;
                            }
                            break;
                    }
                    return this.aLD;
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
                if (this.aLD) {
                    this.aLD = false;
                    if (isReadyForPullDown()) {
                        if (this.aLz && this.aLE == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startRefreshing();
                            z = true;
                        } else if (!isPullRefreshing()) {
                            this.aLE = ILoadingLayout.State.RESET;
                            a(ILoadingLayout.State.RESET, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.aLF == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    this.aLD = false;
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
                    this.aLD = false;
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
        this.aLz = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.aLA = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.aLB = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.aLz && this.aLv != null;
    }

    public boolean isPullLoadEnabled() {
        return this.aLA && this.aLw != null;
    }

    public boolean isScrollLoadEnabled() {
        return this.aLB;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.aLu = aVar;
    }

    public void bN(boolean z) {
        e(z, null);
    }

    public void e(boolean z, String str) {
        if (isPullRefreshing()) {
            this.aLE = ILoadingLayout.State.RESET;
            a(ILoadingLayout.State.RESET, true);
            setInterceptTouchEventEnabled(false);
            this.aLv.a(z, str, new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                            PullToRefreshBase.this.aLv.setState(ILoadingLayout.State.RESET);
                        }
                    }, PullToRefreshBase.this.getSmoothScrollDuration());
                    PullToRefreshBase.this.resetHeaderLayout();
                }
            });
        }
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.aLJ;
    }

    public T getRefreshableView() {
        return this.aLG;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.aLv;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.aLw;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.aLv != null) {
            this.aLv.setLastUpdatedLabel(charSequence);
        }
        if (this.aLw != null) {
            this.aLw.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.aLI = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.aLv != null) {
            this.aLv.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.aLv != null) {
            this.aLv.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.aLv != null) {
            this.aLv.setHeaderBigBackground(i);
        }
    }

    public void a(final boolean z, long j, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.4
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.aLv.getRefreshingHeight();
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

    protected boolean Kw() {
        return true;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        Ky();
        LoadingLayout loadingLayout = null;
        switch (this.aLt) {
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
        if (this.aLH != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aLH.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.aLH.requestLayout();
            }
        }
    }

    public void setEmptyView(View view) {
        if (this.aLH != null) {
            this.aLH.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        this.aLH = new FrameLayout(context);
        this.aLH.addView(t, -1, -1);
        addView(this.aLH, new LinearLayout.LayoutParams(-1, 10));
    }

    protected void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.aLv;
        LoadingLayout loadingLayout2 = this.aLw;
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
            F(0, 0);
            if (this.aLv != null) {
                this.aLv.cY(0);
            }
        } else if (this.aLI <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.aLI) {
            G(0, -((int) f));
            if (this.aLv != null) {
                this.aLv.cY(-getScrollY());
                if (this.aLx != 0) {
                    this.aLv.onPull(Math.abs(getScrollYValue()) / this.aLx);
                }
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing()) {
                if (abs > this.aLv.getCanRefreshPullLength()) {
                    this.aLE = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.aLE = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.aLv != null) {
                    this.aLv.setState(this.aLE);
                }
                a(this.aLE, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            F(0, 0);
            return;
        }
        G(0, -((int) f));
        if (this.aLw != null && this.aLy != 0) {
            this.aLw.onPull(Math.abs(getScrollYValue()) / this.aLy);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.aLy) {
                this.aLF = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.aLF = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.aLw != null) {
                this.aLw.setState(this.aLF);
            }
            a(this.aLF, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.aLv.getRefreshingHeight()) {
            de(0);
        } else if (isPullRefreshing) {
            de(-this.aLv.getRefreshingHeight());
        } else {
            de(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.aLy) {
            de(0);
        } else if (isPullLoading) {
            de(this.aLy);
        } else {
            de(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.aLE == ILoadingLayout.State.REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.aLF == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        bO(true);
    }

    private void bO(boolean z) {
        if (!isPullRefreshing()) {
            this.aLE = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.aLv != null) {
                this.aLv.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.aLu != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.aLu.a(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoading() {
        if (!isPullLoading()) {
            this.aLF = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.aLw != null) {
                this.aLw.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.aLu != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.aLu.b(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    private void F(int i, int i2) {
        scrollTo(i, i2);
    }

    private void G(int i, int i2) {
        scrollBy(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getScrollYValue() {
        return getScrollY();
    }

    private void de(int i) {
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
            this.aLv.cY(-currY);
            this.aLw.onPull(Math.abs(getScrollYValue()) / this.aLy);
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.aLC = z;
    }

    private boolean Kx() {
        return this.aLC;
    }

    protected void Ky() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
