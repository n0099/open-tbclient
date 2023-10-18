package com.baidu.mobads.sdk.internal;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.z;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p a;
    public transient /* synthetic */ FieldHolder $fh;
    public List<z.a> b;

    public p() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new CopyOnWriteArrayList();
    }

    public static p a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (p.class) {
                    if (a == null) {
                        a = new p();
                    }
                }
            }
            return a;
        }
        return (p) invokeV.objValue;
    }

    private void b(z.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, aVar) == null) && this.b.contains(aVar)) {
            this.b.remove(aVar);
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            for (z.a aVar : this.b) {
                if (i == 1) {
                    aVar.onSuccess();
                } else if (i == 2) {
                    aVar.onFailure();
                }
                b(aVar);
            }
        }
    }

    public void a(z.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && aVar != null && !this.b.contains(aVar)) {
            this.b.add(aVar);
        }
    }
}
