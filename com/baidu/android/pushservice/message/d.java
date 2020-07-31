package com.baidu.android.pushservice.message;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import java.io.IOException;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public abstract class d {
    protected Context a;
    private LinkedList<e> b = new LinkedList<>();

    public d(Context context) {
        this.a = context;
    }

    public abstract e a(byte[] bArr) throws IOException;

    public LinkedList<e> a() {
        return this.b;
    }

    public void a(e eVar) {
        synchronized (this.b) {
            try {
                this.b.add(eVar);
                this.b.notifyAll();
            } catch (Exception e) {
                new b.c(this.a).a(Log.getStackTraceString(e)).a();
            }
        }
    }

    public abstract void b();

    public abstract void b(e eVar) throws Exception;

    public abstract void c();

    public abstract void d();
}
