package com.baidu.poly.b;

import android.widget.ImageView;
/* loaded from: classes2.dex */
public class b {
    private static b agJ;
    private c ago;

    public b(c cVar) {
        this.ago = cVar;
    }

    public static void a(c cVar) {
        agJ = new b(cVar);
    }

    public static b ty() {
        return agJ;
    }

    public void b(ImageView imageView, String str) {
        this.ago.a(imageView, str);
    }
}
