package com.baidu.swan.games.y;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.pms.c.d.f;
/* loaded from: classes10.dex */
public class b {

    /* loaded from: classes10.dex */
    public interface a {
        void aXp();

        void e(int i, long j, long j2);

        void hw(int i);
    }

    public static void a(String str, a aVar) {
        e aHu;
        if (aVar != null && !TextUtils.isEmpty(str) && (aHu = e.aHu()) != null) {
            if (com.baidu.swan.games.y.a.aXo().xJ(str)) {
                aVar.aXp();
                return;
            }
            String rY = com.baidu.swan.games.y.a.aXo().rY(str);
            if (TextUtils.isEmpty(rY)) {
                aVar.hw(2112);
            } else {
                com.baidu.swan.pms.c.a(new f(aHu.id, aHu.getVersion(), rY, 1), new com.baidu.swan.games.y.b.a(aHu.id, aHu.getVersion(), com.baidu.swan.games.y.a.aXo().ac(str, 2), aVar));
            }
        }
    }
}
