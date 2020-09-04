package com.baidu.poly.a.d;

import android.widget.ImageView;
/* loaded from: classes6.dex */
public class b {
    private static b bFe;
    private c bFf;

    public b(c cVar) {
        this.bFf = cVar;
    }

    public static b TZ() {
        return bFe;
    }

    public static void a(c cVar) {
        if (bFe == null) {
            synchronized (b.class) {
                if (bFe == null) {
                    bFe = new b(cVar);
                }
            }
        }
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.bFf;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
