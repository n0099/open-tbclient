package com.baidu.swan.pms.c.a.d;

import android.text.TextUtils;
import com.baidu.swan.pms.c.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class h {
    public static f<com.baidu.swan.pms.model.d> a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.a.g gVar) {
        if (gVar != null && a(dVar, gVar.asS())) {
            return new f<>(new e(dVar), dVar, new c(gVar.asS()));
        }
        return null;
    }

    public static f<com.baidu.swan.pms.model.f> a(com.baidu.swan.pms.model.f fVar, com.baidu.swan.pms.a.g gVar) {
        if (gVar != null && a(fVar, gVar.asR())) {
            return new f<>(new e(fVar), fVar, new c(gVar.asR()));
        }
        return null;
    }

    public static f<com.baidu.swan.pms.model.b> a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.a.g gVar) {
        if (gVar != null && a(bVar, gVar.asT())) {
            return new f<>(new e(bVar), bVar, new c(gVar.asT()));
        }
        return null;
    }

    public static f<com.baidu.swan.pms.model.h> a(com.baidu.swan.pms.model.h hVar, com.baidu.swan.pms.a.g gVar) {
        if (gVar != null && a(hVar, gVar.aGR())) {
            return new f<>(new e(hVar), hVar, new c(gVar.aGR()));
        }
        return null;
    }

    public static f<com.baidu.swan.pms.model.i> a(com.baidu.swan.pms.model.i iVar, com.baidu.swan.pms.a.g gVar) {
        if (gVar != null && a(iVar, gVar.awj())) {
            return new f<>(new e(iVar), iVar, new c(gVar.awj()));
        }
        return null;
    }

    public static List<f<a.C0568a>> a(List<a.C0568a> list, com.baidu.swan.pms.a.g gVar) {
        ArrayList arrayList = new ArrayList();
        if (gVar == null) {
            return arrayList;
        }
        if (list != null && list.size() > 0) {
            for (a.C0568a c0568a : list) {
                com.baidu.swan.pms.model.f fVar = c0568a.enS;
                if (fVar != null && a(c0568a, gVar.asN())) {
                    arrayList.add(new f(new e(fVar), c0568a, new c(gVar.asN())));
                }
            }
        }
        return arrayList;
    }

    public static List<f<com.baidu.swan.pms.model.g>> b(List<com.baidu.swan.pms.model.g> list, com.baidu.swan.pms.a.g gVar) {
        ArrayList arrayList = new ArrayList();
        if (gVar == null) {
            return arrayList;
        }
        if (list != null && list.size() > 0) {
            for (com.baidu.swan.pms.model.g gVar2 : list) {
                if (a(gVar2, gVar.asO())) {
                    arrayList.add(new f(new e(gVar2), gVar2, new c(gVar.asO())));
                }
            }
        }
        return arrayList;
    }

    private static <T> boolean a(T t, com.baidu.swan.pms.a.c<T> cVar) {
        if (cVar == null || t == null) {
            return false;
        }
        if (t instanceof com.baidu.swan.pms.model.e) {
            com.baidu.swan.pms.model.e eVar = (com.baidu.swan.pms.model.e) t;
            return a(cVar, t, eVar.md5, eVar.downloadUrl);
        } else if (t instanceof a.C0568a) {
            com.baidu.swan.pms.model.f fVar = ((a.C0568a) t).enS;
            return a(cVar, t, fVar.md5, fVar.downloadUrl);
        } else {
            return false;
        }
    }

    private static <T> boolean a(com.baidu.swan.pms.a.c<T> cVar, T t, String str, String str2) {
        if (t == null || cVar == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            a(t, "md5", cVar);
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            a(t, "downloadUrl", cVar);
            return false;
        } else {
            return true;
        }
    }

    private static <T> void a(T t, String str, com.baidu.swan.pms.a.c<T> cVar) {
        cVar.a((com.baidu.swan.pms.a.c<T>) t, new com.baidu.swan.pms.model.a(2207, String.format("download : param error:%s", str)));
    }
}
