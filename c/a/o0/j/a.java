package c.a.o0.j;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static b f13268a;

    /* renamed from: b  reason: collision with root package name */
    public static a f13269b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f13270c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(997381447, "Lc/a/o0/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(997381447, "Lc/a/o0/j/a;");
                return;
            }
        }
        new ArrayList(5);
    }

    public a() {
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

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, baseFragmentActivity)) == null) {
            if (f13269b == null) {
                synchronized (a.class) {
                    if (f13269b == null) {
                        f13269b = new a();
                        f13268a = b.a(baseFragmentActivity);
                    }
                }
            } else {
                b bVar2 = f13268a;
                if (bVar2 != null) {
                    bVar2.j(baseFragmentActivity.getPageContext());
                }
            }
            if (f13270c && (bVar = f13268a) != null) {
                bVar.d();
                f13268a.c();
                f13270c = false;
            }
            return f13269b;
        }
        return (a) invokeL.objValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            try {
                if (f13268a != null) {
                    if (f13269b != null) {
                        f13269b.j();
                    }
                    f13268a.e();
                    f13268a.i();
                    f13268a = null;
                }
                if (f13269b != null) {
                    f13269b = null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || f13268a == null) {
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b();
            b bVar = f13268a;
            if (bVar != null) {
                bVar.d();
                f13270c = false;
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b();
            b bVar = f13268a;
            if (bVar != null) {
                bVar.c();
                f13270c = false;
            }
        }
    }

    public void e(boolean z, boolean z2, boolean z3, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), aVar}) == null) {
            b();
            if (z) {
                c();
            }
            if (z2) {
                d();
            }
            l(z3);
            k(aVar);
        }
    }

    public void f(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            b();
            b bVar = f13268a;
            if (bVar != null) {
                if (bVar.b()) {
                    f13268a.k(aVar);
                }
                f13268a.f();
            }
        }
    }

    public void g(int i2, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, aVar) == null) {
            b();
            b bVar = f13268a;
            if (bVar != null) {
                if (bVar.b()) {
                    f13268a.k(aVar);
                }
                f13268a.g(i2);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b();
            b bVar = f13268a;
            if (bVar != null) {
                bVar.h();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b();
            i();
            m();
        }
    }

    public void k(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            b();
            b bVar = f13268a;
            if (bVar != null) {
                bVar.k(aVar);
            }
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            b();
            b bVar = f13268a;
            if (bVar != null) {
                bVar.l(z);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            b();
            b bVar = f13268a;
            if (bVar != null) {
                bVar.m();
                f13270c = true;
            }
        }
    }
}
