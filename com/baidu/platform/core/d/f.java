package com.baidu.platform.core.d;

import android.net.http.Headers;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.IndoorRouteLine;
import com.baidu.mapapi.search.route.IndoorRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f extends com.baidu.platform.base.d {
    private LatLng a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null) {
            GeoPoint geoPoint = new GeoPoint(0.0d, 0.0d);
            geoPoint.setLatitudeE6(optJSONArray.optDouble(1));
            geoPoint.setLongitudeE6(optJSONArray.optDouble(0));
            return CoordUtil.mc2ll(geoPoint);
        }
        return null;
    }

    private boolean a(String str, IndoorRouteResult indoorRouteResult) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("indoor_navi")) == null || (optJSONObject2 = optJSONObject.optJSONObject("option")) == null) {
                return false;
            }
            switch (optJSONObject2.optInt(BdStatsConstant.StatsType.ERROR)) {
                case 0:
                    JSONArray optJSONArray = optJSONObject.optJSONArray("routes");
                    if (optJSONArray == null || (optJSONObject3 = optJSONArray.optJSONObject(0)) == null) {
                        return false;
                    }
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("legs");
                    if (optJSONArray2 == null) {
                        return false;
                    }
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        IndoorRouteLine indoorRouteLine = new IndoorRouteLine();
                        JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i);
                        if (optJSONObject4 != null) {
                            indoorRouteLine.setDistance(optJSONObject4.optInt("distance"));
                            indoorRouteLine.setDuration(optJSONObject4.optInt("duration"));
                            indoorRouteLine.setStarting(RouteNode.location(a(optJSONObject4, "sstart_location")));
                            indoorRouteLine.setTerminal(RouteNode.location(a(optJSONObject4, "send_location")));
                            JSONArray optJSONArray3 = optJSONObject4.optJSONArray("steps");
                            if (optJSONArray3 != null) {
                                ArrayList arrayList2 = new ArrayList();
                                for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                                    IndoorRouteLine.IndoorRouteStep indoorRouteStep = new IndoorRouteLine.IndoorRouteStep();
                                    JSONObject optJSONObject5 = optJSONArray3.optJSONObject(i2);
                                    if (optJSONObject5 != null) {
                                        indoorRouteStep.setDistance(optJSONObject5.optInt("distance"));
                                        indoorRouteStep.setDuration(optJSONObject5.optInt("duration"));
                                        indoorRouteStep.setBuildingId(optJSONObject5.optString("buildingid"));
                                        indoorRouteStep.setFloorId(optJSONObject5.optString("floorid"));
                                        indoorRouteStep.setEntrace(RouteNode.location(a(optJSONObject5, "sstart_location")));
                                        indoorRouteStep.setExit(RouteNode.location(a(optJSONObject5, "send_location")));
                                        JSONArray optJSONArray4 = optJSONObject5.optJSONArray("spath");
                                        if (optJSONArray4 != null) {
                                            ArrayList arrayList3 = new ArrayList();
                                            double d = 0.0d;
                                            double d2 = 0.0d;
                                            for (int i3 = 5; i3 < optJSONArray4.length(); i3 += 2) {
                                                d += optJSONArray4.optDouble(i3 + 1);
                                                d2 += optJSONArray4.optDouble(i3);
                                                GeoPoint geoPoint = new GeoPoint(0.0d, 0.0d);
                                                geoPoint.setLatitudeE6(d);
                                                geoPoint.setLongitudeE6(d2);
                                                LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
                                                arrayList3.add(Double.valueOf(mc2ll.latitude));
                                                arrayList3.add(Double.valueOf(mc2ll.longitude));
                                            }
                                            indoorRouteStep.setPath(arrayList3);
                                            indoorRouteStep.setInstructions(optJSONObject5.optString("instructions"));
                                            JSONArray optJSONArray5 = optJSONObject5.optJSONArray("pois");
                                            if (optJSONArray5 != null) {
                                                ArrayList arrayList4 = new ArrayList();
                                                for (int i4 = 0; i4 < optJSONArray5.length(); i4++) {
                                                    JSONObject optJSONObject6 = optJSONArray5.optJSONObject(i4);
                                                    if (optJSONObject6 != null) {
                                                        IndoorRouteLine.IndoorRouteStep.IndoorStepNode indoorStepNode = new IndoorRouteLine.IndoorRouteStep.IndoorStepNode();
                                                        indoorStepNode.setDetail(optJSONObject6.optString("detail"));
                                                        indoorStepNode.setName(optJSONObject6.optString("name"));
                                                        indoorStepNode.setType(optJSONObject6.optInt("type"));
                                                        indoorStepNode.setLocation(a(optJSONObject6, Headers.LOCATION));
                                                        arrayList4.add(indoorStepNode);
                                                    }
                                                }
                                                indoorRouteStep.setStepNodes(arrayList4);
                                            }
                                            arrayList2.add(indoorRouteStep);
                                        }
                                    }
                                }
                                if (arrayList2.size() > 0) {
                                    indoorRouteLine.setSteps(arrayList2);
                                }
                            }
                            arrayList.add(indoorRouteLine);
                        }
                    }
                    indoorRouteResult.setRouteLines(arrayList);
                    return true;
                case 6:
                    indoorRouteResult.error = SearchResult.ERRORNO.INDOOR_ROUTE_NO_IN_BUILDING;
                    return true;
                case 7:
                    indoorRouteResult.error = SearchResult.ERRORNO.INDOOR_ROUTE_NO_IN_SAME_BUILDING;
                    return true;
                default:
                    return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        IndoorRouteResult indoorRouteResult = new IndoorRouteResult();
        if (str == null || str.equals("")) {
            indoorRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        indoorRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    } else if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        if (optString.equals("NETWORK_ERROR")) {
                            indoorRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                        } else if (optString.equals("REQUEST_ERROR")) {
                            indoorRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                        } else {
                            indoorRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        }
                    }
                }
                if (!a(str, indoorRouteResult)) {
                    indoorRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
            } catch (Exception e) {
                indoorRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
        }
        return indoorRouteResult;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetRoutePlanResultListener)) {
            return;
        }
        ((OnGetRoutePlanResultListener) obj).onGetIndoorRouteResult((IndoorRouteResult) searchResult);
    }
}
