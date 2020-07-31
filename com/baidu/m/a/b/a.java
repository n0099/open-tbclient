package com.baidu.m.a.b;

import android.content.Context;
import com.b.a.a;
import com.baidu.m.a.a.d;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes12.dex */
public class a extends d {
    public a(Context context) {
        super(context);
        this.mNV = "";
        this.mNT = false;
        this.mOw = false;
        this.mStatusCode = -200;
    }

    public com.baidu.m.a.a.c dBh() {
        final Object obj = new Object();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.b.a.a.a(this.mCtx, new a.b() { // from class: com.baidu.m.a.b.a.1
            @Override // com.b.a.a.b
            public void aU(String str, boolean z) {
                a.this.mNV = str;
                a.this.mNT = z;
                a.this.mOw = true;
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

    @Override // com.baidu.m.a.a.c
    public com.baidu.m.a.a.c dBg() {
        return dBh();
    }
}
