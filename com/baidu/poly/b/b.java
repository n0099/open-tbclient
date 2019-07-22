package com.baidu.poly.b;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {
    private static b ahr;
    private c agU;

    public b(c cVar) {
        this.agU = cVar;
    }

    public static void a(c cVar) {
        ahr = new b(cVar);
    }

    public static b uJ() {
        return ahr;
    }

    public void b(ImageView imageView, String str) {
        this.agU.a(imageView, str);
    }
}
