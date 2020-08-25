package com.baidu.swan.games.y;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.pms.c.d.f;
/* loaded from: classes8.dex */
public class b {

    /* loaded from: classes8.dex */
    public interface a {
        void aPB();

        void d(int i, long j, long j2);

        void gv(int i);
    }

    public static void a(String str, a aVar) {
        e azI;
        if (aVar != null && !TextUtils.isEmpty(str) && (azI = e.azI()) != null) {
            if (com.baidu.swan.games.y.a.aPA().vW(str)) {
                aVar.aPB();
                return;
            }
            String ql = com.baidu.swan.games.y.a.aPA().ql(str);
            if (TextUtils.isEmpty(ql)) {
                aVar.gv(2112);
            } else {
                com.baidu.swan.pms.c.a(new f(azI.id, azI.getVersion(), ql, 1), new com.baidu.swan.games.y.b.a(azI.id, azI.getVersion(), com.baidu.swan.games.y.a.aPA().Z(str, 2), aVar));
            }
        }
    }
}
