package com.baidu.platform.core.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.VehicleInfo;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
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
/* loaded from: classes2.dex */
public class m extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m() {
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

    private RouteNode a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, jSONObject, str)) == null) {
            if (jSONObject != null && str != null && !"".equals(str)) {
                JSONObject optJSONObject = jSONObject.optJSONObject(str);
                RouteNode routeNode = new RouteNode();
                routeNode.setTitle(optJSONObject.optString(ActVideoSetting.WIFI_DISPLAY));
                routeNode.setUid(optJSONObject.optString("uid"));
                routeNode.setLocation(CoordUtil.decodeLocation(optJSONObject.optString(Config.PLATFORM_TYPE)));
                return routeNode;
            }
            return null;
        }
        return (RouteNode) invokeLL.objValue;
    }

    private TaxiInfo a(JSONObject jSONObject) {
        InterceptResult invokeL;
        float f;
        float f2;
        float f3;
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
            int i = 0;
            while (true) {
                f = 0.0f;
                if (i < length) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                    if (jSONObject2 != null && jSONObject2.optString("desc").contains("白天")) {
                        f2 = (float) jSONObject2.optDouble("km_price");
                        f3 = (float) jSONObject2.optDouble("start_price");
                        f = (float) jSONObject2.optDouble("total_price");
                        break;
                    }
                    i++;
                } else {
                    f2 = 0.0f;
                    f3 = 0.0f;
                    break;
                }
            }
            taxiInfo.setDesc(jSONObject.optString("remark"));
            taxiInfo.setDistance(jSONObject.optInt("distance"));
            taxiInfo.setDuration(jSONObject.optInt("duration"));
            taxiInfo.setTotalPrice(f);
            taxiInfo.setStartPrice(f3);
            taxiInfo.setPerKMPrice(f2);
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
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == '<') {
                    z = true;
                } else if (charArray[i] == '>') {
                    z = false;
                } else if (!z) {
                    sb.append(charArray[i]);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, transitRouteResult)) == null) {
            int i = 0;
            if (str != null && str.length() > 0) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject optJSONObject = jSONObject.optJSONObject(TiebaStatic.LogFields.RESULT);
                    if (optJSONObject == null) {
                        return false;
                    }
                    int optInt = optJSONObject.optInt("error");
                    if (optInt != 0) {
                        if (optInt != 1) {
                            if (optInt != 200) {
                                return false;
                            }
                            transitRouteResult.error = SearchResult.ERRORNO.NOT_SUPPORT_BUS_2CITY;
                            return true;
                        }
                        transitRouteResult.error = SearchResult.ERRORNO.ST_EN_TOO_NEAR;
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
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        int i2 = 0;
                        while (i2 < optJSONArray.length()) {
                            JSONObject jSONObject2 = (JSONObject) ((JSONObject) optJSONArray.opt(i2)).optJSONArray("legs").opt(i);
                            if (jSONObject2 != null) {
                                TransitRouteLine transitRouteLine = new TransitRouteLine();
                                transitRouteLine.setDistance(jSONObject2.optInt("distance"));
                                transitRouteLine.setDuration(jSONObject2.optInt("duration"));
                                transitRouteLine.setStarting(a);
                                transitRouteLine.setTerminal(a2);
                                JSONArray optJSONArray2 = jSONObject2.optJSONArray("steps");
                                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                    ArrayList arrayList2 = new ArrayList();
                                    int i3 = 0;
                                    while (i3 < optJSONArray2.length()) {
                                        JSONArray optJSONArray3 = optJSONArray2.optJSONObject(i3).optJSONArray(ShaderParams.VALUE_TYPE_STEP);
                                        if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                                            JSONObject optJSONObject5 = optJSONArray3.optJSONObject(i);
                                            TransitRouteLine.TransitStep transitStep = new TransitRouteLine.TransitStep();
                                            transitStep.setEntrace(RouteNode.location(CoordUtil.decodeLocation(optJSONObject5.optString("start_location"))));
                                            transitStep.setExit(RouteNode.location(CoordUtil.decodeLocation(optJSONObject5.optString("end_location"))));
                                            jSONArray2 = optJSONArray;
                                            routeNode2 = a2;
                                            if (optJSONObject5.optInt("type") == 5) {
                                                transitStep.setStepType(TransitRouteLine.TransitStep.TransitRouteStepType.WAKLING);
                                            } else {
                                                transitStep.setStepType(TransitRouteLine.TransitStep.TransitRouteStepType.BUSLINE);
                                            }
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
                                                if (valueOf != null) {
                                                    if (valueOf.intValue() == 1) {
                                                        transitStep.setStepType(TransitRouteLine.TransitStep.TransitRouteStepType.SUBWAY);
                                                    } else {
                                                        transitStep.setStepType(TransitRouteLine.TransitStep.TransitRouteStepType.BUSLINE);
                                                    }
                                                } else {
                                                    transitStep.setStepType(TransitRouteLine.TransitStep.TransitRouteStepType.BUSLINE);
                                                }
                                            }
                                            arrayList2.add(transitStep);
                                        } else {
                                            jSONArray2 = optJSONArray;
                                            routeNode2 = a2;
                                        }
                                        i3++;
                                        optJSONArray = jSONArray2;
                                        a2 = routeNode2;
                                        i = 0;
                                    }
                                    jSONArray = optJSONArray;
                                    routeNode = a2;
                                    transitRouteLine.setSteps(arrayList2);
                                    arrayList.add(transitRouteLine);
                                    i2++;
                                    optJSONArray = jSONArray;
                                    a2 = routeNode;
                                    i = 0;
                                }
                            }
                            jSONArray = optJSONArray;
                            routeNode = a2;
                            i2++;
                            optJSONArray = jSONArray;
                            a2 = routeNode;
                            i = 0;
                        }
                        transitRouteResult.setRoutelines(arrayList);
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

    private VehicleInfo c(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
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
                            if (optString.equals("NETWORK_ERROR")) {
                                transitRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                                return;
                            } else if (optString.equals("REQUEST_ERROR")) {
                                transitRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                                return;
                            } else {
                                transitRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                                return;
                            }
                        }
                    }
                    if (!a(str, transitRouteResult, false) && !b(str, transitRouteResult)) {
                        transitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    transitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return;
                }
            }
            transitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        }
    }
}
