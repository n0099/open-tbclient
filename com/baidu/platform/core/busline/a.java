package com.baidu.platform.core.busline;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.busline.BusLineResult;
import com.baidu.mapapi.search.busline.OnGetBusLineSearchResultListener;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.platform.base.d;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            BusLineResult busLineResult = new BusLineResult();
            if (str != null && !str.equals("")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("SDK_InnerError")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                        if (optJSONObject.has("PermissionCheckError")) {
                            busLineResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                            return busLineResult;
                        } else if (optJSONObject.has("httpStateError")) {
                            String optString = optJSONObject.optString("httpStateError");
                            busLineResult.error = optString.equals("NETWORK_ERROR") ? SearchResult.ERRORNO.NETWORK_ERROR : optString.equals("REQUEST_ERROR") ? SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                            return busLineResult;
                        }
                    }
                    if (!a(str, busLineResult, false) && !a(str, busLineResult)) {
                        busLineResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    }
                    return busLineResult;
                } catch (Exception unused) {
                }
            }
            busLineResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return busLineResult;
        }
        return (SearchResult) invokeL.objValue;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, searchResult, obj) == null) && obj != null && (obj instanceof OnGetBusLineSearchResultListener)) {
            ((OnGetBusLineSearchResultListener) obj).onGetBusLineResult((BusLineResult) searchResult);
        }
    }

    public boolean a(String str, BusLineResult busLineResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, busLineResult)) == null) {
            if (str != null && !"".equals(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject optJSONObject = jSONObject.optJSONObject("result");
                    JSONArray optJSONArray = jSONObject.optJSONArray("content");
                    if (optJSONObject == null || optJSONArray == null || optJSONArray.length() <= 0) {
                        return false;
                    }
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(0);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                    try {
                        busLineResult.setStartTime(simpleDateFormat.parse(optJSONObject2.optString(FetchLog.START_TIME)));
                        busLineResult.setEndTime(simpleDateFormat.parse(optJSONObject2.optString(FetchLog.END_TIME)));
                    } catch (ParseException e2) {
                        e2.printStackTrace();
                    }
                    busLineResult.setBusLineName(optJSONObject2.optString("name"));
                    busLineResult.setMonthTicket(optJSONObject2.optInt("isMonTicket") == 1);
                    busLineResult.setUid(optJSONObject2.optString("uid"));
                    busLineResult.setBasePrice(optJSONObject2.optInt("ticketPrice") / 100.0f);
                    busLineResult.setLineDirection(optJSONObject2.optString("line_direction"));
                    busLineResult.setMaxPrice(optJSONObject2.optInt("maxPrice") / 100.0f);
                    ArrayList arrayList = new ArrayList();
                    List<List<LatLng>> decodeLocationList2D = CoordUtil.decodeLocationList2D(optJSONObject2.optString("geo"));
                    if (decodeLocationList2D != null) {
                        for (List<LatLng> list : decodeLocationList2D) {
                            BusLineResult.BusStep busStep = new BusLineResult.BusStep();
                            busStep.setWayPoints(list);
                            arrayList.add(busStep);
                        }
                    }
                    if (arrayList.size() > 0) {
                        busLineResult.setSteps(arrayList);
                    }
                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray("stations");
                    if (optJSONArray2 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                            if (optJSONObject3 != null) {
                                BusLineResult.BusStation busStation = new BusLineResult.BusStation();
                                busStation.setTitle(optJSONObject3.optString("name"));
                                busStation.setLocation(CoordUtil.decodeLocation(optJSONObject3.optString("geo")));
                                busStation.setUid(optJSONObject3.optString("uid"));
                                arrayList2.add(busStation);
                            }
                        }
                        if (arrayList2.size() > 0) {
                            busLineResult.setStations(arrayList2);
                        }
                    }
                    busLineResult.error = SearchResult.ERRORNO.NO_ERROR;
                    return true;
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
