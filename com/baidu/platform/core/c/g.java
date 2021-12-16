package com.baidu.platform.core.c;

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
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
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
/* loaded from: classes10.dex */
public class g extends com.baidu.platform.base.d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f38861b = "g";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public int f38862c;

    /* renamed from: d  reason: collision with root package name */
    public int f38863d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2056822974, "Lcom/baidu/platform/core/c/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2056822974, "Lcom/baidu/platform/core/c/g;");
        }
    }

    public g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38862c = i2;
        this.f38863d = i3;
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
                    poiResult.error = optInt != 1 ? optInt != 2 ? SearchResult.ERRORNO.RESULT_NOT_FOUND : SearchResult.ERRORNO.SEARCH_OPTION_ERROR : SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    return false;
                } catch (JSONException unused) {
                    poiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private boolean a(JSONObject jSONObject, PoiResult poiResult) {
        InterceptResult invokeLL;
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
                    poiResult.setCurrentPageNum(this.f38862c);
                    if (length != 0) {
                        int i2 = this.f38863d;
                        poiResult.setTotalPageNum((optInt / i2) + (optInt % i2 > 0 ? 1 : 0));
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i3);
                        if (jSONObject2 != null && jSONObject2.length() != 0) {
                            PoiInfo poiInfo = new PoiInfo();
                            poiInfo.setName(jSONObject2.optString("name"));
                            poiInfo.setAddress(jSONObject2.optString("address"));
                            poiInfo.setProvince(jSONObject2.optString("province"));
                            poiInfo.setCity(jSONObject2.optString("city"));
                            poiInfo.setArea(jSONObject2.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA));
                            poiInfo.setStreetId(jSONObject2.optString("street_id"));
                            poiInfo.setUid(jSONObject2.optString("uid"));
                            poiInfo.setPhoneNum(jSONObject2.optString("telephone"));
                            poiInfo.setDetail(jSONObject2.optInt("detail"));
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
                if (SearchType.f38822b == a || SearchType.a == a) {
                    poiDetailInfo.setPoiChildrenInfoList(b(jSONObject));
                }
                return poiDetailInfo;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (PoiDetailInfo) invokeL.objValue;
    }

    private List<PoiChildrenInfo> b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, jSONObject)) == null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
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
        return (List) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
        if (r7.equals("NETWORK_ERROR") != false) goto L28;
     */
    @Override // com.baidu.platform.base.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SearchResult a(String str) {
        InterceptResult invokeL;
        SearchResult.ERRORNO errorno;
        JSONObject jSONObject;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            PoiResult poiResult = new PoiResult();
            if (str != null && !str.equals("") && !str.isEmpty()) {
                try {
                    jSONObject = new JSONObject(str);
                    c2 = 0;
                } catch (JSONException unused) {
                }
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        errorno = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                        poiResult.error = errorno;
                        return poiResult;
                    } else if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        int hashCode = optString.hashCode();
                        if (hashCode != -879828873) {
                            if (hashCode == 1470557208 && optString.equals("REQUEST_ERROR")) {
                                c2 = 1;
                            }
                            c2 = 65535;
                        }
                        poiResult.error = c2 != 0 ? c2 != 1 ? SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR : SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.NETWORK_ERROR;
                        return poiResult;
                    }
                }
                if (a(str, poiResult, false)) {
                    return poiResult;
                }
                poiResult.error = a(str, poiResult) ? SearchResult.ERRORNO.NO_ERROR : SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return poiResult;
            }
            errorno = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            poiResult.error = errorno;
            return poiResult;
        }
        return (SearchResult) invokeL.objValue;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, searchResult, obj) == null) && obj != null && (obj instanceof OnGetPoiSearchResultListener)) {
            int i2 = h.a[a().ordinal()];
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                ((OnGetPoiSearchResultListener) obj).onGetPoiResult((PoiResult) searchResult);
            }
        }
    }
}
