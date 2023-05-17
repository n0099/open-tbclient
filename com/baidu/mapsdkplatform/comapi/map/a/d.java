package com.baidu.mapsdkplatform.comapi.map.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.track.TraceOverlay;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ c a;

    public d(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.a.b
    public void a(TraceOverlay traceOverlay) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, traceOverlay) != null) {
            return;
        }
        this.a.a(traceOverlay);
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.a.b
    public void b(TraceOverlay traceOverlay) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, traceOverlay) != null) {
            return;
        }
        this.a.b(traceOverlay);
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.a.b
    public void c(TraceOverlay traceOverlay) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, traceOverlay) == null) {
            this.a.b();
        }
    }
}
