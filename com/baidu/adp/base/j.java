package com.baidu.adp.base;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.w;
/* loaded from: classes.dex */
public interface j {
    BdUniqueId getUniqueId();

    boolean isScroll();

    void onPreLoad(w wVar);

    void setIsScroll(boolean z);
}
