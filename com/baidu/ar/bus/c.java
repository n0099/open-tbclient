package com.baidu.ar.bus;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public static final List<c> kC;
    public transient /* synthetic */ FieldHolder $fh;
    public Object kD;
    public g kE;
    public c kF;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-724490633, "Lcom/baidu/ar/bus/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-724490633, "Lcom/baidu/ar/bus/c;");
                return;
            }
        }
        kC = new ArrayList();
    }

    public c(Object obj, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, gVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.kD = obj;
        this.kE = gVar;
    }

    public static void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cVar) == null) {
            cVar.kD = null;
            cVar.kE = null;
            cVar.kF = null;
            synchronized (kC) {
                if (kC.size() < 20) {
                    kC.add(cVar);
                }
            }
        }
    }

    public static c d(g gVar, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, gVar, obj)) == null) {
            synchronized (kC) {
                int size = kC.size();
                if (size > 0) {
                    c remove = kC.remove(size - 1);
                    remove.kD = obj;
                    remove.kE = gVar;
                    remove.kF = null;
                    return remove;
                }
                return new c(obj, gVar);
            }
        }
        return (c) invokeLL.objValue;
    }
}
