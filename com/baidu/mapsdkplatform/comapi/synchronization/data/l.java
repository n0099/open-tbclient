package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class l {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "l";
    public transient /* synthetic */ FieldHolder $fh;
    public d b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-178203713, "Lcom/baidu/mapsdkplatform/comapi/synchronization/data/l;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-178203713, "Lcom/baidu/mapsdkplatform/comapi/synchronization/data/l;");
        }
    }

    public l(RoleOptions roleOptions, DisplayOptions displayOptions) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {roleOptions, displayOptions};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d a2 = d.a();
        this.b = a2;
        if (a2 != null) {
            a2.a(roleOptions, displayOptions);
        }
    }

    public void a() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.b) == null) {
            return;
        }
        dVar.b();
    }

    public void a(int i) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (dVar = this.b) == null) {
            return;
        }
        dVar.a(i);
    }

    public void a(View view2) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) || (dVar = this.b) == null) {
            return;
        }
        dVar.a(view2);
    }

    public void a(DisplayOptions displayOptions) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, displayOptions) == null) || (dVar = this.b) == null) {
            return;
        }
        dVar.a(displayOptions);
    }

    public void a(RoleOptions roleOptions) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, roleOptions) == null) || (dVar = this.b) == null) {
            return;
        }
        dVar.a(roleOptions);
    }

    public void a(k kVar) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) || (dVar = this.b) == null) {
            return;
        }
        dVar.a(kVar);
    }

    public void b() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (dVar = this.b) == null) {
            return;
        }
        dVar.c();
    }

    public void b(int i) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (dVar = this.b) == null) {
            return;
        }
        dVar.b(i);
    }

    public void b(View view2) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) || (dVar = this.b) == null) {
            return;
        }
        dVar.b(view2);
    }

    public void c() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (dVar = this.b) == null) {
            return;
        }
        dVar.d();
    }

    public void c(View view2) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, view2) == null) || (dVar = this.b) == null) {
            return;
        }
        dVar.c(view2);
    }
}
