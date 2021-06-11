package com.baidu.clientupdate.a;

import android.content.Context;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f4583b;

    /* renamed from: a  reason: collision with root package name */
    public Context f4584a;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.clientupdate.download.a f4585c;

    public b(Context context) {
        this.f4584a = null;
        this.f4584a = context.getApplicationContext();
        this.f4585c = com.baidu.clientupdate.download.a.a(context);
    }

    public static b a(Context context) {
        if (f4583b == null) {
            f4583b = new b(context);
        }
        return f4583b;
    }

    public void a(byte[] bArr) {
        new c(this, com.baidu.clientupdate.c.a.a(this.f4584a).a() + "/lcmanage/index.php?r=InstallAction&cv=1", bArr).start();
    }
}
