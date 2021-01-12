package com.baidu.platform.core.f;

import android.net.http.Headers;
import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiChildrenInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends com.baidu.platform.base.d {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4496b = c.class.getSimpleName();

    private LatLng a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        double optDouble = jSONObject.optDouble("lat");
        double optDouble2 = jSONObject.optDouble("lng");
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(new LatLng(optDouble, optDouble2)) : new LatLng(optDouble, optDouble2);
    }

    private List<PoiChildrenInfo> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && optJSONObject.length() != 0) {
                PoiChildrenInfo poiChildrenInfo = new PoiChildrenInfo();
                poiChildrenInfo.setUid(optJSONObject.optString("uid"));
                poiChildrenInfo.setName(optJSONObject.optString("name"));
                poiChildrenInfo.setShowName(optJSONObject.optString("show_name"));
                poiChildrenInfo.setTag(optJSONObject.optString("tag"));
                poiChildrenInfo.setAddress(optJSONObject.optString("address"));
                arrayList.add(poiChildrenInfo);
            }
        }
        return arrayList;
    }

    private boolean a(String str, SuggestionResult suggestionResult) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject == null || jSONObject.length() == 0) {
                suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return false;
            }
            int optInt = jSONObject.optInt("status");
            if (optInt == 0) {
                return a(jSONObject, suggestionResult);
            }
            switch (optInt) {
                case 1:
                    suggestionResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    return false;
                case 2:
                    suggestionResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
                    return false;
                default:
                    suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return false;
            }
        } catch (JSONException e) {
            Log.e(f4496b, "Parse sug search error", e);
            suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return false;
        }
    }

    private boolean a(JSONObject jSONObject, SuggestionResult suggestionResult) {
        int i = 0;
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        suggestionResult.error = SearchResult.ERRORNO.NO_ERROR;
        JSONArray optJSONArray = jSONObject.optJSONArray("result");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return false;
        }
        ArrayList<SuggestionResult.SuggestionInfo> arrayList = new ArrayList<>();
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                suggestionResult.setSuggestionInfo(arrayList);
                return true;
            }
            JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
            if (jSONObject2 != null && jSONObject2.length() != 0) {
                SuggestionResult.SuggestionInfo suggestionInfo = new SuggestionResult.SuggestionInfo();
                suggestionInfo.setKey(jSONObject2.optString("name"));
                suggestionInfo.setCity(jSONObject2.optString("city"));
                suggestionInfo.setDistrict(jSONObject2.optString("district"));
                suggestionInfo.setUid(jSONObject2.optString("uid"));
                suggestionInfo.setTag(jSONObject2.optString("tag"));
                suggestionInfo.setAddress(jSONObject2.optString("address"));
                suggestionInfo.setPt(a(jSONObject2.optJSONObject(Headers.LOCATION)));
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("children");
                if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                    suggestionInfo.setPoiChildrenInfoList(a(optJSONArray2));
                }
                arrayList.add(suggestionInfo);
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        SuggestionResult suggestionResult = new SuggestionResult();
        if (str == null || str.isEmpty()) {
            suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject == null || jSONObject.length() == 0) {
                    suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                } else {
                    if (jSONObject.has("SDK_InnerError")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
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
                                        suggestionResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                                        break;
                                    case 1:
                                        suggestionResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                                        break;
                                    default:
                                        suggestionResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                                        break;
                                }
                            }
                        } else {
                            suggestionResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                        }
                    }
                    if (!a(str, suggestionResult, true)) {
                        a(str, suggestionResult);
                    }
                }
            } catch (JSONException e) {
                Log.e(f4496b, "Parse suggestion search result error", e);
                suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
        }
        return suggestionResult;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetSuggestionResultListener)) {
            return;
        }
        ((OnGetSuggestionResultListener) obj).onGetSuggestionResult((SuggestionResult) searchResult);
    }
}
