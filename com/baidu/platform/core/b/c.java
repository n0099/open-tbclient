package com.baidu.platform.core.b;

import com.baidu.ar.util.IoUtils;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
/* loaded from: classes4.dex */
public class c extends com.baidu.platform.base.e {
    public c(GeoCodeOption geoCodeOption) {
        a(geoCodeOption);
    }

    private void a(GeoCodeOption geoCodeOption) {
        this.a.a("qt", "gc");
        this.a.a(AdvanceSetting.CLEAR_NOTIFICATION, geoCodeOption.mCity);
        this.a.a("ie", IoUtils.UTF_8);
        this.a.a("oue", "0");
        this.a.a(ActVideoSetting.WIFI_DISPLAY, geoCodeOption.mAddress);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.f();
    }
}
