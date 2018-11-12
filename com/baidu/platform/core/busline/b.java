package com.baidu.platform.core.busline;

import com.baidu.ar.util.IoUtils;
import com.baidu.mapapi.search.busline.BusLineSearchOption;
import com.baidu.platform.base.e;
/* loaded from: classes4.dex */
public class b extends e {
    public b(BusLineSearchOption busLineSearchOption) {
        a(busLineSearchOption);
    }

    private void a(BusLineSearchOption busLineSearchOption) {
        this.a.a("qt", "bsl");
        this.a.a("rt_info", "1");
        this.a.a("ie", IoUtils.UTF_8);
        this.a.a("oue", "0");
        this.a.a("c", busLineSearchOption.mCity);
        this.a.a("uid", busLineSearchOption.mUid);
        this.a.a("t", System.currentTimeMillis() + "");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.m();
    }
}
