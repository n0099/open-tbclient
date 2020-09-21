package com.baidu.live.adp.widget.listview;
/* loaded from: classes4.dex */
public interface IPreLoadListView {
    void cancelRefresh();

    IListAdapter getAdapter();

    int getFirstVisiblePosition();

    int getLastVisiblePosition();
}
