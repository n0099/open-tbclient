package com.baidu.android.pushservice.w;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class d {
    public Context a;
    public LinkedList<e> b = new LinkedList<>();

    public d(Context context, InputStream inputStream, OutputStream outputStream) {
        this.a = context;
    }

    public LinkedList<e> a() {
        return this.b;
    }

    public abstract void a(int i);

    public abstract void a(int i, String str, byte[] bArr);

    public abstract void a(e eVar) throws Exception;

    public abstract void b();

    public void b(e eVar) {
        synchronized (this.b) {
            try {
                this.b.add(eVar);
                this.b.notifyAll();
            } catch (Exception unused) {
            }
        }
    }

    public abstract e c() throws IOException;

    public abstract void d();
}
