package com.baidu.mapsdkplatform.comapi.map.a;

import com.baidu.mapapi.map.track.TraceOverlay;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ TraceOverlay a;
    public final /* synthetic */ c b;

    public e(c cVar, TraceOverlay traceOverlay) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, traceOverlay};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = cVar;
        this.a = traceOverlay;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        aVar = this.b.a;
        if (aVar == null) {
            return;
        }
        dVar = this.b.b;
        if (dVar == null) {
            return;
        }
        this.b.c(this.a);
        aVar2 = this.b.a;
        aVar2.a();
    }
}
