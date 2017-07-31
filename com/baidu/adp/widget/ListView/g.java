package com.baidu.adp.widget.ListView;

import android.widget.ListAdapter;
/* loaded from: classes.dex */
public interface g {
    void cancelRefresh();

    ListAdapter getAdapter();

    int getFirstVisiblePosition();

    int getLastVisiblePosition();
}
