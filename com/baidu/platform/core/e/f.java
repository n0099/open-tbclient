package com.baidu.platform.core.e;

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
/* loaded from: classes5.dex */
public class f extends com.baidu.platform.base.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        InterceptResult invokeL;
        SearchResult.ERRORNO errorno;
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
                            shareUrlResult.error = optString.equals("NETWORK_ERROR") ? SearchResult.ERRORNO.NETWORK_ERROR : optString.equals("REQUEST_ERROR") ? SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                            return shareUrlResult;
                        }
                    }
                    if (str != null) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(str);
                            if (jSONObject2.optString("state").equals("success")) {
                                shareUrlResult.setUrl(jSONObject2.optString("url"));
                                shareUrlResult.setType(a().ordinal());
                                errorno = SearchResult.ERRORNO.NO_ERROR;
                            } else {
                                errorno = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                            }
                            shareUrlResult.error = errorno;
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        return shareUrlResult;
                    }
                    shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return shareUrlResult;
                } catch (Exception unused) {
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
            OnGetShareUrlResultListener onGetShareUrlResultListener = (OnGetShareUrlResultListener) obj;
            int i2 = g.f44223a[a().ordinal()];
            if (i2 == 1) {
                onGetShareUrlResultListener.onGetPoiDetailShareUrlResult((ShareUrlResult) searchResult);
            } else if (i2 != 2) {
            } else {
                onGetShareUrlResultListener.onGetLocationShareUrlResult((ShareUrlResult) searchResult);
            }
        }
    }
}
