package com.baidu.poly.a.c;

import android.widget.ImageView;
/* loaded from: classes11.dex */
public class b {
    private static b aQJ;
    private c aQK;

    public b(c cVar) {
        this.aQK = cVar;
    }

    public static b EJ() {
        return aQJ;
    }

    public static void a(c cVar) {
        if (aQJ == null) {
            synchronized (b.class) {
                if (aQJ == null) {
                    aQJ = new b(cVar);
                }
            }
        }
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.aQK;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
