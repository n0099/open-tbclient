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
/* loaded from: classes11.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private static final boolean DEBUG = b.DEBUG;
    protected HEADERTYPE cBE;
    private a<T> cBF;
    private LoadingLayout cBG;
    private LoadingLayout cBH;
    private int cBI;
    private int cBJ;
    private boolean cBK;
    private boolean cBL;
    private boolean cBM;
    private boolean cBN;
    private boolean cBO;
    private ILoadingLayout.State cBP;
    private ILoadingLayout.State cBQ;
    protected T cBR;
    private FrameLayout cBS;
    private int cBT;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> cBU;
    private int mActivePointerId;
    private float mLastMotionY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes11.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER,
        Common_STYLE_HEADER,
        SWAN_APP_HEADER
    }

    /* loaded from: classes11.dex */
    public interface a<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);

        void b(PullToRefreshBase<V> pullToRefreshBase);
    }

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    protected abstract boolean isReadyForPullDown();

    protected abstract boolean isReadyForPullUp();

    public PullToRefreshBase(Context context, com.baidu.swan.apps.res.ui.pullrefresh.a<T> aVar, HEADERTYPE headertype) {
        super(context);
        this.cBE = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.cBK = true;
        this.cBL = false;
        this.cBM = false;
        this.cBN = true;
        this.cBO = false;
        this.cBP = ILoadingLayout.State.NONE;
        this.cBQ = ILoadingLayout.State.NONE;
        this.cBT = -1;
        this.mActivePointerId = -1;
        this.cBU = aVar;
        this.cBE = headertype;
        init(context, null);
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.cBE = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.cBK = true;
        this.cBL = false;
        this.cBM = false;
        this.cBN = true;
        this.cBO = false;
        this.cBP = ILoadingLayout.State.NONE;
        this.cBQ = ILoadingLayout.State.NONE;
        this.cBT = -1;
        this.mActivePointerId = -1;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cBE = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.cBK = true;
        this.cBL = false;
        this.cBM = false;
        this.cBN = true;
        this.cBO = false;
        this.cBP = ILoadingLayout.State.NONE;
        this.cBQ = ILoadingLayout.State.NONE;
        this.cBT = -1;
        this.mActivePointerId = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mScroller = new Scroller(context);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.cBG = e(context, attributeSet);
        this.cBH = f(context, attributeSet);
        this.cBR = createRefreshableView(context, attributeSet);
        if (this.cBR == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.cBR);
        addHeaderAndFooter(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PullToRefreshBase.this.aoV();
                PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoV() {
        int contentSize = this.cBG != null ? this.cBG.getContentSize() : 0;
        int contentSize2 = this.cBH != null ? this.cBH.getContentSize() : 0;
        int i = contentSize < 0 ? 0 : contentSize;
        int i2 = contentSize2 < 0 ? 0 : contentSize2;
        this.cBI = i;
        this.cBJ = i2;
        int measuredHeight = this.cBG != null ? this.cBG.getMeasuredHeight() : 0;
        int measuredHeight2 = this.cBH != null ? this.cBH.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.cBJ;
        }
        setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        aoV();
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
        if (aoX()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.cBO = false;
                    return false;
                } else if (action == 0 || !this.cBO) {
                    int actionIndex = motionEvent.getActionIndex();
                    switch (action) {
                        case 0:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY();
                            this.cBO = false;
                            break;
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                this.cBO = false;
                                return this.cBO;
                            }
                            float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading()) {
                                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.cBO = z;
                                    if (this.cBO && aoW()) {
                                        this.cBR.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.cBO = z;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY(actionIndex);
                            this.cBO = false;
                            break;
                        case 6:
                            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                            if (motionEvent.getPointerId(action2) == this.mActivePointerId) {
                                this.mActivePointerId = motionEvent.getPointerId(action2 != 0 ? 0 : 1);
                                this.mLastMotionY = (int) motionEvent.getY(i);
                                this.cBO = false;
                                break;
                            }
                            break;
                    }
                    return this.cBO;
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
                if (this.cBO) {
                    this.cBO = false;
                    if (isReadyForPullDown()) {
                        if (this.cBK && this.cBP == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startRefreshing();
                            z = true;
                        } else if (!isPullRefreshing()) {
                            this.cBP = ILoadingLayout.State.RESET;
                            a(ILoadingLayout.State.RESET, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.cBQ == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    this.cBO = false;
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
                    this.cBO = false;
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
        this.cBK = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.cBL = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.cBM = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.cBK && this.cBG != null;
    }

    public boolean isPullLoadEnabled() {
        return this.cBL && this.cBH != null;
    }

    public boolean isScrollLoadEnabled() {
        return this.cBM;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.cBF = aVar;
    }

    public void eP(boolean z) {
        i(z, null);
    }

    public void i(boolean z, String str) {
        if (isPullRefreshing()) {
            this.cBP = ILoadingLayout.State.RESET;
            a(ILoadingLayout.State.RESET, true);
            setInterceptTouchEventEnabled(false);
            this.cBG.a(z, str, new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                            PullToRefreshBase.this.cBG.setState(ILoadingLayout.State.RESET);
                        }
                    }, PullToRefreshBase.this.getSmoothScrollDuration());
                    PullToRefreshBase.this.resetHeaderLayout();
                }
            });
        }
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.cBU;
    }

    public T getRefreshableView() {
        return this.cBR;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.cBG;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.cBH;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.cBG != null) {
            this.cBG.setLastUpdatedLabel(charSequence);
        }
        if (this.cBH != null) {
            this.cBH.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.cBT = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.cBG != null) {
            this.cBG.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.cBG != null) {
            this.cBG.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.cBG != null) {
            this.cBG.setHeaderBigBackground(i);
        }
    }

    public void a(final boolean z, long j, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.4
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.cBG.getRefreshingHeight();
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

    protected boolean aoW() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        aoY();
        LoadingLayout loadingLayout = null;
        switch (this.cBE) {
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
        if (this.cBS != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cBS.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.cBS.requestLayout();
            }
        }
    }

    public void setEmptyView(View view) {
        if (this.cBS != null) {
            this.cBS.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        this.cBS = new FrameLayout(context);
        this.cBS.addView(t, -1, -1);
        addView(this.cBS, new LinearLayout.LayoutParams(-1, com.baidu.swan.apps.u.a.aga().getSwitch("swan_app_refresh_ngwebview_height_switch", false) ? 10 : -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.cBG;
        LoadingLayout loadingLayout2 = this.cBH;
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
            if (this.cBG != null) {
                this.cBG.gv(0);
            }
        } else if (this.cBT <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.cBT) {
            am(0, -((int) f));
            if (this.cBG != null) {
                this.cBG.gv(-getScrollY());
                if (this.cBI != 0) {
                    this.cBG.onPull(Math.abs(getScrollYValue()) / this.cBI);
                }
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing()) {
                if (this.cBG != null && abs > this.cBG.getCanRefreshPullLength()) {
                    this.cBP = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.cBP = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.cBG != null) {
                    this.cBG.setState(this.cBP);
                }
                a(this.cBP, true);
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
        if (this.cBH != null && this.cBJ != 0) {
            this.cBH.onPull(Math.abs(getScrollYValue()) / this.cBJ);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.cBJ) {
                this.cBQ = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.cBQ = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.cBH != null) {
                this.cBH.setState(this.cBQ);
            }
            a(this.cBQ, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.cBG.getRefreshingHeight()) {
            gA(0);
        } else if (isPullRefreshing) {
            gA(-this.cBG.getRefreshingHeight());
        } else {
            gA(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.cBJ) {
            gA(0);
        } else if (isPullLoading) {
            gA(this.cBJ);
        } else {
            gA(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.cBP == ILoadingLayout.State.REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.cBQ == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        eQ(true);
    }

    private void eQ(boolean z) {
        if (!isPullRefreshing()) {
            this.cBP = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.cBG != null) {
                this.cBG.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.cBF != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.cBF.a(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoading() {
        if (!isPullLoading()) {
            this.cBQ = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.cBH != null) {
                this.cBH.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.cBF != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.cBF.b(PullToRefreshBase.this);
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

    private void gA(int i) {
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
            this.cBG.gv(-currY);
            this.cBH.onPull(Math.abs(getScrollYValue()) / this.cBJ);
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.cBN = z;
    }

    private boolean aoX() {
        return this.cBN;
    }

    protected void aoY() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
