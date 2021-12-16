package com.baidu.mapapi.search.sug;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.l;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class SuggestionSearch extends l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.platform.core.f.a a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36714b;

    public SuggestionSearch() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36714b = false;
        this.a = new com.baidu.platform.core.f.b();
    }

    public static SuggestionSearch newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            BMapManager.init();
            return new SuggestionSearch();
        }
        return (SuggestionSearch) invokeV.objValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f36714b) {
            return;
        }
        this.f36714b = true;
        this.a.a();
        BMapManager.destroy();
    }

    public boolean requestSuggestion(SuggestionSearchOption suggestionSearchOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, suggestionSearchOption)) == null) {
            com.baidu.platform.core.f.a aVar = this.a;
            if (aVar != null) {
                if (suggestionSearchOption == null || suggestionSearchOption.mKeyword == null || suggestionSearchOption.mCity == null) {
                    throw new IllegalArgumentException("BDMapSDKException: option or keyword or city can not be null");
                }
                return aVar.a(suggestionSearchOption);
            }
            throw new IllegalStateException("BDMapSDKException: suggestionsearch is null, please call newInstance() first.");
        }
        return invokeL.booleanValue;
    }

    public void setOnGetSuggestionResultListener(OnGetSuggestionResultListener onGetSuggestionResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onGetSuggestionResultListener) == null) {
            com.baidu.platform.core.f.a aVar = this.a;
            if (aVar == null) {
                throw new IllegalStateException("BDMapSDKException: suggestionsearch is null, please call newInstance() first.");
            }
            if (onGetSuggestionResultListener == null) {
                throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
            }
            aVar.a(onGetSuggestionResultListener);
        }
    }
}
