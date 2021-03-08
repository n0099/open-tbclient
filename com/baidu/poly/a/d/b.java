package com.baidu.poly.a.d;

import android.widget.ImageView;
/* loaded from: classes14.dex */
public class b {
    private static b coR;
    private c coS;

    public b(c cVar) {
        this.coS = cVar;
    }

    public static void a(c cVar) {
        if (coR == null) {
            synchronized (b.class) {
                if (coR == null) {
                    coR = new b(cVar);
                }
            }
        }
    }

    public static b ads() {
        return coR;
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.coS;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
