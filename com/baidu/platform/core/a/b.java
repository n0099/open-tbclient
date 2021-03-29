package com.baidu.platform.core.a;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends com.baidu.platform.base.d {

    /* renamed from: b  reason: collision with root package name */
    public boolean f10405b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f10406c = null;

    private boolean a(String str, DistrictResult districtResult) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONArray jSONArray;
        JSONArray optJSONArray2;
        int length;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        int i;
        if (str == null || "".equals(str) || districtResult == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("result");
            JSONObject optJSONObject3 = jSONObject.optJSONObject("city_result");
            if (optJSONObject2 == null || optJSONObject3 == null) {
                return false;
            }
            if (optJSONObject2.optInt("error") == 0 && (optJSONObject = optJSONObject3.optJSONObject("content")) != null) {
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("sgeo");
                if (optJSONObject4 != null && (optJSONArray = optJSONObject4.optJSONArray("geo_elements")) != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    while (i2 < optJSONArray.length()) {
                        JSONObject optJSONObject5 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject5 == null || (optJSONArray2 = optJSONObject5.optJSONArray(Config.EVENT_HEAT_POINT)) == null || (length = optJSONArray2.length()) <= 0) {
                            jSONArray = optJSONArray;
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            int i3 = 0;
                            int i4 = 0;
                            int i5 = 0;
                            while (i3 < length) {
                                int optInt = optJSONArray2.optInt(i3);
                                if (i3 % 2 == 0) {
                                    i5 += optInt;
                                    jSONArray2 = optJSONArray;
                                    jSONArray3 = optJSONArray2;
                                    i = length;
                                } else {
                                    i4 += optInt;
                                    jSONArray2 = optJSONArray;
                                    jSONArray3 = optJSONArray2;
                                    i = length;
                                    arrayList2.add(CoordUtil.mc2ll(new GeoPoint(i4, i5)));
                                }
                                i3++;
                                optJSONArray = jSONArray2;
                                optJSONArray2 = jSONArray3;
                                length = i;
                            }
                            jSONArray = optJSONArray;
                            arrayList.add(arrayList2);
                        }
                        i2++;
                        optJSONArray = jSONArray;
                    }
                    if (arrayList.size() > 0) {
                        districtResult.setPolylines(arrayList);
                        districtResult.setCenterPt(CoordUtil.decodeLocation(optJSONObject.optString("geo")));
                        districtResult.setCityCode(optJSONObject.optInt("code"));
                        districtResult.setCityName(optJSONObject.optString("cname"));
                        districtResult.error = SearchResult.ERRORNO.NO_ERROR;
                        return true;
                    }
                }
                districtResult.setCityName(optJSONObject.optString("uid"));
                this.f10406c = optJSONObject.optString("cname");
                districtResult.setCenterPt(CoordUtil.decodeLocation(optJSONObject.optString("geo")));
                districtResult.setCityCode(optJSONObject.optInt("code"));
                return false;
            }
            return false;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(String str, DistrictResult districtResult) {
        List<List<LatLng>> decodeLocationList2D;
        if (str != null && !str.equals("") && districtResult != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("result");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("content");
                if (optJSONObject == null || optJSONObject2 == null || optJSONObject.optInt("error") != 0) {
                    return false;
                }
                ArrayList arrayList = new ArrayList();
                if (this.f10406c != null) {
                    try {
                        decodeLocationList2D = CoordUtil.decodeLocationList2D(optJSONObject2.optString("geo"));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (decodeLocationList2D != null) {
                        for (List<LatLng> list : decodeLocationList2D) {
                            ArrayList arrayList2 = new ArrayList();
                            for (LatLng latLng : list) {
                                arrayList2.add(latLng);
                            }
                            arrayList.add(arrayList2);
                        }
                    }
                    if (arrayList.size() > 0) {
                        districtResult.setPolylines(arrayList);
                    }
                    districtResult.setCityName(this.f10406c);
                    districtResult.error = SearchResult.ERRORNO.NO_ERROR;
                    this.f10406c = null;
                    return true;
                }
                decodeLocationList2D = null;
                if (decodeLocationList2D != null) {
                }
                if (arrayList.size() > 0) {
                }
                districtResult.setCityName(this.f10406c);
                districtResult.error = SearchResult.ERRORNO.NO_ERROR;
                this.f10406c = null;
                return true;
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        DistrictResult districtResult = new DistrictResult();
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        districtResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                        return districtResult;
                    } else if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        districtResult.error = optString.equals("NETWORK_ERROR") ? SearchResult.ERRORNO.NETWORK_ERROR : optString.equals("REQUEST_ERROR") ? SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        return districtResult;
                    }
                }
                if (!a(str, districtResult, false)) {
                    if (this.f10405b) {
                        b(str, districtResult);
                    } else if (!a(str, districtResult)) {
                        districtResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    }
                }
                return districtResult;
            } catch (Exception unused) {
            }
        }
        districtResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return districtResult;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetDistricSearchResultListener)) {
            return;
        }
        ((OnGetDistricSearchResultListener) obj).onGetDistrictResult((DistrictResult) searchResult);
    }

    public void a(boolean z) {
        this.f10405b = z;
    }
}
