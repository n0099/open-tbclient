package com.baidu.mapsdkplatform.comapi.synchronization.c;

import com.baidu.mapsdkplatform.comapi.synchronization.c.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends a.AbstractRunnableC0119a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f7861a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7862b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f7863c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, e eVar, String str) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, eVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7863c = aVar;
        this.f7861a = eVar;
        this.f7862b = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.a.AbstractRunnableC0119a
    public void a() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c cVar = new c("GET", this.f7861a);
            i2 = this.f7863c.f7858a;
            cVar.b(i2);
            i3 = this.f7863c.f7859b;
            cVar.a(i3);
            cVar.a(this.f7862b);
        }
    }
}
