package com.baidu.location.c;

import com.baidu.location.b.l;
import com.baidu.location.b.t;
import com.baidu.location.b.x;
import com.baidu.location.c.i;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class j implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f41286a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i.a f41287b;

    public j(i.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41287b = aVar;
        this.f41286a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            z = this.f41287b.f41283a.f41282j;
            if (!z) {
                this.f41287b.f41283a.f41282j = this.f41286a;
            }
            this.f41287b.f41283a.q();
            l.c().h();
            if (System.currentTimeMillis() - t.b() <= 5000) {
                x.a().c();
            }
        }
    }
}
