package com.baidu.platform.core.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiDetailInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d extends com.baidu.platform.base.d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f44212b = "d";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public boolean f44213c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2056823067, "Lcom/baidu/platform/core/c/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2056823067, "Lcom/baidu/platform/core/c/d;");
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f44213c = false;
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
            return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(new LatLng(optDouble, optDouble2)) : new LatLng(optDouble, optDouble2);
        }
        return (LatLng) invokeL.objValue;
    }

    private boolean a(String str, SearchResult searchResult) {
        InterceptResult invokeLL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, searchResult)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() != 0 && jSONObject.optInt("status") == 0 && (optJSONArray = jSONObject.optJSONArray("result")) != null && optJSONArray.length() != 0) {
                    return this.f44213c ? a(optJSONArray, (PoiDetailSearchResult) searchResult) : a(optJSONArray, (PoiDetailResult) searchResult);
                }
            } catch (JSONException unused) {
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private boolean a(JSONArray jSONArray, PoiDetailResult poiDetailResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONArray, poiDetailResult)) == null) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(0);
            if (jSONObject == null || jSONObject.length() == 0) {
                return false;
            }
            poiDetailResult.setName(jSONObject.optString("name"));
            poiDetailResult.setLocation(a(jSONObject.optJSONObject("location")));
            poiDetailResult.setAddress(jSONObject.optString("address"));
            poiDetailResult.setTelephone(jSONObject.optString("telephone"));
            poiDetailResult.setUid(jSONObject.optString("uid"));
            JSONObject optJSONObject = jSONObject.optJSONObject("detail_info");
            if (optJSONObject != null && optJSONObject.length() != 0) {
                poiDetailResult.setTag(optJSONObject.optString("tag"));
                poiDetailResult.setDetailUrl(optJSONObject.optString("detail_url"));
                poiDetailResult.setType(optJSONObject.optString("type"));
                poiDetailResult.setPrice(optJSONObject.optDouble("price", 0.0d));
                poiDetailResult.setOverallRating(optJSONObject.optDouble("overall_rating", 0.0d));
                poiDetailResult.setTasteRating(optJSONObject.optDouble("taste_rating", 0.0d));
                poiDetailResult.setServiceRating(optJSONObject.optDouble("service_rating", 0.0d));
                poiDetailResult.setEnvironmentRating(optJSONObject.optDouble("environment_rating", 0.0d));
                poiDetailResult.setFacilityRating(optJSONObject.optDouble("facility_rating", 0.0d));
                poiDetailResult.setHygieneRating(optJSONObject.optDouble("hygiene_rating", 0.0d));
                poiDetailResult.setTechnologyRating(optJSONObject.optDouble("technology_rating", 0.0d));
                poiDetailResult.setImageNum(optJSONObject.optInt("image_num"));
                poiDetailResult.setGrouponNum(optJSONObject.optInt("groupon_num", 0));
                poiDetailResult.setCommentNum(optJSONObject.optInt("comment_num", 0));
                poiDetailResult.setDiscountNum(optJSONObject.optInt("discount_num", 0));
                poiDetailResult.setFavoriteNum(optJSONObject.optInt("favorite_num", 0));
                poiDetailResult.setCheckinNum(optJSONObject.optInt("checkin_num", 0));
                poiDetailResult.setShopHours(optJSONObject.optString("shop_hours"));
            }
            poiDetailResult.error = SearchResult.ERRORNO.NO_ERROR;
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean a(JSONArray jSONArray, PoiDetailSearchResult poiDetailSearchResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, jSONArray, poiDetailSearchResult)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i2);
                if (jSONObject != null && jSONObject.length() != 0) {
                    PoiDetailInfo poiDetailInfo = new PoiDetailInfo();
                    poiDetailInfo.setName(jSONObject.optString("name"));
                    poiDetailInfo.setLocation(a(jSONObject.optJSONObject("location")));
                    poiDetailInfo.setAddress(jSONObject.optString("address"));
                    poiDetailInfo.setProvince(jSONObject.optString("province"));
                    poiDetailInfo.setCity(jSONObject.optString("city"));
                    poiDetailInfo.setArea(jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                    poiDetailInfo.setTelephone(jSONObject.optString("telephone"));
                    poiDetailInfo.setUid(jSONObject.optString("uid"));
                    poiDetailInfo.setStreetId(jSONObject.optString("setStreetId"));
                    poiDetailInfo.setDetail(jSONObject.optString("detail"));
                    JSONObject optJSONObject = jSONObject.optJSONObject("detail_info");
                    if (optJSONObject != null && optJSONObject.length() != 0) {
                        poiDetailInfo.setDistance(optJSONObject.optInt("distance", 0));
                        poiDetailInfo.setType(optJSONObject.optString("type"));
                        poiDetailInfo.setTag(optJSONObject.optString("tag"));
                        poiDetailInfo.setDetailUrl(optJSONObject.optString("detail_url"));
                        poiDetailInfo.setPrice(optJSONObject.optDouble("price", 0.0d));
                        poiDetailInfo.setShopHours(optJSONObject.optString("shop_hours"));
                        poiDetailInfo.setOverallRating(optJSONObject.optDouble("overall_rating", 0.0d));
                        poiDetailInfo.setTasteRating(optJSONObject.optDouble("taste_rating", 0.0d));
                        poiDetailInfo.setServiceRating(optJSONObject.optDouble("service_rating", 0.0d));
                        poiDetailInfo.setEnvironmentRating(optJSONObject.optDouble("environment_rating", 0.0d));
                        poiDetailInfo.setFacilityRating(optJSONObject.optDouble("facility_rating", 0.0d));
                        poiDetailInfo.setHygieneRating(optJSONObject.optDouble("hygiene_rating", 0.0d));
                        poiDetailInfo.setTechnologyRating(optJSONObject.optDouble("technology_rating", 0.0d));
                        poiDetailInfo.setImageNum(optJSONObject.optInt("image_num"));
                        poiDetailInfo.setGrouponNum(optJSONObject.optInt("groupon_num", 0));
                        poiDetailInfo.setCommentNum(optJSONObject.optInt("comment_num", 0));
                        poiDetailInfo.setDiscountNum(optJSONObject.optInt("discount_num", 0));
                        poiDetailInfo.setFavoriteNum(optJSONObject.optInt("favorite_num", 0));
                        poiDetailInfo.setCheckinNum(optJSONObject.optInt("checkin_num", 0));
                    }
                    arrayList.add(poiDetailInfo);
                }
            }
            poiDetailSearchResult.setPoiDetailInfoList(arrayList);
            poiDetailSearchResult.error = SearchResult.ERRORNO.NO_ERROR;
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        InterceptResult invokeL;
        SearchResult.ERRORNO errorno;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SearchResult poiDetailSearchResult = this.f44213c ? new PoiDetailSearchResult() : new PoiDetailResult();
            if (str != null && !str.isEmpty()) {
                try {
                    jSONObject = new JSONObject(str);
                } catch (JSONException unused) {
                }
                if (jSONObject.length() == 0) {
                    poiDetailSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return poiDetailSearchResult;
                } else if (!jSONObject.has("SDK_InnerError")) {
                    if (!a(str, poiDetailSearchResult)) {
                        poiDetailSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    }
                    return poiDetailSearchResult;
                } else {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject != null && optJSONObject.length() != 0) {
                        if (optJSONObject.has("PermissionCheckError")) {
                            errorno = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                            poiDetailSearchResult.error = errorno;
                            return poiDetailSearchResult;
                        }
                        if (optJSONObject.has("httpStateError")) {
                            String optString = optJSONObject.optString("httpStateError");
                            char c2 = 65535;
                            int hashCode = optString.hashCode();
                            if (hashCode != -879828873) {
                                if (hashCode == 1470557208 && optString.equals("REQUEST_ERROR")) {
                                    c2 = 1;
                                }
                            } else if (optString.equals("NETWORK_ERROR")) {
                                c2 = 0;
                            }
                            poiDetailSearchResult.error = c2 != 0 ? c2 != 1 ? SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR : SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.NETWORK_ERROR;
                        }
                        return poiDetailSearchResult;
                    }
                }
            }
            errorno = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            poiDetailSearchResult.error = errorno;
            return poiDetailSearchResult;
        }
        return (SearchResult) invokeL.objValue;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, searchResult, obj) == null) && obj != null && (obj instanceof OnGetPoiSearchResultListener)) {
            OnGetPoiSearchResultListener onGetPoiSearchResultListener = (OnGetPoiSearchResultListener) obj;
            if (this.f44213c) {
                onGetPoiSearchResultListener.onGetPoiDetailResult((PoiDetailSearchResult) searchResult);
            } else {
                onGetPoiSearchResultListener.onGetPoiDetailResult((PoiDetailResult) searchResult);
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f44213c = z;
        }
    }
}
