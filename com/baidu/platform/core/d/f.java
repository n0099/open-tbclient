package com.baidu.platform.core.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.IndoorRouteLine;
import com.baidu.mapapi.search.route.IndoorRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends com.baidu.platform.base.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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

    private LatLng a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, jSONObject, str)) == null) {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray != null) {
                GeoPoint geoPoint = new GeoPoint(0.0d, 0.0d);
                geoPoint.setLatitudeE6(optJSONArray.optDouble(1));
                geoPoint.setLongitudeE6(optJSONArray.optDouble(0));
                return CoordUtil.mc2ll(geoPoint);
            }
            return null;
        }
        return (LatLng) invokeLL.objValue;
    }

    private boolean a(String str, IndoorRouteResult indoorRouteResult) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONArray jSONArray;
        int i2;
        IndoorRouteLine indoorRouteLine;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        String str2;
        int i3;
        IndoorRouteLine indoorRouteLine2;
        String str3;
        String str4;
        String str5;
        SearchResult.ERRORNO errorno;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, indoorRouteResult)) == null) {
            if (str == null || "".equals(str)) {
                return false;
            }
            try {
                JSONObject optJSONObject3 = new JSONObject(str).optJSONObject("indoor_navi");
                if (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("option")) == null) {
                    return false;
                }
                int optInt = optJSONObject.optInt("error");
                if (optInt != 0) {
                    if (optInt == 6) {
                        errorno = SearchResult.ERRORNO.INDOOR_ROUTE_NO_IN_BUILDING;
                    } else if (optInt != 7) {
                        return false;
                    } else {
                        errorno = SearchResult.ERRORNO.INDOOR_ROUTE_NO_IN_SAME_BUILDING;
                    }
                    indoorRouteResult.error = errorno;
                    return true;
                }
                JSONArray optJSONArray = optJSONObject3.optJSONArray("routes");
                if (optJSONArray == null || (optJSONObject2 = optJSONArray.optJSONObject(0)) == null) {
                    return false;
                }
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("legs");
                if (optJSONArray2 == null) {
                    return false;
                }
                int i4 = 0;
                while (i4 < optJSONArray2.length()) {
                    IndoorRouteLine indoorRouteLine3 = new IndoorRouteLine();
                    JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i4);
                    if (optJSONObject4 == null) {
                        jSONArray = optJSONArray2;
                        i2 = i4;
                    } else {
                        String str6 = "distance";
                        indoorRouteLine3.setDistance(optJSONObject4.optInt("distance"));
                        String str7 = "duration";
                        indoorRouteLine3.setDuration(optJSONObject4.optInt("duration"));
                        String str8 = "sstart_location";
                        indoorRouteLine3.setStarting(RouteNode.location(a(optJSONObject4, "sstart_location")));
                        String str9 = "send_location";
                        indoorRouteLine3.setTerminal(RouteNode.location(a(optJSONObject4, "send_location")));
                        JSONArray optJSONArray3 = optJSONObject4.optJSONArray("steps");
                        if (optJSONArray3 != null) {
                            ArrayList arrayList2 = new ArrayList();
                            int i5 = 0;
                            while (i5 < optJSONArray3.length()) {
                                IndoorRouteLine.IndoorRouteStep indoorRouteStep = new IndoorRouteLine.IndoorRouteStep();
                                JSONObject optJSONObject5 = optJSONArray3.optJSONObject(i5);
                                if (optJSONObject5 != null) {
                                    indoorRouteStep.setDistance(optJSONObject5.optInt(str6));
                                    indoorRouteStep.setDuration(optJSONObject5.optInt(str7));
                                    indoorRouteStep.setBuildingId(optJSONObject5.optString("buildingid"));
                                    indoorRouteStep.setFloorId(optJSONObject5.optString("floorid"));
                                    indoorRouteStep.setEntrace(RouteNode.location(a(optJSONObject5, str8)));
                                    indoorRouteStep.setExit(RouteNode.location(a(optJSONObject5, str9)));
                                    JSONArray optJSONArray4 = optJSONObject5.optJSONArray("spath");
                                    if (optJSONArray4 != null) {
                                        jSONArray2 = optJSONArray2;
                                        ArrayList arrayList3 = new ArrayList();
                                        jSONArray3 = optJSONArray3;
                                        str2 = str6;
                                        int i6 = 5;
                                        double d2 = 0.0d;
                                        double d3 = 0.0d;
                                        while (i6 < optJSONArray4.length()) {
                                            double optDouble = d2 + optJSONArray4.optDouble(i6 + 1);
                                            String str10 = str8;
                                            double optDouble2 = d3 + optJSONArray4.optDouble(i6);
                                            JSONArray jSONArray4 = optJSONArray4;
                                            GeoPoint geoPoint = new GeoPoint(0.0d, 0.0d);
                                            geoPoint.setLatitudeE6(optDouble);
                                            geoPoint.setLongitudeE6(optDouble2);
                                            LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
                                            arrayList3.add(Double.valueOf(mc2ll.latitude));
                                            arrayList3.add(Double.valueOf(mc2ll.longitude));
                                            i6 += 2;
                                            optJSONArray4 = jSONArray4;
                                            i4 = i4;
                                            indoorRouteLine3 = indoorRouteLine3;
                                            d2 = optDouble;
                                            d3 = optDouble2;
                                            str7 = str7;
                                            str8 = str10;
                                            str9 = str9;
                                        }
                                        i3 = i4;
                                        indoorRouteLine2 = indoorRouteLine3;
                                        str3 = str7;
                                        str4 = str8;
                                        str5 = str9;
                                        indoorRouteStep.setPath(arrayList3);
                                        indoorRouteStep.setInstructions(optJSONObject5.optString("instructions"));
                                        JSONArray optJSONArray5 = optJSONObject5.optJSONArray("pois");
                                        if (optJSONArray5 != null) {
                                            ArrayList arrayList4 = new ArrayList();
                                            for (int i7 = 0; i7 < optJSONArray5.length(); i7++) {
                                                JSONObject optJSONObject6 = optJSONArray5.optJSONObject(i7);
                                                if (optJSONObject6 != null) {
                                                    IndoorRouteLine.IndoorRouteStep.IndoorStepNode indoorStepNode = new IndoorRouteLine.IndoorRouteStep.IndoorStepNode();
                                                    indoorStepNode.setDetail(optJSONObject6.optString("detail"));
                                                    indoorStepNode.setName(optJSONObject6.optString("name"));
                                                    indoorStepNode.setType(optJSONObject6.optInt("type"));
                                                    indoorStepNode.setLocation(a(optJSONObject6, "location"));
                                                    arrayList4.add(indoorStepNode);
                                                }
                                            }
                                            indoorRouteStep.setStepNodes(arrayList4);
                                        }
                                        arrayList2.add(indoorRouteStep);
                                        i5++;
                                        optJSONArray2 = jSONArray2;
                                        str7 = str3;
                                        str6 = str2;
                                        optJSONArray3 = jSONArray3;
                                        i4 = i3;
                                        indoorRouteLine3 = indoorRouteLine2;
                                        str8 = str4;
                                        str9 = str5;
                                    }
                                }
                                jSONArray2 = optJSONArray2;
                                i3 = i4;
                                indoorRouteLine2 = indoorRouteLine3;
                                jSONArray3 = optJSONArray3;
                                str2 = str6;
                                str3 = str7;
                                str4 = str8;
                                str5 = str9;
                                i5++;
                                optJSONArray2 = jSONArray2;
                                str7 = str3;
                                str6 = str2;
                                optJSONArray3 = jSONArray3;
                                i4 = i3;
                                indoorRouteLine3 = indoorRouteLine2;
                                str8 = str4;
                                str9 = str5;
                            }
                            jSONArray = optJSONArray2;
                            i2 = i4;
                            IndoorRouteLine indoorRouteLine4 = indoorRouteLine3;
                            if (arrayList2.size() > 0) {
                                indoorRouteLine = indoorRouteLine4;
                                indoorRouteLine.setSteps(arrayList2);
                            } else {
                                indoorRouteLine = indoorRouteLine4;
                            }
                        } else {
                            jSONArray = optJSONArray2;
                            i2 = i4;
                            indoorRouteLine = indoorRouteLine3;
                        }
                        arrayList.add(indoorRouteLine);
                    }
                    i4 = i2 + 1;
                    optJSONArray2 = jSONArray;
                }
                indoorRouteResult.setRouteLines(arrayList);
                return true;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            IndoorRouteResult indoorRouteResult = new IndoorRouteResult();
            if (str != null && !str.equals("")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("SDK_InnerError")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                        if (optJSONObject.has("PermissionCheckError")) {
                            indoorRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                            return indoorRouteResult;
                        } else if (optJSONObject.has("httpStateError")) {
                            String optString = optJSONObject.optString("httpStateError");
                            indoorRouteResult.error = optString.equals("NETWORK_ERROR") ? SearchResult.ERRORNO.NETWORK_ERROR : optString.equals("REQUEST_ERROR") ? SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                            return indoorRouteResult;
                        }
                    }
                    if (!a(str, indoorRouteResult)) {
                        indoorRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    }
                    return indoorRouteResult;
                } catch (Exception unused) {
                }
            }
            indoorRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return indoorRouteResult;
        }
        return (SearchResult) invokeL.objValue;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, searchResult, obj) == null) && obj != null && (obj instanceof OnGetRoutePlanResultListener)) {
            ((OnGetRoutePlanResultListener) obj).onGetIndoorRouteResult((IndoorRouteResult) searchResult);
        }
    }
}
