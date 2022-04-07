package com.baidu.platform.core.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.BikingRouteLine;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.SuggestAddrInfo;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends com.baidu.platform.base.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    private LatLng a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            LatLng latLng = new LatLng(jSONObject.optDouble(SuggestAddrField.KEY_LAT), jSONObject.optDouble(SuggestAddrField.KEY_LNG));
            return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(latLng) : latLng;
        }
        return (LatLng) invokeL.objValue;
    }

    private RouteNode a(JSONObject jSONObject, String str, String str2) {
        InterceptResult invokeLLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, jSONObject, str, str2)) == null) {
            if (jSONObject == null || str == null || "".equals(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
                return null;
            }
            RouteNode routeNode = new RouteNode();
            routeNode.setTitle(optJSONObject.optString("cname"));
            routeNode.setUid(optJSONObject.optString("uid"));
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(str2);
            if (optJSONObject2 != null) {
                LatLng latLng = new LatLng(optJSONObject2.optDouble(SuggestAddrField.KEY_LAT), optJSONObject2.optDouble(SuggestAddrField.KEY_LNG));
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    latLng = CoordTrans.baiduToGcj(latLng);
                }
                routeNode.setLocation(latLng);
            }
            return routeNode;
        }
        return (RouteNode) invokeLLL.objValue;
    }

    private List<BikingRouteLine.BikingStep> a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, jSONArray)) == null) {
            boolean z = jSONArray == null;
            int length = jSONArray.length();
            if ((length <= 0) || z) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    BikingRouteLine.BikingStep bikingStep = new BikingRouteLine.BikingStep();
                    bikingStep.setDirection(optJSONObject.optInt("direction") * 30);
                    bikingStep.setDistance(optJSONObject.optInt("distance"));
                    bikingStep.setDuration(optJSONObject.optInt("duration"));
                    bikingStep.setName(optJSONObject.optString("name"));
                    bikingStep.setTurnType(optJSONObject.optString("turn_type"));
                    bikingStep.setEntrance(RouteNode.location(a(optJSONObject.optJSONObject("stepOriginLocation"))));
                    bikingStep.setExit(RouteNode.location(a(optJSONObject.optJSONObject("stepDestinationLocation"))));
                    String optString = optJSONObject.optString("instructions");
                    if (optString != null && optString.length() >= 4) {
                        optString = optString.replaceAll("</?[a-z]>", "");
                    }
                    bikingStep.setInstructions(optString);
                    bikingStep.setEntranceInstructions(optJSONObject.optString("stepOriginInstruction"));
                    bikingStep.setExitInstructions(optJSONObject.optString("stepDestinationInstruction"));
                    bikingStep.setPathString(optJSONObject.optString("path"));
                    arrayList.add(bikingStep);
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    private boolean a(String str, BikingRouteResult bikingRouteResult) {
        InterceptResult invokeLL;
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, bikingRouteResult)) == null) {
            if (str != null && str.length() > 0) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("status_sdk");
                    if (optInt != 0) {
                        if (optInt == 1) {
                            bikingRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                            return true;
                        }
                        if (optInt == 2) {
                            bikingRouteResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
                        }
                        return false;
                    }
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("result");
                    if (optJSONObject2 == null) {
                        return false;
                    }
                    int optInt2 = jSONObject.optInt("type");
                    if (optInt2 == 1) {
                        bikingRouteResult.setSuggestAddrInfo(b(optJSONObject2));
                        bikingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                    } else if (optInt2 != 2 || (optJSONArray = optJSONObject2.optJSONArray("routes")) == null || optJSONArray.length() <= 0) {
                        return false;
                    } else {
                        RouteNode a = a(optJSONObject2, "origin", "originPt");
                        RouteNode a2 = a(optJSONObject2, "destination", "destinationPt");
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            BikingRouteLine bikingRouteLine = new BikingRouteLine();
                            try {
                                optJSONObject = optJSONArray.optJSONObject(i);
                            } catch (Exception unused) {
                            }
                            if (optJSONObject == null) {
                                return false;
                            }
                            bikingRouteLine.setStarting(a);
                            bikingRouteLine.setTerminal(a2);
                            bikingRouteLine.setDistance(optJSONObject.optInt("distance"));
                            bikingRouteLine.setDuration(optJSONObject.optInt("duration"));
                            bikingRouteLine.setSteps(a(optJSONObject.optJSONArray("steps")));
                            arrayList.add(bikingRouteLine);
                        }
                        bikingRouteResult.setRouteLines(arrayList);
                    }
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private SuggestAddrInfo b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            SuggestAddrInfo suggestAddrInfo = new SuggestAddrInfo();
            JSONObject optJSONObject = jSONObject.optJSONObject("origin");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("destination");
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("listType");
                String optString = optJSONObject.optString("cityName");
                if (optInt == 1) {
                    suggestAddrInfo.setSuggestStartCity(a(optJSONObject, "content"));
                } else if (optInt == 0) {
                    suggestAddrInfo.setSuggestStartNode(b(optJSONObject, "content", optString));
                }
            }
            if (optJSONObject2 != null) {
                int optInt2 = optJSONObject2.optInt("listType");
                String optString2 = optJSONObject2.optString("cityName");
                if (optInt2 == 1) {
                    suggestAddrInfo.setSuggestEndCity(a(optJSONObject2, "content"));
                } else if (optInt2 == 0) {
                    suggestAddrInfo.setSuggestEndNode(b(optJSONObject2, "content", optString2));
                }
            }
            return suggestAddrInfo;
        }
        return (SuggestAddrInfo) invokeL.objValue;
    }

    private List<PoiInfo> b(JSONObject jSONObject, String str, String str2) {
        InterceptResult invokeLLL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, this, jSONObject, str, str2)) == null) {
            if (jSONObject != null && str != null && !"".equals(str) && (optJSONArray = jSONObject.optJSONArray(str)) != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                    if (jSONObject2 != null) {
                        PoiInfo poiInfo = new PoiInfo();
                        if (jSONObject2.has("address")) {
                            poiInfo.address = jSONObject2.optString("address");
                        }
                        poiInfo.uid = jSONObject2.optString("uid");
                        poiInfo.name = jSONObject2.optString("name");
                        JSONObject optJSONObject = jSONObject2.optJSONObject("location");
                        if (optJSONObject != null) {
                            poiInfo.location = new LatLng(optJSONObject.optDouble(SuggestAddrField.KEY_LAT), optJSONObject.optDouble(SuggestAddrField.KEY_LNG));
                            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                                poiInfo.location = CoordTrans.baiduToGcj(poiInfo.location);
                            }
                        }
                        poiInfo.city = str2;
                        arrayList.add(poiInfo);
                    }
                }
                if (arrayList.size() > 0) {
                    return arrayList;
                }
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            BikingRouteResult bikingRouteResult = new BikingRouteResult();
            if (str != null && !str.equals("")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("SDK_InnerError")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                        if (optJSONObject.has("PermissionCheckError")) {
                            bikingRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                            return bikingRouteResult;
                        } else if (optJSONObject.has("httpStateError")) {
                            String optString = optJSONObject.optString("httpStateError");
                            bikingRouteResult.error = optString.equals("NETWORK_ERROR") ? SearchResult.ERRORNO.NETWORK_ERROR : optString.equals("REQUEST_ERROR") ? SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                            return bikingRouteResult;
                        }
                    }
                    if (!a(str, (SearchResult) bikingRouteResult, false) && !a(str, bikingRouteResult)) {
                        bikingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    }
                    return bikingRouteResult;
                } catch (Exception unused) {
                }
            }
            bikingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return bikingRouteResult;
        }
        return (SearchResult) invokeL.objValue;
    }

    public List<CityInfo> a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, str)) == null) {
            if (jSONObject == null || str == null || str.equals("") || (optJSONArray = jSONObject.optJSONArray(str)) == null || optJSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                if (jSONObject2 != null) {
                    CityInfo cityInfo = new CityInfo();
                    cityInfo.num = jSONObject2.optInt("number");
                    cityInfo.city = jSONObject2.optString("name");
                    arrayList.add(cityInfo);
                }
            }
            arrayList.trimToSize();
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, searchResult, obj) == null) && obj != null && (obj instanceof OnGetRoutePlanResultListener)) {
            ((OnGetRoutePlanResultListener) obj).onGetBikingRouteResult((BikingRouteResult) searchResult);
        }
    }
}
