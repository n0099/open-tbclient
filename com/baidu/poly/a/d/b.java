package com.baidu.poly.a.d;

import android.widget.ImageView;
/* loaded from: classes4.dex */
public class b {
    private static b cnO;
    private c cnP;

    public b(c cVar) {
        this.cnP = cVar;
    }

    public static void a(c cVar) {
        if (cnO == null) {
            synchronized (b.class) {
                if (cnO == null) {
                    cnO = new b(cVar);
                }
            }
        }
    }

    public static b afu() {
        return cnO;
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.cnP;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
