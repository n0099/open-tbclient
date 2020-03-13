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
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public final class SwanAppMessengerService extends Service {
    public static final String ACTION_DEFAULT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_DEFAULT";
    public static final String ACTION_PREFIX = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_";
    static final String ACTION_PRELOAD_NEXT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_PRELOAD_NEXT";
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
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
    public static final int MSG_TYPE_SC_UPDATE_APP_INFO = 118;
    public static final int MSG_TYPE_SC_UPDATE_EXTENSION_CORE_VERSION = 121;
    public static final int MSG_TYPE_SC_UPDATE_GAME_CORE_VERSION = 117;
    public static final int MSG_TYPE_SC_UPDATE_SWAN_CORE_VERSION = 114;
    public static final String SEND_BROADCAST_INNER_ACTION = "innerAction";
    private static final String TAG = "SwanAppMessengerService";

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        if (DEBUG) {
            Log.d(TAG, "onBind() " + this + " pid: " + Process.myPid());
        }
        return e.abu().mMessenger.getBinder();
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
            e.abu().a(indexOf).abo();
            switch (message.what) {
                case 1:
                    E(message);
                    return;
                case 2:
                    F(message);
                    return;
                case 3:
                    if (SwanAppMessengerService.DEBUG) {
                        Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_GET_DATA msg: " + message);
                    }
                    com.baidu.swan.apps.process.messaging.a.aaL().a(new com.baidu.swan.apps.process.messaging.c(101).a(indexOf));
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
                    com.baidu.swan.apps.w.a.Us().bT(com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState());
                    com.baidu.swan.apps.process.messaging.a.aaL().a(new com.baidu.swan.apps.process.messaging.c(102).f(message.arg1));
                    return;
                case 7:
                    if (SwanAppMessengerService.DEBUG) {
                        Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_WX_PAY_APPID");
                    }
                    Bundle bundle = (Bundle) message.obj;
                    if (bundle != null) {
                        com.baidu.swan.apps.ae.a.Zu().appId = bundle.getString("appId");
                        com.baidu.swan.apps.ae.a.Zu().bGZ = bundle.getString("frameType");
                        com.baidu.swan.apps.ae.a.Zu().bHa = bundle.getString("params");
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
                        com.baidu.swan.apps.env.c RE = com.baidu.swan.apps.env.e.RD().RE();
                        if (RE != null) {
                            RE.u(swanAppDeleteInfo.mAppId, z);
                            return;
                        }
                        return;
                    }
                    return;
                case 9:
                    A(message);
                    return;
                case 10:
                    B(message);
                    return;
                case 12:
                    com.baidu.swan.apps.process.messaging.a.a.p(message);
                    return;
                case 13:
                    C(message);
                    return;
                case 14:
                    D(message);
                    return;
                case 15:
                    G(message);
                    return;
                case 16:
                    H(message);
                    return;
                case 17:
                    SwanAppMessengerService.updatePkg(message);
                    return;
                case 18:
                    if (message.obj instanceof Bundle) {
                        com.baidu.swan.apps.extcore.g.a.w((Bundle) message.obj);
                        return;
                    }
                    return;
                case 19:
                    com.baidu.j.d.i((Bundle) message.obj);
                    return;
                case 20:
                    e.abu().L(message);
                    return;
                case 300:
                    com.baidu.swan.apps.process.messaging.a.a.o(message);
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }

        private void A(@NonNull Message message) {
            c a;
            if (SwanAppMessengerService.DEBUG) {
                Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_FOREGROUND");
            }
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && (a = e.abu().a(indexOf)) != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                String string = bundle.getString(Constants.APP_ID);
                e.abu().c(string, a);
                com.baidu.swan.apps.w.a.UE().p(string, true);
                e.abu().b(indexOf);
                e.abu().kB("onAppForegroud => " + a.toString());
            }
        }

        private void B(@NonNull Message message) {
            if (SwanAppMessengerService.DEBUG) {
                Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_BACKGROUND");
            }
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && e.abu().a(indexOf) != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                com.baidu.swan.apps.w.a.UE().p(bundle.getString(Constants.APP_ID), false);
            }
        }

        private void C(@NonNull Message message) {
            c a;
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && (a = e.abu().a(indexOf)) != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                a.L(bundle);
                e.abu().kB("onConnAck => " + a.toString());
            }
        }

        private void D(@NonNull Message message) {
            c a;
            if (message.obj instanceof Bundle) {
                ((Bundle) message.obj).setClassLoader(getClass().getClassLoader());
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (indexOf.isSwanAppProcess() && (a = e.abu().a(indexOf)) != null) {
                    a.abs();
                    e.abu().kB("onPreloaded => " + a.toString());
                }
            }
        }

        private void E(@NonNull Message message) {
            if (SwanAppMessengerService.DEBUG) {
                Log.d(SwanAppMessengerService.TAG, "handleOnActivityRegister arg1: " + message.arg1);
                Log.d(SwanAppMessengerService.TAG, "handleOnActivityRegister obj: " + message.obj);
                Log.d(SwanAppMessengerService.TAG, "handleOnActivityRegister is main looper: " + (Thread.currentThread() == Looper.getMainLooper().getThread()));
            }
            int i = message.arg1;
            e abu = e.abu();
            c fG = abu.fG(i);
            if (fG != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                fG.M(bundle);
                abu.kB("onLoaded => " + fG.toString());
            }
        }

        private void F(@NonNull Message message) {
            if (SwanAppMessengerService.DEBUG) {
                Log.d(SwanAppMessengerService.TAG, "unregister client. arg1: " + message.arg1);
            }
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                c fG = e.abu().fG(message.arg1);
                if (fG != null) {
                    String string = bundle.getString("ai_apps_id", "");
                    if (TextUtils.isEmpty(string)) {
                        string = fG.getAppId();
                    }
                    com.baidu.swan.apps.process.messaging.a.aaL().kr(string);
                    fG.abq();
                    e.abu().kB("onUnloaded => " + fG.toString());
                }
            }
        }

        private void G(@NonNull Message message) {
            c a;
            if (message.obj instanceof Bundle) {
                ((Bundle) message.obj).setClassLoader(getClass().getClassLoader());
                SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
                if (indexOf.isSwanAppProcess() && (a = e.abu().a(indexOf)) != null) {
                    a.abt();
                    e.abu().kB("onRePreloaded => " + a.toString());
                }
            }
        }

        private void H(@NonNull Message message) {
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                String string = bundle.getString(SwanAppMessengerService.SEND_BROADCAST_INNER_ACTION);
                String string2 = bundle.getString("ai_apps_data");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    com.baidu.swan.apps.w.a.UF().ap(string, string2);
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
        com.baidu.swan.apps.process.messaging.a.aaL().a(new com.baidu.swan.apps.process.messaging.c(i, bundle).a(swanAppProcessInfo));
        return true;
    }

    @Deprecated
    public boolean sendMessageToClient(c cVar, int i, Bundle bundle) {
        com.baidu.swan.apps.process.messaging.a.aaL().a(new com.baidu.swan.apps.process.messaging.c(i, bundle).a(cVar.bJA));
        return true;
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("ai_apps_data", str);
        com.baidu.swan.apps.process.messaging.a.aaL().a(new com.baidu.swan.apps.process.messaging.c(Message.obtain(null, i, bundle)).aaQ());
        return true;
    }

    @Deprecated
    public static boolean sendMessageWithDataToAllClient(int i, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("ai_apps_data", j);
        com.baidu.swan.apps.process.messaging.a.aaL().a(new com.baidu.swan.apps.process.messaging.c(Message.obtain(null, i, bundle)).aaQ());
        return true;
    }

    public void sendDelegationMessage(@Nullable int i, @Nullable Bundle bundle, @NonNull Class<? extends com.baidu.swan.apps.process.a.a.a> cls, @Nullable com.baidu.swan.apps.process.a.b.c.c cVar) {
        if (DEBUG) {
            Log.d(TAG, "sendMessageToClient: delegation: " + cls.getName());
        }
        Message obtain = Message.obtain((Handler) null, 301);
        obtain.replyTo = e.abu().mMessenger;
        Bundle bundle2 = new Bundle();
        bundle2.putString("ai_apps_delegation_name", cls.getName());
        if (cVar != null) {
            bundle2.putString("ai_apps_observer_id", cVar.aaI());
            com.baidu.swan.apps.process.a.b.b.a.aaJ().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        obtain.obj = bundle2;
        com.baidu.swan.apps.process.messaging.a.aaL().a(new com.baidu.swan.apps.process.messaging.c(obtain).a(SwanAppProcessInfo.indexOf(i)));
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
            com.baidu.swan.apps.x.d.a.G((Bundle) message.obj);
        }
    }
}
