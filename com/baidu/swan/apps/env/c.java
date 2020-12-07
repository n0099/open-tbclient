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
/* loaded from: classes25.dex */
public class c implements com.baidu.swan.apps.a.c, com.baidu.swan.apps.env.c.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a cWS;
    private final String cWT = ProcessUtils.getCurProcessName();
    private f cWU;
    private g cWV;
    private AtomicInteger cWW;
    private CopyOnWriteArrayList<String> cWX;
    private com.baidu.swan.apps.env.a.f cWY;

    /* loaded from: classes25.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.cWS = aVar;
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.t.a.azf().a(c.this);
            }
        }, "addLoginStatusChangedListener", 2);
        this.cWW = new AtomicInteger(0);
        this.cWX = new CopyOnWriteArrayList<>();
        this.cWU = new f();
        this.cWV = new g();
        this.cWY = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void eA(boolean z) {
        String bV = com.baidu.swan.apps.t.a.azf().bV(this.cWS.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + bV + ")  -> " + z);
        }
        if (z) {
            avD();
        } else {
            avF();
        }
    }

    public String toString() {
        return "Process<" + this.cWT + "> " + super.toString();
    }

    public void a(@Nullable String str, boolean z, b.C0449b c0449b) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a(arrayList, z, c0449b);
        }
    }

    public void a(@Nullable List<String> list, boolean z, b.C0449b c0449b) {
        if (list != null && !list.isEmpty()) {
            a(list, true, z, c0449b);
        }
    }

    public void a(@Nullable final List<String> list, final boolean z, boolean z2, final b.C0449b c0449b) {
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
            aF(list);
        }
        if (list != null && !list.isEmpty()) {
            rx.d.bU("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(String str) {
                    c.this.b(list, z, c0449b);
                }
            });
        }
    }

    @WorkerThread
    public void b(@Nullable List<String> list, boolean z, b.C0449b c0449b) {
        if (list == null) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                return;
            }
            return;
        }
        this.cWW.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.cWU.aD(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.f.a.mC(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.r(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.cWU.aE(list);
        for (String str : list) {
            if (this.cWX.contains(str)) {
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
                a(str, c0449b);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.cWU.ou(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.cWU.ov(str);
            }
        }
        if (this.cWW.decrementAndGet() <= 0) {
            this.cWW.set(0);
            this.cWX.clear();
        }
        com.baidu.swan.apps.env.c.c.a(c0449b).awr();
    }

    private void aF(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> awS = SwanFavorDataManager.awR().awS();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : awS) {
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

    public boolean avC() {
        return this.cWW.get() > 0;
    }

    public void a(@Nullable Set<String> set, b.C0449b c0449b) {
        if (this.cWY != null) {
            this.cWY.b(set, c0449b);
        }
    }

    public void ow(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cWX.add(str);
        }
    }

    private void avD() {
        d(avE());
    }

    private Set<String> avE() {
        return iM(103);
    }

    private void d(Set<String> set) {
        com.baidu.swan.apps.t.a.azZ().a("aiapp_setting_", set, true);
    }

    private void avF() {
        e(avG());
    }

    private Set<String> avG() {
        return iM(100);
    }

    private void e(Set<String> set) {
        com.baidu.swan.apps.t.a.azZ().a("aiapp_", set, true);
        String aMZ = com.baidu.swan.apps.storage.b.aMZ();
        if (!TextUtils.isEmpty(aMZ)) {
            com.baidu.swan.c.d.deleteFile(aMZ);
        }
        String aNa = com.baidu.swan.apps.storage.b.aNa();
        if (!TextUtils.isEmpty(aNa)) {
            com.baidu.swan.c.d.deleteFile(aNa);
        }
        com.baidu.swan.games.w.b.aZH();
        n.aXM();
    }

    private Set<String> iM(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<com.baidu.swan.apps.process.messaging.service.c> aIu = com.baidu.swan.apps.process.messaging.service.e.aIs().aIu();
        if (aIu.size() < 1) {
            return hashSet;
        }
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = aIu.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aIf() && next.aId()) {
                hashSet.add(next.getAppId());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + ")");
                }
                com.baidu.swan.apps.process.messaging.a.aHE().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.drv));
            }
        }
        return hashSet;
    }

    private void a(String str, b.C0449b c0449b) {
        com.baidu.swan.apps.env.c.c.a(c0449b).oL(str);
        this.cWU.ox(str);
        this.cWV.ox(str);
        com.baidu.swan.apps.core.pms.d.a.nS(str);
    }
}
