package com.baidu.swan.apps.process.messaging.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.page.model.SwanAppPageInfo;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ad3;
import com.repackage.bk2;
import com.repackage.bm2;
import com.repackage.bx2;
import com.repackage.db2;
import com.repackage.dt2;
import com.repackage.e92;
import com.repackage.ea3;
import com.repackage.eh1;
import com.repackage.g92;
import com.repackage.it2;
import com.repackage.kx2;
import com.repackage.lc2;
import com.repackage.mx2;
import com.repackage.nx2;
import com.repackage.pa2;
import com.repackage.pv2;
import com.repackage.q71;
import com.repackage.sx2;
import com.repackage.t03;
import com.repackage.tx2;
import com.repackage.ue3;
import com.repackage.uw2;
import com.repackage.ux1;
import com.repackage.vx2;
import com.repackage.yw2;
import com.repackage.z93;
/* loaded from: classes2.dex */
public final class SwanAppMessengerService extends Service {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_DEFAULT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_DEFAULT";
    public static final String ACTION_PREFIX = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_";
    public static final String ACTION_PRELOAD_NEXT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_PRELOAD_NEXT";
    public static final boolean DEBUG;
    public static final String SEND_BROADCAST_INNER_ACTION = "innerAction";
    public static final String TAG = "SwanAppMessengerService";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ue3 launchHelper;

    /* loaded from: classes2.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super(Looper.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ux1.i(SwanAppMessengerService.TAG, "resetCore: service handleCoreReset");
                ea3.b(0);
                db2.f(0).f().c();
                kx2 e = kx2.e();
                mx2 mx2Var = new mx2(129);
                mx2Var.d();
                e.h(mx2Var);
                z93.n(0);
            }
        }

        public final void b(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) && SwanAppProcessInfo.indexOf(message.arg1).isSwanAppProcess()) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    bundle.setClassLoader(a.class.getClassLoader());
                    bk2.w().a(AppRuntime.getAppContext(), bundle.getInt(QuickPersistConfigConst.KEY_TEXT_SIZE));
                    kx2 e = kx2.e();
                    mx2 mx2Var = new mx2(127);
                    mx2Var.e(message.arg1);
                    e.h(mx2Var);
                }
            }
        }

        public final void c(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) && SwanAppProcessInfo.indexOf(message.arg1).isSwanAppProcess()) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    bundle.setClassLoader(a.class.getClassLoader());
                    dt2.e().i(new SwanAppPageInfo(bundle.getString("page_info")));
                }
            }
        }

        public final void d(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
                if (SwanAppMessengerService.DEBUG) {
                    Log.d(SwanAppMessengerService.TAG, "handleOnActivityRegister arg1: " + message.arg1);
                    Log.d(SwanAppMessengerService.TAG, "handleOnActivityRegister obj: " + message.obj);
                    StringBuilder sb = new StringBuilder();
                    sb.append("handleOnActivityRegister is main looper: ");
                    sb.append(Thread.currentThread() == Looper.getMainLooper().getThread());
                    Log.d(SwanAppMessengerService.TAG, sb.toString());
                }
                int i = message.arg1;
                vx2 k = vx2.k();
                tx2 n = k.n(i);
                if (n == null) {
                    return;
                }
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    bundle.setClassLoader(a.class.getClassLoader());
                    n.W(bundle);
                    if (SwanAppMessengerService.DEBUG) {
                        k.u("onLoaded => " + n.toString());
                    }
                }
            }
        }

        public final void e(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, message) == null) {
                if (SwanAppMessengerService.DEBUG) {
                    Log.d(SwanAppMessengerService.TAG, "unregister client. arg1: " + message.arg1);
                }
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    bundle.setClassLoader(a.class.getClassLoader());
                    tx2 n = vx2.k().n(message.arg1);
                    if (n == null) {
                        return;
                    }
                    String string = bundle.getString("ai_apps_id", "");
                    if (TextUtils.isEmpty(string)) {
                        string = n.getAppId();
                    }
                    kx2.e().b(string);
                    n.X();
                    if (SwanAppMessengerService.DEBUG) {
                        vx2 k = vx2.k();
                        k.u("onUnloaded => " + n.toString());
                    }
                }
            }
        }

        public final void f(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, message) == null) {
                if (SwanAppMessengerService.DEBUG) {
                    Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_BACKGROUND");
                }
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (indexOf.isSwanAppProcess() && vx2.k().o(indexOf) != null) {
                    Object obj = message.obj;
                    if (obj instanceof Bundle) {
                        Bundle bundle = (Bundle) obj;
                        bundle.setClassLoader(a.class.getClassLoader());
                        String string = bundle.getString("app_id");
                        int i = bundle.getInt("task_id");
                        bk2.N().b(string, false);
                        ue3.h(false, i);
                    }
                }
            }
        }

        public final void g(@NonNull Message message) {
            tx2 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, message) == null) {
                if (SwanAppMessengerService.DEBUG) {
                    Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_FOREGROUND");
                }
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (indexOf.isSwanAppProcess() && (o = vx2.k().o(indexOf)) != null) {
                    Object obj = message.obj;
                    if (obj instanceof Bundle) {
                        Bundle bundle = (Bundle) obj;
                        bundle.setClassLoader(a.class.getClassLoader());
                        String string = bundle.getString("app_id");
                        int i = bundle.getInt("task_id");
                        vx2.k().g(string, o);
                        bk2.N().b(string, true);
                        ue3.h(true, i);
                        vx2.k().v(indexOf);
                        if (SwanAppMessengerService.DEBUG) {
                            vx2 k = vx2.k();
                            k.u("onAppForegroud => " + o.toString());
                        }
                    }
                }
            }
        }

        public final void h(@NonNull Message message) {
            tx2 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, message) == null) {
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (indexOf.isSwanAppProcess() && (o = vx2.k().o(indexOf)) != null) {
                    Object obj = message.obj;
                    if (obj instanceof Bundle) {
                        Bundle bundle = (Bundle) obj;
                        bundle.setClassLoader(a.class.getClassLoader());
                        o.V(bundle);
                        if (SwanAppMessengerService.DEBUG) {
                            vx2 k = vx2.k();
                            k.u("onConnAck => " + o.toString());
                        }
                    }
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SwanAppDeleteInfo swanAppDeleteInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, message) == null) {
                int i = message.what;
                if (i == 1) {
                    d(message);
                } else if (i == 2) {
                    e(message);
                } else if (i == 3) {
                    if (SwanAppMessengerService.DEBUG) {
                        Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_GET_DATA msg: " + message);
                    }
                    SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                    vx2.k().o(indexOf).k0();
                    kx2 e = kx2.e();
                    mx2 mx2Var = new mx2(101);
                    mx2Var.b(indexOf);
                    e.h(mx2Var);
                } else if (i == 4) {
                    if (SwanAppMessengerService.DEBUG) {
                        Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_RESPONSE msg: " + message);
                    }
                } else if (i == 5) {
                    if (SwanAppMessengerService.DEBUG) {
                        Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_NIGHT_MODE_CHANGED");
                    }
                    bk2.M().c(bk2.M().a());
                    kx2 e2 = kx2.e();
                    mx2 mx2Var2 = new mx2(102);
                    mx2Var2.e(message.arg1);
                    e2.h(mx2Var2);
                } else if (i == 123) {
                    kx2 e3 = kx2.e();
                    mx2 mx2Var3 = new mx2(message);
                    mx2Var3.e(message.arg1);
                    e3.h(mx2Var3);
                } else if (i == 124) {
                    ad3.q(message);
                    kx2 e4 = kx2.e();
                    mx2 mx2Var4 = new mx2(message);
                    mx2Var4.e(message.arg1);
                    e4.h(mx2Var4);
                } else if (i != 129) {
                    switch (i) {
                        case 7:
                            if (SwanAppMessengerService.DEBUG) {
                                Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_WX_PAY_APPID");
                            }
                            Bundle bundle = (Bundle) message.obj;
                            if (bundle != null) {
                                it2.b().a = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                                it2.b().b = bundle.getString("frameType");
                                it2.b().c = bundle.getString("params");
                                return;
                            }
                            return;
                        case 8:
                            if (SwanAppMessengerService.DEBUG) {
                                Log.e(SwanAppMessengerService.TAG, "MSG_TYPE_CS_DELETE_SWAN_APP_WITH_FAV_HISTORY_CHECK");
                            }
                            Bundle bundle2 = (Bundle) message.obj;
                            bundle2.setClassLoader(a.class.getClassLoader());
                            if (bundle2 == null || (swanAppDeleteInfo = (SwanAppDeleteInfo) bundle2.getParcelable("ai_apps_data")) == null || TextUtils.isEmpty(swanAppDeleteInfo.mAppId)) {
                                return;
                            }
                            boolean z = swanAppDeleteInfo.mCheckHisAndFavor == 0;
                            e92 d = g92.c().d();
                            if (d != null) {
                                String str = swanAppDeleteInfo.mAppId;
                                pa2 l = pa2.l();
                                l.i(swanAppDeleteInfo.getPurgerScenes());
                                d.e(str, z, l.k());
                                return;
                            }
                            return;
                        case 9:
                            g(message);
                            return;
                        case 10:
                            f(message);
                            return;
                        case 11:
                            if (message.obj instanceof Bundle) {
                                t03.J().w("event_messenger_call_in", (Bundle) message.obj);
                                return;
                            }
                            return;
                        case 12:
                            nx2.a(message);
                            return;
                        case 13:
                            h(message);
                            return;
                        case 14:
                            i(message);
                            return;
                        case 15:
                            j(message);
                            return;
                        case 16:
                            k(message);
                            return;
                        case 17:
                            SwanAppMessengerService.updatePkg(message);
                            return;
                        case 18:
                            Object obj = message.obj;
                            if (obj instanceof Bundle) {
                                lc2.a((Bundle) obj);
                                return;
                            }
                            return;
                        case 19:
                            q71.b((Bundle) message.obj);
                            return;
                        case 20:
                            vx2.k().s(message);
                            return;
                        case 21:
                            nx2.c(message);
                            return;
                        case 22:
                            b(message);
                            return;
                        case 23:
                            pv2.b().c(message);
                            return;
                        case 24:
                            c(message);
                            return;
                        default:
                            super.handleMessage(message);
                            return;
                    }
                } else {
                    a();
                }
            }
        }

        public final void i(@NonNull Message message) {
            tx2 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, message) == null) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    ((Bundle) obj).setClassLoader(a.class.getClassLoader());
                    SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                    if (indexOf.isSwanAppProcess() && (o = vx2.k().o(indexOf)) != null) {
                        o.a0();
                        if (SwanAppMessengerService.DEBUG) {
                            vx2 k = vx2.k();
                            k.u("onPreloaded => " + o.toString());
                        }
                    }
                }
            }
        }

        public final void j(@NonNull Message message) {
            tx2 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, message) == null) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    ((Bundle) obj).setClassLoader(a.class.getClassLoader());
                    SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                    if (indexOf.isSwanAppProcess() && (o = vx2.k().o(indexOf)) != null) {
                        o.d0();
                        if (SwanAppMessengerService.DEBUG) {
                            vx2 k = vx2.k();
                            k.u("onRePreloaded => " + o.toString());
                        }
                    }
                }
            }
        }

        public final void k(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, message) == null) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    String string = bundle.getString(SwanAppMessengerService.SEND_BROADCAST_INNER_ACTION);
                    String string2 = bundle.getString("ai_apps_data");
                    if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                        return;
                    }
                    bk2.i().a(string, string2);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(498117947, "Lcom/baidu/swan/apps/process/messaging/service/SwanAppMessengerService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(498117947, "Lcom/baidu/swan/apps/process/messaging/service/SwanAppMessengerService;");
                return;
            }
        }
        DEBUG = eh1.a;
    }

    public SwanAppMessengerService() {
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

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65541, null, i, str)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_data", str);
            Message obtain = Message.obtain(null, i, bundle);
            kx2 e = kx2.e();
            mx2 mx2Var = new mx2(obtain);
            mx2Var.d();
            e.h(mx2Var);
            return true;
        }
        return invokeIL.booleanValue;
    }

    public static void updatePkg(@NonNull Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, message) == null) && (message.obj instanceof Bundle)) {
            if (DEBUG) {
                Log.i(TAG, "updatePkg: swanAsyncUpdate -> 收到异步升级消息");
            }
            bm2.a((Bundle) message.obj);
        }
    }

    public static void updateStateByBroadcast(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, intent) == null) {
            sendMessageWithDataToAllClient(116, intent.toUri(0));
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            if (DEBUG) {
                Log.d(TAG, "onBind() " + this + " pid: " + Process.myPid());
            }
            return vx2.k().e.asBinder();
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            if (!ProcessUtils.isMainProcess() || getApplication() == null) {
                return;
            }
            this.launchHelper = new ue3(getApplication());
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ue3 ue3Var = this.launchHelper;
            if (ue3Var != null) {
                ue3Var.i();
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, intent, i, i2)) == null) {
            String action = (intent == null || TextUtils.isEmpty(intent.getAction())) ? ACTION_DEFAULT : intent.getAction();
            char c = 65535;
            int hashCode = action.hashCode();
            if (hashCode != -74985808) {
                if (hashCode == -5111142 && action.equals(ACTION_DEFAULT)) {
                    c = 1;
                }
            } else if (action.equals(ACTION_PRELOAD_NEXT)) {
                c = 0;
            }
            if (c == 0) {
                if (TextUtils.isEmpty(intent.getStringExtra("bundle_key_preload_preload_scene"))) {
                    intent.putExtra("bundle_key_preload_preload_scene", "0");
                }
                sx2.l(this, intent.getExtras());
            }
            return super.onStartCommand(intent, i, i2);
        }
        return invokeLII.intValue;
    }

    public void sendDelegationMessage(@Nullable int i, @Nullable Bundle bundle, @NonNull Class<? extends uw2> cls, @Nullable bx2 bx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), bundle, cls, bx2Var}) == null) {
            if (DEBUG) {
                Log.d(TAG, "sendMessageToClient: delegation: " + cls.getName());
            }
            Message obtain = Message.obtain((Handler) null, 125);
            obtain.replyTo = vx2.k().d;
            Bundle bundle2 = new Bundle();
            bundle2.putString("ai_apps_delegation_name", cls.getName());
            if (bx2Var != null) {
                bundle2.putString("ai_apps_observer_id", bx2Var.b());
                yw2.b().e(bx2Var);
            }
            if (bundle != null) {
                bundle2.putBundle("ai_apps_data", bundle);
            }
            obtain.obj = bundle2;
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(i);
            kx2 e = kx2.e();
            mx2 mx2Var = new mx2(obtain);
            mx2Var.b(indexOf);
            e.h(mx2Var);
        }
    }

    @Deprecated
    public boolean sendMessageToClient(int i, int i2, Bundle bundle) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048581, this, i, i2, bundle)) == null) ? sendMessageToClient(SwanAppProcessInfo.indexOf(i), i2, bundle) : invokeIIL.booleanValue;
    }

    @Deprecated
    public boolean sendMessageToClient(SwanAppProcessInfo swanAppProcessInfo, int i, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048582, this, swanAppProcessInfo, i, bundle)) == null) {
            kx2 e = kx2.e();
            mx2 mx2Var = new mx2(i, bundle);
            mx2Var.b(swanAppProcessInfo);
            e.h(mx2Var);
            return true;
        }
        return invokeLIL.booleanValue;
    }

    @Deprecated
    public boolean sendMessageToClient(tx2 tx2Var, int i, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048583, this, tx2Var, i, bundle)) == null) {
            kx2 e = kx2.e();
            mx2 mx2Var = new mx2(i, bundle);
            mx2Var.b(tx2Var.b);
            e.h(mx2Var);
            return true;
        }
        return invokeLIL.booleanValue;
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            Bundle bundle = new Bundle();
            bundle.putLong("ai_apps_data", j);
            Message obtain = Message.obtain(null, i, bundle);
            kx2 e = kx2.e();
            mx2 mx2Var = new mx2(obtain);
            mx2Var.d();
            e.h(mx2Var);
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
