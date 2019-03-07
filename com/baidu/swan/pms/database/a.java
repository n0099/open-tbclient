package com.baidu.swan.pms.database;

import com.baidu.swan.pms.model.c;
import com.baidu.swan.pms.model.e;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import com.baidu.swan.pms.model.i;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class a {
    private static volatile a blA;

    public abstract boolean N(String str, int i);

    public abstract Map<String, com.baidu.swan.pms.model.a> RB();

    public abstract boolean a(g gVar, List<i> list, e eVar, c cVar, com.baidu.swan.pms.model.a aVar);

    public abstract <T extends f> boolean c(T t);

    public abstract <T extends f> boolean c(Class<T> cls, String str);

    public abstract boolean f(com.baidu.swan.pms.model.a aVar);

    public abstract com.baidu.swan.pms.model.a ji(String str);

    public abstract boolean jj(String str);

    public static a RA() {
        if (blA == null) {
            synchronized (a.class) {
                if (blA == null) {
                    blA = new b();
                }
            }
        }
        return blA;
    }
}
