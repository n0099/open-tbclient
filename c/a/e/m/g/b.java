package c.a.e.m.g;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final boolean a(@NonNull a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? aVar.i == 1 : invokeL.booleanValue;
    }

    public void b(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            aVar.a = 2;
            c.a.e.m.b.a(aVar, "image");
        }
    }

    public void c(@NonNull a aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, aVar, i) == null) {
            aVar.a = 7;
            c.a.e.m.b.b(aVar, i);
        }
    }

    public void d(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            aVar.a = 5;
            c.a.e.m.b.d(aVar);
        }
    }

    public void e(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            aVar.a = 2;
            c.a.e.m.b.a(aVar, "button");
        }
    }

    public void f(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) && a(aVar)) {
            aVar.a = 34;
            c.a.e.m.b.c(aVar);
        }
    }

    public void g(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) && a(aVar)) {
            aVar.a = 32;
            c.a.e.m.b.c(aVar);
        }
    }

    public void h(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) && a(aVar)) {
            aVar.a = 33;
            c.a.e.m.b.c(aVar);
        }
    }

    public void i(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            aVar.a = 3;
            c.a.e.m.b.e(aVar);
            if (a(aVar)) {
                aVar.a = 31;
                c.a.e.m.b.f(aVar);
            }
        }
    }

    public void j(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            aVar.a = 2;
            c.a.e.m.b.a(aVar, "title");
        }
    }

    public void k(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
        }
    }

    public void l(@NonNull a aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, aVar, i) == null) {
            c.a.e.m.b.g(aVar, i);
        }
    }
}
