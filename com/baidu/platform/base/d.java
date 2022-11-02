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
/* loaded from: classes2.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SearchType a;

    public abstract SearchResult a(String str);

    public abstract void a(SearchResult searchResult, Object obj);

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

    public SearchType a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (SearchType) invokeV.objValue;
    }

    public void a(SearchType searchType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, searchType) == null) {
            this.a = searchType;
        }
    }

    public boolean a(String str, SearchResult searchResult, boolean z) {
        InterceptResult invokeLLZ;
        int optInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, str, searchResult, z)) == null) {
            if (str != null) {
                try {
                    if (str.length() > 0) {
                        JSONObject jSONObject = new JSONObject(str);
                        if (z) {
                            optInt = jSONObject.optInt("status");
                        } else {
                            optInt = jSONObject.optInt("status_sp");
                        }
                        if (optInt != 0) {
                            if (optInt != 2) {
                                if (optInt != 200 && optInt != 230) {
                                    if (optInt != 10 && optInt != 11) {
                                        if (optInt != 40) {
                                            if (optInt != 41 && optInt != 44) {
                                                if (optInt != 45) {
                                                    switch (optInt) {
                                                        case 104:
                                                        case 105:
                                                        case 106:
                                                        case 107:
                                                        case 108:
                                                            searchResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                                                            break;
                                                        default:
                                                            searchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                                                            break;
                                                    }
                                                }
                                            } else {
                                                searchResult.error = SearchResult.ERRORNO.NO_DATA_FOR_LATLNG;
                                            }
                                        } else {
                                            searchResult.error = SearchResult.ERRORNO.INVALID_DISTRICT_ID;
                                        }
                                    } else {
                                        searchResult.error = SearchResult.ERRORNO.PARAMER_ERROR;
                                    }
                                } else {
                                    searchResult.error = SearchResult.ERRORNO.KEY_ERROR;
                                }
                                return true;
                            }
                            searchResult.error = SearchResult.ERRORNO.NO_ADVANCED_PERMISSION;
                            return true;
                        }
                        return false;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
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
