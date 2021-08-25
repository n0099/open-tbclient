package c.a.o0.a.p.e.j;

import android.content.Context;
import c.a.o0.a.h0.k.f;
import c.a.o0.a.p.d.l1;
import c.a.o0.a.p.e.e;
import c.a.o0.a.s.a.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.view.SwanAppSimpleH5Widget;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b implements l1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    @Override // c.a.o0.a.p.d.l1
    public c.a.o0.a.p.e.a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? new c.a.o0.a.h0.e.d(context) : (c.a.o0.a.p.e.a) invokeL.objValue;
    }

    @Override // c.a.o0.a.p.d.l1
    public f b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new f() : (f) invokeV.objValue;
    }

    @Override // c.a.o0.a.p.d.l1
    public e c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? new i(context) : (e) invokeL.objValue;
    }

    @Override // c.a.o0.a.p.d.l1
    public e d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? new c.a.o0.a.s.a.k.a.b(context) : (e) invokeL.objValue;
    }

    @Override // c.a.o0.a.p.d.l1
    public c.a.o0.a.h0.l.a e(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, context, i2)) == null) ? new c.a.o0.a.h0.l.b().a(context, i2) : (c.a.o0.a.h0.l.a) invokeLI.objValue;
    }

    @Override // c.a.o0.a.p.d.l1
    public c.a.o0.a.p.e.b f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? new SwanAppSlaveManager(context) : (c.a.o0.a.p.e.b) invokeL.objValue;
    }

    @Override // c.a.o0.a.p.d.l1
    public e g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) ? new SwanAppSimpleH5Widget(context) : (e) invokeL.objValue;
    }

    public e h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) ? new c.a.o0.a.q.d(context) : (e) invokeL.objValue;
    }
}
