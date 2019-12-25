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
/* loaded from: classes9.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private static final boolean DEBUG = b.DEBUG;
    private LoadingLayout bHA;
    private LoadingLayout bHB;
    private int bHC;
    private int bHD;
    private boolean bHE;
    private boolean bHF;
    private boolean bHG;
    private boolean bHH;
    private boolean bHI;
    private ILoadingLayout.State bHJ;
    private ILoadingLayout.State bHK;
    protected T bHL;
    private FrameLayout bHM;
    private int bHN;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> bHO;
    protected HEADERTYPE bHy;
    private a<T> bHz;
    private int mActivePointerId;
    private float mLastMotionY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes9.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER,
        Common_STYLE_HEADER,
        SWAN_APP_HEADER
    }

    /* loaded from: classes9.dex */
    public interface a<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);

        void b(PullToRefreshBase<V> pullToRefreshBase);
    }

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    protected abstract boolean isReadyForPullDown();

    protected abstract boolean isReadyForPullUp();

    public PullToRefreshBase(Context context, com.baidu.swan.apps.res.ui.pullrefresh.a<T> aVar, HEADERTYPE headertype) {
        super(context);
        this.bHy = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.bHE = true;
        this.bHF = false;
        this.bHG = false;
        this.bHH = true;
        this.bHI = false;
        this.bHJ = ILoadingLayout.State.NONE;
        this.bHK = ILoadingLayout.State.NONE;
        this.bHN = -1;
        this.mActivePointerId = -1;
        this.bHO = aVar;
        this.bHy = headertype;
        init(context, null);
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.bHy = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.bHE = true;
        this.bHF = false;
        this.bHG = false;
        this.bHH = true;
        this.bHI = false;
        this.bHJ = ILoadingLayout.State.NONE;
        this.bHK = ILoadingLayout.State.NONE;
        this.bHN = -1;
        this.mActivePointerId = -1;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHy = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.bHE = true;
        this.bHF = false;
        this.bHG = false;
        this.bHH = true;
        this.bHI = false;
        this.bHJ = ILoadingLayout.State.NONE;
        this.bHK = ILoadingLayout.State.NONE;
        this.bHN = -1;
        this.mActivePointerId = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mScroller = new Scroller(context);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.bHA = e(context, attributeSet);
        this.bHB = f(context, attributeSet);
        this.bHL = createRefreshableView(context, attributeSet);
        if (this.bHL == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.bHL);
        addHeaderAndFooter(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PullToRefreshBase.this.Zh();
                PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zh() {
        int contentSize = this.bHA != null ? this.bHA.getContentSize() : 0;
        int contentSize2 = this.bHB != null ? this.bHB.getContentSize() : 0;
        int i = contentSize < 0 ? 0 : contentSize;
        int i2 = contentSize2 < 0 ? 0 : contentSize2;
        this.bHC = i;
        this.bHD = i2;
        int measuredHeight = this.bHA != null ? this.bHA.getMeasuredHeight() : 0;
        int measuredHeight2 = this.bHB != null ? this.bHB.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.bHD;
        }
        setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Zh();
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
        if (Zj()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.bHI = false;
                    return false;
                } else if (action == 0 || !this.bHI) {
                    int actionIndex = motionEvent.getActionIndex();
                    switch (action) {
                        case 0:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY();
                            this.bHI = false;
                            break;
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                this.bHI = false;
                                return this.bHI;
                            }
                            float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading()) {
                                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.bHI = z;
                                    if (this.bHI && Zi()) {
                                        this.bHL.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.bHI = z;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY(actionIndex);
                            this.bHI = false;
                            break;
                        case 6:
                            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                            if (motionEvent.getPointerId(action2) == this.mActivePointerId) {
                                this.mActivePointerId = motionEvent.getPointerId(action2 != 0 ? 0 : 1);
                                this.mLastMotionY = (int) motionEvent.getY(i);
                                this.bHI = false;
                                break;
                            }
                            break;
                    }
                    return this.bHI;
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
                if (this.bHI) {
                    this.bHI = false;
                    if (isReadyForPullDown()) {
                        if (this.bHE && this.bHJ == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startRefreshing();
                            z = true;
                        } else if (!isPullRefreshing()) {
                            this.bHJ = ILoadingLayout.State.RESET;
                            a(ILoadingLayout.State.RESET, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.bHK == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    this.bHI = false;
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
                    this.bHI = false;
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
        this.bHE = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.bHF = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.bHG = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.bHE && this.bHA != null;
    }

    public boolean isPullLoadEnabled() {
        return this.bHF && this.bHB != null;
    }

    public boolean isScrollLoadEnabled() {
        return this.bHG;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.bHz = aVar;
    }

    public void di(boolean z) {
        f(z, (String) null);
    }

    public void f(boolean z, String str) {
        if (isPullRefreshing()) {
            this.bHJ = ILoadingLayout.State.RESET;
            a(ILoadingLayout.State.RESET, true);
            setInterceptTouchEventEnabled(false);
            this.bHA.a(z, str, new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                            PullToRefreshBase.this.bHA.setState(ILoadingLayout.State.RESET);
                        }
                    }, PullToRefreshBase.this.getSmoothScrollDuration());
                    PullToRefreshBase.this.resetHeaderLayout();
                }
            });
        }
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.bHO;
    }

    public T getRefreshableView() {
        return this.bHL;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.bHA;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.bHB;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.bHA != null) {
            this.bHA.setLastUpdatedLabel(charSequence);
        }
        if (this.bHB != null) {
            this.bHB.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.bHN = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.bHA != null) {
            this.bHA.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.bHA != null) {
            this.bHA.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.bHA != null) {
            this.bHA.setHeaderBigBackground(i);
        }
    }

    public void a(final boolean z, long j, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.4
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.bHA.getRefreshingHeight();
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

    protected boolean Zi() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        Zk();
        LoadingLayout loadingLayout = null;
        switch (this.bHy) {
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
        if (this.bHM != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHM.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.bHM.requestLayout();
            }
        }
    }

    public void setEmptyView(View view) {
        if (this.bHM != null) {
            this.bHM.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        this.bHM = new FrameLayout(context);
        this.bHM.addView(t, -1, -1);
        addView(this.bHM, new LinearLayout.LayoutParams(-1, 10));
    }

    protected void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.bHA;
        LoadingLayout loadingLayout2 = this.bHB;
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
            Z(0, 0);
            if (this.bHA != null) {
                this.bHA.fs(0);
            }
        } else if (this.bHN <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.bHN) {
            aa(0, -((int) f));
            if (this.bHA != null) {
                this.bHA.fs(-getScrollY());
                if (this.bHC != 0) {
                    this.bHA.onPull(Math.abs(getScrollYValue()) / this.bHC);
                }
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing()) {
                if (this.bHA != null && abs > this.bHA.getCanRefreshPullLength()) {
                    this.bHJ = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.bHJ = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.bHA != null) {
                    this.bHA.setState(this.bHJ);
                }
                a(this.bHJ, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            Z(0, 0);
            return;
        }
        aa(0, -((int) f));
        if (this.bHB != null && this.bHD != 0) {
            this.bHB.onPull(Math.abs(getScrollYValue()) / this.bHD);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.bHD) {
                this.bHK = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.bHK = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.bHB != null) {
                this.bHB.setState(this.bHK);
            }
            a(this.bHK, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.bHA.getRefreshingHeight()) {
            fx(0);
        } else if (isPullRefreshing) {
            fx(-this.bHA.getRefreshingHeight());
        } else {
            fx(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.bHD) {
            fx(0);
        } else if (isPullLoading) {
            fx(this.bHD);
        } else {
            fx(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.bHJ == ILoadingLayout.State.REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.bHK == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        dj(true);
    }

    private void dj(boolean z) {
        if (!isPullRefreshing()) {
            this.bHJ = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.bHA != null) {
                this.bHA.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.bHz != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.bHz.a(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoading() {
        if (!isPullLoading()) {
            this.bHK = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.bHB != null) {
                this.bHB.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.bHz != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.bHz.b(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    private void Z(int i, int i2) {
        scrollTo(i, i2);
    }

    private void aa(int i, int i2) {
        scrollBy(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getScrollYValue() {
        return getScrollY();
    }

    private void fx(int i) {
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
            this.bHA.fs(-currY);
            this.bHB.onPull(Math.abs(getScrollYValue()) / this.bHD);
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.bHH = z;
    }

    private boolean Zj() {
        return this.bHH;
    }

    protected void Zk() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
