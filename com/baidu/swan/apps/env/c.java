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
    private final a cgP;
    private final String cgQ = ProcessUtils.getCurProcessName();
    private f cgR;
    private g cgS;
    private AtomicInteger cgT;
    private CopyOnWriteArrayList<String> cgU;
    private com.baidu.swan.apps.env.a.f cgV;

    /* loaded from: classes11.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.cgP = aVar;
        com.baidu.swan.apps.u.a.agc().a(this);
        this.cgT = new AtomicInteger(0);
        this.cgU = new CopyOnWriteArrayList<>();
        this.cgR = new f();
        this.cgS = new g();
        this.cgV = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void dg(boolean z) {
        String bc = com.baidu.swan.apps.u.a.agc().bc(this.cgP.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + bc + ")  -> " + z);
        }
        if (z) {
            adx();
        } else {
            adz();
        }
    }

    public String toString() {
        return "Process<" + this.cgQ + "> " + super.toString();
    }

    public void L(@Nullable String str, boolean z) {
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
            ad(list);
        }
        if (list != null && !list.isEmpty()) {
            rx.d.bS("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.1
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
        this.cgT.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.cgR.ab(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.e.a.iD(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.p(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.cgR.ac(list);
        for (String str : list) {
            if (this.cgU.contains(str)) {
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
                this.cgR.kk(str);
                this.cgS.kk(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.cgR.kh(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.cgR.ki(str);
            }
        }
        if (this.cgT.decrementAndGet() <= 0) {
            this.cgT.set(0);
            this.cgU.clear();
        }
    }

    private void ad(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> aed = SwanFavorDataManager.aec().aed();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : aed) {
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

    public boolean adw() {
        return this.cgT.get() > 0;
    }

    public void d(@Nullable Set<String> set) {
        if (this.cgV != null) {
            this.cgV.g(set);
        }
    }

    public void kj(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cgU.add(str);
        }
    }

    private void adx() {
        e(ady());
    }

    private Set<String> ady() {
        return fo(103);
    }

    private void e(Set<String> set) {
        com.baidu.swan.apps.u.a.agU().a("aiapp_setting_", set, true);
    }

    private void adz() {
        f(adA());
    }

    private Set<String> adA() {
        return fo(100);
    }

    private void f(Set<String> set) {
        com.baidu.swan.apps.u.a.agU().a("aiapp_", set, true);
        String asD = com.baidu.swan.apps.storage.b.asD();
        if (!TextUtils.isEmpty(asD)) {
            com.baidu.swan.e.d.deleteFile(asD);
        }
        String asE = com.baidu.swan.apps.storage.b.asE();
        if (!TextUtils.isEmpty(asE)) {
            com.baidu.swan.e.d.deleteFile(asE);
        }
        com.baidu.swan.games.w.b.aCY();
        n.aBi();
    }

    private Set<String> fo(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<com.baidu.swan.apps.process.messaging.service.c> aox = com.baidu.swan.apps.process.messaging.service.e.aov().aox();
        if (aox.size() < 1) {
            return hashSet;
        }
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = aox.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aom() && next.aok()) {
                hashSet.add(next.getAppId());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + ")");
                }
                com.baidu.swan.apps.process.messaging.a.anM().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.cyQ));
            }
        }
        return hashSet;
    }
}
