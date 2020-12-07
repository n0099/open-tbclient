package com.baidu.platform.core.f;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.e;
/* loaded from: classes26.dex */
public class d extends e {
    public d(SuggestionSearchOption suggestionSearchOption) {
        a(suggestionSearchOption);
    }

    private void a(SuggestionSearchOption suggestionSearchOption) {
        this.f2818a.a("query", suggestionSearchOption.mKeyword);
        this.f2818a.a("region", suggestionSearchOption.mCity);
        if (suggestionSearchOption.mLocation != null) {
            LatLng latLng = new LatLng(suggestionSearchOption.mLocation.latitude, suggestionSearchOption.mLocation.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            this.f2818a.a("location", latLng.latitude + "," + latLng.longitude);
        }
        if (suggestionSearchOption.mCityLimit.booleanValue()) {
            this.f2818a.a("city_limit", "true");
        } else {
            this.f2818a.a("city_limit", "false");
        }
        this.f2818a.a("from", "android_map_sdk");
        this.f2818a.a("output", "json");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.d();
    }
}
