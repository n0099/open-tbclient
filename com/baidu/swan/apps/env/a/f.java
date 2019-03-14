package com.baidu.swan.apps.env.a;

import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.database.SwanAppDbControl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public synchronized void i(@Nullable Set<String> set) {
        List<String> AB;
        if (!ProcessUtils.isMainProcess()) {
            if (DEBUG) {
                Log.w("SwanAppDiskCleaner", "非主进程调用，不执行操作");
            }
        } else if (Bh()) {
            if (DEBUG) {
                Log.d("SwanAppDiskCleaner", "配置无用包个数上限： 50");
            }
            com.baidu.swan.apps.storage.b.f.KL().putLong("clean_disk_check_time", System.currentTimeMillis());
            if (com.baidu.swan.apps.core.pms.a.vq()) {
                AB = Bi();
                if (DEBUG) {
                    Log.d("SwanAppDiskCleaner", "从pms查询小程序");
                }
            } else {
                AB = SwanAppDbControl.bE(AppRuntime.getAppContext()).AB();
                if (DEBUG) {
                    Log.d("SwanAppDiskCleaner", "从aps查询小程序");
                }
            }
            if (AB == null || AB.size() == 0) {
                if (DEBUG) {
                    Log.d("SwanAppDiskCleaner", "未查询到小程序");
                }
            } else {
                if (DEBUG) {
                    Log.d("SwanAppDiskCleaner", "查询到" + AB.size() + "个小程序：");
                    Iterator<String> it = AB.iterator();
                    while (it.hasNext()) {
                        Log.d("SwanAppDiskCleaner", "id: " + it.next());
                    }
                }
                ArrayList<com.baidu.swan.apps.env.a.a> arrayList = new ArrayList();
                arrayList.add(new e(set));
                arrayList.add(new d());
                arrayList.add(new c());
                arrayList.add(new b(50));
                for (com.baidu.swan.apps.env.a.a aVar : arrayList) {
                    AB = aVar.s(AB);
                }
                if (DEBUG) {
                    if (AB == null || AB.size() == 0) {
                        Log.d("SwanAppDiskCleaner", "无需清理小程序");
                    } else {
                        Log.d("SwanAppDiskCleaner", "过滤后需清理" + AB.size() + "个小程序：");
                        Iterator<String> it2 = AB.iterator();
                        while (it2.hasNext()) {
                            Log.d("SwanAppDiskCleaner", "id: " + it2.next());
                        }
                    }
                }
                com.baidu.swan.apps.env.e.Bf().Bg().e(AB, false);
            }
        }
    }

    private boolean Bh() {
        boolean z = System.currentTimeMillis() - com.baidu.swan.apps.storage.b.f.KL().getLong("clean_disk_check_time", 0L) >= 172800000;
        if (DEBUG && !z) {
            Log.w("SwanAppDiskCleaner", "未达到指定频率，不清理");
        }
        return z;
    }

    @Nullable
    private List<String> Bi() {
        Map<String, com.baidu.swan.pms.model.a> RB = com.baidu.swan.pms.database.a.RA().RB();
        if (RB == null || RB.size() == 0) {
            return null;
        }
        ArrayList<com.baidu.swan.pms.model.a> arrayList = new ArrayList(RB.values());
        Collections.sort(arrayList, new a());
        ArrayList arrayList2 = new ArrayList();
        for (com.baidu.swan.pms.model.a aVar : arrayList) {
            arrayList2.add(aVar.appId);
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Comparator<com.baidu.swan.pms.model.a> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.baidu.swan.pms.model.a aVar, com.baidu.swan.pms.model.a aVar2) {
            return Long.compare(aVar.createTime, aVar2.createTime);
        }
    }
}
