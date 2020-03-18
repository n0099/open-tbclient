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
/* loaded from: classes11.dex */
public final class a extends com.baidu.swan.apps.process.messaging.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final long bJx = TimeUnit.MINUTES.toMillis(5);
    private static final Object xQ = new Object();
    private c bJA;
    private ServiceConnection bJB;
    private final Deque<Long> bJC;
    private List<Runnable> bJD;
    private final d bJy;
    private Messenger bJz;

    /* loaded from: classes11.dex */
    public interface b {
        boolean m(Message message);
    }

    /* loaded from: classes11.dex */
    public interface c {
        void abh();

        void abi();
    }

    public a(h hVar) {
        super(hVar);
        this.bJy = new d();
        this.bJC = new ArrayDeque();
    }

    @Deprecated
    public static a aaY() {
        return com.baidu.swan.apps.runtime.d.acF().acB();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Messenger aaZ() {
        return this.bJz;
    }

    public synchronized void aba() {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "tryBindRemoteMsgService");
        }
        if (this.bJB == null) {
            this.bJB = new ServiceConnectionC0273a();
            Application TZ = com.baidu.swan.apps.w.a.TZ();
            try {
                TZ.bindService(new Intent(TZ, SwanAppMessengerService.class), this.bJB, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler abb() {
        return this.bJy;
    }

    public void a(c cVar, b bVar) {
        this.bJA = cVar;
        this.bJy.a(bVar);
        e(1, abg());
        if (this.bJA != null && abc()) {
            this.bJA.abh();
        }
    }

    public boolean abc() {
        return this.bJz != null;
    }

    public void SO() {
        sendMessage(2);
    }

    public synchronized void abd() {
        this.bJB = null;
        this.bJz = null;
        if (this.bJA != null) {
            this.bJA.abi();
        }
        abf();
        if (this.bJD != null) {
            synchronized (xQ) {
                for (Runnable runnable : this.bJD) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                this.bJD.clear();
            }
        }
    }

    private void kt(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "SwanRebind:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.bJC.iterator();
            while (it.hasNext()) {
                Log.i("SwanAppMessengerClient", "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    private boolean abe() {
        synchronized (this.bJC) {
            kt("checkRebindable ===>");
            if (this.bJC.size() < 3) {
                kt(String.format(Locale.getDefault(), "allowRebind by size(%d) < max(%d)", Integer.valueOf(this.bJC.size()), 3));
                return true;
            }
            int size = this.bJC.size() - 3;
            kt("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    kt("purge: " + this.bJC.poll());
                }
            }
            kt("after purge");
            Long peek = this.bJC.peek();
            if (peek == null) {
                kt("allowRebind by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > bJx;
            kt("allowRebind:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void abf() {
        synchronized (this.bJC) {
            if (abe()) {
                this.bJC.offer(Long.valueOf(System.currentTimeMillis()));
                aba();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.client.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class ServiceConnectionC0273a implements ServiceConnection {
        private ServiceConnectionC0273a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder));
            }
            if (a.this.abc() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                if (a.DEBUG) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(a.this.abc()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                    return;
                }
                return;
            }
            a.this.bJz = new Messenger(iBinder);
            a.this.e(13, a.this.abg());
            if (a.this.bJA != null) {
                a.this.bJA.abh();
            }
            com.baidu.swan.apps.process.messaging.a.aaO().aaP();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (a.DEBUG) {
                Log.d("SwanAppMessengerClient", "onServiceDisconnected");
            }
            a.this.abd();
        }
    }

    public void f(@NonNull Runnable runnable) {
        synchronized (xQ) {
            if (this.bJD == null) {
                this.bJD = new ArrayList();
            }
            this.bJD.add(runnable);
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
            bundle2.putString("ai_apps_observer_id", cVar.aaL());
            com.baidu.swan.apps.process.a.b.b.a.aaM().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        bundle2.putString("ai_apps_id", getAppId());
        obtain.obj = bundle2;
        com.baidu.swan.apps.process.messaging.a.aaO().a(new com.baidu.swan.apps.process.messaging.c(obtain).ds(true));
    }

    @Deprecated
    public void sendMessage(int i) {
        B(i, "");
    }

    @Deprecated
    public void B(int i, String str) {
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
        com.baidu.swan.apps.process.messaging.a.aaO().a(new com.baidu.swan.apps.process.messaging.c(obtain));
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
        com.baidu.swan.apps.process.messaging.a.aaO().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    public void e(int i, Bundle bundle) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        Message obtain = Message.obtain(null, i, bundle);
        obtain.arg1 = current.index;
        obtain.obj = bundle;
        com.baidu.swan.apps.process.messaging.a.aaO().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    /* loaded from: classes11.dex */
    private static class d extends Handler {
        private WeakReference<b> bJF;

        d() {
            super(Looper.getMainLooper());
        }

        public void a(b bVar) {
            this.bJF = new WeakReference<>(bVar);
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
                    b bVar = this.bJF != null ? this.bJF.get() : null;
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
            if (com.baidu.swan.apps.runtime.d.acF().abm()) {
                com.baidu.swan.apps.as.c.T(com.baidu.swan.apps.runtime.d.acF().acE());
            }
        }

        private void s(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.acF().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check swanCore version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0 && com.baidu.swan.apps.core.k.d.Qz().QT() != null && com.baidu.swan.apps.core.k.d.Qz().QT().swanCoreVersion < j) {
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + com.baidu.swan.apps.core.k.d.Qz().QT());
                        }
                        com.baidu.swan.apps.runtime.d.acF().acB().sendMessage(15);
                        com.baidu.swan.apps.core.k.d.release();
                    }
                }
            }
        }

        private void t(Message message) {
            Bundle bundle;
            SwanCoreVersion QT;
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.acF().getAppId()) && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j != 0 && (QT = com.baidu.swan.games.i.a.aob().QT()) != null && QT.swanCoreVersion != 0 && QT.swanCoreVersion < j) {
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + QT);
                    }
                    com.baidu.swan.games.i.a.release();
                }
            }
        }

        private void u(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.acF().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check extension version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0) {
                        ExtensionCore QU = com.baidu.swan.apps.core.k.d.Qz().QU();
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + QU);
                        }
                        if (QU != null && QU.extensionCoreVersionCode < j) {
                            if (a.DEBUG) {
                                Log.d("SwanAppMessengerClient", "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + QU);
                            }
                            com.baidu.swan.apps.runtime.d.acF().acB().sendMessage(15);
                            com.baidu.swan.apps.core.k.d.release();
                        }
                    }
                }
            }
        }

        private void v(Message message) {
            Bundle bundle;
            com.baidu.j.a.a aVar;
            if (message != null && (bundle = (Bundle) message.obj) != null && (aVar = com.baidu.swan.apps.ae.a.Zx().bHn) != null) {
                aVar.onPayResult(com.baidu.swan.apps.ae.a.fD(bundle.getInt("_wxapi_baseresp_errcode")), bundle.getString("_wxapi_baseresp_errstr"));
            }
        }

        private void w(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                String string = bundle.getString("ai_apps_data");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        com.baidu.swan.apps.scheme.actions.d.a.adQ().K(Intent.parseUri(string, 0));
                    } catch (URISyntaxException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        private void x(Message message) {
            PMSAppInfo Wc;
            Bundle bundle = (Bundle) message.obj;
            bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
            PrefetchEvent prefetchEvent = (PrefetchEvent) bundle.getParcelable("swan_app_bundle_prefetch");
            if (prefetchEvent != null && prefetchEvent.isValid()) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "PrefetchMessage execCall event: " + prefetchEvent);
                }
                if (f(prefetchEvent)) {
                    b.a aVar = new b.a();
                    aVar.g(com.baidu.swan.pms.database.a.aty().qn(prefetchEvent.appId));
                    com.baidu.swan.apps.runtime.d.acF().c(aVar.toBundle(), "update_tag_by_prefetch");
                }
                e acC = com.baidu.swan.apps.runtime.d.acF().acC();
                if (acC != null && (Wc = acC.acL().Wc()) != null && TextUtils.equals(prefetchEvent.appId, Wc.appId)) {
                    prefetchEvent.appPath = e.d.aK(prefetchEvent.appId, String.valueOf(Wc.versionCode)).getPath() + File.separator;
                    prefetchEvent.appConfig = com.baidu.swan.apps.t.e.o(new File(prefetchEvent.appPath, "app.json"));
                    com.baidu.swan.apps.core.k.d.Qz().a(PrefetchEvent.d(prefetchEvent));
                }
            }
        }

        private boolean f(PrefetchEvent prefetchEvent) {
            com.baidu.swan.apps.runtime.e acJ = com.baidu.swan.apps.runtime.e.acJ();
            if (acJ == null) {
                return true;
            }
            return (acJ.available() || TextUtils.equals(acJ.getAppId(), prefetchEvent.appId)) ? false : true;
        }

        private void y(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                bundle.setClassLoader(PMSAppInfo.class.getClassLoader());
                com.baidu.swan.apps.runtime.d.acF().c(bundle, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle abg() {
        Bundle bundle = new Bundle();
        bundle.putInt("process_id", SwanAppProcessInfo.current().index);
        bundle.putString(Constants.APP_ID, getAppId());
        bundle.putParcelable("app_core", abn());
        return bundle;
    }
}
