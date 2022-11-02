package com.baidu.platform.core.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.share.OnGetShareUrlResultListener;
import com.baidu.mapapi.search.share.ShareUrlResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends com.baidu.platform.base.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x009b -> B:47:0x00a2). Please submit an issue!!! */
    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            ShareUrlResult shareUrlResult = new ShareUrlResult();
            if (str != null && !str.equals("")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("SDK_InnerError")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                        if (optJSONObject.has("PermissionCheckError")) {
                            shareUrlResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                            return shareUrlResult;
                        } else if (optJSONObject.has("httpStateError")) {
                            String optString = optJSONObject.optString("httpStateError");
                            if (optString.equals("NETWORK_ERROR")) {
                                shareUrlResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                            } else if (optString.equals("REQUEST_ERROR")) {
                                shareUrlResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                            } else {
                                shareUrlResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                            }
                            return shareUrlResult;
                        }
                    }
                    if (!a(str, shareUrlResult, false)) {
                        if (str == null) {
                            shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                        }
                        try {
                            JSONObject jSONObject2 = new JSONObject(str);
                            if (str != null) {
                                if (jSONObject2.optInt("status_sdk") != 0) {
                                    shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                                } else {
                                    shareUrlResult.setUrl(jSONObject2.optString("shorturl"));
                                    shareUrlResult.setType(a().ordinal());
                                    shareUrlResult.error = SearchResult.ERRORNO.NO_ERROR;
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                        }
                    }
                    return shareUrlResult;
                } catch (Exception unused) {
                    shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return shareUrlResult;
                }
            }
            shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return shareUrlResult;
        }
        return (SearchResult) invokeL.objValue;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, searchResult, obj) == null) && obj != null && (obj instanceof OnGetShareUrlResultListener)) {
            ((OnGetShareUrlResultListener) obj).onGetRouteShareUrlResult((ShareUrlResult) searchResult);
        }
    }
}
