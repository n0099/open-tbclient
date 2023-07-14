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
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.page.model.SwanAppPageInfo;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.al3;
import com.baidu.tieba.bo3;
import com.baidu.tieba.c83;
import com.baidu.tieba.cv2;
import com.baidu.tieba.cx2;
import com.baidu.tieba.e43;
import com.baidu.tieba.em2;
import com.baidu.tieba.fk2;
import com.baidu.tieba.fl3;
import com.baidu.tieba.fs1;
import com.baidu.tieba.hk2;
import com.baidu.tieba.j43;
import com.baidu.tieba.l83;
import com.baidu.tieba.mn2;
import com.baidu.tieba.n83;
import com.baidu.tieba.ng1;
import com.baidu.tieba.o83;
import com.baidu.tieba.q63;
import com.baidu.tieba.ql2;
import com.baidu.tieba.t83;
import com.baidu.tieba.u83;
import com.baidu.tieba.ub3;
import com.baidu.tieba.v73;
import com.baidu.tieba.v82;
import com.baidu.tieba.vp3;
import com.baidu.tieba.w83;
import com.baidu.tieba.z73;
/* loaded from: classes4.dex */
public final class SwanAppMessengerService extends Service {
    public static final String ACTION_DEFAULT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_DEFAULT";
    public static final String ACTION_PREFIX = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_";
    public static final String ACTION_PRELOAD_NEXT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_PRELOAD_NEXT";
    public static final boolean DEBUG = fs1.a;
    public static final String SEND_BROADCAST_INNER_ACTION = "innerAction";
    public static final String TAG = "SwanAppMessengerService";
    @Nullable
    public vp3 launchHelper;

    /* loaded from: classes4.dex */
    public static class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }

        public final void a() {
            v82.i(SwanAppMessengerService.TAG, "resetCore: service handleCoreReset");
            fl3.b(0);
            em2.f(0).f().c();
            l83 e = l83.e();
            n83 n83Var = new n83(129);
            n83Var.d();
            e.h(n83Var);
            al3.n(0);
        }

        public final void b(Message message) {
            if (!SwanAppProcessInfo.indexOf(message.arg1).isSwanAppProcess()) {
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof Bundle)) {
                return;
            }
            Bundle bundle = (Bundle) obj;
            bundle.setClassLoader(a.class.getClassLoader());
            cv2.w().a(AppRuntime.getAppContext(), bundle.getInt("key_text_size"));
            l83 e = l83.e();
            n83 n83Var = new n83(127);
            n83Var.e(message.arg1);
            e.h(n83Var);
        }

        public final void f(@NonNull Message message) {
            if (SwanAppMessengerService.DEBUG) {
                Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_BACKGROUND");
            }
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (!indexOf.isSwanAppProcess() || w83.k().o(indexOf) == null) {
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
            cv2.N().b(string, false);
            vp3.h(false, i);
        }

        public final void h(@NonNull Message message) {
            u83 o;
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (!indexOf.isSwanAppProcess() || (o = w83.k().o(indexOf)) == null) {
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
                w83 k = w83.k();
                k.u("onConnAck => " + o.toString());
            }
        }

        public final void i(@NonNull Message message) {
            u83 o;
            Object obj = message.obj;
            if (!(obj instanceof Bundle)) {
                return;
            }
            ((Bundle) obj).setClassLoader(a.class.getClassLoader());
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (!indexOf.isSwanAppProcess() || (o = w83.k().o(indexOf)) == null) {
                return;
            }
            o.b0();
            if (SwanAppMessengerService.DEBUG) {
                w83 k = w83.k();
                k.u("onPreloaded => " + o.toString());
            }
        }

        public final void j(@NonNull Message message) {
            u83 o;
            Object obj = message.obj;
            if (!(obj instanceof Bundle)) {
                return;
            }
            ((Bundle) obj).setClassLoader(a.class.getClassLoader());
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (!indexOf.isSwanAppProcess() || (o = w83.k().o(indexOf)) == null) {
                return;
            }
            o.e0();
            if (SwanAppMessengerService.DEBUG) {
                w83 k = w83.k();
                k.u("onRePreloaded => " + o.toString());
            }
        }

        public final void c(Message message) {
            if (!SwanAppProcessInfo.indexOf(message.arg1).isSwanAppProcess()) {
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof Bundle)) {
                return;
            }
            Bundle bundle = (Bundle) obj;
            bundle.setClassLoader(a.class.getClassLoader());
            e43.e().i(new SwanAppPageInfo(bundle.getString(PageInfo.KEY)));
        }

        public final void k(@NonNull Message message) {
            Object obj = message.obj;
            if (!(obj instanceof Bundle)) {
                return;
            }
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString(SwanAppMessengerService.SEND_BROADCAST_INNER_ACTION);
            String string2 = bundle.getString("ai_apps_data");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                cv2.i().a(string, string2);
            }
        }

        public final void d(@NonNull Message message) {
            boolean z;
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
            w83 k = w83.k();
            u83 n = k.n(i);
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

        public final void e(@NonNull Message message) {
            if (SwanAppMessengerService.DEBUG) {
                Log.d(SwanAppMessengerService.TAG, "unregister client. arg1: " + message.arg1);
            }
            Object obj = message.obj;
            if (!(obj instanceof Bundle)) {
                return;
            }
            Bundle bundle = (Bundle) obj;
            bundle.setClassLoader(a.class.getClassLoader());
            u83 n = w83.k().n(message.arg1);
            if (n == null) {
                return;
            }
            String string = bundle.getString("ai_apps_id", "");
            if (TextUtils.isEmpty(string)) {
                string = n.getAppId();
            }
            l83.e().b(string);
            n.Y();
            if (SwanAppMessengerService.DEBUG) {
                w83 k = w83.k();
                k.u("onUnloaded => " + n.toString());
            }
        }

        public final void g(@NonNull Message message) {
            u83 o;
            if (SwanAppMessengerService.DEBUG) {
                Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_FOREGROUND");
            }
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (!indexOf.isSwanAppProcess() || (o = w83.k().o(indexOf)) == null) {
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
            w83.k().g(string, o);
            cv2.N().b(string, true);
            vp3.h(true, i);
            w83.k().v(indexOf);
            if (SwanAppMessengerService.DEBUG) {
                w83 k = w83.k();
                k.u("onAppForegroud => " + o.toString());
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SwanAppDeleteInfo swanAppDeleteInfo;
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
                                                        j43.b().a = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                                                        j43.b().b = bundle.getString("frameType");
                                                        j43.b().c = bundle.getString("params");
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
                                                        fk2 d = hk2.c().d();
                                                        if (d != null) {
                                                            String str = swanAppDeleteInfo.mAppId;
                                                            ql2 l = ql2.l();
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
                                                        ub3.K().v("event_messenger_call_in", (Bundle) message.obj);
                                                        return;
                                                    }
                                                    return;
                                                case 12:
                                                    o83.a(message);
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
                                                        mn2.a((Bundle) obj);
                                                        return;
                                                    }
                                                    return;
                                                case 19:
                                                    ng1.b((Bundle) message.obj);
                                                    return;
                                                case 20:
                                                    w83.k().s(message);
                                                    return;
                                                case 21:
                                                    o83.c(message);
                                                    return;
                                                case 22:
                                                    b(message);
                                                    return;
                                                case 23:
                                                    q63.b().c(message);
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
                                    bo3.q(message);
                                    l83 e = l83.e();
                                    n83 n83Var = new n83(message);
                                    n83Var.e(message.arg1);
                                    e.h(n83Var);
                                    return;
                                }
                                l83 e2 = l83.e();
                                n83 n83Var2 = new n83(message);
                                n83Var2.e(message.arg1);
                                e2.h(n83Var2);
                                return;
                            }
                            if (SwanAppMessengerService.DEBUG) {
                                Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_NIGHT_MODE_CHANGED");
                            }
                            cv2.M().c(cv2.M().a());
                            l83 e3 = l83.e();
                            n83 n83Var3 = new n83(102);
                            n83Var3.e(message.arg1);
                            e3.h(n83Var3);
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
                    w83.k().o(indexOf).l0();
                    l83 e4 = l83.e();
                    n83 n83Var4 = new n83(101);
                    n83Var4.b(indexOf);
                    e4.h(n83Var4);
                    return;
                }
                e(message);
                return;
            }
            d(message);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (ProcessUtils.isMainProcess() && getApplication() != null) {
            this.launchHelper = new vp3(getApplication());
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        vp3 vp3Var = this.launchHelper;
        if (vp3Var != null) {
            vp3Var.i();
        }
        super.onDestroy();
    }

    public static void updatePkg(@NonNull Message message) {
        if (message.obj instanceof Bundle) {
            if (DEBUG) {
                Log.i(TAG, "updatePkg: swanAsyncUpdate -> 收到异步升级消息");
            }
            cx2.a((Bundle) message.obj);
        }
    }

    public static void updateStateByBroadcast(Intent intent) {
        sendMessageWithDataToAllClient(116, intent.toUri(0));
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        if (DEBUG) {
            Log.d(TAG, "onBind() " + this + " pid: " + Process.myPid());
        }
        return w83.k().e.asBinder();
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("ai_apps_data", j);
        Message obtain = Message.obtain(null, i, bundle);
        l83 e = l83.e();
        n83 n83Var = new n83(obtain);
        n83Var.d();
        e.h(n83Var);
        return true;
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("ai_apps_data", str);
        Message obtain = Message.obtain(null, i, bundle);
        l83 e = l83.e();
        n83 n83Var = new n83(obtain);
        n83Var.d();
        e.h(n83Var);
        return true;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String str;
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
            t83.l(this, intent.getExtras());
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void sendDelegationMessage(@Nullable int i, @Nullable Bundle bundle, @NonNull Class<? extends v73> cls, @Nullable c83 c83Var) {
        if (DEBUG) {
            Log.d(TAG, "sendMessageToClient: delegation: " + cls.getName());
        }
        Message obtain = Message.obtain((Handler) null, 125);
        obtain.replyTo = w83.k().d;
        Bundle bundle2 = new Bundle();
        bundle2.putString("ai_apps_delegation_name", cls.getName());
        if (c83Var != null) {
            bundle2.putString("ai_apps_observer_id", c83Var.b());
            z73.b().e(c83Var);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        obtain.obj = bundle2;
        SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(i);
        l83 e = l83.e();
        n83 n83Var = new n83(obtain);
        n83Var.b(indexOf);
        e.h(n83Var);
    }

    @Deprecated
    public boolean sendMessageToClient(int i, int i2, Bundle bundle) {
        return sendMessageToClient(SwanAppProcessInfo.indexOf(i), i2, bundle);
    }

    @Deprecated
    public boolean sendMessageToClient(SwanAppProcessInfo swanAppProcessInfo, int i, Bundle bundle) {
        l83 e = l83.e();
        n83 n83Var = new n83(i, bundle);
        n83Var.b(swanAppProcessInfo);
        e.h(n83Var);
        return true;
    }

    @Deprecated
    public boolean sendMessageToClient(u83 u83Var, int i, Bundle bundle) {
        l83 e = l83.e();
        n83 n83Var = new n83(i, bundle);
        n83Var.b(u83Var.b);
        e.h(n83Var);
        return true;
    }
}
