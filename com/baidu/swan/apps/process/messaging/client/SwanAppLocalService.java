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
import com.baidu.android.imsdk.internal.Constants;
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
import com.repackage.a42;
import com.repackage.a52;
import com.repackage.a63;
import com.repackage.aj2;
import com.repackage.az1;
import com.repackage.bz1;
import com.repackage.c42;
import com.repackage.cd3;
import com.repackage.cg1;
import com.repackage.cr1;
import com.repackage.cu2;
import com.repackage.fl2;
import com.repackage.gw2;
import com.repackage.i42;
import com.repackage.je4;
import com.repackage.lk2;
import com.repackage.m62;
import com.repackage.mc3;
import com.repackage.md3;
import com.repackage.n62;
import com.repackage.nw2;
import com.repackage.p42;
import com.repackage.qt2;
import com.repackage.rz2;
import com.repackage.te3;
import com.repackage.tt2;
import com.repackage.u32;
import com.repackage.uc2;
import com.repackage.ue3;
import com.repackage.vt2;
import com.repackage.x32;
import com.repackage.xs2;
import com.repackage.xz2;
import com.repackage.zi2;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
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
                mc3.g();
                mc3.f();
                mc3.h();
                cr1.e(AppRuntime.getAppContext());
                if (zi2.V().b()) {
                    zi2.I().d();
                }
                ue3.y(zi2.c());
                cu2.a().c(R.layout.obfuscated_res_0x7f0d00a3, R.layout.obfuscated_res_0x7f0d00c1, R.layout.obfuscated_res_0x7f0d00b6);
                zi2.V().a(zi2.u0().a());
                boolean z = te3.i;
                lk2.c().d("screenSize", cd3.b());
                this.a.preloadActivityClass();
            }
        }
    }

    /* loaded from: classes2.dex */
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
                    Class.forName(je4.class.getName(), true, classLoader);
                    Class.forName(bz1.b.class.getName(), true, classLoader);
                    Class.forName(az1.class.getName(), true, classLoader);
                    Class.forName(SwanAppSlaveManager.class.getName(), true, classLoader);
                    Class.forName(JsFunction.class.getName(), true, classLoader);
                    Class.forName(xz2.class.getName(), true, classLoader);
                    Class.forName(SlideHelper.class.getName(), true, classLoader);
                    Class.forName(uc2.class.getName(), true, classLoader);
                    Class.forName(PullToRefreshBaseWebView.class.getName(), true, classLoader);
                    Class.forName(SlidingPaneLayout.class.getName(), true, classLoader);
                    Class.forName(a52.class.getName(), true, classLoader);
                    Class.forName(SwanAppConfigData.class.getName(), true, classLoader);
                    Class.forName(gw2.class.getName(), true, classLoader);
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
        DEBUG = cg1.a;
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
                    a63.b bVar = new a63.b(10013);
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
                        rz2.K().z().R().handleMessage(message);
                    }
                } catch (Exception e) {
                    Log.e(TAG, ACTION_RECEIVER_MSG, e);
                }
            }
        }
    }

    private void onActionPreload(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, intent) == null) || intent == null) {
            return;
        }
        vt2.e().i();
        long currentTimeMillis = System.currentTimeMillis();
        long longExtra = intent.getLongExtra("bundle_key_preload_launch_time", currentTimeMillis);
        long longExtra2 = intent.getLongExtra("bundle_key_preload_swan_updated_time", currentTimeMillis);
        String stringExtra = intent.getStringExtra("bundle_key_preload_preload_scene");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "0";
        }
        HybridUbcFlow p = xs2.p("preload");
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
        if (zi2.g0() != null && zi2.g0().u()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", intent.getIntExtra("bundle_key_process", -1));
                jSONObject.put("cost", currentTimeMillis - longExtra2);
                jSONObject.put("is_preload_started", m62.D);
                jSONObject.put("is_preload_ready", m62.U().m0());
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            xs2.d dVar = new xs2.d("812");
            dVar.g("swan");
            dVar.i(StatConstants.VALUE_TYPE_RECEIVE);
            dVar.h(intent.getStringExtra("bundle_key_preload_src"));
            dVar.e(jSONObject);
            xs2.onEvent(dVar);
        }
        m62.v.g(intent);
        fl2.U().t(intent);
        preloadSwanGame(intent);
        if (tt2.m()) {
            SwanPrefetchImageRes.b().c();
        }
        if (!sFlagPreloaded) {
            sFlagPreloaded = true;
            md3.a0(new a(this));
        }
        n62.c(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadActivityClass() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            mc3.k(new b(this), "PreClassLoader");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        if ((java.lang.System.currentTimeMillis() - com.repackage.m82.b(1)) < (r0 * 86400000)) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void preloadSwanGame(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, intent) == null) {
            int d = qt2.d();
            boolean z = false;
            if (d >= 0) {
                if (d != 0) {
                }
                z = true;
            }
            if (z) {
                aj2.i().q(intent);
            }
            if (DEBUG) {
                Log.d(TAG, "strategy : " + d + " , canPreload swan game : " + z);
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
            zi2.G().a();
            super.onCreate();
            this.mMessenger = new Messenger(nw2.Q().R());
            if (DEBUG) {
                Log.i(TAG, "onCreate " + getProcessInfo());
            }
            nw2.Q().c0();
            x32 a2 = x32.a();
            x32.b bVar = new x32.b();
            bVar.i(52428800L);
            bVar.g(new a42());
            bVar.h(new CustomStrategyImpl());
            a2.i(bVar);
            u32.b().a(new i42(this, c42.d()));
            u32.b().a(new p42(this, null));
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
