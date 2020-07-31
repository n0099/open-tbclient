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
/* loaded from: classes7.dex */
public final class e {
    static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final long cBC = TimeUnit.MINUTES.toMillis(5);
    private final LinkedHashMap<SwanAppProcessInfo, c> cBB;
    private final Deque<Long> cBD;
    private final Set<com.baidu.swan.apps.process.messaging.service.a> cBE;
    private final com.baidu.swan.apps.process.messaging.service.a cBF;
    public final Messenger mMessenger;

    /* loaded from: classes7.dex */
    public interface a<FILTER> {
        boolean a(FILTER filter, c cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class b {
        private static e cBK = new e();
    }

    public static e aqf() {
        if (!DEBUG || ProcessUtils.isMainProcess()) {
            return b.cBK;
        }
        throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
    }

    private e() {
        SwanAppProcessInfo[] indices;
        this.cBB = new LinkedHashMap<>();
        this.cBD = new ArrayDeque();
        this.mMessenger = new Messenger(new SwanAppMessengerService.a());
        this.cBE = new HashSet();
        this.cBF = new com.baidu.swan.apps.process.messaging.service.a() { // from class: com.baidu.swan.apps.process.messaging.service.e.1
            @Override // com.baidu.swan.apps.process.messaging.service.a
            public void c(final String str, final c cVar) {
                if (e.DEBUG) {
                    Log.i("SwanPuppetManager", "onEvent: to=" + e.this.cBE.size() + " event=" + str + " client=" + cVar.cBq);
                }
                synchronized (e.this.cBE) {
                    com.baidu.swan.apps.aq.e.a.a(com.baidu.swan.apps.runtime.d.getMainHandler(), (com.baidu.swan.apps.aq.e.b) new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.process.messaging.service.a>() { // from class: com.baidu.swan.apps.process.messaging.service.e.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.aq.e.b
                        /* renamed from: b */
                        public void H(com.baidu.swan.apps.process.messaging.service.a aVar) {
                            aVar.c(str, cVar);
                        }
                    }, (Collection) e.this.cBE);
                }
            }

            @Override // com.baidu.swan.apps.process.messaging.service.a
            public void aeN() {
            }
        };
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.cBB.put(swanAppProcessInfo, new c(swanAppProcessInfo));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.swan.apps.process.messaging.service.a aqg() {
        return this.cBF;
    }

    public void a(final com.baidu.swan.apps.process.messaging.service.a aVar, long j) {
        synchronized (this.cBE) {
            this.cBE.add(aVar);
            if (DEBUG) {
                Log.i("SwanPuppetManager", "addCallback: after = " + this.cBE.size());
            }
        }
        if (j > 0) {
            com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.service.e.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (e.this.cBE) {
                        if (e.this.cBE.contains(aVar)) {
                            if (e.DEBUG) {
                                Log.i("SwanPuppetManager", "timeout: callback = " + aVar);
                            }
                            e.this.a(aVar);
                            aVar.aeN();
                        }
                    }
                }
            }, j);
        }
    }

    public void a(com.baidu.swan.apps.process.messaging.service.a aVar) {
        synchronized (this.cBE) {
            this.cBE.remove(aVar);
            if (DEBUG) {
                Log.i("SwanPuppetManager", "delCallback: after = " + this.cBE.size());
            }
        }
    }

    public synchronized c gB(int i) {
        return a(SwanAppProcessInfo.indexOf(i));
    }

    public synchronized c a(SwanAppProcessInfo swanAppProcessInfo) {
        return this.cBB.get(swanAppProcessInfo);
    }

    public synchronized <FILTER> c a(FILTER filter, a<FILTER> aVar) {
        c cVar;
        Iterator<c> it = this.cBB.values().iterator();
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

    public synchronized LinkedHashSet<c> aqh() {
        return new LinkedHashSet<>(this.cBB.values());
    }

    public synchronized c nS(@Nullable String str) {
        c nU;
        nU = nU(str);
        if (nU == null) {
            nU = aqi();
        }
        return nU;
    }

    @NonNull
    public synchronized c nT(@Nullable String str) {
        c nS;
        nS = nS(str);
        b(nS.cBq);
        return nS;
    }

    public synchronized c aqi() {
        c a2;
        c cVar;
        c cVar2 = null;
        synchronized (this) {
            nX("b4 computNextAvailableProcess");
            int i = 0;
            c cVar3 = null;
            while (true) {
                if (i <= 5) {
                    a2 = this.cBB.get(SwanAppProcessInfo.indexOf(i));
                    if (a2 != null && a2.cBq.isSwanAppProcess()) {
                        if (a2.apU()) {
                            a2 = cVar2;
                            cVar = cVar3;
                        } else if (a2.apT()) {
                            if (DEBUG) {
                                Log.i("SwanPuppetManager", "computNextAvailableProcess: firstPreloadedClient=" + a2);
                            }
                        } else {
                            if (cVar3 == null && a2.apW()) {
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
                    Iterator<c> it = this.cBB.values().iterator();
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
    public synchronized c aqj() {
        c cVar;
        nX("b4 computNextPreloadProcess");
        int i = 0;
        cVar = null;
        while (true) {
            if (i <= 5) {
                c cVar2 = this.cBB.get(SwanAppProcessInfo.indexOf(i));
                if (cVar2 != null && cVar2.cBq.isSwanAppProcess()) {
                    if (cVar2.apU()) {
                        cVar2 = cVar;
                    } else if (cVar2.apT()) {
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
    public synchronized c nU(@Nullable String str) {
        List<c> nV;
        nV = nV(str);
        return nV.isEmpty() ? null : nV.get(nV.size() - 1);
    }

    @NonNull
    public synchronized List<c> nV(@Nullable String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (c cVar : this.cBB.values()) {
                if (TextUtils.equals(cVar.getAppId(), str)) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    public synchronized void b(SwanAppProcessInfo swanAppProcessInfo) {
        c remove = this.cBB.remove(swanAppProcessInfo);
        if (remove != null) {
            this.cBB.put(swanAppProcessInfo, remove);
        }
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            if (DEBUG) {
                nX("lru -> " + swanAppProcessInfo);
            }
        } else {
            nX("lru -> " + swanAppProcessInfo);
        }
    }

    public synchronized void d(String str, c cVar) {
        if (!TextUtils.isEmpty(str)) {
            List<c> nV = aqf().nV(str);
            if (!nV.isEmpty()) {
                for (c cVar2 : nV) {
                    if (cVar2 != cVar && cVar2 != null && cVar2.apU()) {
                        if (DEBUG) {
                            Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + cVar);
                            Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + cVar2);
                        }
                        cVar2.aqe().aqc();
                        if (cVar2.apW()) {
                            com.baidu.swan.apps.process.messaging.a.apw().a(new com.baidu.swan.apps.process.messaging.c(110, new Bundle()).a(cVar2.cBq));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aqk() {
        synchronized (this.cBD) {
            if (aql()) {
                this.cBD.offer(Long.valueOf(System.currentTimeMillis()));
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "1");
                com.baidu.swan.apps.process.messaging.service.b.c(com.baidu.swan.apps.t.a.ahj(), bundle);
            }
        }
    }

    private boolean aql() {
        synchronized (this.cBD) {
            nW("checkRescuable ===>");
            if (this.cBD.size() < 3) {
                nW(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.cBD.size()), 3));
                return true;
            }
            int size = this.cBD.size() - 3;
            nW("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    nW("purge: " + this.cBD.poll());
                }
            }
            nW("after purge");
            Long peek = this.cBD.peek();
            if (peek == null) {
                nW("allowRescue by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > cBC;
            nW("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void nW(String str) {
        if (DEBUG) {
            Log.i("SwanPuppetManager", "SwanRescue:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.cBD.iterator();
            while (it.hasNext()) {
                Log.i("SwanPuppetManager", "SwanRescue::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(Message message) {
        c a2;
        if (message != null) {
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && (a2 = a(indexOf)) != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                a2.bw(bundle.getLong("property_launch_cost", -1L));
            }
        }
    }

    public void nX(String str) {
        if (DEBUG) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanPuppetManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public String toString() {
        LinkedHashSet<c> aqh = aqh();
        StringBuilder append = new StringBuilder().append(super.toString()).append(":").append("\n-> clients: ");
        for (c cVar : aqh) {
            append.append("\n--> ").append(cVar.toString());
        }
        return append.toString();
    }
}
