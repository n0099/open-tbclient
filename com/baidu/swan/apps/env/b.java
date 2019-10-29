package com.baidu.swan.apps.env;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class b implements com.baidu.swan.apps.a.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a aPC;
    private final String aPD = ProcessUtils.getCurProcessName();
    private e aPE;
    private f aPF;
    private AtomicInteger aPG;
    private CopyOnWriteArrayList<String> aPH;
    private com.baidu.swan.apps.env.a.f aPI;

    /* loaded from: classes2.dex */
    public interface a {
    }

    public b(a aVar) {
        this.aPC = aVar;
        com.baidu.swan.apps.u.a.Jn().a(this);
        this.aPG = new AtomicInteger(0);
        this.aPH = new CopyOnWriteArrayList<>();
        this.aPE = new e();
        this.aPF = new f();
        this.aPI = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    public String toString() {
        return "Process<" + this.aPD + "> " + super.toString();
    }

    public void s(@Nullable String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            g(arrayList, z);
        }
    }

    public void g(@Nullable List<String> list, boolean z) {
        if (list != null && !list.isEmpty()) {
            b(list, true, z);
        }
    }

    public void b(@Nullable final List<String> list, final boolean z, boolean z2) {
        if (DEBUG) {
            Log.d("SwanAppPurger", "deleteSwanApp");
        }
        if (z2) {
            Q(list);
        }
        if (list != null && !list.isEmpty()) {
            rx.d.bh("").a(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(String str) {
                    b.this.aPG.incrementAndGet();
                    if (z) {
                        if (b.DEBUG) {
                            Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
                        }
                        b.this.aPE.O(list);
                    }
                    if (b.DEBUG) {
                        Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
                    }
                    b.this.aPE.P(list);
                    for (String str2 : list) {
                        if (b.this.aPH.contains(str2)) {
                            if (b.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>删除忽略: " + str2);
                            }
                        } else {
                            if (b.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>删除小程序相关（小程序包、小程序分包）的APS记录: " + str2);
                            }
                            b.this.aPE.eK(str2);
                            if (b.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>删除小程序文件: " + str2);
                            }
                            b.this.aPE.fd(str2);
                            b.this.aPF.fd(str2);
                            if (b.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str2);
                            }
                            b.this.aPE.eY(str2);
                            if (b.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str2);
                            }
                            b.this.aPE.eX(str2);
                        }
                    }
                    if (b.this.aPG.decrementAndGet() <= 0) {
                        b.this.aPG.set(0);
                        b.this.aPH.clear();
                    }
                }
            });
        }
    }

    private void Q(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<com.baidu.swan.apps.database.a> Hw = com.baidu.swan.apps.database.favorite.a.Hw();
            HashMap hashMap = new HashMap();
            for (com.baidu.swan.apps.database.a aVar : Hw) {
                hashMap.put(aVar.appId, aVar);
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

    public boolean HM() {
        return this.aPG.get() > 0;
    }

    public void c(@Nullable Set<String> set) {
        if (this.aPI != null) {
            this.aPI.d(set);
        }
    }

    public void fc(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aPH.add(str);
        }
    }
}
