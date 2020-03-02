package com.baidu.poly.a.c;

import android.widget.ImageView;
/* loaded from: classes11.dex */
public class b {
    private static b aQv;
    private c aQw;

    public b(c cVar) {
        this.aQw = cVar;
    }

    public static b ED() {
        return aQv;
    }

    public static void a(c cVar) {
        if (aQv == null) {
            synchronized (b.class) {
                if (aQv == null) {
                    aQv = new b(cVar);
                }
            }
        }
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.aQw;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
