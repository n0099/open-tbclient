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
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.ao.e;
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
/* loaded from: classes8.dex */
public final class a extends com.baidu.swan.apps.process.messaging.b {
    private final d dru;
    private Messenger drv;
    private c drw;
    private final Deque<Long> drx;
    private List<Runnable> dry;
    private ServiceConnection mConnection;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final long drt = TimeUnit.MINUTES.toMillis(5);
    private static final Object TT = new Object();

    /* loaded from: classes8.dex */
    public interface b {
        boolean l(Message message);
    }

    /* loaded from: classes8.dex */
    public interface c {
        void aFx();

        void aFy();
    }

    public a(h hVar) {
        super(hVar);
        this.dru = new d();
        this.drx = new ArrayDeque();
    }

    @Deprecated
    public static a aFo() {
        return com.baidu.swan.apps.runtime.d.aIn().aIi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Messenger aFp() {
        return this.drv;
    }

    public synchronized void aFq() {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "tryBindRemoteMsgService");
        }
        if (this.mConnection == null) {
            this.mConnection = new ServiceConnectionC0445a();
            Application awy = com.baidu.swan.apps.t.a.awy();
            try {
                awy.bindService(new Intent(awy, SwanAppMessengerService.class), this.mConnection, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler aFr() {
        return this.dru;
    }

    public void a(c cVar, b bVar) {
        this.drw = cVar;
        this.dru.a(bVar);
        d(1, aFw());
        if (this.drw != null && aFs()) {
            this.drw.aFx();
        }
    }

    public boolean aFs() {
        return this.drv != null;
    }

    public void auR() {
        is(2);
    }

    public synchronized void aFt() {
        this.mConnection = null;
        this.drv = null;
        if (this.drw != null) {
            this.drw.aFy();
        }
        aFv();
        if (this.dry != null) {
            synchronized (TT) {
                for (Runnable runnable : this.dry) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                this.dry.clear();
            }
        }
    }

    private void qK(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessengerClient", "SwanRebind:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.drx.iterator();
            while (it.hasNext()) {
                Log.i("SwanAppMessengerClient", "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    private boolean aFu() {
        synchronized (this.drx) {
            qK("checkRebindable ===>");
            if (this.drx.size() < 3) {
                qK(String.format(Locale.getDefault(), "allowRebind by size(%d) < max(%d)", Integer.valueOf(this.drx.size()), 3));
                return true;
            }
            int size = this.drx.size() - 3;
            qK("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    qK("purge: " + this.drx.poll());
                }
            }
            qK("after purge");
            Long peek = this.drx.peek();
            if (peek == null) {
                qK("allowRebind by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > drt;
            qK("allowRebind:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void aFv() {
        synchronized (this.drx) {
            if (aFu()) {
                this.drx.offer(Long.valueOf(System.currentTimeMillis()));
                aFq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.client.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ServiceConnectionC0445a implements ServiceConnection {
        private ServiceConnectionC0445a() {
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
            a.this.drv = new Messenger(iBinder);
            a.this.d(13, a.this.aFw());
            if (a.this.drw != null) {
                a.this.drw.aFx();
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

    public void e(@NonNull Runnable runnable) {
        synchronized (TT) {
            if (this.dry == null) {
                this.dry = new ArrayList();
            }
            this.dry.add(runnable);
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
        com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(obtain).gC(true));
    }

    @Deprecated
    public void is(int i) {
        ap(i, "");
    }

    @Deprecated
    public void ap(int i, String str) {
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

    /* loaded from: classes8.dex */
    private static class d extends Handler {
        private WeakReference<b> drA;

        d() {
            super(Looper.getMainLooper());
        }

        public void a(b bVar) {
            this.drA = new WeakReference<>(bVar);
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
                        com.baidu.swan.apps.runtime.d.aIn().g("event_messenger_call_in", (Bundle) message.obj);
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
                    com.baidu.k.d.l((Bundle) message.obj);
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
            b bVar = this.drA != null ? this.drA.get() : null;
            if (bVar != null && bVar.l(message)) {
                return true;
            }
            return com.baidu.swan.apps.t.a.axA().l(message);
        }

        private void s(Message message) {
            if (a.DEBUG) {
                Log.i("SwanAppMessengerClient", "handleKillActivity");
            }
            if (com.baidu.swan.apps.runtime.d.aIn().aFD()) {
                e.N(com.baidu.swan.apps.runtime.d.aIn().aIl());
            }
        }

        private void t(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aIn().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check swanCore version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0 && com.baidu.swan.apps.core.turbo.d.arG().asb() != null) {
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + com.baidu.swan.apps.core.turbo.d.arG().asb());
                        }
                        com.baidu.swan.apps.core.turbo.d.arJ();
                    }
                }
            }
        }

        private void u(Message message) {
            Bundle bundle;
            SwanCoreVersion asb;
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aIn().getAppId()) && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j != 0 && (asb = com.baidu.swan.games.j.a.aWo().asb()) != null && asb.swanCoreVersion != 0 && asb.swanCoreVersion < j) {
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + asb);
                    }
                    com.baidu.swan.games.j.a.release();
                }
            }
        }

        private void v(Message message) {
            if (message != null && TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aIn().getAppId())) {
                if (a.DEBUG) {
                    Log.d("SwanAppMessengerClient", "start check extension version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                    long j = bundle.getLong("ai_apps_data");
                    if (j != 0) {
                        ExtensionCore asc = com.baidu.swan.apps.core.turbo.d.arG().asc();
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + asc);
                        }
                        if (asc != null && asc.extensionCoreVersionCode < j) {
                            if (a.DEBUG) {
                                Log.d("SwanAppMessengerClient", "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + asc);
                            }
                            com.baidu.swan.apps.core.turbo.d.arJ();
                        }
                    }
                }
            }
        }

        private void w(Message message) {
            Bundle bundle;
            com.baidu.k.a.a aVar;
            if (message != null && (bundle = (Bundle) message.obj) != null && (aVar = com.baidu.swan.apps.aa.a.aDg().dnL) != null) {
                aVar.onPayResult(com.baidu.swan.apps.aa.a.in(bundle.getInt("_wxapi_baseresp_errcode")), bundle.getString("_wxapi_baseresp_errstr"));
            }
        }

        private void x(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle != null) {
                String string = bundle.getString("ai_apps_data");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        com.baidu.swan.apps.scheme.actions.d.a.aJG().x(Intent.parseUri(string, 0));
                    } catch (URISyntaxException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        private void y(Message message) {
            PMSAppInfo ayS;
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
                        pMSAppInfo = com.baidu.swan.pms.database.a.bci().xC(prefetchEvent.appId);
                    }
                    aVar.k(pMSAppInfo);
                    com.baidu.swan.apps.runtime.d.aIn().e(aVar.toBundle(), "update_tag_by_prefetch");
                }
                com.baidu.swan.apps.runtime.e aIj = com.baidu.swan.apps.runtime.d.aIn().aIj();
                if (aIj != null && (ayS = aIj.aIv().ayS()) != null) {
                    if (TextUtils.equals(prefetchEvent.appId, ayS.appId)) {
                        prefetchEvent.appPath = d.C0449d.bR(prefetchEvent.appId, String.valueOf(ayS.versionCode)).getPath() + File.separator;
                        prefetchEvent.appConfig = com.baidu.swan.apps.r.d.z(new File(prefetchEvent.appPath, "app.json"));
                        if (aIj.aIA() == null) {
                            com.baidu.swan.apps.r.d.e(aIj);
                        }
                        prefetchEvent.pageUrl = a(prefetchEvent, aIj);
                        if (a.DEBUG) {
                            Log.d("SwanAppMessengerClient", "PrefetchEvent - " + prefetchEvent.toString());
                        }
                        com.baidu.swan.apps.core.turbo.d.arG().a(prefetchEvent.appId, PrefetchEvent.a(prefetchEvent, bundle));
                    }
                    if (a.DEBUG) {
                        Log.d("SwanAppMessengerClient", "PrefetchMessage send event end.");
                    }
                }
            }
        }

        private String a(PrefetchEvent prefetchEvent, @NonNull com.baidu.swan.apps.runtime.e eVar) {
            SwanAppConfigData aIA = eVar.aIA();
            if (aIA == null) {
                if (a.DEBUG) {
                    Log.w("SwanAppMessengerClient", "getPrefectPageUrl - configData is null ");
                }
                return null;
            }
            String a2 = com.baidu.swan.apps.u.c.b.a(prefetchEvent.schema, aIA);
            if (TextUtils.isEmpty(a2)) {
                return aIA.azw();
            }
            return a2;
        }

        private boolean f(PrefetchEvent prefetchEvent) {
            com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
            if (aIs == null) {
                return true;
            }
            return (aIs.available() || TextUtils.equals(aIs.getAppId(), prefetchEvent.appId)) ? false : true;
        }

        private void z(Message message) {
            Bundle bundle;
            if (a.DEBUG) {
                Log.d("AppLaunchMessenger", "handleAppOnLaunch msg start.");
            }
            com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
            if ((aIs == null || !aIs.available()) && com.baidu.swan.apps.core.turbo.d.arG().arO() && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                Bundle bundle2 = bundle.getBundle("swan_app_on_launch_event");
                if (bundle2 != null) {
                    if (a.DEBUG) {
                        Log.d("AppLaunchMessenger", "handleAppOnLaunch get bundle.");
                    }
                    com.baidu.swan.apps.runtime.d.aIn().e(bundle2, "update_tag_by_app_launch");
                    com.baidu.swan.apps.runtime.e aIs2 = com.baidu.swan.apps.runtime.e.aIs();
                    if (aIs2 != null && com.baidu.swan.apps.r.d.e(aIs2)) {
                        if (a.DEBUG) {
                            Log.d("AppLaunchMessenger", "handleAppOnLaunch swan app updated.");
                        }
                        f.azN().hS(aIs2.afr());
                        com.baidu.swan.apps.core.turbo.d.arG().c(aIs2);
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
                com.baidu.swan.apps.runtime.d.aIn().e(bundle, null);
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
