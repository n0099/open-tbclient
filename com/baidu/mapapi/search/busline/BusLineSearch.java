package com.baidu.mapapi.search.busline;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.l;
import com.baidu.platform.core.busline.IBusLineSearch;
import com.baidu.platform.core.busline.c;
/* loaded from: classes10.dex */
public class BusLineSearch extends l {
    private boolean b = false;
    IBusLineSearch a = new c();

    BusLineSearch() {
    }

    public static BusLineSearch newInstance() {
        BMapManager.init();
        return new BusLineSearch();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.a.a();
        BMapManager.destroy();
    }

    public boolean searchBusLine(BusLineSearchOption busLineSearchOption) {
        if (this.a == null) {
            throw new IllegalStateException("searcher is null, please call newInstance first.");
        }
        if (busLineSearchOption == null || busLineSearchOption.mCity == null || busLineSearchOption.mUid == null) {
            throw new IllegalArgumentException("option or city or uid can not be null");
        }
        return this.a.a(busLineSearchOption);
    }

    public void setOnGetBusLineSearchResultListener(OnGetBusLineSearchResultListener onGetBusLineSearchResultListener) {
        if (this.a == null) {
            throw new IllegalStateException("searcher is null, please call newInstance first.");
        }
        if (onGetBusLineSearchResultListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        this.a.a(onGetBusLineSearchResultListener);
    }
}
