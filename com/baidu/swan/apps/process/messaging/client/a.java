package com.baidu.swan.apps.process.messaging.client;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.l;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.apps.process.SwanAppPreHandleInfo;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.a.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private f aEN;
    private Messenger aEO;
    private g aEP;
    private e aEQ;
    private final List<C0154a> aER;
    public final ServiceConnection aES;
    private Messenger mMessenger;

    /* loaded from: classes2.dex */
    public interface d {
        boolean j(Message message);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void Gu();

        void Gv();
    }

    /* loaded from: classes2.dex */
    public static class c implements com.baidu.swan.apps.an.c.b<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.c.b
        /* renamed from: Gt */
        public a uS() {
            return new a();
        }
    }

    public static a Gq() {
        return com.baidu.swan.apps.ae.e.Jo().aNY.get();
    }

    private a() {
        this.aEN = new f();
        this.mMessenger = new Messenger(this.aEN);
        this.aER = new ArrayList();
        this.aES = new ServiceConnection() { // from class: com.baidu.swan.apps.process.messaging.client.a.3
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (a.DEBUG) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder));
                }
                if (a.this.Gr() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                    if (a.DEBUG) {
                        Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(a.this.Gr()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                        return;
                    }
                    return;
                }
                a.this.aEO = new Messenger(iBinder);
                a.this.c(iBinder);
                Bundle bundle = new Bundle();
                bundle.putInt("process_id", SwanAppProcessInfo.current().id);
                if (a.this.aEP != null) {
                    bundle.putString("app_id", a.this.aEP.appId);
                    if (a.this.aEP.aEX != null) {
                        bundle.putParcelable("app_core", a.this.aEP.aEX);
                    }
                }
                a.this.e(13, bundle);
                if (a.this.aEQ != null) {
                    a.this.aEQ.Gu();
                }
                if (a.DEBUG) {
                    Log.i("SwanAppMessengerClient", "onServiceConnected: mMsgCachedList.size" + a.this.aER.size());
                }
                synchronized (a.this.aER) {
                    if (a.this.aER.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (C0154a c0154a : a.this.aER) {
                            arrayList.add(c0154a);
                            if (c0154a.aEU instanceof SwanAppIPCData) {
                                a.this.a(c0154a.msgType, (SwanAppIPCData) c0154a.aEU);
                            } else if (c0154a.aEU instanceof b) {
                                b bVar = (b) c0154a.aEU;
                                a.this.a(bVar.mParams, bVar.mDelegation, bVar.aEV);
                            } else if (c0154a.aEU instanceof Bundle) {
                                a.this.e(c0154a.msgType, (Bundle) c0154a.aEU);
                            } else {
                                a.this.o(c0154a.msgType, c0154a.aEU == null ? "" : c0154a.aEU.toString());
                            }
                        }
                        a.this.aER.removeAll(arrayList);
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "onServiceDisconnected");
                }
                a.this.Gs();
            }
        };
    }

    public void a(g gVar, e eVar, d dVar) {
        this.aEP = gVar;
        this.aEQ = eVar;
        this.aEN.a(dVar);
        if (DEBUG) {
            Log.d("SwanAppMessengerClient", "bindSwanAppInfo : mBindInfo=" + this.aEP.toString());
        }
        Bundle bundle = new Bundle();
        bundle.putInt("process_id", SwanAppProcessInfo.current().id);
        if (this.aEP != null) {
            bundle.putString("app_id", this.aEP.appId);
            if (this.aEP.aEX != null) {
                bundle.putParcelable("app_core", this.aEP.aEX);
            }
        }
        e(1, bundle);
        if (this.aEQ != null && Gr()) {
            this.aEQ.Gu();
        }
    }

    public boolean Gr() {
        return this.aEO != null;
    }

    public void BK() {
        this.aEP = null;
        sendMessage(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(IBinder iBinder) {
        if (iBinder != null) {
            com.baidu.swan.apps.process.a.a.a(iBinder, new a.InterfaceC0152a() { // from class: com.baidu.swan.apps.process.messaging.client.a.1
                @Override // com.baidu.swan.apps.process.a.a.InterfaceC0152a
                public void Gl() {
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "service process goes away");
                    }
                    a.this.Gs();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gs() {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "onConnectionDown mMsgCachedList.size=" + this.aER.size());
        }
        aa.j(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.client.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.aEO = null;
                if (a.this.aEQ != null) {
                    a.this.aEQ.Gv();
                }
                synchronized (a.this.aER) {
                    a.this.aER.clear();
                }
                SwanAppLocalService.startForRebindMsgService(SwanAppProcessInfo.current());
            }
        });
    }

    public void a(@Nullable Bundle bundle, @NonNull Class<? extends com.baidu.swan.apps.process.b.a.a> cls) {
        a(bundle, cls, (com.baidu.swan.apps.process.b.b.c.c) null);
    }

    public void a(@Nullable Bundle bundle, @NonNull Class<? extends com.baidu.swan.apps.process.b.a.a> cls, @Nullable com.baidu.swan.apps.process.b.b.c.c cVar) {
        if (this.aEO == null || this.mMessenger == null) {
            b bVar = new b();
            bVar.mParams = bundle;
            bVar.mDelegation = cls;
            bVar.aEV = cVar;
            this.aER.add(new C0154a(12, bVar));
            if (DEBUG) {
                Log.d("SwanAppMessengerClient", String.format("sendMessage Cached(%d) msg(%d) deleData(%s)", Integer.valueOf(this.aER.size()), 12, bVar.toString()));
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMessengerClient", "sendMessageToClient: delegation: " + cls.getName());
        }
        Message obtain = Message.obtain((Handler) null, 12);
        obtain.replyTo = this.mMessenger;
        obtain.arg1 = SwanAppProcessInfo.current().id;
        Bundle bundle2 = new Bundle();
        bundle2.putString("ai_apps_delegation_name", cls.getName());
        if (cVar != null) {
            bundle2.putString("ai_apps_observer_id", cVar.Gm());
            com.baidu.swan.apps.process.b.b.b.a.Gn().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        bundle2.putString("ai_apps_id", getAppId());
        obtain.obj = bundle2;
        try {
            this.aEO.send(obtain);
        } catch (RemoteException e2) {
            if (DEBUG) {
                Log.e("SwanAppMessengerClient", Log.getStackTraceString(e2));
            }
        }
    }

    @Deprecated
    public void sendMessage(int i) {
        o(i, "");
    }

    @Deprecated
    public void o(int i, String str) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        if (this.aEO == null || this.mMessenger == null || !current.isSwanAppProcess()) {
            if (i == 6) {
                this.aER.add(new C0154a(i, str));
                if (DEBUG) {
                    Log.d("SwanAppMessengerClient", String.format("sendMessage Cached(%d) msg(%d) strData(%s)", Integer.valueOf(this.aER.size()), Integer.valueOf(i), str));
                    return;
                }
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMessengerClient", "sendMessage msgType:" + i + " strData: " + str);
        }
        Message obtain = Message.obtain((Handler) null, i);
        obtain.replyTo = this.mMessenger;
        obtain.arg1 = current.id;
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("ai_apps_data", str);
        }
        bundle.putString("ai_apps_id", getAppId());
        obtain.obj = bundle;
        try {
            this.aEO.send(obtain);
        } catch (RemoteException e2) {
            if (DEBUG) {
                Log.e("SwanAppMessengerClient", Log.getStackTraceString(e2));
            }
        }
    }

    @Deprecated
    public void a(int i, SwanAppIPCData swanAppIPCData) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        if (this.aEO == null || this.mMessenger == null || !current.isSwanAppProcess()) {
            if (i == 6) {
                if (DEBUG) {
                    Log.d("SwanAppMessengerClient", String.format("sendMessage Cached(%d) msg(%d) ipcData(%s)", Integer.valueOf(this.aER.size()), Integer.valueOf(i), swanAppIPCData.toString()));
                }
                this.aER.add(new C0154a(i, swanAppIPCData));
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMessengerClient", "sendMessage msgType:" + i + " ipcData: " + swanAppIPCData);
        }
        Message obtain = Message.obtain((Handler) null, i);
        obtain.replyTo = this.mMessenger;
        obtain.arg1 = current.id;
        Bundle bundle = new Bundle();
        if (swanAppIPCData != null) {
            bundle.putParcelable("ai_apps_data", swanAppIPCData);
        }
        bundle.putString("ai_apps_id", getAppId());
        obtain.obj = bundle;
        try {
            this.aEO.send(obtain);
        } catch (RemoteException e2) {
            if (DEBUG) {
                Log.e("SwanAppMessengerClient", Log.getStackTraceString(e2));
            }
        }
    }

    public void e(int i, Bundle bundle) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        Message obtain = Message.obtain(null, i, bundle);
        obtain.replyTo = this.mMessenger;
        obtain.arg1 = current.id;
        obtain.obj = bundle;
        if (this.aEO == null || this.mMessenger == null) {
            if (DEBUG) {
                Log.i("SwanAppMessengerClient", "sendMessage: msgType=" + obtain + " Bundle=" + bundle);
            }
            this.aER.add(new C0154a(i, bundle));
            if (DEBUG) {
                Log.d("SwanAppMessengerClient", String.format("sendMessage Cached(%d) msg(%d) bData(%s)", Integer.valueOf(this.aER.size()), Integer.valueOf(i), bundle));
                return;
            }
            return;
        }
        try {
            this.aEO.send(obtain);
        } catch (RemoteException e2) {
            if (DEBUG) {
                Log.e("SwanAppMessengerClient", Log.getStackTraceString(e2));
            }
        }
    }

    public String getAppId() {
        return this.aEP == null ? "" : this.aEP.appId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class f extends Handler {
        private WeakReference<d> aEW;

        private f() {
        }

        public void a(d dVar) {
            this.aEW = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 108:
                    p(message);
                    return;
                case 109:
                    com.baidu.swan.apps.performance.f.k(message);
                    return;
                case 110:
                    q(message);
                    return;
                case 111:
                case 112:
                case 113:
                default:
                    d dVar = this.aEW != null ? this.aEW.get() : null;
                    if (dVar == null || !dVar.j(message)) {
                        super.handleMessage(message);
                        return;
                    }
                    return;
                case 114:
                    r(message);
                    return;
            }
        }

        private void p(Message message) {
            Uri hL;
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                SwanAppPreHandleInfo swanAppPreHandleInfo = (SwanAppPreHandleInfo) bundle.getParcelable("ai_apps_data");
                if (swanAppPreHandleInfo != null) {
                    if (!TextUtils.isEmpty(swanAppPreHandleInfo.iconUrl) && (hL = aa.hL(swanAppPreHandleInfo.iconUrl)) != null) {
                        if (a.DEBUG) {
                            Log.i("SwanAppMessengerClient", "handle prefetch icon by fresco");
                        }
                        l.a(hL, "SwanAppMessengerClient");
                    }
                    if (!TextUtils.isEmpty(swanAppPreHandleInfo.appId) && !TextUtils.isEmpty(swanAppPreHandleInfo.version) && swanAppPreHandleInfo.category == 0) {
                        if (a.DEBUG) {
                            Log.i("SwanAppMessengerClient", "pre handle config");
                        }
                        com.baidu.swan.apps.core.g.a.zO().af(swanAppPreHandleInfo.appId, swanAppPreHandleInfo.version);
                    }
                }
            }
        }

        private void q(Message message) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", "handleKillActivity");
            }
            com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
            if (IX != null) {
                com.baidu.swan.apps.an.b.K(IX.getActivity());
            }
        }

        private void r(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.ae.b.Ji())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check swanCore version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0 && com.baidu.swan.apps.core.i.c.Ab().As() != null && com.baidu.swan.apps.core.i.c.Ab().As().aTd < j) {
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + com.baidu.swan.apps.core.i.c.Ab().As());
                        }
                        a.Gq().sendMessage(15);
                        com.baidu.swan.apps.core.i.c.release();
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class g {
        public SwanAppCores aEX;
        public String appId;

        public String toString() {
            return String.format("%s appid(%s)\n swanAppCores(%s)", super.toString(), this.appId, this.aEX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.client.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0154a<T> {
        private T aEU;
        private int msgType;

        C0154a(int i, T t) {
            this.msgType = i;
            this.aEU = t;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        @Nullable
        private com.baidu.swan.apps.process.b.b.c.c aEV;
        private Class<? extends com.baidu.swan.apps.process.b.a.a> mDelegation;
        @Nullable
        private Bundle mParams;

        private b() {
        }
    }
}
