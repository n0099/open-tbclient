package com.baidu.platform.core.busline;

import com.baidu.mapapi.search.busline.BusLineSearchOption;
import com.baidu.mapapi.search.busline.OnGetBusLineSearchResultListener;
/* loaded from: classes9.dex */
public interface IBusLineSearch {
    void a();

    void a(OnGetBusLineSearchResultListener onGetBusLineSearchResultListener);

    boolean a(BusLineSearchOption busLineSearchOption);
}
