package com.baidu.poly.b;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {
    private static b ahN;
    private c ahq;

    public b(c cVar) {
        this.ahq = cVar;
    }

    public static void a(c cVar) {
        ahN = new b(cVar);
    }

    public static b uN() {
        return ahN;
    }

    public void b(ImageView imageView, String str) {
        this.ahq.a(imageView, str);
    }
}
