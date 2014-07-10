package com.baidu.tbadk.core.util.resourceLoader;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.h;
import com.baidu.tbadk.core.util.httpNet.i;
/* loaded from: classes.dex */
public class e extends a {
    @Override // com.baidu.tbadk.core.util.resourceLoader.a
    public Object a(String str, com.baidu.tbadk.core.util.b bVar) {
        return com.baidu.tbadk.imageManager.e.a().b(str);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoader.a
    public Object a(String str, com.baidu.adp.lib.e.d dVar, com.baidu.tbadk.core.util.b bVar, com.baidu.tbadk.core.util.e eVar) {
        Bitmap a;
        if (eVar.g) {
            int i = eVar.d;
            synchronized (h.a) {
                if (i == 1) {
                    a = com.baidu.tbadk.core.a.a.b(str, 0L);
                } else {
                    a = i == 2 ? com.baidu.tbadk.core.a.a.a(str, 0L) : null;
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
                eVar.i = new com.baidu.adp.widget.a.a(eVar.e, false, str);
                a(str, eVar.i);
                if (dVar.isCancelled()) {
                    return null;
                }
                if (eVar.i != null) {
                    dVar.a(eVar);
                }
                return eVar.i;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoader.a
    public Object b(String str, com.baidu.adp.lib.e.d dVar, com.baidu.tbadk.core.util.b bVar, com.baidu.tbadk.core.util.e eVar) {
        String str2;
        int i = eVar.d;
        if (i == 2) {
            str2 = String.valueOf(TbConfig.getPhotoSmallAddress()) + str;
        } else {
            str2 = i == 1 ? String.valueOf(TbConfig.getFriendPhotoAddress()) + str : null;
        }
        eVar.a = new i();
        if (bVar.h != null) {
            for (int i2 = 0; i2 < bVar.h.size(); i2++) {
                eVar.a.a(bVar.h.get(i2));
            }
        }
        byte[] a = eVar.a.a(str2, false);
        if (a == null || !eVar.a.b() || eVar.n) {
            return null;
        }
        synchronized (h.a) {
            if (eVar.n) {
                return null;
            }
            eVar.e = h.a(a);
            if (eVar.e == null) {
                return null;
            }
            eVar.h = eVar.a.d || j.a(a);
            if (eVar.n) {
                return null;
            }
            int i3 = 80;
            if (i == 1) {
                i3 = TbConfig.getFriendPhotoMaxSize();
            }
            if (eVar.e.getWidth() > i3 || eVar.e.getHeight() > i3) {
                com.baidu.tbadk.imageManager.e.a().c(h.a(eVar.e) * 2);
                eVar.e = h.a(eVar.e, i3);
            }
            if (eVar.n) {
                return null;
            }
            com.baidu.tbadk.imageManager.e.a().c(h.a(eVar.e) * 2);
            eVar.e = h.a(eVar.e, 7.0f, true);
            if (eVar.n) {
                return null;
            }
            eVar.i = new com.baidu.adp.widget.a.a(eVar.e, false, str);
            a(str, eVar.i);
            if (eVar.n) {
                return null;
            }
            dVar.a(eVar);
            if (eVar.n) {
                return null;
            }
            if (i == 1) {
                com.baidu.tbadk.core.a.a.c(str, eVar.e);
            } else {
                if (i == 2) {
                    com.baidu.tbadk.core.a.a.a(str, eVar.e);
                }
                return eVar.i;
            }
            return eVar.i;
        }
    }

    public static void a(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.e.a().a(str, aVar);
    }
}
