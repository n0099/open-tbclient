package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
/* loaded from: classes4.dex */
public class PullToRefreshListView extends PullToRefreshBase<ListView> implements AbsListView.OnScrollListener {
    public ListView w;
    public LoadingLayout x;
    public AbsListView.OnScrollListener y;

    public PullToRefreshListView(Context context) {
        this(context, null);
    }

    public void setHasMoreData(boolean z) {
        ILoadingLayout$State iLoadingLayout$State;
        ILoadingLayout$State iLoadingLayout$State2;
        LoadingLayout loadingLayout = this.x;
        if (loadingLayout != null) {
            if (z) {
                iLoadingLayout$State2 = ILoadingLayout$State.RESET;
            } else {
                iLoadingLayout$State2 = ILoadingLayout$State.NO_MORE_DATA;
            }
            loadingLayout.setState(iLoadingLayout$State2);
        }
        LoadingLayout footerLoadingLayout = getFooterLoadingLayout();
        if (footerLoadingLayout != null) {
            if (z) {
                iLoadingLayout$State = ILoadingLayout$State.RESET;
            } else {
                iLoadingLayout$State = ILoadingLayout$State.NO_MORE_DATA;
            }
            footerLoadingLayout.setState(iLoadingLayout$State);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.y = onScrollListener;
    }

    public void setRefreshableView(ListView listView) {
        this.w = listView;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public void setScrollLoadEnabled(boolean z) {
        if (v() == z) {
            return;
        }
        super.setScrollLoadEnabled(z);
        if (z) {
            if (this.x == null) {
                FooterLoadingLayout footerLoadingLayout = new FooterLoadingLayout(getContext());
                this.x = footerLoadingLayout;
                this.w.addFooterView(footerLoadingLayout, null, false);
            }
            this.x.m(true);
            return;
        }
        LoadingLayout loadingLayout = this.x;
        if (loadingLayout != null) {
            loadingLayout.m(false);
        }
    }

    public PullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setPullLoadEnabled(false);
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

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (v() && O() && ((i == 0 || i == 2) && u())) {
            K();
        }
        AbsListView.OnScrollListener onScrollListener = this.y;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public void K() {
        super.K();
        LoadingLayout loadingLayout = this.x;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout$State.REFRESHING);
        }
    }

    public final boolean O() {
        LoadingLayout loadingLayout = this.x;
        if (loadingLayout != null && loadingLayout.getState() == ILoadingLayout$State.NO_MORE_DATA) {
            return false;
        }
        return true;
    }

    public final boolean P() {
        int i;
        ListAdapter adapter = this.w.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        if (this.w.getChildCount() > 0) {
            i = this.w.getChildAt(0).getTop();
        } else {
            i = 0;
        }
        if (i >= 0 && this.w.getFirstVisiblePosition() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public LoadingLayout getFooterLoadingLayout() {
        if (v()) {
            return this.x;
        }
        return super.getFooterLoadingLayout();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public boolean t() {
        return P();
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase
    public boolean u() {
        return Q();
    }

    public final boolean Q() {
        ListAdapter adapter = this.w.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        int lastVisiblePosition = this.w.getLastVisiblePosition();
        if (lastVisiblePosition >= (adapter.getCount() - 1) - 1) {
            View childAt = this.w.getChildAt(Math.min(lastVisiblePosition - this.w.getFirstVisiblePosition(), this.w.getChildCount() - 1));
            if (childAt != null && childAt.getBottom() <= this.w.getBottom()) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener = this.y;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }
}
