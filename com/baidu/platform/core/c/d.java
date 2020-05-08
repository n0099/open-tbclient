package com.baidu.platform.core.c;

import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiDetailInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.swan.bdprivate.invoice.model.InvoiceInfo;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d extends com.baidu.platform.base.d {
    private static final String b = d.class.getSimpleName();
    private boolean c = false;

    private LatLng a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        double optDouble = jSONObject.optDouble("lat");
        double optDouble2 = jSONObject.optDouble("lng");
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(new LatLng(optDouble, optDouble2)) : new LatLng(optDouble, optDouble2);
    }

    private boolean a(String str, SearchResult searchResult) {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject == null || jSONObject.length() == 0 || jSONObject.optInt("status") != 0 || (optJSONArray = jSONObject.optJSONArray("result")) == null || optJSONArray.length() == 0) {
                return false;
            }
            return this.c ? a(optJSONArray, (PoiDetailSearchResult) searchResult) : a(optJSONArray, (PoiDetailResult) searchResult);
        } catch (JSONException e) {
            Log.e(b, "Parse detail search result error", e);
            return false;
        }
    }

    private boolean a(JSONArray jSONArray, PoiDetailResult poiDetailResult) {
        JSONObject jSONObject = (JSONObject) jSONArray.opt(0);
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        poiDetailResult.setName(jSONObject.optString("name"));
        poiDetailResult.setLocation(a(jSONObject.optJSONObject("location")));
        poiDetailResult.setAddress(jSONObject.optString("address"));
        poiDetailResult.setTelephone(jSONObject.optString(InvoiceInfo.KEY_TELEPHONE));
        poiDetailResult.setUid(jSONObject.optString("uid"));
        JSONObject optJSONObject = jSONObject.optJSONObject("detail_info");
        if (optJSONObject != null && optJSONObject.length() != 0) {
            poiDetailResult.setTag(optJSONObject.optString("tag"));
            poiDetailResult.setDetailUrl(optJSONObject.optString("detail_url"));
            poiDetailResult.setType(optJSONObject.optString("type"));
            poiDetailResult.setPrice(optJSONObject.optDouble("price", 0.0d));
            poiDetailResult.setOverallRating(optJSONObject.optDouble("overall_rating", 0.0d));
            poiDetailResult.setTasteRating(optJSONObject.optDouble("taste_rating", 0.0d));
            poiDetailResult.setServiceRating(optJSONObject.optDouble("service_rating", 0.0d));
            poiDetailResult.setEnvironmentRating(optJSONObject.optDouble("environment_rating", 0.0d));
            poiDetailResult.setFacilityRating(optJSONObject.optDouble("facility_rating", 0.0d));
            poiDetailResult.setHygieneRating(optJSONObject.optDouble("hygiene_rating", 0.0d));
            poiDetailResult.setTechnologyRating(optJSONObject.optDouble("technology_rating", 0.0d));
            poiDetailResult.setImageNum(optJSONObject.optInt("image_num"));
            poiDetailResult.setGrouponNum(optJSONObject.optInt("groupon_num", 0));
            poiDetailResult.setCommentNum(optJSONObject.optInt("comment_num", 0));
            poiDetailResult.setDiscountNum(optJSONObject.optInt("discount_num", 0));
            poiDetailResult.setFavoriteNum(optJSONObject.optInt("favorite_num", 0));
            poiDetailResult.setCheckinNum(optJSONObject.optInt("checkin_num", 0));
            poiDetailResult.setShopHours(optJSONObject.optString("shop_hours"));
        }
        poiDetailResult.error = SearchResult.ERRORNO.NO_ERROR;
        return true;
    }

    private boolean a(JSONArray jSONArray, PoiDetailSearchResult poiDetailSearchResult) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
            if (jSONObject != null && jSONObject.length() != 0) {
                PoiDetailInfo poiDetailInfo = new PoiDetailInfo();
                poiDetailInfo.setName(jSONObject.optString("name"));
                poiDetailInfo.setLocation(a(jSONObject.optJSONObject("location")));
                poiDetailInfo.setAddress(jSONObject.optString("address"));
                poiDetailInfo.setProvince(jSONObject.optString("province"));
                poiDetailInfo.setCity(jSONObject.optString("city"));
                poiDetailInfo.setArea(jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                poiDetailInfo.setTelephone(jSONObject.optString(InvoiceInfo.KEY_TELEPHONE));
                poiDetailInfo.setUid(jSONObject.optString("uid"));
                poiDetailInfo.setStreetId(jSONObject.optString("setStreetId"));
                poiDetailInfo.setDetail(jSONObject.optString("detail"));
                JSONObject optJSONObject = jSONObject.optJSONObject("detail_info");
                if (optJSONObject != null && optJSONObject.length() != 0) {
                    poiDetailInfo.setDistance(optJSONObject.optInt("distance", 0));
                    poiDetailInfo.setType(optJSONObject.optString("type"));
                    poiDetailInfo.setTag(optJSONObject.optString("tag"));
                    poiDetailInfo.setDetailUrl(optJSONObject.optString("detail_url"));
                    poiDetailInfo.setPrice(optJSONObject.optDouble("price", 0.0d));
                    poiDetailInfo.setShopHours(optJSONObject.optString("shop_hours"));
                    poiDetailInfo.setOverallRating(optJSONObject.optDouble("overall_rating", 0.0d));
                    poiDetailInfo.setTasteRating(optJSONObject.optDouble("taste_rating", 0.0d));
                    poiDetailInfo.setServiceRating(optJSONObject.optDouble("service_rating", 0.0d));
                    poiDetailInfo.setEnvironmentRating(optJSONObject.optDouble("environment_rating", 0.0d));
                    poiDetailInfo.setFacilityRating(optJSONObject.optDouble("facility_rating", 0.0d));
                    poiDetailInfo.setHygieneRating(optJSONObject.optDouble("hygiene_rating", 0.0d));
                    poiDetailInfo.setTechnologyRating(optJSONObject.optDouble("technology_rating", 0.0d));
                    poiDetailInfo.setImageNum(optJSONObject.optInt("image_num"));
                    poiDetailInfo.setGrouponNum(optJSONObject.optInt("groupon_num", 0));
                    poiDetailInfo.setCommentNum(optJSONObject.optInt("comment_num", 0));
                    poiDetailInfo.setDiscountNum(optJSONObject.optInt("discount_num", 0));
                    poiDetailInfo.setFavoriteNum(optJSONObject.optInt("favorite_num", 0));
                    poiDetailInfo.setCheckinNum(optJSONObject.optInt("checkin_num", 0));
                }
                arrayList.add(poiDetailInfo);
            }
        }
        poiDetailSearchResult.setPoiDetailInfoList(arrayList);
        poiDetailSearchResult.error = SearchResult.ERRORNO.NO_ERROR;
        return true;
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        SearchResult poiDetailSearchResult = this.c ? new PoiDetailSearchResult() : new PoiDetailResult();
        if (str == null || str.isEmpty()) {
            poiDetailSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null && jSONObject.length() != 0) {
                    if (jSONObject.has("SDK_InnerError")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                        if (optJSONObject != null && optJSONObject.length() != 0) {
                            if (!optJSONObject.has("PermissionCheckError")) {
                                if (optJSONObject.has("httpStateError")) {
                                    String optString = optJSONObject.optString("httpStateError");
                                    char c = 65535;
                                    switch (optString.hashCode()) {
                                        case -879828873:
                                            if (optString.equals("NETWORK_ERROR")) {
                                                c = 0;
                                                break;
                                            }
                                            break;
                                        case 1470557208:
                                            if (optString.equals("REQUEST_ERROR")) {
                                                c = 1;
                                                break;
                                            }
                                            break;
                                    }
                                    switch (c) {
                                        case 0:
                                            poiDetailSearchResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                                            break;
                                        case 1:
                                            poiDetailSearchResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                                            break;
                                        default:
                                            poiDetailSearchResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                                            break;
                                    }
                                }
                            } else {
                                poiDetailSearchResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                            }
                        } else {
                            poiDetailSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                        }
                    } else if (!a(str, poiDetailSearchResult)) {
                        poiDetailSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    }
                } else {
                    poiDetailSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
            } catch (JSONException e) {
                Log.e(b, "Parse detail search result failed", e);
                poiDetailSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
        }
        return poiDetailSearchResult;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetPoiSearchResultListener)) {
            return;
        }
        if (this.c) {
            ((OnGetPoiSearchResultListener) obj).onGetPoiDetailResult((PoiDetailSearchResult) searchResult);
        } else {
            ((OnGetPoiSearchResultListener) obj).onGetPoiDetailResult((PoiDetailResult) searchResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.c = z;
    }
}
