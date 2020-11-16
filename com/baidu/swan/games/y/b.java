package com.baidu.swan.games.y;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.pms.c.d.f;
/* loaded from: classes7.dex */
public class b {

    /* loaded from: classes7.dex */
    public interface a {
        void aWH();

        void e(int i, long j, long j2);

        void hs(int i);
    }

    public static void a(String str, a aVar) {
        e aGM;
        if (aVar != null && !TextUtils.isEmpty(str) && (aGM = e.aGM()) != null) {
            if (com.baidu.swan.games.y.a.aWG().xE(str)) {
                aVar.aWH();
                return;
            }
            String rS = com.baidu.swan.games.y.a.aWG().rS(str);
            if (TextUtils.isEmpty(rS)) {
                aVar.hs(2112);
            } else {
                com.baidu.swan.pms.c.a(new f(aGM.id, aGM.getVersion(), rS, 1), new com.baidu.swan.games.y.b.a(aGM.id, aGM.getVersion(), com.baidu.swan.games.y.a.aWG().ac(str, 2), aVar));
            }
        }
    }
}
