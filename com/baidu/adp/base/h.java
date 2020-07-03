package com.baidu.adp.base;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.t;
/* loaded from: classes.dex */
public interface h {
    BdUniqueId getUniqueId();

    boolean isScroll();

    void onPreLoad(t tVar);

    void setIsScroll(boolean z);
}
