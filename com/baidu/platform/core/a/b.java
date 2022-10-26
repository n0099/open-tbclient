package com.baidu.platform.core.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.baidu.mobstat.Config;
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
        JSONArray jSONArray;
        JSONArray optJSONArray2;
        int length;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, districtResult)) == null) {
            if (str == null || "".equals(str) || districtResult == null) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject2 = jSONObject.optJSONObject(TiebaStatic.LogFields.RESULT);
                JSONObject optJSONObject3 = jSONObject.optJSONObject("city_result");
                if (optJSONObject2 == null || optJSONObject3 == null) {
                    return false;
                }
                if (optJSONObject2.optInt("error") == 0 && (optJSONObject = optJSONObject3.optJSONObject("content")) != null) {
                    JSONObject optJSONObject4 = optJSONObject.optJSONObject("sgeo");
                    if (optJSONObject4 != null && (optJSONArray = optJSONObject4.optJSONArray("geo_elements")) != null && optJSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        int i2 = 0;
                        while (i2 < optJSONArray.length()) {
                            JSONObject optJSONObject5 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject5 == null || (optJSONArray2 = optJSONObject5.optJSONArray(Config.EVENT_HEAT_POINT)) == null || (length = optJSONArray2.length()) <= 0) {
                                jSONArray = optJSONArray;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                int i3 = 0;
                                int i4 = 0;
                                int i5 = 0;
                                while (i3 < length) {
                                    int optInt = optJSONArray2.optInt(i3);
                                    if (i3 % 2 == 0) {
                                        i5 += optInt;
                                        jSONArray2 = optJSONArray;
                                        jSONArray3 = optJSONArray2;
                                        i = length;
                                    } else {
                                        i4 += optInt;
                                        jSONArray2 = optJSONArray;
                                        jSONArray3 = optJSONArray2;
                                        i = length;
                                        arrayList2.add(CoordUtil.mc2ll(new GeoPoint(i4, i5)));
                                    }
                                    i3++;
                                    optJSONArray = jSONArray2;
                                    optJSONArray2 = jSONArray3;
                                    length = i;
                                }
                                jSONArray = optJSONArray;
                                arrayList.add(arrayList2);
                            }
                            i2++;
                            optJSONArray = jSONArray;
                        }
                        if (arrayList.size() > 0) {
                            districtResult.setPolylines(arrayList);
                            districtResult.setCenterPt(CoordUtil.decodeLocation(optJSONObject.optString("geo")));
                            districtResult.setCityCode(optJSONObject.optInt("code"));
                            districtResult.setCityName(optJSONObject.optString("cname"));
                            districtResult.error = SearchResult.ERRORNO.NO_ERROR;
                            return true;
                        }
                    }
                    districtResult.setCityName(optJSONObject.optString("uid"));
                    this.c = optJSONObject.optString("cname");
                    districtResult.setCenterPt(CoordUtil.decodeLocation(optJSONObject.optString("geo")));
                    districtResult.setCityCode(optJSONObject.optInt("code"));
                    return false;
                }
                return false;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(String str, DistrictResult districtResult) {
        InterceptResult invokeLL;
        List<List> decodeLocationList2D;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, districtResult)) == null) {
            if (str != null && !str.equals("") && districtResult != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject optJSONObject = jSONObject.optJSONObject(TiebaStatic.LogFields.RESULT);
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("content");
                    if (optJSONObject == null || optJSONObject2 == null || optJSONObject.optInt("error") != 0) {
                        return false;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (this.c != null) {
                        try {
                            decodeLocationList2D = CoordUtil.decodeLocationList2D(optJSONObject2.optString("geo"));
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
                            districtResult.error = optString.equals("NETWORK_ERROR") ? SearchResult.ERRORNO.NETWORK_ERROR : optString.equals("REQUEST_ERROR") ? SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                            return districtResult;
                        }
                    }
                    if (!a(str, districtResult, false)) {
                        if (this.b) {
                            b(str, districtResult);
                        } else if (!a(str, districtResult)) {
                            districtResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                        }
                    }
                    return districtResult;
                } catch (Exception unused) {
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
