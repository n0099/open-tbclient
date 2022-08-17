package com.baidu.swan.apps.env.launch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ad3;
import com.repackage.ah4;
import com.repackage.ay2;
import com.repackage.b72;
import com.repackage.bt1;
import com.repackage.bv9;
import com.repackage.d72;
import com.repackage.ea3;
import com.repackage.g62;
import com.repackage.ga3;
import com.repackage.gk2;
import com.repackage.gm2;
import com.repackage.ib2;
import com.repackage.jh1;
import com.repackage.mb2;
import com.repackage.pu9;
import com.repackage.ql2;
import com.repackage.qu9;
import com.repackage.sc3;
import com.repackage.sf3;
import com.repackage.t92;
import com.repackage.te3;
import com.repackage.tl2;
import com.repackage.u84;
import com.repackage.u92;
import com.repackage.uv2;
import com.repackage.wx2;
import com.repackage.xl2;
import com.repackage.xx1;
import com.repackage.xx2;
import com.repackage.y03;
import com.repackage.yu9;
import com.repackage.yw2;
import com.repackage.yx2;
import com.repackage.zl2;
import com.repackage.zx1;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class SwanLauncher {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final f b;
    public static final f c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class T7CheckException extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public T7CheckException() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ T7CheckException(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class a implements qu9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx2 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ SwanLauncher e;

        public a(SwanLauncher swanLauncher, yx2 yx2Var, Bundle bundle, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, yx2Var, bundle, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = swanLauncher;
            this.a = yx2Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.repackage.qu9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.o(this.a, this.b, this.c);
                y03.K().p("event_launch_swan");
            }
        }

        @Override // com.repackage.qu9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (te3.G() && (th instanceof T7CheckException)) {
                    return;
                }
                y03.K().p("event_launch_swan");
                this.e.k(th, this.c, this.d, this.b);
            }
        }

        @Override // com.repackage.qu9
        public void onSubscribe(yu9 yu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yu9Var) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx2 a;

        public b(SwanLauncher swanLauncher, yx2 yx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, yx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements wx2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx2 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, yx2 yx2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, yx2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx2Var;
            this.b = str;
        }

        @Override // com.repackage.wx2
        public void a(String str, yx2 yx2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, yx2Var) == null) && yx2Var == this.a) {
                if ("event_puppet_fmp_launch_finish".equals(str) && yx2Var.E() && TextUtils.equals(this.b, yx2Var.getAppId())) {
                    ay2.k().h(this);
                    ql2.l(this.b);
                } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                    ay2.k().h(this);
                    ql2.k(this.b);
                }
            }
        }

        @Override // com.repackage.wx2
        public void timeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ql2.k(this.b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements qu9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sf3 a;

        public d(SwanLauncher swanLauncher, sf3 sf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, sf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sf3Var;
        }

        @Override // com.repackage.qu9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
                sf3 sf3Var = this.a;
                if (sf3Var != null) {
                    sf3Var.a(null);
                }
            }
        }

        @Override // com.repackage.qu9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
                sf3 sf3Var = this.a;
                if (sf3Var != null) {
                    sf3Var.a(new Exception("initEnv failed", th));
                }
            }
        }

        @Override // com.repackage.qu9
        public void onSubscribe(yu9 yu9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yu9Var) == null) && SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + yu9Var);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public Bundle c;

        /* loaded from: classes2.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public e a;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = new e(null);
            }

            public e a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (e) invokeV.objValue;
            }

            public a b(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                    this.a.a = i;
                    return this;
                }
                return (a) invokeI.objValue;
            }

            public a c(Bundle bundle) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
                    this.a.c = bundle;
                    return this;
                }
                return (a) invokeL.objValue;
            }

            public a d(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                    this.a.b = i;
                    return this;
                }
                return (a) invokeI.objValue;
            }
        }

        public /* synthetic */ e(a aVar) {
            this();
        }

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = -1;
            this.b = -1;
        }
    }

    /* loaded from: classes2.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public static final SwanLauncher a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-636362726, "Lcom/baidu/swan/apps/env/launch/SwanLauncher$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-636362726, "Lcom/baidu/swan/apps/env/launch/SwanLauncher$g;");
                    return;
                }
            }
            a = new SwanLauncher(null);
        }
    }

    /* loaded from: classes2.dex */
    public static class h extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int b;

        /* loaded from: classes2.dex */
        public class a implements sf3<Exception> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ qu9 a;
            public final /* synthetic */ h b;

            public a(h hVar, qu9 qu9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, qu9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = hVar;
                this.a = qu9Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.sf3
            /* renamed from: b */
            public void a(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                    if (exc == null) {
                        this.b.b();
                        this.a.onCompleted();
                        return;
                    }
                    qu9 qu9Var = this.a;
                    qu9Var.onError(new Exception("SwanJsUpdater fail frame type = " + this.b.b, exc));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(int i) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.repackage.pu9.f, com.repackage.fv9
        public void call(qu9 qu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qu9Var) == null) {
                if (a()) {
                    qu9Var.onCompleted();
                } else {
                    mb2.d().c(new a(this, qu9Var), this.b);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class i extends f {
        public static /* synthetic */ Interceptable $ic;
        public static boolean c;
        public transient /* synthetic */ FieldHolder $fh;
        public final e b;

        /* loaded from: classes2.dex */
        public class a implements b72 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d72 a;
            public final /* synthetic */ qu9 b;
            public final /* synthetic */ i c;

            public a(i iVar, d72 d72Var, qu9 qu9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, d72Var, qu9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = iVar;
                this.a = d72Var;
                this.b = qu9Var;
            }

            @Override // com.repackage.b72
            public void onFail() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.repackage.b72
            public void onSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.c.f();
                    if (this.a.b) {
                        this.c.b();
                        this.b.onCompleted();
                    }
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-636362664, "Lcom/baidu/swan/apps/env/launch/SwanLauncher$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-636362664, "Lcom/baidu/swan/apps/env/launch/SwanLauncher$i;");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(@NonNull e eVar) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.b = eVar;
        }

        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c || gk2.w0().c() : invokeV.booleanValue;
        }

        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c = true;
            }
        }

        public final d72 d(e eVar, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, eVar, z)) == null) {
                d72 d72Var = new d72();
                d72Var.a = "by_click";
                int i = this.b.a;
                d72Var.b = z;
                Bundle bundle = eVar.c;
                if (bundle != null) {
                    bundle.getString("mFrom", "unknown");
                }
                return d72Var;
            }
            return (d72) invokeLZ.objValue;
        }

        public final void e(qu9 qu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, qu9Var) == null) {
                Bundle bundle = this.b.c;
                if (bundle == null) {
                    qu9Var.onError(new T7CheckException(null));
                    return;
                }
                String string = bundle.getString("launchScheme");
                if (TextUtils.isEmpty(string)) {
                    qu9Var.onError(new T7CheckException(null));
                    return;
                }
                Uri build = Uri.parse(string).buildUpon().build();
                if (build == null) {
                    qu9Var.onError(new T7CheckException(null));
                    return;
                }
                boolean z = true;
                if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !gk2.A().a()) {
                    z = false;
                }
                if (!z) {
                    b();
                    qu9Var.onCompleted();
                }
                g();
                d72 d = d(this.b, z);
                gk2.w0().b(d, new a(this, d, qu9Var));
            }
        }

        public final void f() {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bundle = this.b.c) == null) {
                return;
            }
            bundle.putLong("t7_loading_end", System.currentTimeMillis());
            zx1.k("SwanLauncher", "swanSailor loadingEnd");
        }

        public final void g() {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bundle = this.b.c) == null) {
                return;
            }
            bundle.putLong("t7_loading_start", System.currentTimeMillis());
            zx1.k("SwanLauncher", "swanSailor loadingStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.repackage.pu9.f, com.repackage.fv9
        public void call(qu9 qu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qu9Var) == null) {
                gk2.G().c();
                if (a()) {
                    qu9Var.onCompleted();
                } else if (gk2.w0().c()) {
                    b();
                    qu9Var.onCompleted();
                } else {
                    e eVar = this.b;
                    if (eVar.b != 1) {
                        qu9Var.onError(new T7CheckException(null));
                        return;
                    }
                    if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                        b();
                        qu9Var.onCompleted();
                    }
                    e(qu9Var);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(857437437, "Lcom/baidu/swan/apps/env/launch/SwanLauncher;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(857437437, "Lcom/baidu/swan/apps/env/launch/SwanLauncher;");
                return;
            }
        }
        a = jh1.a;
        b = new h(0);
        c = new h(1);
    }

    public /* synthetic */ SwanLauncher(a aVar) {
        this();
    }

    public static String g(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bundle)) == null) {
            String string = bundle.getString("launch_id");
            if (TextUtils.isEmpty(string)) {
                String h2 = h();
                bundle.putString("launch_id", h2);
                return h2;
            }
            return string;
        }
        return (String) invokeL.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? UUID.randomUUID().toString() : (String) invokeV.objValue;
    }

    public static int i(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bundle)) == null) ? Math.max(bundle.getInt("appFrameType", -1), -1) : invokeL.intValue;
    }

    public static SwanLauncher j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? g.a : (SwanLauncher) invokeV.objValue;
    }

    public static void p(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            zx1.j(str, "SwanLaunch", str2, false);
        }
    }

    public final void d(String str, yx2 yx2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, yx2Var) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        ay2.k().c(new c(this, yx2Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public final void e(@NonNull qu9 qu9Var, f... fVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qu9Var, fVarArr) == null) {
            if (a) {
                Log.i("SwanLauncher", "checkEnv: checkers=" + fVarArr);
            }
            if (fVarArr != null && fVarArr.length >= 1) {
                ArrayList arrayList = null;
                for (f fVar : fVarArr) {
                    if (a) {
                        Log.i("SwanLauncher", "checkEnv: checker=" + fVar);
                    }
                    if (fVar != null && !fVar.a()) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(pu9.b(fVar));
                    }
                }
                if (a) {
                    Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    pu9.a(arrayList).h(bv9.b()).d(bv9.b()).g(qu9Var);
                    return;
                } else {
                    qu9Var.onCompleted();
                    return;
                }
            }
            qu9Var.onCompleted();
        }
    }

    public final void f(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            Context appContext = AppRuntime.getAppContext();
            Intent intent = new Intent(appContext, SwanAppLauncherActivity.class);
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.putExtras(bundle);
            appContext.startActivity(intent);
        }
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048579, this, th, i2, str, bundle) == null) {
            boolean z = th instanceof T7CheckException;
            p("SwanLauncher", "#handleError 进入错误页 isT7Error=" + z);
            sc3 sc3Var = new sc3();
            sc3Var.k(z ? 15L : 9L);
            sc3Var.i(z ? 42L : 25L);
            sc3Var.d(z ? "Sailor安装失败" : "Swan core 更新出错");
            tl2.f(AppRuntime.getAppContext(), sc3Var, i2, str, bundle);
        }
    }

    public void l(sf3<Exception> sf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sf3Var) == null) {
            e.a aVar = new e.a();
            aVar.b(-1);
            aVar.d(0);
            e(new d(this, sf3Var), new i(aVar.a()), b, c);
        }
    }

    public void m(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) || bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", gk2.o().E());
        bundle.putInt("host_launch_type", ad3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        uv2.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        yx2 r = ay2.k().r(string);
        r.U(string);
        String string2 = bundle.getString("mPage");
        if (u92.b(string, string2)) {
            bundle.putLong("launch_interval", u92.a());
            u92.c();
            u92.d(bundle);
            return;
        }
        u92.e(string, string2);
        u92.c();
        zx1.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", xx1.b(bt1.a(string)));
        String g2 = g(bundle);
        bundle.putLong("launch_time_on_main", System.currentTimeMillis());
        bundle.putInt("main_pid", Process.myPid());
        p("SwanLauncher", "启动小程序 appId=" + string + " launchId=" + g2 + " isColdBoot=" + r.R() + " processId=" + r.b + " client=" + r.toString());
        e.a aVar = new e.a();
        aVar.b(i2);
        aVar.d(1);
        aVar.c(bundle);
        i iVar = new i(aVar.a());
        a aVar2 = new a(this, r, bundle, i2, string);
        f[] fVarArr = new f[2];
        fVarArr[0] = iVar;
        fVarArr[1] = 1 == i2 ? c : b;
        e(aVar2, fVarArr);
        t92.c(i2);
    }

    public void n(zl2 zl2Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, zl2Var, bundle) == null) || zl2Var == null || TextUtils.isEmpty(zl2Var.H())) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("mAppId", zl2Var.H());
        bundle2.putAll(zl2Var.D());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        m(bundle2);
    }

    @UiThread
    public final void o(yx2 yx2Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048583, this, yx2Var, bundle, i2) == null) {
            if (ea3.j()) {
                ga3.e();
            }
            SwanCoreVersion e2 = ea3.e(i2);
            bundle.putParcelable("swanCoreVersion", e2);
            ExtensionCore c2 = ib2.c(i2);
            bundle.putParcelable("extensionCore", c2);
            p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
            Bundle I = yw2.I(xl2.f1(bundle));
            if (I != null) {
                bundle.putAll(I);
            }
            Bundle bundle2 = bundle.getBundle("mExtraData");
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle("mExtraData", bundle2);
            }
            bundle2.putLong("launch_flag_for_statistic", System.currentTimeMillis());
            bundle2.putLong("page_display_flag_for_statistic", System.currentTimeMillis());
            String string = bundle2.getString(UBCCloudControlProcessor.UBC_KEY);
            if (TextUtils.isEmpty(string)) {
                jSONObject2 = ah4.b(bundle.getString("mFrom"), null);
            } else {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e3) {
                    jSONObject = new JSONObject();
                    if (a) {
                        e3.printStackTrace();
                    }
                }
                jSONObject2 = jSONObject;
            }
            bundle2.putString(UBCCloudControlProcessor.UBC_KEY, jSONObject2.toString());
            xx2.j(bundle);
            Context appContext = AppRuntime.getAppContext();
            int q = q(yx2Var, bundle);
            Intent intent = new Intent(appContext, yx2Var.O().activity);
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.putExtras(bundle);
            intent.putExtra("start_activity_time", System.currentTimeMillis());
            intent.putExtra("preAppReadyState", q);
            try {
                appContext.startActivity(intent);
            } catch (Exception e4) {
                p("SwanLauncher", "#launchSwanActivity startActivity error " + Log.getStackTraceString(e4));
            }
            if (i2 == 0) {
                gk2.d0().a(bundle.getString("mAppId"), yx2Var);
                d(bundle.getString("mAppId"), yx2Var);
            }
            y03.M().post(new b(this, yx2Var));
        }
    }

    public final int q(@NonNull yx2 yx2Var, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        int i2;
        boolean e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yx2Var, bundle)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            PMSAppInfo u = u84.i().u(yx2Var.c);
            if (u != null && !u.isMaxAgeExpires()) {
                if (g62.a.b()) {
                    e2 = gm2.b(u, bundle);
                } else {
                    e2 = gm2.e(u);
                }
                if (e2) {
                    bundle.putParcelable("pms_db_info_onload", u);
                    g62.b(yx2Var, bundle);
                    i2 = 5;
                } else {
                    i2 = 4;
                }
            } else if (u == null) {
                i2 = 2;
            } else {
                i2 = u.isMaxAgeExpires() ? 3 : 0;
            }
            if (a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + yx2Var.R());
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    /* loaded from: classes2.dex */
    public static abstract class f implements pu9.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.booleanValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a = true;
            }
        }

        @Override // com.repackage.pu9.f, com.repackage.fv9
        public abstract /* synthetic */ void call(T t);

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return super.toString() + " checked=" + this.a;
            }
            return (String) invokeV.objValue;
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public SwanLauncher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
