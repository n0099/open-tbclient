package com.baidu.swan.apps.env.launch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.p.a;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
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
import h.b;
import h.k;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class SwanLauncher {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43675a;

    /* renamed from: b  reason: collision with root package name */
    public static final f f43676b;

    /* renamed from: c  reason: collision with root package name */
    public static final f f43677c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class T7CheckException extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public T7CheckException() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ T7CheckException(a aVar) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public class a implements h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v1.c.f.c f43678e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f43679f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43680g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43681h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ SwanLauncher f43682i;

        public a(SwanLauncher swanLauncher, b.a.p0.a.v1.c.f.c cVar, Bundle bundle, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, cVar, bundle, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43682i = swanLauncher;
            this.f43678e = cVar;
            this.f43679f = bundle;
            this.f43680g = i2;
            this.f43681h = str;
        }

        @Override // h.c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f43682i.o(this.f43678e, this.f43679f, this.f43680g);
                b.a.p0.a.a2.d.g().q("event_launch_swan");
            }
        }

        @Override // h.c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (q0.G() && (th instanceof T7CheckException)) {
                    return;
                }
                b.a.p0.a.a2.d.g().q("event_launch_swan");
                this.f43682i.k(th, this.f43680g, this.f43681h, this.f43679f);
            }
        }

        @Override // h.c
        public void onSubscribe(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kVar) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v1.c.f.c f43683e;

        public b(SwanLauncher swanLauncher, b.a.p0.a.v1.c.f.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43683e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f43683e.Z();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements b.a.p0.a.v1.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v1.c.f.c f43684a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f43685b;

        public c(SwanLauncher swanLauncher, b.a.p0.a.v1.c.f.c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43684a = cVar;
            this.f43685b = str;
        }

        @Override // b.a.p0.a.v1.c.f.a
        public void a(String str, b.a.p0.a.v1.c.f.c cVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) && cVar == this.f43684a) {
                if ("event_puppet_fmp_launch_finish".equals(str) && cVar.C() && TextUtils.equals(this.f43685b, cVar.getAppId())) {
                    b.a.p0.a.v1.c.f.e.k().h(this);
                    b.a.p0.a.f1.b.l(this.f43685b);
                } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                    b.a.p0.a.v1.c.f.e.k().h(this);
                    b.a.p0.a.f1.b.k(this.f43685b);
                }
            }
        }

        @Override // b.a.p0.a.v1.c.f.a
        public void timeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b.a.p0.a.f1.b.k(this.f43685b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v2.e1.b f43686e;

        public d(SwanLauncher swanLauncher, b.a.p0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLauncher, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43686e = bVar;
        }

        @Override // h.c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.e0.d.h("SwanLauncher", "init onCompleted");
                b.a.p0.a.v2.e1.b bVar = this.f43686e;
                if (bVar != null) {
                    bVar.onCallback(null);
                }
            }
        }

        @Override // h.c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                b.a.p0.a.e0.d.i("SwanLauncher", "initEnv onError: ", th);
                b.a.p0.a.v2.e1.b bVar = this.f43686e;
                if (bVar != null) {
                    bVar.onCallback(new Exception("initEnv failed", th));
                }
            }
        }

        @Override // h.c
        public void onSubscribe(k kVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kVar) == null) && SwanLauncher.f43675a) {
                String str = "init onSubscribe: " + kVar;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f43687a;

        /* renamed from: b  reason: collision with root package name */
        public int f43688b;

        /* renamed from: c  reason: collision with root package name */
        public Bundle f43689c;

        /* loaded from: classes8.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public e f43690a;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43690a = new e(null);
            }

            public e a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43690a : (e) invokeV.objValue;
            }

            public a b(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.f43690a.f43687a = i2;
                    return this;
                }
                return (a) invokeI.objValue;
            }

            public a c(Bundle bundle) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
                    this.f43690a.f43689c = bundle;
                    return this;
                }
                return (a) invokeL.objValue;
            }

            public a d(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                    this.f43690a.f43688b = i2;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43687a = -1;
            this.f43688b = -1;
        }
    }

    /* loaded from: classes8.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final SwanLauncher f43692a;
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
            f43692a = new SwanLauncher(null);
        }
    }

    /* loaded from: classes8.dex */
    public static class h extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final int f43693f;

        /* loaded from: classes8.dex */
        public class a implements b.a.p0.a.v2.e1.b<Exception> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.c f43694e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f43695f;

            public a(h hVar, h.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43695f = hVar;
                this.f43694e = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                    if (exc == null) {
                        this.f43695f.b();
                        this.f43694e.onCompleted();
                        return;
                    }
                    h.c cVar = this.f43694e;
                    cVar.onError(new Exception("SwanJsUpdater fail frame type = " + this.f43695f.f43693f, exc));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(int i2) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43693f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, h.b.f, h.n.b
        public void call(h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (a()) {
                    cVar.onCompleted();
                } else {
                    b.a.p0.a.p0.e.a.d().c(new a(this, cVar), this.f43693f);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class i extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final e f43696f;

        /* loaded from: classes8.dex */
        public class a implements b.a.p0.a.h0.s.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.h0.s.e f43697a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h.c f43698b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ i f43699c;

            public a(i iVar, b.a.p0.a.h0.s.e eVar, h.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, eVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43699c = iVar;
                this.f43697a = eVar;
                this.f43698b = cVar;
            }

            @Override // b.a.p0.a.h0.s.c
            public void onFail() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f43697a.f5770b) {
                    this.f43698b.onError(new T7CheckException(null));
                }
            }

            @Override // b.a.p0.a.h0.s.c
            public void onSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f43699c.f();
                    if (this.f43697a.f5770b) {
                        this.f43699c.b();
                        this.f43698b.onCompleted();
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
            this.f43696f = eVar;
        }

        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.a() || b.a.p0.a.c1.a.n0().c() : invokeV.booleanValue;
        }

        public final b.a.p0.a.h0.s.e d(e eVar, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, eVar, z)) == null) {
                b.a.p0.a.h0.s.e eVar2 = new b.a.p0.a.h0.s.e();
                eVar2.f5769a = "by_click";
                int i2 = this.f43696f.f43687a;
                eVar2.f5770b = z;
                Bundle bundle = eVar.f43689c;
                if (bundle != null) {
                    bundle.getString("mFrom", "unknown");
                }
                return eVar2;
            }
            return (b.a.p0.a.h0.s.e) invokeLZ.objValue;
        }

        public final void e(h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
                Bundle bundle = this.f43696f.f43689c;
                if (bundle == null) {
                    cVar.onError(new T7CheckException(null));
                    return;
                }
                String string = bundle.getString("launchScheme");
                if (TextUtils.isEmpty(string)) {
                    cVar.onError(new T7CheckException(null));
                    return;
                }
                Uri build = Uri.parse(string).buildUpon().build();
                if (build == null) {
                    cVar.onError(new T7CheckException(null));
                    return;
                }
                boolean z = true;
                if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.f43696f.f43687a != 1 && !b.a.p0.a.c1.a.w().g()) {
                    z = false;
                }
                if (!z) {
                    b();
                    cVar.onCompleted();
                }
                g();
                b.a.p0.a.h0.s.e d2 = d(this.f43696f, z);
                b.a.p0.a.c1.a.n0().b(d2, new a(this, d2, cVar));
            }
        }

        public final void f() {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (bundle = this.f43696f.f43689c) == null) {
                return;
            }
            bundle.putLong("t7_loading_end", System.currentTimeMillis());
            b.a.p0.a.e0.d.h("SwanLauncher", "swanSailor loadingEnd");
        }

        public final void g() {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bundle = this.f43696f.f43689c) == null) {
                return;
            }
            bundle.putLong("t7_loading_start", System.currentTimeMillis());
            b.a.p0.a.e0.d.h("SwanLauncher", "swanSailor loadingStart");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f, h.b.f, h.n.b
        public void call(h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                b.a.p0.a.c1.a.C().c();
                if (a()) {
                    cVar.onCompleted();
                } else if (b.a.p0.a.c1.a.n0().c()) {
                    b();
                    cVar.onCompleted();
                } else {
                    e eVar = this.f43696f;
                    if (eVar.f43688b != 1) {
                        cVar.onError(new T7CheckException(null));
                        return;
                    }
                    if (eVar.f43687a == 0 && !BdZeusUtil.isZeusSupported()) {
                        b();
                        cVar.onCompleted();
                    }
                    e(cVar);
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
        f43675a = b.a.p0.a.k.f6397a;
        f43676b = new h(0);
        f43677c = new h(1);
    }

    public /* synthetic */ SwanLauncher(a aVar) {
        this();
    }

    public static String g(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bundle)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? g.f43692a : (SwanLauncher) invokeV.objValue;
    }

    public final void d(String str, b.a.p0.a.v1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        b.a.p0.a.v1.c.f.e.k().c(new c(this, cVar, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public final void e(@NonNull h.c cVar, f... fVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, fVarArr) == null) {
            if (f43675a) {
                String str = "checkEnv: checkers=" + fVarArr;
            }
            if (fVarArr != null && fVarArr.length >= 1) {
                ArrayList arrayList = null;
                for (f fVar : fVarArr) {
                    if (f43675a) {
                        String str2 = "checkEnv: checker=" + fVar;
                    }
                    if (fVar != null && !fVar.a()) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(h.b.b(fVar));
                    }
                }
                if (f43675a) {
                    String str3 = "checkEnv: list=" + arrayList;
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    h.b.a(arrayList).h(h.l.b.a.b()).d(h.l.b.a.b()).g(cVar);
                    return;
                } else {
                    cVar.onCompleted();
                    return;
                }
            }
            cVar.onCompleted();
        }
    }

    public final void f(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            Context appContext = AppRuntime.getAppContext();
            Intent intent = new Intent(appContext, SwanAppLauncherActivity.class);
            intent.addFlags(268435456);
            intent.putExtras(bundle);
            appContext.startActivity(intent);
        }
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048579, this, th, i2, str, bundle) == null) {
            boolean z = th instanceof T7CheckException;
            b.a.p0.a.e0.d.h("SwanLauncher", "isT7Error = " + z);
            b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
            aVar.j(z ? 15L : 9L);
            aVar.h(z ? 42L : 25L);
            aVar.c(z ? "Sailor安装失败" : "Swan core 更新出错");
            b.a.p0.a.f1.d.a.e(AppRuntime.getAppContext(), aVar, i2, str, bundle);
        }
    }

    public void l(b.a.p0.a.v2.e1.b<Exception> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            e.a aVar = new e.a();
            aVar.b(-1);
            aVar.d(0);
            e(new d(this, bVar), new i(aVar.a()), f43676b, f43677c);
        }
    }

    public void m(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) || bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", b.a.p0.a.c1.a.n().B());
        bundle.putInt("host_launch_type", b.a.p0.a.t2.a.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        b.a.p0.a.r1.r.b.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        b.a.p0.a.v1.c.f.c r = b.a.p0.a.v1.c.f.e.k().r(string);
        r.I(string);
        String string2 = bundle.getString("mPage");
        if (b.a.p0.a.n0.i.b.b(string, string2)) {
            bundle.putLong("launch_interval", b.a.p0.a.n0.i.b.a());
            b.a.p0.a.n0.i.b.c();
            b.a.p0.a.n0.i.b.d(bundle);
            return;
        }
        b.a.p0.a.n0.i.b.e(string, string2);
        b.a.p0.a.n0.i.b.c();
        if (f43675a) {
            String str = "app is cold boot = " + r.F();
        }
        b.a.p0.a.e0.d.g("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", b.a.p0.a.e0.b.b(b.a.p0.a.v.a.a(string)));
        g(bundle);
        bundle.putLong("launch_time_on_main", System.currentTimeMillis());
        bundle.putInt("main_pid", Process.myPid());
        if (f43675a) {
            String str2 = "onReady processId: " + r.f8519f + " ,client:" + r.toString();
        }
        e.a aVar = new e.a();
        aVar.b(i2);
        aVar.d(1);
        aVar.c(bundle);
        i iVar = new i(aVar.a());
        a aVar2 = new a(this, r, bundle, i2, string);
        f[] fVarArr = new f[2];
        fVarArr[0] = iVar;
        fVarArr[1] = 1 == i2 ? f43677c : f43676b;
        e(aVar2, fVarArr);
        b.a.p0.a.n0.i.a.c(i2);
    }

    public void n(b.a.p0.a.f1.e.e eVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, eVar, bundle) == null) || eVar == null || TextUtils.isEmpty(eVar.G())) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("mAppId", eVar.G());
        bundle2.putAll(eVar.C());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        m(bundle2);
    }

    @UiThread
    public final void o(b.a.p0.a.v1.c.f.c cVar, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048583, this, cVar, bundle, i2) == null) {
            if (b.a.p0.a.m2.b.j()) {
                b.a.p0.a.m2.d.a.e();
            }
            SwanCoreVersion e2 = b.a.p0.a.m2.b.e(i2);
            bundle.putParcelable("swanCoreVersion", e2);
            ExtensionCore c2 = b.a.p0.a.p0.b.c(i2);
            bundle.putParcelable("extensionCore", c2);
            if (f43675a) {
                String str = "onUpdateFinished() SwanCoreVersion: " + e2;
                String str2 = "onUpdateFinished() ExtensionCoreVersion: " + c2;
            }
            Bundle H = b.a.p0.a.u1.a.a.H(b.a.p0.a.f1.e.c.b1(bundle));
            if (H != null) {
                bundle.putAll(H);
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
                jSONObject2 = b.a.p0.t.c.b(bundle.getString("mFrom"), null);
            } else {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e3) {
                    jSONObject = new JSONObject();
                    if (f43675a) {
                        e3.printStackTrace();
                    }
                }
                jSONObject2 = jSONObject;
            }
            bundle2.putString(UBCCloudControlProcessor.UBC_KEY, jSONObject2.toString());
            b.a.p0.a.v1.c.f.b.j(bundle);
            Context appContext = AppRuntime.getAppContext();
            int p = p(cVar, bundle);
            Intent intent = new Intent(appContext, cVar.k().activity);
            intent.addFlags(268435456);
            intent.putExtras(bundle);
            intent.putExtra("start_activity_time", System.currentTimeMillis());
            intent.putExtra("preAppReadyState", p);
            try {
                appContext.startActivity(intent);
            } catch (Exception e4) {
                if (f43675a) {
                    e4.printStackTrace();
                }
            }
            if (i2 == 0) {
                b.a.p0.a.c1.a.W().a(bundle.getString("mAppId"), cVar);
                d(bundle.getString("mAppId"), cVar);
            }
            b.a.p0.a.a2.d.i().post(new b(this, cVar));
        }
    }

    public final int p(@NonNull b.a.p0.a.v1.c.f.c cVar, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        int i2;
        boolean e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, bundle)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            PMSAppInfo s = b.a.p0.n.g.a.h().s(cVar.f8520g);
            if (s != null && !s.isMaxAgeExpires()) {
                if (a.C0241a.b()) {
                    e2 = b.a.p0.a.f1.h.a.b(s, bundle);
                } else {
                    e2 = b.a.p0.a.f1.h.a.e(s);
                }
                if (e2) {
                    bundle.putParcelable("pms_db_info_onload", s);
                    b.a.p0.a.h0.p.a.b(cVar, bundle);
                    i2 = 5;
                } else {
                    i2 = 4;
                }
            } else if (s == null) {
                i2 = 2;
            } else {
                i2 = s.isMaxAgeExpires() ? 3 : 0;
            }
            if (f43675a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + cVar.F();
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    /* loaded from: classes8.dex */
    public static abstract class f implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f43691e;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43691e = false;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43691e : invokeV.booleanValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f43691e = true;
            }
        }

        @Override // h.b.f, h.n.b
        public abstract /* synthetic */ void call(T t);

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return super.toString() + " checked=" + this.f43691e;
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
