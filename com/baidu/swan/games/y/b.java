package com.baidu.swan.games.y;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.pms.c.d.f;
/* loaded from: classes8.dex */
public class b {

    /* loaded from: classes8.dex */
    public interface a {
        void aYC();

        void f(int i, long j, long j2);

        void gh(int i);
    }

    public static void a(String str, a aVar) {
        e aIN;
        if (aVar != null && !TextUtils.isEmpty(str) && (aIN = e.aIN()) != null) {
            if (com.baidu.swan.games.y.a.aYB().xz(str)) {
                aVar.aYC();
                return;
            }
            String rL = com.baidu.swan.games.y.a.aYB().rL(str);
            if (TextUtils.isEmpty(rL)) {
                aVar.gh(2112);
            } else {
                com.baidu.swan.pms.c.a(new f(aIN.id, aIN.getVersion(), rL, 1), new com.baidu.swan.games.y.b.a(aIN.id, aIN.getVersion(), com.baidu.swan.games.y.a.aYB().ai(str, 2), aVar));
            }
        }
    }
}
