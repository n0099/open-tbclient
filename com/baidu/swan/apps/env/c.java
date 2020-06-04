package com.baidu.swan.apps.env;

import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
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
/* loaded from: classes11.dex */
public class c implements com.baidu.swan.apps.a.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a cca;
    private final String ccb = ProcessUtils.getCurProcessName();
    private f ccc;
    private g ccd;
    private AtomicInteger cce;
    private CopyOnWriteArrayList<String> ccf;
    private com.baidu.swan.apps.env.a.f ccg;

    /* loaded from: classes11.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.cca = aVar;
        com.baidu.swan.apps.u.a.aeW().a(this);
        this.cce = new AtomicInteger(0);
        this.ccf = new CopyOnWriteArrayList<>();
        this.ccc = new f();
        this.ccd = new g();
        this.ccg = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void db(boolean z) {
        String bb = com.baidu.swan.apps.u.a.aeW().bb(this.cca.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + bb + ")  -> " + z);
        }
        if (z) {
            acr();
        } else {
            act();
        }
    }

    public String toString() {
        return "Process<" + this.ccb + "> " + super.toString();
    }

    public void J(@Nullable String str, boolean z) {
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
            Z(list);
        }
        if (list != null && !list.isEmpty()) {
            rx.d.bR("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.1
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
        this.cce.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.ccc.X(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.e.a.iv(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.q(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.ccc.Y(list);
        for (String str : list) {
            if (this.ccf.contains(str)) {
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
                this.ccc.kc(str);
                this.ccd.kc(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.ccc.jZ(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.ccc.ka(str);
            }
        }
        if (this.cce.decrementAndGet() <= 0) {
            this.cce.set(0);
            this.ccf.clear();
        }
    }

    private void Z(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> acX = SwanFavorDataManager.acW().acX();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : acX) {
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

    public boolean acq() {
        return this.cce.get() > 0;
    }

    public void d(@Nullable Set<String> set) {
        if (this.ccg != null) {
            this.ccg.g(set);
        }
    }

    public void kb(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ccf.add(str);
        }
    }

    private void acr() {
        e(acs());
    }

    private Set<String> acs() {
        return fd(103);
    }

    private void e(Set<String> set) {
        com.baidu.swan.apps.u.a.afO().a("aiapp_setting_", set, true);
    }

    private void act() {
        f(acu());
    }

    private Set<String> acu() {
        return fd(100);
    }

    private void f(Set<String> set) {
        com.baidu.swan.apps.u.a.afO().a("aiapp_", set, true);
        String arw = com.baidu.swan.apps.storage.b.arw();
        if (!TextUtils.isEmpty(arw)) {
            com.baidu.swan.e.d.deleteFile(arw);
        }
        String arx = com.baidu.swan.apps.storage.b.arx();
        if (!TextUtils.isEmpty(arx)) {
            com.baidu.swan.e.d.deleteFile(arx);
        }
        com.baidu.swan.games.w.b.aBS();
        n.aAc();
    }

    private Set<String> fd(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<com.baidu.swan.apps.process.messaging.service.c> anr = com.baidu.swan.apps.process.messaging.service.e.anp().anr();
        if (anr.size() < 1) {
            return hashSet;
        }
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = anr.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.ang() && next.ane()) {
                hashSet.add(next.getAppId());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + ")");
                }
                com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.cud));
            }
        }
        return hashSet;
    }
}
