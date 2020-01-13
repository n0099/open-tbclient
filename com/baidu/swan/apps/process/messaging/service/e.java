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
/* loaded from: classes10.dex */
public final class e {
    static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final long bFF = TimeUnit.MINUTES.toMillis(5);
    private final LinkedHashMap<SwanAppProcessInfo, c> bFE;
    private final Deque<Long> bFG;
    private final Set<com.baidu.swan.apps.process.messaging.service.a> bFH;
    private final com.baidu.swan.apps.process.messaging.service.a bFI;
    public final Messenger mMessenger;

    /* loaded from: classes10.dex */
    public interface a<FILTER> {
        boolean a(FILTER filter, c cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        private static e bFN = new e();
    }

    public static e Ze() {
        if (!DEBUG || ProcessUtils.isMainProcess()) {
            return b.bFN;
        }
        throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
    }

    private e() {
        SwanAppProcessInfo[] indices;
        this.bFE = new LinkedHashMap<>();
        this.bFG = new ArrayDeque();
        this.mMessenger = new Messenger(new SwanAppMessengerService.a());
        this.bFH = new HashSet();
        this.bFI = new com.baidu.swan.apps.process.messaging.service.a() { // from class: com.baidu.swan.apps.process.messaging.service.e.1
            @Override // com.baidu.swan.apps.process.messaging.service.a
            public void b(final String str, final c cVar) {
                if (e.DEBUG) {
                    Log.i("SwanPuppetManager", "onEvent: to=" + e.this.bFH.size() + " event=" + str + " client=" + cVar.bFt);
                }
                synchronized (e.this.bFH) {
                    com.baidu.swan.apps.as.d.a.a(com.baidu.swan.apps.runtime.d.getMainHandler(), (com.baidu.swan.apps.as.d.b) new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.process.messaging.service.a>() { // from class: com.baidu.swan.apps.process.messaging.service.e.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.as.d.b
                        /* renamed from: b */
                        public void B(com.baidu.swan.apps.process.messaging.service.a aVar) {
                            aVar.b(str, cVar);
                        }
                    }, (Collection) e.this.bFH);
                }
            }

            @Override // com.baidu.swan.apps.process.messaging.service.a
            public void SZ() {
            }
        };
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.bFE.put(swanAppProcessInfo, new c(swanAppProcessInfo));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.swan.apps.process.messaging.service.a Zf() {
        return this.bFI;
    }

    public void a(final com.baidu.swan.apps.process.messaging.service.a aVar, long j) {
        synchronized (this.bFH) {
            this.bFH.add(aVar);
            if (DEBUG) {
                Log.i("SwanPuppetManager", "addCallback: after = " + this.bFH.size());
            }
        }
        if (j > 0) {
            com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.service.e.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (e.this.bFH) {
                        if (e.this.bFH.contains(aVar)) {
                            if (e.DEBUG) {
                                Log.i("SwanPuppetManager", "timeout: callback = " + aVar);
                            }
                            e.this.a(aVar);
                            aVar.SZ();
                        }
                    }
                }
            }, j);
        }
    }

    public void a(com.baidu.swan.apps.process.messaging.service.a aVar) {
        synchronized (this.bFH) {
            this.bFH.remove(aVar);
            if (DEBUG) {
                Log.i("SwanPuppetManager", "delCallback: after = " + this.bFH.size());
            }
        }
    }

    public synchronized c fq(int i) {
        return a(SwanAppProcessInfo.indexOf(i));
    }

    public synchronized c a(SwanAppProcessInfo swanAppProcessInfo) {
        return this.bFE.get(swanAppProcessInfo);
    }

    public synchronized <FILTER> c a(FILTER filter, a<FILTER> aVar) {
        c cVar;
        Iterator<c> it = this.bFE.values().iterator();
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

    public synchronized LinkedHashSet<c> Zg() {
        return new LinkedHashSet<>(this.bFE.values());
    }

    public synchronized c kh(@Nullable String str) {
        c kj;
        kj = kj(str);
        if (kj == null) {
            kj = Zh();
        }
        return kj;
    }

    @NonNull
    public synchronized c ki(@Nullable String str) {
        c kh;
        kh = kh(str);
        b(kh.bFt);
        return kh;
    }

    public synchronized c Zh() {
        c a2;
        c cVar;
        c cVar2 = null;
        synchronized (this) {
            km("b4 computNextAvailableProcess");
            int i = 0;
            c cVar3 = null;
            while (true) {
                if (i <= 5) {
                    a2 = this.bFE.get(SwanAppProcessInfo.indexOf(i));
                    if (a2 != null && a2.bFt.isSwanAppProcess()) {
                        if (a2.YT()) {
                            a2 = cVar2;
                            cVar = cVar3;
                        } else if (a2.YS()) {
                            if (DEBUG) {
                                Log.i("SwanPuppetManager", "computNextAvailableProcess: firstPreloadedClient=" + a2);
                            }
                        } else {
                            if (cVar3 == null && a2.YV()) {
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
                    Iterator<c> it = this.bFE.values().iterator();
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
    public synchronized c Zi() {
        c cVar;
        km("b4 computNextPreloadProcess");
        int i = 0;
        cVar = null;
        while (true) {
            if (i <= 5) {
                c cVar2 = this.bFE.get(SwanAppProcessInfo.indexOf(i));
                if (cVar2 != null && cVar2.bFt.isSwanAppProcess()) {
                    if (cVar2.YT()) {
                        cVar2 = cVar;
                    } else if (cVar2.YS()) {
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
    public synchronized c kj(@Nullable String str) {
        List<c> kk;
        kk = kk(str);
        return kk.isEmpty() ? null : kk.get(kk.size() - 1);
    }

    @NonNull
    public synchronized List<c> kk(@Nullable String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (c cVar : this.bFE.values()) {
                if (TextUtils.equals(cVar.getAppId(), str)) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    public synchronized void b(SwanAppProcessInfo swanAppProcessInfo) {
        c remove = this.bFE.remove(swanAppProcessInfo);
        if (remove != null) {
            this.bFE.put(swanAppProcessInfo, remove);
        }
        km("lru -> " + swanAppProcessInfo);
    }

    public synchronized void c(String str, c cVar) {
        if (!TextUtils.isEmpty(str)) {
            List<c> kk = Ze().kk(str);
            if (!kk.isEmpty()) {
                for (c cVar2 : kk) {
                    if (cVar2 != cVar && cVar2 != null && cVar2.YT()) {
                        if (DEBUG) {
                            Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + cVar);
                            Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + cVar2);
                        }
                        cVar2.Zd().Zb();
                        if (cVar2.YV()) {
                            com.baidu.swan.apps.process.messaging.a.Yv().a(new com.baidu.swan.apps.process.messaging.c(110, new Bundle()).a(cVar2.bFt));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Zj() {
        synchronized (this.bFG) {
            if (Zk()) {
                this.bFG.offer(Long.valueOf(System.currentTimeMillis()));
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "1");
                com.baidu.swan.apps.process.messaging.service.b.c(com.baidu.swan.apps.w.a.RG(), bundle);
            }
        }
    }

    private boolean Zk() {
        synchronized (this.bFG) {
            kl("checkRescuable ===>");
            if (this.bFG.size() < 3) {
                kl(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.bFG.size()), 3));
                return true;
            }
            int size = this.bFG.size() - 3;
            kl("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    kl("purge: " + this.bFG.poll());
                }
            }
            kl("after purge");
            Long peek = this.bFG.peek();
            if (peek == null) {
                kl("allowRescue by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > bFF;
            kl("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void kl(String str) {
        if (DEBUG) {
            Log.i("SwanPuppetManager", "SwanRescue:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.bFG.iterator();
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
                a2.as(bundle.getLong("property_launch_cost", -1L));
            }
        }
    }

    public void km(String str) {
        if (DEBUG) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanPuppetManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public String toString() {
        LinkedHashSet<c> Zg = Zg();
        StringBuilder append = new StringBuilder().append(super.toString()).append(":").append("\n-> clients: ");
        for (c cVar : Zg) {
            append.append("\n--> ").append(cVar.toString());
        }
        return append.toString();
    }
}
