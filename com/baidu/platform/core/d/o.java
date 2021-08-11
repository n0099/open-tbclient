package com.baidu.platform.core.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.route.WalkingRouteLine;
import com.baidu.mapapi.search.route.WalkingRouteResult;
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
public class o extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public o() {
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
                    RouteNode a2 = a(jSONArray.optJSONObject(i2));
                    if (i2 == length - 1) {
                        return a2;
                    }
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(a2);
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
            routeNode.setLocation(CoordUtil.decodeLocation(jSONObject.optString("pt")));
            return routeNode;
        }
        return (RouteNode) invokeL.objValue;
    }

    private List<WalkingRouteLine.WalkingStep> a(JSONArray jSONArray) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, jSONArray)) == null) {
            if (jSONArray == null || (length = jSONArray.length()) <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
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
        return (List) invokeL.objValue;
    }

    private TaxiInfo b(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            if (str == null || str.length() == 0) {
                return null;
            }
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
                jSONObject = null;
            }
            if (jSONObject == null) {
                return null;
            }
            TaxiInfo taxiInfo = new TaxiInfo();
            taxiInfo.setDesc(jSONObject.optString("remark"));
            taxiInfo.setDistance(jSONObject.optInt("distance"));
            taxiInfo.setDuration(jSONObject.optInt("duration"));
            taxiInfo.setTotalPrice((float) jSONObject.optDouble("total_price"));
            taxiInfo.setStartPrice((float) jSONObject.optDouble("start_price"));
            taxiInfo.setPerKMPrice((float) jSONObject.optDouble("km_price"));
            return taxiInfo;
        }
        return (TaxiInfo) invokeL.objValue;
    }

    private boolean b(String str, WalkingRouteResult walkingRouteResult) {
        InterceptResult invokeLL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, walkingRouteResult)) == null) {
            if (str != null && !"".equals(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (walkingRouteResult == null) {
                        return false;
                    }
                    if (jSONObject.has("taxi")) {
                        walkingRouteResult.setTaxiInfo(b(jSONObject.optString("taxi")));
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("result");
                    if (optJSONObject == null) {
                        return false;
                    }
                    int optInt = optJSONObject.optInt("error");
                    if (optInt != 0) {
                        if (optInt != 4) {
                            return false;
                        }
                        walkingRouteResult.error = SearchResult.ERRORNO.ST_EN_TOO_NEAR;
                        return true;
                    }
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("walk");
                    if (optJSONObject2 == null) {
                        return false;
                    }
                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray("routes");
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject(SpeedStatsUtils.UBC_KEY_OPTION);
                    if (optJSONObject3 == null || optJSONArray2 == null) {
                        return false;
                    }
                    RouteNode a2 = a(optJSONObject3.optJSONObject("start"));
                    RouteNode a3 = a(optJSONObject3.optJSONArray("end"), (List<RouteNode>) null);
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i2);
                        if (optJSONObject4 != null && (optJSONArray = optJSONObject4.optJSONArray("legs")) != null && optJSONArray.length() > 0) {
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                JSONObject optJSONObject5 = optJSONArray.optJSONObject(i2);
                                if (optJSONObject5 != null) {
                                    WalkingRouteLine walkingRouteLine = new WalkingRouteLine();
                                    walkingRouteLine.setStarting(a2);
                                    walkingRouteLine.setTerminal(a3);
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
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void a(String str, WalkingRouteResult walkingRouteResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, walkingRouteResult) == null) {
            if (str != null && !str.equals("")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("SDK_InnerError")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                        if (optJSONObject.has("PermissionCheckError")) {
                            walkingRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                            return;
                        } else if (optJSONObject.has("httpStateError")) {
                            String optString = optJSONObject.optString("httpStateError");
                            walkingRouteResult.error = optString.equals("NETWORK_ERROR") ? SearchResult.ERRORNO.NETWORK_ERROR : optString.equals("REQUEST_ERROR") ? SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                            return;
                        }
                    }
                    if (a(str, walkingRouteResult, false) || b(str, walkingRouteResult)) {
                        return;
                    }
                    walkingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return;
                } catch (Exception unused) {
                }
            }
            walkingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        }
    }
}
