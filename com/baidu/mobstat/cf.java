package com.baidu.mobstat;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.cw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetSocketAddress;
/* loaded from: classes2.dex */
public abstract class cf implements ch {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.mobstat.ch
    public void a(ce ceVar, cw cwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ceVar, cwVar) == null) {
        }
    }

    @Override // com.baidu.mobstat.ch
    public void a(ce ceVar, cy cyVar) throws cn {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ceVar, cyVar) == null) {
        }
    }

    @Override // com.baidu.mobstat.ch
    public void a(ce ceVar, cy cyVar, df dfVar) throws cn {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, ceVar, cyVar, dfVar) == null) {
        }
    }

    @Override // com.baidu.mobstat.ch
    public void c(ce ceVar, cw cwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, ceVar, cwVar) == null) {
        }
    }

    public cf() {
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

    @Override // com.baidu.mobstat.ch
    public String a(ce ceVar) throws cn {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ceVar)) == null) {
            InetSocketAddress a = ceVar.a();
            if (a != null) {
                return "<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"" + a.getPort() + "\" /></cross-domain-policy>\u0000";
            }
            throw new cp("socket not bound");
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.ch
    public void b(ce ceVar, cw cwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, ceVar, cwVar) == null) {
            cx cxVar = new cx(cwVar);
            cxVar.a(cw.a.e);
            ceVar.a(cxVar);
        }
    }
}
