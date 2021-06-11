package com.baidu.platform.core.c;

import com.baidu.down.request.task.ProgressInfo;
import com.baidu.mapapi.search.poi.PoiIndoorOption;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
/* loaded from: classes2.dex */
public class c extends com.baidu.platform.base.e {
    public c(PoiIndoorOption poiIndoorOption) {
        a(poiIndoorOption);
    }

    private void a(PoiIndoorOption poiIndoorOption) {
        this.f9309a.a("qt", "indoor_s");
        this.f9309a.a("x", "0");
        this.f9309a.a("y", "0");
        this.f9309a.a("from", "android_map_sdk");
        String str = poiIndoorOption.bid;
        if (str != null && !str.equals("")) {
            this.f9309a.a("bid", str);
        }
        String str2 = poiIndoorOption.wd;
        if (str2 != null && !str2.equals("")) {
            this.f9309a.a(ActVideoSetting.WIFI_DISPLAY, str2);
        }
        String str3 = poiIndoorOption.floor;
        if (str3 != null && !str3.equals("")) {
            this.f9309a.a("floor", str3);
        }
        com.baidu.platform.util.a aVar = this.f9309a;
        aVar.a(ProgressInfo.JSON_KEY_CURRENT, poiIndoorOption.currentPage + "");
        com.baidu.platform.util.a aVar2 = this.f9309a;
        aVar2.a("pageSize", poiIndoorOption.pageSize + "");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.c();
    }
}
