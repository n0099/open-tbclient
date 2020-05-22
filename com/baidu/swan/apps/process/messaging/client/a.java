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
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.runtime.h;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.apps.w.f;
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
    private final d ctS;
    private Messenger ctT;
    private c ctU;
    private final Deque<Long> ctV;
    private List<Runnable> ctW;
    private ServiceConnection mConnection;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final long ctR = TimeUnit.MINUTES.toMillis(5);
    private static final Object Ri = new Object();

    /* loaded from: classes11.dex */
    public interface b {
        boolean m(Message message);
    }

    /* loaded from: classes11.dex */
    public interface c {
        void amZ();

        void ana();
    }

    public a(h hVar) {
        super(hVar);
        this.ctS = new d();
        this.ctV = new ArrayDeque();
    }

    @Deprecated
    public static a amQ() {
        return com.baidu.swan.apps.runtime.d.aoB().aow();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Messenger amR() {
        return this.ctT;
    }

    public synchronized void amS() {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "tryBindRemoteMsgService");
        }
        if (this.mConnection == null) {
            this.mConnection = new ServiceConnectionC0367a();
            Application aeR = com.baidu.swan.apps.u.a.aeR();
            try {
                aeR.bindService(new Intent(aeR, SwanAppMessengerService.class), this.mConnection, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler amT() {
        return this.ctS;
    }

    public void a(c cVar, b bVar) {
        this.ctU = cVar;
        this.ctS.a(bVar);
        d(1, amY());
        if (this.ctU != null && amU()) {
            this.ctU.amZ();
        }
    }

    public boolean amU() {
        return this.ctT != null;
    }

    public void adD() {
        sendMessage(2);
    }

    public synchronized void amV() {
        this.mConnection = null;
        this.ctT = null;
        if (this.ctU != null) {
            this.ctU.ana();
        }
        amX();
        if (this.ctW != null) {
            synchronized (Ri) {
                for (Runnable runnable : this.ctW) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                this.ctW.clear();
            }
        }
    }

    private void nb(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "SwanRebind:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.ctV.iterator();
            while (it.hasNext()) {
                Log.i("SwanAppMessengerClient", "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    private boolean amW() {
        synchronized (this.ctV) {
            nb("checkRebindable ===>");
            if (this.ctV.size() < 3) {
                nb(String.format(Locale.getDefault(), "allowRebind by size(%d) < max(%d)", Integer.valueOf(this.ctV.size()), 3));
                return true;
            }
            int size = this.ctV.size() - 3;
            nb("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    nb("purge: " + this.ctV.poll());
                }
            }
            nb("after purge");
            Long peek = this.ctV.peek();
            if (peek == null) {
                nb("allowRebind by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > ctR;
            nb("allowRebind:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void amX() {
        synchronized (this.ctV) {
            if (amW()) {
                this.ctV.offer(Long.valueOf(System.currentTimeMillis()));
                amS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.client.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class ServiceConnectionC0367a implements ServiceConnection {
        private ServiceConnectionC0367a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder));
            }
            if (a.this.amU() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                if (a.DEBUG) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(a.this.amU()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                    return;
                }
                return;
            }
            a.this.ctT = new Messenger(iBinder);
            a.this.d(13, a.this.amY());
            if (a.this.ctU != null) {
                a.this.ctU.amZ();
            }
            com.baidu.swan.apps.process.messaging.a.amG().amH();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (a.DEBUG) {
                Log.d("SwanAppMessengerClient", "onServiceDisconnected");
            }
            a.this.amV();
        }
    }

    public void i(@NonNull Runnable runnable) {
        synchronized (Ri) {
            if (this.ctW == null) {
                this.ctW = new ArrayList();
            }
            this.ctW.add(runnable);
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
            bundle2.putString("ai_apps_observer_id", cVar.amw());
            com.baidu.swan.apps.process.a.b.b.a.amx().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        bundle2.putString("ai_apps_id", getAppId());
        obtain.obj = bundle2;
        com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(obtain).eH(true));
    }

    @Deprecated
    public void sendMessage(int i) {
        T(i, "");
    }

    @Deprecated
    public void T(int i, String str) {
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
        com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(obtain));
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
        com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    public void d(int i, Bundle bundle) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        Message obtain = Message.obtain(null, i, bundle);
        obtain.arg1 = current.index;
        obtain.obj = bundle;
        com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    /* loaded from: classes11.dex */
    private static class d extends Handler {
        private WeakReference<b> ctY;

        d() {
            super(Looper.getMainLooper());
        }

        public void a(b bVar) {
            this.ctY = new WeakReference<>(bVar);
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
                        com.baidu.swan.apps.runtime.d.aoB().g("event_messenger_call_in", (Bundle) message.obj);
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
                    com.baidu.g.d.l((Bundle) message.obj);
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
                    b bVar = this.ctY != null ? this.ctY.get() : null;
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
            if (com.baidu.swan.apps.runtime.d.aoB().ane()) {
                com.baidu.swan.apps.aq.d.N(com.baidu.swan.apps.runtime.d.aoB().aoz());
            }
        }

        private void s(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aoB().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check swanCore version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0 && com.baidu.swan.apps.core.turbo.d.abl().abG() != null && com.baidu.swan.apps.core.turbo.d.abl().abG().swanCoreVersion < j) {
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + com.baidu.swan.apps.core.turbo.d.abl().abG());
                        }
                        com.baidu.swan.apps.runtime.d.aoB().aow().sendMessage(15);
                        com.baidu.swan.apps.core.turbo.d.release(false);
                    }
                }
            }
        }

        private void t(Message message) {
            Bundle bundle;
            SwanCoreVersion abG;
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aoB().getAppId()) && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j != 0 && (abG = com.baidu.swan.games.j.a.aAd().abG()) != null && abG.swanCoreVersion != 0 && abG.swanCoreVersion < j) {
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + abG);
                    }
                    com.baidu.swan.games.j.a.release();
                }
            }
        }

        private void u(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aoB().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check extension version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0) {
                        ExtensionCore abH = com.baidu.swan.apps.core.turbo.d.abl().abH();
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + abH);
                        }
                        if (abH != null && abH.extensionCoreVersionCode < j) {
                            if (a.DEBUG) {
                                Log.d("SwanAppMessengerClient", "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + abH);
                            }
                            com.baidu.swan.apps.runtime.d.aoB().aow().sendMessage(15);
                            com.baidu.swan.apps.core.turbo.d.release(false);
                        }
                    }
                }
            }
        }

        private void v(Message message) {
            Bundle bundle;
            com.baidu.g.a.a aVar;
            if (message != null && (bundle = (Bundle) message.obj) != null && (aVar = com.baidu.swan.apps.ac.a.akW().cqN) != null) {
                aVar.onPayResult(com.baidu.swan.apps.ac.a.fZ(bundle.getInt("_wxapi_baseresp_errcode")), bundle.getString("_wxapi_baseresp_errstr"));
            }
        }

        private void w(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                String string = bundle.getString("ai_apps_data");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        com.baidu.swan.apps.scheme.actions.d.a.apR().v(Intent.parseUri(string, 0));
                    } catch (URISyntaxException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        private void x(Message message) {
            PMSAppInfo aha;
            Bundle bundle = (Bundle) message.obj;
            bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
            PrefetchEvent prefetchEvent = (PrefetchEvent) bundle.getParcelable("swan_app_bundle_prefetch");
            if (prefetchEvent != null && prefetchEvent.isValid()) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "PrefetchMessage execCall event: " + prefetchEvent);
                }
                if (g(prefetchEvent)) {
                    b.a aVar = new b.a();
                    aVar.h(com.baidu.swan.pms.database.a.aFV().tf(prefetchEvent.appId));
                    com.baidu.swan.apps.runtime.d.aoB().d(aVar.toBundle(), "update_tag_by_prefetch");
                }
                e aox = com.baidu.swan.apps.runtime.d.aoB().aox();
                if (aox != null && (aha = aox.aoJ().aha()) != null && TextUtils.equals(prefetchEvent.appId, aha.appId)) {
                    prefetchEvent.appPath = e.d.bk(prefetchEvent.appId, String.valueOf(aha.versionCode)).getPath() + File.separator;
                    prefetchEvent.appConfig = com.baidu.swan.apps.r.e.t(new File(prefetchEvent.appPath, "app.json"));
                    com.baidu.swan.apps.core.turbo.d.abl().a(PrefetchEvent.d(prefetchEvent));
                }
            }
        }

        private boolean g(PrefetchEvent prefetchEvent) {
            com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
            if (aoG == null) {
                return true;
            }
            return (aoG.available() || TextUtils.equals(aoG.getAppId(), prefetchEvent.appId)) ? false : true;
        }

        private void y(Message message) {
            Bundle bundle;
            if (a.DEBUG) {
                Log.d("AppLaunchMessenger", "handleAppOnLaunch msg start.");
            }
            com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
            if ((aoG == null || !aoG.ane()) && com.baidu.swan.apps.core.turbo.d.abl().abr() && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                Bundle bundle2 = bundle.getBundle("swan_app_on_launch_event");
                if (bundle2 != null) {
                    if (a.DEBUG) {
                        Log.d("AppLaunchMessenger", "handleAppOnLaunch get bundle.");
                    }
                    com.baidu.swan.apps.runtime.d.aoB().d(bundle2, "update_tag_by_app_launch");
                    com.baidu.swan.apps.runtime.e aoG2 = com.baidu.swan.apps.runtime.e.aoG();
                    if (aoG2 != null && com.baidu.swan.apps.r.e.d(aoG2)) {
                        if (a.DEBUG) {
                            Log.d("AppLaunchMessenger", "handleAppOnLaunch swan app updated.");
                        }
                        f.ahV().fG(aoG2.Qz());
                        com.baidu.swan.apps.core.turbo.d.abl().abp();
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
                com.baidu.swan.apps.runtime.d.aoB().d(bundle, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle amY() {
        Bundle bundle = new Bundle();
        bundle.putInt("process_id", SwanAppProcessInfo.current().index);
        bundle.putString("app_id", getAppId());
        bundle.putParcelable("app_core", anf());
        return bundle;
    }
}
