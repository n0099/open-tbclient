package com.baidu.l.a.b;

import android.content.Context;
import com.b.a.a;
import com.baidu.l.a.a.d;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a extends d {
    public a(Context context) {
        super(context);
        this.miI = "";
        this.miG = false;
        this.mjj = false;
        this.mStatusCode = -200;
    }

    public com.baidu.l.a.a.c dta() {
        final Object obj = new Object();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.b.a.a.a(this.mCtx, new a.b() { // from class: com.baidu.l.a.b.a.1
            @Override // com.b.a.a.b
            public void aV(String str, boolean z) {
                a.this.miI = str;
                a.this.miG = z;
                a.this.mjj = true;
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

    @Override // com.baidu.l.a.a.c
    public com.baidu.l.a.a.c dsZ() {
        return dta();
    }
}
