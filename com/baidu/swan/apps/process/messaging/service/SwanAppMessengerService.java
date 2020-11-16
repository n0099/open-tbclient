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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ap.an;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
/* loaded from: classes7.dex */
public final class SwanAppMessengerService extends Service {
    public static final String ACTION_DEFAULT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_DEFAULT";
    public static final String ACTION_PREFIX = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_";
    static final String ACTION_PRELOAD_NEXT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_PRELOAD_NEXT";
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final String SEND_BROADCAST_INNER_ACTION = "innerAction";
    private static final String TAG = "SwanAppMessengerService";
    @Nullable
    private an launchHelper;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (ProcessUtils.isMainProcess() && getApplication() != null) {
            this.launchHelper = new an(getApplication());
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        if (DEBUG) {
            Log.d(TAG, "onBind() " + this + " pid: " + Process.myPid());
        }
        return e.aFk().mMessenger.getBinder();
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
    /* loaded from: classes7.dex */
    public static class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SwanAppDeleteInfo swanAppDeleteInfo;
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            e.aFk().a(indexOf).aFe();
            switch (message.what) {
                case 1:
                    G(message);
                    return;
                case 2:
                    H(message);
                    return;
                case 3:
                    if (SwanAppMessengerService.DEBUG) {
                        Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_GET_DATA msg: " + message);
                    }
                    com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(101).a(indexOf));
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
                    com.baidu.swan.apps.t.a.awo().en(com.baidu.swan.apps.t.a.awo().getNightModeSwitcherState());
                    com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(102).g(message.arg1));
                    return;
                case 7:
                    if (SwanAppMessengerService.DEBUG) {
                        Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_WX_PAY_APPID");
                    }
                    Bundle bundle = (Bundle) message.obj;
                    if (bundle != null) {
                        com.baidu.swan.apps.aa.a.aCw().appId = bundle.getString("appId");
                        com.baidu.swan.apps.aa.a.aCw().dgz = bundle.getString("frameType");
                        com.baidu.swan.apps.aa.a.aCw().dgA = bundle.getString("params");
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
                        com.baidu.swan.apps.env.c asB = com.baidu.swan.apps.env.e.asA().asB();
                        if (asB != null) {
                            asB.a(swanAppDeleteInfo.mAppId, z, com.baidu.swan.apps.env.c.c.atf().ir(swanAppDeleteInfo.asz()).atg());
                            return;
                        }
                        return;
                    }
                    return;
                case 9:
                    C(message);
                    return;
                case 10:
                    D(message);
                    return;
                case 11:
                    if (message.obj instanceof Bundle) {
                        com.baidu.swan.apps.runtime.d.aGI().f("event_messenger_call_in", (Bundle) message.obj);
                        return;
                    }
                    return;
                case 12:
                    com.baidu.swan.apps.process.messaging.a.a.p(message);
                    return;
                case 13:
                    E(message);
                    return;
                case 14:
                    F(message);
                    return;
                case 15:
                    I(message);
                    return;
                case 16:
                    J(message);
                    return;
                case 17:
                    SwanAppMessengerService.updatePkg(message);
                    return;
                case 18:
                    if (message.obj instanceof Bundle) {
                        com.baidu.swan.apps.extcore.f.a.x((Bundle) message.obj);
                        return;
                    }
                    return;
                case 19:
                    com.baidu.l.d.k((Bundle) message.obj);
                    return;
                case 20:
                    e.aFk().N(message);
                    return;
                case 21:
                    com.baidu.swan.apps.process.messaging.a.a.o(message);
                    return;
                case 22:
                    return;
                case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                    com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(message).g(message.arg1));
                    return;
                case Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER /* 124 */:
                    com.baidu.swan.apps.ap.b.P(message);
                    com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(message).g(message.arg1));
                    return;
                case 129:
                    aER();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }

        private void aER() {
            com.baidu.swan.apps.console.c.i(SwanAppMessengerService.TAG, "resetCore: service handleCoreReset");
            com.baidu.swan.apps.swancore.d.a.kU(0);
            com.baidu.swan.apps.extcore.b.it(0).ats().bE(0L);
            com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(129).aEB());
            com.baidu.swan.apps.swancore.b.kA(0);
        }

        private void C(@NonNull Message message) {
            c a2;
            if (SwanAppMessengerService.DEBUG) {
                Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_FOREGROUND");
            }
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && (a2 = e.aFk().a(indexOf)) != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                String string = bundle.getString("app_id");
                int i = bundle.getInt("task_id");
                e.aFk().d(string, a2);
                com.baidu.swan.apps.t.a.awB().L(string, true);
                an.m(true, i);
                e.aFk().b(indexOf);
                if (SwanAppMessengerService.DEBUG) {
                    e.aFk().rC("onAppForegroud => " + a2.toString());
                }
            }
        }

        private void D(@NonNull Message message) {
            if (SwanAppMessengerService.DEBUG) {
                Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_BACKGROUND");
            }
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && e.aFk().a(indexOf) != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                String string = bundle.getString("app_id");
                int i = bundle.getInt("task_id");
                com.baidu.swan.apps.t.a.awB().L(string, false);
                an.m(false, i);
            }
        }

        private void E(@NonNull Message message) {
            c a2;
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && (a2 = e.aFk().a(indexOf)) != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                a2.Q(bundle);
                if (SwanAppMessengerService.DEBUG) {
                    e.aFk().rC("onConnAck => " + a2.toString());
                }
            }
        }

        private void F(@NonNull Message message) {
            c a2;
            if (message.obj instanceof Bundle) {
                ((Bundle) message.obj).setClassLoader(getClass().getClassLoader());
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (indexOf.isSwanAppProcess() && (a2 = e.aFk().a(indexOf)) != null) {
                    a2.aFi();
                    if (SwanAppMessengerService.DEBUG) {
                        e.aFk().rC("onPreloaded => " + a2.toString());
                    }
                }
            }
        }

        private void G(@NonNull Message message) {
            if (SwanAppMessengerService.DEBUG) {
                Log.d(SwanAppMessengerService.TAG, "handleOnActivityRegister arg1: " + message.arg1);
                Log.d(SwanAppMessengerService.TAG, "handleOnActivityRegister obj: " + message.obj);
                Log.d(SwanAppMessengerService.TAG, "handleOnActivityRegister is main looper: " + (Thread.currentThread() == Looper.getMainLooper().getThread()));
            }
            int i = message.arg1;
            e aFk = e.aFk();
            c jF = aFk.jF(i);
            if (jF != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                jF.R(bundle);
                if (SwanAppMessengerService.DEBUG) {
                    aFk.rC("onLoaded => " + jF.toString());
                }
            }
        }

        private void H(@NonNull Message message) {
            if (SwanAppMessengerService.DEBUG) {
                Log.d(SwanAppMessengerService.TAG, "unregister client. arg1: " + message.arg1);
            }
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                c jF = e.aFk().jF(message.arg1);
                if (jF != null) {
                    String string = bundle.getString("ai_apps_id", "");
                    if (TextUtils.isEmpty(string)) {
                        string = jF.getAppId();
                    }
                    com.baidu.swan.apps.process.messaging.a.aEw().rs(string);
                    jF.aFg();
                    if (SwanAppMessengerService.DEBUG) {
                        e.aFk().rC("onUnloaded => " + jF.toString());
                    }
                }
            }
        }

        private void I(@NonNull Message message) {
            c a2;
            if (message.obj instanceof Bundle) {
                ((Bundle) message.obj).setClassLoader(getClass().getClassLoader());
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (indexOf.isSwanAppProcess() && (a2 = e.aFk().a(indexOf)) != null) {
                    a2.aFj();
                    if (SwanAppMessengerService.DEBUG) {
                        e.aFk().rC("onRePreloaded => " + a2.toString());
                    }
                }
            }
        }

        private void J(@NonNull Message message) {
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                String string = bundle.getString(SwanAppMessengerService.SEND_BROADCAST_INNER_ACTION);
                String string2 = bundle.getString("ai_apps_data");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    com.baidu.swan.apps.t.a.awC().be(string, string2);
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
        com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(i, bundle).a(swanAppProcessInfo));
        return true;
    }

    @Deprecated
    public boolean sendMessageToClient(c cVar, int i, Bundle bundle) {
        com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(i, bundle).a(cVar.dkv));
        return true;
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("ai_apps_data", str);
        com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(Message.obtain(null, i, bundle)).aEB());
        return true;
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("ai_apps_data", j);
        com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(Message.obtain(null, i, bundle)).aEB());
        return true;
    }

    public void sendDelegationMessage(@Nullable int i, @Nullable Bundle bundle, @NonNull Class<? extends com.baidu.swan.apps.process.a.a.a> cls, @Nullable com.baidu.swan.apps.process.a.b.c.c cVar) {
        if (DEBUG) {
            Log.d(TAG, "sendMessageToClient: delegation: " + cls.getName());
        }
        Message obtain = Message.obtain((Handler) null, (int) Constants.METHOD_IM_FRIEND_GROUP_ASSIGN);
        obtain.replyTo = e.aFk().mMessenger;
        Bundle bundle2 = new Bundle();
        bundle2.putString("ai_apps_delegation_name", cls.getName());
        if (cVar != null) {
            bundle2.putString("ai_apps_observer_id", cVar.aEo());
            com.baidu.swan.apps.process.a.b.b.a.aEp().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        obtain.obj = bundle2;
        com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(obtain).a(SwanAppProcessInfo.indexOf(i)));
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
            com.baidu.swan.apps.u.f.a.I((Bundle) message.obj);
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
