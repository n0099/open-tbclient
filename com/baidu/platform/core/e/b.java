package com.baidu.platform.core.e;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
/* loaded from: classes6.dex */
public class b extends com.baidu.platform.base.e {
    public b(LocationShareURLOption locationShareURLOption) {
        a(locationShareURLOption);
    }

    private void a(LocationShareURLOption locationShareURLOption) {
        this.a.a("qt", IXAdRequestInfo.CS);
        Point ll2point = CoordUtil.ll2point(locationShareURLOption.mLocation);
        this.a.a("geo", ll2point.x + "|" + ll2point.y);
        this.a.a("t", locationShareURLOption.mName);
        this.a.a("cnt", locationShareURLOption.mSnippet);
        b(false);
        a(false);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.q();
    }
}
