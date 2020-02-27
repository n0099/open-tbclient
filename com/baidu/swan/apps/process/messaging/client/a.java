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
    public static final long bJk = TimeUnit.MINUTES.toMillis(5);
    private static final Object xQ = new Object();
    private final d bJl;
    private Messenger bJm;
    private c bJn;
    private ServiceConnection bJo;
    private final Deque<Long> bJp;
    private List<Runnable> bJq;

    /* loaded from: classes11.dex */
    public interface b {
        boolean m(Message message);
    }

    /* loaded from: classes11.dex */
    public interface c {
        void abc();

        void abd();
    }

    public a(h hVar) {
        super(hVar);
        this.bJl = new d();
        this.bJp = new ArrayDeque();
    }

    @Deprecated
    public static a aaT() {
        return com.baidu.swan.apps.runtime.d.acA().acw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Messenger aaU() {
        return this.bJm;
    }

    public synchronized void aaV() {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "tryBindRemoteMsgService");
        }
        if (this.bJo == null) {
            this.bJo = new ServiceConnectionC0273a();
            Application TU = com.baidu.swan.apps.w.a.TU();
            try {
                TU.bindService(new Intent(TU, SwanAppMessengerService.class), this.bJo, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler aaW() {
        return this.bJl;
    }

    public void a(c cVar, b bVar) {
        this.bJn = cVar;
        this.bJl.a(bVar);
        e(1, abb());
        if (this.bJn != null && aaX()) {
            this.bJn.abc();
        }
    }

    public boolean aaX() {
        return this.bJm != null;
    }

    public void SJ() {
        sendMessage(2);
    }

    public synchronized void aaY() {
        this.bJo = null;
        this.bJm = null;
        if (this.bJn != null) {
            this.bJn.abd();
        }
        aba();
        if (this.bJq != null) {
            synchronized (xQ) {
                for (Runnable runnable : this.bJq) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                this.bJq.clear();
            }
        }
    }

    private void ku(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "SwanRebind:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.bJp.iterator();
            while (it.hasNext()) {
                Log.i("SwanAppMessengerClient", "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    private boolean aaZ() {
        synchronized (this.bJp) {
            ku("checkRebindable ===>");
            if (this.bJp.size() < 3) {
                ku(String.format(Locale.getDefault(), "allowRebind by size(%d) < max(%d)", Integer.valueOf(this.bJp.size()), 3));
                return true;
            }
            int size = this.bJp.size() - 3;
            ku("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    ku("purge: " + this.bJp.poll());
                }
            }
            ku("after purge");
            Long peek = this.bJp.peek();
            if (peek == null) {
                ku("allowRebind by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > bJk;
            ku("allowRebind:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void aba() {
        synchronized (this.bJp) {
            if (aaZ()) {
                this.bJp.offer(Long.valueOf(System.currentTimeMillis()));
                aaV();
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
            if (a.this.aaX() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                if (a.DEBUG) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(a.this.aaX()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                    return;
                }
                return;
            }
            a.this.bJm = new Messenger(iBinder);
            a.this.e(13, a.this.abb());
            if (a.this.bJn != null) {
                a.this.bJn.abc();
            }
            com.baidu.swan.apps.process.messaging.a.aaJ().aaK();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (a.DEBUG) {
                Log.d("SwanAppMessengerClient", "onServiceDisconnected");
            }
            a.this.aaY();
        }
    }

    public void f(@NonNull Runnable runnable) {
        synchronized (xQ) {
            if (this.bJq == null) {
                this.bJq = new ArrayList();
            }
            this.bJq.add(runnable);
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
            bundle2.putString("ai_apps_observer_id", cVar.aaG());
            com.baidu.swan.apps.process.a.b.b.a.aaH().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        bundle2.putString("ai_apps_id", getAppId());
        obtain.obj = bundle2;
        com.baidu.swan.apps.process.messaging.a.aaJ().a(new com.baidu.swan.apps.process.messaging.c(obtain).dr(true));
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
        com.baidu.swan.apps.process.messaging.a.aaJ().a(new com.baidu.swan.apps.process.messaging.c(obtain));
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
        com.baidu.swan.apps.process.messaging.a.aaJ().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    public void e(int i, Bundle bundle) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        Message obtain = Message.obtain(null, i, bundle);
        obtain.arg1 = current.index;
        obtain.obj = bundle;
        com.baidu.swan.apps.process.messaging.a.aaJ().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    /* loaded from: classes11.dex */
    private static class d extends Handler {
        private WeakReference<b> bJs;

        d() {
            super(Looper.getMainLooper());
        }

        public void a(b bVar) {
            this.bJs = new WeakReference<>(bVar);
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
                    b bVar = this.bJs != null ? this.bJs.get() : null;
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
            if (com.baidu.swan.apps.runtime.d.acA().abh()) {
                com.baidu.swan.apps.as.c.T(com.baidu.swan.apps.runtime.d.acA().acz());
            }
        }

        private void s(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.acA().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check swanCore version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0 && com.baidu.swan.apps.core.k.d.Qu().QO() != null && com.baidu.swan.apps.core.k.d.Qu().QO().swanCoreVersion < j) {
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + com.baidu.swan.apps.core.k.d.Qu().QO());
                        }
                        com.baidu.swan.apps.runtime.d.acA().acw().sendMessage(15);
                        com.baidu.swan.apps.core.k.d.release();
                    }
                }
            }
        }

        private void t(Message message) {
            Bundle bundle;
            SwanCoreVersion QO;
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.acA().getAppId()) && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j != 0 && (QO = com.baidu.swan.games.i.a.anW().QO()) != null && QO.swanCoreVersion != 0 && QO.swanCoreVersion < j) {
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + QO);
                    }
                    com.baidu.swan.games.i.a.release();
                }
            }
        }

        private void u(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.acA().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check extension version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0) {
                        ExtensionCore QP = com.baidu.swan.apps.core.k.d.Qu().QP();
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + QP);
                        }
                        if (QP != null && QP.extensionCoreVersionCode < j) {
                            if (a.DEBUG) {
                                Log.d("SwanAppMessengerClient", "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + QP);
                            }
                            com.baidu.swan.apps.runtime.d.acA().acw().sendMessage(15);
                            com.baidu.swan.apps.core.k.d.release();
                        }
                    }
                }
            }
        }

        private void v(Message message) {
            Bundle bundle;
            com.baidu.j.a.a aVar;
            if (message != null && (bundle = (Bundle) message.obj) != null && (aVar = com.baidu.swan.apps.ae.a.Zs().bHa) != null) {
                aVar.onPayResult(com.baidu.swan.apps.ae.a.fD(bundle.getInt("_wxapi_baseresp_errcode")), bundle.getString("_wxapi_baseresp_errstr"));
            }
        }

        private void w(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                String string = bundle.getString("ai_apps_data");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        com.baidu.swan.apps.scheme.actions.d.a.adL().K(Intent.parseUri(string, 0));
                    } catch (URISyntaxException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        private void x(Message message) {
            PMSAppInfo VX;
            Bundle bundle = (Bundle) message.obj;
            bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
            PrefetchEvent prefetchEvent = (PrefetchEvent) bundle.getParcelable("swan_app_bundle_prefetch");
            if (prefetchEvent != null && prefetchEvent.isValid()) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "PrefetchMessage execCall event: " + prefetchEvent);
                }
                if (f(prefetchEvent)) {
                    b.a aVar = new b.a();
                    aVar.g(com.baidu.swan.pms.database.a.att().qo(prefetchEvent.appId));
                    com.baidu.swan.apps.runtime.d.acA().c(aVar.toBundle(), "update_tag_by_prefetch");
                }
                e acx = com.baidu.swan.apps.runtime.d.acA().acx();
                if (acx != null && (VX = acx.acG().VX()) != null && TextUtils.equals(prefetchEvent.appId, VX.appId)) {
                    prefetchEvent.appPath = e.d.aL(prefetchEvent.appId, String.valueOf(VX.versionCode)).getPath() + File.separator;
                    prefetchEvent.appConfig = com.baidu.swan.apps.t.e.o(new File(prefetchEvent.appPath, "app.json"));
                    com.baidu.swan.apps.core.k.d.Qu().a(PrefetchEvent.d(prefetchEvent));
                }
            }
        }

        private boolean f(PrefetchEvent prefetchEvent) {
            com.baidu.swan.apps.runtime.e acE = com.baidu.swan.apps.runtime.e.acE();
            if (acE == null) {
                return true;
            }
            return (acE.available() || TextUtils.equals(acE.getAppId(), prefetchEvent.appId)) ? false : true;
        }

        private void y(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                bundle.setClassLoader(PMSAppInfo.class.getClassLoader());
                com.baidu.swan.apps.runtime.d.acA().c(bundle, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle abb() {
        Bundle bundle = new Bundle();
        bundle.putInt("process_id", SwanAppProcessInfo.current().index);
        bundle.putString(Constants.APP_ID, getAppId());
        bundle.putParcelable("app_core", abi());
        return bundle;
    }
}
