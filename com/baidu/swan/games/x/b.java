package com.baidu.swan.games.x;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes9.dex */
public class b {

    /* loaded from: classes9.dex */
    public interface a {
        void ani();

        void d(int i, long j, long j2);

        void dH(int i);
    }

    public static void a(String str, a aVar) {
        e ZS;
        if (aVar != null && !TextUtils.isEmpty(str) && (ZS = e.ZS()) != null) {
            if (com.baidu.swan.games.x.a.anh().ps(str)) {
                aVar.ani();
                return;
            }
            String kz = com.baidu.swan.games.x.a.anh().kz(str);
            if (TextUtils.isEmpty(kz)) {
                aVar.dH(2112);
            } else {
                com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.e(ZS.id, Integer.valueOf(ZS.getVersion()).intValue(), kz, 1), new com.baidu.swan.games.x.b.a(ZS.id, ZS.getVersion(), com.baidu.swan.games.x.a.anh().Q(str, 2), aVar));
            }
        }
    }
}
