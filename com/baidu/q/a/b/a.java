package com.baidu.q.a.b;

import android.content.Context;
import com.a.a.a;
import com.baidu.q.a.a.d;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a extends d {
    public a(Context context) {
        super(context);
        this.oje = "";
        this.ojc = false;
        this.ojF = false;
        this.mStatusCode = -200;
    }

    public com.baidu.q.a.a.c eaG() {
        final Object obj = new Object();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.a.a.a.a(this.mCtx, new a.b() { // from class: com.baidu.q.a.b.a.1
            @Override // com.a.a.a.b
            public void bj(String str, boolean z) {
                a.this.oje = str;
                a.this.ojc = z;
                a.this.ojF = true;
                a.this.mStatusCode = 0;
                atomicBoolean.set(true);
                synchronized (obj) {
                    obj.notifyAll();
                }
            }

            @Override // com.a.a.a.b
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

    @Override // com.baidu.q.a.a.c
    public com.baidu.q.a.a.c eaF() {
        return eaG();
    }
}
