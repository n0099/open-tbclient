package com.baidu.ar.f;

import android.content.Context;
import com.baidu.ar.f.a;
/* loaded from: classes10.dex */
public class b {
    private static b vp;
    private a vq;
    private boolean vr = false;

    private b(Context context) {
        this.vq = new a(context);
    }

    public static synchronized b p(Context context) {
        b bVar;
        synchronized (b.class) {
            if (vp == null) {
                vp = new b(context);
            }
            bVar = vp;
        }
        return bVar;
    }

    public void U(boolean z) {
        if (this.vq != null) {
            this.vq.U(z);
        }
    }

    public void b(a.InterfaceC0082a interfaceC0082a) {
        if (this.vq != null) {
            this.vq.a(interfaceC0082a);
            if (this.vr) {
                return;
            }
            try {
                this.vq.start();
                this.vr = true;
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
        if (this.vq != null) {
            this.vq = null;
        }
        if (vp != null) {
            vp = null;
        }
        this.vr = false;
    }

    public void stop() {
        if (this.vq != null) {
            this.vq.stop();
            this.vr = false;
        }
    }
}
