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
    private final a dbN;
    private final String dbO = ProcessUtils.getCurProcessName();
    private f dbP;
    private g dbQ;
    private AtomicInteger dbR;
    private CopyOnWriteArrayList<String> dbS;
    private com.baidu.swan.apps.env.a.f dbT;

    /* loaded from: classes9.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.dbN = aVar;
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.t.a.aAx().a(c.this);
            }
        }, "addLoginStatusChangedListener", 2);
        this.dbR = new AtomicInteger(0);
        this.dbS = new CopyOnWriteArrayList<>();
        this.dbP = new f();
        this.dbQ = new g();
        this.dbT = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void eI(boolean z) {
        String cc = com.baidu.swan.apps.t.a.aAx().cc(this.dbN.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + cc + ")  -> " + z);
        }
        if (z) {
            awW();
        } else {
            awY();
        }
    }

    public String toString() {
        return "Process<" + this.dbO + "> " + super.toString();
    }

    public void a(@Nullable String str, boolean z, b.C0441b c0441b) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a(arrayList, z, c0441b);
        }
    }

    public void a(@Nullable List<String> list, boolean z, b.C0441b c0441b) {
        if (list != null && !list.isEmpty()) {
            a(list, true, z, c0441b);
        }
    }

    public void a(@Nullable final List<String> list, final boolean z, boolean z2, final b.C0441b c0441b) {
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
            aJ(list);
        }
        if (list != null && !list.isEmpty()) {
            rx.d.bX("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(String str) {
                    c.this.b(list, z, c0441b);
                }
            });
        }
    }

    @WorkerThread
    public void b(@Nullable List<String> list, boolean z, b.C0441b c0441b) {
        if (list == null) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                return;
            }
            return;
        }
        this.dbR.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.dbP.aH(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.f.a.mv(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.y(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.dbP.aI(list);
        for (String str : list) {
            if (this.dbS.contains(str)) {
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
                a(str, c0441b);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.dbP.om(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.dbP.oo(str);
            }
        }
        if (this.dbR.decrementAndGet() <= 0) {
            this.dbR.set(0);
            this.dbS.clear();
        }
        com.baidu.swan.apps.env.c.c.a(c0441b).axK();
    }

    private void aJ(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> ayl = SwanFavorDataManager.ayk().ayl();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : ayl) {
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

    public boolean awV() {
        return this.dbR.get() > 0;
    }

    public void a(@Nullable Set<String> set, b.C0441b c0441b) {
        if (this.dbT != null) {
            this.dbT.b(set, c0441b);
        }
    }

    public void op(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dbS.add(str);
        }
    }

    private void awW() {
        d(awX());
    }

    private Set<String> awX() {
        return iH(103);
    }

    private void d(Set<String> set) {
        com.baidu.swan.apps.t.a.aBr().a("aiapp_setting_", set, true);
    }

    private void awY() {
        e(awZ());
    }

    private Set<String> awZ() {
        return iH(100);
    }

    private void e(Set<String> set) {
        com.baidu.swan.apps.t.a.aBr().a("aiapp_", set, true);
        String aPq = com.baidu.swan.apps.storage.b.aPq();
        if (!TextUtils.isEmpty(aPq)) {
            com.baidu.swan.c.d.deleteFile(aPq);
        }
        String aPr = com.baidu.swan.apps.storage.b.aPr();
        if (!TextUtils.isEmpty(aPr)) {
            com.baidu.swan.c.d.deleteFile(aPr);
        }
        com.baidu.swan.games.w.b.bcc();
        n.bah();
    }

    private Set<String> iH(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<com.baidu.swan.apps.process.messaging.service.c> aJO = com.baidu.swan.apps.process.messaging.service.e.aJM().aJO();
        if (aJO.size() < 1) {
            return hashSet;
        }
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = aJO.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aJz() && next.aJx()) {
                hashSet.add(next.getAppId());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + ")");
                }
                com.baidu.swan.apps.process.messaging.a.aIY().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.dwt));
            }
        }
        return hashSet;
    }

    private void a(String str, b.C0441b c0441b) {
        com.baidu.swan.apps.env.c.c.a(c0441b).oE(str);
        this.dbP.oq(str);
        this.dbQ.oq(str);
        com.baidu.swan.apps.core.pms.d.a.nL(str);
    }
}
