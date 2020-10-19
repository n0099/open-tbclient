package com.baidu.swan.games.y;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.pms.c.d.f;
/* loaded from: classes10.dex */
public class b {

    /* loaded from: classes10.dex */
    public interface a {
        void aSV();

        void d(int i, long j, long j2);

        void hb(int i);
    }

    public static void a(String str, a aVar) {
        e aDa;
        if (aVar != null && !TextUtils.isEmpty(str) && (aDa = e.aDa()) != null) {
            if (com.baidu.swan.games.y.a.aSU().xc(str)) {
                aVar.aSV();
                return;
            }
            String rr = com.baidu.swan.games.y.a.aSU().rr(str);
            if (TextUtils.isEmpty(rr)) {
                aVar.hb(2112);
            } else {
                com.baidu.swan.pms.c.a(new f(aDa.id, aDa.getVersion(), rr, 1), new com.baidu.swan.games.y.b.a(aDa.id, aDa.getVersion(), com.baidu.swan.games.y.a.aSU().aa(str, 2), aVar));
            }
        }
    }
}
