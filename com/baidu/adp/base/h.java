package com.baidu.adp.base;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.k;
/* loaded from: classes.dex */
public interface h {
    BdUniqueId getUniqueId();

    boolean isScroll();

    void onPreLoad(k kVar);

    void setIsScroll(boolean z);
}
