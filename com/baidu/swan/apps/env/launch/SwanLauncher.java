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
import com.alibaba.fastjson.asm.Label;
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
import d.a.q0.a.h0.p.a;
import d.a.q0.a.v2.q0;
import h.b;
import h.k;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class SwanLauncher {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10982a;

    /* renamed from: b  reason: collision with root package name */
    public static final f f10983b;

    /* renamed from: c  reason: collision with root package name */
    public static final f f10984c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class a implements h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.v1.c.f.c f10985e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f10986f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f10987g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f10988h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ SwanLauncher f10989i;

        public a(SwanLauncher swanLauncher, d.a.q0.a.v1.c.f.c cVar, Bundle bundle, int i2, String str) {
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
            this.f10989i = swanLauncher;
            this.f10985e = cVar;
            this.f10986f = bundle;
            this.f10987g = i2;
            this.f10988h = str;
        }

        @Override // h.c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10989i.o(this.f10985e, this.f10986f, this.f10987g);
                d.a.q0.a.a2.d.g().q("event_launch_swan");
            }
        }

        @Override // h.c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (q0.G() && (th instanceof T7CheckException)) {
                    return;
                }
                d.a.q0.a.a2.d.g().q("event_launch_swan");
                this.f10989i.k(th, this.f10987g, this.f10988h, this.f10986f);
            }
        }

        @Override // h.c
        public void onSubscribe(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kVar) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.v1.c.f.c f10990e;

        public b(SwanLauncher swanLauncher, d.a.q0.a.v1.c.f.c cVar) {
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
            this.f10990e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10990e.Z();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.q0.a.v1.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.v1.c.f.c f10991a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10992b;

        public c(SwanLauncher swanLauncher, d.a.q0.a.v1.c.f.c cVar, String str) {
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
            this.f10991a = cVar;
            this.f10992b = str;
        }

        @Override // d.a.q0.a.v1.c.f.a
        public void a(String str, d.a.q0.a.v1.c.f.c cVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) && cVar == this.f10991a) {
                if ("event_puppet_fmp_launch_finish".equals(str) && cVar.C() && TextUtils.equals(this.f10992b, cVar.getAppId())) {
                    d.a.q0.a.v1.c.f.e.k().h(this);
                    d.a.q0.a.f1.b.l(this.f10992b);
                } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                    d.a.q0.a.v1.c.f.e.k().h(this);
                    d.a.q0.a.f1.b.k(this.f10992b);
                }
            }
        }

        @Override // d.a.q0.a.v1.c.f.a
        public void timeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.q0.a.f1.b.k(this.f10992b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.v2.e1.b f10993e;

        public d(SwanLauncher swanLauncher, d.a.q0.a.v2.e1.b bVar) {
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
            this.f10993e = bVar;
        }

        @Override // h.c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.e0.d.h("SwanLauncher", "init onCompleted");
                d.a.q0.a.v2.e1.b bVar = this.f10993e;
                if (bVar != null) {
                    bVar.onCallback(null);
                }
            }
        }

        @Override // h.c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                d.a.q0.a.e0.d.i("SwanLauncher", "initEnv onError: ", th);
                d.a.q0.a.v2.e1.b bVar = this.f10993e;
                if (bVar != null) {
                    bVar.onCallback(new Exception("initEnv failed", th));
                }
            }
        }

        @Override // h.c
        public void onSubscribe(k kVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kVar) == null) && SwanLauncher.f10982a) {
                Log.i("SwanLauncher", "init onSubscribe: " + kVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f10994a;

        /* renamed from: b  reason: collision with root package name */
        public int f10995b;

        /* renamed from: c  reason: collision with root package name */
        public Bundle f10996c;

        /* loaded from: classes4.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public e f10997a;

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
                this.f10997a = new e(null);
            }

            public e a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f10997a : (e) invokeV.objValue;
            }

            public a b(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.f10997a.f10994a = i2;
                    return this;
                }
                return (a) invokeI.objValue;
            }

            public a c(Bundle bundle) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
                    this.f10997a.f10996c = bundle;
                    return this;
                }
                return (a) invokeL.objValue;
            }

            public a d(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                    this.f10997a.f10995b = i2;
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
            this.f10994a = -1;
            this.f10995b = -1;
        }
    }

    /* loaded from: classes4.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final SwanLauncher f10999a;
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
            f10999a = new SwanLauncher(null);
        }
    }

    /* loaded from: classes4.dex */
    public static class h extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final int f11000f;

        /* loaded from: classes4.dex */
        public class a implements d.a.q0.a.v2.e1.b<Exception> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.c f11001e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f11002f;

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
                this.f11002f = hVar;
                this.f11001e = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.q0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                    if (exc == null) {
                        this.f11002f.b();
                        this.f11001e.onCompleted();
                        return;
                    }
                    h.c cVar = this.f11001e;
                    cVar.onError(new Exception("SwanJsUpdater fail frame type = " + this.f11002f.f11000f, exc));
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
            this.f11000f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: c */
        public void call(h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (a()) {
                    cVar.onCompleted();
                } else {
                    d.a.q0.a.p0.e.a.d().c(new a(this, cVar), this.f11000f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class i extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final e f11003f;

        /* loaded from: classes4.dex */
        public class a implements d.a.q0.a.h0.s.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.q0.a.h0.s.e f11004a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h.c f11005b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ i f11006c;

            public a(i iVar, d.a.q0.a.h0.s.e eVar, h.c cVar) {
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
                this.f11006c = iVar;
                this.f11004a = eVar;
                this.f11005b = cVar;
            }

            @Override // d.a.q0.a.h0.s.c
            public void onFail() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f11004a.f48506b) {
                    this.f11005b.onError(new T7CheckException(null));
                }
            }

            @Override // d.a.q0.a.h0.s.c
            public void onSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f11006c.g();
                    if (this.f11004a.f48506b) {
                        this.f11006c.b();
                        this.f11005b.onCompleted();
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
            this.f11003f = eVar;
        }

        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.a() || d.a.q0.a.c1.a.n0().c() : invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: d */
        public void call(h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
                d.a.q0.a.c1.a.C().c();
                if (a()) {
                    cVar.onCompleted();
                } else if (d.a.q0.a.c1.a.n0().c()) {
                    b();
                    cVar.onCompleted();
                } else {
                    e eVar = this.f11003f;
                    if (eVar.f10995b != 1) {
                        cVar.onError(new T7CheckException(null));
                        return;
                    }
                    if (eVar.f10994a == 0 && !BdZeusUtil.isZeusSupported()) {
                        b();
                        cVar.onCompleted();
                    }
                    f(cVar);
                }
            }
        }

        public final d.a.q0.a.h0.s.e e(e eVar, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, eVar, z)) == null) {
                d.a.q0.a.h0.s.e eVar2 = new d.a.q0.a.h0.s.e();
                eVar2.f48505a = "by_click";
                int i2 = this.f11003f.f10994a;
                eVar2.f48506b = z;
                Bundle bundle = eVar.f10996c;
                if (bundle != null) {
                    bundle.getString("mFrom", "unknown");
                }
                return eVar2;
            }
            return (d.a.q0.a.h0.s.e) invokeLZ.objValue;
        }

        public final void f(h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
                Bundle bundle = this.f11003f.f10996c;
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
                if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.f11003f.f10994a != 1 && !d.a.q0.a.c1.a.w().g()) {
                    z = false;
                }
                if (!z) {
                    b();
                    cVar.onCompleted();
                }
                h();
                d.a.q0.a.h0.s.e e2 = e(this.f11003f, z);
                d.a.q0.a.c1.a.n0().b(e2, new a(this, e2, cVar));
            }
        }

        public final void g() {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (bundle = this.f11003f.f10996c) == null) {
                return;
            }
            bundle.putLong("t7_loading_end", System.currentTimeMillis());
            d.a.q0.a.e0.d.h("SwanLauncher", "swanSailor loadingEnd");
        }

        public final void h() {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bundle = this.f11003f.f10996c) == null) {
                return;
            }
            bundle.putLong("t7_loading_start", System.currentTimeMillis());
            d.a.q0.a.e0.d.h("SwanLauncher", "swanSailor loadingStart");
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
        f10982a = d.a.q0.a.k.f49133a;
        f10983b = new h(0);
        f10984c = new h(1);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? g.f10999a : (SwanLauncher) invokeV.objValue;
    }

    public final void d(String str, d.a.q0.a.v1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        d.a.q0.a.v1.c.f.e.k().c(new c(this, cVar, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public final void e(@NonNull h.c cVar, f... fVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, fVarArr) == null) {
            if (f10982a) {
                Log.i("SwanLauncher", "checkEnv: checkers=" + fVarArr);
            }
            if (fVarArr != null && fVarArr.length >= 1) {
                ArrayList arrayList = null;
                for (f fVar : fVarArr) {
                    if (f10982a) {
                        Log.i("SwanLauncher", "checkEnv: checker=" + fVar);
                    }
                    if (fVar != null && !fVar.a()) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(h.b.b(fVar));
                    }
                }
                if (f10982a) {
                    Log.i("SwanLauncher", "checkEnv: list=" + arrayList);
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
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.putExtras(bundle);
            appContext.startActivity(intent);
        }
    }

    public final void k(Throwable th, int i2, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048579, this, th, i2, str, bundle) == null) {
            boolean z = th instanceof T7CheckException;
            d.a.q0.a.e0.d.h("SwanLauncher", "isT7Error = " + z);
            d.a.q0.a.q2.a aVar = new d.a.q0.a.q2.a();
            aVar.j(z ? 15L : 9L);
            aVar.h(z ? 42L : 25L);
            aVar.c(z ? "Sailor安装失败" : "Swan core 更新出错");
            d.a.q0.a.f1.d.a.e(AppRuntime.getAppContext(), aVar, i2, str, bundle);
        }
    }

    public void l(d.a.q0.a.v2.e1.b<Exception> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            e.a aVar = new e.a();
            aVar.b(-1);
            aVar.d(0);
            e(new d(this, bVar), new i(aVar.a()), f10983b, f10984c);
        }
    }

    public void m(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) || bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", d.a.q0.a.c1.a.n().B());
        bundle.putInt("host_launch_type", d.a.q0.a.t2.a.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        d.a.q0.a.r1.r.b.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        d.a.q0.a.v1.c.f.c r = d.a.q0.a.v1.c.f.e.k().r(string);
        r.I(string);
        String string2 = bundle.getString("mPage");
        if (d.a.q0.a.n0.i.b.b(string, string2)) {
            bundle.putLong("launch_interval", d.a.q0.a.n0.i.b.a());
            d.a.q0.a.n0.i.b.c();
            d.a.q0.a.n0.i.b.d(bundle);
            return;
        }
        d.a.q0.a.n0.i.b.e(string, string2);
        d.a.q0.a.n0.i.b.c();
        if (f10982a) {
            boolean F = r.F();
            Log.d("SwanPerformance", "app is cold boot = " + F);
        }
        d.a.q0.a.e0.d.g("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", d.a.q0.a.e0.b.b(d.a.q0.a.v.a.a(string)));
        g(bundle);
        bundle.putLong("launch_time_on_main", System.currentTimeMillis());
        bundle.putInt("main_pid", Process.myPid());
        if (f10982a) {
            Log.d("SwanLauncher", "onReady processId: " + r.f51259f + " ,client:" + r.toString());
        }
        e.a aVar = new e.a();
        aVar.b(i2);
        aVar.d(1);
        aVar.c(bundle);
        i iVar = new i(aVar.a());
        a aVar2 = new a(this, r, bundle, i2, string);
        f[] fVarArr = new f[2];
        fVarArr[0] = iVar;
        fVarArr[1] = 1 == i2 ? f10984c : f10983b;
        e(aVar2, fVarArr);
        d.a.q0.a.n0.i.a.c(i2);
    }

    public void n(d.a.q0.a.f1.e.e eVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, eVar, bundle) == null) || eVar == null || TextUtils.isEmpty(eVar.H())) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("mAppId", eVar.H());
        bundle2.putAll(eVar.C());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        m(bundle2);
    }

    @UiThread
    public final void o(d.a.q0.a.v1.c.f.c cVar, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048583, this, cVar, bundle, i2) == null) {
            if (d.a.q0.a.m2.b.j()) {
                d.a.q0.a.m2.d.a.e();
            }
            SwanCoreVersion e2 = d.a.q0.a.m2.b.e(i2);
            bundle.putParcelable("swanCoreVersion", e2);
            ExtensionCore c2 = d.a.q0.a.p0.b.c(i2);
            bundle.putParcelable("extensionCore", c2);
            if (f10982a) {
                Log.d("SwanLauncher", "onUpdateFinished() SwanCoreVersion: " + e2);
                Log.d("SwanLauncher", "onUpdateFinished() ExtensionCoreVersion: " + c2);
            }
            Bundle H = d.a.q0.a.u1.a.a.H(d.a.q0.a.f1.e.c.c1(bundle));
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
                jSONObject2 = d.a.q0.t.c.b(bundle.getString("mFrom"), null);
            } else {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e3) {
                    jSONObject = new JSONObject();
                    if (f10982a) {
                        e3.printStackTrace();
                    }
                }
                jSONObject2 = jSONObject;
            }
            bundle2.putString(UBCCloudControlProcessor.UBC_KEY, jSONObject2.toString());
            d.a.q0.a.v1.c.f.b.j(bundle);
            Context appContext = AppRuntime.getAppContext();
            int p = p(cVar, bundle);
            Intent intent = new Intent(appContext, cVar.k().activity);
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.putExtras(bundle);
            intent.putExtra("start_activity_time", System.currentTimeMillis());
            intent.putExtra("preAppReadyState", p);
            try {
                appContext.startActivity(intent);
            } catch (Exception e4) {
                if (f10982a) {
                    e4.printStackTrace();
                }
            }
            if (i2 == 0) {
                d.a.q0.a.c1.a.W().a(bundle.getString("mAppId"), cVar);
                d(bundle.getString("mAppId"), cVar);
            }
            d.a.q0.a.a2.d.i().post(new b(this, cVar));
        }
    }

    public final int p(@NonNull d.a.q0.a.v1.c.f.c cVar, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        int i2;
        boolean e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, bundle)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            PMSAppInfo s = d.a.q0.n.g.a.h().s(cVar.f51260g);
            if (s != null && !s.isMaxAgeExpires()) {
                if (a.C0813a.b()) {
                    e2 = d.a.q0.a.f1.h.a.b(s, bundle);
                } else {
                    e2 = d.a.q0.a.f1.h.a.e(s);
                }
                if (e2) {
                    bundle.putParcelable("pms_db_info_onload", s);
                    d.a.q0.a.h0.p.a.b(cVar, bundle);
                    i2 = 5;
                } else {
                    i2 = 4;
                }
            } else if (s == null) {
                i2 = 2;
            } else {
                i2 = s.isMaxAgeExpires() ? 3 : 0;
            }
            if (f10982a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPerformance", "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + cVar.F());
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    /* loaded from: classes4.dex */
    public static abstract class f implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f10998e;

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
            this.f10998e = false;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f10998e : invokeV.booleanValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f10998e = true;
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return super.toString() + " checked=" + this.f10998e;
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
