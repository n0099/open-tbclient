package com.baidu.ar.e;

import android.content.Context;
import com.baidu.ar.e.a;
/* loaded from: classes3.dex */
public class b {
    private static b ul;
    private a um;
    private boolean un = false;

    private b(Context context) {
        this.um = new a(context);
    }

    public static synchronized b m(Context context) {
        b bVar;
        synchronized (b.class) {
            if (ul == null) {
                ul = new b(context);
            }
            bVar = ul;
        }
        return bVar;
    }

    public void T(boolean z) {
        if (this.um != null) {
            this.um.T(z);
        }
    }

    public void b(a.InterfaceC0079a interfaceC0079a) {
        if (this.um != null) {
            this.um.a(interfaceC0079a);
            if (this.un) {
                return;
            }
            try {
                this.um.start();
                this.un = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void destroy() {
        try {
            stop();
        } catch (Throwable th) {
        }
        if (this.um != null) {
            this.um = null;
        }
        if (ul != null) {
            ul = null;
        }
        this.un = false;
    }

    public void stop() {
        if (this.um != null) {
            this.um.stop();
            this.un = false;
        }
    }
}
