package com.baidu.platform.base;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SearchType f44304a;

    public d() {
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

    public abstract SearchResult a(String str);

    public SearchType a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f44304a : (SearchType) invokeV.objValue;
    }

    public abstract void a(SearchResult searchResult, Object obj);

    public void a(SearchType searchType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, searchType) == null) {
            this.f44304a = searchType;
        }
    }

    public boolean a(String str, SearchResult searchResult, boolean z) {
        InterceptResult invokeLLZ;
        SearchResult.ERRORNO errorno;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, str, searchResult, z)) == null) {
            if (str != null) {
                try {
                    if (str.length() > 0) {
                        int optInt = new JSONObject(str).optInt(z ? "status" : "status_sp");
                        if (optInt != 0) {
                            if (optInt != 200 && optInt != 230) {
                                switch (optInt) {
                                    case 104:
                                    case 105:
                                    case 106:
                                    case 107:
                                    case 108:
                                        errorno = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                                        break;
                                    default:
                                        errorno = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                                        break;
                                }
                            } else {
                                errorno = SearchResult.ERRORNO.KEY_ERROR;
                            }
                            searchResult.error = errorno;
                            return true;
                        }
                        return false;
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    searchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return true;
                }
            }
            searchResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            return true;
        }
        return invokeLLZ.booleanValue;
    }
}
