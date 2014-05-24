package com.baidu.adp.gif;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class b implements a {
    private static a a;
    private int b;
    private final f c = new f();

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
    public com.baidu.adp.widget.a.a a(String str) {
        if (this.b != 0) {
            return null;
        }
        try {
            return this.c.a(str);
        } catch (Exception e) {
            BdLog.d("GifFactory", "get", "failed to create native gif");
            return null;
        }
    }
}
