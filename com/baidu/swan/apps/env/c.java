package com.baidu.swan.apps.env;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.process.messaging.service.a;
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
/* loaded from: classes2.dex */
public class c implements com.baidu.swan.apps.a.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a auS;
    private f auT;
    private g auU;
    private AtomicInteger auV;
    private CopyOnWriteArrayList<String> auW;
    private com.baidu.swan.apps.env.a.f auX;
    private final String mProcess = ProcessUtils.getCurProcessName();

    /* loaded from: classes2.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.auS = aVar;
        com.baidu.swan.apps.u.a.CB().a(this);
        this.auV = new AtomicInteger(0);
        this.auW = new CopyOnWriteArrayList<>();
        this.auT = new f();
        this.auU = new g();
        this.auX = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void aL(boolean z) {
        String bI = com.baidu.swan.apps.u.a.CB().bI(this.auS.AX());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + bI + ")  -> " + z);
        }
        if (z) {
            AZ();
        } else {
            Bb();
        }
    }

    public String toString() {
        return "Process<" + this.mProcess + "> " + super.toString();
    }

    public void p(@Nullable String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            e(arrayList, z);
        }
    }

    public void e(@Nullable List<String> list, boolean z) {
        if (list != null && !list.isEmpty()) {
            a(list, true, z);
        }
    }

    public void a(@Nullable final List<String> list, final boolean z, boolean z2) {
        if (DEBUG) {
            Log.d("SwanAppPurger", "deleteSwanApp");
        }
        if (z2) {
            q(list);
        }
        if (list != null && !list.isEmpty()) {
            rx.d.bj("").a(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(String str) {
                    c.this.auV.incrementAndGet();
                    if (z) {
                        if (c.DEBUG) {
                            Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
                        }
                        c.this.auT.o(list);
                    }
                    if (c.DEBUG) {
                        Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
                    }
                    c.this.auT.p(list);
                    for (String str2 : list) {
                        if (c.this.auW.contains(str2)) {
                            if (c.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>删除忽略: " + str2);
                            }
                        } else {
                            if (c.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>删除小程序相关（小程序包、小程序分包）的APS记录: " + str2);
                            }
                            c.this.auT.ej(str2);
                            if (c.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>删除小程序文件: " + str2);
                            }
                            c.this.auT.eB(str2);
                            c.this.auU.eB(str2);
                            if (c.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str2);
                            }
                            c.this.auT.ew(str2);
                            if (c.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str2);
                            }
                            c.this.auT.ev(str2);
                        }
                    }
                    if (c.this.auV.decrementAndGet() <= 0) {
                        c.this.auV.set(0);
                        c.this.auW.clear();
                    }
                }
            });
        }
    }

    private void q(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<com.baidu.swan.apps.database.a> AI = com.baidu.swan.apps.database.favorite.a.AI();
            HashMap hashMap = new HashMap();
            for (com.baidu.swan.apps.database.a aVar : AI) {
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

    public boolean AY() {
        return this.auV.get() > 0;
    }

    public void f(@Nullable Set<String> set) {
        if (this.auX != null) {
            this.auX.i(set);
        }
    }

    public void eA(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.auW.add(str);
        }
    }

    private void AZ() {
        g(Ba());
    }

    private Set<String> Ba() {
        return cq(103);
    }

    private void g(Set<String> set) {
        d.a("aiapp_setting_", set, true);
    }

    private void Bb() {
        h(Bc());
    }

    private Set<String> Bc() {
        return cq(100);
    }

    private void h(Set<String> set) {
        d.a("aiapp_", set, true);
        String KA = com.baidu.swan.apps.storage.b.KA();
        if (!TextUtils.isEmpty(KA)) {
            com.baidu.swan.c.b.deleteFile(KA);
        }
        String KB = com.baidu.swan.apps.storage.b.KB();
        if (!TextUtils.isEmpty(KB)) {
            com.baidu.swan.c.b.deleteFile(KB);
        }
    }

    private Set<String> cq(int i) {
        SwanAppMessengerService serviceObject = SwanAppMessengerService.getServiceObject();
        if (serviceObject == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        LinkedHashSet<a.b> Gv = com.baidu.swan.apps.process.messaging.service.a.Gu().Gv();
        if (Gv.size() < 1) {
            return hashSet;
        }
        Iterator<a.b> it = Gv.iterator();
        while (it.hasNext()) {
            a.b next = it.next();
            if (next.aFh && next.GG()) {
                hashSet.add(next.GC());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active aiapp(" + next.GC() + ")");
                }
            }
        }
        serviceObject.sendMessageToAllClients(i);
        return hashSet;
    }
}
