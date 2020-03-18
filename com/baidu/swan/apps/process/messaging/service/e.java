package com.baidu.swan.apps.process.messaging.service;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public final class e {
    static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final long bJX = TimeUnit.MINUTES.toMillis(5);
    private final LinkedHashMap<SwanAppProcessInfo, c> bJW;
    private final Deque<Long> bJY;
    private final Set<com.baidu.swan.apps.process.messaging.service.a> bJZ;
    private final com.baidu.swan.apps.process.messaging.service.a bKa;
    public final Messenger mMessenger;

    /* loaded from: classes11.dex */
    public interface a<FILTER> {
        boolean a(FILTER filter, c cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        private static e bKf = new e();
    }

    public static e abx() {
        if (!DEBUG || ProcessUtils.isMainProcess()) {
            return b.bKf;
        }
        throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
    }

    private e() {
        SwanAppProcessInfo[] indices;
        this.bJW = new LinkedHashMap<>();
        this.bJY = new ArrayDeque();
        this.mMessenger = new Messenger(new SwanAppMessengerService.a());
        this.bJZ = new HashSet();
        this.bKa = new com.baidu.swan.apps.process.messaging.service.a() { // from class: com.baidu.swan.apps.process.messaging.service.e.1
            @Override // com.baidu.swan.apps.process.messaging.service.a
            public void b(final String str, final c cVar) {
                if (e.DEBUG) {
                    Log.i("SwanPuppetManager", "onEvent: to=" + e.this.bJZ.size() + " event=" + str + " client=" + cVar.bJL);
                }
                synchronized (e.this.bJZ) {
                    com.baidu.swan.apps.as.d.a.a(com.baidu.swan.apps.runtime.d.getMainHandler(), (com.baidu.swan.apps.as.d.b) new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.process.messaging.service.a>() { // from class: com.baidu.swan.apps.process.messaging.service.e.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.as.d.b
                        /* renamed from: b */
                        public void D(com.baidu.swan.apps.process.messaging.service.a aVar) {
                            aVar.b(str, cVar);
                        }
                    }, (Collection) e.this.bJZ);
                }
            }

            @Override // com.baidu.swan.apps.process.messaging.service.a
            public void Vs() {
            }
        };
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.bJW.put(swanAppProcessInfo, new c(swanAppProcessInfo));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.swan.apps.process.messaging.service.a aby() {
        return this.bKa;
    }

    public void a(final com.baidu.swan.apps.process.messaging.service.a aVar, long j) {
        synchronized (this.bJZ) {
            this.bJZ.add(aVar);
            if (DEBUG) {
                Log.i("SwanPuppetManager", "addCallback: after = " + this.bJZ.size());
            }
        }
        if (j > 0) {
            com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.service.e.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (e.this.bJZ) {
                        if (e.this.bJZ.contains(aVar)) {
                            if (e.DEBUG) {
                                Log.i("SwanPuppetManager", "timeout: callback = " + aVar);
                            }
                            e.this.a(aVar);
                            aVar.Vs();
                        }
                    }
                }
            }, j);
        }
    }

    public void a(com.baidu.swan.apps.process.messaging.service.a aVar) {
        synchronized (this.bJZ) {
            this.bJZ.remove(aVar);
            if (DEBUG) {
                Log.i("SwanPuppetManager", "delCallback: after = " + this.bJZ.size());
            }
        }
    }

    public synchronized c fG(int i) {
        return a(SwanAppProcessInfo.indexOf(i));
    }

    public synchronized c a(SwanAppProcessInfo swanAppProcessInfo) {
        return this.bJW.get(swanAppProcessInfo);
    }

    public synchronized <FILTER> c a(FILTER filter, a<FILTER> aVar) {
        c cVar;
        Iterator<c> it = this.bJW.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                cVar = null;
                break;
            }
            cVar = it.next();
            if (aVar.a(filter, cVar)) {
                break;
            }
        }
        return cVar;
    }

    public synchronized LinkedHashSet<c> abz() {
        return new LinkedHashSet<>(this.bJW.values());
    }

    public synchronized c kv(@Nullable String str) {
        c kx;
        kx = kx(str);
        if (kx == null) {
            kx = abA();
        }
        return kx;
    }

    @NonNull
    public synchronized c kw(@Nullable String str) {
        c kv;
        kv = kv(str);
        b(kv.bJL);
        return kv;
    }

    public synchronized c abA() {
        c a2;
        c cVar;
        c cVar2 = null;
        synchronized (this) {
            kA("b4 computNextAvailableProcess");
            int i = 0;
            c cVar3 = null;
            while (true) {
                if (i <= 5) {
                    a2 = this.bJW.get(SwanAppProcessInfo.indexOf(i));
                    if (a2 != null && a2.bJL.isSwanAppProcess()) {
                        if (a2.abm()) {
                            a2 = cVar2;
                            cVar = cVar3;
                        } else if (a2.abl()) {
                            if (DEBUG) {
                                Log.i("SwanPuppetManager", "computNextAvailableProcess: firstPreloadedClient=" + a2);
                            }
                        } else {
                            if (cVar3 == null && a2.abo()) {
                                cVar3 = a2;
                            }
                            if (cVar2 == null) {
                                cVar = cVar3;
                            }
                        }
                        i++;
                        cVar3 = cVar;
                        cVar2 = a2;
                    }
                    a2 = cVar2;
                    cVar = cVar3;
                    i++;
                    cVar3 = cVar;
                    cVar2 = a2;
                } else if (cVar3 != null) {
                    if (DEBUG) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: firstConnectedEmptyClient=" + cVar3);
                    }
                    a2 = cVar3;
                } else if (cVar2 != null) {
                    if (DEBUG) {
                        Log.i("SwanPuppetManager", "computNextAvailableProcess: firstEmptyClient=" + cVar2);
                    }
                    a2 = cVar2;
                } else {
                    Iterator<c> it = this.bJW.values().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            a2 = it.next();
                            if (a2 != null) {
                                if (DEBUG) {
                                    Log.i("SwanPuppetManager", "computNextAvailableProcess: lruClient=" + a2);
                                }
                            }
                        } else {
                            if (DEBUG) {
                                Log.i("SwanPuppetManager", "computNextAvailableProcess: P0");
                            }
                            a2 = a(SwanAppProcessInfo.P0);
                        }
                    }
                }
            }
        }
        return a2;
    }

    @Nullable
    public synchronized c abB() {
        c cVar;
        kA("b4 computNextPreloadProcess");
        int i = 0;
        cVar = null;
        while (true) {
            if (i <= 5) {
                c cVar2 = this.bJW.get(SwanAppProcessInfo.indexOf(i));
                if (cVar2 != null && cVar2.bJL.isSwanAppProcess()) {
                    if (cVar2.abm()) {
                        cVar2 = cVar;
                    } else if (cVar2.abl()) {
                        if (DEBUG) {
                            Log.i("SwanPuppetManager", "computNextPreloadProcess: return null by found empty process=" + cVar2);
                        }
                        cVar = null;
                    } else if (cVar == null) {
                    }
                    i++;
                    cVar = cVar2;
                }
                cVar2 = cVar;
                i++;
                cVar = cVar2;
            } else if (DEBUG) {
                Log.i("SwanPuppetManager", "computNextPreloadProcess: firstPreloadableClient=" + cVar);
            }
        }
        return cVar;
    }

    @Nullable
    public synchronized c kx(@Nullable String str) {
        List<c> ky;
        ky = ky(str);
        return ky.isEmpty() ? null : ky.get(ky.size() - 1);
    }

    @NonNull
    public synchronized List<c> ky(@Nullable String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (c cVar : this.bJW.values()) {
                if (TextUtils.equals(cVar.getAppId(), str)) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    public synchronized void b(SwanAppProcessInfo swanAppProcessInfo) {
        c remove = this.bJW.remove(swanAppProcessInfo);
        if (remove != null) {
            this.bJW.put(swanAppProcessInfo, remove);
        }
        kA("lru -> " + swanAppProcessInfo);
    }

    public synchronized void c(String str, c cVar) {
        if (!TextUtils.isEmpty(str)) {
            List<c> ky = abx().ky(str);
            if (!ky.isEmpty()) {
                for (c cVar2 : ky) {
                    if (cVar2 != cVar && cVar2 != null && cVar2.abm()) {
                        if (DEBUG) {
                            Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + cVar);
                            Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + cVar2);
                        }
                        cVar2.abw().abu();
                        if (cVar2.abo()) {
                            com.baidu.swan.apps.process.messaging.a.aaO().a(new com.baidu.swan.apps.process.messaging.c(110, new Bundle()).a(cVar2.bJL));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void abC() {
        synchronized (this.bJY) {
            if (abD()) {
                this.bJY.offer(Long.valueOf(System.currentTimeMillis()));
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "1");
                com.baidu.swan.apps.process.messaging.service.b.c(com.baidu.swan.apps.w.a.TZ(), bundle);
            }
        }
    }

    private boolean abD() {
        synchronized (this.bJY) {
            kz("checkRescuable ===>");
            if (this.bJY.size() < 3) {
                kz(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.bJY.size()), 3));
                return true;
            }
            int size = this.bJY.size() - 3;
            kz("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    kz("purge: " + this.bJY.poll());
                }
            }
            kz("after purge");
            Long peek = this.bJY.peek();
            if (peek == null) {
                kz("allowRescue by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > bJX;
            kz("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void kz(String str) {
        if (DEBUG) {
            Log.i("SwanPuppetManager", "SwanRescue:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.bJY.iterator();
            while (it.hasNext()) {
                Log.i("SwanPuppetManager", "SwanRescue::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(Message message) {
        c a2;
        if (message != null) {
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && (a2 = a(indexOf)) != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                a2.aw(bundle.getLong("property_launch_cost", -1L));
            }
        }
    }

    public void kA(String str) {
        if (DEBUG) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanPuppetManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public String toString() {
        LinkedHashSet<c> abz = abz();
        StringBuilder append = new StringBuilder().append(super.toString()).append(":").append("\n-> clients: ");
        for (c cVar : abz) {
            append.append("\n--> ").append(cVar.toString());
        }
        return append.toString();
    }
}
