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
    public static final long dwH = TimeUnit.MINUTES.toMillis(5);
    private final Set<com.baidu.swan.apps.process.messaging.service.a> dcQ;
    private final LinkedHashMap<SwanAppProcessInfo, c> dwG;
    private final Deque<Long> dwI;
    private final com.baidu.swan.apps.process.messaging.service.a dwJ;
    public final Messenger mMessenger;

    /* loaded from: classes9.dex */
    public interface a<FILTER> {
        boolean a(FILTER filter, c cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        private static e dwO = new e();
    }

    public static e aJL() {
        if (!DEBUG || ProcessUtils.isMainProcess()) {
            return b.dwO;
        }
        throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
    }

    private e() {
        SwanAppProcessInfo[] indices;
        this.dwG = new LinkedHashMap<>();
        this.dwI = new ArrayDeque();
        this.mMessenger = new Messenger(new SwanAppMessengerService.a());
        this.dcQ = new HashSet();
        this.dwJ = new com.baidu.swan.apps.process.messaging.service.a() { // from class: com.baidu.swan.apps.process.messaging.service.e.1
            @Override // com.baidu.swan.apps.process.messaging.service.a
            public void c(final String str, final c cVar) {
                if (e.DEBUG) {
                    Log.i("SwanPuppetManager", "onEvent: to=" + e.this.dcQ.size() + " event=" + str + " client=" + cVar.dwt);
                }
                synchronized (e.this.dcQ) {
                    com.baidu.swan.apps.ao.e.a.a(com.baidu.swan.apps.runtime.d.getMainHandler(), (com.baidu.swan.apps.ao.e.b) new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.process.messaging.service.a>() { // from class: com.baidu.swan.apps.process.messaging.service.e.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ao.e.b
                        /* renamed from: b */
                        public void L(com.baidu.swan.apps.process.messaging.service.a aVar) {
                            aVar.c(str, cVar);
                        }
                    }, (Collection) e.this.dcQ);
                }
            }

            @Override // com.baidu.swan.apps.process.messaging.service.a
            public void axf() {
            }
        };
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.dwG.put(swanAppProcessInfo, new c(swanAppProcessInfo));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.swan.apps.process.messaging.service.a aJM() {
        return this.dwJ;
    }

    public void a(final com.baidu.swan.apps.process.messaging.service.a aVar, long j) {
        synchronized (this.dcQ) {
            this.dcQ.add(aVar);
            if (DEBUG) {
                Log.i("SwanPuppetManager", "addCallback: after = " + this.dcQ.size());
            }
        }
        if (j > 0) {
            com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.service.e.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (e.this.dcQ) {
                        if (e.this.dcQ.contains(aVar)) {
                            if (e.DEBUG) {
                                Log.i("SwanPuppetManager", "timeout: callback = " + aVar);
                            }
                            e.this.a(aVar);
                            aVar.axf();
                        }
                    }
                }
            }, j);
        }
    }

    public void a(com.baidu.swan.apps.process.messaging.service.a aVar) {
        synchronized (this.dcQ) {
            this.dcQ.remove(aVar);
            if (DEBUG) {
                Log.i("SwanPuppetManager", "delCallback: after = " + this.dcQ.size());
            }
        }
    }

    public synchronized c jZ(int i) {
        return a(SwanAppProcessInfo.indexOf(i));
    }

    public synchronized c a(SwanAppProcessInfo swanAppProcessInfo) {
        return this.dwG.get(swanAppProcessInfo);
    }

    public synchronized <FILTER> c a(FILTER filter, a<FILTER> aVar) {
        c cVar;
        Iterator<c> it = this.dwG.values().iterator();
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

    public synchronized LinkedHashSet<c> aJN() {
        return new LinkedHashSet<>(this.dwG.values());
    }

    public synchronized c rX(@Nullable String str) {
        c rZ;
        rZ = rZ(str);
        if (rZ == null) {
            rZ = aJO();
        }
        return rZ;
    }

    @NonNull
    public synchronized c rY(@Nullable String str) {
        c rX;
        rX = rX(str);
        b(rX.dwt);
        return rX;
    }

    public synchronized c aJO() {
        c a2;
        sc("b4 computNextAvailableProcess");
        int i = 0;
        c cVar = null;
        c cVar2 = null;
        while (true) {
            if (i <= 5) {
                a2 = this.dwG.get(SwanAppProcessInfo.indexOf(i));
                if (a2 != null && a2.dwt.isSwanAppProcess()) {
                    if (a2.aJw()) {
                        a2 = cVar;
                    } else if (a2.aJv()) {
                        if (DEBUG) {
                            Log.i("SwanPuppetManager", "computNextAvailableProcess: firstPreloadedClient=" + a2);
                        }
                    } else {
                        if (cVar2 == null && a2.aJy()) {
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
                Iterator<c> it = this.dwG.values().iterator();
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
    public synchronized c aJP() {
        c cVar;
        sc("b4 computNextPreloadProcess");
        int i = 0;
        cVar = null;
        while (true) {
            if (i <= 5) {
                c cVar2 = this.dwG.get(SwanAppProcessInfo.indexOf(i));
                if (cVar2 != null && cVar2.dwt.isSwanAppProcess()) {
                    if (cVar2.aJw()) {
                        cVar2 = cVar;
                    } else if (cVar2.aJv()) {
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
    public synchronized c rZ(@Nullable String str) {
        List<c> sa;
        sa = sa(str);
        return sa.isEmpty() ? null : sa.get(sa.size() - 1);
    }

    @NonNull
    public synchronized List<c> sa(@Nullable String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (c cVar : this.dwG.values()) {
                if (TextUtils.equals(cVar.getAppId(), str)) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    public synchronized void b(SwanAppProcessInfo swanAppProcessInfo) {
        c remove = this.dwG.remove(swanAppProcessInfo);
        if (remove != null) {
            this.dwG.put(swanAppProcessInfo, remove);
        }
        if (DEBUG) {
            sc("lru -> " + swanAppProcessInfo);
        }
    }

    public synchronized void d(String str, c cVar) {
        if (!TextUtils.isEmpty(str)) {
            List<c> sa = aJL().sa(str);
            if (!sa.isEmpty()) {
                for (c cVar2 : sa) {
                    if (cVar2 != cVar && cVar2 != null && cVar2.aJw()) {
                        if (DEBUG) {
                            Log.i("SwanPuppetManager", "deduplicateClients: protectedClient=" + cVar);
                            Log.i("SwanPuppetManager", "deduplicateClients: exClient=" + cVar2);
                        }
                        cVar2.aJK().aJI();
                        if (cVar2.aJy()) {
                            com.baidu.swan.apps.process.messaging.a.aIX().a(new com.baidu.swan.apps.process.messaging.c(110, new Bundle()).a(cVar2.dwt));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aJQ() {
        synchronized (this.dwI) {
            if (aJR()) {
                this.dwI.offer(Long.valueOf(System.currentTimeMillis()));
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "1");
                com.baidu.swan.apps.process.messaging.service.b.c(com.baidu.swan.apps.t.a.aAr(), bundle);
            }
        }
    }

    private boolean aJR() {
        synchronized (this.dwI) {
            sb("checkRescuable ===>");
            if (this.dwI.size() < 3) {
                sb(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", Integer.valueOf(this.dwI.size()), 3));
                return true;
            }
            int size = this.dwI.size() - 3;
            sb("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    sb("purge: " + this.dwI.poll());
                }
            }
            sb("after purge");
            Long peek = this.dwI.peek();
            if (peek == null) {
                sb("allowRescue by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > dwH;
            sb("allowRescue:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    private void sb(String str) {
        if (DEBUG) {
            Log.i("SwanPuppetManager", "SwanRescue:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.dwI.iterator();
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

    public void sc(String str) {
        if (DEBUG) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanPuppetManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public String toString() {
        LinkedHashSet<c> aJN = aJN();
        StringBuilder append = new StringBuilder().append(super.toString()).append(":").append("\n-> clients: ");
        for (c cVar : aJN) {
            append.append("\n--> ").append(cVar.toString());
        }
        return append.toString();
    }
}
