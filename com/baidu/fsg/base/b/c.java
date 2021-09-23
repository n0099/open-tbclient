package com.baidu.fsg.base.b;

import com.baidu.fsg.base.b.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f39405a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d.c f39406b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f39407c;

    public c(d dVar, long j2, d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, Long.valueOf(j2), cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39407c = dVar;
        this.f39405a = j2;
        this.f39406b = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                Thread.sleep(this.f39405a);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            this.f39407c.b(this.f39406b);
        }
    }
}
