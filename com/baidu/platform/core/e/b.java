package com.baidu.platform.core.e;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapBundleKey;
/* loaded from: classes20.dex */
public class b extends com.baidu.platform.base.e {
    public b(LocationShareURLOption locationShareURLOption) {
        a(locationShareURLOption);
    }

    private void a(LocationShareURLOption locationShareURLOption) {
        this.a.a("qt", IXAdRequestInfo.CS);
        Point ll2point = CoordUtil.ll2point(locationShareURLOption.mLocation);
        this.a.a(MapBundleKey.MapObjKey.OBJ_GEO, ll2point.x + "|" + ll2point.y);
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
