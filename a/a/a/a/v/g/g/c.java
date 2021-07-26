package a.a.a.a.v.g.g;

import a.a.a.a.s.h;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final a.a.a.a.v.g.d f1440b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a f1441a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1671667131, "La/a/a/a/v/g/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1671667131, "La/a/a/a/v/g/g/c;");
                return;
            }
        }
        f1440b = a.a.a.a.v.g.d.a();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1441a = new a();
    }

    public static void a(a aVar, Object obj, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, aVar, obj, objArr) == null) {
            String str = aVar.f1427a;
            int i2 = aVar.f1428b;
            String str2 = aVar.f1430d;
            f1440b.a("ad", new b(aVar.f1429c, str, i2, aVar.f1431e, str2, obj, false, objArr));
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a(this.f1441a, "left_app", new Object[0]);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            a(this.f1441a, "render_failed", NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i2));
        }
    }

    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            a(this.f1441a, "ld_err", NotificationCompat.CATEGORY_ERROR, obj);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            a(z, this.f1441a, "onclick", new Object[0]);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a(this.f1441a, "ld_succeed", new Object[0]);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            a(this.f1441a, "video_err", NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i2));
        }
    }

    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            a(this.f1441a, "sh_failed", NotificationCompat.CATEGORY_ERROR, obj);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            a(z, this.f1441a, "sh_succeed", new Object[0]);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            a(this.f1441a, "oncached", new Object[0]);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            a(this.f1441a, "onclosed", new Object[0]);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            a(this.f1441a, "render_succeed", new Object[0]);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            a(this.f1441a, "reward", new Object[0]);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            a(this.f1441a, "sh_start", new Object[0]);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            a(this.f1441a, "splash_skip", new Object[0]);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            a(this.f1441a, "unlike_selected", new Object[0]);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(this.f1441a, "video_complete", new Object[0]);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            a(this.f1441a, "video_err", new Object[0]);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            a(this.f1441a, "video_pause", new Object[0]);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            a(this.f1441a, "video_resume", new Object[0]);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            a(this.f1441a, "video_skip", new Object[0]);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            a(this.f1441a, "video_start", new Object[0]);
        }
    }

    public static void a(boolean z, a aVar, Object obj, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), aVar, obj, objArr}) == null) {
            f1440b.a("ad", new b(aVar.f1429c, aVar.f1427a, aVar.f1428b, aVar.f1431e, aVar.f1430d, obj, z, objArr));
        }
    }

    public void a(FunAdSlot funAdSlot, h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, funAdSlot, aVar) == null) {
            int a2 = a.a.a.a.s.c.a(funAdSlot.getSid(), aVar);
            a aVar2 = this.f1441a;
            String sid = funAdSlot.getSid();
            long currentTimeMillis = System.currentTimeMillis();
            String str = aVar.f1361c;
            String str2 = aVar.f1362d;
            aVar2.f1427a = sid;
            aVar2.f1428b = a2;
            aVar2.f1429c = currentTimeMillis;
            aVar2.f1430d = str;
            aVar2.f1431e = str2;
            a(this.f1441a, "ld_start", new Object[0]);
        }
    }
}
