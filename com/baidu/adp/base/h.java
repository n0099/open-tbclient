package com.baidu.adp.base;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.r;
/* loaded from: classes.dex */
public interface h {
    BdUniqueId getUniqueId();

    boolean isScroll();

    void onPreLoad(r rVar);

    void setIsScroll(boolean z);
}
