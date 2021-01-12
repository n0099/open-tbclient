package com.baidu.platform.core.busline;

import com.baidu.mapapi.search.busline.BusLineSearchOption;
import com.baidu.platform.base.e;
/* loaded from: classes6.dex */
public class b extends e {
    public b(BusLineSearchOption busLineSearchOption) {
        a(busLineSearchOption);
    }

    private void a(BusLineSearchOption busLineSearchOption) {
        this.f4140a.a("qt", "bsl");
        this.f4140a.a("rt_info", "1");
        this.f4140a.a("ie", "utf-8");
        this.f4140a.a("oue", "0");
        this.f4140a.a("c", busLineSearchOption.mCity);
        this.f4140a.a("uid", busLineSearchOption.mUid);
        this.f4140a.a("t", System.currentTimeMillis() + "");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.m();
    }
}
