package com.baidu.poly.a.c;

import android.widget.ImageView;
/* loaded from: classes11.dex */
public class b {
    private static b aQw;
    private c aQx;

    public b(c cVar) {
        this.aQx = cVar;
    }

    public static b ED() {
        return aQw;
    }

    public static void a(c cVar) {
        if (aQw == null) {
            synchronized (b.class) {
                if (aQw == null) {
                    aQw = new b(cVar);
                }
            }
        }
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.aQx;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
