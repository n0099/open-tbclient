package com.baidu.adp.base;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public interface i {
    BdUniqueId getUniqueId();

    boolean isScroll();

    void onPreLoad(q qVar);

    void setIsScroll(boolean z);
}
