package com.baidu.swan.apps.env.a;

import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.env.b.b;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @AnyThread
    public synchronized void b(@Nullable final Set<String> set, final b.C0356b c0356b) {
        if (!ProcessUtils.isMainProcess()) {
            if (DEBUG) {
                Log.w("SwanAppDiskCleaner", "非主进程调用，不执行操作");
            }
        } else if (aeK()) {
            p.awC().execute(new Runnable() { // from class: com.baidu.swan.apps.env.a.f.1
                @Override // java.lang.Runnable
                public void run() {
                    List<String> list;
                    List<String> af;
                    h.auW().putLong("clean_disk_check_time", System.currentTimeMillis());
                    Map aS = f.this.aS(0L);
                    if (aS.isEmpty()) {
                        if (f.DEBUG) {
                            Log.d("SwanAppDiskCleaner", "cleanDiskSpace empty");
                            return;
                        }
                        return;
                    }
                    List<String> arrayList = new ArrayList<>(aS.keySet());
                    Iterator it = Arrays.asList(new e(set), new d(), new c()).iterator();
                    while (true) {
                        list = arrayList;
                        if (!it.hasNext()) {
                            break;
                        }
                        arrayList = ((com.baidu.swan.apps.env.a.a) it.next()).af(list);
                    }
                    if (list == null || list.isEmpty()) {
                        if (f.DEBUG) {
                            Log.i("SwanAppDiskCleaner", "cleanDiskSpace empty after strategy");
                            return;
                        }
                        return;
                    }
                    if (f.DEBUG) {
                        Log.i("SwanAppDiskCleaner", "after strategy swanApp size=" + list.size());
                    }
                    com.baidu.swan.pms.node.b.a aMe = com.baidu.swan.pms.node.b.b.aMd().aMe();
                    long j = aMe.dxt;
                    long j2 = aMe.dxv;
                    long j3 = aMe.dxu;
                    long j4 = aMe.dxs;
                    if (f.DEBUG) {
                        Log.i("SwanAppDiskCleaner", "forceCleanHour=" + j + ", ignoreCleanHour=" + j2 + ", holdMaxCount=" + j3 + ", maxCount=" + j4);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator<String> it2 = list.iterator();
                    while (it2.hasNext()) {
                        String next = it2.next();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ((Long) aS.get(next)).longValue() <= BdKVCache.MILLS_1Hour * j2) {
                            it2.remove();
                            arrayList3.add(next);
                        } else if (currentTimeMillis - ((Long) aS.get(next)).longValue() > BdKVCache.MILLS_1Hour * j) {
                            it2.remove();
                            arrayList2.add(next);
                        }
                    }
                    if (f.DEBUG) {
                        Log.i("SwanAppDiskCleaner", "timeoutSize=" + arrayList2.size() + ", ignoreCleanSize=" + arrayList3.size() + " normalSize=" + list.size() + " allSize=" + aS.size());
                    }
                    List<String> af2 = new b((int) j3).af(list);
                    if (af2 == null) {
                        af2 = arrayList2;
                    } else {
                        af2.addAll(arrayList2);
                    }
                    if (arrayList3.size() > j4 && (af = new b((int) j4).af(arrayList3)) != null) {
                        af2.addAll(af);
                    }
                    if (f.DEBUG) {
                        Log.i("SwanAppDiskCleaner", "deleteSwanAppList=" + af2);
                    }
                    com.baidu.swan.apps.env.e.aeI().aeJ().a(af2, false, false, c0356b);
                }
            }, "cleanDiskSpace");
        }
    }

    private boolean aeK() {
        long j = h.auW().getLong("clean_disk_check_time", 0L);
        boolean z = System.currentTimeMillis() - j >= 86400000;
        if (DEBUG && !z) {
            Log.w("SwanAppDiskCleaner", "未达到指定频率不清理, lastTime=" + j + ", now=" + System.currentTimeMillis());
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    @NonNull
    public Map<String, Long> aS(long j) {
        Map<String, PMSAppInfo> aKU = com.baidu.swan.pms.database.a.aKS().aKU();
        if (aKU == null || aKU.isEmpty()) {
            return Collections.emptyMap();
        }
        ArrayList<PMSAppInfo> arrayList = new ArrayList(aKU.values());
        Collections.sort(arrayList, new a());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (PMSAppInfo pMSAppInfo : arrayList) {
            if (System.currentTimeMillis() - pMSAppInfo.createTime > j) {
                linkedHashMap.put(pMSAppInfo.appId, Long.valueOf(pMSAppInfo.createTime));
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements Comparator<PMSAppInfo> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: c */
        public int compare(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            return Long.compare(pMSAppInfo.createTime, pMSAppInfo2.createTime);
        }
    }
}
