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
    protected HEADERTYPE bIi;
    private a<T> bIj;
    private LoadingLayout bIk;
    private LoadingLayout bIl;
    private int bIm;
    private int bIn;
    private boolean bIo;
    private boolean bIp;
    private boolean bIq;
    private boolean bIr;
    private boolean bIs;
    private ILoadingLayout.State bIt;
    private ILoadingLayout.State bIu;
    protected T bIv;
    private FrameLayout bIw;
    private int bIx;
    com.baidu.swan.apps.res.ui.pullrefresh.a<T> bIy;
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
        this.bIi = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.bIo = true;
        this.bIp = false;
        this.bIq = false;
        this.bIr = true;
        this.bIs = false;
        this.bIt = ILoadingLayout.State.NONE;
        this.bIu = ILoadingLayout.State.NONE;
        this.bIx = -1;
        this.mActivePointerId = -1;
        this.bIy = aVar;
        this.bIi = headertype;
        init(context, null);
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.bIi = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.bIo = true;
        this.bIp = false;
        this.bIq = false;
        this.bIr = true;
        this.bIs = false;
        this.bIt = ILoadingLayout.State.NONE;
        this.bIu = ILoadingLayout.State.NONE;
        this.bIx = -1;
        this.mActivePointerId = -1;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bIi = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.bIo = true;
        this.bIp = false;
        this.bIq = false;
        this.bIr = true;
        this.bIs = false;
        this.bIt = ILoadingLayout.State.NONE;
        this.bIu = ILoadingLayout.State.NONE;
        this.bIx = -1;
        this.mActivePointerId = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mScroller = new Scroller(context);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.bIk = e(context, attributeSet);
        this.bIl = f(context, attributeSet);
        this.bIv = createRefreshableView(context, attributeSet);
        if (this.bIv == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.bIv);
        addHeaderAndFooter(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PullToRefreshBase.this.ZE();
                PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZE() {
        int contentSize = this.bIk != null ? this.bIk.getContentSize() : 0;
        int contentSize2 = this.bIl != null ? this.bIl.getContentSize() : 0;
        int i = contentSize < 0 ? 0 : contentSize;
        int i2 = contentSize2 < 0 ? 0 : contentSize2;
        this.bIm = i;
        this.bIn = i2;
        int measuredHeight = this.bIk != null ? this.bIk.getMeasuredHeight() : 0;
        int measuredHeight2 = this.bIl != null ? this.bIl.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.bIn;
        }
        setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ZE();
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
        if (ZG()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.bIs = false;
                    return false;
                } else if (action == 0 || !this.bIs) {
                    int actionIndex = motionEvent.getActionIndex();
                    switch (action) {
                        case 0:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY();
                            this.bIs = false;
                            break;
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                this.bIs = false;
                                return this.bIs;
                            }
                            float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading()) {
                                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.bIs = z;
                                    if (this.bIs && ZF()) {
                                        this.bIv.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.bIs = z;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY(actionIndex);
                            this.bIs = false;
                            break;
                        case 6:
                            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                            if (motionEvent.getPointerId(action2) == this.mActivePointerId) {
                                this.mActivePointerId = motionEvent.getPointerId(action2 != 0 ? 0 : 1);
                                this.mLastMotionY = (int) motionEvent.getY(i);
                                this.bIs = false;
                                break;
                            }
                            break;
                    }
                    return this.bIs;
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
                if (this.bIs) {
                    this.bIs = false;
                    if (isReadyForPullDown()) {
                        if (this.bIo && this.bIt == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startRefreshing();
                            z = true;
                        } else if (!isPullRefreshing()) {
                            this.bIt = ILoadingLayout.State.RESET;
                            a(ILoadingLayout.State.RESET, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.bIu == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    this.bIs = false;
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
                    this.bIs = false;
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
        this.bIo = z;
    }

    public void setPullLoadEnabled(boolean z) {
        this.bIp = z;
    }

    public void setScrollLoadEnabled(boolean z) {
        this.bIq = z;
    }

    public boolean isPullRefreshEnabled() {
        return this.bIo && this.bIk != null;
    }

    public boolean isPullLoadEnabled() {
        return this.bIp && this.bIl != null;
    }

    public boolean isScrollLoadEnabled() {
        return this.bIq;
    }

    public void setOnRefreshListener(a<T> aVar) {
        this.bIj = aVar;
    }

    public void dn(boolean z) {
        f(z, (String) null);
    }

    public void f(boolean z, String str) {
        if (isPullRefreshing()) {
            this.bIt = ILoadingLayout.State.RESET;
            a(ILoadingLayout.State.RESET, true);
            setInterceptTouchEventEnabled(false);
            this.bIk.a(z, str, new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                            PullToRefreshBase.this.bIk.setState(ILoadingLayout.State.RESET);
                        }
                    }, PullToRefreshBase.this.getSmoothScrollDuration());
                    PullToRefreshBase.this.resetHeaderLayout();
                }
            });
        }
    }

    public com.baidu.swan.apps.res.ui.pullrefresh.a<T> getRefreshableFactory() {
        return this.bIy;
    }

    public T getRefreshableView() {
        return this.bIv;
    }

    public LoadingLayout getHeaderLoadingLayout() {
        return this.bIk;
    }

    public LoadingLayout getFooterLoadingLayout() {
        return this.bIl;
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.bIk != null) {
            this.bIk.setLastUpdatedLabel(charSequence);
        }
        if (this.bIl != null) {
            this.bIl.setLastUpdatedLabel(charSequence);
        }
    }

    public void setMaxPullOffset(int i) {
        this.bIx = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.bIk != null) {
            this.bIk.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.bIk != null) {
            this.bIk.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.bIk != null) {
            this.bIk.setHeaderBigBackground(i);
        }
    }

    public void a(final boolean z, long j, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.4
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.bIk.getRefreshingHeight();
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

    protected boolean ZF() {
        return true;
    }

    protected LoadingLayout e(Context context, AttributeSet attributeSet) {
        ZH();
        LoadingLayout loadingLayout = null;
        switch (this.bIi) {
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
        if (this.bIw != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bIw.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.bIw.requestLayout();
            }
        }
    }

    public void setEmptyView(View view) {
        if (this.bIw != null) {
            this.bIw.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        this.bIw = new FrameLayout(context);
        this.bIw.addView(t, -1, -1);
        addView(this.bIw, new LinearLayout.LayoutParams(-1, 10));
    }

    protected void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.bIk;
        LoadingLayout loadingLayout2 = this.bIl;
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
            ad(0, 0);
            if (this.bIk != null) {
                this.bIk.ft(0);
            }
        } else if (this.bIx <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.bIx) {
            ae(0, -((int) f));
            if (this.bIk != null) {
                this.bIk.ft(-getScrollY());
                if (this.bIm != 0) {
                    this.bIk.onPull(Math.abs(getScrollYValue()) / this.bIm);
                }
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing()) {
                if (this.bIk != null && abs > this.bIk.getCanRefreshPullLength()) {
                    this.bIt = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.bIt = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                if (this.bIk != null) {
                    this.bIk.setState(this.bIt);
                }
                a(this.bIt, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            ad(0, 0);
            return;
        }
        ae(0, -((int) f));
        if (this.bIl != null && this.bIn != 0) {
            this.bIl.onPull(Math.abs(getScrollYValue()) / this.bIn);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.bIn) {
                this.bIu = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.bIu = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            if (this.bIl != null) {
                this.bIl.setState(this.bIu);
            }
            a(this.bIu, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.bIk.getRefreshingHeight()) {
            fy(0);
        } else if (isPullRefreshing) {
            fy(-this.bIk.getRefreshingHeight());
        } else {
            fy(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.bIn) {
            fy(0);
        } else if (isPullLoading) {
            fy(this.bIn);
        } else {
            fy(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.bIt == ILoadingLayout.State.REFRESHING;
    }

    protected boolean isPullLoading() {
        return this.bIu == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        m21do(true);
    }

    /* renamed from: do  reason: not valid java name */
    private void m21do(boolean z) {
        if (!isPullRefreshing()) {
            this.bIt = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, true);
            if (this.bIk != null) {
                this.bIk.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.bIj != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.bIj.a(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoading() {
        if (!isPullLoading()) {
            this.bIu = ILoadingLayout.State.REFRESHING;
            a(ILoadingLayout.State.REFRESHING, false);
            if (this.bIl != null) {
                this.bIl.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.bIj != null) {
                postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.bIj.b(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void a(ILoadingLayout.State state, boolean z) {
    }

    private void ad(int i, int i2) {
        scrollTo(i, i2);
    }

    private void ae(int i, int i2) {
        scrollBy(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getScrollYValue() {
        return getScrollY();
    }

    private void fy(int i) {
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
            this.bIk.ft(-currY);
            this.bIl.onPull(Math.abs(getScrollYValue()) / this.bIn);
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.bIr = z;
    }

    private boolean ZG() {
        return this.bIr;
    }

    protected void ZH() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
