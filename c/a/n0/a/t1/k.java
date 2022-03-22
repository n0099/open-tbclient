package c.a.n0.a.t1;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d2.n;
import c.a.n0.a.p2.l0;
import c.a.n0.a.p2.o0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.t1.i;
import c.a.n0.a.v0.e.b;
import c.a.n0.a.x.g.k;
import c.a.n0.q.i.m.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import java.io.File;
import java.util.Locale;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class k extends m implements c.a.n0.a.d0.l.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6353b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6354c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6355d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6356e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6357f;

    /* renamed from: g  reason: collision with root package name */
    public Set<a.C0756a> f6358g;

    /* renamed from: h  reason: collision with root package name */
    public int f6359h;
    public boolean i;
    public final c.a.n0.a.t1.e j;
    public String k;
    public boolean l;
    public PMSAppInfo m;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.t1.d.J().o("flag_finish_activity", "flag_remove_task");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.v0.e.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f6360b;

        public b(k kVar, c.a.n0.a.v0.e.b bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.f6360b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.u0(this.f6360b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f6361b;

        public c(k kVar, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6361b = kVar;
            this.a = hybridUbcFlow;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HybridUbcFlow hybridUbcFlow = this.a;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-run");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                this.f6361b.c0();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f6362b;

        public d(k kVar, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6362b = kVar;
            this.a = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bundle bundle = new Bundle();
                Bundle bundle2 = this.a;
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
                bundle.putInt("appFrameType", this.f6362b.i0().G());
                bundle.putString("mAppId", this.f6362b.getAppId());
                if (k.n) {
                    k.o0("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                c.a.n0.a.o1.c.a e2 = c.a.n0.a.o1.c.a.e();
                c.a.n0.a.o1.c.c cVar = new c.a.n0.a.o1.c.c(17, bundle);
                cVar.j(5000L);
                e2.h(cVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.n0.a.x.r.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        public e(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        @Override // c.a.n0.a.x.r.d
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckUpdate");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                this.a.b0(pMSAppInfo);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // c.a.n0.a.x.r.d
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                this.a.f6359h = 5;
                k kVar = this.a;
                kVar.a0("KEY_PKG_STATE", "event_pms_check_finish", kVar.f6359h);
                HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                if (k.n) {
                    k.o0("预制包安装成功");
                }
                k.n0(this.a.i0(), pMSAppInfo, false, false);
                this.a.L0(pMSAppInfo);
                this.a.H0(null);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // c.a.n0.a.x.r.d
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                if (k.n) {
                    k.o0("预制包安装失败");
                }
                this.a.J0();
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends c.a.n0.a.o1.a.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.v0.e.b f6363c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ k f6364d;

        public f(k kVar, c.a.n0.a.v0.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6364d = kVar;
            this.f6363c = bVar;
        }

        @Override // c.a.n0.a.o1.a.b.c.b, c.a.n0.a.o1.a.b.c.a
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1000L;
            }
            return invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.o1.a.b.c.b, c.a.n0.a.o1.a.b.c.c, c.a.n0.a.o1.a.b.c.a
        public void onEvent(@NonNull c.a.n0.a.o1.a.b.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                Bundle a = bVar.a();
                k.n0(this.f6363c, this.f6364d.m, true, a != null ? a.getBoolean("isDownloading", false) : false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g extends c.a.n0.a.x.m.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ k f6365h;

        public g(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6365h = kVar;
        }

        @Override // c.a.n0.a.x.m.e, c.a.n0.q.e.i
        public void H(c.a.n0.q.o.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                this.f6365h.f6354c = true;
                c.a.n0.a.t1.d.J().q("event_pkg_download_start");
                super.H(gVar);
            }
        }

        @Override // c.a.n0.a.x.m.e
        public void R(@NonNull c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                c.a.n0.a.k2.e.a().f(aVar);
                this.f6365h.z0(aVar);
                this.f6365h.s0(false);
            }
        }

        @Override // c.a.n0.a.x.m.e
        public void S() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f6365h.f6354c = false;
                k.n0(this.f6365h.i0(), this.f6365h.m, false, false);
                k kVar = this.f6365h;
                kVar.f6359h = kVar.i ? 3 : 4;
                this.f6365h.H0(null);
                k kVar2 = this.f6365h;
                kVar2.a0("KEY_PKG_STATE", "event_pms_check_finish", kVar2.f6359h);
            }
        }

        @Override // c.a.n0.a.x.m.e, c.a.n0.q.e.i, c.a.n0.q.e.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f6365h.f6354c = false;
                c.a.n0.a.t1.d.J().q("event_pkg_download_finish");
                super.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.n0.a.x.m.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.q.i.m.d f6366b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f6367c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ k f6368d;

        public h(k kVar, boolean z, c.a.n0.q.i.m.d dVar, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Boolean.valueOf(z), dVar, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6368d = kVar;
            this.a = z;
            this.f6366b = dVar;
            this.f6367c = hybridUbcFlow;
        }

        @Override // c.a.n0.a.x.m.p.a
        public void a(c.a.n0.a.k2.a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, aVar, z) == null) {
                long a = aVar == null ? 0L : aVar.a();
                c.a.n0.a.u.d.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalFailed isRetry = " + this.a + ",code =" + a);
                if (this.a) {
                    n.L("pkg_retry_fail", String.valueOf(a));
                }
                if (this.f6368d.Z(this.f6366b, aVar)) {
                    return;
                }
                this.f6368d.f6354c = false;
                c.a.n0.a.t1.d.J().q("event_pkg_download_finish");
                HybridUbcFlow hybridUbcFlow = this.f6367c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                c.a.n0.a.k2.e.a().f(aVar);
                if (z) {
                    k kVar = this.f6368d;
                    kVar.f6359h = kVar.i ? 3 : 4;
                    k kVar2 = this.f6368d;
                    kVar2.a0("KEY_PKG_STATE", "event_pms_check_finish", kVar2.f6359h);
                    this.f6368d.G0(aVar);
                } else if (aVar != null && aVar.h() == 1020) {
                    this.f6368d.z0(aVar);
                }
                HybridUbcFlow hybridUbcFlow2 = this.f6367c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
                if (aVar == null || aVar.h() != 2203) {
                    return;
                }
                c.a.n0.a.u.d.k("SwanPkgMaintainer", "recoverPlatform for errorCode 2203");
                if (c.a.n0.a.d0.j.c.a().b(1) == 0) {
                    c.a.n0.a.d0.j.c.a().c();
                }
            }
        }

        @Override // c.a.n0.a.x.m.p.a
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                c.a.n0.a.u.d.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalComplete isRetry = " + this.a);
                if (this.a) {
                    n.L("pkg_retry_success", "");
                }
                this.f6368d.f6354c = false;
                k kVar = this.f6368d;
                kVar.f6359h = kVar.f6356e ? 2 : 0;
                k kVar2 = this.f6368d;
                kVar2.f6359h = kVar2.i ? 1 : this.f6368d.f6359h;
                k kVar3 = this.f6368d;
                kVar3.a0("KEY_PKG_STATE", "event_pms_check_finish", kVar3.f6359h);
                HybridUbcFlow hybridUbcFlow = this.f6367c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                this.f6368d.L0(pMSAppInfo);
                this.f6368d.E0(null);
                HybridUbcFlow hybridUbcFlow2 = this.f6367c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.a.n0.a.p2.g1.c<PMSAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f6369b;

        public i(k kVar, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6369b = kVar;
            this.a = hybridUbcFlow;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                HybridUbcFlow hybridUbcFlow = this.a;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                if (k.n) {
                    k.o0("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                this.f6369b.L0(pMSAppInfo);
                this.f6369b.b0(pMSAppInfo);
                HybridUbcFlow hybridUbcFlow2 = this.a;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j extends c.a.n0.a.x.m.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean G;
        public final /* synthetic */ k H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(k kVar, c.a.n0.a.t1.e eVar, boolean z) {
            super(eVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, eVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((c.a.n0.a.t1.e) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.H = kVar;
            this.G = z;
        }

        @Override // c.a.n0.a.x.m.h, c.a.n0.a.x.m.g, c.a.n0.q.e.i
        public void H(c.a.n0.q.o.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                c.a.n0.a.u.d.k("SwanPkgMaintainer", "mFlagDownloading set onPrepareDownload isRetry = " + this.G);
                this.H.f6354c = true;
                c.a.n0.a.t1.d.J().q("event_pkg_download_start");
                super.H(gVar);
            }
        }

        @Override // c.a.n0.q.e.i, c.a.n0.q.e.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.n0.a.u.d.k("SwanPkgMaintainer", "mFlagDownloading reset onTotalPkgDownloadFinish isRetry = " + this.G);
                this.H.f6354c = false;
                c.a.n0.a.t1.d.J().q("event_pkg_download_finish");
                super.b();
            }
        }
    }

    /* renamed from: c.a.n0.a.t1.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0460k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.d2.s.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6370b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6371c;

        public RunnableC0460k(c.a.n0.a.d2.s.f fVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
            this.f6370b = str;
            this.f6371c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k.m0(this.a, this.f6370b, this.f6371c);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class l extends c.a.n0.a.o1.a.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
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

        @Override // c.a.n0.a.o1.a.a.a
        public void b(@NonNull Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                String string = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                boolean z = false;
                if (TextUtils.isEmpty(string)) {
                    this.f5585d.putBoolean("isDownloading", false);
                    c();
                    return;
                }
                boolean j = c.a.n0.q.b.j(string);
                boolean k = c.a.n0.q.b.k(string);
                if (c.a.n0.a.o1.a.a.a.f5582e) {
                    Log.d("MDelegate-Delegation", "isDownloading: " + j + ", isInQueue: " + k);
                }
                this.f5585d.putBoolean("isDownloading", (j || k) ? true : true);
                c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1223146349, "Lc/a/n0/a/t1/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1223146349, "Lc/a/n0/a/t1/k;");
                return;
            }
        }
        n = c.a.n0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(c.a.n0.a.t1.e eVar) {
        super(eVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.n0.a.t1.h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6353b = false;
        this.f6354c = false;
        this.f6355d = false;
        this.f6356e = false;
        this.f6357f = false;
        this.f6359h = -1;
        this.i = false;
        this.k = "";
        this.l = false;
        this.j = eVar;
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            SwanAppActivity x = this.j.x();
            return (x == null || x.isDestroyed()) ? c.a.n0.a.s0.a.c() : x;
        }
        return (Context) invokeV.objValue;
    }

    public static String h0(Context context, c.a.n0.a.k2.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, aVar)) == null) ? String.format(context.getResources().getString(R.string.obfuscated_res_0x7f0f019a), q0.D(), c.a.n0.a.g2.b.i(c.a.n0.a.w0.f.U().M(), c.a.n0.a.t1.d.J().r().l()), String.valueOf(aVar.a())) : (String) invokeLL.objValue;
    }

    public static void m0(c.a.n0.a.d2.s.f fVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, fVar, str, str2) == null) {
            JSONObject k = n.k(str);
            fVar.d(str2);
            fVar.b(k);
            n.onEvent(fVar);
        }
    }

    public static void n0(c.a.n0.a.v0.e.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{eVar, pMSAppInfo, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (n) {
                Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
            }
            eVar.s0().putString("aiapp_extra_need_download", z ? "1" : "0");
            eVar.s0().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
            c.a.n0.a.d2.s.f fVar = new c.a.n0.a.d2.s.f();
            fVar.a = n.n(eVar.G());
            fVar.h(eVar);
            fVar.f4188b = "launch";
            fVar.o = z ? "1" : "0";
            if (pMSAppInfo != null) {
                fVar.l = String.valueOf(pMSAppInfo.versionCode);
            }
            c.a.n0.a.k1.k.i.c.e().d(new RunnableC0460k(fVar, eVar.W(), eVar.s0().getString(UBCCloudControlProcessor.UBC_KEY)), "launchStatistic", true);
        }
    }

    public static void o0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, str) == null) && n) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    public static void x0(PMSAppInfo pMSAppInfo, Context context, c.a.n0.a.v0.e.b bVar, boolean z, String str, c.a.n0.a.k2.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{pMSAppInfo, context, bVar, Boolean.valueOf(z), str, aVar}) == null) || pMSAppInfo == null) {
            return;
        }
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo(bVar, str, h0(context, aVar));
        forbiddenInfo.enableSlidingFlag = -1;
        c.a.n0.a.v0.d.a.l(context, z ? SwanAppErrorActivity.TYPE_PATH_FORBIDDEN : SwanAppErrorActivity.TYPE_APP_FORBIDDEN, aVar, forbiddenInfo, bVar.D());
        c.a.n0.a.d2.s.f fVar = new c.a.n0.a.d2.s.f();
        fVar.a = n.n(bVar.G());
        fVar.f4188b = "launch";
        fVar.f4191e = "success";
        fVar.i(bVar);
        fVar.a("status", "2");
        fVar.d(bVar.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        n.onEvent(fVar);
    }

    public boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6354c : invokeV.booleanValue;
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.n0.a.q0.d.O(this.j);
        }
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateForIndependentPkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                o0("独立分包启动，本地有包--->打开小程序，异步更新主包");
            }
            c.a.n0.a.v0.e.b i0 = i0();
            String c2 = c.a.n0.a.v0.h.a.c(this.m, i0.e0());
            i0.F0(true);
            i0.V0(c2);
            Bundle bundle = new Bundle();
            bundle.putLong("pms_update_expect_pkg_ver", this.m.versionCode);
            H0(bundle);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateForIndependentPkgEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public final int D0(c.a.n0.a.k2.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
            HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInfoWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                o0("updateInfoWithFinalCheck: mAppInfo=" + this.m);
            }
            PMSAppInfo pMSAppInfo = this.m;
            if (pMSAppInfo == null) {
                if (aVar == null) {
                    aVar = new c.a.n0.a.k2.a();
                    aVar.k(10L);
                    aVar.i(2902L);
                    aVar.f("no pkg was installed");
                }
                c.a.n0.a.k2.e.a().f(aVar);
                z0(aVar);
                return -1;
            }
            int Y = Y(pMSAppInfo);
            if (c.a.n0.a.r2.c.g(aVar, Y)) {
                return -2;
            }
            if (Y != 10001 && Y != 10002) {
                F0();
                if (Y != 0) {
                    c.a.n0.a.k2.a g0 = g0(10003);
                    c.a.n0.a.k2.e.a().f(g0);
                    y0(false, null, g0);
                    c.a.n0.a.k1.h.k(g0);
                    c.a.n0.a.s0.a.p0().flush(false);
                    return -1;
                }
                if (!this.f6357f) {
                    Set<a.C0756a> i2 = c.a.n0.a.m1.c.a.i(this.m);
                    boolean z = i2 == null || i2.isEmpty();
                    this.f6357f = z;
                    if (!z) {
                        c.a.n0.a.k2.a aVar2 = new c.a.n0.a.k2.a();
                        aVar2.k(17L);
                        aVar2.i(2909L);
                        aVar2.f("dependent pkg is missing.");
                        c.a.n0.a.k2.e.a().f(aVar2);
                        z0(aVar2);
                        return -1;
                    }
                }
                c.a.n0.a.w0.f U = c.a.n0.a.w0.f.U();
                String e0 = r().V().e0();
                if (!TextUtils.isEmpty(e0)) {
                    if (c.a.n0.a.v1.f.f0.d.b().a(c.a.n0.a.c1.b.d(e0, U.z()))) {
                        c.a.n0.a.k2.a g02 = g0(10004);
                        c.a.n0.a.k2.e.a().f(g02);
                        y0(true, c.a.n0.a.v1.f.f0.d.b().d(), g02);
                        c.a.n0.a.k1.h.k(g02);
                        c.a.n0.a.s0.a.p0().flush(false);
                        return -1;
                    }
                }
                return 1;
            }
            if (aVar == null) {
                aVar = g0(Y);
            }
            c.a.n0.a.k2.e.a().f(aVar);
            z0(aVar);
            return -1;
        }
        return invokeL.intValue;
    }

    public final boolean E0(c.a.n0.a.k2.a aVar) {
        InterceptResult invokeL;
        c.a.n0.a.d0.d d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (j0()) {
                return false;
            }
            int D0 = D0(aVar);
            if (D0 == -1) {
                c.a.n0.a.u.d.i("SwanPkgMaintainer", "updateInstalledPkgWithFinalCheck by null launchParams");
                s0(false);
                return false;
            } else if (D0 == -2) {
                r0();
                return false;
            } else {
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateInfoWithFinalCheckOk");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
                b.a V = this.j.V();
                SwanCoreVersion j0 = V.j0();
                String str = j0 != null ? j0.swanCoreVersionName : "0";
                if (n) {
                    Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + V.k0() + " ,curSwanVersionName: " + str);
                }
                if (l0.a(V.k0(), str)) {
                    c.a.n0.a.g2.b.n(V.G());
                }
                c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME).D("launch_type", String.valueOf(V.i("host_launch_type")));
                if (V.G() == 0) {
                    B0();
                }
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
                s0(true);
                if (ProcessUtils.isMainProcess() && (d2 = c.a.n0.a.d0.f.c().d()) != null && d2.m()) {
                    d2.b(getAppId());
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.a V = r().V();
            PMSAppInfo pMSAppInfo = this.m;
            boolean z = (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || !TextUtils.equals(getAppId(), this.m.appId)) ? false : true;
            if (z) {
                V.S0(this.m);
            }
            PMSAppInfo pMSAppInfo2 = this.m;
            if (pMSAppInfo2 != null) {
                int i2 = (z && pMSAppInfo2.appCategory == 1) ? 1 : 0;
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    V.u0(i2);
                } else {
                    q0.e0(new b(this, V, i2));
                }
            }
        }
    }

    public final void G0(c.a.n0.a.k2.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) && E0(aVar)) {
            c.a.n0.a.d2.s.d dVar = new c.a.n0.a.d2.s.d();
            dVar.p(aVar);
            dVar.r(i0());
            n.R(dVar);
        }
    }

    public final void H0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                o0("启动本地包，进程预处理-加载本地包-后台异步更新");
            }
            E0(null);
            c.a.n0.a.k1.k.i.b.j().i(new d(this, bundle));
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public void I0(Set<a.C0756a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, set) == null) {
            this.f6358g = set;
            if (set == null || set.isEmpty()) {
                this.f6357f = true;
            }
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.n0.a.t1.d.J().q("event_pms_check_start");
            HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableStart");
            boolean z = true;
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            c.a.n0.a.v0.e.b i0 = i0();
            if (n) {
                o0("预置包不可用");
            }
            boolean q0 = q0();
            if (n) {
                Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + q0);
            }
            if (!q0) {
                if (!this.f6357f) {
                    Set<a.C0756a> set = this.f6358g;
                    if (set == null || set.isEmpty()) {
                        this.f6358g = c.a.n0.a.m1.c.a.i(this.m);
                    }
                    Set<a.C0756a> set2 = this.f6358g;
                    if (set2 != null && !set2.isEmpty()) {
                        z = false;
                    }
                    this.f6357f = z;
                    if (!z) {
                        f0(this.f6358g);
                        this.f6358g = null;
                        return;
                    }
                }
                if (n) {
                    o0("可以直接打开小程序，异步从Server拉取新包");
                }
                this.f6359h = 4;
                n0(i0, this.m, false, false);
                this.f6359h = this.i ? 3 : 4;
                H0(null);
                a0("KEY_PKG_STATE", "event_pms_check_finish", this.f6359h);
                return;
            }
            if (n) {
                o0("不能直接打开小程序，同步从Server拉取新包");
            }
            a0("KEY_PKG_STATE", "event_pms_check_finish", this.f6359h);
            d0(this.j.V().H(), new f(this, i0));
            String appId = getAppId();
            c.a.n0.q.i.m.d dVar = new c.a.n0.q.i.m.d(appId, i0.G());
            dVar.d("3");
            PMSAppInfo pMSAppInfo = this.m;
            dVar.u(pMSAppInfo == null ? 0L : pMSAppInfo.versionCode);
            PMSAppInfo pMSAppInfo2 = this.m;
            dVar.o(pMSAppInfo2 != null ? pMSAppInfo2.appSign : 0L);
            String f2 = o0.f(i0.e0());
            if (!TextUtils.isEmpty(f2)) {
                if (f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                dVar.t(f2);
            }
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            A((i.a) new i.a("event_on_still_maintaining").t(" event_params_pkg_update", this.l));
            c.a.n0.a.v0.d.b.a.b().g(appId);
            e0(dVar, false, null);
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgOnPresetUnavailableReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                o0(this.m == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
            }
            c.a.n0.a.x.r.c c2 = c.a.n0.a.x.r.f.b().c(getAppId());
            PMSAppInfo pMSAppInfo = this.m;
            long j2 = pMSAppInfo == null ? -1L : pMSAppInfo.versionCode;
            long j3 = c2 != null ? c2.i : -1L;
            boolean z = j3 > j2;
            if (n) {
                o0(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3)));
            }
            if (!z) {
                J0();
                return;
            }
            q("event_on_still_maintaining");
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            c.a.n0.a.x.r.f.b().e(c2, new e(this));
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgWithPresetCheckReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
        }
    }

    public void L0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, pMSAppInfo) == null) {
            this.m = pMSAppInfo;
            this.j.V().c1(pMSAppInfo);
            if (j0()) {
                F0();
                t0();
            }
        }
    }

    public final void M0(PMSAppInfo pMSAppInfo, HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, pMSAppInfo, hybridUbcFlow) == null) || pMSAppInfo == null || hybridUbcFlow == null) {
            return;
        }
        L0(pMSAppInfo);
        b0(this.m);
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("update_icon");
        ubcFlowEvent.a(true);
        hybridUbcFlow.F(ubcFlowEvent);
    }

    public final int Y(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, pMSAppInfo)) == null) {
            int i2 = pMSAppInfo.appStatus;
            if (i2 != 0) {
                return i2;
            }
            int G = i0().G();
            int i3 = pMSAppInfo.appCategory;
            return (i3 > -1 || G == i3) ? 0 : 10002;
        }
        return invokeL.intValue;
    }

    public final boolean Z(@NonNull c.a.n0.q.i.m.d dVar, c.a.n0.a.k2.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, dVar, aVar)) == null) {
            String appId = getAppId();
            if (aVar != null && SwanAppNetworkUtils.i(c.a.n0.a.s0.a.c()) && c.a.n0.a.v0.d.b.a.b().f(appId)) {
                c.a.n0.a.u.d.k("SwanPkgMaintainer", "checkGetPkgResult appId=" + appId + " errCode=" + aVar.a());
                if (aVar.h() == 2101) {
                    c.a.n0.a.v0.d.b.a.b().a(appId);
                    c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("pkg_download_retry"));
                    e0(dVar, true, aVar);
                    return true;
                } else if (aVar.h() == 2205) {
                    c.a.n0.a.d0.f.c().d().u(c.a.n0.a.p2.a1.a.a(appId), true, 12);
                    c.a.n0.a.v0.d.b.a.b().a(appId);
                    c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("pkg_download_retry"));
                    e0(dVar, true, aVar);
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void a0(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048591, this, str, str2, i2) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(str, i2);
            c.a.n0.a.t1.d.J().w(str2, bundle);
        }
    }

    public final void b0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, pMSAppInfo) == null) || pMSAppInfo == null) {
            return;
        }
        i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").z("mAppId", getAppId())).w("appFrameType", pMSAppInfo.appCategory);
        if (n) {
            o0("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
        }
        if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
            if (n) {
                o0("dispatchPmsInfo appName=" + pMSAppInfo.appName);
            }
            aVar.z("app_name", pMSAppInfo.appName);
        }
        if (pMSAppInfo.versionCode > -1) {
            if (n) {
                o0("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
            }
            aVar.x(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
        }
        if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
            if (n) {
                o0("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
            }
            aVar.z("app_icon_url", pMSAppInfo.iconUrl);
        }
        aVar.w("app_pay_protected", pMSAppInfo.payProtected);
        aVar.t("event_flag_force_post", true);
        A(aVar);
    }

    public final synchronized void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this) {
                this.f6359h = 99;
                a0("KEY_PKG_STATE", "event_pms_check_start", 99);
                b.a V = this.j.V();
                if (!c.a.n0.a.n1.a.a.H() && TextUtils.isEmpty(V.g0()) && ((!n || !V.n0()) && !V.p0())) {
                    String V2 = V.V();
                    this.k = V2;
                    if (n) {
                        c.a.n0.a.v0.g.a.d(V2).f("start");
                    }
                    c.a.n0.a.o0.k.f.b.d("1");
                    HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                    p.E("type", "1");
                    p.D("is_updating", String.valueOf(c.a.n0.a.x.c.b.a.a().b()));
                    p.F(new UbcFlowEvent("na_query_db_start"));
                    PMSAppInfo f0 = this.j.V().f0();
                    if (f0 == null || f0.isMaxAgeExpires()) {
                        f0 = c.a.n0.q.f.a.i().u(getAppId());
                    }
                    p.F(new UbcFlowEvent("na_query_db"));
                    boolean e2 = c.a.n0.a.v0.h.a.e(f0);
                    this.l = e2;
                    this.f6356e = (f0 == null || e2) ? false : true;
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("has_local_file");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (this.l) {
                        M0(f0, p);
                    }
                    if (!this.l && c.a.n0.a.v0.h.a.f(f0, V.e0())) {
                        M0(f0, p);
                        C0();
                    } else {
                        K0();
                    }
                    return;
                }
                s0(true);
            }
        }
    }

    public final void d0(@NonNull String str, @NonNull c.a.n0.a.o1.a.b.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, bVar) == null) {
            c.a.n0.a.o1.c.e.a P = c.a.n0.a.o1.c.e.a.P();
            if (P == null) {
                c.a.n0.a.o1.a.b.a.b bVar2 = new c.a.n0.a.o1.a.b.a.b(bVar.b());
                Bundle bundle = new Bundle();
                bundle.putBoolean("isDownloading", false);
                bVar2.setResult(bundle);
                bVar.onEvent(bVar2);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
            P.W(bundle2, l.class, bVar);
        }
    }

    public final void e0(@NonNull c.a.n0.q.i.m.d dVar, boolean z, @Nullable c.a.n0.a.k2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{dVar, Boolean.valueOf(z), aVar}) == null) {
            HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            dVar.v(z ? 1L : 0L);
            j jVar = new j(this, this.j, z);
            jVar.f0(new i(this, p));
            jVar.h0(new h(this, z, dVar, p));
            jVar.M(this.i ? 2 : 1);
            if (z && aVar != null) {
                dVar.p(aVar.h());
            }
            c.a.n0.q.b.c(dVar, jVar);
        }
    }

    public final void f0(Set<a.C0756a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, set) == null) {
            c.a.n0.q.i.m.a aVar = new c.a.n0.q.i.m.a(set);
            aVar.d("3");
            g gVar = new g(this);
            gVar.M(this.i ? 2 : 1);
            c.a.n0.q.b.d(aVar, gVar);
        }
    }

    public final c.a.n0.a.k2.a g0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
            switch (i2) {
                case 10001:
                    aVar.k(10L);
                    aVar.i(2902L);
                    aVar.f("no aiapps info in database");
                    break;
                case 10002:
                    aVar.k(10L);
                    aVar.i(27L);
                    aVar.f("category not match");
                    break;
                case 10003:
                    aVar.k(10L);
                    aVar.i(2107L);
                    aVar.d("app forbiddeon");
                    break;
                case 10004:
                    aVar.k(10L);
                    aVar.i(48L);
                    aVar.d("path forbiddeon");
                    break;
            }
            return aVar;
        }
        return (c.a.n0.a.k2.a) invokeI.objValue;
    }

    public c.a.n0.a.v0.e.b i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.j.V() : (c.a.n0.a.v0.e.b) invokeV.objValue;
    }

    public final boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? c.a.n0.a.t1.d.J().r().V().d("property_web_mode_degrade") : invokeV.booleanValue;
    }

    public synchronized boolean k0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            synchronized (this) {
                z = this.f6353b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean l0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            synchronized (this) {
                z = this.f6355d;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            synchronized (this) {
                if (SwanAppProcessInfo.current().isSwanAppProcess() && this.j.f6345c && !k0() && !l0()) {
                    boolean z = true;
                    this.f6353b = true;
                    HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("maintain_start");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (1 != this.j.V().G()) {
                        z = false;
                    }
                    if (z || !c.a.n0.a.x.u.g.U().m0()) {
                        q("event_on_still_maintaining");
                    }
                    if (z) {
                        w0();
                    } else {
                        c0();
                    }
                }
            }
        }
    }

    public final boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            PMSAppInfo pMSAppInfo = this.m;
            if (pMSAppInfo == null) {
                if (n) {
                    Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
                }
                p.D("launch_state", String.valueOf(0));
                a0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
                return true;
            } else if (pMSAppInfo.appStatus != 0) {
                if (n) {
                    Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
                }
                this.f6356e = true;
                p.D("launch_state", String.valueOf(2));
                a0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
                return true;
            } else if (pMSAppInfo.hasPendingErrCode()) {
                if (n) {
                    Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
                }
                this.f6356e = true;
                p.D("launch_state", String.valueOf(2));
                a0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
                return true;
            } else if (this.m.isMaxAgeExpires()) {
                if (c.a.n0.a.x.c.b.a.a().c(getAppId())) {
                    if (n) {
                        Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                    }
                    p.D("launch_state", String.valueOf(3));
                    a0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                    return false;
                }
                if (n) {
                    Log.i("SwanPkgMaintainer", "本地包已过期");
                }
                a0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
                p.D("launch_state", String.valueOf(1));
                this.i = true;
                return true;
            } else {
                p.D("launch_state", String.valueOf(4));
                a0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            synchronized (this) {
                u0(true, null);
            }
        }
    }

    public final synchronized void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            synchronized (this) {
                this.f6353b = false;
                this.f6355d = z;
                this.m = null;
                if (k.b.a()) {
                    this.j.I0(true);
                }
                if (n) {
                    o0("notifyMaintainFinish: " + z);
                }
                if (r() == c.a.n0.a.t1.d.J().r()) {
                    A((i.a) new i.a("event_on_pkg_maintain_finish").z("mAppId", this.j.f6344b));
                }
                if (n) {
                    c.a.n0.a.v0.g.a.d(this.k).h();
                }
                this.k = "";
            }
        }
    }

    public synchronized void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            synchronized (this) {
                u0(false, null);
            }
        }
    }

    public synchronized void u0(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, str) == null) {
            synchronized (this) {
                this.f6353b = false;
                this.f6355d = true;
                this.m = null;
                if (this.j != null) {
                    this.j.I0(true);
                    c.a.n0.a.u.d.i("SwanPkgMaintainer", "swan/web, notifyWebModeStart: true");
                    i.a aVar = (i.a) new i.a("event_on_web_mode_launched").z("mAppId", this.j.f6344b);
                    if (!TextUtils.isEmpty(str)) {
                        aVar.z("property_launch_url", str);
                    }
                    A(aVar);
                    n.V(z, str);
                }
                if (n) {
                    c.a.n0.a.v0.g.a.d(this.k).h();
                }
                this.k = "";
            }
        }
    }

    public int v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f6359h : invokeV.intValue;
    }

    public final synchronized void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-onhold");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                c.a.n0.a.t1.d.L().post(new c(this, p));
            }
        }
    }

    public final void y0(boolean z, String str, c.a.n0.a.k2.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Boolean.valueOf(z), str, aVar}) == null) || this.m == null) {
            return;
        }
        x0(this.m, getContext(), i0(), z, str, aVar);
    }

    public final void z0(c.a.n0.a.k2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, aVar) == null) {
            c.a.n0.a.k1.h.k(aVar);
            Context context = getContext();
            if ((context instanceof SwanAppActivity) && !c.a.n0.a.p2.f.d((SwanAppActivity) context)) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity closed, ignore launch err");
                    return;
                }
                return;
            }
            c.a.n0.a.v0.e.b i0 = i0();
            int G = i0.G();
            if (!aVar.l()) {
                c.a.n0.a.d2.s.d dVar = new c.a.n0.a.d2.s.d();
                dVar.q(n.n(G));
                dVar.p(aVar);
                dVar.m(getAppId());
                dVar.t(i0.T());
                n.R(dVar);
                aVar.n();
            }
            if (!c.a.n0.a.w0.g.a().b()) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity hide, ignore launch err and reset.");
                }
                q0.e0(new a(this));
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", i0.H());
            bundle.putAll(i0.D());
            c.a.n0.a.v0.d.a.g(c.a.n0.a.s0.a.c(), aVar, G, getAppId(), true, bundle);
            c.a.n0.a.d2.e.m(i0, G, aVar);
            c.a.n0.a.s0.a.p0().flush(false);
        }
    }
}
