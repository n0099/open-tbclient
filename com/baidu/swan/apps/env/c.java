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
/* loaded from: classes9.dex */
public class c implements com.baidu.swan.apps.a.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a boM;
    private final String boN = ProcessUtils.getCurProcessName();
    private f boO;
    private g boP;
    private AtomicInteger boQ;
    private CopyOnWriteArrayList<String> boR;
    private com.baidu.swan.apps.env.a.f boS;

    /* loaded from: classes9.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.boM = aVar;
        com.baidu.swan.apps.w.a.Rp().a(this);
        this.boQ = new AtomicInteger(0);
        this.boR = new CopyOnWriteArrayList<>();
        this.boO = new f();
        this.boP = new g();
        this.boS = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void bF(boolean z) {
        String bm = com.baidu.swan.apps.w.a.Rp().bm(this.boM.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + bm + ")  -> " + z);
        }
        if (z) {
            ON();
        } else {
            OP();
        }
    }

    public String toString() {
        return "Process<" + this.boN + "> " + super.toString();
    }

    public void u(@Nullable String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            f(arrayList, z);
        }
    }

    public void f(@Nullable List<String> list, boolean z) {
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
            R(list);
        }
        if (list != null && !list.isEmpty()) {
            rx.d.bS("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(String str) {
                    c.this.g(list, z);
                }
            });
        }
    }

    @WorkerThread
    public void g(@Nullable List<String> list, boolean z) {
        if (list == null) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                return;
            }
            return;
        }
        this.boQ.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.boO.P(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.e.a.fQ(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.n(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.boO.Q(list);
        for (String str : list) {
            if (this.boR.contains(str)) {
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
                this.boO.hq(str);
                this.boP.hq(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.boO.hn(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.boO.ho(str);
            }
        }
        if (this.boQ.decrementAndGet() <= 0) {
            this.boQ.set(0);
            this.boR.clear();
        }
    }

    private void R(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> Pu = SwanFavorDataManager.Pt().Pu();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : Pu) {
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

    public boolean OM() {
        return this.boQ.get() > 0;
    }

    public void c(@Nullable Set<String> set) {
        if (this.boS != null) {
            this.boS.f(set);
        }
    }

    public void hp(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.boR.add(str);
        }
    }

    private void ON() {
        d(OO());
    }

    private Set<String> OO() {
        return eu(103);
    }

    private void d(Set<String> set) {
        d.a("aiapp_setting_", set, true);
    }

    private void OP() {
        e(OQ());
    }

    private Set<String> OQ() {
        return eu(100);
    }

    private void e(Set<String> set) {
        d.a("aiapp_", set, true);
        String act = com.baidu.swan.apps.storage.b.act();
        if (!TextUtils.isEmpty(act)) {
            com.baidu.swan.d.c.deleteFile(act);
        }
        String acu = com.baidu.swan.apps.storage.b.acu();
        if (!TextUtils.isEmpty(acu)) {
            com.baidu.swan.d.c.deleteFile(acu);
        }
        com.baidu.swan.games.v.b.and();
        l.aln();
    }

    private Set<String> eu(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<com.baidu.swan.apps.process.messaging.service.c> YJ = com.baidu.swan.apps.process.messaging.service.e.YH().YJ();
        if (YJ.size() < 1) {
            return hashSet;
        }
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = YJ.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.Yy() && next.Yw()) {
                hashSet.add(next.getAppId());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + ")");
                }
                com.baidu.swan.apps.process.messaging.a.XY().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.bEI));
            }
        }
        return hashSet;
    }
}
