package com.baidu.platform.core.d;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.route.WalkingRouteLine;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o extends k {
    private RouteNode a(JSONArray jSONArray, List<RouteNode> list) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return null;
        }
        int i = 0;
        while (i < length) {
            RouteNode a = a(jSONArray.optJSONObject(i));
            if (i == length - 1) {
                return a;
            }
            List<RouteNode> arrayList = list == null ? new ArrayList<>() : list;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(a);
            i++;
            list = arrayList;
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
        routeNode.setLocation(CoordUtil.decodeLocation(jSONObject.optString("pt")));
        return routeNode;
    }

    private List<WalkingRouteLine.WalkingStep> a(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                WalkingRouteLine.WalkingStep walkingStep = new WalkingRouteLine.WalkingStep();
                walkingStep.setDirection(optJSONObject.optInt("direction") * 30);
                walkingStep.setDistance(optJSONObject.optInt("distance"));
                walkingStep.setDuration(optJSONObject.optInt("duration"));
                walkingStep.setEntrance(RouteNode.location(CoordUtil.decodeLocation(optJSONObject.optString("start_location"))));
                walkingStep.setExit(RouteNode.location(CoordUtil.decodeLocation(optJSONObject.optString("end_location"))));
                String optString = optJSONObject.optString("instructions");
                if (optString != null && optString.length() >= 4) {
                    optString = optString.replaceAll("</?[a-z]>", "");
                }
                walkingStep.setInstructions(optString);
                walkingStep.setEntranceInstructions(optJSONObject.optString("start_instructions"));
                walkingStep.setExitInstructions(optJSONObject.optString("end_instructions"));
                walkingStep.setPathString(optJSONObject.optString("path"));
                arrayList.add(walkingStep);
            }
        }
        return arrayList;
    }

    private TaxiInfo b(String str) {
        JSONObject jSONObject;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject != null) {
            TaxiInfo taxiInfo = new TaxiInfo();
            taxiInfo.setDesc(jSONObject.optString("remark"));
            taxiInfo.setDistance(jSONObject.optInt("distance"));
            taxiInfo.setDuration(jSONObject.optInt("duration"));
            taxiInfo.setTotalPrice((float) jSONObject.optDouble("total_price"));
            taxiInfo.setStartPrice((float) jSONObject.optDouble("start_price"));
            taxiInfo.setPerKMPrice((float) jSONObject.optDouble("km_price"));
            return taxiInfo;
        }
        return null;
    }

    private boolean b(String str, WalkingRouteResult walkingRouteResult) {
        JSONArray optJSONArray;
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (walkingRouteResult != null) {
                if (jSONObject.has("taxi")) {
                    walkingRouteResult.setTaxiInfo(b(jSONObject.optString("taxi")));
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("result");
                if (optJSONObject != null) {
                    switch (optJSONObject.optInt(BdStatsConstant.StatsType.ERROR)) {
                        case 0:
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("walk");
                            if (optJSONObject2 != null) {
                                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("routes");
                                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("option");
                                if (optJSONObject3 == null || optJSONArray2 == null) {
                                    return false;
                                }
                                RouteNode a = a(optJSONObject3.optJSONObject("start"));
                                RouteNode a2 = a(optJSONObject3.optJSONArray("end"), (List<RouteNode>) null);
                                ArrayList arrayList = new ArrayList();
                                for (int i = 0; i < optJSONArray2.length(); i++) {
                                    JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i);
                                    if (optJSONObject4 != null && (optJSONArray = optJSONObject4.optJSONArray("legs")) != null && optJSONArray.length() > 0) {
                                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                            JSONObject optJSONObject5 = optJSONArray.optJSONObject(i);
                                            if (optJSONObject5 != null) {
                                                WalkingRouteLine walkingRouteLine = new WalkingRouteLine();
                                                walkingRouteLine.setStarting(a);
                                                walkingRouteLine.setTerminal(a2);
                                                walkingRouteLine.setDistance(optJSONObject5.optInt("distance"));
                                                walkingRouteLine.setDuration(optJSONObject5.optInt("duration"));
                                                walkingRouteLine.setSteps(a(optJSONObject5.optJSONArray("steps")));
                                                arrayList.add(walkingRouteLine);
                                            }
                                        }
                                    }
                                }
                                walkingRouteResult.setRouteLines(arrayList);
                                return true;
                            }
                            return false;
                        case 4:
                            walkingRouteResult.error = SearchResult.ERRORNO.ST_EN_TOO_NEAR;
                            return true;
                        default:
                            return false;
                    }
                }
                return false;
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void a(String str, WalkingRouteResult walkingRouteResult) {
        if (str == null || str.equals("")) {
            walkingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (optJSONObject.has("PermissionCheckError")) {
                    walkingRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                } else if (optJSONObject.has("httpStateError")) {
                    String optString = optJSONObject.optString("httpStateError");
                    if (optString.equals("NETWORK_ERROR")) {
                        walkingRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                    } else if (optString.equals("REQUEST_ERROR")) {
                        walkingRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                    } else {
                        walkingRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                }
            }
            if (!a(str, walkingRouteResult, false) && !b(str, walkingRouteResult)) {
                walkingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
        } catch (Exception e) {
            walkingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        }
    }
}
