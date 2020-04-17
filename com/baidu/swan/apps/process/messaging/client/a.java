package com.baidu.swan.apps.process.messaging.client;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.runtime.h;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public final class a extends com.baidu.swan.apps.process.messaging.b {
    private final d cii;
    private Messenger cij;
    private c cik;
    private ServiceConnection cil;
    private final Deque<Long> cim;
    private List<Runnable> cin;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final long cih = TimeUnit.MINUTES.toMillis(5);
    private static final Object QU = new Object();

    /* loaded from: classes11.dex */
    public interface b {
        boolean m(Message message);
    }

    /* loaded from: classes11.dex */
    public interface c {
        void ajm();

        void ajn();
    }

    public a(h hVar) {
        super(hVar);
        this.cii = new d();
        this.cim = new ArrayDeque();
    }

    @Deprecated
    public static a ajd() {
        return com.baidu.swan.apps.runtime.d.akK().akG();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Messenger aje() {
        return this.cij;
    }

    public synchronized void ajf() {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "tryBindRemoteMsgService");
        }
        if (this.cil == null) {
            this.cil = new ServiceConnectionC0303a();
            Application abO = com.baidu.swan.apps.w.a.abO();
            try {
                abO.bindService(new Intent(abO, SwanAppMessengerService.class), this.cil, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler ajg() {
        return this.cii;
    }

    public void a(c cVar, b bVar) {
        this.cik = cVar;
        this.cii.a(bVar);
        d(1, ajl());
        if (this.cik != null && ajh()) {
            this.cik.ajm();
        }
    }

    public boolean ajh() {
        return this.cij != null;
    }

    public void aaD() {
        sendMessage(2);
    }

    public synchronized void aji() {
        this.cil = null;
        this.cij = null;
        if (this.cik != null) {
            this.cik.ajn();
        }
        ajk();
        if (this.cin != null) {
            synchronized (QU) {
                for (Runnable runnable : this.cin) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                this.cin.clear();
            }
        }
    }

    private void lG(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "SwanRebind:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.cim.iterator();
            while (it.hasNext()) {
                Log.i("SwanAppMessengerClient", "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    private boolean ajj() {
        synchronized (this.cim) {
            lG("checkRebindable ===>");
            if (this.cim.size() < 3) {
                lG(String.format(Locale.getDefault(), "allowRebind by size(%d) < max(%d)", Integer.valueOf(this.cim.size()), 3));
                return true;
            }
            int size = this.cim.size() - 3;
            lG("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    lG("purge: " + this.cim.poll());
                }
            }
            lG("after purge");
            Long peek = this.cim.peek();
            if (peek == null) {
                lG("allowRebind by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > cih;
            lG("allowRebind:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void ajk() {
        synchronized (this.cim) {
            if (ajj()) {
                this.cim.offer(Long.valueOf(System.currentTimeMillis()));
                ajf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.client.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class ServiceConnectionC0303a implements ServiceConnection {
        private ServiceConnectionC0303a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder));
            }
            if (a.this.ajh() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                if (a.DEBUG) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(a.this.ajh()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                    return;
                }
                return;
            }
            a.this.cij = new Messenger(iBinder);
            a.this.d(13, a.this.ajl());
            if (a.this.cik != null) {
                a.this.cik.ajm();
            }
            com.baidu.swan.apps.process.messaging.a.aiT().aiU();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (a.DEBUG) {
                Log.d("SwanAppMessengerClient", "onServiceDisconnected");
            }
            a.this.aji();
        }
    }

    public void i(@NonNull Runnable runnable) {
        synchronized (QU) {
            if (this.cin == null) {
                this.cin = new ArrayList();
            }
            this.cin.add(runnable);
        }
    }

    @Deprecated
    public void a(@Nullable Bundle bundle, @NonNull Class<? extends com.baidu.swan.apps.process.a.a.a> cls) {
        a(bundle, cls, null);
    }

    @Deprecated
    public void a(@Nullable Bundle bundle, @NonNull Class<? extends com.baidu.swan.apps.process.a.a.a> cls, @Nullable com.baidu.swan.apps.process.a.b.c.c cVar) {
        if (DEBUG) {
            Log.d("SwanAppMessengerClient", "sendMessageToClient: delegation: " + cls.getName());
        }
        Message obtain = Message.obtain((Handler) null, 12);
        obtain.arg1 = SwanAppProcessInfo.current().index;
        Bundle bundle2 = new Bundle();
        bundle2.putString("ai_apps_delegation_name", cls.getName());
        if (cVar != null) {
            bundle2.putString("ai_apps_observer_id", cVar.aiQ());
            com.baidu.swan.apps.process.a.b.b.a.aiR().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        bundle2.putString("ai_apps_id", getAppId());
        obtain.obj = bundle2;
        com.baidu.swan.apps.process.messaging.a.aiT().a(new com.baidu.swan.apps.process.messaging.c(obtain).eo(true));
    }

    @Deprecated
    public void sendMessage(int i) {
        S(i, "");
    }

    @Deprecated
    public void S(int i, String str) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        if (DEBUG) {
            Log.d("SwanAppMessengerClient", "sendMessage msgType:" + i + " strData: " + str);
        }
        Message obtain = Message.obtain((Handler) null, i);
        obtain.arg1 = current.index;
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("ai_apps_data", str);
        }
        bundle.putString("ai_apps_id", getAppId());
        obtain.obj = bundle;
        com.baidu.swan.apps.process.messaging.a.aiT().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    @Deprecated
    public void a(int i, SwanAppIPCData swanAppIPCData) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        if (DEBUG) {
            Log.d("SwanAppMessengerClient", "sendMessage msgType:" + i + " ipcData: " + swanAppIPCData);
        }
        Message obtain = Message.obtain((Handler) null, i);
        obtain.arg1 = current.index;
        Bundle bundle = new Bundle();
        if (swanAppIPCData != null) {
            bundle.putParcelable("ai_apps_data", swanAppIPCData);
        }
        bundle.putString("ai_apps_id", getAppId());
        obtain.obj = bundle;
        com.baidu.swan.apps.process.messaging.a.aiT().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    public void d(int i, Bundle bundle) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        Message obtain = Message.obtain(null, i, bundle);
        obtain.arg1 = current.index;
        obtain.obj = bundle;
        com.baidu.swan.apps.process.messaging.a.aiT().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    /* loaded from: classes11.dex */
    private static class d extends Handler {
        private WeakReference<b> cip;

        d() {
            super(Looper.getMainLooper());
        }

        public void a(b bVar) {
            this.cip = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", "handleMessage => " + message);
            }
            switch (message.what) {
                case 109:
                    return;
                case 110:
                    r(message);
                    return;
                case 111:
                case 112:
                case 113:
                default:
                    b bVar = this.cip != null ? this.cip.get() : null;
                    if (bVar == null || !bVar.m(message)) {
                        super.handleMessage(message);
                        return;
                    }
                    return;
                case 114:
                    s(message);
                    return;
                case 115:
                    v(message);
                    return;
                case 116:
                    w(message);
                    return;
                case 117:
                    t(message);
                    return;
                case 118:
                    y(message);
                    return;
                case 119:
                    com.baidu.g.d.j((Bundle) message.obj);
                    return;
                case 120:
                    x(message);
                    return;
                case 121:
                    u(message);
                    return;
            }
        }

        private void r(Message message) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", "handleKillActivity");
            }
            if (com.baidu.swan.apps.runtime.d.akK().ajr()) {
                com.baidu.swan.apps.as.c.P(com.baidu.swan.apps.runtime.d.akK().akJ());
            }
        }

        private void s(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.akK().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check swanCore version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0 && com.baidu.swan.apps.core.k.d.Yo().YI() != null && com.baidu.swan.apps.core.k.d.Yo().YI().swanCoreVersion < j) {
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + com.baidu.swan.apps.core.k.d.Yo().YI());
                        }
                        com.baidu.swan.apps.runtime.d.akK().akG().sendMessage(15);
                        com.baidu.swan.apps.core.k.d.release();
                    }
                }
            }
        }

        private void t(Message message) {
            Bundle bundle;
            SwanCoreVersion YI;
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.akK().getAppId()) && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j != 0 && (YI = com.baidu.swan.games.i.a.awo().YI()) != null && YI.swanCoreVersion != 0 && YI.swanCoreVersion < j) {
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + YI);
                    }
                    com.baidu.swan.games.i.a.release();
                }
            }
        }

        private void u(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.akK().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check extension version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0) {
                        ExtensionCore YJ = com.baidu.swan.apps.core.k.d.Yo().YJ();
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + YJ);
                        }
                        if (YJ != null && YJ.extensionCoreVersionCode < j) {
                            if (a.DEBUG) {
                                Log.d("SwanAppMessengerClient", "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + YJ);
                            }
                            com.baidu.swan.apps.runtime.d.akK().akG().sendMessage(15);
                            com.baidu.swan.apps.core.k.d.release();
                        }
                    }
                }
            }
        }

        private void v(Message message) {
            Bundle bundle;
            com.baidu.g.a.a aVar;
            if (message != null && (bundle = (Bundle) message.obj) != null && (aVar = com.baidu.swan.apps.ae.a.ahC().cfW) != null) {
                aVar.onPayResult(com.baidu.swan.apps.ae.a.fK(bundle.getInt("_wxapi_baseresp_errcode")), bundle.getString("_wxapi_baseresp_errstr"));
            }
        }

        private void w(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                String string = bundle.getString("ai_apps_data");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        com.baidu.swan.apps.scheme.actions.d.a.alV().J(Intent.parseUri(string, 0));
                    } catch (URISyntaxException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        private void x(Message message) {
            PMSAppInfo adR;
            Bundle bundle = (Bundle) message.obj;
            bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
            PrefetchEvent prefetchEvent = (PrefetchEvent) bundle.getParcelable("swan_app_bundle_prefetch");
            if (prefetchEvent != null && prefetchEvent.isValid()) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "PrefetchMessage execCall event: " + prefetchEvent);
                }
                if (f(prefetchEvent)) {
                    b.a aVar = new b.a();
                    aVar.g(com.baidu.swan.pms.database.a.aBI().rA(prefetchEvent.appId));
                    com.baidu.swan.apps.runtime.d.akK().c(aVar.toBundle(), "update_tag_by_prefetch");
                }
                e akH = com.baidu.swan.apps.runtime.d.akK().akH();
                if (akH != null && (adR = akH.akQ().adR()) != null && TextUtils.equals(prefetchEvent.appId, adR.appId)) {
                    prefetchEvent.appPath = e.d.aT(prefetchEvent.appId, String.valueOf(adR.versionCode)).getPath() + File.separator;
                    prefetchEvent.appConfig = com.baidu.swan.apps.t.e.p(new File(prefetchEvent.appPath, "app.json"));
                    com.baidu.swan.apps.core.k.d.Yo().a(PrefetchEvent.d(prefetchEvent));
                }
            }
        }

        private boolean f(PrefetchEvent prefetchEvent) {
            com.baidu.swan.apps.runtime.e akO = com.baidu.swan.apps.runtime.e.akO();
            if (akO == null) {
                return true;
            }
            return (akO.available() || TextUtils.equals(akO.getAppId(), prefetchEvent.appId)) ? false : true;
        }

        private void y(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                bundle.setClassLoader(PMSAppInfo.class.getClassLoader());
                com.baidu.swan.apps.runtime.d.akK().c(bundle, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle ajl() {
        Bundle bundle = new Bundle();
        bundle.putInt("process_id", SwanAppProcessInfo.current().index);
        bundle.putString("app_id", getAppId());
        bundle.putParcelable("app_core", ajs());
        return bundle;
    }
}
