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
import com.xiaomi.mipush.sdk.Constants;
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
/* loaded from: classes10.dex */
public final class a extends com.baidu.swan.apps.process.messaging.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final long bFf = TimeUnit.MINUTES.toMillis(5);
    private static final Object xy = new Object();
    private final d bFg;
    private Messenger bFh;
    private c bFi;
    private ServiceConnection bFj;
    private final Deque<Long> bFk;
    private List<Runnable> bFl;

    /* loaded from: classes10.dex */
    public interface b {
        boolean m(Message message);
    }

    /* loaded from: classes10.dex */
    public interface c {
        void YO();

        void YP();
    }

    public a(h hVar) {
        super(hVar);
        this.bFg = new d();
        this.bFk = new ArrayDeque();
    }

    @Deprecated
    public static a YF() {
        return com.baidu.swan.apps.runtime.d.aam().aai();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Messenger YG() {
        return this.bFh;
    }

    public synchronized void YH() {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "tryBindRemoteMsgService");
        }
        if (this.bFj == null) {
            this.bFj = new ServiceConnectionC0263a();
            Application RG = com.baidu.swan.apps.w.a.RG();
            try {
                RG.bindService(new Intent(RG, SwanAppMessengerService.class), this.bFj, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler YI() {
        return this.bFg;
    }

    public void a(c cVar, b bVar) {
        this.bFi = cVar;
        this.bFg.a(bVar);
        e(1, YN());
        if (this.bFi != null && YJ()) {
            this.bFi.YO();
        }
    }

    public boolean YJ() {
        return this.bFh != null;
    }

    public void Qv() {
        sendMessage(2);
    }

    public synchronized void YK() {
        this.bFj = null;
        this.bFh = null;
        if (this.bFi != null) {
            this.bFi.YP();
        }
        YM();
        if (this.bFl != null) {
            synchronized (xy) {
                for (Runnable runnable : this.bFl) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                this.bFl.clear();
            }
        }
    }

    private void kf(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "SwanRebind:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.bFk.iterator();
            while (it.hasNext()) {
                Log.i("SwanAppMessengerClient", "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    private boolean YL() {
        synchronized (this.bFk) {
            kf("checkRebindable ===>");
            if (this.bFk.size() < 3) {
                kf(String.format(Locale.getDefault(), "allowRebind by size(%d) < max(%d)", Integer.valueOf(this.bFk.size()), 3));
                return true;
            }
            int size = this.bFk.size() - 3;
            kf("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    kf("purge: " + this.bFk.poll());
                }
            }
            kf("after purge");
            Long peek = this.bFk.peek();
            if (peek == null) {
                kf("allowRebind by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > bFf;
            kf("allowRebind:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void YM() {
        synchronized (this.bFk) {
            if (YL()) {
                this.bFk.offer(Long.valueOf(System.currentTimeMillis()));
                YH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.client.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class ServiceConnectionC0263a implements ServiceConnection {
        private ServiceConnectionC0263a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder));
            }
            if (a.this.YJ() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                if (a.DEBUG) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(a.this.YJ()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                    return;
                }
                return;
            }
            a.this.bFh = new Messenger(iBinder);
            a.this.e(13, a.this.YN());
            if (a.this.bFi != null) {
                a.this.bFi.YO();
            }
            com.baidu.swan.apps.process.messaging.a.Yv().Yw();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (a.DEBUG) {
                Log.d("SwanAppMessengerClient", "onServiceDisconnected");
            }
            a.this.YK();
        }
    }

    public void f(@NonNull Runnable runnable) {
        synchronized (xy) {
            if (this.bFl == null) {
                this.bFl = new ArrayList();
            }
            this.bFl.add(runnable);
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
            bundle2.putString("ai_apps_observer_id", cVar.Ys());
            com.baidu.swan.apps.process.a.b.b.a.Yt().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        bundle2.putString("ai_apps_id", getAppId());
        obtain.obj = bundle2;
        com.baidu.swan.apps.process.messaging.a.Yv().a(new com.baidu.swan.apps.process.messaging.c(obtain).dk(true));
    }

    @Deprecated
    public void sendMessage(int i) {
        z(i, "");
    }

    @Deprecated
    public void z(int i, String str) {
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
        com.baidu.swan.apps.process.messaging.a.Yv().a(new com.baidu.swan.apps.process.messaging.c(obtain));
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
        com.baidu.swan.apps.process.messaging.a.Yv().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    public void e(int i, Bundle bundle) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        Message obtain = Message.obtain(null, i, bundle);
        obtain.arg1 = current.index;
        obtain.obj = bundle;
        com.baidu.swan.apps.process.messaging.a.Yv().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    /* loaded from: classes10.dex */
    private static class d extends Handler {
        private WeakReference<b> bFn;

        d() {
            super(Looper.getMainLooper());
        }

        public void a(b bVar) {
            this.bFn = new WeakReference<>(bVar);
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
                    b bVar = this.bFn != null ? this.bFn.get() : null;
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
                    com.baidu.j.d.j((Bundle) message.obj);
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
            if (com.baidu.swan.apps.runtime.d.aam().YT()) {
                com.baidu.swan.apps.as.c.S(com.baidu.swan.apps.runtime.d.aam().aal());
            }
        }

        private void s(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aam().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check swanCore version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0 && com.baidu.swan.apps.core.k.d.Og().OA() != null && com.baidu.swan.apps.core.k.d.Og().OA().swanCoreVersion < j) {
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + com.baidu.swan.apps.core.k.d.Og().OA());
                        }
                        com.baidu.swan.apps.runtime.d.aam().aai().sendMessage(15);
                        com.baidu.swan.apps.core.k.d.release();
                    }
                }
            }
        }

        private void t(Message message) {
            Bundle bundle;
            SwanCoreVersion OA;
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aam().getAppId()) && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j != 0 && (OA = com.baidu.swan.games.i.a.alJ().OA()) != null && OA.swanCoreVersion != 0 && OA.swanCoreVersion < j) {
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + OA);
                    }
                    com.baidu.swan.games.i.a.release();
                }
            }
        }

        private void u(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aam().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check extension version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0) {
                        ExtensionCore OB = com.baidu.swan.apps.core.k.d.Og().OB();
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + OB);
                        }
                        if (OB != null && OB.extensionCoreVersionCode < j) {
                            if (a.DEBUG) {
                                Log.d("SwanAppMessengerClient", "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + OB);
                            }
                            com.baidu.swan.apps.runtime.d.aam().aai().sendMessage(15);
                            com.baidu.swan.apps.core.k.d.release();
                        }
                    }
                }
            }
        }

        private void v(Message message) {
            Bundle bundle;
            com.baidu.j.a.a aVar;
            if (message != null && (bundle = (Bundle) message.obj) != null && (aVar = com.baidu.swan.apps.ae.a.Xe().bCU) != null) {
                aVar.onPayResult(com.baidu.swan.apps.ae.a.fn(bundle.getInt("_wxapi_baseresp_errcode")), bundle.getString("_wxapi_baseresp_errstr"));
            }
        }

        private void w(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                String string = bundle.getString("ai_apps_data");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        com.baidu.swan.apps.scheme.actions.d.a.abx().K(Intent.parseUri(string, 0));
                    } catch (URISyntaxException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        private void x(Message message) {
            PMSAppInfo TJ;
            Bundle bundle = (Bundle) message.obj;
            bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
            PrefetchEvent prefetchEvent = (PrefetchEvent) bundle.getParcelable("swan_app_bundle_prefetch");
            if (prefetchEvent != null && prefetchEvent.isValid()) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "PrefetchMessage execCall event: " + prefetchEvent);
                }
                if (f(prefetchEvent)) {
                    b.a aVar = new b.a();
                    aVar.g(com.baidu.swan.pms.database.a.arf().pZ(prefetchEvent.appId));
                    com.baidu.swan.apps.runtime.d.aam().c(aVar.toBundle(), "update_tag_by_prefetch");
                }
                e aaj = com.baidu.swan.apps.runtime.d.aam().aaj();
                if (aaj != null && (TJ = aaj.aas().TJ()) != null && TextUtils.equals(prefetchEvent.appId, TJ.appId)) {
                    prefetchEvent.appPath = e.d.aB(prefetchEvent.appId, String.valueOf(TJ.versionCode)).getPath() + File.separator;
                    prefetchEvent.appConfig = com.baidu.swan.apps.t.e.n(new File(prefetchEvent.appPath, "app.json"));
                    com.baidu.swan.apps.core.k.d.Og().a(PrefetchEvent.d(prefetchEvent));
                }
            }
        }

        private boolean f(PrefetchEvent prefetchEvent) {
            com.baidu.swan.apps.runtime.e aaq = com.baidu.swan.apps.runtime.e.aaq();
            if (aaq == null) {
                return true;
            }
            return (aaq.available() || TextUtils.equals(aaq.getAppId(), prefetchEvent.appId)) ? false : true;
        }

        private void y(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                bundle.setClassLoader(PMSAppInfo.class.getClassLoader());
                com.baidu.swan.apps.runtime.d.aam().c(bundle, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle YN() {
        Bundle bundle = new Bundle();
        bundle.putInt("process_id", SwanAppProcessInfo.current().index);
        bundle.putString(Constants.APP_ID, getAppId());
        bundle.putParcelable("app_core", YU());
        return bundle;
    }
}
