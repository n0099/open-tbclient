package com.baidu.swan.apps.env.a;

import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.an.t;
import com.baidu.swan.apps.database.SwanAppDbControl;
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
/* loaded from: classes2.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @AnyThread
    public synchronized void d(@Nullable final Set<String> set) {
        if (!ProcessUtils.isMainProcess()) {
            if (DEBUG) {
                Log.w("SwanAppDiskCleaner", "非主进程调用，不执行操作");
            }
        } else if (HR()) {
            j.Ug().d(new Runnable() { // from class: com.baidu.swan.apps.env.a.f.1
                @Override // java.lang.Runnable
                public void run() {
                    Map<String, Long> S;
                    List<String> list;
                    List<String> S2;
                    com.baidu.swan.apps.storage.b.f.ST().putLong("clean_disk_check_time", System.currentTimeMillis());
                    boolean Gf = com.baidu.swan.apps.core.pms.a.Gf();
                    if (Gf) {
                        S = f.this.T(0L);
                    } else {
                        S = SwanAppDbControl.aZ(AppRuntime.getAppContext()).S(0L);
                    }
                    if (S.isEmpty()) {
                        if (f.DEBUG) {
                            Log.d("SwanAppDiskCleaner", "cleanDiskSpace empty, psmEnable:" + Gf);
                            return;
                        }
                        return;
                    }
                    List<String> arrayList = new ArrayList<>(S.keySet());
                    Iterator it = Arrays.asList(new e(set), new d(), new c()).iterator();
                    while (true) {
                        list = arrayList;
                        if (!it.hasNext()) {
                            break;
                        }
                        arrayList = ((com.baidu.swan.apps.env.a.a) it.next()).S(list);
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
                    long k = f.this.k("value_disk_cleaner_force_hour", 720L);
                    long k2 = f.this.k("value_disk_cleaner_ignore_hour", 168L);
                    long k3 = f.this.k("value_disk_hold_max_count", 10L);
                    long k4 = f.this.k("value_disk_cleaner_max_count", 200L);
                    if (f.DEBUG) {
                        Log.i("SwanAppDiskCleaner", "forceCleanHour=" + k + ", ignoreCleanHour=" + k2 + ", holdMaxCount=" + k3 + ", maxCount=" + k4);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator<String> it2 = list.iterator();
                    while (it2.hasNext()) {
                        String next = it2.next();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - S.get(next).longValue() <= BdKVCache.MILLS_1Hour * k2) {
                            it2.remove();
                            arrayList3.add(next);
                        } else if (currentTimeMillis - S.get(next).longValue() > BdKVCache.MILLS_1Hour * k) {
                            it2.remove();
                            arrayList2.add(next);
                        }
                    }
                    if (f.DEBUG) {
                        Log.i("SwanAppDiskCleaner", "timeoutSize=" + arrayList2.size() + ", ignoreCleanSize=" + arrayList3.size() + " normalSize=" + list.size() + " allSize=" + S.size());
                    }
                    List<String> S3 = new b((int) k3).S(list);
                    if (S3 == null) {
                        S3 = arrayList2;
                    } else {
                        S3.addAll(arrayList2);
                    }
                    if (arrayList3.size() > k4 && (S2 = new b((int) k4).S(arrayList3)) != null) {
                        S3.addAll(S2);
                    }
                    if (f.DEBUG) {
                        Log.i("SwanAppDiskCleaner", "deleteSwanAppList=" + S3);
                    }
                    com.baidu.swan.apps.env.d.HO().HQ().g(S3, false);
                }
            }, "cleanDiskSpace");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long k(@NonNull String str, long j) {
        long j2 = t.getLong(str, j);
        return j2 <= 0 ? j : j2;
    }

    private boolean HR() {
        long j = com.baidu.swan.apps.storage.b.f.ST().getLong("clean_disk_check_time", 0L);
        boolean z = System.currentTimeMillis() - j >= 86400000;
        if (DEBUG && !z) {
            Log.w("SwanAppDiskCleaner", "未达到指定频率不清理, lastTime=" + j + ", now=" + System.currentTimeMillis());
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    @NonNull
    public Map<String, Long> T(long j) {
        Map<String, PMSAppInfo> aaW = com.baidu.swan.pms.database.a.aaV().aaW();
        if (aaW == null || aaW.isEmpty()) {
            return Collections.emptyMap();
        }
        ArrayList<PMSAppInfo> arrayList = new ArrayList(aaW.values());
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
    /* loaded from: classes2.dex */
    public class a implements Comparator<PMSAppInfo> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            return Long.compare(pMSAppInfo.createTime, pMSAppInfo2.createTime);
        }
    }
}
