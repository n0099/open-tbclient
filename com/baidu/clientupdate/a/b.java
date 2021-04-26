package com.baidu.clientupdate.a;

import android.content.Context;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f4707b;

    /* renamed from: a  reason: collision with root package name */
    public Context f4708a;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.clientupdate.download.a f4709c;

    public b(Context context) {
        this.f4708a = null;
        this.f4708a = context.getApplicationContext();
        this.f4709c = com.baidu.clientupdate.download.a.a(context);
    }

    public static b a(Context context) {
        if (f4707b == null) {
            f4707b = new b(context);
        }
        return f4707b;
    }

    public void a(byte[] bArr) {
        new c(this, com.baidu.clientupdate.c.a.a(this.f4708a).a() + "/lcmanage/index.php?r=InstallAction&cv=1", bArr).start();
    }
}
