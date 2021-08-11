package b.a.a.a.x.f.g;

import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import b.a.a.a.u.c;
import b.a.a.a.u.h;
import b.a.a.a.x.f.d;
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
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final d f1518b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a f1519a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1274790180, "Lb/a/a/a/x/f/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1274790180, "Lb/a/a/a/x/f/g/b;");
                return;
            }
        }
        f1518b = d.a();
    }

    public b() {
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
        this.f1519a = new a();
    }

    public static void c(a aVar, Object obj, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, aVar, obj, objArr) == null) {
            String str = aVar.f1513a;
            int i2 = aVar.f1514b;
            String str2 = aVar.f1516d;
            f1518b.c("ad", new a.a.a.a.w.g.g.b(aVar.f1515c, str, i2, aVar.f1517e, str2, obj, false, objArr));
        }
    }

    public static void g(boolean z, a aVar, Object obj, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), aVar, obj, objArr}) == null) {
            f1518b.c("ad", new a.a.a.a.w.g.g.b(aVar.f1515c, aVar.f1513a, aVar.f1514b, aVar.f1517e, aVar.f1516d, obj, z, objArr));
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c(this.f1519a, "left_app", new Object[0]);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            c(this.f1519a, "render_failed", NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i2));
        }
    }

    public void d(FunAdSlot funAdSlot, h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, funAdSlot, aVar) == null) {
            int a2 = c.a(funAdSlot.getSid(), aVar);
            a aVar2 = this.f1519a;
            String sid = funAdSlot.getSid();
            long currentTimeMillis = System.currentTimeMillis();
            String str = aVar.f1448c;
            String str2 = aVar.f1449d;
            aVar2.f1513a = sid;
            aVar2.f1514b = a2;
            aVar2.f1515c = currentTimeMillis;
            aVar2.f1516d = str;
            aVar2.f1517e = str2;
            c(this.f1519a, "ld_start", new Object[0]);
        }
    }

    public void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            c(this.f1519a, "ld_err", NotificationCompat.CATEGORY_ERROR, obj);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            g(z, this.f1519a, "onclick", new Object[0]);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c(this.f1519a, "ld_succeed", new Object[0]);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            c(this.f1519a, "video_err", NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i2));
        }
    }

    public void j(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            c(this.f1519a, "sh_failed", NotificationCompat.CATEGORY_ERROR, obj);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            g(z, this.f1519a, "sh_succeed", new Object[0]);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c(this.f1519a, "oncached", new Object[0]);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c(this.f1519a, "onclosed", new Object[0]);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c(this.f1519a, "render_succeed", new Object[0]);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c(this.f1519a, "reward", new Object[0]);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c(this.f1519a, "sh_start", new Object[0]);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c(this.f1519a, "splash_skip", new Object[0]);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c(this.f1519a, "unlike_selected", new Object[0]);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c(this.f1519a, "video_complete", new Object[0]);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            c(this.f1519a, "video_err", new Object[0]);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c(this.f1519a, "video_pause", new Object[0]);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c(this.f1519a, "video_resume", new Object[0]);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            c(this.f1519a, "video_skip", new Object[0]);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            c(this.f1519a, "video_start", new Object[0]);
        }
    }
}
