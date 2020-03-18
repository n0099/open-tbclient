package com.baidu.swan.a;

import com.baidu.swan.pms.c.a.d.f;
import com.baidu.swan.pms.c.a.d.i;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class d {
    public static synchronized void a(com.baidu.swan.a.a.a aVar, a<com.baidu.swan.a.a.c> aVar2) {
        synchronized (d.class) {
            if (aVar2 != null) {
                if (aVar == null) {
                    aVar2.a(new com.baidu.swan.pms.model.a(PushConstants.BROADCAST_MESSAGE_ARRIVE, "request对象为空"));
                } else {
                    HashMap<String, String> a = b.a(aVar);
                    if (aVar2.atv() != null) {
                        a.putAll(aVar2.atv());
                    }
                    aVar2.Ne();
                    com.baidu.swan.pms.c.a.a(c.ajn(), a, aVar2.atw(), new com.baidu.swan.a.a.b(aVar, aVar2));
                }
            }
        }
    }

    public static <T extends com.baidu.swan.pms.model.e> void a(T t, a aVar) {
        f b = b(t, aVar);
        i iVar = new i(aVar);
        iVar.a(com.baidu.swan.pms.c.a.d.d.atY().i(b));
        iVar.startDownload();
    }

    private static <T extends com.baidu.swan.pms.model.e> f b(T t, a<T> aVar) {
        if (t == null || aVar == null) {
            return null;
        }
        return new f(new com.baidu.swan.pms.c.a.d.e(t), t, new com.baidu.swan.pms.c.a.d.c(aVar.ajm()));
    }
}
