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
    public static final long dmq = TimeUnit.MINUTES.toMillis(5);
    private final Set<com.baidu.swan.apps.process.messaging.service.a> cSM;
    private final LinkedHashMap<SwanAppProcessInfo, c> dmp;
    private final Deque<Long> dmr;
    private final com.baidu.swan.apps.process.messaging.service.a dms;
    public final Messenger mMessenger;

    /* loaded from: classes10.dex */
    public interface a<FILTER> {
        boolean a(FILTER filter, c cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        private static e dmx = new e();
    }

    public static e aFS() {
        if (!DEBUG || ProcessUtils.isMainProcess()) {
            return b.dmx;
        }
        throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
    }

    private e() {
        SwanAppProcessInfo[] indices;
        this.dmp = new LinkedHashMap<>();
        this.dmr = new ArrayDeque();
        this.mMessenger = new Messenger(new SwanAppMessengerService.a());
        this.cSM = new HashSet();
        this.dms = new com.baidu.swan.apps.process.messaging.service.a() { // from class: com.baidu.swan.apps.process.messaging.service.e.1
            @Override // com.baidu.swan.apps.process.messaging.service.a
            public void c(final String str, final c cVar) {
                if (e.DEBUG) {
                    Log.i("SwanPuppetManager", "onEvent: to=" + e.this.cSM.size() + " event=" + str + " client=" + cVar.dmc);
                }
                synchronized (e.this.cSM) {
                    com.baidu.swan.apps.ap.e.a.a(com.baidu.swan.apps.runtime.d.getMainHandler(), (com.baidu.swan.apps.ap.e.b) new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.process.messaging.service.a>() { // from class: com.baidu.swan.apps.process.messaging.service.e.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: b */
                        public void M(com.baidu.swan.apps.process.messaging.service.a aVar) {
                            aVar.c(str, cVar);
                        }
                    }, (Collection) e.this.cSM);
                }
            }

            @Override // com.baidu.swan.apps.process.messaging.service.a
            public void atn() {
            }
        };
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.dmp.put(swanAppProcessInfo, new c(swanAppProcessInfo));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.swan.apps.process.messaging.service.a aFT() {
        return this.dms;
    }

    public void a(final com.baidu.swan.apps.process.messaging.service.a aVar, long j) {
        synchronized (this.cSM) {
            this.cSM.add(aVar);
            if (DEBUG) {
                Log.i("SwanPuppetManager", "addCallback: after = " + this.cSM.size());
            }
        }
        if (j > 0) {
            com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.service.e.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (e.this.cSM) {
                        if (e.this.cSM.contains(aVar)) {
                            if (e.DEBUG) {
                                Log.i("SwanPuppetManager", "timeout: callback = " + aVar);
                            }
                            e.this.a(aVar);
                            aVar.atn();
                        }
                    }
                }
            }, j);
        }
    }

    public void a(com.baidu.swan.apps.process.messaging.service.a aVar) {
        synchronized (this.cSM) {
            this.cSM.remove(aVar);
            if (DEBUG) {
                Log.i("SwanPuppetManager", "delCallback: after = " + this.cSM.size());
            }
        }
    }

    public synchronized c jJ(int i) {
        return a(SwanAppProcessInfo.indexOf(i));
    }

    public synchronized c a(SwanAppProcessInfo swanAppProcessInfo) {
        return this.dmp.get(swanAppProcessInfo);
    }

    public synchronized <FILTER> c a(FILTER filter, a<FILTER> aVar) {
        c cVar;
        Iterator<c> it = this.dmp.values().iterator();
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
        return new LinkedHashSet<>(this.dmp.values());
    }

    public synchronized c rD(@Nullable String str) {
        c rF;
        rF = rF(str);
        if (rF == null) {
            rF = aFV();
        }
        return rF;
    }

    @NonNull
    public synchronized c rE(@Nullable String str) {
        c rD;
        rD = rD(str);
        b(rD.dmc);
        return rD;
    }

    public synchronized c aFV() {
        c a2;
        c cVar;
        c cVar2 = null;
        synchronized (this) {
            rI("b4 computNextAvailableProcess");
            int i = 0;
            c cVar3 = null;
            while (true) {
                if (i <= 5) {
                    a2 = this.dmp.get(SwanAppProcessInfo.indexOf(i));
                    if (a2 != null && a2.dmc.isSwanAppProcess()) {
                        if (a2.aFD()) {
                            a2 = cVar2;
                            cVar = cVar3;
                        } else if (a2.aFC()) {
                            if (DEBUG) {
                                Log.i("SwanPuppetManager", "computNextAvailableProcess: firstPreloadedClient=" + a2);
                            }
                        } else {
                            if (cVar3 == null && a2.aFF()) {
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
                    Iterator<c> it = this.dmp.values().iterator();
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
    public synchronized c aFW() {
        c cVar;
        rI("b4 computNextPreloadProcess");
        int i = 0;
        cVar = null;
        while (true) {
            if (i <= 5) {
                c cVar2 = this.dmp.get(SwanAppProcessInfo.indexOf(i));
                if (cVar2 != null && cVar2.dmc.isSwanAppProcess()) {
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
    public synchronized c rF(@Nullable String str) {
        List<c> rG;
        rG = rG(str);
        return rG.isEmpty() ? null : rG.get(rG.size() - 1);
    }

    @NonNull
    public synchronized List<c> rG(@Nullable String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (c cVar : this.dmp.values()) {
                if (TextUtils.equals(cVar.getAppId(), str)) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    public synchronized void b(SwanAppProcessInfo swanAppProcessInfo) {
        c remove = this.dmp.remove(swanAppProcessInfo);
        if (remove != null) {
            this.dmp.put(swanAppProcessInfo, remove);
        }
        if (DEBUG) {
            rI("lru -> " + swanAppProcessInfo);
        }
    }

    public synchronized void d(String str, c cVar) {
        if (!TextUtils.isEmpty(str)) {
            List<c> rG = aFS().rG(str);
            if (!rG.isEmpty()) {
                for (c cVar2 : rG) {
                    if (cVar2 != cVar && cVar2 != null && cVar2.aFD()) {
                        if (DEBUG) {
                            Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + cVar);
                            Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + cVar2);
                        }
                        cVar2.aFR().aFP();
                        if (cVar2.aFF()) {
                            com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(110, new Bundle()).a(cVar2.dmc));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aFX() {
        synchronized (this.dmr) {
            if (aFY()) {
                this.dmr.offer(Long.valueOf(System.currentTimeMillis()));
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "1");
                com.baidu.swan.apps.process.messaging.service.b.c(com.baidu.swan.apps.t.a.awA(), bundle);
            }
        }
    }

    private boolean aFY() {
        synchronized (this.dmr) {
            rH("checkRescuable ===>");
            if (this.dmr.size() < 3) {
                rH(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.dmr.size()), 3));
                return true;
            }
            int size = this.dmr.size() - 3;
            rH("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    rH("purge: " + this.dmr.poll());
                }
            }
            rH("after purge");
            Long peek = this.dmr.peek();
            if (peek == null) {
                rH("allowRescue by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > dmq;
            rH("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void rH(String str) {
        if (DEBUG) {
            Log.i("SwanPuppetManager", "SwanRescue:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.dmr.iterator();
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
                a2.ck(bundle.getLong("property_launch_cost", -1L));
            }
        }
    }

    public void rI(String str) {
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
