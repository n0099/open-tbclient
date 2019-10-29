package com.baidu.platform.core.a;

import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import com.tencent.connect.common.Constants;
/* loaded from: classes5.dex */
public class a extends com.baidu.platform.base.e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(DistrictSearchOption districtSearchOption) {
        a(districtSearchOption);
    }

    private void a(DistrictSearchOption districtSearchOption) {
        if (districtSearchOption == null) {
            return;
        }
        this.a.a("qt", "con");
        this.a.a("rp_format", "json");
        this.a.a("rp_filter", "mobile");
        this.a.a("area_res", "true");
        this.a.a("addr_identify", "1");
        this.a.a("ie", "utf-8");
        this.a.a(Config.PACKAGE_NAME, "0");
        this.a.a("rn", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        this.a.a("c", districtSearchOption.mCityName);
        if (districtSearchOption.mDistrictName == null || districtSearchOption.mDistrictName.equals("")) {
            this.a.a(ActVideoSetting.WIFI_DISPLAY, districtSearchOption.mCityName);
        } else {
            this.a.a(ActVideoSetting.WIFI_DISPLAY, districtSearchOption.mDistrictName);
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.n();
    }
}
