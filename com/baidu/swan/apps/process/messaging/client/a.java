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
import com.baidu.swan.apps.aq.e;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.runtime.h;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.v.f;
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
/* loaded from: classes7.dex */
public final class a extends com.baidu.swan.apps.process.messaging.b {
    private final d cBf;
    private Messenger cBg;
    private c cBh;
    private final Deque<Long> cBi;
    private List<Runnable> cBj;
    private ServiceConnection mConnection;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final long cBe = TimeUnit.MINUTES.toMillis(5);
    private static final Object RG = new Object();

    /* loaded from: classes7.dex */
    public interface b {
        boolean m(Message message);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void apP();

        void apQ();
    }

    public a(h hVar) {
        super(hVar);
        this.cBf = new d();
        this.cBi = new ArrayDeque();
    }

    @Deprecated
    public static a apG() {
        return com.baidu.swan.apps.runtime.d.arr().arm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Messenger apH() {
        return this.cBg;
    }

    public synchronized void apI() {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "tryBindRemoteMsgService");
        }
        if (this.mConnection == null) {
            this.mConnection = new ServiceConnectionC0376a();
            Application ahj = com.baidu.swan.apps.t.a.ahj();
            try {
                ahj.bindService(new Intent(ahj, SwanAppMessengerService.class), this.mConnection, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler apJ() {
        return this.cBf;
    }

    public void a(c cVar, b bVar) {
        this.cBh = cVar;
        this.cBf.a(bVar);
        d(1, apO());
        if (this.cBh != null && apK()) {
            this.cBh.apP();
        }
    }

    public boolean apK() {
        return this.cBg != null;
    }

    public void afV() {
        sendMessage(2);
    }

    public synchronized void apL() {
        this.mConnection = null;
        this.cBg = null;
        if (this.cBh != null) {
            this.cBh.apQ();
        }
        apN();
        if (this.cBj != null) {
            synchronized (RG) {
                for (Runnable runnable : this.cBj) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                this.cBj.clear();
            }
        }
    }

    private void nQ(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "SwanRebind:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.cBi.iterator();
            while (it.hasNext()) {
                Log.i("SwanAppMessengerClient", "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    private boolean apM() {
        synchronized (this.cBi) {
            nQ("checkRebindable ===>");
            if (this.cBi.size() < 3) {
                nQ(String.format(Locale.getDefault(), "allowRebind by size(%d) < max(%d)", Integer.valueOf(this.cBi.size()), 3));
                return true;
            }
            int size = this.cBi.size() - 3;
            nQ("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    nQ("purge: " + this.cBi.poll());
                }
            }
            nQ("after purge");
            Long peek = this.cBi.peek();
            if (peek == null) {
                nQ("allowRebind by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > cBe;
            nQ("allowRebind:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void apN() {
        synchronized (this.cBi) {
            if (apM()) {
                this.cBi.offer(Long.valueOf(System.currentTimeMillis()));
                apI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.client.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class ServiceConnectionC0376a implements ServiceConnection {
        private ServiceConnectionC0376a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder));
            }
            if (a.this.apK() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                if (a.DEBUG) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(a.this.apK()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                    return;
                }
                return;
            }
            a.this.cBg = new Messenger(iBinder);
            a.this.d(13, a.this.apO());
            if (a.this.cBh != null) {
                a.this.cBh.apP();
            }
            com.baidu.swan.apps.process.messaging.a.apw().apx();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (a.DEBUG) {
                Log.d("SwanAppMessengerClient", "onServiceDisconnected");
            }
            a.this.apL();
        }
    }

    public void i(@NonNull Runnable runnable) {
        synchronized (RG) {
            if (this.cBj == null) {
                this.cBj = new ArrayList();
            }
            this.cBj.add(runnable);
        }
    }

    @Deprecated
    public void b(@Nullable Bundle bundle, @NonNull Class<? extends com.baidu.swan.apps.process.a.a.a> cls) {
        b(bundle, cls, null);
    }

    @Deprecated
    public void b(@Nullable Bundle bundle, @NonNull Class<? extends com.baidu.swan.apps.process.a.a.a> cls, @Nullable com.baidu.swan.apps.process.a.b.c.c cVar) {
        if (DEBUG) {
            Log.d("SwanAppMessengerClient", "sendMessageToClient: delegation: " + cls.getName());
        }
        Message obtain = Message.obtain((Handler) null, 12);
        obtain.arg1 = SwanAppProcessInfo.current().index;
        Bundle bundle2 = new Bundle();
        bundle2.putString("ai_apps_delegation_name", cls.getName());
        if (cVar != null) {
            bundle2.putString("ai_apps_observer_id", cVar.apm());
            com.baidu.swan.apps.process.a.b.b.a.apn().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        bundle2.putString("ai_apps_id", getAppId());
        obtain.obj = bundle2;
        com.baidu.swan.apps.process.messaging.a.apw().a(new com.baidu.swan.apps.process.messaging.c(obtain).eV(true));
    }

    @Deprecated
    public void sendMessage(int i) {
        V(i, "");
    }

    @Deprecated
    public void V(int i, String str) {
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
        com.baidu.swan.apps.process.messaging.a.apw().a(new com.baidu.swan.apps.process.messaging.c(obtain));
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
        com.baidu.swan.apps.process.messaging.a.apw().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    public void d(int i, Bundle bundle) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        Message obtain = Message.obtain(null, i, bundle);
        obtain.arg1 = current.index;
        obtain.obj = bundle;
        com.baidu.swan.apps.process.messaging.a.apw().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    /* loaded from: classes7.dex */
    private static class d extends Handler {
        private WeakReference<b> cBl;

        d() {
            super(Looper.getMainLooper());
        }

        public void a(b bVar) {
            this.cBl = new WeakReference<>(bVar);
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
                    if (message.obj instanceof Bundle) {
                        com.baidu.swan.apps.runtime.d.arr().g("event_messenger_call_in", (Bundle) message.obj);
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
                    z(message);
                    return;
                case 119:
                    com.baidu.h.d.l((Bundle) message.obj);
                    return;
                case 120:
                    x(message);
                    return;
                case 121:
                    u(message);
                    return;
                case 122:
                    y(message);
                    return;
                case 302:
                    com.baidu.swan.apps.process.messaging.a.a.q(message);
                    return;
                default:
                    b bVar = this.cBl != null ? this.cBl.get() : null;
                    if (bVar == null || !bVar.m(message)) {
                        super.handleMessage(message);
                        return;
                    }
                    return;
            }
        }

        private void r(Message message) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", "handleKillActivity");
            }
            if (com.baidu.swan.apps.runtime.d.arr().apU()) {
                e.M(com.baidu.swan.apps.runtime.d.arr().arp());
            }
        }

        private void s(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.arr().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check swanCore version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0 && com.baidu.swan.apps.core.turbo.d.adw().adQ() != null && com.baidu.swan.apps.core.turbo.d.adw().adQ().swanCoreVersion < j) {
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + com.baidu.swan.apps.core.turbo.d.adw().adQ());
                        }
                        com.baidu.swan.apps.runtime.d.arr().arm().sendMessage(15);
                        com.baidu.swan.apps.core.turbo.d.release(false);
                    }
                }
            }
        }

        private void t(Message message) {
            Bundle bundle;
            SwanCoreVersion adQ;
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.arr().getAppId()) && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j != 0 && (adQ = com.baidu.swan.games.j.a.aEO().adQ()) != null && adQ.swanCoreVersion != 0 && adQ.swanCoreVersion < j) {
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + adQ);
                    }
                    com.baidu.swan.games.j.a.release();
                }
            }
        }

        private void u(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.arr().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check extension version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0) {
                        ExtensionCore adR = com.baidu.swan.apps.core.turbo.d.adw().adR();
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + adR);
                        }
                        if (adR != null && adR.extensionCoreVersionCode < j) {
                            if (a.DEBUG) {
                                Log.d("SwanAppMessengerClient", "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + adR);
                            }
                            com.baidu.swan.apps.runtime.d.arr().arm().sendMessage(15);
                            com.baidu.swan.apps.core.turbo.d.release(false);
                        }
                    }
                }
            }
        }

        private void v(Message message) {
            Bundle bundle;
            com.baidu.h.a.a aVar;
            if (message != null && (bundle = (Bundle) message.obj) != null && (aVar = com.baidu.swan.apps.ab.a.anv().cxP) != null) {
                aVar.onPayResult(com.baidu.swan.apps.ab.a.gw(bundle.getInt("_wxapi_baseresp_errcode")), bundle.getString("_wxapi_baseresp_errstr"));
            }
        }

        private void w(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                String string = bundle.getString("ai_apps_data");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        com.baidu.swan.apps.scheme.actions.d.a.asO().v(Intent.parseUri(string, 0));
                    } catch (URISyntaxException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        private void x(Message message) {
            PMSAppInfo ajw;
            Bundle bundle = (Bundle) message.obj;
            bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
            PrefetchEvent prefetchEvent = (PrefetchEvent) bundle.getParcelable("swan_app_bundle_prefetch");
            if (prefetchEvent != null && prefetchEvent.isValid()) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "PrefetchMessage execCall event: " + prefetchEvent);
                }
                if (g(prefetchEvent)) {
                    b.a aVar = new b.a();
                    PMSAppInfo pMSAppInfo = (PMSAppInfo) bundle.getParcelable("swan_app_prefetch_pms_info");
                    if (pMSAppInfo == null) {
                        pMSAppInfo = com.baidu.swan.pms.database.a.aKS().uq(prefetchEvent.appId);
                    }
                    aVar.k(pMSAppInfo);
                    com.baidu.swan.apps.runtime.d.arr().d(aVar.toBundle(), "update_tag_by_prefetch");
                }
                com.baidu.swan.apps.runtime.e arn = com.baidu.swan.apps.runtime.d.arr().arn();
                if (arn != null && (ajw = arn.arz().ajw()) != null) {
                    if (TextUtils.equals(prefetchEvent.appId, ajw.appId)) {
                        prefetchEvent.appPath = d.C0380d.bq(prefetchEvent.appId, String.valueOf(ajw.versionCode)).getPath() + File.separator;
                        prefetchEvent.appConfig = com.baidu.swan.apps.r.d.u(new File(prefetchEvent.appPath, "app.json"));
                        if (arn.arE() == null) {
                            com.baidu.swan.apps.r.d.d(arn);
                        }
                        prefetchEvent.pageUrl = a(prefetchEvent, arn);
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "PrefetchEvent - " + prefetchEvent.toString());
                        }
                        com.baidu.swan.apps.core.turbo.d.adw().a(PrefetchEvent.d(prefetchEvent));
                    }
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "PrefetchMessage send event end.");
                    }
                }
            }
        }

        private String a(PrefetchEvent prefetchEvent, @NonNull com.baidu.swan.apps.runtime.e eVar) {
            SwanAppConfigData arE = eVar.arE();
            if (arE == null) {
                if (a.DEBUG) {
                    Log.w("SwanAppMessengerClient", "getPrefectPageUrl - configData is null ");
                }
                return null;
            }
            String a = com.baidu.swan.apps.u.c.b.a(prefetchEvent.schema, arE);
            if (TextUtils.isEmpty(a)) {
                return arE.aka();
            }
            return a;
        }

        private boolean g(PrefetchEvent prefetchEvent) {
            com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
            if (arw == null) {
                return true;
            }
            return (arw.available() || TextUtils.equals(arw.getAppId(), prefetchEvent.appId)) ? false : true;
        }

        private void y(Message message) {
            Bundle bundle;
            if (a.DEBUG) {
                Log.d("AppLaunchMessenger", "handleAppOnLaunch msg start.");
            }
            com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
            if ((arw == null || !arw.apU()) && com.baidu.swan.apps.core.turbo.d.adw().adC() && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                Bundle bundle2 = bundle.getBundle("swan_app_on_launch_event");
                if (bundle2 != null) {
                    if (a.DEBUG) {
                        Log.d("AppLaunchMessenger", "handleAppOnLaunch get bundle.");
                    }
                    com.baidu.swan.apps.runtime.d.arr().d(bundle2, "update_tag_by_app_launch");
                    com.baidu.swan.apps.runtime.e arw2 = com.baidu.swan.apps.runtime.e.arw();
                    if (arw2 != null && com.baidu.swan.apps.r.d.d(arw2)) {
                        if (a.DEBUG) {
                            Log.d("AppLaunchMessenger", "handleAppOnLaunch swan app updated.");
                        }
                        f.akr().gd(arw2.RU());
                        com.baidu.swan.apps.core.turbo.d.adw().adA();
                        if (a.DEBUG) {
                            Log.d("AppLaunchMessenger", "handleAppOnLaunch msg end");
                        }
                    }
                }
            }
        }

        private void z(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                bundle.setClassLoader(PMSAppInfo.class.getClassLoader());
                com.baidu.swan.apps.runtime.d.arr().d(bundle, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle apO() {
        Bundle bundle = new Bundle();
        bundle.putInt("process_id", SwanAppProcessInfo.current().index);
        bundle.putString("app_id", getAppId());
        bundle.putParcelable("app_core", apV());
        return bundle;
    }
}
