package com.baidu.poly.a.d;

import android.widget.ImageView;
/* loaded from: classes9.dex */
public class b {
    private static b bzu;
    private c bzv;

    public b(c cVar) {
        this.bzv = cVar;
    }

    public static b Og() {
        return bzu;
    }

    public static void a(c cVar) {
        if (bzu == null) {
            synchronized (b.class) {
                if (bzu == null) {
                    bzu = new b(cVar);
                }
            }
        }
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.bzv;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
