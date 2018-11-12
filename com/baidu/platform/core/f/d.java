package com.baidu.platform.core.f;

import android.net.http.Headers;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.e;
import com.baidu.searchbox.ng.ai.apps.network.NetworkDef;
import com.baidu.webkit.internal.ABTestConstants;
/* loaded from: classes4.dex */
public class d extends e {
    public d(SuggestionSearchOption suggestionSearchOption) {
        a(suggestionSearchOption);
    }

    private void a(SuggestionSearchOption suggestionSearchOption) {
        this.a.a("q", suggestionSearchOption.mKeyword);
        this.a.a("region", suggestionSearchOption.mCity);
        if (suggestionSearchOption.mLocation != null) {
            LatLng latLng = new LatLng(suggestionSearchOption.mLocation.latitude, suggestionSearchOption.mLocation.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            this.a.a(Headers.LOCATION, latLng.latitude + "," + latLng.longitude);
        }
        if (suggestionSearchOption.mCityLimit.booleanValue()) {
            this.a.a("city_limit", "true");
        } else {
            this.a.a("city_limit", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        }
        this.a.a("from", "android_map_sdk");
        this.a.a("output", NetworkDef.DataType.JSON);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.d();
    }
}
