package com.baidu.clientupdate.a;

import android.content.Context;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f4565b;

    /* renamed from: a  reason: collision with root package name */
    public Context f4566a;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.clientupdate.download.a f4567c;

    public b(Context context) {
        this.f4566a = null;
        this.f4566a = context.getApplicationContext();
        this.f4567c = com.baidu.clientupdate.download.a.a(context);
    }

    public static b a(Context context) {
        if (f4565b == null) {
            f4565b = new b(context);
        }
        return f4565b;
    }

    public void a(byte[] bArr) {
        new c(this, com.baidu.clientupdate.c.a.a(this.f4566a).a() + "/lcmanage/index.php?r=InstallAction&cv=1", bArr).start();
    }
}
