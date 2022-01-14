package com.baidu.mobstat;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.cq;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetSocketAddress;
/* loaded from: classes10.dex */
public abstract class bz implements cb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bz() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.mobstat.cb
    public String a(by byVar) throws ch {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, byVar)) == null) {
            InetSocketAddress a = byVar.a();
            if (a != null) {
                return "<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"" + a.getPort() + "\" /></cross-domain-policy>\u0000";
            }
            throw new cj("socket not bound");
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobstat.cb
    public void a(by byVar, cq cqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byVar, cqVar) == null) {
        }
    }

    @Override // com.baidu.mobstat.cb
    public void a(by byVar, cs csVar) throws ch {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, byVar, csVar) == null) {
        }
    }

    @Override // com.baidu.mobstat.cb
    public void a(by byVar, cs csVar, cz czVar) throws ch {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, byVar, csVar, czVar) == null) {
        }
    }

    @Override // com.baidu.mobstat.cb
    public void b(by byVar, cq cqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, byVar, cqVar) == null) {
            cr crVar = new cr(cqVar);
            crVar.a(cq.a.f36604e);
            byVar.a(crVar);
        }
    }

    @Override // com.baidu.mobstat.cb
    public void c(by byVar, cq cqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, byVar, cqVar) == null) {
        }
    }
}
