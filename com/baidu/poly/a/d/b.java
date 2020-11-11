package com.baidu.poly.a.d;

import android.widget.ImageView;
/* loaded from: classes6.dex */
public class b {
    private static b cbV;
    private c cbW;

    public b(c cVar) {
        this.cbW = cVar;
    }

    public static void a(c cVar) {
        if (cbV == null) {
            synchronized (b.class) {
                if (cbV == null) {
                    cbV = new b(cVar);
                }
            }
        }
    }

    public static b aaY() {
        return cbV;
    }

    public void b(ImageView imageView, String str) {
        c cVar = this.cbW;
        if (cVar != null) {
            cVar.a(imageView, str);
        }
    }
}
