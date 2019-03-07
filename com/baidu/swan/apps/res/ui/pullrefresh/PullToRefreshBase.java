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
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes2.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private static final boolean DEBUG = c.DEBUG;
    protected HEADERTYPE aIN;
    private a<T> aIO;
    private LoadingLayout aIP;
    private LoadingLayout aIQ;
    private int aIR;
    private int aIS;
    private boolean aIT;
    private boolean aIU;
    private boolean aIV;
    private boolean aIW;
    private boolean aIX;
    private ILoadingLayout.State aIY;
    private ILoadingLayout.State aIZ;
    protected T aJa;
    private FrameLayout aJb;
    private int aJc;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> aJd;
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
        this.aIN = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.aIT = true;
        this.aIU = false;
        this.aIV = false;
        this.aIW = true;
        this.aIX = false;
        this.aIY = ILoadingLayout.State.NONE;
        this.aIZ = ILoadingLayout.State.NONE;
        this.aJc = -1;
        this.mActivePointerId = -1;
        this.aJd = aVar;
        this.aIN = headertype;
        init(context, null);
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.aIN = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.aIT = true;
        this.aIU = false;
        this.aIV = false;
        this.aIW = true;
        this.aIX = false;
        this.aIY = ILoadingLayout.State.NONE;
        this.aIZ = ILoadingLayout.State.NONE;
        this.aJc = -1;
        this.mActivePointerId = -1;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIN = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.aIT = true;
        this.aIU = false;
        this.aIV = false;
        this.aIW = true;
        this.aIX = false;
        this.aIY = ILoadingLayout.State.NONE;
        this.aIZ = ILoadingLayout.State.NONE;
        this.aJc = -1;
        this.mActivePointerId = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mScroller = new Scroller(context);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.aIP = f(context, attributeSet);
        this.aIQ = g(context, attributeSet);
        this.aJa = createRefreshableView(context, attributeSet);
        if (this.aJa == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.aJa);
        addHeaderAndFooter(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PullToRefreshBase.this.Hu();
                PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hu() {
        int contentSize = this.aIP != null ? this.aIP.getContentSize() : 0;
        int contentSize2 = this.aIQ != null ? this.aIQ.getContentSize() : 0;
        int i = contentSize < 0 ? 0 : contentSize;
        int i2 = contentSize2 < 0 ? 0 : contentSize2;
        this.aIR = i;
        this.aIS = i2;
        int measuredHeight = this.aIP != null ? this.aIP.getMeasuredHeight() : 0;
        int measuredHeight2 = this.aIQ != null ? this.aIQ.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.aIS;
        }
        setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Hu();
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
        if (Hw()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.aIX = false;
                    return false;
                } else if (action == 0 || !this.aIX) {
                    int actionIndex = motionEvent.getActionIndex();
                    switch (action) {
                        case 0:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY();
                            this.aIX = false;
                            break;
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                this.aIX = false;
                                return this.aIX;
                            }
                            float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading()) {
                                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.aIX = z;
                                    if (this.aIX && Hv()) {
                                        this.aJa.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.aIX = z;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY(actionIndex);
                            this.aIX = false;
                            break;
                        case 6:
                            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                            if (motionEvent.getPointerId(action2) == this.mActivePointerId) {
                                this.mActivePointerId = motionEvent.getPointerId(action2 != 0 ? 0 : 1);
                                this.mLastMotionY = (int) motionEvent.getY(i);
                                this.aIX = false;
                                break;
                            }
                            break;
                    }
                    return this.aIX;
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
                if (this.aIX) {
                    this.aIX = false;
                    if (isReadyForPullDown()) {
                        if (this.aIT && this.aIY == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startRefreshing();
                            z = true;
                        } else if (!isPullRefreshing()) {
                            this.aIY = ILoadingLayout.State.RESET;
                            a(ILoadingLayout.State.RESET, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.aIZ == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    this.aIX = false;
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
                    this.aIX = false;
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
        this.aIT = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.aIU = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.aIV = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.aIT && this.aIP != null;
    }

    public boolean isPullLoadEnabled() {
        return this.aIU && this.aIQ != null;
    }

    public boolean isScrollLoadEnabled() {
        return this.aIV;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.aIO = aVar;
    }

    public void bB(boolean z) {
        e(z, null);
    }

    public void e(boolean z, String str) {
        if (isPullRefreshing()) {
            this.aIY = ILoadingLayout.State.RESET;
            a(ILoadingLayout.State.RESET, true);
            setInterceptTouchEventEnabled(false);
            this.aIP.a(z, str, new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                            PullToRefreshBase.this.aIP.setState(ILoadingLayout.State.RESET);
                        }
                    }, PullToRefreshBase.this.getSmoothScrollDuration());
                    PullToRefreshBase.this.resetHeaderLayout();
                }
            });
        }
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.aJd;
    }

    public T getRefreshableView() {
        return this.aJa;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.aIP;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.aIQ;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.aIP != null) {
            this.aIP.setLastUpdatedLabel(charSequence);
        }
        if (this.aIQ != null) {
            this.aIQ.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.aJc = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.aIP != null) {
            this.aIP.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.aIP != null) {
            this.aIP.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.aIP != null) {
            this.aIP.setHeaderBigBackground(i);
        }
    }

    public void a(final boolean z, long j, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.4
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.aIP.getRefreshingHeight();
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

    protected boolean Hv() {
        return true;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        Hx();
        LoadingLayout loadingLayout = null;
        switch (this.aIN) {
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
        if (this.aJb != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJb.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.aJb.requestLayout();
            }
        }
    }

    public void setEmptyView(View view) {
        if (this.aJb != null) {
            this.aJb.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        this.aJb = new FrameLayout(context);
        this.aJb.addView(t, -1, -1);
        addView(this.aJb, new LinearLayout.LayoutParams(-1, 10));
    }

    protected void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.aIP;
        LoadingLayout loadingLayout2 = this.aIQ;
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
            E(0, 0);
            if (this.aIP != null) {
                this.aIP.cR(0);
            }
        } else if (this.aJc <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.aJc) {
            F(0, -((int) f));
            if (this.aIP != null) {
                this.aIP.cR(-getScrollY());
                if (this.aIR != 0) {
                    this.aIP.onPull(Math.abs(getScrollYValue()) / this.aIR);
                }
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing()) {
                if (abs > this.aIP.getCanRefreshPullLength()) {
                    this.aIY = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.aIY = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.aIP != null) {
                    this.aIP.setState(this.aIY);
                }
                a(this.aIY, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            E(0, 0);
            return;
        }
        F(0, -((int) f));
        if (this.aIQ != null && this.aIS != 0) {
            this.aIQ.onPull(Math.abs(getScrollYValue()) / this.aIS);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.aIS) {
                this.aIZ = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.aIZ = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.aIQ != null) {
                this.aIQ.setState(this.aIZ);
            }
            a(this.aIZ, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.aIP.getRefreshingHeight()) {
            cX(0);
        } else if (isPullRefreshing) {
            cX(-this.aIP.getRefreshingHeight());
        } else {
            cX(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.aIS) {
            cX(0);
        } else if (isPullLoading) {
            cX(this.aIS);
        } else {
            cX(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.aIY == ILoadingLayout.State.REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.aIZ == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        bC(true);
    }

    private void bC(boolean z) {
        if (!isPullRefreshing()) {
            this.aIY = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.aIP != null) {
                this.aIP.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.aIO != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.aIO.a(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoading() {
        if (!isPullLoading()) {
            this.aIZ = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.aIQ != null) {
                this.aIQ.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.aIO != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.aIO.b(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    private void E(int i, int i2) {
        scrollTo(i, i2);
    }

    private void F(int i, int i2) {
        scrollBy(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getScrollYValue() {
        return getScrollY();
    }

    private void cX(int i) {
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
            this.aIP.cR(-currY);
            this.aIQ.onPull(Math.abs(getScrollYValue()) / this.aIS);
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.aIW = z;
    }

    private boolean Hw() {
        return this.aIW;
    }

    protected void Hx() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
