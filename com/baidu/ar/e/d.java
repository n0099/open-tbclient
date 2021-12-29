package com.baidu.ar.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class d implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a<?, ?>> tL;

    public d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.tL = new ArrayList();
        d(aVar);
    }

    public static <InT, OutT> c b(a<InT, OutT> aVar, InT r5) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, aVar, r5)) == null) {
            aVar.h(r5);
            return new d(aVar);
        }
        return (c) invokeLL.objValue;
    }

    @Override // com.baidu.ar.callback.ICancellable
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (a<?, ?> aVar : this.tL) {
                aVar.cancel();
            }
        }
    }

    @Override // com.baidu.ar.e.c
    public c d(a<?, ?> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (!this.tL.isEmpty()) {
                List<a<?, ?>> list = this.tL;
                list.get(list.size() - 1).a(aVar);
            }
            this.tL.add(aVar);
            return this;
        }
        return (c) invokeL.objValue;
    }
}
