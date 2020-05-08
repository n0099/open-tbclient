package com.baidu.poly.a.c;

import android.widget.ImageView;
/* loaded from: classes11.dex */
public class b {
    private static b bmR;
    private c bmS;

    public b(c cVar) {
        this.bmS = cVar;
    }

    public static b KT() {
        return bmR;
    }

    public static void a(c cVar) {
        if (bmR == null) {
            synchronized (b.class) {
                if (bmR == null) {
                    bmR = new b(cVar);
                }
            }
        }
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.bmS;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
