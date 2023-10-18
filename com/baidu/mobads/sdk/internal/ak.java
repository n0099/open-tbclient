package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ak implements e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ak() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.b
    public void a(NativeResponse nativeResponse) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, nativeResponse) == null) && (nativeResponse instanceof XAdNativeResponse)) {
            ((XAdNativeResponse) nativeResponse).onADStatusChanged();
        }
    }
}
