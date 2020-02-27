package com.baidu.poly.a.c;

import android.widget.ImageView;
/* loaded from: classes11.dex */
public class b {
    private static b aQu;
    private c aQv;

    public b(c cVar) {
        this.aQv = cVar;
    }

    public static b EB() {
        return aQu;
    }

    public static void a(c cVar) {
        if (aQu == null) {
            synchronized (b.class) {
                if (aQu == null) {
                    aQu = new b(cVar);
                }
            }
        }
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.aQv;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
