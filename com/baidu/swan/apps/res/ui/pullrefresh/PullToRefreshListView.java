package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
/* loaded from: classes3.dex */
public class PullToRefreshListView extends PullToRefreshBase<ListView> implements AbsListView.OnScrollListener {
    public LoadingLayout A;
    public AbsListView.OnScrollListener B;
    public ListView z;

    public PullToRefreshListView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public void K() {
        super.K();
        LoadingLayout loadingLayout = this.A;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    /* renamed from: N */
    public ListView j(Context context, AttributeSet attributeSet) {
        ListView listView = new ListView(context);
        listView.setOnScrollListener(this);
        setRefreshableView(listView);
        return listView;
    }

    public final boolean O() {
        LoadingLayout loadingLayout = this.A;
        return loadingLayout == null || loadingLayout.getState() != ILoadingLayout$State.NO_MORE_DATA;
    }

    public final boolean P() {
        ListAdapter adapter = this.z.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        return (this.z.getChildCount() > 0 ? this.z.getChildAt(0).getTop() : 0) >= 0 && this.z.getFirstVisiblePosition() == 0;
    }

    public final boolean Q() {
        ListAdapter adapter = this.z.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        int lastVisiblePosition = this.z.getLastVisiblePosition();
        if (lastVisiblePosition >= (adapter.getCount() - 1) - 1) {
            View childAt = this.z.getChildAt(Math.min(lastVisiblePosition - this.z.getFirstVisiblePosition(), this.z.getChildCount() - 1));
            return childAt != null && childAt.getBottom() <= this.z.getBottom();
        }
        return false;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public LoadingLayout getFooterLoadingLayout() {
        if (v()) {
            return this.A;
        }
        return super.getFooterLoadingLayout();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AbsListView.OnScrollListener onScrollListener = this.B;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i2, i3, i4);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (v() && O() && ((i2 == 0 || i2 == 2) && u())) {
            K();
        }
        AbsListView.OnScrollListener onScrollListener = this.B;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i2);
        }
    }

    public void setHasMoreData(boolean z) {
        LoadingLayout loadingLayout = this.A;
        if (loadingLayout != null) {
            loadingLayout.setState(z ? ILoadingLayout$State.RESET : ILoadingLayout$State.NO_MORE_DATA);
        }
        LoadingLayout footerLoadingLayout = getFooterLoadingLayout();
        if (footerLoadingLayout != null) {
            footerLoadingLayout.setState(z ? ILoadingLayout$State.RESET : ILoadingLayout$State.NO_MORE_DATA);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.B = onScrollListener;
    }

    public void setRefreshableView(ListView listView) {
        this.z = listView;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public void setScrollLoadEnabled(boolean z) {
        if (v() == z) {
            return;
        }
        super.setScrollLoadEnabled(z);
        if (z) {
            if (this.A == null) {
                FooterLoadingLayout footerLoadingLayout = new FooterLoadingLayout(getContext());
                this.A = footerLoadingLayout;
                this.z.addFooterView(footerLoadingLayout, null, false);
            }
            this.A.m(true);
            return;
        }
        LoadingLayout loadingLayout = this.A;
        if (loadingLayout != null) {
            loadingLayout.m(false);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public boolean t() {
        return P();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public boolean u() {
        return Q();
    }

    public PullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setPullLoadEnabled(false);
    }
}
