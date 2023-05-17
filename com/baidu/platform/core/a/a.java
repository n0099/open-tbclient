package com.baidu.platform.core.a;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.search.building.BuildingResult;
import com.baidu.mapapi.search.building.OnGetBuildingSearchResultListener;
import com.baidu.mapapi.search.core.BuildingInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.platform.base.d;
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
public class a extends d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String b = "a";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2056882742, "Lcom/baidu/platform/core/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2056882742, "Lcom/baidu/platform/core/a/a;");
        }
    }

    public a() {
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

    private boolean a(String str, BuildingResult buildingResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, buildingResult)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() == 0) {
                    buildingResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return false;
                }
                int optInt = jSONObject.optInt("status");
                if (optInt == 0) {
                    buildingResult.setRelation("in".equals(jSONObject.optString("relation")) ? 1 : 0);
                    return a(jSONObject, buildingResult);
                }
                if (optInt != 1) {
                    if (optInt != 2) {
                        buildingResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    } else {
                        buildingResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
                    }
                } else {
                    buildingResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                }
                return false;
            } catch (JSONException e) {
                Log.e(b, "ParseBuidingResult error: ", e);
                buildingResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private boolean a(JSONObject jSONObject, BuildingResult buildingResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, jSONObject, buildingResult)) == null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("buildinginfo");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                if (jSONObject2 != null) {
                    BuildingInfo buildingInfo = new BuildingInfo();
                    buildingInfo.a(jSONObject2.optString("label").equals("main") ? 1 : 0);
                    buildingInfo.a(jSONObject2.optString("struct_id"));
                    buildingInfo.setHeight((float) jSONObject2.optLong("height"));
                    buildingInfo.b(jSONObject2.optInt("accuracy"));
                    buildingInfo.b(jSONObject2.optString("geom"));
                    buildingInfo.c(jSONObject2.optString("center"));
                    arrayList.add(buildingInfo);
                }
            }
            buildingResult.setBuildingList(arrayList);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            BuildingResult buildingResult = new BuildingResult();
            if (str != null && !str.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.length() == 0) {
                        buildingResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                        return buildingResult;
                    }
                    if (jSONObject.has("SDK_InnerError")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                        if (optJSONObject != null && optJSONObject.has("PermissionCheckError")) {
                            buildingResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                            return buildingResult;
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
                                    buildingResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                                } else {
                                    buildingResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                                }
                            } else {
                                buildingResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                            }
                            return buildingResult;
                        }
                    }
                    if (!a(str, buildingResult, true)) {
                        a(str, buildingResult);
                    }
                    return buildingResult;
                } catch (JSONException e) {
                    Log.e(b, "ParseBuidingResult: ", e);
                    buildingResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return buildingResult;
                }
            }
            buildingResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return buildingResult;
        }
        return (SearchResult) invokeL.objValue;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, searchResult, obj) != null) || !(obj instanceof OnGetBuildingSearchResultListener)) {
            return;
        }
        ((OnGetBuildingSearchResultListener) obj).onGetBuildingResult((BuildingResult) searchResult);
    }
}
