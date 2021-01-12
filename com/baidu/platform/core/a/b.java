package com.baidu.platform.core.a;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
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
/* loaded from: classes6.dex */
public class b extends com.baidu.platform.base.d {

    /* renamed from: b  reason: collision with root package name */
    boolean f4481b = false;
    String c = null;

    private boolean a(String str, DistrictResult districtResult) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        int length;
        if (str == null || "".equals(str) || districtResult == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject == null) {
                return false;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("result");
            JSONObject optJSONObject3 = jSONObject.optJSONObject("city_result");
            if (optJSONObject2 == null || optJSONObject3 == null || optJSONObject2.optInt(BdStatsConstant.StatsType.ERROR) != 0 || (optJSONObject = optJSONObject3.optJSONObject("content")) == null) {
                return false;
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("sgeo");
            if (optJSONObject4 != null && (optJSONArray = optJSONObject4.optJSONArray("geo_elements")) != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject5 = optJSONArray.optJSONObject(i);
                    if (optJSONObject5 != null && (optJSONArray2 = optJSONObject5.optJSONArray(Config.EVENT_HEAT_POINT)) != null && (length = optJSONArray2.length()) > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        int i2 = 0;
                        int i3 = 0;
                        for (int i4 = 0; i4 < length; i4++) {
                            int optInt = optJSONArray2.optInt(i4);
                            if (i4 % 2 == 0) {
                                i2 += optInt;
                            } else {
                                i3 += optInt;
                                arrayList2.add(CoordUtil.mc2ll(new GeoPoint(i3, i2)));
                            }
                        }
                        arrayList.add(arrayList2);
                    }
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
            this.c = optJSONObject.optString("cname");
            districtResult.setCenterPt(CoordUtil.decodeLocation(optJSONObject.optString("geo")));
            districtResult.setCityCode(optJSONObject.optInt("code"));
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(String str, DistrictResult districtResult) {
        List<List<LatLng>> decodeLocationList2D;
        if (str == null || str.equals("") || districtResult == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("result");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("content");
                if (optJSONObject == null || optJSONObject2 == null || optJSONObject.optInt(BdStatsConstant.StatsType.ERROR) != 0) {
                    return false;
                }
                ArrayList arrayList = new ArrayList();
                if (this.c != null) {
                    try {
                        decodeLocationList2D = CoordUtil.decodeLocationList2D(optJSONObject2.optString("geo"));
                    } catch (Exception e) {
                        e.printStackTrace();
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
                    districtResult.setCityName(this.c);
                    districtResult.error = SearchResult.ERRORNO.NO_ERROR;
                    this.c = null;
                    return true;
                }
                decodeLocationList2D = null;
                if (decodeLocationList2D != null) {
                }
                if (arrayList.size() > 0) {
                }
                districtResult.setCityName(this.c);
                districtResult.error = SearchResult.ERRORNO.NO_ERROR;
                this.c = null;
                return true;
            }
            return false;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        DistrictResult districtResult = new DistrictResult();
        if (str == null || str.equals("")) {
            districtResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        districtResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    } else if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        if (optString.equals("NETWORK_ERROR")) {
                            districtResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                        } else if (optString.equals("REQUEST_ERROR")) {
                            districtResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                        } else {
                            districtResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        }
                    }
                }
                if (!a(str, districtResult, false)) {
                    if (this.f4481b) {
                        b(str, districtResult);
                    } else if (!a(str, districtResult)) {
                        districtResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    }
                }
            } catch (Exception e) {
                districtResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
        }
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
        this.f4481b = z;
    }
}
