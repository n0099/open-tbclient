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
/* loaded from: classes10.dex */
public final class a extends com.baidu.swan.apps.process.messaging.b {
    private final d dlR;
    private Messenger dlS;
    private c dlT;
    private final Deque<Long> dlU;
    private List<Runnable> dlV;
    private ServiceConnection mConnection;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final long dlQ = TimeUnit.MINUTES.toMillis(5);
    private static final Object SZ = new Object();

    /* loaded from: classes10.dex */
    public interface b {
        boolean l(Message message);
    }

    /* loaded from: classes10.dex */
    public interface c {
        void aFx();

        void aFy();
    }

    public a(h hVar) {
        super(hVar);
        this.dlR = new d();
        this.dlU = new ArrayDeque();
    }

    @Deprecated
    public static a aFo() {
        return com.baidu.swan.apps.runtime.d.aHq().aHl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Messenger aFp() {
        return this.dlS;
    }

    public synchronized void aFq() {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "tryBindRemoteMsgService");
        }
        if (this.mConnection == null) {
            this.mConnection = new ServiceConnectionC0460a();
            Application awA = com.baidu.swan.apps.t.a.awA();
            try {
                awA.bindService(new Intent(awA, SwanAppMessengerService.class), this.mConnection, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler aFr() {
        return this.dlR;
    }

    public void a(c cVar, b bVar) {
        this.dlT = cVar;
        this.dlR.a(bVar);
        d(1, aFw());
        if (this.dlT != null && aFs()) {
            this.dlT.aFx();
        }
    }

    public boolean aFs() {
        return this.dlS != null;
    }

    public void auT() {
        sendMessage(2);
    }

    public synchronized void aFt() {
        this.mConnection = null;
        this.dlS = null;
        if (this.dlT != null) {
            this.dlT.aFy();
        }
        aFv();
        if (this.dlV != null) {
            synchronized (SZ) {
                for (Runnable runnable : this.dlV) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                this.dlV.clear();
            }
        }
    }

    private void rB(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "SwanRebind:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.dlU.iterator();
            while (it.hasNext()) {
                Log.i("SwanAppMessengerClient", "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    private boolean aFu() {
        synchronized (this.dlU) {
            rB("checkRebindable ===>");
            if (this.dlU.size() < 3) {
                rB(String.format(Locale.getDefault(), "allowRebind by size(%d) < max(%d)", Integer.valueOf(this.dlU.size()), 3));
                return true;
            }
            int size = this.dlU.size() - 3;
            rB("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    rB("purge: " + this.dlU.poll());
                }
            }
            rB("after purge");
            Long peek = this.dlU.peek();
            if (peek == null) {
                rB("allowRebind by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > dlQ;
            rB("allowRebind:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void aFv() {
        synchronized (this.dlU) {
            if (aFu()) {
                this.dlU.offer(Long.valueOf(System.currentTimeMillis()));
                aFq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.client.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class ServiceConnectionC0460a implements ServiceConnection {
        private ServiceConnectionC0460a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder));
            }
            if (a.this.aFs() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                if (a.DEBUG) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(a.this.aFs()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                    return;
                }
                return;
            }
            a.this.dlS = new Messenger(iBinder);
            a.this.d(13, a.this.aFw());
            if (a.this.dlT != null) {
                a.this.dlT.aFx();
            }
            com.baidu.swan.apps.process.messaging.a.aFe().aFf();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (a.DEBUG) {
                Log.d("SwanAppMessengerClient", "onServiceDisconnected");
            }
            a.this.aFt();
        }
    }

    public void f(@NonNull Runnable runnable) {
        synchronized (SZ) {
            if (this.dlV == null) {
                this.dlV = new ArrayList();
            }
            this.dlV.add(runnable);
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
            bundle2.putString("ai_apps_observer_id", cVar.aEW());
            com.baidu.swan.apps.process.a.b.b.a.aEX().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        bundle2.putString("ai_apps_id", getAppId());
        obtain.obj = bundle2;
        com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(obtain).gf(true));
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
        com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(obtain));
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
        com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    public void d(int i, Bundle bundle) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        Message obtain = Message.obtain(null, i, bundle);
        obtain.arg1 = current.index;
        obtain.obj = bundle;
        com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    /* loaded from: classes10.dex */
    private static class d extends Handler {
        private WeakReference<b> dlX;

        d() {
            super(Looper.getMainLooper());
        }

        public void a(b bVar) {
            this.dlX = new WeakReference<>(bVar);
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
                        com.baidu.swan.apps.runtime.d.aHq().f("event_messenger_call_in", (Bundle) message.obj);
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
            b bVar = this.dlX != null ? this.dlX.get() : null;
            if (bVar != null && bVar.l(message)) {
                return true;
            }
            return com.baidu.swan.apps.t.a.axC().l(message);
        }

        private void s(Message message) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", "handleKillActivity");
            }
            if (com.baidu.swan.apps.runtime.d.aHq().aFD()) {
                e.N(com.baidu.swan.apps.runtime.d.aHq().aHo());
            }
        }

        private void t(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aHq().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check swanCore version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0 && com.baidu.swan.apps.core.turbo.d.arI().asd() != null) {
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + com.baidu.swan.apps.core.turbo.d.arI().asd());
                        }
                        com.baidu.swan.apps.core.turbo.d.arL();
                    }
                }
            }
        }

        private void u(Message message) {
            Bundle bundle;
            SwanCoreVersion asd;
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aHq().getAppId()) && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j != 0 && (asd = com.baidu.swan.games.j.a.aVq().asd()) != null && asd.swanCoreVersion != 0 && asd.swanCoreVersion < j) {
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + asd);
                    }
                    com.baidu.swan.games.j.a.release();
                }
            }
        }

        private void v(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aHq().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check extension version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0) {
                        ExtensionCore ase = com.baidu.swan.apps.core.turbo.d.arI().ase();
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + ase);
                        }
                        if (ase != null && ase.extensionCoreVersionCode < j) {
                            if (a.DEBUG) {
                                Log.d("SwanAppMessengerClient", "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + ase);
                            }
                            com.baidu.swan.apps.core.turbo.d.arL();
                        }
                    }
                }
            }
        }

        private void w(Message message) {
            Bundle bundle;
            com.baidu.l.a.a aVar;
            if (message != null && (bundle = (Bundle) message.obj) != null && (aVar = com.baidu.swan.apps.aa.a.aDe().dik) != null) {
                aVar.onPayResult(com.baidu.swan.apps.aa.a.jE(bundle.getInt("_wxapi_baseresp_errcode")), bundle.getString("_wxapi_baseresp_errstr"));
            }
        }

        private void x(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                String string = bundle.getString("ai_apps_data");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        com.baidu.swan.apps.scheme.actions.d.a.aIJ().x(Intent.parseUri(string, 0));
                    } catch (URISyntaxException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        private void y(Message message) {
            PMSAppInfo ayT;
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
                        pMSAppInfo = com.baidu.swan.pms.database.a.bbh().ym(prefetchEvent.appId);
                    }
                    aVar.k(pMSAppInfo);
                    com.baidu.swan.apps.runtime.d.aHq().e(aVar.toBundle(), "update_tag_by_prefetch");
                }
                com.baidu.swan.apps.runtime.e aHm = com.baidu.swan.apps.runtime.d.aHq().aHm();
                if (aHm != null && (ayT = aHm.aHy().ayT()) != null) {
                    if (TextUtils.equals(prefetchEvent.appId, ayT.appId)) {
                        prefetchEvent.appPath = d.C0464d.bN(prefetchEvent.appId, String.valueOf(ayT.versionCode)).getPath() + File.separator;
                        prefetchEvent.appConfig = com.baidu.swan.apps.r.d.y(new File(prefetchEvent.appPath, "app.json"));
                        if (aHm.aHD() == null) {
                            com.baidu.swan.apps.r.d.e(aHm);
                        }
                        prefetchEvent.pageUrl = a(prefetchEvent, aHm);
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "PrefetchEvent - " + prefetchEvent.toString());
                        }
                        com.baidu.swan.apps.core.turbo.d.arI().a(prefetchEvent.appId, PrefetchEvent.a(prefetchEvent, bundle));
                    }
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "PrefetchMessage send event end.");
                    }
                }
            }
        }

        private String a(PrefetchEvent prefetchEvent, @NonNull com.baidu.swan.apps.runtime.e eVar) {
            SwanAppConfigData aHD = eVar.aHD();
            if (aHD == null) {
                if (a.DEBUG) {
                    Log.w("SwanAppMessengerClient", "getPrefectPageUrl - configData is null ");
                }
                return null;
            }
            String a2 = com.baidu.swan.apps.u.c.b.a(prefetchEvent.schema, aHD);
            if (TextUtils.isEmpty(a2)) {
                return aHD.azx();
            }
            return a2;
        }

        private boolean f(PrefetchEvent prefetchEvent) {
            com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
            if (aHv == null) {
                return true;
            }
            return (aHv.available() || TextUtils.equals(aHv.getAppId(), prefetchEvent.appId)) ? false : true;
        }

        private void z(Message message) {
            Bundle bundle;
            if (a.DEBUG) {
                Log.d("AppLaunchMessenger", "handleAppOnLaunch msg start.");
            }
            com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
            if ((aHv == null || !aHv.available()) && com.baidu.swan.apps.core.turbo.d.arI().arQ() && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                Bundle bundle2 = bundle.getBundle("swan_app_on_launch_event");
                if (bundle2 != null) {
                    if (a.DEBUG) {
                        Log.d("AppLaunchMessenger", "handleAppOnLaunch get bundle.");
                    }
                    com.baidu.swan.apps.runtime.d.aHq().e(bundle2, "update_tag_by_app_launch");
                    com.baidu.swan.apps.runtime.e aHv2 = com.baidu.swan.apps.runtime.e.aHv();
                    if (aHv2 != null && com.baidu.swan.apps.r.d.e(aHv2)) {
                        if (a.DEBUG) {
                            Log.d("AppLaunchMessenger", "handleAppOnLaunch swan app updated.");
                        }
                        f.azO().jj(aHv2.afE());
                        com.baidu.swan.apps.core.turbo.d.arI().c(aHv2);
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
                com.baidu.swan.apps.runtime.d.aHq().e(bundle, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle aFw() {
        Bundle bundle = new Bundle();
        bundle.putInt("process_id", SwanAppProcessInfo.current().index);
        bundle.putString("app_id", getAppId());
        bundle.putParcelable("app_core", aFE());
        return bundle;
    }
}
