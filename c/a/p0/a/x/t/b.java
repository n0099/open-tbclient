package c.a.p0.a.x.t;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.d2.i;
import c.a.p0.a.p2.q;
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
    public static final boolean f8864g;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppSlaveManager a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f8865b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f8866c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f8867d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a.c1.b f8868e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f8869f;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f8870e;

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
            this.f8870e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8870e.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78564482, "Lc/a/p0/a/x/t/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(78564482, "Lc/a/p0/a/x/t/b;");
                return;
            }
        }
        f8864g = c.a.p0.a.a.a;
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
        this.f8865b = false;
        this.f8866c = false;
        this.f8867d = false;
        this.f8869f = false;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f8866c || this.f8869f) {
            return;
        }
        this.f8869f = true;
        c.a.p0.a.s0.a.l0().c(c.a.p0.a.t1.d.J().getAppId());
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f8866c) {
            SwanAppSlaveManager swanAppSlaveManager = this.a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            i.d(this.f8868e, "realsuccess", swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.O());
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f8865b = true;
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
            this.f8865b = false;
            if (this.f8866c) {
                i.d(this.f8868e, "success", null);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f8867d = false;
            boolean b2 = i.b();
            boolean a2 = i.a();
            if (b2) {
                this.f8866c = false;
            } else if (this.f8865b) {
                this.f8866c = true;
                if (a2) {
                    return;
                }
                this.f8868e.f4647j = UUID.randomUUID().toString();
                c.a.p0.a.c1.b bVar = this.f8868e;
                bVar.f4646i = "6";
                i.h(bVar);
                if (f8864g) {
                    String str = "mCurPageParams = " + this.f8868e;
                }
            } else {
                this.f8866c = !TextUtils.isEmpty(this.a.l0());
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (f8864g) {
                String str = "mCurPageParams = " + this.f8868e;
            }
            if (!this.f8866c || this.f8867d) {
                return;
            }
            this.f8867d = true;
            SwanAppSlaveManager swanAppSlaveManager = this.a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            c.a.p0.a.f.e.j.d O = swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.O();
            if (O != null && O.f5130c > 0) {
                i.d(this.f8868e, "arrivesuccess", O);
            } else {
                i.d(this.f8868e, "arrivecancel", O);
            }
        }
    }

    public void h(@NonNull c.a.p0.a.c1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f8868e = bVar;
        }
    }
}
