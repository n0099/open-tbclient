package com.baidu.swan.games.y;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.pms.c.d.f;
/* loaded from: classes8.dex */
public class b {

    /* loaded from: classes8.dex */
    public interface a {
        void aYn();

        void f(int i, long j, long j2);

        void gd(int i);
    }

    public static void a(String str, a aVar) {
        e aIr;
        if (aVar != null && !TextUtils.isEmpty(str) && (aIr = e.aIr()) != null) {
            if (com.baidu.swan.games.y.a.aYm().wZ(str)) {
                aVar.aYn();
                return;
            }
            String rl = com.baidu.swan.games.y.a.aYm().rl(str);
            if (TextUtils.isEmpty(rl)) {
                aVar.gd(2112);
            } else {
                com.baidu.swan.pms.c.a(new f(aIr.id, aIr.getVersion(), rl, 1), new com.baidu.swan.games.y.b.a(aIr.id, aIr.getVersion(), com.baidu.swan.games.y.a.aYm().af(str, 2), aVar));
            }
        }
    }
}
