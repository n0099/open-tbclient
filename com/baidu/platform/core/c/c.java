package com.baidu.platform.core.c;

import com.baidu.mapapi.search.poi.PoiIndoorOption;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
/* loaded from: classes8.dex */
public class c extends com.baidu.platform.base.e {
    public c(PoiIndoorOption poiIndoorOption) {
        a(poiIndoorOption);
    }

    private void a(PoiIndoorOption poiIndoorOption) {
        this.a.a("qt", "indoor_s");
        this.a.a(Config.EVENT_HEAT_X, "0");
        this.a.a("y", "0");
        this.a.a("from", "android_map_sdk");
        String str = poiIndoorOption.bid;
        if (str != null && !str.equals("")) {
            this.a.a("bid", str);
        }
        String str2 = poiIndoorOption.wd;
        if (str2 != null && !str2.equals("")) {
            this.a.a(ActVideoSetting.WIFI_DISPLAY, str2);
        }
        String str3 = poiIndoorOption.floor;
        if (str3 != null && !str3.equals("")) {
            this.a.a("floor", str3);
        }
        this.a.a("current", poiIndoorOption.currentPage + "");
        this.a.a("pageSize", poiIndoorOption.pageSize + "");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.c();
    }
}
