package com.baidu.android.pushservice.message;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import java.io.IOException;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public Context f3525a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<e> f3526b = new LinkedList<>();

    public d(Context context) {
        this.f3525a = context;
    }

    public abstract e a(byte[] bArr) throws IOException;

    public LinkedList<e> a() {
        return this.f3526b;
    }

    public abstract void a(int i2, String str, byte[] bArr);

    public void a(e eVar) {
        synchronized (this.f3526b) {
            try {
                this.f3526b.add(eVar);
                this.f3526b.notifyAll();
            } catch (Exception e2) {
                new b.c(this.f3525a).a(Log.getStackTraceString(e2)).a();
            }
        }
    }

    public abstract void b();

    public abstract void b(e eVar) throws Exception;

    public abstract void c();

    public abstract void d();
}
