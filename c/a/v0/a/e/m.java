package c.a.v0.a.e;

import android.app.Activity;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import c.a.v0.a.c;
import c.a.v0.a.e.a;
import c.a.v0.a.e.d;
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
/* loaded from: classes4.dex */
public final class m implements a.InterfaceC1404a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static n f30400f;

    /* renamed from: g  reason: collision with root package name */
    public static long f30401g;

    /* renamed from: h  reason: collision with root package name */
    public static long f30402h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f30403a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30404b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f30405c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f30406d;

    /* renamed from: e  reason: collision with root package name */
    public e f30407e;

    /* loaded from: classes4.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f30408a;

        /* renamed from: c.a.v0.a.e.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1405a extends c.a.v0.a.f.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1405a(a aVar) {
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

            @Override // c.a.v0.a.f.c
            public final void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.v0.a.f.a.b("记录一次app启动事件");
                    c.a.v0.a.a.c("power_on", "", "", null);
                    c.a.v0.a.c.i().d(false);
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
            this.f30408a = mVar;
        }

        @Override // c.a.v0.a.e.m.e
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                c.a.v0.a.f.a.b("app   went foreground ");
                if (currentTimeMillis - m.f30402h > m.f30401g) {
                    this.f30408a.m(currentTimeMillis);
                }
                if (c.a.v0.a.c.i().h()) {
                    c.a.v0.a.f.b.a(new C1405a(this));
                }
            }
        }

        @Override // c.a.v0.a.e.m.e
        public final void b() {
            c.a.v0.a.e.d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                dVar = d.a.f30376a;
                if (dVar.a().size() == 0) {
                    c.a.v0.a.f.a.b("后台应用退出了 了               ");
                    c.a.v0.a.c.i().d(true);
                    long unused = m.f30402h = 0L;
                    return;
                }
                c.a.v0.a.f.a.b("进入后台但没退出                  ");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f30409e;

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
            this.f30409e = mVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f30409e.f30403a && this.f30409e.f30404b) {
                this.f30409e.f30403a = false;
                try {
                    this.f30409e.f30407e.b();
                } catch (Exception e2) {
                    c.a.v0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends c.a.v0.a.f.c {
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

        @Override // c.a.v0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                m.f30400f.z(String.valueOf(currentTimeMillis));
                try {
                    m.f30400f.A(String.valueOf(currentTimeMillis - Long.parseLong(m.f30400f.N())));
                } catch (NumberFormatException e2) {
                    c.a.v0.a.f.a.b(e2.getLocalizedMessage());
                }
                c.l lVar = new c.l();
                if (lVar.b(m.f30400f.I())) {
                    lVar.e(m.f30400f);
                } else {
                    lVar.f(m.f30400f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends c.a.v0.a.f.c {
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

        @Override // c.a.v0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.v0.a.f.a.b("超时了……………… 一个新的session");
                new c.l().f(m.f30400f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(681032917, "Lc/a/v0/a/e/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(681032917, "Lc/a/v0/a/e/m;");
                return;
            }
        }
        f30401g = f.a();
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
        this.f30403a = false;
        this.f30404b = true;
        this.f30405c = new Handler();
        this.f30407e = new a(this);
        long currentTimeMillis = System.currentTimeMillis();
        f30402h = currentTimeMillis;
        m(currentTimeMillis);
    }

    public static n e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f30400f : (n) invokeV.objValue;
    }

    @Override // c.a.v0.a.e.a.InterfaceC1404a
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f30404b = false;
            boolean z = !this.f30403a;
            this.f30403a = true;
            Runnable runnable = this.f30406d;
            if (runnable != null) {
                this.f30405c.removeCallbacks(runnable);
            }
            if (z) {
                try {
                    this.f30407e.a();
                } catch (Exception e2) {
                    c.a.v0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    @Override // c.a.v0.a.e.a.InterfaceC1404a
    public final void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
        }
    }

    @Override // c.a.v0.a.e.a.InterfaceC1404a
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f30404b = true;
            Runnable runnable = this.f30406d;
            if (runnable != null) {
                this.f30405c.removeCallbacks(runnable);
                this.f30406d = null;
            }
            f30402h = System.currentTimeMillis();
            c.a.v0.a.f.b.c(new c(this));
            Handler handler = this.f30405c;
            b bVar = new b(this);
            this.f30406d = bVar;
            handler.postDelayed(bVar, 1000L);
        }
    }

    public final void m(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            n nVar = new n();
            f30400f = nVar;
            nVar.setStartTime(String.valueOf(j2));
            f30400f.x(UUID.randomUUID().toString().replace("-", ""));
            c.a.v0.a.f.b.c(new d(this));
        }
    }

    @Override // c.a.v0.a.e.a.InterfaceC1404a
    public final void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
        }
    }
}
