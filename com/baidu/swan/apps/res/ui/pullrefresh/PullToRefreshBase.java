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
    protected HEADERTYPE aIO;
    private a<T> aIP;
    private LoadingLayout aIQ;
    private LoadingLayout aIR;
    private int aIS;
    private int aIT;
    private boolean aIU;
    private boolean aIV;
    private boolean aIW;
    private boolean aIX;
    private boolean aIY;
    private ILoadingLayout.State aIZ;
    private ILoadingLayout.State aJa;
    protected T aJb;
    private FrameLayout aJc;
    private int aJd;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> aJe;
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
        this.aIO = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.aIU = true;
        this.aIV = false;
        this.aIW = false;
        this.aIX = true;
        this.aIY = false;
        this.aIZ = ILoadingLayout.State.NONE;
        this.aJa = ILoadingLayout.State.NONE;
        this.aJd = -1;
        this.mActivePointerId = -1;
        this.aJe = aVar;
        this.aIO = headertype;
        init(context, null);
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.aIO = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.aIU = true;
        this.aIV = false;
        this.aIW = false;
        this.aIX = true;
        this.aIY = false;
        this.aIZ = ILoadingLayout.State.NONE;
        this.aJa = ILoadingLayout.State.NONE;
        this.aJd = -1;
        this.mActivePointerId = -1;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIO = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.aIU = true;
        this.aIV = false;
        this.aIW = false;
        this.aIX = true;
        this.aIY = false;
        this.aIZ = ILoadingLayout.State.NONE;
        this.aJa = ILoadingLayout.State.NONE;
        this.aJd = -1;
        this.mActivePointerId = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mScroller = new Scroller(context);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.aIQ = f(context, attributeSet);
        this.aIR = g(context, attributeSet);
        this.aJb = createRefreshableView(context, attributeSet);
        if (this.aJb == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.aJb);
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
        int contentSize = this.aIQ != null ? this.aIQ.getContentSize() : 0;
        int contentSize2 = this.aIR != null ? this.aIR.getContentSize() : 0;
        int i = contentSize < 0 ? 0 : contentSize;
        int i2 = contentSize2 < 0 ? 0 : contentSize2;
        this.aIS = i;
        this.aIT = i2;
        int measuredHeight = this.aIQ != null ? this.aIQ.getMeasuredHeight() : 0;
        int measuredHeight2 = this.aIR != null ? this.aIR.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.aIT;
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
                    this.aIY = false;
                    return false;
                } else if (action == 0 || !this.aIY) {
                    int actionIndex = motionEvent.getActionIndex();
                    switch (action) {
                        case 0:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY();
                            this.aIY = false;
                            break;
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                this.aIY = false;
                                return this.aIY;
                            }
                            float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading()) {
                                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.aIY = z;
                                    if (this.aIY && Hv()) {
                                        this.aJb.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.aIY = z;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY(actionIndex);
                            this.aIY = false;
                            break;
                        case 6:
                            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                            if (motionEvent.getPointerId(action2) == this.mActivePointerId) {
                                this.mActivePointerId = motionEvent.getPointerId(action2 != 0 ? 0 : 1);
                                this.mLastMotionY = (int) motionEvent.getY(i);
                                this.aIY = false;
                                break;
                            }
                            break;
                    }
                    return this.aIY;
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
                if (this.aIY) {
                    this.aIY = false;
                    if (isReadyForPullDown()) {
                        if (this.aIU && this.aIZ == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startRefreshing();
                            z = true;
                        } else if (!isPullRefreshing()) {
                            this.aIZ = ILoadingLayout.State.RESET;
                            a(ILoadingLayout.State.RESET, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.aJa == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    this.aIY = false;
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
                    this.aIY = false;
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
        this.aIU = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.aIV = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.aIW = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.aIU && this.aIQ != null;
    }

    public boolean isPullLoadEnabled() {
        return this.aIV && this.aIR != null;
    }

    public boolean isScrollLoadEnabled() {
        return this.aIW;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.aIP = aVar;
    }

    public void bB(boolean z) {
        e(z, null);
    }

    public void e(boolean z, String str) {
        if (isPullRefreshing()) {
            this.aIZ = ILoadingLayout.State.RESET;
            a(ILoadingLayout.State.RESET, true);
            setInterceptTouchEventEnabled(false);
            this.aIQ.a(z, str, new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                            PullToRefreshBase.this.aIQ.setState(ILoadingLayout.State.RESET);
                        }
                    }, PullToRefreshBase.this.getSmoothScrollDuration());
                    PullToRefreshBase.this.resetHeaderLayout();
                }
            });
        }
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.aJe;
    }

    public T getRefreshableView() {
        return this.aJb;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.aIQ;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.aIR;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.aIQ != null) {
            this.aIQ.setLastUpdatedLabel(charSequence);
        }
        if (this.aIR != null) {
            this.aIR.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.aJd = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.aIQ != null) {
            this.aIQ.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.aIQ != null) {
            this.aIQ.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.aIQ != null) {
            this.aIQ.setHeaderBigBackground(i);
        }
    }

    public void a(final boolean z, long j, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.4
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.aIQ.getRefreshingHeight();
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
        switch (this.aIO) {
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
        if (this.aJc != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJc.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.aJc.requestLayout();
            }
        }
    }

    public void setEmptyView(View view) {
        if (this.aJc != null) {
            this.aJc.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        this.aJc = new FrameLayout(context);
        this.aJc.addView(t, -1, -1);
        addView(this.aJc, new LinearLayout.LayoutParams(-1, 10));
    }

    protected void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.aIQ;
        LoadingLayout loadingLayout2 = this.aIR;
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
            if (this.aIQ != null) {
                this.aIQ.cR(0);
            }
        } else if (this.aJd <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.aJd) {
            F(0, -((int) f));
            if (this.aIQ != null) {
                this.aIQ.cR(-getScrollY());
                if (this.aIS != 0) {
                    this.aIQ.onPull(Math.abs(getScrollYValue()) / this.aIS);
                }
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing()) {
                if (abs > this.aIQ.getCanRefreshPullLength()) {
                    this.aIZ = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.aIZ = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.aIQ != null) {
                    this.aIQ.setState(this.aIZ);
                }
                a(this.aIZ, true);
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
        if (this.aIR != null && this.aIT != 0) {
            this.aIR.onPull(Math.abs(getScrollYValue()) / this.aIT);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.aIT) {
                this.aJa = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.aJa = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.aIR != null) {
                this.aIR.setState(this.aJa);
            }
            a(this.aJa, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.aIQ.getRefreshingHeight()) {
            cX(0);
        } else if (isPullRefreshing) {
            cX(-this.aIQ.getRefreshingHeight());
        } else {
            cX(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.aIT) {
            cX(0);
        } else if (isPullLoading) {
            cX(this.aIT);
        } else {
            cX(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.aIZ == ILoadingLayout.State.REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.aJa == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        bC(true);
    }

    private void bC(boolean z) {
        if (!isPullRefreshing()) {
            this.aIZ = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.aIQ != null) {
                this.aIQ.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.aIP != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.aIP.a(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoading() {
        if (!isPullLoading()) {
            this.aJa = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.aIR != null) {
                this.aIR.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.aIP != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.aIP.b(PullToRefreshBase.this);
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
            this.aIQ.cR(-currY);
            this.aIR.onPull(Math.abs(getScrollYValue()) / this.aIT);
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.aIX = z;
    }

    private boolean Hw() {
        return this.aIX;
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
