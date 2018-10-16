package com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh;

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
import com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes2.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout implements IPullToRefresh<T> {
    private static final boolean DEBUG = false;
    private static final float OFFSET_RADIO = 1.5f;
    private static final int SCROLL_DURATION = 300;
    private static final String TAG = "PullToRefreshBase";
    private int mActivePointerId;
    RefreshableViewFactory<T> mFactory;
    private int mFooterHeight;
    private LoadingLayout mFooterLayout;
    private int mHeaderHeight;
    private LoadingLayout mHeaderLayout;
    protected HEADERTYPE mHeaderType;
    private boolean mInterceptEventEnable;
    private boolean mIsHandledTouchEvent;
    private float mLastMotionY;
    private int mMaxPullOffset;
    private ILoadingLayout.State mPullDownState;
    private boolean mPullLoadEnabled;
    private boolean mPullRefreshEnabled;
    private ILoadingLayout.State mPullUpState;
    private OnRefreshListener<T> mRefreshListener;
    protected T mRefreshableView;
    private FrameLayout mRefreshableViewWrapper;
    private boolean mScrollLoadEnabled;
    private Scroller mScroller;
    private int mTouchSlop;

    /* loaded from: classes2.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER,
        Common_STYLE_HEADER,
        AIAPPS_HEADER
    }

    /* loaded from: classes2.dex */
    public interface OnRefreshListener<V extends View> {
        void onPullDownToRefresh(PullToRefreshBase<V> pullToRefreshBase);

        void onPullUpToRefresh(PullToRefreshBase<V> pullToRefreshBase);
    }

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    protected abstract boolean isReadyForPullDown();

    protected abstract boolean isReadyForPullUp();

    public PullToRefreshBase(Context context, RefreshableViewFactory<T> refreshableViewFactory) {
        this(context, refreshableViewFactory, HEADERTYPE.Common_STYLE_HEADER);
    }

    public PullToRefreshBase(Context context, RefreshableViewFactory<T> refreshableViewFactory, HEADERTYPE headertype) {
        super(context);
        this.mHeaderType = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.mPullRefreshEnabled = true;
        this.mPullLoadEnabled = false;
        this.mScrollLoadEnabled = false;
        this.mInterceptEventEnable = true;
        this.mIsHandledTouchEvent = false;
        this.mPullDownState = ILoadingLayout.State.NONE;
        this.mPullUpState = ILoadingLayout.State.NONE;
        this.mMaxPullOffset = -1;
        this.mActivePointerId = -1;
        this.mFactory = refreshableViewFactory;
        this.mHeaderType = headertype;
        init(context, null);
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.mHeaderType = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.mPullRefreshEnabled = true;
        this.mPullLoadEnabled = false;
        this.mScrollLoadEnabled = false;
        this.mInterceptEventEnable = true;
        this.mIsHandledTouchEvent = false;
        this.mPullDownState = ILoadingLayout.State.NONE;
        this.mPullUpState = ILoadingLayout.State.NONE;
        this.mMaxPullOffset = -1;
        this.mActivePointerId = -1;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHeaderType = HEADERTYPE.Common_STYLE_HEADER;
        this.mLastMotionY = -1.0f;
        this.mPullRefreshEnabled = true;
        this.mPullLoadEnabled = false;
        this.mScrollLoadEnabled = false;
        this.mInterceptEventEnable = true;
        this.mIsHandledTouchEvent = false;
        this.mPullDownState = ILoadingLayout.State.NONE;
        this.mPullUpState = ILoadingLayout.State.NONE;
        this.mMaxPullOffset = -1;
        this.mActivePointerId = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mScroller = new Scroller(context);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mHeaderLayout = createHeaderLoadingLayout(context, attributeSet);
        this.mFooterLayout = createFooterLoadingLayout(context, attributeSet);
        this.mRefreshableView = createRefreshableView(context, attributeSet);
        if (this.mRefreshableView == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.mRefreshableView);
        addHeaderAndFooter(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PullToRefreshBase.this.refreshLoadingViewsSize();
                PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshLoadingViewsSize() {
        int contentSize = this.mHeaderLayout != null ? this.mHeaderLayout.getContentSize() : 0;
        int contentSize2 = this.mFooterLayout != null ? this.mFooterLayout.getContentSize() : 0;
        int i = contentSize < 0 ? 0 : contentSize;
        int i2 = contentSize2 < 0 ? 0 : contentSize2;
        this.mHeaderHeight = i;
        this.mFooterHeight = i2;
        int measuredHeight = this.mHeaderLayout != null ? this.mHeaderLayout.getMeasuredHeight() : 0;
        int measuredHeight2 = this.mFooterLayout != null ? this.mFooterLayout.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.mFooterHeight;
        }
        setPadding(getPaddingLeft(), -measuredHeight, getPaddingRight(), -measuredHeight2);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        refreshLoadingViewsSize();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase.2
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
        if (isInterceptTouchEventEnabled()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.mIsHandledTouchEvent = false;
                    return false;
                } else if (action == 0 || !this.mIsHandledTouchEvent) {
                    int actionIndex = motionEvent.getActionIndex();
                    switch (action) {
                        case 0:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY();
                            this.mIsHandledTouchEvent = false;
                            break;
                        case 2:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex < 0) {
                                this.mIsHandledTouchEvent = false;
                                return this.mIsHandledTouchEvent;
                            }
                            float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading()) {
                                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y > 0.5f) {
                                        z = true;
                                    }
                                    this.mIsHandledTouchEvent = z;
                                    if (this.mIsHandledTouchEvent && isNeedTransferEvent()) {
                                        this.mRefreshableView.onTouchEvent(motionEvent);
                                        break;
                                    }
                                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                                    if (Math.abs(getScrollYValue()) > 0 || y < -0.5f) {
                                        z = true;
                                    }
                                    this.mIsHandledTouchEvent = z;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY(actionIndex);
                            this.mIsHandledTouchEvent = false;
                            break;
                        case 6:
                            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                            if (motionEvent.getPointerId(action2) == this.mActivePointerId) {
                                this.mActivePointerId = motionEvent.getPointerId(action2 != 0 ? 0 : 1);
                                this.mLastMotionY = (int) motionEvent.getY(i);
                                this.mIsHandledTouchEvent = false;
                                break;
                            }
                            break;
                    }
                    return this.mIsHandledTouchEvent;
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
                if (this.mIsHandledTouchEvent) {
                    this.mIsHandledTouchEvent = false;
                    if (isReadyForPullDown()) {
                        if (this.mPullRefreshEnabled && this.mPullDownState == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                            startRefreshing();
                            z = true;
                        } else if (!isPullRefreshing()) {
                            this.mPullDownState = ILoadingLayout.State.RESET;
                            onStateChanged(ILoadingLayout.State.RESET, true);
                        }
                        resetHeaderLayout();
                        return z;
                    } else if (isReadyForPullUp()) {
                        if (isPullLoadEnabled() && this.mPullUpState == ILoadingLayout.State.RELEASE_TO_REFRESH) {
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
                    this.mIsHandledTouchEvent = false;
                    return false;
                }
                float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                this.mLastMotionY = motionEvent.getY(findPointerIndex);
                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                    pullHeaderLayout(y / OFFSET_RADIO);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / OFFSET_RADIO);
                    return true;
                } else {
                    this.mIsHandledTouchEvent = false;
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

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefresh
    public void setPullRefreshEnabled(boolean z) {
        this.mPullRefreshEnabled = z;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefresh
    public void setPullLoadEnabled(boolean z) {
        this.mPullLoadEnabled = z;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefresh
    public void setScrollLoadEnabled(boolean z) {
        this.mScrollLoadEnabled = z;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefresh
    public boolean isPullRefreshEnabled() {
        return this.mPullRefreshEnabled && this.mHeaderLayout != null;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefresh
    public boolean isPullLoadEnabled() {
        return this.mPullLoadEnabled && this.mFooterLayout != null;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefresh
    public boolean isScrollLoadEnabled() {
        return this.mScrollLoadEnabled;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefresh
    public void setOnRefreshListener(OnRefreshListener<T> onRefreshListener) {
        this.mRefreshListener = onRefreshListener;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefresh
    @Deprecated
    public void onPullDownRefreshComplete() {
        onPullDownRefreshComplete(false);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefresh
    public void onPullDownRefreshComplete(boolean z) {
        onPullDownRefreshComplete(z, null);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefresh
    public void onPullDownRefreshComplete(boolean z, String str) {
        if (isPullRefreshing()) {
            this.mPullDownState = ILoadingLayout.State.RESET;
            onStateChanged(ILoadingLayout.State.RESET, true);
            setInterceptTouchEventEnabled(false);
            this.mHeaderLayout.onPullRefreshComplete(z, str, new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.postDelayed(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                            PullToRefreshBase.this.mHeaderLayout.setState(ILoadingLayout.State.RESET);
                        }
                    }, PullToRefreshBase.this.getSmoothScrollDuration());
                    PullToRefreshBase.this.resetHeaderLayout();
                }
            });
        }
    }

    public RefreshableViewFactory<T> getRefreshableFactory() {
        return this.mFactory;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefresh
    public void onPullUpRefreshComplete() {
        if (isPullLoading()) {
            this.mPullUpState = ILoadingLayout.State.RESET;
            onStateChanged(ILoadingLayout.State.RESET, false);
            postDelayed(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase.4
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                    PullToRefreshBase.this.mFooterLayout.setState(ILoadingLayout.State.RESET);
                }
            }, getSmoothScrollDuration());
            resetFooterLayout();
            setInterceptTouchEventEnabled(false);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefresh
    public T getRefreshableView() {
        return this.mRefreshableView;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefresh
    public LoadingLayout getHeaderLoadingLayout() {
        return this.mHeaderLayout;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefresh
    public LoadingLayout getFooterLoadingLayout() {
        return this.mFooterLayout;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefresh
    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.mHeaderLayout != null) {
            this.mHeaderLayout.setLastUpdatedLabel(charSequence);
        }
        if (this.mFooterLayout != null) {
            this.mFooterLayout.setLastUpdatedLabel(charSequence);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefresh
    public void setMaxPullOffset(int i) {
        this.mMaxPullOffset = i;
    }

    public void setHeaderBackgroundColor(int i) {
        if (this.mHeaderLayout != null) {
            this.mHeaderLayout.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        if (this.mHeaderLayout != null) {
            this.mHeaderLayout.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        if (this.mHeaderLayout != null) {
            this.mHeaderLayout.setHeaderBigBackground(i);
        }
    }

    public void doPullRefreshing(final boolean z, long j, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase.5
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.mHeaderLayout.getRefreshingHeight();
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
        doPullRefreshing(z, j, null);
    }

    public void showPullRefreshing(final boolean z, long j) {
        postDelayed(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase.6
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBase.this.mHeaderLayout.getRefreshingHeight();
                int i2 = z ? 300 : 0;
                PullToRefreshBase.this.startRefreshing(false);
                PullToRefreshBase.this.smoothScrollTo(i, i2);
            }
        }, j);
    }

    protected boolean isNeedTransferEvent() {
        return true;
    }

    protected LoadingLayout createHeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        setHeaderType();
        LoadingLayout loadingLayout = null;
        switch (this.mHeaderType) {
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
            case AIAPPS_HEADER:
                loadingLayout = new NeutralHeaderLoadingLayout(context);
                break;
        }
        if (loadingLayout == null) {
            return new HeaderLoadingLayout(context);
        }
        return loadingLayout;
    }

    protected LoadingLayout createFooterLoadingLayout(Context context, AttributeSet attributeSet) {
        return new FooterLoadingLayout(context);
    }

    protected int getSmoothScrollDuration() {
        return 300;
    }

    protected void refreshRefreshableViewSize(int i, int i2) {
        if (this.mRefreshableViewWrapper != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mRefreshableViewWrapper.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.mRefreshableViewWrapper.requestLayout();
            }
        }
    }

    public void setEmptyView(View view) {
        if (this.mRefreshableViewWrapper != null) {
            this.mRefreshableViewWrapper.addView(view, -1, -1);
        }
    }

    protected void addRefreshableView(Context context, T t) {
        this.mRefreshableViewWrapper = new FrameLayout(context);
        this.mRefreshableViewWrapper.addView(t, -1, -1);
        addView(this.mRefreshableViewWrapper, new LinearLayout.LayoutParams(-1, 10));
    }

    protected void addHeaderAndFooter(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LoadingLayout loadingLayout = this.mHeaderLayout;
        LoadingLayout loadingLayout2 = this.mFooterLayout;
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
            setScrollTo(0, 0);
            this.mHeaderLayout.onPullLength(0);
        } else if (this.mMaxPullOffset <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.mMaxPullOffset) {
            setScrollBy(0, -((int) f));
            this.mHeaderLayout.onPullLength(-getScrollY());
            if (this.mHeaderLayout != null && this.mHeaderHeight != 0) {
                this.mHeaderLayout.onPull(Math.abs(getScrollYValue()) / this.mHeaderHeight);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing()) {
                if (abs > this.mHeaderLayout.getCanRefreshPullLength()) {
                    this.mPullDownState = ILoadingLayout.State.RELEASE_TO_REFRESH;
                } else {
                    this.mPullDownState = ILoadingLayout.State.PULL_TO_REFRESH;
                }
                this.mHeaderLayout.setState(this.mPullDownState);
                onStateChanged(this.mPullDownState, true);
            }
        }
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            setScrollTo(0, 0);
            return;
        }
        setScrollBy(0, -((int) f));
        if (this.mFooterLayout != null && this.mFooterHeight != 0) {
            this.mFooterLayout.onPull(Math.abs(getScrollYValue()) / this.mFooterHeight);
        }
        int abs = Math.abs(getScrollYValue());
        if (isPullLoadEnabled() && !isPullLoading()) {
            if (abs > this.mFooterHeight) {
                this.mPullUpState = ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.mPullUpState = ILoadingLayout.State.PULL_TO_REFRESH;
            }
            this.mFooterLayout.setState(this.mPullUpState);
            onStateChanged(this.mPullUpState, false);
        }
    }

    protected void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        if (isPullRefreshing && abs <= this.mHeaderLayout.getRefreshingHeight()) {
            smoothScrollTo(0);
        } else if (isPullRefreshing) {
            smoothScrollTo(-this.mHeaderLayout.getRefreshingHeight());
        } else {
            smoothScrollTo(0);
        }
    }

    protected void resetFooterLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullLoading = isPullLoading();
        if (isPullLoading && abs <= this.mFooterHeight) {
            smoothScrollTo(0);
        } else if (isPullLoading) {
            smoothScrollTo(this.mFooterHeight);
        } else {
            smoothScrollTo(0);
        }
    }

    protected boolean isPullRefreshing() {
        return this.mPullDownState == ILoadingLayout.State.REFRESHING;
    }

    protected boolean isPullDownIdle() {
        return this.mPullDownState == ILoadingLayout.State.NONE || this.mPullDownState == ILoadingLayout.State.RESET;
    }

    protected boolean isPullLoading() {
        return this.mPullUpState == ILoadingLayout.State.REFRESHING;
    }

    protected void startRefreshing() {
        startRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRefreshing(boolean z) {
        if (!isPullRefreshing()) {
            this.mPullDownState = ILoadingLayout.State.REFRESHING;
            onStateChanged(ILoadingLayout.State.REFRESHING, true);
            if (this.mHeaderLayout != null) {
                this.mHeaderLayout.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.mRefreshListener != null) {
                postDelayed(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase.7
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.mRefreshListener.onPullDownToRefresh(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoading() {
        if (!isPullLoading()) {
            this.mPullUpState = ILoadingLayout.State.REFRESHING;
            onStateChanged(ILoadingLayout.State.REFRESHING, false);
            if (this.mFooterLayout != null) {
                this.mFooterLayout.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.mRefreshListener != null) {
                postDelayed(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase.8
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBase.this.mRefreshListener.onPullUpToRefresh(PullToRefreshBase.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void onStateChanged(ILoadingLayout.State state, boolean z) {
    }

    private void setScrollTo(int i, int i2) {
        scrollTo(i, i2);
    }

    private void setScrollBy(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void smoothScrollTo(int i) {
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
            this.mHeaderLayout.onPullLength(-currY);
            this.mFooterLayout.onPull(Math.abs(getScrollYValue()) / this.mFooterHeight);
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.mInterceptEventEnable = z;
    }

    private boolean isInterceptTouchEventEnabled() {
        return this.mInterceptEventEnable;
    }

    protected void setHeaderType() {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void superRequestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
    }
}
