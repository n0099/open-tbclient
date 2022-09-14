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
import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.page.model.SwanAppPageInfo;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.cz2;
import com.baidu.tieba.dc3;
import com.baidu.tieba.ef3;
import com.baidu.tieba.fm2;
import com.baidu.tieba.fo2;
import com.baidu.tieba.fz2;
import com.baidu.tieba.hd2;
import com.baidu.tieba.hv2;
import com.baidu.tieba.ib2;
import com.baidu.tieba.ic3;
import com.baidu.tieba.ij1;
import com.baidu.tieba.kb2;
import com.baidu.tieba.mv2;
import com.baidu.tieba.oz2;
import com.baidu.tieba.pe2;
import com.baidu.tieba.q91;
import com.baidu.tieba.qz2;
import com.baidu.tieba.rz2;
import com.baidu.tieba.tc2;
import com.baidu.tieba.tx2;
import com.baidu.tieba.wz2;
import com.baidu.tieba.x23;
import com.baidu.tieba.xz2;
import com.baidu.tieba.yg3;
import com.baidu.tieba.yy2;
import com.baidu.tieba.yz1;
import com.baidu.tieba.zz2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public yg3 launchHelper;

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
                yz1.i(SwanAppMessengerService.TAG, "resetCore: service handleCoreReset");
                ic3.b(0);
                hd2.f(0).f().c();
                oz2 e = oz2.e();
                qz2 qz2Var = new qz2(129);
                qz2Var.d();
                e.h(qz2Var);
                dc3.n(0);
            }
        }

        public final void b(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) && SwanAppProcessInfo.indexOf(message.arg1).isSwanAppProcess()) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    bundle.setClassLoader(a.class.getClassLoader());
                    fm2.w().a(AppRuntime.getAppContext(), bundle.getInt(QuickPersistConfigConst.KEY_TEXT_SIZE));
                    oz2 e = oz2.e();
                    qz2 qz2Var = new qz2(127);
                    qz2Var.e(message.arg1);
                    e.h(qz2Var);
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
                    hv2.e().i(new SwanAppPageInfo(bundle.getString(PageInfo.KEY)));
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
                zz2 k = zz2.k();
                xz2 n = k.n(i);
                if (n == null) {
                    return;
                }
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    bundle.setClassLoader(a.class.getClassLoader());
                    n.X(bundle);
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
                    xz2 n = zz2.k().n(message.arg1);
                    if (n == null) {
                        return;
                    }
                    String string = bundle.getString("ai_apps_id", "");
                    if (TextUtils.isEmpty(string)) {
                        string = n.getAppId();
                    }
                    oz2.e().b(string);
                    n.Y();
                    if (SwanAppMessengerService.DEBUG) {
                        zz2 k = zz2.k();
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
                if (indexOf.isSwanAppProcess() && zz2.k().o(indexOf) != null) {
                    Object obj = message.obj;
                    if (obj instanceof Bundle) {
                        Bundle bundle = (Bundle) obj;
                        bundle.setClassLoader(a.class.getClassLoader());
                        String string = bundle.getString("app_id");
                        int i = bundle.getInt("task_id");
                        fm2.N().b(string, false);
                        yg3.h(false, i);
                    }
                }
            }
        }

        public final void g(@NonNull Message message) {
            xz2 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, message) == null) {
                if (SwanAppMessengerService.DEBUG) {
                    Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_FOREGROUND");
                }
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (indexOf.isSwanAppProcess() && (o = zz2.k().o(indexOf)) != null) {
                    Object obj = message.obj;
                    if (obj instanceof Bundle) {
                        Bundle bundle = (Bundle) obj;
                        bundle.setClassLoader(a.class.getClassLoader());
                        String string = bundle.getString("app_id");
                        int i = bundle.getInt("task_id");
                        zz2.k().g(string, o);
                        fm2.N().b(string, true);
                        yg3.h(true, i);
                        zz2.k().v(indexOf);
                        if (SwanAppMessengerService.DEBUG) {
                            zz2 k = zz2.k();
                            k.u("onAppForegroud => " + o.toString());
                        }
                    }
                }
            }
        }

        public final void h(@NonNull Message message) {
            xz2 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, message) == null) {
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (indexOf.isSwanAppProcess() && (o = zz2.k().o(indexOf)) != null) {
                    Object obj = message.obj;
                    if (obj instanceof Bundle) {
                        Bundle bundle = (Bundle) obj;
                        bundle.setClassLoader(a.class.getClassLoader());
                        o.W(bundle);
                        if (SwanAppMessengerService.DEBUG) {
                            zz2 k = zz2.k();
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
                    zz2.k().o(indexOf).l0();
                    oz2 e = oz2.e();
                    qz2 qz2Var = new qz2(101);
                    qz2Var.b(indexOf);
                    e.h(qz2Var);
                } else if (i == 4) {
                    if (SwanAppMessengerService.DEBUG) {
                        Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_RESPONSE msg: " + message);
                    }
                } else if (i == 5) {
                    if (SwanAppMessengerService.DEBUG) {
                        Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_NIGHT_MODE_CHANGED");
                    }
                    fm2.M().c(fm2.M().a());
                    oz2 e2 = oz2.e();
                    qz2 qz2Var2 = new qz2(102);
                    qz2Var2.e(message.arg1);
                    e2.h(qz2Var2);
                } else if (i == 123) {
                    oz2 e3 = oz2.e();
                    qz2 qz2Var3 = new qz2(message);
                    qz2Var3.e(message.arg1);
                    e3.h(qz2Var3);
                } else if (i == 124) {
                    ef3.q(message);
                    oz2 e4 = oz2.e();
                    qz2 qz2Var4 = new qz2(message);
                    qz2Var4.e(message.arg1);
                    e4.h(qz2Var4);
                } else if (i != 129) {
                    switch (i) {
                        case 7:
                            if (SwanAppMessengerService.DEBUG) {
                                Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_WX_PAY_APPID");
                            }
                            Bundle bundle = (Bundle) message.obj;
                            if (bundle != null) {
                                mv2.b().a = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                                mv2.b().b = bundle.getString("frameType");
                                mv2.b().c = bundle.getString("params");
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
                            ib2 d = kb2.c().d();
                            if (d != null) {
                                String str = swanAppDeleteInfo.mAppId;
                                tc2 l = tc2.l();
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
                                x23.K().v("event_messenger_call_in", (Bundle) message.obj);
                                return;
                            }
                            return;
                        case 12:
                            rz2.a(message);
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
                                pe2.a((Bundle) obj);
                                return;
                            }
                            return;
                        case 19:
                            q91.b((Bundle) message.obj);
                            return;
                        case 20:
                            zz2.k().s(message);
                            return;
                        case 21:
                            rz2.c(message);
                            return;
                        case 22:
                            b(message);
                            return;
                        case 23:
                            tx2.b().c(message);
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
            xz2 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, message) == null) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    ((Bundle) obj).setClassLoader(a.class.getClassLoader());
                    SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                    if (indexOf.isSwanAppProcess() && (o = zz2.k().o(indexOf)) != null) {
                        o.b0();
                        if (SwanAppMessengerService.DEBUG) {
                            zz2 k = zz2.k();
                            k.u("onPreloaded => " + o.toString());
                        }
                    }
                }
            }
        }

        public final void j(@NonNull Message message) {
            xz2 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, message) == null) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    ((Bundle) obj).setClassLoader(a.class.getClassLoader());
                    SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                    if (indexOf.isSwanAppProcess() && (o = zz2.k().o(indexOf)) != null) {
                        o.e0();
                        if (SwanAppMessengerService.DEBUG) {
                            zz2 k = zz2.k();
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
                    fm2.i().a(string, string2);
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
        DEBUG = ij1.a;
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
            oz2 e = oz2.e();
            qz2 qz2Var = new qz2(obtain);
            qz2Var.d();
            e.h(qz2Var);
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
            fo2.a((Bundle) message.obj);
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
            return zz2.k().e.asBinder();
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
            this.launchHelper = new yg3(getApplication());
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            yg3 yg3Var = this.launchHelper;
            if (yg3Var != null) {
                yg3Var.i();
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
                wz2.l(this, intent.getExtras());
            }
            return super.onStartCommand(intent, i, i2);
        }
        return invokeLII.intValue;
    }

    public void sendDelegationMessage(@Nullable int i, @Nullable Bundle bundle, @NonNull Class<? extends yy2> cls, @Nullable fz2 fz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), bundle, cls, fz2Var}) == null) {
            if (DEBUG) {
                Log.d(TAG, "sendMessageToClient: delegation: " + cls.getName());
            }
            Message obtain = Message.obtain((Handler) null, 125);
            obtain.replyTo = zz2.k().d;
            Bundle bundle2 = new Bundle();
            bundle2.putString("ai_apps_delegation_name", cls.getName());
            if (fz2Var != null) {
                bundle2.putString("ai_apps_observer_id", fz2Var.b());
                cz2.b().e(fz2Var);
            }
            if (bundle != null) {
                bundle2.putBundle("ai_apps_data", bundle);
            }
            obtain.obj = bundle2;
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(i);
            oz2 e = oz2.e();
            qz2 qz2Var = new qz2(obtain);
            qz2Var.b(indexOf);
            e.h(qz2Var);
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
            oz2 e = oz2.e();
            qz2 qz2Var = new qz2(i, bundle);
            qz2Var.b(swanAppProcessInfo);
            e.h(qz2Var);
            return true;
        }
        return invokeLIL.booleanValue;
    }

    @Deprecated
    public boolean sendMessageToClient(xz2 xz2Var, int i, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048583, this, xz2Var, i, bundle)) == null) {
            oz2 e = oz2.e();
            qz2 qz2Var = new qz2(i, bundle);
            qz2Var.b(xz2Var.b);
            e.h(qz2Var);
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
            oz2 e = oz2.e();
            qz2 qz2Var = new qz2(obtain);
            qz2Var.d();
            e.h(qz2Var);
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
