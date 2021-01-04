package com.baidu.swan.games.y;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.pms.c.d.f;
/* loaded from: classes9.dex */
public class b {

    /* loaded from: classes9.dex */
    public interface a {
        void bcg();

        void f(int i, long j, long j2);

        void hK(int i);
    }

    public static void a(String str, a aVar) {
        e aMk;
        if (aVar != null && !TextUtils.isEmpty(str) && (aMk = e.aMk()) != null) {
            if (com.baidu.swan.games.y.a.bcf().yk(str)) {
                aVar.bcg();
                return;
            }
            String sx = com.baidu.swan.games.y.a.bcf().sx(str);
            if (TextUtils.isEmpty(sx)) {
                aVar.hK(2112);
            } else {
                com.baidu.swan.pms.c.a(new f(aMk.id, aMk.getVersion(), sx, 1), new com.baidu.swan.games.y.b.a(aMk.id, aMk.getVersion(), com.baidu.swan.games.y.a.bcf().af(str, 2), aVar));
            }
        }
    }
}
