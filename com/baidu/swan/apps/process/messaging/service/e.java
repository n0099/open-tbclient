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
    public static final long dvG = TimeUnit.MINUTES.toMillis(5);
    private final Set<com.baidu.swan.apps.process.messaging.service.a> dbO;
    private final LinkedHashMap<SwanAppProcessInfo, c> dvF;
    private final Deque<Long> dvH;
    private final com.baidu.swan.apps.process.messaging.service.a dvI;
    public final Messenger mMessenger;

    /* loaded from: classes8.dex */
    public interface a<FILTER> {
        boolean a(FILTER filter, c cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        private static e dvN = new e();
    }

    public static e aGq() {
        if (!DEBUG || ProcessUtils.isMainProcess()) {
            return b.dvN;
        }
        throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
    }

    private e() {
        SwanAppProcessInfo[] indices;
        this.dvF = new LinkedHashMap<>();
        this.dvH = new ArrayDeque();
        this.mMessenger = new Messenger(new SwanAppMessengerService.a());
        this.dbO = new HashSet();
        this.dvI = new com.baidu.swan.apps.process.messaging.service.a() { // from class: com.baidu.swan.apps.process.messaging.service.e.1
            @Override // com.baidu.swan.apps.process.messaging.service.a
            public void c(final String str, final c cVar) {
                if (e.DEBUG) {
                    Log.i("SwanPuppetManager", "onEvent: to=" + e.this.dbO.size() + " event=" + str + " client=" + cVar.dvs);
                }
                synchronized (e.this.dbO) {
                    com.baidu.swan.apps.ao.e.a.a(com.baidu.swan.apps.runtime.d.getMainHandler(), (com.baidu.swan.apps.ao.e.b) new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.process.messaging.service.a>() { // from class: com.baidu.swan.apps.process.messaging.service.e.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ao.e.b
                        /* renamed from: b */
                        public void N(com.baidu.swan.apps.process.messaging.service.a aVar) {
                            aVar.c(str, cVar);
                        }
                    }, (Collection) e.this.dbO);
                }
            }

            @Override // com.baidu.swan.apps.process.messaging.service.a
            public void atN() {
            }
        };
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.dvF.put(swanAppProcessInfo, new c(swanAppProcessInfo));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.swan.apps.process.messaging.service.a aGr() {
        return this.dvI;
    }

    public void a(final com.baidu.swan.apps.process.messaging.service.a aVar, long j) {
        synchronized (this.dbO) {
            this.dbO.add(aVar);
            if (DEBUG) {
                Log.i("SwanPuppetManager", "addCallback: after = " + this.dbO.size());
            }
        }
        if (j > 0) {
            com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.service.e.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (e.this.dbO) {
                        if (e.this.dbO.contains(aVar)) {
                            if (e.DEBUG) {
                                Log.i("SwanPuppetManager", "timeout: callback = " + aVar);
                            }
                            e.this.a(aVar);
                            aVar.atN();
                        }
                    }
                }
            }, j);
        }
    }

    public void a(com.baidu.swan.apps.process.messaging.service.a aVar) {
        synchronized (this.dbO) {
            this.dbO.remove(aVar);
            if (DEBUG) {
                Log.i("SwanPuppetManager", "delCallback: after = " + this.dbO.size());
            }
        }
    }

    public synchronized c ix(int i) {
        return a(SwanAppProcessInfo.indexOf(i));
    }

    public synchronized c a(SwanAppProcessInfo swanAppProcessInfo) {
        return this.dvF.get(swanAppProcessInfo);
    }

    public synchronized <FILTER> c a(FILTER filter, a<FILTER> aVar) {
        c cVar;
        Iterator<c> it = this.dvF.values().iterator();
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

    public synchronized LinkedHashSet<c> aGs() {
        return new LinkedHashSet<>(this.dvF.values());
    }

    public synchronized c rl(@Nullable String str) {
        c ro;
        ro = ro(str);
        if (ro == null) {
            ro = aGt();
        }
        return ro;
    }

    @NonNull
    public synchronized c rn(@Nullable String str) {
        c rl;
        rl = rl(str);
        b(rl.dvs);
        return rl;
    }

    public synchronized c aGt() {
        c a2;
        rr("b4 computNextAvailableProcess");
        int i = 0;
        c cVar = null;
        c cVar2 = null;
        while (true) {
            if (i <= 5) {
                a2 = this.dvF.get(SwanAppProcessInfo.indexOf(i));
                if (a2 != null && a2.dvs.isSwanAppProcess()) {
                    if (a2.aGb()) {
                        a2 = cVar;
                    } else if (a2.aGa()) {
                        if (DEBUG) {
                            Log.i("SwanPuppetManager", "computNextAvailableProcess: firstPreloadedClient=" + a2);
                        }
                    } else {
                        if (cVar2 == null && a2.aGd()) {
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
                Iterator<c> it = this.dvF.values().iterator();
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
    public synchronized c aGu() {
        c cVar;
        rr("b4 computNextPreloadProcess");
        int i = 0;
        cVar = null;
        while (true) {
            if (i <= 5) {
                c cVar2 = this.dvF.get(SwanAppProcessInfo.indexOf(i));
                if (cVar2 != null && cVar2.dvs.isSwanAppProcess()) {
                    if (cVar2.aGb()) {
                        cVar2 = cVar;
                    } else if (cVar2.aGa()) {
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
    public synchronized c ro(@Nullable String str) {
        List<c> rp;
        rp = rp(str);
        return rp.isEmpty() ? null : rp.get(rp.size() - 1);
    }

    @NonNull
    public synchronized List<c> rp(@Nullable String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (c cVar : this.dvF.values()) {
                if (TextUtils.equals(cVar.getAppId(), str)) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    public synchronized void b(SwanAppProcessInfo swanAppProcessInfo) {
        c remove = this.dvF.remove(swanAppProcessInfo);
        if (remove != null) {
            this.dvF.put(swanAppProcessInfo, remove);
        }
        if (DEBUG) {
            rr("lru -> " + swanAppProcessInfo);
        }
    }

    public synchronized void d(String str, c cVar) {
        if (!TextUtils.isEmpty(str)) {
            List<c> rp = aGq().rp(str);
            if (!rp.isEmpty()) {
                for (c cVar2 : rp) {
                    if (cVar2 != cVar && cVar2 != null && cVar2.aGb()) {
                        if (DEBUG) {
                            Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + cVar);
                            Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + cVar2);
                        }
                        cVar2.aGp().aGn();
                        if (cVar2.aGd()) {
                            com.baidu.swan.apps.process.messaging.a.aFC().a(new com.baidu.swan.apps.process.messaging.c(110, new Bundle()).a(cVar2.dvs));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aGv() {
        synchronized (this.dvH) {
            if (aGw()) {
                this.dvH.offer(Long.valueOf(System.currentTimeMillis()));
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "1");
                com.baidu.swan.apps.process.messaging.service.b.c(com.baidu.swan.apps.t.a.awZ(), bundle);
            }
        }
    }

    private boolean aGw() {
        synchronized (this.dvH) {
            rq("checkRescuable ===>");
            if (this.dvH.size() < 3) {
                rq(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.dvH.size()), 3));
                return true;
            }
            int size = this.dvH.size() - 3;
            rq("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    rq("purge: " + this.dvH.poll());
                }
            }
            rq("after purge");
            Long peek = this.dvH.peek();
            if (peek == null) {
                rq("allowRescue by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > dvG;
            rq("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void rq(String str) {
        if (DEBUG) {
            Log.i("SwanPuppetManager", "SwanRescue:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.dvH.iterator();
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
                a2.cQ(bundle.getLong("property_launch_cost", -1L));
            }
        }
    }

    public void rr(String str) {
        if (DEBUG) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanPuppetManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public String toString() {
        LinkedHashSet<c> aGs = aGs();
        StringBuilder append = new StringBuilder().append(super.toString()).append(":").append("\n-> clients: ");
        for (c cVar : aGs) {
            append.append("\n--> ").append(cVar.toString());
        }
        return append.toString();
    }
}
