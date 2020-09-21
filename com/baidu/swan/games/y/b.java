package com.baidu.swan.games.y;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.pms.c.d.f;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public interface a {
        void aQm();

        void d(int i, long j, long j2);

        void gE(int i);
    }

    public static void a(String str, a aVar) {
        e aAr;
        if (aVar != null && !TextUtils.isEmpty(str) && (aAr = e.aAr()) != null) {
            if (com.baidu.swan.games.y.a.aQl().wq(str)) {
                aVar.aQm();
                return;
            }
            String qF = com.baidu.swan.games.y.a.aQl().qF(str);
            if (TextUtils.isEmpty(qF)) {
                aVar.gE(2112);
            } else {
                com.baidu.swan.pms.c.a(new f(aAr.id, aAr.getVersion(), qF, 1), new com.baidu.swan.games.y.b.a(aAr.id, aAr.getVersion(), com.baidu.swan.games.y.a.aQl().Z(str, 2), aVar));
            }
        }
    }
}
