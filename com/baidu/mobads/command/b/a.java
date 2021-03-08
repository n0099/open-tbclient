package com.baidu.mobads.command.b;

import android.content.Context;
import android.content.IntentFilter;
/* loaded from: classes4.dex */
public class a extends com.baidu.mobads.openad.a.c {
    private static a d;
    private Context b;
    private b c;

    private a(Context context) {
        this.b = context.getApplicationContext();
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
            if (this.b != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("lp_close");
                this.b.registerReceiver(this.c, intentFilter);
            }
        } catch (Exception e) {
        }
    }

    public void c() {
        if (this.b != null && this.c != null) {
            this.b.unregisterReceiver(this.c);
            this.c = null;
        }
    }
}
