package com.baidu.poly.b;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {
    private static b agI;
    private c agn;

    public b(c cVar) {
        this.agn = cVar;
    }

    public static void a(c cVar) {
        agI = new b(cVar);
    }

    public static b ty() {
        return agI;
    }

    public void b(ImageView imageView, String str) {
        this.agn.a(imageView, str);
    }
}
