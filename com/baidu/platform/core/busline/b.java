package com.baidu.platform.core.busline;

import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.mapapi.search.busline.BusLineSearchOption;
import com.baidu.platform.base.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            this.a.a("qt", "bsl");
            this.a.a("rt_info", "1");
            this.a.a("ie", IMAudioTransRequest.CHARSET);
            this.a.a("oue", "0");
            this.a.a("c", busLineSearchOption.mCity);
            this.a.a("uid", busLineSearchOption.mUid);
            com.baidu.platform.util.a aVar = this.a;
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
