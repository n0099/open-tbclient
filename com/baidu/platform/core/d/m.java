package com.baidu.platform.core.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.VehicleInfo;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class m extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m() {
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

    private RouteNode a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, jSONObject, str)) == null) {
            if (jSONObject == null || str == null || "".equals(str)) {
                return null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            RouteNode routeNode = new RouteNode();
            routeNode.setTitle(optJSONObject.optString(ActVideoSetting.WIFI_DISPLAY));
            routeNode.setUid(optJSONObject.optString("uid"));
            routeNode.setLocation(CoordUtil.decodeLocation(optJSONObject.optString("pt")));
            return routeNode;
        }
        return (RouteNode) invokeLL.objValue;
    }

    private TaxiInfo a(JSONObject jSONObject) {
        InterceptResult invokeL;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, jSONObject)) == null) {
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
        return (TaxiInfo) invokeL.objValue;
    }

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
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
        return (String) invokeL.objValue;
    }

    private boolean b(String str, TransitRouteResult transitRouteResult) {
        InterceptResult invokeLL;
        JSONArray jSONArray;
        RouteNode routeNode;
        JSONArray jSONArray2;
        RouteNode routeNode2;
        SearchResult.ERRORNO errorno;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, transitRouteResult)) == null) {
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
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject(SpeedStatsUtils.UBC_KEY_OPTION);
                if (optJSONObject4 == null) {
                    return false;
                }
                RouteNode a = a(optJSONObject4, "start");
                RouteNode a2 = a(optJSONObject4, "end");
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
                        transitRouteLine.setStarting(a);
                        transitRouteLine.setTerminal(a2);
                        JSONArray optJSONArray2 = jSONObject2.optJSONArray("steps");
                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                            ArrayList arrayList2 = new ArrayList();
                            int i4 = 0;
                            while (i4 < optJSONArray2.length()) {
                                JSONArray optJSONArray3 = optJSONArray2.optJSONObject(i4).optJSONArray(ShaderParams.VALUE_TYPE_STEP);
                                if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                                    jSONArray2 = optJSONArray;
                                    routeNode2 = a2;
                                } else {
                                    JSONObject optJSONObject5 = optJSONArray3.optJSONObject(i2);
                                    TransitRouteLine.TransitStep transitStep = new TransitRouteLine.TransitStep();
                                    transitStep.setEntrace(RouteNode.location(CoordUtil.decodeLocation(optJSONObject5.optString("start_location"))));
                                    transitStep.setExit(RouteNode.location(CoordUtil.decodeLocation(optJSONObject5.optString("end_location"))));
                                    jSONArray2 = optJSONArray;
                                    routeNode2 = a2;
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
                                a2 = routeNode2;
                                i2 = 0;
                            }
                            jSONArray = optJSONArray;
                            routeNode = a2;
                            transitRouteLine.setSteps(arrayList2);
                            arrayList.add(transitRouteLine);
                            i3++;
                            optJSONArray = jSONArray;
                            a2 = routeNode;
                            i2 = 0;
                        }
                    }
                    jSONArray = optJSONArray;
                    routeNode = a2;
                    i3++;
                    optJSONArray = jSONArray;
                    a2 = routeNode;
                    i2 = 0;
                }
                transitRouteResult.setRoutelines(arrayList);
                return true;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private VehicleInfo c(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
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
        return (VehicleInfo) invokeL.objValue;
    }

    public void a(String str, TransitRouteResult transitRouteResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, transitRouteResult) == null) {
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
}
