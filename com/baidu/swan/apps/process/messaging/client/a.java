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
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.ap.e;
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
    private final d dkk;
    private Messenger dkl;
    private c dkm;
    private final Deque<Long> dkn;
    private List<Runnable> dko;
    private ServiceConnection mConnection;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final long dkj = TimeUnit.MINUTES.toMillis(5);
    private static final Object Ta = new Object();

    /* loaded from: classes7.dex */
    public interface b {
        boolean l(Message message);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void aEP();

        void aEQ();
    }

    public a(h hVar) {
        super(hVar);
        this.dkk = new d();
        this.dkn = new ArrayDeque();
    }

    @Deprecated
    public static a aEG() {
        return com.baidu.swan.apps.runtime.d.aGI().aGD();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Messenger aEH() {
        return this.dkl;
    }

    public synchronized void aEI() {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "tryBindRemoteMsgService");
        }
        if (this.mConnection == null) {
            this.mConnection = new ServiceConnectionC0458a();
            Application avS = com.baidu.swan.apps.t.a.avS();
            try {
                avS.bindService(new Intent(avS, SwanAppMessengerService.class), this.mConnection, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler aEJ() {
        return this.dkk;
    }

    public void a(c cVar, b bVar) {
        this.dkm = cVar;
        this.dkk.a(bVar);
        d(1, aEO());
        if (this.dkm != null && aEK()) {
            this.dkm.aEP();
        }
    }

    public boolean aEK() {
        return this.dkl != null;
    }

    public void aul() {
        sendMessage(2);
    }

    public synchronized void aEL() {
        this.mConnection = null;
        this.dkl = null;
        if (this.dkm != null) {
            this.dkm.aEQ();
        }
        aEN();
        if (this.dko != null) {
            synchronized (Ta) {
                for (Runnable runnable : this.dko) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                this.dko.clear();
            }
        }
    }

    private void rv(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "SwanRebind:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.dkn.iterator();
            while (it.hasNext()) {
                Log.i("SwanAppMessengerClient", "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    private boolean aEM() {
        synchronized (this.dkn) {
            rv("checkRebindable ===>");
            if (this.dkn.size() < 3) {
                rv(String.format(Locale.getDefault(), "allowRebind by size(%d) < max(%d)", Integer.valueOf(this.dkn.size()), 3));
                return true;
            }
            int size = this.dkn.size() - 3;
            rv("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    rv("purge: " + this.dkn.poll());
                }
            }
            rv("after purge");
            Long peek = this.dkn.peek();
            if (peek == null) {
                rv("allowRebind by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > dkj;
            rv("allowRebind:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void aEN() {
        synchronized (this.dkn) {
            if (aEM()) {
                this.dkn.offer(Long.valueOf(System.currentTimeMillis()));
                aEI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.client.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class ServiceConnectionC0458a implements ServiceConnection {
        private ServiceConnectionC0458a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder));
            }
            if (a.this.aEK() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                if (a.DEBUG) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(a.this.aEK()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                    return;
                }
                return;
            }
            a.this.dkl = new Messenger(iBinder);
            a.this.d(13, a.this.aEO());
            if (a.this.dkm != null) {
                a.this.dkm.aEP();
            }
            com.baidu.swan.apps.process.messaging.a.aEw().aEx();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (a.DEBUG) {
                Log.d("SwanAppMessengerClient", "onServiceDisconnected");
            }
            a.this.aEL();
        }
    }

    public void f(@NonNull Runnable runnable) {
        synchronized (Ta) {
            if (this.dko == null) {
                this.dko = new ArrayList();
            }
            this.dko.add(runnable);
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
            bundle2.putString("ai_apps_observer_id", cVar.aEo());
            com.baidu.swan.apps.process.a.b.b.a.aEp().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        bundle2.putString("ai_apps_id", getAppId());
        obtain.obj = bundle2;
        com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(obtain).gi(true));
    }

    @Deprecated
    public void sendMessage(int i) {
        am(i, "");
    }

    @Deprecated
    public void am(int i, String str) {
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
        com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(obtain));
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
        com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    public void d(int i, Bundle bundle) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        Message obtain = Message.obtain(null, i, bundle);
        obtain.arg1 = current.index;
        obtain.obj = bundle;
        com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    /* loaded from: classes7.dex */
    private static class d extends Handler {
        private WeakReference<b> dkq;

        d() {
            super(Looper.getMainLooper());
        }

        public void a(b bVar) {
            this.dkq = new WeakReference<>(bVar);
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
                    s(message);
                    return;
                case 111:
                    if (message.obj instanceof Bundle) {
                        com.baidu.swan.apps.runtime.d.aGI().f("event_messenger_call_in", (Bundle) message.obj);
                        return;
                    }
                    return;
                case 112:
                case 113:
                case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                case Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER /* 124 */:
                case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                default:
                    if (!r(message)) {
                        super.handleMessage(message);
                        return;
                    }
                    return;
                case 114:
                    t(message);
                    return;
                case 115:
                    w(message);
                    return;
                case 116:
                    x(message);
                    return;
                case 117:
                    u(message);
                    return;
                case 118:
                    A(message);
                    return;
                case 119:
                    com.baidu.l.d.l((Bundle) message.obj);
                    return;
                case 120:
                    y(message);
                    return;
                case Constants.METHOD_IM_FRIEND_GROUP_DROP /* 121 */:
                    v(message);
                    return;
                case 122:
                    z(message);
                    return;
                case Opcodes.IAND /* 126 */:
                    com.baidu.swan.apps.process.messaging.a.a.q(message);
                    return;
            }
        }

        private boolean r(Message message) {
            b bVar = this.dkq != null ? this.dkq.get() : null;
            if (bVar != null && bVar.l(message)) {
                return true;
            }
            return com.baidu.swan.apps.t.a.awU().l(message);
        }

        private void s(Message message) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", "handleKillActivity");
            }
            if (com.baidu.swan.apps.runtime.d.aGI().aEV()) {
                e.M(com.baidu.swan.apps.runtime.d.aGI().aGG());
            }
        }

        private void t(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aGI().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check swanCore version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0 && com.baidu.swan.apps.core.turbo.d.ara().arv() != null) {
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + com.baidu.swan.apps.core.turbo.d.ara().arv());
                        }
                        com.baidu.swan.apps.core.turbo.d.ard();
                    }
                }
            }
        }

        private void u(Message message) {
            Bundle bundle;
            SwanCoreVersion arv;
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aGI().getAppId()) && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j != 0 && (arv = com.baidu.swan.games.j.a.aUI().arv()) != null && arv.swanCoreVersion != 0 && arv.swanCoreVersion < j) {
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + arv);
                    }
                    com.baidu.swan.games.j.a.release();
                }
            }
        }

        private void v(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aGI().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check extension version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0) {
                        ExtensionCore arw = com.baidu.swan.apps.core.turbo.d.ara().arw();
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + arw);
                        }
                        if (arw != null && arw.extensionCoreVersionCode < j) {
                            if (a.DEBUG) {
                                Log.d("SwanAppMessengerClient", "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + arw);
                            }
                            com.baidu.swan.apps.core.turbo.d.ard();
                        }
                    }
                }
            }
        }

        private void w(Message message) {
            Bundle bundle;
            com.baidu.l.a.a aVar;
            if (message != null && (bundle = (Bundle) message.obj) != null && (aVar = com.baidu.swan.apps.aa.a.aCw().dgC) != null) {
                aVar.onPayResult(com.baidu.swan.apps.aa.a.jA(bundle.getInt("_wxapi_baseresp_errcode")), bundle.getString("_wxapi_baseresp_errstr"));
            }
        }

        private void x(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                String string = bundle.getString("ai_apps_data");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        com.baidu.swan.apps.scheme.actions.d.a.aIb().x(Intent.parseUri(string, 0));
                    } catch (URISyntaxException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        private void y(Message message) {
            PMSAppInfo ayl;
            Bundle bundle = (Bundle) message.obj;
            bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
            PrefetchEvent prefetchEvent = (PrefetchEvent) bundle.getParcelable("swan_app_bundle_prefetch");
            if (prefetchEvent != null && prefetchEvent.isValid()) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "PrefetchMessage execCall event: " + prefetchEvent);
                }
                if (f(prefetchEvent)) {
                    b.a aVar = new b.a();
                    PMSAppInfo pMSAppInfo = (PMSAppInfo) bundle.getParcelable("swan_app_prefetch_pms_info");
                    if (pMSAppInfo == null) {
                        pMSAppInfo = com.baidu.swan.pms.database.a.baA().yh(prefetchEvent.appId);
                    }
                    aVar.k(pMSAppInfo);
                    com.baidu.swan.apps.runtime.d.aGI().e(aVar.toBundle(), "update_tag_by_prefetch");
                }
                com.baidu.swan.apps.runtime.e aGE = com.baidu.swan.apps.runtime.d.aGI().aGE();
                if (aGE != null && (ayl = aGE.aGQ().ayl()) != null) {
                    if (TextUtils.equals(prefetchEvent.appId, ayl.appId)) {
                        prefetchEvent.appPath = d.C0462d.bM(prefetchEvent.appId, String.valueOf(ayl.versionCode)).getPath() + File.separator;
                        prefetchEvent.appConfig = com.baidu.swan.apps.r.d.y(new File(prefetchEvent.appPath, "app.json"));
                        if (aGE.aGV() == null) {
                            com.baidu.swan.apps.r.d.e(aGE);
                        }
                        prefetchEvent.pageUrl = a(prefetchEvent, aGE);
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "PrefetchEvent - " + prefetchEvent.toString());
                        }
                        com.baidu.swan.apps.core.turbo.d.ara().a(prefetchEvent.appId, PrefetchEvent.a(prefetchEvent, bundle));
                    }
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "PrefetchMessage send event end.");
                    }
                }
            }
        }

        private String a(PrefetchEvent prefetchEvent, @NonNull com.baidu.swan.apps.runtime.e eVar) {
            SwanAppConfigData aGV = eVar.aGV();
            if (aGV == null) {
                if (a.DEBUG) {
                    Log.w("SwanAppMessengerClient", "getPrefectPageUrl - configData is null ");
                }
                return null;
            }
            String a2 = com.baidu.swan.apps.u.c.b.a(prefetchEvent.schema, aGV);
            if (TextUtils.isEmpty(a2)) {
                return aGV.ayP();
            }
            return a2;
        }

        private boolean f(PrefetchEvent prefetchEvent) {
            com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
            if (aGN == null) {
                return true;
            }
            return (aGN.available() || TextUtils.equals(aGN.getAppId(), prefetchEvent.appId)) ? false : true;
        }

        private void z(Message message) {
            Bundle bundle;
            if (a.DEBUG) {
                Log.d("AppLaunchMessenger", "handleAppOnLaunch msg start.");
            }
            com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
            if ((aGN == null || !aGN.available()) && com.baidu.swan.apps.core.turbo.d.ara().ari() && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                Bundle bundle2 = bundle.getBundle("swan_app_on_launch_event");
                if (bundle2 != null) {
                    if (a.DEBUG) {
                        Log.d("AppLaunchMessenger", "handleAppOnLaunch get bundle.");
                    }
                    com.baidu.swan.apps.runtime.d.aGI().e(bundle2, "update_tag_by_app_launch");
                    com.baidu.swan.apps.runtime.e aGN2 = com.baidu.swan.apps.runtime.e.aGN();
                    if (aGN2 != null && com.baidu.swan.apps.r.d.e(aGN2)) {
                        if (a.DEBUG) {
                            Log.d("AppLaunchMessenger", "handleAppOnLaunch swan app updated.");
                        }
                        f.azg().jf(aGN2.aeW());
                        com.baidu.swan.apps.core.turbo.d.ara().c(aGN2);
                        if (a.DEBUG) {
                            Log.d("AppLaunchMessenger", "handleAppOnLaunch msg end");
                        }
                    }
                }
            }
        }

        private void A(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                bundle.setClassLoader(PMSAppInfo.class.getClassLoader());
                com.baidu.swan.apps.runtime.d.aGI().e(bundle, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle aEO() {
        Bundle bundle = new Bundle();
        bundle.putInt("process_id", SwanAppProcessInfo.current().index);
        bundle.putString("app_id", getAppId());
        bundle.putParcelable("app_core", aEW());
        return bundle;
    }
}
