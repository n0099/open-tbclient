package com.baidu.clientupdate.a;

import android.content.Context;
/* loaded from: classes17.dex */
public final class b {
    private static b b = null;

    /* renamed from: a  reason: collision with root package name */
    private Context f1316a;
    private com.baidu.clientupdate.download.a c;

    private b(Context context) {
        this.f1316a = null;
        this.f1316a = context.getApplicationContext();
        this.c = com.baidu.clientupdate.download.a.a(context);
    }

    public static b a(Context context) {
        if (b == null) {
            b = new b(context);
        }
        return b;
    }

    public void a(byte[] bArr) {
        new c(this, com.baidu.clientupdate.c.a.a(this.f1316a).a() + "/lcmanage/index.php?r=InstallAction&cv=1", bArr).start();
    }
}
