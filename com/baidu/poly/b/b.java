package com.baidu.poly.b;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {
    private static b ahY;
    private c ahC;

    public b(c cVar) {
        this.ahC = cVar;
    }

    public static void a(c cVar) {
        ahY = new b(cVar);
    }

    public static b ux() {
        return ahY;
    }

    public void b(ImageView imageView, String str) {
        this.ahC.a(imageView, str);
    }
}
