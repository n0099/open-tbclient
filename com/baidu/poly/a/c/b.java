package com.baidu.poly.a.c;

import android.widget.ImageView;
/* loaded from: classes9.dex */
public class b {
    private static b aLd;
    private c aLe;

    public b(c cVar) {
        this.aLe = cVar;
    }

    public static b BJ() {
        return aLd;
    }

    public static void a(c cVar) {
        if (aLd == null) {
            synchronized (b.class) {
                if (aLd == null) {
                    aLd = new b(cVar);
                }
            }
        }
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.aLe;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
