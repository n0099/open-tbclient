package b.a.p0.a.p.e.j;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.k.f;
import b.a.p0.a.p.d.r1;
import b.a.p0.a.p.e.e;
import b.a.p0.a.s.a.h;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // b.a.p0.a.p.d.r1
    public e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? new SwanWebModeWidget(context) : (e) invokeL.objValue;
    }

    @Override // b.a.p0.a.p.d.r1
    public b.a.p0.a.p.e.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new b.a.p0.a.h0.e.d(context) : (b.a.p0.a.p.e.a) invokeL.objValue;
    }

    @Override // b.a.p0.a.p.d.r1
    public e c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? new b.a.p0.a.q.e(context) : (e) invokeL.objValue;
    }

    @Override // b.a.p0.a.p.d.r1
    public f d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new f() : (f) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.d.r1
    public b.a.p0.a.p.e.b e(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, context, i2)) == null) ? new SwanAppSlaveManager(context) : (b.a.p0.a.p.e.b) invokeLI.objValue;
    }

    @Override // b.a.p0.a.p.d.r1
    public e f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? new h(context) : (e) invokeL.objValue;
    }

    @Override // b.a.p0.a.p.d.r1
    public e g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) ? new b.a.p0.a.s.a.j.a.b(context) : (e) invokeL.objValue;
    }

    @Override // b.a.p0.a.p.d.r1
    public b.a.p0.a.h0.l.a h(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, context, i2)) == null) ? new b.a.p0.a.h0.l.b().a(context, i2) : (b.a.p0.a.h0.l.a) invokeLI.objValue;
    }

    @Override // b.a.p0.a.p.d.r1
    public e i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) ? new SwanAppSimpleH5Widget(context) : (e) invokeL.objValue;
    }

    @Override // b.a.p0.a.p.d.r1
    public boolean j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? i2 == 0 : invokeI.booleanValue;
    }
}
