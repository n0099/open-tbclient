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
import c.a.o0.a.h0.p.a;
import c.a.o0.a.v2.q0;
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
import i.b;
import i.k;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class SwanLauncher {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45831a;

    /* renamed from: b  reason: collision with root package name */
    public static final f f45832b;

    /* renamed from: c  reason: collision with root package name */
    public static final f f45833c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class a implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.v1.c.f.c f45834e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f45835f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f45836g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45837h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ SwanLauncher f45838i;

        public a(SwanLauncher swanLauncher, c.a.o0.a.v1.c.f.c cVar, Bundle bundle, int i2, String str) {
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
            this.f45838i = swanLauncher;
            this.f45834e = cVar;
            this.f45835f = bundle;
            this.f45836g = i2;
            this.f45837h = str;
        }

        @Override // i.c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45838i.o(this.f45834e, this.f45835f, this.f45836g);
                c.a.o0.a.a2.d.g().q("event_launch_swan");
            }
        }

        @Override // i.c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (q0.G() && (th instanceof T7CheckException)) {
                    return;
                }
                c.a.o0.a.a2.d.g().q("event_launch_swan");
                this.f45838i.k(th, this.f45836g, this.f45837h, this.f45835f);
            }
        }

        @Override // i.c
        public void onSubscribe(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kVar) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.v1.c.f.c f45839e;

        public b(SwanLauncher swanLauncher, c.a.o0.a.v1.c.f.c cVar) {
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
            this.f45839e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45839e.Z();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements c.a.o0.a.v1.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.v1.c.f.c f45840a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45841b;

        public c(SwanLauncher swanLauncher, c.a.o0.a.v1.c.f.c cVar, String str) {
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
            this.f45840a = cVar;
            this.f45841b = str;
        }

        @Override // c.a.o0.a.v1.c.f.a
        public void a(String str, c.a.o0.a.v1.c.f.c cVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) && cVar == this.f45840a) {
                if ("event_puppet_fmp_launch_finish".equals(str) && cVar.C() && TextUtils.equals(this.f45841b, cVar.getAppId())) {
                    c.a.o0.a.v1.c.f.e.k().h(this);
                    c.a.o0.a.f1.b.l(this.f45841b);
                } else if ("event_puppet_unload_app".equals(str) || "event_puppet_offline".equals(str)) {
                    c.a.o0.a.v1.c.f.e.k().h(this);
                    c.a.o0.a.f1.b.k(this.f45841b);
                }
            }
        }

        @Override // c.a.o0.a.v1.c.f.a
        public void timeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.o0.a.f1.b.k(this.f45841b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.v2.e1.b f45842e;

        public d(SwanLauncher swanLauncher, c.a.o0.a.v2.e1.b bVar) {
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
            this.f45842e = bVar;
        }

        @Override // i.c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.a.e0.d.h("SwanLauncher", "init onCompleted");
                c.a.o0.a.v2.e1.b bVar = this.f45842e;
                if (bVar != null) {
                    bVar.onCallback(null);
                }
            }
        }

        @Override // i.c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                c.a.o0.a.e0.d.i("SwanLauncher", "initEnv onError: ", th);
                c.a.o0.a.v2.e1.b bVar = this.f45842e;
                if (bVar != null) {
                    bVar.onCallback(new Exception("initEnv failed", th));
                }
            }
        }

        @Override // i.c
        public void onSubscribe(k kVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kVar) == null) && SwanLauncher.f45831a) {
                String str = "init onSubscribe: " + kVar;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f45843a;

        /* renamed from: b  reason: collision with root package name */
        public int f45844b;

        /* renamed from: c  reason: collision with root package name */
        public Bundle f45845c;

        /* loaded from: classes6.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public e f45846a;

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
                this.f45846a = new e(null);
            }

            public e a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f45846a : (e) invokeV.objValue;
            }

            public a b(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.f45846a.f45843a = i2;
                    return this;
                }
                return (a) invokeI.objValue;
            }

            public a c(Bundle bundle) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
                    this.f45846a.f45845c = bundle;
                    return this;
                }
                return (a) invokeL.objValue;
            }

            public a d(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                    this.f45846a.f45844b = i2;
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
            this.f45843a = -1;
            this.f45844b = -1;
        }
    }

    /* loaded from: classes6.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final SwanLauncher f45848a;
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
            f45848a = new SwanLauncher(null);
        }
    }

    /* loaded from: classes6.dex */
    public static class h extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final int f45849f;

        /* loaded from: classes6.dex */
        public class a implements c.a.o0.a.v2.e1.b<Exception> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i.c f45850e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f45851f;

            public a(h hVar, i.c cVar) {
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
                this.f45851f = hVar;
                this.f45850e = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.o0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                    if (exc == null) {
                        this.f45851f.b();
                        this.f45850e.onCompleted();
                        return;
                    }
                    i.c cVar = this.f45850e;
                    cVar.onError(new Exception("SwanJsUpdater fail frame type = " + this.f45851f.f45849f, exc));
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
            this.f45849f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: c */
        public void call(i.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                if (a()) {
                    cVar.onCompleted();
                } else {
                    c.a.o0.a.p0.e.a.d().c(new a(this, cVar), this.f45849f);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class i extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final e f45852f;

        /* loaded from: classes6.dex */
        public class a implements c.a.o0.a.h0.s.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.a.h0.s.e f45853a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ i.c f45854b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ i f45855c;

            public a(i iVar, c.a.o0.a.h0.s.e eVar, i.c cVar) {
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
                this.f45855c = iVar;
                this.f45853a = eVar;
                this.f45854b = cVar;
            }

            @Override // c.a.o0.a.h0.s.c
            public void onFail() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f45853a.f6401b) {
                    this.f45854b.onError(new T7CheckException(null));
                }
            }

            @Override // c.a.o0.a.h0.s.c
            public void onSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f45855c.g();
                    if (this.f45853a.f6401b) {
                        this.f45855c.b();
                        this.f45854b.onCompleted();
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
            this.f45852f = eVar;
        }

        @Override // com.baidu.swan.apps.env.launch.SwanLauncher.f
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.a() || c.a.o0.a.c1.a.n0().c() : invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: d */
        public void call(i.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
                c.a.o0.a.c1.a.C().c();
                if (a()) {
                    cVar.onCompleted();
                } else if (c.a.o0.a.c1.a.n0().c()) {
                    b();
                    cVar.onCompleted();
                } else {
                    e eVar = this.f45852f;
                    if (eVar.f45844b != 1) {
                        cVar.onError(new T7CheckException(null));
                        return;
                    }
                    if (eVar.f45843a == 0 && !BdZeusUtil.isZeusSupported()) {
                        b();
                        cVar.onCompleted();
                    }
                    f(cVar);
                }
            }
        }

        public final c.a.o0.a.h0.s.e e(e eVar, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, eVar, z)) == null) {
                c.a.o0.a.h0.s.e eVar2 = new c.a.o0.a.h0.s.e();
                eVar2.f6400a = "by_click";
                int i2 = this.f45852f.f45843a;
                eVar2.f6401b = z;
                Bundle bundle = eVar.f45845c;
                if (bundle != null) {
                    bundle.getString("mFrom", "unknown");
                }
                return eVar2;
            }
            return (c.a.o0.a.h0.s.e) invokeLZ.objValue;
        }

        public final void f(i.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
                Bundle bundle = this.f45852f.f45845c;
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
                if (!"1".equals(build.getQueryParameter("dependOnT7")) && this.f45852f.f45843a != 1 && !c.a.o0.a.c1.a.w().g()) {
                    z = false;
                }
                if (!z) {
                    b();
                    cVar.onCompleted();
                }
                h();
                c.a.o0.a.h0.s.e e2 = e(this.f45852f, z);
                c.a.o0.a.c1.a.n0().b(e2, new a(this, e2, cVar));
            }
        }

        public final void g() {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (bundle = this.f45852f.f45845c) == null) {
                return;
            }
            bundle.putLong("t7_loading_end", System.currentTimeMillis());
            c.a.o0.a.e0.d.h("SwanLauncher", "swanSailor loadingEnd");
        }

        public final void h() {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bundle = this.f45852f.f45845c) == null) {
                return;
            }
            bundle.putLong("t7_loading_start", System.currentTimeMillis());
            c.a.o0.a.e0.d.h("SwanLauncher", "swanSailor loadingStart");
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
        f45831a = c.a.o0.a.k.f7049a;
        f45832b = new h(0);
        f45833c = new h(1);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? g.f45848a : (SwanLauncher) invokeV.objValue;
    }

    public final void d(String str, c.a.o0.a.v1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.o0.a.v1.c.f.e.k().c(new c(this, cVar, str), TimeUnit.SECONDS.toMillis(10L));
    }

    public final void e(@NonNull i.c cVar, f... fVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, fVarArr) == null) {
            if (f45831a) {
                String str = "checkEnv: checkers=" + fVarArr;
            }
            if (fVarArr != null && fVarArr.length >= 1) {
                ArrayList arrayList = null;
                for (f fVar : fVarArr) {
                    if (f45831a) {
                        String str2 = "checkEnv: checker=" + fVar;
                    }
                    if (fVar != null && !fVar.a()) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(i.b.b(fVar));
                    }
                }
                if (f45831a) {
                    String str3 = "checkEnv: list=" + arrayList;
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    i.b.a(arrayList).h(i.l.b.a.b()).d(i.l.b.a.b()).g(cVar);
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
            c.a.o0.a.e0.d.h("SwanLauncher", "isT7Error = " + z);
            c.a.o0.a.q2.a aVar = new c.a.o0.a.q2.a();
            aVar.j(z ? 15L : 9L);
            aVar.h(z ? 42L : 25L);
            aVar.c(z ? "Sailor安装失败" : "Swan core 更新出错");
            c.a.o0.a.f1.d.a.e(AppRuntime.getAppContext(), aVar, i2, str, bundle);
        }
    }

    public void l(c.a.o0.a.v2.e1.b<Exception> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            e.a aVar = new e.a();
            aVar.b(-1);
            aVar.d(0);
            e(new d(this, bVar), new i(aVar.a()), f45832b, f45833c);
        }
    }

    public void m(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) || bundle == null) {
            return;
        }
        bundle.putLong("launch_time", System.currentTimeMillis());
        bundle.putLong("box_cold_launch", c.a.o0.a.c1.a.n().B());
        bundle.putInt("host_launch_type", c.a.o0.a.t2.a.c());
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!ProcessUtils.isMainProcess()) {
            f(bundle);
            return;
        }
        c.a.o0.a.r1.r.b.b().d(string);
        int i2 = i(bundle);
        if (i2 < 0) {
            i2 = 0;
        }
        c.a.o0.a.v1.c.f.c r = c.a.o0.a.v1.c.f.e.k().r(string);
        r.I(string);
        String string2 = bundle.getString("mPage");
        if (c.a.o0.a.n0.i.b.b(string, string2)) {
            bundle.putLong("launch_interval", c.a.o0.a.n0.i.b.a());
            c.a.o0.a.n0.i.b.c();
            c.a.o0.a.n0.i.b.d(bundle);
            return;
        }
        c.a.o0.a.n0.i.b.e(string, string2);
        c.a.o0.a.n0.i.b.c();
        if (f45831a) {
            String str = "app is cold boot = " + r.F();
        }
        c.a.o0.a.e0.d.g("SwanLauncher", "launch appId: " + string);
        bundle.putBoolean("console_switch", c.a.o0.a.e0.b.b(c.a.o0.a.v.a.a(string)));
        g(bundle);
        bundle.putLong("launch_time_on_main", System.currentTimeMillis());
        bundle.putInt("main_pid", Process.myPid());
        if (f45831a) {
            String str2 = "onReady processId: " + r.f9236f + " ,client:" + r.toString();
        }
        e.a aVar = new e.a();
        aVar.b(i2);
        aVar.d(1);
        aVar.c(bundle);
        i iVar = new i(aVar.a());
        a aVar2 = new a(this, r, bundle, i2, string);
        f[] fVarArr = new f[2];
        fVarArr[0] = iVar;
        fVarArr[1] = 1 == i2 ? f45833c : f45832b;
        e(aVar2, fVarArr);
        c.a.o0.a.n0.i.a.c(i2);
    }

    public void n(c.a.o0.a.f1.e.e eVar, Bundle bundle) {
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
    public final void o(c.a.o0.a.v1.c.f.c cVar, Bundle bundle, int i2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048583, this, cVar, bundle, i2) == null) {
            if (c.a.o0.a.m2.b.j()) {
                c.a.o0.a.m2.d.a.e();
            }
            SwanCoreVersion e2 = c.a.o0.a.m2.b.e(i2);
            bundle.putParcelable("swanCoreVersion", e2);
            ExtensionCore c2 = c.a.o0.a.p0.b.c(i2);
            bundle.putParcelable("extensionCore", c2);
            if (f45831a) {
                String str = "onUpdateFinished() SwanCoreVersion: " + e2;
                String str2 = "onUpdateFinished() ExtensionCoreVersion: " + c2;
            }
            Bundle H = c.a.o0.a.u1.a.a.H(c.a.o0.a.f1.e.c.c1(bundle));
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
                jSONObject2 = c.a.o0.t.c.b(bundle.getString("mFrom"), null);
            } else {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e3) {
                    jSONObject = new JSONObject();
                    if (f45831a) {
                        e3.printStackTrace();
                    }
                }
                jSONObject2 = jSONObject;
            }
            bundle2.putString(UBCCloudControlProcessor.UBC_KEY, jSONObject2.toString());
            c.a.o0.a.v1.c.f.b.j(bundle);
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
                if (f45831a) {
                    e4.printStackTrace();
                }
            }
            if (i2 == 0) {
                c.a.o0.a.c1.a.W().a(bundle.getString("mAppId"), cVar);
                d(bundle.getString("mAppId"), cVar);
            }
            c.a.o0.a.a2.d.i().post(new b(this, cVar));
        }
    }

    public final int p(@NonNull c.a.o0.a.v1.c.f.c cVar, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        int i2;
        boolean e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, bundle)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            PMSAppInfo s = c.a.o0.n.g.a.h().s(cVar.f9237g);
            if (s != null && !s.isMaxAgeExpires()) {
                if (a.C0244a.b()) {
                    e2 = c.a.o0.a.f1.h.a.b(s, bundle);
                } else {
                    e2 = c.a.o0.a.f1.h.a.e(s);
                }
                if (e2) {
                    bundle.putParcelable("pms_db_info_onload", s);
                    c.a.o0.a.h0.p.a.b(cVar, bundle);
                    i2 = 5;
                } else {
                    i2 = 4;
                }
            } else if (s == null) {
                i2 = 2;
            } else {
                i2 = s.isMaxAgeExpires() ? 3 : 0;
            }
            if (f45831a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "sendAppLaunch cost " + (currentTimeMillis2 - currentTimeMillis) + "ms, is cold boot = " + cVar.F();
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    /* loaded from: classes6.dex */
    public static abstract class f implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f45847e;

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
            this.f45847e = false;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f45847e : invokeV.booleanValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f45847e = true;
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return super.toString() + " checked=" + this.f45847e;
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
