package com.baidu.tbadk.core.util.resourceLoader;

import android.graphics.NinePatch;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.g;
/* loaded from: classes.dex */
public class c extends a {
    static {
        com.baidu.adp.lib.e.b.a().a(5, new c());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoader.a
    public Object a(String str, com.baidu.tbadk.core.util.b bVar) {
        com.baidu.adp.widget.a.a c = com.baidu.tbadk.imageManager.e.a().c(bVar.a(str));
        if (c == null || c.h() == null || c.m() == null) {
            return null;
        }
        if (c.h().getNinePatchChunk() == null || !NinePatch.isNinePatchChunk(c.h().getNinePatchChunk())) {
            return null;
        }
        return c;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoader.a
    public Object a(String str, com.baidu.adp.lib.e.d dVar, com.baidu.tbadk.core.util.b bVar, com.baidu.tbadk.core.util.e eVar) {
        if (eVar.g) {
            String f = be.f(str);
            if (bVar.f != null) {
                f = String.valueOf(f) + bVar.f;
            }
            String a = bVar.a(str);
            synchronized (g.a) {
                if (f != null) {
                    int e = bd.a().e(f);
                    if (e > 0) {
                        com.baidu.tbadk.imageManager.e.a().c(e);
                        eVar.i = bd.a().a(f, a);
                        eVar.e = eVar.i.h();
                    }
                }
                if (dVar.isCancelled()) {
                    return null;
                }
                if (eVar.e == null) {
                    return null;
                }
                if (eVar.i == null || eVar.i.h() == null || eVar.i.m() == null) {
                    return null;
                }
                if (eVar.i.h().getNinePatchChunk() == null || !NinePatch.isNinePatchChunk(eVar.i.h().getNinePatchChunk())) {
                    return null;
                }
                com.baidu.tbadk.imageManager.e.a().b(a, eVar.i);
                if (dVar.isCancelled()) {
                    return null;
                }
                if (eVar.i != null) {
                    dVar.a(eVar);
                }
                eVar.f = true;
                return eVar.i;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoader.a
    public Object b(String str, com.baidu.adp.lib.e.d dVar, com.baidu.tbadk.core.util.b bVar, com.baidu.tbadk.core.util.e eVar) {
        if (str == null || str.length() == 0) {
            TiebaStatic.imgError("", TbErrInfo.ERR_IMG_URL_IS_NULL, "", "");
            return null;
        }
        String f = be.f(str);
        if (bVar.f != null) {
            f = String.valueOf(f) + bVar.f;
        }
        eVar.a = new com.baidu.tbadk.core.util.a.e();
        byte[] a = eVar.a.a(str);
        if (a == null || !eVar.a.b()) {
            return null;
        }
        if (eVar.n) {
            return null;
        }
        String a2 = bVar.a(str);
        com.baidu.tbadk.imageManager.e.a().c(TbConfig.getPbImageSize() + a.length);
        Rect rect = new Rect();
        eVar.e = g.a(a, rect);
        eVar.j = a;
        if (eVar.n) {
            return null;
        }
        if (eVar.e.getNinePatchChunk() == null || !NinePatch.isNinePatchChunk(eVar.e.getNinePatchChunk())) {
            return null;
        }
        eVar.i = new com.baidu.adp.widget.a.a(eVar.e, false, a2, rect);
        if (eVar.i == null || eVar.i.h() == null || eVar.i.m() == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.e.a().b(a2, eVar.i);
        dVar.a(eVar);
        if (eVar.n) {
            return null;
        }
        eVar.k = f;
        eVar.l = a2;
        eVar.f = false;
        return eVar.i;
    }
}
