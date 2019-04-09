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
    protected HEADERTYPE aIS;
    private a<T> aIT;
    private LoadingLayout aIU;
    private LoadingLayout aIV;
    private int aIW;
    private int aIX;
    private boolean aIY;
    private boolean aIZ;
    private boolean aJa;
    private boolean aJb;
    private boolean aJc;
    private ILoadingLayout.State aJd;
    private ILoadingLayout.State aJe;
    protected T aJf;
    private FrameLayout aJg;
    private int aJh;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> aJi;
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
        this.aIS = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.aIY = true;
        this.aIZ = false;
        this.aJa = false;
        this.aJb = true;
        this.aJc = false;
        this.aJd = ILoadingLayout.State.NONE;
        this.aJe = ILoadingLayout.State.NONE;
        this.aJh = -1;
        this.mActivePointerId = -1;
        this.aJi = aVar;
        this.aIS = headertype;
        init(context, null);
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.aIS = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.aIY = true;
        this.aIZ = false;
        this.aJa = false;
        this.aJb = true;
        this.aJc = false;
        this.aJd = ILoadingLayout.State.NONE;
        this.aJe = ILoadingLayout.State.NONE;
        this.aJh = -1;
        this.mActivePointerId = -1;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIS = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.aIY = true;
        this.aIZ = false;
        this.aJa = false;
        this.aJb = true;
        this.aJc = false;
        this.aJd = ILoadingLayout.State.NONE;
        this.aJe = ILoadingLayout.State.NONE;
        this.aJh = -1;
        this.mActivePointerId = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mScroller = new Scroller(context);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.aIU = f(context, attributeSet);
        this.aIV = g(context, attributeSet);
        this.aJf = createRefreshableView(context, attributeSet);
        if (this.aJf == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.aJf);
        addHeaderAndFooter(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PullToRefreshBase.this.Hs();
                PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hs() {
        int contentSize = this.aIU != null ? this.aIU.getContentSize() : 0;
        int contentSize2 = this.aIV != null ? this.aIV.getContentSize() : 0;
        int i = contentSize < 0 ? 0 : contentSize;
        int i2 = contentSize2 < 0 ? 0 : contentSize2;
        this.aIW = i;
        this.aIX = i2;
        int measuredHeight = this.aIU != null ? this.aIU.getMeasuredHeight() : 0;
        int measuredHeight2 = this.aIV != null ? this.aIV.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.aIX;
        }
        setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Hs();
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
        if (Hu()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.aJc = false;
                    return false;
                } else if (action == 0 || !this.aJc) {
                    int actionIndex = motionEvent.getActionIndex();
                    switch (action) {
                        case 0:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY();
                            this.aJc = false;
                            break;
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                this.aJc = false;
                                return this.aJc;
                            }
                            float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading()) {
                                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.aJc = z;
                                    if (this.aJc && Ht()) {
                                        this.aJf.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.aJc = z;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY(actionIndex);
                            this.aJc = false;
                            break;
                        case 6:
                            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                            if (motionEvent.getPointerId(action2) == this.mActivePointerId) {
                                this.mActivePointerId = motionEvent.getPointerId(action2 != 0 ? 0 : 1);
                                this.mLastMotionY = (int) motionEvent.getY(i);
                                this.aJc = false;
                                break;
                            }
                            break;
                    }
                    return this.aJc;
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
                if (this.aJc) {
                    this.aJc = false;
                    if (isReadyForPullDown()) {
                        if (this.aIY && this.aJd == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startRefreshing();
                            z = true;
                        } else if (!isPullRefreshing()) {
                            this.aJd = ILoadingLayout.State.RESET;
                            a(ILoadingLayout.State.RESET, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.aJe == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    this.aJc = false;
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
                    this.aJc = false;
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
        this.aIY = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.aIZ = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.aJa = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.aIY && this.aIU != null;
    }

    public boolean isPullLoadEnabled() {
        return this.aIZ && this.aIV != null;
    }

    public boolean isScrollLoadEnabled() {
        return this.aJa;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.aIT = aVar;
    }

    public void bB(boolean z) {
        e(z, null);
    }

    public void e(boolean z, String str) {
        if (isPullRefreshing()) {
            this.aJd = ILoadingLayout.State.RESET;
            a(ILoadingLayout.State.RESET, true);
            setInterceptTouchEventEnabled(false);
            this.aIU.a(z, str, new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                            PullToRefreshBase.this.aIU.setState(ILoadingLayout.State.RESET);
                        }
                    }, PullToRefreshBase.this.getSmoothScrollDuration());
                    PullToRefreshBase.this.resetHeaderLayout();
                }
            });
        }
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.aJi;
    }

    public T getRefreshableView() {
        return this.aJf;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.aIU;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.aIV;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.aIU != null) {
            this.aIU.setLastUpdatedLabel(charSequence);
        }
        if (this.aIV != null) {
            this.aIV.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.aJh = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.aIU != null) {
            this.aIU.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.aIU != null) {
            this.aIU.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.aIU != null) {
            this.aIU.setHeaderBigBackground(i);
        }
    }

    public void a(final boolean z, long j, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.4
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.aIU.getRefreshingHeight();
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

    protected boolean Ht() {
        return true;
    }

    protected LoadingLayout f(Context context, AttributeSet attributeSet) {
        Hv();
        LoadingLayout loadingLayout = null;
        switch (this.aIS) {
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
        if (this.aJg != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJg.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.aJg.requestLayout();
            }
        }
    }

    public void setEmptyView(View view) {
        if (this.aJg != null) {
            this.aJg.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        this.aJg = new FrameLayout(context);
        this.aJg.addView(t, -1, -1);
        addView(this.aJg, new LinearLayout.LayoutParams(-1, 10));
    }

    protected void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.aIU;
        LoadingLayout loadingLayout2 = this.aIV;
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
            if (this.aIU != null) {
                this.aIU.cQ(0);
            }
        } else if (this.aJh <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.aJh) {
            F(0, -((int) f));
            if (this.aIU != null) {
                this.aIU.cQ(-getScrollY());
                if (this.aIW != 0) {
                    this.aIU.onPull(Math.abs(getScrollYValue()) / this.aIW);
                }
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing()) {
                if (abs > this.aIU.getCanRefreshPullLength()) {
                    this.aJd = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.aJd = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.aIU != null) {
                    this.aIU.setState(this.aJd);
                }
                a(this.aJd, true);
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
        if (this.aIV != null && this.aIX != 0) {
            this.aIV.onPull(Math.abs(getScrollYValue()) / this.aIX);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.aIX) {
                this.aJe = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.aJe = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.aIV != null) {
                this.aIV.setState(this.aJe);
            }
            a(this.aJe, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.aIU.getRefreshingHeight()) {
            cW(0);
        } else if (isPullRefreshing) {
            cW(-this.aIU.getRefreshingHeight());
        } else {
            cW(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.aIX) {
            cW(0);
        } else if (isPullLoading) {
            cW(this.aIX);
        } else {
            cW(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.aJd == ILoadingLayout.State.REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.aJe == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        bC(true);
    }

    private void bC(boolean z) {
        if (!isPullRefreshing()) {
            this.aJd = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.aIU != null) {
                this.aIU.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.aIT != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.aIT.a(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoading() {
        if (!isPullLoading()) {
            this.aJe = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.aIV != null) {
                this.aIV.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.aIT != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.aIT.b(PullToRefreshBase.this);
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

    private void cW(int i) {
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
            this.aIU.cQ(-currY);
            this.aIV.onPull(Math.abs(getScrollYValue()) / this.aIX);
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.aJb = z;
    }

    private boolean Hu() {
        return this.aJb;
    }

    protected void Hv() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
