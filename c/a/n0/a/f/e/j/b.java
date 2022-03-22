package c.a.n0.a.f.e.j;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.f.d.r1;
import c.a.n0.a.f.e.e;
import c.a.n0.a.i.a.h;
import c.a.n0.a.x.k.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.core.slave.SwanWebModeWidget;
import com.baidu.swan.apps.view.SwanAppSimpleH5Widget;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b implements r1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    @Override // c.a.n0.a.f.d.r1
    public e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? new SwanWebModeWidget(context) : (e) invokeL.objValue;
    }

    @Override // c.a.n0.a.f.d.r1
    public c.a.n0.a.f.e.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new c.a.n0.a.x.e.d(context) : (c.a.n0.a.f.e.a) invokeL.objValue;
    }

    @Override // c.a.n0.a.f.d.r1
    public e c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? new c.a.n0.a.g.e(context) : (e) invokeL.objValue;
    }

    @Override // c.a.n0.a.f.d.r1
    public f d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new f() : (f) invokeV.objValue;
    }

    @Override // c.a.n0.a.f.d.r1
    public c.a.n0.a.f.e.b e(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, context, i)) == null) ? new SwanAppSlaveManager(context) : (c.a.n0.a.f.e.b) invokeLI.objValue;
    }

    @Override // c.a.n0.a.f.d.r1
    public e f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? new h(context) : (e) invokeL.objValue;
    }

    @Override // c.a.n0.a.f.d.r1
    public e g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) ? new c.a.n0.a.i.a.j.a.b(context) : (e) invokeL.objValue;
    }

    @Override // c.a.n0.a.f.d.r1
    public c.a.n0.a.x.l.a h(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, context, i)) == null) ? new c.a.n0.a.x.l.b().a(context, i) : (c.a.n0.a.x.l.a) invokeLI.objValue;
    }

    @Override // c.a.n0.a.f.d.r1
    public e i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) ? new SwanAppSimpleH5Widget(context) : (e) invokeL.objValue;
    }

    @Override // c.a.n0.a.f.d.r1
    public boolean j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? i == 0 : invokeI.booleanValue;
    }
}
