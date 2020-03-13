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
    private final a btL;
    private final String btM = ProcessUtils.getCurProcessName();
    private f btN;
    private g btO;
    private AtomicInteger btP;
    private CopyOnWriteArrayList<String> btQ;
    private com.baidu.swan.apps.env.a.f btR;

    /* loaded from: classes11.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.btL = aVar;
        com.baidu.swan.apps.w.a.Ub().a(this);
        this.btP = new AtomicInteger(0);
        this.btQ = new CopyOnWriteArrayList<>();
        this.btN = new f();
        this.btO = new g();
        this.btR = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void bS(boolean z) {
        String bq = com.baidu.swan.apps.w.a.Ub().bq(this.btL.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + bq + ")  -> " + z);
        }
        if (z) {
            Rz();
        } else {
            RB();
        }
    }

    public String toString() {
        return "Process<" + this.btM + "> " + super.toString();
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
        this.btP.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.btN.O(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.e.a.gi(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.r(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.btN.P(list);
        for (String str : list) {
            if (this.btQ.contains(str)) {
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
                this.btN.hI(str);
                this.btO.hI(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.btN.hF(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.btN.hG(str);
            }
        }
        if (this.btP.decrementAndGet() <= 0) {
            this.btP.set(0);
            this.btQ.clear();
        }
    }

    private void Q(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> Sg = SwanFavorDataManager.Sf().Sg();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : Sg) {
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

    public boolean Ry() {
        return this.btP.get() > 0;
    }

    public void c(@Nullable Set<String> set) {
        if (this.btR != null) {
            this.btR.f(set);
        }
    }

    public void hH(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.btQ.add(str);
        }
    }

    private void Rz() {
        d(RA());
    }

    private Set<String> RA() {
        return eL(103);
    }

    private void d(Set<String> set) {
        d.a("aiapp_setting_", set, true);
    }

    private void RB() {
        e(RC());
    }

    private Set<String> RC() {
        return eL(100);
    }

    private void e(Set<String> set) {
        d.a("aiapp_", set, true);
        String afg = com.baidu.swan.apps.storage.b.afg();
        if (!TextUtils.isEmpty(afg)) {
            com.baidu.swan.d.c.deleteFile(afg);
        }
        String afh = com.baidu.swan.apps.storage.b.afh();
        if (!TextUtils.isEmpty(afh)) {
            com.baidu.swan.d.c.deleteFile(afh);
        }
        com.baidu.swan.games.v.b.apM();
        l.anV();
    }

    private Set<String> eL(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<com.baidu.swan.apps.process.messaging.service.c> abw = com.baidu.swan.apps.process.messaging.service.e.abu().abw();
        if (abw.size() < 1) {
            return hashSet;
        }
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = abw.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.abl() && next.abj()) {
                hashSet.add(next.getAppId());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + ")");
                }
                com.baidu.swan.apps.process.messaging.a.aaL().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.bJA));
            }
        }
        return hashSet;
    }
}
