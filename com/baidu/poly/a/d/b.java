package com.baidu.poly.a.d;

import android.widget.ImageView;
/* loaded from: classes6.dex */
public class b {
    private static b bNO;
    private c bNP;

    public b(c cVar) {
        this.bNP = cVar;
    }

    public static b WF() {
        return bNO;
    }

    public static void a(c cVar) {
        if (bNO == null) {
            synchronized (b.class) {
                if (bNO == null) {
                    bNO = new b(cVar);
                }
            }
        }
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.bNP;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
