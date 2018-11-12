package com.baidu.platform.core.b;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends com.baidu.platform.base.d {
    private boolean a(String str, GeoCodeResult geoCodeResult) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            geoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            e.printStackTrace();
        }
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("result")) == null || optJSONObject.optInt(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR) != 0 || (optJSONObject2 = jSONObject.optJSONObject("content")) == null || (optJSONObject3 = optJSONObject2.optJSONObject("coord")) == null) {
            return false;
        }
        geoCodeResult.setLocation(CoordUtil.mc2ll(new GeoPoint(optJSONObject3.optInt("y"), optJSONObject3.optInt(Config.EVENT_HEAT_X))));
        geoCodeResult.setAddress(optJSONObject2.optString(ActVideoSetting.WIFI_DISPLAY));
        geoCodeResult.error = SearchResult.ERRORNO.NO_ERROR;
        return true;
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        GeoCodeResult geoCodeResult = new GeoCodeResult();
        if (str == null || str.equals("")) {
            geoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        geoCodeResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    } else if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        if (optString.equals("NETWORK_ERROR")) {
                            geoCodeResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                        } else if (optString.equals("REQUEST_ERROR")) {
                            geoCodeResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                        } else {
                            geoCodeResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        }
                    }
                }
                if (!a(str, geoCodeResult, false) && !a(str, geoCodeResult)) {
                    geoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
            } catch (Exception e) {
                geoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
        }
        return geoCodeResult;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetGeoCoderResultListener)) {
            return;
        }
        ((OnGetGeoCoderResultListener) obj).onGetGeoCodeResult((GeoCodeResult) searchResult);
    }
}
