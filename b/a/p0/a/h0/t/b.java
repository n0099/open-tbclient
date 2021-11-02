package b.a.p0.a.h0.t;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.a2.d;
import b.a.p0.a.j2.h;
import b.a.p0.a.k;
import b.a.p0.a.v2.q;
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
    public static final boolean f5784i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppSlaveManager f5785a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f5786b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f5787c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f5788d;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f5789e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.p0.a.l1.b f5790f;

    /* renamed from: g  reason: collision with root package name */
    public String f5791g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f5792h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f5793e;

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
            this.f5793e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5793e.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597790149, "Lb/a/p0/a/h0/t/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597790149, "Lb/a/p0/a/h0/t/b;");
                return;
            }
        }
        f5784i = k.f6397a;
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
        this.f5786b = false;
        this.f5787c = false;
        this.f5788d = false;
        this.f5792h = false;
        this.f5785a = swanAppSlaveManager;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q.c(new a(this), "delayDownloadGuideRes", 3L, TimeUnit.SECONDS);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f5787c || this.f5792h) {
            return;
        }
        this.f5792h = true;
        b.a.p0.a.c1.a.e0().c(d.g().getAppId());
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f5787c) {
            SwanAppSlaveManager swanAppSlaveManager = this.f5785a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            h.e(this.f5791g, "realsuccess", swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.M(), this.f5789e);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f5786b = true;
            if (this.f5785a instanceof SwanAppWebViewWidget) {
                return;
            }
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!(this.f5785a instanceof SwanAppWebViewWidget)) {
                f();
            }
            this.f5786b = false;
            this.f5789e = h.c();
            if (this.f5787c) {
                h.e(this.f5791g, "success", null, this.f5789e);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f5788d = false;
            boolean b2 = h.b();
            boolean a2 = h.a();
            if (b2) {
                this.f5787c = false;
            } else if (this.f5786b) {
                this.f5787c = true;
                if (a2) {
                    return;
                }
                h.g(this.f5791g);
                if (f5784i) {
                    String str = "mCurPageParams = " + this.f5790f;
                }
            } else {
                this.f5787c = !TextUtils.isEmpty(this.f5785a.h0());
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (f5784i) {
                String str = "mCurPageParams = " + this.f5790f;
            }
            if (!this.f5787c || this.f5788d) {
                return;
            }
            this.f5788d = true;
            SwanAppSlaveManager swanAppSlaveManager = this.f5785a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            b.a.p0.a.p.e.j.d M = swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.M();
            if (M != null && M.f7194c > 0) {
                h.e(this.f5791g, "arrivesuccess", M, this.f5789e);
            } else {
                h.e(this.f5791g, "arrivecancel", M, this.f5789e);
            }
        }
    }

    public void h(@NonNull b.a.p0.a.l1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f5790f = bVar;
            this.f5791g = bVar.f6555e;
        }
    }
}
