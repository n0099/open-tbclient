package com.baidu.platform.core.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.common.Logger;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private RouteNode a(JSONArray jSONArray, List<RouteNode> list) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, jSONArray, list)) == null) {
            if (jSONArray != null && (length = jSONArray.length()) > 0) {
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
            }
            return null;
        }
        return (RouteNode) invokeLL.objValue;
    }

    private RouteNode a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            RouteNode routeNode = new RouteNode();
            routeNode.setTitle(jSONObject.optString(ActVideoSetting.WIFI_DISPLAY));
            routeNode.setUid(jSONObject.optString("uid"));
            GeoPoint geoPoint = new GeoPoint(0, 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("spt");
            if (optJSONArray != null) {
                geoPoint.setLongitudeE6(optJSONArray.optInt(0));
                geoPoint.setLatitudeE6(optJSONArray.optInt(1));
            }
            routeNode.setLocation(CoordUtil.mc2ll(geoPoint));
            return routeNode;
        }
        return (RouteNode) invokeL.objValue;
    }

    private List<LatLng> a(JSONArray jSONArray) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, jSONArray)) == null) {
            if (jSONArray != null && (length = jSONArray.length()) >= 6) {
                ArrayList arrayList = new ArrayList();
                double d = 0.0d;
                double d2 = 0.0d;
                for (int i = 5; i < length; i++) {
                    if (i % 2 != 0) {
                        d2 += jSONArray.optInt(i);
                    } else {
                        d += jSONArray.optInt(i);
                        arrayList.add(CoordUtil.mc2ll(new GeoPoint(d, d2)));
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<DrivingRouteLine.DrivingStep> a(JSONArray jSONArray, JSONArray jSONArray2) {
        InterceptResult invokeLL;
        int length;
        int i;
        boolean z;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONArray, jSONArray2)) == null) {
            if (jSONArray != null && (length = jSONArray.length()) > 0) {
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
                                if (optString != null && optString.length() >= 4) {
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
                                        sb.append(distance / 1000.0d);
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
                                drivingStep.setRoadLevel(optJSONObject.optInt("road_level"));
                                drivingStep.setRoadName(optJSONObject.optString("road_name"));
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
            return null;
        }
        return (List) invokeLL.objValue;
    }

    private boolean b(String str, DrivingRouteResult drivingRouteResult) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, str, drivingRouteResult)) == null) {
            boolean z = false;
            if (str != null && !"".equals(str)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    JSONObject optJSONObject = jSONObject2.optJSONObject(TiebaStatic.LogFields.RESULT);
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
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject(SpeedStatsUtils.UBC_KEY_OPTION);
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("content");
                    if (optJSONObject3 != null && optJSONObject4 != null) {
                        RouteNode a = a(optJSONObject3.optJSONObject("start"));
                        ArrayList arrayList = new ArrayList();
                        RouteNode a2 = a(optJSONObject3.optJSONArray("end"), arrayList);
                        List<DrivingRouteLine.DrivingStep> a3 = a(optJSONObject4.optJSONArray("steps"), optJSONObject4.optJSONArray("stepts"));
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
                                jSONObject = optJSONObject4;
                                jSONArray = optJSONArray;
                            } else {
                                JSONArray optJSONArray2 = optJSONObject5.optJSONArray("legs");
                                if (optJSONArray2 == null) {
                                    return z;
                                }
                                int length = optJSONArray2.length();
                                ArrayList arrayList3 = new ArrayList();
                                jSONObject = optJSONObject4;
                                jSONArray = optJSONArray;
                                int i2 = 0;
                                int i3 = 0;
                                int i4 = 0;
                                while (i3 < length) {
                                    int i5 = length;
                                    JSONObject optJSONObject6 = optJSONArray2.optJSONObject(i3);
                                    if (optJSONObject6 == null) {
                                        jSONArray2 = optJSONArray2;
                                    } else {
                                        jSONArray2 = optJSONArray2;
                                        i4 += optJSONObject6.optInt("distance");
                                        i2 += optJSONObject6.optInt("duration");
                                        List<DrivingRouteLine.DrivingStep> b = b(optJSONObject6.optJSONArray("stepis"), a3);
                                        if (b != null) {
                                            arrayList3.addAll(b);
                                        }
                                    }
                                    i3++;
                                    length = i5;
                                    optJSONArray2 = jSONArray2;
                                }
                                drivingRouteLine.setStarting(a);
                                drivingRouteLine.setTerminal(a2);
                                if (arrayList.size() == 0) {
                                    drivingRouteLine.setWayPoints(null);
                                } else {
                                    drivingRouteLine.setWayPoints(arrayList);
                                }
                                drivingRouteLine.setDistance(i4);
                                drivingRouteLine.setDuration(i2);
                                drivingRouteLine.setCongestionDistance(optJSONObject5.optInt("congestion_length"));
                                drivingRouteLine.setLightNum(optJSONObject5.optInt("light_num"));
                                drivingRouteLine.setToll(optJSONObject5.optInt("toll"));
                                if (arrayList3.size() == 0) {
                                    drivingRouteLine.setSteps(null);
                                } else {
                                    drivingRouteLine.setSteps(arrayList3);
                                }
                                arrayList2.add(drivingRouteLine);
                            }
                            i++;
                            optJSONArray = jSONArray;
                            optJSONObject4 = jSONObject;
                            z = false;
                        }
                        drivingRouteResult.setRouteLines(arrayList2);
                        drivingRouteResult.setTaxiInfos(b(optJSONObject4.optString("taxis")));
                        return true;
                    }
                    return false;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private List<TaxiInfo> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
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
                } catch (JSONException e) {
                    if (Logger.debugEnable()) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    private List<DrivingRouteLine.DrivingStep> b(JSONArray jSONArray, List<DrivingRouteLine.DrivingStep> list) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, jSONArray, list)) == null) {
            if (jSONArray != null && (length = jSONArray.length()) > 0 && list != null) {
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
            return null;
        }
        return (List) invokeLL.objValue;
    }

    private int[] b(JSONObject jSONObject) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, jSONObject)) == null) {
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
            for (int i2 = 0; i2 < length; i2++) {
                int optInt = optJSONArray.optInt(i2);
                if (i2 < length2) {
                    i = optJSONArray2.optInt(i2);
                } else {
                    i = 0;
                }
                for (int i3 = 0; i3 < optInt; i3++) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            int[] iArr = new int[arrayList.size()];
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public void a(String str, DrivingRouteResult drivingRouteResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, drivingRouteResult) == null) {
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
                            if (optString.equals("NETWORK_ERROR")) {
                                drivingRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                                return;
                            } else if (optString.equals("REQUEST_ERROR")) {
                                drivingRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                                return;
                            } else {
                                drivingRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                                return;
                            }
                        }
                    }
                    if (!a(str, drivingRouteResult, false) && !b(str, drivingRouteResult)) {
                        drivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    drivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return;
                }
            }
            drivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        }
    }
}
