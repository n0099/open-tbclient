package com.baidu.swan.games.x;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class b {

    /* loaded from: classes11.dex */
    public interface a {
        void apR();

        void d(int i, long j, long j2);

        void dY(int i);
    }

    public static void a(String str, a aVar) {
        e acF;
        if (aVar != null && !TextUtils.isEmpty(str) && (acF = e.acF()) != null) {
            if (com.baidu.swan.games.x.a.apQ().pK(str)) {
                aVar.apR();
                return;
            }
            String kR = com.baidu.swan.games.x.a.apQ().kR(str);
            if (TextUtils.isEmpty(kR)) {
                aVar.dY(2112);
            } else {
                com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.e(acF.id, Integer.valueOf(acF.getVersion()).intValue(), kR, 1), new com.baidu.swan.games.x.b.a(acF.id, acF.getVersion(), com.baidu.swan.games.x.a.apQ().O(str, 2), aVar));
            }
        }
    }
}
