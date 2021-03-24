package com.baidu.platform.core.a;

import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class a extends com.baidu.platform.base.e {
    public a(DistrictSearchOption districtSearchOption) {
        a(districtSearchOption);
    }

    private void a(DistrictSearchOption districtSearchOption) {
        com.baidu.platform.util.a aVar;
        String str;
        if (districtSearchOption == null) {
            return;
        }
        this.f9820a.a("qt", "con");
        this.f9820a.a("rp_format", "json");
        this.f9820a.a("rp_filter", "mobile");
        this.f9820a.a("area_res", "true");
        this.f9820a.a("addr_identify", "1");
        this.f9820a.a("ie", "utf-8");
        this.f9820a.a(Config.PACKAGE_NAME, "0");
        this.f9820a.a("rn", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        this.f9820a.a("c", districtSearchOption.mCityName);
        String str2 = districtSearchOption.mDistrictName;
        if (str2 == null || str2.equals("")) {
            aVar = this.f9820a;
            str = districtSearchOption.mCityName;
        } else {
            aVar = this.f9820a;
            str = districtSearchOption.mDistrictName;
        }
        aVar.a(ActVideoSetting.WIFI_DISPLAY, str);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.n();
    }
}
