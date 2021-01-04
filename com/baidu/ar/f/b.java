package com.baidu.ar.f;

import android.content.Context;
import com.baidu.ar.f.a;
/* loaded from: classes6.dex */
public class b {
    private static b wd;
    private a we;
    private boolean wf = false;

    private b(Context context) {
        this.we = new a(context);
    }

    public static synchronized b q(Context context) {
        b bVar;
        synchronized (b.class) {
            if (wd == null) {
                wd = new b(context);
            }
            bVar = wd;
        }
        return bVar;
    }

    public void S(boolean z) {
        if (this.we != null) {
            this.we.S(z);
        }
    }

    public void b(a.InterfaceC0077a interfaceC0077a) {
        if (this.we != null) {
            this.we.a(interfaceC0077a);
            if (this.wf) {
                return;
            }
            try {
                this.we.start();
                this.wf = true;
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
        if (this.we != null) {
            this.we = null;
        }
        if (wd != null) {
            wd = null;
        }
        this.wf = false;
    }

    public void stop() {
        if (this.we != null) {
            this.we.stop();
            this.wf = false;
        }
    }
}
