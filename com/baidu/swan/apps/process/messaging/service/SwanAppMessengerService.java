package com.baidu.swan.apps.process.messaging.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.env.e;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.install.subpackage.SubPackageAPSInfo;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.a.a;
import com.baidu.swan.apps.process.messaging.service.a;
import com.baidu.swan.games.subpackage.aps.SwanGameSubPackageAPSInfo;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.TreeSet;
/* loaded from: classes2.dex */
public final class SwanAppMessengerService extends Service {
    public static final String ACTION_DEFAULT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_DEFAULT";
    public static final String ACTION_PREFIX = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_";
    static final String ACTION_PRELOAD_NEXT = "com.baidu.searchbox.action.SWAN_APP_MSG_SERVICE_PRELOAD_NEXT";
    public static final int MSG_TYPE_CS_CONN_ACK = 13;
    public static final int MSG_TYPE_CS_DELEGATION = 12;
    public static final int MSG_TYPE_CS_DELEGATION_CALLBACK = 302;
    public static final int MSG_TYPE_CS_DELETE_SWAN_APP_WITH_FAV_HISTORY_CHECK = 8;
    public static final int MSG_TYPE_CS_GET_DATA = 3;
    public static final int MSG_TYPE_CS_GET_GAME_SUB_PACKAGE = 11;
    public static final int MSG_TYPE_CS_GET_SUB_PACKAGE = 6;
    public static final int MSG_TYPE_CS_NIGHT_MODE_CHANGED = 5;
    public static final int MSG_TYPE_CS_ON_APP_FOREGROUND = 9;
    public static final int MSG_TYPE_CS_ON_RE_PRELOADED = 15;
    public static final int MSG_TYPE_CS_PRELOADED = 14;
    public static final int MSG_TYPE_CS_REGISTER = 1;
    public static final int MSG_TYPE_CS_RESPONSE = 4;
    public static final int MSG_TYPE_CS_UNREGISTER = 2;
    public static final int MSG_TYPE_CS_WX_PAY_APPID = 7;
    public static final int MSG_TYPE_SC_ACCOUNT_LOGIN = 103;
    public static final int MSG_TYPE_SC_ACCOUNT_LOGOUT = 100;
    public static final int MSG_TYPE_SC_DELEGATION = 301;
    public static final int MSG_TYPE_SC_DELEGATION_CALLBACK = 300;
    public static final int MSG_TYPE_SC_GET_GAME_SUB_PACKAGE_FAILED = 111;
    public static final int MSG_TYPE_SC_GET_GAME_SUB_PACKAGE_ON_PROGRESS = 113;
    public static final int MSG_TYPE_SC_GET_GAME_SUB_PACKAGE_SUCCESS = 112;
    public static final int MSG_TYPE_SC_GET_SUB_PACKAGE_FAILED = 104;
    public static final int MSG_TYPE_SC_GET_SUB_PACKAGE_SUCCESS = 105;
    public static final int MSG_TYPE_SC_KILL_SELF = 110;
    public static final int MSG_TYPE_SC_LAUNCH_EXT = 109;
    public static final int MSG_TYPE_SC_NIGHT_MODE_CHANGED = 102;
    public static final int MSG_TYPE_SC_PKG_UPDATE = 107;
    public static final int MSG_TYPE_SC_PRELOAD = 108;
    public static final int MSG_TYPE_SC_RESET = 106;
    public static final int MSG_TYPE_SC_RETURN_DATA = 101;
    public static final int MSG_TYPE_SC_UPDATE_SWAN_CORE_VERSION = 114;
    private static final String TAG = "SwanAppMessengerService";
    private static SwanAppMessengerService sServiceObject;
    private a mHandler = new a(this);
    private final Messenger mMessenger = new Messenger(this.mHandler);
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static LinkedHashMap<String, LinkedList<Message>> sPendingMsgMap = new LinkedHashMap<>();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (DEBUG) {
            Log.d(TAG, "onCreate() " + this + " pid: " + Process.myPid());
        }
        sServiceObject = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (DEBUG) {
            Log.d(TAG, "onDestroy() " + this + " pid: " + Process.myPid());
        }
        this.mHandler.removeCallbacksAndMessages(null);
        sServiceObject = null;
        super.onDestroy();
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        if (DEBUG) {
            Log.d(TAG, "onBind() " + this + " pid: " + Process.myPid());
        }
        return this.mMessenger.getBinder();
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
                c.e(this, intent.getExtras());
                break;
        }
        return super.onStartCommand(intent, i, i2);
    }

    public static SwanAppMessengerService getServiceObject() {
        return sServiceObject;
    }

    public Messenger getMessenger() {
        return this.mMessenger;
    }

    /* loaded from: classes2.dex */
    private static class a extends Handler {
        private WeakReference<SwanAppMessengerService> aFl;

        public a(SwanAppMessengerService swanAppMessengerService) {
            this.aFl = null;
            this.aFl = new WeakReference<>(swanAppMessengerService);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SwanAppDeleteInfo swanAppDeleteInfo;
            SwanAppMessengerService swanAppMessengerService = this.aFl != null ? this.aFl.get() : null;
            if (swanAppMessengerService != null) {
                SwanAppProcessInfo byId = SwanAppProcessInfo.getById(message.arg1);
                switch (message.what) {
                    case 1:
                        d(message, swanAppMessengerService);
                        return;
                    case 2:
                        e(message, swanAppMessengerService);
                        return;
                    case 3:
                        if (SwanAppMessengerService.DEBUG) {
                            Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_GET_DATA msg: " + message);
                        }
                        swanAppMessengerService.sendMessageToClient(byId, 101);
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
                        com.baidu.swan.apps.u.a.CT().bf(com.baidu.swan.apps.u.a.CT().Ds());
                        swanAppMessengerService.sendMessageToAllClients(102, new int[]{message.arg1});
                        return;
                    case 6:
                        if (SwanAppMessengerService.DEBUG) {
                            Log.e(SwanAppMessengerService.TAG, "MSG_TYPE_CS_GET_SUB_PACKAGE");
                        }
                        Bundle bundle = (Bundle) message.obj;
                        bundle.setClassLoader(getClass().getClassLoader());
                        com.baidu.swan.apps.core.a.d.a.a((SubPackageAPSInfo) bundle.getParcelable("ai_apps_data"), byId.id);
                        return;
                    case 7:
                        if (SwanAppMessengerService.DEBUG) {
                            Log.d(SwanAppMessengerService.TAG, "MSG_TYPE_CS_WX_PAY_APPID");
                        }
                        Bundle bundle2 = (Bundle) message.obj;
                        if (bundle2 != null) {
                            com.baidu.swan.apps.aa.c.aDm = bundle2.getString("ai_apps_id");
                            com.baidu.swan.apps.aa.c.aDn = bundle2.getString("ai_apps_data");
                            return;
                        }
                        return;
                    case 8:
                        if (SwanAppMessengerService.DEBUG) {
                            Log.e(SwanAppMessengerService.TAG, "MSG_TYPE_CS_DELETE_SWAN_APP_WITH_FAV_HISTORY_CHECK");
                        }
                        Bundle bundle3 = (Bundle) message.obj;
                        bundle3.setClassLoader(getClass().getClassLoader());
                        if (bundle3 != null && (swanAppDeleteInfo = (SwanAppDeleteInfo) bundle3.getParcelable("ai_apps_data")) != null && !TextUtils.isEmpty(swanAppDeleteInfo.mAppId)) {
                            boolean z = swanAppDeleteInfo.auX == 0;
                            com.baidu.swan.apps.env.c Bg = e.Bf().Bg();
                            if (Bg != null) {
                                Bg.p(swanAppDeleteInfo.mAppId, z);
                                return;
                            }
                            return;
                        }
                        return;
                    case 9:
                        a(message, swanAppMessengerService);
                        return;
                    case 11:
                        if (SwanAppMessengerService.DEBUG) {
                            Log.e(SwanAppMessengerService.TAG, "MSG_TYPE_CS_GET_SUB_PACKAGE");
                        }
                        Bundle bundle4 = (Bundle) message.obj;
                        bundle4.setClassLoader(getClass().getClassLoader());
                        com.baidu.swan.games.subpackage.b.a((SwanGameSubPackageAPSInfo) bundle4.getParcelable("ai_apps_data"), message.arg1);
                        return;
                    case 12:
                        com.baidu.swan.apps.process.messaging.a.a.n(message);
                        return;
                    case 13:
                        b(message, swanAppMessengerService);
                        return;
                    case 14:
                        c(message, swanAppMessengerService);
                        return;
                    case 15:
                        s(message);
                        return;
                    case 300:
                        com.baidu.swan.apps.process.messaging.a.a.m(message);
                        return;
                    default:
                        super.handleMessage(message);
                        return;
                }
            }
        }

        private void a(@NonNull Message message, @NonNull SwanAppMessengerService swanAppMessengerService) {
            a.b a;
            if (SwanAppMessengerService.DEBUG) {
                Log.i(SwanAppMessengerService.TAG, "MSG_TYPE_CS_ON_APP_FOREGROUND");
            }
            SwanAppProcessInfo byId = SwanAppProcessInfo.getById(message.arg1);
            if (byId.isSwanAppProcess() && (a = com.baidu.swan.apps.process.messaging.service.a.Gw().a(byId)) != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                com.baidu.swan.apps.process.messaging.service.a.Gw().a(bundle.getString("app_id"), a);
                com.baidu.swan.apps.process.messaging.service.a.Gw().b(byId);
                try {
                    swanAppMessengerService.registClientBinderCallback(a);
                } catch (NullPointerException e) {
                    if (SwanAppMessengerService.DEBUG) {
                        e.printStackTrace();
                    }
                }
                com.baidu.swan.apps.process.messaging.service.a.Gw().fS("onAppForegroud => " + a.toString());
            }
        }

        private void b(@NonNull Message message, @NonNull SwanAppMessengerService swanAppMessengerService) {
            a.b a;
            SwanAppProcessInfo byId = SwanAppProcessInfo.getById(message.arg1);
            if (byId.isSwanAppProcess() && (a = com.baidu.swan.apps.process.messaging.service.a.Gw().a(byId)) != null) {
                a.aFd = true;
                a.mMessenger = message.replyTo;
                if (message.obj instanceof Bundle) {
                    Bundle bundle = (Bundle) message.obj;
                    bundle.setClassLoader(getClass().getClassLoader());
                    Parcelable parcelable = bundle.getParcelable("app_core");
                    a.aFa = parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null;
                    String string = bundle.getString("app_id");
                    if (!TextUtils.isEmpty(string)) {
                        a.fU(string);
                        com.baidu.swan.apps.process.messaging.service.a.Gw().a(string, a);
                    }
                    try {
                        swanAppMessengerService.registClientBinderCallback(a);
                    } catch (NullPointerException e) {
                        if (SwanAppMessengerService.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    com.baidu.swan.apps.process.messaging.service.a.Gw().fS("onConnAck => " + a.toString());
                }
            }
        }

        private void c(@NonNull Message message, @NonNull SwanAppMessengerService swanAppMessengerService) {
            a.b a;
            if (message.obj instanceof Bundle) {
                ((Bundle) message.obj).setClassLoader(getClass().getClassLoader());
                SwanAppProcessInfo byId = SwanAppProcessInfo.getById(message.arg1);
                if (byId.isSwanAppProcess() && (a = com.baidu.swan.apps.process.messaging.service.a.Gw().a(byId)) != null) {
                    a.GG();
                    com.baidu.swan.apps.process.messaging.service.a.Gw().fS("onPreloaded => " + a.toString());
                }
            }
        }

        private void d(@NonNull Message message, @NonNull SwanAppMessengerService swanAppMessengerService) {
            if (SwanAppMessengerService.DEBUG) {
                Log.d(SwanAppMessengerService.TAG, "handleOnActivityRegister arg1: " + message.arg1);
                Log.d(SwanAppMessengerService.TAG, "handleOnActivityRegister obj: " + message.obj);
                Log.d(SwanAppMessengerService.TAG, "handleOnActivityRegister is main looper: " + (Thread.currentThread() == Looper.getMainLooper().getThread()));
            }
            a.b cL = com.baidu.swan.apps.process.messaging.service.a.Gw().cL(message.arg1);
            if (cL != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                Parcelable parcelable = bundle.getParcelable("app_core");
                cL.aFa = parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null;
                String string = bundle.getString("app_id");
                cL.fU(string);
                cL.GD();
                com.baidu.swan.apps.process.messaging.service.a.Gw().a(string, cL);
                try {
                    swanAppMessengerService.sendPendingMessageToClient(cL.GE(), cL.mMessenger);
                } catch (NullPointerException e) {
                    if (SwanAppMessengerService.DEBUG) {
                        e.printStackTrace();
                    }
                }
                com.baidu.swan.apps.process.messaging.service.a.Gw().fS("onLoaded => " + cL.toString());
            }
        }

        private void e(@NonNull Message message, @NonNull SwanAppMessengerService swanAppMessengerService) {
            if (SwanAppMessengerService.DEBUG) {
                Log.d(SwanAppMessengerService.TAG, "unregister client. arg1: " + message.arg1);
            }
            if (message.obj instanceof Bundle) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                swanAppMessengerService.removePendingMessageToClient(bundle.getString("ai_apps_id", ""));
                a.b cL = com.baidu.swan.apps.process.messaging.service.a.Gw().cL(message.arg1);
                if (cL != null) {
                    cL.GC();
                    cL.GD();
                    com.baidu.swan.apps.process.messaging.service.a.Gw().fS("onUnloaded => " + cL.toString());
                }
            }
        }

        private void s(@NonNull Message message) {
            a.b a;
            if (message.obj instanceof Bundle) {
                ((Bundle) message.obj).setClassLoader(getClass().getClassLoader());
                SwanAppProcessInfo byId = SwanAppProcessInfo.getById(message.arg1);
                if (byId.isSwanAppProcess() && (a = com.baidu.swan.apps.process.messaging.service.a.Gw().a(byId)) != null) {
                    a.GJ();
                    com.baidu.swan.apps.process.messaging.service.a.Gw().fS("onRePreloaded => " + a.toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registClientBinderCallback(final a.b bVar) {
        if (bVar != null && bVar.mMessenger != null) {
            com.baidu.swan.apps.process.a.a.a(bVar.mMessenger.getBinder(), new a.InterfaceC0123a() { // from class: com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService.1
                @Override // com.baidu.swan.apps.process.a.a.InterfaceC0123a
                public void Gl() {
                    if (SwanAppMessengerService.DEBUG) {
                        Log.d(SwanAppMessengerService.TAG, "client process goes away:" + bVar.aEZ);
                    }
                    SwanAppMessengerService.this.onConnectionDown(bVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnectionDown(a.b bVar) {
        com.baidu.swan.apps.process.messaging.service.a.Gw().fS("onConnDown => " + bVar);
        if (DEBUG) {
            Log.d(TAG, "unregister client. arg1: " + bVar);
        }
        if (bVar != null) {
            bVar.GB();
        }
        Bundle bundle = new Bundle();
        bundle.putString("bundle_key_preload_preload_scene", "1");
        c.d(this, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sendMessageToClient(SwanAppProcessInfo swanAppProcessInfo, int i) {
        return sendMessageToClient(com.baidu.swan.apps.process.messaging.service.a.Gw().a(swanAppProcessInfo), i);
    }

    private boolean sendMessageToClient(a.b bVar, int i) {
        Messenger messenger;
        if (bVar == null || (messenger = bVar.mMessenger) == null) {
            return false;
        }
        try {
            messenger.send(Message.obtain(null, i, generateMessageData(i)));
            return true;
        } catch (RemoteException e) {
            onConnectionDown(bVar);
            if (DEBUG) {
                Log.e(TAG, Log.getStackTraceString(e));
                return false;
            }
            return false;
        }
    }

    public boolean sendMessageToClient(int i, int i2, Bundle bundle) {
        return sendMessageToClient(SwanAppProcessInfo.getById(i), i2, bundle);
    }

    public boolean sendMessageToClient(SwanAppProcessInfo swanAppProcessInfo, int i, Bundle bundle) {
        return sendMessageToClient(com.baidu.swan.apps.process.messaging.service.a.Gw().a(swanAppProcessInfo), i, bundle);
    }

    public boolean sendMessageToClient(a.b bVar, int i, Bundle bundle) {
        Messenger messenger;
        if (bVar == null || (messenger = bVar.mMessenger) == null) {
            return false;
        }
        try {
            messenger.send(Message.obtain(null, i, bundle));
            return true;
        } catch (RemoteException e) {
            onConnectionDown(bVar);
            if (DEBUG) {
                Log.e(TAG, Log.getStackTraceString(e));
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePendingMessageToClient(String str) {
        LinkedList<Message> linkedList;
        if (!TextUtils.isEmpty(str) && (linkedList = sPendingMsgMap.get(str)) != null) {
            if (DEBUG) {
                Log.d(TAG, "remove pending message from map, appId=" + str);
            }
            linkedList.clear();
            sPendingMsgMap.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPendingMessageToClient(String str, Messenger messenger) {
        LinkedList<Message> linkedList;
        if (!TextUtils.isEmpty(str) && messenger != null && (linkedList = sPendingMsgMap.get(str)) != null && linkedList.size() != 0) {
            while (linkedList.size() != 0) {
                try {
                    if (DEBUG) {
                        Log.d(TAG, "send pending message to aiapp, appId=" + str);
                    }
                    messenger.send(linkedList.removeFirst());
                } catch (RemoteException | NoSuchElementException e) {
                    if (DEBUG) {
                        Log.e(TAG, Log.getStackTraceString(e));
                    }
                }
            }
        }
    }

    public static void storePendingMessageToClient(String str, int i, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            Message obtain = Message.obtain(null, i, bundle);
            LinkedList<Message> linkedList = sPendingMsgMap.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                sPendingMsgMap.put(str, linkedList);
            }
            if (DEBUG) {
                Log.d(TAG, "store pending message to aiapp, appId=" + str);
            }
            linkedList.add(obtain);
        }
    }

    public boolean sendMessageWithDataToAllClient(int i, String str) {
        Iterator<a.b> it = com.baidu.swan.apps.process.messaging.service.a.Gw().Gx().iterator();
        while (it.hasNext()) {
            a.b next = it.next();
            if (next != null && next.aFd && next.mMessenger != null) {
                Bundle generateMessageData = generateMessageData(i);
                generateMessageData.putString("ai_apps_data", str);
                try {
                    next.mMessenger.send(Message.obtain(null, i, generateMessageData));
                } catch (RemoteException e) {
                    onConnectionDown(next);
                    if (DEBUG) {
                        Log.e(TAG, Log.getStackTraceString(e));
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean sendMessageWithDataToAllClient(int i, long j) {
        Iterator<a.b> it = com.baidu.swan.apps.process.messaging.service.a.Gw().Gx().iterator();
        while (it.hasNext()) {
            a.b next = it.next();
            if (next != null && next.aFd && next.mMessenger != null) {
                Bundle generateMessageData = generateMessageData(i);
                generateMessageData.putLong("ai_apps_data", j);
                try {
                    next.mMessenger.send(Message.obtain(null, i, generateMessageData));
                } catch (RemoteException e) {
                    onConnectionDown(next);
                    if (DEBUG) {
                        Log.e(TAG, Log.getStackTraceString(e));
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean sendMessageToAllClients(int i) {
        return sendMessageToAllClients(i, null);
    }

    public boolean sendMessageToAllClients(int i, int[] iArr) {
        TreeSet treeSet = new TreeSet();
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                treeSet.add(Integer.valueOf(i2));
            }
        }
        Iterator<a.b> it = com.baidu.swan.apps.process.messaging.service.a.Gw().Gx().iterator();
        boolean z = true;
        while (it.hasNext()) {
            a.b next = it.next();
            if (next != null && next.aFd && !treeSet.contains(Integer.valueOf(next.aEZ.id))) {
                z = !sendMessageToClient(next, i) ? false : z;
            }
        }
        return z;
    }

    private Bundle generateMessageData(int i) {
        Bundle bundle = new Bundle();
        switch (i) {
            case 100:
            case 101:
            case 102:
            default:
                return bundle;
        }
    }

    public void sendDelegationMessage(@Nullable int i, @Nullable Bundle bundle, @NonNull Class<? extends com.baidu.swan.apps.process.b.a.a> cls, @Nullable com.baidu.swan.apps.process.b.b.c.c cVar) {
        Messenger messenger;
        if (DEBUG) {
            Log.d(TAG, "sendMessageToClient: delegation: " + cls.getName());
        }
        Message obtain = Message.obtain((Handler) null, 301);
        obtain.replyTo = this.mMessenger;
        Bundle bundle2 = new Bundle();
        bundle2.putString("ai_apps_delegation_name", cls.getName());
        if (cVar != null) {
            bundle2.putString("ai_apps_observer_id", cVar.Gm());
            com.baidu.swan.apps.process.b.b.b.a.Gn().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        obtain.obj = bundle2;
        try {
            a.b a2 = com.baidu.swan.apps.process.messaging.service.a.Gw().a(SwanAppProcessInfo.getById(i));
            if (a2 != null && (messenger = a2.mMessenger) != null) {
                messenger.send(obtain);
            }
        } catch (RemoteException e) {
            if (DEBUG) {
                Log.e(TAG, Log.getStackTraceString(e));
            }
        }
    }

    public void sendDelegationMessageToAllClient(@Nullable Bundle bundle, @NonNull Class<? extends com.baidu.swan.apps.process.b.a.a> cls) {
        Iterator<a.b> it = com.baidu.swan.apps.process.messaging.service.a.Gw().Gx().iterator();
        while (it.hasNext()) {
            a.b next = it.next();
            if (next != null && next.aFd) {
                sendDelegationMessage(next.aEZ.id, bundle, cls, null);
            }
        }
    }
}
