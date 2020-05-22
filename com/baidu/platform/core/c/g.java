package com.baidu.platform.core.c;

import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiChildrenInfo;
import com.baidu.mapapi.search.core.PoiDetailInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.SearchType;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g extends com.baidu.platform.base.d {
    private static final String b = g.class.getSimpleName();
    private int c;
    private int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    private LatLng a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        double optDouble = jSONObject.optDouble("lat");
        double optDouble2 = jSONObject.optDouble("lng");
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(new LatLng(optDouble, optDouble2)) : new LatLng(optDouble, optDouble2);
    }

    private boolean a(String str, PoiResult poiResult) {
        if (str == null || str.equals("") || str.isEmpty()) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("status");
            if (optInt == 0) {
                return a(jSONObject, poiResult);
            }
            switch (optInt) {
                case 1:
                    poiResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    return false;
                case 2:
                    poiResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
                    return false;
                default:
                    poiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return false;
            }
        } catch (JSONException e) {
            Log.e(b, "Parse poi search failed", e);
            poiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return false;
        }
    }

    private boolean a(JSONObject jSONObject, PoiResult poiResult) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        poiResult.error = SearchResult.ERRORNO.NO_ERROR;
        JSONArray optJSONArray = jSONObject.optJSONArray("results");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            poiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return false;
        }
        int optInt = jSONObject.optInt("total");
        poiResult.setTotalPoiNum(optInt);
        int length = optJSONArray.length();
        poiResult.setCurrentPageCapacity(length);
        poiResult.setCurrentPageNum(this.c);
        if (length != 0) {
            poiResult.setTotalPageNum((optInt % this.d > 0 ? 1 : 0) + (optInt / this.d));
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
            if (jSONObject2 != null && jSONObject2.length() != 0) {
                PoiInfo poiInfo = new PoiInfo();
                poiInfo.setName(jSONObject2.optString("name"));
                poiInfo.setAddress(jSONObject2.optString("address"));
                poiInfo.setProvince(jSONObject2.optString("province"));
                poiInfo.setCity(jSONObject2.optString("city"));
                poiInfo.setArea(jSONObject2.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                poiInfo.setStreetId(jSONObject2.optString("street_id"));
                poiInfo.setUid(jSONObject2.optString("uid"));
                poiInfo.setPhoneNum(jSONObject2.optString("telephone"));
                poiInfo.setDetail(jSONObject2.optInt("detail"));
                poiInfo.setLocation(a(jSONObject2.optJSONObject("location")));
                String optString = jSONObject2.optString("detail_info");
                if (optString != null && optString.length() != 0) {
                    poiInfo.setPoiDetailInfo(b(optString));
                }
                arrayList.add(poiInfo);
            }
        }
        poiResult.setPoiInfo(arrayList);
        return true;
    }

    private PoiDetailInfo b(String str) {
        PoiDetailInfo poiDetailInfo = new PoiDetailInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject == null || jSONObject.length() == 0) {
                return null;
            }
            poiDetailInfo.setDistance(jSONObject.optInt("distance", 0));
            poiDetailInfo.setTag(jSONObject.optString("tag"));
            poiDetailInfo.setDetailUrl(jSONObject.optString("detail_url"));
            poiDetailInfo.setType(jSONObject.optString("type"));
            poiDetailInfo.setPrice(jSONObject.optDouble("price", 0.0d));
            poiDetailInfo.setOverallRating(jSONObject.optDouble("overall_rating", 0.0d));
            poiDetailInfo.setTasteRating(jSONObject.optDouble("taste_rating", 0.0d));
            poiDetailInfo.setServiceRating(jSONObject.optDouble("service_rating", 0.0d));
            poiDetailInfo.setEnvironmentRating(jSONObject.optDouble("environment_rating", 0.0d));
            poiDetailInfo.setFacilityRating(jSONObject.optDouble("facility_rating", 0.0d));
            poiDetailInfo.setHygieneRating(jSONObject.optDouble("hygiene_rating", 0.0d));
            poiDetailInfo.setTechnologyRating(jSONObject.optDouble("technology_rating", 0.0d));
            poiDetailInfo.setImageNum(jSONObject.optInt("image_num"));
            poiDetailInfo.setGrouponNum(jSONObject.optInt("groupon_num"));
            poiDetailInfo.setCommentNum(jSONObject.optInt("comment_num"));
            poiDetailInfo.setDiscountNum(jSONObject.optInt("discount_num"));
            poiDetailInfo.setFavoriteNum(jSONObject.optInt("favorite_num"));
            poiDetailInfo.setCheckinNum(jSONObject.optInt("checkin_num"));
            poiDetailInfo.setShopHours(jSONObject.optString("shop_hours"));
            poiDetailInfo.naviLocation = a(jSONObject.optJSONObject("navi_location"));
            SearchType a = a();
            if (SearchType.POI_IN_CITY_SEARCH == a || SearchType.POI_NEAR_BY_SEARCH == a) {
                poiDetailInfo.setPoiChildrenInfoList(b(jSONObject));
                return poiDetailInfo;
            }
            return poiDetailInfo;
        } catch (JSONException e) {
            Log.e(b, "Parse poi search detail info failed", e);
            return null;
        }
    }

    private List<PoiChildrenInfo> b(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("children");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null && optJSONObject.length() != 0) {
                PoiChildrenInfo poiChildrenInfo = new PoiChildrenInfo();
                poiChildrenInfo.setUid(optJSONObject.optString("uid"));
                poiChildrenInfo.setName(optJSONObject.optString("name"));
                poiChildrenInfo.setShowName(optJSONObject.optString("show_name"));
                poiChildrenInfo.setTag(optJSONObject.optString("tag"));
                poiChildrenInfo.setLocation(a(optJSONObject.optJSONObject("location")));
                poiChildrenInfo.setAddress(optJSONObject.optString("address"));
                arrayList.add(poiChildrenInfo);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0079, code lost:
        if (r3.equals("NETWORK_ERROR") != false) goto L21;
     */
    @Override // com.baidu.platform.base.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SearchResult a(String str) {
        boolean z = false;
        PoiResult poiResult = new PoiResult();
        if (str == null || str.equals("") || str.isEmpty()) {
            poiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return poiResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (optJSONObject.has("PermissionCheckError")) {
                    poiResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    return poiResult;
                } else if (optJSONObject.has("httpStateError")) {
                    String optString = optJSONObject.optString("httpStateError");
                    switch (optString.hashCode()) {
                        case -879828873:
                            break;
                        case 1470557208:
                            if (optString.equals("REQUEST_ERROR")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        default:
                            z = true;
                            break;
                    }
                    switch (z) {
                        case false:
                            poiResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                            break;
                        case true:
                            poiResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                            break;
                        default:
                            poiResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                            break;
                    }
                    return poiResult;
                }
            }
            if (a(str, poiResult, false)) {
                return poiResult;
            }
            poiResult.error = a(str, poiResult) ? SearchResult.ERRORNO.NO_ERROR : SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return poiResult;
        } catch (JSONException e) {
            Log.e(b, "Parse poi search error", e);
            poiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return poiResult;
        }
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetPoiSearchResultListener)) {
            return;
        }
        switch (a()) {
            case POI_NEAR_BY_SEARCH:
            case POI_IN_CITY_SEARCH:
            case POI_IN_BOUND_SEARCH:
                ((OnGetPoiSearchResultListener) obj).onGetPoiResult((PoiResult) searchResult);
                return;
            default:
                return;
        }
    }
}
