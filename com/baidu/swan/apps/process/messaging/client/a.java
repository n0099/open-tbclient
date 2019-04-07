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
    private f aEQ;
    private Messenger aER;
    private g aES;
    private e aET;
    private final List<C0154a> aEU;
    public final ServiceConnection aEV;
    private Messenger mMessenger;

    /* loaded from: classes2.dex */
    public interface d {
        boolean j(Message message);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void Gs();

        void Gt();
    }

    /* loaded from: classes2.dex */
    public static class c implements com.baidu.swan.apps.an.c.b<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.c.b
        /* renamed from: Gr */
        public a uR() {
            return new a();
        }
    }

    public static a Go() {
        return com.baidu.swan.apps.ae.e.Jm().aOb.get();
    }

    private a() {
        this.aEQ = new f();
        this.mMessenger = new Messenger(this.aEQ);
        this.aEU = new ArrayList();
        this.aEV = new ServiceConnection() { // from class: com.baidu.swan.apps.process.messaging.client.a.3
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (a.DEBUG) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder));
                }
                if (a.this.Gp() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                    if (a.DEBUG) {
                        Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(a.this.Gp()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                        return;
                    }
                    return;
                }
                a.this.aER = new Messenger(iBinder);
                a.this.c(iBinder);
                Bundle bundle = new Bundle();
                bundle.putInt("process_id", SwanAppProcessInfo.current().id);
                if (a.this.aES != null) {
                    bundle.putString("app_id", a.this.aES.appId);
                    if (a.this.aES.aFa != null) {
                        bundle.putParcelable("app_core", a.this.aES.aFa);
                    }
                }
                a.this.e(13, bundle);
                if (a.this.aET != null) {
                    a.this.aET.Gs();
                }
                if (a.DEBUG) {
                    Log.i("SwanAppMessengerClient", "onServiceConnected: mMsgCachedList.size" + a.this.aEU.size());
                }
                synchronized (a.this.aEU) {
                    if (a.this.aEU.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (C0154a c0154a : a.this.aEU) {
                            arrayList.add(c0154a);
                            if (c0154a.aEX instanceof SwanAppIPCData) {
                                a.this.a(c0154a.msgType, (SwanAppIPCData) c0154a.aEX);
                            } else if (c0154a.aEX instanceof b) {
                                b bVar = (b) c0154a.aEX;
                                a.this.a(bVar.mParams, bVar.mDelegation, bVar.aEY);
                            } else if (c0154a.aEX instanceof Bundle) {
                                a.this.e(c0154a.msgType, (Bundle) c0154a.aEX);
                            } else {
                                a.this.o(c0154a.msgType, c0154a.aEX == null ? "" : c0154a.aEX.toString());
                            }
                        }
                        a.this.aEU.removeAll(arrayList);
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "onServiceDisconnected");
                }
                a.this.Gq();
            }
        };
    }

    public void a(g gVar, e eVar, d dVar) {
        this.aES = gVar;
        this.aET = eVar;
        this.aEQ.a(dVar);
        if (DEBUG) {
            Log.d("SwanAppMessengerClient", "bindSwanAppInfo : mBindInfo=" + this.aES.toString());
        }
        Bundle bundle = new Bundle();
        bundle.putInt("process_id", SwanAppProcessInfo.current().id);
        if (this.aES != null) {
            bundle.putString("app_id", this.aES.appId);
            if (this.aES.aFa != null) {
                bundle.putParcelable("app_core", this.aES.aFa);
            }
        }
        e(1, bundle);
        if (this.aET != null && Gp()) {
            this.aET.Gs();
        }
    }

    public boolean Gp() {
        return this.aER != null;
    }

    public void BI() {
        this.aES = null;
        sendMessage(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(IBinder iBinder) {
        if (iBinder != null) {
            com.baidu.swan.apps.process.a.a.a(iBinder, new a.InterfaceC0152a() { // from class: com.baidu.swan.apps.process.messaging.client.a.1
                @Override // com.baidu.swan.apps.process.a.a.InterfaceC0152a
                public void Gj() {
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "service process goes away");
                    }
                    a.this.Gq();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gq() {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "onConnectionDown mMsgCachedList.size=" + this.aEU.size());
        }
        aa.j(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.client.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.aER = null;
                if (a.this.aET != null) {
                    a.this.aET.Gt();
                }
                synchronized (a.this.aEU) {
                    a.this.aEU.clear();
                }
                SwanAppLocalService.startForRebindMsgService(SwanAppProcessInfo.current());
            }
        });
    }

    public void a(@Nullable Bundle bundle, @NonNull Class<? extends com.baidu.swan.apps.process.b.a.a> cls) {
        a(bundle, cls, (com.baidu.swan.apps.process.b.b.c.c) null);
    }

    public void a(@Nullable Bundle bundle, @NonNull Class<? extends com.baidu.swan.apps.process.b.a.a> cls, @Nullable com.baidu.swan.apps.process.b.b.c.c cVar) {
        if (this.aER == null || this.mMessenger == null) {
            b bVar = new b();
            bVar.mParams = bundle;
            bVar.mDelegation = cls;
            bVar.aEY = cVar;
            this.aEU.add(new C0154a(12, bVar));
            if (DEBUG) {
                Log.d("SwanAppMessengerClient", String.format("sendMessage Cached(%d) msg(%d) deleData(%s)", Integer.valueOf(this.aEU.size()), 12, bVar.toString()));
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
            bundle2.putString("ai_apps_observer_id", cVar.Gk());
            com.baidu.swan.apps.process.b.b.b.a.Gl().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        bundle2.putString("ai_apps_id", getAppId());
        obtain.obj = bundle2;
        try {
            this.aER.send(obtain);
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
        if (this.aER == null || this.mMessenger == null || !current.isSwanAppProcess()) {
            if (i == 6) {
                this.aEU.add(new C0154a(i, str));
                if (DEBUG) {
                    Log.d("SwanAppMessengerClient", String.format("sendMessage Cached(%d) msg(%d) strData(%s)", Integer.valueOf(this.aEU.size()), Integer.valueOf(i), str));
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
            this.aER.send(obtain);
        } catch (RemoteException e2) {
            if (DEBUG) {
                Log.e("SwanAppMessengerClient", Log.getStackTraceString(e2));
            }
        }
    }

    @Deprecated
    public void a(int i, SwanAppIPCData swanAppIPCData) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        if (this.aER == null || this.mMessenger == null || !current.isSwanAppProcess()) {
            if (i == 6) {
                if (DEBUG) {
                    Log.d("SwanAppMessengerClient", String.format("sendMessage Cached(%d) msg(%d) ipcData(%s)", Integer.valueOf(this.aEU.size()), Integer.valueOf(i), swanAppIPCData.toString()));
                }
                this.aEU.add(new C0154a(i, swanAppIPCData));
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
            this.aER.send(obtain);
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
        if (this.aER == null || this.mMessenger == null) {
            if (DEBUG) {
                Log.i("SwanAppMessengerClient", "sendMessage: msgType=" + obtain + " Bundle=" + bundle);
            }
            this.aEU.add(new C0154a(i, bundle));
            if (DEBUG) {
                Log.d("SwanAppMessengerClient", String.format("sendMessage Cached(%d) msg(%d) bData(%s)", Integer.valueOf(this.aEU.size()), Integer.valueOf(i), bundle));
                return;
            }
            return;
        }
        try {
            this.aER.send(obtain);
        } catch (RemoteException e2) {
            if (DEBUG) {
                Log.e("SwanAppMessengerClient", Log.getStackTraceString(e2));
            }
        }
    }

    public String getAppId() {
        return this.aES == null ? "" : this.aES.appId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class f extends Handler {
        private WeakReference<d> aEZ;

        private f() {
        }

        public void a(d dVar) {
            this.aEZ = new WeakReference<>(dVar);
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
                    d dVar = this.aEZ != null ? this.aEZ.get() : null;
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
            Uri hM;
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                SwanAppPreHandleInfo swanAppPreHandleInfo = (SwanAppPreHandleInfo) bundle.getParcelable("ai_apps_data");
                if (swanAppPreHandleInfo != null) {
                    if (!TextUtils.isEmpty(swanAppPreHandleInfo.iconUrl) && (hM = aa.hM(swanAppPreHandleInfo.iconUrl)) != null) {
                        if (a.DEBUG) {
                            Log.i("SwanAppMessengerClient", "handle prefetch icon by fresco");
                        }
                        l.a(hM, "SwanAppMessengerClient");
                    }
                    if (!TextUtils.isEmpty(swanAppPreHandleInfo.appId) && !TextUtils.isEmpty(swanAppPreHandleInfo.version) && swanAppPreHandleInfo.category == 0) {
                        if (a.DEBUG) {
                            Log.i("SwanAppMessengerClient", "pre handle config");
                        }
                        com.baidu.swan.apps.core.g.a.zN().af(swanAppPreHandleInfo.appId, swanAppPreHandleInfo.version);
                    }
                }
            }
        }

        private void q(Message message) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", "handleKillActivity");
            }
            com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
            if (IV != null) {
                com.baidu.swan.apps.an.b.K(IV.getActivity());
            }
        }

        private void r(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.ae.b.Jg())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check swanCore version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0 && com.baidu.swan.apps.core.i.c.Aa().Ar() != null && com.baidu.swan.apps.core.i.c.Aa().Ar().aTg < j) {
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + com.baidu.swan.apps.core.i.c.Aa().Ar());
                        }
                        a.Go().sendMessage(15);
                        com.baidu.swan.apps.core.i.c.release();
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class g {
        public SwanAppCores aFa;
        public String appId;

        public String toString() {
            return String.format("%s appid(%s)\n swanAppCores(%s)", super.toString(), this.appId, this.aFa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.client.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0154a<T> {
        private T aEX;
        private int msgType;

        C0154a(int i, T t) {
            this.msgType = i;
            this.aEX = t;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        @Nullable
        private com.baidu.swan.apps.process.b.b.c.c aEY;
        private Class<? extends com.baidu.swan.apps.process.b.a.a> mDelegation;
        @Nullable
        private Bundle mParams;

        private b() {
        }
    }
}
