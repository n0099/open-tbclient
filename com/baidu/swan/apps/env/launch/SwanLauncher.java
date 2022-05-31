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
import com.repackage.ab3;
import com.repackage.ae3;
import com.repackage.av9;
import com.repackage.b82;
import com.repackage.bd3;
import com.repackage.bk2;
import com.repackage.c74;
import com.repackage.c82;
import com.repackage.cu2;
import com.repackage.ew2;
import com.repackage.fk2;
import com.repackage.fw1;
import com.repackage.fw2;
import com.repackage.gv2;
import com.repackage.gw2;
import com.repackage.gz2;
import com.repackage.hk2;
import com.repackage.hw1;
import com.repackage.ib3;
import com.repackage.iw2;
import com.repackage.j52;
import com.repackage.jf4;
import com.repackage.jr1;
import com.repackage.l52;
import com.repackage.m83;
import com.repackage.o42;
import com.repackage.o83;
import com.repackage.oi2;
import com.repackage.ok2;
import com.repackage.ou9;
import com.repackage.pu9;
import com.repackage.q92;
import com.repackage.rf1;
import com.repackage.u92;
import com.repackage.xu9;
import com.repackage.yj2;
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
    public class a implements pu9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw2 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ SwanLauncher e;

        public a(SwanLauncher swanLauncher, gw2 gw2Var, Bundle bundle, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, gw2Var, bundle, Integer.valueOf(i), str};
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
            this.a = gw2Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.repackage.pu9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.o(this.a, this.b, this.c);
                gz2.J().q("event_launch_swan");
            }
        }

        @Override // com.repackage.pu9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (bd3.G() && (th instanceof T7CheckException)) {
                    return;
                }
                gz2.J().q("event_launch_swan");
                this.e.k(th, this.c, this.d, this.b);
            }
        }

        @Override // com.repackage.pu9
        public void onSubscribe(xu9 xu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xu9Var) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw2 a;

        public b(SwanLauncher swanLauncher, gw2 gw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, gw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements ew2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw2 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, gw2 gw2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, gw2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw2Var;
            this.b = str;
        }

        @Override // com.repackage.ew2
        public void a(String str, gw2 gw2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, gw2Var) == null) && gw2Var == this.a) {
                if ("event_puppet_fmp_launch_finish".equals(str) && gw2Var.D() && TextUtils.equals(this.b, gw2Var.getAppId())) {
                    iw2.k().h(this);
                    yj2.l(this.b);
                } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                    iw2.k().h(this);
                    yj2.k(this.b);
                }
            }
        }

        @Override // com.repackage.ew2
        public void timeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                yj2.k(this.b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements pu9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae3 a;

        public d(SwanLauncher swanLauncher, ae3 ae3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, ae3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ae3Var;
        }

        @Override // com.repackage.pu9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
                ae3 ae3Var = this.a;
                if (ae3Var != null) {
                    ae3Var.onCallback(null);
                }
            }
        }

        @Override // com.repackage.pu9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
                ae3 ae3Var = this.a;
                if (ae3Var != null) {
                    ae3Var.onCallback(new Exception("initEnv failed", th));
                }
            }
        }

        @Override // com.repackage.pu9
        public void onSubscribe(xu9 xu9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xu9Var) == null) && SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + xu9Var);
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
        public class a implements ae3<Exception> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ pu9 a;
            public final /* synthetic */ h b;

            public a(h hVar, pu9 pu9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, pu9Var};
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
                this.a = pu9Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.ae3
            /* renamed from: a */
            public void onCallback(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                    if (exc == null) {
                        this.b.b();
                        this.a.onCompleted();
                        return;
                    }
                    pu9 pu9Var = this.a;
                    pu9Var.onError(new Exception("SwanJsUpdater fail frame type = " + this.b.b, exc));
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
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.repackage.ou9.f, com.repackage.ev9
        public void call(pu9 pu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu9Var) == null) {
                if (a()) {
                    pu9Var.onCompleted();
                } else {
                    u92.d().c(new a(this, pu9Var), this.b);
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
        public class a implements j52 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l52 a;
            public final /* synthetic */ pu9 b;
            public final /* synthetic */ i c;

            public a(i iVar, l52 l52Var, pu9 pu9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, l52Var, pu9Var};
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
                this.a = l52Var;
                this.b = pu9Var;
            }

            @Override // com.repackage.j52
            public void onFail() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.repackage.j52
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c || oi2.w0().c() : invokeV.booleanValue;
        }

        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c = true;
            }
        }

        public final l52 d(e eVar, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, eVar, z)) == null) {
                l52 l52Var = new l52();
                l52Var.a = "by_click";
                int i = this.b.a;
                l52Var.b = z;
                Bundle bundle = eVar.c;
                if (bundle != null) {
                    bundle.getString("mFrom", "unknown");
                }
                return l52Var;
            }
            return (l52) invokeLZ.objValue;
        }

        public final void e(pu9 pu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, pu9Var) == null) {
                Bundle bundle = this.b.c;
                if (bundle == null) {
                    pu9Var.onError(new T7CheckException(null));
                    return;
                }
                String string = bundle.getString("launchScheme");
                if (TextUtils.isEmpty(string)) {
                    pu9Var.onError(new T7CheckException(null));
                    return;
                }
                Uri build = Uri.parse(string).buildUpon().build();
                if (build == null) {
                    pu9Var.onError(new T7CheckException(null));
                    return;
                }
                boolean z = true;
                if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !oi2.A().a()) {
                    z = false;
                }
                if (!z) {
                    b();
                    pu9Var.onCompleted();
                }
                g();
                l52 d = d(this.b, z);
                oi2.w0().b(d, new a(this, d, pu9Var));
            }
        }

        public final void f() {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bundle = this.b.c) == null) {
                return;
            }
            bundle.putLong("t7_loading_end", System.currentTimeMillis());
            hw1.k("SwanLauncher", "swanSailor loadingEnd");
        }

        public final void g() {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bundle = this.b.c) == null) {
                return;
            }
            bundle.putLong("t7_loading_start", System.currentTimeMillis());
            hw1.k("SwanLauncher", "swanSailor loadingStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.repackage.ou9.f, com.repackage.ev9
        public void call(pu9 pu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pu9Var) == null) {
                oi2.G().c();
                if (a()) {
                    pu9Var.onCompleted();
                } else if (oi2.w0().c()) {
                    b();
                    pu9Var.onCompleted();
                } else {
                    e eVar = this.b;
                    if (eVar.b != 1) {
                        pu9Var.onError(new T7CheckException(null));
                        return;
                    }
                    if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                        b();
                        pu9Var.onCompleted();
                    }
                    e(pu9Var);
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
        a = rf1.a;
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
            hw1.j(str, "SwanLaunch", str2, false);
        }
    }

    public final void d(String str, gw2 gw2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, gw2Var) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        iw2.k().c(new c(this, gw2Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public final void e(@NonNull pu9 pu9Var, f... fVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pu9Var, fVarArr) == null) {
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
                        arrayList.add(ou9.b(fVar));
                    }
                }
                if (a) {
                    Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    ou9.a(arrayList).h(av9.b()).d(av9.b()).g(pu9Var);
                    return;
                } else {
                    pu9Var.onCompleted();
                    return;
                }
            }
            pu9Var.onCompleted();
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
            ab3 ab3Var = new ab3();
            ab3Var.k(z ? 15L : 9L);
            ab3Var.i(z ? 42L : 25L);
            ab3Var.d(z ? "Sailor安装失败" : "Swan core 更新出错");
            bk2.f(AppRuntime.getAppContext(), ab3Var, i2, str, bundle);
        }
    }

    public void l(ae3<Exception> ae3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ae3Var) == null) {
            e.a aVar = new e.a();
            aVar.b(-1);
            aVar.d(0);
            e(new d(this, ae3Var), new i(aVar.a()), b, c);
        }
    }

    public void m(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) || bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", oi2.o().E());
        bundle.putInt("host_launch_type", ib3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        cu2.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        gw2 r = iw2.k().r(string);
        r.T(string);
        String string2 = bundle.getString("mPage");
        if (c82.b(string, string2)) {
            bundle.putLong("launch_interval", c82.a());
            c82.c();
            c82.d(bundle);
            return;
        }
        c82.e(string, string2);
        c82.c();
        hw1.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", fw1.b(jr1.a(string)));
        String g2 = g(bundle);
        bundle.putLong("launch_time_on_main", System.currentTimeMillis());
        bundle.putInt("main_pid", Process.myPid());
        p("SwanLauncher", "启动小程序 appId=" + string + " launchId=" + g2 + " isColdBoot=" + r.Q() + " processId=" + r.b + " client=" + r.toString());
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
        b82.c(i2);
    }

    public void n(hk2 hk2Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, hk2Var, bundle) == null) || hk2Var == null || TextUtils.isEmpty(hk2Var.H())) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("mAppId", hk2Var.H());
        bundle2.putAll(hk2Var.D());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        m(bundle2);
    }

    @UiThread
    public final void o(gw2 gw2Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048583, this, gw2Var, bundle, i2) == null) {
            if (m83.j()) {
                o83.e();
            }
            SwanCoreVersion e2 = m83.e(i2);
            bundle.putParcelable("swanCoreVersion", e2);
            ExtensionCore c2 = q92.c(i2);
            bundle.putParcelable("extensionCore", c2);
            p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
            Bundle I = gv2.I(fk2.f1(bundle));
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
                jSONObject2 = jf4.b(bundle.getString("mFrom"), null);
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
            fw2.j(bundle);
            Context appContext = AppRuntime.getAppContext();
            int q = q(gw2Var, bundle);
            Intent intent = new Intent(appContext, gw2Var.N().activity);
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
                oi2.d0().a(bundle.getString("mAppId"), gw2Var);
                d(bundle.getString("mAppId"), gw2Var);
            }
            gz2.L().post(new b(this, gw2Var));
        }
    }

    public final int q(@NonNull gw2 gw2Var, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        int i2;
        boolean e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gw2Var, bundle)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            PMSAppInfo u = c74.i().u(gw2Var.c);
            if (u != null && !u.isMaxAgeExpires()) {
                if (o42.a.b()) {
                    e2 = ok2.b(u, bundle);
                } else {
                    e2 = ok2.e(u);
                }
                if (e2) {
                    bundle.putParcelable("pms_db_info_onload", u);
                    o42.b(gw2Var, bundle);
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
                Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + gw2Var.Q());
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    /* loaded from: classes2.dex */
    public static abstract class f implements ou9.f {
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

        @Override // com.repackage.ou9.f, com.repackage.ev9
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
