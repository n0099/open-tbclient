package com.baidu.swan.apps.env;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
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
/* loaded from: classes9.dex */
public class c implements com.baidu.swan.apps.a.c, com.baidu.swan.apps.env.c.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a cZl;
    private final String cZm = ProcessUtils.getCurProcessName();
    private f cZn;
    private g cZo;
    private AtomicInteger cZp;
    private CopyOnWriteArrayList<String> cZq;
    private com.baidu.swan.apps.env.a.f cZr;

    /* loaded from: classes9.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.cZl = aVar;
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.t.a.axb().a(c.this);
            }
        }, "addLoginStatusChangedListener", 2);
        this.cZp = new AtomicInteger(0);
        this.cZq = new CopyOnWriteArrayList<>();
        this.cZn = new f();
        this.cZo = new g();
        this.cZr = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void eG(boolean z) {
        String ca = com.baidu.swan.apps.t.a.axb().ca(this.cZl.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + ca + ")  -> " + z);
        }
        if (z) {
            atA();
        } else {
            atC();
        }
    }

    public String toString() {
        return "Process<" + this.cZm + "> " + super.toString();
    }

    public void a(@Nullable String str, boolean z, b.C0421b c0421b) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a(arrayList, z, c0421b);
        }
    }

    public void a(@Nullable List<String> list, boolean z, b.C0421b c0421b) {
        if (list != null && !list.isEmpty()) {
            a(list, true, z, c0421b);
        }
    }

    public void a(@Nullable final List<String> list, final boolean z, boolean z2, final b.C0421b c0421b) {
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
            aE(list);
        }
        if (list != null && !list.isEmpty()) {
            rx.d.bX("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(String str) {
                    c.this.b(list, z, c0421b);
                }
            });
        }
    }

    @WorkerThread
    public void b(@Nullable List<String> list, boolean z, b.C0421b c0421b) {
        if (list == null) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                return;
            }
            return;
        }
        this.cZp.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.cZn.aC(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.f.a.lC(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.y(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.cZn.aD(list);
        for (String str : list) {
            if (this.cZq.contains(str)) {
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
                a(str, c0421b);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.cZn.ns(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.cZn.nt(str);
            }
        }
        if (this.cZp.decrementAndGet() <= 0) {
            this.cZp.set(0);
            this.cZq.clear();
        }
        com.baidu.swan.apps.env.c.c.a(c0421b).auo();
    }

    private void aE(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> auP = SwanFavorDataManager.auO().auP();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : auP) {
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

    public boolean atz() {
        return this.cZp.get() > 0;
    }

    public void a(@Nullable Set<String> set, b.C0421b c0421b) {
        if (this.cZr != null) {
            this.cZr.b(set, c0421b);
        }
    }

    public void nu(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cZq.add(str);
        }
    }

    private void atA() {
        d(atB());
    }

    private Set<String> atB() {
        return he(103);
    }

    private void d(Set<String> set) {
        com.baidu.swan.apps.t.a.axV().a("aiapp_setting_", set, true);
    }

    private void atC() {
        e(atD());
    }

    private Set<String> atD() {
        return he(100);
    }

    private void e(Set<String> set) {
        com.baidu.swan.apps.t.a.axV().a("aiapp_", set, true);
        String aLP = com.baidu.swan.apps.storage.b.aLP();
        if (!TextUtils.isEmpty(aLP)) {
            com.baidu.swan.c.d.deleteFile(aLP);
        }
        String aLQ = com.baidu.swan.apps.storage.b.aLQ();
        if (!TextUtils.isEmpty(aLQ)) {
            com.baidu.swan.c.d.deleteFile(aLQ);
        }
        com.baidu.swan.games.w.b.aYu();
        n.aWz();
    }

    private Set<String> he(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<com.baidu.swan.apps.process.messaging.service.c> aGp = com.baidu.swan.apps.process.messaging.service.e.aGn().aGp();
        if (aGp.size() < 1) {
            return hashSet;
        }
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = aGp.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aGa() && next.aFY()) {
                hashSet.add(next.getAppId());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + ")");
                }
                com.baidu.swan.apps.process.messaging.a.aFz().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.dtR));
            }
        }
        return hashSet;
    }

    private void a(String str, b.C0421b c0421b) {
        com.baidu.swan.apps.env.c.c.a(c0421b).nJ(str);
        this.cZn.nv(str);
        this.cZo.nv(str);
        com.baidu.swan.apps.core.pms.d.a.mS(str);
    }
}
