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
    protected HEADERTYPE aKL;
    private a<T> aKM;
    private LoadingLayout aKN;
    private LoadingLayout aKO;
    private int aKP;
    private int aKQ;
    private boolean aKR;
    private boolean aKS;
    private boolean aKT;
    private boolean aKU;
    private boolean aKV;
    private ILoadingLayout.State aKW;
    private ILoadingLayout.State aKX;
    protected T aKY;
    private FrameLayout aKZ;
    private int aLa;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> aLb;
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
        this.aKL = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.aKR = true;
        this.aKS = false;
        this.aKT = false;
        this.aKU = true;
        this.aKV = false;
        this.aKW = ILoadingLayout.State.NONE;
        this.aKX = ILoadingLayout.State.NONE;
        this.aLa = -1;
        this.mActivePointerId = -1;
        this.aLb = aVar;
        this.aKL = headertype;
        init(context, null);
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.aKL = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.aKR = true;
        this.aKS = false;
        this.aKT = false;
        this.aKU = true;
        this.aKV = false;
        this.aKW = ILoadingLayout.State.NONE;
        this.aKX = ILoadingLayout.State.NONE;
        this.aLa = -1;
        this.mActivePointerId = -1;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKL = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.aKR = true;
        this.aKS = false;
        this.aKT = false;
        this.aKU = true;
        this.aKV = false;
        this.aKW = ILoadingLayout.State.NONE;
        this.aKX = ILoadingLayout.State.NONE;
        this.aLa = -1;
        this.mActivePointerId = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mScroller = new Scroller(context);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.aKN = f(context, attributeSet);
        this.aKO = g(context, attributeSet);
        this.aKY = createRefreshableView(context, attributeSet);
        if (this.aKY == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.aKY);
        addHeaderAndFooter(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PullToRefreshBase.this.JI();
                PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JI() {
        int contentSize = this.aKN != null ? this.aKN.getContentSize() : 0;
        int contentSize2 = this.aKO != null ? this.aKO.getContentSize() : 0;
        int i = contentSize < 0 ? 0 : contentSize;
        int i2 = contentSize2 < 0 ? 0 : contentSize2;
        this.aKP = i;
        this.aKQ = i2;
        int measuredHeight = this.aKN != null ? this.aKN.getMeasuredHeight() : 0;
        int measuredHeight2 = this.aKO != null ? this.aKO.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.aKQ;
        }
        setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        JI();
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
        if (JK()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.aKV = false;
                    return false;
                } else if (action == 0 || !this.aKV) {
                    int actionIndex = motionEvent.getActionIndex();
                    switch (action) {
                        case 0:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY();
                            this.aKV = false;
                            break;
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                this.aKV = false;
                                return this.aKV;
                            }
                            float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading()) {
                                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.aKV = z;
                                    if (this.aKV && JJ()) {
                                        this.aKY.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.aKV = z;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY(actionIndex);
                            this.aKV = false;
                            break;
                        case 6:
                            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                            if (motionEvent.getPointerId(action2) == this.mActivePointerId) {
                                this.mActivePointerId = motionEvent.getPointerId(action2 != 0 ? 0 : 1);
                                this.mLastMotionY = (int) motionEvent.getY(i);
                                this.aKV = false;
                                break;
                            }
                            break;
                    }
                    return this.aKV;
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
                if (this.aKV) {
                    this.aKV = false;
                    if (isReadyForPullDown()) {
                        if (this.aKR && this.aKW == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startRefreshing();
                            z = true;
                        } else if (!isPullRefreshing()) {
                            this.aKW = ILoadingLayout.State.RESET;
                            a(ILoadingLayout.State.RESET, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.aKX == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    this.aKV = false;
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
                    this.aKV = false;
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
        this.aKR = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.aKS = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.aKT = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.aKR && this.aKN != null;
    }

    public boolean isPullLoadEnabled() {
        return this.aKS && this.aKO != null;
    }

    public boolean isScrollLoadEnabled() {
        return this.aKT;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.aKM = aVar;
    }

    public void bK(boolean z) {
        e(z, null);
    }

    public void e(boolean z, String str) {
        if (isPullRefreshing()) {
            this.aKW = ILoadingLayout.State.RESET;
            a(ILoadingLayout.State.RESET, true);
            setInterceptTouchEventEnabled(false);
            this.aKN.a(z, str, new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                            PullToRefreshBase.this.aKN.setState(ILoadingLayout.State.RESET);
                        }
                    }, PullToRefreshBase.this.getSmoothScrollDuration());
                    PullToRefreshBase.this.resetHeaderLayout();
                }
            });
        }
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.aLb;
    }

    public T getRefreshableView() {
        return this.aKY;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.aKN;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.aKO;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.aKN != null) {
            this.aKN.setLastUpdatedLabel(charSequence);
        }
        if (this.aKO != null) {
            this.aKO.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.aLa = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.aKN != null) {
            this.aKN.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.aKN != null) {
            this.aKN.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.aKN != null) {
            this.aKN.setHeaderBigBackground(i);
        }
    }

    public void a(final boolean z, long j, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.4
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.aKN.getRefreshingHeight();
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

    protected boolean JJ() {
        return true;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        JL();
        LoadingLayout loadingLayout = null;
        switch (this.aKL) {
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
        if (this.aKZ != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aKZ.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.aKZ.requestLayout();
            }
        }
    }

    public void setEmptyView(View view) {
        if (this.aKZ != null) {
            this.aKZ.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        this.aKZ = new FrameLayout(context);
        this.aKZ.addView(t, -1, -1);
        addView(this.aKZ, new LinearLayout.LayoutParams(-1, 10));
    }

    protected void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.aKN;
        LoadingLayout loadingLayout2 = this.aKO;
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
            C(0, 0);
            if (this.aKN != null) {
                this.aKN.cV(0);
            }
        } else if (this.aLa <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.aLa) {
            D(0, -((int) f));
            if (this.aKN != null) {
                this.aKN.cV(-getScrollY());
                if (this.aKP != 0) {
                    this.aKN.onPull(Math.abs(getScrollYValue()) / this.aKP);
                }
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing()) {
                if (abs > this.aKN.getCanRefreshPullLength()) {
                    this.aKW = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.aKW = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.aKN != null) {
                    this.aKN.setState(this.aKW);
                }
                a(this.aKW, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            C(0, 0);
            return;
        }
        D(0, -((int) f));
        if (this.aKO != null && this.aKQ != 0) {
            this.aKO.onPull(Math.abs(getScrollYValue()) / this.aKQ);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.aKQ) {
                this.aKX = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.aKX = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.aKO != null) {
                this.aKO.setState(this.aKX);
            }
            a(this.aKX, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.aKN.getRefreshingHeight()) {
            db(0);
        } else if (isPullRefreshing) {
            db(-this.aKN.getRefreshingHeight());
        } else {
            db(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.aKQ) {
            db(0);
        } else if (isPullLoading) {
            db(this.aKQ);
        } else {
            db(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.aKW == ILoadingLayout.State.REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.aKX == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        bL(true);
    }

    private void bL(boolean z) {
        if (!isPullRefreshing()) {
            this.aKW = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.aKN != null) {
                this.aKN.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.aKM != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.aKM.a(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoading() {
        if (!isPullLoading()) {
            this.aKX = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.aKO != null) {
                this.aKO.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.aKM != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.aKM.b(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    private void C(int i, int i2) {
        scrollTo(i, i2);
    }

    private void D(int i, int i2) {
        scrollBy(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getScrollYValue() {
        return getScrollY();
    }

    private void db(int i) {
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
            this.aKN.cV(-currY);
            this.aKO.onPull(Math.abs(getScrollYValue()) / this.aKQ);
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.aKU = z;
    }

    private boolean JK() {
        return this.aKU;
    }

    protected void JL() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
