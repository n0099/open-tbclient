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
    private final a bSk;
    private final String bSl = ProcessUtils.getCurProcessName();
    private f bSm;
    private g bSn;
    private AtomicInteger bSo;
    private CopyOnWriteArrayList<String> bSp;
    private com.baidu.swan.apps.env.a.f bSq;

    /* loaded from: classes11.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.bSk = aVar;
        com.baidu.swan.apps.w.a.abS().a(this);
        this.bSo = new AtomicInteger(0);
        this.bSp = new CopyOnWriteArrayList<>();
        this.bSm = new f();
        this.bSn = new g();
        this.bSq = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void cP(boolean z) {
        String aR = com.baidu.swan.apps.w.a.abS().aR(this.bSk.requireContext());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + aR + ")  -> " + z);
        }
        if (z) {
            Zq();
        } else {
            Zs();
        }
    }

    public String toString() {
        return "Process<" + this.bSl + "> " + super.toString();
    }

    public void z(@Nullable String str, boolean z) {
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
            Y(list);
        }
        if (list != null && !list.isEmpty()) {
            rx.d.bL("").c(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.1
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
        this.bSo.incrementAndGet();
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
            }
            this.bSm.W(list);
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = com.baidu.swan.apps.e.a.hv(list.get(i));
            }
            com.baidu.swan.apps.database.subscribe.a.r(strArr);
        }
        if (DEBUG) {
            Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
        }
        this.bSm.X(list);
        for (String str : list) {
            if (this.bSp.contains(str)) {
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
                this.bSm.iV(str);
                this.bSn.iV(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                }
                this.bSm.iS(str);
                if (DEBUG) {
                    Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                }
                this.bSm.iT(str);
            }
        }
        if (this.bSo.decrementAndGet() <= 0) {
            this.bSo.set(0);
            this.bSp.clear();
        }
    }

    private void Y(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<SwanFavorItemData> ZX = SwanFavorDataManager.ZW().ZX();
            HashMap hashMap = new HashMap();
            for (SwanFavorItemData swanFavorItemData : ZX) {
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

    public boolean Zp() {
        return this.bSo.get() > 0;
    }

    public void d(@Nullable Set<String> set) {
        if (this.bSq != null) {
            this.bSq.g(set);
        }
    }

    public void iU(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bSp.add(str);
        }
    }

    private void Zq() {
        e(Zr());
    }

    private Set<String> Zr() {
        return eQ(103);
    }

    private void e(Set<String> set) {
        d.a("aiapp_setting_", set, true);
    }

    private void Zs() {
        f(Zt());
    }

    private Set<String> Zt() {
        return eQ(100);
    }

    private void f(Set<String> set) {
        d.a("aiapp_", set, true);
        String ann = com.baidu.swan.apps.storage.b.ann();
        if (!TextUtils.isEmpty(ann)) {
            com.baidu.swan.d.c.deleteFile(ann);
        }
        String ano = com.baidu.swan.apps.storage.b.ano();
        if (!TextUtils.isEmpty(ano)) {
            com.baidu.swan.d.c.deleteFile(ano);
        }
        com.baidu.swan.games.v.b.ayb();
        l.awl();
    }

    private Set<String> eQ(int i) {
        HashSet hashSet = new HashSet();
        LinkedHashSet<com.baidu.swan.apps.process.messaging.service.c> ajD = com.baidu.swan.apps.process.messaging.service.e.ajB().ajD();
        if (ajD.size() < 1) {
            return hashSet;
        }
        Iterator<com.baidu.swan.apps.process.messaging.service.c> it = ajD.iterator();
        while (it.hasNext()) {
            com.baidu.swan.apps.process.messaging.service.c next = it.next();
            if (next.ajs() && next.ajq()) {
                hashSet.add(next.getAppId());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active swan(" + next.getAppId() + ")");
                }
                com.baidu.swan.apps.process.messaging.a.aiS().a(new com.baidu.swan.apps.process.messaging.c(i).a(next.ciB));
            }
        }
        return hashSet;
    }
}
