package com.baidu.mobads.command.b;

import android.content.Context;
import android.content.IntentFilter;
/* loaded from: classes2.dex */
public class a extends com.baidu.mobads.openad.a.c {

    /* renamed from: d  reason: collision with root package name */
    public static a f8195d;

    /* renamed from: b  reason: collision with root package name */
    public Context f8196b;

    /* renamed from: c  reason: collision with root package name */
    public b f8197c;

    public a(Context context) {
        this.f8196b = context.getApplicationContext();
    }

    public static a a(Context context) {
        if (f8195d == null) {
            synchronized (a.class) {
                if (f8195d == null) {
                    f8195d = new a(context);
                }
            }
        }
        return f8195d;
    }

    public void b() {
        try {
            if (this.f8197c == null) {
                this.f8197c = new b(this);
            }
            if (this.f8196b != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("lp_close");
                this.f8196b.registerReceiver(this.f8197c, intentFilter);
            }
        } catch (Exception unused) {
        }
    }

    public void c() {
        b bVar;
        Context context = this.f8196b;
        if (context == null || (bVar = this.f8197c) == null) {
            return;
        }
        context.unregisterReceiver(bVar);
        this.f8197c = null;
    }

    public void a() {
        dispatchEvent(new com.baidu.mobads.openad.a.b("AdLpClosed"));
    }
}
