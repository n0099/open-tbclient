package com.baidu.poly.a.d;

import android.widget.ImageView;
/* loaded from: classes6.dex */
public class b {
    private static b bFa;
    private c bFb;

    public b(c cVar) {
        this.bFb = cVar;
    }

    public static b TZ() {
        return bFa;
    }

    public static void a(c cVar) {
        if (bFa == null) {
            synchronized (b.class) {
                if (bFa == null) {
                    bFa = new b(cVar);
                }
            }
        }
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.bFb;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
