package com.baidu.swan.games.x;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class b {

    /* loaded from: classes11.dex */
    public interface a {
        void apP();

        void d(int i, long j, long j2);

        void dY(int i);
    }

    public static void a(String str, a aVar) {
        e acD;
        if (aVar != null && !TextUtils.isEmpty(str) && (acD = e.acD()) != null) {
            if (com.baidu.swan.games.x.a.apO().pK(str)) {
                aVar.apP();
                return;
            }
            String kR = com.baidu.swan.games.x.a.apO().kR(str);
            if (TextUtils.isEmpty(kR)) {
                aVar.dY(2112);
            } else {
                com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.e(acD.id, Integer.valueOf(acD.getVersion()).intValue(), kR, 1), new com.baidu.swan.games.x.b.a(acD.id, acD.getVersion(), com.baidu.swan.games.x.a.apO().O(str, 2), aVar));
            }
        }
    }
}
