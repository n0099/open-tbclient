package com.baidu.swan.impl.map.location;

import com.baidu.mapapi.search.core.PoiInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public PoiInfo esR;
    public boolean esS;
    public boolean isSelected;

    public c(PoiInfo poiInfo, boolean z, boolean z2) {
        if (poiInfo == null) {
            this.esR = new PoiInfo();
        }
        this.esR = poiInfo;
        this.isSelected = z;
        this.esS = z2;
    }

    public c(PoiInfo poiInfo) {
        this(poiInfo, false, false);
    }

    public static List<c> be(List<PoiInfo> list) {
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
