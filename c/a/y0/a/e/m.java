package c.a.y0.a.e;

import android.app.Activity;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import c.a.y0.a.c;
import c.a.y0.a.e.a;
import c.a.y0.a.e.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubs.analytics.a.n;
import java.util.UUID;
/* loaded from: classes9.dex */
public final class m implements a.InterfaceC1590a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static n f27670f;

    /* renamed from: g  reason: collision with root package name */
    public static long f27671g;

    /* renamed from: h  reason: collision with root package name */
    public static long f27672h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f27673b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f27674c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f27675d;

    /* renamed from: e  reason: collision with root package name */
    public e f27676e;

    /* loaded from: classes9.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m a;

        /* renamed from: c.a.y0.a.e.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1591a extends c.a.y0.a.f.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1591a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.y0.a.f.c
            public final void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.y0.a.f.a.b("记录一次app启动事件");
                    c.a.y0.a.a.c("power_on", "", "", null);
                    c.a.y0.a.c.h().d(false);
                }
            }
        }

        public a(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mVar;
        }

        @Override // c.a.y0.a.e.m.e
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                c.a.y0.a.f.a.b("app   went foreground ");
                if (currentTimeMillis - m.f27672h > m.f27671g) {
                    this.a.n(currentTimeMillis);
                }
                if (c.a.y0.a.c.h().g()) {
                    c.a.y0.a.f.b.a(new C1591a(this));
                }
            }
        }

        @Override // c.a.y0.a.e.m.e
        public final void b() {
            c.a.y0.a.e.d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                dVar = d.a.a;
                if (dVar.a().size() == 0) {
                    c.a.y0.a.f.a.b("后台应用退出了 了               ");
                    c.a.y0.a.c.h().d(true);
                    long unused = m.f27672h = 0L;
                    return;
                }
                c.a.y0.a.f.a.b("进入后台但没退出                  ");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f27677e;

        public b(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27677e = mVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f27677e.a && this.f27677e.f27673b) {
                this.f27677e.a = false;
                try {
                    this.f27677e.f27676e.b();
                } catch (Exception e2) {
                    c.a.y0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends c.a.y0.a.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.y0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                m.f27670f.z(String.valueOf(currentTimeMillis));
                try {
                    m.f27670f.A(String.valueOf(currentTimeMillis - Long.parseLong(m.f27670f.N())));
                } catch (NumberFormatException e2) {
                    c.a.y0.a.f.a.b(e2.getLocalizedMessage());
                }
                c.l lVar = new c.l();
                if (lVar.b(m.f27670f.I())) {
                    lVar.e(m.f27670f);
                } else {
                    lVar.f(m.f27670f);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends c.a.y0.a.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.y0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.y0.a.f.a.b("超时了……………… 一个新的session");
                new c.l().f(m.f27670f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a();

        void b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-446363176, "Lc/a/y0/a/e/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-446363176, "Lc/a/y0/a/e/m;");
                return;
            }
        }
        f27671g = f.a();
    }

    public m() {
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
        this.a = false;
        this.f27673b = true;
        this.f27674c = new Handler();
        this.f27676e = new a(this);
        long currentTimeMillis = System.currentTimeMillis();
        f27672h = currentTimeMillis;
        n(currentTimeMillis);
    }

    public static n f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f27670f : (n) invokeV.objValue;
    }

    @Override // c.a.y0.a.e.a.InterfaceC1590a
    public final void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
        }
    }

    @Override // c.a.y0.a.e.a.InterfaceC1590a
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f27673b = false;
            boolean z = !this.a;
            this.a = true;
            Runnable runnable = this.f27675d;
            if (runnable != null) {
                this.f27674c.removeCallbacks(runnable);
            }
            if (z) {
                try {
                    this.f27676e.a();
                } catch (Exception e2) {
                    c.a.y0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    @Override // c.a.y0.a.e.a.InterfaceC1590a
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f27673b = true;
            Runnable runnable = this.f27675d;
            if (runnable != null) {
                this.f27674c.removeCallbacks(runnable);
                this.f27675d = null;
            }
            f27672h = System.currentTimeMillis();
            c.a.y0.a.f.b.c(new c(this));
            Handler handler = this.f27674c;
            b bVar = new b(this);
            this.f27675d = bVar;
            handler.postDelayed(bVar, 1000L);
        }
    }

    public final void n(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            n nVar = new n();
            f27670f = nVar;
            nVar.setStartTime(String.valueOf(j2));
            f27670f.x(UUID.randomUUID().toString().replace("-", ""));
            c.a.y0.a.f.b.c(new d(this));
        }
    }

    @Override // c.a.y0.a.e.a.InterfaceC1590a
    public final void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
        }
    }
}
