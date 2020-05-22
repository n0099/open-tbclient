package com.baidu.poly.a.c;

import android.widget.ImageView;
/* loaded from: classes11.dex */
public class b {
    private static b buo;
    private c bup;

    public b(c cVar) {
        this.bup = cVar;
    }

    public static b MP() {
        return buo;
    }

    public static void a(c cVar) {
        if (buo == null) {
            synchronized (b.class) {
                if (buo == null) {
                    buo = new b(cVar);
                }
            }
        }
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.bup;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
