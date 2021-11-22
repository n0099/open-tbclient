package com.baidu.swan.apps.process.messaging.client;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a3.e;
import b.a.p0.a.d2.d;
import b.a.p0.a.d2.j;
import b.a.p0.a.g;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.h0.o.g.c.a;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.k;
import b.a.p0.a.n2.c;
import b.a.p0.a.u.e.p.l;
import b.a.p0.a.u1.h;
import b.a.p0.a.z2.g0;
import b.a.p0.a.z2.q;
import b.a.p0.a.z2.q0;
import b.a.p0.r.a.d.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.prefetch.image.config.image.CustomStrategyImpl;
import com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class SwanAppLocalService extends Service implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_PERLOAD = "com.baidu.swan.action.SWAN_APP_LOCAL_SERVICE_PERLOAD";
    public static final String ACTION_PREFIX = "com.baidu.swan.action.SWAN_APP_LOCAL_SERVICE_";
    public static final String ACTION_RECEIVER_MSG = "com.baidu.swan.action.SWAN_APP_LOCAL_SERVICE_RECEIVER_MSG";
    public static final boolean DEBUG;
    public static final String KEY_DATA = "data";
    public static final String TAG = "SwanAppLocalService";
    public static boolean sFlagPreloaded;
    public transient /* synthetic */ FieldHolder $fh;
    public Messenger mMessenger;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppLocalService f44685e;

        public a(SwanAppLocalService swanAppLocalService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppLocalService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44685e = swanAppLocalService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q.g();
                q.f();
                q.h();
                l.e(AppRuntime.getAppContext());
                b.a.p0.a.c1.a.I().d();
                e.y(b.a.p0.a.c1.a.c());
                b.a.p0.a.u1.n.a.a().c(g.aiapps_fragment, g.aiapps_pull_to_load_footer, g.aiapps_loading_layout);
                b.a.p0.a.c1.a.V().a(b.a.p0.a.c1.a.u0().a());
                boolean z = b.a.p0.a.a3.d.b.f4066i;
                b.a.p0.a.f1.c.b.c().d("screenSize", g0.b());
                this.f44685e.preloadActivityClass();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppLocalService f44686e;

        public b(SwanAppLocalService swanAppLocalService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppLocalService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44686e = swanAppLocalService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    ClassLoader classLoader = this.f44686e.getClassLoader();
                    Class.forName(SwanAppProcessInfo.current().activity.getName(), true, classLoader);
                    Class.forName(f.class.getName(), true, classLoader);
                    Class.forName(g.b.class.getName(), true, classLoader);
                    Class.forName(b.a.p0.a.h0.g.f.class.getName(), true, classLoader);
                    Class.forName(SwanAppSlaveManager.class.getName(), true, classLoader);
                    Class.forName(JsFunction.class.getName(), true, classLoader);
                    Class.forName(j.class.getName(), true, classLoader);
                    Class.forName(SlideHelper.class.getName(), true, classLoader);
                    Class.forName(b.a.p0.a.t0.f.a.class.getName(), true, classLoader);
                    Class.forName(PullToRefreshBaseWebView.class.getName(), true, classLoader);
                    Class.forName(SlidingPaneLayout.class.getName(), true, classLoader);
                    Class.forName(b.a.p0.a.h0.p.b.class.getName(), true, classLoader);
                    Class.forName(SwanAppConfigData.class.getName(), true, classLoader);
                    Class.forName(b.a.p0.a.y1.b.f.class.getName(), true, classLoader);
                } catch (Throwable th) {
                    if (SwanAppLocalService.DEBUG) {
                        Log.getStackTraceString(th);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-992226035, "Lcom/baidu/swan/apps/process/messaging/client/SwanAppLocalService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-992226035, "Lcom/baidu/swan/apps/process/messaging/client/SwanAppLocalService;");
                return;
            }
        }
        DEBUG = k.f6863a;
        sFlagPreloaded = false;
    }

    public SwanAppLocalService() {
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

    private void onAction(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, intent) == null) {
            if (DEBUG) {
                String str = "onAction: intent=" + intent;
            }
            String action = intent == null ? "" : intent.getAction();
            if (ACTION_PERLOAD.equals(action)) {
                try {
                    onActionPreload(intent);
                } catch (Throwable th) {
                    c.b bVar = new c.b(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM);
                    bVar.i(th.getMessage());
                    bVar.m();
                    if (DEBUG) {
                        th.printStackTrace();
                    }
                }
            } else if (ACTION_RECEIVER_MSG.equals(action)) {
                try {
                    Message message = (Message) intent.getParcelableExtra("data");
                    if (message != null) {
                        d.J().z().Q().handleMessage(message);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private void onActionPreload(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, intent) == null) || intent == null) {
            return;
        }
        b.a.p0.a.u1.l.g.a.e().i();
        long currentTimeMillis = System.currentTimeMillis();
        long longExtra = intent.getLongExtra("bundle_key_preload_launch_time", currentTimeMillis);
        long longExtra2 = intent.getLongExtra("bundle_key_preload_swan_updated_time", currentTimeMillis);
        String stringExtra = intent.getStringExtra("bundle_key_preload_preload_scene");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "0";
        }
        HybridUbcFlow p = h.p("preload");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_pre_load_launch");
        ubcFlowEvent.h(longExtra);
        p.F(ubcFlowEvent);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_pre_load_swan_updated");
        ubcFlowEvent2.h(longExtra2);
        p.F(ubcFlowEvent2);
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("na_pre_load_receive");
        ubcFlowEvent3.h(currentTimeMillis);
        p.F(ubcFlowEvent3);
        p.D("with_preload", "1");
        if (!TextUtils.isEmpty(stringExtra)) {
            p.D("preload_scene", stringExtra);
        }
        if (b.a.p0.a.c1.a.g0() != null && b.a.p0.a.c1.a.g0().u()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", intent.getIntExtra("bundle_key_process", -1));
                jSONObject.put("cost", currentTimeMillis - longExtra2);
                jSONObject.put("is_preload_started", b.a.p0.a.h0.u.g.D);
                jSONObject.put("is_preload_ready", b.a.p0.a.h0.u.g.U().m0());
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            h.d dVar = new h.d("812");
            dVar.g("swan");
            dVar.i("receive");
            dVar.h(intent.getStringExtra("bundle_key_preload_src"));
            dVar.e(jSONObject);
            h.onEvent(dVar);
        }
        g.v.g(intent);
        b.a.p0.a.g1.f.U().s(intent);
        preloadSwanGame(intent);
        if (b.a.p0.a.u1.l.e.m()) {
            SwanPrefetchImageRes.b().c();
        }
        if (!sFlagPreloaded) {
            sFlagPreloaded = true;
            q0.a0(new a(this));
        }
        b.a.p0.a.h0.u.h.a.c(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadActivityClass() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            q.k(new b(this), "PreClassLoader");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        if ((java.lang.System.currentTimeMillis() - b.a.p0.a.n0.i.a.b(1)) < (r0 * 86400000)) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void preloadSwanGame(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, intent) == null) {
            int d2 = b.a.p0.a.u1.l.b.d();
            boolean z = false;
            if (d2 >= 0) {
                if (d2 != 0) {
                }
                z = true;
            }
            if (z) {
                b.a.p0.a.c1.b.i().q(intent);
            }
            if (DEBUG) {
                String str = "strategy : " + d2 + " , canPreload swan game : " + z;
            }
        }
    }

    public SwanAppProcessInfo getProcessInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SwanAppProcessInfo.P0 : (SwanAppProcessInfo) invokeV.objValue;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent)) == null) {
            if (DEBUG) {
                String str = "onBind: intent=" + intent;
            }
            onAction(intent);
            return this.mMessenger.getBinder();
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SwanAppProcessInfo.init(getProcessInfo());
            b.a.p0.a.c1.a.G().a();
            super.onCreate();
            this.mMessenger = new Messenger(b.a.p0.a.y1.c.e.a.P().Q());
            if (DEBUG) {
                String str = "onCreate " + getProcessInfo();
            }
            b.a.p0.a.y1.c.e.a.P().b0();
            b.a.p0.a.h0.o.g.c.a a2 = b.a.p0.a.h0.o.g.c.a.a();
            a.b bVar = new a.b();
            bVar.i(52428800L);
            bVar.g(new b.a.p0.a.h0.o.g.c.c.b());
            bVar.h(new CustomStrategyImpl());
            a2.i(bVar);
            b.a.p0.a.h0.o.g.a.b().a(new b.a.p0.a.h0.o.g.f.c(this, b.a.p0.a.h0.o.g.e.a.d()));
            b.a.p0.a.h0.o.g.a.b().a(new b.a.p0.a.h0.o.h.a.a(this, null));
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mMessenger = null;
            super.onDestroy();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, intent, i2, i3)) == null) {
            if (DEBUG) {
                String str = "onStartCommand: intent=" + intent;
            }
            onAction(intent);
            return super.onStartCommand(intent, i2, i3);
        }
        return invokeLII.intValue;
    }
}
