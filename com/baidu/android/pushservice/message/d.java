package com.baidu.android.pushservice.message;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import java.io.IOException;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    protected Context f1460a;

    /* renamed from: b  reason: collision with root package name */
    private LinkedList<e> f1461b = new LinkedList<>();

    public d(Context context) {
        this.f1460a = context;
    }

    public abstract e a(byte[] bArr) throws IOException;

    public LinkedList<e> a() {
        return this.f1461b;
    }

    public void a(e eVar) {
        synchronized (this.f1461b) {
            try {
                this.f1461b.add(eVar);
                this.f1461b.notifyAll();
            } catch (Exception e) {
                new b.c(this.f1460a).a(Log.getStackTraceString(e)).a();
            }
        }
    }

    public abstract void b();

    public abstract void b(e eVar) throws Exception;

    public abstract void c();

    public abstract void d();
}
