package c.a.w0.a.e;

import android.app.Activity;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import c.a.w0.a.c;
import c.a.w0.a.e.a;
import c.a.w0.a.e.d;
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
/* loaded from: classes3.dex */
public final class m implements a.InterfaceC1601a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static n f26440f;

    /* renamed from: g  reason: collision with root package name */
    public static long f26441g;

    /* renamed from: h  reason: collision with root package name */
    public static long f26442h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f26443b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f26444c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f26445d;

    /* renamed from: e  reason: collision with root package name */
    public e f26446e;

    /* loaded from: classes3.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m a;

        /* renamed from: c.a.w0.a.e.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1602a extends c.a.w0.a.f.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1602a(a aVar) {
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

            @Override // c.a.w0.a.f.c
            public final void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.w0.a.f.a.b("记录一次app启动事件");
                    c.a.w0.a.a.c("power_on", "", "", null);
                    c.a.w0.a.c.h().d(false);
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

        @Override // c.a.w0.a.e.m.e
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                c.a.w0.a.f.a.b("app   went foreground ");
                if (currentTimeMillis - m.f26442h > m.f26441g) {
                    this.a.n(currentTimeMillis);
                }
                if (c.a.w0.a.c.h().g()) {
                    c.a.w0.a.f.b.a(new C1602a(this));
                }
            }
        }

        @Override // c.a.w0.a.e.m.e
        public final void b() {
            c.a.w0.a.e.d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                dVar = d.a.a;
                if (dVar.a().size() == 0) {
                    c.a.w0.a.f.a.b("后台应用退出了 了               ");
                    c.a.w0.a.c.h().d(true);
                    long unused = m.f26442h = 0L;
                    return;
                }
                c.a.w0.a.f.a.b("进入后台但没退出                  ");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f26447e;

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
            this.f26447e = mVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f26447e.a && this.f26447e.f26443b) {
                this.f26447e.a = false;
                try {
                    this.f26447e.f26446e.b();
                } catch (Exception e2) {
                    c.a.w0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends c.a.w0.a.f.c {
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

        @Override // c.a.w0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                m.f26440f.z(String.valueOf(currentTimeMillis));
                try {
                    m.f26440f.A(String.valueOf(currentTimeMillis - Long.parseLong(m.f26440f.N())));
                } catch (NumberFormatException e2) {
                    c.a.w0.a.f.a.b(e2.getLocalizedMessage());
                }
                c.l lVar = new c.l();
                if (lVar.b(m.f26440f.I())) {
                    lVar.e(m.f26440f);
                } else {
                    lVar.f(m.f26440f);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends c.a.w0.a.f.c {
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

        @Override // c.a.w0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.w0.a.f.a.b("超时了……………… 一个新的session");
                new c.l().f(m.f26440f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a();

        void b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1126421546, "Lc/a/w0/a/e/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1126421546, "Lc/a/w0/a/e/m;");
                return;
            }
        }
        f26441g = f.a();
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
        this.f26443b = true;
        this.f26444c = new Handler();
        this.f26446e = new a(this);
        long currentTimeMillis = System.currentTimeMillis();
        f26442h = currentTimeMillis;
        n(currentTimeMillis);
    }

    public static n f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f26440f : (n) invokeV.objValue;
    }

    @Override // c.a.w0.a.e.a.InterfaceC1601a
    public final void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
        }
    }

    @Override // c.a.w0.a.e.a.InterfaceC1601a
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f26443b = false;
            boolean z = !this.a;
            this.a = true;
            Runnable runnable = this.f26445d;
            if (runnable != null) {
                this.f26444c.removeCallbacks(runnable);
            }
            if (z) {
                try {
                    this.f26446e.a();
                } catch (Exception e2) {
                    c.a.w0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    @Override // c.a.w0.a.e.a.InterfaceC1601a
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26443b = true;
            Runnable runnable = this.f26445d;
            if (runnable != null) {
                this.f26444c.removeCallbacks(runnable);
                this.f26445d = null;
            }
            f26442h = System.currentTimeMillis();
            c.a.w0.a.f.b.c(new c(this));
            Handler handler = this.f26444c;
            b bVar = new b(this);
            this.f26445d = bVar;
            handler.postDelayed(bVar, 1000L);
        }
    }

    public final void n(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            n nVar = new n();
            f26440f = nVar;
            nVar.setStartTime(String.valueOf(j2));
            f26440f.x(UUID.randomUUID().toString().replace("-", ""));
            c.a.w0.a.f.b.c(new d(this));
        }
    }

    @Override // c.a.w0.a.e.a.InterfaceC1601a
    public final void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
        }
    }
}
