package com.baidu.swan.apps.env.a;

import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
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
        } else if (CS()) {
            j.Po().d(new Runnable() { // from class: com.baidu.swan.apps.env.a.f.1
                @Override // java.lang.Runnable
                public void run() {
                    Map<String, Long> A;
                    List<String> list;
                    List<String> t;
                    com.baidu.swan.apps.storage.b.f.NX().putLong("clean_disk_check_time", System.currentTimeMillis());
                    boolean Bf = com.baidu.swan.apps.core.pms.a.Bf();
                    if (Bf) {
                        A = f.this.B(0L);
                    } else {
                        A = SwanAppDbControl.aX(AppRuntime.getAppContext()).A(0L);
                    }
                    if (A.isEmpty()) {
                        if (f.DEBUG) {
                            Log.d("SwanAppDiskCleaner", "cleanDiskSpace empty, psmEnable:" + Bf);
                            return;
                        }
                        return;
                    }
                    List<String> arrayList = new ArrayList<>(A.keySet());
                    Iterator it = Arrays.asList(new e(set), new d(), new c()).iterator();
                    while (true) {
                        list = arrayList;
                        if (!it.hasNext()) {
                            break;
                        }
                        arrayList = ((com.baidu.swan.apps.env.a.a) it.next()).t(list);
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
                    long g = f.this.g("value_disk_cleaner_force_hour", 720L);
                    long g2 = f.this.g("value_disk_cleaner_ignore_hour", 168L);
                    long g3 = f.this.g("value_disk_hold_max_count", 10L);
                    long g4 = f.this.g("value_disk_cleaner_max_count", 200L);
                    if (f.DEBUG) {
                        Log.i("SwanAppDiskCleaner", "forceCleanHour=" + g + ", ignoreCleanHour=" + g2 + ", holdMaxCount=" + g3 + ", maxCount=" + g4);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator<String> it2 = list.iterator();
                    while (it2.hasNext()) {
                        String next = it2.next();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - A.get(next).longValue() <= 3600000 * g2) {
                            it2.remove();
                            arrayList3.add(next);
                        } else if (currentTimeMillis - A.get(next).longValue() > 3600000 * g) {
                            it2.remove();
                            arrayList2.add(next);
                        }
                    }
                    if (f.DEBUG) {
                        Log.i("SwanAppDiskCleaner", "timeoutSize=" + arrayList2.size() + ", ignoreCleanSize=" + arrayList3.size() + " normalSize=" + list.size() + " allSize=" + A.size());
                    }
                    List<String> t2 = new b((int) g3).t(list);
                    if (t2 == null) {
                        t2 = arrayList2;
                    } else {
                        t2.addAll(arrayList2);
                    }
                    if (arrayList3.size() > g4 && (t = new b((int) g4).t(arrayList3)) != null) {
                        t2.addAll(t);
                    }
                    if (f.DEBUG) {
                        Log.i("SwanAppDiskCleaner", "deleteSwanAppList=" + t2);
                    }
                    com.baidu.swan.apps.env.d.CP().CR().d(t2, false);
                }
            }, "cleanDiskSpace");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long g(@NonNull String str, long j) {
        long j2 = t.getLong(str, j);
        return j2 <= 0 ? j : j2;
    }

    private boolean CS() {
        long j = com.baidu.swan.apps.storage.b.f.NX().getLong("clean_disk_check_time", 0L);
        boolean z = System.currentTimeMillis() - j >= 86400000;
        if (DEBUG && !z) {
            Log.w("SwanAppDiskCleaner", "未达到指定频率不清理, lastTime=" + j + ", now=" + System.currentTimeMillis());
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    @NonNull
    public Map<String, Long> B(long j) {
        Map<String, PMSAppInfo> Wf = com.baidu.swan.pms.database.a.We().Wf();
        if (Wf == null || Wf.isEmpty()) {
            return Collections.emptyMap();
        }
        ArrayList<PMSAppInfo> arrayList = new ArrayList(Wf.values());
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
