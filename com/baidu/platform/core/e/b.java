package com.baidu.platform.core.e;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapBundleKey;
/* loaded from: classes15.dex */
public class b extends com.baidu.platform.base.e {
    public b(LocationShareURLOption locationShareURLOption) {
        a(locationShareURLOption);
    }

    private void a(LocationShareURLOption locationShareURLOption) {
        this.f4177a.a("qt", IXAdRequestInfo.CS);
        Point ll2point = CoordUtil.ll2point(locationShareURLOption.mLocation);
        this.f4177a.a(MapBundleKey.MapObjKey.OBJ_GEO, ll2point.x + "|" + ll2point.y);
        this.f4177a.a("t", locationShareURLOption.mName);
        this.f4177a.a("cnt", locationShareURLOption.mSnippet);
        b(false);
        a(false);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.q();
    }
}
