package com.baidu.swan.pms.b.a.c;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class h {
    public static f<com.baidu.swan.pms.model.e> a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.e eVar2) {
        if (eVar2 != null && a(eVar, eVar2.zF())) {
            return new f<>(new e(eVar), eVar, new c(eVar, eVar2.zF()));
        }
        return null;
    }

    public static f<com.baidu.swan.pms.model.g> a(com.baidu.swan.pms.model.g gVar, com.baidu.swan.pms.a.e eVar) {
        if (eVar != null && a(gVar, eVar.zD())) {
            return new f<>(new e(gVar), gVar, new c(gVar, eVar.zD()));
        }
        return null;
    }

    public static f<com.baidu.swan.pms.model.c> a(com.baidu.swan.pms.model.c cVar, com.baidu.swan.pms.a.e eVar) {
        if (eVar != null && a(cVar, eVar.zG())) {
            return new f<>(new e(cVar), cVar, new c(cVar, eVar.zG()));
        }
        return null;
    }

    public static List<f<com.baidu.swan.pms.model.i>> a(List<com.baidu.swan.pms.model.i> list, com.baidu.swan.pms.a.e eVar) {
        ArrayList arrayList = new ArrayList();
        if (eVar == null) {
            return arrayList;
        }
        if (list != null && list.size() > 0) {
            for (com.baidu.swan.pms.model.i iVar : list) {
                if (a(iVar, eVar.zE())) {
                    arrayList.add(new f(new e(iVar), iVar, new c(iVar, eVar.zE())));
                }
            }
        }
        return arrayList;
    }

    private static <T> boolean a(T t, com.baidu.swan.pms.a.a<T> aVar) {
        if (aVar == null || t == null) {
            return false;
        }
        if (t instanceof com.baidu.swan.pms.model.f) {
            com.baidu.swan.pms.model.f fVar = (com.baidu.swan.pms.model.f) t;
            return a(aVar, t, fVar.md5, fVar.downloadUrl);
        } else if (t instanceof com.baidu.swan.pms.model.h) {
            com.baidu.swan.pms.model.g gVar = ((com.baidu.swan.pms.model.h) t).blX;
            return a(aVar, t, gVar.md5, gVar.downloadUrl);
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
        aVar.a(t, new com.baidu.swan.pms.model.b(2207, String.format("download : param error:%s", str)));
    }
}
