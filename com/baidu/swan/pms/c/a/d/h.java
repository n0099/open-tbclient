package com.baidu.swan.pms.c.a.d;

import android.text.TextUtils;
import com.baidu.swan.pms.c.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class h {
    public static f<com.baidu.swan.pms.model.d> a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.a.g gVar) {
        if (gVar != null && a(dVar, gVar.anR())) {
            return new f<>(new e(dVar), dVar, new c(gVar.anR()));
        }
        return null;
    }

    public static f<com.baidu.swan.pms.model.f> a(com.baidu.swan.pms.model.f fVar, com.baidu.swan.pms.a.g gVar) {
        if (gVar != null && a(fVar, gVar.anQ())) {
            return new f<>(new e(fVar), fVar, new c(gVar.anQ()));
        }
        return null;
    }

    public static f<com.baidu.swan.pms.model.b> a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.a.g gVar) {
        if (gVar != null && a(bVar, gVar.anS())) {
            return new f<>(new e(bVar), bVar, new c(gVar.anS()));
        }
        return null;
    }

    public static f<com.baidu.swan.pms.model.h> a(com.baidu.swan.pms.model.h hVar, com.baidu.swan.pms.a.g gVar) {
        if (gVar != null && a(hVar, gVar.aBR())) {
            return new f<>(new e(hVar), hVar, new c(gVar.aBR()));
        }
        return null;
    }

    public static f<com.baidu.swan.pms.model.i> a(com.baidu.swan.pms.model.i iVar, com.baidu.swan.pms.a.g gVar) {
        if (gVar != null && a(iVar, gVar.ari())) {
            return new f<>(new e(iVar), iVar, new c(gVar.ari()));
        }
        return null;
    }

    public static List<f<a.C0546a>> a(List<a.C0546a> list, com.baidu.swan.pms.a.g gVar) {
        ArrayList arrayList = new ArrayList();
        if (gVar == null) {
            return arrayList;
        }
        if (list != null && list.size() > 0) {
            for (a.C0546a c0546a : list) {
                com.baidu.swan.pms.model.f fVar = c0546a.ecG;
                if (fVar != null && a(c0546a, gVar.anM())) {
                    arrayList.add(new f(new e(fVar), c0546a, new c(gVar.anM())));
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
                if (a(gVar2, gVar.anN())) {
                    arrayList.add(new f(new e(gVar2), gVar2, new c(gVar.anN())));
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
        } else if (t instanceof a.C0546a) {
            com.baidu.swan.pms.model.f fVar = ((a.C0546a) t).ecG;
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
