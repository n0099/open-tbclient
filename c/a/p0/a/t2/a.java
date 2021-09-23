package c.a.p0.a.t2;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.c1.b;
import c.a.p0.a.h2.e;
import c.a.p0.a.k;
import c.a.p0.a.v2.j;
import c.a.p0.a.v2.q;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f8721a;

    /* renamed from: b  reason: collision with root package name */
    public static int f8722b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.t2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0382a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f8723e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8724f;

        public RunnableC0382a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8723e = i2;
            this.f8724f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.b(this.f8723e, this.f8724f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(830148820, "Lc/a/p0/a/t2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(830148820, "Lc/a/p0/a/t2/a;");
                return;
            }
        }
        f8721a = k.f7085a;
        f8722b = 0;
    }

    public static void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, null, i2, i3) == null) {
            c.a.p0.a.p0.e.a.d().e(i2, i3);
            j.f();
            if (i2 == 0) {
                f8722b = 2;
            } else if (i3 > i2) {
                f8722b = 1;
                b.m().i();
                e.a.a();
                c.a.p0.a.h0.s.a.d();
            }
            if (f8721a) {
                String str = "App onUpgrade on thread: " + Thread.currentThread();
            }
        }
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f8722b : invokeV.intValue;
    }

    public static void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3) == null) {
            if (c.a.p0.a.c1.a.Z().l()) {
                q.j(new RunnableC0382a(i2, i3), "onUpgradeOperation");
            } else {
                b(i2, i3);
            }
        }
    }
}
