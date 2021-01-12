package com.baidu.android.pushservice.message;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import java.io.IOException;
import java.util.LinkedList;
/* loaded from: classes14.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    protected Context f1466a;

    /* renamed from: b  reason: collision with root package name */
    private LinkedList<e> f1467b = new LinkedList<>();

    public d(Context context) {
        this.f1466a = context;
    }

    public abstract e a(byte[] bArr) throws IOException;

    public LinkedList<e> a() {
        return this.f1467b;
    }

    public void a(e eVar) {
        synchronized (this.f1467b) {
            try {
                this.f1467b.add(eVar);
                this.f1467b.notifyAll();
            } catch (Exception e) {
                new b.c(this.f1466a).a(Log.getStackTraceString(e)).a();
            }
        }
    }

    public abstract void b();

    public abstract void b(e eVar) throws Exception;

    public abstract void c();

    public abstract void d();
}
