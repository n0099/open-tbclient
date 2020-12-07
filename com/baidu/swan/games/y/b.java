package com.baidu.swan.games.y;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.pms.c.d.f;
/* loaded from: classes25.dex */
public class b {

    /* loaded from: classes25.dex */
    public interface a {
        void aZM();

        void e(int i, long j, long j2);

        void hQ(int i);
    }

    public static void a(String str, a aVar) {
        e aJU;
        if (aVar != null && !TextUtils.isEmpty(str) && (aJU = e.aJU()) != null) {
            if (com.baidu.swan.games.y.a.aZL().yl(str)) {
                aVar.aZM();
                return;
            }
            String sA = com.baidu.swan.games.y.a.aZL().sA(str);
            if (TextUtils.isEmpty(sA)) {
                aVar.hQ(2112);
            } else {
                com.baidu.swan.pms.c.a(new f(aJU.id, aJU.getVersion(), sA, 1), new com.baidu.swan.games.y.b.a(aJU.id, aJU.getVersion(), com.baidu.swan.games.y.a.aZL().ad(str, 2), aVar));
            }
        }
    }
}
