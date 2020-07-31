package com.baidu.swan.apps.env;

import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.env.b.b;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.games.i.n;
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
/* loaded from: classes7.dex */
public class c implements com.baidu.swan.apps.a.c, com.baidu.swan.apps.env.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a ciD;
    private final String ciE = ProcessUtils.getCurProcessName();
    private f ciF;
    private g ciG;
    private AtomicInteger ciH;
    private CopyOnWriteArrayList<String> ciI;
    private com.baidu.swan.apps.env.a.f ciJ;

    /* loaded from: classes7.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.ciD = aVar;
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.aho().a(c.this);
                }
            }, "addLoginStatusChangedListener", 2);
        } else {
            com.baidu.swan.apps.t.a.aho().a(this);
        }
        this.ciH = new AtomicInteger(0);
        this.ciI = new CopyOnWriteArrayList<>();
        this.ciF = new f();
        this.ciG = new g();
        this.ciJ = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void dj(boolean z) {
        String be = com.baidu.swan.apps.t.a.aho().be(this.ciD.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + be + ")  -> " + z);
        }
        if (z) {
            aeD();
        } else {
            aeF();
        }
    }

    public String toString() {
        return "Process<" + this.ciE + "> " + super.toString();
    }

    public void a(@Nullable String str, boolean z, b.C0356b c0356b) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a(arrayList, z, c0356b);
        }
    }

    public void a(@Nullable List<String> list, boolean z, b.C0356b c0356b) {
        if (list != null && !list.isEmpty()) {
            a(list, true, z, c0356b);
        }
    }

    public void a(@Nullable final List<String> list, final boolean z, boolean z2, final b.C0356b c0356b) {
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
            ad(list);
        }
        if (list != null && !list.isEmpty()) {
            rx.d.bS("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(String str) {
                    c.this.b(list, z, c0356b);
                }
            });
        }
    }

    @WorkerThread
    public void b(@Nullable List<String> list, boolean z, b.C0356b c0356b) {
        if (list == null) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                return;
            }
            return;
        }
        this.ciH.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.ciF.ab(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.e.a.iN(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.p(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.ciF.ac(list);
        for (String str : list) {
            if (this.ciI.contains(str)) {
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
                a(str, c0356b);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.ciF.kB(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.ciF.kC(str);
            }
        }
        if (this.ciH.decrementAndGet() <= 0) {
            this.ciH.set(0);
            this.ciI.clear();
        }
        com.baidu.swan.apps.env.b.c.a(c0356b).aeU();
    }

    private void ad(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> afu = SwanFavorDataManager.aft().afu();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : afu) {
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

    public boolean aeC() {
        return this.ciH.get() > 0;
    }

    public void a(@Nullable Set<String> set, b.C0356b c0356b) {
        if (this.ciJ != null) {
            this.ciJ.b(set, c0356b);
        }
    }

    public void kD(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ciI.add(str);
        }
    }

    private void aeD() {
        d(aeE());
    }

    private Set<String> aeE() {
        return fu(103);
    }

    private void d(Set<String> set) {
        com.baidu.swan.apps.t.a.aih().a("aiapp_setting_", set, true);
    }

    private void aeF() {
        e(aeG());
    }

    private Set<String> aeG() {
        return fu(100);
    }

    private void e(Set<String> set) {
        com.baidu.swan.apps.t.a.aih().a("aiapp_", set, true);
        String auE = com.baidu.swan.apps.storage.b.auE();
        if (!TextUtils.isEmpty(auE)) {
            com.baidu.swan.d.d.deleteFile(auE);
        }
        String auF = com.baidu.swan.apps.storage.b.auF();
        if (!TextUtils.isEmpty(auF)) {
            com.baidu.swan.d.d.deleteFile(auF);
        }
        com.baidu.swan.games.w.b.aGF();
        n.aEN();
    }

    private Set<String> fu(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<com.baidu.swan.apps.process.messaging.service.c> aqh = com.baidu.swan.apps.process.messaging.service.e.aqf().aqh();
        if (aqh.size() < 1) {
            return hashSet;
        }
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = aqh.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.apW() && next.apU()) {
                hashSet.add(next.getAppId());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + ")");
                }
                com.baidu.swan.apps.process.messaging.a.apw().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.cBq));
            }
        }
        return hashSet;
    }

    private void a(String str, b.C0356b c0356b) {
        com.baidu.swan.apps.env.b.c.a(c0356b).kG(str);
        this.ciF.kE(str);
        this.ciG.kE(str);
        com.baidu.swan.apps.core.pms.d.a.jZ(str);
    }
}
