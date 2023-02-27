package com.baidu.platform.core.c;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.DuPaBInfoMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.mobstat.Config;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends com.baidu.platform.base.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    private PoiInfo.ParentPoiInfo a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONObject)) == null) {
            if (jSONObject != null && jSONObject.length() != 0) {
                PoiInfo.ParentPoiInfo parentPoiInfo = new PoiInfo.ParentPoiInfo();
                parentPoiInfo.setParentPoiAddress(jSONObject.optString(DuPaBInfoMsg.B_ADDR));
                parentPoiInfo.setParentPoiDirection(jSONObject.optString(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
                parentPoiInfo.setParentPoiDistance(jSONObject.optInt("distance"));
                parentPoiInfo.setParentPoiName(jSONObject.optString("name"));
                parentPoiInfo.setParentPoiTag(jSONObject.optString("tag"));
                parentPoiInfo.setParentPoiUid(jSONObject.optString("uid"));
                parentPoiInfo.setParentPoiLocation(d(jSONObject, Config.EVENT_HEAT_POINT));
                return parentPoiInfo;
            }
            return null;
        }
        return (PoiInfo.ParentPoiInfo) invokeL.objValue;
    }

    private List<ReverseGeoCodeResult.RoadInfo> a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, jSONObject, str)) == null) {
            if (jSONObject == null || TextUtils.isEmpty(str) || (optJSONArray = jSONObject.optJSONArray(str)) == null || optJSONArray.length() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    ReverseGeoCodeResult.RoadInfo roadInfo = new ReverseGeoCodeResult.RoadInfo();
                    roadInfo.name = optJSONObject.optString("name");
                    roadInfo.distance = optJSONObject.optString("distance");
                    arrayList.add(roadInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    private LatLng d(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, jSONObject, str)) == null) {
            if (jSONObject == null || str == null || "".equals(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
                return null;
            }
            LatLng latLng = new LatLng(optJSONObject.optDouble("y"), optJSONObject.optDouble("x"));
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                return CoordTrans.baiduToGcj(latLng);
            }
            return latLng;
        }
        return (LatLng) invokeLL.objValue;
    }

    private List<PoiInfo> a(JSONObject jSONObject, String str, String str2) {
        InterceptResult invokeLLL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, jSONObject, str, str2)) == null) {
            if (jSONObject == null || str == null || "".equals(str) || (optJSONArray = jSONObject.optJSONArray(str)) == null || optJSONArray.length() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    PoiInfo poiInfo = new PoiInfo();
                    poiInfo.setAddress(optJSONObject.optString(DuPaBInfoMsg.B_ADDR));
                    poiInfo.setPhoneNum(optJSONObject.optString("tel"));
                    poiInfo.setUid(optJSONObject.optString("uid"));
                    poiInfo.setPostCode(optJSONObject.optString(StatConstants.VALUE_TYPE_ZIP));
                    poiInfo.setName(optJSONObject.optString("name"));
                    poiInfo.setLocation(d(optJSONObject, Config.EVENT_HEAT_POINT));
                    poiInfo.setCity(str2);
                    poiInfo.setDirection(optJSONObject.optString(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
                    poiInfo.setDistance(optJSONObject.optInt("distance"));
                    poiInfo.setTag(optJSONObject.optString("tag"));
                    poiInfo.setParentPoi(a(optJSONObject.optJSONObject("parent_poi")));
                    arrayList.add(poiInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }

    private boolean a(String str, ReverseGeoCodeResult reverseGeoCodeResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, reverseGeoCodeResult)) == null) {
            if (str != null) {
                try {
                    if (str.length() > 0) {
                        JSONObject jSONObject = new JSONObject(str);
                        int optInt = jSONObject.optInt("status");
                        if (optInt != 0) {
                            if (optInt != 1) {
                                if (optInt != 2) {
                                    reverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                                } else {
                                    reverseGeoCodeResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
                                }
                            } else {
                                reverseGeoCodeResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                            }
                            return false;
                        } else if (a(jSONObject, reverseGeoCodeResult)) {
                            return true;
                        } else {
                            reverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                            return false;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    reverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return false;
                }
            }
            reverseGeoCodeResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            return false;
        }
        return invokeLL.booleanValue;
    }

    private boolean a(JSONObject jSONObject, ReverseGeoCodeResult reverseGeoCodeResult) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, jSONObject, reverseGeoCodeResult)) == null) {
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("result")) == null) {
                return false;
            }
            reverseGeoCodeResult.setCityCode(optJSONObject.optInt("cityCode"));
            reverseGeoCodeResult.setAddress(optJSONObject.optString("formatted_address"));
            reverseGeoCodeResult.setBusinessCircle(optJSONObject.optString("business"));
            ReverseGeoCodeResult.AddressComponent b = b(optJSONObject, "addressComponent");
            reverseGeoCodeResult.setAddressDetail(b);
            reverseGeoCodeResult.setLocation(e(optJSONObject, "location"));
            if (b != null) {
                str = b.city;
                reverseGeoCodeResult.setAdcode(b.adcode);
            } else {
                str = "";
            }
            reverseGeoCodeResult.setPoiList(a(optJSONObject, "pois", str));
            reverseGeoCodeResult.setSematicDescription(optJSONObject.optString("sematic_description"));
            reverseGeoCodeResult.setPoiRegionsInfoList(c(optJSONObject, "poiRegions"));
            reverseGeoCodeResult.setRoadInfoList(a(optJSONObject, "roads"));
            reverseGeoCodeResult.error = SearchResult.ERRORNO.NO_ERROR;
            return true;
        }
        return invokeLL.booleanValue;
    }

    private List<ReverseGeoCodeResult.PoiRegionsInfo> c(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, jSONObject, str)) == null) {
            if (jSONObject == null || TextUtils.isEmpty(str) || (optJSONArray = jSONObject.optJSONArray(str)) == null || optJSONArray.length() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    ReverseGeoCodeResult.PoiRegionsInfo poiRegionsInfo = new ReverseGeoCodeResult.PoiRegionsInfo();
                    poiRegionsInfo.setDirectionDesc(optJSONObject.optString("direction_desc"));
                    poiRegionsInfo.setRegionName(optJSONObject.optString("name"));
                    poiRegionsInfo.setRegionTag(optJSONObject.optString("tag"));
                    arrayList.add(poiRegionsInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    private ReverseGeoCodeResult.AddressComponent b(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, jSONObject, str)) == null) {
            if (jSONObject == null || TextUtils.isEmpty(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
                return null;
            }
            ReverseGeoCodeResult.AddressComponent addressComponent = new ReverseGeoCodeResult.AddressComponent();
            addressComponent.city = optJSONObject.optString("city");
            addressComponent.setTown(optJSONObject.optString("town"));
            addressComponent.district = optJSONObject.optString("district");
            addressComponent.province = optJSONObject.optString("province");
            addressComponent.adcode = optJSONObject.optInt("adcode");
            addressComponent.street = optJSONObject.optString("street");
            addressComponent.streetNumber = optJSONObject.optString("street_number");
            addressComponent.countryName = optJSONObject.optString("country");
            addressComponent.countryCode = optJSONObject.optInt("country_code");
            addressComponent.setDirection(optJSONObject.optString(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
            addressComponent.setDistance(optJSONObject.optString("distance"));
            addressComponent.countryCodeIso = optJSONObject.optString("country_code_iso");
            addressComponent.countryCodeIso2 = optJSONObject.optString("country_code_iso2");
            addressComponent.townCode = optJSONObject.optString("town_code");
            addressComponent.cityLevel = optJSONObject.optInt("cityLevel");
            return addressComponent;
        }
        return (ReverseGeoCodeResult.AddressComponent) invokeLL.objValue;
    }

    private LatLng e(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, jSONObject, str)) == null) {
            if (jSONObject == null || str == null || "".equals(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
                return null;
            }
            LatLng latLng = new LatLng(optJSONObject.optDouble(SuggestAddrField.KEY_LAT), optJSONObject.optDouble(SuggestAddrField.KEY_LNG));
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                return CoordTrans.baiduToGcj(latLng);
            }
            return latLng;
        }
        return (LatLng) invokeLL.objValue;
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            ReverseGeoCodeResult reverseGeoCodeResult = new ReverseGeoCodeResult();
            if (str != null && !str.equals("")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("SDK_InnerError")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                        if (optJSONObject.has("PermissionCheckError")) {
                            reverseGeoCodeResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                            return reverseGeoCodeResult;
                        } else if (optJSONObject.has("httpStateError")) {
                            String optString = optJSONObject.optString("httpStateError");
                            if (optString.equals("NETWORK_ERROR")) {
                                reverseGeoCodeResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                            } else if (optString.equals("REQUEST_ERROR")) {
                                reverseGeoCodeResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                            } else {
                                reverseGeoCodeResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                            }
                            return reverseGeoCodeResult;
                        }
                    }
                    if (!a(str, (SearchResult) reverseGeoCodeResult, false)) {
                        a(str, reverseGeoCodeResult);
                    }
                    return reverseGeoCodeResult;
                } catch (Exception unused) {
                    reverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return reverseGeoCodeResult;
                }
            }
            reverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return reverseGeoCodeResult;
        }
        return (SearchResult) invokeL.objValue;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, searchResult, obj) == null) && obj != null && (obj instanceof OnGetGeoCoderResultListener)) {
            ((OnGetGeoCoderResultListener) obj).onGetReverseGeoCodeResult((ReverseGeoCodeResult) searchResult);
        }
    }
}
