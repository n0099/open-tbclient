package com.baidu.adp.base;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
public interface m {
    BdUniqueId getUniqueId();

    boolean isScroll();

    void onPreLoad(BdListView bdListView);

    void setIsScroll(boolean z);
}
