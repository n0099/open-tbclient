package com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes2.dex */
public abstract class PullToRefreshBaseNew<T extends View> extends FrameLayout implements IPullToRefreshNew<T> {
    private static final int SCROLL_DURATION = 150;
    RefreshableViewFactory<T> mFactory;
    private int mFooterHeight;
    private LoadingLayout mFooterLayout;
    private int mHeaderHeight;
    private LoadingLayout mHeaderLayout;
    protected HEADERTYPE mHeaderType;
    private boolean mInterceptEventEnable;
    private boolean mIsHandledTouchEvent;
    private float mLastMotionY;
    private boolean mListeneParentScroll;
    private boolean mLongPullRefreshEnabled;
    private int mMaxPullOffset;
    private float mOffsetRadio;
    private ILoadingLayout.State mPullDownState;
    private boolean mPullLoadEnabled;
    private float mPullRatio;
    private boolean mPullRefreshEnabled;
    private ILoadingLayout.State mPullUpState;
    private OnRefreshListener<T> mRefreshListener;
    T mRefreshableView;
    private FrameLayout mRefreshableViewWrapper;
    private boolean mScrollLoadEnabled;
    private PullToRefreshBaseNew<T>.SmoothScrollRunnable mSmoothScrollRunnable;
    private int mTouchSlop;

    /* loaded from: classes2.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER
    }

    /* loaded from: classes2.dex */
    public interface OnRefreshListener<V extends View> {
        void onPullDownToLongRefresh(PullToRefreshBaseNew<V> pullToRefreshBaseNew);

        void onPullDownToRefresh(PullToRefreshBaseNew<V> pullToRefreshBaseNew);

        void onPullDownToRefreshCompleted(boolean z);

        void onPullUpToRefresh(PullToRefreshBaseNew<V> pullToRefreshBaseNew);
    }

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    protected abstract boolean isReadyForPullDown();

    protected abstract boolean isReadyForPullUp();

    public PullToRefreshBaseNew(Context context, RefreshableViewFactory<T> refreshableViewFactory) {
        super(context);
        this.mHeaderType = HEADERTYPE.STANDARD_HEADER;
        this.mOffsetRadio = 2.5f;
        this.mLastMotionY = -1.0f;
        this.mPullRefreshEnabled = true;
        this.mPullLoadEnabled = false;
        this.mScrollLoadEnabled = false;
        this.mInterceptEventEnable = true;
        this.mIsHandledTouchEvent = false;
        this.mPullDownState = ILoadingLayout.State.NONE;
        this.mPullUpState = ILoadingLayout.State.NONE;
        this.mMaxPullOffset = -1;
        this.mLongPullRefreshEnabled = false;
        this.mPullRatio = 1.0f;
        this.mFactory = refreshableViewFactory;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context) {
        super(context);
        this.mHeaderType = HEADERTYPE.STANDARD_HEADER;
        this.mOffsetRadio = 2.5f;
        this.mLastMotionY = -1.0f;
        this.mPullRefreshEnabled = true;
        this.mPullLoadEnabled = false;
        this.mScrollLoadEnabled = false;
        this.mInterceptEventEnable = true;
        this.mIsHandledTouchEvent = false;
        this.mPullDownState = ILoadingLayout.State.NONE;
        this.mPullUpState = ILoadingLayout.State.NONE;
        this.mMaxPullOffset = -1;
        this.mLongPullRefreshEnabled = false;
        this.mPullRatio = 1.0f;
        init(context, null);
    }

    public PullToRefreshBaseNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHeaderType = HEADERTYPE.STANDARD_HEADER;
        this.mOffsetRadio = 2.5f;
        this.mLastMotionY = -1.0f;
        this.mPullRefreshEnabled = true;
        this.mPullLoadEnabled = false;
        this.mScrollLoadEnabled = false;
        this.mInterceptEventEnable = true;
        this.mIsHandledTouchEvent = false;
        this.mPullDownState = ILoadingLayout.State.NONE;
        this.mPullUpState = ILoadingLayout.State.NONE;
        this.mMaxPullOffset = -1;
        this.mLongPullRefreshEnabled = false;
        this.mPullRatio = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mHeaderLayout = createHeaderLoadingLayout(context, attributeSet);
        this.mFooterLayout = createFooterLoadingLayout(context, attributeSet);
        this.mRefreshableView = createRefreshableView(context, attributeSet);
        if (this.mRefreshableView == null) {
            throw new NullPointerException("Refreshable view can not be null.");
        }
        addRefreshableView(context, this.mRefreshableView);
        addHeaderAndFooter(context);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (isInterceptTouchEventEnabled()) {
            if (isPullLoadEnabled() || isPullRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.mIsHandledTouchEvent = false;
                    return false;
                } else if (action == 0 || !this.mIsHandledTouchEvent) {
                    switch (action) {
                        case 0:
                            this.mLastMotionY = motionEvent.getY();
                            this.mIsHandledTouchEvent = false;
                            break;
                        case 2:
                            float y = motionEvent.getY() - this.mLastMotionY;
                            if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || isLongPullRefreshing()) {
                                this.mLastMotionY = motionEvent.getY();
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
        boolean z = false;
        boolean z2 = true;
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastMotionY = motionEvent.getY();
                this.mIsHandledTouchEvent = false;
                return false;
            case 1:
            case 3:
                if (this.mIsHandledTouchEvent) {
                    this.mIsHandledTouchEvent = false;
                    if (isReadyForPullDown()) {
                        if (this.mPullRefreshEnabled) {
                            if (this.mPullDownState == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                                startRefreshing();
                            } else if (this.mLongPullRefreshEnabled && this.mPullDownState == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                                startLongRefreshing();
                                if (this.mListeneParentScroll) {
                                    return true;
                                }
                            }
                            resetHeaderLayout();
                            return z2;
                        }
                        this.mPullDownState = ILoadingLayout.State.RESET;
                        onStateChanged(ILoadingLayout.State.RESET, true);
                        z2 = false;
                        resetHeaderLayout();
                        return z2;
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
                float y = motionEvent.getY() - this.mLastMotionY;
                this.mLastMotionY = motionEvent.getY();
                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                    pullHeaderLayout(y / this.mOffsetRadio);
                    return true;
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / this.mOffsetRadio);
                    return true;
                } else {
                    this.mIsHandledTouchEvent = false;
                    return false;
                }
            default:
                return false;
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefreshNew
    public void setPullRefreshEnabled(boolean z) {
        this.mPullRefreshEnabled = z;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefreshNew
    public void setPullLoadEnabled(boolean z) {
        this.mPullLoadEnabled = z;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefreshNew
    public void setScrollLoadEnabled(boolean z) {
        this.mScrollLoadEnabled = z;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefreshNew
    public boolean isPullRefreshEnabled() {
        return this.mPullRefreshEnabled && this.mHeaderLayout != null;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefreshNew
    public boolean isPullLoadEnabled() {
        return this.mPullLoadEnabled && this.mFooterLayout != null;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefreshNew
    public boolean isScrollLoadEnabled() {
        return this.mScrollLoadEnabled;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefreshNew
    public void setOnRefreshListener(OnRefreshListener<T> onRefreshListener) {
        this.mRefreshListener = onRefreshListener;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefreshNew
    public void onPullDownRefreshComplete() {
        if (isPullRefreshing()) {
            this.mPullDownState = ILoadingLayout.State.RESET;
            onStateChanged(ILoadingLayout.State.RESET, true);
            postDelayed(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBaseNew.1
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBaseNew.this.setInterceptTouchEventEnabled(true);
                    PullToRefreshBaseNew.this.mHeaderLayout.setState(ILoadingLayout.State.RESET);
                }
            }, getSmoothScrollDuration());
            resetHeaderLayout();
            setInterceptTouchEventEnabled(false);
        }
        if (this.mRefreshListener != null) {
            this.mRefreshListener.onPullDownToRefreshCompleted(true);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefreshNew
    public void onPullDownLongRefreshComplete() {
        if (isLongPullRefreshing()) {
            this.mPullDownState = ILoadingLayout.State.RESET;
            onStateChanged(ILoadingLayout.State.RESET, true);
            postDelayed(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBaseNew.2
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBaseNew.this.setInterceptTouchEventEnabled(true);
                    PullToRefreshBaseNew.this.mHeaderLayout.setState(ILoadingLayout.State.RESET);
                }
            }, getSmoothScrollDuration());
            if (!this.mListeneParentScroll) {
                resetHeaderLayout();
            }
            setInterceptTouchEventEnabled(false);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefreshNew
    public void onPullUpRefreshComplete() {
        if (isPullLoading()) {
            this.mPullUpState = ILoadingLayout.State.RESET;
            onStateChanged(ILoadingLayout.State.RESET, false);
            postDelayed(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBaseNew.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBaseNew.this.setInterceptTouchEventEnabled(true);
                    PullToRefreshBaseNew.this.mFooterLayout.setState(ILoadingLayout.State.RESET);
                }
            }, getSmoothScrollDuration());
            resetFooterLayout();
            setInterceptTouchEventEnabled(false);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefreshNew
    public T getRefreshableView() {
        return this.mRefreshableView;
    }

    public RefreshableViewFactory<T> getRefreshableFactory() {
        return this.mFactory;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefreshNew
    public LoadingLayout getHeaderLoadingLayout() {
        return this.mHeaderLayout;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefreshNew
    public LoadingLayout getFooterLoadingLayout() {
        return this.mFooterLayout;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefreshNew
    public void setLastUpdatedLabel(CharSequence charSequence) {
        if (this.mHeaderLayout != null) {
            this.mHeaderLayout.setLastUpdatedLabel(charSequence);
        }
        if (this.mFooterLayout != null) {
            this.mFooterLayout.setLastUpdatedLabel(charSequence);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefreshNew
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

    public void doPullRefreshing(final boolean z, long j, final Runnable runnable, final boolean z2) {
        postDelayed(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBaseNew.4
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBaseNew.this.startRefreshing();
                if (z2) {
                    PullToRefreshBaseNew.this.smoothScrollTo(-PullToRefreshBaseNew.this.mHeaderHeight, z ? 150 : 0, 0L);
                }
                if (runnable != null) {
                    PullToRefreshBaseNew.this.post(runnable);
                }
            }
        }, j);
    }

    public void doPullRefreshing(boolean z, long j) {
        doPullRefreshing(z, j, null, true);
    }

    public void doPullRefreshing(boolean z, boolean z2) {
        doPullRefreshing(z, 0L, null, z2);
    }

    public void showPullRefreshing(final boolean z, long j) {
        postDelayed(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBaseNew.5
            @Override // java.lang.Runnable
            public void run() {
                int i = -PullToRefreshBaseNew.this.mHeaderHeight;
                int i2 = z ? 150 : 0;
                PullToRefreshBaseNew.this.startRefreshing(false);
                PullToRefreshBaseNew.this.smoothScrollTo(i, i2, 0L);
            }
        }, j);
    }

    public void pullDownWithoutAnim(boolean z) {
        startRefreshing(false);
        if (getScrollY() != (-this.mHeaderHeight)) {
            setScrollTo(0, -this.mHeaderHeight);
        }
        if (z && this.mRefreshListener != null) {
            this.mRefreshListener.onPullUpToRefresh(this);
        }
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
        }
        if (loadingLayout == null) {
            return new HeaderLoadingLayout(context);
        }
        return loadingLayout;
    }

    protected LoadingLayout createFooterLoadingLayout(Context context, AttributeSet attributeSet) {
        return new FooterLoadingLayout(context);
    }

    protected long getSmoothScrollDuration() {
        return 150L;
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
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    protected void addHeaderAndFooter(Context context) {
        LoadingLayout loadingLayout = this.mHeaderLayout;
        LoadingLayout loadingLayout2 = this.mFooterLayout;
        if (loadingLayout != null) {
            if (this == loadingLayout.getParent()) {
                removeView(loadingLayout);
            }
            addView(loadingLayout, 0, new FrameLayout.LayoutParams(-1, -2));
        }
        if (loadingLayout2 != null) {
            if (this == loadingLayout2.getParent()) {
                removeView(loadingLayout2);
            }
            addView(loadingLayout2, -1, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mHeaderLayout != null) {
            this.mHeaderLayout.layout(this.mHeaderLayout.getLeft(), this.mHeaderLayout.getTop() - this.mHeaderLayout.getHeight(), this.mHeaderLayout.getRight(), this.mHeaderLayout.getBottom() - this.mHeaderLayout.getHeight());
            this.mHeaderHeight = this.mHeaderLayout.getContentSize();
        }
        if (this.mFooterLayout != null && this.mRefreshableView != null) {
            this.mFooterLayout.layout(this.mFooterLayout.getLeft(), this.mRefreshableView.getBottom(), this.mFooterLayout.getRight(), this.mRefreshableView.getBottom() + this.mFooterLayout.getHeight());
            this.mFooterHeight = this.mFooterLayout.getContentSize();
        }
    }

    public void onParentScrollChanged(int i, int i2) {
        if (this.mListeneParentScroll) {
            int scrollYValue = getScrollYValue();
            if (scrollYValue < 0) {
                setScrollBy(0, i - i2);
            } else if (scrollYValue > 0) {
                setScrollTo(0, 0);
            }
            if (i2 == 0 && getScrollYValue() != 0) {
                smoothScrollTo(0);
            }
        }
    }

    public void setListenParentScroll(boolean z) {
        this.mListeneParentScroll = z;
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            setScrollTo(0, 0);
        } else if (this.mMaxPullOffset <= 0 || f <= 0.0f || Math.abs(scrollYValue) < this.mMaxPullOffset) {
            setScrollBy(0, -((int) f));
            if (this.mHeaderLayout != null && this.mHeaderHeight != 0) {
                this.mHeaderLayout.onPull(Math.abs(getScrollYValue()) / this.mHeaderHeight);
            }
            int abs = Math.abs(getScrollYValue());
            if (isPullRefreshEnabled() && !isPullRefreshing() && !isLongPullRefreshing()) {
                if (this.mLongPullRefreshEnabled && abs > this.mHeaderHeight * this.mPullRatio * 2.0f) {
                    this.mPullDownState = ILoadingLayout.State.RELEASE_TO_LONG_REFRESH;
                } else if (abs > this.mHeaderHeight * this.mPullRatio) {
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
        boolean isLongPullRefreshing = isLongPullRefreshing();
        if ((isPullRefreshing || isLongPullRefreshing) && abs <= this.mHeaderHeight) {
            smoothScrollTo(0);
        } else if (isPullRefreshing || isLongPullRefreshing) {
            smoothScrollTo(-this.mHeaderHeight);
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

    protected boolean isLongPullRefreshing() {
        return this.mPullDownState == ILoadingLayout.State.LONG_REFRESHING;
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
        if (!isPullRefreshing() && !isLongPullRefreshing()) {
            this.mPullDownState = ILoadingLayout.State.REFRESHING;
            onStateChanged(ILoadingLayout.State.REFRESHING, true);
            if (this.mHeaderLayout != null) {
                this.mHeaderLayout.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.mRefreshListener != null) {
                postDelayed(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBaseNew.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.mRefreshListener.onPullDownToRefresh(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLongRefreshing() {
        startLongRefreshing(true);
    }

    private void startLongRefreshing(boolean z) {
        if (!isPullRefreshing() && !isLongPullRefreshing()) {
            this.mPullDownState = ILoadingLayout.State.LONG_REFRESHING;
            onStateChanged(this.mPullDownState, true);
            if (this.mHeaderLayout != null) {
                this.mHeaderLayout.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (z) {
            }
            if (this.mRefreshListener != null) {
                postDelayed(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBaseNew.7
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.mRefreshListener.onPullDownToLongRefresh(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void startLoading() {
        if (!isPullLoading()) {
            this.mPullUpState = ILoadingLayout.State.REFRESHING;
            onStateChanged(ILoadingLayout.State.REFRESHING, false);
            if (this.mFooterLayout != null) {
                this.mFooterLayout.setState(ILoadingLayout.State.REFRESHING);
            }
            if (this.mRefreshListener != null) {
                postDelayed(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBaseNew.8
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.mRefreshListener.onPullUpToRefresh(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    protected void onStateChanged(ILoadingLayout.State state, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollTo(int i, int i2) {
        scrollTo(i, i2);
    }

    private void setScrollBy(int i, int i2) {
        scrollBy(i, i2);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private void smoothScrollTo(int i) {
        smoothScrollTo(i, getSmoothScrollDuration(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void smoothScrollTo(int i, long j, long j2) {
        if (this.mSmoothScrollRunnable != null) {
            this.mSmoothScrollRunnable.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            this.mSmoothScrollRunnable = new SmoothScrollRunnable(scrollYValue, i, j);
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(this.mSmoothScrollRunnable, j2);
            } else {
                post(this.mSmoothScrollRunnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.mInterceptEventEnable = z;
    }

    private boolean isInterceptTouchEventEnabled() {
        return this.mInterceptEventEnable;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.mLongPullRefreshEnabled = z;
    }

    public void setPullRatio(float f) {
        this.mPullRatio = Math.max(f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class SmoothScrollRunnable implements Runnable {
        private final long mDuration;
        private final int mScrollFromY;
        private final int mScrollToY;
        private boolean mContinueRunning = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;
        private final Interpolator mInterpolator = new DecelerateInterpolator();

        public SmoothScrollRunnable(int i, int i2, long j) {
            this.mScrollFromY = i;
            this.mScrollToY = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                PullToRefreshBaseNew.this.setScrollTo(0, this.mScrollToY);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.mScrollFromY - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.mScrollFromY - this.mScrollToY));
                PullToRefreshBaseNew.this.setScrollTo(0, this.mCurrentY);
            }
            if (this.mContinueRunning && this.mScrollToY != this.mCurrentY) {
                PullToRefreshBaseNew.this.postDelayed(this, 16L);
            }
        }

        public void stop() {
            this.mContinueRunning = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
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

    public void setOffsetRadio(float f) {
        this.mOffsetRadio = f;
    }
}
