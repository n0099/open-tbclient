package com.baidu.swan.impl.map.location;

import com.baidu.mapapi.search.core.PoiInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public PoiInfo eqk;
    public boolean eql;
    public boolean isSelected;

    public c(PoiInfo poiInfo, boolean z, boolean z2) {
        if (poiInfo == null) {
            this.eqk = new PoiInfo();
        }
        this.eqk = poiInfo;
        this.isSelected = z;
        this.eql = z2;
    }

    public c(PoiInfo poiInfo) {
        this(poiInfo, false, false);
    }

    public static List<c> aZ(List<PoiInfo> list) {
        if (list == null || list.size() <= 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (PoiInfo poiInfo : list) {
            if (poiInfo.location != null) {
                arrayList.add(new c(poiInfo));
            }
        }
        return arrayList;
    }
}
