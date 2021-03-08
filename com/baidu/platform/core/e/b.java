package com.baidu.platform.core.e;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
/* loaded from: classes4.dex */
public class b extends com.baidu.platform.base.e {
    public b(LocationShareURLOption locationShareURLOption) {
        a(locationShareURLOption);
    }

    private void a(LocationShareURLOption locationShareURLOption) {
        this.f2867a.a("qt", IXAdRequestInfo.CS);
        Point ll2point = CoordUtil.ll2point(locationShareURLOption.mLocation);
        this.f2867a.a("geo", ll2point.x + "|" + ll2point.y);
        this.f2867a.a("t", locationShareURLOption.mName);
        this.f2867a.a("cnt", locationShareURLOption.mSnippet);
        b(false);
        a(false);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.q();
    }
}
