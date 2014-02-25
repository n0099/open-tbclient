package com.baidu.adp.gif;
/* loaded from: classes.dex */
public class b implements a {
    private static a a;
    private int b;
    private g c = new g();
    private d d = new d();

    public b() {
        this.b = 0;
        if (NSGif.a) {
            this.b = 0;
        } else {
            this.b = 1;
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            aVar = a;
        }
        return aVar;
    }

    @Override // com.baidu.adp.gif.a
    public com.baidu.adp.widget.ImageView.b a(String str) {
        if (this.b == 0) {
            try {
                return this.c.a(str);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.e("GifFactory", "get", "failed to create native gif");
                return null;
            }
        } else if (this.b != 1) {
            return null;
        } else {
            try {
                return this.d.a(str);
            } catch (Exception e2) {
                com.baidu.adp.lib.util.f.e("GifFactory", "get", "failed to create movie gif");
                return null;
            }
        }
    }
}
