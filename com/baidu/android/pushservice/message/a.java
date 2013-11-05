package com.baidu.android.pushservice.message;

import android.content.Context;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected InputStream f703a;
    protected OutputStream b;
    protected Context c;
    protected com.baidu.android.pushservice.e d;

    public a(Context context, com.baidu.android.pushservice.e eVar) {
        this.c = context;
        this.d = eVar;
    }

    public a(Context context, com.baidu.android.pushservice.e eVar, InputStream inputStream, OutputStream outputStream) {
        this.f703a = inputStream;
        this.b = outputStream;
        this.c = context;
        this.d = eVar;
    }

    public abstract b a(byte[] bArr, int i);

    public abstract void a();

    public abstract void a(int i);

    public void a(b bVar) {
        this.d.a(bVar);
    }

    public abstract b b();

    public abstract void b(b bVar);

    public abstract void c();

    public abstract void d();
}
