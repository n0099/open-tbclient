package com.baidu.platform.core.d;

import com.baidu.down.request.task.ProgressInfo;
import com.baidu.mapapi.common.Logger;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends k {
    private RouteNode a(JSONArray jSONArray, List<RouteNode> list) {
        int length;
        if (jSONArray != null && (length = jSONArray.length()) > 0) {
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    RouteNode a2 = a(optJSONObject);
                    if (i == length - 1) {
                        return a2;
                    }
                    list.add(a2);
                }
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
        if (jSONArray == null || (length = jSONArray.length()) < 6) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        double d2 = 0.0d;
        double d3 = 0.0d;
        for (int i = 5; i < length; i++) {
            if (i % 2 != 0) {
                double optInt = jSONArray.optInt(i);
                Double.isNaN(optInt);
                d3 += optInt;
            } else {
                double optInt2 = jSONArray.optInt(i);
                Double.isNaN(optInt2);
                d2 += optInt2;
                arrayList.add(CoordUtil.mc2ll(new GeoPoint(d2, d3)));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<DrivingRouteLine.DrivingStep> a(JSONArray jSONArray, JSONArray jSONArray2) {
        int length;
        int i;
        boolean z;
        int i2;
        int i3;
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return null;
        }
        if (jSONArray2 != null) {
            i = jSONArray2.length();
            if (i > 0) {
                z = true;
                ArrayList arrayList = new ArrayList();
                int i4 = 0;
                for (i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
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
                            if (distance < 1000) {
                                optString2 = " - " + distance + "米";
                                i3 = i;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append(" - ");
                                i3 = i;
                                double d2 = distance;
                                Double.isNaN(d2);
                                sb.append(d2 / 1000.0d);
                                sb.append("公里");
                                optString2 = sb.toString();
                            }
                            if (i4 <= arrayList.size()) {
                                optString2 = ((DrivingRouteLine.DrivingStep) arrayList.get(i4 - 1)).getExitInstructions() + optString2;
                            }
                        } else {
                            i3 = i;
                        }
                        drivingStep.setEntranceInstructions(optString2);
                        drivingStep.setExitInstructions(optJSONObject.optString("end_instructions"));
                        drivingStep.setNumTurns(optJSONObject.optInt("turn"));
                        List<LatLng> a2 = a(optJSONObject.optJSONArray("spath"));
                        drivingStep.setPathList(a2);
                        if (a2 != null) {
                            RouteNode routeNode = new RouteNode();
                            routeNode.setLocation(a2.get(0));
                            drivingStep.setEntrance(routeNode);
                            RouteNode routeNode2 = new RouteNode();
                            routeNode2.setLocation(a2.get(a2.size() - 1));
                            drivingStep.setExit(routeNode2);
                        }
                        i = i3;
                        if (z && i2 < i) {
                            drivingStep.setTrafficList(b(jSONArray2.optJSONObject(i2)));
                        }
                        i4++;
                        arrayList.add(drivingStep);
                    }
                }
                return arrayList;
            }
        } else {
            i = 0;
        }
        z = false;
        ArrayList arrayList2 = new ArrayList();
        int i42 = 0;
        while (i2 < length) {
        }
        return arrayList2;
    }

    private List<TaxiInfo> b(String str) {
        if (str != null && str.length() > 0) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        TaxiInfo taxiInfo = new TaxiInfo();
                        String optString = jSONObject.optString("total_price");
                        if (optString != null && !optString.equals("")) {
                            taxiInfo.setTotalPrice(Float.parseFloat(optString));
                            arrayList.add(taxiInfo);
                        }
                        taxiInfo.setTotalPrice(0.0f);
                        arrayList.add(taxiInfo);
                    }
                }
                return arrayList;
            } catch (JSONException e2) {
                if (Logger.debugEnable()) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
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
                    int i3 = optInt2 + i2;
                    if (i3 < list.size()) {
                        arrayList.add(list.get(i3));
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean b(String str, DrivingRouteResult drivingRouteResult) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        boolean z = false;
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            JSONObject optJSONObject = jSONObject2.optJSONObject("result");
            if (optJSONObject == null) {
                return false;
            }
            int optInt = optJSONObject.optInt("error");
            if (optInt != 0) {
                if (optInt != 4) {
                    return false;
                }
                drivingRouteResult.error = SearchResult.ERRORNO.ST_EN_TOO_NEAR;
                return true;
            }
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("cars");
            if (optJSONObject2 == null) {
                return false;
            }
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("option");
            JSONObject optJSONObject4 = optJSONObject2.optJSONObject("content");
            if (optJSONObject3 == null || optJSONObject4 == null) {
                return false;
            }
            RouteNode a2 = a(optJSONObject3.optJSONObject(IntentConfig.START));
            ArrayList arrayList = new ArrayList();
            RouteNode a3 = a(optJSONObject3.optJSONArray(ProgressInfo.JSON_KEY_END), arrayList);
            List<DrivingRouteLine.DrivingStep> a4 = a(optJSONObject4.optJSONArray("steps"), optJSONObject4.optJSONArray("stepts"));
            ArrayList arrayList2 = new ArrayList();
            JSONArray optJSONArray = optJSONObject4.optJSONArray("routes");
            if (optJSONArray == null) {
                return false;
            }
            int i = 0;
            while (i < optJSONArray.length()) {
                DrivingRouteLine drivingRouteLine = new DrivingRouteLine();
                JSONObject optJSONObject5 = optJSONArray.optJSONObject(i);
                if (optJSONObject5 == null) {
                    jSONObject = optJSONObject2;
                    jSONArray = optJSONArray;
                } else {
                    JSONArray optJSONArray2 = optJSONObject5.optJSONArray("legs");
                    if (optJSONArray2 == null) {
                        return z;
                    }
                    int length = optJSONArray2.length();
                    ArrayList arrayList3 = new ArrayList();
                    jSONObject = optJSONObject2;
                    jSONArray = optJSONArray;
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < length) {
                        int i5 = length;
                        JSONObject optJSONObject6 = optJSONArray2.optJSONObject(i3);
                        JSONArray jSONArray2 = optJSONArray2;
                        if (optJSONObject6 != null) {
                            i4 += optJSONObject6.optInt("distance");
                            i2 += optJSONObject6.optInt("duration");
                            List<DrivingRouteLine.DrivingStep> b2 = b(optJSONObject6.optJSONArray("stepis"), a4);
                            if (b2 != null) {
                                arrayList3.addAll(b2);
                            }
                        }
                        i3++;
                        length = i5;
                        optJSONArray2 = jSONArray2;
                    }
                    drivingRouteLine.setStarting(a2);
                    drivingRouteLine.setTerminal(a3);
                    if (arrayList.size() == 0) {
                        drivingRouteLine.setWayPoints(null);
                    } else {
                        drivingRouteLine.setWayPoints(arrayList);
                    }
                    drivingRouteLine.setDistance(i4);
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
                i++;
                optJSONArray = jSONArray;
                optJSONObject2 = jSONObject;
                z = false;
            }
            drivingRouteResult.setRouteLines(arrayList2);
            drivingRouteResult.setTaxiInfos(b(optJSONObject2.optString("taxis")));
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private int[] b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(ProgressInfo.JSON_KEY_END);
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
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        drivingRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                        return;
                    } else if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        drivingRouteResult.error = optString.equals("NETWORK_ERROR") ? SearchResult.ERRORNO.NETWORK_ERROR : optString.equals("REQUEST_ERROR") ? SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        return;
                    }
                }
                if (a(str, drivingRouteResult, false) || b(str, drivingRouteResult)) {
                    return;
                }
                drivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return;
            } catch (Exception unused) {
            }
        }
        drivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    }
}
