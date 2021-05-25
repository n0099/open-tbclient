package com.baidu.platform.core.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends com.baidu.platform.base.d {

    /* renamed from: b  reason: collision with root package name */
    public static final String f9271b = "b";

    /* renamed from: c  reason: collision with root package name */
    public String f9272c;

    private LatLng a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        double optDouble = jSONObject.optDouble(SuggestAddrField.KEY_LAT);
        double optDouble2 = jSONObject.optDouble(SuggestAddrField.KEY_LNG);
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(new LatLng(optDouble, optDouble2)) : new LatLng(optDouble, optDouble2);
    }

    private boolean a(String str, GeoCodeResult geoCodeResult) {
        if (TextUtils.isEmpty(str) || geoCodeResult == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("status");
            if (optInt != 0) {
                geoCodeResult.error = optInt != 1 ? optInt != 2 ? SearchResult.ERRORNO.RESULT_NOT_FOUND : SearchResult.ERRORNO.SEARCH_OPTION_ERROR : SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                return false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject == null) {
                geoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return false;
            }
            geoCodeResult.setLocation(a(optJSONObject.optJSONObject("location")));
            geoCodeResult.setAddress(this.f9272c);
            geoCodeResult.setPrecise(optJSONObject.optInt("precise"));
            geoCodeResult.setConfidence(optJSONObject.optInt("confidence"));
            geoCodeResult.setLevel(optJSONObject.optString("level"));
            geoCodeResult.error = SearchResult.ERRORNO.NO_ERROR;
            return true;
        } catch (JSONException e2) {
            geoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            Log.e(f9271b, "Parse GeoCodeResult catch JSONException", e2);
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x006f, code lost:
        if (r7.equals("NETWORK_ERROR") != false) goto L31;
     */
    @Override // com.baidu.platform.base.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SearchResult a(String str) {
        SearchResult.ERRORNO errorno;
        JSONObject jSONObject;
        char c2;
        GeoCodeResult geoCodeResult = new GeoCodeResult();
        if (str != null && !str.equals("")) {
            try {
                jSONObject = new JSONObject(str);
                c2 = 0;
            } catch (JSONException e2) {
                Log.e(f9271b, "JSONException caught", e2);
            }
            if (!jSONObject.has("SDK_InnerError")) {
                if (!a(str, geoCodeResult, false) && !a(str, geoCodeResult)) {
                    geoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
                return geoCodeResult;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
            if (optJSONObject.has("PermissionCheckError")) {
                errorno = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                geoCodeResult.error = errorno;
                return geoCodeResult;
            } else if (optJSONObject.has("httpStateError")) {
                String optString = optJSONObject.optString("httpStateError");
                int hashCode = optString.hashCode();
                if (hashCode != -879828873) {
                    if (hashCode == 1470557208 && optString.equals("REQUEST_ERROR")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                }
                geoCodeResult.error = c2 != 0 ? c2 != 1 ? SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR : SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.NETWORK_ERROR;
                return geoCodeResult;
            }
        }
        errorno = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        geoCodeResult.error = errorno;
        return geoCodeResult;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetGeoCoderResultListener)) {
            return;
        }
        ((OnGetGeoCoderResultListener) obj).onGetGeoCodeResult((GeoCodeResult) searchResult);
    }

    public void b(String str) {
        this.f9272c = str;
    }
}
