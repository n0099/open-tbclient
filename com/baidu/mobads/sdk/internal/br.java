package com.baidu.mobads.sdk.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes3.dex */
public class br {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "logger";
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = -1;
    public static volatile br i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1833693951, "Lcom/baidu/mobads/sdk/internal/br;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1833693951, "Lcom/baidu/mobads/sdk/internal/br;");
        }
    }

    public boolean a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i2)) == null) {
            return true;
        }
        return invokeLI.booleanValue;
    }

    public br() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static br a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (i == null) {
                synchronized (br.class) {
                    if (i == null) {
                        i = new br();
                    }
                }
            }
            return i;
        }
        return (br) invokeV.objValue;
    }

    private String e(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, objArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                sb.append(obj);
                sb.append(WebvttCueParser.CHAR_SPACE);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            a(a, str);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, str) != null) || !a(5)) {
            return;
        }
        try {
            av.c().e(str);
        } catch (Exception unused) {
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, str) != null) || !a(6)) {
            return;
        }
        try {
            av.c().f(str);
        } catch (Exception unused) {
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            b(a, str);
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) != null) || !a(3)) {
            return;
        }
        try {
            av.h(str).c(str2);
        } catch (Exception unused) {
        }
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) != null) || !a(4)) {
            return;
        }
        try {
            av.c().c(str, str2);
        } catch (Exception unused) {
        }
    }

    public void c(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, str, th) != null) || !a(6)) {
            return;
        }
        try {
            av.c().e(th, str);
        } catch (Exception unused) {
        }
    }

    public void d(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048593, this, str, th) != null) || !a(4)) {
            return;
        }
        try {
            av.c().c(th, str);
        } catch (Exception unused) {
        }
    }

    public void a(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, th) != null) || !a(3)) {
            return;
        }
        try {
            av.h(a).b(th, str);
        } catch (Exception unused) {
        }
    }

    public void b(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, str, th) != null) || !a(5)) {
            return;
        }
        try {
            av.c().d(th, str);
        } catch (Exception unused) {
        }
    }

    public void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
            a("", th);
        }
    }

    public void b(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, th) == null) {
            b("", th);
        }
    }

    public void c(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, th) == null) {
            c("", th);
        }
    }

    public void d(Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, objArr) != null) || !a(4)) {
            return;
        }
        d(e(objArr));
    }

    public void a(Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, objArr) != null) || !a(3)) {
            return;
        }
        a(e(objArr));
    }

    public void b(Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, objArr) != null) || !a(5)) {
            return;
        }
        b(e(objArr));
    }

    public void c(Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, objArr) != null) || !a(6)) {
            return;
        }
        c(e(objArr));
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return a(a, i2);
        }
        return invokeI.booleanValue;
    }
}
