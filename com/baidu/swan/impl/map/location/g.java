package com.baidu.swan.impl.map.location;

import com.baidu.mapapi.search.core.PoiInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class g {
    public PoiInfo dEe;
    public boolean dEf;
    public boolean isSelected;

    public g(PoiInfo poiInfo, boolean z, boolean z2) {
        if (poiInfo == null) {
            this.dEe = new PoiInfo();
        }
        this.dEe = poiInfo;
        this.isSelected = z;
        this.dEf = z2;
    }

    public g(PoiInfo poiInfo) {
        this(poiInfo, false, false);
    }

    public static List<g> aA(List<PoiInfo> list) {
        if (list == null || list.size() <= 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (PoiInfo poiInfo : list) {
            if (poiInfo.location != null) {
                arrayList.add(new g(poiInfo));
            }
        }
        return arrayList;
    }
}
