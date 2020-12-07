package com.baidu.r.a.b;

import android.content.Context;
import com.a.a.a;
import com.baidu.r.a.a.d;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes14.dex */
public class a extends d {
    public a(Context context) {
        super(context);
        this.oIU = "";
        this.oIS = false;
        this.oJu = false;
        this.mStatusCode = -200;
    }

    public com.baidu.r.a.a.c ejZ() {
        final Object obj = new Object();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.a.a.a.a(this.mCtx, new a.b() { // from class: com.baidu.r.a.b.a.1
            @Override // com.a.a.a.b
            public void bm(String str, boolean z) {
                a.this.oIU = str;
                a.this.oIS = z;
                a.this.oJu = true;
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

    @Override // com.baidu.r.a.a.c
    public com.baidu.r.a.a.c ejX() {
        return ejZ();
    }
}
