package com.baidu.android.pushservice.message;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected Context f321a;
    protected com.baidu.android.pushservice.e b;

    public a(Context context, com.baidu.android.pushservice.e eVar) {
        this.f321a = context;
        this.b = eVar;
    }

    public abstract b a(byte[] bArr, int i);

    public abstract void a();

    public abstract void a(int i);

    public void a(b bVar) {
        this.b.a(bVar);
    }

    public abstract void b(b bVar);
}
