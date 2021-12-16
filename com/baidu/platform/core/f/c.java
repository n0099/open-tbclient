package com.baidu.platform.core.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiChildrenInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
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
public class c extends com.baidu.platform.base.d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f38869b = "c";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2056733725, "Lcom/baidu/platform/core/f/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2056733725, "Lcom/baidu/platform/core/f/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
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
            return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(new LatLng(optDouble, optDouble2)) : new LatLng(optDouble, optDouble2);
        }
        return (LatLng) invokeL.objValue;
    }

    private List<PoiChildrenInfo> a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null && optJSONObject.length() != 0) {
                    PoiChildrenInfo poiChildrenInfo = new PoiChildrenInfo();
                    poiChildrenInfo.setUid(optJSONObject.optString("uid"));
                    poiChildrenInfo.setName(optJSONObject.optString("name"));
                    poiChildrenInfo.setShowName(optJSONObject.optString("show_name"));
                    poiChildrenInfo.setTag(optJSONObject.optString("tag"));
                    poiChildrenInfo.setAddress(optJSONObject.optString("address"));
                    arrayList.add(poiChildrenInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private boolean a(String str, SuggestionResult suggestionResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, suggestionResult)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() != 0) {
                    int optInt = jSONObject.optInt("status");
                    if (optInt == 0) {
                        return a(jSONObject, suggestionResult);
                    }
                    suggestionResult.error = optInt != 1 ? optInt != 2 ? SearchResult.ERRORNO.RESULT_NOT_FOUND : SearchResult.ERRORNO.SEARCH_OPTION_ERROR : SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                    return false;
                }
            } catch (JSONException unused) {
            }
            suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return false;
        }
        return invokeLL.booleanValue;
    }

    private boolean a(JSONObject jSONObject, SuggestionResult suggestionResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, jSONObject, suggestionResult)) == null) {
            if (jSONObject != null && jSONObject.length() != 0) {
                suggestionResult.error = SearchResult.ERRORNO.NO_ERROR;
                JSONArray optJSONArray = jSONObject.optJSONArray("result");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    ArrayList<SuggestionResult.SuggestionInfo> arrayList = new ArrayList<>();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                        if (jSONObject2 != null && jSONObject2.length() != 0) {
                            SuggestionResult.SuggestionInfo suggestionInfo = new SuggestionResult.SuggestionInfo();
                            suggestionInfo.setKey(jSONObject2.optString("name"));
                            suggestionInfo.setCity(jSONObject2.optString("city"));
                            suggestionInfo.setDistrict(jSONObject2.optString("district"));
                            suggestionInfo.setUid(jSONObject2.optString("uid"));
                            suggestionInfo.setTag(jSONObject2.optString("tag"));
                            suggestionInfo.setAddress(jSONObject2.optString("address"));
                            suggestionInfo.setPt(a(jSONObject2.optJSONObject("location")));
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray("children");
                            if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                                suggestionInfo.setPoiChildrenInfoList(a(optJSONArray2));
                            }
                            arrayList.add(suggestionInfo);
                        }
                    }
                    suggestionResult.setSuggestionInfo(arrayList);
                    return true;
                }
                suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
            return false;
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
            SuggestionResult suggestionResult = new SuggestionResult();
            if (str != null && !str.isEmpty()) {
                try {
                    jSONObject = new JSONObject(str);
                } catch (JSONException unused) {
                }
                if (jSONObject.length() != 0) {
                    if (jSONObject.has("SDK_InnerError")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                        if (optJSONObject.has("PermissionCheckError")) {
                            errorno = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                            suggestionResult.error = errorno;
                            return suggestionResult;
                        } else if (optJSONObject.has("httpStateError")) {
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
                            suggestionResult.error = c2 != 0 ? c2 != 1 ? SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR : SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.NETWORK_ERROR;
                            return suggestionResult;
                        }
                    }
                    if (!a(str, suggestionResult, true)) {
                        a(str, suggestionResult);
                    }
                    return suggestionResult;
                }
            }
            errorno = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            suggestionResult.error = errorno;
            return suggestionResult;
        }
        return (SearchResult) invokeL.objValue;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, searchResult, obj) == null) && obj != null && (obj instanceof OnGetSuggestionResultListener)) {
            ((OnGetSuggestionResultListener) obj).onGetSuggestionResult((SuggestionResult) searchResult);
        }
    }
}
