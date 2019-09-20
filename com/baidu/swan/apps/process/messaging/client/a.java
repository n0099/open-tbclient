package com.baidu.swan.apps.process.messaging.client;

import android.content.ComponentName;
import android.content.Intent;
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
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.m;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.apps.process.SwanAppPreHandleInfo;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.a.a;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private f aHQ;
    private Messenger aHR;
    private g aHS;
    private e aHT;
    private final List<C0170a> aHU;
    public final ServiceConnection aHV;
    private Messenger mMessenger;

    /* loaded from: classes2.dex */
    public interface d {
        boolean j(Message message);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void JA();

        void Jz();
    }

    /* loaded from: classes2.dex */
    public static class c implements com.baidu.swan.apps.an.d.b<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.d.b
        /* renamed from: Jy */
        public a wg() {
            return new a();
        }
    }

    public static a Jv() {
        return com.baidu.swan.apps.ae.e.Mz().aRn.get();
    }

    private a() {
        this.aHQ = new f();
        this.mMessenger = new Messenger(this.aHQ);
        this.aHU = new ArrayList();
        this.aHV = new ServiceConnection() { // from class: com.baidu.swan.apps.process.messaging.client.a.3
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (a.DEBUG) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder));
                }
                if (a.this.Jw() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                    if (a.DEBUG) {
                        Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(a.this.Jw()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                        return;
                    }
                    return;
                }
                a.this.aHR = new Messenger(iBinder);
                a.this.c(iBinder);
                Bundle bundle = new Bundle();
                bundle.putInt("process_id", SwanAppProcessInfo.current().id);
                if (a.this.aHS != null) {
                    bundle.putString(Constants.APP_ID, a.this.aHS.appId);
                    if (a.this.aHS.aIa != null) {
                        bundle.putParcelable("app_core", a.this.aHS.aIa);
                    }
                }
                a.this.e(13, bundle);
                if (a.this.aHT != null) {
                    a.this.aHT.Jz();
                }
                if (a.DEBUG) {
                    Log.i("SwanAppMessengerClient", "onServiceConnected: mMsgCachedList.size" + a.this.aHU.size());
                }
                if (a.this.aHU.size() > 0) {
                    Iterator it = a.this.aHU.iterator();
                    while (it.hasNext()) {
                        C0170a c0170a = (C0170a) it.next();
                        if (c0170a.aHX instanceof SwanAppIPCData) {
                            a.this.a(c0170a.msgType, (SwanAppIPCData) c0170a.aHX);
                        } else if (c0170a.aHX instanceof b) {
                            b bVar = (b) c0170a.aHX;
                            a.this.a(bVar.mParams, bVar.mDelegation, bVar.aHY);
                        } else if (c0170a.aHX instanceof Bundle) {
                            a.this.e(c0170a.msgType, (Bundle) c0170a.aHX);
                        } else {
                            a.this.p(c0170a.msgType, c0170a.aHX == null ? "" : c0170a.aHX.toString());
                        }
                        it.remove();
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "onServiceDisconnected");
                }
                a.this.Jx();
            }
        };
    }

    public void a(g gVar, e eVar, d dVar) {
        this.aHS = gVar;
        this.aHT = eVar;
        this.aHQ.a(dVar);
        if (DEBUG) {
            Log.d("SwanAppMessengerClient", "bindSwanAppInfo : mBindInfo=" + this.aHS.toString());
        }
        Bundle bundle = new Bundle();
        bundle.putInt("process_id", SwanAppProcessInfo.current().id);
        if (this.aHS != null) {
            bundle.putString(Constants.APP_ID, this.aHS.appId);
            if (this.aHS.aIa != null) {
                bundle.putParcelable("app_core", this.aHS.aIa);
            }
        }
        e(1, bundle);
        if (this.aHT != null && Jw()) {
            this.aHT.Jz();
        }
    }

    public boolean Jw() {
        return this.aHR != null;
    }

    public void Dx() {
        this.aHS = null;
        sendMessage(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(IBinder iBinder) {
        if (iBinder != null) {
            com.baidu.swan.apps.process.a.a.a(iBinder, new a.InterfaceC0168a() { // from class: com.baidu.swan.apps.process.messaging.client.a.1
                @Override // com.baidu.swan.apps.process.a.a.InterfaceC0168a
                public void Jq() {
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "service process goes away");
                    }
                    a.this.Jx();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jx() {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "onConnectionDown mMsgCachedList.size=" + this.aHU.size());
        }
        ac.k(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.client.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.aHR = null;
                if (a.this.aHT != null) {
                    a.this.aHT.JA();
                }
                a.this.aHU.clear();
            }
        });
        SwanAppLocalService.startForRebindMsgService(SwanAppProcessInfo.current());
    }

    public void a(@Nullable Bundle bundle, @NonNull Class<? extends com.baidu.swan.apps.process.b.a.a> cls) {
        a(bundle, cls, (com.baidu.swan.apps.process.b.b.c.c) null);
    }

    public void a(@Nullable Bundle bundle, @NonNull Class<? extends com.baidu.swan.apps.process.b.a.a> cls, @Nullable com.baidu.swan.apps.process.b.b.c.c cVar) {
        if (this.aHR == null || this.mMessenger == null) {
            b bVar = new b();
            bVar.mParams = bundle;
            bVar.mDelegation = cls;
            bVar.aHY = cVar;
            this.aHU.add(new C0170a(12, bVar));
            if (DEBUG) {
                Log.d("SwanAppMessengerClient", String.format("sendMessage Cached(%d) msg(%d) deleData(%s)", Integer.valueOf(this.aHU.size()), 12, bVar.toString()));
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
            bundle2.putString("ai_apps_observer_id", cVar.Jr());
            com.baidu.swan.apps.process.b.b.b.a.Js().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        bundle2.putString("ai_apps_id", getAppId());
        obtain.obj = bundle2;
        try {
            this.aHR.send(obtain);
        } catch (RemoteException e2) {
            if (DEBUG) {
                Log.e("SwanAppMessengerClient", Log.getStackTraceString(e2));
            }
        }
    }

    @Deprecated
    public void sendMessage(int i) {
        p(i, "");
    }

    @Deprecated
    public void p(int i, String str) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        if (this.aHR == null || this.mMessenger == null || !current.isSwanAppProcess()) {
            if (i == 6) {
                this.aHU.add(new C0170a(i, str));
                if (DEBUG) {
                    Log.d("SwanAppMessengerClient", String.format("sendMessage Cached(%d) msg(%d) strData(%s)", Integer.valueOf(this.aHU.size()), Integer.valueOf(i), str));
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
            this.aHR.send(obtain);
        } catch (RemoteException e2) {
            if (DEBUG) {
                Log.e("SwanAppMessengerClient", Log.getStackTraceString(e2));
            }
        }
    }

    @Deprecated
    public void a(int i, SwanAppIPCData swanAppIPCData) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        if (this.aHR == null || this.mMessenger == null || !current.isSwanAppProcess()) {
            if (i == 6) {
                if (DEBUG) {
                    Log.d("SwanAppMessengerClient", String.format("sendMessage Cached(%d) msg(%d) ipcData(%s)", Integer.valueOf(this.aHU.size()), Integer.valueOf(i), swanAppIPCData.toString()));
                }
                this.aHU.add(new C0170a(i, swanAppIPCData));
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
            this.aHR.send(obtain);
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
        if (this.aHR == null || this.mMessenger == null) {
            if (DEBUG) {
                Log.i("SwanAppMessengerClient", "sendMessage: msgType=" + obtain + " Bundle=" + bundle);
            }
            this.aHU.add(new C0170a(i, bundle));
            if (DEBUG) {
                Log.d("SwanAppMessengerClient", String.format("sendMessage Cached(%d) msg(%d) bData(%s)", Integer.valueOf(this.aHU.size()), Integer.valueOf(i), bundle));
                return;
            }
            return;
        }
        try {
            this.aHR.send(obtain);
        } catch (RemoteException e2) {
            if (DEBUG) {
                Log.e("SwanAppMessengerClient", Log.getStackTraceString(e2));
            }
        }
    }

    public String getAppId() {
        return this.aHS == null ? "" : this.aHS.appId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class f extends Handler {
        private WeakReference<d> aHZ;

        private f() {
        }

        public void a(d dVar) {
            this.aHZ = new WeakReference<>(dVar);
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
                    d dVar = this.aHZ != null ? this.aHZ.get() : null;
                    if (dVar == null || !dVar.j(message)) {
                        super.handleMessage(message);
                        return;
                    }
                    return;
                case 114:
                    r(message);
                    return;
                case 115:
                    s(message);
                    return;
                case 116:
                    t(message);
                    return;
            }
        }

        private void p(Message message) {
            Uri iy;
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                SwanAppPreHandleInfo swanAppPreHandleInfo = (SwanAppPreHandleInfo) bundle.getParcelable("ai_apps_data");
                if (swanAppPreHandleInfo != null) {
                    if (!TextUtils.isEmpty(swanAppPreHandleInfo.iconUrl) && (iy = ac.iy(swanAppPreHandleInfo.iconUrl)) != null) {
                        if (a.DEBUG) {
                            Log.i("SwanAppMessengerClient", "handle prefetch icon by fresco");
                        }
                        m.a(iy, "SwanAppMessengerClient");
                    }
                    if (!TextUtils.isEmpty(swanAppPreHandleInfo.appId) && !TextUtils.isEmpty(swanAppPreHandleInfo.version) && swanAppPreHandleInfo.avC == 0) {
                        if (a.DEBUG) {
                            Log.i("SwanAppMessengerClient", "pre handle config");
                        }
                        com.baidu.swan.apps.core.h.a.BI().ab(swanAppPreHandleInfo.appId, swanAppPreHandleInfo.version);
                    }
                }
            }
        }

        private void q(Message message) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", "handleKillActivity");
            }
            com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
            if (Mh != null) {
                com.baidu.swan.apps.an.b.O(Mh.getActivity());
            }
        }

        private void r(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.ae.b.Ms())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check swanCore version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0 && com.baidu.swan.apps.core.j.c.BU().Cm() != null && com.baidu.swan.apps.core.j.c.BU().Cm().aXe < j) {
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + com.baidu.swan.apps.core.j.c.BU().Cm());
                        }
                        a.Jv().sendMessage(15);
                        com.baidu.swan.apps.core.j.c.release();
                    }
                }
            }
        }

        private void s(Message message) {
            Bundle bundle;
            com.baidu.swan.apps.aa.a.d dVar;
            if (message != null && (bundle = (Bundle) message.obj) != null && (dVar = com.baidu.swan.apps.aa.d.Ip().aGr) != null) {
                dVar.k(com.baidu.swan.apps.aa.d.cR(bundle.getInt("_wxapi_baseresp_errcode")), bundle.getString("_wxapi_baseresp_errstr"));
            }
        }

        private void t(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                String string = bundle.getString("ai_apps_data");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        com.baidu.swan.apps.scheme.actions.c.a.MX().L(Intent.parseUri(string, 0));
                    } catch (URISyntaxException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class g {
        public SwanAppCores aIa;
        public String appId;

        public String toString() {
            return String.format("%s appid(%s)\n swanAppCores(%s)", super.toString(), this.appId, this.aIa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.client.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0170a<T> {
        private T aHX;
        private int msgType;

        C0170a(int i, T t) {
            this.msgType = i;
            this.aHX = t;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        @Nullable
        private com.baidu.swan.apps.process.b.b.c.c aHY;
        private Class<? extends com.baidu.swan.apps.process.b.a.a> mDelegation;
        @Nullable
        private Bundle mParams;

        private b() {
        }
    }
}
