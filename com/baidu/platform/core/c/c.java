package com.baidu.platform.core.c;

import com.baidu.mapapi.search.poi.PoiIndoorOption;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
/* loaded from: classes15.dex */
public class c extends com.baidu.platform.base.e {
    public c(PoiIndoorOption poiIndoorOption) {
        a(poiIndoorOption);
    }

    private void a(PoiIndoorOption poiIndoorOption) {
        this.f4177a.a("qt", "indoor_s");
        this.f4177a.a("x", "0");
        this.f4177a.a("y", "0");
        this.f4177a.a("from", "android_map_sdk");
        String str = poiIndoorOption.bid;
        if (str != null && !str.equals("")) {
            this.f4177a.a(MapBundleKey.MapObjKey.OBJ_BID, str);
        }
        String str2 = poiIndoorOption.wd;
        if (str2 != null && !str2.equals("")) {
            this.f4177a.a(ActVideoSetting.WIFI_DISPLAY, str2);
        }
        String str3 = poiIndoorOption.floor;
        if (str3 != null && !str3.equals("")) {
            this.f4177a.a("floor", str3);
        }
        this.f4177a.a("current", poiIndoorOption.currentPage + "");
        this.f4177a.a("pageSize", poiIndoorOption.pageSize + "");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.c();
    }
}
