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
    protected HEADERTYPE dpV;
    private a<T> dpW;
    private LoadingLayout dpX;
    private LoadingLayout dpY;
    private int dpZ;
    private int dqa;
    private boolean dqb;
    private boolean dqc;
    private boolean dqd;
    private boolean dqe;
    private boolean dqf;
    private ILoadingLayout.State dqg;
    private ILoadingLayout.State dqh;
    protected T dqi;
    private FrameLayout dqj;
    private int dqk;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> dql;
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
        this.dpV = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.dqb = true;
        this.dqc = false;
        this.dqd = false;
        this.dqe = true;
        this.dqf = false;
        this.dqg = ILoadingLayout.State.NONE;
        this.dqh = ILoadingLayout.State.NONE;
        this.dqk = -1;
        this.mActivePointerId = -1;
        this.dql = aVar;
        this.dpV = headertype;
        init(context, null);
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.dpV = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.dqb = true;
        this.dqc = false;
        this.dqd = false;
        this.dqe = true;
        this.dqf = false;
        this.dqg = ILoadingLayout.State.NONE;
        this.dqh = ILoadingLayout.State.NONE;
        this.dqk = -1;
        this.mActivePointerId = -1;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dpV = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.dqb = true;
        this.dqc = false;
        this.dqd = false;
        this.dqe = true;
        this.dqf = false;
        this.dqg = ILoadingLayout.State.NONE;
        this.dqh = ILoadingLayout.State.NONE;
        this.dqk = -1;
        this.mActivePointerId = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mScroller = new Scroller(context);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.dpX = e(context, attributeSet);
        this.dpY = f(context, attributeSet);
        this.dqi = createRefreshableView(context, attributeSet);
        if (this.dqi == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.dqi);
        addHeaderAndFooter(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PullToRefreshBase.this.aGD();
                PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGD() {
        int contentSize = this.dpX != null ? this.dpX.getContentSize() : 0;
        int contentSize2 = this.dpY != null ? this.dpY.getContentSize() : 0;
        int i = contentSize < 0 ? 0 : contentSize;
        int i2 = contentSize2 < 0 ? 0 : contentSize2;
        this.dpZ = i;
        this.dqa = i2;
        int measuredHeight = this.dpX != null ? this.dpX.getMeasuredHeight() : 0;
        int measuredHeight2 = this.dpY != null ? this.dpY.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.dqa;
        }
        setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        aGD();
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
        if (aGF()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.dqf = false;
                    return false;
                } else if (action == 0 || !this.dqf) {
                    int actionIndex = motionEvent.getActionIndex();
                    switch (action) {
                        case 0:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY();
                            this.dqf = false;
                            break;
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                this.dqf = false;
                                return this.dqf;
                            }
                            float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading()) {
                                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.dqf = z;
                                    if (this.dqf && aGE()) {
                                        this.dqi.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.dqf = z;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY(actionIndex);
                            this.dqf = false;
                            break;
                        case 6:
                            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                            if (motionEvent.getPointerId(action2) == this.mActivePointerId) {
                                this.mActivePointerId = motionEvent.getPointerId(action2 != 0 ? 0 : 1);
                                this.mLastMotionY = (int) motionEvent.getY(i);
                                this.dqf = false;
                                break;
                            }
                            break;
                    }
                    return this.dqf;
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
                if (this.dqf) {
                    this.dqf = false;
                    if (isReadyForPullDown()) {
                        if (this.dqb && this.dqg == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startRefreshing();
                            z = true;
                        } else if (!isPullRefreshing()) {
                            this.dqg = ILoadingLayout.State.RESET;
                            a(ILoadingLayout.State.RESET, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.dqh == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    this.dqf = false;
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
                    this.dqf = false;
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
        this.dqb = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.dqc = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.dqd = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.dqb && this.dpX != null;
    }

    public boolean isPullLoadEnabled() {
        return this.dqc && this.dpY != null;
    }

    public boolean isScrollLoadEnabled() {
        return this.dqd;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.dpW = aVar;
    }

    public void gi(boolean z) {
        k(z, null);
    }

    public void k(boolean z, String str) {
        if (isPullRefreshing()) {
            this.dqg = ILoadingLayout.State.RESET;
            a(ILoadingLayout.State.RESET, true);
            setInterceptTouchEventEnabled(false);
            this.dpX.a(z, str, new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                            PullToRefreshBase.this.dpX.setState(ILoadingLayout.State.RESET);
                        }
                    }, PullToRefreshBase.this.getSmoothScrollDuration());
                    PullToRefreshBase.this.resetHeaderLayout();
                }
            });
        }
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.dql;
    }

    public T getRefreshableView() {
        return this.dqi;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.dpX;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.dpY;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.dpX != null) {
            this.dpX.setLastUpdatedLabel(charSequence);
        }
        if (this.dpY != null) {
            this.dpY.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.dqk = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.dpX != null) {
            this.dpX.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.dpX != null) {
            this.dpX.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.dpX != null) {
            this.dpX.setHeaderBigBackground(i);
        }
    }

    public void a(final boolean z, long j, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.4
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.dpX.getRefreshingHeight();
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

    protected boolean aGE() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        aGG();
        LoadingLayout loadingLayout = null;
        switch (this.dpV) {
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
        if (this.dqj != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqj.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.dqj.requestLayout();
            }
        }
    }

    public void setEmptyView(View view) {
        if (this.dqj != null) {
            this.dqj.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        this.dqj = new FrameLayout(context);
        this.dqj.addView(t, -1, -1);
        addView(this.dqj, new LinearLayout.LayoutParams(-1, getNgWebViewHeightSwitch() ? 10 : -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.dpX;
        LoadingLayout loadingLayout2 = this.dpY;
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
            if (this.dpX != null) {
                this.dpX.jN(0);
            }
        } else if (this.dqk <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.dqk) {
            ar(0, -((int) f));
            if (this.dpX != null) {
                this.dpX.jN(-getScrollY());
                if (this.dpZ != 0) {
                    this.dpX.onPull(Math.abs(getScrollYValue()) / this.dpZ);
                }
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing()) {
                if (this.dpX != null && abs > this.dpX.getCanRefreshPullLength()) {
                    this.dqg = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.dqg = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.dpX != null) {
                    this.dpX.setState(this.dqg);
                }
                a(this.dqg, true);
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
        if (this.dpY != null && this.dqa != 0) {
            this.dpY.onPull(Math.abs(getScrollYValue()) / this.dqa);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.dqa) {
                this.dqh = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.dqh = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.dpY != null) {
                this.dpY.setState(this.dqh);
            }
            a(this.dqh, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.dpX.getRefreshingHeight()) {
            jT(0);
        } else if (isPullRefreshing) {
            jT(-this.dpX.getRefreshingHeight());
        } else {
            jT(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.dqa) {
            jT(0);
        } else if (isPullLoading) {
            jT(this.dqa);
        } else {
            jT(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.dqg == ILoadingLayout.State.REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.dqh == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        gj(true);
    }

    private void gj(boolean z) {
        if (!isPullRefreshing()) {
            this.dqg = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.dpX != null) {
                this.dpX.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.dpW != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.dpW.a(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoading() {
        if (!isPullLoading()) {
            this.dqh = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.dpY != null) {
                this.dpY.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.dpW != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.dpW.b(PullToRefreshBase.this);
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

    private void jT(int i) {
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
            this.dpX.jN(-currY);
            this.dpY.onPull(Math.abs(getScrollYValue()) / this.dqa);
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.dqe = z;
    }

    private boolean aGF() {
        return this.dqe;
    }

    protected void aGG() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public static boolean getNgWebViewHeightSwitch() {
        return com.baidu.swan.apps.performance.b.b.aDW() ? com.baidu.swan.apps.performance.b.b.getNgWebViewHeightSwitch() : com.baidu.swan.apps.t.a.awD().getSwitch("swan_app_refresh_ngwebview_height_switch", false);
    }
}
