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
/* loaded from: classes7.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private static final boolean DEBUG = b.DEBUG;
    private boolean cEA;
    private boolean cEB;
    private ILoadingLayout.State cEC;
    private ILoadingLayout.State cED;
    protected T cEE;
    private FrameLayout cEF;
    private int cEG;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> cEH;
    protected HEADERTYPE cEr;
    private a<T> cEs;
    private LoadingLayout cEt;
    private LoadingLayout cEu;
    private int cEv;
    private int cEw;
    private boolean cEx;
    private boolean cEy;
    private boolean cEz;
    private int mActivePointerId;
    private float mLastMotionY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes7.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER,
        Common_STYLE_HEADER,
        SWAN_APP_HEADER
    }

    /* loaded from: classes7.dex */
    public interface a<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);

        void b(PullToRefreshBase<V> pullToRefreshBase);
    }

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    protected abstract boolean isReadyForPullDown();

    protected abstract boolean isReadyForPullUp();

    public PullToRefreshBase(Context context, com.baidu.swan.apps.res.ui.pullrefresh.a<T> aVar, HEADERTYPE headertype) {
        super(context);
        this.cEr = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.cEx = true;
        this.cEy = false;
        this.cEz = false;
        this.cEA = true;
        this.cEB = false;
        this.cEC = ILoadingLayout.State.NONE;
        this.cED = ILoadingLayout.State.NONE;
        this.cEG = -1;
        this.mActivePointerId = -1;
        this.cEH = aVar;
        this.cEr = headertype;
        init(context, null);
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.cEr = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.cEx = true;
        this.cEy = false;
        this.cEz = false;
        this.cEA = true;
        this.cEB = false;
        this.cEC = ILoadingLayout.State.NONE;
        this.cED = ILoadingLayout.State.NONE;
        this.cEG = -1;
        this.mActivePointerId = -1;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cEr = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.cEx = true;
        this.cEy = false;
        this.cEz = false;
        this.cEA = true;
        this.cEB = false;
        this.cEC = ILoadingLayout.State.NONE;
        this.cED = ILoadingLayout.State.NONE;
        this.cEG = -1;
        this.mActivePointerId = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mScroller = new Scroller(context);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.cEt = e(context, attributeSet);
        this.cEu = f(context, attributeSet);
        this.cEE = createRefreshableView(context, attributeSet);
        if (this.cEE == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.cEE);
        addHeaderAndFooter(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PullToRefreshBase.this.aqF();
                PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqF() {
        int contentSize = this.cEt != null ? this.cEt.getContentSize() : 0;
        int contentSize2 = this.cEu != null ? this.cEu.getContentSize() : 0;
        int i = contentSize < 0 ? 0 : contentSize;
        int i2 = contentSize2 < 0 ? 0 : contentSize2;
        this.cEv = i;
        this.cEw = i2;
        int measuredHeight = this.cEt != null ? this.cEt.getMeasuredHeight() : 0;
        int measuredHeight2 = this.cEu != null ? this.cEu.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.cEw;
        }
        setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        aqF();
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
        if (aqH()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.cEB = false;
                    return false;
                } else if (action == 0 || !this.cEB) {
                    int actionIndex = motionEvent.getActionIndex();
                    switch (action) {
                        case 0:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY();
                            this.cEB = false;
                            break;
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                this.cEB = false;
                                return this.cEB;
                            }
                            float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading()) {
                                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.cEB = z;
                                    if (this.cEB && aqG()) {
                                        this.cEE.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.cEB = z;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY(actionIndex);
                            this.cEB = false;
                            break;
                        case 6:
                            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                            if (motionEvent.getPointerId(action2) == this.mActivePointerId) {
                                this.mActivePointerId = motionEvent.getPointerId(action2 != 0 ? 0 : 1);
                                this.mLastMotionY = (int) motionEvent.getY(i);
                                this.cEB = false;
                                break;
                            }
                            break;
                    }
                    return this.cEB;
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
                if (this.cEB) {
                    this.cEB = false;
                    if (isReadyForPullDown()) {
                        if (this.cEx && this.cEC == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startRefreshing();
                            z = true;
                        } else if (!isPullRefreshing()) {
                            this.cEC = ILoadingLayout.State.RESET;
                            a(ILoadingLayout.State.RESET, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.cED == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    this.cEB = false;
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
                    this.cEB = false;
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
        this.cEx = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.cEy = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.cEz = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.cEx && this.cEt != null;
    }

    public boolean isPullLoadEnabled() {
        return this.cEy && this.cEu != null;
    }

    public boolean isScrollLoadEnabled() {
        return this.cEz;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.cEs = aVar;
    }

    public void eY(boolean z) {
        i(z, null);
    }

    public void i(boolean z, String str) {
        if (isPullRefreshing()) {
            this.cEC = ILoadingLayout.State.RESET;
            a(ILoadingLayout.State.RESET, true);
            setInterceptTouchEventEnabled(false);
            this.cEt.a(z, str, new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                            PullToRefreshBase.this.cEt.setState(ILoadingLayout.State.RESET);
                        }
                    }, PullToRefreshBase.this.getSmoothScrollDuration());
                    PullToRefreshBase.this.resetHeaderLayout();
                }
            });
        }
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.cEH;
    }

    public T getRefreshableView() {
        return this.cEE;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.cEt;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.cEu;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.cEt != null) {
            this.cEt.setLastUpdatedLabel(charSequence);
        }
        if (this.cEu != null) {
            this.cEu.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.cEG = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.cEt != null) {
            this.cEt.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.cEt != null) {
            this.cEt.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.cEt != null) {
            this.cEt.setHeaderBigBackground(i);
        }
    }

    public void a(final boolean z, long j, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.4
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.cEt.getRefreshingHeight();
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

    protected boolean aqG() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        aqI();
        LoadingLayout loadingLayout = null;
        switch (this.cEr) {
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
        if (this.cEF != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cEF.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.cEF.requestLayout();
            }
        }
    }

    public void setEmptyView(View view) {
        if (this.cEF != null) {
            this.cEF.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        this.cEF = new FrameLayout(context);
        this.cEF.addView(t, -1, -1);
        addView(this.cEF, new LinearLayout.LayoutParams(-1, com.baidu.swan.apps.t.a.ahm().getSwitch("swan_app_refresh_ngwebview_height_switch", false) ? 10 : -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.cEt;
        LoadingLayout loadingLayout2 = this.cEu;
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
            al(0, 0);
            if (this.cEt != null) {
                this.cEt.gE(0);
            }
        } else if (this.cEG <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.cEG) {
            am(0, -((int) f));
            if (this.cEt != null) {
                this.cEt.gE(-getScrollY());
                if (this.cEv != 0) {
                    this.cEt.onPull(Math.abs(getScrollYValue()) / this.cEv);
                }
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing()) {
                if (this.cEt != null && abs > this.cEt.getCanRefreshPullLength()) {
                    this.cEC = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.cEC = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.cEt != null) {
                    this.cEt.setState(this.cEC);
                }
                a(this.cEC, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            al(0, 0);
            return;
        }
        am(0, -((int) f));
        if (this.cEu != null && this.cEw != 0) {
            this.cEu.onPull(Math.abs(getScrollYValue()) / this.cEw);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.cEw) {
                this.cED = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.cED = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.cEu != null) {
                this.cEu.setState(this.cED);
            }
            a(this.cED, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.cEt.getRefreshingHeight()) {
            gJ(0);
        } else if (isPullRefreshing) {
            gJ(-this.cEt.getRefreshingHeight());
        } else {
            gJ(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.cEw) {
            gJ(0);
        } else if (isPullLoading) {
            gJ(this.cEw);
        } else {
            gJ(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.cEC == ILoadingLayout.State.REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.cED == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        eZ(true);
    }

    private void eZ(boolean z) {
        if (!isPullRefreshing()) {
            this.cEC = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.cEt != null) {
                this.cEt.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.cEs != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.cEs.a(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoading() {
        if (!isPullLoading()) {
            this.cED = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.cEu != null) {
                this.cEu.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.cEs != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.cEs.b(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    private void al(int i, int i2) {
        scrollTo(i, i2);
    }

    private void am(int i, int i2) {
        scrollBy(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getScrollYValue() {
        return getScrollY();
    }

    private void gJ(int i) {
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
            this.cEt.gE(-currY);
            this.cEu.onPull(Math.abs(getScrollYValue()) / this.cEw);
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.cEA = z;
    }

    private boolean aqH() {
        return this.cEA;
    }

    protected void aqI() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
