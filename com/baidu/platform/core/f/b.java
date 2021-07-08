package com.baidu.platform.core.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.platform.base.SearchType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends com.baidu.platform.base.a implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public OnGetSuggestionResultListener f9443b;

    public b() {
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
        this.f9443b = null;
    }

    @Override // com.baidu.platform.core.f.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f9394a.lock();
            this.f9443b = null;
            this.f9394a.unlock();
        }
    }

    @Override // com.baidu.platform.core.f.a
    public void a(OnGetSuggestionResultListener onGetSuggestionResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onGetSuggestionResultListener) == null) {
            this.f9394a.lock();
            this.f9443b = onGetSuggestionResultListener;
            this.f9394a.unlock();
        }
    }

    @Override // com.baidu.platform.core.f.a
    public boolean a(SuggestionSearchOption suggestionSearchOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, suggestionSearchOption)) == null) {
            c cVar = new c();
            cVar.a(SearchType.f9390f);
            return a(new d(suggestionSearchOption), this.f9443b, cVar);
        }
        return invokeL.booleanValue;
    }
}
