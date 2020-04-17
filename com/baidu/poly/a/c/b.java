package com.baidu.poly.a.c;

import android.widget.ImageView;
/* loaded from: classes11.dex */
public class b {
    private static b bmM;
    private c bmN;

    public b(c cVar) {
        this.bmN = cVar;
    }

    public static b KU() {
        return bmM;
    }

    public static void a(c cVar) {
        if (bmM == null) {
            synchronized (b.class) {
                if (bmM == null) {
                    bmM = new b(cVar);
                }
            }
        }
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.bmN;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
