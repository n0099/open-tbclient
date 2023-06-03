package com.baidu.searchbox.ui.pullrefresh;

import android.view.View;
import com.baidu.searchbox.ui.pullrefresh.PullToRefreshBaseNew;
/* loaded from: classes4.dex */
public interface IPullToRefreshNew<T extends View> {
    LoadingLayout getFooterLoadingLayout();

    LoadingLayout getHeaderLoadingLayout();

    T getRefreshableView();

    boolean isPullLoadEnabled();

    boolean isPullRefreshEnabled();

    boolean isScrollLoadEnabled();

    void onPullDownLongRefreshComplete();

    void onPullDownRefreshComplete();

    void onPullUpRefreshComplete();

    void setLastUpdatedLabel(CharSequence charSequence);

    void setMaxPullOffset(int i);

    void setOnRefreshListener(PullToRefreshBaseNew.OnRefreshListener<T> onRefreshListener);

    void setPullLoadEnabled(boolean z);

    void setPullRefreshEnabled(boolean z);

    void setScrollLoadEnabled(boolean z);
}
