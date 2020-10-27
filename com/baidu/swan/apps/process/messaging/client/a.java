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
    private final d dfW;
    private Messenger dfX;
    private c dfY;
    private final Deque<Long> dfZ;
    private List<Runnable> dga;
    private ServiceConnection mConnection;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final long dfV = TimeUnit.MINUTES.toMillis(5);
    private static final Object SZ = new Object();

    /* loaded from: classes10.dex */
    public interface b {
        boolean l(Message message);
    }

    /* loaded from: classes10.dex */
    public interface c {
        void aCX();

        void aCY();
    }

    public a(h hVar) {
        super(hVar);
        this.dfW = new d();
        this.dfZ = new ArrayDeque();
    }

    @Deprecated
    public static a aCO() {
        return com.baidu.swan.apps.runtime.d.aEQ().aEL();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Messenger aCP() {
        return this.dfX;
    }

    public synchronized void aCQ() {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "tryBindRemoteMsgService");
        }
        if (this.mConnection == null) {
            this.mConnection = new ServiceConnectionC0448a();
            Application aua = com.baidu.swan.apps.t.a.aua();
            try {
                aua.bindService(new Intent(aua, SwanAppMessengerService.class), this.mConnection, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler aCR() {
        return this.dfW;
    }

    public void a(c cVar, b bVar) {
        this.dfY = cVar;
        this.dfW.a(bVar);
        d(1, aCW());
        if (this.dfY != null && aCS()) {
            this.dfY.aCX();
        }
    }

    public boolean aCS() {
        return this.dfX != null;
    }

    public void ast() {
        sendMessage(2);
    }

    public synchronized void aCT() {
        this.mConnection = null;
        this.dfX = null;
        if (this.dfY != null) {
            this.dfY.aCY();
        }
        aCV();
        if (this.dga != null) {
            synchronized (SZ) {
                for (Runnable runnable : this.dga) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                this.dga.clear();
            }
        }
    }

    private void rn(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "SwanRebind:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.dfZ.iterator();
            while (it.hasNext()) {
                Log.i("SwanAppMessengerClient", "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    private boolean aCU() {
        synchronized (this.dfZ) {
            rn("checkRebindable ===>");
            if (this.dfZ.size() < 3) {
                rn(String.format(Locale.getDefault(), "allowRebind by size(%d) < max(%d)", Integer.valueOf(this.dfZ.size()), 3));
                return true;
            }
            int size = this.dfZ.size() - 3;
            rn("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    rn("purge: " + this.dfZ.poll());
                }
            }
            rn("after purge");
            Long peek = this.dfZ.peek();
            if (peek == null) {
                rn("allowRebind by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > dfV;
            rn("allowRebind:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void aCV() {
        synchronized (this.dfZ) {
            if (aCU()) {
                this.dfZ.offer(Long.valueOf(System.currentTimeMillis()));
                aCQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.client.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class ServiceConnectionC0448a implements ServiceConnection {
        private ServiceConnectionC0448a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder));
            }
            if (a.this.aCS() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                if (a.DEBUG) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(a.this.aCS()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                    return;
                }
                return;
            }
            a.this.dfX = new Messenger(iBinder);
            a.this.d(13, a.this.aCW());
            if (a.this.dfY != null) {
                a.this.dfY.aCX();
            }
            com.baidu.swan.apps.process.messaging.a.aCE().aCF();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (a.DEBUG) {
                Log.d("SwanAppMessengerClient", "onServiceDisconnected");
            }
            a.this.aCT();
        }
    }

    public void f(@NonNull Runnable runnable) {
        synchronized (SZ) {
            if (this.dga == null) {
                this.dga = new ArrayList();
            }
            this.dga.add(runnable);
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
            bundle2.putString("ai_apps_observer_id", cVar.aCw());
            com.baidu.swan.apps.process.a.b.b.a.aCx().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        bundle2.putString("ai_apps_id", getAppId());
        obtain.obj = bundle2;
        com.baidu.swan.apps.process.messaging.a.aCE().a(new com.baidu.swan.apps.process.messaging.c(obtain).fW(true));
    }

    @Deprecated
    public void sendMessage(int i) {
        ai(i, "");
    }

    @Deprecated
    public void ai(int i, String str) {
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
        com.baidu.swan.apps.process.messaging.a.aCE().a(new com.baidu.swan.apps.process.messaging.c(obtain));
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
        com.baidu.swan.apps.process.messaging.a.aCE().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    public void d(int i, Bundle bundle) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        Message obtain = Message.obtain(null, i, bundle);
        obtain.arg1 = current.index;
        obtain.obj = bundle;
        com.baidu.swan.apps.process.messaging.a.aCE().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    /* loaded from: classes10.dex */
    private static class d extends Handler {
        private WeakReference<b> dgc;

        d() {
            super(Looper.getMainLooper());
        }

        public void a(b bVar) {
            this.dgc = new WeakReference<>(bVar);
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
                        com.baidu.swan.apps.runtime.d.aEQ().f("event_messenger_call_in", (Bundle) message.obj);
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
            b bVar = this.dgc != null ? this.dgc.get() : null;
            if (bVar != null && bVar.l(message)) {
                return true;
            }
            return com.baidu.swan.apps.t.a.avc().l(message);
        }

        private void s(Message message) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", "handleKillActivity");
            }
            if (com.baidu.swan.apps.runtime.d.aEQ().aDd()) {
                e.N(com.baidu.swan.apps.runtime.d.aEQ().aEO());
            }
        }

        private void t(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aEQ().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check swanCore version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0 && com.baidu.swan.apps.core.turbo.d.aph().apD() != null) {
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + com.baidu.swan.apps.core.turbo.d.aph().apD());
                        }
                        com.baidu.swan.apps.core.turbo.d.apl();
                    }
                }
            }
        }

        private void u(Message message) {
            Bundle bundle;
            SwanCoreVersion apD;
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aEQ().getAppId()) && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j != 0 && (apD = com.baidu.swan.games.j.a.aSQ().apD()) != null && apD.swanCoreVersion != 0 && apD.swanCoreVersion < j) {
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + apD);
                    }
                    com.baidu.swan.games.j.a.release();
                }
            }
        }

        private void v(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aEQ().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check extension version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0) {
                        ExtensionCore apE = com.baidu.swan.apps.core.turbo.d.aph().apE();
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + apE);
                        }
                        if (apE != null && apE.extensionCoreVersionCode < j) {
                            if (a.DEBUG) {
                                Log.d("SwanAppMessengerClient", "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + apE);
                            }
                            com.baidu.swan.apps.core.turbo.d.apl();
                        }
                    }
                }
            }
        }

        private void w(Message message) {
            Bundle bundle;
            com.baidu.l.a.a aVar;
            if (message != null && (bundle = (Bundle) message.obj) != null && (aVar = com.baidu.swan.apps.aa.a.aAE().dco) != null) {
                aVar.onPayResult(com.baidu.swan.apps.aa.a.ju(bundle.getInt("_wxapi_baseresp_errcode")), bundle.getString("_wxapi_baseresp_errstr"));
            }
        }

        private void x(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                String string = bundle.getString("ai_apps_data");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        com.baidu.swan.apps.scheme.actions.d.a.aGj().x(Intent.parseUri(string, 0));
                    } catch (URISyntaxException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        private void y(Message message) {
            PMSAppInfo awt;
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
                        pMSAppInfo = com.baidu.swan.pms.database.a.aYH().xY(prefetchEvent.appId);
                    }
                    aVar.k(pMSAppInfo);
                    com.baidu.swan.apps.runtime.d.aEQ().e(aVar.toBundle(), "update_tag_by_prefetch");
                }
                com.baidu.swan.apps.runtime.e aEM = com.baidu.swan.apps.runtime.d.aEQ().aEM();
                if (aEM != null && (awt = aEM.aEY().awt()) != null) {
                    if (TextUtils.equals(prefetchEvent.appId, awt.appId)) {
                        prefetchEvent.appPath = d.C0452d.bN(prefetchEvent.appId, String.valueOf(awt.versionCode)).getPath() + File.separator;
                        prefetchEvent.appConfig = com.baidu.swan.apps.r.d.y(new File(prefetchEvent.appPath, "app.json"));
                        if (aEM.aFd() == null) {
                            com.baidu.swan.apps.r.d.e(aEM);
                        }
                        prefetchEvent.pageUrl = a(prefetchEvent, aEM);
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "PrefetchEvent - " + prefetchEvent.toString());
                        }
                        com.baidu.swan.apps.core.turbo.d.aph().a(prefetchEvent.appId, PrefetchEvent.a(prefetchEvent, bundle));
                    }
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "PrefetchMessage send event end.");
                    }
                }
            }
        }

        private String a(PrefetchEvent prefetchEvent, @NonNull com.baidu.swan.apps.runtime.e eVar) {
            SwanAppConfigData aFd = eVar.aFd();
            if (aFd == null) {
                if (a.DEBUG) {
                    Log.w("SwanAppMessengerClient", "getPrefectPageUrl - configData is null ");
                }
                return null;
            }
            String a2 = com.baidu.swan.apps.u.c.b.a(prefetchEvent.schema, aFd);
            if (TextUtils.isEmpty(a2)) {
                return aFd.awX();
            }
            return a2;
        }

        private boolean f(PrefetchEvent prefetchEvent) {
            com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
            if (aEV == null) {
                return true;
            }
            return (aEV.available() || TextUtils.equals(aEV.getAppId(), prefetchEvent.appId)) ? false : true;
        }

        private void z(Message message) {
            Bundle bundle;
            if (a.DEBUG) {
                Log.d("AppLaunchMessenger", "handleAppOnLaunch msg start.");
            }
            com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
            if ((aEV == null || !aEV.available()) && com.baidu.swan.apps.core.turbo.d.aph().apq() && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                Bundle bundle2 = bundle.getBundle("swan_app_on_launch_event");
                if (bundle2 != null) {
                    if (a.DEBUG) {
                        Log.d("AppLaunchMessenger", "handleAppOnLaunch get bundle.");
                    }
                    com.baidu.swan.apps.runtime.d.aEQ().e(bundle2, "update_tag_by_app_launch");
                    com.baidu.swan.apps.runtime.e aEV2 = com.baidu.swan.apps.runtime.e.aEV();
                    if (aEV2 != null && com.baidu.swan.apps.r.d.e(aEV2)) {
                        if (a.DEBUG) {
                            Log.d("AppLaunchMessenger", "handleAppOnLaunch swan app updated.");
                        }
                        f.axo().iZ(aEV2.ade());
                        com.baidu.swan.apps.core.turbo.d.aph().c(aEV2);
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
                com.baidu.swan.apps.runtime.d.aEQ().e(bundle, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle aCW() {
        Bundle bundle = new Bundle();
        bundle.putInt("process_id", SwanAppProcessInfo.current().index);
        bundle.putString("app_id", getAppId());
        bundle.putParcelable("app_core", aDe());
        return bundle;
    }
}
