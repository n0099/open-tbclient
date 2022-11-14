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
import com.baidu.tieba.ad2;
import com.baidu.tieba.az2;
import com.baidu.tieba.b0a;
import com.baidu.tieba.c13;
import com.baidu.tieba.cc4;
import com.baidu.tieba.d12;
import com.baidu.tieba.d13;
import com.baidu.tieba.dp2;
import com.baidu.tieba.e03;
import com.baidu.tieba.e13;
import com.baidu.tieba.e43;
import com.baidu.tieba.f12;
import com.baidu.tieba.fp2;
import com.baidu.tieba.g13;
import com.baidu.tieba.gg3;
import com.baidu.tieba.ha2;
import com.baidu.tieba.hw1;
import com.baidu.tieba.ik4;
import com.baidu.tieba.ja2;
import com.baidu.tieba.kd3;
import com.baidu.tieba.m92;
import com.baidu.tieba.md3;
import com.baidu.tieba.mn2;
import com.baidu.tieba.mp2;
import com.baidu.tieba.oe2;
import com.baidu.tieba.pk1;
import com.baidu.tieba.pz9;
import com.baidu.tieba.qz9;
import com.baidu.tieba.se2;
import com.baidu.tieba.wo2;
import com.baidu.tieba.yf3;
import com.baidu.tieba.yi3;
import com.baidu.tieba.yz9;
import com.baidu.tieba.zc2;
import com.baidu.tieba.zh3;
import com.baidu.tieba.zo2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class SwanLauncher {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final f b;
    public static final f c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public Bundle c;

        /* loaded from: classes3.dex */
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
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.a;
                }
                return (e) invokeV.objValue;
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

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int b;

        /* loaded from: classes3.dex */
        public class a implements yi3<Exception> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ qz9 a;
            public final /* synthetic */ h b;

            public a(h hVar, qz9 qz9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, qz9Var};
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
                this.a = qz9Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.yi3
            /* renamed from: b */
            public void a(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                    if (exc == null) {
                        this.b.b();
                        this.a.onCompleted();
                        return;
                    }
                    qz9 qz9Var = this.a;
                    qz9Var.onError(new Exception("SwanJsUpdater fail frame type = " + this.b.b, exc));
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
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.pz9.f, com.baidu.tieba.f0a
        public void call(qz9 qz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qz9Var) == null) {
                if (a()) {
                    qz9Var.onCompleted();
                } else {
                    se2.d().c(new a(this, qz9Var), this.b);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class i extends f {
        public static /* synthetic */ Interceptable $ic;
        public static boolean c;
        public transient /* synthetic */ FieldHolder $fh;
        public final e b;

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

        /* loaded from: classes3.dex */
        public class a implements ha2 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ja2 a;
            public final /* synthetic */ qz9 b;
            public final /* synthetic */ i c;

            public a(i iVar, ja2 ja2Var, qz9 qz9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, ja2Var, qz9Var};
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
                this.a = ja2Var;
                this.b = qz9Var;
            }

            @Override // com.baidu.tieba.ha2
            public void onFail() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b) {
                    this.b.onError(new T7CheckException(null));
                }
            }

            @Override // com.baidu.tieba.ha2
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!c && !mn2.w0().c()) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c = true;
            }
        }

        public final void f() {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (bundle = this.b.c) != null) {
                bundle.putLong("t7_loading_end", System.currentTimeMillis());
                f12.k("SwanLauncher", "swanSailor loadingEnd");
            }
        }

        public final void g() {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (bundle = this.b.c) != null) {
                bundle.putLong("t7_loading_start", System.currentTimeMillis());
                f12.k("SwanLauncher", "swanSailor loadingStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, com.baidu.tieba.pz9.f, com.baidu.tieba.f0a
        public void call(qz9 qz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qz9Var) == null) {
                mn2.G().c();
                if (a()) {
                    qz9Var.onCompleted();
                } else if (mn2.w0().c()) {
                    b();
                    qz9Var.onCompleted();
                } else {
                    e eVar = this.b;
                    if (eVar.b != 1) {
                        qz9Var.onError(new T7CheckException(null));
                        return;
                    }
                    if (eVar.a == 0 && !BdZeusUtil.isZeusSupported()) {
                        b();
                        qz9Var.onCompleted();
                    }
                    e(qz9Var);
                }
            }
        }

        public final ja2 d(e eVar, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, eVar, z)) == null) {
                ja2 ja2Var = new ja2();
                ja2Var.a = "by_click";
                int i = this.b.a;
                ja2Var.b = z;
                Bundle bundle = eVar.c;
                if (bundle != null) {
                    bundle.getString("mFrom", "unknown");
                }
                return ja2Var;
            }
            return (ja2) invokeLZ.objValue;
        }

        public final void e(qz9 qz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, qz9Var) == null) {
                Bundle bundle = this.b.c;
                if (bundle == null) {
                    qz9Var.onError(new T7CheckException(null));
                    return;
                }
                String string = bundle.getString("launchScheme");
                if (TextUtils.isEmpty(string)) {
                    qz9Var.onError(new T7CheckException(null));
                    return;
                }
                Uri build = Uri.parse(string).buildUpon().build();
                if (build == null) {
                    qz9Var.onError(new T7CheckException(null));
                    return;
                }
                boolean z = true;
                if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.b.a != 1 && !mn2.A().a()) {
                    z = false;
                }
                if (!z) {
                    b();
                    qz9Var.onCompleted();
                }
                g();
                ja2 d = d(this.b, z);
                mn2.w0().b(d, new a(this, d, qz9Var));
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class a implements qz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e13 a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ SwanLauncher e;

        @Override // com.baidu.tieba.qz9
        public void onSubscribe(yz9 yz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yz9Var) == null) {
            }
        }

        public a(SwanLauncher swanLauncher, e13 e13Var, Bundle bundle, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, e13Var, bundle, Integer.valueOf(i), str};
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
            this.a = e13Var;
            this.b = bundle;
            this.c = i;
            this.d = str;
        }

        @Override // com.baidu.tieba.qz9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.e.o(this.a, this.b, this.c);
            e43.K().p("event_launch_swan");
        }

        @Override // com.baidu.tieba.qz9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (zh3.G() && (th instanceof T7CheckException)) {
                    return;
                }
                e43.K().p("event_launch_swan");
                this.e.k(th, this.c, this.d, this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e13 a;

        public b(SwanLauncher swanLauncher, e13 e13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, e13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e13Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements c13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e13 a;
        public final /* synthetic */ String b;

        public c(SwanLauncher swanLauncher, e13 e13Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, e13Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e13Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.c13
        public void a(String str, e13 e13Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, str, e13Var) != null) || e13Var != this.a) {
                return;
            }
            if ("event_puppet_fmp_launch_finish".equals(str) && e13Var.E() && TextUtils.equals(this.b, e13Var.getAppId())) {
                g13.k().h(this);
                wo2.l(this.b);
            } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                g13.k().h(this);
                wo2.k(this.b);
            }
        }

        @Override // com.baidu.tieba.c13
        public void timeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                wo2.k(this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements qz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yi3 a;

        public d(SwanLauncher swanLauncher, yi3 yi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, yi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yi3Var;
        }

        @Override // com.baidu.tieba.qz9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境完成");
                yi3 yi3Var = this.a;
                if (yi3Var != null) {
                    yi3Var.a(null);
                }
            }
        }

        @Override // com.baidu.tieba.qz9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                SwanLauncher.p("SwanLauncher", "#initEnv 初始化环境失败 " + Log.getStackTraceString(th));
                yi3 yi3Var = this.a;
                if (yi3Var != null) {
                    yi3Var.a(new Exception("initEnv failed", th));
                }
            }
        }

        @Override // com.baidu.tieba.qz9
        public void onSubscribe(yz9 yz9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yz9Var) == null) && SwanLauncher.a) {
                Log.i("SwanLauncher", "init onSubscribe: " + yz9Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class f implements pz9.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        @Override // com.baidu.tieba.pz9.f, com.baidu.tieba.f0a
        public abstract /* synthetic */ void call(T t);

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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.booleanValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a = true;
            }
        }

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

    /* loaded from: classes3.dex */
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
        a = pk1.a;
        b = new h(0);
        c = new h(1);
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

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return UUID.randomUUID().toString();
        }
        return (String) invokeV.objValue;
    }

    public static SwanLauncher j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return g.a;
        }
        return (SwanLauncher) invokeV.objValue;
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

    public static int i(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bundle)) == null) {
            return Math.max(bundle.getInt("appFrameType", -1), -1);
        }
        return invokeL.intValue;
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

    public static void p(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            f12.j(str, "SwanLaunch", str2, false);
        }
    }

    public final void d(String str, e13 e13Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, str, e13Var) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        g13.k().c(new c(this, e13Var, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public final void e(@NonNull qz9 qz9Var, f... fVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qz9Var, fVarArr) == null) {
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
                        arrayList.add(pz9.b(fVar));
                    }
                }
                if (a) {
                    Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    pz9.a(arrayList).h(b0a.b()).d(b0a.b()).g(qz9Var);
                    return;
                } else {
                    qz9Var.onCompleted();
                    return;
                }
            }
            qz9Var.onCompleted();
        }
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        long j;
        long j2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048579, this, th, i2, str, bundle) == null) {
            boolean z = th instanceof T7CheckException;
            p("SwanLauncher", "#handleError 进入错误页 isT7Error=" + z);
            yf3 yf3Var = new yf3();
            if (z) {
                j = 15;
            } else {
                j = 9;
            }
            yf3Var.k(j);
            if (z) {
                j2 = 42;
            } else {
                j2 = 25;
            }
            yf3Var.i(j2);
            if (z) {
                str2 = "Sailor安装失败";
            } else {
                str2 = "Swan core 更新出错";
            }
            yf3Var.d(str2);
            zo2.f(AppRuntime.getAppContext(), yf3Var, i2, str, bundle);
        }
    }

    public void l(yi3<Exception> yi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yi3Var) == null) {
            e.a aVar = new e.a();
            aVar.b(-1);
            aVar.d(0);
            e(new d(this, yi3Var), new i(aVar.a()), b, c);
        }
    }

    public void m(Bundle bundle) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, bundle) != null) || bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", mn2.o().E());
        bundle.putInt("host_launch_type", gg3.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        az2.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        e13 r = g13.k().r(string);
        r.U(string);
        String string2 = bundle.getString("mPage");
        if (ad2.b(string, string2)) {
            bundle.putLong("launch_interval", ad2.a());
            ad2.c();
            ad2.d(bundle);
            return;
        }
        ad2.e(string, string2);
        ad2.c();
        f12.i("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", d12.b(hw1.a(string)));
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
        if (1 == i2) {
            fVar = c;
        } else {
            fVar = b;
        }
        fVarArr[1] = fVar;
        e(aVar2, fVarArr);
        zc2.c(i2);
    }

    public void n(fp2 fp2Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, fp2Var, bundle) == null) && fp2Var != null && !TextUtils.isEmpty(fp2Var.H())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("mAppId", fp2Var.H());
            bundle2.putAll(fp2Var.D());
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            m(bundle2);
        }
    }

    @UiThread
    public final void o(e13 e13Var, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048583, this, e13Var, bundle, i2) == null) {
            if (kd3.j()) {
                md3.e();
            }
            SwanCoreVersion e2 = kd3.e(i2);
            bundle.putParcelable("swanCoreVersion", e2);
            ExtensionCore c2 = oe2.c(i2);
            bundle.putParcelable("extensionCore", c2);
            p("SwanLauncher", "#launchSwanActivity swanCoreVersion=" + e2 + " ExtensionCore=" + c2);
            Bundle I = e03.I(dp2.f1(bundle));
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
                jSONObject2 = ik4.b(bundle.getString("mFrom"), null);
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
            d13.j(bundle);
            Context appContext = AppRuntime.getAppContext();
            int q = q(e13Var, bundle);
            Intent intent = new Intent(appContext, e13Var.O().activity);
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
                mn2.d0().a(bundle.getString("mAppId"), e13Var);
                d(bundle.getString("mAppId"), e13Var);
            }
            e43.M().post(new b(this, e13Var));
        }
    }

    public final int q(@NonNull e13 e13Var, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        int i2;
        boolean e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, e13Var, bundle)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            PMSAppInfo u = cc4.i().u(e13Var.c);
            if (u != null && !u.isMaxAgeExpires()) {
                if (m92.a.b()) {
                    e2 = mp2.b(u, bundle);
                } else {
                    e2 = mp2.e(u);
                }
                if (e2) {
                    bundle.putParcelable("pms_db_info_onload", u);
                    m92.b(e13Var, bundle);
                    i2 = 5;
                } else {
                    i2 = 4;
                }
            } else if (u == null) {
                i2 = 2;
            } else if (u.isMaxAgeExpires()) {
                i2 = 3;
            } else {
                i2 = 0;
            }
            if (a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + e13Var.R());
            }
            return i2;
        }
        return invokeLL.intValue;
    }
}
