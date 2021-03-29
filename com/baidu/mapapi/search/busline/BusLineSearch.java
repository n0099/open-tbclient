package com.baidu.mapapi.search.busline;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.l;
import com.baidu.platform.core.busline.IBusLineSearch;
import com.baidu.platform.core.busline.c;
/* loaded from: classes2.dex */
public class BusLineSearch extends l {

    /* renamed from: b  reason: collision with root package name */
    public boolean f7137b = false;

    /* renamed from: a  reason: collision with root package name */
    public IBusLineSearch f7136a = new c();

    public static BusLineSearch newInstance() {
        BMapManager.init();
        return new BusLineSearch();
    }

    public void destroy() {
        if (this.f7137b) {
            return;
        }
        this.f7137b = true;
        this.f7136a.a();
        BMapManager.destroy();
    }

    public boolean searchBusLine(BusLineSearchOption busLineSearchOption) {
        IBusLineSearch iBusLineSearch = this.f7136a;
        if (iBusLineSearch != null) {
            if (busLineSearchOption == null || busLineSearchOption.mCity == null || busLineSearchOption.mUid == null) {
                throw new IllegalArgumentException("option or city or uid can not be null");
            }
            return iBusLineSearch.a(busLineSearchOption);
        }
        throw new IllegalStateException("searcher is null, please call newInstance first.");
    }

    public void setOnGetBusLineSearchResultListener(OnGetBusLineSearchResultListener onGetBusLineSearchResultListener) {
        IBusLineSearch iBusLineSearch = this.f7136a;
        if (iBusLineSearch == null) {
            throw new IllegalStateException("searcher is null, please call newInstance first.");
        }
        if (onGetBusLineSearchResultListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        iBusLineSearch.a(onGetBusLineSearchResultListener);
    }
}
