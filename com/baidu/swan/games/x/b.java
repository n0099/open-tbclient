package com.baidu.swan.games.x;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class b {

    /* loaded from: classes11.dex */
    public interface a {
        void apU();

        void d(int i, long j, long j2);

        void dY(int i);
    }

    public static void a(String str, a aVar) {
        e acI;
        if (aVar != null && !TextUtils.isEmpty(str) && (acI = e.acI()) != null) {
            if (com.baidu.swan.games.x.a.apT().pJ(str)) {
                aVar.apU();
                return;
            }
            String kQ = com.baidu.swan.games.x.a.apT().kQ(str);
            if (TextUtils.isEmpty(kQ)) {
                aVar.dY(2112);
            } else {
                com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.e(acI.id, Integer.valueOf(acI.getVersion()).intValue(), kQ, 1), new com.baidu.swan.games.x.b.a(acI.id, acI.getVersion(), com.baidu.swan.games.x.a.apT().O(str, 2), aVar));
            }
        }
    }
}
