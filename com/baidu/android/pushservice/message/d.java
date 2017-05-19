package com.baidu.android.pushservice.message;

import android.content.Context;
import java.io.IOException;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public abstract class d {
    protected Context a;
    private LinkedList<e> b = new LinkedList<>();

    public d(Context context) {
        this.a = context;
    }

    public abstract e a(byte[] bArr, int i) throws IOException;

    public LinkedList<e> a() {
        return this.b;
    }

    public abstract void a(int i);

    public void a(e eVar) {
        synchronized (this.b) {
            try {
                this.b.add(eVar);
                this.b.notify();
            } catch (Exception e) {
                com.baidu.android.pushservice.e.a.a("IMessageHandler", e);
            }
        }
    }

    public abstract void b();

    public abstract void b(e eVar) throws Exception;

    public abstract void c();
}
