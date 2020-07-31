package com.baidu.swan.a;

import com.baidu.swan.pms.c.a.d.f;
import com.baidu.swan.pms.c.a.d.i;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class d {
    public static synchronized void a(com.baidu.swan.a.a.a aVar, a<com.baidu.swan.a.a.c> aVar2) {
        synchronized (d.class) {
            if (aVar2 != null) {
                if (aVar == null) {
                    aVar2.b(new com.baidu.swan.pms.model.a(2100, "request对象为空"));
                } else {
                    HashMap<String, String> a = b.a(aVar);
                    if (aVar2.aKP() != null) {
                        a.putAll(aVar2.aKP());
                    }
                    aVar2.Zu();
                    com.baidu.swan.pms.d.aKM().aix().a(c.ayX(), a, aVar2.aKQ(), new com.baidu.swan.a.a.b(aVar, aVar2));
                }
            }
        }
    }

    public static <T extends com.baidu.swan.pms.model.e> void a(T t, a aVar) {
        f b = b(t, aVar);
        i iVar = new i(aVar);
        iVar.a(com.baidu.swan.pms.c.a.d.d.aLv().i(b));
        iVar.aLH();
    }

    private static <T extends com.baidu.swan.pms.model.e> f b(T t, a<T> aVar) {
        if (t == null || aVar == null) {
            return null;
        }
        return new f(new com.baidu.swan.pms.c.a.d.e(t), t, new com.baidu.swan.pms.c.a.d.c(aVar.ayW()));
    }
}
