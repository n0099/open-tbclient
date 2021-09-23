package c.a.f.m.g;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
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

    public final boolean a(@NonNull a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? aVar.f3334i == 1 : invokeL.booleanValue;
    }

    public void b(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            aVar.f3326a = 2;
            c.a.f.m.b.a(aVar, "image");
        }
    }

    public void c(@NonNull a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, aVar, i2) == null) {
            aVar.f3326a = 7;
            c.a.f.m.b.b(aVar, i2);
        }
    }

    public void d(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            aVar.f3326a = 5;
            c.a.f.m.b.d(aVar);
        }
    }

    public void e(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            aVar.f3326a = 2;
            c.a.f.m.b.a(aVar, "button");
        }
    }

    public void f(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) && a(aVar)) {
            aVar.f3326a = 34;
            c.a.f.m.b.c(aVar);
        }
    }

    public void g(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) && a(aVar)) {
            aVar.f3326a = 32;
            c.a.f.m.b.c(aVar);
        }
    }

    public void h(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) && a(aVar)) {
            aVar.f3326a = 33;
            c.a.f.m.b.c(aVar);
        }
    }

    public void i(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            aVar.f3326a = 3;
            c.a.f.m.b.e(aVar);
            if (a(aVar)) {
                aVar.f3326a = 31;
                c.a.f.m.b.f(aVar);
            }
        }
    }

    public void j(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            aVar.f3326a = 2;
            c.a.f.m.b.a(aVar, "title");
        }
    }

    public void k(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
        }
    }

    public void l(@NonNull a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, aVar, i2) == null) {
            c.a.f.m.b.g(aVar, i2);
        }
    }
}
