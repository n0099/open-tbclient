package com.baidu.fsg.base.b;

import com.baidu.fsg.base.b.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f5184a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a.c f5185b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f5186c;

    public d(a aVar, long j, a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Long.valueOf(j), cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5186c = aVar;
        this.f5184a = j;
        this.f5185b = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                Thread.sleep(this.f5184a);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            this.f5186c.d(this.f5185b);
        }
    }
}
