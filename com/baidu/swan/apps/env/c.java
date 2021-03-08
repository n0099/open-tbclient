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
/* loaded from: classes8.dex */
public class c implements com.baidu.swan.apps.a.c, com.baidu.swan.apps.env.c.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a daN;
    private final String daO = ProcessUtils.getCurProcessName();
    private f daP;
    private g daQ;
    private AtomicInteger daR;
    private CopyOnWriteArrayList<String> daS;
    private com.baidu.swan.apps.env.a.f daT;

    /* loaded from: classes8.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.daN = aVar;
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.t.a.axe().a(c.this);
            }
        }, "addLoginStatusChangedListener", 2);
        this.daR = new AtomicInteger(0);
        this.daS = new CopyOnWriteArrayList<>();
        this.daP = new f();
        this.daQ = new g();
        this.daT = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void eG(boolean z) {
        String bZ = com.baidu.swan.apps.t.a.axe().bZ(this.daN.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + bZ + ")  -> " + z);
        }
        if (z) {
            atD();
        } else {
            atF();
        }
    }

    public String toString() {
        return "Process<" + this.daO + "> " + super.toString();
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
            aE(list);
        }
        if (list != null && !list.isEmpty()) {
            rx.d.bY("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.2
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
        this.daR.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.daP.aC(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.f.a.lJ(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.y(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.daP.aD(list);
        for (String str : list) {
            if (this.daS.contains(str)) {
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
                this.daP.nz(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.daP.nA(str);
            }
        }
        if (this.daR.decrementAndGet() <= 0) {
            this.daR.set(0);
            this.daS.clear();
        }
        com.baidu.swan.apps.env.c.c.a(c0427b).aur();
    }

    private void aE(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> auS = SwanFavorDataManager.auR().auS();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : auS) {
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

    public boolean atC() {
        return this.daR.get() > 0;
    }

    public void a(@Nullable Set<String> set, b.C0427b c0427b) {
        if (this.daT != null) {
            this.daT.b(set, c0427b);
        }
    }

    public void nB(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.daS.add(str);
        }
    }

    private void atD() {
        d(atE());
    }

    private Set<String> atE() {
        return hf(103);
    }

    private void d(Set<String> set) {
        com.baidu.swan.apps.t.a.axY().a("aiapp_setting_", set, true);
    }

    private void atF() {
        e(atG());
    }

    private Set<String> atG() {
        return hf(100);
    }

    private void e(Set<String> set) {
        com.baidu.swan.apps.t.a.axY().a("aiapp_", set, true);
        String aLS = com.baidu.swan.apps.storage.b.aLS();
        if (!TextUtils.isEmpty(aLS)) {
            com.baidu.swan.c.d.deleteFile(aLS);
        }
        String aLT = com.baidu.swan.apps.storage.b.aLT();
        if (!TextUtils.isEmpty(aLT)) {
            com.baidu.swan.c.d.deleteFile(aLT);
        }
        com.baidu.swan.games.w.b.aYx();
        n.aWC();
    }

    private Set<String> hf(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<com.baidu.swan.apps.process.messaging.service.c> aGs = com.baidu.swan.apps.process.messaging.service.e.aGq().aGs();
        if (aGs.size() < 1) {
            return hashSet;
        }
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = aGs.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aGd() && next.aGb()) {
                hashSet.add(next.getAppId());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + ")");
                }
                com.baidu.swan.apps.process.messaging.a.aFC().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.dvs));
            }
        }
        return hashSet;
    }

    private void a(String str, b.C0427b c0427b) {
        com.baidu.swan.apps.env.c.c.a(c0427b).nQ(str);
        this.daP.nC(str);
        this.daQ.nC(str);
        com.baidu.swan.apps.core.pms.d.a.mZ(str);
    }
}
