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
/* loaded from: classes3.dex */
public class c implements com.baidu.swan.apps.a.c, com.baidu.swan.apps.env.c.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a cri;
    private final String crj = ProcessUtils.getCurProcessName();
    private f crk;
    private g crl;
    private AtomicInteger crm;
    private CopyOnWriteArrayList<String> crn;
    private com.baidu.swan.apps.env.a.f cro;

    /* loaded from: classes3.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.cri = aVar;
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.t.a.apz().a(c.this);
            }
        }, "addLoginStatusChangedListener", 2);
        this.crm = new AtomicInteger(0);
        this.crn = new CopyOnWriteArrayList<>();
        this.crk = new f();
        this.crl = new g();
        this.cro = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void dq(boolean z) {
        String bj = com.baidu.swan.apps.t.a.apz().bj(this.cri.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + bj + ")  -> " + z);
        }
        if (z) {
            alW();
        } else {
            alY();
        }
    }

    public String toString() {
        return "Process<" + this.crj + "> " + super.toString();
    }

    public void a(@Nullable String str, boolean z, b.C0396b c0396b) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a(arrayList, z, c0396b);
        }
    }

    public void a(@Nullable List<String> list, boolean z, b.C0396b c0396b) {
        if (list != null && !list.isEmpty()) {
            a(list, true, z, c0396b);
        }
    }

    public void a(@Nullable final List<String> list, final boolean z, boolean z2, final b.C0396b c0396b) {
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
            ai(list);
        }
        if (list != null && !list.isEmpty()) {
            rx.d.bW("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(String str) {
                    c.this.b(list, z, c0396b);
                }
            });
        }
    }

    @WorkerThread
    public void b(@Nullable List<String> list, boolean z, b.C0396b c0396b) {
        if (list == null) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                return;
            }
            return;
        }
        this.crm.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.crk.ag(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.f.a.kH(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.p(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.crk.ah(list);
        for (String str : list) {
            if (this.crn.contains(str)) {
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
                a(str, c0396b);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.crk.my(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.crk.mz(str);
            }
        }
        if (this.crm.decrementAndGet() <= 0) {
            this.crm.set(0);
            this.crn.clear();
        }
        com.baidu.swan.apps.env.c.c.a(c0396b).amK();
    }

    private void ai(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> anl = SwanFavorDataManager.ank().anl();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : anl) {
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

    public boolean alV() {
        return this.crm.get() > 0;
    }

    public void a(@Nullable Set<String> set, b.C0396b c0396b) {
        if (this.cro != null) {
            this.cro.b(set, c0396b);
        }
    }

    public void mA(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.crn.add(str);
        }
    }

    private void alW() {
        d(alX());
    }

    private Set<String> alX() {
        return hA(103);
    }

    private void d(Set<String> set) {
        com.baidu.swan.apps.t.a.aqt().a("aiapp_setting_", set, true);
    }

    private void alY() {
        e(alZ());
    }

    private Set<String> alZ() {
        return hA(100);
    }

    private void e(Set<String> set) {
        com.baidu.swan.apps.t.a.aqt().a("aiapp_", set, true);
        String aDx = com.baidu.swan.apps.storage.b.aDx();
        if (!TextUtils.isEmpty(aDx)) {
            com.baidu.swan.c.d.deleteFile(aDx);
        }
        String aDy = com.baidu.swan.apps.storage.b.aDy();
        if (!TextUtils.isEmpty(aDy)) {
            com.baidu.swan.c.d.deleteFile(aDy);
        }
        com.baidu.swan.games.w.b.aQh();
        n.aOm();
    }

    private Set<String> hA(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<com.baidu.swan.apps.process.messaging.service.c> ayR = com.baidu.swan.apps.process.messaging.service.e.ayP().ayR();
        if (ayR.size() < 1) {
            return hashSet;
        }
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = ayR.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.ayC() && next.ayA()) {
                hashSet.add(next.getAppId());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + ")");
                }
                com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.cLD));
            }
        }
        return hashSet;
    }

    private void a(String str, b.C0396b c0396b) {
        com.baidu.swan.apps.env.c.c.a(c0396b).mP(str);
        this.crk.mB(str);
        this.crl.mB(str);
        com.baidu.swan.apps.core.pms.d.a.lX(str);
    }
}
