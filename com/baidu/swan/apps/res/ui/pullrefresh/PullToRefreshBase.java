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
/* loaded from: classes3.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    private static final boolean DEBUG = b.DEBUG;
    private boolean cPA;
    private boolean cPB;
    private boolean cPC;
    private boolean cPD;
    private ILoadingLayout.State cPE;
    private ILoadingLayout.State cPF;
    protected T cPG;
    private FrameLayout cPH;
    private int cPI;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> cPJ;
    protected HEADERTYPE cPt;
    private a<T> cPu;
    private LoadingLayout cPv;
    private LoadingLayout cPw;
    private int cPx;
    private int cPy;
    private boolean cPz;
    private int mActivePointerId;
    private float mLastMotionY;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes3.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER,
        Common_STYLE_HEADER,
        SWAN_APP_HEADER
    }

    /* loaded from: classes3.dex */
    public interface a<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);

        void b(PullToRefreshBase<V> pullToRefreshBase);
    }

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    protected abstract boolean isReadyForPullDown();

    protected abstract boolean isReadyForPullUp();

    public PullToRefreshBase(Context context, com.baidu.swan.apps.res.ui.pullrefresh.a<T> aVar, HEADERTYPE headertype) {
        super(context);
        this.cPt = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.cPz = true;
        this.cPA = false;
        this.cPB = false;
        this.cPC = true;
        this.cPD = false;
        this.cPE = ILoadingLayout.State.NONE;
        this.cPF = ILoadingLayout.State.NONE;
        this.cPI = -1;
        this.mActivePointerId = -1;
        this.cPJ = aVar;
        this.cPt = headertype;
        init(context, null);
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.cPt = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.cPz = true;
        this.cPA = false;
        this.cPB = false;
        this.cPC = true;
        this.cPD = false;
        this.cPE = ILoadingLayout.State.NONE;
        this.cPF = ILoadingLayout.State.NONE;
        this.cPI = -1;
        this.mActivePointerId = -1;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cPt = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.cPz = true;
        this.cPA = false;
        this.cPB = false;
        this.cPC = true;
        this.cPD = false;
        this.cPE = ILoadingLayout.State.NONE;
        this.cPF = ILoadingLayout.State.NONE;
        this.cPI = -1;
        this.mActivePointerId = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mScroller = new Scroller(context);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.cPv = e(context, attributeSet);
        this.cPw = f(context, attributeSet);
        this.cPG = createRefreshableView(context, attributeSet);
        if (this.cPG == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.cPG);
        addHeaderAndFooter(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PullToRefreshBase.this.azA();
                PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azA() {
        int contentSize = this.cPv != null ? this.cPv.getContentSize() : 0;
        int contentSize2 = this.cPw != null ? this.cPw.getContentSize() : 0;
        int i = contentSize < 0 ? 0 : contentSize;
        int i2 = contentSize2 < 0 ? 0 : contentSize2;
        this.cPx = i;
        this.cPy = i2;
        int measuredHeight = this.cPv != null ? this.cPv.getMeasuredHeight() : 0;
        int measuredHeight2 = this.cPw != null ? this.cPw.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.cPy;
        }
        setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        azA();
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
        if (azC()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.cPD = false;
                    return false;
                } else if (action == 0 || !this.cPD) {
                    int actionIndex = motionEvent.getActionIndex();
                    switch (action) {
                        case 0:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY();
                            this.cPD = false;
                            break;
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                this.cPD = false;
                                return this.cPD;
                            }
                            float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading()) {
                                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.cPD = z;
                                    if (this.cPD && azB()) {
                                        this.cPG.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.cPD = z;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY(actionIndex);
                            this.cPD = false;
                            break;
                        case 6:
                            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                            if (motionEvent.getPointerId(action2) == this.mActivePointerId) {
                                this.mActivePointerId = motionEvent.getPointerId(action2 != 0 ? 0 : 1);
                                this.mLastMotionY = (int) motionEvent.getY(i);
                                this.cPD = false;
                                break;
                            }
                            break;
                    }
                    return this.cPD;
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
                if (this.cPD) {
                    this.cPD = false;
                    if (isReadyForPullDown()) {
                        if (this.cPz && this.cPE == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startRefreshing();
                            z = true;
                        } else if (!isPullRefreshing()) {
                            this.cPE = ILoadingLayout.State.RESET;
                            a(ILoadingLayout.State.RESET, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.cPF == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    this.cPD = false;
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
                    this.cPD = false;
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
        this.cPz = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.cPA = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.cPB = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.cPz && this.cPv != null;
    }

    public boolean isPullLoadEnabled() {
        return this.cPA && this.cPw != null;
    }

    public boolean isScrollLoadEnabled() {
        return this.cPB;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.cPu = aVar;
    }

    public void fq(boolean z) {
        i(z, null);
    }

    public void i(boolean z, String str) {
        if (isPullRefreshing()) {
            this.cPE = ILoadingLayout.State.RESET;
            a(ILoadingLayout.State.RESET, true);
            setInterceptTouchEventEnabled(false);
            this.cPv.a(z, str, new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                            PullToRefreshBase.this.cPv.setState(ILoadingLayout.State.RESET);
                        }
                    }, PullToRefreshBase.this.getSmoothScrollDuration());
                    PullToRefreshBase.this.resetHeaderLayout();
                }
            });
        }
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.cPJ;
    }

    public T getRefreshableView() {
        return this.cPG;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.cPv;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.cPw;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.cPv != null) {
            this.cPv.setLastUpdatedLabel(charSequence);
        }
        if (this.cPw != null) {
            this.cPw.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.cPI = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.cPv != null) {
            this.cPv.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.cPv != null) {
            this.cPv.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.cPv != null) {
            this.cPv.setHeaderBigBackground(i);
        }
    }

    public void a(final boolean z, long j, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.4
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.cPv.getRefreshingHeight();
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

    protected boolean azB() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        azD();
        LoadingLayout loadingLayout = null;
        switch (this.cPt) {
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
        if (this.cPH != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cPH.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.cPH.requestLayout();
            }
        }
    }

    public void setEmptyView(View view) {
        if (this.cPH != null) {
            this.cPH.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        this.cPH = new FrameLayout(context);
        this.cPH.addView(t, -1, -1);
        addView(this.cPH, new LinearLayout.LayoutParams(-1, getNgWebViewHeightSwitch() ? 10 : -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.cPv;
        LoadingLayout loadingLayout2 = this.cPw;
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
            if (this.cPv != null) {
                this.cPv.iV(0);
            }
        } else if (this.cPI <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.cPI) {
            ar(0, -((int) f));
            if (this.cPv != null) {
                this.cPv.iV(-getScrollY());
                if (this.cPx != 0) {
                    this.cPv.onPull(Math.abs(getScrollYValue()) / this.cPx);
                }
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing()) {
                if (this.cPv != null && abs > this.cPv.getCanRefreshPullLength()) {
                    this.cPE = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.cPE = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.cPv != null) {
                    this.cPv.setState(this.cPE);
                }
                a(this.cPE, true);
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
        if (this.cPw != null && this.cPy != 0) {
            this.cPw.onPull(Math.abs(getScrollYValue()) / this.cPy);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.cPy) {
                this.cPF = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.cPF = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.cPw != null) {
                this.cPw.setState(this.cPF);
            }
            a(this.cPF, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.cPv.getRefreshingHeight()) {
            jb(0);
        } else if (isPullRefreshing) {
            jb(-this.cPv.getRefreshingHeight());
        } else {
            jb(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.cPy) {
            jb(0);
        } else if (isPullLoading) {
            jb(this.cPy);
        } else {
            jb(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.cPE == ILoadingLayout.State.REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.cPF == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        fr(true);
    }

    private void fr(boolean z) {
        if (!isPullRefreshing()) {
            this.cPE = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.cPv != null) {
                this.cPv.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.cPu != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.cPu.a(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoading() {
        if (!isPullLoading()) {
            this.cPF = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.cPw != null) {
                this.cPw.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.cPu != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.cPu.b(PullToRefreshBase.this);
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

    private void jb(int i) {
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
            this.cPv.iV(-currY);
            this.cPw.onPull(Math.abs(getScrollYValue()) / this.cPy);
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.cPC = z;
    }

    private boolean azC() {
        return this.cPC;
    }

    protected void azD() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public static boolean getNgWebViewHeightSwitch() {
        return com.baidu.swan.apps.performance.b.b.awR() ? com.baidu.swan.apps.performance.b.b.getNgWebViewHeightSwitch() : com.baidu.swan.apps.t.a.apx().getSwitch("swan_app_refresh_ngwebview_height_switch", false);
    }
}
