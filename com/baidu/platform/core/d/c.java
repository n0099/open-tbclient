package com.baidu.platform.core.d;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mapapi.common.Logger;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends k {
    private RouteNode a(JSONArray jSONArray, List<RouteNode> list) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return null;
        }
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                RouteNode a = a(optJSONObject);
                if (i == length - 1) {
                    return a;
                }
                list.add(a);
            }
        }
        return null;
    }

    private RouteNode a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        RouteNode routeNode = new RouteNode();
        routeNode.setTitle(jSONObject.optString(ActVideoSetting.WIFI_DISPLAY));
        routeNode.setUid(jSONObject.optString("uid"));
        GeoPoint geoPoint = new GeoPoint(0.0d, 0.0d);
        JSONArray optJSONArray = jSONObject.optJSONArray("spt");
        if (optJSONArray != null) {
            geoPoint.setLongitudeE6(optJSONArray.optInt(0));
            geoPoint.setLatitudeE6(optJSONArray.optInt(1));
        }
        routeNode.setLocation(CoordUtil.mc2ll(geoPoint));
        return routeNode;
    }

    private List<LatLng> a(JSONArray jSONArray) {
        int length;
        double d = 0.0d;
        if (jSONArray == null || (length = jSONArray.length()) < 6) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        double d2 = 0.0d;
        for (int i = 5; i < length; i++) {
            if (i % 2 != 0) {
                d += jSONArray.optInt(i);
            } else {
                d2 += jSONArray.optInt(i);
                arrayList.add(CoordUtil.mc2ll(new GeoPoint(d2, d)));
            }
        }
        return arrayList;
    }

    private List<DrivingRouteLine.DrivingStep> a(JSONArray jSONArray, JSONArray jSONArray2) {
        int length;
        boolean z;
        int i;
        int i2;
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return null;
        }
        int i3 = 0;
        if (jSONArray2 == null || (i3 = jSONArray2.length()) <= 0) {
            z = false;
            i = i3;
        } else {
            z = true;
            i = i3;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        int i5 = 0;
        while (i5 < length) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i5);
            if (optJSONObject == null) {
                i2 = i4;
            } else {
                DrivingRouteLine.DrivingStep drivingStep = new DrivingRouteLine.DrivingStep();
                drivingStep.setDistance(optJSONObject.optInt("distance"));
                drivingStep.setDirection(optJSONObject.optInt("direction") * 30);
                String optString = optJSONObject.optString("instructions");
                if (optString != null || optString.length() >= 4) {
                    optString = optString.replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
                }
                drivingStep.setInstructions(optString);
                String optString2 = optJSONObject.optString("start_instructions");
                if (optString2 == null) {
                    int distance = drivingStep.getDistance();
                    optString2 = distance < 1000 ? " - " + distance + "米" : " - " + (distance / 1000.0d) + "公里";
                    if (i4 <= arrayList.size()) {
                        optString2 = ((DrivingRouteLine.DrivingStep) arrayList.get(i4 - 1)).getExitInstructions() + optString2;
                    }
                }
                drivingStep.setEntranceInstructions(optString2);
                drivingStep.setExitInstructions(optJSONObject.optString("end_instructions"));
                drivingStep.setNumTurns(optJSONObject.optInt("turn"));
                List<LatLng> a = a(optJSONObject.optJSONArray("spath"));
                drivingStep.setPathList(a);
                if (a != null) {
                    RouteNode routeNode = new RouteNode();
                    routeNode.setLocation(a.get(0));
                    drivingStep.setEntrance(routeNode);
                    RouteNode routeNode2 = new RouteNode();
                    routeNode2.setLocation(a.get(a.size() - 1));
                    drivingStep.setExit(routeNode2);
                }
                if (z && i5 < i) {
                    drivingStep.setTrafficList(b(jSONArray2.optJSONObject(i5)));
                }
                i2 = i4 + 1;
                arrayList.add(drivingStep);
            }
            i5++;
            i4 = i2;
        }
        return arrayList;
    }

    private List<TaxiInfo> b(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        TaxiInfo taxiInfo = new TaxiInfo();
                        String optString = jSONObject.optString("total_price");
                        if (optString == null || optString.equals("")) {
                            taxiInfo.setTotalPrice(0.0f);
                        } else {
                            taxiInfo.setTotalPrice(Float.parseFloat(optString));
                        }
                        arrayList.add(taxiInfo);
                    }
                }
                return arrayList;
            }
            return null;
        } catch (JSONException e) {
            if (Logger.debugEnable()) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    private List<DrivingRouteLine.DrivingStep> b(JSONArray jSONArray, List<DrivingRouteLine.DrivingStep> list) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) <= 0 || list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("n");
                int optInt2 = optJSONObject.optInt("s");
                for (int i2 = 0; i2 < optInt; i2++) {
                    if (optInt2 + i2 < list.size()) {
                        arrayList.add(list.get(optInt2 + i2));
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean b(String str, DrivingRouteResult drivingRouteResult) {
        JSONObject optJSONObject;
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("result")) == null) {
                return false;
            }
            switch (optJSONObject.optInt(BdStatsConstant.StatsType.ERROR)) {
                case 0:
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("cars");
                    if (optJSONObject2 == null) {
                        return false;
                    }
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("option");
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("content");
                    if (optJSONObject3 == null || optJSONObject4 == null) {
                        return false;
                    }
                    RouteNode a = a(optJSONObject3.optJSONObject("start"));
                    ArrayList arrayList = new ArrayList();
                    RouteNode a2 = a(optJSONObject3.optJSONArray("end"), arrayList);
                    List<DrivingRouteLine.DrivingStep> a3 = a(optJSONObject4.optJSONArray("steps"), optJSONObject4.optJSONArray("stepts"));
                    ArrayList arrayList2 = new ArrayList();
                    JSONArray optJSONArray = optJSONObject4.optJSONArray("routes");
                    if (optJSONArray == null) {
                        return false;
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        DrivingRouteLine drivingRouteLine = new DrivingRouteLine();
                        JSONObject optJSONObject5 = optJSONArray.optJSONObject(i);
                        if (optJSONObject5 != null) {
                            JSONArray optJSONArray2 = optJSONObject5.optJSONArray("legs");
                            if (optJSONArray2 == null) {
                                return false;
                            }
                            int length = optJSONArray2.length();
                            ArrayList arrayList3 = new ArrayList();
                            int i2 = 0;
                            int i3 = 0;
                            for (int i4 = 0; i4 < length; i4++) {
                                JSONObject optJSONObject6 = optJSONArray2.optJSONObject(i4);
                                if (optJSONObject6 != null) {
                                    i3 += optJSONObject6.optInt("distance");
                                    i2 += optJSONObject6.optInt("duration");
                                    List<DrivingRouteLine.DrivingStep> b = b(optJSONObject6.optJSONArray("stepis"), a3);
                                    if (b != null) {
                                        arrayList3.addAll(b);
                                    }
                                }
                            }
                            drivingRouteLine.setStarting(a);
                            drivingRouteLine.setTerminal(a2);
                            if (arrayList.size() == 0) {
                                drivingRouteLine.setWayPoints(null);
                            } else {
                                drivingRouteLine.setWayPoints(arrayList);
                            }
                            drivingRouteLine.setDistance(i3);
                            drivingRouteLine.setDuration(i2);
                            drivingRouteLine.setCongestionDistance(optJSONObject5.optInt("congestion_length"));
                            drivingRouteLine.setLightNum(optJSONObject5.optInt("light_num"));
                            if (arrayList3.size() == 0) {
                                drivingRouteLine.setSteps(null);
                            } else {
                                drivingRouteLine.setSteps(arrayList3);
                            }
                            arrayList2.add(drivingRouteLine);
                        }
                    }
                    drivingRouteResult.setRouteLines(arrayList2);
                    drivingRouteResult.setTaxiInfos(b(optJSONObject2.optString("taxis")));
                    return true;
                case 4:
                    drivingRouteResult.error = SearchResult.ERRORNO.ST_EN_TOO_NEAR;
                    return true;
                default:
                    return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private int[] b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("end");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("status");
        if (optJSONArray == null || optJSONArray2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        int length2 = optJSONArray2.length();
        int i = 0;
        while (i < length) {
            int optInt = optJSONArray.optInt(i);
            int optInt2 = i < length2 ? optJSONArray2.optInt(i) : 0;
            for (int i2 = 0; i2 < optInt; i2++) {
                arrayList.add(Integer.valueOf(optInt2));
            }
            i++;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr;
    }

    public void a(String str, DrivingRouteResult drivingRouteResult) {
        if (str == null || str.equals("")) {
            drivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (optJSONObject.has("PermissionCheckError")) {
                    drivingRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                } else if (optJSONObject.has("httpStateError")) {
                    String optString = optJSONObject.optString("httpStateError");
                    if (optString.equals("NETWORK_ERROR")) {
                        drivingRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (optString.equals("REQUEST_ERROR")) {
                        drivingRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        drivingRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                }
            }
            if (!a(str, drivingRouteResult, false) && !b(str, drivingRouteResult)) {
                drivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
        } catch (Exception e) {
            drivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        }
    }
}
