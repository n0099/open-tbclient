package com.baidu.platform.core.d;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
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
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class k extends com.baidu.platform.base.d {
    SuggestAddrInfo b = null;
    protected boolean c;

    private SuggestAddrInfo a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject jSONObject2;
        SuggestAddrInfo suggestAddrInfo = null;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("traffic_pois")) != null) {
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
                        zArr[i] = parseInt == 1;
                        zArr2[i] = parseInt2 == 1;
                    }
                    suggestAddrInfo = new SuggestAddrInfo();
                    for (int i2 = 0; i2 < length; i2++) {
                        if (!zArr2[i2]) {
                            if (zArr[i2]) {
                                if (i2 == 0) {
                                    suggestAddrInfo.setSuggestStartCity(a(optJSONObject3.optJSONArray("start")));
                                } else if (i2 != length - 1 || i2 <= 0) {
                                    suggestAddrInfo.setSuggestWpCity(a(optJSONObject3, "multi_waypoints"));
                                } else {
                                    suggestAddrInfo.setSuggestEndCity(a(optJSONObject3.optJSONArray("end")));
                                }
                            } else if (i2 == 0) {
                                suggestAddrInfo.setSuggestStartNode(a(optJSONObject3.optJSONArray("start"), optString));
                            } else if (i2 != length - 1 || i2 <= 0) {
                                suggestAddrInfo.setSuggestWpNode(b(optJSONObject3, "multi_waypoints"));
                            } else {
                                suggestAddrInfo.setSuggestEndNode(a(optJSONObject3.optJSONArray("end"), optString2));
                            }
                        }
                    }
                }
            }
        }
        return suggestAddrInfo;
    }

    private List<CityInfo> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                arrayList.trimToSize();
                return arrayList;
            }
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i2);
            if (jSONObject != null) {
                CityInfo cityInfo = new CityInfo();
                cityInfo.num = jSONObject.optInt("num");
                cityInfo.city = jSONObject.optString("name");
                arrayList.add(cityInfo);
            }
            i = i2 + 1;
        }
    }

    private List<PoiInfo> a(JSONArray jSONArray, String str) {
        if (jSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i2);
                if (jSONObject != null) {
                    PoiInfo poiInfo = new PoiInfo();
                    poiInfo.address = jSONObject.optString("addr");
                    poiInfo.uid = jSONObject.optString("uid");
                    poiInfo.name = jSONObject.optString("name");
                    poiInfo.location = CoordUtil.decodeLocation(jSONObject.optString("geo"));
                    poiInfo.city = str;
                    arrayList.add(poiInfo);
                }
                i = i2 + 1;
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
        }
        return null;
    }

    private List<List<CityInfo>> a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray(str)) == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                return arrayList;
            }
            List<CityInfo> a = a((JSONArray) optJSONArray.opt(i2));
            if (a != null) {
                arrayList.add(a);
            }
            i = i2 + 1;
        }
    }

    private List<List<PoiInfo>> b(JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray(str)) == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                return arrayList;
            }
            List<PoiInfo> a = a((JSONArray) optJSONArray.opt(i2), "");
            if (a != null) {
                arrayList.add(a);
            }
            i = i2 + 1;
        }
    }

    private boolean b(String str) {
        JSONObject optJSONObject;
        if (str == null || str.length() <= 0) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("result")) == null || optJSONObject.optInt("type") != 23 || optJSONObject.optInt(BdStatsConstant.StatsType.ERROR) != 0) {
                return false;
            }
            this.b = a(jSONObject);
            return this.b != null;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        SearchType a = a();
        if (b(str)) {
            this.c = true;
        } else {
            this.c = false;
        }
        switch (a) {
            case TRANSIT_ROUTE:
                TransitRouteResult transitRouteResult = new TransitRouteResult();
                if (!this.c) {
                    ((m) this).a(str, transitRouteResult);
                    return transitRouteResult;
                }
                transitRouteResult.setSuggestAddrInfo(this.b);
                transitRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                return transitRouteResult;
            case DRIVE_ROUTE:
                DrivingRouteResult drivingRouteResult = new DrivingRouteResult();
                if (!this.c) {
                    ((c) this).a(str, drivingRouteResult);
                    return drivingRouteResult;
                }
                drivingRouteResult.setSuggestAddrInfo(this.b);
                drivingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                return drivingRouteResult;
            case WALK_ROUTE:
                WalkingRouteResult walkingRouteResult = new WalkingRouteResult();
                if (!this.c) {
                    ((o) this).a(str, walkingRouteResult);
                    return walkingRouteResult;
                }
                walkingRouteResult.setSuggestAddrInfo(this.b);
                walkingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                return walkingRouteResult;
            default:
                return null;
        }
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetRoutePlanResultListener)) {
            return;
        }
        OnGetRoutePlanResultListener onGetRoutePlanResultListener = (OnGetRoutePlanResultListener) obj;
        switch (a()) {
            case TRANSIT_ROUTE:
                onGetRoutePlanResultListener.onGetTransitRouteResult((TransitRouteResult) searchResult);
                return;
            case DRIVE_ROUTE:
                onGetRoutePlanResultListener.onGetDrivingRouteResult((DrivingRouteResult) searchResult);
                return;
            case WALK_ROUTE:
                onGetRoutePlanResultListener.onGetWalkingRouteResult((WalkingRouteResult) searchResult);
                return;
            default:
                return;
        }
    }
}
