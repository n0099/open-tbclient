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
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.xiaomi.mipush.sdk.Constants;
import d.b.g0.a.c0.c;
import d.b.g0.a.i2.n0;
import d.b.g0.a.k;
import d.b.g0.a.l0.b;
import d.b.g0.a.n1.c.f.e;
import d.b.g0.a.r1.d;
/* loaded from: classes3.dex */
public final class SwanAppMessengerService extends Service {
    public static final String ACTION_DEFAULT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_DEFAULT";
    public static final String ACTION_PREFIX = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_";
    public static final String ACTION_PRELOAD_NEXT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_PRELOAD_NEXT";
    public static final boolean DEBUG = k.f45050a;
    public static final String SEND_BROADCAST_INNER_ACTION = "innerAction";
    public static final String TAG = "SwanAppMessengerService";
    @Nullable
    public n0 launchHelper;

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }

        public final void a() {
            c.g(SwanAppMessengerService.TAG, "resetCore: service handleCoreReset");
            d.b.g0.a.b2.f.a.b(0);
            b.d(0).e().h(0L);
            d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
            d.b.g0.a.n1.c.c cVar = new d.b.g0.a.n1.c.c(129);
            cVar.d();
            e2.h(cVar);
            d.b.g0.a.b2.b.l(0);
        }

        public final void b(@NonNull Message message) {
            if (SwanAppMessengerService.DEBUG) {
                Log.d(SwanAppMessengerService.TAG, "handleOnActivityRegister arg1: " + message.arg1);
                Log.d(SwanAppMessengerService.TAG, "handleOnActivityRegister obj: " + message.obj);
                StringBuilder sb = new StringBuilder();
                sb.append("handleOnActivityRegister is main looper: ");
                sb.append(Thread.currentThread() == Looper.getMainLooper().getThread());
                Log.d(SwanAppMessengerService.TAG, sb.toString());
            }
            int i = message.arg1;
            e j = e.j();
            d.b.g0.a.n1.c.f.c m = j.m(i);
            if (m == null) {
                return;
            }
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                bundle.setClassLoader(a.class.getClassLoader());
                m.I(bundle);
                if (SwanAppMessengerService.DEBUG) {
                    j.t("onLoaded => " + m.toString());
                }
            }
        }

        public final void c(@NonNull Message message) {
            if (SwanAppMessengerService.DEBUG) {
                Log.d(SwanAppMessengerService.TAG, "unregister client. arg1: " + message.arg1);
            }
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                bundle.setClassLoader(a.class.getClassLoader());
                d.b.g0.a.n1.c.f.c m = e.j().m(message.arg1);
                if (m == null) {
                    return;
                }
                String string = bundle.getString("ai_apps_id", "");
                if (TextUtils.isEmpty(string)) {
                    string = m.getAppId();
                }
                d.b.g0.a.n1.c.a.e().b(string);
                m.J();
                if (SwanAppMessengerService.DEBUG) {
                    e j = e.j();
                    j.t("onUnloaded => " + m.toString());
                }
            }
        }

        public final void d(@NonNull Message message) {
            if (SwanAppMessengerService.DEBUG) {
                Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_BACKGROUND");
            }
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && e.j().n(indexOf) != null) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    bundle.setClassLoader(a.class.getClassLoader());
                    String string = bundle.getString(Constants.APP_ID);
                    int i = bundle.getInt("task_id");
                    d.b.g0.a.w0.a.A().b(string, false);
                    n0.h(false, i);
                }
            }
        }

        public final void e(@NonNull Message message) {
            d.b.g0.a.n1.c.f.c n;
            if (SwanAppMessengerService.DEBUG) {
                Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_FOREGROUND");
            }
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && (n = e.j().n(indexOf)) != null) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    bundle.setClassLoader(a.class.getClassLoader());
                    String string = bundle.getString(Constants.APP_ID);
                    int i = bundle.getInt("task_id");
                    e.j().f(string, n);
                    d.b.g0.a.w0.a.A().b(string, true);
                    n0.h(true, i);
                    e.j().u(indexOf);
                    if (SwanAppMessengerService.DEBUG) {
                        e j = e.j();
                        j.t("onAppForegroud => " + n.toString());
                    }
                }
            }
        }

        public final void f(@NonNull Message message) {
            d.b.g0.a.n1.c.f.c n;
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && (n = e.j().n(indexOf)) != null) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    bundle.setClassLoader(a.class.getClassLoader());
                    n.H(bundle);
                    if (SwanAppMessengerService.DEBUG) {
                        e j = e.j();
                        j.t("onConnAck => " + n.toString());
                    }
                }
            }
        }

        public final void g(@NonNull Message message) {
            d.b.g0.a.n1.c.f.c n;
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                ((Bundle) obj).setClassLoader(a.class.getClassLoader());
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (indexOf.isSwanAppProcess() && (n = e.j().n(indexOf)) != null) {
                    n.L();
                    if (SwanAppMessengerService.DEBUG) {
                        e j = e.j();
                        j.t("onPreloaded => " + n.toString());
                    }
                }
            }
        }

        public final void h(@NonNull Message message) {
            d.b.g0.a.n1.c.f.c n;
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                ((Bundle) obj).setClassLoader(a.class.getClassLoader());
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (indexOf.isSwanAppProcess() && (n = e.j().n(indexOf)) != null) {
                    n.O();
                    if (SwanAppMessengerService.DEBUG) {
                        e j = e.j();
                        j.t("onRePreloaded => " + n.toString());
                    }
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SwanAppDeleteInfo swanAppDeleteInfo;
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            e.j().n(indexOf).U();
            int i = message.what;
            if (i == 1) {
                b(message);
            } else if (i == 2) {
                c(message);
            } else if (i == 3) {
                if (SwanAppMessengerService.DEBUG) {
                    Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_GET_DATA msg: " + message);
                }
                d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
                d.b.g0.a.n1.c.c cVar = new d.b.g0.a.n1.c.c(101);
                cVar.b(indexOf);
                e2.h(cVar);
            } else if (i == 4) {
                if (SwanAppMessengerService.DEBUG) {
                    Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_RESPONSE msg: " + message);
                }
            } else if (i == 5) {
                if (SwanAppMessengerService.DEBUG) {
                    Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_NIGHT_MODE_CHANGED");
                }
                d.b.g0.a.w0.a.z().c(d.b.g0.a.w0.a.z().a());
                d.b.g0.a.n1.c.a e3 = d.b.g0.a.n1.c.a.e();
                d.b.g0.a.n1.c.c cVar2 = new d.b.g0.a.n1.c.c(102);
                cVar2.e(message.arg1);
                e3.h(cVar2);
            } else if (i == 123) {
                d.b.g0.a.n1.c.a e4 = d.b.g0.a.n1.c.a.e();
                d.b.g0.a.n1.c.c cVar3 = new d.b.g0.a.n1.c.c(message);
                cVar3.e(message.arg1);
                e4.h(cVar3);
            } else if (i == 124) {
                d.b.g0.a.i2.b.q(message);
                d.b.g0.a.n1.c.a e5 = d.b.g0.a.n1.c.a.e();
                d.b.g0.a.n1.c.c cVar4 = new d.b.g0.a.n1.c.c(message);
                cVar4.e(message.arg1);
                e5.h(cVar4);
            } else if (i != 129) {
                switch (i) {
                    case 7:
                        if (SwanAppMessengerService.DEBUG) {
                            Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_WX_PAY_APPID");
                        }
                        Bundle bundle = (Bundle) message.obj;
                        if (bundle != null) {
                            d.b.g0.a.i1.a.b().f44618a = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                            d.b.g0.a.i1.a.b().f44619b = bundle.getString("frameType");
                            d.b.g0.a.i1.a.b().f44620c = bundle.getString("params");
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
                        d.b.g0.a.j0.c d2 = d.b.g0.a.j0.e.c().d();
                        if (d2 != null) {
                            String str = swanAppDeleteInfo.mAppId;
                            d.b.g0.a.j0.j.c k = d.b.g0.a.j0.j.c.k();
                            k.h(swanAppDeleteInfo.a());
                            d2.e(str, z, k.j());
                            return;
                        }
                        return;
                    case 9:
                        e(message);
                        return;
                    case 10:
                        d(message);
                        return;
                    case 11:
                        if (message.obj instanceof Bundle) {
                            d.e().l("event_messenger_call_in", (Bundle) message.obj);
                            return;
                        }
                        return;
                    case 12:
                        d.b.g0.a.n1.c.d.a.a(message);
                        return;
                    case 13:
                        f(message);
                        return;
                    case 14:
                        g(message);
                        return;
                    case 15:
                        h(message);
                        return;
                    case 16:
                        i(message);
                        return;
                    case 17:
                        SwanAppMessengerService.updatePkg(message);
                        return;
                    case 18:
                        Object obj = message.obj;
                        if (obj instanceof Bundle) {
                            d.b.g0.a.l0.k.a.a((Bundle) obj);
                            return;
                        }
                        return;
                    case 19:
                        d.b.b0.d.b((Bundle) message.obj);
                        return;
                    case 20:
                        e.j().r(message);
                        return;
                    case 21:
                        d.b.g0.a.n1.c.d.a.c(message);
                        return;
                    case 22:
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
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                Bundle bundle = (Bundle) obj;
                String string = bundle.getString(SwanAppMessengerService.SEND_BROADCAST_INNER_ACTION);
                String string2 = bundle.getString("ai_apps_data");
                if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                    return;
                }
                d.b.g0.a.w0.a.g().a(string, string2);
            }
        }
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("ai_apps_data", str);
        Message obtain = Message.obtain(null, i, bundle);
        d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
        d.b.g0.a.n1.c.c cVar = new d.b.g0.a.n1.c.c(obtain);
        cVar.d();
        e2.h(cVar);
        return true;
    }

    public static void updatePkg(@NonNull Message message) {
        if (message.obj instanceof Bundle) {
            if (DEBUG) {
                Log.i(TAG, "updatePkg: swanAsyncUpdate -> 收到异步升级消息");
            }
            d.b.g0.a.y0.h.a.a((Bundle) message.obj);
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
        return e.j().f45399c.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (!ProcessUtils.isMainProcess() || getApplication() == null) {
            return;
        }
        this.launchHelper = new n0(getApplication());
    }

    @Override // android.app.Service
    public void onDestroy() {
        n0 n0Var = this.launchHelper;
        if (n0Var != null) {
            n0Var.i();
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
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
            d.b.g0.a.n1.c.f.b.j(this, intent.getExtras());
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void sendDelegationMessage(@Nullable int i, @Nullable Bundle bundle, @NonNull Class<? extends d.b.g0.a.n1.a.a.a> cls, @Nullable d.b.g0.a.n1.a.b.c.c cVar) {
        if (DEBUG) {
            Log.d(TAG, "sendMessageToClient: delegation: " + cls.getName());
        }
        Message obtain = Message.obtain((Handler) null, 125);
        obtain.replyTo = e.j().f45399c;
        Bundle bundle2 = new Bundle();
        bundle2.putString("ai_apps_delegation_name", cls.getName());
        if (cVar != null) {
            bundle2.putString("ai_apps_observer_id", cVar.b());
            d.b.g0.a.n1.a.b.b.a.b().e(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        obtain.obj = bundle2;
        SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(i);
        d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
        d.b.g0.a.n1.c.c cVar2 = new d.b.g0.a.n1.c.c(obtain);
        cVar2.b(indexOf);
        e2.h(cVar2);
    }

    @Deprecated
    public boolean sendMessageToClient(int i, int i2, Bundle bundle) {
        return sendMessageToClient(SwanAppProcessInfo.indexOf(i), i2, bundle);
    }

    @Deprecated
    public boolean sendMessageToClient(SwanAppProcessInfo swanAppProcessInfo, int i, Bundle bundle) {
        d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
        d.b.g0.a.n1.c.c cVar = new d.b.g0.a.n1.c.c(i, bundle);
        cVar.b(swanAppProcessInfo);
        e2.h(cVar);
        return true;
    }

    @Deprecated
    public boolean sendMessageToClient(d.b.g0.a.n1.c.f.c cVar, int i, Bundle bundle) {
        d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
        d.b.g0.a.n1.c.c cVar2 = new d.b.g0.a.n1.c.c(i, bundle);
        cVar2.b(cVar.f45390f);
        e2.h(cVar2);
        return true;
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("ai_apps_data", j);
        Message obtain = Message.obtain(null, i, bundle);
        d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
        d.b.g0.a.n1.c.c cVar = new d.b.g0.a.n1.c.c(obtain);
        cVar.d();
        e2.h(cVar);
        return true;
    }
}
