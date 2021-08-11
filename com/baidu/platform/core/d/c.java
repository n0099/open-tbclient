package com.baidu.platform.core.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.common.Logger;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
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
/* loaded from: classes5.dex */
public class c extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        RouteNode a2 = a(optJSONObject);
                        if (i2 == length - 1) {
                            return a2;
                        }
                        list.add(a2);
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
            GeoPoint geoPoint = new GeoPoint(0.0d, 0.0d);
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
            if (jSONArray == null || (length = jSONArray.length()) < 6) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            double d2 = 0.0d;
            double d3 = 0.0d;
            for (int i2 = 5; i2 < length; i2++) {
                if (i2 % 2 != 0) {
                    d3 += jSONArray.optInt(i2);
                } else {
                    d2 += jSONArray.optInt(i2);
                    arrayList.add(CoordUtil.mc2ll(new GeoPoint(d2, d3)));
                }
            }
            return arrayList;
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
        int i2;
        boolean z;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONArray, jSONArray2)) == null) {
            if (jSONArray == null || (length = jSONArray.length()) <= 0) {
                return null;
            }
            if (jSONArray2 != null) {
                i2 = jSONArray2.length();
                if (i2 > 0) {
                    z = true;
                    ArrayList arrayList = new ArrayList();
                    int i5 = 0;
                    for (i3 = 0; i3 < length; i3++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i3);
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
                                    i4 = i2;
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(" - ");
                                    i4 = i2;
                                    sb.append(distance / 1000.0d);
                                    sb.append("公里");
                                    optString2 = sb.toString();
                                }
                                if (i5 <= arrayList.size()) {
                                    optString2 = ((DrivingRouteLine.DrivingStep) arrayList.get(i5 - 1)).getExitInstructions() + optString2;
                                }
                            } else {
                                i4 = i2;
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
                            i2 = i4;
                            if (z && i3 < i2) {
                                drivingStep.setTrafficList(b(jSONArray2.optJSONObject(i3)));
                            }
                            i5++;
                            arrayList.add(drivingStep);
                        }
                    }
                    return arrayList;
                }
            } else {
                i2 = 0;
            }
            z = false;
            ArrayList arrayList2 = new ArrayList();
            int i52 = 0;
            while (i3 < length) {
            }
            return arrayList2;
        }
        return (List) invokeLL.objValue;
    }

    private List<TaxiInfo> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
            if (str != null && str.length() > 0) {
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
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
        return (List) invokeL.objValue;
    }

    private List<DrivingRouteLine.DrivingStep> b(JSONArray jSONArray, List<DrivingRouteLine.DrivingStep> list) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, jSONArray, list)) == null) {
            if (jSONArray == null || (length = jSONArray.length()) <= 0 || list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    int optInt = optJSONObject.optInt("n");
                    int optInt2 = optJSONObject.optInt("s");
                    for (int i3 = 0; i3 < optInt; i3++) {
                        int i4 = optInt2 + i3;
                        if (i4 < list.size()) {
                            arrayList.add(list.get(i4));
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    private boolean b(String str, DrivingRouteResult drivingRouteResult) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, str, drivingRouteResult)) == null) {
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
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject(SpeedStatsUtils.UBC_KEY_OPTION);
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("content");
                if (optJSONObject3 == null || optJSONObject4 == null) {
                    return false;
                }
                RouteNode a2 = a(optJSONObject3.optJSONObject("start"));
                ArrayList arrayList = new ArrayList();
                RouteNode a3 = a(optJSONObject3.optJSONArray("end"), arrayList);
                List<DrivingRouteLine.DrivingStep> a4 = a(optJSONObject4.optJSONArray("steps"), optJSONObject4.optJSONArray("stepts"));
                ArrayList arrayList2 = new ArrayList();
                JSONArray optJSONArray = optJSONObject4.optJSONArray("routes");
                if (optJSONArray == null) {
                    return false;
                }
                int i2 = 0;
                while (i2 < optJSONArray.length()) {
                    DrivingRouteLine drivingRouteLine = new DrivingRouteLine();
                    JSONObject optJSONObject5 = optJSONArray.optJSONObject(i2);
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
                        int i3 = 0;
                        int i4 = 0;
                        int i5 = 0;
                        while (i4 < length) {
                            int i6 = length;
                            JSONObject optJSONObject6 = optJSONArray2.optJSONObject(i4);
                            JSONArray jSONArray2 = optJSONArray2;
                            if (optJSONObject6 != null) {
                                i5 += optJSONObject6.optInt("distance");
                                i3 += optJSONObject6.optInt("duration");
                                List<DrivingRouteLine.DrivingStep> b2 = b(optJSONObject6.optJSONArray("stepis"), a4);
                                if (b2 != null) {
                                    arrayList3.addAll(b2);
                                }
                            }
                            i4++;
                            length = i6;
                            optJSONArray2 = jSONArray2;
                        }
                        drivingRouteLine.setStarting(a2);
                        drivingRouteLine.setTerminal(a3);
                        if (arrayList.size() == 0) {
                            drivingRouteLine.setWayPoints(null);
                        } else {
                            drivingRouteLine.setWayPoints(arrayList);
                        }
                        drivingRouteLine.setDistance(i5);
                        drivingRouteLine.setDuration(i3);
                        drivingRouteLine.setCongestionDistance(optJSONObject5.optInt("congestion_length"));
                        drivingRouteLine.setLightNum(optJSONObject5.optInt("light_num"));
                        if (arrayList3.size() == 0) {
                            drivingRouteLine.setSteps(null);
                        } else {
                            drivingRouteLine.setSteps(arrayList3);
                        }
                        arrayList2.add(drivingRouteLine);
                    }
                    i2++;
                    optJSONArray = jSONArray;
                    optJSONObject4 = jSONObject;
                    z = false;
                }
                drivingRouteResult.setRouteLines(arrayList2);
                drivingRouteResult.setTaxiInfos(b(optJSONObject4.optString("taxis")));
                return true;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private int[] b(JSONObject jSONObject) {
        InterceptResult invokeL;
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
            int i2 = 0;
            while (i2 < length) {
                int optInt = optJSONArray.optInt(i2);
                int optInt2 = i2 < length2 ? optJSONArray2.optInt(i2) : 0;
                for (int i3 = 0; i3 < optInt; i3++) {
                    arrayList.add(Integer.valueOf(optInt2));
                }
                i2++;
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
}
