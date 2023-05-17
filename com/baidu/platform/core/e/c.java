package com.baidu.platform.core.e;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RecommendStopInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.recommendstop.OnGetRecommendStopResultListener;
import com.baidu.mapapi.search.recommendstop.RecommendStopResult;
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
/* loaded from: classes3.dex */
public class c extends com.baidu.platform.base.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String b = "c";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2056763516, "Lcom/baidu/platform/core/e/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2056763516, "Lcom/baidu/platform/core/e/c;");
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
            double optDouble = jSONObject.optDouble("bd09ll_y");
            double optDouble2 = jSONObject.optDouble("bd09ll_x");
            double optDouble3 = jSONObject.optDouble("gcj02ll_y");
            double optDouble4 = jSONObject.optDouble("gcj02ll_x");
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                if (Double.compare(optDouble3, 0.0d) == 0 && Double.compare(optDouble4, 0.0d) == 0) {
                    return null;
                }
                return new LatLng(optDouble3, optDouble4);
            } else if (Double.compare(optDouble, 0.0d) == 0 && Double.compare(optDouble2, 0.0d) == 0) {
                return null;
            } else {
                return new LatLng(optDouble, optDouble2);
            }
        }
        return (LatLng) invokeL.objValue;
    }

    private boolean a(String str, RecommendStopResult recommendStopResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, recommendStopResult)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() == 0) {
                    recommendStopResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return false;
                }
                int optInt = jSONObject.optInt("status");
                if (optInt == 0) {
                    return a(jSONObject, recommendStopResult);
                }
                if (optInt != 1) {
                    if (optInt != 2) {
                        recommendStopResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    } else {
                        recommendStopResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
                    }
                } else {
                    recommendStopResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                }
                return false;
            } catch (JSONException e) {
                Log.e(b, "Parse RecommendStop error", e);
                recommendStopResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private boolean a(JSONObject jSONObject, RecommendStopResult recommendStopResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject, recommendStopResult)) == null) {
            if (jSONObject != null && jSONObject.length() != 0) {
                recommendStopResult.error = SearchResult.ERRORNO.NO_ERROR;
                JSONArray optJSONArray = jSONObject.optJSONArray("recommendStops");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                        if (jSONObject2 != null && jSONObject2.length() != 0) {
                            RecommendStopInfo recommendStopInfo = new RecommendStopInfo();
                            recommendStopInfo.setName(jSONObject2.optString("name"));
                            recommendStopInfo.setDistance((float) jSONObject2.optDouble("distance"));
                            recommendStopInfo.setAddress(jSONObject2.optString("address"));
                            recommendStopInfo.setId(jSONObject2.optString("id"));
                            recommendStopInfo.setLocation(a(jSONObject2));
                            arrayList.add(recommendStopInfo);
                        }
                    }
                    recommendStopResult.setRecommendStopInfoList(arrayList);
                    return true;
                }
                recommendStopResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
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
            RecommendStopResult recommendStopResult = new RecommendStopResult();
            if (str != null && !str.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.length() == 0) {
                        recommendStopResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                        return recommendStopResult;
                    }
                    if (jSONObject.has("SDK_InnerError")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                        if (optJSONObject != null && optJSONObject.has("PermissionCheckError")) {
                            recommendStopResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                            return recommendStopResult;
                        } else if (optJSONObject != null && optJSONObject.has("httpStateError")) {
                            String optString = optJSONObject.optString("httpStateError");
                            char c = 65535;
                            int hashCode = optString.hashCode();
                            if (hashCode != -879828873) {
                                if (hashCode == 1470557208 && optString.equals("REQUEST_ERROR")) {
                                    c = 1;
                                }
                            } else if (optString.equals("NETWORK_ERROR")) {
                                c = 0;
                            }
                            if (c != 0) {
                                if (c != 1) {
                                    recommendStopResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                                } else {
                                    recommendStopResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                                }
                            } else {
                                recommendStopResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                            }
                            return recommendStopResult;
                        }
                    }
                    if (!a(str, recommendStopResult, true)) {
                        a(str, recommendStopResult);
                    }
                    return recommendStopResult;
                } catch (JSONException e) {
                    Log.e(b, "Parse RecommendStopResult result error", e);
                    recommendStopResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return recommendStopResult;
                }
            }
            recommendStopResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return recommendStopResult;
        }
        return (SearchResult) invokeL.objValue;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, searchResult, obj) != null) || !(obj instanceof OnGetRecommendStopResultListener)) {
            return;
        }
        ((OnGetRecommendStopResultListener) obj).onGetRecommendStopResult((RecommendStopResult) searchResult);
    }
}
