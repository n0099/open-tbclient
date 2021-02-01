package com.baidu.swan.pms.c.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.a.d.d;
import com.baidu.swan.pms.c.a.d.f;
import com.baidu.swan.pms.c.a.d.h;
import com.baidu.swan.pms.c.a.d.i;
import com.baidu.swan.pms.c.c.c;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static void a(com.baidu.swan.pms.c.c.b bVar, g gVar) {
        com.baidu.swan.pms.c.a.a.a.a(bVar, gVar);
    }

    public static void a(@NonNull com.baidu.swan.pms.c.c.a aVar, @Nullable List<com.baidu.swan.pms.model.g> list, @NonNull g gVar) {
        i a2 = com.baidu.swan.pms.c.a.a.a.a(aVar, gVar);
        if (list != null && !list.isEmpty()) {
            for (f<com.baidu.swan.pms.model.g> fVar : h.b(list, gVar)) {
                a2.a(d.bcW().i(fVar));
            }
        }
        a2.bdh();
    }

    public static void a(com.baidu.swan.pms.node.d.a aVar, g gVar) {
        com.baidu.swan.pms.c.a.a.a.a(aVar, gVar);
    }

    public static void a(com.baidu.swan.pms.c.c.d dVar, g gVar) {
        com.baidu.swan.pms.c.a.a.a.a(dVar, gVar);
    }

    public static void a(c cVar, g gVar) {
        com.baidu.swan.pms.c.a.a.a.a(cVar, gVar);
    }
}
