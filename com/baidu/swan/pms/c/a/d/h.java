package com.baidu.swan.pms.c.a.d;

import android.text.TextUtils;
import com.baidu.swan.pms.c.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    public static f<com.baidu.swan.pms.model.d> a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.a.g gVar) {
        if (gVar != null && a(dVar, gVar.aqN())) {
            return new f<>(new e(dVar), dVar, new c(gVar.aqN()));
        }
        return null;
    }

    public static f<com.baidu.swan.pms.model.f> a(com.baidu.swan.pms.model.f fVar, com.baidu.swan.pms.a.g gVar) {
        if (gVar != null && a(fVar, gVar.aqM())) {
            return new f<>(new e(fVar), fVar, new c(gVar.aqM()));
        }
        return null;
    }

    public static f<com.baidu.swan.pms.model.b> a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.a.g gVar) {
        if (gVar != null && a(bVar, gVar.aqO())) {
            return new f<>(new e(bVar), bVar, new c(gVar.aqO()));
        }
        return null;
    }

    public static f<com.baidu.swan.pms.model.h> a(com.baidu.swan.pms.model.h hVar, com.baidu.swan.pms.a.g gVar) {
        if (gVar != null && a(hVar, gVar.aEM())) {
            return new f<>(new e(hVar), hVar, new c(gVar.aEM()));
        }
        return null;
    }

    public static f<com.baidu.swan.pms.model.i> a(com.baidu.swan.pms.model.i iVar, com.baidu.swan.pms.a.g gVar) {
        if (gVar != null && a(iVar, gVar.aug())) {
            return new f<>(new e(iVar), iVar, new c(gVar.aug()));
        }
        return null;
    }

    public static List<f<a.C0539a>> a(List<a.C0539a> list, com.baidu.swan.pms.a.g gVar) {
        ArrayList arrayList = new ArrayList();
        if (gVar == null) {
            return arrayList;
        }
        if (list != null && list.size() > 0) {
            for (a.C0539a c0539a : list) {
                com.baidu.swan.pms.model.f fVar = c0539a.euT;
                if (fVar != null && a(c0539a, gVar.aqI())) {
                    arrayList.add(new f(new e(fVar), c0539a, new c(gVar.aqI())));
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
                if (a(gVar2, gVar.aqJ())) {
                    arrayList.add(new f(new e(gVar2), gVar2, new c(gVar.aqJ())));
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
        } else if (t instanceof a.C0539a) {
            com.baidu.swan.pms.model.f fVar = ((a.C0539a) t).euT;
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
