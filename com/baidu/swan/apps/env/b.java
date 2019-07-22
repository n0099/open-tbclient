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
    private final a avP;
    private final String avQ = ProcessUtils.getCurProcessName();
    private e avR;
    private f avS;
    private AtomicInteger avT;
    private CopyOnWriteArrayList<String> avU;
    private com.baidu.swan.apps.env.a.f avV;

    /* loaded from: classes2.dex */
    public interface a {
    }

    public b(a aVar) {
        this.avP = aVar;
        com.baidu.swan.apps.u.a.Ep().a(this);
        this.avT = new AtomicInteger(0);
        this.avU = new CopyOnWriteArrayList<>();
        this.avR = new e();
        this.avS = new f();
        this.avV = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    public String toString() {
        return "Process<" + this.avQ + "> " + super.toString();
    }

    public void p(@Nullable String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            d(arrayList, z);
        }
    }

    public void d(@Nullable List<String> list, boolean z) {
        if (list != null && !list.isEmpty()) {
            a(list, true, z);
        }
    }

    public void a(@Nullable final List<String> list, final boolean z, boolean z2) {
        if (DEBUG) {
            Log.d("SwanAppPurger", "deleteSwanApp");
        }
        if (z2) {
            r(list);
        }
        if (list != null && !list.isEmpty()) {
            rx.d.bm("").a(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(String str) {
                    b.this.avT.incrementAndGet();
                    if (z) {
                        if (b.DEBUG) {
                            Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
                        }
                        b.this.avR.p(list);
                    }
                    if (b.DEBUG) {
                        Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
                    }
                    b.this.avR.q(list);
                    for (String str2 : list) {
                        if (b.this.avU.contains(str2)) {
                            if (b.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>删除忽略: " + str2);
                            }
                        } else {
                            if (b.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>删除小程序相关（小程序包、小程序分包）的APS记录: " + str2);
                            }
                            b.this.avR.eb(str2);
                            if (b.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>删除小程序文件: " + str2);
                            }
                            b.this.avR.eu(str2);
                            b.this.avS.eu(str2);
                            if (b.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str2);
                            }
                            b.this.avR.ep(str2);
                            if (b.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str2);
                            }
                            b.this.avR.eo(str2);
                        }
                    }
                    if (b.this.avT.decrementAndGet() <= 0) {
                        b.this.avT.set(0);
                        b.this.avU.clear();
                    }
                }
            });
        }
    }

    private void r(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<com.baidu.swan.apps.database.a> Cy = com.baidu.swan.apps.database.favorite.a.Cy();
            HashMap hashMap = new HashMap();
            for (com.baidu.swan.apps.database.a aVar : Cy) {
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

    public boolean CO() {
        return this.avT.get() > 0;
    }

    public void c(@Nullable Set<String> set) {
        if (this.avV != null) {
            this.avV.d(set);
        }
    }

    public void et(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.avU.add(str);
        }
    }
}
