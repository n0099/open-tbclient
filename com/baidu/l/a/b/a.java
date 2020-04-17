package com.baidu.l.a.b;

import android.content.Context;
import com.b.a.a;
import com.baidu.l.a.a.d;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a extends d {
    public a(Context context) {
        super(context);
        this.lPn = "";
        this.lPl = false;
        this.lPO = false;
        this.mStatusCode = -200;
    }

    public com.baidu.l.a.a.c dlQ() {
        final Object obj = new Object();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.b.a.a.a(this.mCtx, new a.b() { // from class: com.baidu.l.a.b.a.1
            @Override // com.b.a.a.b
            public void aI(String str, boolean z) {
                a.this.lPn = str;
                a.this.lPl = z;
                a.this.lPO = true;
                a.this.mStatusCode = 0;
                atomicBoolean.set(true);
                synchronized (obj) {
                    obj.notifyAll();
                }
            }

            @Override // com.b.a.a.b
            public void d(int i, Exception exc) {
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
    public com.baidu.l.a.a.c dlM() {
        return dlQ();
    }
}
