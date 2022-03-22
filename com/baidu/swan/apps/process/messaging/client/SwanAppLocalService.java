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
import c.a.n0.a.d2.c;
import c.a.n0.a.k.e.p.l;
import c.a.n0.a.k1.h;
import c.a.n0.a.p2.g0;
import c.a.n0.a.p2.q;
import c.a.n0.a.p2.q0;
import c.a.n0.a.q2.e;
import c.a.n0.a.t1.d;
import c.a.n0.a.t1.j;
import c.a.n0.a.x.g.g;
import c.a.n0.a.x.o.g.c.a;
import c.a.n0.a.x.u.g;
import c.a.n0.r.a.d.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppLocalService a;

        public a(SwanAppLocalService swanAppLocalService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppLocalService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppLocalService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q.g();
                q.f();
                q.h();
                l.e(AppRuntime.getAppContext());
                if (c.a.n0.a.s0.a.V().b()) {
                    c.a.n0.a.s0.a.I().d();
                }
                e.y(c.a.n0.a.s0.a.c());
                c.a.n0.a.k1.n.a.a().c(R.layout.obfuscated_res_0x7f0d00aa, R.layout.obfuscated_res_0x7f0d00c8, R.layout.obfuscated_res_0x7f0d00bd);
                c.a.n0.a.s0.a.V().a(c.a.n0.a.s0.a.u0().a());
                boolean z = c.a.n0.a.q2.d.b.i;
                c.a.n0.a.v0.c.b.c().d("screenSize", g0.b());
                this.a.preloadActivityClass();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppLocalService a;

        public b(SwanAppLocalService swanAppLocalService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppLocalService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppLocalService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    ClassLoader classLoader = this.a.getClassLoader();
                    Class.forName(SwanAppProcessInfo.current().activity.getName(), true, classLoader);
                    Class.forName(f.class.getName(), true, classLoader);
                    Class.forName(g.b.class.getName(), true, classLoader);
                    Class.forName(c.a.n0.a.x.g.f.class.getName(), true, classLoader);
                    Class.forName(SwanAppSlaveManager.class.getName(), true, classLoader);
                    Class.forName(JsFunction.class.getName(), true, classLoader);
                    Class.forName(j.class.getName(), true, classLoader);
                    Class.forName(SlideHelper.class.getName(), true, classLoader);
                    Class.forName(c.a.n0.a.j0.f.a.class.getName(), true, classLoader);
                    Class.forName(PullToRefreshBaseWebView.class.getName(), true, classLoader);
                    Class.forName(SlidingPaneLayout.class.getName(), true, classLoader);
                    Class.forName(c.a.n0.a.x.p.b.class.getName(), true, classLoader);
                    Class.forName(SwanAppConfigData.class.getName(), true, classLoader);
                    Class.forName(c.a.n0.a.o1.b.f.class.getName(), true, classLoader);
                } catch (Throwable th) {
                    if (SwanAppLocalService.DEBUG) {
                        Log.d(SwanAppLocalService.TAG, Log.getStackTraceString(th));
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
        DEBUG = c.a.n0.a.a.a;
        sFlagPreloaded = false;
    }

    public SwanAppLocalService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void onAction(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, intent) == null) {
            if (DEBUG) {
                Log.i(TAG, "onAction: intent=" + intent);
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
                } catch (Exception e2) {
                    Log.e(TAG, ACTION_RECEIVER_MSG, e2);
                }
            }
        }
    }

    private void onActionPreload(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, intent) == null) || intent == null) {
            return;
        }
        c.a.n0.a.k1.l.g.a.e().i();
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
        if (c.a.n0.a.s0.a.g0() != null && c.a.n0.a.s0.a.g0().u()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", intent.getIntExtra("bundle_key_process", -1));
                jSONObject.put("cost", currentTimeMillis - longExtra2);
                jSONObject.put("is_preload_started", c.a.n0.a.x.u.g.D);
                jSONObject.put("is_preload_ready", c.a.n0.a.x.u.g.U().m0());
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            h.d dVar = new h.d("812");
            dVar.g("swan");
            dVar.i(StatConstants.VALUE_TYPE_RECEIVE);
            dVar.h(intent.getStringExtra("bundle_key_preload_src"));
            dVar.e(jSONObject);
            h.onEvent(dVar);
        }
        g.v.g(intent);
        c.a.n0.a.w0.f.U().t(intent);
        preloadSwanGame(intent);
        if (c.a.n0.a.k1.l.e.m()) {
            SwanPrefetchImageRes.b().c();
        }
        if (!sFlagPreloaded) {
            sFlagPreloaded = true;
            q0.a0(new a(this));
        }
        c.a.n0.a.x.u.h.a.c(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadActivityClass() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            q.k(new b(this), "PreClassLoader");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        if ((java.lang.System.currentTimeMillis() - c.a.n0.a.d0.i.a.b(1)) < (r0 * 86400000)) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void preloadSwanGame(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, intent) == null) {
            int d2 = c.a.n0.a.k1.l.b.d();
            boolean z = false;
            if (d2 >= 0) {
                if (d2 != 0) {
                }
                z = true;
            }
            if (z) {
                c.a.n0.a.s0.b.i().q(intent);
            }
            if (DEBUG) {
                Log.d(TAG, "strategy : " + d2 + " , canPreload swan game : " + z);
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
                Log.d(TAG, "onBind: intent=" + intent);
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
            c.a.n0.a.s0.a.G().a();
            super.onCreate();
            this.mMessenger = new Messenger(c.a.n0.a.o1.c.e.a.P().Q());
            if (DEBUG) {
                Log.i(TAG, "onCreate " + getProcessInfo());
            }
            c.a.n0.a.o1.c.e.a.P().b0();
            c.a.n0.a.x.o.g.c.a a2 = c.a.n0.a.x.o.g.c.a.a();
            a.b bVar = new a.b();
            bVar.i(52428800L);
            bVar.g(new c.a.n0.a.x.o.g.c.c.b());
            bVar.h(new CustomStrategyImpl());
            a2.i(bVar);
            c.a.n0.a.x.o.g.a.b().a(new c.a.n0.a.x.o.g.f.c(this, c.a.n0.a.x.o.g.e.a.d()));
            c.a.n0.a.x.o.g.a.b().a(new c.a.n0.a.x.o.h.a.a(this, null));
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
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, intent, i, i2)) == null) {
            if (DEBUG) {
                Log.d(TAG, "onStartCommand: intent=" + intent);
            }
            onAction(intent);
            return super.onStartCommand(intent, i, i2);
        }
        return invokeLII.intValue;
    }
}
