package com.baidu.poly.a.d;

import android.widget.ImageView;
/* loaded from: classes3.dex */
public class b {
    private static b cja;
    private c cjb;

    public b(c cVar) {
        this.cjb = cVar;
    }

    public static void a(c cVar) {
        if (cja == null) {
            synchronized (b.class) {
                if (cja == null) {
                    cja = new b(cVar);
                }
            }
        }
    }

    public static b abB() {
        return cja;
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.cjb;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
