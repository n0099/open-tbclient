package com.baidu.n.a.b;

import android.content.Context;
import com.baidu.n.a.a.d;
import com.c.a.a;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a extends d {
    public a(Context context) {
        super(context);
        this.lDU = "";
        this.lDS = false;
        this.lEv = false;
        this.mStatusCode = -200;
    }

    public com.baidu.n.a.a.c diC() {
        final Object obj = new Object();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.c.a.a.a(this.mCtx, new a.b() { // from class: com.baidu.n.a.b.a.1
            @Override // com.c.a.a.b
            public void aI(String str, boolean z) {
                a.this.lDU = str;
                a.this.lDS = z;
                a.this.lEv = true;
                a.this.mStatusCode = 0;
                atomicBoolean.set(true);
                synchronized (obj) {
                    obj.notifyAll();
                }
            }

            @Override // com.c.a.a.b
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

    @Override // com.baidu.n.a.a.c
    public com.baidu.n.a.a.c diy() {
        return diC();
    }
}
