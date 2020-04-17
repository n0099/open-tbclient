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
    private final a bSe;
    private final String bSf = ProcessUtils.getCurProcessName();
    private f bSg;
    private g bSh;
    private AtomicInteger bSi;
    private CopyOnWriteArrayList<String> bSj;
    private com.baidu.swan.apps.env.a.f bSk;

    /* loaded from: classes11.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.bSe = aVar;
        com.baidu.swan.apps.w.a.abT().a(this);
        this.bSi = new AtomicInteger(0);
        this.bSj = new CopyOnWriteArrayList<>();
        this.bSg = new f();
        this.bSh = new g();
        this.bSk = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void cP(boolean z) {
        String bd = com.baidu.swan.apps.w.a.abT().bd(this.bSe.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + bd + ")  -> " + z);
        }
        if (z) {
            Zr();
        } else {
            Zt();
        }
    }

    public String toString() {
        return "Process<" + this.bSf + "> " + super.toString();
    }

    public void z(@Nullable String str, boolean z) {
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
            Y(list);
        }
        if (list != null && !list.isEmpty()) {
            rx.d.bK("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.1
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
        this.bSi.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.bSg.W(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.e.a.hv(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.r(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.bSg.X(list);
        for (String str : list) {
            if (this.bSj.contains(str)) {
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
                this.bSg.iV(str);
                this.bSh.iV(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.bSg.iS(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.bSg.iT(str);
            }
        }
        if (this.bSi.decrementAndGet() <= 0) {
            this.bSi.set(0);
            this.bSj.clear();
        }
    }

    private void Y(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> ZY = SwanFavorDataManager.ZX().ZY();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : ZY) {
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

    public boolean Zq() {
        return this.bSi.get() > 0;
    }

    public void d(@Nullable Set<String> set) {
        if (this.bSk != null) {
            this.bSk.g(set);
        }
    }

    public void iU(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bSj.add(str);
        }
    }

    private void Zr() {
        e(Zs());
    }

    private Set<String> Zs() {
        return eQ(103);
    }

    private void e(Set<String> set) {
        d.a("aiapp_setting_", set, true);
    }

    private void Zt() {
        f(Zu());
    }

    private Set<String> Zu() {
        return eQ(100);
    }

    private void f(Set<String> set) {
        d.a("aiapp_", set, true);
        String ano = com.baidu.swan.apps.storage.b.ano();
        if (!TextUtils.isEmpty(ano)) {
            com.baidu.swan.d.c.deleteFile(ano);
        }
        String anp = com.baidu.swan.apps.storage.b.anp();
        if (!TextUtils.isEmpty(anp)) {
            com.baidu.swan.d.c.deleteFile(anp);
        }
        com.baidu.swan.games.v.b.ayb();
        l.awl();
    }

    private Set<String> eQ(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<com.baidu.swan.apps.process.messaging.service.c> ajE = com.baidu.swan.apps.process.messaging.service.e.ajC().ajE();
        if (ajE.size() < 1) {
            return hashSet;
        }
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = ajE.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.ajt() && next.ajr()) {
                hashSet.add(next.getAppId());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + ")");
                }
                com.baidu.swan.apps.process.messaging.a.aiT().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.civ));
            }
        }
        return hashSet;
    }
}
