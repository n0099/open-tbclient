package com.baidu.platform.core.d;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiChildrenInfo;
import com.baidu.mapapi.search.core.PoiDetailInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.platform.base.SearchType;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
public class g extends com.baidu.platform.base.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String b = "g";
    public transient /* synthetic */ FieldHolder $fh;
    public int c;
    public int d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2056793183, "Lcom/baidu/platform/core/d/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2056793183, "Lcom/baidu/platform/core/d/g;");
        }
    }

    public g(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = i;
        this.d = i2;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, searchResult, obj) == null) && obj != null && (obj instanceof OnGetPoiSearchResultListener)) {
            int i = h.a[a().ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                ((OnGetPoiSearchResultListener) obj).onGetPoiResult((PoiResult) searchResult);
            }
        }
    }

    private LatLng a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            double optDouble = jSONObject.optDouble(SuggestAddrField.KEY_LAT);
            double optDouble2 = jSONObject.optDouble(SuggestAddrField.KEY_LNG);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                return CoordTrans.baiduToGcj(new LatLng(optDouble, optDouble2));
            }
            return new LatLng(optDouble, optDouble2);
        }
        return (LatLng) invokeL.objValue;
    }

    private boolean a(String str, PoiResult poiResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, poiResult)) == null) {
            if (str != null && !str.equals("") && !str.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("status");
                    if (optInt == 0) {
                        return a(jSONObject, poiResult);
                    }
                    if (optInt != 1) {
                        if (optInt != 2) {
                            poiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                        } else {
                            poiResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
                        }
                    } else {
                        poiResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    }
                    return false;
                } catch (JSONException e) {
                    Log.e(b, "Parse poi search failed", e);
                    poiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private boolean a(JSONObject jSONObject, PoiResult poiResult) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject, poiResult)) == null) {
            if (jSONObject != null && jSONObject.length() != 0) {
                poiResult.error = SearchResult.ERRORNO.NO_ERROR;
                JSONArray optJSONArray = jSONObject.optJSONArray("results");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int optInt = jSONObject.optInt("total");
                    poiResult.setTotalPoiNum(optInt);
                    int length = optJSONArray.length();
                    poiResult.setCurrentPageCapacity(length);
                    poiResult.setCurrentPageNum(this.c);
                    if (length != 0) {
                        int i2 = this.d;
                        int i3 = optInt / i2;
                        if (optInt % i2 > 0) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        poiResult.setTotalPageNum(i3 + i);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i4);
                        if (jSONObject2 != null && jSONObject2.length() != 0) {
                            PoiInfo poiInfo = new PoiInfo();
                            poiInfo.setName(jSONObject2.optString("name"));
                            poiInfo.setAddress(jSONObject2.optString("address"));
                            poiInfo.setProvince(jSONObject2.optString("province"));
                            poiInfo.setCity(jSONObject2.optString("city"));
                            poiInfo.setArea(jSONObject2.optString("area"));
                            poiInfo.setStreetId(jSONObject2.optString("street_id"));
                            poiInfo.setUid(jSONObject2.optString("uid"));
                            poiInfo.setPhoneNum(jSONObject2.optString("telephone"));
                            poiInfo.setDetail(jSONObject2.optInt("detail"));
                            poiInfo.setAdCode(jSONObject2.optInt("adcode"));
                            poiInfo.setLocation(a(jSONObject2.optJSONObject("location")));
                            String optString = jSONObject2.optString("detail_info");
                            if (optString != null && optString.length() != 0) {
                                poiInfo.setPoiDetailInfo(b(optString));
                            }
                            arrayList.add(poiInfo);
                        }
                    }
                    poiResult.setPoiInfo(arrayList);
                    return true;
                }
                poiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private PoiDetailInfo b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            PoiDetailInfo poiDetailInfo = new PoiDetailInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() == 0) {
                    return null;
                }
                poiDetailInfo.setDistance(jSONObject.optInt("distance", 0));
                poiDetailInfo.setTag(jSONObject.optString("tag"));
                poiDetailInfo.setDetailUrl(jSONObject.optString("detail_url"));
                poiDetailInfo.setType(jSONObject.optString("type"));
                poiDetailInfo.setPrice(jSONObject.optDouble("price", 0.0d));
                poiDetailInfo.setOverallRating(jSONObject.optDouble("overall_rating", 0.0d));
                poiDetailInfo.setTasteRating(jSONObject.optDouble("taste_rating", 0.0d));
                poiDetailInfo.setServiceRating(jSONObject.optDouble("service_rating", 0.0d));
                poiDetailInfo.setEnvironmentRating(jSONObject.optDouble("environment_rating", 0.0d));
                poiDetailInfo.setFacilityRating(jSONObject.optDouble("facility_rating", 0.0d));
                poiDetailInfo.setHygieneRating(jSONObject.optDouble("hygiene_rating", 0.0d));
                poiDetailInfo.setTechnologyRating(jSONObject.optDouble("technology_rating", 0.0d));
                poiDetailInfo.setImageNum(jSONObject.optInt("image_num"));
                poiDetailInfo.setGrouponNum(jSONObject.optInt("groupon_num"));
                poiDetailInfo.setCommentNum(jSONObject.optInt("comment_num"));
                poiDetailInfo.setDiscountNum(jSONObject.optInt("discount_num"));
                poiDetailInfo.setFavoriteNum(jSONObject.optInt("favorite_num"));
                poiDetailInfo.setCheckinNum(jSONObject.optInt("checkin_num"));
                poiDetailInfo.setShopHours(jSONObject.optString("shop_hours"));
                poiDetailInfo.naviLocation = a(jSONObject.optJSONObject("navi_location"));
                SearchType a = a();
                if (SearchType.b == a || SearchType.a == a) {
                    poiDetailInfo.setPoiChildrenInfoList(b(jSONObject));
                }
                return poiDetailInfo;
            } catch (JSONException e) {
                Log.e(b, "Parse poi search detail info failed", e);
                return null;
            }
        }
        return (PoiDetailInfo) invokeL.objValue;
    }

    private List<PoiChildrenInfo> b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, jSONObject)) == null) {
            JSONArray optJSONArray = jSONObject.optJSONArray(CriusAttrConstants.CHILDREN);
            if (optJSONArray != null && optJSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null && optJSONObject.length() != 0) {
                        PoiChildrenInfo poiChildrenInfo = new PoiChildrenInfo();
                        poiChildrenInfo.setUid(optJSONObject.optString("uid"));
                        poiChildrenInfo.setName(optJSONObject.optString("name"));
                        poiChildrenInfo.setShowName(optJSONObject.optString("show_name"));
                        poiChildrenInfo.setTag(optJSONObject.optString("tag"));
                        poiChildrenInfo.setLocation(a(optJSONObject.optJSONObject("location")));
                        poiChildrenInfo.setAddress(optJSONObject.optString("address"));
                        arrayList.add(poiChildrenInfo);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0067, code lost:
        if (r7.equals("NETWORK_ERROR") != false) goto L27;
     */
    @Override // com.baidu.platform.base.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SearchResult a(String str) {
        InterceptResult invokeL;
        SearchResult.ERRORNO errorno;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            PoiResult poiResult = new PoiResult();
            if (str != null && !str.equals("") && !str.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    char c = 0;
                    if (jSONObject.has("SDK_InnerError")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                        if (optJSONObject.has("PermissionCheckError")) {
                            poiResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                            return poiResult;
                        } else if (optJSONObject.has("httpStateError")) {
                            String optString = optJSONObject.optString("httpStateError");
                            int hashCode = optString.hashCode();
                            if (hashCode != -879828873) {
                                if (hashCode == 1470557208 && optString.equals("REQUEST_ERROR")) {
                                    c = 1;
                                }
                                c = 65535;
                            }
                            if (c != 0) {
                                if (c != 1) {
                                    poiResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                                } else {
                                    poiResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                                }
                            } else {
                                poiResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                            }
                            return poiResult;
                        }
                    }
                    if (a(str, poiResult, false)) {
                        return poiResult;
                    }
                    if (a(str, poiResult)) {
                        errorno = SearchResult.ERRORNO.NO_ERROR;
                    } else {
                        errorno = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    }
                    poiResult.error = errorno;
                    return poiResult;
                } catch (JSONException e) {
                    Log.e(b, "Parse poi search error", e);
                    poiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return poiResult;
                }
            }
            poiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return poiResult;
        }
        return (SearchResult) invokeL.objValue;
    }
}
