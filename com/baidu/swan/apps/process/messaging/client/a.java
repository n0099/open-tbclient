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
/* loaded from: classes3.dex */
public final class a extends com.baidu.swan.apps.process.messaging.b {
    private final d cLs;
    private Messenger cLt;
    private c cLu;
    private final Deque<Long> cLv;
    private List<Runnable> cLw;
    private ServiceConnection mConnection;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final long cLr = TimeUnit.MINUTES.toMillis(5);
    private static final Object SF = new Object();

    /* loaded from: classes3.dex */
    public interface b {
        boolean l(Message message);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void ayu();

        void ayv();
    }

    public a(h hVar) {
        super(hVar);
        this.cLs = new d();
        this.cLv = new ArrayDeque();
    }

    @Deprecated
    public static a ayl() {
        return com.baidu.swan.apps.runtime.d.aAn().aAi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Messenger aym() {
        return this.cLt;
    }

    public synchronized void ayn() {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "tryBindRemoteMsgService");
        }
        if (this.mConnection == null) {
            this.mConnection = new ServiceConnectionC0417a();
            Application apu = com.baidu.swan.apps.t.a.apu();
            try {
                apu.bindService(new Intent(apu, SwanAppMessengerService.class), this.mConnection, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler ayo() {
        return this.cLs;
    }

    public void a(c cVar, b bVar) {
        this.cLu = cVar;
        this.cLs.a(bVar);
        d(1, ayt());
        if (this.cLu != null && ayp()) {
            this.cLu.ayu();
        }
    }

    public boolean ayp() {
        return this.cLt != null;
    }

    public void anM() {
        sendMessage(2);
    }

    public synchronized void ayq() {
        this.mConnection = null;
        this.cLt = null;
        if (this.cLu != null) {
            this.cLu.ayv();
        }
        ays();
        if (this.cLw != null) {
            synchronized (SF) {
                for (Runnable runnable : this.cLw) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                this.cLw.clear();
            }
        }
    }

    private void qi(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "SwanRebind:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.cLv.iterator();
            while (it.hasNext()) {
                Log.i("SwanAppMessengerClient", "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    private boolean ayr() {
        synchronized (this.cLv) {
            qi("checkRebindable ===>");
            if (this.cLv.size() < 3) {
                qi(String.format(Locale.getDefault(), "allowRebind by size(%d) < max(%d)", Integer.valueOf(this.cLv.size()), 3));
                return true;
            }
            int size = this.cLv.size() - 3;
            qi("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    qi("purge: " + this.cLv.poll());
                }
            }
            qi("after purge");
            Long peek = this.cLv.peek();
            if (peek == null) {
                qi("allowRebind by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > cLr;
            qi("allowRebind:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void ays() {
        synchronized (this.cLv) {
            if (ayr()) {
                this.cLv.offer(Long.valueOf(System.currentTimeMillis()));
                ayn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.client.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class ServiceConnectionC0417a implements ServiceConnection {
        private ServiceConnectionC0417a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder));
            }
            if (a.this.ayp() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                if (a.DEBUG) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(a.this.ayp()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                    return;
                }
                return;
            }
            a.this.cLt = new Messenger(iBinder);
            a.this.d(13, a.this.ayt());
            if (a.this.cLu != null) {
                a.this.cLu.ayu();
            }
            com.baidu.swan.apps.process.messaging.a.ayb().ayc();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (a.DEBUG) {
                Log.d("SwanAppMessengerClient", "onServiceDisconnected");
            }
            a.this.ayq();
        }
    }

    public void f(@NonNull Runnable runnable) {
        synchronized (SF) {
            if (this.cLw == null) {
                this.cLw = new ArrayList();
            }
            this.cLw.add(runnable);
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
            bundle2.putString("ai_apps_observer_id", cVar.axR());
            com.baidu.swan.apps.process.a.b.b.a.axS().a(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        bundle2.putString("ai_apps_id", getAppId());
        obtain.obj = bundle2;
        com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(obtain).fn(true));
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
        com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(obtain));
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
        com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    public void d(int i, Bundle bundle) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        Message obtain = Message.obtain(null, i, bundle);
        obtain.arg1 = current.index;
        obtain.obj = bundle;
        com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(obtain));
    }

    /* loaded from: classes3.dex */
    private static class d extends Handler {
        private WeakReference<b> cLy;

        d() {
            super(Looper.getMainLooper());
        }

        public void a(b bVar) {
            this.cLy = new WeakReference<>(bVar);
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
                        com.baidu.swan.apps.runtime.d.aAn().f("event_messenger_call_in", (Bundle) message.obj);
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
            b bVar = this.cLy != null ? this.cLy.get() : null;
            if (bVar != null && bVar.l(message)) {
                return true;
            }
            return com.baidu.swan.apps.t.a.aqw().l(message);
        }

        private void s(Message message) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", "handleKillActivity");
            }
            if (com.baidu.swan.apps.runtime.d.aAn().ayA()) {
                e.M(com.baidu.swan.apps.runtime.d.aAn().aAl());
            }
        }

        private void t(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aAn().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check swanCore version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0 && com.baidu.swan.apps.core.turbo.d.akC().akX() != null) {
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + com.baidu.swan.apps.core.turbo.d.akC().akX());
                        }
                        com.baidu.swan.apps.core.turbo.d.akF();
                    }
                }
            }
        }

        private void u(Message message) {
            Bundle bundle;
            SwanCoreVersion akX;
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aAn().getAppId()) && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j != 0 && (akX = com.baidu.swan.games.j.a.aOn().akX()) != null && akX.swanCoreVersion != 0 && akX.swanCoreVersion < j) {
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + akX);
                    }
                    com.baidu.swan.games.j.a.release();
                }
            }
        }

        private void v(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aAn().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check extension version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0) {
                        ExtensionCore akY = com.baidu.swan.apps.core.turbo.d.akC().akY();
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + akY);
                        }
                        if (akY != null && akY.extensionCoreVersionCode < j) {
                            if (a.DEBUG) {
                                Log.d("SwanAppMessengerClient", "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + akY);
                            }
                            com.baidu.swan.apps.core.turbo.d.akF();
                        }
                    }
                }
            }
        }

        private void w(Message message) {
            Bundle bundle;
            com.baidu.l.a.a aVar;
            if (message != null && (bundle = (Bundle) message.obj) != null && (aVar = com.baidu.swan.apps.aa.a.avZ().cHN) != null) {
                aVar.onPayResult(com.baidu.swan.apps.aa.a.iM(bundle.getInt("_wxapi_baseresp_errcode")), bundle.getString("_wxapi_baseresp_errstr"));
            }
        }

        private void x(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                String string = bundle.getString("ai_apps_data");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        com.baidu.swan.apps.scheme.actions.d.a.aBG().x(Intent.parseUri(string, 0));
                    } catch (URISyntaxException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        private void y(Message message) {
            PMSAppInfo arN;
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
                        pMSAppInfo = com.baidu.swan.pms.database.a.aUf().wT(prefetchEvent.appId);
                    }
                    aVar.k(pMSAppInfo);
                    com.baidu.swan.apps.runtime.d.aAn().e(aVar.toBundle(), "update_tag_by_prefetch");
                }
                com.baidu.swan.apps.runtime.e aAj = com.baidu.swan.apps.runtime.d.aAn().aAj();
                if (aAj != null && (arN = aAj.aAv().arN()) != null) {
                    if (TextUtils.equals(prefetchEvent.appId, arN.appId)) {
                        prefetchEvent.appPath = d.C0421d.bB(prefetchEvent.appId, String.valueOf(arN.versionCode)).getPath() + File.separator;
                        prefetchEvent.appConfig = com.baidu.swan.apps.r.d.v(new File(prefetchEvent.appPath, "app.json"));
                        if (aAj.aAA() == null) {
                            com.baidu.swan.apps.r.d.e(aAj);
                        }
                        prefetchEvent.pageUrl = a(prefetchEvent, aAj);
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "PrefetchEvent - " + prefetchEvent.toString());
                        }
                        com.baidu.swan.apps.core.turbo.d.akC().a(prefetchEvent.appId, PrefetchEvent.a(prefetchEvent, bundle));
                    }
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "PrefetchMessage send event end.");
                    }
                }
            }
        }

        private String a(PrefetchEvent prefetchEvent, @NonNull com.baidu.swan.apps.runtime.e eVar) {
            SwanAppConfigData aAA = eVar.aAA();
            if (aAA == null) {
                if (a.DEBUG) {
                    Log.w("SwanAppMessengerClient", "getPrefectPageUrl - configData is null ");
                }
                return null;
            }
            String a = com.baidu.swan.apps.u.c.b.a(prefetchEvent.schema, aAA);
            if (TextUtils.isEmpty(a)) {
                return aAA.ass();
            }
            return a;
        }

        private boolean f(PrefetchEvent prefetchEvent) {
            com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
            if (aAs == null) {
                return true;
            }
            return (aAs.available() || TextUtils.equals(aAs.getAppId(), prefetchEvent.appId)) ? false : true;
        }

        private void z(Message message) {
            Bundle bundle;
            if (a.DEBUG) {
                Log.d("AppLaunchMessenger", "handleAppOnLaunch msg start.");
            }
            com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
            if ((aAs == null || !aAs.available()) && com.baidu.swan.apps.core.turbo.d.akC().akK() && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                Bundle bundle2 = bundle.getBundle("swan_app_on_launch_event");
                if (bundle2 != null) {
                    if (a.DEBUG) {
                        Log.d("AppLaunchMessenger", "handleAppOnLaunch get bundle.");
                    }
                    com.baidu.swan.apps.runtime.d.aAn().e(bundle2, "update_tag_by_app_launch");
                    com.baidu.swan.apps.runtime.e aAs2 = com.baidu.swan.apps.runtime.e.aAs();
                    if (aAs2 != null && com.baidu.swan.apps.r.d.e(aAs2)) {
                        if (a.DEBUG) {
                            Log.d("AppLaunchMessenger", "handleAppOnLaunch swan app updated.");
                        }
                        f.asJ().ir(aAs2.Yy());
                        com.baidu.swan.apps.core.turbo.d.akC().c(aAs2);
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
                com.baidu.swan.apps.runtime.d.aAn().e(bundle, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle ayt() {
        Bundle bundle = new Bundle();
        bundle.putInt("process_id", SwanAppProcessInfo.current().index);
        bundle.putString("app_id", getAppId());
        bundle.putParcelable("app_core", ayB());
        return bundle;
    }
}
