package com.baidu.searchbox.ui.swipe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.baidu.searchbox.ui.pullrefresh.FooterLoadingLayout;
import com.baidu.searchbox.ui.pullrefresh.ILoadingLayout;
import com.baidu.searchbox.ui.pullrefresh.LoadingLayout;
import com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase;
/* loaded from: classes4.dex */
public class PullRefreshSwipeListView extends PullToRefreshBase<SwipeMenuListView> {
    public SwipeMenuListView mListView;
    public LoadingLayout mLoadMoreFooterLayout;
    public AbsListView.OnScrollListener mScrollListener;

    public PullRefreshSwipeListView(Context context) {
        super(context);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        SwipeMenuListView swipeMenuListView = this.mListView;
        if (swipeMenuListView != null && !swipeMenuListView.canInterceptInPullRefreshView()) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setHasMoreData(boolean z) {
        ILoadingLayout.State state;
        ILoadingLayout.State state2;
        LoadingLayout loadingLayout = this.mLoadMoreFooterLayout;
        if (loadingLayout != null) {
            if (z) {
                state2 = ILoadingLayout.State.RESET;
            } else {
                state2 = ILoadingLayout.State.NO_MORE_DATA;
            }
            loadingLayout.setState(state2);
        }
        LoadingLayout footerLoadingLayout = getFooterLoadingLayout();
        if (footerLoadingLayout != null) {
            if (z) {
                state = ILoadingLayout.State.RESET;
            } else {
                state = ILoadingLayout.State.NO_MORE_DATA;
            }
            footerLoadingLayout.setState(state);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void setRefreshableView(SwipeMenuListView swipeMenuListView) {
        this.mListView = swipeMenuListView;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase, com.baidu.searchbox.ui.pullrefresh.IPullToRefresh
    public void setScrollLoadEnabled(boolean z) {
        if (isScrollLoadEnabled() == z) {
            return;
        }
        super.setScrollLoadEnabled(z);
        if (z) {
            if (this.mLoadMoreFooterLayout == null) {
                FooterLoadingLayout footerLoadingLayout = new FooterLoadingLayout(getContext());
                this.mLoadMoreFooterLayout = footerLoadingLayout;
                this.mListView.addFooterView(footerLoadingLayout, null, false);
            }
            this.mLoadMoreFooterLayout.show(true);
            return;
        }
        LoadingLayout loadingLayout = this.mLoadMoreFooterLayout;
        if (loadingLayout != null) {
            loadingLayout.show(false);
        }
    }

    public PullRefreshSwipeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean hasMoreData() {
        LoadingLayout loadingLayout = this.mLoadMoreFooterLayout;
        if (loadingLayout != null && loadingLayout.getState() == ILoadingLayout.State.NO_MORE_DATA) {
            return false;
        }
        return true;
    }

    private boolean isFirstItemVisible() {
        int i;
        ListAdapter adapter = this.mListView.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        if (this.mListView.getChildCount() > 0) {
            i = this.mListView.getChildAt(0).getTop();
        } else {
            i = 0;
        }
        if (i >= 0 && this.mListView.getFirstVisiblePosition() == 0) {
            return true;
        }
        return false;
    }

    public void dismissListViewDivider() {
        SwipeMenuListView swipeMenuListView = this.mListView;
        if (swipeMenuListView != null) {
            swipeMenuListView.setDivider(null);
        }
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase, com.baidu.searchbox.ui.pullrefresh.IPullToRefresh
    public LoadingLayout getFooterLoadingLayout() {
        if (isScrollLoadEnabled()) {
            return this.mLoadMoreFooterLayout;
        }
        return super.getFooterLoadingLayout();
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase
    public boolean isReadyForPullDown() {
        return isFirstItemVisible();
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase
    public boolean isReadyForPullUp() {
        return isLastItemVisible();
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase, com.baidu.searchbox.ui.pullrefresh.IPullToRefresh
    public void onPullUpRefreshComplete() {
        super.onPullUpRefreshComplete();
        LoadingLayout loadingLayout = this.mLoadMoreFooterLayout;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout.State.RESET);
        }
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase
    public void startLoading() {
        super.startLoading();
        LoadingLayout loadingLayout = this.mLoadMoreFooterLayout;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout.State.REFRESHING);
        }
    }

    private boolean isLastItemVisible() {
        ListAdapter adapter = this.mListView.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        if (lastVisiblePosition >= (adapter.getCount() - 1) - 1) {
            View childAt = this.mListView.getChildAt(Math.min(lastVisiblePosition - this.mListView.getFirstVisiblePosition(), this.mListView.getChildCount() - 1));
            if (childAt != null && childAt.getBottom() <= this.mListView.getBottom()) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase
    public SwipeMenuListView createRefreshableView(Context context, AttributeSet attributeSet) {
        SwipeMenuListView swipeMenuListView = new SwipeMenuListView(context);
        setRefreshableView(swipeMenuListView);
        return swipeMenuListView;
    }
}
