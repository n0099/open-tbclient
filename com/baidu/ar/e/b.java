package com.baidu.ar.e;

import android.content.Context;
import com.baidu.ar.e.a;
/* loaded from: classes3.dex */
public class b {
    private static b uL;
    private a uM;
    private boolean uN = false;

    private b(Context context) {
        this.uM = new a(context);
    }

    public static synchronized b o(Context context) {
        b bVar;
        synchronized (b.class) {
            if (uL == null) {
                uL = new b(context);
            }
            bVar = uL;
        }
        return bVar;
    }

    public void U(boolean z) {
        if (this.uM != null) {
            this.uM.U(z);
        }
    }

    public void b(a.InterfaceC0082a interfaceC0082a) {
        if (this.uM != null) {
            this.uM.a(interfaceC0082a);
            if (this.uN) {
                return;
            }
            try {
                this.uM.start();
                this.uN = true;
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
        if (this.uM != null) {
            this.uM = null;
        }
        if (uL != null) {
            uL = null;
        }
        this.uN = false;
    }

    public void stop() {
        if (this.uM != null) {
            this.uM.stop();
            this.uN = false;
        }
    }
}
