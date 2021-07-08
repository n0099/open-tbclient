package com.baidu.location.c;

import com.baidu.location.b.l;
import com.baidu.location.b.t;
import com.baidu.location.b.x;
import com.baidu.location.c.i;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class j implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f6744a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i.a f6745b;

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
        this.f6745b = aVar;
        this.f6744a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            z = this.f6745b.f6741a.j;
            if (!z) {
                this.f6745b.f6741a.j = this.f6744a;
            }
            this.f6745b.f6741a.q();
            l.c().h();
            if (System.currentTimeMillis() - t.b() <= 5000) {
                x.a().c();
            }
        }
    }
}
