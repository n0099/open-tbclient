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
/* loaded from: classes10.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @AnyThread
    public synchronized void f(@Nullable final Set<String> set) {
        if (!ProcessUtils.isMainProcess()) {
            if (DEBUG) {
                Log.w("SwanAppDiskCleaner", "非主进程调用，不执行操作");
            }
        } else if (Pp()) {
            m.aev().execute(new Runnable() { // from class: com.baidu.swan.apps.env.a.f.1
                @Override // java.lang.Runnable
                public void run() {
                    List<String> list;
                    List<String> S;
                    h.adb().putLong("clean_disk_check_time", System.currentTimeMillis());
                    Map aa = f.this.aa(0L);
                    if (aa.isEmpty()) {
                        if (f.DEBUG) {
                            Log.d("SwanAppDiskCleaner", "cleanDiskSpace empty");
                            return;
                        }
                        return;
                    }
                    List<String> arrayList = new ArrayList<>(aa.keySet());
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
                    long i = f.this.i("value_disk_cleaner_force_hour", 720L);
                    long i2 = f.this.i("value_disk_cleaner_ignore_hour", 168L);
                    long i3 = f.this.i("value_disk_hold_max_count", 10L);
                    long i4 = f.this.i("value_disk_cleaner_max_count", 200L);
                    if (f.DEBUG) {
                        Log.i("SwanAppDiskCleaner", "forceCleanHour=" + i + ", ignoreCleanHour=" + i2 + ", holdMaxCount=" + i3 + ", maxCount=" + i4);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator<String> it2 = list.iterator();
                    while (it2.hasNext()) {
                        String next = it2.next();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ((Long) aa.get(next)).longValue() <= BdKVCache.MILLS_1Hour * i2) {
                            it2.remove();
                            arrayList3.add(next);
                        } else if (currentTimeMillis - ((Long) aa.get(next)).longValue() > BdKVCache.MILLS_1Hour * i) {
                            it2.remove();
                            arrayList2.add(next);
                        }
                    }
                    if (f.DEBUG) {
                        Log.i("SwanAppDiskCleaner", "timeoutSize=" + arrayList2.size() + ", ignoreCleanSize=" + arrayList3.size() + " normalSize=" + list.size() + " allSize=" + aa.size());
                    }
                    List<String> S2 = new b((int) i3).S(list);
                    if (S2 == null) {
                        S2 = arrayList2;
                    } else {
                        S2.addAll(arrayList2);
                    }
                    if (arrayList3.size() > i4 && (S = new b((int) i4).S(arrayList3)) != null) {
                        S2.addAll(S);
                    }
                    if (f.DEBUG) {
                        Log.i("SwanAppDiskCleaner", "deleteSwanAppList=" + S2);
                    }
                    com.baidu.swan.apps.env.e.Pn().Po().b(S2, false, false);
                }
            }, "cleanDiskSpace");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long i(@NonNull String str, long j) {
        long j2 = x.getLong(str, j);
        return j2 <= 0 ? j : j2;
    }

    private boolean Pp() {
        long j = h.adb().getLong("clean_disk_check_time", 0L);
        boolean z = System.currentTimeMillis() - j >= 86400000;
        if (DEBUG && !z) {
            Log.w("SwanAppDiskCleaner", "未达到指定频率不清理, lastTime=" + j + ", now=" + System.currentTimeMillis());
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    @NonNull
    public Map<String, Long> aa(long j) {
        Map<String, PMSAppInfo> arh = com.baidu.swan.pms.database.a.arf().arh();
        if (arh == null || arh.isEmpty()) {
            return Collections.emptyMap();
        }
        ArrayList<PMSAppInfo> arrayList = new ArrayList(arh.values());
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
    /* loaded from: classes10.dex */
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
