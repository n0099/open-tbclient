package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes10.dex */
public class PullToRefreshListView extends PullToRefreshBase<ListView> implements AbsListView.OnScrollListener {
    private AbsListView.OnScrollListener dpT;
    private LoadingLayout dqA;
    private ListView mListView;

    public PullToRefreshListView(Context context) {
        this(context, null);
    }

    public PullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setPullLoadEnabled(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
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
        if (this.dqA != null) {
            this.dqA.setState(z ? ILoadingLayout.State.RESET : ILoadingLayout.State.NO_MORE_DATA);
        }
        LoadingLayout footerLoadingLayout = getFooterLoadingLayout();
        if (footerLoadingLayout != null) {
            footerLoadingLayout.setState(z ? ILoadingLayout.State.RESET : ILoadingLayout.State.NO_MORE_DATA);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.dpT = onScrollListener;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    protected boolean isReadyForPullUp() {
        return aGL();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    protected boolean isReadyForPullDown() {
        return aGK();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public void startLoading() {
        super.startLoading();
        if (this.dqA != null) {
            this.dqA.setState(ILoadingLayout.State.REFRESHING);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public void setScrollLoadEnabled(boolean z) {
        if (isScrollLoadEnabled() != z) {
            super.setScrollLoadEnabled(z);
            if (z) {
                if (this.dqA == null) {
                    this.dqA = new FooterLoadingLayout(getContext());
                    this.mListView.addFooterView(this.dqA, null, false);
                }
                this.dqA.show(true);
            } else if (this.dqA != null) {
                this.dqA.show(false);
            }
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public LoadingLayout getFooterLoadingLayout() {
        return isScrollLoadEnabled() ? this.dqA : super.getFooterLoadingLayout();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (isScrollLoadEnabled() && aGJ() && ((i == 0 || i == 2) && isReadyForPullUp())) {
            startLoading();
        }
        if (this.dpT != null) {
            this.dpT.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dpT != null) {
            this.dpT.onScroll(absListView, i, i2, i3);
        }
    }

    private boolean aGJ() {
        return this.dqA == null || this.dqA.getState() != ILoadingLayout.State.NO_MORE_DATA;
    }

    private boolean aGK() {
        ListAdapter adapter = this.mListView.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        return (this.mListView.getChildCount() > 0 ? this.mListView.getChildAt(0).getTop() : 0) >= 0 && this.mListView.getFirstVisiblePosition() == 0;
    }

    private boolean aGL() {
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
