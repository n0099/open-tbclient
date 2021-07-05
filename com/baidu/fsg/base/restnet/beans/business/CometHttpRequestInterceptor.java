package com.baidu.fsg.base.restnet.beans.business;

import android.content.Context;
import com.baidu.fsg.base.restnet.rest.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class CometHttpRequestInterceptor extends EbpayHttpRequestInterceptor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COMET_HTTP_TIMEOUT = 60000;
    public static final String TAG = "CometHttpRequestInterceptor";
    public transient /* synthetic */ FieldHolder $fh;

    public CometHttpRequestInterceptor() {
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

    @Override // com.baidu.fsg.base.restnet.beans.business.EbpayHttpRequestInterceptor, com.baidu.fsg.base.restnet.rest.RestHttpRequestInterceptor
    public void intercept(Context context, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, dVar) == null) {
            super.intercept(context, dVar);
            dVar.a(60000);
        }
    }
}
