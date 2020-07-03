package com.baidu.poly.a.c;

import android.widget.ImageView;
/* loaded from: classes11.dex */
public class b {
    private static b bzg;
    private c bzh;

    public b(c cVar) {
        this.bzh = cVar;
    }

    public static b NY() {
        return bzg;
    }

    public static void a(c cVar) {
        if (bzg == null) {
            synchronized (b.class) {
                if (bzg == null) {
                    bzg = new b(cVar);
                }
            }
        }
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.bzh;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
