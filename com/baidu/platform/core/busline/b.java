package com.baidu.platform.core.busline;

import com.baidu.mapapi.search.busline.BusLineSearchOption;
import com.baidu.platform.base.e;
/* loaded from: classes2.dex */
public class b extends e {
    public b(BusLineSearchOption busLineSearchOption) {
        a(busLineSearchOption);
    }

    private void a(BusLineSearchOption busLineSearchOption) {
        this.f9379a.a("qt", "bsl");
        this.f9379a.a("rt_info", "1");
        this.f9379a.a("ie", "utf-8");
        this.f9379a.a("oue", "0");
        this.f9379a.a("c", busLineSearchOption.mCity);
        this.f9379a.a("uid", busLineSearchOption.mUid);
        com.baidu.platform.util.a aVar = this.f9379a;
        aVar.a("t", System.currentTimeMillis() + "");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.m();
    }
}
