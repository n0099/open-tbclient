package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f3451a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public long f3452b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    public a f3453c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3454d;

    /* renamed from: e  reason: collision with root package name */
    public Intent f3455e;

    /* renamed from: f  reason: collision with root package name */
    public String f3456f;

    /* renamed from: g  reason: collision with root package name */
    public Intent f3457g;

    public c(Context context, Intent intent, String str) {
        this.f3454d = context;
        this.f3455e = intent;
        this.f3456f = str;
    }

    public long a() {
        return this.f3452b;
    }

    public void a(Intent intent) {
        a aVar = this.f3453c;
        if (aVar != null) {
            aVar.a(0, intent);
        }
        this.f3457g = intent;
        synchronized (f3451a) {
            f3451a.notifyAll();
        }
    }

    public com.baidu.android.pushservice.message.g b() {
        this.f3455e.putExtra("bd.cross.request.ID", this.f3452b);
        this.f3455e.putExtra("bd.cross.request.NEED_CALLBACK", true);
        this.f3455e.putExtra("bd.cross.request.SOURCE_PACKAGE", this.f3454d.getPackageName());
        this.f3455e.putExtra("bd.cross.request.SENDING", true);
        b.a(this);
        try {
            m.a(this.f3454d, this.f3455e, this.f3456f);
        } catch (Exception unused) {
        }
        com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
        com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("timeOutRunnable-" + this.f3452b, (short) 50) { // from class: com.baidu.android.pushservice.j.c.1
            @Override // com.baidu.android.pushservice.h.c
            public void a() {
                try {
                    Thread.sleep(1000L);
                    synchronized (c.f3451a) {
                        c.f3451a.notifyAll();
                    }
                } catch (InterruptedException e2) {
                    new b.c(c.this.f3454d).a(Log.getStackTraceString(e2)).a();
                }
            }
        });
        if (this.f3453c == null) {
            synchronized (f3451a) {
                try {
                    f3451a.wait();
                } catch (Exception e2) {
                    new b.c(this.f3454d).a(Log.getStackTraceString(e2)).a();
                }
            }
            c();
            Intent intent = this.f3457g;
            if (intent != null) {
                gVar.a(intent.getIntExtra("bd.cross.request.RESULT_CODE", 10));
                if (this.f3457g.hasExtra("bd.cross.request.RESULT_DATA")) {
                    String stringExtra = this.f3457g.getStringExtra("bd.cross.request.RESULT_DATA");
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
        this.f3453c = null;
        this.f3454d = null;
        b.a(this.f3452b);
    }
}
