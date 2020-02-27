package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.swan.apps.res.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes11.dex */
public class PullToRefreshListView extends PullToRefreshBase<ListView> implements AbsListView.OnScrollListener {
    private LoadingLayout bMS;
    private AbsListView.OnScrollListener bMl;
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
        if (this.bMS != null) {
            this.bMS.setState(z ? ILoadingLayout.State.RESET : ILoadingLayout.State.NO_MORE_DATA);
        }
        LoadingLayout footerLoadingLayout = getFooterLoadingLayout();
        if (footerLoadingLayout != null) {
            footerLoadingLayout.setState(z ? ILoadingLayout.State.RESET : ILoadingLayout.State.NO_MORE_DATA);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bMl = onScrollListener;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    protected boolean isReadyForPullUp() {
        return aca();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    protected boolean isReadyForPullDown() {
        return abZ();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public void startLoading() {
        super.startLoading();
        if (this.bMS != null) {
            this.bMS.setState(ILoadingLayout.State.REFRESHING);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public void setScrollLoadEnabled(boolean z) {
        if (isScrollLoadEnabled() != z) {
            super.setScrollLoadEnabled(z);
            if (z) {
                if (this.bMS == null) {
                    this.bMS = new FooterLoadingLayout(getContext());
                    this.mListView.addFooterView(this.bMS, null, false);
                }
                this.bMS.show(true);
            } else if (this.bMS != null) {
                this.bMS.show(false);
            }
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public LoadingLayout getFooterLoadingLayout() {
        return isScrollLoadEnabled() ? this.bMS : super.getFooterLoadingLayout();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (isScrollLoadEnabled() && abY() && ((i == 0 || i == 2) && isReadyForPullUp())) {
            startLoading();
        }
        if (this.bMl != null) {
            this.bMl.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bMl != null) {
            this.bMl.onScroll(absListView, i, i2, i3);
        }
    }

    private boolean abY() {
        return this.bMS == null || this.bMS.getState() != ILoadingLayout.State.NO_MORE_DATA;
    }

    private boolean abZ() {
        ListAdapter adapter = this.mListView.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        return (this.mListView.getChildCount() > 0 ? this.mListView.getChildAt(0).getTop() : 0) >= 0 && this.mListView.getFirstVisiblePosition() == 0;
    }

    private boolean aca() {
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
