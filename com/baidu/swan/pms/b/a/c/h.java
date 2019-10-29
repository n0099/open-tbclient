package com.baidu.swan.pms.b.a.c;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class h {
    public static f<com.baidu.swan.pms.model.d> a(com.baidu.swan.pms.model.d dVar, com.baidu.swan.pms.a.f fVar) {
        if (fVar != null && a(dVar, fVar.Gp())) {
            return new f<>(new e(dVar), dVar, new c(dVar, fVar.Gp()));
        }
        return null;
    }

    public static f<com.baidu.swan.pms.model.f> a(com.baidu.swan.pms.model.f fVar, com.baidu.swan.pms.a.f fVar2) {
        if (fVar2 != null && a(fVar, fVar2.Gn())) {
            return new f<>(new e(fVar), fVar, new c(fVar, fVar2.Gn()));
        }
        return null;
    }

    public static f<com.baidu.swan.pms.model.b> a(com.baidu.swan.pms.model.b bVar, com.baidu.swan.pms.a.f fVar) {
        if (fVar != null && a(bVar, fVar.Gq())) {
            return new f<>(new e(bVar), bVar, new c(bVar, fVar.Gq()));
        }
        return null;
    }

    public static f<com.baidu.swan.pms.model.i> a(com.baidu.swan.pms.model.i iVar, com.baidu.swan.pms.a.f fVar) {
        if (fVar != null && a(iVar, fVar.Wu())) {
            return new f<>(new e(iVar), iVar, new c(iVar, fVar.Wu()));
        }
        return null;
    }

    public static List<f<com.baidu.swan.pms.model.h>> a(List<com.baidu.swan.pms.model.h> list, com.baidu.swan.pms.a.f fVar) {
        ArrayList arrayList = new ArrayList();
        if (fVar == null) {
            return arrayList;
        }
        if (list != null && list.size() > 0) {
            for (com.baidu.swan.pms.model.h hVar : list) {
                if (a(hVar, fVar.Go())) {
                    arrayList.add(new f(new e(hVar), hVar, new c(hVar, fVar.Go())));
                }
            }
        }
        return arrayList;
    }

    private static <T> boolean a(T t, com.baidu.swan.pms.a.a<T> aVar) {
        if (aVar == null || t == null) {
            return false;
        }
        if (t instanceof com.baidu.swan.pms.model.e) {
            com.baidu.swan.pms.model.e eVar = (com.baidu.swan.pms.model.e) t;
            return a(aVar, t, eVar.md5, eVar.downloadUrl);
        } else if (t instanceof com.baidu.swan.pms.model.g) {
            com.baidu.swan.pms.model.f fVar = ((com.baidu.swan.pms.model.g) t).bMc;
            return a(aVar, t, fVar.md5, fVar.downloadUrl);
        } else {
            return false;
        }
    }

    private static <T> boolean a(com.baidu.swan.pms.a.a<T> aVar, T t, String str, String str2) {
        if (t == null || aVar == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            a(t, "md5", aVar);
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            a(t, "downloadUrl", aVar);
            return false;
        } else {
            return true;
        }
    }

    private static <T> void a(T t, String str, com.baidu.swan.pms.a.a<T> aVar) {
        aVar.a((com.baidu.swan.pms.a.a<T>) t, new com.baidu.swan.pms.model.a(2207, String.format("download : param error:%s", str)));
    }
}
