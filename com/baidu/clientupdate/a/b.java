package com.baidu.clientupdate.a;

import android.content.Context;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f4561b;

    /* renamed from: a  reason: collision with root package name */
    public Context f4562a;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.clientupdate.download.a f4563c;

    public b(Context context) {
        this.f4562a = null;
        this.f4562a = context.getApplicationContext();
        this.f4563c = com.baidu.clientupdate.download.a.a(context);
    }

    public static b a(Context context) {
        if (f4561b == null) {
            f4561b = new b(context);
        }
        return f4561b;
    }

    public void a(byte[] bArr) {
        new c(this, com.baidu.clientupdate.c.a.a(this.f4562a).a() + "/lcmanage/index.php?r=InstallAction&cv=1", bArr).start();
    }
}
