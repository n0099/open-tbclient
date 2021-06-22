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
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.page.model.SwanAppPageInfo;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.xiaomi.mipush.sdk.Constants;
import d.a.m0.a.e0.d;
import d.a.m0.a.k;
import d.a.m0.a.n0.f;
import d.a.m0.a.p0.b;
import d.a.m0.a.v1.c.c;
import d.a.m0.a.v1.c.f.e;
import d.a.m0.a.v2.v0;
/* loaded from: classes3.dex */
public final class SwanAppMessengerService extends Service {
    public static final String ACTION_DEFAULT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_DEFAULT";
    public static final String ACTION_PREFIX = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_";
    public static final String ACTION_PRELOAD_NEXT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_PRELOAD_NEXT";
    public static final boolean DEBUG = k.f46983a;
    public static final String SEND_BROADCAST_INNER_ACTION = "innerAction";
    public static final String TAG = "SwanAppMessengerService";
    @Nullable
    public v0 launchHelper;

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }

        public final void a() {
            d.g(SwanAppMessengerService.TAG, "resetCore: service handleCoreReset");
            d.a.m0.a.m2.f.a.b(0);
            b.f(0).f().c();
            d.a.m0.a.v1.c.a e2 = d.a.m0.a.v1.c.a.e();
            c cVar = new c(129);
            cVar.d();
            e2.h(cVar);
            d.a.m0.a.m2.b.n(0);
        }

        public final void b(Message message) {
            if (SwanAppProcessInfo.indexOf(message.arg1).isSwanAppProcess()) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    bundle.setClassLoader(a.class.getClassLoader());
                    d.a.m0.a.c1.a.u().a(AppRuntime.getAppContext(), bundle.getInt(QuickPersistConfigConst.KEY_TEXT_SIZE));
                    d.a.m0.a.v1.c.a e2 = d.a.m0.a.v1.c.a.e();
                    c cVar = new c(127);
                    cVar.e(message.arg1);
                    e2.h(cVar);
                }
            }
        }

        public final void c(Message message) {
            if (SwanAppProcessInfo.indexOf(message.arg1).isSwanAppProcess()) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    bundle.setClassLoader(a.class.getClassLoader());
                    String string = bundle.getString("page_info");
                    if (d.a.m0.a.p1.a.a().f47894a != null) {
                        d.a.m0.a.p1.a.a().f47894a.onCallback(new SwanAppPageInfo(string));
                    }
                }
            }
        }

        public final void d(@NonNull Message message) {
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
            d.a.m0.a.v1.c.f.c n = k.n(i2);
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

        public final void e(@NonNull Message message) {
            if (SwanAppMessengerService.DEBUG) {
                Log.d(SwanAppMessengerService.TAG, "unregister client. arg1: " + message.arg1);
            }
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                bundle.setClassLoader(a.class.getClassLoader());
                d.a.m0.a.v1.c.f.c n = e.k().n(message.arg1);
                if (n == null) {
                    return;
                }
                String string = bundle.getString("ai_apps_id", "");
                if (TextUtils.isEmpty(string)) {
                    string = n.getAppId();
                }
                d.a.m0.a.v1.c.a.e().b(string);
                n.M();
                if (SwanAppMessengerService.DEBUG) {
                    e k = e.k();
                    k.u("onUnloaded => " + n.toString());
                }
            }
        }

        public final void f(@NonNull Message message) {
            if (SwanAppMessengerService.DEBUG) {
                Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_BACKGROUND");
            }
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && e.k().o(indexOf) != null) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    bundle.setClassLoader(a.class.getClassLoader());
                    String string = bundle.getString(Constants.APP_ID);
                    int i2 = bundle.getInt("task_id");
                    d.a.m0.a.c1.a.I().b(string, false);
                    v0.h(false, i2);
                }
            }
        }

        public final void g(@NonNull Message message) {
            d.a.m0.a.v1.c.f.c o;
            if (SwanAppMessengerService.DEBUG) {
                Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_FOREGROUND");
            }
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && (o = e.k().o(indexOf)) != null) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    bundle.setClassLoader(a.class.getClassLoader());
                    String string = bundle.getString(Constants.APP_ID);
                    int i2 = bundle.getInt("task_id");
                    e.k().g(string, o);
                    d.a.m0.a.c1.a.I().b(string, true);
                    v0.h(true, i2);
                    e.k().v(indexOf);
                    if (SwanAppMessengerService.DEBUG) {
                        e k = e.k();
                        k.u("onAppForegroud => " + o.toString());
                    }
                }
            }
        }

        public final void h(@NonNull Message message) {
            d.a.m0.a.v1.c.f.c o;
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

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SwanAppDeleteInfo swanAppDeleteInfo;
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
                d.a.m0.a.v1.c.a e2 = d.a.m0.a.v1.c.a.e();
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
                d.a.m0.a.c1.a.H().c(d.a.m0.a.c1.a.H().a());
                d.a.m0.a.v1.c.a e3 = d.a.m0.a.v1.c.a.e();
                c cVar2 = new c(102);
                cVar2.e(message.arg1);
                e3.h(cVar2);
            } else if (i2 == 123) {
                d.a.m0.a.v1.c.a e4 = d.a.m0.a.v1.c.a.e();
                c cVar3 = new c(message);
                cVar3.e(message.arg1);
                e4.h(cVar3);
            } else if (i2 == 124) {
                d.a.m0.a.v2.c.q(message);
                d.a.m0.a.v1.c.a e5 = d.a.m0.a.v1.c.a.e();
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
                            d.a.m0.a.q1.a.b().f47950a = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                            d.a.m0.a.q1.a.b().f47951b = bundle.getString("frameType");
                            d.a.m0.a.q1.a.b().f47952c = bundle.getString("params");
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
                        d.a.m0.a.n0.d d2 = f.c().d();
                        if (d2 != null) {
                            String str = swanAppDeleteInfo.mAppId;
                            d.a.m0.a.n0.l.c l = d.a.m0.a.n0.l.c.l();
                            l.i(swanAppDeleteInfo.a());
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
                            d.a.m0.a.a2.d.g().w("event_messenger_call_in", (Bundle) message.obj);
                            return;
                        }
                        return;
                    case 12:
                        d.a.m0.a.v1.c.d.a.a(message);
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
                            d.a.m0.a.p0.j.a.a((Bundle) obj);
                            return;
                        }
                        return;
                    case 19:
                        d.a.b0.d.b((Bundle) message.obj);
                        return;
                    case 20:
                        e.k().s(message);
                        return;
                    case 21:
                        d.a.m0.a.v1.c.d.a.c(message);
                        return;
                    case 22:
                        b(message);
                        return;
                    case 23:
                        d.a.m0.a.r1.r.b.b().c(message);
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

        public final void i(@NonNull Message message) {
            d.a.m0.a.v1.c.f.c o;
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

        public final void j(@NonNull Message message) {
            d.a.m0.a.v1.c.f.c o;
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

        public final void k(@NonNull Message message) {
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                String string = bundle.getString(SwanAppMessengerService.SEND_BROADCAST_INNER_ACTION);
                String string2 = bundle.getString("ai_apps_data");
                if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                    return;
                }
                d.a.m0.a.c1.a.h().a(string, string2);
            }
        }
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i2, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("ai_apps_data", str);
        Message obtain = Message.obtain(null, i2, bundle);
        d.a.m0.a.v1.c.a e2 = d.a.m0.a.v1.c.a.e();
        c cVar = new c(obtain);
        cVar.d();
        e2.h(cVar);
        return true;
    }

    public static void updatePkg(@NonNull Message message) {
        if (message.obj instanceof Bundle) {
            if (DEBUG) {
                Log.i(TAG, "updatePkg: swanAsyncUpdate -> 收到异步升级消息");
            }
            d.a.m0.a.f1.h.a.a((Bundle) message.obj);
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
        return e.k().f49125e.asBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (!ProcessUtils.isMainProcess() || getApplication() == null) {
            return;
        }
        this.launchHelper = new v0(getApplication());
    }

    @Override // android.app.Service
    public void onDestroy() {
        v0 v0Var = this.launchHelper;
        if (v0Var != null) {
            v0Var.i();
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
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
            d.a.m0.a.v1.c.f.b.l(this, intent.getExtras());
        }
        return super.onStartCommand(intent, i2, i3);
    }

    public void sendDelegationMessage(@Nullable int i2, @Nullable Bundle bundle, @NonNull Class<? extends d.a.m0.a.v1.a.a.a> cls, @Nullable d.a.m0.a.v1.a.b.c.c cVar) {
        if (DEBUG) {
            Log.d(TAG, "sendMessageToClient: delegation: " + cls.getName());
        }
        Message obtain = Message.obtain((Handler) null, 125);
        obtain.replyTo = e.k().f49124d;
        Bundle bundle2 = new Bundle();
        bundle2.putString("ai_apps_delegation_name", cls.getName());
        if (cVar != null) {
            bundle2.putString("ai_apps_observer_id", cVar.b());
            d.a.m0.a.v1.a.b.b.a.b().e(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        obtain.obj = bundle2;
        SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(i2);
        d.a.m0.a.v1.c.a e2 = d.a.m0.a.v1.c.a.e();
        c cVar2 = new c(obtain);
        cVar2.b(indexOf);
        e2.h(cVar2);
    }

    @Deprecated
    public boolean sendMessageToClient(int i2, int i3, Bundle bundle) {
        return sendMessageToClient(SwanAppProcessInfo.indexOf(i2), i3, bundle);
    }

    @Deprecated
    public boolean sendMessageToClient(SwanAppProcessInfo swanAppProcessInfo, int i2, Bundle bundle) {
        d.a.m0.a.v1.c.a e2 = d.a.m0.a.v1.c.a.e();
        c cVar = new c(i2, bundle);
        cVar.b(swanAppProcessInfo);
        e2.h(cVar);
        return true;
    }

    @Deprecated
    public boolean sendMessageToClient(d.a.m0.a.v1.c.f.c cVar, int i2, Bundle bundle) {
        d.a.m0.a.v1.c.a e2 = d.a.m0.a.v1.c.a.e();
        c cVar2 = new c(i2, bundle);
        cVar2.b(cVar.f49113f);
        e2.h(cVar2);
        return true;
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i2, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("ai_apps_data", j);
        Message obtain = Message.obtain(null, i2, bundle);
        d.a.m0.a.v1.c.a e2 = d.a.m0.a.v1.c.a.e();
        c cVar = new c(obtain);
        cVar.d();
        e2.h(cVar);
        return true;
    }
}
