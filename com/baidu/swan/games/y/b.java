package com.baidu.swan.games.y;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class b {

    /* loaded from: classes11.dex */
    public interface a {
        void aDd();

        void d(int i, long j, long j2);

        void ew(int i);
    }

    public static void a(String str, a aVar) {
        e apM;
        if (aVar != null && !TextUtils.isEmpty(str) && (apM = e.apM()) != null) {
            if (com.baidu.swan.games.y.a.aDc().sI(str)) {
                aVar.aDd();
                return;
            }
            String nG = com.baidu.swan.games.y.a.aDc().nG(str);
            if (TextUtils.isEmpty(nG)) {
                aVar.ew(2112);
            } else {
                com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.e(apM.id, Integer.valueOf(apM.getVersion()).intValue(), nG, 1), new com.baidu.swan.games.y.b.a(apM.id, apM.getVersion(), com.baidu.swan.games.y.a.aDc().X(str, 2), aVar));
            }
        }
    }
}
