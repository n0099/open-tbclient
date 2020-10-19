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
/* loaded from: classes10.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private static final boolean DEBUG = b.DEBUG;
    private LoadingLayout dbA;
    private LoadingLayout dbB;
    private int dbC;
    private int dbD;
    private boolean dbE;
    private boolean dbF;
    private boolean dbG;
    private boolean dbH;
    private boolean dbI;
    private ILoadingLayout.State dbJ;
    private ILoadingLayout.State dbK;
    protected T dbL;
    private FrameLayout dbM;
    private int dbN;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> dbO;
    protected HEADERTYPE dby;
    private a<T> dbz;
    private int mActivePointerId;
    private float mLastMotionY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes10.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER,
        Common_STYLE_HEADER,
        SWAN_APP_HEADER
    }

    /* loaded from: classes10.dex */
    public interface a<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);

        void b(PullToRefreshBase<V> pullToRefreshBase);
    }

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    protected abstract boolean isReadyForPullDown();

    protected abstract boolean isReadyForPullUp();

    public PullToRefreshBase(Context context, com.baidu.swan.apps.res.ui.pullrefresh.a<T> aVar, HEADERTYPE headertype) {
        super(context);
        this.dby = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.dbE = true;
        this.dbF = false;
        this.dbG = false;
        this.dbH = true;
        this.dbI = false;
        this.dbJ = ILoadingLayout.State.NONE;
        this.dbK = ILoadingLayout.State.NONE;
        this.dbN = -1;
        this.mActivePointerId = -1;
        this.dbO = aVar;
        this.dby = headertype;
        init(context, null);
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.dby = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.dbE = true;
        this.dbF = false;
        this.dbG = false;
        this.dbH = true;
        this.dbI = false;
        this.dbJ = ILoadingLayout.State.NONE;
        this.dbK = ILoadingLayout.State.NONE;
        this.dbN = -1;
        this.mActivePointerId = -1;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dby = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.dbE = true;
        this.dbF = false;
        this.dbG = false;
        this.dbH = true;
        this.dbI = false;
        this.dbJ = ILoadingLayout.State.NONE;
        this.dbK = ILoadingLayout.State.NONE;
        this.dbN = -1;
        this.mActivePointerId = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mScroller = new Scroller(context);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.dbA = e(context, attributeSet);
        this.dbB = f(context, attributeSet);
        this.dbL = createRefreshableView(context, attributeSet);
        if (this.dbL == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.dbL);
        addHeaderAndFooter(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PullToRefreshBase.this.aCj();
                PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCj() {
        int contentSize = this.dbA != null ? this.dbA.getContentSize() : 0;
        int contentSize2 = this.dbB != null ? this.dbB.getContentSize() : 0;
        int i = contentSize < 0 ? 0 : contentSize;
        int i2 = contentSize2 < 0 ? 0 : contentSize2;
        this.dbC = i;
        this.dbD = i2;
        int measuredHeight = this.dbA != null ? this.dbA.getMeasuredHeight() : 0;
        int measuredHeight2 = this.dbB != null ? this.dbB.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.dbD;
        }
        setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        aCj();
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
        if (aCl()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.dbI = false;
                    return false;
                } else if (action == 0 || !this.dbI) {
                    int actionIndex = motionEvent.getActionIndex();
                    switch (action) {
                        case 0:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY();
                            this.dbI = false;
                            break;
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                this.dbI = false;
                                return this.dbI;
                            }
                            float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading()) {
                                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.dbI = z;
                                    if (this.dbI && aCk()) {
                                        this.dbL.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.dbI = z;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY(actionIndex);
                            this.dbI = false;
                            break;
                        case 6:
                            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                            if (motionEvent.getPointerId(action2) == this.mActivePointerId) {
                                this.mActivePointerId = motionEvent.getPointerId(action2 != 0 ? 0 : 1);
                                this.mLastMotionY = (int) motionEvent.getY(i);
                                this.dbI = false;
                                break;
                            }
                            break;
                    }
                    return this.dbI;
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
                if (this.dbI) {
                    this.dbI = false;
                    if (isReadyForPullDown()) {
                        if (this.dbE && this.dbJ == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startRefreshing();
                            z = true;
                        } else if (!isPullRefreshing()) {
                            this.dbJ = ILoadingLayout.State.RESET;
                            a(ILoadingLayout.State.RESET, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.dbK == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    this.dbI = false;
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
                    this.dbI = false;
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
        this.dbE = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.dbF = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.dbG = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.dbE && this.dbA != null;
    }

    public boolean isPullLoadEnabled() {
        return this.dbF && this.dbB != null;
    }

    public boolean isScrollLoadEnabled() {
        return this.dbG;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.dbz = aVar;
    }

    public void fM(boolean z) {
        i(z, null);
    }

    public void i(boolean z, String str) {
        if (isPullRefreshing()) {
            this.dbJ = ILoadingLayout.State.RESET;
            a(ILoadingLayout.State.RESET, true);
            setInterceptTouchEventEnabled(false);
            this.dbA.a(z, str, new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                            PullToRefreshBase.this.dbA.setState(ILoadingLayout.State.RESET);
                        }
                    }, PullToRefreshBase.this.getSmoothScrollDuration());
                    PullToRefreshBase.this.resetHeaderLayout();
                }
            });
        }
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.dbO;
    }

    public T getRefreshableView() {
        return this.dbL;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.dbA;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.dbB;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.dbA != null) {
            this.dbA.setLastUpdatedLabel(charSequence);
        }
        if (this.dbB != null) {
            this.dbB.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.dbN = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.dbA != null) {
            this.dbA.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.dbA != null) {
            this.dbA.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.dbA != null) {
            this.dbA.setHeaderBigBackground(i);
        }
    }

    public void a(final boolean z, long j, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.4
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.dbA.getRefreshingHeight();
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

    protected boolean aCk() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        aCm();
        LoadingLayout loadingLayout = null;
        switch (this.dby) {
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
        if (this.dbM != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dbM.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.dbM.requestLayout();
            }
        }
    }

    public void setEmptyView(View view) {
        if (this.dbM != null) {
            this.dbM.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        this.dbM = new FrameLayout(context);
        this.dbM.addView(t, -1, -1);
        addView(this.dbM, new LinearLayout.LayoutParams(-1, getNgWebViewHeightSwitch() ? 10 : -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.dbA;
        LoadingLayout loadingLayout2 = this.dbB;
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
            ap(0, 0);
            if (this.dbA != null) {
                this.dbA.js(0);
            }
        } else if (this.dbN <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.dbN) {
            aq(0, -((int) f));
            if (this.dbA != null) {
                this.dbA.js(-getScrollY());
                if (this.dbC != 0) {
                    this.dbA.onPull(Math.abs(getScrollYValue()) / this.dbC);
                }
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing()) {
                if (this.dbA != null && abs > this.dbA.getCanRefreshPullLength()) {
                    this.dbJ = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.dbJ = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.dbA != null) {
                    this.dbA.setState(this.dbJ);
                }
                a(this.dbJ, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            ap(0, 0);
            return;
        }
        aq(0, -((int) f));
        if (this.dbB != null && this.dbD != 0) {
            this.dbB.onPull(Math.abs(getScrollYValue()) / this.dbD);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.dbD) {
                this.dbK = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.dbK = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.dbB != null) {
                this.dbB.setState(this.dbK);
            }
            a(this.dbK, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.dbA.getRefreshingHeight()) {
            jy(0);
        } else if (isPullRefreshing) {
            jy(-this.dbA.getRefreshingHeight());
        } else {
            jy(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.dbD) {
            jy(0);
        } else if (isPullLoading) {
            jy(this.dbD);
        } else {
            jy(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.dbJ == ILoadingLayout.State.REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.dbK == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        fN(true);
    }

    private void fN(boolean z) {
        if (!isPullRefreshing()) {
            this.dbJ = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.dbA != null) {
                this.dbA.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.dbz != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.dbz.a(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoading() {
        if (!isPullLoading()) {
            this.dbK = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.dbB != null) {
                this.dbB.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.dbz != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.dbz.b(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    private void ap(int i, int i2) {
        scrollTo(i, i2);
    }

    private void aq(int i, int i2) {
        scrollBy(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getScrollYValue() {
        return getScrollY();
    }

    private void jy(int i) {
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
            this.dbA.js(-currY);
            this.dbB.onPull(Math.abs(getScrollYValue()) / this.dbD);
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.dbH = z;
    }

    private boolean aCl() {
        return this.dbH;
    }

    protected void aCm() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public static boolean getNgWebViewHeightSwitch() {
        return com.baidu.swan.apps.performance.b.b.azC() ? com.baidu.swan.apps.performance.b.b.getNgWebViewHeightSwitch() : com.baidu.swan.apps.t.a.asi().getSwitch("swan_app_refresh_ngwebview_height_switch", false);
    }
}
