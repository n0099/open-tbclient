package com.baidu.platform.core.b;

import android.net.http.Headers;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e extends com.baidu.platform.base.d {
    private ReverseGeoCodeResult.AddressComponent a(JSONObject jSONObject, String str) {
        JSONObject optJSONObject;
        if (jSONObject == null || str == null || "".equals(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return null;
        }
        ReverseGeoCodeResult.AddressComponent addressComponent = new ReverseGeoCodeResult.AddressComponent();
        addressComponent.city = optJSONObject.optString("city");
        addressComponent.district = optJSONObject.optString("district");
        addressComponent.province = optJSONObject.optString("province");
        addressComponent.adcode = optJSONObject.optInt("adcode");
        addressComponent.street = optJSONObject.optString("street");
        addressComponent.streetNumber = optJSONObject.optString("street_number");
        addressComponent.countryName = optJSONObject.optString("country");
        addressComponent.countryCode = optJSONObject.optInt("country_code");
        return addressComponent;
    }

    private List<PoiInfo> a(JSONObject jSONObject, String str, String str2) {
        JSONArray optJSONArray;
        if (jSONObject == null || str == null || "".equals(str) || (optJSONArray = jSONObject.optJSONArray(str)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                PoiInfo poiInfo = new PoiInfo();
                poiInfo.address = optJSONObject.optString("addr");
                poiInfo.phoneNum = optJSONObject.optString("tel");
                poiInfo.uid = optJSONObject.optString("uid");
                poiInfo.postCode = optJSONObject.optString("zip");
                poiInfo.name = optJSONObject.optString("name");
                poiInfo.location = b(optJSONObject, Config.EVENT_HEAT_POINT);
                poiInfo.city = str2;
                arrayList.add(poiInfo);
            }
        }
        return arrayList;
    }

    private boolean a(String str, ReverseGeoCodeResult reverseGeoCodeResult) {
        boolean z = false;
        if (str != null) {
            try {
            } catch (JSONException e) {
                e.printStackTrace();
                reverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
            if (str.length() > 0) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject == null) {
                    reverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                } else {
                    int optInt = jSONObject.optInt("status");
                    if (optInt != 0) {
                        switch (optInt) {
                            case 1:
                                reverseGeoCodeResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                                break;
                            case 2:
                                reverseGeoCodeResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
                                break;
                            default:
                                reverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                                break;
                        }
                    } else if (a(jSONObject, reverseGeoCodeResult)) {
                        z = true;
                    } else {
                        reverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    }
                }
                return z;
            }
        }
        reverseGeoCodeResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
        return z;
    }

    private boolean a(JSONObject jSONObject, ReverseGeoCodeResult reverseGeoCodeResult) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("result")) == null) {
            return false;
        }
        reverseGeoCodeResult.setCityCode(optJSONObject.optInt("cityCode"));
        reverseGeoCodeResult.setAddress(optJSONObject.optString("formatted_address"));
        reverseGeoCodeResult.setBusinessCircle(optJSONObject.optString("business"));
        reverseGeoCodeResult.setAddressDetail(a(optJSONObject, "addressComponent"));
        reverseGeoCodeResult.setLocation(c(optJSONObject, Headers.LOCATION));
        reverseGeoCodeResult.setPoiList(a(optJSONObject, "pois", reverseGeoCodeResult.getAddressDetail() != null ? reverseGeoCodeResult.getAddressDetail().city : ""));
        reverseGeoCodeResult.setSematicDescription(optJSONObject.optString("sematic_description"));
        reverseGeoCodeResult.error = SearchResult.ERRORNO.NO_ERROR;
        return true;
    }

    private LatLng b(JSONObject jSONObject, String str) {
        JSONObject optJSONObject;
        if (jSONObject == null || str == null || "".equals(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return null;
        }
        LatLng latLng = new LatLng(optJSONObject.optDouble("y"), optJSONObject.optDouble(Config.EVENT_HEAT_X));
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(latLng) : latLng;
    }

    private LatLng c(JSONObject jSONObject, String str) {
        JSONObject optJSONObject;
        if (jSONObject == null || str == null || "".equals(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return null;
        }
        LatLng latLng = new LatLng(optJSONObject.optDouble("lat"), optJSONObject.optDouble("lng"));
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(latLng) : latLng;
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        ReverseGeoCodeResult reverseGeoCodeResult = new ReverseGeoCodeResult();
        if (str == null || str.equals("")) {
            reverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        reverseGeoCodeResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    } else if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        if (optString.equals("NETWORK_ERROR")) {
                            reverseGeoCodeResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                        } else if (optString.equals("REQUEST_ERROR")) {
                            reverseGeoCodeResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                        } else {
                            reverseGeoCodeResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        }
                    }
                }
                if (!a(str, (SearchResult) reverseGeoCodeResult, true)) {
                    a(str, reverseGeoCodeResult);
                }
            } catch (Exception e) {
                reverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
        }
        return reverseGeoCodeResult;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetGeoCoderResultListener)) {
            return;
        }
        ((OnGetGeoCoderResultListener) obj).onGetReverseGeoCodeResult((ReverseGeoCodeResult) searchResult);
    }
}
