package com.baidu.adp.lib.debug.a;

import android.content.Context;
import java.io.IOException;
/* loaded from: classes.dex */
public final class o extends a implements Runnable {
    private d a;
    private l b;

    public o(Context context) {
        this.a = new d(context);
        this.b = new l(context);
    }

    @Override // com.baidu.adp.lib.debug.a.a
    public final void c() {
        super.c();
        this.a.c();
        this.b.c();
    }

    @Override // java.lang.Runnable
    public final void run() {
        super.b();
        while (true) {
            try {
                com.baidu.adp.lib.debug.c.b(this.a.d());
                com.baidu.adp.lib.debug.c.a(this.b.d());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!a()) {
                return;
            }
            Thread.sleep(300L);
        }
    }
}
