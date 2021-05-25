package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f3454a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public long f3455b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public a f3456c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3457d;

    /* renamed from: e  reason: collision with root package name */
    public Intent f3458e;

    /* renamed from: f  reason: collision with root package name */
    public String f3459f;

    /* renamed from: g  reason: collision with root package name */
    public Intent f3460g;

    public c(Context context, Intent intent, String str) {
        this.f3457d = context;
        this.f3458e = intent;
        this.f3459f = str;
    }

    public long a() {
        return this.f3455b;
    }

    public void a(Intent intent) {
        a aVar = this.f3456c;
        if (aVar != null) {
            aVar.a(0, intent);
        }
        this.f3460g = intent;
        synchronized (f3454a) {
            f3454a.notifyAll();
        }
    }

    public com.baidu.android.pushservice.message.g b() {
        this.f3458e.putExtra("bd.cross.request.ID", this.f3455b);
        this.f3458e.putExtra("bd.cross.request.NEED_CALLBACK", true);
        this.f3458e.putExtra("bd.cross.request.SOURCE_PACKAGE", this.f3457d.getPackageName());
        this.f3458e.putExtra("bd.cross.request.SENDING", true);
        b.a(this);
        try {
            m.a(this.f3457d, this.f3458e, this.f3459f);
        } catch (Exception unused) {
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("timeOutRunnable-" + this.f3455b, (short) 50) { // from class: com.baidu.android.pushservice.j.c.1
            @Override // com.baidu.android.pushservice.h.c
            public void a() {
                try {
                    Thread.sleep(1000L);
                    synchronized (c.f3454a) {
                        c.f3454a.notifyAll();
                    }
                } catch (InterruptedException e2) {
                    new b.c(c.this.f3457d).a(Log.getStackTraceString(e2)).a();
                }
            }
        });
        if (this.f3456c == null) {
            synchronized (f3454a) {
                try {
                    f3454a.wait();
                } catch (Exception e2) {
                    new b.c(this.f3457d).a(Log.getStackTraceString(e2)).a();
                }
            }
            c();
            Intent intent = this.f3460g;
            if (intent != null) {
                gVar.a(intent.getIntExtra("bd.cross.request.RESULT_CODE", 10));
                if (this.f3460g.hasExtra("bd.cross.request.RESULT_DATA")) {
                    String stringExtra = this.f3460g.getStringExtra("bd.cross.request.RESULT_DATA");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        gVar.a(stringExtra.getBytes());
                    }
                }
            } else {
                gVar.a(11);
            }
        }
        return gVar;
    }

    public synchronized void c() {
        this.f3456c = null;
        this.f3457d = null;
        b.a(this.f3455b);
    }
}
