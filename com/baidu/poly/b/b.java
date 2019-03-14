package com.baidu.poly.b;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {
    private static b agD;
    private c agi;

    public b(c cVar) {
        this.agi = cVar;
    }

    public static void a(c cVar) {
        agD = new b(cVar);
    }

    public static b tz() {
        return agD;
    }

    public void b(ImageView imageView, String str) {
        this.agi.a(imageView, str);
    }
}
