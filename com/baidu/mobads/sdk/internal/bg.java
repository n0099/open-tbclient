package com.baidu.mobads.sdk.internal;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.z;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bg implements z.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ bf c;

    public bg(bf bfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bfVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = bfVar;
    }

    @Override // com.baidu.mobads.sdk.internal.z.a
    public void onFailure() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.i.a(bf.b, "AbstractProdTemplate,load-dex请求，回调失败");
            this.c.j();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.z.a
    public void onSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.i.a(bf.b, "AbstractProdTemplate,load-dex请求，回调成功");
            this.c.i();
        }
    }
}
