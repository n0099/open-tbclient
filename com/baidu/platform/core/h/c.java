package com.baidu.platform.core.h;

import android.util.Log;
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
public class c extends com.baidu.platform.base.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String b = "c";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2056674143, "Lcom/baidu/platform/core/h/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2056674143, "Lcom/baidu/platform/core/h/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                return CoordTrans.baiduToGcj(new LatLng(optDouble, optDouble2));
            }
            return new LatLng(optDouble, optDouble2);
        }
        return (LatLng) invokeL.objValue;
    }

    private List<PoiChildrenInfo> a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, jSONArray)) == null) {
            if (jSONArray != null && jSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
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
            return null;
        }
        return (List) invokeL.objValue;
    }

    private boolean a(String str, SuggestionResult suggestionResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, suggestionResult)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() == 0) {
                    suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return false;
                }
                int optInt = jSONObject.optInt("status");
                if (optInt == 0) {
                    return a(jSONObject, suggestionResult);
                }
                if (optInt != 1) {
                    if (optInt != 2) {
                        suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    } else {
                        suggestionResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
                    }
                } else {
                    suggestionResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                }
                return false;
            } catch (JSONException e) {
                Log.e(b, "Parse sug search error", e);
                suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return false;
            }
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
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                        if (jSONObject2 != null && jSONObject2.length() != 0) {
                            SuggestionResult.SuggestionInfo suggestionInfo = new SuggestionResult.SuggestionInfo();
                            suggestionInfo.setKey(jSONObject2.optString("name"));
                            suggestionInfo.setAdCode(jSONObject2.optInt("adcode"));
                            suggestionInfo.setCity(jSONObject2.optString("city"));
                            suggestionInfo.setDistrict(jSONObject2.optString("district"));
                            suggestionInfo.setUid(jSONObject2.optString("uid"));
                            suggestionInfo.setTag(jSONObject2.optString("tag"));
                            suggestionInfo.setAddress(jSONObject2.optString("address"));
                            suggestionInfo.setPt(a(jSONObject2.optJSONObject("location")));
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray(CriusAttrConstants.CHILDREN);
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

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
        if (r7.equals("NETWORK_ERROR") != false) goto L29;
     */
    @Override // com.baidu.platform.base.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SearchResult a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SuggestionResult suggestionResult = new SuggestionResult();
            if (str != null && !str.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.length() == 0) {
                        suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                        return suggestionResult;
                    }
                    char c = 0;
                    if (jSONObject.has("SDK_InnerError")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                        if (optJSONObject.has("PermissionCheckError")) {
                            suggestionResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                            return suggestionResult;
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
                                    suggestionResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                                } else {
                                    suggestionResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                                }
                            } else {
                                suggestionResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                            }
                            return suggestionResult;
                        }
                    }
                    if (!a(str, suggestionResult, false)) {
                        a(str, suggestionResult);
                    }
                    return suggestionResult;
                } catch (JSONException e) {
                    Log.e(b, "Parse suggestion search result error", e);
                    suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return suggestionResult;
                }
            }
            suggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
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
