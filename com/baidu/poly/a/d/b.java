package com.baidu.poly.a.d;

import android.widget.ImageView;
/* loaded from: classes19.dex */
public class b {
    private static b cgL;
    private c cgM;

    public b(c cVar) {
        this.cgM = cVar;
    }

    public static void a(c cVar) {
        if (cgL == null) {
            synchronized (b.class) {
                if (cgL == null) {
                    cgL = new b(cVar);
                }
            }
        }
    }

    public static b adx() {
        return cgL;
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.cgM;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
