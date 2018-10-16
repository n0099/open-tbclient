package com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes2.dex */
public class PullToRefreshListView extends PullToRefreshBase<ListView> implements AbsListView.OnScrollListener {
    private ListView mListView;
    private LoadingLayout mLoadMoreFooterLayout;
    private AbsListView.OnScrollListener mScrollListener;

    public PullToRefreshListView(Context context) {
        this(context, null);
    }

    public PullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setPullLoadEnabled(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase
    public ListView createRefreshableView(Context context, AttributeSet attributeSet) {
        ListView listView = new ListView(context);
        listView.setOnScrollListener(this);
        setRefreshableView(listView);
        return listView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRefreshableView(ListView listView) {
        this.mListView = listView;
    }

    public void setHasMoreData(boolean z) {
        if (this.mLoadMoreFooterLayout != null) {
            this.mLoadMoreFooterLayout.setState(z ? ILoadingLayout.State.RESET : ILoadingLayout.State.NO_MORE_DATA);
        }
        LoadingLayout footerLoadingLayout = getFooterLoadingLayout();
        if (footerLoadingLayout != null) {
            footerLoadingLayout.setState(z ? ILoadingLayout.State.RESET : ILoadingLayout.State.NO_MORE_DATA);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase
    protected boolean isReadyForPullUp() {
        return isLastItemVisible();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase
    protected boolean isReadyForPullDown() {
        return isFirstItemVisible();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase
    public void startLoading() {
        super.startLoading();
        if (this.mLoadMoreFooterLayout != null) {
            this.mLoadMoreFooterLayout.setState(ILoadingLayout.State.REFRESHING);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase, com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefresh
    public void onPullUpRefreshComplete() {
        super.onPullUpRefreshComplete();
        if (this.mLoadMoreFooterLayout != null) {
            this.mLoadMoreFooterLayout.setState(ILoadingLayout.State.RESET);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase, com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefresh
    public void setScrollLoadEnabled(boolean z) {
        if (isScrollLoadEnabled() != z) {
            super.setScrollLoadEnabled(z);
            if (z) {
                if (this.mLoadMoreFooterLayout == null) {
                    this.mLoadMoreFooterLayout = new FooterLoadingLayout(getContext());
                    this.mListView.addFooterView(this.mLoadMoreFooterLayout, null, false);
                }
                this.mLoadMoreFooterLayout.show(true);
            } else if (this.mLoadMoreFooterLayout != null) {
                this.mLoadMoreFooterLayout.show(false);
            }
        }
    }

    public void dismissListViewDivider() {
        if (this.mListView != null) {
            this.mListView.setDivider(null);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase, com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.IPullToRefresh
    public LoadingLayout getFooterLoadingLayout() {
        return isScrollLoadEnabled() ? this.mLoadMoreFooterLayout : super.getFooterLoadingLayout();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (isScrollLoadEnabled() && hasMoreData() && ((i == 0 || i == 2) && isReadyForPullUp())) {
            startLoading();
        }
        if (this.mScrollListener != null) {
            this.mScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.mScrollListener != null) {
            this.mScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    private boolean hasMoreData() {
        return this.mLoadMoreFooterLayout == null || this.mLoadMoreFooterLayout.getState() != ILoadingLayout.State.NO_MORE_DATA;
    }

    private boolean isFirstItemVisible() {
        ListAdapter adapter = this.mListView.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        return (this.mListView.getChildCount() > 0 ? this.mListView.getChildAt(0).getTop() : 0) >= 0 && this.mListView.getFirstVisiblePosition() == 0;
    }

    private boolean isLastItemVisible() {
        ListAdapter adapter = this.mListView.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        if (lastVisiblePosition >= (adapter.getCount() - 1) - 1) {
            View childAt = this.mListView.getChildAt(Math.min(lastVisiblePosition - this.mListView.getFirstVisiblePosition(), this.mListView.getChildCount() - 1));
            if (childAt != null) {
                return childAt.getBottom() <= this.mListView.getBottom();
            }
        }
        return false;
    }
}
