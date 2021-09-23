package c.a.p0.a.h0.t;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.a2.d;
import c.a.p0.a.j2.h;
import c.a.p0.a.k;
import c.a.p0.a.v2.q;
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
    public static final boolean f6451i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppSlaveManager f6452a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f6453b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f6454c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f6455d;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f6456e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a.l1.b f6457f;

    /* renamed from: g  reason: collision with root package name */
    public String f6458g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f6459h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f6460e;

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
            this.f6460e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6460e.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1087255972, "Lc/a/p0/a/h0/t/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1087255972, "Lc/a/p0/a/h0/t/b;");
                return;
            }
        }
        f6451i = k.f7085a;
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
        this.f6453b = false;
        this.f6454c = false;
        this.f6455d = false;
        this.f6459h = false;
        this.f6452a = swanAppSlaveManager;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q.c(new a(this), "delayDownloadGuideRes", 3L, TimeUnit.SECONDS);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f6454c || this.f6459h) {
            return;
        }
        this.f6459h = true;
        c.a.p0.a.c1.a.e0().c(d.g().getAppId());
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f6454c) {
            SwanAppSlaveManager swanAppSlaveManager = this.f6452a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            h.e(this.f6458g, "realsuccess", swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.N(), this.f6456e);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f6453b = true;
            if (this.f6452a instanceof SwanAppWebViewWidget) {
                return;
            }
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!(this.f6452a instanceof SwanAppWebViewWidget)) {
                f();
            }
            this.f6453b = false;
            this.f6456e = h.c();
            if (this.f6454c) {
                h.e(this.f6458g, "success", null, this.f6456e);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f6455d = false;
            boolean b2 = h.b();
            boolean a2 = h.a();
            if (b2) {
                this.f6454c = false;
            } else if (this.f6453b) {
                this.f6454c = true;
                if (a2) {
                    return;
                }
                h.g(this.f6458g);
                if (f6451i) {
                    String str = "mCurPageParams = " + this.f6457f;
                }
            } else {
                this.f6454c = !TextUtils.isEmpty(this.f6452a.i0());
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (f6451i) {
                String str = "mCurPageParams = " + this.f6457f;
            }
            if (!this.f6454c || this.f6455d) {
                return;
            }
            this.f6455d = true;
            SwanAppSlaveManager swanAppSlaveManager = this.f6452a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            c.a.p0.a.p.e.j.d N = swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.N();
            if (N != null && N.f7901c > 0) {
                h.e(this.f6458g, "arrivesuccess", N, this.f6456e);
            } else {
                h.e(this.f6458g, "arrivecancel", N, this.f6456e);
            }
        }
    }

    public void h(@NonNull c.a.p0.a.l1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f6457f = bVar;
            this.f6458g = bVar.f7244e;
        }
    }
}
