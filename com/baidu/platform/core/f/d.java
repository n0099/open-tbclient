package com.baidu.platform.core.f;

import android.net.http.Headers;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.platform.base.e;
/* loaded from: classes4.dex */
public class d extends e {
    public d(SuggestionSearchOption suggestionSearchOption) {
        a(suggestionSearchOption);
    }

    private void a(SuggestionSearchOption suggestionSearchOption) {
        this.f4143a.a(IXAdRequestInfo.COST_NAME, suggestionSearchOption.mKeyword);
        this.f4143a.a("region", suggestionSearchOption.mCity);
        if (suggestionSearchOption.mLocation != null) {
            LatLng latLng = new LatLng(suggestionSearchOption.mLocation.latitude, suggestionSearchOption.mLocation.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            this.f4143a.a(Headers.LOCATION, latLng.latitude + "," + latLng.longitude);
        }
        if (suggestionSearchOption.mCityLimit.booleanValue()) {
            this.f4143a.a("city_limit", "true");
        } else {
            this.f4143a.a("city_limit", "false");
        }
        this.f4143a.a("from", "android_map_sdk");
        this.f4143a.a("output", "json");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.d();
    }
}
