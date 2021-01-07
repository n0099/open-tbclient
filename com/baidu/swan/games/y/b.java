package com.baidu.swan.games.y;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.pms.c.d.f;
/* loaded from: classes9.dex */
public class b {

    /* loaded from: classes9.dex */
    public interface a {
        void bch();

        void f(int i, long j, long j2);

        void hK(int i);
    }

    public static void a(String str, a aVar) {
        e aMl;
        if (aVar != null && !TextUtils.isEmpty(str) && (aMl = e.aMl()) != null) {
            if (com.baidu.swan.games.y.a.bcg().yk(str)) {
                aVar.bch();
                return;
            }
            String sx = com.baidu.swan.games.y.a.bcg().sx(str);
            if (TextUtils.isEmpty(sx)) {
                aVar.hK(2112);
            } else {
                com.baidu.swan.pms.c.a(new f(aMl.id, aMl.getVersion(), sx, 1), new com.baidu.swan.games.y.b.a(aMl.id, aMl.getVersion(), com.baidu.swan.games.y.a.bcg().af(str, 2), aVar));
            }
        }
    }
}
