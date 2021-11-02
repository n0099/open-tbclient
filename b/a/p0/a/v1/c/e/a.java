package b.a.p0.a.v1.c.e;

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
import b.a.p0.a.a1.e;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.g1.f;
import b.a.p0.a.h0.l.g.h;
import b.a.p0.a.h0.p.a;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.k;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.IProcessBridge;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
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
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class a extends b.a.p0.a.v1.c.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public static final long m;
    public static final Object n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final e f8499f;

    /* renamed from: g  reason: collision with root package name */
    public IProcessBridge f8500g;

    /* renamed from: h  reason: collision with root package name */
    public d f8501h;

    /* renamed from: i  reason: collision with root package name */
    public ServiceConnection f8502i;
    public final Deque<Long> j;
    public List<Runnable> k;

    /* renamed from: b.a.p0.a.v1.c.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0426a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f8503e;

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
            this.f8503e = aVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                if (a.l) {
                    String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder);
                }
                if (this.f8503e.k() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                    if (a.l) {
                        String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(this.f8503e.k()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess()));
                        return;
                    }
                    return;
                }
                this.f8503e.f8500g = IProcessBridge.Stub.asInterface(iBinder);
                a aVar = this.f8503e;
                aVar.N(13, aVar.D());
                if (this.f8503e.f8501h != null) {
                    this.f8503e.f8501h.a();
                }
                b.a.p0.a.v1.c.a.e().c();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                boolean unused = a.l;
                this.f8503e.I();
            }
        }

        public /* synthetic */ b(a aVar, C0426a c0426a) {
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
        public WeakReference<c> f8504a;

        /* renamed from: b.a.p0.a.v1.c.e.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0427a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0427a(e eVar) {
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
                    b.a.p0.a.e0.d.h("SwanAppMessengerClient", "Recovery kill self");
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
                WeakReference<c> weakReference = this.f8504a;
                c cVar = weakReference != null ? weakReference.get() : null;
                if ((cVar == null || !cVar.a(message)) && !e(message)) {
                    return b.a.p0.a.c1.a.h0().a(message);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final String b(PrefetchEvent prefetchEvent, @NonNull b.a.p0.a.a2.e eVar, b.a.p0.a.h0.o.j.a aVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, prefetchEvent, eVar, aVar)) == null) {
                SwanAppConfigData E = eVar.E();
                if (E == null) {
                    boolean unused = a.l;
                    return null;
                }
                String k1 = b.a.p0.a.f1.e.b.k1(prefetchEvent.schema, E);
                if (TextUtils.isEmpty(k1)) {
                    if (aVar.f5706b) {
                        return E.f(aVar.f5707c);
                    }
                    return E.e();
                }
                return k1;
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
                b.a.p0.a.c2.f.i0.a.d().b(Intent.parseUri(string, 0));
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
                b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
                if (P != null) {
                    if (!TextUtils.isEmpty(P.K().U())) {
                        b.a.p0.a.h0.u.b.c(18);
                        return;
                    } else if (P.e()) {
                        if (!"update_tag_by_activity_on_create".equals(P.X())) {
                            if ("update_tag_by_activity_on_new_intent".equals(P.X())) {
                                b.a.p0.a.h0.u.b.c(17);
                                return;
                            } else {
                                b.a.p0.a.h0.u.b.c(6);
                                return;
                            }
                        }
                        b.a.p0.a.h0.u.b.c(16);
                        if (!a.C0241a.c()) {
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
                } else if (g.M().b0()) {
                    boolean unused2 = a.l;
                    b.a.p0.a.r1.k.i.a.k().n();
                    b.a.p0.a.a2.d.g().m(bundle2, "update_tag_by_app_launch");
                    b.a.p0.a.a2.e P2 = b.a.p0.a.a2.e.P();
                    if (P2 != null && b.a.p0.a.a1.e.M(P2)) {
                        b.a.p0.a.h0.q.b.g().p(bundle2.getString("mAppId", null), false);
                        boolean unused3 = a.l;
                        f.T().P(P2.l());
                        g.M().I0(P2);
                        if (b.a.p0.a.h0.n.a.a.c()) {
                            b.a.p0.a.e0.d.g("SwanAppMessengerClient", "handleAppOnLaunch: init cache video ");
                            b.a.p0.a.y0.k.d.a();
                        }
                        boolean unused4 = a.l;
                        return;
                    }
                    b.a.p0.a.h0.u.b.c(10);
                } else {
                    b.a.p0.a.h0.u.b.c(9);
                }
            }
        }

        public final boolean e(Message message) {
            InterceptResult invokeL;
            b.a.p0.a.a2.e P;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, message)) == null) {
                if (h.b().a() == null || (P = b.a.p0.a.a2.e.P()) == null || P.e()) {
                    return false;
                }
                int i2 = message.what;
                if (i2 == 100) {
                    boolean unused = a.l;
                    q(P);
                    b.a.p0.a.a2.d.g().t();
                } else if (i2 == 103) {
                    boolean unused2 = a.l;
                    P.S().i();
                    b.a.p0.a.n1.q.a.g().v();
                    q(P);
                } else if (i2 != 106) {
                    return false;
                } else {
                    boolean unused3 = a.l;
                    b.a.p0.a.a2.d.g().t();
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final void f(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, message) == null) {
                Bundle bundle = (Bundle) message.obj;
                b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
                b.a.p0.a.c2.f.g0.d b2 = b.a.p0.a.c2.f.g0.d.b();
                if (bundle == null || P == null || b2 == null || !TextUtils.equals(bundle.getString("ai_apps_key", ""), P.k())) {
                    return;
                }
                b2.j();
            }
        }

        public final void g(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, message) == null) {
                boolean unused = a.l;
                if (b.a.p0.a.a2.d.g().C()) {
                    b.a.p0.a.v2.f.j(b.a.p0.a.a2.d.g().x());
                }
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                b.a.p0.a.e0.d.h("SwanAppMessengerClient", "Recovery killProcess hasAppOccupied: " + b.a.p0.a.a2.d.g().C());
                if (b.a.p0.a.a2.d.g().C()) {
                    b.a.p0.a.a2.d.g().o("flag_finish_activity", "flag_remove_task");
                    q0.X(new RunnableC0427a(this));
                    return;
                }
                b.a.p0.a.e0.d.h("SwanAppMessengerClient", "Recovery kill self");
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
                            b.a.p0.a.a2.d.g().w("event_messenger_call_in", (Bundle) message.obj);
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
                        b.a.d0.d.a((Bundle) message.obj);
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
                        b.a.p0.a.v1.c.d.a.d(message);
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
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
                PrefetchEvent prefetchEvent = (PrefetchEvent) bundle.getParcelable("swan_app_bundle_prefetch");
                if (prefetchEvent == null || !prefetchEvent.isValid()) {
                    return;
                }
                if (a.l) {
                    String str = "PrefetchMessage execCall event: " + prefetchEvent;
                }
                boolean z = false;
                if (p(prefetchEvent, bundle)) {
                    b.a aVar = new b.a();
                    PMSAppInfo pMSAppInfo = (PMSAppInfo) bundle.getParcelable("swan_app_prefetch_pms_info");
                    if (pMSAppInfo == null) {
                        pMSAppInfo = b.a.p0.n.g.a.h().s(prefetchEvent.appId);
                    }
                    aVar.Q0(pMSAppInfo);
                    b.a.p0.a.a2.d.g().m(aVar.C(), "update_tag_by_prefetch");
                    z = true;
                }
                b.a.p0.a.a2.e r = b.a.p0.a.a2.d.g().r();
                if (r == null) {
                    return;
                }
                SwanPrefetchImageRes.b().d(prefetchEvent.appId);
                PMSAppInfo e0 = r.K().e0();
                if (e0 == null || e0.isMaxAgeExpires()) {
                    return;
                }
                if (TextUtils.equals(prefetchEvent.appId, e0.appId)) {
                    b.a.p0.a.h0.o.j.a a2 = b.a.p0.a.h0.o.j.b.a(e0, b.a.p0.a.f1.e.b.l1(prefetchEvent.schema));
                    if (a2 == null || !a2.a()) {
                        return;
                    }
                    File file = new File(a2.f5705a, "app.json");
                    if ((r.E() == null || z) && !b.a.p0.a.a1.e.N(r, a2.f5705a)) {
                        boolean unused = a.l;
                        return;
                    } else if (r.E() == null) {
                        return;
                    } else {
                        prefetchEvent.appConfig = b.a.p0.a.a1.e.m(file);
                        prefetchEvent.appPath = e.C0109e.i(prefetchEvent.appId, String.valueOf(e0.versionCode)).getPath() + File.separator;
                        String b2 = b(prefetchEvent, r, a2);
                        prefetchEvent.pageUrl = b2;
                        prefetchEvent.rootPath = b.a.p0.a.h0.u.a.c(r, b2);
                        prefetchEvent.pageType = r.E().g(prefetchEvent.pageUrl);
                        prefetchEvent.sConsole = String.valueOf(b.a.p0.a.e0.c.c());
                        prefetchEvent.version = String.valueOf(e0.versionCode);
                        if (b.a.p0.a.h0.o.e.a.m() || TextUtils.equals(prefetchEvent.pageType, FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT)) {
                            if (a.l) {
                                String str2 = "PrefetchEvent - " + prefetchEvent.toString();
                            }
                            g.M().m0(prefetchEvent, e0);
                        } else if (a.l) {
                            String str3 = "not support sub pkg preload, page type - " + prefetchEvent.pageType;
                            return;
                        } else {
                            return;
                        }
                    }
                }
                if (a.l) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str4 = "prefetch cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                }
            }
        }

        public final void j(Message message) {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, message) == null) || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            bundle.setClassLoader(PMSAppInfo.class.getClassLoader());
            b.a.p0.a.a2.d.g().m(bundle, null);
        }

        public final void k(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048587, this, message) == null) && message != null && TextUtils.isEmpty(b.a.p0.a.a2.d.g().getAppId())) {
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
                ExtensionCore L = g.M().L();
                if (a.l) {
                    String str = "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + L;
                }
                if (L == null || L.extensionCoreVersionCode >= j) {
                    return;
                }
                if (a.l) {
                    String str2 = "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + L;
                }
                g.C0();
            }
        }

        public final void l(Message message) {
            Bundle bundle;
            SwanCoreVersion n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, message) == null) || message == null || !TextUtils.isEmpty(b.a.p0.a.a2.d.g().getAppId()) || (bundle = (Bundle) message.obj) == null) {
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
            if ((interceptable == null || interceptable.invokeL(1048589, this, message) == null) && message != null && TextUtils.isEmpty(b.a.p0.a.a2.d.g().getAppId())) {
                boolean unused = a.l;
                Bundle bundle = (Bundle) message.obj;
                if (bundle == null) {
                    return;
                }
                bundle.setClassLoader(e.class.getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j == 0 || g.M().U() == null) {
                    return;
                }
                if (a.l) {
                    String str = "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + g.M().U();
                }
                g.C0();
            }
        }

        public final void n(Message message) {
            Bundle bundle;
            b.a.d0.e.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048590, this, message) == null) || message == null || (bundle = (Bundle) message.obj) == null || (aVar = b.a.p0.a.q1.a.b().f7363d) == null) {
                return;
            }
            aVar.onPayResult(b.a.p0.a.q1.a.a(bundle.getInt(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_CODE)), bundle.getString(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_STR));
        }

        public void o(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
                this.f8504a = new WeakReference<>(cVar);
            }
        }

        public final boolean p(PrefetchEvent prefetchEvent, Bundle bundle) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, prefetchEvent, bundle)) == null) {
                b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
                if (P == null) {
                    return true;
                }
                if (!P.e() && TextUtils.isEmpty(P.K().U())) {
                    if (TextUtils.equals(P.getAppId(), prefetchEvent.appId)) {
                        PMSAppInfo pMSAppInfo = (PMSAppInfo) bundle.getParcelable("swan_app_prefetch_pms_info");
                        if (pMSAppInfo == null) {
                            return false;
                        }
                        PMSAppInfo e0 = P.K().e0();
                        return e0 == null || e0.versionCode != pMSAppInfo.versionCode;
                    }
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public final void q(b.a.p0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) {
                b.a.p0.a.p.d.b a2 = eVar.y().a().a();
                if (a2 != null) {
                    a2.a(AppRuntime.getAppContext());
                }
                b.a.p0.a.m.b j = eVar.j();
                j.h(j.c(AppRuntime.getAppContext()));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-400321810, "Lb/a/p0/a/v1/c/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-400321810, "Lb/a/p0/a/v1/c/e/a;");
                return;
            }
        }
        l = k.f6397a;
        m = TimeUnit.MINUTES.toMillis(5L);
        n = new Object();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b.a.p0.a.a2.h hVar) {
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
                super((b.a.p0.a.a2.h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8499f = new e();
        this.j = new ArrayDeque();
    }

    @Deprecated
    public static a E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a.p0.a.a2.d.g().z() : (a) invokeV.objValue;
    }

    public final Bundle D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("process_id", SwanAppProcessInfo.current().index);
            bundle.putString("app_id", getAppId());
            bundle.putParcelable("app_core", n());
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public Handler F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f8499f : (Handler) invokeV.objValue;
    }

    public IProcessBridge G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f8500g : (IProcessBridge) invokeV.objValue;
    }

    public final void H(String str) {
        Iterator<Long> it;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && l) {
            String str2 = "SwanRebind:: status => " + str;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            while (this.j.iterator().hasNext()) {
                String str3 = "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue()));
            }
        }
    }

    public synchronized void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                this.f8502i = null;
                this.f8500g = null;
                if (this.f8501h != null) {
                    this.f8501h.b();
                }
                R();
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

    public void J(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, runnable) == null) {
            synchronized (n) {
                if (this.k == null) {
                    this.k = new ArrayList();
                }
                this.k.add(runnable);
            }
        }
    }

    @Deprecated
    public void K(@Nullable Bundle bundle, @NonNull Class<? extends b.a.p0.a.v1.a.a.a> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, cls) == null) {
            L(bundle, cls, null);
        }
    }

    @Deprecated
    public void L(@Nullable Bundle bundle, @NonNull Class<? extends b.a.p0.a.v1.a.a.a> cls, @Nullable b.a.p0.a.v1.a.b.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, bundle, cls, cVar) == null) {
            if (l) {
                String str = "sendMessageToClient: delegation: " + cls.getName();
            }
            Message obtain = Message.obtain((Handler) null, 12);
            obtain.arg1 = SwanAppProcessInfo.current().index;
            Bundle bundle2 = new Bundle();
            bundle2.putString("ai_apps_delegation_name", cls.getName());
            if (cVar != null) {
                bundle2.putString("ai_apps_observer_id", cVar.b());
                b.a.p0.a.v1.a.b.b.a.b().e(cVar);
            }
            if (bundle != null) {
                bundle2.putBundle("ai_apps_data", bundle);
            }
            bundle2.putString("ai_apps_id", getAppId());
            obtain.obj = bundle2;
            b.a.p0.a.v1.c.a e2 = b.a.p0.a.v1.c.a.e();
            b.a.p0.a.v1.c.c cVar2 = new b.a.p0.a.v1.c.c(obtain);
            cVar2.p(true);
            e2.h(cVar2);
        }
    }

    @Deprecated
    public void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            P(i2, "");
        }
    }

    public void N(int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, bundle) == null) {
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            Message obtain = Message.obtain(null, i2, bundle);
            obtain.arg1 = current.index;
            obtain.obj = bundle;
            b.a.p0.a.v1.c.a.e().h(new b.a.p0.a.v1.c.c(obtain));
        }
    }

    @Deprecated
    public void O(int i2, SwanAppIPCData swanAppIPCData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, swanAppIPCData) == null) {
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
            b.a.p0.a.v1.c.a.e().h(new b.a.p0.a.v1.c.c(obtain));
        }
    }

    @Deprecated
    public void P(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, str) == null) {
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
            b.a.p0.a.v1.c.a.e().h(new b.a.p0.a.v1.c.c(obtain));
        }
    }

    public synchronized void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                boolean z = l;
                if (this.f8502i == null) {
                    this.f8502i = new b(this, null);
                    Application b2 = b.a.p0.a.c1.a.b();
                    try {
                        b2.bindService(new Intent(b2, SwanAppMessengerService.class), this.f8502i, 1);
                    } catch (Exception e2) {
                        if (l) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this.j) {
                if (j()) {
                    this.j.offer(Long.valueOf(System.currentTimeMillis()));
                    Q();
                }
            }
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            M(2);
        }
    }

    public void i(d dVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, dVar, cVar) == null) {
            this.f8501h = dVar;
            this.f8499f.o(cVar);
            N(1, D());
            if (this.f8501h == null || !k()) {
                return;
            }
            this.f8501h.a();
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            synchronized (this.j) {
                H("checkRebindable ===>");
                if (this.j.size() < 3) {
                    H(String.format(Locale.getDefault(), "allowRebind by size(%d) < max(%d)", Integer.valueOf(this.j.size()), 3));
                    return true;
                }
                int size = this.j.size() - 3;
                H("after offer purgeCount=" + size);
                if (size > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        H("purge: " + this.j.poll());
                    }
                }
                H("after purge");
                Long peek = this.j.peek();
                if (peek == null) {
                    H("allowRebind by null oldestRecord is should not happen");
                    return true;
                }
                long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
                boolean z = currentTimeMillis > m;
                H("allowRebind:" + z + " oldestRecordDuration:" + currentTimeMillis);
                return z;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f8500g != null : invokeV.booleanValue;
    }
}
