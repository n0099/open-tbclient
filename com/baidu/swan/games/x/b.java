package com.baidu.swan.games.x;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes10.dex */
public class b {

    /* loaded from: classes10.dex */
    public interface a {
        void anB();

        void d(int i, long j, long j2);

        void dI(int i);
    }

    public static void a(String str, a aVar) {
        e aap;
        if (aVar != null && !TextUtils.isEmpty(str) && (aap = e.aap()) != null) {
            if (com.baidu.swan.games.x.a.anA().pv(str)) {
                aVar.anB();
                return;
            }
            String kC = com.baidu.swan.games.x.a.anA().kC(str);
            if (TextUtils.isEmpty(kC)) {
                aVar.dI(2112);
            } else {
                com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.e(aap.id, Integer.valueOf(aap.getVersion()).intValue(), kC, 1), new com.baidu.swan.games.x.b.a(aap.id, aap.getVersion(), com.baidu.swan.games.x.a.anA().Q(str, 2), aVar));
            }
        }
    }
}
