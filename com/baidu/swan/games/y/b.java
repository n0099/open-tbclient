package com.baidu.swan.games.y;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class b {

    /* loaded from: classes11.dex */
    public interface a {
        void aBX();

        void d(int i, long j, long j2);

        void el(int i);
    }

    public static void a(String str, a aVar) {
        e aoF;
        if (aVar != null && !TextUtils.isEmpty(str) && (aoF = e.aoF()) != null) {
            if (com.baidu.swan.games.y.a.aBW().sA(str)) {
                aVar.aBX();
                return;
            }
            String ny = com.baidu.swan.games.y.a.aBW().ny(str);
            if (TextUtils.isEmpty(ny)) {
                aVar.el(2112);
            } else {
                com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.e(aoF.id, Integer.valueOf(aoF.getVersion()).intValue(), ny, 1), new com.baidu.swan.games.y.b.a(aoF.id, aoF.getVersion(), com.baidu.swan.games.y.a.aBW().X(str, 2), aVar));
            }
        }
    }
}
