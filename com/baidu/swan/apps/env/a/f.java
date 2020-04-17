package com.baidu.swan.apps.env.a;

import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.as.x;
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
        } else if (Zx()) {
            m.aoU().execute(new Runnable() { // from class: com.baidu.swan.apps.env.a.f.1
                @Override // java.lang.Runnable
                public void run() {
                    List<String> list;
                    List<String> aa;
                    h.anz().putLong("clean_disk_check_time", System.currentTimeMillis());
                    Map aI = f.this.aI(0L);
                    if (aI.isEmpty()) {
                        if (f.DEBUG) {
                            Log.d("SwanAppDiskCleaner", "cleanDiskSpace empty");
                            return;
                        }
                        return;
                    }
                    List<String> arrayList = new ArrayList<>(aI.keySet());
                    Iterator it = Arrays.asList(new e(set), new d(), new c()).iterator();
                    while (true) {
                        list = arrayList;
                        if (!it.hasNext()) {
                            break;
                        }
                        arrayList = ((com.baidu.swan.apps.env.a.a) it.next()).aa(list);
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
                    long j = f.this.j("value_disk_cleaner_force_hour", 720L);
                    long j2 = f.this.j("value_disk_cleaner_ignore_hour", 168L);
                    long j3 = f.this.j("value_disk_hold_max_count", 10L);
                    long j4 = f.this.j("value_disk_cleaner_max_count", 200L);
                    if (f.DEBUG) {
                        Log.i("SwanAppDiskCleaner", "forceCleanHour=" + j + ", ignoreCleanHour=" + j2 + ", holdMaxCount=" + j3 + ", maxCount=" + j4);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator<String> it2 = list.iterator();
                    while (it2.hasNext()) {
                        String next = it2.next();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ((Long) aI.get(next)).longValue() <= BdKVCache.MILLS_1Hour * j2) {
                            it2.remove();
                            arrayList3.add(next);
                        } else if (currentTimeMillis - ((Long) aI.get(next)).longValue() > BdKVCache.MILLS_1Hour * j) {
                            it2.remove();
                            arrayList2.add(next);
                        }
                    }
                    if (f.DEBUG) {
                        Log.i("SwanAppDiskCleaner", "timeoutSize=" + arrayList2.size() + ", ignoreCleanSize=" + arrayList3.size() + " normalSize=" + list.size() + " allSize=" + aI.size());
                    }
                    List<String> aa2 = new b((int) j3).aa(list);
                    if (aa2 == null) {
                        aa2 = arrayList2;
                    } else {
                        aa2.addAll(arrayList2);
                    }
                    if (arrayList3.size() > j4 && (aa = new b((int) j4).aa(arrayList3)) != null) {
                        aa2.addAll(aa);
                    }
                    if (f.DEBUG) {
                        Log.i("SwanAppDiskCleaner", "deleteSwanAppList=" + aa2);
                    }
                    com.baidu.swan.apps.env.e.Zv().Zw().b(aa2, false, false);
                }
            }, "cleanDiskSpace");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long j(@NonNull String str, long j) {
        long j2 = x.getLong(str, j);
        return j2 <= 0 ? j : j2;
    }

    private boolean Zx() {
        long j = h.anz().getLong("clean_disk_check_time", 0L);
        boolean z = System.currentTimeMillis() - j >= 86400000;
        if (DEBUG && !z) {
            Log.w("SwanAppDiskCleaner", "未达到指定频率不清理, lastTime=" + j + ", now=" + System.currentTimeMillis());
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    @NonNull
    public Map<String, Long> aI(long j) {
        Map<String, PMSAppInfo> aBK = com.baidu.swan.pms.database.a.aBI().aBK();
        if (aBK == null || aBK.isEmpty()) {
            return Collections.emptyMap();
        }
        ArrayList<PMSAppInfo> arrayList = new ArrayList(aBK.values());
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
        /* renamed from: b */
        public int compare(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            return Long.compare(pMSAppInfo.createTime, pMSAppInfo2.createTime);
        }
    }
}
