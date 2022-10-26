package com.baidu.platform.core.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.SuggestAddrInfo;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.baidu.platform.base.SearchType;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
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
public class k extends com.baidu.platform.base.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SuggestAddrInfo b;
    public boolean c;

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
    }

    private SuggestAddrInfo a(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONObject)) == null) {
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("traffic_pois")) == null) {
                return null;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(SpeedStatsUtils.UBC_KEY_OPTION);
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("content");
            if (optJSONObject2 != null && optJSONObject3 != null) {
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("start_city");
                String optString = optJSONObject4 != null ? optJSONObject4.optString("cname") : null;
                JSONArray optJSONArray = optJSONObject2.optJSONArray("end_city");
                String optString2 = (optJSONArray == null || (jSONObject2 = (JSONObject) optJSONArray.opt(0)) == null) ? null : jSONObject2.optString("cname");
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("city_list");
                JSONArray optJSONArray3 = optJSONObject2.optJSONArray("prio_flag");
                if (optJSONArray2 != null && optJSONArray3 != null) {
                    int length = optJSONArray2.length();
                    boolean[] zArr = new boolean[length];
                    boolean[] zArr2 = new boolean[length];
                    for (int i = 0; i < length; i++) {
                        int parseInt = Integer.parseInt(optJSONArray2.optString(i));
                        int parseInt2 = Integer.parseInt(optJSONArray3.optString(i));
                        boolean z = true;
                        zArr[i] = parseInt == 1;
                        if (parseInt2 != 1) {
                            z = false;
                        }
                        zArr2[i] = z;
                    }
                    SuggestAddrInfo suggestAddrInfo = new SuggestAddrInfo();
                    for (int i2 = 0; i2 < length; i2++) {
                        if (!zArr2[i2]) {
                            if (zArr[i2]) {
                                if (i2 == 0) {
                                    suggestAddrInfo.setSuggestStartCity(a(optJSONObject3.optJSONArray("start")));
                                } else if (i2 != length - 1 || i2 <= 0) {
                                    suggestAddrInfo.setSuggestWpCity(a(optJSONObject3, "multi_waypoints"));
                                } else {
                                    suggestAddrInfo.setSuggestEndCity(a(optJSONObject3.optJSONArray("end")));
                                }
                            } else if (i2 == 0) {
                                suggestAddrInfo.setSuggestStartNode(a(optJSONObject3.optJSONArray("start"), optString));
                            } else if (i2 != length - 1 || i2 <= 0) {
                                suggestAddrInfo.setSuggestWpNode(b(optJSONObject3, "multi_waypoints"));
                            } else {
                                suggestAddrInfo.setSuggestEndNode(a(optJSONObject3.optJSONArray("end"), optString2));
                            }
                        }
                    }
                    return suggestAddrInfo;
                }
            }
            return null;
        }
        return (SuggestAddrInfo) invokeL.objValue;
    }

    private List a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                if (jSONObject != null) {
                    CityInfo cityInfo = new CityInfo();
                    cityInfo.num = jSONObject.optInt("num");
                    cityInfo.city = jSONObject.optString("name");
                    arrayList.add(cityInfo);
                }
            }
            arrayList.trimToSize();
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private List a(JSONArray jSONArray, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, jSONArray, str)) == null) {
            if (jSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                    if (jSONObject != null) {
                        PoiInfo poiInfo = new PoiInfo();
                        poiInfo.address = jSONObject.optString(DuPaBInfoMsg.B_ADDR);
                        poiInfo.uid = jSONObject.optString("uid");
                        poiInfo.name = jSONObject.optString("name");
                        poiInfo.location = CoordUtil.decodeLocation(jSONObject.optString("geo"));
                        poiInfo.city = str;
                        arrayList.add(poiInfo);
                    }
                }
                if (arrayList.size() > 0) {
                    return arrayList;
                }
                return null;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    private List a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray(str)) == null) {
                return null;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                List a = a((JSONArray) optJSONArray.opt(i));
                if (a != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    private List b(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, jSONObject, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray(str)) == null) {
                return null;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                List a = a(((JSONObject) optJSONArray.opt(i)).optJSONArray("way_ponits"), "");
                if (a != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    private boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            if (str != null && str.length() > 0) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject optJSONObject = jSONObject.optJSONObject(TiebaStatic.LogFields.RESULT);
                    if (optJSONObject != null && optJSONObject.optInt("type") == 23 && optJSONObject.optInt("error") == 0) {
                        SuggestAddrInfo a = a(jSONObject);
                        this.b = a;
                        return a != null;
                    }
                    return false;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.baidu.mapapi.search.route.DrivingRouteResult */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.mapapi.search.route.WalkingRouteResult */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        InterceptResult invokeL;
        WalkingRouteResult walkingRouteResult;
        WalkingRouteResult walkingRouteResult2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SearchType a = a();
            if (b(str)) {
                this.c = true;
            } else {
                this.c = false;
            }
            int i = l.a[a.ordinal()];
            if (i == 1) {
                TransitRouteResult transitRouteResult = new TransitRouteResult();
                if (this.c) {
                    transitRouteResult.setSuggestAddrInfo(this.b);
                    walkingRouteResult = transitRouteResult;
                    walkingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                    walkingRouteResult2 = walkingRouteResult;
                } else {
                    ((m) this).a(str, transitRouteResult);
                    walkingRouteResult2 = transitRouteResult;
                }
            } else if (i == 2) {
                DrivingRouteResult drivingRouteResult = new DrivingRouteResult();
                if (this.c) {
                    drivingRouteResult.setSuggestAddrInfo(this.b);
                    walkingRouteResult = drivingRouteResult;
                    walkingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                    walkingRouteResult2 = walkingRouteResult;
                } else {
                    ((c) this).a(str, drivingRouteResult);
                    walkingRouteResult2 = drivingRouteResult;
                }
            } else if (i != 3) {
                return null;
            } else {
                WalkingRouteResult walkingRouteResult3 = new WalkingRouteResult();
                if (this.c) {
                    walkingRouteResult3.setSuggestAddrInfo(this.b);
                    walkingRouteResult = walkingRouteResult3;
                    walkingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                    walkingRouteResult2 = walkingRouteResult;
                } else {
                    ((o) this).a(str, walkingRouteResult3);
                    walkingRouteResult2 = walkingRouteResult3;
                }
            }
            return walkingRouteResult2;
        }
        return (SearchResult) invokeL.objValue;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, searchResult, obj) == null) && obj != null && (obj instanceof OnGetRoutePlanResultListener)) {
            OnGetRoutePlanResultListener onGetRoutePlanResultListener = (OnGetRoutePlanResultListener) obj;
            int i = l.a[a().ordinal()];
            if (i == 1) {
                onGetRoutePlanResultListener.onGetTransitRouteResult((TransitRouteResult) searchResult);
            } else if (i == 2) {
                onGetRoutePlanResultListener.onGetDrivingRouteResult((DrivingRouteResult) searchResult);
            } else if (i != 3) {
            } else {
                onGetRoutePlanResultListener.onGetWalkingRouteResult((WalkingRouteResult) searchResult);
            }
        }
    }
}
