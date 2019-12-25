package com.baidu.live.adp.base;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IPreLoadListView;
/* loaded from: classes2.dex */
public interface IScrollable {
    BdUniqueId getUniqueId();

    boolean isScroll();

    void onPreLoad(IPreLoadListView iPreLoadListView);

    void setIsScroll(boolean z);
}
