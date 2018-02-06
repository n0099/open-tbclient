package com.baidu.ar.b;

import android.content.Context;
import com.baidu.ar.i;
/* loaded from: classes3.dex */
public class b {
    private static b a;
    private i b;

    private b(Context context) {
        this.b = new i(context);
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b(context);
            }
            bVar = a;
        }
        return bVar;
    }

    public void a() {
        if (this.b != null) {
            this.b.b();
        }
    }

    public void a(i.a aVar) {
        if (this.b != null) {
            this.b.a(aVar);
            this.b.a();
        }
    }

    public void a(boolean z) {
        if (this.b != null) {
            this.b.a(z);
        }
    }
}
