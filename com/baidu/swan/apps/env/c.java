package com.baidu.swan.apps.env;

import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.env.c.b;
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
/* loaded from: classes8.dex */
public class c implements com.baidu.swan.apps.a.c, com.baidu.swan.apps.env.c.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a cpa;
    private final String cpb = ProcessUtils.getCurProcessName();
    private f cpc;
    private g cpd;
    private AtomicInteger cpe;
    private CopyOnWriteArrayList<String> cpf;
    private com.baidu.swan.apps.env.a.f cpg;

    /* loaded from: classes8.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.cpa = aVar;
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.t.a.aoO().a(c.this);
            }
        }, "addLoginStatusChangedListener", 2);
        this.cpe = new AtomicInteger(0);
        this.cpf = new CopyOnWriteArrayList<>();
        this.cpc = new f();
        this.cpd = new g();
        this.cpg = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void dr(boolean z) {
        String bk = com.baidu.swan.apps.t.a.aoO().bk(this.cpa.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + bk + ")  -> " + z);
        }
        if (z) {
            alm();
        } else {
            alo();
        }
    }

    public String toString() {
        return "Process<" + this.cpb + "> " + super.toString();
    }

    public void a(@Nullable String str, boolean z, b.C0401b c0401b) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a(arrayList, z, c0401b);
        }
    }

    public void a(@Nullable List<String> list, boolean z, b.C0401b c0401b) {
        if (list != null && !list.isEmpty()) {
            a(list, true, z, c0401b);
        }
    }

    public void a(@Nullable final List<String> list, final boolean z, boolean z2, final b.C0401b c0401b) {
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
            ae(list);
        }
        if (list != null && !list.isEmpty()) {
            rx.d.bW("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(String str) {
                    c.this.b(list, z, c0401b);
                }
            });
        }
    }

    @WorkerThread
    public void b(@Nullable List<String> list, boolean z, b.C0401b c0401b) {
        if (list == null) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                return;
            }
            return;
        }
        this.cpe.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.cpc.ac(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.f.a.kn(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.p(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.cpc.ad(list);
        for (String str : list) {
            if (this.cpf.contains(str)) {
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
                a(str, c0401b);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.cpc.me(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.cpc.mf(str);
            }
        }
        if (this.cpe.decrementAndGet() <= 0) {
            this.cpe.set(0);
            this.cpf.clear();
        }
        com.baidu.swan.apps.env.c.c.a(c0401b).ama();
    }

    private void ae(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> amB = SwanFavorDataManager.amA().amB();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : amB) {
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

    public boolean all() {
        return this.cpe.get() > 0;
    }

    public void a(@Nullable Set<String> set, b.C0401b c0401b) {
        if (this.cpg != null) {
            this.cpg.b(set, c0401b);
        }
    }

    public void mg(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cpf.add(str);
        }
    }

    private void alm() {
        d(aln());
    }

    private Set<String> aln() {
        return hr(103);
    }

    private void d(Set<String> set) {
        com.baidu.swan.apps.t.a.apJ().a("aiapp_setting_", set, true);
    }

    private void alo() {
        e(alp());
    }

    private Set<String> alp() {
        return hr(100);
    }

    private void e(Set<String> set) {
        com.baidu.swan.apps.t.a.apJ().a("aiapp_", set, true);
        String aCN = com.baidu.swan.apps.storage.b.aCN();
        if (!TextUtils.isEmpty(aCN)) {
            com.baidu.swan.c.d.deleteFile(aCN);
        }
        String aCO = com.baidu.swan.apps.storage.b.aCO();
        if (!TextUtils.isEmpty(aCO)) {
            com.baidu.swan.c.d.deleteFile(aCO);
        }
        com.baidu.swan.games.w.b.aPw();
        n.aNB();
    }

    private Set<String> hr(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<com.baidu.swan.apps.process.messaging.service.c> ayi = com.baidu.swan.apps.process.messaging.service.e.ayg().ayi();
        if (ayi.size() < 1) {
            return hashSet;
        }
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = ayi.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.axT() && next.axR()) {
                hashSet.add(next.getAppId());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + ")");
                }
                com.baidu.swan.apps.process.messaging.a.axs().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.cJz));
            }
        }
        return hashSet;
    }

    private void a(String str, b.C0401b c0401b) {
        com.baidu.swan.apps.env.c.c.a(c0401b).mv(str);
        this.cpc.mh(str);
        this.cpd.mh(str);
        com.baidu.swan.apps.core.pms.d.a.lD(str);
    }
}
