package com.baidu.poly.b;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {
    private static b agC;
    private c agh;

    public b(c cVar) {
        this.agh = cVar;
    }

    public static void a(c cVar) {
        agC = new b(cVar);
    }

    public static b tz() {
        return agC;
    }

    public void b(ImageView imageView, String str) {
        this.agh.a(imageView, str);
    }
}
