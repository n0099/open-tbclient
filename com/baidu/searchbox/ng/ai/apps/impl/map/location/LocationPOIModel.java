package com.baidu.searchbox.ng.ai.apps.impl.map.location;

import com.baidu.mapapi.search.core.PoiInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class LocationPOIModel {
    public boolean isDefaultItem;
    public boolean isSelected;
    public PoiInfo poiInfo;

    public LocationPOIModel(PoiInfo poiInfo, boolean z, boolean z2) {
        if (poiInfo == null) {
            this.poiInfo = new PoiInfo();
        }
        this.poiInfo = poiInfo;
        this.isSelected = z;
        this.isDefaultItem = z2;
    }

    public LocationPOIModel(PoiInfo poiInfo) {
        this(poiInfo, false, false);
    }

    public static List<LocationPOIModel> createModels(List<PoiInfo> list) {
        if (list == null || list.size() <= 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (PoiInfo poiInfo : list) {
            if (poiInfo.location != null) {
                arrayList.add(new LocationPOIModel(poiInfo));
            }
        }
        return arrayList;
    }
}
