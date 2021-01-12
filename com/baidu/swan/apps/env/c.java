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
    private final a cWZ;
    private final String cXa = ProcessUtils.getCurProcessName();
    private f cXb;
    private g cXc;
    private AtomicInteger cXd;
    private CopyOnWriteArrayList<String> cXe;
    private com.baidu.swan.apps.env.a.f cXf;

    /* loaded from: classes8.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.cWZ = aVar;
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.t.a.awD().a(c.this);
            }
        }, "addLoginStatusChangedListener", 2);
        this.cXd = new AtomicInteger(0);
        this.cXe = new CopyOnWriteArrayList<>();
        this.cXb = new f();
        this.cXc = new g();
        this.cXf = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void eE(boolean z) {
        String cb = com.baidu.swan.apps.t.a.awD().cb(this.cWZ.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + cb + ")  -> " + z);
        }
        if (z) {
            atc();
        } else {
            ate();
        }
    }

    public String toString() {
        return "Process<" + this.cXa + "> " + super.toString();
    }

    public void a(@Nullable String str, boolean z, b.C0424b c0424b) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a(arrayList, z, c0424b);
        }
    }

    public void a(@Nullable List<String> list, boolean z, b.C0424b c0424b) {
        if (list != null && !list.isEmpty()) {
            a(list, true, z, c0424b);
        }
    }

    public void a(@Nullable final List<String> list, final boolean z, boolean z2, final b.C0424b c0424b) {
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
                    c.this.b(list, z, c0424b);
                }
            });
        }
    }

    @WorkerThread
    public void b(@Nullable List<String> list, boolean z, b.C0424b c0424b) {
        if (list == null) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                return;
            }
            return;
        }
        this.cXd.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.cXb.aH(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.f.a.lk(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.y(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.cXb.aI(list);
        for (String str : list) {
            if (this.cXe.contains(str)) {
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
                a(str, c0424b);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.cXb.na(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.cXb.nb(str);
            }
        }
        if (this.cXd.decrementAndGet() <= 0) {
            this.cXd.set(0);
            this.cXe.clear();
        }
        com.baidu.swan.apps.env.c.c.a(c0424b).atQ();
    }

    private void aJ(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> aur = SwanFavorDataManager.auq().aur();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : aur) {
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

    public boolean atb() {
        return this.cXd.get() > 0;
    }

    public void a(@Nullable Set<String> set, b.C0424b c0424b) {
        if (this.cXf != null) {
            this.cXf.b(set, c0424b);
        }
    }

    public void nc(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cXe.add(str);
        }
    }

    private void atc() {
        d(atd());
    }

    private Set<String> atd() {
        return hb(103);
    }

    private void d(Set<String> set) {
        com.baidu.swan.apps.t.a.axx().a("aiapp_setting_", set, true);
    }

    private void ate() {
        e(atf());
    }

    private Set<String> atf() {
        return hb(100);
    }

    private void e(Set<String> set) {
        com.baidu.swan.apps.t.a.axx().a("aiapp_", set, true);
        String aLw = com.baidu.swan.apps.storage.b.aLw();
        if (!TextUtils.isEmpty(aLw)) {
            com.baidu.swan.c.d.deleteFile(aLw);
        }
        String aLx = com.baidu.swan.apps.storage.b.aLx();
        if (!TextUtils.isEmpty(aLx)) {
            com.baidu.swan.c.d.deleteFile(aLx);
        }
        com.baidu.swan.games.w.b.aYi();
        n.aWn();
    }

    private Set<String> hb(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<com.baidu.swan.apps.process.messaging.service.c> aFU = com.baidu.swan.apps.process.messaging.service.e.aFS().aFU();
        if (aFU.size() < 1) {
            return hashSet;
        }
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = aFU.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.aFF() && next.aFD()) {
                hashSet.add(next.getAppId());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + ")");
                }
                com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.drF));
            }
        }
        return hashSet;
    }

    private void a(String str, b.C0424b c0424b) {
        com.baidu.swan.apps.env.c.c.a(c0424b).nr(str);
        this.cXb.nd(str);
        this.cXc.nd(str);
        com.baidu.swan.apps.core.pms.d.a.mA(str);
    }
}
