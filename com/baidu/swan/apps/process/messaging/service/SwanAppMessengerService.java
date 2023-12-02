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
import com.baidu.tieba.a33;
import com.baidu.tieba.bi2;
import com.baidu.tieba.c33;
import com.baidu.tieba.d33;
import com.baidu.tieba.db1;
import com.baidu.tieba.f13;
import com.baidu.tieba.fg2;
import com.baidu.tieba.i33;
import com.baidu.tieba.j33;
import com.baidu.tieba.j63;
import com.baidu.tieba.k23;
import com.baidu.tieba.k32;
import com.baidu.tieba.kk3;
import com.baidu.tieba.l33;
import com.baidu.tieba.o23;
import com.baidu.tieba.pf3;
import com.baidu.tieba.qi3;
import com.baidu.tieba.r23;
import com.baidu.tieba.rp2;
import com.baidu.tieba.rr2;
import com.baidu.tieba.tg2;
import com.baidu.tieba.ty2;
import com.baidu.tieba.ue2;
import com.baidu.tieba.uf3;
import com.baidu.tieba.vm1;
import com.baidu.tieba.we2;
import com.baidu.tieba.yy2;
/* loaded from: classes4.dex */
public final class SwanAppMessengerService extends Service {
    public static final String ACTION_DEFAULT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_DEFAULT";
    public static final String ACTION_PREFIX = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_";
    public static final String ACTION_PRELOAD_NEXT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_PRELOAD_NEXT";
    public static final boolean DEBUG = vm1.a;
    public static final String SEND_BROADCAST_INNER_ACTION = "innerAction";
    public static final String TAG = "SwanAppMessengerService";
    @Nullable
    public kk3 launchHelper;

    /* loaded from: classes4.dex */
    public static class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }

        public final void a() {
            k32.i(SwanAppMessengerService.TAG, "resetCore: service handleCoreReset");
            uf3.b(0);
            tg2.f(0).f().c();
            a33 e = a33.e();
            c33 c33Var = new c33(129);
            c33Var.d();
            e.h(c33Var);
            pf3.n(0);
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
            rp2.w().a(AppRuntime.getAppContext(), bundle.getInt("key_text_size"));
            a33 e = a33.e();
            c33 c33Var = new c33(127);
            c33Var.e(message.arg1);
            e.h(c33Var);
        }

        public final void f(@NonNull Message message) {
            if (SwanAppMessengerService.DEBUG) {
                Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_BACKGROUND");
            }
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (!indexOf.isSwanAppProcess() || l33.k().o(indexOf) == null) {
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
            rp2.N().b(string, false);
            kk3.h(false, i);
        }

        public final void h(@NonNull Message message) {
            j33 o;
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (!indexOf.isSwanAppProcess() || (o = l33.k().o(indexOf)) == null) {
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
                l33 k = l33.k();
                k.u("onConnAck => " + o.toString());
            }
        }

        public final void i(@NonNull Message message) {
            j33 o;
            Object obj = message.obj;
            if (!(obj instanceof Bundle)) {
                return;
            }
            ((Bundle) obj).setClassLoader(a.class.getClassLoader());
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (!indexOf.isSwanAppProcess() || (o = l33.k().o(indexOf)) == null) {
                return;
            }
            o.b0();
            if (SwanAppMessengerService.DEBUG) {
                l33 k = l33.k();
                k.u("onPreloaded => " + o.toString());
            }
        }

        public final void j(@NonNull Message message) {
            j33 o;
            Object obj = message.obj;
            if (!(obj instanceof Bundle)) {
                return;
            }
            ((Bundle) obj).setClassLoader(a.class.getClassLoader());
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (!indexOf.isSwanAppProcess() || (o = l33.k().o(indexOf)) == null) {
                return;
            }
            o.e0();
            if (SwanAppMessengerService.DEBUG) {
                l33 k = l33.k();
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
            ty2.e().i(new SwanAppPageInfo(bundle.getString(PageInfo.KEY)));
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
            l33 k = l33.k();
            j33 n = k.n(i);
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
            j33 n = l33.k().n(message.arg1);
            if (n == null) {
                return;
            }
            String string = bundle.getString("ai_apps_id", "");
            if (TextUtils.isEmpty(string)) {
                string = n.getAppId();
            }
            a33.e().b(string);
            n.Y();
            if (SwanAppMessengerService.DEBUG) {
                l33 k = l33.k();
                k.u("onUnloaded => " + n.toString());
            }
        }

        public final void g(@NonNull Message message) {
            j33 o;
            if (SwanAppMessengerService.DEBUG) {
                Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_FOREGROUND");
            }
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (!indexOf.isSwanAppProcess() || (o = l33.k().o(indexOf)) == null) {
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
            l33.k().g(string, o);
            rp2.N().b(string, true);
            kk3.h(true, i);
            l33.k().v(indexOf);
            if (SwanAppMessengerService.DEBUG) {
                l33 k = l33.k();
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
                                                        yy2.b().a = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                                                        yy2.b().b = bundle.getString("frameType");
                                                        yy2.b().c = bundle.getString("params");
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
                                                        ue2 d = we2.c().d();
                                                        if (d != null) {
                                                            String str = swanAppDeleteInfo.mAppId;
                                                            fg2 l = fg2.l();
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
                                                        j63.K().v("event_messenger_call_in", (Bundle) message.obj);
                                                        return;
                                                    }
                                                    return;
                                                case 12:
                                                    d33.a(message);
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
                                                        bi2.a((Bundle) obj);
                                                        return;
                                                    }
                                                    return;
                                                case 19:
                                                    db1.b((Bundle) message.obj);
                                                    return;
                                                case 20:
                                                    l33.k().s(message);
                                                    return;
                                                case 21:
                                                    d33.c(message);
                                                    return;
                                                case 22:
                                                    b(message);
                                                    return;
                                                case 23:
                                                    f13.b().c(message);
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
                                    qi3.q(message);
                                    a33 e = a33.e();
                                    c33 c33Var = new c33(message);
                                    c33Var.e(message.arg1);
                                    e.h(c33Var);
                                    return;
                                }
                                a33 e2 = a33.e();
                                c33 c33Var2 = new c33(message);
                                c33Var2.e(message.arg1);
                                e2.h(c33Var2);
                                return;
                            }
                            if (SwanAppMessengerService.DEBUG) {
                                Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_NIGHT_MODE_CHANGED");
                            }
                            rp2.M().c(rp2.M().a());
                            a33 e3 = a33.e();
                            c33 c33Var3 = new c33(102);
                            c33Var3.e(message.arg1);
                            e3.h(c33Var3);
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
                    l33.k().o(indexOf).l0();
                    a33 e4 = a33.e();
                    c33 c33Var4 = new c33(101);
                    c33Var4.b(indexOf);
                    e4.h(c33Var4);
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
                rp2.i().a(string, string2);
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (ProcessUtils.isMainProcess() && getApplication() != null) {
            this.launchHelper = new kk3(getApplication());
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        kk3 kk3Var = this.launchHelper;
        if (kk3Var != null) {
            kk3Var.i();
        }
        super.onDestroy();
    }

    public static void updatePkg(@NonNull Message message) {
        if (message.obj instanceof Bundle) {
            if (DEBUG) {
                Log.i(TAG, "updatePkg: swanAsyncUpdate -> 收到异步升级消息");
            }
            rr2.a((Bundle) message.obj);
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
        return l33.k().e.asBinder();
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("ai_apps_data", j);
        Message obtain = Message.obtain(null, i, bundle);
        a33 e = a33.e();
        c33 c33Var = new c33(obtain);
        c33Var.d();
        e.h(c33Var);
        return true;
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("ai_apps_data", str);
        Message obtain = Message.obtain(null, i, bundle);
        a33 e = a33.e();
        c33 c33Var = new c33(obtain);
        c33Var.d();
        e.h(c33Var);
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
            i33.l(this, intent.getExtras());
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void sendDelegationMessage(@Nullable int i, @Nullable Bundle bundle, @NonNull Class<? extends k23> cls, @Nullable r23 r23Var) {
        if (DEBUG) {
            Log.d(TAG, "sendMessageToClient: delegation: " + cls.getName());
        }
        Message obtain = Message.obtain((Handler) null, 125);
        obtain.replyTo = l33.k().d;
        Bundle bundle2 = new Bundle();
        bundle2.putString("ai_apps_delegation_name", cls.getName());
        if (r23Var != null) {
            bundle2.putString("ai_apps_observer_id", r23Var.b());
            o23.b().e(r23Var);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        obtain.obj = bundle2;
        SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(i);
        a33 e = a33.e();
        c33 c33Var = new c33(obtain);
        c33Var.b(indexOf);
        e.h(c33Var);
    }

    @Deprecated
    public boolean sendMessageToClient(int i, int i2, Bundle bundle) {
        return sendMessageToClient(SwanAppProcessInfo.indexOf(i), i2, bundle);
    }

    @Deprecated
    public boolean sendMessageToClient(SwanAppProcessInfo swanAppProcessInfo, int i, Bundle bundle) {
        a33 e = a33.e();
        c33 c33Var = new c33(i, bundle);
        c33Var.b(swanAppProcessInfo);
        e.h(c33Var);
        return true;
    }

    @Deprecated
    public boolean sendMessageToClient(j33 j33Var, int i, Bundle bundle) {
        a33 e = a33.e();
        c33 c33Var = new c33(i, bundle);
        c33Var.b(j33Var.b);
        e.h(c33Var);
        return true;
    }
}
