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
/* loaded from: classes7.dex */
public class c implements com.baidu.swan.apps.a.c, com.baidu.swan.apps.env.c.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a cPZ;
    private final String cQa = ProcessUtils.getCurProcessName();
    private f cQb;
    private g cQc;
    private AtomicInteger cQd;
    private CopyOnWriteArrayList<String> cQe;
    private com.baidu.swan.apps.env.a.f cQf;

    /* loaded from: classes7.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.cPZ = aVar;
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.t.a.avX().a(c.this);
            }
        }, "addLoginStatusChangedListener", 2);
        this.cQd = new AtomicInteger(0);
        this.cQe = new CopyOnWriteArrayList<>();
        this.cQb = new f();
        this.cQc = new g();
        this.cQf = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void el(boolean z) {
        String bp = com.baidu.swan.apps.t.a.avX().bp(this.cPZ.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + bp + ")  -> " + z);
        }
        if (z) {
            asv();
        } else {
            asx();
        }
    }

    public String toString() {
        return "Process<" + this.cQa + "> " + super.toString();
    }

    public void a(@Nullable String str, boolean z, b.C0437b c0437b) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a(arrayList, z, c0437b);
        }
    }

    public void a(@Nullable List<String> list, boolean z, b.C0437b c0437b) {
        if (list != null && !list.isEmpty()) {
            a(list, true, z, c0437b);
        }
    }

    public void a(@Nullable final List<String> list, final boolean z, boolean z2, final b.C0437b c0437b) {
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
            aC(list);
        }
        if (list != null && !list.isEmpty()) {
            rx.d.ce("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(String str) {
                    c.this.b(list, z, c0437b);
                }
            });
        }
    }

    @WorkerThread
    public void b(@Nullable List<String> list, boolean z, b.C0437b c0437b) {
        if (list == null) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                return;
            }
            return;
        }
        this.cQd.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.cQb.aA(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.f.a.lV(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.r(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.cQb.aB(list);
        for (String str : list) {
            if (this.cQe.contains(str)) {
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
                a(str, c0437b);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.cQb.nL(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.cQb.nM(str);
            }
        }
        if (this.cQd.decrementAndGet() <= 0) {
            this.cQd.set(0);
            this.cQe.clear();
        }
        com.baidu.swan.apps.env.c.c.a(c0437b).atj();
    }

    private void aC(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> atK = SwanFavorDataManager.atJ().atK();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : atK) {
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

    public boolean asu() {
        return this.cQd.get() > 0;
    }

    public void a(@Nullable Set<String> set, b.C0437b c0437b) {
        if (this.cQf != null) {
            this.cQf.b(set, c0437b);
        }
    }

    public void nN(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cQe.add(str);
        }
    }

    private void asv() {
        d(asw());
    }

    private Set<String> asw() {
        return io(103);
    }

    private void d(Set<String> set) {
        com.baidu.swan.apps.t.a.awR().a("aiapp_setting_", set, true);
    }

    private void asx() {
        e(asy());
    }

    private Set<String> asy() {
        return io(100);
    }

    private void e(Set<String> set) {
        com.baidu.swan.apps.t.a.awR().a("aiapp_", set, true);
        String aJS = com.baidu.swan.apps.storage.b.aJS();
        if (!TextUtils.isEmpty(aJS)) {
            com.baidu.swan.c.d.deleteFile(aJS);
        }
        String aJT = com.baidu.swan.apps.storage.b.aJT();
        if (!TextUtils.isEmpty(aJT)) {
            com.baidu.swan.c.d.deleteFile(aJT);
        }
        com.baidu.swan.games.w.b.aWC();
        n.aUH();
    }

    private Set<String> io(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<com.baidu.swan.apps.process.messaging.service.c> aFm = com.baidu.swan.apps.process.messaging.service.e.aFk().aFm();
        if (aFm.size() < 1) {
            return hashSet;
        }
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = aFm.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aEX() && next.aEV()) {
                hashSet.add(next.getAppId());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + ")");
                }
                com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.dkv));
            }
        }
        return hashSet;
    }

    private void a(String str, b.C0437b c0437b) {
        com.baidu.swan.apps.env.c.c.a(c0437b).oc(str);
        this.cQb.nO(str);
        this.cQc.nO(str);
        com.baidu.swan.apps.core.pms.d.a.nl(str);
    }
}
