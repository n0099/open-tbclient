package com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh;

import android.view.View;
import com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase;
/* loaded from: classes2.dex */
public interface IPullToRefresh<T extends View> {
    LoadingLayout getFooterLoadingLayout();

    LoadingLayout getHeaderLoadingLayout();

    T getRefreshableView();

    boolean isPullLoadEnabled();

    boolean isPullRefreshEnabled();

    boolean isScrollLoadEnabled();

    void onPullDownRefreshComplete();

    void onPullDownRefreshComplete(boolean z);

    void onPullDownRefreshComplete(boolean z, String str);

    void onPullUpRefreshComplete();

    void setLastUpdatedLabel(CharSequence charSequence);

    void setMaxPullOffset(int i);

    void setOnRefreshListener(PullToRefreshBase.OnRefreshListener<T> onRefreshListener);

    void setPullLoadEnabled(boolean z);

    void setPullRefreshEnabled(boolean z);

    void setScrollLoadEnabled(boolean z);
}
