package com.baidu.adp.base;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public interface h {
    BdUniqueId getUniqueId();

    boolean isScroll();

    void onPreLoad(com.baidu.adp.widget.ListView.g gVar);

    void setIsScroll(boolean z);
}
