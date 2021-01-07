package com.baidu.platform.core.c;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiIndoorInfo;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends com.baidu.platform.base.d {
    private boolean a(String str, PoiIndoorResult poiIndoorResult) {
        int i = 0;
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            switch (jSONObject.optInt("errNo")) {
                case 0:
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray("poi_list");
                        if (optJSONArray == null || optJSONArray.length() <= 0) {
                            poiIndoorResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                        } else {
                            ArrayList arrayList = new ArrayList();
                            while (true) {
                                int i2 = i;
                                if (i2 < optJSONArray.length()) {
                                    JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                                    if (jSONObject2 != null) {
                                        PoiIndoorInfo poiIndoorInfo = new PoiIndoorInfo();
                                        poiIndoorInfo.address = jSONObject2.optString("address");
                                        poiIndoorInfo.bid = jSONObject2.optString("bd_id");
                                        poiIndoorInfo.cid = jSONObject2.optInt(IXAdRequestInfo.CELL_ID);
                                        poiIndoorInfo.discount = jSONObject2.optInt("discount");
                                        poiIndoorInfo.floor = jSONObject2.optString("floor");
                                        poiIndoorInfo.name = jSONObject2.optString("name");
                                        poiIndoorInfo.phone = jSONObject2.optString("phone");
                                        poiIndoorInfo.price = jSONObject2.optInt("price");
                                        poiIndoorInfo.starLevel = jSONObject2.optInt("star_level");
                                        poiIndoorInfo.tag = jSONObject2.optString("tag");
                                        poiIndoorInfo.uid = jSONObject2.optString("uid");
                                        poiIndoorInfo.groupNum = jSONObject2.optInt("tuan_nums");
                                        int parseInt = Integer.parseInt(jSONObject2.optString("twp"));
                                        if ((parseInt & 1) == 1) {
                                            poiIndoorInfo.isGroup = true;
                                        }
                                        if ((parseInt & 2) == 1) {
                                            poiIndoorInfo.isTakeOut = true;
                                        }
                                        if ((parseInt & 4) == 1) {
                                            poiIndoorInfo.isWaited = true;
                                        }
                                        poiIndoorInfo.latLng = CoordUtil.mc2ll(new GeoPoint(jSONObject2.optDouble("pt_y"), jSONObject2.optDouble("pt_x")));
                                        arrayList.add(poiIndoorInfo);
                                    }
                                    i = i2 + 1;
                                } else {
                                    poiIndoorResult.error = SearchResult.ERRORNO.NO_ERROR;
                                    poiIndoorResult.setmArrayPoiInfo(arrayList);
                                }
                            }
                        }
                        poiIndoorResult.pageNum = optJSONObject.optInt("page_num");
                        poiIndoorResult.poiNum = optJSONObject.optInt("poi_num");
                        poiIndoorResult.error = SearchResult.ERRORNO.NO_ERROR;
                        return true;
                    }
                    return false;
                case 1:
                    String optString = jSONObject.optString("Msg");
                    if (optString.contains(MapBundleKey.MapObjKey.OBJ_BID)) {
                        poiIndoorResult.error = SearchResult.ERRORNO.POIINDOOR_BID_ERROR;
                        return true;
                    } else if (optString.contains("floor")) {
                        poiIndoorResult.error = SearchResult.ERRORNO.POIINDOOR_FLOOR_ERROR;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                case 3:
                case 4:
                default:
                    poiIndoorResult.error = SearchResult.ERRORNO.POIINDOOR_SERVER_ERROR;
                    return true;
                case 5:
                    return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        PoiIndoorResult poiIndoorResult = new PoiIndoorResult();
        if (str == null || str.equals("")) {
            poiIndoorResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        poiIndoorResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    } else if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        if (optString.equals("NETWORK_ERROR")) {
                            poiIndoorResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                        } else if (optString.equals("REQUEST_ERROR")) {
                            poiIndoorResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                        } else {
                            poiIndoorResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        }
                    }
                }
                if (!a(str, poiIndoorResult, false) && !a(str, poiIndoorResult)) {
                    poiIndoorResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
            } catch (Exception e) {
                poiIndoorResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
        }
        return poiIndoorResult;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetPoiSearchResultListener)) {
            return;
        }
        ((OnGetPoiSearchResultListener) obj).onGetPoiIndoorResult((PoiIndoorResult) searchResult);
    }
}
