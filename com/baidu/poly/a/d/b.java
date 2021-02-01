package com.baidu.poly.a.d;

import android.widget.ImageView;
/* loaded from: classes4.dex */
public class b {
    private static b cnp;
    private c cnq;

    public b(c cVar) {
        this.cnq = cVar;
    }

    public static void a(c cVar) {
        if (cnp == null) {
            synchronized (b.class) {
                if (cnp == null) {
                    cnp = new b(cVar);
                }
            }
        }
    }

    public static b adp() {
        return cnp;
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.cnq;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
