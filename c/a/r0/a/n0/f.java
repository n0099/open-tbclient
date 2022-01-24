package c.a.r0.a.n0;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.e0.b;
import c.a.r0.a.k;
import c.a.r0.a.n0.d;
import c.a.r0.a.p.d.a1;
import c.a.r0.a.p.d.t;
import c.a.r0.a.z2.q0;
import c.a.r0.a.z2.x0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class f implements d.InterfaceC0476d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f7901d;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.a.n0.d a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f7902b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f7903c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a1 f7904e;

        public a(f fVar, a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7904e = a1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7904e.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.c1.a.s0().b();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f7905e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f7906f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f7907g;

        public c(f fVar, int i2, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2), bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7907g = fVar;
            this.f7905e = i2;
            this.f7906f = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (f.f7901d) {
                    String str = "zygoteSwanProcess delay - run. switch: " + this.f7905e;
                }
                c.a.r0.a.y1.c.f.b.k(this.f7907g.a(), this.f7906f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final f a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1919918679, "Lc/a/r0/a/n0/f$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1919918679, "Lc/a/r0/a/n0/f$d;");
                    return;
                }
            }
            a = new f(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(431521257, "Lc/a/r0/a/n0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(431521257, "Lc/a/r0/a/n0/f;");
                return;
            }
        }
        f7901d = k.a;
    }

    public /* synthetic */ f(a aVar) {
        this();
    }

    public static f c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d.a : (f) invokeV.objValue;
    }

    @Override // c.a.r0.a.n0.b
    @NonNull
    public Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    public c.a.r0.a.n0.d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (c.a.r0.a.n0.d) invokeV.objValue;
    }

    public void e(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) || this.f7902b) {
            return;
        }
        synchronized (this) {
            if (!this.f7902b) {
                f(bundle);
                this.f7902b = true;
            }
        }
    }

    public final void f(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            g(bundle);
            SwanLauncher.j().l(null);
            b.C0306b.d();
            x0.a();
            if (f7901d) {
                String str = "swan_env_init_thread_pool_optimize: " + this.f7903c;
            }
            if (this.f7903c) {
                ExecutorUtilsExt.postOnElastic(new a(this, c.a.r0.a.c1.a.s0()), "requestBatchRebateInfo", 2);
            } else {
                ExecutorUtilsExt.postOnElastic(new b(this), "requestBatchRebateInfo", 2);
            }
        }
    }

    public final void g(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            boolean z = f7901d;
            t g2 = c.a.r0.a.c1.a.g();
            if (g2 == null) {
                return;
            }
            int a2 = g2.a();
            if (f7901d) {
                String str = "zygoteSwanProcess switch : " + a2;
            }
            if (g2.e()) {
                return;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (TextUtils.isEmpty(bundle.getString("bundle_key_preload_preload_scene"))) {
                bundle.putString("bundle_key_preload_preload_scene", "0");
            }
            if (bundle.getBoolean("bundle_key_preload_delay", false) && g2.f()) {
                if (f7901d) {
                    String str2 = "zygoteSwanProcess delay - start. switch: " + a2;
                }
                q0.b0(new c(this, a2, bundle), c.a.r0.a.c1.a.g().c());
                return;
            }
            if (f7901d) {
                String str3 = "zygoteSwanProcess start. switch: " + a2;
            }
            c.a.r0.a.y1.c.f.b.k(a(), bundle);
        }
    }

    public f() {
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
        this.f7902b = false;
        c.a.r0.a.c1.a.g0().getSwitch("swan_env_init_thread_pool_optimize", true);
        this.f7903c = true;
        this.a = new c.a.r0.a.n0.d(this);
        c.a.r0.a.w0.d.i();
        SwanFavorDataManager.h();
        c.a.r0.a.p0.e.a.d().f();
    }
}
