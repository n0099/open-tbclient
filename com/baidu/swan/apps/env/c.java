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
    private final a auP;
    private f auQ;
    private g auR;
    private AtomicInteger auS;
    private CopyOnWriteArrayList<String> auT;
    private com.baidu.swan.apps.env.a.f auU;
    private final String mProcess = ProcessUtils.getCurProcessName();

    /* loaded from: classes2.dex */
    public interface a extends b {
    }

    public c(a aVar) {
        this.auP = aVar;
        com.baidu.swan.apps.u.a.CD().a(this);
        this.auS = new AtomicInteger(0);
        this.auT = new CopyOnWriteArrayList<>();
        this.auQ = new f();
        this.auR = new g();
        this.auU = new com.baidu.swan.apps.env.a.f();
        if (DEBUG) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // com.baidu.swan.apps.a.c
    public void aL(boolean z) {
        String bI = com.baidu.swan.apps.u.a.CD().bI(this.auP.AZ());
        if (DEBUG) {
            Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
            Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + bI + ")  -> " + z);
        }
        if (z) {
            Bb();
        } else {
            Bd();
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
            rx.d.bn("").a(Schedulers.io()).c(new rx.functions.b<String>() { // from class: com.baidu.swan.apps.env.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(String str) {
                    c.this.auS.incrementAndGet();
                    if (z) {
                        if (c.DEBUG) {
                            Log.d("SwanAppPurger", "删除小程序==>开始重置小程序授权");
                        }
                        c.this.auQ.o(list);
                    }
                    if (c.DEBUG) {
                        Log.d("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
                    }
                    c.this.auQ.p(list);
                    for (String str2 : list) {
                        if (c.this.auT.contains(str2)) {
                            if (c.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>删除忽略: " + str2);
                            }
                        } else {
                            if (c.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>删除小程序相关（小程序包、小程序分包）的APS记录: " + str2);
                            }
                            c.this.auQ.eh(str2);
                            if (c.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>删除小程序文件: " + str2);
                            }
                            c.this.auQ.eA(str2);
                            c.this.auR.eA(str2);
                            if (c.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str2);
                            }
                            c.this.auQ.ev(str2);
                            if (c.DEBUG) {
                                Log.d("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str2);
                            }
                            c.this.auQ.eu(str2);
                        }
                    }
                    if (c.this.auS.decrementAndGet() <= 0) {
                        c.this.auS.set(0);
                        c.this.auT.clear();
                    }
                }
            });
        }
    }

    private void q(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            List<com.baidu.swan.apps.database.a> AK = com.baidu.swan.apps.database.favorite.a.AK();
            HashMap hashMap = new HashMap();
            for (com.baidu.swan.apps.database.a aVar : AK) {
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

    public boolean Ba() {
        return this.auS.get() > 0;
    }

    public void f(@Nullable Set<String> set) {
        if (this.auU != null) {
            this.auU.i(set);
        }
    }

    public void ez(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.auT.add(str);
        }
    }

    private void Bb() {
        g(Bc());
    }

    private Set<String> Bc() {
        return cr(103);
    }

    private void g(Set<String> set) {
        d.a("aiapp_setting_", set, true);
    }

    private void Bd() {
        h(Be());
    }

    private Set<String> Be() {
        return cr(100);
    }

    private void h(Set<String> set) {
        d.a("aiapp_", set, true);
        String KC = com.baidu.swan.apps.storage.b.KC();
        if (!TextUtils.isEmpty(KC)) {
            com.baidu.swan.c.b.deleteFile(KC);
        }
        String KD = com.baidu.swan.apps.storage.b.KD();
        if (!TextUtils.isEmpty(KD)) {
            com.baidu.swan.c.b.deleteFile(KD);
        }
    }

    private Set<String> cr(int i) {
        SwanAppMessengerService serviceObject = SwanAppMessengerService.getServiceObject();
        if (serviceObject == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        LinkedHashSet<a.b> Gx = com.baidu.swan.apps.process.messaging.service.a.Gw().Gx();
        if (Gx.size() < 1) {
            return hashSet;
        }
        Iterator<a.b> it = Gx.iterator();
        while (it.hasNext()) {
            a.b next = it.next();
            if (next.aFe && next.GI()) {
                hashSet.add(next.GE());
                if (DEBUG) {
                    Log.i("SwanAppPurger", "sent msg(" + i + ") to active aiapp(" + next.GE() + ")");
                }
            }
        }
        serviceObject.sendMessageToAllClients(i);
        return hashSet;
    }
}
