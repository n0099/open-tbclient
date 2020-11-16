package com.baidu.poly.a.d;

import android.widget.ImageView;
/* loaded from: classes6.dex */
public class b {
    private static b cak;
    private c cal;

    public b(c cVar) {
        this.cal = cVar;
    }

    public static void a(c cVar) {
        if (cak == null) {
            synchronized (b.class) {
                if (cak == null) {
                    cak = new b(cVar);
                }
            }
        }
    }

    public static b aap() {
        return cak;
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.cal;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
