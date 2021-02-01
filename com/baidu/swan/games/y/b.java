package com.baidu.swan.games.y;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.pms.c.d.f;
/* loaded from: classes9.dex */
public class b {

    /* loaded from: classes9.dex */
    public interface a {
        void aYz();

        void f(int i, long j, long j2);

        void gg(int i);
    }

    public static void a(String str, a aVar) {
        e aIK;
        if (aVar != null && !TextUtils.isEmpty(str) && (aIK = e.aIK()) != null) {
            if (com.baidu.swan.games.y.a.aYy().xs(str)) {
                aVar.aYz();
                return;
            }
            String rE = com.baidu.swan.games.y.a.aYy().rE(str);
            if (TextUtils.isEmpty(rE)) {
                aVar.gg(2112);
            } else {
                com.baidu.swan.pms.c.a(new f(aIK.id, aIK.getVersion(), rE, 1), new com.baidu.swan.games.y.b.a(aIK.id, aIK.getVersion(), com.baidu.swan.games.y.a.aYy().ah(str, 2), aVar));
            }
        }
    }
}
