package com.baidu.platform.core.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiIndoorInfo;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends com.baidu.platform.base.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
            }
        }
    }

    private boolean a(String str, PoiIndoorResult poiIndoorResult) {
        InterceptResult invokeLL;
        SearchResult.ERRORNO errorno;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, poiIndoorResult)) == null) {
            if (str != null && !"".equals(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errNo");
                    if (optInt == 0) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject == null) {
                            return false;
                        }
                        JSONArray optJSONArray = optJSONObject.optJSONArray("poi_list");
                        if (optJSONArray == null || optJSONArray.length() <= 0) {
                            poiIndoorResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                        } else {
                            ArrayList arrayList = new ArrayList();
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                                if (jSONObject2 != null) {
                                    PoiIndoorInfo poiIndoorInfo = new PoiIndoorInfo();
                                    poiIndoorInfo.address = jSONObject2.optString("address");
                                    poiIndoorInfo.bid = jSONObject2.optString("bd_id");
                                    poiIndoorInfo.cid = jSONObject2.optInt("cid");
                                    poiIndoorInfo.discount = jSONObject2.optInt("discount");
                                    poiIndoorInfo.floor = jSONObject2.optString("floor");
                                    poiIndoorInfo.name = jSONObject2.optString("name");
                                    poiIndoorInfo.phone = jSONObject2.optString("phone");
                                    poiIndoorInfo.price = jSONObject2.optInt("price");
                                    poiIndoorInfo.starLevel = jSONObject2.optInt("star_level");
                                    poiIndoorInfo.tag = jSONObject2.optString("tag");
                                    poiIndoorInfo.uid = jSONObject2.optString("uid");
                                    poiIndoorInfo.groupNum = jSONObject2.optInt("tuan_nums");
                                    int parseInt = Integer.parseInt(jSONObject2.optString("twp"));
                                    if ((parseInt & 1) == 1) {
                                        poiIndoorInfo.isGroup = true;
                                    }
                                    if ((parseInt & 2) == 1) {
                                        poiIndoorInfo.isTakeOut = true;
                                    }
                                    if ((parseInt & 4) == 1) {
                                        poiIndoorInfo.isWaited = true;
                                    }
                                    poiIndoorInfo.latLng = CoordUtil.mc2ll(new GeoPoint(jSONObject2.optDouble("pt_y"), jSONObject2.optDouble("pt_x")));
                                    arrayList.add(poiIndoorInfo);
                                }
                            }
                            poiIndoorResult.error = SearchResult.ERRORNO.NO_ERROR;
                            poiIndoorResult.setmArrayPoiInfo(arrayList);
                        }
                        poiIndoorResult.pageNum = optJSONObject.optInt(SuggestAddrField.KEY_PAGE_NUM);
                        poiIndoorResult.poiNum = optJSONObject.optInt("poi_num");
                        errorno = SearchResult.ERRORNO.NO_ERROR;
                    } else if (optInt != 1) {
                        if (optInt != 5) {
                            errorno = SearchResult.ERRORNO.POIINDOOR_SERVER_ERROR;
                        }
                        return false;
                    } else {
                        String optString = jSONObject.optString("Msg");
                        if (!optString.contains("bid")) {
                            if (optString.contains("floor")) {
                                errorno = SearchResult.ERRORNO.POIINDOOR_FLOOR_ERROR;
                            }
                            return false;
                        }
                        errorno = SearchResult.ERRORNO.POIINDOOR_BID_ERROR;
                    }
                    poiIndoorResult.error = errorno;
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
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
            PoiIndoorResult poiIndoorResult = new PoiIndoorResult();
            if (str != null && !str.equals("")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("SDK_InnerError")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                        if (optJSONObject.has("PermissionCheckError")) {
                            poiIndoorResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                            return poiIndoorResult;
                        } else if (optJSONObject.has("httpStateError")) {
                            String optString = optJSONObject.optString("httpStateError");
                            poiIndoorResult.error = optString.equals("NETWORK_ERROR") ? SearchResult.ERRORNO.NETWORK_ERROR : optString.equals("REQUEST_ERROR") ? SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                            return poiIndoorResult;
                        }
                    }
                    if (!a(str, poiIndoorResult, false) && !a(str, poiIndoorResult)) {
                        poiIndoorResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    }
                    return poiIndoorResult;
                } catch (Exception unused) {
                }
            }
            poiIndoorResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return poiIndoorResult;
        }
        return (SearchResult) invokeL.objValue;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, searchResult, obj) == null) && obj != null && (obj instanceof OnGetPoiSearchResultListener)) {
            ((OnGetPoiSearchResultListener) obj).onGetPoiIndoorResult((PoiIndoorResult) searchResult);
        }
    }
}
