package com.baidu.live.adp.widget.listview;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.base.IScrollable;
import com.baidu.live.adp.widget.listview.BdListView;
/* loaded from: classes3.dex */
public interface IListView<V extends ViewGroup> {
    void addFooterView(View view);

    void addFooterView(View view, Object obj, boolean z);

    void addHeaderView(View view);

    void addHeaderView(View view, int i);

    void addHeaderView(View view, Object obj, boolean z);

    int getContentViewsCount();

    int getFooterViewsCount();

    int getHeaderViewsCount();

    IListAdapter getListAdapter();

    V getListView();

    boolean removeFooterView(View view);

    boolean removeHeaderView(View view);

    void setOnScrollStopDelayedListener(BdListView.OnScrollStopDelayedListener onScrollStopDelayedListener, long j);

    void setScrollable(IScrollable iScrollable);

    void setSelection(int i);

    void smoothScrollToPosition(int i);

    void smoothScrollToPosition(int i, int i2);

    void smoothScrollToPosition(int i, int i2, int i3);
}
