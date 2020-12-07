package com.baidu.platform.core.busline;

import com.baidu.mapapi.search.busline.BusLineSearchOption;
import com.baidu.platform.base.e;
/* loaded from: classes26.dex */
public class b extends e {
    public b(BusLineSearchOption busLineSearchOption) {
        a(busLineSearchOption);
    }

    private void a(BusLineSearchOption busLineSearchOption) {
        this.f2818a.a("qt", "bsl");
        this.f2818a.a("rt_info", "1");
        this.f2818a.a("ie", "utf-8");
        this.f2818a.a("oue", "0");
        this.f2818a.a("c", busLineSearchOption.mCity);
        this.f2818a.a("uid", busLineSearchOption.mUid);
        this.f2818a.a("t", System.currentTimeMillis() + "");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.m();
    }
}
