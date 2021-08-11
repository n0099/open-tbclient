package c.a.n0.a.h0.t;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.n0.a.a2.d;
import c.a.n0.a.j2.h;
import c.a.n0.a.k;
import c.a.n0.a.v2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f6169i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppSlaveManager f6170a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f6171b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f6172c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f6173d;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f6174e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.a.l1.b f6175f;

    /* renamed from: g  reason: collision with root package name */
    public String f6176g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f6177h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f6178e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6178e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6178e.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(829090534, "Lc/a/n0/a/h0/t/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(829090534, "Lc/a/n0/a/h0/t/b;");
                return;
            }
        }
        f6169i = k.f6803a;
    }

    public b(@NonNull SwanAppSlaveManager swanAppSlaveManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppSlaveManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6171b = false;
        this.f6172c = false;
        this.f6173d = false;
        this.f6177h = false;
        this.f6170a = swanAppSlaveManager;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q.c(new a(this), "delayDownloadGuideRes", 3L, TimeUnit.SECONDS);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f6172c || this.f6177h) {
            return;
        }
        this.f6177h = true;
        c.a.n0.a.c1.a.e0().c(d.g().getAppId());
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f6172c) {
            SwanAppSlaveManager swanAppSlaveManager = this.f6170a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            h.e(this.f6176g, "realsuccess", swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.N(), this.f6174e);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f6171b = true;
            if (this.f6170a instanceof SwanAppWebViewWidget) {
                return;
            }
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!(this.f6170a instanceof SwanAppWebViewWidget)) {
                f();
            }
            this.f6171b = false;
            this.f6174e = h.c();
            if (this.f6172c) {
                h.e(this.f6176g, "success", null, this.f6174e);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f6173d = false;
            boolean b2 = h.b();
            boolean a2 = h.a();
            if (b2) {
                this.f6172c = false;
            } else if (this.f6171b) {
                this.f6172c = true;
                if (a2) {
                    return;
                }
                h.g(this.f6176g);
                if (f6169i) {
                    String str = "mCurPageParams = " + this.f6175f;
                }
            } else {
                this.f6172c = !TextUtils.isEmpty(this.f6170a.i0());
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (f6169i) {
                String str = "mCurPageParams = " + this.f6175f;
            }
            if (!this.f6172c || this.f6173d) {
                return;
            }
            this.f6173d = true;
            SwanAppSlaveManager swanAppSlaveManager = this.f6170a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            c.a.n0.a.p.e.j.d N = swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.N();
            if (N != null && N.f7619c > 0) {
                h.e(this.f6176g, "arrivesuccess", N, this.f6174e);
            } else {
                h.e(this.f6176g, "arrivecancel", N, this.f6174e);
            }
        }
    }

    public void h(@NonNull c.a.n0.a.l1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f6175f = bVar;
            this.f6176g = bVar.f6962e;
        }
    }
}
