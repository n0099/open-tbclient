package com.baidu.platform.core.f;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.platform.base.e;
/* loaded from: classes2.dex */
public class d extends e {
    public d(SuggestionSearchOption suggestionSearchOption) {
        a(suggestionSearchOption);
    }

    private void a(SuggestionSearchOption suggestionSearchOption) {
        com.baidu.platform.util.a aVar;
        String str;
        this.f9379a.a(IAdRequestParam.COST_NAME, suggestionSearchOption.mKeyword);
        this.f9379a.a("region", suggestionSearchOption.mCity);
        if (suggestionSearchOption.mLocation != null) {
            LatLng latLng = suggestionSearchOption.mLocation;
            LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
            }
            com.baidu.platform.util.a aVar2 = this.f9379a;
            aVar2.a("location", latLng2.latitude + "," + latLng2.longitude);
        }
        if (suggestionSearchOption.mCityLimit.booleanValue()) {
            aVar = this.f9379a;
            str = "true";
        } else {
            aVar = this.f9379a;
            str = "false";
        }
        aVar.a("city_limit", str);
        this.f9379a.a("from", "android_map_sdk");
        this.f9379a.a("output", "json");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.d();
    }
}
