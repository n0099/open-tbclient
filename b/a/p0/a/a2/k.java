package b.a.p0.a.a2;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a2.i;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.v2.l0;
import b.a.p0.a.v2.o0;
import b.a.p0.a.v2.q0;
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
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class k extends m implements b.a.p0.a.n0.l.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3968f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3969g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3970h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3971i;
    public int j;
    public boolean k;
    public final b.a.p0.a.a2.e l;
    public String m;
    public boolean n;
    public final boolean o;
    public PMSAppInfo p;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f3972e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f3973f;

        public a(k kVar, HybridUbcFlow hybridUbcFlow) {
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
            this.f3973f = kVar;
            this.f3972e = hybridUbcFlow;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HybridUbcFlow hybridUbcFlow = this.f3972e;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-run");
                ubcFlowEvent.a(true);
                hybridUbcFlow.C(ubcFlowEvent);
                this.f3973f.T();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bundle f3974e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f3975f;

        public b(k kVar, Bundle bundle) {
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
            this.f3975f = kVar;
            this.f3974e = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bundle bundle = new Bundle();
                Bundle bundle2 = this.f3974e;
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
                bundle.putInt("appFrameType", this.f3975f.Y().F());
                bundle.putString("mAppId", this.f3975f.getAppId());
                if (k.q) {
                    k.d0("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                b.a.p0.a.v1.c.a e2 = b.a.p0.a.v1.c.a.e();
                b.a.p0.a.v1.c.c cVar = new b.a.p0.a.v1.c.c(17, bundle);
                cVar.j(5000L);
                e2.h(cVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.h0.r.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f3976a;

        public c(k kVar) {
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
            this.f3976a = kVar;
        }

        @Override // b.a.p0.a.h0.r.d
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckUpdate");
                ubcFlowEvent.a(true);
                p.C(ubcFlowEvent);
                this.f3976a.S(pMSAppInfo);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon");
                ubcFlowEvent2.a(true);
                p.C(ubcFlowEvent2);
            }
        }

        @Override // b.a.p0.a.h0.r.d
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                this.f3976a.j = 5;
                k kVar = this.f3976a;
                kVar.R("KEY_PKG_STATE", "event_pms_check_finish", kVar.j);
                HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart");
                ubcFlowEvent.a(true);
                p.C(ubcFlowEvent);
                if (k.q) {
                    k.d0("预制包安装成功");
                }
                k.c0(this.f3976a.Y(), pMSAppInfo, false, false);
                this.f3976a.w0(pMSAppInfo);
                this.f3976a.t0(null);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd");
                ubcFlowEvent2.a(true);
                p.C(ubcFlowEvent2);
            }
        }

        @Override // b.a.p0.a.h0.r.d
        public void onFailed(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart");
                ubcFlowEvent.a(true);
                p.C(ubcFlowEvent);
                if (k.q) {
                    k.d0("预制包安装失败");
                }
                this.f3976a.u0();
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd");
                ubcFlowEvent2.a(true);
                p.C(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends b.a.p0.a.v1.a.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f3977c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ k f3978d;

        public d(k kVar, b.a.p0.a.f1.e.b bVar) {
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
            this.f3978d = kVar;
            this.f3977c = bVar;
        }

        @Override // b.a.p0.a.v1.a.b.c.b, b.a.p0.a.v1.a.b.c.a
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1000L;
            }
            return invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v1.a.b.c.b, b.a.p0.a.v1.a.b.c.c, b.a.p0.a.v1.a.b.c.a
        public void onEvent(@NonNull b.a.p0.a.v1.a.b.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                Bundle a2 = bVar.a();
                k.c0(this.f3977c, this.f3978d.p, true, a2 != null ? a2.getBoolean("isDownloading", false) : false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.a.p0.a.h0.m.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f3979a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.n.i.m.c f3980b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f3981c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ k f3982d;

        public e(k kVar, boolean z, b.a.p0.n.i.m.c cVar, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Boolean.valueOf(z), cVar, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3982d = kVar;
            this.f3979a = z;
            this.f3980b = cVar;
            this.f3981c = hybridUbcFlow;
        }

        @Override // b.a.p0.a.h0.m.m.a
        public void a(b.a.p0.a.q2.a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, aVar, z) == null) {
                long a2 = aVar == null ? 0L : aVar.a();
                b.a.p0.a.e0.d.h("SwanPkgMaintainer", "mFlagDownloading reset onFinalFailed isRetry = " + this.f3979a + ",code =" + a2);
                if (this.f3979a) {
                    b.a.p0.a.j2.k.G("pkg_retry_fail", String.valueOf(a2));
                }
                if (this.f3982d.Q(this.f3980b, aVar)) {
                    return;
                }
                this.f3982d.f3969g = false;
                b.a.p0.a.a2.d.g().q("event_pkg_download_finish");
                HybridUbcFlow hybridUbcFlow = this.f3981c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.C(ubcFlowEvent);
                b.a.p0.a.q2.e.a().f(aVar);
                if (z) {
                    k kVar = this.f3982d;
                    kVar.j = kVar.k ? 3 : 4;
                    k kVar2 = this.f3982d;
                    kVar2.R("KEY_PKG_STATE", "event_pms_check_finish", kVar2.j);
                    this.f3982d.s0(aVar);
                } else {
                    if (aVar != null && aVar.g() == 1020) {
                        this.f3982d.l0(aVar);
                    }
                    this.f3982d.g0(false);
                }
                HybridUbcFlow hybridUbcFlow2 = this.f3981c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.C(ubcFlowEvent2);
                if (aVar == null || aVar.g() != 2203) {
                    return;
                }
                b.a.p0.a.e0.d.h("SwanPkgMaintainer", "mRecoveryABSwitch = " + this.f3982d.o);
                if (this.f3982d.o && b.a.p0.a.n0.j.c.a().b(1) == 0) {
                    b.a.p0.a.n0.j.c.a().c();
                }
            }
        }

        @Override // b.a.p0.a.h0.m.m.a
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                b.a.p0.a.e0.d.h("SwanPkgMaintainer", "mFlagDownloading reset onFinalComplete isRetry = " + this.f3979a);
                if (this.f3979a) {
                    b.a.p0.a.j2.k.G("pkg_retry_success", "");
                }
                this.f3982d.f3969g = false;
                k kVar = this.f3982d;
                kVar.j = kVar.f3971i ? 2 : 0;
                k kVar2 = this.f3982d;
                kVar2.j = kVar2.k ? 1 : this.f3982d.j;
                k kVar3 = this.f3982d;
                kVar3.R("KEY_PKG_STATE", "event_pms_check_finish", kVar3.j);
                HybridUbcFlow hybridUbcFlow = this.f3981c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.C(ubcFlowEvent);
                this.f3982d.w0(pMSAppInfo);
                this.f3982d.q0(null);
                HybridUbcFlow hybridUbcFlow2 = this.f3981c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.C(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements b.a.p0.a.v2.e1.b<PMSAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f3983e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f3984f;

        public f(k kVar, HybridUbcFlow hybridUbcFlow) {
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
            this.f3984f = kVar;
            this.f3983e = hybridUbcFlow;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                HybridUbcFlow hybridUbcFlow = this.f3983e;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.C(ubcFlowEvent);
                if (k.q) {
                    k.d0("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                this.f3984f.w0(pMSAppInfo);
                this.f3984f.S(pMSAppInfo);
                HybridUbcFlow hybridUbcFlow2 = this.f3983e;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.C(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g extends b.a.p0.a.h0.m.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean I;
        public final /* synthetic */ k J;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(k kVar, b.a.p0.a.a2.e eVar, boolean z) {
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
                    super((b.a.p0.a.a2.e) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.J = kVar;
            this.I = z;
        }

        @Override // b.a.p0.a.h0.m.g, b.a.p0.a.h0.m.f, b.a.p0.n.f.g
        public void F(b.a.p0.n.o.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                b.a.p0.a.e0.d.h("SwanPkgMaintainer", "mFlagDownloading set onPrepareDownload isRetry = " + this.I);
                this.J.f3969g = true;
                b.a.p0.a.a2.d.g().q("event_pkg_download_start");
                super.F(fVar);
            }
        }

        @Override // b.a.p0.n.f.g, b.a.p0.n.f.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b.a.p0.a.e0.d.h("SwanPkgMaintainer", "mFlagDownloading reset onTotalPkgDownloadFinish isRetry = " + this.I);
                this.J.f3969g = false;
                b.a.p0.a.a2.d.g().q("event_pkg_download_finish");
                super.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j2.p.f f3985e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f3986f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f3987g;

        public h(b.a.p0.a.j2.p.f fVar, String str, String str2) {
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
            this.f3985e = fVar;
            this.f3986f = str;
            this.f3987g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k.b0(this.f3985e, this.f3986f, this.f3987g);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f3988e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3989f;

        public i(k kVar, b.a.p0.a.f1.e.b bVar, int i2) {
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
            this.f3988e = bVar;
            this.f3989f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3988e.s0(this.f3989f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class j extends b.a.p0.a.v1.a.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j() {
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

        @Override // b.a.p0.a.v1.a.a.a
        public void b(@NonNull Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                String string = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                boolean z = false;
                if (TextUtils.isEmpty(string)) {
                    this.f8460d.putBoolean("isDownloading", false);
                    c();
                    return;
                }
                boolean h2 = b.a.p0.n.b.h(string);
                boolean i2 = b.a.p0.n.b.i(string);
                if (b.a.p0.a.v1.a.a.a.f8456e) {
                    String str = "isDownloading: " + h2 + ", isInQueue: " + i2;
                }
                this.f8460d.putBoolean("isDownloading", (h2 || i2) ? true : true);
                c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1318160856, "Lb/a/p0/a/a2/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1318160856, "Lb/a/p0/a/a2/k;");
                return;
            }
        }
        q = b.a.p0.a.k.f6397a;
        b.a.p0.a.c1.a.Z().getSwitch("swan_pms_http_request_retry_replace_net_lib", 0);
        r = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(b.a.p0.a.a2.e eVar) {
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
                super((b.a.p0.a.a2.h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f3968f = false;
        this.f3969g = false;
        this.f3970h = false;
        this.f3971i = false;
        this.j = -1;
        this.k = false;
        this.m = "";
        this.n = false;
        b.a.p0.a.c1.a.Z().getSwitch("swan_error_recovery", false);
        this.o = false;
        this.l = eVar;
    }

    public static String X(Context context, b.a.p0.a.q2.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, aVar)) == null) ? String.format(context.getResources().getString(b.a.p0.a.h.aiapps_open_failed_detail_format), q0.D(), b.a.p0.a.m2.b.i(b.a.p0.a.g1.f.T().L(), b.a.p0.a.a2.d.g().r().l()), String.valueOf(aVar.a())) : (String) invokeLL.objValue;
    }

    public static void b0(b.a.p0.a.j2.p.f fVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, fVar, str, str2) == null) {
            JSONObject k = b.a.p0.a.j2.k.k(str);
            fVar.d(str2);
            fVar.b(k);
            b.a.p0.a.j2.k.onEvent(fVar);
        }
    }

    public static void c0(b.a.p0.a.f1.e.e eVar, PMSAppInfo pMSAppInfo, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{eVar, pMSAppInfo, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            boolean z3 = q;
            eVar.q0().putString("aiapp_extra_need_download", z ? "1" : "0");
            eVar.q0().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
            b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
            fVar.f6383a = b.a.p0.a.j2.k.m(eVar.F());
            fVar.h(eVar);
            fVar.f6384b = "launch";
            fVar.o = z ? "1" : "0";
            if (pMSAppInfo != null) {
                fVar.l = String.valueOf(pMSAppInfo.versionCode);
            }
            b.a.p0.a.r1.k.i.c.f().e(new h(fVar, eVar.V(), eVar.q0().getString(UBCCloudControlProcessor.UBC_KEY)), "launchStatistic");
        }
    }

    public static void d0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            boolean z = q;
        }
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            SwanAppActivity x = this.l.x();
            return (x == null || x.isDestroyed()) ? b.a.p0.a.c1.a.b() : x;
        }
        return (Context) invokeV.objValue;
    }

    public static void j0(PMSAppInfo pMSAppInfo, Context context, b.a.p0.a.f1.e.b bVar, boolean z, String str, b.a.p0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{pMSAppInfo, context, bVar, Boolean.valueOf(z), str, aVar}) == null) || pMSAppInfo == null) {
            return;
        }
        if (!b.a.p0.a.c1.a.O().a(context, b.a.p0.a.a2.d.g().r().k(), aVar)) {
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo(bVar, str, X(context, aVar));
            forbiddenInfo.enableSlidingFlag = -1;
            b.a.p0.a.f1.d.a.k(context, z ? SwanAppErrorActivity.TYPE_PATH_FORBIDDEN : SwanAppErrorActivity.TYPE_APP_FORBIDDEN, bVar.C(), forbiddenInfo);
        }
        b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
        fVar.f6383a = b.a.p0.a.j2.k.m(bVar.F());
        fVar.f6384b = "launch";
        fVar.f6387e = "success";
        fVar.i(bVar);
        fVar.a("status", "2");
        fVar.d(bVar.q0().getString(UBCCloudControlProcessor.UBC_KEY));
        b.a.p0.a.j2.k.onEvent(fVar);
    }

    public final int P(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pMSAppInfo)) == null) {
            int i2 = pMSAppInfo.appStatus;
            if (i2 != 0) {
                return i2;
            }
            if (TextUtils.isEmpty(pMSAppInfo.appId)) {
                return 10001;
            }
            int F = Y().F();
            int i3 = pMSAppInfo.appCategory;
            return (i3 > -1 || F == i3) ? 0 : 10002;
        }
        return invokeL.intValue;
    }

    public final boolean Q(@NonNull b.a.p0.n.i.m.c cVar, b.a.p0.a.q2.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, aVar)) == null) {
            String appId = getAppId();
            if (aVar != null && SwanAppNetworkUtils.i(b.a.p0.a.c1.a.b()) && b.a.p0.a.f1.d.b.a.b().f(appId)) {
                b.a.p0.a.e0.d.h("SwanPkgMaintainer", "checkGetPkgResult appId=" + appId + " errCode=" + aVar.a());
                if (aVar.g() == 2101) {
                    b.a.p0.a.f1.d.b.a.b().a(appId);
                    b.a.p0.a.r1.h.p("startup").C(new UbcFlowEvent("pkg_download_retry"));
                    V(cVar, true, aVar);
                    return true;
                } else if (aVar.g() == 2205) {
                    b.a.p0.a.n0.f.c().d().u(b.a.p0.a.v2.z0.a.a(appId), true, 12);
                    b.a.p0.a.f1.d.b.a.b().a(appId);
                    b.a.p0.a.r1.h.p("startup").C(new UbcFlowEvent("pkg_download_retry"));
                    V(cVar, true, aVar);
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void R(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i2) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(str, i2);
            b.a.p0.a.a2.d.g().w(str2, bundle);
        }
    }

    public final void S(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pMSAppInfo) == null) || pMSAppInfo == null) {
            return;
        }
        i.a aVar = (i.a) ((i.a) new i.a("event_on_app_icon_update").y("mAppId", getAppId())).v("appFrameType", pMSAppInfo.appCategory);
        if (q) {
            d0("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
        }
        if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
            if (q) {
                d0("dispatchPmsInfo appName=" + pMSAppInfo.appName);
            }
            aVar.y("app_name", pMSAppInfo.appName);
        }
        if (pMSAppInfo.versionCode > -1) {
            if (q) {
                d0("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
            }
            aVar.w(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
        }
        if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
            if (q) {
                d0("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
            }
            aVar.y("app_icon_url", pMSAppInfo.iconUrl);
        }
        aVar.v("app_pay_protected", pMSAppInfo.payProtected);
        aVar.s("event_flag_force_post", true);
        A(aVar);
    }

    public final synchronized void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                this.j = 99;
                R("KEY_PKG_STATE", "event_pms_check_start", 99);
                b.a K = this.l.K();
                if (!b.a.p0.a.u1.a.a.G() && TextUtils.isEmpty(K.f0()) && ((!q || !K.l0()) && !K.n0())) {
                    String U = K.U();
                    this.m = U;
                    if (q) {
                        b.a.p0.a.f1.g.a.d(U).f("start");
                    }
                    if (b.a.p0.a.h0.n.a.a.c()) {
                        b.a.p0.a.y0.k.f.b.d("0");
                    } else {
                        b.a.p0.a.y0.k.f.b.e("1");
                    }
                    HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
                    p.B("type", "1");
                    p.A("is_updating", String.valueOf(b.a.p0.a.h0.c.b.a.a().b()));
                    p.C(new UbcFlowEvent("na_query_db_start"));
                    PMSAppInfo e0 = this.l.K().e0();
                    if (e0 == null || e0.isMaxAgeExpires()) {
                        e0 = b.a.p0.n.g.a.h().s(getAppId());
                    }
                    p.C(new UbcFlowEvent("na_query_db"));
                    boolean e2 = b.a.p0.a.f1.h.a.e(e0);
                    this.n = e2;
                    this.f3971i = (e0 == null || e2) ? false : true;
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("has_local_file");
                    ubcFlowEvent.a(true);
                    p.C(ubcFlowEvent);
                    if (this.n) {
                        x0(e0, p);
                    }
                    if (!this.n && b.a.p0.a.f1.h.a.f(e0, K.d0())) {
                        x0(e0, p);
                        o0();
                    } else {
                        v0();
                    }
                    return;
                }
                g0(true);
            }
        }
    }

    public final void U(@NonNull String str, @NonNull b.a.p0.a.v1.a.b.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, bVar) == null) {
            b.a.p0.a.v1.c.e.a E = b.a.p0.a.v1.c.e.a.E();
            if (E == null) {
                b.a.p0.a.v1.a.b.a.b bVar2 = new b.a.p0.a.v1.a.b.a.b(bVar.b());
                Bundle bundle = new Bundle();
                bundle.putBoolean("isDownloading", false);
                bVar2.setResult(bundle);
                bVar.onEvent(bVar2);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
            E.L(bundle2, j.class, bVar);
        }
    }

    public final void V(@NonNull b.a.p0.n.i.m.c cVar, boolean z, @Nullable b.a.p0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{cVar, Boolean.valueOf(z), aVar}) == null) {
            HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
            cVar.t(z ? 1L : 0L);
            g gVar = new g(this, this.l, z);
            gVar.b0(new f(this, p));
            gVar.d0(new e(this, z, cVar, p));
            gVar.K(this.k ? 2 : 1);
            if (r == 1 && z && aVar != null && aVar.g() == 2101) {
                b.a.p0.a.e0.d.h("SwanPkgMaintainer", "PMS请求失败后重试时替换网络库");
                b.a.p0.n.b.c(cVar, gVar);
                return;
            }
            b.a.p0.n.b.b(cVar, gVar);
        }
    }

    public final b.a.p0.a.q2.a W(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
            switch (i2) {
                case 10001:
                    aVar.j(10L);
                    aVar.h(2902L);
                    aVar.e("no aiapps info in database");
                    break;
                case 10002:
                    aVar.j(10L);
                    aVar.h(27L);
                    aVar.e("category not match");
                    break;
                case 10003:
                    aVar.j(10L);
                    aVar.h(2107L);
                    aVar.c("app forbiddeon");
                    break;
                case 10004:
                    aVar.j(10L);
                    aVar.h(48L);
                    aVar.c("path forbiddeon");
                    break;
            }
            return aVar;
        }
        return (b.a.p0.a.q2.a) invokeI.objValue;
    }

    public b.a.p0.a.f1.e.b Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.l.K() : (b.a.p0.a.f1.e.b) invokeV.objValue;
    }

    public synchronized boolean Z() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                z = this.f3968f;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean a0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                z = this.f3970h;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                if (SwanAppProcessInfo.current().isSwanAppProcess() && this.l.f3962g && !Z() && !a0()) {
                    boolean z = true;
                    this.f3968f = true;
                    HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("maintain_start");
                    ubcFlowEvent.a(true);
                    p.C(ubcFlowEvent);
                    if (1 != this.l.K().F()) {
                        z = false;
                    }
                    if (z || !b.a.p0.a.h0.u.g.M().b0()) {
                        q("event_on_still_maintaining");
                    }
                    if (z) {
                        i0();
                    } else {
                        T();
                    }
                }
            }
        }
    }

    public final boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
            PMSAppInfo pMSAppInfo = this.p;
            if (pMSAppInfo == null) {
                boolean z = q;
                p.A("launch_state", String.valueOf(0));
                R("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
                return true;
            } else if (pMSAppInfo.appStatus != 0) {
                boolean z2 = q;
                this.f3971i = true;
                p.A("launch_state", String.valueOf(2));
                R("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
                return true;
            } else if (pMSAppInfo.hasPendingErrCode()) {
                boolean z3 = q;
                this.f3971i = true;
                p.A("launch_state", String.valueOf(2));
                R("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
                return true;
            } else if (this.p.isMaxAgeExpires()) {
                if (b.a.p0.a.h0.c.b.a.a().c(getAppId())) {
                    if (q) {
                        String str = "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId();
                    }
                    p.A("launch_state", String.valueOf(3));
                    R("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                    return false;
                }
                boolean z4 = q;
                R("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
                p.A("launch_state", String.valueOf(1));
                this.k = true;
                return true;
            } else {
                p.A("launch_state", String.valueOf(4));
                R("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final synchronized void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            synchronized (this) {
                this.f3968f = false;
                this.f3970h = z;
                this.p = null;
                if (q) {
                    d0("notifyMaintainFinish: " + z);
                }
                A((i.a) new i.a("event_on_pkg_maintain_finish").y("mAppId", this.l.f3961f));
                if (q) {
                    b.a.p0.a.f1.g.a.d(this.m).h();
                }
                this.m = "";
            }
        }
    }

    public int h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.j : invokeV.intValue;
    }

    public final synchronized void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-onhold");
                ubcFlowEvent.a(true);
                p.C(ubcFlowEvent);
                b.a.p0.a.a2.d.i().post(new a(this, p));
            }
        }
    }

    public final void k0(boolean z, String str, b.a.p0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), str, aVar}) == null) || this.p == null) {
            return;
        }
        j0(this.p, getContext(), Y(), z, str, aVar);
    }

    public final void l0(b.a.p0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            b.a.p0.a.r1.h.k(aVar);
            Context context = getContext();
            if ((context instanceof SwanAppActivity) && !b.a.p0.a.v2.f.d((SwanAppActivity) context)) {
                boolean z = q;
                return;
            }
            b.a.p0.a.f1.e.b Y = Y();
            int F = Y.F();
            if (!aVar.k()) {
                b.a.p0.a.j2.p.d dVar = new b.a.p0.a.j2.p.d();
                dVar.q(b.a.p0.a.j2.k.m(F));
                dVar.p(aVar);
                dVar.m(getAppId());
                dVar.t(Y.S());
                b.a.p0.a.j2.k.L(dVar);
                aVar.m();
            }
            if (!b.a.p0.a.g1.g.a().b()) {
                boolean z2 = q;
                b.a.p0.a.a2.d.g().o("flag_finish_activity", "flag_remove_task");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", Y.G());
            bundle.putAll(Y.C());
            b.a.p0.a.f1.d.a.f(b.a.p0.a.c1.a.b(), aVar, F, getAppId(), true, bundle);
            b.a.p0.a.j2.e.m(Y, F, aVar);
            b.a.p0.a.c1.a.g0().flush(false);
        }
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f3969g : invokeV.booleanValue;
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            b.a.p0.a.a1.e.M(this.l);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateForIndependentPkgStart");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            if (q) {
                d0("独立分包启动，本地有包--->打开小程序，异步更新主包");
            }
            b.a.p0.a.f1.e.b Y = Y();
            String c2 = b.a.p0.a.f1.h.a.c(this.p, Y.d0());
            Y.D0(true);
            Y.T0(c2);
            Bundle bundle = new Bundle();
            bundle.putLong("pms_update_expect_pkg_ver", this.p.versionCode);
            t0(bundle);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateForIndependentPkgEnd");
            ubcFlowEvent2.a(true);
            p.C(ubcFlowEvent2);
        }
    }

    public final boolean p0(b.a.p0.a.q2.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, aVar)) == null) {
            HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInfoWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            if (q) {
                d0("updateInfoWithFinalCheck: mAppInfo=" + this.p);
            }
            PMSAppInfo pMSAppInfo = this.p;
            if (pMSAppInfo == null) {
                if (aVar == null) {
                    aVar = new b.a.p0.a.q2.a();
                    aVar.j(10L);
                    aVar.h(2902L);
                    aVar.e("no pkg was installed");
                }
                b.a.p0.a.q2.e.a().f(aVar);
                l0(aVar);
                return false;
            }
            int P = P(pMSAppInfo);
            if (P != 10001 && P != 10002) {
                r0();
                if (P != 0) {
                    b.a.p0.a.q2.a W = W(10003);
                    b.a.p0.a.q2.e.a().f(W);
                    k0(false, null, W);
                    b.a.p0.a.r1.h.k(W);
                    b.a.p0.a.c1.a.g0().flush(false);
                    return false;
                }
                b.a.p0.a.g1.f T = b.a.p0.a.g1.f.T();
                String d0 = r().K().d0();
                if (!TextUtils.isEmpty(d0)) {
                    if (b.a.p0.a.c2.f.g0.d.b().a(b.a.p0.a.l1.b.e(d0, T.z()))) {
                        b.a.p0.a.q2.a W2 = W(10004);
                        b.a.p0.a.q2.e.a().f(W2);
                        k0(true, b.a.p0.a.c2.f.g0.d.b().d(), W2);
                        b.a.p0.a.r1.h.k(W2);
                        b.a.p0.a.c1.a.g0().flush(false);
                        return false;
                    }
                }
                return true;
            }
            if (aVar == null) {
                aVar = W(P);
            }
            b.a.p0.a.q2.e.a().f(aVar);
            l0(aVar);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean q0(b.a.p0.a.q2.a aVar) {
        InterceptResult invokeL;
        b.a.p0.a.n0.d d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, aVar)) == null) {
            HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            if (!p0(aVar)) {
                if (q) {
                    d0("updateInstalledPkgWithFinalCheck by null launchParams");
                }
                g0(false);
                return false;
            }
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateInfoWithFinalCheckOk");
            ubcFlowEvent2.a(true);
            p.C(ubcFlowEvent2);
            b.a K = this.l.K();
            String str = K.h0() != null ? K.h0().swanCoreVersionName : "0";
            if (q) {
                String str2 = "SwanCoreVersion target string version: " + K.i0() + " ,curSwanVersionName: " + str;
            }
            if (l0.a(K.i0(), str)) {
                b.a.p0.a.m2.b.n(K.F());
            }
            b.a.p0.a.r1.h.p("startup").A("launch_type", String.valueOf(K.i("host_launch_type")));
            if (K.F() == 0) {
                n0();
            }
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd");
            ubcFlowEvent3.a(true);
            p.C(ubcFlowEvent3);
            g0(true);
            if (ProcessUtils.isMainProcess() && (d2 = b.a.p0.a.n0.f.c().d()) != null && d2.m()) {
                d2.b(getAppId());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            b.a K = r().K();
            PMSAppInfo pMSAppInfo = this.p;
            boolean z = (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || !TextUtils.equals(getAppId(), this.p.appId)) ? false : true;
            if (z) {
                K.Q0(this.p);
            }
            int i2 = (z && this.p.appCategory == 1) ? 1 : 0;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                K.s0(i2);
            } else {
                q0.b0(new i(this, K, i2));
            }
        }
    }

    public final void s0(b.a.p0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) && q0(aVar)) {
            b.a.p0.a.j2.p.d dVar = new b.a.p0.a.j2.p.d();
            dVar.p(aVar);
            dVar.r(Y());
            b.a.p0.a.j2.k.L(dVar);
        }
    }

    public final void t0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            if (q) {
                d0("启动本地包，进程预处理-加载本地包-后台异步更新");
            }
            q0(null);
            b.a.p0.a.r1.k.i.a.k().j(new b(this, bundle));
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd");
            ubcFlowEvent2.a(true);
            p.C(ubcFlowEvent2);
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            b.a.p0.a.a2.d.g().q("event_pms_check_start");
            HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableStart");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            b.a.p0.a.f1.e.b Y = Y();
            if (q) {
                d0("预置包不可用");
            }
            boolean f0 = f0();
            if (q) {
                String str = "updatePkgOnPresetUnavailable: isNeedFetchPkg " + f0;
            }
            if (!f0) {
                if (q) {
                    d0("可以直接打开小程序，异步从Server拉取新包");
                }
                this.j = 4;
                c0(Y, this.p, false, false);
                this.j = this.k ? 3 : 4;
                t0(null);
                R("KEY_PKG_STATE", "event_pms_check_finish", this.j);
                return;
            }
            if (q) {
                d0("不能直接打开小程序，同步从Server拉取新包");
            }
            R("KEY_PKG_STATE", "event_pms_check_finish", this.j);
            U(this.l.K().G(), new d(this, Y));
            String appId = getAppId();
            b.a.p0.n.i.m.c cVar = new b.a.p0.n.i.m.c(appId, Y.F());
            cVar.d("3");
            PMSAppInfo pMSAppInfo = this.p;
            cVar.s(pMSAppInfo == null ? 0L : pMSAppInfo.versionCode);
            PMSAppInfo pMSAppInfo2 = this.p;
            cVar.n(pMSAppInfo2 != null ? pMSAppInfo2.appSign : 0L);
            String f2 = o0.f(Y.d0());
            if (!TextUtils.isEmpty(f2)) {
                if (f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                cVar.r(f2);
            }
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest");
            ubcFlowEvent2.a(true);
            p.C(ubcFlowEvent2);
            A((i.a) new i.a("event_on_still_maintaining").s(" event_params_pkg_update", this.n));
            b.a.p0.a.f1.d.b.a.b().g(appId);
            V(cVar, false, null);
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgOnPresetUnavailableReturn");
            ubcFlowEvent3.a(true);
            p.C(ubcFlowEvent3);
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckStart");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            if (q) {
                d0(this.p == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
            }
            b.a.p0.a.h0.r.c c2 = b.a.p0.a.h0.r.f.b().c(getAppId());
            PMSAppInfo pMSAppInfo = this.p;
            long j2 = pMSAppInfo == null ? -1L : pMSAppInfo.versionCode;
            long j3 = c2 != null ? c2.f11078i : -1L;
            boolean z = j3 > j2;
            if (q) {
                d0(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3)));
            }
            if (!z) {
                u0();
                return;
            }
            q("event_on_still_maintaining");
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp");
            ubcFlowEvent2.a(true);
            p.C(ubcFlowEvent2);
            b.a.p0.a.h0.r.f.b().e(c2, new c(this));
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgWithPresetCheckReturn");
            ubcFlowEvent3.a(true);
            p.C(ubcFlowEvent3);
        }
    }

    public final void w0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, pMSAppInfo) == null) {
            this.p = pMSAppInfo;
            this.l.K().Z0(pMSAppInfo);
        }
    }

    public final void x0(PMSAppInfo pMSAppInfo, HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048605, this, pMSAppInfo, hybridUbcFlow) == null) || pMSAppInfo == null || hybridUbcFlow == null) {
            return;
        }
        w0(pMSAppInfo);
        S(this.p);
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("update_icon");
        ubcFlowEvent.a(true);
        hybridUbcFlow.C(ubcFlowEvent);
    }
}
