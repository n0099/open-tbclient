package com.baidu.swan.apps.process.messaging.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
/* loaded from: classes11.dex */
public final class SwanAppMessengerService extends Service {
    public static final String ACTION_DEFAULT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_DEFAULT";
    public static final String ACTION_PREFIX = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_";
    static final String ACTION_PRELOAD_NEXT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_PRELOAD_NEXT";
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final int MSG_TYPE_CS_CALL = 11;
    public static final int MSG_TYPE_CS_CONN_ACK = 13;
    public static final int MSG_TYPE_CS_DATA_CHANNEL = 16;
    public static final int MSG_TYPE_CS_DELEGATION = 12;
    public static final int MSG_TYPE_CS_DELEGATION_CALLBACK = 300;
    public static final int MSG_TYPE_CS_DELETE_OLD_EXTENSION_CORES = 18;
    public static final int MSG_TYPE_CS_DELETE_SWAN_APP_WITH_FAV_HISTORY_CHECK = 8;
    public static final int MSG_TYPE_CS_GET_DATA = 3;
    public static final int MSG_TYPE_CS_GET_SUB_PACKAGE = 6;
    public static final int MSG_TYPE_CS_NIGHT_MODE_CHANGED = 5;
    public static final int MSG_TYPE_CS_ON_APP_BACKGROUND = 10;
    public static final int MSG_TYPE_CS_ON_APP_FOREGROUND = 9;
    public static final int MSG_TYPE_CS_ON_LAUNCH_FINISH = 20;
    public static final int MSG_TYPE_CS_ON_QUICK_PAY_RESULT = 19;
    public static final int MSG_TYPE_CS_ON_RE_PRELOADED = 15;
    public static final int MSG_TYPE_CS_PRELOADED = 14;
    public static final int MSG_TYPE_CS_REGISTER = 1;
    public static final int MSG_TYPE_CS_RESPONSE = 4;
    public static final int MSG_TYPE_CS_UNREGISTER = 2;
    public static final int MSG_TYPE_CS_UPDATE_PKG = 17;
    public static final int MSG_TYPE_CS_WX_PAY_APPID = 7;
    public static final int MSG_TYPE_SC_ACCOUNT_LOGIN = 103;
    public static final int MSG_TYPE_SC_ACCOUNT_LOGOUT = 100;
    public static final int MSG_TYPE_SC_APK_INSTALL_UNINSTALL = 116;
    public static final int MSG_TYPE_SC_APP_ON_LAUNCH = 122;
    public static final int MSG_TYPE_SC_BACKGROUND_KILL_NOTIFY = 124;
    public static final int MSG_TYPE_SC_CALL = 111;
    public static final int MSG_TYPE_SC_DELEGATION = 301;
    public static final int MSG_TYPE_SC_DELEGATION_CALLBACK = 302;
    public static final int MSG_TYPE_SC_KILL_SELF = 110;
    public static final int MSG_TYPE_SC_LAUNCH_EXT = 109;
    public static final int MSG_TYPE_SC_NEW_WX_PAY_CALLBACK = 115;
    public static final int MSG_TYPE_SC_NIGHT_MODE_CHANGED = 102;
    public static final int MSG_TYPE_SC_ON_QUICK_PAY_RESULT = 119;
    public static final int MSG_TYPE_SC_PKG_UPDATE = 107;
    public static final int MSG_TYPE_SC_PURGE = 106;
    public static final int MSG_TYPE_SC_RETURN_DATA = 101;
    public static final int MSG_TYPE_SC_SEND_PREFETCH_EVENT = 120;
    public static final int MSG_TYPE_SC_TASK_CHANGE = 123;
    public static final int MSG_TYPE_SC_UPDATE_APP_INFO = 118;
    public static final int MSG_TYPE_SC_UPDATE_EXTENSION_CORE_VERSION = 121;
    public static final int MSG_TYPE_SC_UPDATE_GAME_CORE_VERSION = 117;
    public static final int MSG_TYPE_SC_UPDATE_SWAN_CORE_VERSION = 114;
    public static final String SEND_BROADCAST_INNER_ACTION = "innerAction";
    private static final String TAG = "SwanAppMessengerService";
    @Nullable
    private al launchHelper;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (ProcessUtils.isMainProcess() && getApplication() != null) {
            this.launchHelper = new al(getApplication());
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        if (DEBUG) {
            Log.d(TAG, "onBind() " + this + " pid: " + Process.myPid());
        }
        return e.anp().mMessenger.getBinder();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        boolean z;
        String action = (intent == null || TextUtils.isEmpty(intent.getAction())) ? ACTION_DEFAULT : intent.getAction();
        switch (action.hashCode()) {
            case -74985808:
                if (action.equals(ACTION_PRELOAD_NEXT)) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case -5111142:
                if (action.equals(ACTION_DEFAULT)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                if (TextUtils.isEmpty(intent.getStringExtra("bundle_key_preload_preload_scene"))) {
                    intent.putExtra("bundle_key_preload_preload_scene", "0");
                }
                b.d(this, intent.getExtras());
                break;
        }
        return super.onStartCommand(intent, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SwanAppDeleteInfo swanAppDeleteInfo;
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            e.anp().a(indexOf).anj();
            switch (message.what) {
                case 1:
                    F(message);
                    return;
                case 2:
                    G(message);
                    return;
                case 3:
                    if (SwanAppMessengerService.DEBUG) {
                        Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_GET_DATA msg: " + message);
                    }
                    com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(101).a(indexOf));
                    return;
                case 4:
                    if (SwanAppMessengerService.DEBUG) {
                        Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_RESPONSE msg: " + message);
                        return;
                    }
                    return;
                case 5:
                    if (SwanAppMessengerService.DEBUG) {
                        Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_NIGHT_MODE_CHANGED");
                    }
                    com.baidu.swan.apps.u.a.afm().dd(com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState());
                    com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(102).f(message.arg1));
                    return;
                case 7:
                    if (SwanAppMessengerService.DEBUG) {
                        Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_WX_PAY_APPID");
                    }
                    Bundle bundle = (Bundle) message.obj;
                    if (bundle != null) {
                        com.baidu.swan.apps.ac.a.akW().appId = bundle.getString("appId");
                        com.baidu.swan.apps.ac.a.akW().cqK = bundle.getString("frameType");
                        com.baidu.swan.apps.ac.a.akW().cqL = bundle.getString("params");
                        return;
                    }
                    return;
                case 8:
                    if (SwanAppMessengerService.DEBUG) {
                        Log.e(SwanAppMessengerService.TAG, "MSG_TYPE_CS_DELETE_SWAN_APP_WITH_FAV_HISTORY_CHECK");
                    }
                    Bundle bundle2 = (Bundle) message.obj;
                    bundle2.setClassLoader(getClass().getClassLoader());
                    if (bundle2 != null && (swanAppDeleteInfo = (SwanAppDeleteInfo) bundle2.getParcelable("ai_apps_data")) != null && !TextUtils.isEmpty(swanAppDeleteInfo.mAppId)) {
                        boolean z = swanAppDeleteInfo.mCheckHisAndFavor == 0;
                        com.baidu.swan.apps.env.c acw = com.baidu.swan.apps.env.e.acv().acw();
                        if (acw != null) {
                            acw.J(swanAppDeleteInfo.mAppId, z);
                            return;
                        }
                        return;
                    }
                    return;
                case 9:
                    B(message);
                    return;
                case 10:
                    C(message);
                    return;
                case 11:
                    if (message.obj instanceof Bundle) {
                        com.baidu.swan.apps.runtime.d.aoB().g("event_messenger_call_in", (Bundle) message.obj);
                        return;
                    }
                    return;
                case 12:
                    com.baidu.swan.apps.process.messaging.a.a.p(message);
                    return;
                case 13:
                    D(message);
                    return;
                case 14:
                    E(message);
                    return;
                case 15:
                    H(message);
                    return;
                case 16:
                    I(message);
                    return;
                case 17:
                    SwanAppMessengerService.updatePkg(message);
                    return;
                case 18:
                    if (message.obj instanceof Bundle) {
                        com.baidu.swan.apps.extcore.f.a.z((Bundle) message.obj);
                        return;
                    }
                    return;
                case 19:
                    com.baidu.g.d.k((Bundle) message.obj);
                    return;
                case 20:
                    e.anp().M(message);
                    return;
                case 123:
                    com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(message).f(message.arg1));
                    return;
                case 124:
                    com.baidu.swan.apps.aq.a.O(message);
                    com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(message).f(message.arg1));
                    return;
                case 300:
                    com.baidu.swan.apps.process.messaging.a.a.o(message);
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }

        private void B(@NonNull Message message) {
            c a;
            if (SwanAppMessengerService.DEBUG) {
                Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_FOREGROUND");
            }
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && (a = e.anp().a(indexOf)) != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                String string = bundle.getString("app_id");
                int i = bundle.getInt("task_id");
                e.anp().c(string, a);
                com.baidu.swan.apps.u.a.afy().y(string, true);
                al.l(true, i);
                e.anp().b(indexOf);
                e.anp().ni("onAppForegroud => " + a.toString());
            }
        }

        private void C(@NonNull Message message) {
            if (SwanAppMessengerService.DEBUG) {
                Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_BACKGROUND");
            }
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && e.anp().a(indexOf) != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                com.baidu.swan.apps.u.a.afy().y(bundle.getString("app_id"), false);
            }
        }

        private void D(@NonNull Message message) {
            c a;
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && (a = e.anp().a(indexOf)) != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                a.R(bundle);
                e.anp().ni("onConnAck => " + a.toString());
            }
        }

        private void E(@NonNull Message message) {
            c a;
            if (message.obj instanceof Bundle) {
                ((Bundle) message.obj).setClassLoader(getClass().getClassLoader());
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (indexOf.isSwanAppProcess() && (a = e.anp().a(indexOf)) != null) {
                    a.ann();
                    e.anp().ni("onPreloaded => " + a.toString());
                }
            }
        }

        private void F(@NonNull Message message) {
            if (SwanAppMessengerService.DEBUG) {
                Log.d(SwanAppMessengerService.TAG, "handleOnActivityRegister arg1: " + message.arg1);
                Log.d(SwanAppMessengerService.TAG, "handleOnActivityRegister obj: " + message.obj);
                Log.d(SwanAppMessengerService.TAG, "handleOnActivityRegister is main looper: " + (Thread.currentThread() == Looper.getMainLooper().getThread()));
            }
            int i = message.arg1;
            e anp = e.anp();
            c ge = anp.ge(i);
            if (ge != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                ge.S(bundle);
                anp.ni("onLoaded => " + ge.toString());
            }
        }

        private void G(@NonNull Message message) {
            if (SwanAppMessengerService.DEBUG) {
                Log.d(SwanAppMessengerService.TAG, "unregister client. arg1: " + message.arg1);
            }
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                c ge = e.anp().ge(message.arg1);
                if (ge != null) {
                    String string = bundle.getString("ai_apps_id", "");
                    if (TextUtils.isEmpty(string)) {
                        string = ge.getAppId();
                    }
                    com.baidu.swan.apps.process.messaging.a.amG().mY(string);
                    ge.anl();
                    e.anp().ni("onUnloaded => " + ge.toString());
                }
            }
        }

        private void H(@NonNull Message message) {
            c a;
            if (message.obj instanceof Bundle) {
                ((Bundle) message.obj).setClassLoader(getClass().getClassLoader());
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (indexOf.isSwanAppProcess() && (a = e.anp().a(indexOf)) != null) {
                    a.ano();
                    e.anp().ni("onRePreloaded => " + a.toString());
                }
            }
        }

        private void I(@NonNull Message message) {
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                String string = bundle.getString(SwanAppMessengerService.SEND_BROADCAST_INNER_ACTION);
                String string2 = bundle.getString("ai_apps_data");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    com.baidu.swan.apps.u.a.afz().aM(string, string2);
                }
            }
        }
    }

    @Deprecated
    public boolean sendMessageToClient(int i, int i2, Bundle bundle) {
        return sendMessageToClient(SwanAppProcessInfo.indexOf(i), i2, bundle);
    }

    @Deprecated
    public boolean sendMessageToClient(SwanAppProcessInfo swanAppProcessInfo, int i, Bundle bundle) {
        com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(i, bundle).a(swanAppProcessInfo));
        return true;
    }

    @Deprecated
    public boolean sendMessageToClient(c cVar, int i, Bundle bundle) {
        com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(i, bundle).a(cVar.cud));
        return true;
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("ai_apps_data", str);
        com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(Message.obtain(null, i, bundle)).amL());
        return true;
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("ai_apps_data", j);
        com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(Message.obtain(null, i, bundle)).amL());
        return true;
    }

    public void sendDelegationMessage(@Nullable int i, @Nullable Bundle bundle, @NonNull Class<? extends com.baidu.swan.apps.process.a.a.a> cls, @Nullable com.baidu.swan.apps.process.a.b.c.c cVar) {
        if (DEBUG) {
            Log.d(TAG, "sendMessageToClient: delegation: " + cls.getName());
        }
        Message obtain = Message.obtain((Handler) null, 301);
        obtain.replyTo = e.anp().mMessenger;
        Bundle bundle2 = new Bundle();
        bundle2.putString("ai_apps_delegation_name", cls.getName());
        if (cVar != null) {
            bundle2.putString("ai_apps_observer_id", cVar.amw());
            com.baidu.swan.apps.process.a.b.b.a.amx().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        obtain.obj = bundle2;
        com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(obtain).a(SwanAppProcessInfo.indexOf(i)));
    }

    public static void updateStateByBroadcast(Intent intent) {
        sendMessageWithDataToAllClient(116, intent.toUri(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updatePkg(@NonNull Message message) {
        if (message.obj instanceof Bundle) {
            if (DEBUG) {
                Log.i(TAG, "updatePkg: swanAsyncUpdate -> 收到异步升级消息");
            }
            com.baidu.swan.apps.v.d.a.J((Bundle) message.obj);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.launchHelper != null) {
            this.launchHelper.onDestroy();
        }
        super.onDestroy();
    }
}
