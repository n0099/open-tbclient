package com.baidu.location;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationClient f39926a;

    public c(LocationClient locationClient) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {locationClient};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39926a = locationClient;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        com.baidu.location.b.c cVar;
        com.baidu.location.b.c cVar2;
        com.baidu.location.b.c cVar3;
        Context context;
        LocationClientOption locationClientOption;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            cVar = this.f39926a.C;
            if (cVar == null) {
                LocationClient locationClient = this.f39926a;
                context = this.f39926a.f39745f;
                locationClientOption = this.f39926a.f39743d;
                locationClient.C = new com.baidu.location.b.c(context, locationClientOption, this.f39926a);
            }
            cVar2 = this.f39926a.C;
            if (cVar2 != null) {
                cVar3 = this.f39926a.C;
                cVar3.c();
            }
        }
    }
}
