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
/* loaded from: classes8.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private static final boolean DEBUG = b.DEBUG;
    private ILoadingLayout.State cNA;
    private ILoadingLayout.State cNB;
    protected T cNC;
    private FrameLayout cND;
    private int cNE;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> cNF;
    protected HEADERTYPE cNp;
    private a<T> cNq;
    private LoadingLayout cNr;
    private LoadingLayout cNs;
    private int cNt;
    private int cNu;
    private boolean cNv;
    private boolean cNw;
    private boolean cNx;
    private boolean cNy;
    private boolean cNz;
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
        this.cNp = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.cNv = true;
        this.cNw = false;
        this.cNx = false;
        this.cNy = true;
        this.cNz = false;
        this.cNA = ILoadingLayout.State.NONE;
        this.cNB = ILoadingLayout.State.NONE;
        this.cNE = -1;
        this.mActivePointerId = -1;
        this.cNF = aVar;
        this.cNp = headertype;
        init(context, null);
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.cNp = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.cNv = true;
        this.cNw = false;
        this.cNx = false;
        this.cNy = true;
        this.cNz = false;
        this.cNA = ILoadingLayout.State.NONE;
        this.cNB = ILoadingLayout.State.NONE;
        this.cNE = -1;
        this.mActivePointerId = -1;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cNp = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.cNv = true;
        this.cNw = false;
        this.cNx = false;
        this.cNy = true;
        this.cNz = false;
        this.cNA = ILoadingLayout.State.NONE;
        this.cNB = ILoadingLayout.State.NONE;
        this.cNE = -1;
        this.mActivePointerId = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mScroller = new Scroller(context);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.cNr = e(context, attributeSet);
        this.cNs = f(context, attributeSet);
        this.cNC = createRefreshableView(context, attributeSet);
        if (this.cNC == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.cNC);
        addHeaderAndFooter(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PullToRefreshBase.this.ayR();
                PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayR() {
        int contentSize = this.cNr != null ? this.cNr.getContentSize() : 0;
        int contentSize2 = this.cNs != null ? this.cNs.getContentSize() : 0;
        int i = contentSize < 0 ? 0 : contentSize;
        int i2 = contentSize2 < 0 ? 0 : contentSize2;
        this.cNt = i;
        this.cNu = i2;
        int measuredHeight = this.cNr != null ? this.cNr.getMeasuredHeight() : 0;
        int measuredHeight2 = this.cNs != null ? this.cNs.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.cNu;
        }
        setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ayR();
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
        if (ayT()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.cNz = false;
                    return false;
                } else if (action == 0 || !this.cNz) {
                    int actionIndex = motionEvent.getActionIndex();
                    switch (action) {
                        case 0:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY();
                            this.cNz = false;
                            break;
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                this.cNz = false;
                                return this.cNz;
                            }
                            float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading()) {
                                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.cNz = z;
                                    if (this.cNz && ayS()) {
                                        this.cNC.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.cNz = z;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY(actionIndex);
                            this.cNz = false;
                            break;
                        case 6:
                            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                            if (motionEvent.getPointerId(action2) == this.mActivePointerId) {
                                this.mActivePointerId = motionEvent.getPointerId(action2 != 0 ? 0 : 1);
                                this.mLastMotionY = (int) motionEvent.getY(i);
                                this.cNz = false;
                                break;
                            }
                            break;
                    }
                    return this.cNz;
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
                if (this.cNz) {
                    this.cNz = false;
                    if (isReadyForPullDown()) {
                        if (this.cNv && this.cNA == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startRefreshing();
                            z = true;
                        } else if (!isPullRefreshing()) {
                            this.cNA = ILoadingLayout.State.RESET;
                            a(ILoadingLayout.State.RESET, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.cNB == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    this.cNz = false;
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
                    this.cNz = false;
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
        this.cNv = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.cNw = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.cNx = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.cNv && this.cNr != null;
    }

    public boolean isPullLoadEnabled() {
        return this.cNw && this.cNs != null;
    }

    public boolean isScrollLoadEnabled() {
        return this.cNx;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.cNq = aVar;
    }

    public void fr(boolean z) {
        i(z, null);
    }

    public void i(boolean z, String str) {
        if (isPullRefreshing()) {
            this.cNA = ILoadingLayout.State.RESET;
            a(ILoadingLayout.State.RESET, true);
            setInterceptTouchEventEnabled(false);
            this.cNr.a(z, str, new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                            PullToRefreshBase.this.cNr.setState(ILoadingLayout.State.RESET);
                        }
                    }, PullToRefreshBase.this.getSmoothScrollDuration());
                    PullToRefreshBase.this.resetHeaderLayout();
                }
            });
        }
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.cNF;
    }

    public T getRefreshableView() {
        return this.cNC;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.cNr;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.cNs;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.cNr != null) {
            this.cNr.setLastUpdatedLabel(charSequence);
        }
        if (this.cNs != null) {
            this.cNs.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.cNE = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.cNr != null) {
            this.cNr.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.cNr != null) {
            this.cNr.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.cNr != null) {
            this.cNr.setHeaderBigBackground(i);
        }
    }

    public void a(final boolean z, long j, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.4
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.cNr.getRefreshingHeight();
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

    protected boolean ayS() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        ayU();
        LoadingLayout loadingLayout = null;
        switch (this.cNp) {
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
        if (this.cND != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cND.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.cND.requestLayout();
            }
        }
    }

    public void setEmptyView(View view) {
        if (this.cND != null) {
            this.cND.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        this.cND = new FrameLayout(context);
        this.cND.addView(t, -1, -1);
        addView(this.cND, new LinearLayout.LayoutParams(-1, getNgWebViewHeightSwitch() ? 10 : -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.cNr;
        LoadingLayout loadingLayout2 = this.cNs;
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
            aq(0, 0);
            if (this.cNr != null) {
                this.cNr.iL(0);
            }
        } else if (this.cNE <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.cNE) {
            ar(0, -((int) f));
            if (this.cNr != null) {
                this.cNr.iL(-getScrollY());
                if (this.cNt != 0) {
                    this.cNr.onPull(Math.abs(getScrollYValue()) / this.cNt);
                }
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing()) {
                if (this.cNr != null && abs > this.cNr.getCanRefreshPullLength()) {
                    this.cNA = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.cNA = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.cNr != null) {
                    this.cNr.setState(this.cNA);
                }
                a(this.cNA, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            aq(0, 0);
            return;
        }
        ar(0, -((int) f));
        if (this.cNs != null && this.cNu != 0) {
            this.cNs.onPull(Math.abs(getScrollYValue()) / this.cNu);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.cNu) {
                this.cNB = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.cNB = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.cNs != null) {
                this.cNs.setState(this.cNB);
            }
            a(this.cNB, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.cNr.getRefreshingHeight()) {
            iQ(0);
        } else if (isPullRefreshing) {
            iQ(-this.cNr.getRefreshingHeight());
        } else {
            iQ(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.cNu) {
            iQ(0);
        } else if (isPullLoading) {
            iQ(this.cNu);
        } else {
            iQ(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.cNA == ILoadingLayout.State.REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.cNB == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        fs(true);
    }

    private void fs(boolean z) {
        if (!isPullRefreshing()) {
            this.cNA = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.cNr != null) {
                this.cNr.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.cNq != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.cNq.a(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoading() {
        if (!isPullLoading()) {
            this.cNB = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.cNs != null) {
                this.cNs.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.cNq != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.cNq.b(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    private void aq(int i, int i2) {
        scrollTo(i, i2);
    }

    private void ar(int i, int i2) {
        scrollBy(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getScrollYValue() {
        return getScrollY();
    }

    private void iQ(int i) {
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
            this.cNr.iL(-currY);
            this.cNs.onPull(Math.abs(getScrollYValue()) / this.cNu);
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.cNy = z;
    }

    private boolean ayT() {
        return this.cNy;
    }

    protected void ayU() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public static boolean getNgWebViewHeightSwitch() {
        return com.baidu.swan.apps.performance.b.b.awi() ? com.baidu.swan.apps.performance.b.b.getNgWebViewHeightSwitch() : com.baidu.swan.apps.t.a.aoM().getSwitch("swan_app_refresh_ngwebview_height_switch", false);
    }
}
