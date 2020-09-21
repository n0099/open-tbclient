package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes3.dex */
public class d extends InnerOverlay {
    public d() {
        super(20);
    }

    public d(AppBaseMap appBaseMap) {
        super(20, appBaseMap);
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public boolean getDefaultShowStatus() {
        return true;
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public String getLayerTag() {
        return MapController.COMPASS_LAYER_TAG;
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public void setData(String str) {
        super.setData(str);
    }
}
