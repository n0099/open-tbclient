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
import com.baidu.tieba.am1;
import com.baidu.tieba.be2;
import com.baidu.tieba.dy2;
import com.baidu.tieba.f23;
import com.baidu.tieba.gh2;
import com.baidu.tieba.h23;
import com.baidu.tieba.i23;
import com.baidu.tieba.ia1;
import com.baidu.tieba.k03;
import com.baidu.tieba.kf2;
import com.baidu.tieba.n23;
import com.baidu.tieba.o23;
import com.baidu.tieba.o53;
import com.baidu.tieba.p13;
import com.baidu.tieba.p22;
import com.baidu.tieba.pj3;
import com.baidu.tieba.q23;
import com.baidu.tieba.t13;
import com.baidu.tieba.ue3;
import com.baidu.tieba.vh3;
import com.baidu.tieba.w13;
import com.baidu.tieba.wo2;
import com.baidu.tieba.wq2;
import com.baidu.tieba.yf2;
import com.baidu.tieba.yx2;
import com.baidu.tieba.zd2;
import com.baidu.tieba.ze3;
/* loaded from: classes4.dex */
public final class SwanAppMessengerService extends Service {
    public static final String ACTION_DEFAULT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_DEFAULT";
    public static final String ACTION_PREFIX = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_";
    public static final String ACTION_PRELOAD_NEXT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_PRELOAD_NEXT";
    public static final boolean DEBUG = am1.a;
    public static final String SEND_BROADCAST_INNER_ACTION = "innerAction";
    public static final String TAG = "SwanAppMessengerService";
    @Nullable
    public pj3 launchHelper;

    /* loaded from: classes4.dex */
    public static class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }

        public final void a() {
            p22.i(SwanAppMessengerService.TAG, "resetCore: service handleCoreReset");
            ze3.b(0);
            yf2.f(0).f().c();
            f23 e = f23.e();
            h23 h23Var = new h23(129);
            h23Var.d();
            e.h(h23Var);
            ue3.n(0);
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
            wo2.w().a(AppRuntime.getAppContext(), bundle.getInt("key_text_size"));
            f23 e = f23.e();
            h23 h23Var = new h23(127);
            h23Var.e(message.arg1);
            e.h(h23Var);
        }

        public final void f(@NonNull Message message) {
            if (SwanAppMessengerService.DEBUG) {
                Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_BACKGROUND");
            }
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (!indexOf.isSwanAppProcess() || q23.k().o(indexOf) == null) {
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
            wo2.N().b(string, false);
            pj3.h(false, i);
        }

        public final void h(@NonNull Message message) {
            o23 o;
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (!indexOf.isSwanAppProcess() || (o = q23.k().o(indexOf)) == null) {
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
                q23 k = q23.k();
                k.u("onConnAck => " + o.toString());
            }
        }

        public final void i(@NonNull Message message) {
            o23 o;
            Object obj = message.obj;
            if (!(obj instanceof Bundle)) {
                return;
            }
            ((Bundle) obj).setClassLoader(a.class.getClassLoader());
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (!indexOf.isSwanAppProcess() || (o = q23.k().o(indexOf)) == null) {
                return;
            }
            o.b0();
            if (SwanAppMessengerService.DEBUG) {
                q23 k = q23.k();
                k.u("onPreloaded => " + o.toString());
            }
        }

        public final void j(@NonNull Message message) {
            o23 o;
            Object obj = message.obj;
            if (!(obj instanceof Bundle)) {
                return;
            }
            ((Bundle) obj).setClassLoader(a.class.getClassLoader());
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (!indexOf.isSwanAppProcess() || (o = q23.k().o(indexOf)) == null) {
                return;
            }
            o.e0();
            if (SwanAppMessengerService.DEBUG) {
                q23 k = q23.k();
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
            yx2.e().i(new SwanAppPageInfo(bundle.getString(PageInfo.KEY)));
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
            q23 k = q23.k();
            o23 n = k.n(i);
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
            o23 n = q23.k().n(message.arg1);
            if (n == null) {
                return;
            }
            String string = bundle.getString("ai_apps_id", "");
            if (TextUtils.isEmpty(string)) {
                string = n.getAppId();
            }
            f23.e().b(string);
            n.Y();
            if (SwanAppMessengerService.DEBUG) {
                q23 k = q23.k();
                k.u("onUnloaded => " + n.toString());
            }
        }

        public final void g(@NonNull Message message) {
            o23 o;
            if (SwanAppMessengerService.DEBUG) {
                Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_FOREGROUND");
            }
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (!indexOf.isSwanAppProcess() || (o = q23.k().o(indexOf)) == null) {
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
            q23.k().g(string, o);
            wo2.N().b(string, true);
            pj3.h(true, i);
            q23.k().v(indexOf);
            if (SwanAppMessengerService.DEBUG) {
                q23 k = q23.k();
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
                                                        dy2.b().a = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                                                        dy2.b().b = bundle.getString("frameType");
                                                        dy2.b().c = bundle.getString("params");
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
                                                        zd2 d = be2.c().d();
                                                        if (d != null) {
                                                            String str = swanAppDeleteInfo.mAppId;
                                                            kf2 l = kf2.l();
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
                                                        o53.K().v("event_messenger_call_in", (Bundle) message.obj);
                                                        return;
                                                    }
                                                    return;
                                                case 12:
                                                    i23.a(message);
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
                                                        gh2.a((Bundle) obj);
                                                        return;
                                                    }
                                                    return;
                                                case 19:
                                                    ia1.b((Bundle) message.obj);
                                                    return;
                                                case 20:
                                                    q23.k().s(message);
                                                    return;
                                                case 21:
                                                    i23.c(message);
                                                    return;
                                                case 22:
                                                    b(message);
                                                    return;
                                                case 23:
                                                    k03.b().c(message);
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
                                    vh3.q(message);
                                    f23 e = f23.e();
                                    h23 h23Var = new h23(message);
                                    h23Var.e(message.arg1);
                                    e.h(h23Var);
                                    return;
                                }
                                f23 e2 = f23.e();
                                h23 h23Var2 = new h23(message);
                                h23Var2.e(message.arg1);
                                e2.h(h23Var2);
                                return;
                            }
                            if (SwanAppMessengerService.DEBUG) {
                                Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_NIGHT_MODE_CHANGED");
                            }
                            wo2.M().c(wo2.M().a());
                            f23 e3 = f23.e();
                            h23 h23Var3 = new h23(102);
                            h23Var3.e(message.arg1);
                            e3.h(h23Var3);
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
                    q23.k().o(indexOf).l0();
                    f23 e4 = f23.e();
                    h23 h23Var4 = new h23(101);
                    h23Var4.b(indexOf);
                    e4.h(h23Var4);
                    return;
                }
                e(message);
                return;
            }
            d(message);
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
                wo2.i().a(string, string2);
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (ProcessUtils.isMainProcess() && getApplication() != null) {
            this.launchHelper = new pj3(getApplication());
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        pj3 pj3Var = this.launchHelper;
        if (pj3Var != null) {
            pj3Var.i();
        }
        super.onDestroy();
    }

    public static void updatePkg(@NonNull Message message) {
        if (message.obj instanceof Bundle) {
            if (DEBUG) {
                Log.i(TAG, "updatePkg: swanAsyncUpdate -> 收到异步升级消息");
            }
            wq2.a((Bundle) message.obj);
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
        return q23.k().e.asBinder();
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("ai_apps_data", j);
        Message obtain = Message.obtain(null, i, bundle);
        f23 e = f23.e();
        h23 h23Var = new h23(obtain);
        h23Var.d();
        e.h(h23Var);
        return true;
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("ai_apps_data", str);
        Message obtain = Message.obtain(null, i, bundle);
        f23 e = f23.e();
        h23 h23Var = new h23(obtain);
        h23Var.d();
        e.h(h23Var);
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
            n23.l(this, intent.getExtras());
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void sendDelegationMessage(@Nullable int i, @Nullable Bundle bundle, @NonNull Class<? extends p13> cls, @Nullable w13 w13Var) {
        if (DEBUG) {
            Log.d(TAG, "sendMessageToClient: delegation: " + cls.getName());
        }
        Message obtain = Message.obtain((Handler) null, 125);
        obtain.replyTo = q23.k().d;
        Bundle bundle2 = new Bundle();
        bundle2.putString("ai_apps_delegation_name", cls.getName());
        if (w13Var != null) {
            bundle2.putString("ai_apps_observer_id", w13Var.b());
            t13.b().e(w13Var);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        obtain.obj = bundle2;
        SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(i);
        f23 e = f23.e();
        h23 h23Var = new h23(obtain);
        h23Var.b(indexOf);
        e.h(h23Var);
    }

    @Deprecated
    public boolean sendMessageToClient(int i, int i2, Bundle bundle) {
        return sendMessageToClient(SwanAppProcessInfo.indexOf(i), i2, bundle);
    }

    @Deprecated
    public boolean sendMessageToClient(SwanAppProcessInfo swanAppProcessInfo, int i, Bundle bundle) {
        f23 e = f23.e();
        h23 h23Var = new h23(i, bundle);
        h23Var.b(swanAppProcessInfo);
        e.h(h23Var);
        return true;
    }

    @Deprecated
    public boolean sendMessageToClient(o23 o23Var, int i, Bundle bundle) {
        f23 e = f23.e();
        h23 h23Var = new h23(i, bundle);
        h23Var.b(o23Var.b);
        e.h(h23Var);
        return true;
    }
}
