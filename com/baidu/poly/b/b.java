package com.baidu.poly.b;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {
    private static b aBl;
    private c aAO;

    public b(c cVar) {
        this.aAO = cVar;
    }

    public static void a(c cVar) {
        aBl = new b(cVar);
    }

    public static b zH() {
        return aBl;
    }

    public void b(ImageView imageView, String str) {
        this.aAO.a(imageView, str);
    }
}
