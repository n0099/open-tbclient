package com.baidu.clientupdate.a;

import android.content.Context;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    private static b f1656b = null;

    /* renamed from: a  reason: collision with root package name */
    private Context f1657a;
    private com.baidu.clientupdate.download.a c;

    private b(Context context) {
        this.f1657a = null;
        this.f1657a = context.getApplicationContext();
        this.c = com.baidu.clientupdate.download.a.a(context);
    }

    public static b a(Context context) {
        if (f1656b == null) {
            f1656b = new b(context);
        }
        return f1656b;
    }

    public void a(byte[] bArr) {
        new c(this, com.baidu.clientupdate.c.a.a(this.f1657a).a() + "/lcmanage/index.php?r=InstallAction&cv=1", bArr).start();
    }
}
