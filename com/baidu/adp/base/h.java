package com.baidu.adp.base;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.l;
/* loaded from: classes.dex */
public interface h {
    BdUniqueId getUniqueId();

    boolean isScroll();

    void onPreLoad(l lVar);

    void setIsScroll(boolean z);
}
