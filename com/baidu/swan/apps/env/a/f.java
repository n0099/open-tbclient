package com.baidu.swan.apps.env.a;

import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.aq.n;
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
/* loaded from: classes11.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @AnyThread
    public synchronized void g(@Nullable final Set<String> set) {
        if (!ProcessUtils.isMainProcess()) {
            if (DEBUG) {
                Log.w("SwanAppDiskCleaner", "非主进程调用，不执行操作");
            }
        } else if (acx()) {
            n.atu().execute(new Runnable() { // from class: com.baidu.swan.apps.env.a.f.1
                @Override // java.lang.Runnable
                public void run() {
                    List<String> list;
                    List<String> ab;
                    h.arO().putLong("clean_disk_check_time", System.currentTimeMillis());
                    Map aP = f.this.aP(0L);
                    if (aP.isEmpty()) {
                        if (f.DEBUG) {
                            Log.d("SwanAppDiskCleaner", "cleanDiskSpace empty");
                            return;
                        }
                        return;
                    }
                    List<String> arrayList = new ArrayList<>(aP.keySet());
                    Iterator it = Arrays.asList(new e(set), new d(), new c()).iterator();
                    while (true) {
                        list = arrayList;
                        if (!it.hasNext()) {
                            break;
                        }
                        arrayList = ((com.baidu.swan.apps.env.a.a) it.next()).ab(list);
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
                    com.baidu.swan.pms.node.b.a aHg = com.baidu.swan.pms.node.b.b.aHf().aHg();
                    long j = aHg.dmQ;
                    long j2 = aHg.dmS;
                    long j3 = aHg.dmR;
                    long j4 = aHg.dmP;
                    if (f.DEBUG) {
                        Log.i("SwanAppDiskCleaner", "forceCleanHour=" + j + ", ignoreCleanHour=" + j2 + ", holdMaxCount=" + j3 + ", maxCount=" + j4);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator<String> it2 = list.iterator();
                    while (it2.hasNext()) {
                        String next = it2.next();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ((Long) aP.get(next)).longValue() <= BdKVCache.MILLS_1Hour * j2) {
                            it2.remove();
                            arrayList3.add(next);
                        } else if (currentTimeMillis - ((Long) aP.get(next)).longValue() > BdKVCache.MILLS_1Hour * j) {
                            it2.remove();
                            arrayList2.add(next);
                        }
                    }
                    if (f.DEBUG) {
                        Log.i("SwanAppDiskCleaner", "timeoutSize=" + arrayList2.size() + ", ignoreCleanSize=" + arrayList3.size() + " normalSize=" + list.size() + " allSize=" + aP.size());
                    }
                    List<String> ab2 = new b((int) j3).ab(list);
                    if (ab2 == null) {
                        ab2 = arrayList2;
                    } else {
                        ab2.addAll(arrayList2);
                    }
                    if (arrayList3.size() > j4 && (ab = new b((int) j4).ab(arrayList3)) != null) {
                        ab2.addAll(ab);
                    }
                    if (f.DEBUG) {
                        Log.i("SwanAppDiskCleaner", "deleteSwanAppList=" + ab2);
                    }
                    com.baidu.swan.apps.env.e.acv().acw().b(ab2, false, false);
                }
            }, "cleanDiskSpace");
        }
    }

    private boolean acx() {
        long j = h.arO().getLong("clean_disk_check_time", 0L);
        boolean z = System.currentTimeMillis() - j >= 86400000;
        if (DEBUG && !z) {
            Log.w("SwanAppDiskCleaner", "未达到指定频率不清理, lastTime=" + j + ", now=" + System.currentTimeMillis());
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    @NonNull
    public Map<String, Long> aP(long j) {
        Map<String, PMSAppInfo> aFX = com.baidu.swan.pms.database.a.aFV().aFX();
        if (aFX == null || aFX.isEmpty()) {
            return Collections.emptyMap();
        }
        ArrayList<PMSAppInfo> arrayList = new ArrayList(aFX.values());
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
    /* loaded from: classes11.dex */
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
