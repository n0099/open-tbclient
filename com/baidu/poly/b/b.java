package com.baidu.poly.b;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {
    private static b ahP;
    private c aht;

    public b(c cVar) {
        this.aht = cVar;
    }

    public static void a(c cVar) {
        ahP = new b(cVar);
    }

    public static b ut() {
        return ahP;
    }

    public void b(ImageView imageView, String str) {
        this.aht.a(imageView, str);
    }
}
