package b.a.p0.a.n0;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.e0.b;
import b.a.p0.a.k;
import b.a.p0.a.n0.d;
import b.a.p0.a.p.d.t;
import b.a.p0.a.p.d.v0;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.w0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class f implements d.InterfaceC0306d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f6786c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f6787a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f6788b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v0 f6789e;

        public a(f fVar, v0 v0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, v0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6789e = v0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6789e.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f6790e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f6791f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f6792g;

        public b(f fVar, int i2, Bundle bundle) {
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
            this.f6792g = fVar;
            this.f6790e = i2;
            this.f6791f = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (f.f6786c) {
                    String str = "zygoteSwanProcess delay - run. switch: " + this.f6790e;
                }
                b.a.p0.a.v1.c.f.b.k(this.f6792g.a(), this.f6791f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final f f6793a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1667549971, "Lb/a/p0/a/n0/f$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1667549971, "Lb/a/p0/a/n0/f$c;");
                    return;
                }
            }
            f6793a = new f(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1330106892, "Lb/a/p0/a/n0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1330106892, "Lb/a/p0/a/n0/f;");
                return;
            }
        }
        f6786c = k.f6397a;
    }

    public /* synthetic */ f(a aVar) {
        this();
    }

    public static f c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.f6793a : (f) invokeV.objValue;
    }

    @Override // b.a.p0.a.n0.b
    @NonNull
    public Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    public d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6787a : (d) invokeV.objValue;
    }

    public void e(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) || this.f6788b) {
            return;
        }
        synchronized (this) {
            if (!this.f6788b) {
                f(bundle);
                this.f6788b = true;
            }
        }
    }

    public final void f(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            g(bundle);
            SwanLauncher.j().l(null);
            b.C0145b.e();
            w0.a();
            ExecutorUtilsExt.postOnElastic(new a(this, b.a.p0.a.c1.a.j0()), "requestBatchRebateInfo", 2);
        }
    }

    public final void g(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            boolean z = f6786c;
            t f2 = b.a.p0.a.c1.a.f();
            if (f2 == null) {
                return;
            }
            int a2 = f2.a();
            if (f6786c) {
                String str = "zygoteSwanProcess switch : " + a2;
            }
            if (f2.e()) {
                return;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (TextUtils.isEmpty(bundle.getString("bundle_key_preload_preload_scene"))) {
                bundle.putString("bundle_key_preload_preload_scene", "0");
            }
            if (bundle.getBoolean("bundle_key_preload_delay", false) && f2.f()) {
                if (f6786c) {
                    String str2 = "zygoteSwanProcess delay - start. switch: " + a2;
                }
                q0.Y(new b(this, a2, bundle), b.a.p0.a.c1.a.f().c());
                return;
            }
            if (f6786c) {
                String str3 = "zygoteSwanProcess start. switch: " + a2;
            }
            b.a.p0.a.v1.c.f.b.k(a(), bundle);
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
        this.f6788b = false;
        this.f6787a = new d(this);
        b.a.p0.a.p0.e.a.d().f();
    }
}
