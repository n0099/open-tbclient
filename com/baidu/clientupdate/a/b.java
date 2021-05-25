package com.baidu.clientupdate.a;

import android.content.Context;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f4564b;

    /* renamed from: a  reason: collision with root package name */
    public Context f4565a;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.clientupdate.download.a f4566c;

    public b(Context context) {
        this.f4565a = null;
        this.f4565a = context.getApplicationContext();
        this.f4566c = com.baidu.clientupdate.download.a.a(context);
    }

    public static b a(Context context) {
        if (f4564b == null) {
            f4564b = new b(context);
        }
        return f4564b;
    }

    public void a(byte[] bArr) {
        new c(this, com.baidu.clientupdate.c.a.a(this.f4565a).a() + "/lcmanage/index.php?r=InstallAction&cv=1", bArr).start();
    }
}
