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
/* loaded from: classes8.dex */
public final class e {
    static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final long cJN = TimeUnit.MINUTES.toMillis(5);
    private final LinkedHashMap<SwanAppProcessInfo, c> cJM;
    private final Deque<Long> cJO;
    private final com.baidu.swan.apps.process.messaging.service.a cJP;
    private final Set<com.baidu.swan.apps.process.messaging.service.a> cqf;
    public final Messenger mMessenger;

    /* loaded from: classes8.dex */
    public interface a<FILTER> {
        boolean a(FILTER filter, c cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        private static e cJU = new e();
    }

    public static e ayg() {
        if (!DEBUG || ProcessUtils.isMainProcess()) {
            return b.cJU;
        }
        throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
    }

    private e() {
        SwanAppProcessInfo[] indices;
        this.cJM = new LinkedHashMap<>();
        this.cJO = new ArrayDeque();
        this.mMessenger = new Messenger(new SwanAppMessengerService.a());
        this.cqf = new HashSet();
        this.cJP = new com.baidu.swan.apps.process.messaging.service.a() { // from class: com.baidu.swan.apps.process.messaging.service.e.1
            @Override // com.baidu.swan.apps.process.messaging.service.a
            public void c(final String str, final c cVar) {
                if (e.DEBUG) {
                    Log.i("SwanPuppetManager", "onEvent: to=" + e.this.cqf.size() + " event=" + str + " client=" + cVar.cJz);
                }
                synchronized (e.this.cqf) {
                    com.baidu.swan.apps.ap.e.a.a(com.baidu.swan.apps.runtime.d.getMainHandler(), (com.baidu.swan.apps.ap.e.b) new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.process.messaging.service.a>() { // from class: com.baidu.swan.apps.process.messaging.service.e.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: b */
                        public void I(com.baidu.swan.apps.process.messaging.service.a aVar) {
                            aVar.c(str, cVar);
                        }
                    }, (Collection) e.this.cqf);
                }
            }

            @Override // com.baidu.swan.apps.process.messaging.service.a
            public void alw() {
            }
        };
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.cJM.put(swanAppProcessInfo, new c(swanAppProcessInfo));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.swan.apps.process.messaging.service.a ayh() {
        return this.cJP;
    }

    public void a(final com.baidu.swan.apps.process.messaging.service.a aVar, long j) {
        synchronized (this.cqf) {
            this.cqf.add(aVar);
            if (DEBUG) {
                Log.i("SwanPuppetManager", "addCallback: after = " + this.cqf.size());
            }
        }
        if (j > 0) {
            com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.service.e.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (e.this.cqf) {
                        if (e.this.cqf.contains(aVar)) {
                            if (e.DEBUG) {
                                Log.i("SwanPuppetManager", "timeout: callback = " + aVar);
                            }
                            e.this.a(aVar);
                            aVar.alw();
                        }
                    }
                }
            }, j);
        }
    }

    public void a(com.baidu.swan.apps.process.messaging.service.a aVar) {
        synchronized (this.cqf) {
            this.cqf.remove(aVar);
            if (DEBUG) {
                Log.i("SwanPuppetManager", "delCallback: after = " + this.cqf.size());
            }
        }
    }

    public synchronized c iH(int i) {
        return a(SwanAppProcessInfo.indexOf(i));
    }

    public synchronized c a(SwanAppProcessInfo swanAppProcessInfo) {
        return this.cJM.get(swanAppProcessInfo);
    }

    public synchronized <FILTER> c a(FILTER filter, a<FILTER> aVar) {
        c cVar;
        Iterator<c> it = this.cJM.values().iterator();
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

    public synchronized LinkedHashSet<c> ayi() {
        return new LinkedHashSet<>(this.cJM.values());
    }

    public synchronized c pQ(@Nullable String str) {
        c pS;
        pS = pS(str);
        if (pS == null) {
            pS = ayj();
        }
        return pS;
    }

    @NonNull
    public synchronized c pR(@Nullable String str) {
        c pQ;
        pQ = pQ(str);
        b(pQ.cJz);
        return pQ;
    }

    public synchronized c ayj() {
        c a2;
        c cVar;
        c cVar2 = null;
        synchronized (this) {
            pV("b4 computNextAvailableProcess");
            int i = 0;
            c cVar3 = null;
            while (true) {
                if (i <= 5) {
                    a2 = this.cJM.get(SwanAppProcessInfo.indexOf(i));
                    if (a2 != null && a2.cJz.isSwanAppProcess()) {
                        if (a2.axR()) {
                            a2 = cVar2;
                            cVar = cVar3;
                        } else if (a2.axQ()) {
                            if (DEBUG) {
                                Log.i("SwanPuppetManager", "computNextAvailableProcess: firstPreloadedClient=" + a2);
                            }
                        } else {
                            if (cVar3 == null && a2.axT()) {
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
                    Iterator<c> it = this.cJM.values().iterator();
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
    public synchronized c ayk() {
        c cVar;
        pV("b4 computNextPreloadProcess");
        int i = 0;
        cVar = null;
        while (true) {
            if (i <= 5) {
                c cVar2 = this.cJM.get(SwanAppProcessInfo.indexOf(i));
                if (cVar2 != null && cVar2.cJz.isSwanAppProcess()) {
                    if (cVar2.axR()) {
                        cVar2 = cVar;
                    } else if (cVar2.axQ()) {
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
    public synchronized c pS(@Nullable String str) {
        List<c> pT;
        pT = pT(str);
        return pT.isEmpty() ? null : pT.get(pT.size() - 1);
    }

    @NonNull
    public synchronized List<c> pT(@Nullable String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (c cVar : this.cJM.values()) {
                if (TextUtils.equals(cVar.getAppId(), str)) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    public synchronized void b(SwanAppProcessInfo swanAppProcessInfo) {
        c remove = this.cJM.remove(swanAppProcessInfo);
        if (remove != null) {
            this.cJM.put(swanAppProcessInfo, remove);
        }
        if (DEBUG) {
            pV("lru -> " + swanAppProcessInfo);
        }
    }

    public synchronized void d(String str, c cVar) {
        if (!TextUtils.isEmpty(str)) {
            List<c> pT = ayg().pT(str);
            if (!pT.isEmpty()) {
                for (c cVar2 : pT) {
                    if (cVar2 != cVar && cVar2 != null && cVar2.axR()) {
                        if (DEBUG) {
                            Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + cVar);
                            Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + cVar2);
                        }
                        cVar2.ayf().ayd();
                        if (cVar2.axT()) {
                            com.baidu.swan.apps.process.messaging.a.axs().a(new com.baidu.swan.apps.process.messaging.c(110, new Bundle()).a(cVar2.cJz));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ayl() {
        synchronized (this.cJO) {
            if (aym()) {
                this.cJO.offer(Long.valueOf(System.currentTimeMillis()));
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "1");
                com.baidu.swan.apps.process.messaging.service.b.c(com.baidu.swan.apps.t.a.aoJ(), bundle);
            }
        }
    }

    private boolean aym() {
        synchronized (this.cJO) {
            pU("checkRescuable ===>");
            if (this.cJO.size() < 3) {
                pU(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.cJO.size()), 3));
                return true;
            }
            int size = this.cJO.size() - 3;
            pU("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    pU("purge: " + this.cJO.poll());
                }
            }
            pU("after purge");
            Long peek = this.cJO.peek();
            if (peek == null) {
                pU("allowRescue by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > cJN;
            pU("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void pU(String str) {
        if (DEBUG) {
            Log.i("SwanPuppetManager", "SwanRescue:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.cJO.iterator();
            while (it.hasNext()) {
                Log.i("SwanPuppetManager", "SwanRescue::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(Message message) {
        c a2;
        if (message != null) {
            SwanAppProcessInfo indexOf = SwanAppProcessInfo.indexOf(message.arg1);
            if (indexOf.isSwanAppProcess() && (a2 = a(indexOf)) != null && (message.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                a2.bD(bundle.getLong("property_launch_cost", -1L));
            }
        }
    }

    public void pV(String str) {
        if (DEBUG) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanPuppetManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public String toString() {
        LinkedHashSet<c> ayi = ayi();
        StringBuilder append = new StringBuilder().append(super.toString()).append(":").append("\n-> clients: ");
        for (c cVar : ayi) {
            append.append("\n--> ").append(cVar.toString());
        }
        return append.toString();
    }
}
