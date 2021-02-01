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
/* loaded from: classes9.dex */
public final class e {
    static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final long duf = TimeUnit.MINUTES.toMillis(5);
    private final Set<com.baidu.swan.apps.process.messaging.service.a> dal;
    private final LinkedHashMap<SwanAppProcessInfo, c> due;
    private final Deque<Long> dug;
    private final com.baidu.swan.apps.process.messaging.service.a duh;
    public final Messenger mMessenger;

    /* loaded from: classes9.dex */
    public interface a<FILTER> {
        boolean a(FILTER filter, c cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        private static e dum = new e();
    }

    public static e aGn() {
        if (!DEBUG || ProcessUtils.isMainProcess()) {
            return b.dum;
        }
        throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
    }

    private e() {
        SwanAppProcessInfo[] indices;
        this.due = new LinkedHashMap<>();
        this.dug = new ArrayDeque();
        this.mMessenger = new Messenger(new SwanAppMessengerService.a());
        this.dal = new HashSet();
        this.duh = new com.baidu.swan.apps.process.messaging.service.a() { // from class: com.baidu.swan.apps.process.messaging.service.e.1
            @Override // com.baidu.swan.apps.process.messaging.service.a
            public void c(final String str, final c cVar) {
                if (e.DEBUG) {
                    Log.i("SwanPuppetManager", "onEvent: to=" + e.this.dal.size() + " event=" + str + " client=" + cVar.dtR);
                }
                synchronized (e.this.dal) {
                    com.baidu.swan.apps.ao.e.a.a(com.baidu.swan.apps.runtime.d.getMainHandler(), (com.baidu.swan.apps.ao.e.b) new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.process.messaging.service.a>() { // from class: com.baidu.swan.apps.process.messaging.service.e.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ao.e.b
                        /* renamed from: b */
                        public void L(com.baidu.swan.apps.process.messaging.service.a aVar) {
                            aVar.c(str, cVar);
                        }
                    }, (Collection) e.this.dal);
                }
            }

            @Override // com.baidu.swan.apps.process.messaging.service.a
            public void atK() {
            }
        };
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.due.put(swanAppProcessInfo, new c(swanAppProcessInfo));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.swan.apps.process.messaging.service.a aGo() {
        return this.duh;
    }

    public void a(final com.baidu.swan.apps.process.messaging.service.a aVar, long j) {
        synchronized (this.dal) {
            this.dal.add(aVar);
            if (DEBUG) {
                Log.i("SwanPuppetManager", "addCallback: after = " + this.dal.size());
            }
        }
        if (j > 0) {
            com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.service.e.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (e.this.dal) {
                        if (e.this.dal.contains(aVar)) {
                            if (e.DEBUG) {
                                Log.i("SwanPuppetManager", "timeout: callback = " + aVar);
                            }
                            e.this.a(aVar);
                            aVar.atK();
                        }
                    }
                }
            }, j);
        }
    }

    public void a(com.baidu.swan.apps.process.messaging.service.a aVar) {
        synchronized (this.dal) {
            this.dal.remove(aVar);
            if (DEBUG) {
                Log.i("SwanPuppetManager", "delCallback: after = " + this.dal.size());
            }
        }
    }

    public synchronized c iw(int i) {
        return a(SwanAppProcessInfo.indexOf(i));
    }

    public synchronized c a(SwanAppProcessInfo swanAppProcessInfo) {
        return this.due.get(swanAppProcessInfo);
    }

    public synchronized <FILTER> c a(FILTER filter, a<FILTER> aVar) {
        c cVar;
        Iterator<c> it = this.due.values().iterator();
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

    public synchronized LinkedHashSet<c> aGp() {
        return new LinkedHashSet<>(this.due.values());
    }

    public synchronized c re(@Nullable String str) {
        c rg;
        rg = rg(str);
        if (rg == null) {
            rg = aGq();
        }
        return rg;
    }

    @NonNull
    public synchronized c rf(@Nullable String str) {
        c re;
        re = re(str);
        b(re.dtR);
        return re;
    }

    public synchronized c aGq() {
        c a2;
        rj("b4 computNextAvailableProcess");
        int i = 0;
        c cVar = null;
        c cVar2 = null;
        while (true) {
            if (i <= 5) {
                a2 = this.due.get(SwanAppProcessInfo.indexOf(i));
                if (a2 != null && a2.dtR.isSwanAppProcess()) {
                    if (a2.aFY()) {
                        a2 = cVar;
                    } else if (a2.aFX()) {
                        if (DEBUG) {
                            Log.i("SwanPuppetManager", "computNextAvailableProcess: firstPreloadedClient=" + a2);
                        }
                    } else {
                        if (cVar2 == null && a2.aGa()) {
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
                Iterator<c> it = this.due.values().iterator();
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
    public synchronized c aGr() {
        c cVar;
        rj("b4 computNextPreloadProcess");
        int i = 0;
        cVar = null;
        while (true) {
            if (i <= 5) {
                c cVar2 = this.due.get(SwanAppProcessInfo.indexOf(i));
                if (cVar2 != null && cVar2.dtR.isSwanAppProcess()) {
                    if (cVar2.aFY()) {
                        cVar2 = cVar;
                    } else if (cVar2.aFX()) {
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
    public synchronized c rg(@Nullable String str) {
        List<c> rh;
        rh = rh(str);
        return rh.isEmpty() ? null : rh.get(rh.size() - 1);
    }

    @NonNull
    public synchronized List<c> rh(@Nullable String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (c cVar : this.due.values()) {
                if (TextUtils.equals(cVar.getAppId(), str)) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    public synchronized void b(SwanAppProcessInfo swanAppProcessInfo) {
        c remove = this.due.remove(swanAppProcessInfo);
        if (remove != null) {
            this.due.put(swanAppProcessInfo, remove);
        }
        if (DEBUG) {
            rj("lru -> " + swanAppProcessInfo);
        }
    }

    public synchronized void d(String str, c cVar) {
        if (!TextUtils.isEmpty(str)) {
            List<c> rh = aGn().rh(str);
            if (!rh.isEmpty()) {
                for (c cVar2 : rh) {
                    if (cVar2 != cVar && cVar2 != null && cVar2.aFY()) {
                        if (DEBUG) {
                            Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + cVar);
                            Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + cVar2);
                        }
                        cVar2.aGm().aGk();
                        if (cVar2.aGa()) {
                            com.baidu.swan.apps.process.messaging.a.aFz().a(new com.baidu.swan.apps.process.messaging.c(110, new Bundle()).a(cVar2.dtR));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aGs() {
        synchronized (this.dug) {
            if (aGt()) {
                this.dug.offer(Long.valueOf(System.currentTimeMillis()));
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "1");
                com.baidu.swan.apps.process.messaging.service.b.c(com.baidu.swan.apps.t.a.awW(), bundle);
            }
        }
    }

    private boolean aGt() {
        synchronized (this.dug) {
            ri("checkRescuable ===>");
            if (this.dug.size() < 3) {
                ri(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.dug.size()), 3));
                return true;
            }
            int size = this.dug.size() - 3;
            ri("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    ri("purge: " + this.dug.poll());
                }
            }
            ri("after purge");
            Long peek = this.dug.peek();
            if (peek == null) {
                ri("allowRescue by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > duf;
            ri("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void ri(String str) {
        if (DEBUG) {
            Log.i("SwanPuppetManager", "SwanRescue:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.dug.iterator();
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

    public void rj(String str) {
        if (DEBUG) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanPuppetManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public String toString() {
        LinkedHashSet<c> aGp = aGp();
        StringBuilder append = new StringBuilder().append(super.toString()).append(":").append("\n-> clients: ");
        for (c cVar : aGp) {
            append.append("\n--> ").append(cVar.toString());
        }
        return append.toString();
    }
}
