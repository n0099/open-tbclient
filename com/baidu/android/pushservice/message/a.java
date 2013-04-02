package com.baidu.android.pushservice.message;

import android.content.Context;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public abstract class a {
    protected InputStream a;
    protected OutputStream b;
    protected Context c;
    protected com.baidu.android.pushservice.d d;

    public a(Context context, com.baidu.android.pushservice.d dVar, InputStream inputStream, OutputStream outputStream) {
        this.a = inputStream;
        this.b = outputStream;
        this.c = context;
        this.d = dVar;
    }

    public abstract b a();

    public void a(b bVar) {
        this.d.a(bVar);
    }

    public abstract void b();

    public abstract void b(b bVar);

    public abstract void c();

    public abstract void d();
}
