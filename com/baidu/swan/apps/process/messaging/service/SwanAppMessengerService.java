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
import com.baidu.mobads.container.util.AdIconUtil;
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
import d.a.q0.a.e0.d;
import d.a.q0.a.k;
import d.a.q0.a.n0.f;
import d.a.q0.a.p0.b;
import d.a.q0.a.v1.c.c;
import d.a.q0.a.v1.c.f.e;
import d.a.q0.a.v2.v0;
/* loaded from: classes4.dex */
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
    public v0 launchHelper;

    /* loaded from: classes4.dex */
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

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.g(SwanAppMessengerService.TAG, "resetCore: service handleCoreReset");
                d.a.q0.a.m2.f.a.b(0);
                b.f(0).f().c();
                d.a.q0.a.v1.c.a e2 = d.a.q0.a.v1.c.a.e();
                c cVar = new c(129);
                cVar.d();
                e2.h(cVar);
                d.a.q0.a.m2.b.n(0);
            }
        }

        public final void b(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) && SwanAppProcessInfo.indexOf(message.arg1).isSwanAppProcess()) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    bundle.setClassLoader(a.class.getClassLoader());
                    d.a.q0.a.c1.a.u().a(AppRuntime.getAppContext(), bundle.getInt(QuickPersistConfigConst.KEY_TEXT_SIZE));
                    d.a.q0.a.v1.c.a e2 = d.a.q0.a.v1.c.a.e();
                    c cVar = new c(127);
                    cVar.e(message.arg1);
                    e2.h(cVar);
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
                    String string = bundle.getString("page_info");
                    if (d.a.q0.a.p1.a.a().f50040a != null) {
                        d.a.q0.a.p1.a.a().f50040a.onCallback(new SwanAppPageInfo(string));
                    }
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
                int i2 = message.arg1;
                e k = e.k();
                d.a.q0.a.v1.c.f.c n = k.n(i2);
                if (n == null) {
                    return;
                }
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    bundle.setClassLoader(a.class.getClassLoader());
                    n.L(bundle);
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
                    d.a.q0.a.v1.c.f.c n = e.k().n(message.arg1);
                    if (n == null) {
                        return;
                    }
                    String string = bundle.getString("ai_apps_id", "");
                    if (TextUtils.isEmpty(string)) {
                        string = n.getAppId();
                    }
                    d.a.q0.a.v1.c.a.e().b(string);
                    n.M();
                    if (SwanAppMessengerService.DEBUG) {
                        e k = e.k();
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
                if (indexOf.isSwanAppProcess() && e.k().o(indexOf) != null) {
                    Object obj = message.obj;
                    if (obj instanceof Bundle) {
                        Bundle bundle = (Bundle) obj;
                        bundle.setClassLoader(a.class.getClassLoader());
                        String string = bundle.getString("app_id");
                        int i2 = bundle.getInt("task_id");
                        d.a.q0.a.c1.a.I().b(string, false);
                        v0.h(false, i2);
                    }
                }
            }
        }

        public final void g(@NonNull Message message) {
            d.a.q0.a.v1.c.f.c o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, message) == null) {
                if (SwanAppMessengerService.DEBUG) {
                    Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_FOREGROUND");
                }
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (indexOf.isSwanAppProcess() && (o = e.k().o(indexOf)) != null) {
                    Object obj = message.obj;
                    if (obj instanceof Bundle) {
                        Bundle bundle = (Bundle) obj;
                        bundle.setClassLoader(a.class.getClassLoader());
                        String string = bundle.getString("app_id");
                        int i2 = bundle.getInt("task_id");
                        e.k().g(string, o);
                        d.a.q0.a.c1.a.I().b(string, true);
                        v0.h(true, i2);
                        e.k().v(indexOf);
                        if (SwanAppMessengerService.DEBUG) {
                            e k = e.k();
                            k.u("onAppForegroud => " + o.toString());
                        }
                    }
                }
            }
        }

        public final void h(@NonNull Message message) {
            d.a.q0.a.v1.c.f.c o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, message) == null) {
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (indexOf.isSwanAppProcess() && (o = e.k().o(indexOf)) != null) {
                    Object obj = message.obj;
                    if (obj instanceof Bundle) {
                        Bundle bundle = (Bundle) obj;
                        bundle.setClassLoader(a.class.getClassLoader());
                        o.K(bundle);
                        if (SwanAppMessengerService.DEBUG) {
                            e k = e.k();
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
                int i2 = message.what;
                if (i2 == 1) {
                    d(message);
                } else if (i2 == 2) {
                    e(message);
                } else if (i2 == 3) {
                    if (SwanAppMessengerService.DEBUG) {
                        Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_GET_DATA msg: " + message);
                    }
                    SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                    e.k().o(indexOf).Z();
                    d.a.q0.a.v1.c.a e2 = d.a.q0.a.v1.c.a.e();
                    c cVar = new c(101);
                    cVar.b(indexOf);
                    e2.h(cVar);
                } else if (i2 == 4) {
                    if (SwanAppMessengerService.DEBUG) {
                        Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_RESPONSE msg: " + message);
                    }
                } else if (i2 == 5) {
                    if (SwanAppMessengerService.DEBUG) {
                        Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_NIGHT_MODE_CHANGED");
                    }
                    d.a.q0.a.c1.a.H().c(d.a.q0.a.c1.a.H().a());
                    d.a.q0.a.v1.c.a e3 = d.a.q0.a.v1.c.a.e();
                    c cVar2 = new c(102);
                    cVar2.e(message.arg1);
                    e3.h(cVar2);
                } else if (i2 == 123) {
                    d.a.q0.a.v1.c.a e4 = d.a.q0.a.v1.c.a.e();
                    c cVar3 = new c(message);
                    cVar3.e(message.arg1);
                    e4.h(cVar3);
                } else if (i2 == 124) {
                    d.a.q0.a.v2.c.q(message);
                    d.a.q0.a.v1.c.a e5 = d.a.q0.a.v1.c.a.e();
                    c cVar4 = new c(message);
                    cVar4.e(message.arg1);
                    e5.h(cVar4);
                } else if (i2 != 129) {
                    switch (i2) {
                        case 7:
                            if (SwanAppMessengerService.DEBUG) {
                                Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_WX_PAY_APPID");
                            }
                            Bundle bundle = (Bundle) message.obj;
                            if (bundle != null) {
                                d.a.q0.a.q1.a.b().f50096a = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                                d.a.q0.a.q1.a.b().f50097b = bundle.getString("frameType");
                                d.a.q0.a.q1.a.b().f50098c = bundle.getString("params");
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
                            d.a.q0.a.n0.d d2 = f.c().d();
                            if (d2 != null) {
                                String str = swanAppDeleteInfo.mAppId;
                                d.a.q0.a.n0.l.c l = d.a.q0.a.n0.l.c.l();
                                l.i(swanAppDeleteInfo.getPurgerScenes());
                                d2.e(str, z, l.k());
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
                                d.a.q0.a.a2.d.g().w("event_messenger_call_in", (Bundle) message.obj);
                                return;
                            }
                            return;
                        case 12:
                            d.a.q0.a.v1.c.d.a.a(message);
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
                                d.a.q0.a.p0.j.a.a((Bundle) obj);
                                return;
                            }
                            return;
                        case 19:
                            d.a.f0.d.b((Bundle) message.obj);
                            return;
                        case 20:
                            e.k().s(message);
                            return;
                        case 21:
                            d.a.q0.a.v1.c.d.a.c(message);
                            return;
                        case 22:
                            b(message);
                            return;
                        case 23:
                            d.a.q0.a.r1.r.b.b().c(message);
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
            d.a.q0.a.v1.c.f.c o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, message) == null) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    ((Bundle) obj).setClassLoader(a.class.getClassLoader());
                    SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                    if (indexOf.isSwanAppProcess() && (o = e.k().o(indexOf)) != null) {
                        o.P();
                        if (SwanAppMessengerService.DEBUG) {
                            e k = e.k();
                            k.u("onPreloaded => " + o.toString());
                        }
                    }
                }
            }
        }

        public final void j(@NonNull Message message) {
            d.a.q0.a.v1.c.f.c o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, message) == null) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    ((Bundle) obj).setClassLoader(a.class.getClassLoader());
                    SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                    if (indexOf.isSwanAppProcess() && (o = e.k().o(indexOf)) != null) {
                        o.S();
                        if (SwanAppMessengerService.DEBUG) {
                            e k = e.k();
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
                    d.a.q0.a.c1.a.h().a(string, string2);
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
        DEBUG = k.f49133a;
    }

    public SwanAppMessengerService() {
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

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, null, i2, str)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_data", str);
            Message obtain = Message.obtain(null, i2, bundle);
            d.a.q0.a.v1.c.a e2 = d.a.q0.a.v1.c.a.e();
            c cVar = new c(obtain);
            cVar.d();
            e2.h(cVar);
            return true;
        }
        return invokeIL.booleanValue;
    }

    public static void updatePkg(@NonNull Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, message) == null) && (message.obj instanceof Bundle)) {
            if (DEBUG) {
                Log.i(TAG, "updatePkg: swanAsyncUpdate -> 收到异步升级消息");
            }
            d.a.q0.a.f1.h.a.a((Bundle) message.obj);
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
            return e.k().f51271e.asBinder();
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
            this.launchHelper = new v0(getApplication());
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            v0 v0Var = this.launchHelper;
            if (v0Var != null) {
                v0Var.i();
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, intent, i2, i3)) == null) {
            String action = (intent == null || TextUtils.isEmpty(intent.getAction())) ? ACTION_DEFAULT : intent.getAction();
            char c2 = 65535;
            int hashCode = action.hashCode();
            if (hashCode != -74985808) {
                if (hashCode == -5111142 && action.equals(ACTION_DEFAULT)) {
                    c2 = 1;
                }
            } else if (action.equals(ACTION_PRELOAD_NEXT)) {
                c2 = 0;
            }
            if (c2 == 0) {
                if (TextUtils.isEmpty(intent.getStringExtra("bundle_key_preload_preload_scene"))) {
                    intent.putExtra("bundle_key_preload_preload_scene", "0");
                }
                d.a.q0.a.v1.c.f.b.l(this, intent.getExtras());
            }
            return super.onStartCommand(intent, i2, i3);
        }
        return invokeLII.intValue;
    }

    public void sendDelegationMessage(@Nullable int i2, @Nullable Bundle bundle, @NonNull Class<? extends d.a.q0.a.v1.a.a.a> cls, @Nullable d.a.q0.a.v1.a.b.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), bundle, cls, cVar}) == null) {
            if (DEBUG) {
                Log.d(TAG, "sendMessageToClient: delegation: " + cls.getName());
            }
            Message obtain = Message.obtain((Handler) null, 125);
            obtain.replyTo = e.k().f51270d;
            Bundle bundle2 = new Bundle();
            bundle2.putString("ai_apps_delegation_name", cls.getName());
            if (cVar != null) {
                bundle2.putString("ai_apps_observer_id", cVar.b());
                d.a.q0.a.v1.a.b.b.a.b().e(cVar);
            }
            if (bundle != null) {
                bundle2.putBundle("ai_apps_data", bundle);
            }
            obtain.obj = bundle2;
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(i2);
            d.a.q0.a.v1.c.a e2 = d.a.q0.a.v1.c.a.e();
            c cVar2 = new c(obtain);
            cVar2.b(indexOf);
            e2.h(cVar2);
        }
    }

    @Deprecated
    public boolean sendMessageToClient(int i2, int i3, Bundle bundle) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048581, this, i2, i3, bundle)) == null) ? sendMessageToClient(SwanAppProcessInfo.indexOf(i2), i3, bundle) : invokeIIL.booleanValue;
    }

    @Deprecated
    public boolean sendMessageToClient(SwanAppProcessInfo swanAppProcessInfo, int i2, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048582, this, swanAppProcessInfo, i2, bundle)) == null) {
            d.a.q0.a.v1.c.a e2 = d.a.q0.a.v1.c.a.e();
            c cVar = new c(i2, bundle);
            cVar.b(swanAppProcessInfo);
            e2.h(cVar);
            return true;
        }
        return invokeLIL.booleanValue;
    }

    @Deprecated
    public boolean sendMessageToClient(d.a.q0.a.v1.c.f.c cVar, int i2, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048583, this, cVar, i2, bundle)) == null) {
            d.a.q0.a.v1.c.a e2 = d.a.q0.a.v1.c.a.e();
            c cVar2 = new c(i2, bundle);
            cVar2.b(cVar.f51259f);
            e2.h(cVar2);
            return true;
        }
        return invokeLIL.booleanValue;
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            Bundle bundle = new Bundle();
            bundle.putLong("ai_apps_data", j);
            Message obtain = Message.obtain(null, i2, bundle);
            d.a.q0.a.v1.c.a e2 = d.a.q0.a.v1.c.a.e();
            c cVar = new c(obtain);
            cVar.d();
            e2.h(cVar);
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
