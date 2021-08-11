package c.a.n0.a.v1.c.e;

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
import c.a.n0.a.a1.e;
import c.a.n0.a.f1.e.b;
import c.a.n0.a.g1.f;
import c.a.n0.a.h0.l.g.h;
import c.a.n0.a.h0.p.a;
import c.a.n0.a.h0.u.g;
import c.a.n0.a.k;
import c.a.n0.a.v2.q0;
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
public final class a extends c.a.n0.a.v1.c.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public static final long m;
    public static final Object n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final e f8969f;

    /* renamed from: g  reason: collision with root package name */
    public IProcessBridge f8970g;

    /* renamed from: h  reason: collision with root package name */
    public d f8971h;

    /* renamed from: i  reason: collision with root package name */
    public ServiceConnection f8972i;

    /* renamed from: j  reason: collision with root package name */
    public final Deque<Long> f8973j;
    public List<Runnable> k;

    /* renamed from: c.a.n0.a.v1.c.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0421a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f8974e;

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
            this.f8974e = aVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                if (a.l) {
                    String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder);
                }
                if (this.f8974e.k() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                    if (a.l) {
                        String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(this.f8974e.k()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess()));
                        return;
                    }
                    return;
                }
                this.f8974e.f8970g = IProcessBridge.Stub.asInterface(iBinder);
                a aVar = this.f8974e;
                aVar.N(13, aVar.D());
                if (this.f8974e.f8971h != null) {
                    this.f8974e.f8971h.a();
                }
                c.a.n0.a.v1.c.a.e().c();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                boolean unused = a.l;
                this.f8974e.I();
            }
        }

        public /* synthetic */ b(a aVar, C0421a c0421a) {
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
        public WeakReference<c> f8975a;

        /* renamed from: c.a.n0.a.v1.c.e.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0422a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0422a(e eVar) {
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
                    c.a.n0.a.e0.d.h("SwanAppMessengerClient", "Recovery kill self");
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
                WeakReference<c> weakReference = this.f8975a;
                c cVar = weakReference != null ? weakReference.get() : null;
                if ((cVar == null || !cVar.a(message)) && !e(message)) {
                    return c.a.n0.a.c1.a.h0().a(message);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final String b(PrefetchEvent prefetchEvent, @NonNull c.a.n0.a.a2.e eVar, c.a.n0.a.h0.o.j.a aVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, prefetchEvent, eVar, aVar)) == null) {
                SwanAppConfigData F = eVar.F();
                if (F == null) {
                    boolean unused = a.l;
                    return null;
                }
                String l1 = c.a.n0.a.f1.e.b.l1(prefetchEvent.schema, F);
                if (TextUtils.isEmpty(l1)) {
                    if (aVar.f6091b) {
                        return F.f(aVar.f6092c);
                    }
                    return F.e();
                }
                return l1;
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
                c.a.n0.a.c2.f.i0.a.d().b(Intent.parseUri(string, 0));
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
                c.a.n0.a.a2.e Q = c.a.n0.a.a2.e.Q();
                if (Q != null) {
                    if (!TextUtils.isEmpty(Q.L().V())) {
                        c.a.n0.a.h0.u.b.c(18);
                        return;
                    } else if (Q.e()) {
                        if (!"update_tag_by_activity_on_create".equals(Q.Y())) {
                            if ("update_tag_by_activity_on_new_intent".equals(Q.Y())) {
                                c.a.n0.a.h0.u.b.c(17);
                                return;
                            } else {
                                c.a.n0.a.h0.u.b.c(6);
                                return;
                            }
                        }
                        c.a.n0.a.h0.u.b.c(16);
                        if (!a.C0236a.c()) {
                            return;
                        }
                    }
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle == null) {
                    c.a.n0.a.h0.u.b.c(7);
                    return;
                }
                bundle.setClassLoader(e.class.getClassLoader());
                Bundle bundle2 = bundle.getBundle("swan_app_on_launch_event");
                if (bundle2 == null) {
                    c.a.n0.a.h0.u.b.c(8);
                } else if (g.N().c0()) {
                    boolean unused2 = a.l;
                    c.a.n0.a.r1.k.i.a.k().n();
                    c.a.n0.a.a2.d.g().m(bundle2, "update_tag_by_app_launch");
                    c.a.n0.a.a2.e Q2 = c.a.n0.a.a2.e.Q();
                    if (Q2 != null && c.a.n0.a.a1.e.M(Q2)) {
                        c.a.n0.a.h0.q.b.g().p(bundle2.getString("mAppId", null), false);
                        boolean unused3 = a.l;
                        f.V().R(Q2.l());
                        g.N().J0(Q2);
                        if (c.a.n0.a.h0.n.a.a.c()) {
                            c.a.n0.a.e0.d.g("SwanAppMessengerClient", "handleAppOnLaunch: init cache video ");
                            c.a.n0.a.y0.k.d.a();
                        }
                        boolean unused4 = a.l;
                        return;
                    }
                    c.a.n0.a.h0.u.b.c(10);
                } else {
                    c.a.n0.a.h0.u.b.c(9);
                }
            }
        }

        public final boolean e(Message message) {
            InterceptResult invokeL;
            c.a.n0.a.a2.e Q;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, message)) == null) {
                if (h.b().a() == null || (Q = c.a.n0.a.a2.e.Q()) == null || Q.e()) {
                    return false;
                }
                int i2 = message.what;
                if (i2 == 100) {
                    boolean unused = a.l;
                    q(Q);
                    c.a.n0.a.a2.d.g().t();
                } else if (i2 == 103) {
                    boolean unused2 = a.l;
                    Q.T().i();
                    c.a.n0.a.n1.q.a.g().v();
                    q(Q);
                } else if (i2 != 106) {
                    return false;
                } else {
                    boolean unused3 = a.l;
                    c.a.n0.a.a2.d.g().t();
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final void f(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, message) == null) {
                Bundle bundle = (Bundle) message.obj;
                c.a.n0.a.a2.e Q = c.a.n0.a.a2.e.Q();
                c.a.n0.a.c2.f.g0.d b2 = c.a.n0.a.c2.f.g0.d.b();
                if (bundle == null || Q == null || b2 == null || !TextUtils.equals(bundle.getString("ai_apps_key", ""), Q.D())) {
                    return;
                }
                b2.j();
            }
        }

        public final void g(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, message) == null) {
                boolean unused = a.l;
                if (c.a.n0.a.a2.d.g().C()) {
                    c.a.n0.a.v2.f.j(c.a.n0.a.a2.d.g().x());
                }
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                c.a.n0.a.e0.d.h("SwanAppMessengerClient", "Recovery killProcess hasAppOccupied: " + c.a.n0.a.a2.d.g().C());
                if (c.a.n0.a.a2.d.g().C()) {
                    c.a.n0.a.a2.d.g().o("flag_finish_activity", "flag_remove_task");
                    q0.X(new RunnableC0422a(this));
                    return;
                }
                c.a.n0.a.e0.d.h("SwanAppMessengerClient", "Recovery kill self");
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
                            c.a.n0.a.a2.d.g().w("event_messenger_call_in", (Bundle) message.obj);
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
                        c.a.c0.d.a((Bundle) message.obj);
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
                        c.a.n0.a.v1.c.d.a.d(message);
                        return;
                    case IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER /* 130 */:
                        c.a.n0.a.h0.l.g.n.a.i().g((Bundle) message.obj);
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
                        pMSAppInfo = c.a.n0.n.g.a.h().s(prefetchEvent.appId);
                    }
                    aVar.R0(pMSAppInfo);
                    c.a.n0.a.a2.d.g().m(aVar.C(), "update_tag_by_prefetch");
                    z = true;
                }
                c.a.n0.a.a2.e r = c.a.n0.a.a2.d.g().r();
                if (r == null) {
                    return;
                }
                SwanPrefetchImageRes.b().d(prefetchEvent.appId);
                PMSAppInfo f0 = r.L().f0();
                if (f0 == null || f0.isMaxAgeExpires()) {
                    return;
                }
                if (TextUtils.equals(prefetchEvent.appId, f0.appId)) {
                    c.a.n0.a.h0.o.j.a a2 = c.a.n0.a.h0.o.j.b.a(f0, c.a.n0.a.f1.e.b.m1(prefetchEvent.schema));
                    if (a2 == null || !a2.a()) {
                        return;
                    }
                    File file = new File(a2.f6090a, "app.json");
                    if ((r.F() == null || z) && !c.a.n0.a.a1.e.N(r, a2.f6090a)) {
                        boolean unused = a.l;
                        return;
                    } else if (r.F() == null) {
                        return;
                    } else {
                        prefetchEvent.appConfig = c.a.n0.a.a1.e.m(file);
                        prefetchEvent.appPath = e.C0104e.i(prefetchEvent.appId, String.valueOf(f0.versionCode)).getPath() + File.separator;
                        String b2 = b(prefetchEvent, r, a2);
                        prefetchEvent.pageUrl = b2;
                        prefetchEvent.rootPath = c.a.n0.a.h0.u.a.c(r, b2);
                        prefetchEvent.pageType = r.F().g(prefetchEvent.pageUrl);
                        prefetchEvent.sConsole = String.valueOf(c.a.n0.a.e0.c.c());
                        prefetchEvent.version = String.valueOf(f0.versionCode);
                        if (c.a.n0.a.h0.o.e.a.m() || TextUtils.equals(prefetchEvent.pageType, FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT)) {
                            if (a.l) {
                                String str2 = "PrefetchEvent - " + prefetchEvent.toString();
                            }
                            g.N().n0(prefetchEvent, f0);
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
            c.a.n0.a.a2.d.g().m(bundle, null);
        }

        public final void k(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048587, this, message) == null) && message != null && TextUtils.isEmpty(c.a.n0.a.a2.d.g().getAppId())) {
                boolean unused = a.l;
                Bundle bundle = (Bundle) message.obj;
                if (bundle == null) {
                    return;
                }
                bundle.setClassLoader(e.class.getClassLoader());
                long j2 = bundle.getLong("ai_apps_data");
                if (j2 == 0) {
                    return;
                }
                ExtensionCore M = g.N().M();
                if (a.l) {
                    String str = "handleUpdateExtensionCoreVersion: remoteVersion : " + j2 + " curVersion : " + M;
                }
                if (M == null || M.extensionCoreVersionCode >= j2) {
                    return;
                }
                if (a.l) {
                    String str2 = "start reCreate cause lower extension version, remoteVersion : " + j2 + " curVersion : " + M;
                }
                g.D0();
            }
        }

        public final void l(Message message) {
            Bundle bundle;
            SwanCoreVersion n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, message) == null) || message == null || !TextUtils.isEmpty(c.a.n0.a.a2.d.g().getAppId()) || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            bundle.setClassLoader(e.class.getClassLoader());
            long j2 = bundle.getLong("ai_apps_data");
            if (j2 == 0 || (n = c.a.n0.a.c1.b.i().n()) == null) {
                return;
            }
            long j3 = n.swanCoreVersionCode;
            if (j3 == 0 || j3 >= j2) {
                return;
            }
            if (a.l) {
                String str = "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j2 + " coreRuntimeVersion : " + n;
            }
            c.a.n0.a.c1.b.i().release();
        }

        public final void m(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, message) == null) && message != null && TextUtils.isEmpty(c.a.n0.a.a2.d.g().getAppId())) {
                boolean unused = a.l;
                Bundle bundle = (Bundle) message.obj;
                if (bundle == null) {
                    return;
                }
                bundle.setClassLoader(e.class.getClassLoader());
                long j2 = bundle.getLong("ai_apps_data");
                if (j2 == 0 || g.N().V() == null) {
                    return;
                }
                if (a.l) {
                    String str = "start reCreate cause lower version, remoteVersion : " + j2 + " curVersion : " + g.N().V();
                }
                g.D0();
            }
        }

        public final void n(Message message) {
            Bundle bundle;
            c.a.c0.e.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048590, this, message) == null) || message == null || (bundle = (Bundle) message.obj) == null || (aVar = c.a.n0.a.q1.a.b().f7791d) == null) {
                return;
            }
            aVar.onPayResult(c.a.n0.a.q1.a.a(bundle.getInt(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_CODE)), bundle.getString(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_STR));
        }

        public void o(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
                this.f8975a = new WeakReference<>(cVar);
            }
        }

        public final boolean p(PrefetchEvent prefetchEvent, Bundle bundle) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, prefetchEvent, bundle)) == null) {
                c.a.n0.a.a2.e Q = c.a.n0.a.a2.e.Q();
                if (Q == null) {
                    return true;
                }
                if (!Q.e() && TextUtils.isEmpty(Q.L().V())) {
                    if (TextUtils.equals(Q.getAppId(), prefetchEvent.appId)) {
                        PMSAppInfo pMSAppInfo = (PMSAppInfo) bundle.getParcelable("swan_app_prefetch_pms_info");
                        if (pMSAppInfo == null) {
                            return false;
                        }
                        PMSAppInfo f0 = Q.L().f0();
                        return f0 == null || f0.versionCode != pMSAppInfo.versionCode;
                    }
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public final void q(c.a.n0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) {
                c.a.n0.a.p.d.b a2 = eVar.y().a().a();
                if (a2 != null) {
                    a2.a(AppRuntime.getAppContext());
                }
                c.a.n0.a.m.b j2 = eVar.j();
                j2.h(j2.c(AppRuntime.getAppContext()));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-386276913, "Lc/a/n0/a/v1/c/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-386276913, "Lc/a/n0/a/v1/c/e/a;");
                return;
            }
        }
        l = k.f6803a;
        m = TimeUnit.MINUTES.toMillis(5L);
        n = new Object();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.n0.a.a2.h hVar) {
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
                super((c.a.n0.a.a2.h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8969f = new e();
        this.f8973j = new ArrayDeque();
    }

    @Deprecated
    public static a E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a.n0.a.a2.d.g().z() : (a) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f8969f : (Handler) invokeV.objValue;
    }

    public IProcessBridge G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f8970g : (IProcessBridge) invokeV.objValue;
    }

    public final void H(String str) {
        Iterator<Long> it;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && l) {
            String str2 = "SwanRebind:: status => " + str;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            while (this.f8973j.iterator().hasNext()) {
                String str3 = "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue()));
            }
        }
    }

    public synchronized void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                this.f8972i = null;
                this.f8970g = null;
                if (this.f8971h != null) {
                    this.f8971h.b();
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
    public void K(@Nullable Bundle bundle, @NonNull Class<? extends c.a.n0.a.v1.a.a.a> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, cls) == null) {
            L(bundle, cls, null);
        }
    }

    @Deprecated
    public void L(@Nullable Bundle bundle, @NonNull Class<? extends c.a.n0.a.v1.a.a.a> cls, @Nullable c.a.n0.a.v1.a.b.c.c cVar) {
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
                c.a.n0.a.v1.a.b.b.a.b().e(cVar);
            }
            if (bundle != null) {
                bundle2.putBundle("ai_apps_data", bundle);
            }
            bundle2.putString("ai_apps_id", getAppId());
            obtain.obj = bundle2;
            c.a.n0.a.v1.c.a e2 = c.a.n0.a.v1.c.a.e();
            c.a.n0.a.v1.c.c cVar2 = new c.a.n0.a.v1.c.c(obtain);
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
            c.a.n0.a.v1.c.a.e().h(new c.a.n0.a.v1.c.c(obtain));
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
            c.a.n0.a.v1.c.a.e().h(new c.a.n0.a.v1.c.c(obtain));
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
            c.a.n0.a.v1.c.a.e().h(new c.a.n0.a.v1.c.c(obtain));
        }
    }

    public synchronized void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                boolean z = l;
                if (this.f8972i == null) {
                    this.f8972i = new b(this, null);
                    Application b2 = c.a.n0.a.c1.a.b();
                    try {
                        b2.bindService(new Intent(b2, SwanAppMessengerService.class), this.f8972i, 1);
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
            synchronized (this.f8973j) {
                if (j()) {
                    this.f8973j.offer(Long.valueOf(System.currentTimeMillis()));
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
            this.f8971h = dVar;
            this.f8969f.o(cVar);
            N(1, D());
            if (this.f8971h == null || !k()) {
                return;
            }
            this.f8971h.a();
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            synchronized (this.f8973j) {
                H("checkRebindable ===>");
                if (this.f8973j.size() < 3) {
                    H(String.format(Locale.getDefault(), "allowRebind by size(%d) < max(%d)", Integer.valueOf(this.f8973j.size()), 3));
                    return true;
                }
                int size = this.f8973j.size() - 3;
                H("after offer purgeCount=" + size);
                if (size > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        H("purge: " + this.f8973j.poll());
                    }
                }
                H("after purge");
                Long peek = this.f8973j.peek();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f8970g != null : invokeV.booleanValue;
    }
}
