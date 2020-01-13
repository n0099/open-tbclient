package com.baidu.swan.apps.env;

import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.games.h.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import rx.schedulers.Schedulers;
/* loaded from: classes10.dex */
public class c implements com.baidu.swan.apps.a.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a bpA;
    private final String bpB = ProcessUtils.getCurProcessName();
    private f bpC;
    private g bpD;
    private AtomicInteger bpE;
    private CopyOnWriteArrayList<String> bpF;
    private com.baidu.swan.apps.env.a.f bpG;

    /* loaded from: classes10.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.bpA = aVar;
        com.baidu.swan.apps.w.a.RL().a(this);
        this.bpE = new AtomicInteger(0);
        this.bpF = new CopyOnWriteArrayList<>();
        this.bpC = new f();
        this.bpD = new g();
        this.bpG = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void bK(boolean z) {
        String bm = com.baidu.swan.apps.w.a.RL().bm(this.bpA.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + bm + ")  -> " + z);
        }
        if (z) {
            Pj();
        } else {
            Pl();
        }
    }

    public String toString() {
        return "Process<" + this.bpB + "> " + super.toString();
    }

    public void u(@Nullable String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            g(arrayList, z);
        }
    }

    public void g(@Nullable List<String> list, boolean z) {
        if (list != null && !list.isEmpty()) {
            b(list, true, z);
        }
    }

    public void b(@Nullable final List<String> list, final boolean z, boolean z2) {
        if (!ProcessUtils.isMainProcess()) {
            if (DEBUG) {
                Log.w("SwanAppPurger", "非主进程调用，不执行操作");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "deleteSwanApp");
        }
        if (z2) {
            Q(list);
        }
        if (list != null && !list.isEmpty()) {
            rx.d.ca("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(String str) {
                    c.this.h(list, z);
                }
            });
        }
    }

    @WorkerThread
    public void h(@Nullable List<String> list, boolean z) {
        if (list == null) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                return;
            }
            return;
        }
        this.bpE.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.bpC.O(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.e.a.fT(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.n(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.bpC.P(list);
        for (String str : list) {
            if (this.bpF.contains(str)) {
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除忽略: " + str);
                }
            } else {
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序相关（小程序包、小程序分包）的APS记录: " + str);
                }
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序文件: " + str);
                }
                this.bpC.ht(str);
                this.bpD.ht(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.bpC.hq(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.bpC.hr(str);
            }
        }
        if (this.bpE.decrementAndGet() <= 0) {
            this.bpE.set(0);
            this.bpF.clear();
        }
    }

    private void Q(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> PQ = SwanFavorDataManager.PP().PQ();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : PQ) {
                hashMap.put(swanFavorItemData.getAppKey(), swanFavorItemData);
            }
            Set<String> a2 = com.baidu.swan.apps.database.a.b.a(AppRuntime.getAppContext().getContentResolver());
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String next = it.next();
                boolean contains = a2.contains(next);
                boolean containsKey = hashMap.containsKey(next);
                if (contains || containsKey) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        Log.d("SwanAppPurger", "清理过滤-过滤此App：" + next + "； 历史：" + contains + "； 我的小程序：" + containsKey);
                    }
                    it.remove();
                } else if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SwanAppPurger", "清理过滤-不过滤： " + next);
                }
            }
        }
    }

    public boolean Pi() {
        return this.bpE.get() > 0;
    }

    public void c(@Nullable Set<String> set) {
        if (this.bpG != null) {
            this.bpG.f(set);
        }
    }

    public void hs(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bpF.add(str);
        }
    }

    private void Pj() {
        d(Pk());
    }

    private Set<String> Pk() {
        return ev(103);
    }

    private void d(Set<String> set) {
        d.a("aiapp_setting_", set, true);
    }

    private void Pl() {
        e(Pm());
    }

    private Set<String> Pm() {
        return ev(100);
    }

    private void e(Set<String> set) {
        d.a("aiapp_", set, true);
        String acQ = com.baidu.swan.apps.storage.b.acQ();
        if (!TextUtils.isEmpty(acQ)) {
            com.baidu.swan.d.c.deleteFile(acQ);
        }
        String acR = com.baidu.swan.apps.storage.b.acR();
        if (!TextUtils.isEmpty(acR)) {
            com.baidu.swan.d.c.deleteFile(acR);
        }
        com.baidu.swan.games.v.b.anw();
        l.alG();
    }

    private Set<String> ev(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<com.baidu.swan.apps.process.messaging.service.c> Zg = com.baidu.swan.apps.process.messaging.service.e.Ze().Zg();
        if (Zg.size() < 1) {
            return hashSet;
        }
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = Zg.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.YV() && next.YT()) {
                hashSet.add(next.getAppId());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + ")");
                }
                com.baidu.swan.apps.process.messaging.a.Yv().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.bFt));
            }
        }
        return hashSet;
    }
}
