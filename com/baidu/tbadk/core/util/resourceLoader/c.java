package com.baidu.tbadk.core.util.resourceLoader;

import android.graphics.NinePatch;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public final class c extends a {
    static {
        com.baidu.adp.lib.e.b.a().a(5, new c());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoader.a
    public final Object a(String str, com.baidu.tbadk.core.util.b bVar) {
        com.baidu.adp.widget.ImageView.b c = com.baidu.tbadk.imageManager.e.a().c(bVar.a(str));
        if (c == null || c.h() == null || c.l() == null) {
            return null;
        }
        if (c.h().getNinePatchChunk() == null || !NinePatch.isNinePatchChunk(c.h().getNinePatchChunk())) {
            return null;
        }
        return c;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoader.a
    public final Object a(String str, com.baidu.adp.lib.e.d dVar, com.baidu.tbadk.core.util.b bVar, com.baidu.tbadk.core.util.e eVar) {
        if (eVar.g) {
            String f = bc.f(str);
            if (bVar.f != null) {
                f = String.valueOf(f) + bVar.f;
            }
            String a = bVar.a(str);
            synchronized (g.a) {
                if (f != null) {
                    bb.a();
                    int a2 = TextUtils.isEmpty(f) ? -1 : (int) w.a(w.a(3), f);
                    if (a2 > 0) {
                        com.baidu.tbadk.imageManager.e.a().b(a2);
                        bb.a();
                        eVar.i = TextUtils.isEmpty(f) ? null : w.d(f, a);
                        eVar.e = eVar.i.h();
                    }
                }
                if (dVar.isCancelled()) {
                    return null;
                }
                if (eVar.e == null) {
                    return null;
                }
                if (eVar.i == null || eVar.i.h() == null || eVar.i.l() == null) {
                    return null;
                }
                if (eVar.i.h().getNinePatchChunk() == null || !NinePatch.isNinePatchChunk(eVar.i.h().getNinePatchChunk())) {
                    return null;
                }
                com.baidu.tbadk.imageManager.e.a().d(a, eVar.i);
                if (dVar.isCancelled()) {
                    return null;
                }
                if (eVar.i != null) {
                    dVar.d(eVar);
                }
                eVar.f = true;
                return eVar.i;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoader.a
    public final Object b(String str, com.baidu.adp.lib.e.d dVar, com.baidu.tbadk.core.util.b bVar, com.baidu.tbadk.core.util.e eVar) {
        if (str == null || str.length() == 0) {
            TiebaStatic.a("", -1003, "", "");
            return null;
        }
        String f = bc.f(str);
        if (bVar.f != null) {
            f = String.valueOf(f) + bVar.f;
        }
        eVar.a = new com.baidu.tbadk.core.util.a.e();
        byte[] a = eVar.a.a(str);
        if (a == null || !eVar.a.a()) {
            return null;
        }
        if (eVar.n) {
            return null;
        }
        String a2 = bVar.a(str);
        com.baidu.tbadk.imageManager.e.a().b(n.h() + a.length);
        Rect rect = new Rect();
        eVar.e = g.a(a, rect);
        eVar.j = a;
        if (eVar.n) {
            return null;
        }
        if (eVar.e.getNinePatchChunk() == null || !NinePatch.isNinePatchChunk(eVar.e.getNinePatchChunk())) {
            return null;
        }
        eVar.i = new com.baidu.adp.widget.ImageView.b(eVar.e, false, a2, rect);
        if (eVar.i == null || eVar.i.h() == null || eVar.i.l() == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.e.a().d(a2, eVar.i);
        dVar.d(eVar);
        if (eVar.n) {
            return null;
        }
        eVar.k = f;
        eVar.l = a2;
        eVar.f = false;
        return eVar.i;
    }
}
