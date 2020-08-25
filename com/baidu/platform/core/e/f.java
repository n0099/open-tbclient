package com.baidu.platform.core.e;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.share.OnGetShareUrlResultListener;
import com.baidu.mapapi.search.share.ShareUrlResult;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class f extends com.baidu.platform.base.d {
    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        ShareUrlResult shareUrlResult = new ShareUrlResult();
        if (str == null || str.equals("")) {
            shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        shareUrlResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    } else if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        if (optString.equals("NETWORK_ERROR")) {
                            shareUrlResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                        } else if (optString.equals("REQUEST_ERROR")) {
                            shareUrlResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                        } else {
                            shareUrlResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        }
                    }
                }
                if (str == null) {
                    shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                } else {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str);
                        if (jSONObject2 != null) {
                            if (jSONObject2.optString("state").equals("success")) {
                                shareUrlResult.setUrl(jSONObject2.optString("url"));
                                shareUrlResult.setType(a().ordinal());
                                shareUrlResult.error = SearchResult.ERRORNO.NO_ERROR;
                            } else {
                                shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    }
                }
            } catch (Exception e2) {
                shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
        }
        return shareUrlResult;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetShareUrlResultListener)) {
            return;
        }
        OnGetShareUrlResultListener onGetShareUrlResultListener = (OnGetShareUrlResultListener) obj;
        switch (a()) {
            case POI_DETAIL_SHARE:
                onGetShareUrlResultListener.onGetPoiDetailShareUrlResult((ShareUrlResult) searchResult);
                return;
            case LOCATION_SEARCH_SHARE:
                onGetShareUrlResultListener.onGetLocationShareUrlResult((ShareUrlResult) searchResult);
                return;
            default:
                return;
        }
    }
}
