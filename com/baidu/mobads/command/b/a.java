package com.baidu.mobads.command.b;

import android.content.Context;
import android.content.IntentFilter;
/* loaded from: classes5.dex */
public class a extends com.baidu.mobads.openad.a.c {
    private static a d;

    /* renamed from: b  reason: collision with root package name */
    private Context f3308b;
    private b c;

    private a(Context context) {
        this.f3308b = context.getApplicationContext();
    }

    public static a a(Context context) {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a(context);
                }
            }
        }
        return d;
    }

    public void a() {
        dispatchEvent(new com.baidu.mobads.openad.a.b("AdLpClosed"));
    }

    public void b() {
        try {
            if (this.c == null) {
                this.c = new b(this);
            }
            if (this.f3308b != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("lp_close");
                this.f3308b.registerReceiver(this.c, intentFilter);
            }
        } catch (Exception e) {
        }
    }

    public void c() {
        if (this.f3308b != null && this.c != null) {
            this.f3308b.unregisterReceiver(this.c);
            this.c = null;
        }
    }
}
