package com.baidu.poly.b;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {
    private static b aAT;
    private c aAw;

    public b(c cVar) {
        this.aAw = cVar;
    }

    public static void a(c cVar) {
        aAT = new b(cVar);
    }

    public static b zI() {
        return aAT;
    }

    public void b(ImageView imageView, String str) {
        this.aAw.a(imageView, str);
    }
}
