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
/* loaded from: classes3.dex */
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
        return e.ayP().mMessenger.getBinder();
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
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SwanAppDeleteInfo swanAppDeleteInfo;
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            e.ayP().a(indexOf).ayJ();
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
                    com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(101).a(indexOf));
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
                    com.baidu.swan.apps.t.a.apQ().ds(com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState());
                    com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(102).g(message.arg1));
                    return;
                case 7:
                    if (SwanAppMessengerService.DEBUG) {
                        Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_WX_PAY_APPID");
                    }
                    Bundle bundle = (Bundle) message.obj;
                    if (bundle != null) {
                        com.baidu.swan.apps.aa.a.avZ().appId = bundle.getString("appId");
                        com.baidu.swan.apps.aa.a.avZ().cHK = bundle.getString("frameType");
                        com.baidu.swan.apps.aa.a.avZ().cHL = bundle.getString("params");
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
                        com.baidu.swan.apps.env.c amc = com.baidu.swan.apps.env.e.amb().amc();
                        if (amc != null) {
                            amc.a(swanAppDeleteInfo.mAppId, z, com.baidu.swan.apps.env.c.c.amG().hD(swanAppDeleteInfo.ama()).amH());
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
                        com.baidu.swan.apps.runtime.d.aAn().f("event_messenger_call_in", (Bundle) message.obj);
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
                    e.ayP().N(message);
                    return;
                case 21:
                    com.baidu.swan.apps.process.messaging.a.a.o(message);
                    return;
                case 22:
                    return;
                case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                    com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(message).g(message.arg1));
                    return;
                case Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER /* 124 */:
                    com.baidu.swan.apps.ap.b.P(message);
                    com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(message).g(message.arg1));
                    return;
                case 129:
                    ayw();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }

        private void ayw() {
            com.baidu.swan.apps.console.c.i(SwanAppMessengerService.TAG, "resetCore: service handleCoreReset");
            com.baidu.swan.apps.swancore.d.a.kg(0);
            com.baidu.swan.apps.extcore.b.hF(0).amT().aY(0L);
            com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(129).ayg());
            com.baidu.swan.apps.swancore.b.jM(0);
        }

        private void C(@NonNull Message message) {
            c a;
            if (SwanAppMessengerService.DEBUG) {
                Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_FOREGROUND");
            }
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && (a = e.ayP().a(indexOf)) != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                String string = bundle.getString("app_id");
                int i = bundle.getInt("task_id");
                e.ayP().d(string, a);
                com.baidu.swan.apps.t.a.aqd().F(string, true);
                an.l(true, i);
                e.ayP().b(indexOf);
                if (SwanAppMessengerService.DEBUG) {
                    e.ayP().qp("onAppForegroud => " + a.toString());
                }
            }
        }

        private void D(@NonNull Message message) {
            if (SwanAppMessengerService.DEBUG) {
                Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_BACKGROUND");
            }
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && e.ayP().a(indexOf) != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                String string = bundle.getString("app_id");
                int i = bundle.getInt("task_id");
                com.baidu.swan.apps.t.a.aqd().F(string, false);
                an.l(false, i);
            }
        }

        private void E(@NonNull Message message) {
            c a;
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && (a = e.ayP().a(indexOf)) != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                a.Q(bundle);
                if (SwanAppMessengerService.DEBUG) {
                    e.ayP().qp("onConnAck => " + a.toString());
                }
            }
        }

        private void F(@NonNull Message message) {
            c a;
            if (message.obj instanceof Bundle) {
                ((Bundle) message.obj).setClassLoader(getClass().getClassLoader());
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (indexOf.isSwanAppProcess() && (a = e.ayP().a(indexOf)) != null) {
                    a.ayN();
                    if (SwanAppMessengerService.DEBUG) {
                        e.ayP().qp("onPreloaded => " + a.toString());
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
            e ayP = e.ayP();
            c iR = ayP.iR(i);
            if (iR != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                iR.R(bundle);
                if (SwanAppMessengerService.DEBUG) {
                    ayP.qp("onLoaded => " + iR.toString());
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
                c iR = e.ayP().iR(message.arg1);
                if (iR != null) {
                    String string = bundle.getString("ai_apps_id", "");
                    if (TextUtils.isEmpty(string)) {
                        string = iR.getAppId();
                    }
                    com.baidu.swan.apps.process.messaging.a.ayb().qf(string);
                    iR.ayL();
                    if (SwanAppMessengerService.DEBUG) {
                        e.ayP().qp("onUnloaded => " + iR.toString());
                    }
                }
            }
        }

        private void I(@NonNull Message message) {
            c a;
            if (message.obj instanceof Bundle) {
                ((Bundle) message.obj).setClassLoader(getClass().getClassLoader());
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (indexOf.isSwanAppProcess() && (a = e.ayP().a(indexOf)) != null) {
                    a.ayO();
                    if (SwanAppMessengerService.DEBUG) {
                        e.ayP().qp("onRePreloaded => " + a.toString());
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
                    com.baidu.swan.apps.t.a.aqe().aT(string, string2);
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
        com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(i, bundle).a(swanAppProcessInfo));
        return true;
    }

    @Deprecated
    public boolean sendMessageToClient(c cVar, int i, Bundle bundle) {
        com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(i, bundle).a(cVar.cLD));
        return true;
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("ai_apps_data", str);
        com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(Message.obtain(null, i, bundle)).ayg());
        return true;
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("ai_apps_data", j);
        com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(Message.obtain(null, i, bundle)).ayg());
        return true;
    }

    public void sendDelegationMessage(@Nullable int i, @Nullable Bundle bundle, @NonNull Class<? extends com.baidu.swan.apps.process.a.a.a> cls, @Nullable com.baidu.swan.apps.process.a.b.c.c cVar) {
        if (DEBUG) {
            Log.d(TAG, "sendMessageToClient: delegation: " + cls.getName());
        }
        Message obtain = Message.obtain((Handler) null, (int) Constants.METHOD_IM_FRIEND_GROUP_ASSIGN);
        obtain.replyTo = e.ayP().mMessenger;
        Bundle bundle2 = new Bundle();
        bundle2.putString("ai_apps_delegation_name", cls.getName());
        if (cVar != null) {
            bundle2.putString("ai_apps_observer_id", cVar.axR());
            com.baidu.swan.apps.process.a.b.b.a.axS().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        obtain.obj = bundle2;
        com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(obtain).a(SwanAppProcessInfo.indexOf(i)));
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
