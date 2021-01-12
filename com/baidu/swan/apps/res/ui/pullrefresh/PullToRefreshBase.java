package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.core.view.MotionEventCompat;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes8.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private static final boolean DEBUG = b.DEBUG;
    protected HEADERTYPE dwM;
    private a<T> dwN;
    private LoadingLayout dwO;
    private LoadingLayout dwP;
    private int dwQ;
    private int dwR;
    private boolean dwS;
    private boolean dwT;
    private boolean dwU;
    private boolean dwV;
    private boolean dwW;
    private ILoadingLayout.State dwX;
    private ILoadingLayout.State dwY;
    protected T dwZ;
    private FrameLayout dxa;
    private int dxb;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> dxc;
    private int mActivePointerId;
    private float mLastMotionY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes8.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER,
        Common_STYLE_HEADER,
        SWAN_APP_HEADER
    }

    /* loaded from: classes8.dex */
    public interface a<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);

        void b(PullToRefreshBase<V> pullToRefreshBase);
    }

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    protected abstract boolean isReadyForPullDown();

    protected abstract boolean isReadyForPullUp();

    public PullToRefreshBase(Context context, com.baidu.swan.apps.res.ui.pullrefresh.a<T> aVar, HEADERTYPE headertype) {
        super(context);
        this.dwM = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.dwS = true;
        this.dwT = false;
        this.dwU = false;
        this.dwV = true;
        this.dwW = false;
        this.dwX = ILoadingLayout.State.NONE;
        this.dwY = ILoadingLayout.State.NONE;
        this.dxb = -1;
        this.mActivePointerId = -1;
        this.dxc = aVar;
        this.dwM = headertype;
        init(context, null);
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.dwM = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.dwS = true;
        this.dwT = false;
        this.dwU = false;
        this.dwV = true;
        this.dwW = false;
        this.dwX = ILoadingLayout.State.NONE;
        this.dwY = ILoadingLayout.State.NONE;
        this.dxb = -1;
        this.mActivePointerId = -1;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dwM = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.dwS = true;
        this.dwT = false;
        this.dwU = false;
        this.dwV = true;
        this.dwW = false;
        this.dwX = ILoadingLayout.State.NONE;
        this.dwY = ILoadingLayout.State.NONE;
        this.dxb = -1;
        this.mActivePointerId = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mScroller = new Scroller(context);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.dwO = f(context, attributeSet);
        this.dwP = g(context, attributeSet);
        this.dwZ = createRefreshableView(context, attributeSet);
        if (this.dwZ == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.dwZ);
        addHeaderAndFooter(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PullToRefreshBase.this.aGU();
                PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGU() {
        int contentSize = this.dwO != null ? this.dwO.getContentSize() : 0;
        int contentSize2 = this.dwP != null ? this.dwP.getContentSize() : 0;
        int i = contentSize < 0 ? 0 : contentSize;
        int i2 = contentSize2 < 0 ? 0 : contentSize2;
        this.dwQ = i;
        this.dwR = i2;
        int measuredHeight = this.dwO != null ? this.dwO.getMeasuredHeight() : 0;
        int measuredHeight2 = this.dwP != null ? this.dwP.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.dwR;
        }
        setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        aGU();
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
        if (aGW()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.dwW = false;
                    return false;
                } else if (action == 0 || !this.dwW) {
                    int actionIndex = motionEvent.getActionIndex();
                    switch (action) {
                        case 0:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY();
                            this.dwW = false;
                            break;
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                this.dwW = false;
                                return this.dwW;
                            }
                            float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading()) {
                                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.dwW = z;
                                    if (this.dwW && aGV()) {
                                        this.dwZ.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.dwW = z;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY(actionIndex);
                            this.dwW = false;
                            break;
                        case 6:
                            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                            if (motionEvent.getPointerId(action2) == this.mActivePointerId) {
                                this.mActivePointerId = motionEvent.getPointerId(action2 != 0 ? 0 : 1);
                                this.mLastMotionY = (int) motionEvent.getY(i);
                                this.dwW = false;
                                break;
                            }
                            break;
                    }
                    return this.dwW;
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
                if (this.dwW) {
                    this.dwW = false;
                    if (isReadyForPullDown()) {
                        if (this.dwS && this.dwX == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startRefreshing();
                            z = true;
                        } else if (!isPullRefreshing()) {
                            this.dwX = ILoadingLayout.State.RESET;
                            a(ILoadingLayout.State.RESET, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.dwY == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    this.dwW = false;
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
                    this.dwW = false;
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
        this.dwS = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.dwT = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.dwU = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.dwS && this.dwO != null;
    }

    public boolean isPullLoadEnabled() {
        return this.dwT && this.dwP != null;
    }

    public boolean isScrollLoadEnabled() {
        return this.dwU;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.dwN = aVar;
    }

    public void gF(boolean z) {
        k(z, null);
    }

    public void k(boolean z, String str) {
        if (isPullRefreshing()) {
            this.dwX = ILoadingLayout.State.RESET;
            a(ILoadingLayout.State.RESET, true);
            setInterceptTouchEventEnabled(false);
            this.dwO.a(z, str, new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                            PullToRefreshBase.this.dwO.setState(ILoadingLayout.State.RESET);
                        }
                    }, PullToRefreshBase.this.getSmoothScrollDuration());
                    PullToRefreshBase.this.resetHeaderLayout();
                }
            });
        }
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.dxc;
    }

    public T getRefreshableView() {
        return this.dwZ;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.dwO;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.dwP;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.dwO != null) {
            this.dwO.setLastUpdatedLabel(charSequence);
        }
        if (this.dwP != null) {
            this.dwP.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.dxb = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.dwO != null) {
            this.dwO.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.dwO != null) {
            this.dwO.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.dwO != null) {
            this.dwO.setHeaderBigBackground(i);
        }
    }

    public void a(final boolean z, long j, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.4
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.dwO.getRefreshingHeight();
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

    protected boolean aGV() {
        return true;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        aGX();
        LoadingLayout loadingLayout = null;
        switch (this.dwM) {
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
        if (this.dxa != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dxa.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.dxa.requestLayout();
            }
        }
    }

    public void setEmptyView(View view) {
        if (this.dxa != null) {
            this.dxa.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        this.dxa = new FrameLayout(context);
        this.dxa.addView(t, -1, -1);
        addView(this.dxa, new LinearLayout.LayoutParams(-1, getNgWebViewHeightSwitch() ? 10 : -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.dwO;
        LoadingLayout loadingLayout2 = this.dwP;
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
            ao(0, 0);
            if (this.dwO != null) {
                this.dwO.iA(0);
            }
        } else if (this.dxb <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.dxb) {
            ap(0, -((int) f));
            if (this.dwO != null) {
                this.dwO.iA(-getScrollY());
                if (this.dwQ != 0) {
                    this.dwO.onPull(Math.abs(getScrollYValue()) / this.dwQ);
                }
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing()) {
                if (this.dwO != null && abs > this.dwO.getCanRefreshPullLength()) {
                    this.dwX = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.dwX = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.dwO != null) {
                    this.dwO.setState(this.dwX);
                }
                a(this.dwX, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            ao(0, 0);
            return;
        }
        ap(0, -((int) f));
        if (this.dwP != null && this.dwR != 0) {
            this.dwP.onPull(Math.abs(getScrollYValue()) / this.dwR);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.dwR) {
                this.dwY = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.dwY = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.dwP != null) {
                this.dwP.setState(this.dwY);
            }
            a(this.dwY, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.dwO.getRefreshingHeight()) {
            iG(0);
        } else if (isPullRefreshing) {
            iG(-this.dwO.getRefreshingHeight());
        } else {
            iG(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.dwR) {
            iG(0);
        } else if (isPullLoading) {
            iG(this.dwR);
        } else {
            iG(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.dwX == ILoadingLayout.State.REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.dwY == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        gG(true);
    }

    private void gG(boolean z) {
        if (!isPullRefreshing()) {
            this.dwX = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.dwO != null) {
                this.dwO.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.dwN != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.dwN.a(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoading() {
        if (!isPullLoading()) {
            this.dwY = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.dwP != null) {
                this.dwP.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.dwN != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.dwN.b(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    private void ao(int i, int i2) {
        scrollTo(i, i2);
    }

    private void ap(int i, int i2) {
        scrollBy(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getScrollYValue() {
        return getScrollY();
    }

    private void iG(int i) {
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
            this.dwO.iA(-currY);
            this.dwP.onPull(Math.abs(getScrollYValue()) / this.dwR);
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.dwV = z;
    }

    private boolean aGW() {
        return this.dwV;
    }

    protected void aGX() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public static boolean getNgWebViewHeightSwitch() {
        return com.baidu.swan.apps.performance.b.b.aDW() ? com.baidu.swan.apps.performance.b.b.getNgWebViewHeightSwitch() : com.baidu.swan.apps.t.a.awB().getSwitch("swan_app_refresh_ngwebview_height_switch", false);
    }
}
