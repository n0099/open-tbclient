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
    private com.baidu.swan.apps.env.a.f cDA;
    private final a cDu;
    private final String cDv = ProcessUtils.getCurProcessName();
    private f cDw;
    private g cDx;
    private AtomicInteger cDy;
    private CopyOnWriteArrayList<String> cDz;

    /* loaded from: classes10.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.cDu = aVar;
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.t.a.ask().a(c.this);
            }
        }, "addLoginStatusChangedListener", 2);
        this.cDy = new AtomicInteger(0);
        this.cDz = new CopyOnWriteArrayList<>();
        this.cDw = new f();
        this.cDx = new g();
        this.cDA = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void dM(boolean z) {
        String bp = com.baidu.swan.apps.t.a.ask().bp(this.cDu.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + bp + ")  -> " + z);
        }
        if (z) {
            aoH();
        } else {
            aoJ();
        }
    }

    public String toString() {
        return "Process<" + this.cDv + "> " + super.toString();
    }

    public void a(@Nullable String str, boolean z, b.C0413b c0413b) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a(arrayList, z, c0413b);
        }
    }

    public void a(@Nullable List<String> list, boolean z, b.C0413b c0413b) {
        if (list != null && !list.isEmpty()) {
            a(list, true, z, c0413b);
        }
    }

    public void a(@Nullable final List<String> list, final boolean z, boolean z2, final b.C0413b c0413b) {
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
            al(list);
        }
        if (list != null && !list.isEmpty()) {
            rx.d.bZ("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(String str) {
                    c.this.b(list, z, c0413b);
                }
            });
        }
    }

    @WorkerThread
    public void b(@Nullable List<String> list, boolean z, b.C0413b c0413b) {
        if (list == null) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                return;
            }
            return;
        }
        this.cDy.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.cDw.aj(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.f.a.lt(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.q(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.cDw.ak(list);
        for (String str : list) {
            if (this.cDz.contains(str)) {
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
                a(str, c0413b);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.cDw.nk(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.cDw.nl(str);
            }
        }
        if (this.cDy.decrementAndGet() <= 0) {
            this.cDy.set(0);
            this.cDz.clear();
        }
        com.baidu.swan.apps.env.c.c.a(c0413b).apw();
    }

    private void al(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> apX = SwanFavorDataManager.apW().apX();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : apX) {
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

    public boolean aoG() {
        return this.cDy.get() > 0;
    }

    public void a(@Nullable Set<String> set, b.C0413b c0413b) {
        if (this.cDA != null) {
            this.cDA.b(set, c0413b);
        }
    }

    public void nm(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cDz.add(str);
        }
    }

    private void aoH() {
        d(aoI());
    }

    private Set<String> aoI() {
        return hX(103);
    }

    private void d(Set<String> set) {
        com.baidu.swan.apps.t.a.atf().a("aiapp_setting_", set, true);
    }

    private void aoJ() {
        e(aoK());
    }

    private Set<String> aoK() {
        return hX(100);
    }

    private void e(Set<String> set) {
        com.baidu.swan.apps.t.a.atf().a("aiapp_", set, true);
        String aGg = com.baidu.swan.apps.storage.b.aGg();
        if (!TextUtils.isEmpty(aGg)) {
            com.baidu.swan.c.d.deleteFile(aGg);
        }
        String aGh = com.baidu.swan.apps.storage.b.aGh();
        if (!TextUtils.isEmpty(aGh)) {
            com.baidu.swan.c.d.deleteFile(aGh);
        }
        com.baidu.swan.games.w.b.aSQ();
        n.aQV();
    }

    private Set<String> hX(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<com.baidu.swan.apps.process.messaging.service.c> aBA = com.baidu.swan.apps.process.messaging.service.e.aBy().aBA();
        if (aBA.size() < 1) {
            return hashSet;
        }
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = aBA.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aBl() && next.aBj()) {
                hashSet.add(next.getAppId());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + ")");
                }
                com.baidu.swan.apps.process.messaging.a.aAK().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.cXG));
            }
        }
        return hashSet;
    }

    private void a(String str, b.C0413b c0413b) {
        com.baidu.swan.apps.env.c.c.a(c0413b).nB(str);
        this.cDw.nn(str);
        this.cDx.nn(str);
        com.baidu.swan.apps.core.pms.d.a.mJ(str);
    }
}
