package com.baidu.p.a.b;

import android.content.Context;
import com.b.a.a;
import com.baidu.p.a.a.d;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a extends d {
    public a(Context context) {
        super(context);
        this.oPd = "";
        this.oPb = false;
        this.oPD = false;
        this.mStatusCode = -200;
    }

    public com.baidu.p.a.a.c ekf() {
        final Object obj = new Object();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.b.a.a.a(this.mCtx, new a.b() { // from class: com.baidu.p.a.b.a.1
            @Override // com.b.a.a.b
            public void bl(String str, boolean z) {
                a.this.oPd = str;
                a.this.oPb = z;
                a.this.oPD = true;
                a.this.mStatusCode = 0;
                atomicBoolean.set(true);
                synchronized (obj) {
                    obj.notifyAll();
                }
            }

            @Override // com.b.a.a.b
            public void g(int i, Exception exc) {
                a.this.mStatusCode = i;
                atomicBoolean.set(true);
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        synchronized (obj) {
            if (!atomicBoolean.get()) {
                try {
                    obj.wait(4000L);
                } catch (InterruptedException e) {
                }
            }
        }
        return this;
    }

    @Override // com.baidu.p.a.a.c
    public com.baidu.p.a.a.c ekd() {
        return ekf();
    }
}
