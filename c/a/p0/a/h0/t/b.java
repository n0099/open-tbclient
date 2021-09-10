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
    public static final boolean f6443i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppSlaveManager f6444a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f6445b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f6446c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f6447d;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f6448e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a.l1.b f6449f;

    /* renamed from: g  reason: collision with root package name */
    public String f6450g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f6451h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f6452e;

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
            this.f6452e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6452e.b();
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
        f6443i = k.f7077a;
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
        this.f6445b = false;
        this.f6446c = false;
        this.f6447d = false;
        this.f6451h = false;
        this.f6444a = swanAppSlaveManager;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q.c(new a(this), "delayDownloadGuideRes", 3L, TimeUnit.SECONDS);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f6446c || this.f6451h) {
            return;
        }
        this.f6451h = true;
        c.a.p0.a.c1.a.e0().c(d.g().getAppId());
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f6446c) {
            SwanAppSlaveManager swanAppSlaveManager = this.f6444a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            h.e(this.f6450g, "realsuccess", swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.N(), this.f6448e);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f6445b = true;
            if (this.f6444a instanceof SwanAppWebViewWidget) {
                return;
            }
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!(this.f6444a instanceof SwanAppWebViewWidget)) {
                f();
            }
            this.f6445b = false;
            this.f6448e = h.c();
            if (this.f6446c) {
                h.e(this.f6450g, "success", null, this.f6448e);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f6447d = false;
            boolean b2 = h.b();
            boolean a2 = h.a();
            if (b2) {
                this.f6446c = false;
            } else if (this.f6445b) {
                this.f6446c = true;
                if (a2) {
                    return;
                }
                h.g(this.f6450g);
                if (f6443i) {
                    String str = "mCurPageParams = " + this.f6449f;
                }
            } else {
                this.f6446c = !TextUtils.isEmpty(this.f6444a.i0());
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (f6443i) {
                String str = "mCurPageParams = " + this.f6449f;
            }
            if (!this.f6446c || this.f6447d) {
                return;
            }
            this.f6447d = true;
            SwanAppSlaveManager swanAppSlaveManager = this.f6444a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            c.a.p0.a.p.e.j.d N = swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.N();
            if (N != null && N.f7893c > 0) {
                h.e(this.f6450g, "arrivesuccess", N, this.f6448e);
            } else {
                h.e(this.f6450g, "arrivecancel", N, this.f6448e);
            }
        }
    }

    public void h(@NonNull c.a.p0.a.l1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f6449f = bVar;
            this.f6450g = bVar.f7236e;
        }
    }
}
