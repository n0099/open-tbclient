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
    private final a cRJ;
    private final String cRK = ProcessUtils.getCurProcessName();
    private f cRL;
    private g cRM;
    private AtomicInteger cRN;
    private CopyOnWriteArrayList<String> cRO;
    private com.baidu.swan.apps.env.a.f cRP;

    /* loaded from: classes10.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.cRJ = aVar;
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.t.a.awF().a(c.this);
            }
        }, "addLoginStatusChangedListener", 2);
        this.cRN = new AtomicInteger(0);
        this.cRO = new CopyOnWriteArrayList<>();
        this.cRL = new f();
        this.cRM = new g();
        this.cRP = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void ei(boolean z) {
        String bp = com.baidu.swan.apps.t.a.awF().bp(this.cRJ.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + bp + ")  -> " + z);
        }
        if (z) {
            atd();
        } else {
            atf();
        }
    }

    public String toString() {
        return "Process<" + this.cRK + "> " + super.toString();
    }

    public void a(@Nullable String str, boolean z, b.C0439b c0439b) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            a(arrayList, z, c0439b);
        }
    }

    public void a(@Nullable List<String> list, boolean z, b.C0439b c0439b) {
        if (list != null && !list.isEmpty()) {
            a(list, true, z, c0439b);
        }
    }

    public void a(@Nullable final List<String> list, final boolean z, boolean z2, final b.C0439b c0439b) {
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
            rx.d.cd("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(String str) {
                    c.this.b(list, z, c0439b);
                }
            });
        }
    }

    @WorkerThread
    public void b(@Nullable List<String> list, boolean z, b.C0439b c0439b) {
        if (list == null) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                return;
            }
            return;
        }
        this.cRN.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.cRL.aA(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.f.a.mb(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.r(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.cRL.aB(list);
        for (String str : list) {
            if (this.cRO.contains(str)) {
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
                a(str, c0439b);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.cRL.nR(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.cRL.nS(str);
            }
        }
        if (this.cRN.decrementAndGet() <= 0) {
            this.cRN.set(0);
            this.cRO.clear();
        }
        com.baidu.swan.apps.env.c.c.a(c0439b).atR();
    }

    private void aC(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> aus = SwanFavorDataManager.aur().aus();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : aus) {
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

    public boolean atc() {
        return this.cRN.get() > 0;
    }

    public void a(@Nullable Set<String> set, b.C0439b c0439b) {
        if (this.cRP != null) {
            this.cRP.b(set, c0439b);
        }
    }

    public void nT(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cRO.add(str);
        }
    }

    private void atd() {
        d(ate());
    }

    private Set<String> ate() {
        return is(103);
    }

    private void d(Set<String> set) {
        com.baidu.swan.apps.t.a.axz().a("aiapp_setting_", set, true);
    }

    private void atf() {
        e(atg());
    }

    private Set<String> atg() {
        return is(100);
    }

    private void e(Set<String> set) {
        com.baidu.swan.apps.t.a.axz().a("aiapp_", set, true);
        String aKA = com.baidu.swan.apps.storage.b.aKA();
        if (!TextUtils.isEmpty(aKA)) {
            com.baidu.swan.c.d.deleteFile(aKA);
        }
        String aKB = com.baidu.swan.apps.storage.b.aKB();
        if (!TextUtils.isEmpty(aKB)) {
            com.baidu.swan.c.d.deleteFile(aKB);
        }
        com.baidu.swan.games.w.b.aXk();
        n.aVp();
    }

    private Set<String> is(int i) {
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
                com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.dmc));
            }
        }
        return hashSet;
    }

    private void a(String str, b.C0439b c0439b) {
        com.baidu.swan.apps.env.c.c.a(c0439b).oj(str);
        this.cRL.nU(str);
        this.cRM.nU(str);
        com.baidu.swan.apps.core.pms.d.a.nr(str);
    }
}
