package com.baidu.poly.a.c;

import android.widget.ImageView;
/* loaded from: classes10.dex */
public class b {
    private static b aLV;
    private c aLW;

    public b(c cVar) {
        this.aLW = cVar;
    }

    public static b Cf() {
        return aLV;
    }

    public static void a(c cVar) {
        if (aLV == null) {
            synchronized (b.class) {
                if (aLV == null) {
                    aLV = new b(cVar);
                }
            }
        }
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.aLW;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
