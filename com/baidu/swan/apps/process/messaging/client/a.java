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
    public static final long bJm = TimeUnit.MINUTES.toMillis(5);
    private static final Object xQ = new Object();
    private final d bJn;
    private Messenger bJo;
    private c bJp;
    private ServiceConnection bJq;
    private final Deque<Long> bJr;
    private List<Runnable> bJs;

    /* loaded from: classes11.dex */
    public interface b {
        boolean m(Message message);
    }

    /* loaded from: classes11.dex */
    public interface c {
        void abe();

        void abf();
    }

    public a(h hVar) {
        super(hVar);
        this.bJn = new d();
        this.bJr = new ArrayDeque();
    }

    @Deprecated
    public static a aaV() {
        return com.baidu.swan.apps.runtime.d.acC().acy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Messenger aaW() {
        return this.bJo;
    }

    public synchronized void aaX() {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "tryBindRemoteMsgService");
        }
        if (this.bJq == null) {
            this.bJq = new ServiceConnectionC0273a();
            Application TW = com.baidu.swan.apps.w.a.TW();
            try {
                TW.bindService(new Intent(TW, SwanAppMessengerService.class), this.bJq, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler aaY() {
        return this.bJn;
    }

    public void a(c cVar, b bVar) {
        this.bJp = cVar;
        this.bJn.a(bVar);
        e(1, abd());
        if (this.bJp != null && aaZ()) {
            this.bJp.abe();
        }
    }

    public boolean aaZ() {
        return this.bJo != null;
    }

    public void SL() {
        sendMessage(2);
    }

    public synchronized void aba() {
        this.bJq = null;
        this.bJo = null;
        if (this.bJp != null) {
            this.bJp.abf();
        }
        abc();
        if (this.bJs != null) {
            synchronized (xQ) {
                for (Runnable runnable : this.bJs) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                this.bJs.clear();
            }
        }
    }

    private void ku(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "SwanRebind:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.bJr.iterator();
            while (it.hasNext()) {
                Log.i("SwanAppMessengerClient", "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    private boolean abb() {
        synchronized (this.bJr) {
            ku("checkRebindable ===>");
            if (this.bJr.size() < 3) {
                ku(String.format(Locale.getDefault(), "allowRebind by size(%d) < max(%d)", Integer.valueOf(this.bJr.size()), 3));
                return true;
            }
            int size = this.bJr.size() - 3;
            ku("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    ku("purge: " + this.bJr.poll());
                }
            }
            ku("after purge");
            Long peek = this.bJr.peek();
            if (peek == null) {
                ku("allowRebind by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > bJm;
            ku("allowRebind:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void abc() {
        synchronized (this.bJr) {
            if (abb()) {
                this.bJr.offer(Long.valueOf(System.currentTimeMillis()));
                aaX();
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
            if (a.this.aaZ() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                if (a.DEBUG) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(a.this.aaZ()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                    return;
                }
                return;
            }
            a.this.bJo = new Messenger(iBinder);
            a.this.e(13, a.this.abd());
            if (a.this.bJp != null) {
                a.this.bJp.abe();
            }
            com.baidu.swan.apps.process.messaging.a.aaL().aaM();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (a.DEBUG) {
                Log.d("SwanAppMessengerClient", "onServiceDisconnected");
            }
            a.this.aba();
        }
    }

    public void f(@NonNull Runnable runnable) {
        synchronized (xQ) {
            if (this.bJs == null) {
                this.bJs = new ArrayList();
            }
            this.bJs.add(runnable);
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
            bundle2.putString("ai_apps_observer_id", cVar.aaI());
            com.baidu.swan.apps.process.a.b.b.a.aaJ().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        bundle2.putString("ai_apps_id", getAppId());
        obtain.obj = bundle2;
        com.baidu.swan.apps.process.messaging.a.aaL().a(new com.baidu.swan.apps.process.messaging.c(obtain).dr(true));
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
        com.baidu.swan.apps.process.messaging.a.aaL().a(new com.baidu.swan.apps.process.messaging.c(obtain));
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
        com.baidu.swan.apps.process.messaging.a.aaL().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    public void e(int i, Bundle bundle) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        Message obtain = Message.obtain(null, i, bundle);
        obtain.arg1 = current.index;
        obtain.obj = bundle;
        com.baidu.swan.apps.process.messaging.a.aaL().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    /* loaded from: classes11.dex */
    private static class d extends Handler {
        private WeakReference<b> bJu;

        d() {
            super(Looper.getMainLooper());
        }

        public void a(b bVar) {
            this.bJu = new WeakReference<>(bVar);
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
                    b bVar = this.bJu != null ? this.bJu.get() : null;
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
            if (com.baidu.swan.apps.runtime.d.acC().abj()) {
                com.baidu.swan.apps.as.c.T(com.baidu.swan.apps.runtime.d.acC().acB());
            }
        }

        private void s(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.acC().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check swanCore version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0 && com.baidu.swan.apps.core.k.d.Qw().QQ() != null && com.baidu.swan.apps.core.k.d.Qw().QQ().swanCoreVersion < j) {
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + com.baidu.swan.apps.core.k.d.Qw().QQ());
                        }
                        com.baidu.swan.apps.runtime.d.acC().acy().sendMessage(15);
                        com.baidu.swan.apps.core.k.d.release();
                    }
                }
            }
        }

        private void t(Message message) {
            Bundle bundle;
            SwanCoreVersion QQ;
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.acC().getAppId()) && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j != 0 && (QQ = com.baidu.swan.games.i.a.anY().QQ()) != null && QQ.swanCoreVersion != 0 && QQ.swanCoreVersion < j) {
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + QQ);
                    }
                    com.baidu.swan.games.i.a.release();
                }
            }
        }

        private void u(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.acC().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check extension version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0) {
                        ExtensionCore QR = com.baidu.swan.apps.core.k.d.Qw().QR();
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + QR);
                        }
                        if (QR != null && QR.extensionCoreVersionCode < j) {
                            if (a.DEBUG) {
                                Log.d("SwanAppMessengerClient", "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + QR);
                            }
                            com.baidu.swan.apps.runtime.d.acC().acy().sendMessage(15);
                            com.baidu.swan.apps.core.k.d.release();
                        }
                    }
                }
            }
        }

        private void v(Message message) {
            Bundle bundle;
            com.baidu.j.a.a aVar;
            if (message != null && (bundle = (Bundle) message.obj) != null && (aVar = com.baidu.swan.apps.ae.a.Zu().bHc) != null) {
                aVar.onPayResult(com.baidu.swan.apps.ae.a.fD(bundle.getInt("_wxapi_baseresp_errcode")), bundle.getString("_wxapi_baseresp_errstr"));
            }
        }

        private void w(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                String string = bundle.getString("ai_apps_data");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        com.baidu.swan.apps.scheme.actions.d.a.adN().K(Intent.parseUri(string, 0));
                    } catch (URISyntaxException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        private void x(Message message) {
            PMSAppInfo VZ;
            Bundle bundle = (Bundle) message.obj;
            bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
            PrefetchEvent prefetchEvent = (PrefetchEvent) bundle.getParcelable("swan_app_bundle_prefetch");
            if (prefetchEvent != null && prefetchEvent.isValid()) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "PrefetchMessage execCall event: " + prefetchEvent);
                }
                if (f(prefetchEvent)) {
                    b.a aVar = new b.a();
                    aVar.g(com.baidu.swan.pms.database.a.atv().qo(prefetchEvent.appId));
                    com.baidu.swan.apps.runtime.d.acC().c(aVar.toBundle(), "update_tag_by_prefetch");
                }
                e acz = com.baidu.swan.apps.runtime.d.acC().acz();
                if (acz != null && (VZ = acz.acI().VZ()) != null && TextUtils.equals(prefetchEvent.appId, VZ.appId)) {
                    prefetchEvent.appPath = e.d.aL(prefetchEvent.appId, String.valueOf(VZ.versionCode)).getPath() + File.separator;
                    prefetchEvent.appConfig = com.baidu.swan.apps.t.e.o(new File(prefetchEvent.appPath, "app.json"));
                    com.baidu.swan.apps.core.k.d.Qw().a(PrefetchEvent.d(prefetchEvent));
                }
            }
        }

        private boolean f(PrefetchEvent prefetchEvent) {
            com.baidu.swan.apps.runtime.e acG = com.baidu.swan.apps.runtime.e.acG();
            if (acG == null) {
                return true;
            }
            return (acG.available() || TextUtils.equals(acG.getAppId(), prefetchEvent.appId)) ? false : true;
        }

        private void y(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                bundle.setClassLoader(PMSAppInfo.class.getClassLoader());
                com.baidu.swan.apps.runtime.d.acC().c(bundle, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle abd() {
        Bundle bundle = new Bundle();
        bundle.putInt("process_id", SwanAppProcessInfo.current().index);
        bundle.putString(Constants.APP_ID, getAppId());
        bundle.putParcelable("app_core", abk());
        return bundle;
    }
}
