package com.baidu.platform.core.busline;

import com.baidu.mapapi.search.busline.BusLineSearchOption;
import com.baidu.platform.base.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b(BusLineSearchOption busLineSearchOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {busLineSearchOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(busLineSearchOption);
    }

    private void a(BusLineSearchOption busLineSearchOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, busLineSearchOption) == null) {
            this.f9434a.a("qt", "bsl");
            this.f9434a.a("rt_info", "1");
            this.f9434a.a("ie", "utf-8");
            this.f9434a.a("oue", "0");
            this.f9434a.a("c", busLineSearchOption.mCity);
            this.f9434a.a("uid", busLineSearchOption.mUid);
            com.baidu.platform.util.a aVar = this.f9434a;
            aVar.a("t", System.currentTimeMillis() + "");
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? cVar.m() : (String) invokeL.objValue;
    }
}
