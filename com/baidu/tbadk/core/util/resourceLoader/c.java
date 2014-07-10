package com.baidu.tbadk.core.util.resourceLoader;

import android.graphics.NinePatch;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.util.h;
import com.baidu.tbadk.core.util.httpNet.i;
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
            String f = bm.f(str);
            if (bVar.f != null) {
                f = String.valueOf(f) + bVar.f;
            }
            String a = bVar.a(str);
            synchronized (h.a) {
                if (f != null) {
                    int e = bl.a().e(f);
                    if (e > 0) {
                        com.baidu.tbadk.imageManager.e.a().c(e);
                        eVar.i = bl.a().a(f, a);
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
        String f = bm.f(str);
        if (bVar.f != null) {
            f = String.valueOf(f) + bVar.f;
        }
        eVar.a = new i();
        byte[] b = eVar.a.b(str);
        if (b == null || !eVar.a.b()) {
            return null;
        }
        if (eVar.n) {
            return null;
        }
        String a = bVar.a(str);
        com.baidu.tbadk.imageManager.e.a().c(TbConfig.getPbImageSize() + b.length);
        Rect rect = new Rect();
        eVar.e = h.a(b, rect, (StringBuilder) null);
        eVar.j = b;
        if (eVar.n) {
            return null;
        }
        if (eVar.e.getNinePatchChunk() == null || !NinePatch.isNinePatchChunk(eVar.e.getNinePatchChunk())) {
            return null;
        }
        eVar.i = new com.baidu.adp.widget.a.a(eVar.e, false, a, rect);
        if (eVar.i == null || eVar.i.h() == null || eVar.i.m() == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.e.a().b(a, eVar.i);
        dVar.a(eVar);
        if (eVar.n) {
            return null;
        }
        eVar.k = f;
        eVar.l = a;
        eVar.f = false;
        return eVar.i;
    }
}
