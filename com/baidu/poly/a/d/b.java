package com.baidu.poly.a.d;

import android.widget.ImageView;
/* loaded from: classes9.dex */
public class b {
    private static b bHf;
    private c bHg;

    public b(c cVar) {
        this.bHg = cVar;
    }

    public static b UI() {
        return bHf;
    }

    public static void a(c cVar) {
        if (bHf == null) {
            synchronized (b.class) {
                if (bHf == null) {
                    bHf = new b(cVar);
                }
            }
        }
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.bHg;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
