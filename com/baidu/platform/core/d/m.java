package com.baidu.platform.core.d;

import com.baidu.down.request.task.ProgressInfo;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.VehicleInfo;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m extends k {
    private RouteNode a(JSONObject jSONObject, String str) {
        if (jSONObject == null || str == null || "".equals(str)) {
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        RouteNode routeNode = new RouteNode();
        routeNode.setTitle(optJSONObject.optString(ActVideoSetting.WIFI_DISPLAY));
        routeNode.setUid(optJSONObject.optString("uid"));
        routeNode.setLocation(CoordUtil.decodeLocation(optJSONObject.optString(Config.PLATFORM_TYPE)));
        return routeNode;
    }

    private TaxiInfo a(JSONObject jSONObject) {
        float f2;
        float f3;
        float f4;
        if (jSONObject == null) {
            return null;
        }
        TaxiInfo taxiInfo = new TaxiInfo();
        JSONArray optJSONArray = jSONObject.optJSONArray("detail");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return null;
        }
        int length = optJSONArray.length();
        int i2 = 0;
        while (true) {
            f2 = 0.0f;
            if (i2 >= length) {
                f3 = 0.0f;
                f4 = 0.0f;
                break;
            }
            JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
            if (jSONObject2 != null && jSONObject2.optString("desc").contains("白天")) {
                f3 = (float) jSONObject2.optDouble("km_price");
                f4 = (float) jSONObject2.optDouble("start_price");
                f2 = (float) jSONObject2.optDouble("total_price");
                break;
            }
            i2++;
        }
        taxiInfo.setDesc(jSONObject.optString("remark"));
        taxiInfo.setDistance(jSONObject.optInt("distance"));
        taxiInfo.setDuration(jSONObject.optInt("duration"));
        taxiInfo.setTotalPrice(f2);
        taxiInfo.setStartPrice(f4);
        taxiInfo.setPerKMPrice(f3);
        return taxiInfo;
    }

    private String b(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (charArray[i2] == '<') {
                z = true;
            } else if (charArray[i2] == '>') {
                z = false;
            } else if (!z) {
                sb.append(charArray[i2]);
            }
        }
        return sb.toString();
    }

    private boolean b(String str, TransitRouteResult transitRouteResult) {
        JSONArray jSONArray;
        RouteNode routeNode;
        JSONArray jSONArray2;
        RouteNode routeNode2;
        SearchResult.ERRORNO errorno;
        int i2 = 0;
        if (str == null || str.length() <= 0) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject == null) {
                return false;
            }
            int optInt = optJSONObject.optInt("error");
            if (optInt != 0) {
                if (optInt == 1) {
                    errorno = SearchResult.ERRORNO.ST_EN_TOO_NEAR;
                } else if (optInt != 200) {
                    return false;
                } else {
                    errorno = SearchResult.ERRORNO.NOT_SUPPORT_BUS_2CITY;
                }
                transitRouteResult.error = errorno;
                return true;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("bus");
            if (optJSONObject2 == null) {
                return false;
            }
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("taxi");
            if (optJSONObject3 != null) {
                transitRouteResult.setTaxiInfo(a(optJSONObject3));
            }
            JSONObject optJSONObject4 = optJSONObject2.optJSONObject("option");
            if (optJSONObject4 == null) {
                return false;
            }
            RouteNode a2 = a(optJSONObject4, IntentConfig.START);
            RouteNode a3 = a(optJSONObject4, ProgressInfo.JSON_KEY_END);
            JSONArray optJSONArray = optJSONObject2.optJSONArray("routes");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (i3 < optJSONArray.length()) {
                JSONObject jSONObject2 = (JSONObject) ((JSONObject) optJSONArray.opt(i3)).optJSONArray("legs").opt(i2);
                if (jSONObject2 != null) {
                    TransitRouteLine transitRouteLine = new TransitRouteLine();
                    transitRouteLine.setDistance(jSONObject2.optInt("distance"));
                    transitRouteLine.setDuration(jSONObject2.optInt("duration"));
                    transitRouteLine.setStarting(a2);
                    transitRouteLine.setTerminal(a3);
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray("steps");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        int i4 = 0;
                        while (i4 < optJSONArray2.length()) {
                            JSONArray optJSONArray3 = optJSONArray2.optJSONObject(i4).optJSONArray("step");
                            if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                                jSONArray2 = optJSONArray;
                                routeNode2 = a3;
                            } else {
                                JSONObject optJSONObject5 = optJSONArray3.optJSONObject(i2);
                                TransitRouteLine.TransitStep transitStep = new TransitRouteLine.TransitStep();
                                transitStep.setEntrace(RouteNode.location(CoordUtil.decodeLocation(optJSONObject5.optString("start_location"))));
                                transitStep.setExit(RouteNode.location(CoordUtil.decodeLocation(optJSONObject5.optString("end_location"))));
                                jSONArray2 = optJSONArray;
                                routeNode2 = a3;
                                transitStep.setStepType(optJSONObject5.optInt("type") == 5 ? TransitRouteLine.TransitStep.TransitRouteStepType.WAKLING : TransitRouteLine.TransitStep.TransitRouteStepType.BUSLINE);
                                transitStep.setInstructions(b(optJSONObject5.optString("instructions")));
                                transitStep.setDistance(optJSONObject5.optInt("distance"));
                                transitStep.setDuration(optJSONObject5.optInt("duration"));
                                transitStep.setPathString(optJSONObject5.optString("path"));
                                if (optJSONObject5.has("vehicle")) {
                                    transitStep.setVehicleInfo(c(optJSONObject5.optString("vehicle")));
                                    JSONObject optJSONObject6 = optJSONObject5.optJSONObject("vehicle");
                                    transitStep.getEntrance().setUid(optJSONObject6.optString("start_uid"));
                                    transitStep.getEntrance().setTitle(optJSONObject6.optString("start_name"));
                                    transitStep.getExit().setUid(optJSONObject6.optString("end_uid"));
                                    transitStep.getExit().setTitle(optJSONObject6.optString("end_name"));
                                    Integer valueOf = Integer.valueOf(optJSONObject6.optInt("type"));
                                    transitStep.setStepType((valueOf == null || valueOf.intValue() != 1) ? TransitRouteLine.TransitStep.TransitRouteStepType.BUSLINE : TransitRouteLine.TransitStep.TransitRouteStepType.SUBWAY);
                                }
                                arrayList2.add(transitStep);
                            }
                            i4++;
                            optJSONArray = jSONArray2;
                            a3 = routeNode2;
                            i2 = 0;
                        }
                        jSONArray = optJSONArray;
                        routeNode = a3;
                        transitRouteLine.setSteps(arrayList2);
                        arrayList.add(transitRouteLine);
                        i3++;
                        optJSONArray = jSONArray;
                        a3 = routeNode;
                        i2 = 0;
                    }
                }
                jSONArray = optJSONArray;
                routeNode = a3;
                i3++;
                optJSONArray = jSONArray;
                a3 = routeNode;
                i2 = 0;
            }
            transitRouteResult.setRoutelines(arrayList);
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private VehicleInfo c(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setZonePrice(jSONObject.optInt("zone_price"));
        vehicleInfo.setTotalPrice(jSONObject.optInt("total_price"));
        vehicleInfo.setTitle(jSONObject.optString("name"));
        vehicleInfo.setPassStationNum(jSONObject.optInt("stop_num"));
        vehicleInfo.setUid(jSONObject.optString("uid"));
        return vehicleInfo;
    }

    public void a(String str, TransitRouteResult transitRouteResult) {
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        transitRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                        return;
                    } else if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        transitRouteResult.error = optString.equals("NETWORK_ERROR") ? SearchResult.ERRORNO.NETWORK_ERROR : optString.equals("REQUEST_ERROR") ? SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        return;
                    }
                }
                if (a(str, transitRouteResult, false) || b(str, transitRouteResult)) {
                    return;
                }
                transitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return;
            } catch (Exception unused) {
            }
        }
        transitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    }
}
