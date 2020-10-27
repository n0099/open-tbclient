package com.baidu.poly.a.d;

import android.widget.ImageView;
/* loaded from: classes6.dex */
public class b {
    private static b bWl;
    private c bWm;

    public b(c cVar) {
        this.bWm = cVar;
    }

    public static b Yz() {
        return bWl;
    }

    public static void a(c cVar) {
        if (bWl == null) {
            synchronized (b.class) {
                if (bWl == null) {
                    bWl = new b(cVar);
                }
            }
        }
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.bWm;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
