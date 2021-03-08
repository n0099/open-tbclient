package com.baidu.swan.impl.map.location;

import com.baidu.mapapi.search.core.PoiInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    public PoiInfo erM;
    public boolean erN;
    public boolean isSelected;

    public c(PoiInfo poiInfo, boolean z, boolean z2) {
        if (poiInfo == null) {
            this.erM = new PoiInfo();
        }
        this.erM = poiInfo;
        this.isSelected = z;
        this.erN = z2;
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
