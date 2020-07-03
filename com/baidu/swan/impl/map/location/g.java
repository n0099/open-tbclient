package com.baidu.swan.impl.map.location;

import com.baidu.mapapi.search.core.PoiInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class g {
    public PoiInfo dmd;
    public boolean dme;
    public boolean isSelected;

    public g(PoiInfo poiInfo, boolean z, boolean z2) {
        if (poiInfo == null) {
            this.dmd = new PoiInfo();
        }
        this.dmd = poiInfo;
        this.isSelected = z;
        this.dme = z2;
    }

    public g(PoiInfo poiInfo) {
        this(poiInfo, false, false);
    }

    public static List<g> ar(List<PoiInfo> list) {
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
