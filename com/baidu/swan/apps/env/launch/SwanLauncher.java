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
import com.repackage.b62;
import com.repackage.ba3;
import com.repackage.bk2;
import com.repackage.bm2;
import com.repackage.db2;
import com.repackage.dy9;
import com.repackage.eh1;
import com.repackage.gy9;
import com.repackage.hb2;
import com.repackage.ll2;
import com.repackage.nc3;
import com.repackage.nf3;
import com.repackage.o92;
import com.repackage.oe3;
import com.repackage.ol2;
import com.repackage.p84;
import com.repackage.p92;
import com.repackage.pv2;
import com.repackage.rx2;
import com.repackage.sl2;
import com.repackage.sx1;
import com.repackage.sx2;
import com.repackage.t03;
import com.repackage.tw2;
import com.repackage.tx2;
import com.repackage.ul2;
import com.repackage.ux1;
import com.repackage.ux9;
import com.repackage.vc3;
import com.repackage.vx2;
import com.repackage.vx9;
import com.repackage.w62;
import com.repackage.wg4;
import com.repackage.ws1;
import com.repackage.y62;
import com.repackage.z93;
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
    public class a implements vx9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx2 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ SwanLauncher e;

        public a(SwanLauncher swanLauncher, tx2 tx2Var, Bundle bundle, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, tx2Var, bundle, Integer.valueOf(i), str};
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
            this.a = tx2Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.repackage.vx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.o(this.a, this.b, this.c);
                t03.J().q("event_launch_swan");
            }
        }

        @Override // com.repackage.vx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (oe3.G() && (th instanceof T7CheckException)) {
                    return;
                }
                t03.J().q("event_launch_swan");
                this.e.k(th, this.c, this.d, this.b);
            }
        }

        @Override // com.repackage.vx9
        public void onSubscribe(dy9 dy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dy9Var) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx2 a;

        public b(SwanLauncher swanLauncher, tx2 tx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, tx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx2Var;
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
    public class c implements rx2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx2 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, tx2 tx2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, tx2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx2Var;
            this.b = str;
        }

        @Override // com.repackage.rx2
        public void a(String str, tx2 tx2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, tx2Var) == null) && tx2Var == this.a) {
                if ("event_puppet_fmp_launch_finish".equals(str) && tx2Var.D() && TextUtils.equals(this.b, tx2Var.getAppId())) {
                    vx2.k().h(this);
                    ll2.l(this.b);
                } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                    vx2.k().h(this);
                    ll2.k(this.b);
                }
            }
        }

        @Override // com.repackage.rx2
        public void timeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ll2.k(this.b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements vx9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf3 a;

        public d(SwanLauncher swanLauncher, nf3 nf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, nf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nf3Var;
        }

        @Override // com.repackage.vx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
                nf3 nf3Var = this.a;
                if (nf3Var != null) {
                    nf3Var.onCallback(null);
                }
            }
        }

        @Override // com.repackage.vx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
                nf3 nf3Var = this.a;
                if (nf3Var != null) {
                    nf3Var.onCallback(new Exception("initEnv failed", th));
                }
            }
        }

        @Override // com.repackage.vx9
        public void onSubscribe(dy9 dy9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dy9Var) == null) && SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + dy9Var);
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
        public class a implements nf3<Exception> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ vx9 a;
            public final /* synthetic */ h b;

            public a(h hVar, vx9 vx9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, vx9Var};
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
                this.a = vx9Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.nf3
            /* renamed from: a */
            public void onCallback(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                    if (exc == null) {
                        this.b.b();
                        this.a.onCompleted();
                        return;
                    }
                    vx9 vx9Var = this.a;
                    vx9Var.onError(new Exception("SwanJsUpdater fail frame type = " + this.b.b, exc));
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
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.repackage.ux9.f, com.repackage.ky9
        public void call(vx9 vx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vx9Var) == null) {
                if (a()) {
                    vx9Var.onCompleted();
                } else {
                    hb2.d().c(new a(this, vx9Var), this.b);
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
        public class a implements w62 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ y62 a;
            public final /* synthetic */ vx9 b;
            public final /* synthetic */ i c;

            public a(i iVar, y62 y62Var, vx9 vx9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, y62Var, vx9Var};
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
                this.a = y62Var;
                this.b = vx9Var;
            }

            @Override // com.repackage.w62
            public void onFail() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.repackage.w62
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c || bk2.w0().c() : invokeV.booleanValue;
        }

        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c = true;
            }
        }

        public final y62 d(e eVar, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, eVar, z)) == null) {
                y62 y62Var = new y62();
                y62Var.a = "by_click";
                int i = this.b.a;
                y62Var.b = z;
                Bundle bundle = eVar.c;
                if (bundle != null) {
                    bundle.getString("mFrom", "unknown");
                }
                return y62Var;
            }
            return (y62) invokeLZ.objValue;
        }

        public final void e(vx9 vx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, vx9Var) == null) {
                Bundle bundle = this.b.c;
                if (bundle == null) {
                    vx9Var.onError(new T7CheckException(null));
                    return;
                }
                String string = bundle.getString("launchScheme");
                if (TextUtils.isEmpty(string)) {
                    vx9Var.onError(new T7CheckException(null));
                    return;
                }
                Uri build = Uri.parse(string).buildUpon().build();
                if (build == null) {
                    vx9Var.onError(new T7CheckException(null));
                    return;
                }
                boolean z = true;
                if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !bk2.A().a()) {
                    z = false;
                }
                if (!z) {
                    b();
                    vx9Var.onCompleted();
                }
                g();
                y62 d = d(this.b, z);
                bk2.w0().b(d, new a(this, d, vx9Var));
            }
        }

        public final void f() {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bundle = this.b.c) == null) {
                return;
            }
            bundle.putLong("t7_loading_end", System.currentTimeMillis());
            ux1.k("SwanLauncher", "swanSailor loadingEnd");
        }

        public final void g() {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bundle = this.b.c) == null) {
                return;
            }
            bundle.putLong("t7_loading_start", System.currentTimeMillis());
            ux1.k("SwanLauncher", "swanSailor loadingStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.repackage.ux9.f, com.repackage.ky9
        public void call(vx9 vx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vx9Var) == null) {
                bk2.G().c();
                if (a()) {
                    vx9Var.onCompleted();
                } else if (bk2.w0().c()) {
                    b();
                    vx9Var.onCompleted();
                } else {
                    e eVar = this.b;
                    if (eVar.b != 1) {
                        vx9Var.onError(new T7CheckException(null));
                        return;
                    }
                    if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                        b();
                        vx9Var.onCompleted();
                    }
                    e(vx9Var);
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
        a = eh1.a;
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
            ux1.j(str, "SwanLaunch", str2, false);
        }
    }

    public final void d(String str, tx2 tx2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, tx2Var) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        vx2.k().c(new c(this, tx2Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public final void e(@NonNull vx9 vx9Var, f... fVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vx9Var, fVarArr) == null) {
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
                        arrayList.add(ux9.b(fVar));
                    }
                }
                if (a) {
                    Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    ux9.a(arrayList).h(gy9.b()).d(gy9.b()).g(vx9Var);
                    return;
                } else {
                    vx9Var.onCompleted();
                    return;
                }
            }
            vx9Var.onCompleted();
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
            nc3 nc3Var = new nc3();
            nc3Var.k(z ? 15L : 9L);
            nc3Var.i(z ? 42L : 25L);
            nc3Var.d(z ? "Sailor安装失败" : "Swan core 更新出错");
            ol2.f(AppRuntime.getAppContext(), nc3Var, i2, str, bundle);
        }
    }

    public void l(nf3<Exception> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nf3Var) == null) {
            e.a aVar = new e.a();
            aVar.b(-1);
            aVar.d(0);
            e(new d(this, nf3Var), new i(aVar.a()), b, c);
        }
    }

    public void m(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) || bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", bk2.o().E());
        bundle.putInt("host_launch_type", vc3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        pv2.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        tx2 r = vx2.k().r(string);
        r.T(string);
        String string2 = bundle.getString("mPage");
        if (p92.b(string, string2)) {
            bundle.putLong("launch_interval", p92.a());
            p92.c();
            p92.d(bundle);
            return;
        }
        p92.e(string, string2);
        p92.c();
        ux1.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", sx1.b(ws1.a(string)));
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
        o92.c(i2);
    }

    public void n(ul2 ul2Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, ul2Var, bundle) == null) || ul2Var == null || TextUtils.isEmpty(ul2Var.H())) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("mAppId", ul2Var.H());
        bundle2.putAll(ul2Var.D());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        m(bundle2);
    }

    @UiThread
    public final void o(tx2 tx2Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048583, this, tx2Var, bundle, i2) == null) {
            if (z93.j()) {
                ba3.e();
            }
            SwanCoreVersion e2 = z93.e(i2);
            bundle.putParcelable("swanCoreVersion", e2);
            ExtensionCore c2 = db2.c(i2);
            bundle.putParcelable("extensionCore", c2);
            p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
            Bundle I = tw2.I(sl2.f1(bundle));
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
                jSONObject2 = wg4.b(bundle.getString("mFrom"), null);
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
            sx2.j(bundle);
            Context appContext = AppRuntime.getAppContext();
            int q = q(tx2Var, bundle);
            Intent intent = new Intent(appContext, tx2Var.N().activity);
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
                bk2.d0().a(bundle.getString("mAppId"), tx2Var);
                d(bundle.getString("mAppId"), tx2Var);
            }
            t03.L().post(new b(this, tx2Var));
        }
    }

    public final int q(@NonNull tx2 tx2Var, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        int i2;
        boolean e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tx2Var, bundle)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            PMSAppInfo u = p84.i().u(tx2Var.c);
            if (u != null && !u.isMaxAgeExpires()) {
                if (b62.a.b()) {
                    e2 = bm2.b(u, bundle);
                } else {
                    e2 = bm2.e(u);
                }
                if (e2) {
                    bundle.putParcelable("pms_db_info_onload", u);
                    b62.b(tx2Var, bundle);
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
                Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + tx2Var.Q());
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    /* loaded from: classes2.dex */
    public static abstract class f implements ux9.f {
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

        @Override // com.repackage.ux9.f, com.repackage.ky9
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
