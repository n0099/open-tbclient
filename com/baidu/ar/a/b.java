package com.baidu.ar.a;

import android.content.Context;
import com.baidu.ar.a.a;
/* loaded from: classes3.dex */
public class b {
    private static b a;
    private a b;

    private b(Context context) {
        this.b = new a(context);
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

    public void a(a.InterfaceC0032a interfaceC0032a) {
        if (this.b != null) {
            this.b.a(interfaceC0032a);
            this.b.a();
        }
    }

    public void a(boolean z) {
        if (this.b != null) {
            this.b.a(z);
        }
    }
}
