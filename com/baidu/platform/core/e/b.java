package com.baidu.platform.core.e;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.tbadk.core.util.FieldBuilder;
/* loaded from: classes2.dex */
public class b extends com.baidu.platform.base.e {
    public b(LocationShareURLOption locationShareURLOption) {
        a(locationShareURLOption);
    }

    private void a(LocationShareURLOption locationShareURLOption) {
        this.f9730a.a("qt", "cs");
        Point ll2point = CoordUtil.ll2point(locationShareURLOption.mLocation);
        com.baidu.platform.util.a aVar = this.f9730a;
        aVar.a("geo", ll2point.x + FieldBuilder.SE + ll2point.y);
        this.f9730a.a("t", locationShareURLOption.mName);
        this.f9730a.a("cnt", locationShareURLOption.mSnippet);
        b(false);
        a(false);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.q();
    }
}
