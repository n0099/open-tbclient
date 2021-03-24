package com.baidu.mobads.command.b;

import android.content.Context;
import android.content.IntentFilter;
/* loaded from: classes2.dex */
public class a extends com.baidu.mobads.openad.a.c {

    /* renamed from: d  reason: collision with root package name */
    public static a f8194d;

    /* renamed from: b  reason: collision with root package name */
    public Context f8195b;

    /* renamed from: c  reason: collision with root package name */
    public b f8196c;

    public a(Context context) {
        this.f8195b = context.getApplicationContext();
    }

    public static a a(Context context) {
        if (f8194d == null) {
            synchronized (a.class) {
                if (f8194d == null) {
                    f8194d = new a(context);
                }
            }
        }
        return f8194d;
    }

    public void b() {
        try {
            if (this.f8196c == null) {
                this.f8196c = new b(this);
            }
            if (this.f8195b != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("lp_close");
                this.f8195b.registerReceiver(this.f8196c, intentFilter);
            }
        } catch (Exception unused) {
        }
    }

    public void c() {
        b bVar;
        Context context = this.f8195b;
        if (context == null || (bVar = this.f8196c) == null) {
            return;
        }
        context.unregisterReceiver(bVar);
        this.f8196c = null;
    }

    public void a() {
        dispatchEvent(new com.baidu.mobads.openad.a.b("AdLpClosed"));
    }
}
