package com.baidu.clientupdate.a;

import android.content.Context;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f4566b;

    /* renamed from: a  reason: collision with root package name */
    public Context f4567a;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.clientupdate.download.a f4568c;

    public b(Context context) {
        this.f4567a = null;
        this.f4567a = context.getApplicationContext();
        this.f4568c = com.baidu.clientupdate.download.a.a(context);
    }

    public static b a(Context context) {
        if (f4566b == null) {
            f4566b = new b(context);
        }
        return f4566b;
    }

    public void a(byte[] bArr) {
        new c(this, com.baidu.clientupdate.c.a.a(this.f4567a).a() + "/lcmanage/index.php?r=InstallAction&cv=1", bArr).start();
    }
}
