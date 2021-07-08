package com.baidu.platform.core.busline;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.search.busline.BusLineSearchOption;
import com.baidu.mapapi.search.busline.OnGetBusLineSearchResultListener;
import com.baidu.platform.base.SearchType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c extends com.baidu.platform.base.a implements IBusLineSearch {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public OnGetBusLineSearchResultListener f9429b;

    public c() {
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
        this.f9429b = null;
    }

    @Override // com.baidu.platform.core.busline.IBusLineSearch
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f9394a.lock();
            this.f9429b = null;
            this.f9394a.unlock();
        }
    }

    @Override // com.baidu.platform.core.busline.IBusLineSearch
    public void a(OnGetBusLineSearchResultListener onGetBusLineSearchResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onGetBusLineSearchResultListener) == null) {
            this.f9394a.lock();
            this.f9429b = onGetBusLineSearchResultListener;
            this.f9394a.unlock();
        }
    }

    @Override // com.baidu.platform.core.busline.IBusLineSearch
    public boolean a(BusLineSearchOption busLineSearchOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, busLineSearchOption)) == null) {
            a aVar = new a();
            aVar.a(SearchType.o);
            return a(new b(busLineSearchOption), this.f9429b, aVar);
        }
        return invokeL.booleanValue;
    }
}
