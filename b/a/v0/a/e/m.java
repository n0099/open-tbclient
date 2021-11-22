package b.a.v0.a.e;

import android.app.Activity;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import b.a.v0.a.c;
import b.a.v0.a.e.a;
import b.a.v0.a.e.d;
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
/* loaded from: classes6.dex */
public final class m implements a.InterfaceC1446a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static n f29995f;

    /* renamed from: g  reason: collision with root package name */
    public static long f29996g;

    /* renamed from: h  reason: collision with root package name */
    public static long f29997h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f29998a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f29999b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f30000c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f30001d;

    /* renamed from: e  reason: collision with root package name */
    public e f30002e;

    /* loaded from: classes6.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f30003a;

        /* renamed from: b.a.v0.a.e.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1447a extends b.a.v0.a.f.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1447a(a aVar) {
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

            @Override // b.a.v0.a.f.c
            public final void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.v0.a.f.a.b("记录一次app启动事件");
                    b.a.v0.a.a.c("power_on", "", "", null);
                    b.a.v0.a.c.h().d(false);
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
            this.f30003a = mVar;
        }

        @Override // b.a.v0.a.e.m.e
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                b.a.v0.a.f.a.b("app   went foreground ");
                if (currentTimeMillis - m.f29997h > m.f29996g) {
                    this.f30003a.n(currentTimeMillis);
                }
                if (b.a.v0.a.c.h().g()) {
                    b.a.v0.a.f.b.a(new C1447a(this));
                }
            }
        }

        @Override // b.a.v0.a.e.m.e
        public final void b() {
            b.a.v0.a.e.d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                dVar = d.a.f29971a;
                if (dVar.a().size() == 0) {
                    b.a.v0.a.f.a.b("后台应用退出了 了               ");
                    b.a.v0.a.c.h().d(true);
                    long unused = m.f29997h = 0L;
                    return;
                }
                b.a.v0.a.f.a.b("进入后台但没退出                  ");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f30004e;

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
            this.f30004e = mVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f30004e.f29998a && this.f30004e.f29999b) {
                this.f30004e.f29998a = false;
                try {
                    this.f30004e.f30002e.b();
                } catch (Exception e2) {
                    b.a.v0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends b.a.v0.a.f.c {
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

        @Override // b.a.v0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                m.f29995f.z(String.valueOf(currentTimeMillis));
                try {
                    m.f29995f.A(String.valueOf(currentTimeMillis - Long.parseLong(m.f29995f.N())));
                } catch (NumberFormatException e2) {
                    b.a.v0.a.f.a.b(e2.getLocalizedMessage());
                }
                c.l lVar = new c.l();
                if (lVar.b(m.f29995f.I())) {
                    lVar.e(m.f29995f);
                } else {
                    lVar.f(m.f29995f);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends b.a.v0.a.f.c {
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

        @Override // b.a.v0.a.f.c
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.v0.a.f.a.b("超时了……………… 一个新的session");
                new c.l().f(m.f29995f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a();

        void b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(974435924, "Lb/a/v0/a/e/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(974435924, "Lb/a/v0/a/e/m;");
                return;
            }
        }
        f29996g = f.a();
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
        this.f29998a = false;
        this.f29999b = true;
        this.f30000c = new Handler();
        this.f30002e = new a(this);
        long currentTimeMillis = System.currentTimeMillis();
        f29997h = currentTimeMillis;
        n(currentTimeMillis);
    }

    public static n f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f29995f : (n) invokeV.objValue;
    }

    @Override // b.a.v0.a.e.a.InterfaceC1446a
    public final void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
        }
    }

    @Override // b.a.v0.a.e.a.InterfaceC1446a
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f29999b = false;
            boolean z = !this.f29998a;
            this.f29998a = true;
            Runnable runnable = this.f30001d;
            if (runnable != null) {
                this.f30000c.removeCallbacks(runnable);
            }
            if (z) {
                try {
                    this.f30002e.a();
                } catch (Exception e2) {
                    b.a.v0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    @Override // b.a.v0.a.e.a.InterfaceC1446a
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f29999b = true;
            Runnable runnable = this.f30001d;
            if (runnable != null) {
                this.f30000c.removeCallbacks(runnable);
                this.f30001d = null;
            }
            f29997h = System.currentTimeMillis();
            b.a.v0.a.f.b.c(new c(this));
            Handler handler = this.f30000c;
            b bVar = new b(this);
            this.f30001d = bVar;
            handler.postDelayed(bVar, 1000L);
        }
    }

    public final void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            n nVar = new n();
            f29995f = nVar;
            nVar.setStartTime(String.valueOf(j));
            f29995f.x(UUID.randomUUID().toString().replace("-", ""));
            b.a.v0.a.f.b.c(new d(this));
        }
    }

    @Override // b.a.v0.a.e.a.InterfaceC1446a
    public final void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
        }
    }
}
