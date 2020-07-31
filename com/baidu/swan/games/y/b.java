package com.baidu.swan.games.y;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.pms.c.d.f;
/* loaded from: classes7.dex */
public class b {

    /* loaded from: classes7.dex */
    public interface a {
        void aGK();

        void d(int i, long j, long j2);

        void ex(int i);
    }

    public static void a(String str, a aVar) {
        e arv;
        if (aVar != null && !TextUtils.isEmpty(str) && (arv = e.arv()) != null) {
            if (com.baidu.swan.games.y.a.aGJ().tG(str)) {
                aVar.aGK();
                return;
            }
            String oo = com.baidu.swan.games.y.a.aGJ().oo(str);
            if (TextUtils.isEmpty(oo)) {
                aVar.ex(2112);
            } else {
                com.baidu.swan.pms.c.a(new f(arv.id, arv.getVersion(), oo, 1), new com.baidu.swan.games.y.b.a(arv.id, arv.getVersion(), com.baidu.swan.games.y.a.aGJ().X(str, 2), aVar));
            }
        }
    }
}
