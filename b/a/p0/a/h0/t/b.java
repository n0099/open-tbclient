package b.a.p0.a.h0.t;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.k;
import b.a.p0.a.n2.i;
import b.a.p0.a.z2.q;
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
    public static final boolean f6114g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SwanAppSlaveManager f6115a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f6116b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f6117c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f6118d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.a.m1.b f6119e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f6120f;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f6121e;

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
            this.f6121e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6121e.b();
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
        f6114g = k.f6863a;
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
        this.f6116b = false;
        this.f6117c = false;
        this.f6118d = false;
        this.f6120f = false;
        this.f6115a = swanAppSlaveManager;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q.c(new a(this), "delayDownloadGuideRes", 3L, TimeUnit.SECONDS);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f6117c || this.f6120f) {
            return;
        }
        this.f6120f = true;
        b.a.p0.a.c1.a.l0().c(b.a.p0.a.d2.d.J().getAppId());
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f6117c) {
            SwanAppSlaveManager swanAppSlaveManager = this.f6115a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            i.d(this.f6119e, "realsuccess", swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.O());
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f6116b = true;
            if (this.f6115a instanceof SwanAppWebViewWidget) {
                return;
            }
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!(this.f6115a instanceof SwanAppWebViewWidget)) {
                f();
            }
            this.f6116b = false;
            if (this.f6117c) {
                i.d(this.f6119e, "success", null);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f6118d = false;
            boolean b2 = i.b();
            boolean a2 = i.a();
            if (b2) {
                this.f6117c = false;
            } else if (this.f6116b) {
                this.f6117c = true;
                if (a2) {
                    return;
                }
                this.f6119e.j = UUID.randomUUID().toString();
                b.a.p0.a.m1.b bVar = this.f6119e;
                bVar.f7018i = "6";
                i.h(bVar);
                if (f6114g) {
                    String str = "mCurPageParams = " + this.f6119e;
                }
            } else {
                this.f6117c = !TextUtils.isEmpty(this.f6115a.l0());
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (f6114g) {
                String str = "mCurPageParams = " + this.f6119e;
            }
            if (!this.f6117c || this.f6118d) {
                return;
            }
            this.f6118d = true;
            SwanAppSlaveManager swanAppSlaveManager = this.f6115a;
            SwanAppWebViewWidget swanAppWebViewWidget = swanAppSlaveManager.C;
            b.a.p0.a.p.e.j.d O = swanAppWebViewWidget == null ? swanAppSlaveManager.L : swanAppWebViewWidget.O();
            if (O != null && O.f7609c > 0) {
                i.d(this.f6119e, "arrivesuccess", O);
            } else {
                i.d(this.f6119e, "arrivecancel", O);
            }
        }
    }

    public void h(@NonNull b.a.p0.a.m1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f6119e = bVar;
        }
    }
}
