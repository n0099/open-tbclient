package com.baidu.platform.core.d;

import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.SuggestAddrInfo;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.baidu.platform.base.SearchType;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k extends com.baidu.platform.base.d {

    /* renamed from: b  reason: collision with root package name */
    public SuggestAddrInfo f9978b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9979c;

    private SuggestAddrInfo a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject jSONObject2;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("traffic_pois")) == null) {
            return null;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("option");
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("content");
        if (optJSONObject2 != null && optJSONObject3 != null) {
            JSONObject optJSONObject4 = optJSONObject2.optJSONObject("start_city");
            String optString = optJSONObject4 != null ? optJSONObject4.optString("cname") : null;
            JSONArray optJSONArray = optJSONObject2.optJSONArray("end_city");
            String optString2 = (optJSONArray == null || (jSONObject2 = (JSONObject) optJSONArray.opt(0)) == null) ? null : jSONObject2.optString("cname");
            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("city_list");
            JSONArray optJSONArray3 = optJSONObject2.optJSONArray("prio_flag");
            if (optJSONArray2 != null && optJSONArray3 != null) {
                int length = optJSONArray2.length();
                boolean[] zArr = new boolean[length];
                boolean[] zArr2 = new boolean[length];
                for (int i = 0; i < length; i++) {
                    int parseInt = Integer.parseInt(optJSONArray2.optString(i));
                    int parseInt2 = Integer.parseInt(optJSONArray3.optString(i));
                    boolean z = true;
                    zArr[i] = parseInt == 1;
                    if (parseInt2 != 1) {
                        z = false;
                    }
                    zArr2[i] = z;
                }
                SuggestAddrInfo suggestAddrInfo = new SuggestAddrInfo();
                for (int i2 = 0; i2 < length; i2++) {
                    if (!zArr2[i2]) {
                        if (zArr[i2]) {
                            if (i2 == 0) {
                                suggestAddrInfo.setSuggestStartCity(a(optJSONObject3.optJSONArray(IntentConfig.START)));
                            } else if (i2 != length - 1 || i2 <= 0) {
                                suggestAddrInfo.setSuggestWpCity(a(optJSONObject3, "multi_waypoints"));
                            } else {
                                suggestAddrInfo.setSuggestEndCity(a(optJSONObject3.optJSONArray(ProgressInfo.JSON_KEY_END)));
                            }
                        } else if (i2 == 0) {
                            suggestAddrInfo.setSuggestStartNode(a(optJSONObject3.optJSONArray(IntentConfig.START), optString));
                        } else if (i2 != length - 1 || i2 <= 0) {
                            suggestAddrInfo.setSuggestWpNode(b(optJSONObject3, "multi_waypoints"));
                        } else {
                            suggestAddrInfo.setSuggestEndNode(a(optJSONObject3.optJSONArray(ProgressInfo.JSON_KEY_END), optString2));
                        }
                    }
                }
                return suggestAddrInfo;
            }
        }
        return null;
    }

    private List<CityInfo> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
            if (jSONObject != null) {
                CityInfo cityInfo = new CityInfo();
                cityInfo.num = jSONObject.optInt("num");
                cityInfo.city = jSONObject.optString("name");
                arrayList.add(cityInfo);
            }
        }
        arrayList.trimToSize();
        return arrayList;
    }

    private List<PoiInfo> a(JSONArray jSONArray, String str) {
        if (jSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    PoiInfo poiInfo = new PoiInfo();
                    poiInfo.address = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
                    poiInfo.uid = jSONObject.optString("uid");
                    poiInfo.name = jSONObject.optString("name");
                    poiInfo.location = CoordUtil.decodeLocation(jSONObject.optString("geo"));
                    poiInfo.city = str;
                    arrayList.add(poiInfo);
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        }
        return null;
    }

    private List<List<CityInfo>> a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray(str)) == null) {
            return null;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            List<CityInfo> a2 = a((JSONArray) optJSONArray.opt(i));
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    private List<List<PoiInfo>> b(JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray(str)) == null) {
            return null;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            List<PoiInfo> a2 = a((JSONArray) optJSONArray.opt(i), "");
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    private boolean b(String str) {
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("result");
                if (optJSONObject != null && optJSONObject.optInt("type") == 23 && optJSONObject.optInt("error") == 0) {
                    SuggestAddrInfo a2 = a(jSONObject);
                    this.f9978b = a2;
                    return a2 != null;
                }
                return false;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.baidu.mapapi.search.route.DrivingRouteResult */
    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: com.baidu.mapapi.search.route.WalkingRouteResult */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        WalkingRouteResult walkingRouteResult;
        WalkingRouteResult walkingRouteResult2;
        SearchType a2 = a();
        if (b(str)) {
            this.f9979c = true;
        } else {
            this.f9979c = false;
        }
        int i = l.f9980a[a2.ordinal()];
        if (i == 1) {
            TransitRouteResult transitRouteResult = new TransitRouteResult();
            if (this.f9979c) {
                transitRouteResult.setSuggestAddrInfo(this.f9978b);
                walkingRouteResult = transitRouteResult;
                walkingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                walkingRouteResult2 = walkingRouteResult;
            } else {
                ((m) this).a(str, transitRouteResult);
                walkingRouteResult2 = transitRouteResult;
            }
        } else if (i == 2) {
            DrivingRouteResult drivingRouteResult = new DrivingRouteResult();
            if (this.f9979c) {
                drivingRouteResult.setSuggestAddrInfo(this.f9978b);
                walkingRouteResult = drivingRouteResult;
                walkingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                walkingRouteResult2 = walkingRouteResult;
            } else {
                ((c) this).a(str, drivingRouteResult);
                walkingRouteResult2 = drivingRouteResult;
            }
        } else if (i != 3) {
            return null;
        } else {
            WalkingRouteResult walkingRouteResult3 = new WalkingRouteResult();
            if (this.f9979c) {
                walkingRouteResult3.setSuggestAddrInfo(this.f9978b);
                walkingRouteResult = walkingRouteResult3;
                walkingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                walkingRouteResult2 = walkingRouteResult;
            } else {
                ((o) this).a(str, walkingRouteResult3);
                walkingRouteResult2 = walkingRouteResult3;
            }
        }
        return walkingRouteResult2;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetRoutePlanResultListener)) {
            return;
        }
        OnGetRoutePlanResultListener onGetRoutePlanResultListener = (OnGetRoutePlanResultListener) obj;
        int i = l.f9980a[a().ordinal()];
        if (i == 1) {
            onGetRoutePlanResultListener.onGetTransitRouteResult((TransitRouteResult) searchResult);
        } else if (i == 2) {
            onGetRoutePlanResultListener.onGetDrivingRouteResult((DrivingRouteResult) searchResult);
        } else if (i != 3) {
        } else {
            onGetRoutePlanResultListener.onGetWalkingRouteResult((WalkingRouteResult) searchResult);
        }
    }
}
