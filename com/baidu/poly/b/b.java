package com.baidu.poly.b;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {
    private static b agS;
    private c agx;

    public b(c cVar) {
        this.agx = cVar;
    }

    public static void a(c cVar) {
        agS = new b(cVar);
    }

    public static b uj() {
        return agS;
    }

    public void b(ImageView imageView, String str) {
        this.agx.a(imageView, str);
    }
}
