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
import com.baidu.tieba.aw2;
import com.baidu.tieba.c03;
import com.baidu.tieba.df2;
import com.baidu.tieba.e03;
import com.baidu.tieba.ea1;
import com.baidu.tieba.f03;
import com.baidu.tieba.hd2;
import com.baidu.tieba.hy2;
import com.baidu.tieba.k03;
import com.baidu.tieba.l03;
import com.baidu.tieba.l33;
import com.baidu.tieba.m02;
import com.baidu.tieba.mh3;
import com.baidu.tieba.n03;
import com.baidu.tieba.qz2;
import com.baidu.tieba.rc3;
import com.baidu.tieba.sf3;
import com.baidu.tieba.tm2;
import com.baidu.tieba.to2;
import com.baidu.tieba.tz2;
import com.baidu.tieba.vd2;
import com.baidu.tieba.vv2;
import com.baidu.tieba.wb2;
import com.baidu.tieba.wc3;
import com.baidu.tieba.wj1;
import com.baidu.tieba.yb2;
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
    public mh3 launchHelper;

    /* loaded from: classes2.dex */
    public class a extends Handler {
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
                m02.i(SwanAppMessengerService.TAG, "resetCore: service handleCoreReset");
                wc3.b(0);
                vd2.f(0).f().c();
                c03 e = c03.e();
                e03 e03Var = new e03(129);
                e03Var.d();
                e.h(e03Var);
                rc3.n(0);
            }
        }

        public final void b(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) != null) || !SwanAppProcessInfo.indexOf(message.arg1).isSwanAppProcess()) {
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof Bundle)) {
                return;
            }
            Bundle bundle = (Bundle) obj;
            bundle.setClassLoader(a.class.getClassLoader());
            tm2.w().a(AppRuntime.getAppContext(), bundle.getInt(QuickPersistConfigConst.KEY_TEXT_SIZE));
            c03 e = c03.e();
            e03 e03Var = new e03(127);
            e03Var.e(message.arg1);
            e.h(e03Var);
        }

        public final void f(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, message) == null) {
                if (SwanAppMessengerService.DEBUG) {
                    Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_BACKGROUND");
                }
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (!indexOf.isSwanAppProcess() || n03.k().o(indexOf) == null) {
                    return;
                }
                Object obj = message.obj;
                if (!(obj instanceof Bundle)) {
                    return;
                }
                Bundle bundle = (Bundle) obj;
                bundle.setClassLoader(a.class.getClassLoader());
                String string = bundle.getString("app_id");
                int i = bundle.getInt("task_id");
                tm2.N().b(string, false);
                mh3.h(false, i);
            }
        }

        public final void h(Message message) {
            l03 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, message) == null) {
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (!indexOf.isSwanAppProcess() || (o = n03.k().o(indexOf)) == null) {
                    return;
                }
                Object obj = message.obj;
                if (!(obj instanceof Bundle)) {
                    return;
                }
                Bundle bundle = (Bundle) obj;
                bundle.setClassLoader(a.class.getClassLoader());
                o.W(bundle);
                if (SwanAppMessengerService.DEBUG) {
                    n03 k = n03.k();
                    k.u("onConnAck => " + o.toString());
                }
            }
        }

        public final void i(Message message) {
            l03 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, message) == null) {
                Object obj = message.obj;
                if (!(obj instanceof Bundle)) {
                    return;
                }
                ((Bundle) obj).setClassLoader(a.class.getClassLoader());
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (!indexOf.isSwanAppProcess() || (o = n03.k().o(indexOf)) == null) {
                    return;
                }
                o.b0();
                if (SwanAppMessengerService.DEBUG) {
                    n03 k = n03.k();
                    k.u("onPreloaded => " + o.toString());
                }
            }
        }

        public final void j(Message message) {
            l03 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, message) == null) {
                Object obj = message.obj;
                if (!(obj instanceof Bundle)) {
                    return;
                }
                ((Bundle) obj).setClassLoader(a.class.getClassLoader());
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (!indexOf.isSwanAppProcess() || (o = n03.k().o(indexOf)) == null) {
                    return;
                }
                o.e0();
                if (SwanAppMessengerService.DEBUG) {
                    n03 k = n03.k();
                    k.u("onRePreloaded => " + o.toString());
                }
            }
        }

        public final void c(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) != null) || !SwanAppProcessInfo.indexOf(message.arg1).isSwanAppProcess()) {
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof Bundle)) {
                return;
            }
            Bundle bundle = (Bundle) obj;
            bundle.setClassLoader(a.class.getClassLoader());
            vv2.e().i(new SwanAppPageInfo(bundle.getString(PageInfo.KEY)));
        }

        public final void k(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, message) == null) {
                Object obj = message.obj;
                if (!(obj instanceof Bundle)) {
                    return;
                }
                Bundle bundle = (Bundle) obj;
                String string = bundle.getString(SwanAppMessengerService.SEND_BROADCAST_INNER_ACTION);
                String string2 = bundle.getString("ai_apps_data");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    tm2.i().a(string, string2);
                }
            }
        }

        public final void d(Message message) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
                if (SwanAppMessengerService.DEBUG) {
                    Log.d(SwanAppMessengerService.TAG, "handleOnActivityRegister arg1: " + message.arg1);
                    Log.d(SwanAppMessengerService.TAG, "handleOnActivityRegister obj: " + message.obj);
                    StringBuilder sb = new StringBuilder();
                    sb.append("handleOnActivityRegister is main looper: ");
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    sb.append(z);
                    Log.d(SwanAppMessengerService.TAG, sb.toString());
                }
                int i = message.arg1;
                n03 k = n03.k();
                l03 n = k.n(i);
                if (n == null) {
                    return;
                }
                Object obj = message.obj;
                if (!(obj instanceof Bundle)) {
                    return;
                }
                Bundle bundle = (Bundle) obj;
                bundle.setClassLoader(a.class.getClassLoader());
                n.X(bundle);
                if (SwanAppMessengerService.DEBUG) {
                    k.u("onLoaded => " + n.toString());
                }
            }
        }

        public final void e(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, message) == null) {
                if (SwanAppMessengerService.DEBUG) {
                    Log.d(SwanAppMessengerService.TAG, "unregister client. arg1: " + message.arg1);
                }
                Object obj = message.obj;
                if (!(obj instanceof Bundle)) {
                    return;
                }
                Bundle bundle = (Bundle) obj;
                bundle.setClassLoader(a.class.getClassLoader());
                l03 n = n03.k().n(message.arg1);
                if (n == null) {
                    return;
                }
                String string = bundle.getString("ai_apps_id", "");
                if (TextUtils.isEmpty(string)) {
                    string = n.getAppId();
                }
                c03.e().b(string);
                n.Y();
                if (SwanAppMessengerService.DEBUG) {
                    n03 k = n03.k();
                    k.u("onUnloaded => " + n.toString());
                }
            }
        }

        public final void g(Message message) {
            l03 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, message) == null) {
                if (SwanAppMessengerService.DEBUG) {
                    Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_FOREGROUND");
                }
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (!indexOf.isSwanAppProcess() || (o = n03.k().o(indexOf)) == null) {
                    return;
                }
                Object obj = message.obj;
                if (!(obj instanceof Bundle)) {
                    return;
                }
                Bundle bundle = (Bundle) obj;
                bundle.setClassLoader(a.class.getClassLoader());
                String string = bundle.getString("app_id");
                int i = bundle.getInt("task_id");
                n03.k().g(string, o);
                tm2.N().b(string, true);
                mh3.h(true, i);
                n03.k().v(indexOf);
                if (SwanAppMessengerService.DEBUG) {
                    n03 k = n03.k();
                    k.u("onAppForegroud => " + o.toString());
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SwanAppDeleteInfo swanAppDeleteInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, message) == null) {
                int i = message.what;
                boolean z = true;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    if (i != 123) {
                                        if (i != 124) {
                                            if (i != 129) {
                                                switch (i) {
                                                    case 7:
                                                        if (SwanAppMessengerService.DEBUG) {
                                                            Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_WX_PAY_APPID");
                                                        }
                                                        Bundle bundle = (Bundle) message.obj;
                                                        if (bundle != null) {
                                                            aw2.b().a = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                                                            aw2.b().b = bundle.getString("frameType");
                                                            aw2.b().c = bundle.getString("params");
                                                            return;
                                                        }
                                                        return;
                                                    case 8:
                                                        if (SwanAppMessengerService.DEBUG) {
                                                            Log.e(SwanAppMessengerService.TAG, "MSG_TYPE_CS_DELETE_SWAN_APP_WITH_FAV_HISTORY_CHECK");
                                                        }
                                                        Bundle bundle2 = (Bundle) message.obj;
                                                        bundle2.setClassLoader(a.class.getClassLoader());
                                                        if (bundle2 != null && (swanAppDeleteInfo = (SwanAppDeleteInfo) bundle2.getParcelable("ai_apps_data")) != null && !TextUtils.isEmpty(swanAppDeleteInfo.mAppId)) {
                                                            if (swanAppDeleteInfo.mCheckHisAndFavor != 0) {
                                                                z = false;
                                                            }
                                                            wb2 d = yb2.c().d();
                                                            if (d != null) {
                                                                String str = swanAppDeleteInfo.mAppId;
                                                                hd2 l = hd2.l();
                                                                l.i(swanAppDeleteInfo.getPurgerScenes());
                                                                d.e(str, z, l.k());
                                                                return;
                                                            }
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
                                                            l33.K().v("event_messenger_call_in", (Bundle) message.obj);
                                                            return;
                                                        }
                                                        return;
                                                    case 12:
                                                        f03.a(message);
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
                                                            df2.a((Bundle) obj);
                                                            return;
                                                        }
                                                        return;
                                                    case 19:
                                                        ea1.b((Bundle) message.obj);
                                                        return;
                                                    case 20:
                                                        n03.k().s(message);
                                                        return;
                                                    case 21:
                                                        f03.c(message);
                                                        return;
                                                    case 22:
                                                        b(message);
                                                        return;
                                                    case 23:
                                                        hy2.b().c(message);
                                                        return;
                                                    case 24:
                                                        c(message);
                                                        return;
                                                    default:
                                                        super.handleMessage(message);
                                                        return;
                                                }
                                            }
                                            a();
                                            return;
                                        }
                                        sf3.q(message);
                                        c03 e = c03.e();
                                        e03 e03Var = new e03(message);
                                        e03Var.e(message.arg1);
                                        e.h(e03Var);
                                        return;
                                    }
                                    c03 e2 = c03.e();
                                    e03 e03Var2 = new e03(message);
                                    e03Var2.e(message.arg1);
                                    e2.h(e03Var2);
                                    return;
                                }
                                if (SwanAppMessengerService.DEBUG) {
                                    Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_NIGHT_MODE_CHANGED");
                                }
                                tm2.M().c(tm2.M().a());
                                c03 e3 = c03.e();
                                e03 e03Var3 = new e03(102);
                                e03Var3.e(message.arg1);
                                e3.h(e03Var3);
                                return;
                            } else if (SwanAppMessengerService.DEBUG) {
                                Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_RESPONSE msg: " + message);
                                return;
                            } else {
                                return;
                            }
                        }
                        if (SwanAppMessengerService.DEBUG) {
                            Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_GET_DATA msg: " + message);
                        }
                        SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                        n03.k().o(indexOf).l0();
                        c03 e4 = c03.e();
                        e03 e03Var4 = new e03(101);
                        e03Var4.b(indexOf);
                        e4.h(e03Var4);
                        return;
                    }
                    e(message);
                    return;
                }
                d(message);
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
        DEBUG = wj1.a;
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

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            if (ProcessUtils.isMainProcess() && getApplication() != null) {
                this.launchHelper = new mh3(getApplication());
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            mh3 mh3Var = this.launchHelper;
            if (mh3Var != null) {
                mh3Var.i();
            }
            super.onDestroy();
        }
    }

    public static void updatePkg(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, message) == null) && (message.obj instanceof Bundle)) {
            if (DEBUG) {
                Log.i(TAG, "updatePkg: swanAsyncUpdate -> 收到异步升级消息");
            }
            to2.a((Bundle) message.obj);
        }
    }

    public static void updateStateByBroadcast(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, intent) == null) {
            sendMessageWithDataToAllClient(116, intent.toUri(0));
        }
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            Bundle bundle = new Bundle();
            bundle.putLong("ai_apps_data", j);
            Message obtain = Message.obtain(null, i, bundle);
            c03 e = c03.e();
            e03 e03Var = new e03(obtain);
            e03Var.d();
            e.h(e03Var);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65541, null, i, str)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_data", str);
            Message obtain = Message.obtain(null, i, bundle);
            c03 e = c03.e();
            e03 e03Var = new e03(obtain);
            e03Var.d();
            e.h(e03Var);
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            if (DEBUG) {
                Log.d(TAG, "onBind() " + this + " pid: " + Process.myPid());
            }
            return n03.k().e.asBinder();
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, intent, i, i2)) == null) {
            if (intent != null && !TextUtils.isEmpty(intent.getAction())) {
                str = intent.getAction();
            } else {
                str = ACTION_DEFAULT;
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -74985808) {
                if (hashCode == -5111142 && str.equals(ACTION_DEFAULT)) {
                    c = 1;
                }
            } else if (str.equals(ACTION_PRELOAD_NEXT)) {
                c = 0;
            }
            if (c == 0) {
                if (TextUtils.isEmpty(intent.getStringExtra("bundle_key_preload_preload_scene"))) {
                    intent.putExtra("bundle_key_preload_preload_scene", "0");
                }
                k03.l(this, intent.getExtras());
            }
            return super.onStartCommand(intent, i, i2);
        }
        return invokeLII.intValue;
    }

    public void sendDelegationMessage(int i, Bundle bundle, Class cls, tz2 tz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), bundle, cls, tz2Var}) == null) {
            if (DEBUG) {
                Log.d(TAG, "sendMessageToClient: delegation: " + cls.getName());
            }
            Message obtain = Message.obtain((Handler) null, 125);
            obtain.replyTo = n03.k().d;
            Bundle bundle2 = new Bundle();
            bundle2.putString("ai_apps_delegation_name", cls.getName());
            if (tz2Var != null) {
                bundle2.putString("ai_apps_observer_id", tz2Var.b());
                qz2.b().e(tz2Var);
            }
            if (bundle != null) {
                bundle2.putBundle("ai_apps_data", bundle);
            }
            obtain.obj = bundle2;
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(i);
            c03 e = c03.e();
            e03 e03Var = new e03(obtain);
            e03Var.b(indexOf);
            e.h(e03Var);
        }
    }

    @Deprecated
    public boolean sendMessageToClient(int i, int i2, Bundle bundle) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048581, this, i, i2, bundle)) == null) {
            return sendMessageToClient(SwanAppProcessInfo.indexOf(i), i2, bundle);
        }
        return invokeIIL.booleanValue;
    }

    @Deprecated
    public boolean sendMessageToClient(SwanAppProcessInfo swanAppProcessInfo, int i, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048582, this, swanAppProcessInfo, i, bundle)) == null) {
            c03 e = c03.e();
            e03 e03Var = new e03(i, bundle);
            e03Var.b(swanAppProcessInfo);
            e.h(e03Var);
            return true;
        }
        return invokeLIL.booleanValue;
    }

    @Deprecated
    public boolean sendMessageToClient(l03 l03Var, int i, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048583, this, l03Var, i, bundle)) == null) {
            c03 e = c03.e();
            e03 e03Var = new e03(i, bundle);
            e03Var.b(l03Var.b);
            e.h(e03Var);
            return true;
        }
        return invokeLIL.booleanValue;
    }
}
