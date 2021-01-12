package com.baidu.swan.apps.process.messaging.service;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    public static final long drT = TimeUnit.MINUTES.toMillis(5);
    private final Set<com.baidu.swan.apps.process.messaging.service.a> cYb;
    private final LinkedHashMap<SwanAppProcessInfo, c> drS;
    private final Deque<Long> drU;
    private final com.baidu.swan.apps.process.messaging.service.a drV;
    public final Messenger mMessenger;

    /* loaded from: classes8.dex */
    public interface a<FILTER> {
        boolean a(FILTER filter, c cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        private static e dsa = new e();
    }

    public static e aFS() {
        if (!DEBUG || ProcessUtils.isMainProcess()) {
            return b.dsa;
        }
        throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
    }

    private e() {
        SwanAppProcessInfo[] indices;
        this.drS = new LinkedHashMap<>();
        this.drU = new ArrayDeque();
        this.mMessenger = new Messenger(new SwanAppMessengerService.a());
        this.cYb = new HashSet();
        this.drV = new com.baidu.swan.apps.process.messaging.service.a() { // from class: com.baidu.swan.apps.process.messaging.service.e.1
            @Override // com.baidu.swan.apps.process.messaging.service.a
            public void c(final String str, final c cVar) {
                if (e.DEBUG) {
                    Log.i("SwanPuppetManager", "onEvent: to=" + e.this.cYb.size() + " event=" + str + " client=" + cVar.drF);
                }
                synchronized (e.this.cYb) {
                    com.baidu.swan.apps.ao.e.a.a(com.baidu.swan.apps.runtime.d.getMainHandler(), (com.baidu.swan.apps.ao.e.b) new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.process.messaging.service.a>() { // from class: com.baidu.swan.apps.process.messaging.service.e.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ao.e.b
                        /* renamed from: b */
                        public void L(com.baidu.swan.apps.process.messaging.service.a aVar) {
                            aVar.c(str, cVar);
                        }
                    }, (Collection) e.this.cYb);
                }
            }

            @Override // com.baidu.swan.apps.process.messaging.service.a
            public void atm() {
            }
        };
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.drS.put(swanAppProcessInfo, new c(swanAppProcessInfo));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.swan.apps.process.messaging.service.a aFT() {
        return this.drV;
    }

    public void a(final com.baidu.swan.apps.process.messaging.service.a aVar, long j) {
        synchronized (this.cYb) {
            this.cYb.add(aVar);
            if (DEBUG) {
                Log.i("SwanPuppetManager", "addCallback: after = " + this.cYb.size());
            }
        }
        if (j > 0) {
            com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.service.e.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (e.this.cYb) {
                        if (e.this.cYb.contains(aVar)) {
                            if (e.DEBUG) {
                                Log.i("SwanPuppetManager", "timeout: callback = " + aVar);
                            }
                            e.this.a(aVar);
                            aVar.atm();
                        }
                    }
                }
            }, j);
        }
    }

    public void a(com.baidu.swan.apps.process.messaging.service.a aVar) {
        synchronized (this.cYb) {
            this.cYb.remove(aVar);
            if (DEBUG) {
                Log.i("SwanPuppetManager", "delCallback: after = " + this.cYb.size());
            }
        }
    }

    public synchronized c it(int i) {
        return a(SwanAppProcessInfo.indexOf(i));
    }

    public synchronized c a(SwanAppProcessInfo swanAppProcessInfo) {
        return this.drS.get(swanAppProcessInfo);
    }

    public synchronized <FILTER> c a(FILTER filter, a<FILTER> aVar) {
        c cVar;
        Iterator<c> it = this.drS.values().iterator();
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

    public synchronized LinkedHashSet<c> aFU() {
        return new LinkedHashSet<>(this.drS.values());
    }

    public synchronized c qM(@Nullable String str) {
        c qO;
        qO = qO(str);
        if (qO == null) {
            qO = aFV();
        }
        return qO;
    }

    @NonNull
    public synchronized c qN(@Nullable String str) {
        c qM;
        qM = qM(str);
        b(qM.drF);
        return qM;
    }

    public synchronized c aFV() {
        c a2;
        qR("b4 computNextAvailableProcess");
        int i = 0;
        c cVar = null;
        c cVar2 = null;
        while (true) {
            if (i <= 5) {
                a2 = this.drS.get(SwanAppProcessInfo.indexOf(i));
                if (a2 != null && a2.drF.isSwanAppProcess()) {
                    if (a2.aFD()) {
                        a2 = cVar;
                    } else if (a2.aFC()) {
                        if (DEBUG) {
                            Log.i("SwanPuppetManager", "computNextAvailableProcess: firstPreloadedClient=" + a2);
                        }
                    } else {
                        if (cVar2 == null && a2.aFF()) {
                            cVar2 = a2;
                        }
                        if (cVar == null) {
                        }
                    }
                    i++;
                    cVar = a2;
                }
                a2 = cVar;
                i++;
                cVar = a2;
            } else if (cVar2 != null) {
                if (DEBUG) {
                    Log.i("SwanPuppetManager", "computNextAvailableProcess: firstConnectedEmptyClient=" + cVar2);
                }
                a2 = cVar2;
            } else if (cVar != null) {
                if (DEBUG) {
                    Log.i("SwanPuppetManager", "computNextAvailableProcess: firstEmptyClient=" + cVar);
                }
                a2 = cVar;
            } else {
                Iterator<c> it = this.drS.values().iterator();
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
        return a2;
    }

    @Nullable
    public synchronized c aFW() {
        c cVar;
        qR("b4 computNextPreloadProcess");
        int i = 0;
        cVar = null;
        while (true) {
            if (i <= 5) {
                c cVar2 = this.drS.get(SwanAppProcessInfo.indexOf(i));
                if (cVar2 != null && cVar2.drF.isSwanAppProcess()) {
                    if (cVar2.aFD()) {
                        cVar2 = cVar;
                    } else if (cVar2.aFC()) {
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
    public synchronized c qO(@Nullable String str) {
        List<c> qP;
        qP = qP(str);
        return qP.isEmpty() ? null : qP.get(qP.size() - 1);
    }

    @NonNull
    public synchronized List<c> qP(@Nullable String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (c cVar : this.drS.values()) {
                if (TextUtils.equals(cVar.getAppId(), str)) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    public synchronized void b(SwanAppProcessInfo swanAppProcessInfo) {
        c remove = this.drS.remove(swanAppProcessInfo);
        if (remove != null) {
            this.drS.put(swanAppProcessInfo, remove);
        }
        if (DEBUG) {
            qR("lru -> " + swanAppProcessInfo);
        }
    }

    public synchronized void d(String str, c cVar) {
        if (!TextUtils.isEmpty(str)) {
            List<c> qP = aFS().qP(str);
            if (!qP.isEmpty()) {
                for (c cVar2 : qP) {
                    if (cVar2 != cVar && cVar2 != null && cVar2.aFD()) {
                        if (DEBUG) {
                            Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + cVar);
                            Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + cVar2);
                        }
                        cVar2.aFR().aFP();
                        if (cVar2.aFF()) {
                            com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(110, new Bundle()).a(cVar2.drF));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aFX() {
        synchronized (this.drU) {
            if (aFY()) {
                this.drU.offer(Long.valueOf(System.currentTimeMillis()));
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "1");
                com.baidu.swan.apps.process.messaging.service.b.c(com.baidu.swan.apps.t.a.awy(), bundle);
            }
        }
    }

    private boolean aFY() {
        synchronized (this.drU) {
            qQ("checkRescuable ===>");
            if (this.drU.size() < 3) {
                qQ(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.drU.size()), 3));
                return true;
            }
            int size = this.drU.size() - 3;
            qQ("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    qQ("purge: " + this.drU.poll());
                }
            }
            qQ("after purge");
            Long peek = this.drU.peek();
            if (peek == null) {
                qQ("allowRescue by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > drT;
            qQ("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void qQ(String str) {
        if (DEBUG) {
            Log.i("SwanPuppetManager", "SwanRescue:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.drU.iterator();
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
                a2.cK(bundle.getLong("property_launch_cost", -1L));
            }
        }
    }

    public void qR(String str) {
        if (DEBUG) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanPuppetManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public String toString() {
        LinkedHashSet<c> aFU = aFU();
        StringBuilder append = new StringBuilder().append(super.toString()).append(":").append("\n-> clients: ");
        for (c cVar : aFU) {
            append.append("\n--> ").append(cVar.toString());
        }
        return append.toString();
    }
}
