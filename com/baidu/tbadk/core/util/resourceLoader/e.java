package com.baidu.tbadk.core.util.resourceLoader;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.g;
/* loaded from: classes.dex */
public final class e extends a {
    @Override // com.baidu.tbadk.core.util.resourceLoader.a
    public final Object a(String str, com.baidu.tbadk.core.util.b bVar) {
        return com.baidu.tbadk.imageManager.e.a().b(str);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoader.a
    public final Object a(String str, com.baidu.adp.lib.e.d dVar, com.baidu.tbadk.core.util.b bVar, com.baidu.tbadk.core.util.e eVar) {
        Bitmap a;
        if (eVar.g) {
            int i = eVar.d;
            synchronized (g.a) {
                if (i == 1) {
                    a = com.baidu.tbadk.core.c.a.b(str, 0L);
                } else {
                    a = i == 2 ? com.baidu.tbadk.core.c.a.a(str, 0L) : null;
                }
                if (a != null) {
                    eVar.e = a;
                }
                if (dVar.isCancelled()) {
                    return null;
                }
                if (eVar.e == null) {
                    return null;
                }
                eVar.i = new com.baidu.adp.widget.ImageView.b(eVar.e, false, str);
                a(str, eVar.i);
                if (dVar.isCancelled()) {
                    return null;
                }
                if (eVar.i != null) {
                    dVar.d(eVar);
                }
                return eVar.i;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoader.a
    public final Object b(String str, com.baidu.adp.lib.e.d dVar, com.baidu.tbadk.core.util.b bVar, com.baidu.tbadk.core.util.e eVar) {
        String str2;
        int i = eVar.d;
        if (i == 2) {
            str2 = String.valueOf(n.n()) + str;
        } else if (i != 1) {
            str2 = null;
        } else {
            str2 = String.valueOf(n.l()) + str;
        }
        eVar.a = new com.baidu.tbadk.core.util.a.e();
        if (bVar.h != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= bVar.h.size()) {
                    break;
                }
                eVar.a.a(bVar.h.get(i3));
                i2 = i3 + 1;
            }
        }
        byte[] a = eVar.a.a(str2, false);
        if (a == null || !eVar.a.a() || eVar.n) {
            return null;
        }
        synchronized (g.a) {
            if (eVar.n) {
                return null;
            }
            eVar.e = g.a(a);
            if (eVar.e == null) {
                return null;
            }
            eVar.h = eVar.a.d || i.a(a);
            if (eVar.n) {
                return null;
            }
            int i4 = 80;
            if (i == 1) {
                i4 = n.m();
            }
            if (eVar.e.getWidth() > i4 || eVar.e.getHeight() > i4) {
                f.b(getClass().getName(), "doInBackground", "photo_too_big:" + String.valueOf(String.valueOf(eVar.e.getWidth()) + "*" + String.valueOf(eVar.e.getHeight())));
                com.baidu.tbadk.imageManager.e.a().b(g.a(eVar.e) * 2);
                eVar.e = g.a(eVar.e, i4);
            }
            if (eVar.n) {
                return null;
            }
            com.baidu.tbadk.imageManager.e.a().b(g.a(eVar.e) * 2);
            eVar.e = g.a(eVar.e, 7.0f, true);
            if (eVar.n) {
                return null;
            }
            eVar.i = new com.baidu.adp.widget.ImageView.b(eVar.e, false, str);
            a(str, eVar.i);
            if (eVar.n) {
                return null;
            }
            dVar.d(eVar);
            if (eVar.n) {
                return null;
            }
            if (i == 1) {
                com.baidu.tbadk.core.c.a.c(str, eVar.e);
            } else {
                if (i == 2) {
                    com.baidu.tbadk.core.c.a.a(str, eVar.e);
                }
                return eVar.i;
            }
            return eVar.i;
        }
    }

    private static void a(String str, com.baidu.adp.widget.ImageView.b bVar) {
        com.baidu.tbadk.imageManager.e.a().a(str, bVar);
    }
}
