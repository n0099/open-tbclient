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
/* loaded from: classes11.dex */
public class c implements com.baidu.swan.apps.a.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a btX;
    private final String btY = ProcessUtils.getCurProcessName();
    private f btZ;
    private g bua;
    private AtomicInteger bub;
    private CopyOnWriteArrayList<String> buc;
    private com.baidu.swan.apps.env.a.f bud;

    /* loaded from: classes11.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.btX = aVar;
        com.baidu.swan.apps.w.a.Ue().a(this);
        this.bub = new AtomicInteger(0);
        this.buc = new CopyOnWriteArrayList<>();
        this.btZ = new f();
        this.bua = new g();
        this.bud = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void bT(boolean z) {
        String bp = com.baidu.swan.apps.w.a.Ue().bp(this.btX.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + bp + ")  -> " + z);
        }
        if (z) {
            RC();
        } else {
            RE();
        }
    }

    public String toString() {
        return "Process<" + this.btY + "> " + super.toString();
    }

    public void u(@Nullable String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            h(arrayList, z);
        }
    }

    public void h(@Nullable List<String> list, boolean z) {
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
            rx.d.cb("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(String str) {
                    c.this.i(list, z);
                }
            });
        }
    }

    @WorkerThread
    public void i(@Nullable List<String> list, boolean z) {
        if (list == null) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                return;
            }
            return;
        }
        this.bub.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.btZ.O(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.e.a.gh(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.r(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.btZ.P(list);
        for (String str : list) {
            if (this.buc.contains(str)) {
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
                this.btZ.hH(str);
                this.bua.hH(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.btZ.hE(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.btZ.hF(str);
            }
        }
        if (this.bub.decrementAndGet() <= 0) {
            this.bub.set(0);
            this.buc.clear();
        }
    }

    private void Q(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> Sj = SwanFavorDataManager.Si().Sj();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : Sj) {
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

    public boolean RB() {
        return this.bub.get() > 0;
    }

    public void c(@Nullable Set<String> set) {
        if (this.bud != null) {
            this.bud.f(set);
        }
    }

    public void hG(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.buc.add(str);
        }
    }

    private void RC() {
        d(RD());
    }

    private Set<String> RD() {
        return eL(103);
    }

    private void d(Set<String> set) {
        d.a("aiapp_setting_", set, true);
    }

    private void RE() {
        e(RF());
    }

    private Set<String> RF() {
        return eL(100);
    }

    private void e(Set<String> set) {
        d.a("aiapp_", set, true);
        String afj = com.baidu.swan.apps.storage.b.afj();
        if (!TextUtils.isEmpty(afj)) {
            com.baidu.swan.d.c.deleteFile(afj);
        }
        String afk = com.baidu.swan.apps.storage.b.afk();
        if (!TextUtils.isEmpty(afk)) {
            com.baidu.swan.d.c.deleteFile(afk);
        }
        com.baidu.swan.games.v.b.apP();
        l.anY();
    }

    private Set<String> eL(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<com.baidu.swan.apps.process.messaging.service.c> abz = com.baidu.swan.apps.process.messaging.service.e.abx().abz();
        if (abz.size() < 1) {
            return hashSet;
        }
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = abz.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.abo() && next.abm()) {
                hashSet.add(next.getAppId());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + ")");
                }
                com.baidu.swan.apps.process.messaging.a.aaO().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.bJL));
            }
        }
        return hashSet;
    }
}
