package c.a.n0.a.x.t;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.n0.a.d2.i;
import c.a.n0.a.p2.q;
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
import java.util.UUID;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f7453g;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppSlaveManager a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f7454b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f7455c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f7456d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.a.c1.b f7457e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f7458f;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622500096, "Lc/a/n0/a/x/t/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622500096, "Lc/a/n0/a/x/t/b;");
                return;
            }
        }
        f7453g = c.a.n0.a.a.a;
    }

    public b(@NonNull SwanAppSlaveManager swanAppSlaveManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppSlaveManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7454b = false;
        this.f7455c = false;
        this.f7456d = false;
        this.f7458f = false;
        this.a = swanAppSlaveManager;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q.c(new a(this), "delayDownloadGuideRes", 3L, TimeUnit.SECONDS);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f7455c || this.f7458f) {
            return;
        }
        this.f7458f = true;
        c.a.n0.a.s0.a.l0().c(c.a.n0.a.t1.d.J().getAppId());
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f7455c) {
            SwanAppSlaveManager swanAppSlaveManager = this.a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.y;
            i.d(this.f7457e, "realsuccess", swanAppWebViewWidget == null ? swanAppSlaveManager.H : swanAppWebViewWidget.P());
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f7454b = true;
            if (this.a instanceof SwanAppWebViewWidget) {
                return;
            }
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!(this.a instanceof SwanAppWebViewWidget)) {
                f();
            }
            this.f7454b = false;
            if (this.f7455c) {
                i.d(this.f7457e, "success", null);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f7456d = false;
            boolean b2 = i.b();
            boolean a2 = i.a();
            if (b2) {
                this.f7455c = false;
            } else if (this.f7454b) {
                this.f7455c = true;
                if (a2) {
                    return;
                }
                this.f7457e.f3951f = UUID.randomUUID().toString();
                c.a.n0.a.c1.b bVar = this.f7457e;
                bVar.f3950e = "6";
                i.h(bVar);
                if (f7453g) {
                    Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.f7457e);
                }
            } else {
                this.f7455c = !TextUtils.isEmpty(this.a.m0());
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (f7453g) {
                Log.d("SwanAppSlavePresenter", "mCurPageParams = " + this.f7457e);
            }
            if (!this.f7455c || this.f7456d) {
                return;
            }
            this.f7456d = true;
            SwanAppSlaveManager swanAppSlaveManager = this.a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.y;
            c.a.n0.a.f.e.j.d P = swanAppWebViewWidget == null ? swanAppSlaveManager.H : swanAppWebViewWidget.P();
            if (P != null && P.f4339c > 0) {
                i.d(this.f7457e, "arrivesuccess", P);
            } else {
                i.d(this.f7457e, "arrivecancel", P);
            }
        }
    }

    public void h(@NonNull c.a.n0.a.c1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f7457e = bVar;
        }
    }
}
