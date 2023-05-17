package com.baidu.ar.f;

import android.content.Context;
import com.baidu.ar.f.a;
/* loaded from: classes.dex */
public class b {
    public static b wd;
    public a we;
    public boolean wf = false;

    public b(Context context) {
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
        a aVar = this.we;
        if (aVar != null) {
            aVar.S(z);
        }
    }

    public void b(a.InterfaceC0059a interfaceC0059a) {
        a aVar = this.we;
        if (aVar != null) {
            aVar.a(interfaceC0059a);
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
        } catch (Throwable unused) {
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
        a aVar = this.we;
        if (aVar != null) {
            aVar.stop();
            this.wf = false;
        }
    }
}
