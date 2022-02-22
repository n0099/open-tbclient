package c.a.s0.m;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes6.dex */
public class j implements c.a.s0.a.c1.d.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j() {
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

    @Override // c.a.s0.a.c1.d.f
    public boolean a(Context context, c.a.s0.a.i1.c.g gVar, c.a.s0.a.i1.b bVar, c.a.s0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, gVar, bVar, eVar)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.a.s0.a.c1.d.f
    public boolean b(Context context, c.a.s0.a.i1.c.b bVar, c.a.s0.a.i1.b bVar2, c.a.s0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bVar, bVar2, eVar)) == null) ? c.a.s0.m.l.e.d.e().c(context, bVar, bVar2, eVar) : invokeLLLL.booleanValue;
    }

    @Override // c.a.s0.a.c1.d.f
    public boolean c(Context context, c.a.s0.a.i1.c.c cVar, c.a.s0.a.i1.b bVar, c.a.s0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, cVar, bVar, eVar)) == null) ? c.a.s0.m.l.e.c.d().c(context, cVar, bVar, eVar) : invokeLLLL.booleanValue;
    }

    @Override // c.a.s0.a.c1.d.f
    public void d(c.a.s0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            c.h(bVar);
        }
    }

    @Override // c.a.s0.a.c1.d.f
    public boolean e(Context context, c.a.s0.a.i1.c.a aVar, c.a.s0.a.i1.b bVar, c.a.s0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, aVar, bVar, eVar)) == null) ? c.a.s0.m.p.f.a.h().c(context, aVar, bVar, eVar) : invokeLLLL.booleanValue;
    }

    @Override // c.a.s0.a.c1.d.f
    public void f(c.a.s0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            c.d(bVar);
        }
    }

    @Override // c.a.s0.a.c1.d.f
    public boolean g(Context context, c.a.s0.a.i1.c.c cVar, c.a.s0.a.i1.b bVar, c.a.s0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, cVar, bVar, eVar)) == null) ? c.a.s0.m.l.b.e().c(context, cVar, bVar, eVar) : invokeLLLL.booleanValue;
    }

    @Override // c.a.s0.a.c1.d.f
    public boolean h(Context context, c.a.s0.a.i1.c.e eVar, c.a.s0.a.i1.b bVar, c.a.s0.a.d2.e eVar2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, eVar, bVar, eVar2)) == null) ? c.a.s0.m.l.e.f.e().c(context, eVar, bVar, eVar2) : invokeLLLL.booleanValue;
    }

    @Override // c.a.s0.a.c1.d.f
    public void i(c.a.s0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            c.e(bVar);
        }
    }

    @Override // c.a.s0.a.c1.d.f
    public boolean j(Context context, c.a.s0.a.i1.c.f fVar, c.a.s0.a.i1.b bVar, c.a.s0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, fVar, bVar, eVar)) == null) ? c.a.s0.m.l.e.g.e().c(context, fVar, bVar, eVar) : invokeLLLL.booleanValue;
    }

    @Override // c.a.s0.a.c1.d.f
    public boolean k(Context context, c.a.s0.a.i1.c.c cVar, c.a.s0.a.i1.b bVar, c.a.s0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, cVar, bVar, eVar)) == null) ? c.a.s0.m.l.e.a.d().c(context, cVar, bVar, eVar) : invokeLLLL.booleanValue;
    }

    @Override // c.a.s0.a.c1.d.f
    public boolean l(Context context, c.a.s0.a.i1.c.c cVar, c.a.s0.a.i1.b bVar, c.a.s0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, cVar, bVar, eVar)) == null) ? c.a.s0.m.l.c.d().c(context, cVar, bVar, eVar) : invokeLLLL.booleanValue;
    }

    @Override // c.a.s0.a.c1.d.f
    public boolean m(Context context, c.a.s0.a.i1.c.c cVar, c.a.s0.a.i1.b bVar, c.a.s0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, cVar, bVar, eVar)) == null) ? c.a.s0.m.l.e.e.f().c(context, cVar, bVar, eVar) : invokeLLLL.booleanValue;
    }

    @Override // c.a.s0.a.c1.d.f
    public boolean n(Context context, c.a.s0.a.i1.c.c cVar, c.a.s0.a.i1.b bVar, c.a.s0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, cVar, bVar, eVar)) == null) ? c.a.s0.m.l.e.b.d().c(context, cVar, bVar, eVar) : invokeLLLL.booleanValue;
    }

    @Override // c.a.s0.a.c1.d.f
    public boolean update(Context context, c.a.s0.a.i1.c.c cVar, c.a.s0.a.i1.b bVar, c.a.s0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, cVar, bVar, eVar)) == null) ? c.a.s0.m.l.d.d().c(context, cVar, bVar, eVar) : invokeLLLL.booleanValue;
    }
}
