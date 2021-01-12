package com.baidu.platform.core.busline;

import com.baidu.mapapi.search.busline.BusLineSearchOption;
import com.baidu.mapapi.search.busline.OnGetBusLineSearchResultListener;
import com.baidu.platform.base.SearchType;
/* loaded from: classes6.dex */
public class c extends com.baidu.platform.base.a implements IBusLineSearch {

    /* renamed from: b  reason: collision with root package name */
    OnGetBusLineSearchResultListener f4485b = null;

    @Override // com.baidu.platform.core.busline.IBusLineSearch
    public void a() {
        this.f4133a.lock();
        this.f4485b = null;
        this.f4133a.unlock();
    }

    @Override // com.baidu.platform.core.busline.IBusLineSearch
    public void a(OnGetBusLineSearchResultListener onGetBusLineSearchResultListener) {
        this.f4133a.lock();
        this.f4485b = onGetBusLineSearchResultListener;
        this.f4133a.unlock();
    }

    @Override // com.baidu.platform.core.busline.IBusLineSearch
    public boolean a(BusLineSearchOption busLineSearchOption) {
        a aVar = new a();
        aVar.a(SearchType.BUS_LINE_DETAIL);
        return a(new b(busLineSearchOption), this.f4485b, aVar);
    }
}
