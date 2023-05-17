package com.baidu.live.feedpage.interfaces;
/* loaded from: classes3.dex */
public interface ILiveFeedRefresh {

    /* loaded from: classes3.dex */
    public interface OnLoadMoreListener {
        void onLoadMoreEnd();
    }

    /* loaded from: classes3.dex */
    public interface OnRefreshListener {
        void onPullRefreshEnd();
    }

    void onExternalLoadMore(OnLoadMoreListener onLoadMoreListener);

    void onExternalRefresh();

    void onExternalRefresh(OnRefreshListener onRefreshListener);

    void onSelectedRefresh();
}
