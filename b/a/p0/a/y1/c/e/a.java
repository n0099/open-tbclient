package b.a.p0.a.y1.c.e;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.d;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.g1.f;
import b.a.p0.a.h0.l.g.h;
import b.a.p0.a.h0.o.j.e.a;
import b.a.p0.a.h0.p.a;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.k;
import b.a.p0.a.z2.q0;
import b.a.p0.q.j.m.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.IProcessBridge;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes;
import com.baidu.swan.apps.core.prefetch.statistics.item.RecordType;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.wallet.pay.PayActivityStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class a extends b.a.p0.a.y1.c.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public static final long m;
    public static final Object n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final e f9478f;

    /* renamed from: g  reason: collision with root package name */
    public IProcessBridge f9479g;

    /* renamed from: h  reason: collision with root package name */
    public d f9480h;

    /* renamed from: i  reason: collision with root package name */
    public ServiceConnection f9481i;
    public final Deque<Long> j;
    public List<Runnable> k;

    /* renamed from: b.a.p0.a.y1.c.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0485a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f9482e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9482e = aVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                if (a.l) {
                    String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder);
                }
                if (this.f9482e.N() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                    if (a.l) {
                        String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(this.f9482e.N()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess()));
                        return;
                    }
                    return;
                }
                this.f9482e.f9479g = IProcessBridge.Stub.asInterface(iBinder);
                a aVar = this.f9482e;
                aVar.Y(13, aVar.O());
                if (this.f9482e.f9480h != null) {
                    this.f9482e.f9480h.a();
                }
                b.a.p0.a.y1.c.a.e().c();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                boolean unused = a.l;
                this.f9482e.T();
            }
        }

        public /* synthetic */ b(a aVar, C0485a c0485a) {
            this(aVar);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(Message message);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    public static class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<c> f9483a;

        /* renamed from: b.a.p0.a.y1.c.e.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0486a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0486a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
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
                    b.a.p0.a.e0.d.k("SwanAppMessengerClient", "Recovery kill self");
                    Process.killProcess(Process.myPid());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e() {
            super(Looper.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public final boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                WeakReference<c> weakReference = this.f9483a;
                c cVar = weakReference != null ? weakReference.get() : null;
                if ((cVar == null || !cVar.a(message)) && !e(message)) {
                    return b.a.p0.a.c1.a.q0().a(message);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final String b(PrefetchEvent prefetchEvent, @NonNull b.a.p0.a.d2.e eVar, b.a.p0.a.h0.o.k.a aVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, prefetchEvent, eVar, aVar)) == null) {
                SwanAppConfigData P = eVar.P();
                if (P == null) {
                    boolean unused = a.l;
                    return null;
                }
                String n1 = b.a.p0.a.f1.e.b.n1(prefetchEvent.schema, P);
                if (TextUtils.isEmpty(n1)) {
                    if (aVar.f6015b) {
                        return P.g(aVar.f6016c);
                    }
                    return P.f();
                }
                return n1;
            }
            return (String) invokeLLL.objValue;
        }

        public final void c(Message message) {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            String string = bundle.getString("ai_apps_data");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                b.a.p0.a.f2.f.h0.a.d().b(Intent.parseUri(string, 0));
            } catch (URISyntaxException e2) {
                if (a.l) {
                    e2.printStackTrace();
                }
            }
        }

        public final void d(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
                boolean unused = a.l;
                b.a.p0.a.h0.u.h.a.e();
                b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
                if (a0 != null) {
                    if (!TextUtils.isEmpty(a0.V().V())) {
                        b.a.p0.a.h0.u.b.c(18);
                        return;
                    } else if (a0.H()) {
                        if (!"update_tag_by_activity_on_create".equals(a0.i0())) {
                            if ("update_tag_by_activity_on_new_intent".equals(a0.i0())) {
                                b.a.p0.a.h0.u.b.c(17);
                                return;
                            } else {
                                b.a.p0.a.h0.u.b.c(6);
                                return;
                            }
                        }
                        b.a.p0.a.h0.u.b.c(16);
                        if (!a.C0253a.c()) {
                            return;
                        }
                    }
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle == null) {
                    b.a.p0.a.h0.u.b.c(7);
                    return;
                }
                bundle.setClassLoader(e.class.getClassLoader());
                Bundle bundle2 = bundle.getBundle("swan_app_on_launch_event");
                if (bundle2 == null) {
                    b.a.p0.a.h0.u.b.c(8);
                } else if (g.U().m0()) {
                    boolean unused2 = a.l;
                    b.a.p0.a.u1.k.i.b.j().m();
                    b.a.p0.a.d2.d.J().m(bundle2, "update_tag_by_app_launch");
                    b.a.p0.a.d2.e a02 = b.a.p0.a.d2.e.a0();
                    if (a02 != null && b.a.p0.a.a1.d.O(a02)) {
                        Set<a.C0647a> i2 = b.a.p0.a.w1.c.a.i(a02.V().f0());
                        a02.L0(i2);
                        if (i2 != null && !i2.isEmpty()) {
                            b.a.p0.a.h0.u.b.c(19);
                            return;
                        }
                        b.a.p0.a.h0.q.b.k().x(bundle2.getString("mAppId", null), false);
                        boolean unused3 = a.l;
                        f.U().Q(a02.l());
                        g.U().W0(a02);
                        if (b.a.p0.a.h0.n.a.a.a() && b.a.p0.a.h0.n.a.a.c()) {
                            b.a.p0.a.e0.d.i("SwanAppMessengerClient", "handleAppOnLaunch: init cache video ");
                            b.a.p0.a.y0.k.d.a();
                        }
                        boolean unused4 = a.l;
                        return;
                    }
                    b.a.p0.a.h0.u.b.c(10);
                } else {
                    b.a.p0.a.h0.u.b.c(9);
                    g.U().H0(null);
                }
            }
        }

        public final boolean e(Message message) {
            InterceptResult invokeL;
            b.a.p0.a.d2.e a0;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, message)) == null) {
                if (h.b().a() == null || (a0 = b.a.p0.a.d2.e.a0()) == null || a0.H()) {
                    return false;
                }
                int i2 = message.what;
                if (i2 == 100) {
                    boolean unused = a.l;
                    r(a0);
                    b.a.p0.a.d2.d.J().t();
                } else if (i2 == 103) {
                    boolean unused2 = a.l;
                    a0.d0().i();
                    b.a.p0.a.p1.r.a.g().v();
                    r(a0);
                } else if (i2 != 106) {
                    return false;
                } else {
                    boolean unused3 = a.l;
                    b.a.p0.a.d2.d.J().t();
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final void f(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, message) == null) {
                Bundle bundle = (Bundle) message.obj;
                b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
                b.a.p0.a.f2.f.f0.d b2 = b.a.p0.a.f2.f.f0.d.b();
                if (bundle == null || a0 == null || b2 == null || !TextUtils.equals(bundle.getString("ai_apps_key", ""), a0.N())) {
                    return;
                }
                b2.j();
            }
        }

        public final void g(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, message) == null) {
                boolean unused = a.l;
                if (b.a.p0.a.d2.d.J().D()) {
                    b.a.p0.a.z2.f.j(b.a.p0.a.d2.d.J().x());
                }
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                b.a.p0.a.e0.d.k("SwanAppMessengerClient", "Recovery killProcess hasAppOccupied: " + b.a.p0.a.d2.d.J().D());
                if (b.a.p0.a.d2.d.J().D()) {
                    b.a.p0.a.d2.d.J().o("flag_finish_activity", "flag_remove_task");
                    q0.a0(new RunnableC0486a(this));
                    return;
                }
                b.a.p0.a.e0.d.k("SwanAppMessengerClient", "Recovery kill self");
                Process.killProcess(Process.myPid());
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, message) == null) {
                if (a.l) {
                    String str = "handleMessage => " + message;
                }
                switch (message.what) {
                    case 109:
                        return;
                    case 110:
                        g(message);
                        return;
                    case 111:
                        if (message.obj instanceof Bundle) {
                            b.a.p0.a.d2.d.J().w("event_messenger_call_in", (Bundle) message.obj);
                            return;
                        }
                        return;
                    case 112:
                    case 113:
                    case 123:
                    case 124:
                    case 125:
                    case 127:
                    case 128:
                    case 129:
                    default:
                        if (a(message)) {
                            return;
                        }
                        super.handleMessage(message);
                        return;
                    case 114:
                        m(message);
                        return;
                    case 115:
                        n(message);
                        return;
                    case 116:
                        c(message);
                        return;
                    case 117:
                        l(message);
                        return;
                    case 118:
                        j(message);
                        return;
                    case 119:
                        b.a.d0.c.a((Bundle) message.obj);
                        return;
                    case 120:
                        i(message);
                        return;
                    case 121:
                        k(message);
                        return;
                    case 122:
                        d(message);
                        return;
                    case 126:
                        b.a.p0.a.y1.c.d.a.d(message);
                        return;
                    case IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER /* 130 */:
                        b.a.p0.a.h0.l.g.n.a.i().g((Bundle) message.obj);
                        return;
                    case IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER /* 131 */:
                        f(message);
                        return;
                    case 132:
                        h();
                        return;
                }
            }
        }

        public final void i(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, message) == null) {
                long currentTimeMillis = a.l ? System.currentTimeMillis() : 0L;
                String uuid = UUID.randomUUID().toString();
                b.a.p0.a.h0.o.j.d d2 = b.a.p0.a.h0.o.j.d.d();
                d2.g(uuid);
                d2.b(uuid, new UbcFlowEvent("prefetch_start"));
                d2.j(uuid, 3000L);
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
                PrefetchEvent prefetchEvent = (PrefetchEvent) bundle.getParcelable("swan_app_bundle_prefetch");
                if (prefetchEvent == null || !prefetchEvent.isValid()) {
                    return;
                }
                b.a.p0.a.h0.o.j.d d3 = b.a.p0.a.h0.o.j.d.d();
                a.b a2 = b.a.p0.a.h0.o.j.e.a.a();
                a2.h(RecordType.APP_ID);
                a2.f(prefetchEvent.appId);
                d3.f(uuid, a2.e());
                b.a.p0.a.e0.d.k("SwanAppMessengerClient", "get prefetch event");
                if (a.l) {
                    String str = "PrefetchMessage execCall event: " + prefetchEvent;
                }
                boolean z = false;
                if (q(prefetchEvent, bundle)) {
                    b.a.p0.a.h0.o.j.d.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_app_start"));
                    b.a aVar = new b.a();
                    PMSAppInfo pMSAppInfo = (PMSAppInfo) bundle.getParcelable("swan_app_prefetch_pms_info");
                    if (pMSAppInfo == null) {
                        pMSAppInfo = b.a.p0.q.g.a.i().u(prefetchEvent.appId);
                    }
                    aVar.S0(pMSAppInfo);
                    b.a.p0.a.d2.d.J().m(aVar.D(), "update_tag_by_prefetch");
                    b.a.p0.a.e0.d.k("SwanAppMessengerClient", "shouldUpdateForPrefetch for current Preload");
                    b.a.p0.a.h0.o.j.d.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_app_end"));
                    z = true;
                }
                b.a.p0.a.d2.e r = b.a.p0.a.d2.d.J().r();
                if (r == null) {
                    return;
                }
                SwanPrefetchImageRes.b().d(prefetchEvent.appId);
                if (b.a.p0.a.u1.l.e.e()) {
                    b.a.p0.a.p1.r.c.a.g(true);
                }
                PMSAppInfo f0 = r.V().f0();
                if (f0 != null && !f0.isMaxAgeExpires()) {
                    b.a.p0.a.h0.o.d.g().c(prefetchEvent);
                    if (TextUtils.equals(prefetchEvent.appId, f0.appId)) {
                        o(uuid, r, f0);
                        b.a.p0.a.h0.o.j.d.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_config_start"));
                        b.a.p0.a.h0.o.k.a a3 = b.a.p0.a.h0.o.k.b.a(f0, b.a.p0.a.f1.e.b.o1(prefetchEvent.schema));
                        if (a3 != null && a3.a()) {
                            File file = new File(a3.f6014a, "app.json");
                            if ((r.P() == null || z) && !b.a.p0.a.a1.d.P(r, a3.f6014a)) {
                                b.a.p0.a.e0.d.k("SwanAppMessengerClient", "updateSwanAppConfig failed");
                                boolean unused = a.l;
                                return;
                            } else if (r.P() == null) {
                                b.a.p0.a.e0.d.k("SwanAppMessengerClient", "swanApp.getConfig() == null");
                                return;
                            } else {
                                b.a.p0.a.h0.o.j.d.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_config_start_end"));
                                prefetchEvent.appConfig = b.a.p0.a.a1.d.m(file);
                                prefetchEvent.appPath = d.e.i(prefetchEvent.appId, String.valueOf(f0.versionCode)).getPath() + File.separator;
                                String b2 = b(prefetchEvent, r, a3);
                                prefetchEvent.pageUrl = b2;
                                prefetchEvent.rootPath = b.a.p0.a.h0.u.a.c(r, b2);
                                prefetchEvent.pageType = r.P().h(prefetchEvent.pageUrl);
                                prefetchEvent.sConsole = String.valueOf(b.a.p0.a.e0.c.c());
                                prefetchEvent.version = String.valueOf(f0.versionCode);
                                if (!TextUtils.isEmpty(f0.userActionApis)) {
                                    prefetchEvent.userActionApis = String.valueOf(f0.userActionApis);
                                }
                                b.a.p0.a.h0.o.g.g.a.c(prefetchEvent);
                                if (b.a.p0.a.h0.o.e.a.p() || TextUtils.equals(prefetchEvent.pageType, FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT)) {
                                    if (a.l) {
                                        String str2 = "PrefetchEvent - " + prefetchEvent.toString();
                                    }
                                    g.U().x0(uuid, prefetchEvent, f0);
                                } else {
                                    b.a.p0.a.e0.d.k("SwanAppMessengerClient", "not support sub pkg preload, page type - " + prefetchEvent.pageType);
                                    return;
                                }
                            }
                        } else {
                            b.a.p0.a.e0.d.k("SwanAppMessengerClient", "can not find app.json anywhere");
                            return;
                        }
                    }
                    if (a.l) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        String str3 = "prefetch cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                        return;
                    }
                    return;
                }
                b.a.p0.a.e0.d.k("SwanAppMessengerClient", "appInfo==null or appInfo isMaxAgeExpires");
            }
        }

        public final void j(Message message) {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, message) == null) || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            bundle.setClassLoader(PMSAppInfo.class.getClassLoader());
            b.a.p0.a.d2.d.J().m(bundle, null);
        }

        public final void k(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048587, this, message) == null) && message != null && TextUtils.isEmpty(b.a.p0.a.d2.d.J().getAppId())) {
                boolean unused = a.l;
                Bundle bundle = (Bundle) message.obj;
                if (bundle == null) {
                    return;
                }
                bundle.setClassLoader(e.class.getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j == 0) {
                    return;
                }
                ExtensionCore T = g.U().T();
                if (a.l) {
                    String str = "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + T;
                }
                if (T == null || T.extensionCoreVersionCode >= j) {
                    return;
                }
                if (a.l) {
                    String str2 = "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + T;
                }
                g.Q0();
            }
        }

        public final void l(Message message) {
            Bundle bundle;
            SwanCoreVersion n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, message) == null) || message == null || !TextUtils.isEmpty(b.a.p0.a.d2.d.J().getAppId()) || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            bundle.setClassLoader(e.class.getClassLoader());
            long j = bundle.getLong("ai_apps_data");
            if (j == 0 || (n = b.a.p0.a.c1.b.i().n()) == null) {
                return;
            }
            long j2 = n.swanCoreVersionCode;
            if (j2 == 0 || j2 >= j) {
                return;
            }
            if (a.l) {
                String str = "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + n;
            }
            b.a.p0.a.c1.b.i().release();
        }

        public final void m(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, message) == null) && message != null && TextUtils.isEmpty(b.a.p0.a.d2.d.J().getAppId())) {
                boolean unused = a.l;
                Bundle bundle = (Bundle) message.obj;
                if (bundle == null) {
                    return;
                }
                bundle.setClassLoader(e.class.getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j == 0 || g.U().d0() == null) {
                    return;
                }
                if (a.l) {
                    String str = "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + g.U().d0();
                }
                g.Q0();
            }
        }

        public final void n(Message message) {
            Bundle bundle;
            b.a.d0.f.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048590, this, message) == null) || message == null || (bundle = (Bundle) message.obj) == null || (bVar = b.a.p0.a.t1.d.b().f8398d) == null) {
                return;
            }
            bVar.onPayResult(b.a.p0.a.t1.d.a(bundle.getInt(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_CODE)), bundle.getString(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_STR));
        }

        public final void o(String str, b.a.p0.a.d2.e eVar, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048591, this, str, eVar, pMSAppInfo) == null) {
                b.a.p0.a.h0.o.j.d d2 = b.a.p0.a.h0.o.j.d.d();
                a.b a2 = b.a.p0.a.h0.o.j.e.a.a();
                a2.h(RecordType.APP_ID);
                a2.f(pMSAppInfo.appId);
                d2.f(str, a2.e());
                a.b a3 = b.a.p0.a.h0.o.j.e.a.a();
                a3.h(RecordType.APP_VERSION);
                a3.f(String.valueOf(pMSAppInfo.versionCode));
                d2.f(str, a3.e());
                a.b a4 = b.a.p0.a.h0.o.j.e.a.a();
                a4.h(RecordType.PREFETCH_TYPE);
                a4.g(eVar.H());
                d2.f(str, a4.e());
            }
        }

        public void p(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
                this.f9483a = new WeakReference<>(cVar);
            }
        }

        public final boolean q(PrefetchEvent prefetchEvent, Bundle bundle) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, prefetchEvent, bundle)) == null) {
                b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
                if (a0 == null) {
                    return true;
                }
                if (!a0.H() && TextUtils.isEmpty(a0.V().V())) {
                    if (TextUtils.equals(a0.getAppId(), prefetchEvent.appId)) {
                        PMSAppInfo pMSAppInfo = (PMSAppInfo) bundle.getParcelable("swan_app_prefetch_pms_info");
                        if (pMSAppInfo == null) {
                            return false;
                        }
                        PMSAppInfo f0 = a0.V().f0();
                        return f0 == null || f0.versionCode != pMSAppInfo.versionCode;
                    }
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public final void r(b.a.p0.a.d2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, eVar) == null) {
                b.a.p0.a.p.d.c a2 = eVar.y().a().a();
                if (a2 != null) {
                    a2.a(AppRuntime.getAppContext());
                }
                b.a.p0.a.m.b M = eVar.M();
                M.h(M.c(AppRuntime.getAppContext()));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1527717903, "Lb/a/p0/a/y1/c/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1527717903, "Lb/a/p0/a/y1/c/e/a;");
                return;
            }
        }
        l = k.f6863a;
        m = TimeUnit.MINUTES.toMillis(5L);
        n = new Object();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b.a.p0.a.d2.h hVar) {
        super(hVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.p0.a.d2.h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9478f = new e();
        this.j = new ArrayDeque();
    }

    @Deprecated
    public static a P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? b.a.p0.a.d2.d.J().z() : (a) invokeV.objValue;
    }

    public void L(d dVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, dVar, cVar) == null) {
            this.f9480h = dVar;
            this.f9478f.p(cVar);
            Y(1, O());
            if (this.f9480h == null || !N()) {
                return;
            }
            this.f9480h.a();
        }
    }

    public final boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this.j) {
                S("checkRebindable ===>");
                if (this.j.size() < 3) {
                    S(String.format(Locale.getDefault(), "allowRebind by size(%d) < max(%d)", Integer.valueOf(this.j.size()), 3));
                    return true;
                }
                int size = this.j.size() - 3;
                S("after offer purgeCount=" + size);
                if (size > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        S("purge: " + this.j.poll());
                    }
                }
                S("after purge");
                Long peek = this.j.peek();
                if (peek == null) {
                    S("allowRebind by null oldestRecord is should not happen");
                    return true;
                }
                long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
                boolean z = currentTimeMillis > m;
                S("allowRebind:" + z + " oldestRecordDuration:" + currentTimeMillis);
                return z;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f9479g != null : invokeV.booleanValue;
    }

    public final Bundle O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("process_id", SwanAppProcessInfo.current().index);
            bundle.putString("app_id", getAppId());
            bundle.putParcelable("app_core", n());
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public Handler Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f9478f : (Handler) invokeV.objValue;
    }

    public IProcessBridge R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f9479g : (IProcessBridge) invokeV.objValue;
    }

    public final void S(String str) {
        Iterator<Long> it;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && l) {
            String str2 = "SwanRebind:: status => " + str;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            while (this.j.iterator().hasNext()) {
                String str3 = "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue()));
            }
        }
    }

    public synchronized void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                this.f9481i = null;
                this.f9479g = null;
                if (this.f9480h != null) {
                    this.f9480h.b();
                }
                c0();
                if (this.k != null) {
                    synchronized (n) {
                        for (Runnable runnable : this.k) {
                            if (runnable != null) {
                                runnable.run();
                            }
                        }
                        this.k.clear();
                    }
                }
            }
        }
    }

    public void U(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, runnable) == null) {
            synchronized (n) {
                if (this.k == null) {
                    this.k = new ArrayList();
                }
                this.k.add(runnable);
            }
        }
    }

    @Deprecated
    public void V(@Nullable Bundle bundle, @NonNull Class<? extends b.a.p0.a.y1.a.a.a> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bundle, cls) == null) {
            W(bundle, cls, null);
        }
    }

    @Deprecated
    public void W(@Nullable Bundle bundle, @NonNull Class<? extends b.a.p0.a.y1.a.a.a> cls, @Nullable b.a.p0.a.y1.a.b.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, bundle, cls, cVar) == null) {
            if (l) {
                String str = "sendMessageToClient: delegation: " + cls.getName();
            }
            Message obtain = Message.obtain((Handler) null, 12);
            obtain.arg1 = SwanAppProcessInfo.current().index;
            Bundle bundle2 = new Bundle();
            bundle2.putString("ai_apps_delegation_name", cls.getName());
            if (cVar != null) {
                bundle2.putString("ai_apps_observer_id", cVar.b());
                b.a.p0.a.y1.a.b.b.a.b().e(cVar);
            }
            if (bundle != null) {
                bundle2.putBundle("ai_apps_data", bundle);
            }
            bundle2.putString("ai_apps_id", getAppId());
            obtain.obj = bundle2;
            b.a.p0.a.y1.c.a e2 = b.a.p0.a.y1.c.a.e();
            b.a.p0.a.y1.c.c cVar2 = new b.a.p0.a.y1.c.c(obtain);
            cVar2.p(true);
            e2.h(cVar2);
        }
    }

    @Deprecated
    public void X(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            a0(i2, "");
        }
    }

    public void Y(int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, bundle) == null) {
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            Message obtain = Message.obtain(null, i2, bundle);
            obtain.arg1 = current.index;
            obtain.obj = bundle;
            b.a.p0.a.y1.c.a.e().h(new b.a.p0.a.y1.c.c(obtain));
        }
    }

    @Deprecated
    public void Z(int i2, SwanAppIPCData swanAppIPCData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i2, swanAppIPCData) == null) {
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (l) {
                String str = "sendMessage msgType:" + i2 + " ipcData: " + swanAppIPCData;
            }
            Message obtain = Message.obtain((Handler) null, i2);
            obtain.arg1 = current.index;
            Bundle bundle = new Bundle();
            if (swanAppIPCData != null) {
                bundle.putParcelable("ai_apps_data", swanAppIPCData);
            }
            bundle.putString("ai_apps_id", getAppId());
            obtain.obj = bundle;
            b.a.p0.a.y1.c.a.e().h(new b.a.p0.a.y1.c.c(obtain));
        }
    }

    @Deprecated
    public void a0(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, str) == null) {
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (l) {
                String str2 = "sendMessage msgType:" + i2 + " strData: " + str;
            }
            Message obtain = Message.obtain((Handler) null, i2);
            obtain.arg1 = current.index;
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("ai_apps_data", str);
            }
            bundle.putString("ai_apps_id", getAppId());
            obtain.obj = bundle;
            b.a.p0.a.y1.c.a.e().h(new b.a.p0.a.y1.c.c(obtain));
        }
    }

    public synchronized void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this) {
                boolean z = l;
                if (this.f9481i == null) {
                    this.f9481i = new b(this, null);
                    Application c2 = b.a.p0.a.c1.a.c();
                    try {
                        c2.bindService(new Intent(c2, SwanAppMessengerService.class), this.f9481i, 1);
                    } catch (Exception e2) {
                        if (l) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this.j) {
                if (M()) {
                    this.j.offer(Long.valueOf(System.currentTimeMillis()));
                    b0();
                }
            }
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            X(2);
        }
    }
}
