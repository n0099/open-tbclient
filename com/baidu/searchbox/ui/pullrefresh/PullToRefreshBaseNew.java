package com.baidu.searchbox.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.searchbox.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes4.dex */
public abstract class PullToRefreshBaseNew<T extends View> extends FrameLayout implements IPullToRefreshNew<T> {
    public static final int SCROLL_DURATION = 150;
    public RefreshableViewFactory<T> mFactory;
    public int mFooterHeight;
    public LoadingLayout mFooterLayout;
    public int mHeaderHeight;
    public LoadingLayout mHeaderLayout;
    public HEADERTYPE mHeaderType;
    public boolean mInterceptEventEnable;
    public boolean mIsHandledTouchEvent;
    public float mLastMotionY;
    public boolean mListeneParentScroll;
    public boolean mLongPullRefreshEnabled;
    public int mMaxPullOffset;
    public float mOffsetRadio;
    public ILoadingLayout.State mPullDownState;
    public boolean mPullLoadEnabled;
    public float mPullRatio;
    public boolean mPullRefreshEnabled;
    public ILoadingLayout.State mPullUpState;
    public OnRefreshListener<T> mRefreshListener;
    public T mRefreshableView;
    public FrameLayout mRefreshableViewWrapper;
    public boolean mScrollLoadEnabled;
    public PullToRefreshBaseNew<T>.SmoothScrollRunnable mSmoothScrollRunnable;
    public int mTouchSlop;

    /* loaded from: classes4.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER
    }

    /* loaded from: classes4.dex */
    public interface OnRefreshListener<V extends View> {
        void onPullDownToLongRefresh(PullToRefreshBaseNew<V> pullToRefreshBaseNew);

        void onPullDownToRefresh(PullToRefreshBaseNew<V> pullToRefreshBaseNew);

        void onPullDownToRefreshCompleted(boolean z);

        void onPullUpToRefresh(PullToRefreshBaseNew<V> pullToRefreshBaseNew);
    }

    public abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public long getSmoothScrollDuration() {
        return 150L;
    }

    public boolean isNeedTransferEvent() {
        return true;
    }

    public abstract boolean isReadyForPullDown();

    public abstract boolean isReadyForPullUp();

    public void onStateChanged(ILoadingLayout.State state, boolean z) {
    }

    public void setHeaderType() {
    }

    /* renamed from: com.baidu.searchbox.ui.pullrefresh.PullToRefreshBaseNew$9  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass9 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$pullrefresh$PullToRefreshBaseNew$HEADERTYPE;

        static {
            int[] iArr = new int[HEADERTYPE.values().length];
            $SwitchMap$com$baidu$searchbox$ui$pullrefresh$PullToRefreshBaseNew$HEADERTYPE = iArr;
            try {
                iArr[HEADERTYPE.STANDARD_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$pullrefresh$PullToRefreshBaseNew$HEADERTYPE[HEADERTYPE.BIG_BG_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$pullrefresh$PullToRefreshBaseNew$HEADERTYPE[HEADERTYPE.ROTATE_HEADER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class SmoothScrollRunnable implements Runnable {
        public final long mDuration;
        public final int mScrollFromY;
        public final int mScrollToY;
        public boolean mContinueRunning = true;
        public long mStartTime = -1;
        public int mCurrentY = -1;
        public final Interpolator mInterpolator = new DecelerateInterpolator();

        public SmoothScrollRunnable(int i, int i2, long j) {
            this.mScrollFromY = i;
            this.mScrollToY = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration > 0) {
                if (this.mStartTime == -1) {
                    this.mStartTime = System.currentTimeMillis();
                } else {
                    int round = this.mScrollFromY - Math.round((this.mScrollFromY - this.mScrollToY) * this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f));
                    this.mCurrentY = round;
                    PullToRefreshBaseNew.this.setScrollTo(0, round);
                }
                if (this.mContinueRunning && this.mScrollToY != this.mCurrentY) {
                    PullToRefreshBaseNew.this.postDelayed(this, 16L);
                    return;
                }
                return;
            }
            PullToRefreshBaseNew.this.setScrollTo(0, this.mScrollToY);
        }

        public void stop() {
            this.mContinueRunning = false;
            PullToRefreshBaseNew.this.removeCallbacks(this);
        }
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
        ILoadingLayout.State state = ILoadingLayout.State.NONE;
        this.mPullDownState = state;
        this.mPullUpState = state;
        this.mMaxPullOffset = -1;
        this.mLongPullRefreshEnabled = false;
        this.mPullRatio = 1.0f;
        init(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.mInterceptEventEnable = z;
    }

    private void smoothScrollTo(int i) {
        smoothScrollTo(i, getSmoothScrollDuration(), 0L);
    }

    private void startLongRefreshing(boolean z) {
        if (!isPullRefreshing() && !isLongPullRefreshing()) {
            ILoadingLayout.State state = ILoadingLayout.State.LONG_REFRESHING;
            this.mPullDownState = state;
            onStateChanged(state, true);
            LoadingLayout loadingLayout = this.mHeaderLayout;
            if (loadingLayout != null) {
                loadingLayout.setState(ILoadingLayout.State.LONG_REFRESHING);
            }
            if (this.mRefreshListener != null) {
                postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.pullrefresh.PullToRefreshBaseNew.7
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.mRefreshListener.onPullDownToLongRefresh(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRefreshing(boolean z) {
        if (!isPullRefreshing() && !isLongPullRefreshing()) {
            ILoadingLayout.State state = ILoadingLayout.State.REFRESHING;
            this.mPullDownState = state;
            onStateChanged(state, true);
            LoadingLayout loadingLayout = this.mHeaderLayout;
            if (loadingLayout != null) {
                loadingLayout.setState(ILoadingLayout.State.REFRESHING);
            }
            if (z && this.mRefreshListener != null) {
                postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.pullrefresh.PullToRefreshBaseNew.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PullToRefreshBaseNew.this.mRefreshListener.onPullDownToRefresh(PullToRefreshBaseNew.this);
                    }
                }, getSmoothScrollDuration());
            }
        }
    }

    public void addHeaderAndFooter(Context context) {
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

    public void pullDownWithoutAnim(boolean z) {
        OnRefreshListener<T> onRefreshListener;
        startRefreshing(false);
        int scrollY = getScrollY();
        int i = this.mHeaderHeight;
        if (scrollY != (-i)) {
            setScrollTo(0, -i);
        }
        if (z && (onRefreshListener = this.mRefreshListener) != null) {
            onRefreshListener.onPullUpToRefresh(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setEmptyView(View view2) {
        FrameLayout frameLayout = this.mRefreshableViewWrapper;
        if (frameLayout != null) {
            frameLayout.addView(view2, -1, -1);
        }
    }

    public void setHeaderBackgroundColor(int i) {
        LoadingLayout loadingLayout = this.mHeaderLayout;
        if (loadingLayout != null) {
            loadingLayout.setHeaderBackgroundColor(getResources().getColor(i));
        }
    }

    public void setHeaderBackgroundResource(int i) {
        LoadingLayout loadingLayout = this.mHeaderLayout;
        if (loadingLayout != null) {
            loadingLayout.setHeaderBackgroundResource(i);
        }
    }

    public void setHeaderBigBackground(int i) {
        LoadingLayout loadingLayout = this.mHeaderLayout;
        if (loadingLayout == null) {
            return;
        }
        loadingLayout.setHeaderBigBackground(i);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefreshNew
    public void setLastUpdatedLabel(CharSequence charSequence) {
        LoadingLayout loadingLayout = this.mHeaderLayout;
        if (loadingLayout != null) {
            loadingLayout.setLastUpdatedLabel(charSequence);
        }
        LoadingLayout loadingLayout2 = this.mFooterLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.setLastUpdatedLabel(charSequence);
        }
    }

    public void setListenParentScroll(boolean z) {
        this.mListeneParentScroll = z;
    }

    public void setLongPullRefreshEnabled(boolean z) {
        this.mLongPullRefreshEnabled = z;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefreshNew
    public void setMaxPullOffset(int i) {
        this.mMaxPullOffset = i;
    }

    public void setOffsetRadio(float f) {
        this.mOffsetRadio = f;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefreshNew
    public void setOnRefreshListener(OnRefreshListener<T> onRefreshListener) {
        this.mRefreshListener = onRefreshListener;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefreshNew
    public void setPullLoadEnabled(boolean z) {
        this.mPullLoadEnabled = z;
    }

    public void setPullRatio(float f) {
        this.mPullRatio = Math.max(f, 1.0f);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefreshNew
    public void setPullRefreshEnabled(boolean z) {
        this.mPullRefreshEnabled = z;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefreshNew
    public void setScrollLoadEnabled(boolean z) {
        this.mScrollLoadEnabled = z;
    }

    public void superRequestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
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
        ILoadingLayout.State state = ILoadingLayout.State.NONE;
        this.mPullDownState = state;
        this.mPullUpState = state;
        this.mMaxPullOffset = -1;
        this.mLongPullRefreshEnabled = false;
        this.mPullRatio = 1.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mHeaderLayout = createHeaderLoadingLayout(context, attributeSet);
        this.mFooterLayout = createFooterLoadingLayout(context, attributeSet);
        T createRefreshableView = createRefreshableView(context, attributeSet);
        this.mRefreshableView = createRefreshableView;
        addRefreshableView(context, createRefreshableView);
        addHeaderAndFooter(context);
    }

    private void setScrollBy(int i, int i2) {
        scrollBy(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollTo(int i, int i2) {
        scrollTo(i, i2);
    }

    public void addRefreshableView(Context context, T t) {
        addView(t, new FrameLayout.LayoutParams(-1, -1));
    }

    public LoadingLayout createFooterLoadingLayout(Context context, AttributeSet attributeSet) {
        return new FooterLoadingLayout(context);
    }

    public LoadingLayout createHeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        LoadingLayout headerLoadingLayout;
        setHeaderType();
        int i = AnonymousClass9.$SwitchMap$com$baidu$searchbox$ui$pullrefresh$PullToRefreshBaseNew$HEADERTYPE[this.mHeaderType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    headerLoadingLayout = null;
                } else {
                    headerLoadingLayout = new RotateLoadingLayout(context);
                }
            } else {
                headerLoadingLayout = new BigBgHeaderLoadingLayout(context);
            }
        } else {
            headerLoadingLayout = new HeaderLoadingLayout(context);
        }
        if (headerLoadingLayout == null) {
            return new HeaderLoadingLayout(context);
        }
        return headerLoadingLayout;
    }

    public void doPullRefreshing(boolean z, long j) {
        doPullRefreshing(z, j, null, true);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void onParentScrollChanged(int i, int i2) {
        if (!this.mListeneParentScroll) {
            return;
        }
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

    public void refreshRefreshableViewSize(int i, int i2) {
        FrameLayout frameLayout = this.mRefreshableViewWrapper;
        if (frameLayout != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.mRefreshableViewWrapper.requestLayout();
            }
        }
    }

    public void showPullRefreshing(final boolean z, long j) {
        postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.pullrefresh.PullToRefreshBaseNew.5
            @Override // java.lang.Runnable
            public void run() {
                int i;
                int i2 = -PullToRefreshBaseNew.this.mHeaderHeight;
                if (z) {
                    i = 150;
                } else {
                    i = 0;
                }
                PullToRefreshBaseNew.this.startRefreshing(false);
                PullToRefreshBaseNew.this.smoothScrollTo(i2, i, 0L);
            }
        }, j);
    }

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
        ILoadingLayout.State state = ILoadingLayout.State.NONE;
        this.mPullDownState = state;
        this.mPullUpState = state;
        this.mMaxPullOffset = -1;
        this.mLongPullRefreshEnabled = false;
        this.mPullRatio = 1.0f;
        this.mFactory = refreshableViewFactory;
        init(context, null);
    }

    public void doPullRefreshing(boolean z, boolean z2) {
        doPullRefreshing(z, 0L, null, z2);
    }

    public void doPullRefreshing(final boolean z, long j, final Runnable runnable, final boolean z2) {
        postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.pullrefresh.PullToRefreshBaseNew.4
            @Override // java.lang.Runnable
            public void run() {
                int i;
                PullToRefreshBaseNew.this.startRefreshing();
                if (z2) {
                    int i2 = -PullToRefreshBaseNew.this.mHeaderHeight;
                    if (z) {
                        i = 150;
                    } else {
                        i = 0;
                    }
                    PullToRefreshBaseNew.this.smoothScrollTo(i2, i, 0L);
                }
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    PullToRefreshBaseNew.this.post(runnable2);
                }
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void smoothScrollTo(int i, long j, long j2) {
        boolean z;
        PullToRefreshBaseNew<T>.SmoothScrollRunnable smoothScrollRunnable = this.mSmoothScrollRunnable;
        if (smoothScrollRunnable != null) {
            smoothScrollRunnable.stop();
        }
        int scrollYValue = getScrollYValue();
        if (scrollYValue != i) {
            z = true;
        } else {
            z = false;
        }
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

    private int getScrollYValue() {
        return getScrollY();
    }

    private boolean isInterceptTouchEventEnabled() {
        return this.mInterceptEventEnable;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefreshNew
    public LoadingLayout getFooterLoadingLayout() {
        return this.mFooterLayout;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefreshNew
    public LoadingLayout getHeaderLoadingLayout() {
        return this.mHeaderLayout;
    }

    public RefreshableViewFactory<T> getRefreshableFactory() {
        return this.mFactory;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefreshNew
    public T getRefreshableView() {
        return this.mRefreshableView;
    }

    public boolean isLongPullRefreshing() {
        if (this.mPullDownState == ILoadingLayout.State.LONG_REFRESHING) {
            return true;
        }
        return false;
    }

    public boolean isPullDownIdle() {
        ILoadingLayout.State state = this.mPullDownState;
        if (state != ILoadingLayout.State.NONE && state != ILoadingLayout.State.RESET) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefreshNew
    public boolean isPullLoadEnabled() {
        if (this.mPullLoadEnabled && this.mFooterLayout != null) {
            return true;
        }
        return false;
    }

    public boolean isPullLoading() {
        if (this.mPullUpState == ILoadingLayout.State.REFRESHING) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefreshNew
    public boolean isPullRefreshEnabled() {
        if (this.mPullRefreshEnabled && this.mHeaderLayout != null) {
            return true;
        }
        return false;
    }

    public boolean isPullRefreshing() {
        if (this.mPullDownState == ILoadingLayout.State.REFRESHING) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefreshNew
    public boolean isScrollLoadEnabled() {
        return this.mScrollLoadEnabled;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefreshNew
    public void onPullDownLongRefreshComplete() {
        if (isLongPullRefreshing()) {
            ILoadingLayout.State state = ILoadingLayout.State.RESET;
            this.mPullDownState = state;
            onStateChanged(state, true);
            postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.pullrefresh.PullToRefreshBaseNew.2
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

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefreshNew
    public void onPullDownRefreshComplete() {
        if (isPullRefreshing()) {
            ILoadingLayout.State state = ILoadingLayout.State.RESET;
            this.mPullDownState = state;
            onStateChanged(state, true);
            postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.pullrefresh.PullToRefreshBaseNew.1
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBaseNew.this.setInterceptTouchEventEnabled(true);
                    PullToRefreshBaseNew.this.mHeaderLayout.setState(ILoadingLayout.State.RESET);
                }
            }, getSmoothScrollDuration());
            resetHeaderLayout();
            setInterceptTouchEventEnabled(false);
        }
        OnRefreshListener<T> onRefreshListener = this.mRefreshListener;
        if (onRefreshListener != null) {
            onRefreshListener.onPullDownToRefreshCompleted(true);
        }
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefreshNew
    public void onPullUpRefreshComplete() {
        if (isPullLoading()) {
            ILoadingLayout.State state = ILoadingLayout.State.RESET;
            this.mPullUpState = state;
            onStateChanged(state, false);
            postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.pullrefresh.PullToRefreshBaseNew.3
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

    public void resetFooterLayout() {
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

    public void resetHeaderLayout() {
        int abs = Math.abs(getScrollYValue());
        boolean isPullRefreshing = isPullRefreshing();
        boolean isLongPullRefreshing = isLongPullRefreshing();
        if ((isPullRefreshing || isLongPullRefreshing) && abs <= this.mHeaderHeight) {
            smoothScrollTo(0);
        } else if (!isPullRefreshing && !isLongPullRefreshing) {
            smoothScrollTo(0);
        } else {
            smoothScrollTo(-this.mHeaderHeight);
        }
    }

    public void startLoading() {
        if (isPullLoading()) {
            return;
        }
        ILoadingLayout.State state = ILoadingLayout.State.REFRESHING;
        this.mPullUpState = state;
        onStateChanged(state, false);
        LoadingLayout loadingLayout = this.mFooterLayout;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout.State.REFRESHING);
        }
        if (this.mRefreshListener != null) {
            postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.pullrefresh.PullToRefreshBaseNew.8
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBaseNew.this.mRefreshListener.onPullUpToRefresh(PullToRefreshBaseNew.this);
                }
            }, getSmoothScrollDuration());
        }
    }

    public void startLongRefreshing() {
        startLongRefreshing(true);
    }

    public void startRefreshing() {
        startRefreshing(true);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!isInterceptTouchEventEnabled()) {
            return false;
        }
        if (!isPullLoadEnabled() && !isPullRefreshEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 3 && action != 1) {
            if (action != 0 && this.mIsHandledTouchEvent) {
                return true;
            }
            if (action != 0) {
                if (action == 2) {
                    float y = motionEvent.getY() - this.mLastMotionY;
                    if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading() || isLongPullRefreshing()) {
                        this.mLastMotionY = motionEvent.getY();
                        if (isPullRefreshEnabled() && isReadyForPullDown()) {
                            z = (Math.abs(getScrollYValue()) > 0 || y > 0.5f) ? true : true;
                            this.mIsHandledTouchEvent = z;
                            if (z && isNeedTransferEvent()) {
                                this.mRefreshableView.onTouchEvent(motionEvent);
                            }
                        } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                            this.mIsHandledTouchEvent = (Math.abs(getScrollYValue()) > 0 || y < -0.5f) ? true : true;
                        }
                    }
                }
            } else {
                this.mLastMotionY = motionEvent.getY();
                this.mIsHandledTouchEvent = false;
            }
            return this.mIsHandledTouchEvent;
        }
        this.mIsHandledTouchEvent = false;
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = false;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else {
                    float y = motionEvent.getY() - this.mLastMotionY;
                    this.mLastMotionY = motionEvent.getY();
                    if (isPullRefreshEnabled() && isReadyForPullDown()) {
                        pullHeaderLayout(y / this.mOffsetRadio);
                    } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                        pullFooterLayout(y / this.mOffsetRadio);
                    } else {
                        this.mIsHandledTouchEvent = false;
                        return false;
                    }
                    return true;
                }
            }
            if (!this.mIsHandledTouchEvent) {
                return false;
            }
            this.mIsHandledTouchEvent = false;
            if (isReadyForPullDown()) {
                if (this.mPullRefreshEnabled) {
                    ILoadingLayout.State state = this.mPullDownState;
                    if (state == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                        startRefreshing();
                        z = true;
                    } else if (this.mLongPullRefreshEnabled && state == ILoadingLayout.State.RELEASE_TO_LONG_REFRESH) {
                        startLongRefreshing();
                        z = true;
                        if (this.mListeneParentScroll) {
                            return true;
                        }
                    }
                } else {
                    ILoadingLayout.State state2 = ILoadingLayout.State.RESET;
                    this.mPullDownState = state2;
                    onStateChanged(state2, true);
                }
                resetHeaderLayout();
                return z;
            } else if (!isReadyForPullUp()) {
                return false;
            } else {
                if (isPullLoadEnabled() && this.mPullUpState == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                    startLoading();
                    z = true;
                }
                resetFooterLayout();
                return z;
            }
        }
        this.mLastMotionY = motionEvent.getY();
        this.mIsHandledTouchEvent = false;
        return false;
    }

    public void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            setScrollTo(0, 0);
        } else if (this.mMaxPullOffset > 0 && f > 0.0f && Math.abs(scrollYValue) >= this.mMaxPullOffset) {
        } else {
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

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        LoadingLayout loadingLayout = this.mHeaderLayout;
        if (loadingLayout != null) {
            loadingLayout.layout(loadingLayout.getLeft(), this.mHeaderLayout.getTop() - this.mHeaderLayout.getHeight(), this.mHeaderLayout.getRight(), this.mHeaderLayout.getBottom() - this.mHeaderLayout.getHeight());
            this.mHeaderHeight = this.mHeaderLayout.getContentSize();
        }
        LoadingLayout loadingLayout2 = this.mFooterLayout;
        if (loadingLayout2 != null && this.mRefreshableView != null) {
            loadingLayout2.layout(loadingLayout2.getLeft(), this.mRefreshableView.getBottom(), this.mFooterLayout.getRight(), this.mRefreshableView.getBottom() + this.mFooterLayout.getHeight());
            this.mFooterHeight = this.mFooterLayout.getContentSize();
        }
    }

    public void pullFooterLayout(float f) {
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
}
