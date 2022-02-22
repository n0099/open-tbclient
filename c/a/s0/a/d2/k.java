package c.a.s0.a.d2;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.d2.i;
import c.a.s0.a.f1.e.b;
import c.a.s0.a.h0.g.k;
import c.a.s0.a.n2.n;
import c.a.s0.a.z2.l0;
import c.a.s0.a.z2.o0;
import c.a.s0.a.z2.q0;
import c.a.s0.q.j.m.a;
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
public final class k extends m implements c.a.s0.a.n0.l.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5786f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5787g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5788h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5789i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f5790j;
    public Set<a.C0816a> k;
    public int l;
    public boolean m;
    public final c.a.s0.a.d2.e n;
    public String o;
    public boolean p;
    public PMSAppInfo q;

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
                c.a.s0.a.d2.d.J().o("flag_finish_activity", "flag_remove_task");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.f1.e.b f5791e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f5792f;

        public b(k kVar, c.a.s0.a.f1.e.b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5791e = bVar;
            this.f5792f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5791e.u0(this.f5792f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f5793e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f5794f;

        public c(k kVar, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5794f = kVar;
            this.f5793e = hybridUbcFlow;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HybridUbcFlow hybridUbcFlow = this.f5793e;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-run");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                this.f5794f.c0();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bundle f5795e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f5796f;

        public d(k kVar, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5796f = kVar;
            this.f5795e = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bundle bundle = new Bundle();
                Bundle bundle2 = this.f5795e;
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
                bundle.putInt("appFrameType", this.f5796f.i0().G());
                bundle.putString("mAppId", this.f5796f.getAppId());
                if (k.r) {
                    k.o0("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                c.a.s0.a.y1.c.a e2 = c.a.s0.a.y1.c.a.e();
                c.a.s0.a.y1.c.c cVar = new c.a.s0.a.y1.c.c(17, bundle);
                cVar.j(5000L);
                e2.h(cVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.s0.a.h0.r.d {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        @Override // c.a.s0.a.h0.r.d
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                HybridUbcFlow p = c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckUpdate");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                this.a.b0(pMSAppInfo);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // c.a.s0.a.h0.r.d
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                this.a.l = 5;
                k kVar = this.a;
                kVar.a0("KEY_PKG_STATE", "event_pms_check_finish", kVar.l);
                HybridUbcFlow p = c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                if (k.r) {
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

        @Override // c.a.s0.a.h0.r.d
        public void onFailed(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                HybridUbcFlow p = c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                if (k.r) {
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
    public class f extends c.a.s0.a.y1.a.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.f1.e.b f5797c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ k f5798d;

        public f(k kVar, c.a.s0.a.f1.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5798d = kVar;
            this.f5797c = bVar;
        }

        @Override // c.a.s0.a.y1.a.b.c.b, c.a.s0.a.y1.a.b.c.a
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1000L;
            }
            return invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.y1.a.b.c.b, c.a.s0.a.y1.a.b.c.c, c.a.s0.a.y1.a.b.c.a
        public void onEvent(@NonNull c.a.s0.a.y1.a.b.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                Bundle a = bVar.a();
                k.n0(this.f5797c, this.f5798d.q, true, a != null ? a.getBoolean("isDownloading", false) : false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g extends c.a.s0.a.h0.m.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k l;

        public g(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = kVar;
        }

        @Override // c.a.s0.a.h0.m.e, c.a.s0.q.f.i
        public void H(c.a.s0.q.p.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                this.l.f5787g = true;
                c.a.s0.a.d2.d.J().q("event_pkg_download_start");
                super.H(gVar);
            }
        }

        @Override // c.a.s0.a.h0.m.e
        public void R(@NonNull c.a.s0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                c.a.s0.a.u2.e.a().f(aVar);
                this.l.z0(aVar);
                this.l.s0(false);
            }
        }

        @Override // c.a.s0.a.h0.m.e
        public void S() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.l.f5787g = false;
                k.n0(this.l.i0(), this.l.q, false, false);
                k kVar = this.l;
                kVar.l = kVar.m ? 3 : 4;
                this.l.H0(null);
                k kVar2 = this.l;
                kVar2.a0("KEY_PKG_STATE", "event_pms_check_finish", kVar2.l);
            }
        }

        @Override // c.a.s0.a.h0.m.e, c.a.s0.q.f.i, c.a.s0.q.f.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.l.f5787g = false;
                c.a.s0.a.d2.d.J().q("event_pkg_download_finish");
                super.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.s0.a.h0.m.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.q.j.m.d f5799b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f5800c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ k f5801d;

        public h(k kVar, boolean z, c.a.s0.q.j.m.d dVar, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Boolean.valueOf(z), dVar, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5801d = kVar;
            this.a = z;
            this.f5799b = dVar;
            this.f5800c = hybridUbcFlow;
        }

        @Override // c.a.s0.a.h0.m.p.a
        public void a(c.a.s0.a.u2.a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, aVar, z) == null) {
                long a = aVar == null ? 0L : aVar.a();
                c.a.s0.a.e0.d.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalFailed isRetry = " + this.a + ",code =" + a);
                if (this.a) {
                    n.L("pkg_retry_fail", String.valueOf(a));
                }
                if (this.f5801d.Z(this.f5799b, aVar)) {
                    return;
                }
                this.f5801d.f5787g = false;
                c.a.s0.a.d2.d.J().q("event_pkg_download_finish");
                HybridUbcFlow hybridUbcFlow = this.f5800c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                c.a.s0.a.u2.e.a().f(aVar);
                if (z) {
                    k kVar = this.f5801d;
                    kVar.l = kVar.m ? 3 : 4;
                    k kVar2 = this.f5801d;
                    kVar2.a0("KEY_PKG_STATE", "event_pms_check_finish", kVar2.l);
                    this.f5801d.G0(aVar);
                } else if (aVar != null && aVar.h() == 1020) {
                    this.f5801d.z0(aVar);
                }
                HybridUbcFlow hybridUbcFlow2 = this.f5800c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
                if (aVar == null || aVar.h() != 2203) {
                    return;
                }
                c.a.s0.a.e0.d.k("SwanPkgMaintainer", "recoverPlatform for errorCode 2203");
                if (c.a.s0.a.n0.j.c.a().b(1) == 0) {
                    c.a.s0.a.n0.j.c.a().c();
                }
            }
        }

        @Override // c.a.s0.a.h0.m.p.a
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                c.a.s0.a.e0.d.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalComplete isRetry = " + this.a);
                if (this.a) {
                    n.L("pkg_retry_success", "");
                }
                this.f5801d.f5787g = false;
                k kVar = this.f5801d;
                kVar.l = kVar.f5789i ? 2 : 0;
                k kVar2 = this.f5801d;
                kVar2.l = kVar2.m ? 1 : this.f5801d.l;
                k kVar3 = this.f5801d;
                kVar3.a0("KEY_PKG_STATE", "event_pms_check_finish", kVar3.l);
                HybridUbcFlow hybridUbcFlow = this.f5800c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                this.f5801d.L0(pMSAppInfo);
                this.f5801d.E0(null);
                HybridUbcFlow hybridUbcFlow2 = this.f5800c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.a.s0.a.z2.g1.c<PMSAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f5802e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f5803f;

        public i(k kVar, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5803f = kVar;
            this.f5802e = hybridUbcFlow;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                HybridUbcFlow hybridUbcFlow = this.f5802e;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                if (k.r) {
                    k.o0("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                this.f5803f.L0(pMSAppInfo);
                this.f5803f.b0(pMSAppInfo);
                HybridUbcFlow hybridUbcFlow2 = this.f5802e;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j extends c.a.s0.a.h0.m.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean K;
        public final /* synthetic */ k L;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(k kVar, c.a.s0.a.d2.e eVar, boolean z) {
            super(eVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, eVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a.s0.a.d2.e) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.L = kVar;
            this.K = z;
        }

        @Override // c.a.s0.a.h0.m.h, c.a.s0.a.h0.m.g, c.a.s0.q.f.i
        public void H(c.a.s0.q.p.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                c.a.s0.a.e0.d.k("SwanPkgMaintainer", "mFlagDownloading set onPrepareDownload isRetry = " + this.K);
                this.L.f5787g = true;
                c.a.s0.a.d2.d.J().q("event_pkg_download_start");
                super.H(gVar);
            }
        }

        @Override // c.a.s0.q.f.i, c.a.s0.q.f.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.s0.a.e0.d.k("SwanPkgMaintainer", "mFlagDownloading reset onTotalPkgDownloadFinish isRetry = " + this.K);
                this.L.f5787g = false;
                c.a.s0.a.d2.d.J().q("event_pkg_download_finish");
                super.b();
            }
        }
    }

    /* renamed from: c.a.s0.a.d2.k$k  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0314k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.n2.s.f f5804e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5805f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5806g;

        public RunnableC0314k(c.a.s0.a.n2.s.f fVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5804e = fVar;
            this.f5805f = str;
            this.f5806g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k.m0(this.f5804e, this.f5805f, this.f5806g);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class l extends c.a.s0.a.y1.a.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
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

        @Override // c.a.s0.a.y1.a.a.a
        public void b(@NonNull Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                String string = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                boolean z = false;
                if (TextUtils.isEmpty(string)) {
                    this.f9927d.putBoolean("isDownloading", false);
                    c();
                    return;
                }
                boolean j2 = c.a.s0.q.b.j(string);
                boolean k = c.a.s0.q.b.k(string);
                if (c.a.s0.a.y1.a.a.a.f9924e) {
                    String str = "isDownloading: " + j2 + ", isInQueue: " + k;
                }
                this.f9927d.putBoolean("isDownloading", (j2 || k) ? true : true);
                c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(225832279, "Lc/a/s0/a/d2/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(225832279, "Lc/a/s0/a/d2/k;");
                return;
            }
        }
        r = c.a.s0.a.k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(c.a.s0.a.d2.e eVar) {
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
                super((c.a.s0.a.d2.h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5786f = false;
        this.f5787g = false;
        this.f5788h = false;
        this.f5789i = false;
        this.f5790j = false;
        this.l = -1;
        this.m = false;
        this.o = "";
        this.p = false;
        this.n = eVar;
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            SwanAppActivity x = this.n.x();
            return (x == null || x.isDestroyed()) ? c.a.s0.a.c1.a.c() : x;
        }
        return (Context) invokeV.objValue;
    }

    public static String h0(Context context, c.a.s0.a.u2.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, aVar)) == null) ? String.format(context.getResources().getString(c.a.s0.a.h.aiapps_open_failed_detail_format), q0.D(), c.a.s0.a.q2.b.i(c.a.s0.a.g1.f.U().M(), c.a.s0.a.d2.d.J().r().l()), String.valueOf(aVar.a())) : (String) invokeLL.objValue;
    }

    public static void m0(c.a.s0.a.n2.s.f fVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, fVar, str, str2) == null) {
            JSONObject k = n.k(str);
            fVar.d(str2);
            fVar.b(k);
            n.onEvent(fVar);
        }
    }

    public static void n0(c.a.s0.a.f1.e.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{eVar, pMSAppInfo, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            boolean z3 = r;
            eVar.s0().putString("aiapp_extra_need_download", z ? "1" : "0");
            eVar.s0().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
            c.a.s0.a.n2.s.f fVar = new c.a.s0.a.n2.s.f();
            fVar.a = n.n(eVar.G());
            fVar.h(eVar);
            fVar.f8219b = "launch";
            fVar.o = z ? "1" : "0";
            if (pMSAppInfo != null) {
                fVar.l = String.valueOf(pMSAppInfo.versionCode);
            }
            c.a.s0.a.u1.k.i.c.e().d(new RunnableC0314k(fVar, eVar.W(), eVar.s0().getString(UBCCloudControlProcessor.UBC_KEY)), "launchStatistic", true);
        }
    }

    public static void o0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, str) == null) {
            boolean z = r;
        }
    }

    public static void x0(PMSAppInfo pMSAppInfo, Context context, c.a.s0.a.f1.e.b bVar, boolean z, String str, c.a.s0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{pMSAppInfo, context, bVar, Boolean.valueOf(z), str, aVar}) == null) || pMSAppInfo == null) {
            return;
        }
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo(bVar, str, h0(context, aVar));
        forbiddenInfo.enableSlidingFlag = -1;
        c.a.s0.a.f1.d.a.l(context, z ? SwanAppErrorActivity.TYPE_PATH_FORBIDDEN : SwanAppErrorActivity.TYPE_APP_FORBIDDEN, aVar, forbiddenInfo, bVar.D());
        c.a.s0.a.n2.s.f fVar = new c.a.s0.a.n2.s.f();
        fVar.a = n.n(bVar.G());
        fVar.f8219b = "launch";
        fVar.f8222e = "success";
        fVar.i(bVar);
        fVar.a("status", "2");
        fVar.d(bVar.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        n.onEvent(fVar);
    }

    public boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f5787g : invokeV.booleanValue;
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.s0.a.a1.d.O(this.n);
        }
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HybridUbcFlow p = c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateForIndependentPkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (r) {
                o0("独立分包启动，本地有包--->打开小程序，异步更新主包");
            }
            c.a.s0.a.f1.e.b i0 = i0();
            String c2 = c.a.s0.a.f1.h.a.c(this.q, i0.e0());
            i0.F0(true);
            i0.V0(c2);
            Bundle bundle = new Bundle();
            bundle.putLong("pms_update_expect_pkg_ver", this.q.versionCode);
            H0(bundle);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateForIndependentPkgEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public final int D0(c.a.s0.a.u2.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
            HybridUbcFlow p = c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInfoWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (r) {
                o0("updateInfoWithFinalCheck: mAppInfo=" + this.q);
            }
            PMSAppInfo pMSAppInfo = this.q;
            if (pMSAppInfo == null) {
                if (aVar == null) {
                    aVar = new c.a.s0.a.u2.a();
                    aVar.k(10L);
                    aVar.i(2902L);
                    aVar.f("no pkg was installed");
                }
                c.a.s0.a.u2.e.a().f(aVar);
                z0(aVar);
                return -1;
            }
            int Y = Y(pMSAppInfo);
            if (c.a.s0.a.b3.c.g(aVar, Y)) {
                return -2;
            }
            if (Y != 10001 && Y != 10002) {
                F0();
                if (Y != 0) {
                    c.a.s0.a.u2.a g0 = g0(10003);
                    c.a.s0.a.u2.e.a().f(g0);
                    y0(false, null, g0);
                    c.a.s0.a.u1.h.k(g0);
                    c.a.s0.a.c1.a.p0().flush(false);
                    return -1;
                }
                if (!this.f5790j) {
                    Set<a.C0816a> i2 = c.a.s0.a.w1.c.a.i(this.q);
                    boolean z = i2 == null || i2.isEmpty();
                    this.f5790j = z;
                    if (!z) {
                        c.a.s0.a.u2.a aVar2 = new c.a.s0.a.u2.a();
                        aVar2.k(17L);
                        aVar2.i(2909L);
                        aVar2.f("dependent pkg is missing.");
                        c.a.s0.a.u2.e.a().f(aVar2);
                        z0(aVar2);
                        return -1;
                    }
                }
                c.a.s0.a.g1.f U = c.a.s0.a.g1.f.U();
                String e0 = r().V().e0();
                if (!TextUtils.isEmpty(e0)) {
                    if (c.a.s0.a.f2.f.f0.d.b().a(c.a.s0.a.m1.b.e(e0, U.z()))) {
                        c.a.s0.a.u2.a g02 = g0(10004);
                        c.a.s0.a.u2.e.a().f(g02);
                        y0(true, c.a.s0.a.f2.f.f0.d.b().d(), g02);
                        c.a.s0.a.u1.h.k(g02);
                        c.a.s0.a.c1.a.p0().flush(false);
                        return -1;
                    }
                }
                return 1;
            }
            if (aVar == null) {
                aVar = g0(Y);
            }
            c.a.s0.a.u2.e.a().f(aVar);
            z0(aVar);
            return -1;
        }
        return invokeL.intValue;
    }

    public final boolean E0(c.a.s0.a.u2.a aVar) {
        InterceptResult invokeL;
        c.a.s0.a.n0.d d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            HybridUbcFlow p = c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (j0()) {
                return false;
            }
            int D0 = D0(aVar);
            if (D0 == -1) {
                c.a.s0.a.e0.d.i("SwanPkgMaintainer", "updateInstalledPkgWithFinalCheck by null launchParams");
                s0(false);
                return false;
            } else if (D0 == -2) {
                r0();
                return false;
            } else {
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateInfoWithFinalCheckOk");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
                b.a V = this.n.V();
                SwanCoreVersion j0 = V.j0();
                String str = j0 != null ? j0.swanCoreVersionName : "0";
                if (r) {
                    String str2 = "SwanCoreVersion target string version: " + V.k0() + " ,curSwanVersionName: " + str;
                }
                if (l0.a(V.k0(), str)) {
                    c.a.s0.a.q2.b.n(V.G());
                }
                c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME).D("launch_type", String.valueOf(V.i("host_launch_type")));
                if (V.G() == 0) {
                    B0();
                }
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
                s0(true);
                if (ProcessUtils.isMainProcess() && (d2 = c.a.s0.a.n0.f.c().d()) != null && d2.m()) {
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
            PMSAppInfo pMSAppInfo = this.q;
            boolean z = (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || !TextUtils.equals(getAppId(), this.q.appId)) ? false : true;
            if (z) {
                V.S0(this.q);
            }
            PMSAppInfo pMSAppInfo2 = this.q;
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

    public final void G0(c.a.s0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) && E0(aVar)) {
            c.a.s0.a.n2.s.d dVar = new c.a.s0.a.n2.s.d();
            dVar.p(aVar);
            dVar.r(i0());
            n.R(dVar);
        }
    }

    public final void H0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            HybridUbcFlow p = c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (r) {
                o0("启动本地包，进程预处理-加载本地包-后台异步更新");
            }
            E0(null);
            c.a.s0.a.u1.k.i.b.j().i(new d(this, bundle));
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public void I0(Set<a.C0816a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, set) == null) {
            this.k = set;
            if (set == null || set.isEmpty()) {
                this.f5790j = true;
            }
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.s0.a.d2.d.J().q("event_pms_check_start");
            HybridUbcFlow p = c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableStart");
            boolean z = true;
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            c.a.s0.a.f1.e.b i0 = i0();
            if (r) {
                o0("预置包不可用");
            }
            boolean q0 = q0();
            if (r) {
                String str = "updatePkgOnPresetUnavailable: isNeedFetchPkg " + q0;
            }
            if (!q0) {
                if (!this.f5790j) {
                    Set<a.C0816a> set = this.k;
                    if (set == null || set.isEmpty()) {
                        this.k = c.a.s0.a.w1.c.a.i(this.q);
                    }
                    Set<a.C0816a> set2 = this.k;
                    if (set2 != null && !set2.isEmpty()) {
                        z = false;
                    }
                    this.f5790j = z;
                    if (!z) {
                        f0(this.k);
                        this.k = null;
                        return;
                    }
                }
                if (r) {
                    o0("可以直接打开小程序，异步从Server拉取新包");
                }
                this.l = 4;
                n0(i0, this.q, false, false);
                this.l = this.m ? 3 : 4;
                H0(null);
                a0("KEY_PKG_STATE", "event_pms_check_finish", this.l);
                return;
            }
            if (r) {
                o0("不能直接打开小程序，同步从Server拉取新包");
            }
            a0("KEY_PKG_STATE", "event_pms_check_finish", this.l);
            d0(this.n.V().H(), new f(this, i0));
            String appId = getAppId();
            c.a.s0.q.j.m.d dVar = new c.a.s0.q.j.m.d(appId, i0.G());
            dVar.d("3");
            PMSAppInfo pMSAppInfo = this.q;
            dVar.u(pMSAppInfo == null ? 0L : pMSAppInfo.versionCode);
            PMSAppInfo pMSAppInfo2 = this.q;
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
            A((i.a) new i.a("event_on_still_maintaining").t(" event_params_pkg_update", this.p));
            c.a.s0.a.f1.d.b.a.b().g(appId);
            e0(dVar, false, null);
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgOnPresetUnavailableReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            HybridUbcFlow p = c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (r) {
                o0(this.q == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
            }
            c.a.s0.a.h0.r.c c2 = c.a.s0.a.h0.r.f.b().c(getAppId());
            PMSAppInfo pMSAppInfo = this.q;
            long j2 = pMSAppInfo == null ? -1L : pMSAppInfo.versionCode;
            long j3 = c2 != null ? c2.f11738i : -1L;
            boolean z = j3 > j2;
            if (r) {
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
            c.a.s0.a.h0.r.f.b().e(c2, new e(this));
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgWithPresetCheckReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
        }
    }

    public void L0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, pMSAppInfo) == null) {
            this.q = pMSAppInfo;
            this.n.V().c1(pMSAppInfo);
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
        b0(this.q);
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

    public final boolean Z(@NonNull c.a.s0.q.j.m.d dVar, c.a.s0.a.u2.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, dVar, aVar)) == null) {
            String appId = getAppId();
            if (aVar != null && SwanAppNetworkUtils.i(c.a.s0.a.c1.a.c()) && c.a.s0.a.f1.d.b.a.b().f(appId)) {
                c.a.s0.a.e0.d.k("SwanPkgMaintainer", "checkGetPkgResult appId=" + appId + " errCode=" + aVar.a());
                if (aVar.h() == 2101) {
                    c.a.s0.a.f1.d.b.a.b().a(appId);
                    c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("pkg_download_retry"));
                    e0(dVar, true, aVar);
                    return true;
                } else if (aVar.h() == 2205) {
                    c.a.s0.a.n0.f.c().d().u(c.a.s0.a.z2.a1.a.a(appId), true, 12);
                    c.a.s0.a.f1.d.b.a.b().a(appId);
                    c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent("pkg_download_retry"));
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
            c.a.s0.a.d2.d.J().w(str2, bundle);
        }
    }

    public final void b0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, pMSAppInfo) == null) || pMSAppInfo == null) {
            return;
        }
        i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").z("mAppId", getAppId())).w("appFrameType", pMSAppInfo.appCategory);
        if (r) {
            o0("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
        }
        if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
            if (r) {
                o0("dispatchPmsInfo appName=" + pMSAppInfo.appName);
            }
            aVar.z("app_name", pMSAppInfo.appName);
        }
        if (pMSAppInfo.versionCode > -1) {
            if (r) {
                o0("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
            }
            aVar.x(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
        }
        if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
            if (r) {
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
                this.l = 99;
                a0("KEY_PKG_STATE", "event_pms_check_start", 99);
                b.a V = this.n.V();
                if (!c.a.s0.a.x1.a.a.H() && TextUtils.isEmpty(V.g0()) && ((!r || !V.n0()) && !V.p0())) {
                    String V2 = V.V();
                    this.o = V2;
                    if (r) {
                        c.a.s0.a.f1.g.a.d(V2).f("start");
                    }
                    c.a.s0.a.y0.k.f.b.d("1");
                    HybridUbcFlow p = c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                    p.E("type", "1");
                    p.D("is_updating", String.valueOf(c.a.s0.a.h0.c.b.a.a().b()));
                    p.F(new UbcFlowEvent("na_query_db_start"));
                    PMSAppInfo f0 = this.n.V().f0();
                    if (f0 == null || f0.isMaxAgeExpires()) {
                        f0 = c.a.s0.q.g.a.i().u(getAppId());
                    }
                    p.F(new UbcFlowEvent("na_query_db"));
                    boolean e2 = c.a.s0.a.f1.h.a.e(f0);
                    this.p = e2;
                    this.f5789i = (f0 == null || e2) ? false : true;
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("has_local_file");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (this.p) {
                        M0(f0, p);
                    }
                    if (!this.p && c.a.s0.a.f1.h.a.f(f0, V.e0())) {
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

    public final void d0(@NonNull String str, @NonNull c.a.s0.a.y1.a.b.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, bVar) == null) {
            c.a.s0.a.y1.c.e.a P = c.a.s0.a.y1.c.e.a.P();
            if (P == null) {
                c.a.s0.a.y1.a.b.a.b bVar2 = new c.a.s0.a.y1.a.b.a.b(bVar.b());
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

    public final void e0(@NonNull c.a.s0.q.j.m.d dVar, boolean z, @Nullable c.a.s0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{dVar, Boolean.valueOf(z), aVar}) == null) {
            HybridUbcFlow p = c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            dVar.v(z ? 1L : 0L);
            j jVar = new j(this, this.n, z);
            jVar.f0(new i(this, p));
            jVar.h0(new h(this, z, dVar, p));
            jVar.M(this.m ? 2 : 1);
            if (z && aVar != null) {
                dVar.p(aVar.h());
            }
            c.a.s0.q.b.c(dVar, jVar);
        }
    }

    public final void f0(Set<a.C0816a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, set) == null) {
            c.a.s0.q.j.m.a aVar = new c.a.s0.q.j.m.a(set);
            aVar.d("3");
            g gVar = new g(this);
            gVar.M(this.m ? 2 : 1);
            c.a.s0.q.b.d(aVar, gVar);
        }
    }

    public final c.a.s0.a.u2.a g0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            c.a.s0.a.u2.a aVar = new c.a.s0.a.u2.a();
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
        return (c.a.s0.a.u2.a) invokeI.objValue;
    }

    public c.a.s0.a.f1.e.b i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.n.V() : (c.a.s0.a.f1.e.b) invokeV.objValue;
    }

    public final boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? c.a.s0.a.d2.d.J().r().V().d("property_web_mode_degrade") : invokeV.booleanValue;
    }

    public synchronized boolean k0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            synchronized (this) {
                z = this.f5786f;
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
                z = this.f5788h;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            synchronized (this) {
                if (SwanAppProcessInfo.current().isSwanAppProcess() && this.n.f5780g && !k0() && !l0()) {
                    boolean z = true;
                    this.f5786f = true;
                    HybridUbcFlow p = c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("maintain_start");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (1 != this.n.V().G()) {
                        z = false;
                    }
                    if (z || !c.a.s0.a.h0.u.g.U().m0()) {
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
            HybridUbcFlow p = c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
            PMSAppInfo pMSAppInfo = this.q;
            if (pMSAppInfo == null) {
                boolean z = r;
                p.D("launch_state", String.valueOf(0));
                a0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
                return true;
            } else if (pMSAppInfo.appStatus != 0) {
                boolean z2 = r;
                this.f5789i = true;
                p.D("launch_state", String.valueOf(2));
                a0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
                return true;
            } else if (pMSAppInfo.hasPendingErrCode()) {
                boolean z3 = r;
                this.f5789i = true;
                p.D("launch_state", String.valueOf(2));
                a0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
                return true;
            } else if (this.q.isMaxAgeExpires()) {
                if (c.a.s0.a.h0.c.b.a.a().c(getAppId())) {
                    if (r) {
                        String str = "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId();
                    }
                    p.D("launch_state", String.valueOf(3));
                    a0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                    return false;
                }
                boolean z4 = r;
                a0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
                p.D("launch_state", String.valueOf(1));
                this.m = true;
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
                this.f5786f = false;
                this.f5788h = z;
                this.q = null;
                if (k.b.a()) {
                    this.n.I0(true);
                }
                if (r) {
                    o0("notifyMaintainFinish: " + z);
                }
                if (r() == c.a.s0.a.d2.d.J().r()) {
                    A((i.a) new i.a("event_on_pkg_maintain_finish").z("mAppId", this.n.f5779f));
                }
                if (r) {
                    c.a.s0.a.f1.g.a.d(this.o).h();
                }
                this.o = "";
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
                this.f5786f = false;
                this.f5788h = true;
                this.q = null;
                if (this.n != null) {
                    this.n.I0(true);
                    c.a.s0.a.e0.d.i("SwanPkgMaintainer", "swan/web, notifyWebModeStart: true");
                    i.a aVar = (i.a) new i.a("event_on_web_mode_launched").z("mAppId", this.n.f5779f);
                    if (!TextUtils.isEmpty(str)) {
                        aVar.z("property_launch_url", str);
                    }
                    A(aVar);
                    n.V(z, str);
                }
                if (r) {
                    c.a.s0.a.f1.g.a.d(this.o).h();
                }
                this.o = "";
            }
        }
    }

    public int v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.l : invokeV.intValue;
    }

    public final synchronized void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-onhold");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                c.a.s0.a.d2.d.L().post(new c(this, p));
            }
        }
    }

    public final void y0(boolean z, String str, c.a.s0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Boolean.valueOf(z), str, aVar}) == null) || this.q == null) {
            return;
        }
        x0(this.q, getContext(), i0(), z, str, aVar);
    }

    public final void z0(c.a.s0.a.u2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, aVar) == null) {
            c.a.s0.a.u1.h.k(aVar);
            Context context = getContext();
            if ((context instanceof SwanAppActivity) && !c.a.s0.a.z2.f.d((SwanAppActivity) context)) {
                boolean z = r;
                return;
            }
            c.a.s0.a.f1.e.b i0 = i0();
            int G = i0.G();
            if (!aVar.l()) {
                c.a.s0.a.n2.s.d dVar = new c.a.s0.a.n2.s.d();
                dVar.q(n.n(G));
                dVar.p(aVar);
                dVar.m(getAppId());
                dVar.t(i0.T());
                n.R(dVar);
                aVar.n();
            }
            if (!c.a.s0.a.g1.g.a().b()) {
                boolean z2 = r;
                q0.e0(new a(this));
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", i0.H());
            bundle.putAll(i0.D());
            c.a.s0.a.f1.d.a.g(c.a.s0.a.c1.a.c(), aVar, G, getAppId(), true, bundle);
            c.a.s0.a.n2.e.m(i0, G, aVar);
            c.a.s0.a.c1.a.p0().flush(false);
        }
    }
}
