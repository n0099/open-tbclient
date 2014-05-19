package com.baidu.adp.base;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
public interface i {
    int getUniqueId();

    boolean isScroll();

    void onPreLoad(BdListView bdListView);

    void setIsScroll(boolean z);
}
