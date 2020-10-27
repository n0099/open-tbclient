package com.baidu.swan.games.y;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.pms.c.d.f;
/* loaded from: classes10.dex */
public class b {

    /* loaded from: classes10.dex */
    public interface a {
        void aUP();

        void d(int i, long j, long j2);

        void hm(int i);
    }

    public static void a(String str, a aVar) {
        e aEU;
        if (aVar != null && !TextUtils.isEmpty(str) && (aEU = e.aEU()) != null) {
            if (com.baidu.swan.games.y.a.aUO().xv(str)) {
                aVar.aUP();
                return;
            }
            String rK = com.baidu.swan.games.y.a.aUO().rK(str);
            if (TextUtils.isEmpty(rK)) {
                aVar.hm(2112);
            } else {
                com.baidu.swan.pms.c.a(new f(aEU.id, aEU.getVersion(), rK, 1), new com.baidu.swan.games.y.b.a(aEU.id, aEU.getVersion(), com.baidu.swan.games.y.a.aUO().aa(str, 2), aVar));
            }
        }
    }
}
