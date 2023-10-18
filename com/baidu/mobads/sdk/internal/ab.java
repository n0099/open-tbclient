package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.bx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ab implements bx.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ z a;

    public ab(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = zVar;
    }

    @Override // com.baidu.mobads.sdk.internal.bx.c
    public void a(boolean z) {
        IXAdContainerFactory iXAdContainerFactory;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                try {
                    if (f.a != null) {
                        this.a.b = f.a.i();
                        iXAdContainerFactory = this.a.b;
                        if (iXAdContainerFactory != null) {
                            this.a.k();
                            return;
                        }
                    }
                } catch (Exception unused) {
                    this.a.a("加载dex异常");
                    return;
                }
            }
            f.a = null;
            this.a.a("加载dex失败");
        }
    }
}
