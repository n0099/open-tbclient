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
/* loaded from: classes10.dex */
public class c implements com.baidu.swan.apps.a.c, com.baidu.swan.apps.env.c.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a cLQ;
    private final String cLR = ProcessUtils.getCurProcessName();
    private f cLS;
    private g cLT;
    private AtomicInteger cLU;
    private CopyOnWriteArrayList<String> cLV;
    private com.baidu.swan.apps.env.a.f cLW;

    /* loaded from: classes10.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.cLQ = aVar;
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.t.a.auf().a(c.this);
            }
        }, "addLoginStatusChangedListener", 2);
        this.cLU = new AtomicInteger(0);
        this.cLV = new CopyOnWriteArrayList<>();
        this.cLS = new f();
        this.cLT = new g();
        this.cLW = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void dZ(boolean z) {
        String bp = com.baidu.swan.apps.t.a.auf().bp(this.cLQ.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + bp + ")  -> " + z);
        }
        if (z) {
            aqC();
        } else {
            aqE();
        }
    }

    public String toString() {
        return "Process<" + this.cLR + "> " + super.toString();
    }

    public void a(@Nullable String str, boolean z, b.C0427b c0427b) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a(arrayList, z, c0427b);
        }
    }

    public void a(@Nullable List<String> list, boolean z, b.C0427b c0427b) {
        if (list != null && !list.isEmpty()) {
            a(list, true, z, c0427b);
        }
    }

    public void a(@Nullable final List<String> list, final boolean z, boolean z2, final b.C0427b c0427b) {
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
            av(list);
        }
        if (list != null && !list.isEmpty()) {
            rx.d.cd("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(String str) {
                    c.this.b(list, z, c0427b);
                }
            });
        }
    }

    @WorkerThread
    public void b(@Nullable List<String> list, boolean z, b.C0427b c0427b) {
        if (list == null) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                return;
            }
            return;
        }
        this.cLU.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.cLS.at(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.f.a.lM(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.r(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.cLS.au(list);
        for (String str : list) {
            if (this.cLV.contains(str)) {
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
                a(str, c0427b);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.cLS.nD(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.cLS.nE(str);
            }
        }
        if (this.cLU.decrementAndGet() <= 0) {
            this.cLU.set(0);
            this.cLV.clear();
        }
        com.baidu.swan.apps.env.c.c.a(c0427b).arq();
    }

    private void av(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> arR = SwanFavorDataManager.arQ().arR();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : arR) {
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

    public boolean aqB() {
        return this.cLU.get() > 0;
    }

    public void a(@Nullable Set<String> set, b.C0427b c0427b) {
        if (this.cLW != null) {
            this.cLW.b(set, c0427b);
        }
    }

    public void nF(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cLV.add(str);
        }
    }

    private void aqC() {
        d(aqD());
    }

    private Set<String> aqD() {
        return ii(103);
    }

    private void d(Set<String> set) {
        com.baidu.swan.apps.t.a.auZ().a("aiapp_setting_", set, true);
    }

    private void aqE() {
        e(aqF());
    }

    private Set<String> aqF() {
        return ii(100);
    }

    private void e(Set<String> set) {
        com.baidu.swan.apps.t.a.auZ().a("aiapp_", set, true);
        String aIa = com.baidu.swan.apps.storage.b.aIa();
        if (!TextUtils.isEmpty(aIa)) {
            com.baidu.swan.c.d.deleteFile(aIa);
        }
        String aIb = com.baidu.swan.apps.storage.b.aIb();
        if (!TextUtils.isEmpty(aIb)) {
            com.baidu.swan.c.d.deleteFile(aIb);
        }
        com.baidu.swan.games.w.b.aUK();
        n.aSP();
    }

    private Set<String> ii(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<com.baidu.swan.apps.process.messaging.service.c> aDu = com.baidu.swan.apps.process.messaging.service.e.aDs().aDu();
        if (aDu.size() < 1) {
            return hashSet;
        }
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = aDu.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aDf() && next.aDd()) {
                hashSet.add(next.getAppId());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + ")");
                }
                com.baidu.swan.apps.process.messaging.a.aCE().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.dgh));
            }
        }
        return hashSet;
    }

    private void a(String str, b.C0427b c0427b) {
        com.baidu.swan.apps.env.c.c.a(c0427b).nU(str);
        this.cLS.nG(str);
        this.cLT.nG(str);
        com.baidu.swan.apps.core.pms.d.a.nc(str);
    }
}
