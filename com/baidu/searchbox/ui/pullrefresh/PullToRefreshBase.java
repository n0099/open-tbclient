package com.baidu.searchbox.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.baidu.searchbox.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes4.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout implements IPullToRefresh<T> {
    public static final boolean DEBUG = false;
    public static final float OFFSET_RADIO = 1.5f;
    public static final int SCROLL_DURATION = 300;
    public static final String TAG = "PullToRefreshBase";
    public int mActivePointerId;
    public RefreshableViewFactory<T> mFactory;
    public int mFooterHeight;
    public LoadingLayout mFooterLayout;
    public int mHeaderHeight;
    public LoadingLayout mHeaderLayout;
    public HEADERTYPE mHeaderType;
    public boolean mInterceptEventEnable;
    public boolean mIsHandledTouchEvent;
    public float mLastMotionY;
    public int mMaxPullOffset;
    public ILoadingLayout.State mPullDownState;
    public boolean mPullLoadEnabled;
    public boolean mPullRefreshEnabled;
    public ILoadingLayout.State mPullUpState;
    public OnRefreshListener<T> mRefreshListener;
    public T mRefreshableView;
    public FrameLayout mRefreshableViewWrapper;
    public boolean mScrollLoadEnabled;
    public Scroller mScroller;
    public int mTouchSlop;

    /* loaded from: classes4.dex */
    public enum HEADERTYPE {
        STANDARD_HEADER,
        BIG_BG_HEADER,
        ROTATE_HEADER,
        Common_STYLE_HEADER,
        SWAN_APP_HEADER
    }

    /* loaded from: classes4.dex */
    public interface OnRefreshListener<V extends View> {
        void onPullDownToRefresh(PullToRefreshBase<V> pullToRefreshBase);

        void onPullUpToRefresh(PullToRefreshBase<V> pullToRefreshBase);
    }

    public abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public int getSmoothScrollDuration() {
        return 300;
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

    /* renamed from: com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase$9  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass9 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$pullrefresh$PullToRefreshBase$HEADERTYPE;

        static {
            int[] iArr = new int[HEADERTYPE.values().length];
            $SwitchMap$com$baidu$searchbox$ui$pullrefresh$PullToRefreshBase$HEADERTYPE = iArr;
            try {
                iArr[HEADERTYPE.STANDARD_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$pullrefresh$PullToRefreshBase$HEADERTYPE[HEADERTYPE.BIG_BG_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$pullrefresh$PullToRefreshBase$HEADERTYPE[HEADERTYPE.ROTATE_HEADER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$pullrefresh$PullToRefreshBase$HEADERTYPE[HEADERTYPE.Common_STYLE_HEADER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$pullrefresh$PullToRefreshBase$HEADERTYPE[HEADERTYPE.SWAN_APP_HEADER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
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
        ILoadingLayout.State state = ILoadingLayout.State.NONE;
        this.mPullDownState = state;
        this.mPullUpState = state;
        this.mMaxPullOffset = -1;
        this.mActivePointerId = -1;
        init(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEventEnabled(boolean z) {
        this.mInterceptEventEnable = z;
    }

    private void smoothScrollTo(int i) {
        smoothScrollTo(i, getSmoothScrollDuration());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRefreshing(boolean z) {
        if (isPullRefreshing()) {
            return;
        }
        ILoadingLayout.State state = ILoadingLayout.State.REFRESHING;
        this.mPullDownState = state;
        onStateChanged(state, true);
        LoadingLayout loadingLayout = this.mHeaderLayout;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout.State.REFRESHING);
        }
        if (z && this.mRefreshListener != null) {
            postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase.7
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.mRefreshListener.onPullDownToRefresh(PullToRefreshBase.this);
                }
            }, getSmoothScrollDuration());
        }
    }

    public void addHeaderAndFooter(Context context) {
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

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefresh
    public void onPullDownRefreshComplete(boolean z) {
        onPullDownRefreshComplete(z, null);
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

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefresh
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

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefresh
    public void setMaxPullOffset(int i) {
        this.mMaxPullOffset = i;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefresh
    public void setOnRefreshListener(OnRefreshListener<T> onRefreshListener) {
        this.mRefreshListener = onRefreshListener;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        super.setOrientation(i);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefresh
    public void setPullLoadEnabled(boolean z) {
        this.mPullLoadEnabled = z;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefresh
    public void setPullRefreshEnabled(boolean z) {
        this.mPullRefreshEnabled = z;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefresh
    public void setScrollLoadEnabled(boolean z) {
        this.mScrollLoadEnabled = z;
    }

    public void superRequestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
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
        ILoadingLayout.State state = ILoadingLayout.State.NONE;
        this.mPullDownState = state;
        this.mPullUpState = state;
        this.mMaxPullOffset = -1;
        this.mActivePointerId = -1;
        init(context, attributeSet);
    }

    private void setScrollBy(int i, int i2) {
        scrollBy(i, i2);
    }

    private void setScrollTo(int i, int i2) {
        scrollTo(i, i2);
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

    public void addRefreshableView(Context context, T t) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.mRefreshableViewWrapper = frameLayout;
        frameLayout.addView(t, -1, -1);
        addView(this.mRefreshableViewWrapper, new LinearLayout.LayoutParams(-1, 10));
    }

    public LoadingLayout createFooterLoadingLayout(Context context, AttributeSet attributeSet) {
        return new FooterLoadingLayout(context);
    }

    public void doPullRefreshing(boolean z, long j) {
        doPullRefreshing(z, j, null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefresh
    public void onPullDownRefreshComplete(boolean z, String str) {
        if (isPullRefreshing()) {
            ILoadingLayout.State state = ILoadingLayout.State.RESET;
            this.mPullDownState = state;
            onStateChanged(state, true);
            setInterceptTouchEventEnabled(false);
            this.mHeaderLayout.onPullRefreshComplete(z, str, new Runnable() { // from class: com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase.3
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase.3.1
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
        postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase.6
            @Override // java.lang.Runnable
            public void run() {
                int i;
                int i2 = -PullToRefreshBase.this.mHeaderLayout.getRefreshingHeight();
                if (z) {
                    i = 300;
                } else {
                    i = 0;
                }
                PullToRefreshBase.this.startRefreshing(false);
                PullToRefreshBase.this.smoothScrollTo(i2, i);
            }
        }, j);
    }

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
        ILoadingLayout.State state = ILoadingLayout.State.NONE;
        this.mPullDownState = state;
        this.mPullUpState = state;
        this.mMaxPullOffset = -1;
        this.mActivePointerId = -1;
        this.mFactory = refreshableViewFactory;
        this.mHeaderType = headertype;
        init(context, null);
    }

    public void doPullRefreshing(final boolean z, long j, final Runnable runnable) {
        postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase.5
            @Override // java.lang.Runnable
            public void run() {
                int i;
                int i2 = -PullToRefreshBase.this.mHeaderLayout.getRefreshingHeight();
                if (z) {
                    i = 300;
                } else {
                    i = 0;
                }
                PullToRefreshBase.this.startRefreshing();
                PullToRefreshBase.this.smoothScrollTo(i2, i);
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    PullToRefreshBase.this.post(runnable2);
                }
            }
        }, j);
    }

    private int getScrollYValue() {
        return getScrollY();
    }

    private boolean isInterceptTouchEventEnabled() {
        return this.mInterceptEventEnable;
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

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefresh
    public LoadingLayout getFooterLoadingLayout() {
        return this.mFooterLayout;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefresh
    public LoadingLayout getHeaderLoadingLayout() {
        return this.mHeaderLayout;
    }

    public RefreshableViewFactory<T> getRefreshableFactory() {
        return this.mFactory;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefresh
    public T getRefreshableView() {
        return this.mRefreshableView;
    }

    public boolean isPullDownIdle() {
        ILoadingLayout.State state = this.mPullDownState;
        if (state != ILoadingLayout.State.NONE && state != ILoadingLayout.State.RESET) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefresh
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

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefresh
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

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefresh
    public boolean isScrollLoadEnabled() {
        return this.mScrollLoadEnabled;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefresh
    @Deprecated
    public void onPullDownRefreshComplete() {
        onPullDownRefreshComplete(false);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.IPullToRefresh
    public void onPullUpRefreshComplete() {
        if (isPullLoading()) {
            ILoadingLayout.State state = ILoadingLayout.State.RESET;
            this.mPullUpState = state;
            onStateChanged(state, false);
            postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase.4
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
        if (isPullRefreshing && abs <= this.mHeaderLayout.getRefreshingHeight()) {
            smoothScrollTo(0);
        } else if (isPullRefreshing) {
            smoothScrollTo(-this.mHeaderLayout.getRefreshingHeight());
        } else {
            smoothScrollTo(0);
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
            postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase.8
                @Override // java.lang.Runnable
                public void run() {
                    PullToRefreshBase.this.mRefreshListener.onPullUpToRefresh(PullToRefreshBase.this);
                }
            }, getSmoothScrollDuration());
        }
    }

    public void startRefreshing() {
        startRefreshing(true);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mScroller = new Scroller(context);
        setOrientation(1);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mHeaderLayout = createHeaderLoadingLayout(context, attributeSet);
        this.mFooterLayout = createFooterLoadingLayout(context, attributeSet);
        T createRefreshableView = createRefreshableView(context, attributeSet);
        this.mRefreshableView = createRefreshableView;
        addRefreshableView(context, createRefreshableView);
        addHeaderAndFooter(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PullToRefreshBase.this.refreshLoadingViewsSize();
                PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    public LoadingLayout createHeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        LoadingLayout headerLoadingLayout;
        setHeaderType();
        int i = AnonymousClass9.$SwitchMap$com$baidu$searchbox$ui$pullrefresh$PullToRefreshBase$HEADERTYPE[this.mHeaderType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            headerLoadingLayout = null;
                        } else {
                            headerLoadingLayout = new NeutralHeaderLoadingLayout(context);
                        }
                    } else {
                        headerLoadingLayout = new CommonHeaderLoadingLayout(context);
                    }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshLoadingViewsSize() {
        int i;
        int i2;
        int i3;
        LoadingLayout loadingLayout = this.mHeaderLayout;
        int i4 = 0;
        if (loadingLayout != null) {
            i = loadingLayout.getContentSize();
        } else {
            i = 0;
        }
        LoadingLayout loadingLayout2 = this.mFooterLayout;
        if (loadingLayout2 != null) {
            i2 = loadingLayout2.getContentSize();
        } else {
            i2 = 0;
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        this.mHeaderHeight = i;
        this.mFooterHeight = i2;
        LoadingLayout loadingLayout3 = this.mHeaderLayout;
        if (loadingLayout3 != null) {
            i3 = loadingLayout3.getMeasuredHeight();
        } else {
            i3 = 0;
        }
        LoadingLayout loadingLayout4 = this.mFooterLayout;
        if (loadingLayout4 != null) {
            i4 = loadingLayout4.getMeasuredHeight();
        }
        if (i4 == 0) {
            i4 = this.mFooterHeight;
        }
        setPadding(getPaddingLeft(), -i3, getPaddingRight(), -i4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!isInterceptTouchEventEnabled()) {
            return false;
        }
        if (!isPullLoadEnabled() && !isPullRefreshEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 3) {
            int i = 1;
            if (action != 1) {
                if (action != 0 && this.mIsHandledTouchEvent) {
                    return true;
                }
                int actionIndex = motionEvent.getActionIndex();
                if (action != 0) {
                    if (action != 2) {
                        if (action != 5) {
                            if (action == 6) {
                                int action2 = (motionEvent.getAction() & 65280) >> 8;
                                if (motionEvent.getPointerId(action2) == this.mActivePointerId) {
                                    if (action2 != 0) {
                                        i = 0;
                                    }
                                    this.mActivePointerId = motionEvent.getPointerId(i);
                                    this.mLastMotionY = (int) motionEvent.getY(i);
                                    this.mIsHandledTouchEvent = false;
                                }
                            }
                        } else {
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                            this.mLastMotionY = motionEvent.getY(actionIndex);
                            this.mIsHandledTouchEvent = false;
                        }
                    } else {
                        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                        if (findPointerIndex < 0) {
                            this.mIsHandledTouchEvent = false;
                            return false;
                        }
                        float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                        if (Math.abs(y) > this.mTouchSlop || isPullRefreshing() || isPullLoading()) {
                            this.mLastMotionY = motionEvent.getY(findPointerIndex);
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
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                    this.mLastMotionY = motionEvent.getY();
                    this.mIsHandledTouchEvent = false;
                }
                return this.mIsHandledTouchEvent;
            }
        }
        this.mIsHandledTouchEvent = false;
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        int action = motionEvent.getAction();
        boolean z = false;
        int i = 1;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action != 6) {
                                return false;
                            }
                            int action2 = (motionEvent.getAction() & 65280) >> 8;
                            if (motionEvent.getPointerId(action2) != this.mActivePointerId) {
                                return false;
                            }
                            if (action2 != 0) {
                                i = 0;
                            }
                            this.mActivePointerId = motionEvent.getPointerId(i);
                            this.mLastMotionY = (int) motionEvent.getY(i);
                            return false;
                        }
                        this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                        this.mLastMotionY = motionEvent.getY(actionIndex);
                        return false;
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex < 0) {
                        this.mIsHandledTouchEvent = false;
                        return false;
                    }
                    float y = motionEvent.getY(findPointerIndex) - this.mLastMotionY;
                    this.mLastMotionY = motionEvent.getY(findPointerIndex);
                    if (isPullRefreshEnabled() && isReadyForPullDown()) {
                        pullHeaderLayout(y / 1.5f);
                    } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                        pullFooterLayout(y / 1.5f);
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
                if (this.mPullRefreshEnabled && this.mPullDownState == ILoadingLayout.State.RELEASE_TO_REFRESH) {
                    startRefreshing();
                    z = true;
                } else if (!isPullRefreshing()) {
                    ILoadingLayout.State state = ILoadingLayout.State.RESET;
                    this.mPullDownState = state;
                    onStateChanged(state, true);
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
        this.mActivePointerId = motionEvent.getPointerId(actionIndex);
        this.mLastMotionY = motionEvent.getY();
        return false;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        refreshLoadingViewsSize();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() { // from class: com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase.2
            @Override // java.lang.Runnable
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
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

    public void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f < 0.0f && scrollYValue - f >= 0.0f) {
            setScrollTo(0, 0);
            this.mHeaderLayout.onPullLength(0);
        } else if (this.mMaxPullOffset > 0 && f > 0.0f && Math.abs(scrollYValue) >= this.mMaxPullOffset) {
        } else {
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
}
