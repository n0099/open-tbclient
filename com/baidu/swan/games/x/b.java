package com.baidu.swan.games.x;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class b {

    /* loaded from: classes11.dex */
    public interface a {
        void ayg();

        void d(int i, long j, long j2);

        void ed(int i);
    }

    public static void a(String str, a aVar) {
        e akN;
        if (aVar != null && !TextUtils.isEmpty(str) && (akN = e.akN()) != null) {
            if (com.baidu.swan.games.x.a.ayf().qW(str)) {
                aVar.ayg();
                return;
            }
            String md = com.baidu.swan.games.x.a.ayf().md(str);
            if (TextUtils.isEmpty(md)) {
                aVar.ed(2112);
            } else {
                com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.e(akN.id, Integer.valueOf(akN.getVersion()).intValue(), md, 1), new com.baidu.swan.games.x.b.a(akN.id, akN.getVersion(), com.baidu.swan.games.x.a.ayf().W(str, 2), aVar));
            }
        }
    }
}
