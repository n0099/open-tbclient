package com.baidu.searchbox.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.searchbox.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes4.dex */
public class PullToRefreshListView extends PullToRefreshBase<ListView> implements AbsListView.OnScrollListener {
    public ListView mListView;
    public LoadingLayout mLoadMoreFooterLayout;
    public AbsListView.OnScrollListener mScrollListener;

    public PullToRefreshListView(Context context) {
        this(context, null);
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

    public void setRefreshableView(ListView listView) {
        this.mListView = listView;
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

    public PullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setPullLoadEnabled(false);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (isScrollLoadEnabled() && hasMoreData() && ((i == 0 || i == 2) && isReadyForPullUp())) {
            startLoading();
        }
        AbsListView.OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
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
        ListView listView = this.mListView;
        if (listView != null) {
            listView.setDivider(null);
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
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase
    public ListView createRefreshableView(Context context, AttributeSet attributeSet) {
        ListView listView = new ListView(context);
        listView.setOnScrollListener(this);
        setRefreshableView(listView);
        return listView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }
}
