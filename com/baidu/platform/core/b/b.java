package com.baidu.platform.core.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
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
/* loaded from: classes3.dex */
public class b extends com.baidu.platform.base.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public String c;

    public b() {
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
        this.b = false;
        this.c = null;
    }

    private boolean a(String str, DistrictResult districtResult) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, districtResult)) == null) {
            if (str == null || "".equals(str) || districtResult == null) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("result");
                JSONObject optJSONObject3 = jSONObject.optJSONObject("city_result");
                if (optJSONObject2 == null || optJSONObject3 == null) {
                    return false;
                }
                if (optJSONObject2.optInt("error") != 0 || (optJSONObject = optJSONObject3.optJSONObject("content")) == null) {
                    return false;
                }
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("sgeo");
                if (optJSONObject4 != null && (optJSONArray = optJSONObject4.optJSONArray("geo_elements")) != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject5 = optJSONArray.optJSONObject(i);
                        if (optJSONObject5 != null && (optJSONArray2 = optJSONObject5.optJSONArray(Config.EVENT_HEAT_POINT)) != null && (length = optJSONArray2.length()) > 0) {
                            ArrayList arrayList2 = new ArrayList();
                            int i2 = 0;
                            int i3 = 0;
                            for (int i4 = 0; i4 < length; i4++) {
                                int optInt = optJSONArray2.optInt(i4);
                                if (i4 % 2 == 0) {
                                    i3 += optInt;
                                } else {
                                    i2 += optInt;
                                    arrayList2.add(CoordUtil.mc2ll(new GeoPoint(i2, i3)));
                                }
                            }
                            arrayList.add(arrayList2);
                        }
                    }
                    if (arrayList.size() > 0) {
                        districtResult.setPolylines(arrayList);
                        districtResult.setCenterPt(CoordUtil.decodeLocation(optJSONObject.optString(MapBundleKey.MapObjKey.OBJ_GEO)));
                        districtResult.setCityCode(optJSONObject.optInt("code"));
                        districtResult.setCityName(optJSONObject.optString("cname"));
                        districtResult.error = SearchResult.ERRORNO.NO_ERROR;
                        return true;
                    }
                }
                districtResult.setCityName(optJSONObject.optString("uid"));
                this.c = optJSONObject.optString("cname");
                districtResult.setCenterPt(CoordUtil.decodeLocation(optJSONObject.optString(MapBundleKey.MapObjKey.OBJ_GEO)));
                districtResult.setCityCode(optJSONObject.optInt("code"));
                return false;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(String str, DistrictResult districtResult) {
        InterceptResult invokeLL;
        List<List<LatLng>> decodeLocationList2D;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, districtResult)) == null) {
            if (str != null && !str.equals("") && districtResult != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject optJSONObject = jSONObject.optJSONObject("result");
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("content");
                    if (optJSONObject == null || optJSONObject2 == null || optJSONObject.optInt("error") != 0) {
                        return false;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (this.c != null) {
                        try {
                            decodeLocationList2D = CoordUtil.decodeLocationList2D(optJSONObject2.optString(MapBundleKey.MapObjKey.OBJ_GEO));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (decodeLocationList2D != null) {
                            for (List<LatLng> list : decodeLocationList2D) {
                                ArrayList arrayList2 = new ArrayList();
                                for (LatLng latLng : list) {
                                    arrayList2.add(latLng);
                                }
                                arrayList.add(arrayList2);
                            }
                        }
                        if (arrayList.size() > 0) {
                            districtResult.setPolylines(arrayList);
                        }
                        districtResult.setCityName(this.c);
                        districtResult.error = SearchResult.ERRORNO.NO_ERROR;
                        this.c = null;
                        return true;
                    }
                    decodeLocationList2D = null;
                    if (decodeLocationList2D != null) {
                    }
                    if (arrayList.size() > 0) {
                    }
                    districtResult.setCityName(this.c);
                    districtResult.error = SearchResult.ERRORNO.NO_ERROR;
                    this.c = null;
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            DistrictResult districtResult = new DistrictResult();
            if (str != null && !str.equals("")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("SDK_InnerError")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                        if (optJSONObject.has("PermissionCheckError")) {
                            districtResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                            return districtResult;
                        } else if (optJSONObject.has("httpStateError")) {
                            String optString = optJSONObject.optString("httpStateError");
                            if (optString.equals("NETWORK_ERROR")) {
                                districtResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                            } else if (optString.equals("REQUEST_ERROR")) {
                                districtResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                            } else {
                                districtResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                            }
                            return districtResult;
                        }
                    }
                    if (!a(str, districtResult, false)) {
                        if (!this.b) {
                            if (!a(str, districtResult)) {
                                districtResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                            }
                        } else {
                            b(str, districtResult);
                        }
                    }
                    return districtResult;
                } catch (Exception unused) {
                    districtResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return districtResult;
                }
            }
            districtResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return districtResult;
        }
        return (SearchResult) invokeL.objValue;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, searchResult, obj) == null) && obj != null && (obj instanceof OnGetDistricSearchResultListener)) {
            ((OnGetDistricSearchResultListener) obj).onGetDistrictResult((DistrictResult) searchResult);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.b = z;
        }
    }
}
